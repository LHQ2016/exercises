package io.copy;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyData05 {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(".\\src\\resource\\txt\\CopyData01.java");
        FileWriter fileWriter = new FileWriter(".\\src\\resource\\txt\\second.txt",true);

//        int ch = 0;
//        while ((ch = fileReader.read()) != -1){
//            fileWriter.write(ch);
//        }

        char[] chs = new char[1024];
        int len = 0;
        while ((len = fileReader.read(chs)) != -1) {
            fileWriter.write(chs, 0, len);
            fileWriter.flush();
        }

        fileReader.close();
        fileWriter.close();
    }
}
