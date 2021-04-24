package pl.lsab.prisonmanagerproject.service;

import org.springframework.stereotype.Service;
import pl.lsab.prisonmanagerproject.entity.Cell;
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
}