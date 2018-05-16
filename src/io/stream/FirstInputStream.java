package io.stream;

import java.io.IOException;
import java.io.FileInputStream;
public class FirstInputStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(".\\src\\resource\\txt\\first.txt");
//        int by = fileInputStream.read();
//        while (by != -1) {
//            System.out.print((char) by);
//            by = fileInputStream.read();
//        }
        int by = 0;
        while ((by=fileInputStream.read()) != -1){
            System.out.print((char)by);
        }
        fileInputStream.close();

    }
}
