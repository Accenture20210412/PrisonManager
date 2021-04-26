package pl.lsab.prisonmanagerproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.lsab.prisonmanagerproject.entity.Cell;
import pl.lsab.prisonmanagerproject.entity.Guard;

import java.util.List;

@Repository
public interface GuardRepository extends JpaRepository<Guard,Long> {

    @Query("SELECT g from Guard g where g.id=:id")
    Guard findOne(@Param("id") Long id);

    void deleteById(Long id);

    @Modifying
    @Query("update Guard g set g.cell = ?1 where g.id = ?2")
    void setUpdateGuardCell(Cell cell, Long id);

    @Query("SELECT g from Guard g where g.surname LIKE %?1% or g.name LIKE %?1%")
    List<Guard> searchGuardByPartOfNameOrSurname(String word);




}
