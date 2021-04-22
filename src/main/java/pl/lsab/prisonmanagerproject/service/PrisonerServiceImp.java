package pl.lsab.prisonmanagerproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import pl.lsab.prisonmanagerproject.entity.Prisoner;
import pl.lsab.prisonmanagerproject.repository.PrisonerRepository;

import java.util.List;

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
    public Prisoner findPrisonerByName(String name) {
        return prisonerRepository.findByName(name);
    }

    @Override
    public Prisoner findPrisonerBySurname(String surname) {
        return prisonerRepository.findBySurname(surname);
    }


    @Override
    public void removePrisonerFromJail(Prisoner prisoner) {
        prisonerRepository.delete(prisoner);
    }

}