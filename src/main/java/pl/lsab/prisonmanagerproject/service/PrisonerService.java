package pl.lsab.prisonmanagerproject.service;

import pl.lsab.prisonmanagerproject.entity.Prisoner;

import java.util.List;

public interface PrisonerService {
    void addPrisoner(Prisoner prisoner);
    List<Prisoner> findAll();
    Prisoner findPrisonerByName(String name);
    Prisoner findPrisonerBySurname(String surname);
    void removePrisonerFromJail(Prisoner prisoner);
}
