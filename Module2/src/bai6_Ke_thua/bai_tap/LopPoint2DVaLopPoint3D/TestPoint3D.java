package bai6_Ke_thua.bai_tap.LopPoint2DVaLopPoint3D;

public class TestPoint3D {
    public static void main(String[] args) {
        Point3D point3d = new Point3D(3.14f, 5.62f, 9.73f);

        float[] array = point3d.getXYZ();
        for (float i : array){
            System.out.print(i + " ");
        }

        System.out.println(point3d.toString());

        point3d.setXYZ(1.0f, 2.0f, 3.0f);
        for (float i : array){
            System.out.print(i + " ");
        }

        System.out.println(point3d.toString());
    }
}
