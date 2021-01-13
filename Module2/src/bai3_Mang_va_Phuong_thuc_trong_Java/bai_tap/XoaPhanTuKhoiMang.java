package bai3_Mang_va_Phuong_thuc_trong_Java.bai_tap;

import java.util.Scanner;
import java.util.Arrays;

public class XoaPhanTuKhoiMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.print("\nInput the value you want to remove: ") ;
        int target = scanner.nextInt();
        boolean check = false;
        int position = 0;
        for (int i = 0; i < array.length; i++) {
            if (target == array[i]) {
                check = true;
                position = i;
                break;
            }
        }
        int[] array2 = new int[array.length - 1];
        if (check) {
            System.out.println("Found value " + target + " at position " + (position + 1));
            for(int i = 0, j = 0; i < array.length; i++){
                if(target != array[i]){
                    array2[j] = array[i];
                    j++;
                }
            }
            System.out.println("Array after change:");
            for (int i = 0; i< array2.length; i++){
                System.out.print(array2[i] + " ");
            }

        } else {
            System.out.println("The value doesn't exist in the array");
        }
        }
    }

