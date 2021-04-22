package pl.lsab.prisonmanagerproject.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.lsab.prisonmanagerproject.entity.Admin;
import pl.lsab.prisonmanagerproject.repository.AdminRepository;

import java.util.Optional;

@Service
@Transactional
public class AdminServiceImp implements AdminService{


    private AdminRepository adminRepository;


    @Override
    public void save(Admin admin) {

         adminRepository.save(admin);
    }

    @Override
    public void delete(Admin admin) {

    }

    @Override
    public Optional<Admin> findById(Long id) {
        return Optional.empty();
    }
}
