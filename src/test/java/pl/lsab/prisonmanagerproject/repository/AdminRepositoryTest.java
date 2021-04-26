package pl.lsab.prisonmanagerproject.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.lsab.prisonmanagerproject.entity.Admin;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class AdminRepositoryTest {

    @Autowired
    AdminRepository adminRepository;


    @Test
    void findAdminByUsername() {
        Admin admin = new Admin(1l,"Alan","Uryga","lolo","12345","12345",true);
        adminRepository.save(admin);
       assertEquals(adminRepository.findAdminByUsername(admin.getUsername()).getUsername(),admin.getUsername());
    }
}