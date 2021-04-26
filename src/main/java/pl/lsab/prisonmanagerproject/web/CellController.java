package pl.lsab.prisonmanagerproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.lsab.prisonmanagerproject.entity.Cell;
import pl.lsab.prisonmanagerproject.entity.Prisoner;
import pl.lsab.prisonmanagerproject.service.CellService;
import pl.lsab.prisonmanagerproject.service.PrisonerService;

import java.util.List;

@Controller
@RequestMapping("/cele")
public class CellController {

    private CellService cellService;
    private PrisonerService prisonerService;

    public CellController(CellService cellService, PrisonerService prisonerService) {
        this.cellService = cellService;
        this.prisonerService = prisonerService;
    }


    @GetMapping("/nowa")
    public String addCell(){
        Cell cell = new Cell();
        long lastCellId = 0l;
        List<Cell> allCells = cellService.findAll();
        if (allCells.size()>0) {
            lastCellId = cellService.findLastCell().getId();
        }
            cell.setCellNumber((int) lastCellId);
            cellService.add(cell);
        return "redirect:/cele";
    }

    @GetMapping
    public String findAll(Model model){
        List<Cell> cells = cellService.findAll();
        List<Prisoner> prisoners = prisonerService.findAll();
        model.addAttribute("cells", cells);
        model.addAttribute("prisoners",prisoners);
        return "dashboard/prisoners/cells";
    }
}
