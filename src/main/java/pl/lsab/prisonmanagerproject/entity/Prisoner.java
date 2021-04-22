package pl.lsab.prisonmanagerproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Prisoner {
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
    @Column(name = "nawisko")
    private String surname;


    @Column(name = "ksywa")
    private String nickname;

    @NotNull
    @NotEmpty
    @Column(name = "wyrok")
    private String judgment;

    @NotNull
    @NotEmpty
    @Column(name = "poczatek odsiadki")
    private LocalDate gridBegin;

    @Column(name = "koniec odsiadki")
    private LocalDate gridEnd;



}
