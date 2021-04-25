package pl.lsab.prisonmanagerproject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.lsab.prisonmanagerproject.entity.Cell;
import pl.lsab.prisonmanagerproject.entity.Prisoner;

import java.util.List;

@Repository
public interface PrisonerRepository extends JpaRepository<Prisoner,Long> {
    List<Prisoner> findAll();
    void deleteById(Long id);
    void findPrisonerById(Long id);

    @Modifying
    @Query("update Prisoner p set p.cell = ?1 WHERE p.id = ?2")
    void setUpdatePrisoner(Cell cell, Long id);
}