package bai7_Abstract_Class_va_Interface.bai_tap.TrienKhaiInterfaceResizeableChoCacLopHinhHoc;

public class TestSquare {
    public static void main(String[] args) {
        Square squareTest = new Square(10.0, "green", true);
        System.out.println(squareTest.getSide());
        System.out.println(squareTest.getPerimeter());
        System.out.println(squareTest.getArea());
        System.out.println(squareTest.toString());
        squareTest.setSide(30.0);
        squareTest.setColor("orange");
        squareTest.setFilled(false);
        System.out.println(squareTest.getSide());
        System.out.println(squareTest.getPerimeter());
        System.out.println(squareTest.getArea());
        System.out.println(squareTest.toString());
        System.out.println("Resize by: " + squareTest.resize(Math.random()*100 + 1) + "%");
        System.out.println(squareTest.getPerimeter());
        System.out.println(squareTest.getArea());
        System.out.println(squareTest.toString());
    }
}
