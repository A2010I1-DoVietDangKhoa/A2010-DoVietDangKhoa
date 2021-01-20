package bai4_Lop_va_doi_tuong_trong_Java.bai_tap;

public class XayDungLopFan {
    private static final int SLOW = 1;
    private static final int MEDIUM = 2;
    private static final int FAST = 3;
    public static class Fan{
        private int speed = SLOW;
        private boolean on = false;
        private int radius = 5;
        private String color = "blue";

        public Fan(){

        }

        public String getSpeed() {
            if(this.speed == SLOW){
                return "SLOW";
            }
            else if(this.speed == MEDIUM){
                return "MEDIUM";
            }
            else {
                return "FAST";
            }
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        public boolean isOn() {
            return on;
        }

        public void setOn(boolean on) {
            this.on = on;
        }

        public int getRadius() {
            return radius;
        }

        public void setRadius(int radius) {
            this.radius = radius;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            if (this.on) {
                return "Fan {Speed: " + this.getSpeed()
                        + ", Color: " + this.getColor()
                        + ", Radius: " + this.getRadius()
                        + ", Status: ON}";
            } else {
                return "Fan {Color: " + this.getColor()
                        + ", Radius: " + this.getRadius()
                        + ", Status: OFF}";
            }
        }
    }

    public static void main(String[] args){
        Fan fan1 = new Fan();
        Fan fan2 = new Fan();

        fan1.setSpeed(FAST);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setOn(true);

        fan2.setSpeed(MEDIUM);
        fan2.setRadius(5);
        fan2.setColor("blue");
        fan2.setOn(false);

        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }
}
