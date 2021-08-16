package br.gov.sp.fatec.finances.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ac_account")
@Getter @Setter
public class Account implements Serializable {
    private static final long serialVersionUID = 986589124772488369L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ac_id")
    private Long id;

    @Column(name = "ac_initial_balance")
    private Double initialBalance;

    @Column(name = "ac_current_balance")
    private Double currentBalance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "us_id")
    private User user;

}
