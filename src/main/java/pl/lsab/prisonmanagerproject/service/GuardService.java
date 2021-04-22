package pl.lsab.prisonmanagerproject.service;

import pl.lsab.prisonmanagerproject.entity.Admin;
import pl.lsab.prisonmanagerproject.entity.Guard;

import java.util.List;

public interface GuardService {

    void save(Guard guard);

    void delete(Guard guard);

    Guard findGuardById(Long id);

    List<Guard> allGuards();



}
