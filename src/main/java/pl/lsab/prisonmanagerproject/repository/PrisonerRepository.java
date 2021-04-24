package pl.lsab.prisonmanagerproject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lsab.prisonmanagerproject.entity.Prisoner;

import java.util.List;

@Repository
public interface PrisonerRepository extends JpaRepository<Prisoner,Long> {
    List<Prisoner> findAll();
    void deleteById(Long id);
    void findPrisonerById(Long id);
}