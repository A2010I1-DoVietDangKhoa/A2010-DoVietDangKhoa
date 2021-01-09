package bai1_Introduction_to_Java.bai_tap;

import java.util.Scanner;
import java.util.SortedMap;

public class UngDungDocSoThanhChu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hãy nhập số: ");
        int number = scanner.nextInt();
        
        String numberChar = String.valueOf(number);
        if(number >= 0 && number < 10 ){
            switch (numberChar.charAt(0)){
                case '0':
                    System.out.println("Zero");
                    break;
                case '1':
                    System.out.println("One");
                    break;
                case '2':
                    System.out.println("Two");
                    break;
                case '3':
                    System.out.println("Three");
                    break;
                case '4':
                    System.out.println("Four");
                    break;
                case '5':
                    System.out.println("Five");
                    break;
                case '6':
                    System.out.println("Six");
                    break;
                case '7':
                    System.out.println("Seven");
                    break;
                case '8':
                    System.out.println("Eight");
                    break;
                case '9':
                    System.out.println("Nine");
                    break;
            }
        }
        else if(number > 10 && number <= 99){
            if(number % 10 == 0){
                switch (numberChar.charAt(0)){
                    case '1':
                        System.out.println("Ten");
                        break;
                    case '2':
                        System.out.println("Twenty");
                        break;
                    case '3':
                        System.out.println("Thirty");
                        break;
                    case '4':
                        System.out.println("Forty");
                        break;
                    case '5':
                        System.out.println("Fifty");
                        break;
                    case '6':
                        System.out.println("Sixty");
                        break;
                    case '7':
                        System.out.println("Seventy");
                        break;
                    case '8':
                        System.out.println("Eighty");
                        break;
                    case '9':
                        System.out.println("Ninety");
                        break;
                }
            }
            else {
                if(numberChar.charAt(0) == '1'){
                    switch (numberChar.charAt(1)){
                        case '1':
                            System.out.println("Eleven");
                            break;
                        case '2':
                            System.out.println("Twelve");
                            break;
                        case '3':
                            System.out.println("Thirteen");
                            break;
                        case '4':
                            System.out.println("Forteen");
                            break;
                        case '5':
                            System.out.println("Fifteen");
                            break;
                        case '6':
                            System.out.println("Sixteen");
                            break;
                        case '7':
                            System.out.println("Seventeen");
                            break;
                        case '8':
                            System.out.println("Eighteen");
                            break;
                        case '9':
                            System.out.println("Nineteen");
                            break;
                    }
                }
                else {
                    switch (numberChar.charAt(0)){
                        case '2':
                            System.out.print("Twenty ");
                            break;
                        case '3':
                            System.out.print("Thirty ");
                            break;
                        case '4':
                            System.out.print("Forty ");
                            break;
                        case '5':
                            System.out.print("Fifty ");
                            break;
                        case '6':
                            System.out.print("Sixty ");
                            break;
                        case '7':
                            System.out.print("Seventy ");
                            break;
                        case '8':
                            System.out.print("Eighty ");
                            break;
                        case '9':
                            System.out.print("Ninety ");
                            break;
                    }
                    switch (numberChar.charAt(1)){
                        case '1':
                            System.out.println("one");
                            break;
                        case '2':
                            System.out.println("two");
                            break;
                        case '3':
                            System.out.println("three");
                            break;
                        case '4':
                            System.out.println("four");
                            break;
                        case '5':
                            System.out.println("five");
                            break;
                        case '6':
                            System.out.println("six");
                            break;
                        case '7':
                            System.out.println("seven");
                            break;
                        case '8':
                            System.out.println("eight");
                            break;
                        case '9':
                            System.out.println("nine");
                            break;
                    }
                }
            }
        }
        else if(number >=100 && number <=999){
            if(number % 100 == 0) {
                switch (numberChar.charAt(0)) {
                    case '1':
                        System.out.print("One ");
                        break;
                    case '2':
                        System.out.print("Two ");
                        break;
                    case '3':
                        System.out.print("Three ");
                        break;
                    case '4':
                        System.out.print("Four ");
                        break;
                    case '5':
                        System.out.print("Five ");
                        break;
                    case '6':
                        System.out.print("Six ");
                        break;
                    case '7':
                        System.out.print("Seven ");
                        break;
                    case '8':
                        System.out.print("Eight ");
                        break;
                    case '9':
                        System.out.print("Nine ");
                        break;
                }
                System.out.println("hundred");
            }
            else if(number % 100 != 0 && number % 10 == 0){
                switch (numberChar.charAt(0)) {
                    case '1':
                        System.out.print("One ");
                        break;
                    case '2':
                        System.out.print("Two ");
                        break;
                    case '3':
                        System.out.print("Three ");
                        break;
                    case '4':
                        System.out.print("Four ");
                        break;
                    case '5':
                        System.out.print("Five ");
                        break;
                    case '6':
                        System.out.print("Six ");
                        break;
                    case '7':
                        System.out.print("Seven ");
                        break;
                    case '8':
                        System.out.print("Eight ");
                        break;
                    case '9':
                        System.out.print("Nine ");
                        break;
                }
                System.out.print("hundred ");

                switch (numberChar.charAt(1)){
                    case '1':
                        System.out.println("and Ten");
                        break;
                    case '2':
                        System.out.println("Twenty");
                        break;
                    case '3':
                        System.out.println("Thirty");
                        break;
                    case '4':
                        System.out.println("Forty");
                        break;
                    case '5':
                        System.out.println("Fifty");
                        break;
                    case '6':
                        System.out.println("Sixty");
                        break;
                    case '7':
                        System.out.println("Seventy");
                        break;
                    case '8':
                        System.out.println("Eighty");
                        break;
                    case '9':
                        System.out.println("Ninety");
                        break;
                }
            }
            else if (number % 100 != 0 && number % 10 != 0){
                switch (numberChar.charAt(0)) {
                    case '1':
                        System.out.print("One ");
                        break;
                    case '2':
                        System.out.print("Two ");
                        break;
                    case '3':
                        System.out.print("Three ");
                        break;
                    case '4':
                        System.out.print("Four ");
                        break;
                    case '5':
                        System.out.print("Five ");
                        break;
                    case '6':
                        System.out.print("Six ");
                        break;
                    case '7':
                        System.out.print("Seven ");
                        break;
                    case '8':
                        System.out.print("Eight ");
                        break;
                    case '9':
                        System.out.print("Nine ");
                        break;
                }
                System.out.print("hundred ");

                switch (numberChar.charAt(1)){
                    case '2':
                        System.out.print("Twenty");
                        break;
                    case '3':
                        System.out.print("Thirty");
                        break;
                    case '4':
                        System.out.print("Forty");
                        break;
                    case '5':
                        System.out.print("Fifty");
                        break;
                    case '6':
                        System.out.print("Sixty");
                        break;
                    case '7':
                        System.out.print("Seventy");
                        break;
                    case '8':
                        System.out.print("Eighty");
                        break;
                    case '9':
                        System.out.print("Ninety");
                        break;
                }
                if(numberChar.charAt(1) == '1'){
                    System.out.print("and ");
                    switch (numberChar.charAt(2)){
                        case '1':
                            System.out.println("Eleven");
                            break;
                        case '2':
                            System.out.println("Twelve");
                            break;
                        case '3':
                            System.out.println("Thirteen");
                            break;
                        case '4':
                            System.out.println("Forteen");
                            break;
                        case '5':
                            System.out.println("Fifteen");
                            break;
                        case '6':
                            System.out.println("Sixteen");
                            break;
                        case '7':
                            System.out.println("Seventeen");
                            break;
                        case '8':
                            System.out.println("Eighteen");
                            break;
                        case '9':
                            System.out.println("Nineteen");
                            break;
                    }
                }
                else {
                    switch (numberChar.charAt(2)){
                        case '1':
                            System.out.println(" one");
                            break;
                        case '2':
                            System.out.println(" two");
                            break;
                        case '3':
                            System.out.println(" three");
                            break;
                        case '4':
                            System.out.println(" four");
                            break;
                        case '5':
                            System.out.println(" five");
                            break;
                        case '6':
                            System.out.println(" six");
                            break;
                        case '7':
                            System.out.println(" seven");
                            break;
                        case '8':
                            System.out.println(" eight");
                            break;
                        case '9':
                            System.out.println(" nine");
                            break;
                    }
                }
            }
        }
        else {
            System.out.println("Không thể đọc");
        }
    }
}
