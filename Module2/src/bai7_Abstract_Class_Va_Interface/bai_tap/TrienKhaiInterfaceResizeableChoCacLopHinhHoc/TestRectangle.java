package bai7_Abstract_Class_Va_Interface.bai_tap.TrienKhaiInterfaceResizeableChoCacLopHinhHoc;

public class TestRectangle {
    public static void main(String[] args) {
        Rectangle rectangleTest = new Rectangle(10.0, 14.0, "green", false);
        System.out.println(rectangleTest.getWidth());
        System.out.println(rectangleTest.getLength());
        System.out.println(rectangleTest.getPerimeter());
        System.out.println(rectangleTest.getArea());
        System.out.println(rectangleTest.toString());
        rectangleTest.setWidth(30.0);
        rectangleTest.setLength(10.0);
        rectangleTest.setColor("pink");
        rectangleTest.setFilled(true);
        System.out.println(rectangleTest.getWidth());
        System.out.println(rectangleTest.getLength());
        System.out.println(rectangleTest.getPerimeter());
        System.out.println(rectangleTest.getArea());
        System.out.println(rectangleTest.toString());
        System.out.println("Resize by: " + rectangleTest.resize(Math.random()*100 + 1) + "%");
        System.out.println(rectangleTest.getPerimeter());
        System.out.println(rectangleTest.getArea());
        System.out.println(rectangleTest.toString());
    }
}
