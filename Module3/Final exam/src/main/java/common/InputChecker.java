package common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputChecker {
    private static final Pattern CODE_PATTERN = Pattern.compile("[A-Z0-9]{3}(-)[A-Z0-9]{2}(-)[A-Z0-9]{2}");

    public boolean codeCheck(String code){
        Matcher matcher = CODE_PATTERN.matcher(code);
        if(matcher.matches()){
            return true;
        }
        else {
            return false;
        }
    }


    public boolean priceCheck(String price){
        if(isDouble(price)){
            double check = Double.parseDouble(price);
            if (check > 1000000){
                return true;
            }
            else return false;
        }
        else {
            return false;
        }
    }

    public boolean areaCheck(String area){
        if(isDouble(area)){
            double check = Double.parseDouble(area);
            if (check >= 20){
                return true;
            }
            else return false;
        }
        else {
            return false;
        }
    }

    public boolean floorCheck(String floor){
        if(isInteger(floor)){
            int check = Integer.parseInt(floor);
            if (check > 0 && check <= 15){
                return true;
            }
            else return false;
        }
        else {
            return false;
        }
    }


    public boolean isDouble(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
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
