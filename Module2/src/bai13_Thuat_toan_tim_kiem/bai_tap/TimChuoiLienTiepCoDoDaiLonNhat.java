package bai13_Thuat_toan_tim_kiem.bai_tap;

import java.util.LinkedList;
import java.util.Scanner;

public class TimChuoiLienTiepCoDoDaiLonNhat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Character> max = new LinkedList<>();
        LinkedList<Character> temp = new LinkedList<>();

        System.out.println("Input a string: ");
        String string = scanner.nextLine();
        for (int i = 0; i < string.length(); i++) {
            temp.add(string.charAt(i));
            for (int j = i + 1; j < string.length(); j++) {
                if(string.charAt(j) >= temp.getLast()){
                    temp.add(string.charAt(j));
                }
                else {
                    break;
                }
            }

            if(max.size() < temp.size()){
                max.clear();
                max.addAll(temp);
            }
            temp.clear();
        }

        for (char i : max){
            System.out.print(i);
        }
    }
}
