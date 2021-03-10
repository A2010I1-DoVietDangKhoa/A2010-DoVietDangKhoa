package bai15_Xu_ly_ngoai_le_va_debug.bai_tap.SuDungLopIllegalTriangleException;

import java.util.Scanner;

public class TestIllegalTriangleException {
    public static void illegalTriangle(int a, int b, int c) throws IllegalTriangleException{
        if(a <= 0 || b <= 0 || c <=0 || a + b <= c || a + c <= b || b + c <= a){
                throw new IllegalTriangleException();
        }
        else {
            System.out.println("Triangle has 3 sides: " +
                    "\nFirst side: " + a +
                    "\nSecond side: " + b +
                    "\nThird side: " + c);
        }
        //return true;
    }


    public static void main(String[] args) throws IllegalTriangleException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input value for the first side: ");
        int side1 = scanner.nextInt();
        System.out.println("Input value for the second side: ");
        int side2 = scanner.nextInt();
        System.out.println("Input value for the third side: ");
        int side3 = scanner.nextInt();

        illegalTriangle(side1, side2, side3);
    }
}
