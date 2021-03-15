package bai7_Abstract_Class_va_Interface.bai_tap.TrienKhaiInterfaceResizeableChoCacLopHinhHoc;

import bai7_Abstract_Class_va_Interface.bai_tap.TrienKhaiInterfaceColorableChoCacLopHinhHoc.Colorable;


public class Square extends Rectangle implements Resizeable, Colorable {
    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    @Override
    public double getArea() {
        return this.getSide() * this.getSide();
    }

    @Override
    public void setWidth(double width) {
        setSide(width);
    }

    @Override
    public void setLength(double length) {
        setSide(length);
    }

    @Override
    public String toString() {
        return "A Square with side = "
                + getSide()
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public double resize(double percent) {
        double side = this.getSide();
        side = side + (side*percent)/100;
        this.setSide(side);
        return percent;
    }

    @Override
    public String howToColor() {
        return "Color all 4 sides.";
    }

}
