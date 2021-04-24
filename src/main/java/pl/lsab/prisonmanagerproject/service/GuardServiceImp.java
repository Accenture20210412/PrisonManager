package pl.lsab.prisonmanagerproject.service;

import org.springframework.stereotype.Service;
import pl.lsab.prisonmanagerproject.entity.Guard;
import pl.lsab.prisonmanagerproject.repository.GuardRepository;

import java.util.List;

@Service
public class GuardServiceImp implements GuardService{


    GuardRepository guardRepository;

    public GuardServiceImp(GuardRepository guardRepository) {
        this.guardRepository = guardRepository;
    }

    @Override
    public void save(Guard guard) {
        guardRepository.save(guard);
    }

    @Override
    public void delete(Long id) {
        guardRepository.deleteById(id);
    }


    @Override
    public List<Guard> allGuards() {
        return guardRepository.findAll();
    }

    @Override
    public List<Guard> findAllByAgeMoreThan50() {
        return guardRepository.findAllByAgeMoreThan50();
    }


}
