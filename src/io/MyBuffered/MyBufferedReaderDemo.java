package io.MyBuffered;

import java.io.FileReader;
import java.io.IOException;

public class MyBufferedReaderDemo {
    public static void main(String[] args) throws IOException{
        MyBufferedReader mbr = new MyBufferedReader(new FileReader(".\\src\\resource\\txt\\aaa.txt"));

        String line = null;
        while ((line = mbr.readLine()) != null){
            System.out.println(line);
        }
        mbr.close();
    }
}
