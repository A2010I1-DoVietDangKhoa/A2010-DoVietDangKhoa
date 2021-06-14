package controller;

import model.MailSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.MailSettingService;

@Controller
public class MailSettingController {
    @GetMapping("/")
    public String showHomePage(){
        return "index";
    }

    @GetMapping("/create")
    public String showCreatePage(){
        return "create";
    }

    @Autowired
    private MailSettingService mailSettingService;

    @PostMapping("/create")
    public String createNewSetting(@ModelAttribute MailSetting mailSetting, RedirectAttributes redirectAttributes){
        mailSettingService.add(mailSetting);
        redirectAttributes.addFlashAttribute("result", "Created new setting");
        return "redirect:index";
    }
}
