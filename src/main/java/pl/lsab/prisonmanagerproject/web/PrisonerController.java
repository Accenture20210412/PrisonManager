package pl.lsab.prisonmanagerproject.web;

import org.springframework.data.repository.query.Param;
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
    public String allPrisoners(Model prisoners, Model onePrisoner, Model cells){
        Prisoner prisoner = new Prisoner();
        Cell cell = new Cell();
        List<Prisoner> allPrisoners = prisonerService.findAll();
        List<Cell>allCells = cellService.findAll();
        prisoners.addAttribute("prisoners",allPrisoners);
        cells.addAttribute("cells",allCells);
        onePrisoner.addAttribute("onePrisoner",prisoner);
        return "dashboard/prisoners/prisoners";
    }
    @PostMapping()
    public String addCellToPrisoner(@ModelAttribute Prisoner prisoner) {
       Prisoner prisoner1 =new Prisoner();
        Cell cell1 = new Cell();
        List<Cell>allCells = cellService.findAll();
        if (allCells.size()!=0) {
            if (prisoner.getCell() == null) {
                prisoner1 = prisonerService.findPrisonerById(prisoner.getId());
                Prisoner finalPrisoner = prisoner1;
                Predicate<Cell> isQualified = cell -> cell.getPrisoners().contains(finalPrisoner);
                allCells.stream().filter(isQualified).forEach(Cell::getPrisoners);
                allCells.removeIf(isQualified);
                cell1 = allCells.get(0);
                prisonerService.setUpdatePrisoner(null, prisoner.getId());

            } else {
                cell1 = prisoner.getCell();
                prisoner1 = prisoner;
                prisoner1.setCell(cell1);
                cell1.getPrisoners().add(prisoner);
                prisonerService.setUpdatePrisoner(cell1, prisoner.getId());
            }
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
        Cell cell1 = new Cell();
        if (prisoner.getCell()!=null){
            findCellWithPrisoner(prisoner,cell1);
            prisonerService.setUpdatePrisoner(null, prisoner.getId());
        }
        prisonerService.removePrisoner(id);
        return "redirect:/osadzeni";
    }

    @GetMapping("/search")
    public String searchGuards(@Param("keyword") String keyword, Model prisoners, Model onePrisoner, Model cells){
        Prisoner prisoner = new Prisoner();
        Cell cell = new Cell();
        List<Prisoner> prisonerList = prisonerService.searchPrison(keyword);
        List<Cell>allCells = cellService.findAll();

        prisoners.addAttribute("prisoners",prisonerList);
        cells.addAttribute("cells",allCells);
        onePrisoner.addAttribute("onePrisoner",prisoner);

        return "dashboard/prisoners/prisoners";
    }

    private void findCellWithPrisoner(Prisoner prisoner,Cell cell1) {
        List<Cell> allCells = cellService.findAll();
        Prisoner prisoner1 = prisonerService.findPrisonerById(prisoner.getId());
        Predicate<Cell> isQualified = cell -> cell.getPrisoners().contains(prisoner1);
        allCells.stream().filter(isQualified).forEach(Cell::getPrisoners);
        allCells.removeIf(isQualified);
        cell1 = allCells.get(0) ;

    }

}