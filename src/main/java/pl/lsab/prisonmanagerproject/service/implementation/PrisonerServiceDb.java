package pl.lsab.prisonmanagerproject.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.lsab.prisonmanagerproject.entity.Cell;
import pl.lsab.prisonmanagerproject.entity.Prisoner;
import pl.lsab.prisonmanagerproject.repository.PrisonerRepository;
import pl.lsab.prisonmanagerproject.service.PrisonerService;

import java.util.List;

@Service
public class PrisonerServiceDb implements PrisonerService {

    private final PrisonerRepository prisonerRepository;

    @Autowired
    public PrisonerServiceDb(PrisonerRepository prisonerRepository) {
        this.prisonerRepository = prisonerRepository;
    }

    @Override
    public void addPrisoner(Prisoner prisoner) {
        prisonerRepository.save(prisoner);
    }

    @Override
    public List<Prisoner> findAll() {
        return prisonerRepository.findAll();
    }

    @Override
    public void removePrisoner(Long id) {
        prisonerRepository.deleteById(id);
    }

    @Override
    public Prisoner findPrisonerById(Long id) {
       return prisonerRepository.findPrisonerById(id);
    }

    @Override
    @Transactional
    public void setUpdatePrisoner(Cell cell, Long id) {
        prisonerRepository.setUpdatePrisonerCell(cell, id);
    }

    @Override
    public List<Prisoner> searchPrison(String word) {
        return prisonerRepository.searchPrisonByPartOfNameOrSurname(word);
    }
}