package pl.lsab.prisonmanagerproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.lsab.prisonmanagerproject.entity.Guard;
import pl.lsab.prisonmanagerproject.service.AdminServiceImp;
import pl.lsab.prisonmanagerproject.service.GuardServiceImp;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/straznicy")
public class GuardController {


    GuardServiceImp guardServiceImp;
    AdminServiceImp adminServiceImp;

    public GuardController(GuardServiceImp guardServiceImp, AdminServiceImp adminServiceImp) {
        this.guardServiceImp = guardServiceImp;
        this.adminServiceImp = adminServiceImp;
    }

    @GetMapping
    public String allGuards(@ModelAttribute Guard guard, Model model, Principal principal){
        model.addAttribute("admin",principal.getName());
        List<Guard> guards = guardServiceImp.allGuards();
        model.addAttribute("guards",guards);
        return "dashboard/guards";
    }



}
