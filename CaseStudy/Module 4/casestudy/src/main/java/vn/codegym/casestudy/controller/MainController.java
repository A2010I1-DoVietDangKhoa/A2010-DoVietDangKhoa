package vn.codegym.casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import vn.codegym.casestudy.model.People.Employee.UserEntity;
import vn.codegym.casestudy.service.UserService;

import java.security.Principal;

@Controller
@SessionAttributes("accountUser")
public class MainController {
    private final UserService userService;

    @Autowired
    private MainController(UserService userService){
        this.userService = userService;
    }

    @ModelAttribute("accountUser")
    public UserEntity getUser(Principal principal) {
        if (principal != null) {
            return userService.findByUsername(principal.getName());
        }
        return new UserEntity();
    }

    @GetMapping("")
    public String showHomePage(Model model) {
        return "index";
    }

    @GetMapping("/index")
    public String showHomeLogined(@ModelAttribute("accountUser") UserEntity userEntity, Principal principal, Model model) {
        String username = "";
        if (principal != null) {
            username = principal.getName();
            model.addAttribute("accountUser", userService.findByUsername(username));
        }
        return "index";
    }

}
