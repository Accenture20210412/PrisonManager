package pl.lsab.prisonmanagerproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.lsab.prisonmanagerproject.entity.Admin;
import pl.lsab.prisonmanagerproject.service.AdminServiceImp;

import java.security.Principal;

@Controller
@RequestMapping("/")
public class HomeController {

    AdminServiceImp adminServiceImp;


    public HomeController(AdminServiceImp adminServiceImp) {
        this.adminServiceImp = adminServiceImp;
    }

    @GetMapping()
    public String LandingPageController(
            Principal principal, Model model) {

        model.addAttribute("logged_admin", principal);

        if (principal != null) {
            Admin admin = adminServiceImp.findByUsername(principal.getName());
            model.addAttribute("admin", admin);
        }
        return "index";
    }



}
