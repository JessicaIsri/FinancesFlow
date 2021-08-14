package br.gov.sp.fatec.finances.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Table(name = "ac_account")
@Getter @Setter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ac_id")
    private Long id;

    @Column(name = "ac_initial_balance")
    private Float initialBalance;

    @Column(name = "ac_current_balance")
    private Float currentBalance;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "us_id")
    private User user;

}
