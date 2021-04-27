package pl.lsab.prisonmanagerproject.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cell")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cell {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "cell_number")
    private int cellNumber;

    @OneToMany(mappedBy = "cell")
    private Set<Prisoner> prisoners;

    @OneToOne
    private Guard guard;


    public Cell(Long id) {
        this.id = id;
    }

    public Cell(Long id, int cellNumber) {
        this.id = id;
        this.cellNumber = cellNumber;
    }
}