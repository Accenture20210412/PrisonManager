package pl.lsab.prisonmanagerproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
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

    @Column(name = "stan")
    private boolean isItEmpty;

    @OneToMany
    private Set<Prisoner> prisoners;
}