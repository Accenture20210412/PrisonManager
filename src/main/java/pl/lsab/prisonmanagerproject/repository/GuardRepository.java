package pl.lsab.prisonmanagerproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lsab.prisonmanagerproject.entity.Guard;

import java.util.List;

@Repository
public interface GuardRepository extends JpaRepository<Guard,Long> {

    List<Guard> findAllByAge(int age);
    List<Guard> findAllByAgeGreaterThan(int age);
    List<Guard> findAllByName(String name);
    List<Guard> findAllBySurname(String surname);

}
