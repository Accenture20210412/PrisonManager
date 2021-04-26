package pl.lsab.prisonmanagerproject.service.implementation;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.lsab.prisonmanagerproject.entity.Admin;
import pl.lsab.prisonmanagerproject.repository.AdminRepository;
import pl.lsab.prisonmanagerproject.service.AdminService;

import java.util.Optional;

@Service
@Transactional
public class AdminServiceImp implements AdminService {

    private AdminRepository adminRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AdminServiceImp(AdminRepository adminRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.adminRepository = adminRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void save(Admin admin) {
        admin.setPassword(bCryptPasswordEncoder.encode(admin.getPassword()));
        adminRepository.save(admin);
    }

    @Override
    public Admin findByUsername(String login) {
        return adminRepository.findAdminByUsername(login);
    }

    @Override
    public Optional<Admin> findById(Long id) {
        return adminRepository.findById(id);
    }
}
