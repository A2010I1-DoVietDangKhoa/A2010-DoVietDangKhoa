package bai11_Stack_And_Queue.bai_tap;

import java.util.Scanner;
import java.util.Stack;

public class KiemTraDauNgoacTrongBieuThucSuDungStack {
    public static void main(String[] args) {
        Stack<Character> bStack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input: ");
        String expression = scanner.nextLine();
        boolean check = false;
        for(int i = 0; i < expression.length(); i++){
            char sym = expression.charAt(i);
            if(sym == '('){
                bStack.push(sym);
            }
            else if(sym == ')'){
                if(bStack.empty()){
                    check = false;
                    break;
                }
                else {
                    char left = bStack.pop();
                    if (sym != left){
                        check = true;
                    }
                    else {
                        check = false;
                        break;
                    }
                }
            }
        }
        if(bStack.empty()){
            check = true;
        }
        else {
            check = false;
        }
        if(check){
            System.out.println("Correct");
        }
        else {
            System.out.println("Wrong");
        }
    }
}
