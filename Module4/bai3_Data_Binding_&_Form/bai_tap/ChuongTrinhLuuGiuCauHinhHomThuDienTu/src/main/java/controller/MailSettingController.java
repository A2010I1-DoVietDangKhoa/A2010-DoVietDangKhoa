package controller;

import model.MailSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.MailSettingService;

@Controller
public class MailSettingController {
    @Autowired
    private MailSettingService mailSettingService;

    @GetMapping("/")
    public ModelAndView showHomePage(){
        return new ModelAndView("index", "listSetting", mailSettingService.getAll());
    }


    @PostMapping("/create")
    public String createNewSetting(@ModelAttribute MailSetting mailSetting, RedirectAttributes redirectAttributes){
        mailSettingService.add(mailSetting);
        redirectAttributes.addFlashAttribute("listSetting", mailSettingService.getAll());
        return "redirect:/";
    }

    @GetMapping(value = "/create")
    public String showCreatePage(Model model){
        MailSetting mailSetting = new MailSetting();
        model.addAttribute(mailSetting);
        return "create";
    }

    @GetMapping(value = "/edit/{id}")
    public String showEditPage(@PathVariable int id, Model model){
        MailSetting mailSetting = mailSettingService.getById(id);
        model.addAttribute(mailSetting);
        return "edit";
    }

    @PostMapping(value = "/edit/{id}")
    public String updateMailSetting(@PathVariable int id, @ModelAttribute MailSetting mailSetting, RedirectAttributes redirectAttributes){
        mailSettingService.updateMailSetting(id, mailSetting);
        redirectAttributes.addFlashAttribute("listSetting", mailSettingService.getAll());
        return "redirect:/";
    }
}
