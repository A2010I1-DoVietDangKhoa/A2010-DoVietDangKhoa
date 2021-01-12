package bai3_Mang_va_Phuong_thuc_trong_Java.bai_tap;

import java.util.Scanner;

public class TinhTongCacSoOMotCotXacDinh {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number of rows: ");
        int row = scanner.nextInt();
        System.out.println("Input number of columns: ");
        int column = scanner.nextInt();
        int[][] array = new int[row][column];
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
        System.out.println("Input the column you want to get sum of: ");
        int position = scanner.nextInt();
        if(position >= 0 && position < column){
            for (int i = 0; i < array.length; i++){
                for (int j = 0; j<array[i].length; j++){
                    if(j == position){
                        total += array[i][j];
                    }
                }
            }
            System.out.println("Result: " + total);
        }
        else {
            System.out.println("Invalid position.");
        }
    }
}
