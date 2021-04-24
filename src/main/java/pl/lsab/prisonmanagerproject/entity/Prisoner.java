package pl.lsab.prisonmanagerproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "osadzony")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Prisoner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Size(min = 3, message = "Imie powinno zawierac conajmniej 3 znaki")
    @Column(name = "imie")
    private String name;


    @Size(min = 2, message = "Nazwisko powinno zawierac conajmniej 2 znaki")
    @Column(name = "nazwisko")
    private String surname;


    @Column(name = "ksywa")
    private String nickname;

    @NotEmpty(message = "Wprowadz wyrok")
    @Column(name = "wyrok")
    private String judgment;

    @NotEmpty(message = "Wprowadz czas odsiadki")
    @Column
    private String gridBegin;
}