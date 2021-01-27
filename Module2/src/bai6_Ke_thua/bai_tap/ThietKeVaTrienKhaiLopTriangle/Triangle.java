package bai6_Ke_thua.bai_tap.ThietKeVaTrienKhaiLopTriangle;

public class Triangle extends Shape{
    protected double side1 = 1.0;
    protected double side2 = 1.0;
    protected double side3 = 1.0;

    public Triangle(){

    }

    public Triangle(double side1, double side2, double side3, String color, boolean filled){
        super(color, filled);
        if(side1 + side2 > side3 && side1 + side3 > side2 && side2 + side3 > side1){
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        }
        else {
            System.out.println("Invalid sides' values, created a standard triangle with value 1.0 for all sides.");
//            this.side1 = 1.0;
//            this.side2 = 1.0;
//            this.side3 = 1.0;
        }
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double getArea(){
        double s = 0.5 * (this.side1 + this.side2 + this.side3);
        return Math.sqrt(s*(s-this.side1)*(s-this.side2)*(s-this.side3));
    }

    public double getPerimeter(){
        return this.side1 + this.side2 + this.side3;
    }

    @Override
    public String toString() {
        if(this.isFilled()) {
            return "Side 1: " + this.side1 + " Side 2: " + this.side2 + " Side 3: " + this.side3 + " Color: "
                    + this.getColor() + " Filled: Yes";
        }
        else {
            return "Side 1: " + this.side1 + " Side 2: " + this.side2 + " Side 3: " + this.side3 + " Color: "
                    + this.getColor() + " Filled: No";
        }
    }
}
