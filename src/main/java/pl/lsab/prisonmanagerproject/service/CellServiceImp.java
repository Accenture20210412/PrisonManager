package pl.lsab.prisonmanagerproject.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.lsab.prisonmanagerproject.entity.Cell;
import pl.lsab.prisonmanagerproject.entity.Guard;
import pl.lsab.prisonmanagerproject.repository.CellRepository;

import java.util.List;

@Service
public class CellServiceImp implements CellService{

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
        return cellRepository.findOne(id);
    }

    @Override
    @Transactional
    public void update(Guard guard, Long id) {
         cellRepository.setUpdateCell(guard,id);
    }
}