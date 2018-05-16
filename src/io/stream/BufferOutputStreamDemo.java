package io.stream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream
                (new FileOutputStream(".\\src\\resource\\txt\\test.txt"));
        bufferedOutputStream.write("hello".getBytes());

        bufferedOutputStream.close();

    }
}
