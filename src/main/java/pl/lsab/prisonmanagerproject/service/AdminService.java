package pl.lsab.prisonmanagerproject.service;

import pl.lsab.prisonmanagerproject.entity.Admin;

import java.util.Optional;

public interface AdminService {
    void save(Admin admin);
    Admin findByUsername(String login);
    Optional<Admin> findById(Long id);

}
