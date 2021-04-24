package pl.lsab.prisonmanagerproject.service;

import pl.lsab.prisonmanagerproject.entity.Cell;

import java.util.List;

public interface CellService {
    void add(Cell cell);
    List<Cell> findAll();
}
