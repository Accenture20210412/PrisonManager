package pl.lsab.prisonmanagerproject.service;

import pl.lsab.prisonmanagerproject.entity.Cell;
import pl.lsab.prisonmanagerproject.entity.Guard;
import pl.lsab.prisonmanagerproject.entity.Prisoner;

import java.util.List;

public interface CellService {
    void add(Cell cell);
    List<Cell> findAll();

    Cell findOne(Long id);

    void updateCellByGuard(Guard guard, Long id);

    Cell findCellByGuard(Guard guard);

    List<Cell>findAllCellWhereNoGuard();

    Cell findLastCellCreated();

    void updatePrisonerList(List<Prisoner>prisonersList, Long id);

}
