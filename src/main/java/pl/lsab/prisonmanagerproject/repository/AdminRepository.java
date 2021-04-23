package pl.lsab.prisonmanagerproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lsab.prisonmanagerproject.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {

    Admin findAdminByPasswordBefore(String password);

    Admin findAdminByUsername(String username);

}
