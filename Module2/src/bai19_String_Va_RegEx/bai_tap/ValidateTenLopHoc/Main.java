package bai19_String_Va_RegEx.bai_tap.ValidateTenLopHoc;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("\\W{0}(C|A|P)[0-9]{4}(G|H|I|K|L|M)");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input class name: ");
        String className = scanner.nextLine();
        Matcher matcher = pattern.matcher(className);

        if(!matcher.matches()){
            System.out.println(className + " is an incorrect class name.");
        }
        else {
            System.out.println(className + " is a correct class name.");
        }
    }
}
