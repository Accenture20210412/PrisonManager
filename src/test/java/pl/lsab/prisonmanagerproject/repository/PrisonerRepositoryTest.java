package pl.lsab.prisonmanagerproject.repository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.lsab.prisonmanagerproject.entity.Prisoner;

import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class PrisonerRepositoryTest {



    @Autowired
    PrisonerRepository prisonerRepository;

    @Test
    void findAll() {
        Prisoner prisoner1 = new Prisoner(1l,"Adam","Małysz","lotka","zabojstwo", LocalDate.parse("2020-12-20"),LocalDate.parse("2021-12-20"));
        prisonerRepository.save(prisoner1);
        List<Prisoner> prisonerList = prisonerRepository.findAll();
        assertTrue(prisonerList.size()==1);
    }
    @Test
    void deleteById() {
        Prisoner prisoner1 = new Prisoner(1l,"Adam","Małysz","lotka","zabojstwo", LocalDate.parse("2020-12-20"),LocalDate.parse("2021-12-20"));
        prisonerRepository.save(prisoner1);
        prisonerRepository.deleteById(prisoner1.getId());
        List<Prisoner> prisonerList = prisonerRepository.findAll();
        assertTrue(prisonerList.size()==0);
    }
    @Test
    void findPrisonerById() {
        Prisoner prisoner1 = new Prisoner(1l,"Adam","Małysz","lotka","zabojstwo", LocalDate.parse("2020-12-20"),LocalDate.parse("2021-12-20"));
        Prisoner prisoner2 = new Prisoner(2l,"msasa","Slasa","usa","zabojstwo", LocalDate.parse("2020-12-20"),LocalDate.parse("2021-12-20"));
        prisonerRepository.save(prisoner1);
        prisonerRepository.save(prisoner2);
        Prisoner prisonerCheck = prisonerRepository.findPrisonerById(prisoner1.getId());
        assertEquals(prisonerCheck.getId(),prisoner1.getId());

    }

    @Test
    void searchPrison() {
        Prisoner prisoner1 = new Prisoner(1l,"Adam","Małysz","lotka","zabojstwo", LocalDate.parse("2020-12-20"),LocalDate.parse("2021-12-20"));
        Prisoner prisoner2 = new Prisoner(2l,"msasa","Slasa","usa","zabojstwo", LocalDate.parse("2020-12-20"),LocalDate.parse("2021-12-20"));
        prisonerRepository.save(prisoner1);
        prisonerRepository.save(prisoner2);
        prisonerRepository.searchPrisonByPartOfNameOrSurname("msa");
        assertEquals(prisonerRepository.searchPrisonByPartOfNameOrSurname("msa").size(),1);

    }
}