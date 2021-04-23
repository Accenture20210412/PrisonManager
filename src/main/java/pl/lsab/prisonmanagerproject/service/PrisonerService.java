package pl.lsab.prisonmanagerproject.service;

import pl.lsab.prisonmanagerproject.entity.Prisoner;

import java.util.List;

public interface PrisonerService {
    void addPrisoner(Prisoner prisoner);
    List<Prisoner> findAll();
    Prisoner findPrisonerBySurname(String surname);
    void removePrisoner(Long id);
    Prisoner findPrisonerById(Long id);
}