package bai6_Ke_thua.bai_tap.LopCycleVaLopCylinder;

public class TestCylinder {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder.toString());

        cylinder = new Cylinder(10, "red", 30);
        System.out.println(cylinder.toString());

        System.out.println(cylinder.getLength());
        System.out.println(cylinder.getColor());
        System.out.println(cylinder.getRadius());
        System.out.println(cylinder.getPerimeter());
        System.out.println(cylinder.getVolume());
    }
}
