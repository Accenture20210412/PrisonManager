package pl.lsab.prisonmanagerproject.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.lsab.prisonmanagerproject.entity.Prisoner;
import pl.lsab.prisonmanagerproject.service.PrisonerService;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
@RequestMapping("/osadzeni")
public class PrisonerController {
    private PrisonerService prisonerService;

    public PrisonerController(PrisonerService prisonerService) {
        this.prisonerService = prisonerService;
    }

    @PostMapping("/dodaj")
    public String addPrisoner(@ModelAttribute Prisoner prisoner){
        prisonerService.addPrisoner(prisoner);
        return "redirect:/osadzeni";
    }

    @GetMapping("/dodaj")
    public String addPrisoner(Model model){
        model.addAttribute("prisoner",new Prisoner());
        return "addPrisoner";
    }

    @GetMapping
    public String findAll(Model model){
        List<Prisoner> prisoners = prisonerService.findAll();
        model.addAttribute("prisoners", prisoners);
        return "prisoners";
    }

    @GetMapping("/delete/{id}")
    public String deletePrisoner(@PathVariable Long id){
        prisonerService.removePrisoner(id);
        return "redirect:/osadzeni";
    }
}