package pl.lsab.prisonmanagerproject.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.lsab.prisonmanagerproject.entity.Prisoner;
import pl.lsab.prisonmanagerproject.service.PrisonerService;

@Controller
@RequestMapping("osadzeni")
public class PrisonerController {
    private PrisonerService prisonerService;

    @Autowired
    public PrisonerController(PrisonerService prisonerService) {
        this.prisonerService = prisonerService;
    }

    @GetMapping("/dodajOsadzonego")
    public String addPrisoner(Model model){
        model.addAttribute("prisoner", new Prisoner());
        return null;
    }
}
