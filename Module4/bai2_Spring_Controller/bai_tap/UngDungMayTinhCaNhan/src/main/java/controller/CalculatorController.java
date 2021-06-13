package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {
    @GetMapping("/")
    public String showHome(){
        return "index";
    }

    @PostMapping("/")
    public ModelAndView calculate(@RequestParam int firstNum, int secondNum, String mathButton){
        String result = null;
        if (mathButton.equals("+")){
            result = String.valueOf(firstNum + secondNum);
        }
        else if (mathButton.equals("-")){
            result = String.valueOf(firstNum - secondNum);
        }
        else if (mathButton.equals("*")){
            result = String.valueOf(firstNum * secondNum);
        }
        else if (mathButton.equals("/")){
            if (secondNum != 0) {
                result = String.valueOf(firstNum / secondNum);
            }
            else {
                result = "Can't divide by zero!";
            }
        }
        return new ModelAndView("index", "result", result);
    }
}
