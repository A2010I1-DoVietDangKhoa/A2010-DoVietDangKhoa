package bai7_Abstract_Class_Va_Interface.bai_tap.TrienKhaiInterfaceResizeableChoCacLopHinhHoc;

public class TestCircle {
    public static void main(String[] args) {
        Circle circleTest = new Circle(10.0, "green", true);
        System.out.println(circleTest.getRadius());
        System.out.println(circleTest.getPerimeter());
        System.out.println(circleTest.getArea());
        System.out.println(circleTest.toString());
        circleTest.setRadius(45.0);
        circleTest.setColor("red");
        circleTest.setFilled(false);
        System.out.println(circleTest.getRadius());
        System.out.println(circleTest.getPerimeter());
        System.out.println(circleTest.getArea());
        System.out.println(circleTest.toString());
        System.out.println("Resize by: " + circleTest.resize(Math.random()*100 + 1) + "%");
        System.out.println(circleTest.getPerimeter());
        System.out.println(circleTest.getArea());
        System.out.println(circleTest.toString());
    }
}
