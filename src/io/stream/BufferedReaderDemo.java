package io.stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(".\\src\\resource\\txt\\aaa.txt"));

//        int ch = 0;
//        while ((ch = br.read()) != -1){
//            System.out.print((char)ch);
//        }
        int len = 0;
        char[] chs = new char[1024];
        while ((len = br.read(chs)) != -1){
            System.out.print(chs);
        }

        br.close();
    }
}
