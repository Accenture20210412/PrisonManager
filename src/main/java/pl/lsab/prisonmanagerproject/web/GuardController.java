package pl.lsab.prisonmanagerproject.web;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.lsab.prisonmanagerproject.entity.Admin;
import pl.lsab.prisonmanagerproject.entity.Cell;
import pl.lsab.prisonmanagerproject.entity.Guard;
import pl.lsab.prisonmanagerproject.service.AdminServiceImp;
import pl.lsab.prisonmanagerproject.service.CellServiceImp;
import pl.lsab.prisonmanagerproject.service.GuardServiceImp;
import pl.lsab.prisonmanagerproject.service.PrisonerServiceImp;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

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
    public String allGuards(Model guards, Model cells, Model oneGuard, Model oneCell){
        Guard guard = new Guard();
        Cell cell = new Cell();
        List<Guard> allGuards = guardServiceImp.allGuards();
        List<Cell>allCellsWhereNoGuard = cellServiceImp.findAllWhereNoGuard();
        guards.addAttribute("guards",allGuards);
        cells.addAttribute("cells",allCellsWhereNoGuard);
        oneGuard.addAttribute("oneGuard",guard);
        oneCell.addAttribute("oneCell",cell);
        return "dashboard/guards";
    }

    @GetMapping("/dodaj")
    public String addGuard(Model model){
        model.addAttribute("guard",new Guard());
        return "addGuard";
    }

    @PostMapping("/dodaj")
    public String addGuard(@Valid @ModelAttribute Guard guard, BindingResult result){
        if (result.hasErrors()) {
            return "addGuard";
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




}
