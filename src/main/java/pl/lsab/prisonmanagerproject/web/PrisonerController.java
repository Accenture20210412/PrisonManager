package pl.lsab.prisonmanagerproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.lsab.prisonmanagerproject.entity.Cell;
import pl.lsab.prisonmanagerproject.entity.Prisoner;
import pl.lsab.prisonmanagerproject.service.CellService;
import pl.lsab.prisonmanagerproject.service.PrisonerService;

import javax.validation.Valid;
import java.util.List;
import java.util.function.Predicate;

@Controller
@RequestMapping("/osadzeni")
public class PrisonerController {
    private PrisonerService prisonerService;
    private CellService cellService;

    public PrisonerController(PrisonerService prisonerService, CellService cellService) {
        this.prisonerService = prisonerService;
        this.cellService = cellService;
    }

    @GetMapping()
    public String allPrisoners(Model prisoners, Model onePrisoner, Model oneCell, Model cells){
        Prisoner prisoner = new Prisoner();
        Cell cell = new Cell();
        List<Prisoner> allPrisoners = prisonerService.findAll();
        List<Cell>allCells = cellService.findAll();
        prisoners.addAttribute("prisoners",allPrisoners);
        cells.addAttribute("cells",allCells);
        onePrisoner.addAttribute("onePrisoner",prisoner);
        oneCell.addAttribute("oneCell",cell);
        return "dashboard/prisoners/prisoners";
    }

    @PostMapping()
    public String addCellToPrisoner(@ModelAttribute Prisoner prisoner) {
        Prisoner prisoner1 = new Prisoner();
        Cell cell1 = new Cell();
        if (prisoner.getCell() == null) {
            Predicate<Cell> isQualified = c -> c.getPrisoners().contains(prisoner);
            List<Cell> allCells = cellService.findAll();
            allCells.stream().filter(isQualified).forEach(Cell::getPrisoners);
            allCells.removeIf(isQualified);
            cell1 = allCells.get(0);
            prisonerService.setUpdatePrisoner(null, prisoner.getId());
            cellService.updatePrisonerList(List.copyOf(cell1.getPrisoners()), cell1.getId());
        } else {
            cell1 = prisoner.getCell();
            prisoner1 = prisoner;
            prisoner1.setCell(cell1);
            cell1.getPrisoners().add(prisoner);

            prisonerService.setUpdatePrisoner(cell1, prisoner.getId());
            cellService.updatePrisonerList(List.copyOf(cell1.getPrisoners()), cell1.getId());
        }

        return "redirect:/osadzeni";
    }
    @PostMapping("/dodaj")
    public String addPrisoner(@Valid @ModelAttribute Prisoner prisoner, BindingResult validation){
        if (!validation.hasErrors() && prisoner.getGridBegin().isBefore(prisoner.getGridEnd())){
            prisonerService.addPrisoner(prisoner);
            return "redirect:/osadzeni";
        }
        return "dashboard/prisoners/addPrisoner";
    }

    @GetMapping("/dodaj")
    public String addPrisoner(Model model){
        model.addAttribute("prisoner",new Prisoner());
        return "dashboard/prisoners/addPrisoner";
    }


    @GetMapping("/delete/{id}")
    public String deletePrisoner(@PathVariable Long id){
        Prisoner prisoner = prisonerService.findPrisonerById(id);
        if (prisoner.getCell()!=null){
            List<Cell>allCells = cellService.findAll();
           Cell cell = allCells.stream().filter(c -> c.getPrisoners().stream().map(p -> p.equals(prisoner)).findFirst().get()).findFirst().get();
           cell.getPrisoners().remove(prisoner);
        }
        prisonerService.removePrisoner(id);
        return "redirect:/osadzeni";
    }


}