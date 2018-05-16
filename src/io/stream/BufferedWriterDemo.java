package io.stream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterDemo {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(".\\src\\resource\\txt\\aaa.txt"));

        bw.write("hello, java");
        bw.flush();

        bw.close();
    }
}
