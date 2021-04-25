package pl.lsab.prisonmanagerproject.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "cela")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cell {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "numer")
    private int cellNumber;

    @OneToMany(mappedBy = "cell")
    private Set<Prisoner> prisoners;

    @OneToOne
    private Guard guard;
}