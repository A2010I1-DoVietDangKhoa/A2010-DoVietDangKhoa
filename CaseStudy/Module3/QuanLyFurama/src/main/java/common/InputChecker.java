package common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputChecker {
    private static final Pattern NAME_PATTERN = Pattern.compile("^[A-Z].*");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("[\\w]*(@)[a-zA-z]+(.)[a-zA-Z]+");
    private static final Pattern ID_PATTERN = Pattern.compile("[0-9]{9}");
    private static final Pattern PHONE_PATTERN_1 = Pattern.compile("(091)[0-9]{7}");
    private static final Pattern PHONE_PATTERN_2 = Pattern.compile("(090)[0-9]{7}");
    public boolean emailCheck(String email){
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        if(matcher.matches()){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean nameCheck(String name){
        String[] list = name.split(" ");
        Matcher matcher;
        boolean check = false;
        for (int i = 0; i < list.length; i++) {
            matcher = NAME_PATTERN.matcher(list[i]);
            if (matcher.matches()) {
                check = true;
            } else {
                check = false;
            }
        }
        return check;
    }

    public boolean idCheck(String id){
        Matcher matcher = ID_PATTERN.matcher(id);
        if(matcher.matches()){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean phoneCheck(String phone){
        Matcher matcher1 = PHONE_PATTERN_1.matcher(phone);
        Matcher matcher2 = PHONE_PATTERN_2.matcher(phone);
        if(matcher1.matches() || matcher2.matches()){
            return true;
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
}
