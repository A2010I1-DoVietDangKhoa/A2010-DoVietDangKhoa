package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class RecipeController {
    @GetMapping("/")
    public String showHomePage(){
        return "index";
    }

    @PostMapping("/")
    public ModelAndView returnResult(@RequestParam ArrayList<String> ingredient){
        return new ModelAndView("index", "chosenIngredients", ingredient);
    }
}
