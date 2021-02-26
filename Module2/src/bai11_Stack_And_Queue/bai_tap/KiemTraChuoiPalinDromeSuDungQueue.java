package bai11_Stack_And_Queue.bai_tap;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class KiemTraChuoiPalinDromeSuDungQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Character> characterStack = new Stack<>();
        Queue<Character> characterQueue = new LinkedList<>();
        System.out.println("Input a string: ");
        String inputText = scanner.nextLine();
        String processedText = inputText.trim().toLowerCase();
        for (int i = 0; i < processedText.length(); i++) {
            characterStack.push(processedText.charAt(i));
            characterQueue.offer(processedText.charAt(i));
        }
        System.out.println("Inputted string: " + inputText);
        boolean check = true;
        for (int i = 0; i <= characterStack.size(); i++) {
            if(characterStack.pop() != characterQueue.poll()){
                check = false;
                break;
            }
        }
        if(check){
            System.out.println("The input is a palindrome string.");
        }
        else {
            System.out.println("The input is not a palindrome string.");
        }
    }
}
