package bai6_Ke_thua.bai_tap.LopCycleVaLopCylinder;

public class Cylinder extends Circle {
    private double length;

    Cylinder(){

    }

    Cylinder(double radius, String color, double length){
        super(radius, color);
        this.length = length;
    }

    protected void setLength(double length){
        this.length = length;
    }

    protected double getLength(){
        return this.length;
    }

    protected double getVolume(){
        double area = super.getArea();
        return area*this.length;
    }

    @Override
    public String toString() {
        return "Radius: " + getRadius() +
                ", Color: " + getColor() +
                ", Length: " + this.length;
    }
}
