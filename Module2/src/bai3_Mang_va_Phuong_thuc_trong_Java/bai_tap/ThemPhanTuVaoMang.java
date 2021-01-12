package bai3_Mang_va_Phuong_thuc_trong_Java.bai_tap;

import java.util.Scanner;

public class ThemPhanTuVaoMang {
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
        System.out.print("\nInput the value you want to add: ");
        int value = scanner.nextInt();
        System.out.print("Choose the index of the new value: ");
        int position = scanner.nextInt();
        boolean check = false;
        if(position >= 0 && position <= array.length - 1){
            check = true;
        }

        int[] array2 = new int[array.length + 1];
        if(check){
            for (int i = 0; i < array2.length; i++){
                if(i < position){
                    array2[i] = array[i];
                }
                else if (i == position){
                    array2[i] = value;
                }
                else {
                    array2[i] = array[i-1];
                }
            }
        }
        else {
            System.out.println("Invalid index.");
        }
        System.out.println("Array after change:");
        for (int i = 0; i< array2.length; i++){
            System.out.print(array2[i] + " ");
        }

    }
}
