package br.gov.sp.fatec.finances.models;

import br.gov.sp.fatec.finances.controllers.view.View;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "ac_account")
@Getter @Setter
public class Account implements Serializable {
    private static final long serialVersionUID = 986589124772488369L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ac_id")
    private Long id;

    @JsonView(View.Account.class)
    @Column(name = "ac_initial_balance")
    private Double initialBalance;

    @JsonView(View.Account.class)
    @Column(name = "ac_current_balance")
    private Double currentBalance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "us_id")
    private User user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
    private Set<Movements> movements;

}
