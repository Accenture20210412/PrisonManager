package pl.lsab.prisonmanagerproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.lsab.prisonmanagerproject.entity.Admin;
import pl.lsab.prisonmanagerproject.service.implementation.AdminServiceImp;

import javax.validation.Valid;

@Controller
@RequestMapping("/rejestracja")
public class RegistrationController {

    AdminServiceImp adminServiceImp;

    public RegistrationController(AdminServiceImp adminServiceImp) {
        this.adminServiceImp = adminServiceImp;
    }

    @GetMapping
    public String registerForm( Model model){
        Admin admin = new Admin();
        model.addAttribute("admin", admin);
        return "registration";
    }

    @PostMapping
    public String registerAction (@ModelAttribute @Valid Admin admin, BindingResult result) {
        Admin admin1 = adminServiceImp.findByUsername(admin.getUsername());
        if (admin1 != null) {
            result.rejectValue("username", "error.admin",
                    "Admin zarejestrowany");
        }
        if (result.hasErrors()) {
            return "registration";
        }
        if (!admin.getPassword().equals(admin.getPasswordRepeat())) {
            return"registration";
        }
        admin.setEnable(true);
        adminServiceImp.save(admin);
        return "redirect:/logowanie";
    }


}
