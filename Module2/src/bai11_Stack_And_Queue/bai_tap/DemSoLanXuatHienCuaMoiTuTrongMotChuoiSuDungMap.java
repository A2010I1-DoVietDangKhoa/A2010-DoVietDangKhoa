package bai11_Stack_And_Queue.bai_tap;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DemSoLanXuatHienCuaMoiTuTrongMotChuoiSuDungMap {
    public static void main(String[] args) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a string: ");
        //scanner.nextLine();
        String text = scanner.nextLine();
        System.out.println("String: " + text);
        String word = "";
        text += " ";
        //Iterator<Map.Entry<String, Integer>> iterator = treeMap.entrySet().iterator();
        int spaceCount = 0;
        for (int i = 0; i < text.length(); i++){
//            if(text.charAt(i) != ' ' && text.charAt(i) != ',' && text.charAt(i) != '.' && text.charAt(i) != ':'
//            && text.charAt(i) != ';' && text.charAt(i) != '\'' && text.charAt(i) != '\"'){
//                word += text.toLowerCase().charAt(i);
//            }
            if (Character.isLetter(text.charAt(i))) {
                word += text.toLowerCase().charAt(i);
            } else {
                if (!word.equals("")) {
                    spaceCount += 1;
                    if (spaceCount == 1) {
                        treeMap.put(word, 1);
                        word = "";
                        continue;
                    }
                    //iterator = treeMap.entrySet().iterator();
                    if (treeMap.containsKey(word)) {
                        treeMap.put(word, treeMap.get(word) + 1);
                    } else {
                        treeMap.put(word, 1);
                    }
                    word = "";
                }
            }
//            System.out.println(word);
//            treeMap.put(word, 1);
//            word = "";
        }
        System.out.println(treeMap);
    }
}
