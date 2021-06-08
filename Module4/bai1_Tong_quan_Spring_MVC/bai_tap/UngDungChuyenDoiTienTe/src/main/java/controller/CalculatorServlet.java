package controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


public class CalculatorServlet {
    @GetMapping("/calculates")
    public ModelAndView showList(@RequestParam String input) {
        ModelAndView modelAndView = new ModelAndView("calculate");
        String result;
        if (!isInteger(input) || input == null){
            result = "Please input a valid number.";
        }
        else {
            int amount = Integer.parseInt(input);
            int converted = amount * 22000;
            result = String.valueOf(converted);
        }
        modelAndView.addObject("result", result);
        return modelAndView;
    }

    public boolean isInteger(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
