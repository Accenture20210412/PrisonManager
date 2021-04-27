package pl.lsab.prisonmanagerproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.lsab.prisonmanagerproject.entity.Cell;
import pl.lsab.prisonmanagerproject.entity.Guard;
import pl.lsab.prisonmanagerproject.entity.Prisoner;

import java.util.List;

@Repository
public interface CellRepository extends JpaRepository<Cell, Long > {
    List<Cell> findAll();
    void findCellById(Long id);

    @Query("SELECT c from Cell c where c.id=:id")
    Cell findOneCellById(@Param("id") Long id);

    @Modifying
    @Query("update Cell c set c.guard = ?1 where c.id = ?2")
    void setUpdateGuardToCell(Guard guard, Long id);

    @Query("SELECT c FROM Cell c WHERE c.guard IS NULL ")
    List<Cell>findAllCellWhereNoGuard();

    @Modifying
    @Query("update Cell c set c.prisoners= ?1 where c.id= ?2")
    void updatePrisonerList(List<Prisoner>prisonersList, Long id);

    @Query("SELECT c FROM Cell c WHERE c.id=(SELECT MAX (id) FROM c)")
    Cell findLastCellCreated();

    Cell findByGuard(Guard guard);
}
