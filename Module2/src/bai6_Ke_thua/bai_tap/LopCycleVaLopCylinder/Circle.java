package bai6_Ke_thua.bai_tap.LopCycleVaLopCylinder;

public class Circle {
    private double radius;
    private String color;

    Circle(){

    }

    Circle(double radius, String color){
        this.radius = radius;
        this.color = color;
    }

    protected void setRadius(double radius){
        this.radius = radius;
    }

    protected void setColor(String color){
        this.color = color;
    }

    protected double getRadius(){
        return this.radius;
    }

    protected String getColor(){
        return this.color;
    }

    protected double getArea(){
        return Math.pow(this.radius, 2)*Math.PI;
    }

    protected double getPerimeter(){
        return 2*this.radius*Math.PI;
    }

    @Override
    public String toString() {
        return "Radius: " + this.radius +
                ", Color: " + this.color;
    }
}
