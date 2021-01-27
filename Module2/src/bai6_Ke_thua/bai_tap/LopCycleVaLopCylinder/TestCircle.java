package bai6_Ke_thua.bai_tap.LopCycleVaLopCylinder;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle.toString());

        circle = new Circle(10, "white");
        System.out.println(circle.toString());
        System.out.println(circle.getRadius());
        System.out.println(circle.getColor());
        System.out.println(circle.getArea());
    }
}
