package br.gov.sp.fatec.finances.models;

import jdk.jfr.Enabled;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "mv_moviments")
@Getter
@Setter
public class Movements implements Serializable {
    private static final long serialVersionUID = 986589124772488369L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mv_id")
    private Long id;

    @Column(name = "mv_type")
    private String type;

    @Column(name = "mv_value")
    private Double value;

    @Column(name = "mv_flow")
    private String flow;

    @ManyToOne
    @JoinColumn(name = "ac_id")
    private Account account;
}
