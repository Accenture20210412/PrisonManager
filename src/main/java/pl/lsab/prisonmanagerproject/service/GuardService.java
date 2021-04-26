package pl.lsab.prisonmanagerproject.service;

import pl.lsab.prisonmanagerproject.entity.Cell;
import pl.lsab.prisonmanagerproject.entity.Guard;

import java.util.List;

public interface GuardService {

    void save(Guard guard);

    void delete(Long id);

    List<Guard> allGuards();

    Guard findOne(Long id);

    void setUpdateGuard(Cell cell, Long id);

    List<Guard> searchGuardByPartOfNameOrSurname(String word);



}
