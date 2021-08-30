package br.gov.sp.fatec.finances.models;

import br.gov.sp.fatec.finances.controllers.view.View;
import com.fasterxml.jackson.annotation.JsonView;
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

    @JsonView(View.Movements.class)
    @Column(name = "mv_type")
    private String type;

    @JsonView(View.Movements.class)
    @Column(name = "mv_value")
    private Double value;

    @JsonView(View.Movements.class)
    @Column(name = "mv_flow")
    private String flow;

    @ManyToOne
    @JoinColumn(name = "ac_id")
    private Account account;
}
