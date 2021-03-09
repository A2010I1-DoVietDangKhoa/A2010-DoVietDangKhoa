package bai14_Thuat_toan_sap_xep.bai_tap.CaiDatThuatToanSapXepChen;

import java.util.Scanner;

public class InsertionSort {
    public static void insertionSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i-1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = key;
        }
    }

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

        System.out.println("Array before sorting: ");
        for (int i : arrayInt){
            System.out.print(i + " ");
        }

        insertionSort(arrayInt);

        System.out.println("Array after sorting: ");
        for (int i : arrayInt){
            System.out.print(i + " ");
        }
    }
}
