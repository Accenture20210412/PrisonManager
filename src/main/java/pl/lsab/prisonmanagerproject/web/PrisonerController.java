package pl.lsab.prisonmanagerproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.lsab.prisonmanagerproject.entity.Prisoner;
import pl.lsab.prisonmanagerproject.service.PrisonerService;


import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/osadzeni")
public class PrisonerController {
    private PrisonerService prisonerService;

    public PrisonerController(PrisonerService prisonerService) {

        this.prisonerService = prisonerService;
    }

    @PostMapping("/dodaj")
    public String addPrisoner(@Valid @ModelAttribute Prisoner prisoner, BindingResult validation){
        if (!validation.hasErrors() && prisoner.getGridBegin().isBefore(prisoner.getGridEnd())){
            prisonerService.addPrisoner(prisoner);
            return "redirect:/osadzeni";
        }
        return "addPrisoner";
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