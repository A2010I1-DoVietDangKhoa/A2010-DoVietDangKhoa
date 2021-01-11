package bai2_Vong_lap_trong_Java.bai_tap;

public class HienThi20SoNguyenToDauTien {
    public static void main(String[] args) {
        int number = 0;
        int count = 1;

        while (count<=20){
            if(number == 2){
                System.out.print(number + " ");
                number++;
                count++;
                continue;
            }
            int check = 0;
            for (int i = 1; i<= number; i++){
                if (number % i ==0){
                    check++;
                }
            }
            if(check == 2){
                System.out.print(number + " ");
                count++;
            }
            number++;
        }
    }
}
