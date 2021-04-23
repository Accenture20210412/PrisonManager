package pl.lsab.prisonmanagerproject.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.lsab.prisonmanagerproject.entity.Prisoner;
import pl.lsab.prisonmanagerproject.service.PrisonerService;

import java.util.List;

@Controller
@RequestMapping("osadzeni")
public class PrisonerController {
    private PrisonerService prisonerService;

    @Autowired
    public PrisonerController(PrisonerService prisonerService) {
        this.prisonerService = prisonerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addPrisoner(@RequestBody Prisoner prisoner){
        prisonerService.addPrisoner(prisoner);
    }

    @GetMapping
    public List<Prisoner> findAll(){
        return prisonerService.findAll();
    }


}