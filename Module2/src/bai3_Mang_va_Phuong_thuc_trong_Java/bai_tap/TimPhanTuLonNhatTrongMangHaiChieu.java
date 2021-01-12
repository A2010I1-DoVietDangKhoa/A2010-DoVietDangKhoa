package bai3_Mang_va_Phuong_thuc_trong_Java.bai_tap;

public class TimPhanTuLonNhatTrongMangHaiChieu {
    public static void main(String[] args) {
        int[][] array = {
                {0, 983, 787, 714, 1375, 967, 1087},
                {983, 0, 214, 1102, 1763, 1723, 1842},
                {787, 214, 0, 888, 1549, 1548, 1627},
                {714, 1102, 888, 0, 661, 781, 810},
                {1375, 1763, 1549, 661, 0, 1426, 1187},
                {967, 1723, 1548, 781, 1426, 0, 239},
                {1087, 1842, 1627, 810, 1187, 239, 0},
        };
        int max = array[0][0];
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j<array[i].length; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i< array.length; i++){
            for (int j = 0; j<array[i].length; j++){
                if (max < array[i][j]){
                    max = array[i][j];
                }
            }
        }
        System.out.println("The highest value of this array is: " + max);
    }
}
