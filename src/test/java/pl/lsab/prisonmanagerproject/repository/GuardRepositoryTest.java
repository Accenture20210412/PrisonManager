package pl.lsab.prisonmanagerproject.repository;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.lsab.prisonmanagerproject.entity.Cell;
import pl.lsab.prisonmanagerproject.entity.Guard;
import pl.lsab.prisonmanagerproject.entity.Prisoner;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class GuardRepositoryTest {

    @Autowired
    GuardRepository guardRepository;

    Guard guard;
    Guard guard1;
    Cell cell;
    Cell cell1;


    @BeforeEach
    void before(){
        guard = new Guard(1l,"Adam","Małysz",23);
        guard1 = new Guard(2l,"Adam","Alala",32);
        guardRepository.save(guard);
        guardRepository.save(guard1);
    }

    @Test
    void findOne() {
       assertEquals(guardRepository.findOne(1l).getId(),1l);
    }

    @Test
    void deleteById() {
        guardRepository.deleteById(guard.getId());
        assertTrue(guardRepository.findAll().size()==1);
    }
    @Test
    void searchGuard() {
        assertFalse(guardRepository.searchGuardByPartOfNameOrSurname("ala")==null);
    }
}