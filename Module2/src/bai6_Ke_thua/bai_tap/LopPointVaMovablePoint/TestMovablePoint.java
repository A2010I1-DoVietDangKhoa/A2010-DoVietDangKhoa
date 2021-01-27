package bai6_Ke_thua.bai_tap.LopPointVaMovablePoint;

public class TestMovablePoint {
    public static void main(String[] args) {
        MovablePoint mvpoint = new MovablePoint(2.0f, 4.0f, 7.5f, 9.6f);
        System.out.println(mvpoint.toString());
        mvpoint.setXY(1.5f, 6.9f);
        mvpoint.setSpeed(2.4f, 8.1f);
        System.out.println(mvpoint.toString());
        mvpoint.move();
        System.out.println(mvpoint.toString());
    }
}
