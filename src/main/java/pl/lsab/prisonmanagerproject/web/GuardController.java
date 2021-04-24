package pl.lsab.prisonmanagerproject.web;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.lsab.prisonmanagerproject.entity.Admin;
import pl.lsab.prisonmanagerproject.entity.Guard;
import pl.lsab.prisonmanagerproject.entity.Prisoner;
import pl.lsab.prisonmanagerproject.service.AdminServiceImp;
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
    PrisonerServiceImp prisonerServiceImp;

    public GuardController(GuardServiceImp guardServiceImp, AdminServiceImp adminServiceImp, PrisonerServiceImp prisonerServiceImp) {
        this.guardServiceImp = guardServiceImp;
        this.adminServiceImp = adminServiceImp;
        this.prisonerServiceImp = prisonerServiceImp;
    }

    @GetMapping()
    public String allGuards(Model model, Model model1){
        List<Guard> guards = guardServiceImp.allGuards();
        List<Prisoner>prisoners = prisonerServiceImp.findAll();
        model.addAttribute("guards",guards);
        model1.addAttribute("prison",prisoners);
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


    @GetMapping("/{id}")
    public String addCellToGuard(@PathVariable Long id){
        return "sa";
        }




}
