package bai19_String_Va_RegEx.bai_tap.ValidateSoDienThoai;

import java.util.Scanner;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("\\W{0}[(](\\d{2})[)](-)[(](0)(\\d{9})[)]");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input phone number: ");
        String phoneNumber = scanner.nextLine();
        Matcher matcher = pattern.matcher(phoneNumber);

        if(!matcher.matches()){
            System.out.println(phoneNumber + " is an invalid phone number.");
        }
        else {
            System.out.println(phoneNumber + " is a valid phone number.");
        }
    }
}
