package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.DictionaryService;

@Controller
public class DictionaryServlet {
    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping(value = "/")
    private String showHomePage(){
        dictionaryService.addDefinition("hello", "Xin chào");
        dictionaryService.addDefinition("welcome", "Xin mời");
        dictionaryService.addDefinition("bye", "Tạm biệt");
        dictionaryService.addDefinition("boy", "Con trai");
        dictionaryService.addDefinition("girl", "Con gái");
        return "index";
    }

    @GetMapping(value = "/translate")
    private ModelAndView showMeaning(@RequestParam String eng){
        return new ModelAndView("index", "vie", dictionaryService.getDefinition(eng));
    }
}
