package pl.lsab.prisonmanagerproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        prisonerRepository.findPrisonerById(id);
        return null;
    }


}