package pl.lsab.prisonmanagerproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lsab.prisonmanagerproject.entity.Cell;

import java.util.List;

@Repository
public interface CellRepository extends JpaRepository<Cell, Long > {
    List<Cell> findAll();
    void findCellById(int id);
}
