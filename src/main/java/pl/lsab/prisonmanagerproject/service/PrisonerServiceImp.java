package pl.lsab.prisonmanagerproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.lsab.prisonmanagerproject.entity.Cell;
import pl.lsab.prisonmanagerproject.entity.Guard;
import pl.lsab.prisonmanagerproject.entity.Prisoner;
import pl.lsab.prisonmanagerproject.repository.PrisonerRepository;

import java.util.List;

@Service
public class PrisonerServiceImp implements PrisonerService{

    private final PrisonerRepository prisonerRepository;

    @Autowired
    public PrisonerServiceImp(PrisonerRepository prisonerRepository) {
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
        prisonerRepository.setUpdatePrisoner(cell, id);
    }

    @Override
    public List<Prisoner> searchPrison(String word) {
        return prisonerRepository.searchPrison(word);
    }


}