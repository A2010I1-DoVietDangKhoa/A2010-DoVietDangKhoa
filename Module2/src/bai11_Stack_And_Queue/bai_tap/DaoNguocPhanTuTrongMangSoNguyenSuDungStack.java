package bai11_Stack_And_Queue.bai_tap;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Stack;

public class DaoNguocPhanTuTrongMangSoNguyenSuDungStack {
    public static void main(String[] args) {
        Stack<Integer> nStack = new Stack<>();
        Stack<Character> wStack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println("What do you want to do?: " +
                "\n1. Reverse an Integer array." +
                "\n2. Reverse a string.");
        choice = scanner.nextInt();
        switch (choice){
            case 1:
                int num;
                System.out.println("Input array length: ");
                num = scanner.nextInt();
                int[] nArray = new int[num];
                for (int i = 1; i <= nArray.length; i++) {
                    System.out.println("Input array[" + (i - 1) + "]");
                    nArray[i - 1] = scanner.nextInt();
                }
                System.out.println("Array before reverse: ");
                for (int i : nArray) {
                    System.out.print(i + " ");
                }
                System.out.println();
                for (int i = 0; i < nArray.length; i++) {
                    nStack.push(nArray[i]);
                }
                for (int i = 0; i < nArray.length; i++) {
                    nArray[i] = nStack.pop();
                }
                System.out.println("Array after reverse: ");
                for (int i : nArray) {
                    System.out.print(i + " ");
                }
                break;

            case 2:
                String mWord = "";
                System.out.println("Input a string: ");
                scanner.nextLine();
                mWord = scanner.nextLine();
                for (int i = 0; i < mWord.length(); i++) {
                    if(mWord.charAt(i) == ' '){
                        wStack.push(' ');
                    }
                    else {
                        wStack.push(mWord.charAt(i));
                    }
                }
                String output = "";
                for (int i = 0; i < mWord.length(); i++){
                    output += wStack.pop();
                }
                System.out.println("String before reverse: " + mWord);
                System.out.println("String after reverser: " + output);
                break;

            default:
                System.out.println("Invalid choice.");
        }

    }
}
