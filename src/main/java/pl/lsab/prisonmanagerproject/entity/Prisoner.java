package pl.lsab.prisonmanagerproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import pl.lsab.prisonmanagerproject.converter.LocalDateAttributeConverter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "osadzony")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Prisoner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate gridBegin;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate gridEnd;

    @ManyToOne
    private Cell cell;

    public Prisoner(Long id, String name, String surname, String nickname, String judgment, LocalDate gridBegin, LocalDate gridEnd) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.nickname = nickname;
        this.judgment = judgment;
        this.gridBegin = gridBegin;
        this.gridEnd = gridEnd;
    }
}