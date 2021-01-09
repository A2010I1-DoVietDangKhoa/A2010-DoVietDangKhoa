package bai1_Introduction_to_Java.bai_tap;

import java.util.Scanner;

public class UngDungChuyenDoiTienTe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hãy nhập số tiền muốn chuyển đổi: ");
        int usd = scanner.nextInt();

        int vnd = usd * 23000;
        System.out.println("Số tiền nhập vào: " + usd + " USD");
        System.out.println("Số tiền sau chuyển đổi: " + vnd + " VND");
    }
}
