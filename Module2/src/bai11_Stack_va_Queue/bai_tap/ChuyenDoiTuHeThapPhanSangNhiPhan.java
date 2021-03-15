package bai11_Stack_va_Queue.bai_tap;

import java.util.Scanner;
import java.util.Stack;

public class ChuyenDoiTuHeThapPhanSangNhiPhan {
    public static void main(String[] args) {
        Stack<Integer> nStack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the number you want to convert: ");
        int num = scanner.nextInt();
        while (num / 2 >= 1) {
            int bit = num % 2;
            nStack.push(bit);
            num /= 2;
        }
        nStack.push(1);
        int[] result = new int[nStack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = nStack.pop();
        }
        for (int i : result) {
            System.out.print(i);
        }
    }
}
