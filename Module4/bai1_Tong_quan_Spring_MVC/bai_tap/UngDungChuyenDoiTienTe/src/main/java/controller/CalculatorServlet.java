package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorServlet {
    @GetMapping(value = "/")
    public String getForm() {
        return "index";
    }

    @GetMapping(value = "/exchange")
    public String convert(@RequestParam String rate, @RequestParam String usd, Model model) {
        if(!isInteger(rate) || !isInteger(usd) || rate == null || usd == null){
            String result = "Please input valid numbers.";
            model.addAttribute("rate", rate);
            model.addAttribute("usd", usd);
            model.addAttribute("result", result);
        }
        else {
            int usdNum = Integer.parseInt(usd);
            int rateNum = Integer.parseInt(rate);
            int vnd = usdNum * rateNum;
            model.addAttribute("rate", rate);
            model.addAttribute("usd", usd);
            model.addAttribute("vnd", vnd);
        }
        return "index";
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
