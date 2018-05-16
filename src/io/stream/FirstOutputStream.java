package io.stream;

import java.io.FileOutputStream;
import java.io.IOException;

public class FirstOutputStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream =
                new FileOutputStream(".\\src\\resource\\txt\\first.txt",true);
        fileOutputStream.write("hello,IO\r\n111\r\n".getBytes());
        fileOutputStream.write(97);
        fileOutputStream.write("\r\n".getBytes());
        byte[] bytes = {97, 98, 99, 100, 101};
        fileOutputStream.write(bytes);
        fileOutputStream.write("\r\n".getBytes());
        fileOutputStream.write(bytes, 1, 3);
        fileOutputStream.close();
    }
}
