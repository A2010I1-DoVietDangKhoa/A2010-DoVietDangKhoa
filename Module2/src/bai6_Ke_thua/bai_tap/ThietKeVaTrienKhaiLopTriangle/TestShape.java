package bai6_Ke_thua.bai_tap.ThietKeVaTrienKhaiLopTriangle;

public class TestShape {
    public static void main(String[] args) {
        Shape shape = new Shape("red", true);
        System.out.println(shape.getColor());
        System.out.println(shape.isFilled());
        System.out.println(shape.toString());

        shape.setFilled(false);
        shape.setColor("yellow");
        System.out.println(shape.getColor());
        System.out.println(shape.isFilled());
        System.out.println(shape.toString());
    }
}
