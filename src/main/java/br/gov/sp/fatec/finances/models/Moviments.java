package br.gov.sp.fatec.finances.models;

import jdk.jfr.Enabled;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "mv_moviments")
@Getter @Setter
public class Moviments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mv_id")
    private Long id;

    @Column(name = "mv_type")
    private String type;

    @Column(name = "mv_value")
    private Float value;

    @Column(name = "mv_flow")
    private String flow;

    @ManyToOne
    @JoinColumn(name = "ac_id")
    private Account account;
}
