package pl.lsab.prisonmanagerproject.service;

import org.springframework.data.repository.query.Param;
import pl.lsab.prisonmanagerproject.entity.Cell;
import pl.lsab.prisonmanagerproject.entity.Guard;

import java.util.List;

public interface CellService {
    void add(Cell cell);
    List<Cell> findAll();

    Cell findOne(Long id);

    void update(Guard guard, Long id);

    Cell findByGuard(Guard guard);

    List<Cell>findAllWhereNoGuard();
}
