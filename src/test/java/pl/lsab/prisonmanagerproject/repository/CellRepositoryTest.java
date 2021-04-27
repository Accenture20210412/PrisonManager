package pl.lsab.prisonmanagerproject.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.lsab.prisonmanagerproject.entity.Cell;
import pl.lsab.prisonmanagerproject.entity.Guard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class CellRepositoryTest {
    @Autowired
    CellRepository cellRepository;

    @Test
    void findAll() {
        Cell cell = new Cell(1L);
        cellRepository.save(cell);
        List<Cell> cellList = cellRepository.findAll();
        assertEquals(1, cellList.size());
    }

    @Test
    void findOneCellById() {
        Cell cell = new Cell(1L,1);
        cellRepository.save(cell);
        Cell findCell = cellRepository.findOneCellById((cell.getId()));
        assertEquals(findCell.getId(),cell.getId());
    }
}