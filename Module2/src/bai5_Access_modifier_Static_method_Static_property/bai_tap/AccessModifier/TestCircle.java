package bai5_Access_modifier_Static_method_Static_property.bai_tap.AccessModifier;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle1 = new Circle(2);
        Circle circle2 = new Circle(3);
        Circle circle3 = new Circle(4);
        Circle circle4 = new Circle(5);
        System.out.println(circle1.getRadiusPublic());
        System.out.println(circle1.getAreaPublic());
        System.out.println(circle2.getRadiusProtected());
        System.out.println(circle2.getAreaProtected());
        System.out.println(circle3.getRadiusDefault());
        System.out.println(circle3.getAreaDefault());
//        System.out.println(circle4.getRadiusPrivate());
//        System.out.println(circle4.getAreaPrivate());
    }
}
