package pl.lsab.prisonmanagerproject.service;

import pl.lsab.prisonmanagerproject.entity.Cell;
import pl.lsab.prisonmanagerproject.entity.Guard;
import pl.lsab.prisonmanagerproject.entity.Prisoner;

import java.util.List;

public interface PrisonerService {

    void addPrisoner(Prisoner prisoner);

    List<Prisoner> findAll();

    void removePrisoner(Long id);

    Prisoner findPrisonerById(Long id);

    void setUpdatePrisoner(Cell cell, Long id);

    List<Prisoner> searchPrison(String word);

}