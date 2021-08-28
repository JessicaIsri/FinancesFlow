package br.gov.sp.fatec.finances.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "us_user")
public class User implements Serializable {
    private static final long serialVersionUID = 986589124772488369L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "us_id")
    private Long id;

    @Column(name = "us_name")
    private String name;

    @Column(name = "us_email")
    private String email;

    @Column(name = "us_password")
    private String password;

    @JsonIgnore
    @OneToMany(
        mappedBy = "user",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        orphanRemoval = true)
    private List<Account> accounts;
}
