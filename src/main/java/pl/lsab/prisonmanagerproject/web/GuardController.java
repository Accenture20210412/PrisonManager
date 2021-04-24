package pl.lsab.prisonmanagerproject.web;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.lsab.prisonmanagerproject.entity.Admin;
import pl.lsab.prisonmanagerproject.entity.Cell;
import pl.lsab.prisonmanagerproject.entity.Guard;
import pl.lsab.prisonmanagerproject.entity.Prisoner;
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
    public String allGuards(Model guards, Model cells, Model oneGuard){
        Guard guard = new Guard();
        Cell cell = new Cell();
        List<Guard> allGuards = guardServiceImp.allGuards();
        List<Cell>allCells = cellServiceImp.findAll();
        guards.addAttribute("guards",allGuards);
        cells.addAttribute("cells",allCells);
        oneGuard.addAttribute("oneGuard",guard);
        cells.addAttribute("oneCell",cell);
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
       guardServiceImp.delete(id);
        return "redirect:/straznicy";
    }


    @PostMapping()
    public String addCellToGuard(@ModelAttribute Guard guard){
        Cell cell1 = guard.getCells().get(0);
        cell1.setGuard(guard);


        guardServiceImp.setUpdateGuard(guard, guard.getId());
        cellServiceImp.update(guard, cell1.getId());


//       Guard guard1 = guardServiceImp.findOne(guard);
//       Cell cell1 = cellServiceImp.findOne(cellId);
//       guard.getCells().add(cell);
//       cellServiceImp.update(guard,cellId);
       return "redirect:/straznicy";
        }




}
