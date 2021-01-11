package bai2_Vong_lap_trong_Java.bai_tap;

public class HienThiCacSoNguyenToNhoHon100 {
    public static void main(String[] args) {
        int count = 0;
        while (count<=100){
            int check = 0;
            for (int i = 1; i<=count; i++){
                if(count % i == 0){
                    check++;
                }
            }
            if (check == 2){
                System.out.print(count + " ");
            }
            count++;
        }
    }
}
