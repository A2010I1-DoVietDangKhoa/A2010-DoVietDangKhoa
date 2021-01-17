package bai4_Lop_va_doi_tuong_trong_Java.bai_tap;

import java.util.Date;
import java.util.Scanner;

public class XayDungLopStopWatch {
    public static class StopWatch{
        public long startTime;
        public long endTime;

        public StopWatch(){

        }

        public void start(){
            startTime = System.currentTimeMillis();
        }

        public void end(){
            endTime = System.currentTimeMillis();
        }

        public long getElapsedTime(){
            return endTime - startTime;
        }
    }

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Start stop watch? Y/N");
        char choice = scanner.next().charAt(0);
        switch (choice){
            case 'Y':
            case 'y':
                stopWatch.start();
                System.out.println("Input \"stop\" if you want to stop counting.");
                String command;
                do{
                    command = scanner.nextLine();
                }while (!command.equals("stop"));
                stopWatch.end();
                System.out.println("Millis: " + stopWatch.getElapsedTime());
                break;
            case 'N':
            case 'n':
                System.exit(0);
            default:
                System.out.println("Invalid choice.");
        }
    }
}
