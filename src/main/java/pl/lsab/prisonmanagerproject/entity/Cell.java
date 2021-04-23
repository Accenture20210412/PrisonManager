//package pl.lsab.prisonmanagerproject.entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.List;
//import java.util.Set;
//
//@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//public class Cell {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "numer celi")
//    private int cellNumber;
//
//    @Column(name = "stan celi")
//    private boolean isItEmpty;
//
//    @OneToMany
//    private Set<Prisoner> prisoners;
//}
