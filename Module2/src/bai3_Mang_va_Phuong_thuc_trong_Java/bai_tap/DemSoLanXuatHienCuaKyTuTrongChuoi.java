package bai3_Mang_va_Phuong_thuc_trong_Java.bai_tap;

import java.util.Scanner;

public class DemSoLanXuatHienCuaKyTuTrongChuoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a string: ");
        String txt = scanner.nextLine();
        System.out.println("Input the character you want to inspect: ");
        char character = scanner.next().charAt(0);
        int count = 0;
        for(int i = 0; i < txt.length(); i++){
            if(txt.charAt(i) == character){
                count++;
            }
        }
        System.out.println("In the \"" + txt + "\" string, character \'" + character +"\' appears " + count + " time(s)" );
    }
}
