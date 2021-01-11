package bai2_Vong_lap_trong_Java.bai_tap;

import java.util.Scanner;

public class HienThiCacLoaiHinh {
    public static void main(String[] args) {
        int choice = -1;
        Scanner scanner = new Scanner(System.in);

        while(choice != 0){
            System.out.println("1. Print a rectangle.");
            System.out.println("2. Print a triangle.");
            System.out.println("3. Print an isosceles triangle.");
            System.out.println("4. Exit.");
            System.out.print("Your selection: ");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    for(int i = 0; i<7; i++){
                        System.out.println("*********************************");
                    }
                    break;
                case 2:
                    int triangleChoice = -1;
                    System.out.println("1. Top left corner.");
                    System.out.println("2. Top right corner.");
                    System.out.println("3. Bottom left corner.");
                    System.out.println("4. Bottom right corner.");
                    System.out.println("Your selection: ");
                    triangleChoice = scanner.nextInt();
                    switch (triangleChoice){
                        case 1:
                            for(int i = 10; i>=0; i--){
                                for (int j = 0; j<=i; j++){
                                    System.out.print("*");
                                }
                                System.out.print("\n");
                            }
                            break;
                        case 2:
                            int star = 10;
                            int space = 0;
                            while (star>=0 && space <= 10){
                                for(int i = 0; i<=space; i++){
                                    System.out.print(" ");
                                }
                                for(int j = 0; j<=star; j++){
                                    System.out.print("*");
                                }
                                System.out.print("\n");
                                star--;
                                space++;
                            }
                            break;
                        case 3:
                            for(int i = 1; i<=10; i++){
                                for (int j = 1; j<=i; j++){
                                    System.out.print("*");
                                }
                                System.out.print("\n");
                            }
                            break;
                        case 4:
                            int space2 = 10;
                            int star2 = 0;
                            while (space2>=0 && star2 <= 10){
                                for(int i = 0; i<=space2; i++){
                                    System.out.print(" ");
                                }
                                for(int j = 0; j<=star2; j++){
                                    System.out.print("*");
                                }
                                System.out.print("\n");
                                star2++;
                                space2--;
                            }
                            break;
                    }
                    break;
                case 3:
                    System.out.println("        *        ");
                    System.out.println("      * * *      ");
                    System.out.println("    * * * * *    ");
                    System.out.println("  * * * * * * *  ");
                    System.out.println("* * * * * * * * *");
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
            }
        }
    }
}
