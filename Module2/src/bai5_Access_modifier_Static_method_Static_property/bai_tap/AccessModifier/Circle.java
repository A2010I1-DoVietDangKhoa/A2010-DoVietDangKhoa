package bai5_Access_modifier_Static_method_Static_property.bai_tap.AccessModifier;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    Circle(){

    }

    Circle(double radius){
        this.radius = radius;
    }

    public double getRadiusPublic(){
        return this.radius;
    }

    public double getAreaPublic(){
        return Math.pow(radius, 2)*Math.PI;
    }

    private double getRadiusPrivate(){
        return this.radius;
    }

    private double getAreaPrivate(){
        return Math.pow(radius, 2)*Math.PI;
    }

    protected double getRadiusProtected(){
        return this.radius;
    }

    protected double getAreaProtected(){
        return Math.pow(radius, 2)*Math.PI;
    }

    double getRadiusDefault(){
        return this.radius;
    }

    double getAreaDefault(){
        return Math.pow(radius, 2)*Math.PI;
    }

    public static void main(String[] args) {
        Circle circle = new Circle(5);
        System.out.println(circle.getRadiusPrivate());
        System.out.println(circle.getAreaPrivate());
    }
}
