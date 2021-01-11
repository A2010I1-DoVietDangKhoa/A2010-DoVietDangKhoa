package bai3_Mang_va_Phuong_thuc_trong_Java.thuc_hanh;

public class TimGiaTriTrongMang {
    public static void main(String[] args) {
        System.out.println("The application searches for values in an array");

        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter a name’s student: ");
        String input_name = scanner.nextLine();

        boolean isExist = false;
        for (int i = 0; i < students.length; i++) {
            if (students[i].equals(input_name)) {
                System.out.println("Position of student " + input_name + " in the list is: " + (i + 1));
                isExist = true;
                break;
            }
        }
        if (!isExist)
            System.out.println("Not found " + input_name + " in the list.");
    }
}
