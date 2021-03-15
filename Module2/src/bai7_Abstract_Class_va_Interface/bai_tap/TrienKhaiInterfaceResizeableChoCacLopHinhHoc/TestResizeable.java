package bai7_Abstract_Class_va_Interface.bai_tap.TrienKhaiInterfaceResizeableChoCacLopHinhHoc;

public class TestResizeable {
    public static void main(String[] args) {
        Shape circle = new Circle(5.0, "red", true);
        Shape rectangle = new Rectangle(7.0, 8.0, "cyan", false);
        Shape square = new Square(6.0, "lavender", true);

        System.out.println(circle.toString());
        System.out.println(rectangle.toString());
        System.out.println(square.toString());

        Shape[] shapes = new Shape[3];
        shapes[0] = circle;
        shapes[1] = rectangle;
        shapes[2] = square;

        for (int i = 0; i < shapes.length; i++){
            System.out.println("Before change: " + shapes[i].toString());
            System.out.println("Area: " + shapes[i].getArea());
            if(shapes[i] instanceof Circle){
                Circle circle2 = (Circle) shapes[i];
                System.out.println("Resize by " + circle2.resize(Math.random()*99 + 1) + "%");
                System.out.println("After change: " + circle2.toString());
                System.out.println("Area: " + circle2.getArea());
            }
            else if(shapes[i] instanceof Rectangle){
                Rectangle rectangle2 = (Rectangle) shapes[i];
                System.out.println("Resize by " + rectangle2.resize(Math.random()*99 + 1) + "%");
                System.out.println("After change: " + rectangle2.toString());
                System.out.println("Area: " + rectangle2.getArea());
            }
            else if (shapes[i] instanceof Square){
                Square square2 = (Square) shapes[i];
                System.out.println("Resize by " + square2.resize(Math.random()*99 + 1) + "%");
                System.out.println("After change: " + square2.toString());
                System.out.println("Area: " + square2.getArea());
            }
        }
    }
}
