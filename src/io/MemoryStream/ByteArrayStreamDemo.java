package io.MemoryStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayStreamDemo {
    public static void main(String[] args) throws IOException{
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        for (int i = 0; i < 10; i++) {
            baos.write(("java" + i+"\r\n").getBytes());
        }
        byte[] bytes = baos.toByteArray();
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        int ch = 0;
        while ((ch = bais.read()) != -1){
            System.out.print((char)ch);
        }
//
//        for (byte by:bytes){
//            System.out.print((char) by);
//        }
    }
}
