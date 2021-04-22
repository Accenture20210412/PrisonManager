package pl.lsab.prisonmanagerproject.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.lsab.prisonmanagerproject.entity.Admin;
import pl.lsab.prisonmanagerproject.repository.AdminRepository;

import java.util.Optional;

@Service
@Transactional
public class AdminServiceImp implements AdminService{


    private AdminRepository adminRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public void save(Admin admin) {
        admin.setPassword(bCryptPasswordEncoder.encode(admin.getPassword()));
        adminRepository.save(admin);
    }



    @Override
    public Optional<Admin> findById(Long id) {
        return adminRepository.findById(id);
    }
}
