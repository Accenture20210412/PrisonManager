package pl.lsab.prisonmanagerproject.service.implementation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.lsab.prisonmanagerproject.entity.Cell;
import pl.lsab.prisonmanagerproject.entity.Guard;
import pl.lsab.prisonmanagerproject.repository.GuardRepository;
import pl.lsab.prisonmanagerproject.service.GuardService;

import java.util.List;

@Service
public class GuardServiceDb implements GuardService {

    GuardRepository guardRepository;

    public GuardServiceDb(GuardRepository guardRepository) {
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
        guardRepository.setUpdateGuardCell(cell,id);
    }

    @Override
    public List<Guard> searchGuardByPartOfNameOrSurname(String word) {
        return guardRepository.searchGuardByPartOfNameOrSurname(word);
    }
}
