package pl.lsab.prisonmanagerproject.service;

import org.springframework.stereotype.Service;
import pl.lsab.prisonmanagerproject.entity.Guard;

import java.util.List;

@Service
public class GuardServiceImp implements GuardService{
    @Override
    public void save(Guard guard) {

    }

    @Override
    public void delete(Guard guard) {

    }

    @Override
    public Guard findGuardById(Long id) {
        return null;
    }

    @Override
    public List<Guard> allGuards() {
        return null;
    }
}
