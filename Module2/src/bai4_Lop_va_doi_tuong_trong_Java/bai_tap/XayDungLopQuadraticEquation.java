package bai4_Lop_va_doi_tuong_trong_Java.bai_tap;

import java.util.Scanner;

public class XayDungLopQuadraticEquation {
    public static class QuadraticEquation{
        private double a, b, c;

        public QuadraticEquation(){

        }

        public QuadraticEquation(double a, double b, double c){
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public double getA() {
            return a;
        }

        public double getB() {
            return b;
        }

        public double getC() {
            return c;
        }

        public void setA(double a) {
            this.a = a;
        }

        public void setB(double b) {
            this.b = b;
        }

        public void setC(double c) {
            this.c = c;
        }

        public double getDiscriminant(){
            double delta = Math.pow(b, 2) - 4*this.a*this.c;
            return delta;
        }

        public double getRoot1(double delta){
            double root1 = (-this.b + Math.sqrt(delta))/(2*this.a);
            return root1;
        }
        public double getRoot2(double delta){
            double root2 = (-this.b - Math.sqrt(delta))/(2*this.a);
            return root2;
        }
    }

    public static void main(String[] args) {
        QuadraticEquation equation1 = new QuadraticEquation();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input a: ");
        equation1.setA(scanner.nextDouble());
        System.out.print("Input b: ");
        equation1.setB(scanner.nextDouble());
        System.out.print("Input c: ");
        equation1.setC(scanner.nextDouble());
        System.out.print("Your equation: " + equation1.getA() + "x^2 ");

        if(equation1.getB() > 0){
            System.out.print("+ " + equation1.getB() + "x ");
        }
        else {
            System.out.print(equation1.getB() + "x ");
        }
        if(equation1.getC() > 0){
            System.out.print("+ " + equation1.getC());
        }
        else {
            System.out.print(equation1.getC());
        }
        System.out.println(" = 0");

        double delta = equation1.getDiscriminant();
        System.out.println("Delta = " + delta);
        if (delta < 0){
            System.out.println("The equation has no roots.");
        }
        else if (delta == 0){
            System.out.println("The equation has one root: " + equation1.getRoot1(delta));
        }
        else {
            System.out.println("The equation has two roots: x1 = " + equation1.getRoot1(delta) + " and x2 = " + equation1.getRoot2(delta));
        }
    }
}
