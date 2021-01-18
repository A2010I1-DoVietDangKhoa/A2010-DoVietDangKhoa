package bai4_Lop_va_doi_tuong_trong_Java.bai_tap;

import java.util.Date;
import java.util.Scanner;

public class XayDungLopStopWatch extends Thread {
    public static class StopWatch{
        private long startTime;
        private long endTime;

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
                System.out.println("Counting...");
                System.out.println("Input \"show\" if you want to show elapsed time, \"stop\" if you want to stop.");
                String command;
                do{
                    command = scanner.nextLine();
                    if (command.equals("show")){
                        stopWatch.end();
                        System.out.println(stopWatch.getElapsedTime()/1000.0);
                    }
                    else if (command.equals("stop")){
                        break;
                    }
                }while (true);
                stopWatch.end();
                System.out.println(stopWatch.getElapsedTime()/1000.0 + " seconds");
                break;
            case 'N':
            case 'n':
                System.exit(0);
            default:
                System.out.println("Invalid choice.");
        }
    }
}
