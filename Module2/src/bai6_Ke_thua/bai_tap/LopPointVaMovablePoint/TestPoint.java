package bai6_Ke_thua.bai_tap.LopPointVaMovablePoint;

public class TestPoint {
    public static void main(String[] args) {
        Point point = new Point();
        point.setX(4.0f);
        point.setY(5.0f);

        float[] array = point.getXY();
        for(float i : array){
            System.out.print(i + " ");
        }
        System.out.println(point.toString());

        point.setXY(66.0f, 69.0f);
        System.out.println(point.toString());
    }
}
