package pl.lsab.prisonmanagerproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.lsab.prisonmanagerproject.entity.Guard;

import java.util.List;

@Repository
public interface GuardRepository extends JpaRepository<Guard,Long> {

    List<Guard> findAllByAge(int age);
    List<Guard> findAllByAgeGreaterThan(int age);
    List<Guard> findAllByName(String name);
    List<Guard> findAllBySurname(String surname);

//    @Query("SELECT g from Guard g where g.id=:id")
//    Guard findOne(@Param("id") Long id);

    void deleteById(Long id);

    @Query("SELECT g from Guard g where g.age>?50")
    List<Guard> findAllByAgeMoreThan50();



}
