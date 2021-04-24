package pl.lsab.prisonmanagerproject.entity;

import lombok.*;

import javax.persistence.*;
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

    @Column(name = "number")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cellNumber;

    @Column(name = "stan")
    private boolean isItEmpty;

    @OneToMany
    @JoinTable(name = "stan_cel")
    private Set<Prisoner> prisoners;
}