package bai3_Mang_va_Phuong_thuc_trong_Java.bai_tap;

public class GopMang {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {6, 7, 8, 9};
        int[] array3 = new int[array1.length + array2.length];
        for(int i : array1){
            System.out.print(i + " ");
        }
        System.out.println();
        for(int j : array2){
            System.out.print(j + " ");
        }
        for (int i = 0; i < array1.length; i++) {
            array3[i] = array1[i];
        }
        for (int i = array1.length, j=0; i<array1.length + array2.length; i++ ){
            array3[i] = array2[j];
            j++;
        }
        System.out.println();
        for(int i : array3){
            System.out.print(i + " ");
        }
    }
}
