package bai6_Ke_thua.bai_tap.LopPoint2DVaLopPoint3D;

public class TestPoint2D {
    public static void main(String[] args) {
        Point2D point2d = new Point2D(2.5f, 3.14f);

        float[] array = point2d.getXY();
        for (float i : array){
            System.out.print(i + " ");
        }

        System.out.println(point2d.toString());

        point2d.setXY(4.125f, 5.782f);

        for (float i : array){
            System.out.print(i + " ");
        }

        System.out.println(point2d.toString());
    }
}
