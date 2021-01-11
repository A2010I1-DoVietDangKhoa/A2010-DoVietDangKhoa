package bai2_Vong_lap_trong_Java.thuc_hanh;

public class HienThiCacSoNguyenToNhoHon100 {
    public static void main(String[] args) {
        int count = 0;
        while (count<=100){
            if(count == 2){
                System.out.print(count + " ");
                count++;
                continue;
            }
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
