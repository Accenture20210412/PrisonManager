package pl.lsab.prisonmanagerproject.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Guard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @NotNull
    @NotEmpty
    @Size(min = 3, message = "Imie powinno zawierac conajmniej 3 znaki")
    @Column(name = "imie")
    private String name;


    @NotNull
    @NotEmpty
    @Size(min = 2, message = "Nazwisko powinno zawierac conajmniej 2 znaki")
    @Column(name = "nazwisko")
    private String surname;

    @NotNull
    @NotEmpty
    @Size(max =2, message = "wiek musi byc w przedziale 18-60 lat" )
    @Column(name = "wiek")
    private int age;


}