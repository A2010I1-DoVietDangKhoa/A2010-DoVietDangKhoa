package bai6_Ke_thua.bai_tap.ThietKeVaTrienKhaiLopTriangle;

public class TestTriangle {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(2.0, 3.0, 4.0, "blue", false);
        System.out.println(triangle.toString());
        System.out.println(triangle.getPerimeter());
        System.out.println(triangle.getArea());
        triangle.setColor("black");
        triangle.setFilled(true);
        triangle.setSide1(5.0);
        triangle.setSide2(4.0);
        triangle.setSide3(6.0);
        System.out.println(triangle.toString());
        System.out.println(triangle.getPerimeter());
        System.out.println(triangle.getArea());
    }
}
