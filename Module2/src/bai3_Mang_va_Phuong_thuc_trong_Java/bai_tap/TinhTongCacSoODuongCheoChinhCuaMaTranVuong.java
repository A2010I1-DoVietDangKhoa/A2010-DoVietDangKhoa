package bai3_Mang_va_Phuong_thuc_trong_Java.bai_tap;

import java.util.Scanner;

public class TinhTongCacSoODuongCheoChinhCuaMaTranVuong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number of rows and columns: ");
        int size = scanner.nextInt();
        int[][] array = new int[size][size];
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j<array[i].length; j++){
                System.out.print("Input value of element [" + i + "][" + j + "]: ");
                array[i][j] = scanner.nextInt();
            }
            System.out.println();
        }
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j<array[i].length; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        int total = 0;
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j<array[i].length; j++){
                if(i == j){
                    total += array[i][j];
                }
            }
        }
        System.out.println("Result: " + total);
    }
}
