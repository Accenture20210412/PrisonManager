package pl.lsab.prisonmanagerproject.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.lsab.prisonmanagerproject.entity.Cell;
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
    public Guard findOne(Long id) {
        return guardRepository.findOne(id);
    }

    @Override
    @Transactional
    public void setUpdateGuard(Cell cell, Long id) {
        guardRepository.setUpdateGuard(cell,id);
    }


}
