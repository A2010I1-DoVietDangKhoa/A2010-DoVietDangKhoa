package Final_Exam.Controller;

import java.util.Scanner;

public class Menu {
    public static void displayMainMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------------------Patients Management Program--------------------");
        System.out.println("What you want to do?: \n" +
                "1. Add new patient.\n" +
                "2. Delete patient.\n" +
                "3. Show patient list.\n" +
                "4. Exit.\n" +
                "Please choose: ");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                PatientController.addPatient();
                break;
            case 2:
                PatientController.deletePatient();
                break;
            case 3:
                PatientController.showList();
                break;
            case 4:
                System.exit(0);
            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void main(String[] args) {
        PatientController.readPatient();
        while (true){
            displayMainMenu();
        }
    }
}
