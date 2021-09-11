package Final_Exam.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    public static void main(String[] args) throws ParseException {
//        PatientController.readPatient();
//        while (true){
//            displayMainMenu();
//        }
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        double totalDayBeforeEnd = 1.0;
//        calendar1.set(Calendar.YEAR, 2021);
//        calendar1.set(Calendar.MONTH, 6);
//        calendar1.set(Calendar.DAY_OF_MONTH, 1);
//        calendar2.set(Calendar.YEAR, 2021);
//        calendar2.set(Calendar.MONTH, 6);
//        calendar2.set(Calendar.DAY_OF_MONTH, 10);
//        System.out.println(calendar1.getTime());
//        System.out.println(calendar2.getTime());
//        do {
//            totalDayBeforeEnd++;
//            calendar1.add(Calendar.DATE, 1);
//            System.out.println(calendar1.getTime());
//            System.out.println(totalDayBeforeEnd);
//        }
//        while (calendar1.get(Calendar.DAY_OF_MONTH) != calendar2.get(Calendar.DAY_OF_MONTH)
//            || calendar1.get(Calendar.MONTH) != calendar2.get(Calendar.MONTH)
//                || calendar1.get(Calendar.YEAR) != calendar2.get(Calendar.YEAR)){
//            totalDayBeforeEnd++;
//            calendar1.add(Calendar.DATE, 1);
//            System.out.println(totalDayBeforeEnd);
//        }
//        double percentage = Math.round((61.0/60.0) * 100.0);
//        System.out.println(percentage);
//        double totalHour = (5.0/7.0) * 40;
//        System.out.println(totalHour);
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
//        String string = "true,false,true,true,true,false";
//        String[] arr = string.split(",");
//        for (String s : arr){
//            System.out.println(Boolean.parseBoolean(s));
//        }
        calendar1.set(Calendar.MONTH, 8);
        calendar1.set(Calendar.YEAR, 2021);
        calendar1.set(Calendar.DATE, 4);
        calendar1.set(Calendar.HOUR, 0);
        calendar1.set(Calendar.HOUR_OF_DAY, 0);
        calendar1.set(Calendar.MINUTE, 0);
        calendar1.set(Calendar.SECOND, 0);
        calendar1.set(Calendar.MILLISECOND, 0);
        calendar2.set(Calendar.MONTH, 8);
        calendar2.set(Calendar.YEAR, 2021);
        calendar2.set(Calendar.DATE, 7);
        calendar2.set(Calendar.HOUR, 0);
        calendar2.set(Calendar.HOUR_OF_DAY, 0);
        calendar2.set(Calendar.MINUTE, 0);
        calendar2.set(Calendar.SECOND, 0);
        calendar2.set(Calendar.MILLISECOND, 0);
        //System.out.println(calendar1.getTime());
        //System.out.println(calendar2.getTime());
        List<Date> dateList = new ArrayList<>();
        //Date date1 = calendar1.getTime();
        //System.out.println(date1);
        dateList.add(calendar1.getTime());
        System.out.println(calendar1.equals(calendar2));
        //System.out.println(calendar1.getTime());
//        do{
//            calendar1.add(Calendar.DATE, 1);
//            //date1 = calendar1.getTime();
//            //System.out.println(calendar1.getTime().toString());
//            dateList.add(calendar1.getTime());
//        }while(!calendar1.equals(calendar2));
//        for (Date d : dateList){
//            System.out.println(d.toString());
//        }
        final int MILLISECOND = (1000 * 60 * 60 * 24);

        Date date1 = calendar1.getTime();
        Date date2 = calendar2.getTime();
        Long hourTotal = (((date2.getTime() - date1.getTime()) / MILLISECOND) + 1) * 8;
        System.out.println(hourTotal);
        SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
        date1 = SIMPLE_DATE_FORMAT.parse("2021-09-07");
        date2 = SIMPLE_DATE_FORMAT.parse("2021-09-06");
        System.out.println(date1);
        System.out.println(date2);
        System.out.println(date1.equals(date2));
        System.out.println(date1.before(date2));
        System.out.println(date1.after(date2));
//        calendar1.set(Calendar.MONTH, 8);
//        calendar1.set(Calendar.YEAR, 2021);
//        calendar1.set(Calendar.DATE, 6);
//        System.out.println(calendar1.getTime());
//        System.out.println(calendar1.get(Calendar.DAY_OF_WEEK));
        //System.out.println(calendar1.getTime());
        //System.out.println(calendar1.get(Calendar.DAY_OF_WEEK));
    }
}
