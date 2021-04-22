package pl.lsab.prisonmanagerproject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.lsab.prisonmanagerproject.entity.Prisoner;

import java.util.List;

public interface PrisonerRepository extends JpaRepository<Prisoner,Long> {
    Prisoner findByName(String name);
    Prisoner findBySurname(String surname);
    List<Prisoner> findAllByJudgment(String judgment);
    List<Prisoner> findAll();
}