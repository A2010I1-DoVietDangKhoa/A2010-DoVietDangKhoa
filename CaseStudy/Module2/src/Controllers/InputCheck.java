package Controllers;

public class InputCheck {
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
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public boolean isValidIndex(String index, int arrayListLength){
        if(isInteger(index)){
            int indexTest = Integer.parseInt(index) - 1;
            if(indexTest >=0 && indexTest < arrayListLength){
                return true;
            }
            else{
                return false;
            }
        }
        else {
            return false;
        }
    }
}
