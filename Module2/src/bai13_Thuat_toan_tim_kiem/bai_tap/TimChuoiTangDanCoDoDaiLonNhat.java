package bai13_Thuat_toan_tim_kiem.bai_tap;

import java.util.LinkedList;
import java.util.Scanner;

public class TimChuoiTangDanCoDoDaiLonNhat {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String string = input.nextLine();

        LinkedList<Character> max = new LinkedList<>();
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < string.length(); i++) {
            list.add(string.charAt(i));
            for (int j = i + 1; j < string.length(); j++) {
                if (string.charAt(j) > list.getLast()) {
                    list.add(string.charAt(j));
                }
            }

            if (list.size() > max.size()) {
                max.clear();
                max.addAll(list);
            }
            list.clear();
        }

//        max.add(string.charAt(0));
//        for (int i = 1; i < string.length(); i++){
//            if (string.charAt(i) > max.getLast()){
//                max.add(string.charAt(i));
//            }
//        }


        for (Character ch: max) {
            System.out.print(ch);
        }
    }

}
