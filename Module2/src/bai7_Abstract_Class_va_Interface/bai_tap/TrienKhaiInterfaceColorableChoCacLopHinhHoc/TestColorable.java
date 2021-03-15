package bai7_Abstract_Class_va_Interface.bai_tap.TrienKhaiInterfaceColorableChoCacLopHinhHoc;

import bai7_Abstract_Class_va_Interface.bai_tap.TrienKhaiInterfaceResizeableChoCacLopHinhHoc.*;


public class TestColorable {
    public static void main(String[] args) {
        Shape circle = new Circle(15.0, "violet", false);
        Shape rectangle = new Rectangle(6.0, 9.0, "white", true);
        Shape square = new Square(2.0, "lavender", true);

        System.out.println(circle.toString());
        System.out.println(rectangle.toString());
        System.out.println(square.toString());

        Shape[] shapes = new Shape[3];
        shapes[0] = circle;
        shapes[1] = rectangle;
        shapes[2] = square;

        for (int i = 0; i < shapes.length; i++){
            shapes[i].getArea();
            if (shapes[i] instanceof Square){
//                Colorable color = (Square) shapes[i];
//                System.out.println(color.howToColor());
                Square square2 = (Square) shapes[i];
                System.out.println(square2.howToColor());
            }
        }
    }
}
