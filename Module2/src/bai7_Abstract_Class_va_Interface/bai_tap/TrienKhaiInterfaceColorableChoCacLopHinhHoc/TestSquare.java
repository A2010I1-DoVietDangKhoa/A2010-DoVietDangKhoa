package bai7_Abstract_Class_va_Interface.bai_tap.TrienKhaiInterfaceColorableChoCacLopHinhHoc;

import bai7_Abstract_Class_va_Interface.bai_tap.TrienKhaiInterfaceResizeableChoCacLopHinhHoc.Square;

public class TestSquare {
    public static void main(String[] args) {
        Square squareTest = new Square(10.0, "green", true);
        System.out.println(squareTest.getSide());
        System.out.println(squareTest.getArea());
        System.out.println(squareTest.getPerimeter());
        System.out.println(squareTest.toString());
        System.out.println(squareTest.howToColor());
        squareTest.setSide(20.0);
        squareTest.setColor("orange");
        squareTest.setFilled(false);
        System.out.println(squareTest.getSide());
        System.out.println(squareTest.getArea());
        System.out.println(squareTest.getPerimeter());
        System.out.println(squareTest.toString());
        System.out.println(squareTest.howToColor());
    }
}
