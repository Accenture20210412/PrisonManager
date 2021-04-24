package pl.lsab.prisonmanagerproject.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "admin")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, message = "imie powinno zawierac minimum 3 znaki")
    @Column(name = "imie")
    private String firstName;

    @Size(min = 3, message = "nazwisko powinno zawierac minimum 3 znaki")
    @Column(name = "nazwisko")
    private String lastName;


    @Size(min = 3, message = "login powinien zawierac minimum 3 znaki")
    @Column(unique = true)
    private String username;


    @Size(min = 5, message = "Minimum 5 znakow")
    @Column(name = "haslo")
    private String password;

    @Transient
    private String passwordRepeat;


    private Boolean enable;


}
