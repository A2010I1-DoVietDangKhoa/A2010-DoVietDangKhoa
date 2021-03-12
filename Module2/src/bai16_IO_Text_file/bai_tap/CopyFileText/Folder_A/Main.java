package bai16_IO_Text_file.bai_tap.CopyFileText.Folder_A;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("D:/A2010-DoVietDangKhoa/Module2/src" +
                "/bai16_IO_Text_file/bai_tap/CopyFileText/Folder_A/source.txt");

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        long totalCharacters = 0;
        FileWriter fileWriter = new FileWriter("D:/A2010-DoVietDangKhoa/Module2/src" +
                "/bai16_IO_Text_file/bai_tap/CopyFileText/Folder_B/target.txt", true);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            fileWriter.write(line + "\n");
            totalCharacters += line.length();
        }
        fileWriter.close();

        System.out.println("Total characters: " + totalCharacters);
    }
}
