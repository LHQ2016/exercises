package io.Print;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * PrintWriter
 * 1. 可以操作任意类型（Java的8种类型）
 *
 */
public class PrintWriterDemo {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter(".\\src\\resource\\txt\\ccc.txt"), true);

        pw.println(100);
        pw.println("hello");
    }
}
