package io.stream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class FirstOutputStreamWriter {
    public static void main(String[] args) throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter
                (new FileOutputStream(".\\src\\resource\\txt\\four.txt",true),"utf-8");

        osw.write("中国.....\r\n");

        osw.close();
    }
}
