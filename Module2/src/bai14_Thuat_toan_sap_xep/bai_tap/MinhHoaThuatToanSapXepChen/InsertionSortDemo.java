package bai14_Thuat_toan_sap_xep.bai_tap.MinhHoaThuatToanSapXepChen;

import java.util.Scanner;

public class InsertionSortDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = 0;
        System.out.println("Input array's length: ");
        length = scanner.nextInt();
        int[] arrayInt = new int[length];
        for (int i = 0; i < arrayInt.length; i++) {
            System.out.println("Input element " + (i + 1) + ": ");
            arrayInt[i] = scanner.nextInt();
        }

        for (int i = 1; i < arrayInt.length; i++) {
            int key = arrayInt[i];
            int j = i-1;
            while (j >= 0 && arrayInt[j] > key) {
                arrayInt[j + 1] = arrayInt[j];
                j--;
            }


            arrayInt[j + 1] = key;
        }

        for (int i : arrayInt){
            System.out.print(i + " ");
        }
    }
}
