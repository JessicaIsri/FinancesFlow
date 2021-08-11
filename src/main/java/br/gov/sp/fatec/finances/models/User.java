package br.gov.sp.fatec.finances.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "us_user")
public class User {
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
}
