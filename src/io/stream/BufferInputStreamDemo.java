package io.stream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferInputStreamDemo {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream
                (new FileInputStream(".\\src\\resource\\txt\\first.txt"));
//        int by = 0;
//        while ((by = bufferedInputStream.read()) != -1){
//            System.out.print((char)by);
//        }
//        System.out.println("\n------------------");

        byte[] reads = new byte[1024];
        int len = 0;
        while ((len = bufferedInputStream.read(reads)) != -1){
            System.out.print(new String(reads,0,len));
        }

        bufferedInputStream.close();
    }
}
