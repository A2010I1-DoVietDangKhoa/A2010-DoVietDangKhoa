package Final_Exam.Controller;

import java.util.*;

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
//        PatientController.readPatient();
//        while (true){
//            displayMainMenu();
//        }
        Date date = new Date();
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        double totalDayBeforeEnd = 1.0;
        calendar1.set(Calendar.YEAR, 2021);
        calendar1.set(Calendar.MONTH, 6);
        calendar1.set(Calendar.DAY_OF_MONTH, 1);
        calendar2.set(Calendar.YEAR, 2021);
        calendar2.set(Calendar.MONTH, 6);
        calendar2.set(Calendar.DAY_OF_MONTH, 10);
        System.out.println(calendar1.getTime());
        System.out.println(calendar2.getTime());
//        do {
//            totalDayBeforeEnd++;
//            calendar1.add(Calendar.DATE, 1);
//            System.out.println(calendar1.getTime());
//            System.out.println(totalDayBeforeEnd);
//        }
        while (calendar1.get(Calendar.DAY_OF_MONTH) != calendar2.get(Calendar.DAY_OF_MONTH)
            || calendar1.get(Calendar.MONTH) != calendar2.get(Calendar.MONTH)
                || calendar1.get(Calendar.YEAR) != calendar2.get(Calendar.YEAR)){
            totalDayBeforeEnd++;
            calendar1.add(Calendar.DATE, 1);
            System.out.println(totalDayBeforeEnd);
        }
        double percentage = Math.round((61.0/60.0) * 100.0);
        System.out.println(percentage);
        double totalHour = (5.0/7.0) * 40;
        System.out.println(totalHour);
//        calendar.setTime(date);
//        System.out.println(date);
//        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
//        calendar.add(Calendar.DATE, 1);
//        date = calendar.getTime();
//        System.out.println(date);
//        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
//        calendar.set(Calendar.HOUR_OF_DAY, 8);
//        calendar.set(Calendar.MINUTE, 0);
//        calendar.set(Calendar.SECOND, 0);
//        calendar.set(Calendar.MILLISECOND, 0);
//        date = calendar.getTime();
//        System.out.println(date);
//        calendar.set(Calendar.HOUR_OF_DAY, 17);
//        calendar.set(Calendar.MINUTE, 0);
//        calendar.set(Calendar.SECOND, 0);
//        calendar.set(Calendar.MILLISECOND, 0);
//        date = calendar.getTime();
//        System.out.println(date);
//        calendar.add(Calendar.DATE, -5);
//        date = calendar.getTime();
//        System.out.println(date);
//        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
//        calendar.add(Calendar.DATE, 6);
//        date = calendar.getTime();
//        System.out.println(date);
//        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
//        calendar.add(Calendar.DATE, 1);
//        date = calendar.getTime();
//        System.out.println(date);
//        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
//        calendar.add(Calendar.DATE, -3);
//        date = calendar.getTime();
//        System.out.println(date);
//        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
//        List<Date> dateList = new ArrayList<>();
//        dateList.add(date);
//        if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
//            while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY){
//                Date newDate;
//                calendar.add(Calendar.DATE, 1);
//                newDate = calendar.getTime();
//                dateList.add(newDate);
//            }
//        }
//        else if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
//            while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY){
//                Date newDate;
//                calendar.add(Calendar.DATE, -1);
//                newDate = calendar.getTime();
//                dateList.add(newDate);
//            }
//        }
//        else {
//            while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY){
//                Date newDate;
//                calendar.add(Calendar.DATE, 1);
//                newDate = calendar.getTime();
//                dateList.add(newDate);
//            }
//            calendar.setTime(date);
//            while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY){
//                Date newDate;
//                calendar.add(Calendar.DATE, -1);
//                newDate = calendar.getTime();
//                dateList.add(newDate);
//            }
//        }
//        for (Date date1 : dateList){
//            System.out.println(date1);
//        }
//        System.out.println(date);
//        calendar1.set(Calendar.YEAR, 2021);
//        calendar1.set(Calendar.MONTH, 6);
//        calendar1.set(Calendar.DAY_OF_MONTH, 1);
//        System.out.println(calendar1.get(Calendar.DAY_OF_MONTH));
//        System.out.println(calendar1.get(Calendar.MONTH) + 1);
//        System.out.println(calendar1.get(Calendar.YEAR));
//        System.out.println(calendar1.getActualMaximum(Calendar.DAY_OF_MONTH));
//        while (calendar1.get(Calendar.MONTH) + 1 == 7){
//            System.out.println(calendar1.getTime());
//            //System.out.println(calendar.get(Calendar.MONTH));
//            calendar1.add(Calendar.DATE, 1);
//        }
    }
}
