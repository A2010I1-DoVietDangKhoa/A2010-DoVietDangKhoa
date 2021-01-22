package bai4_Lop_va_doi_tuong_trong_Java.bai_tap;

import java.util.Scanner;

public class XayDungLopStopWatch {
    public static class StopWatch {
        private long startTime;
        private long endTime;

        public StopWatch() {

        }

        public void start() {
            startTime = System.currentTimeMillis();
        }

        public void end() {
            endTime = System.currentTimeMillis();
        }

        public long getElapsedTime() {
            return endTime - startTime;
        }
    }

    static void sort(double[] arr)
    {
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            double temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }


    public static void main(String[] args) {
        double[] array = new double[1000];
        for (int i = 0; i<array.length; i++){
            array[i] = Math.random() * 1000;
        }
        StopWatch stopWatch = new StopWatch();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pick stop watch's option:");
        System.out.println("(1) Start stop watch.");
        System.out.println("(2) Calculate executing time for sorting an array with 1000 elements.");
        System.out.println("(3) Exit.");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                stopWatch.start();
                System.out.println("Counting...");
                System.out.println("Input \"show\" if you want to show elapsed time, \"stop\" if you want to stop.");
                String command;
                do {
                    command = scanner.nextLine();
                    if (command.equals("show")) {
                        stopWatch.end();
                        System.out.println(stopWatch.getElapsedTime() / 1000.0);
                    } else if (command.equals("stop")) {
                        break;
                    }
                } while (true);
                stopWatch.end();
                System.out.println(stopWatch.getElapsedTime() / 1000.0 + " seconds");
                break;
            case 2:
                stopWatch.start();
                sort(array);
                stopWatch.end();
                for(double i : array){
                    System.out.print(i + ", ");
            }
                System.out.println();
                System.out.println(stopWatch.getElapsedTime() / 1000.0);
                break;

            case 3:
                System.exit(0);
            default:
                System.out.println("Invalid choice.");
        }
    }
}
