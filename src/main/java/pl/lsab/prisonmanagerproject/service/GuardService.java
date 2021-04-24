package pl.lsab.prisonmanagerproject.service;

import pl.lsab.prisonmanagerproject.entity.Guard;

import java.util.List;

public interface GuardService {

    void save(Guard guard);

    void delete(Long id);

    List<Guard> allGuards();

    List<Guard> findAllByAgeMoreThan50();




}
