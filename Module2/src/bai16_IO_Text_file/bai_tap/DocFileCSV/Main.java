package bai16_IO_Text_file.bai_tap.DocFileCSV;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(
                "D:/A2010-DoVietDangKhoa/Module2/src/bai16_IO_Text_file/bai_tap/DocFileCSV/file.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        List<String> list = new ArrayList<>();

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            list.add(line);
        }

        String[] arrayCountry = null;
        for (String i : list) {
            arrayCountry = i.split(",");
            Country country = new Country();
            country.setBeginIP(arrayCountry[0]);
            country.setEndIP(arrayCountry[1]);
            country.setIp2(arrayCountry[2]);
            country.setIp2location(arrayCountry[3]);
            country.setAbbreviation(arrayCountry[4]);
            country.setCountryName(arrayCountry[5]);
            Country.countryArrayList.add(country);
        }

        for(Country i : Country.countryArrayList){
            System.out.println(i.toString() + "\n");
        }
    }
}
