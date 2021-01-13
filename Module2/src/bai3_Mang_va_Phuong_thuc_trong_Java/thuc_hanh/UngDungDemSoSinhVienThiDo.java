package bai3_Mang_va_Phuong_thuc_trong_Java.thuc_hanh;

public class UngDungDemSoSinhVienThiDo {
    public static void main(String[] args) {
        System.out.println("The Application to count the number of students pass.");

        int size;
        int[] array;
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        do {
            System.out.print("Enter a size: ");
            size = scanner.nextInt();
            if (size > 30)
                System.out.println("Size does not exceed 30");
        } while (size > 30);

        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Enter a mark for student " + (i + 1) + ": ");
            int mark = scanner.nextInt();
            if(mark >= 0 && mark <= 10){
                array[i] = mark;
            }
            else {
                System.out.println("Mark only has value from 0 to 10.");
                continue;
            }
            i++;
        }

        int count = 0;
        System.out.print("List of mark: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
            if (array[j] >= 5 && array[j] <= 10)
                count++;
        }
        System.out.print("\nThe number of students passing the exam is " + count);
    }
}
