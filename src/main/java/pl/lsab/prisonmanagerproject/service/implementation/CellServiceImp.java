package pl.lsab.prisonmanagerproject.service.implementation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.lsab.prisonmanagerproject.entity.Cell;
import pl.lsab.prisonmanagerproject.entity.Guard;
import pl.lsab.prisonmanagerproject.entity.Prisoner;
import pl.lsab.prisonmanagerproject.repository.CellRepository;
import pl.lsab.prisonmanagerproject.service.CellService;

import java.util.List;

@Service
public class CellServiceImp implements CellService {

    CellRepository cellRepository;

    public CellServiceImp(CellRepository cellRepository) {
        this.cellRepository = cellRepository;
    }

    @Override
    public void add(Cell cell) {
        cellRepository.save(cell);
    }

    @Override
    public List<Cell> findAll() {
        return cellRepository.findAll();
    }

    @Override
    public Cell findOne(Long id) {
        return cellRepository.findOneCellById(id);
    }

    @Override
    @Transactional
    public void updateCellByGuard(Guard guard, Long id) {
        cellRepository.setUpdateGuardToCell(guard, id);
    }

    public Cell findCellByGuard(Guard guard) {
       return cellRepository.findByGuard(guard);
    }

    public List<Cell>findAllCellWhereNoGuard(){
       return cellRepository.findAllCellWhereNoGuard();
    }

    @Override
    public Cell findLastCellCreated() {
        return cellRepository.findLastCellCreated();
    }

    @Override
    @Transactional
    public void updatePrisonerList(List<Prisoner> prisonersList, Long id) {

    }
}

