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

@Controller
@RequestMapping("/cele")
public class CellController {

    private CellService cellService;
    private PrisonerService prisonerService;

    public CellController(CellService cellService, PrisonerService prisonerService) {
        this.cellService = cellService;
        this.prisonerService = prisonerService;
    }

    @PostMapping("/nowacela")
    public String addCell(@Valid @ModelAttribute Cell cell, BindingResult validation){
        if (validation.hasErrors()){
            return "addCell";
        }
        cellService.add(cell);
        return "redirect:/cele";
    }

    @GetMapping("/nowacela")
    public String addCell(Model model){
        model.addAttribute("cell", new Cell());
        return "addCell";
    }

    @GetMapping
    public String findAll(Model model){
        List<Cell> cells = cellService.findAll();
        List<Prisoner> prisoners = prisonerService.findAll();
        model.addAttribute("cells", cells);
        model.addAttribute("prisoners",prisoners);
        return "cells";
    }
}
