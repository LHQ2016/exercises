package io.stream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FirstInputStramReader {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader
                (new FileInputStream(".\\src\\resource\\txt\\four.txt"),"utf-8");
        int ch = 0;
        while ((ch = isr.read()) != -1){
            System.out.print((char)ch);
        }

        isr.close();

    }
}
