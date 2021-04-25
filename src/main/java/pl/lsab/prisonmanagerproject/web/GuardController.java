package pl.lsab.prisonmanagerproject.web;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.lsab.prisonmanagerproject.entity.Cell;
import pl.lsab.prisonmanagerproject.entity.Guard;
import pl.lsab.prisonmanagerproject.service.AdminServiceImp;
import pl.lsab.prisonmanagerproject.service.CellServiceImp;
import pl.lsab.prisonmanagerproject.service.GuardServiceImp;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/straznicy")
public class GuardController {


    GuardServiceImp guardServiceImp;
    AdminServiceImp adminServiceImp;
    CellServiceImp cellServiceImp;

    public GuardController(GuardServiceImp guardServiceImp, AdminServiceImp adminServiceImp, CellServiceImp cellServiceImp) {
        this.guardServiceImp = guardServiceImp;
        this.adminServiceImp = adminServiceImp;
        this.cellServiceImp = cellServiceImp;
    }

    @GetMapping()
    public String allGuards(Model guards, Model cells, Model oneGuard){
        Guard guard = new Guard();
        List<Guard> allGuards = guardServiceImp.allGuards();
        List<Cell>allCellsWhereNoGuard = cellServiceImp.findAllWhereNoGuard();
        guards.addAttribute("guards",allGuards);
        cells.addAttribute("cells",allCellsWhereNoGuard);
        oneGuard.addAttribute("oneGuard",guard);

        return "dashboard/guards/guards";
    }

    @GetMapping("/dodaj")
    public String addGuard(Model model){
        model.addAttribute("guard",new Guard());
        return "dashboard/guards/addGuard";
    }

    @PostMapping("/dodaj")
    public String addGuard(@Valid @ModelAttribute Guard guard, BindingResult result){
        if (result.hasErrors()) {
            return "dashboard/guards/addGuard";
        }
        guardServiceImp.save(guard);
        return "redirect:/straznicy";
    }

    @GetMapping("/delete/{id}")
    public String deleteGuard(@PathVariable Long id){
       Guard guard = guardServiceImp.findOne(id);
        if(guard.getCell()!=null) {
            cellServiceImp.updateCellGuard(null, guard.getCell().getId());
        }
        guardServiceImp.delete(id);
        return "redirect:/straznicy";
    }


    @PostMapping()
    public String addCellToGuard(@ModelAttribute Guard guard){
        Guard guard1= new Guard();
        Cell cell1 = new Cell();
        if (guard.getCell()==null){
            cell1 = cellServiceImp.findByGuard(guard);
            guardServiceImp.setUpdateGuard(null, guard.getId());
            cellServiceImp.updateCellGuard(null,cell1.getId());
        }else {
            cell1 = guard.getCell();
            guard1 = guard;
            guard1.setCell(cell1);

            guardServiceImp.setUpdateGuard(cell1, guard.getId());
            cellServiceImp.updateCellGuard(guard, cell1.getId());
        }
       return "redirect:/straznicy";
        }

    @GetMapping("/search")
    public String searchGuards(@Param("keyword") String keyword, Model guards, Model cells, Model oneGuard){
        Guard guard = new Guard();
        String word = keyword;
        List<Guard> guardSearchList = guardServiceImp.searchGuard(word);
        List<Cell>allCellsWhereNoGuard = cellServiceImp.findAllWhereNoGuard();

        guards.addAttribute("guards",guardSearchList);
        cells.addAttribute("cells",allCellsWhereNoGuard);
        oneGuard.addAttribute("oneGuard",guard);

        return "dashboard/guards/guards";
    }


}

