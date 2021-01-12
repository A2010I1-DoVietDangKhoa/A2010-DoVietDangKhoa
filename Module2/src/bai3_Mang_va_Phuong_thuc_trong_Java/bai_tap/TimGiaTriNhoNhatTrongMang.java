package bai3_Mang_va_Phuong_thuc_trong_Java.bai_tap;

import java.util.Scanner;

public class TimGiaTriNhoNhatTrongMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input array length: ");
        int length = scanner.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            System.out.print("Input element " + (i+1) + ": ");
            array[i] = scanner.nextInt();
        }
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
        int min = array[0];
        for (int i = 1; i<array.length; i++){
            if(min > array[i]){
                min = array[i];
            }
        }
        System.out.print("The lowest value of this array is " + min);
    }
}
