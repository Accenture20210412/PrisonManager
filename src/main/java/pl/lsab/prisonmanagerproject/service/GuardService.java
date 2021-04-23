package pl.lsab.prisonmanagerproject.service;

import pl.lsab.prisonmanagerproject.entity.Admin;
import pl.lsab.prisonmanagerproject.entity.Guard;

import java.util.List;
import java.util.Optional;

public interface GuardService {

    void save(Guard guard);

    void delete(Guard guard);

   Optional <Guard> findGuardById(Long id);

    List<Guard> allGuards();

    List<Guard> findAllByAgeMoreThan50();




}
