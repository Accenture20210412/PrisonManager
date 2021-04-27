package pl.lsab.prisonmanagerproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.lsab.prisonmanagerproject.entity.Admin;
import pl.lsab.prisonmanagerproject.service.AdminService;

import java.security.Principal;

@Controller
@RequestMapping("/")
public class HomeController {

   private AdminService adminService;

    public HomeController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping()
    public String LandingPageController(
            Principal principal) {
        if (principal != null) {
           return "dashboard/main";
        }else{
            return "redirect:/login";
        }
    }
    @PostMapping()
    public String test(){
        Admin admin = new Admin();
        if (adminService.findByUsername(admin.getUsername()) == null){
            return "redirect:register";
        }
        return "redirect:/login";
    }
}
