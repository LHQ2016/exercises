package io.stream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * public int read()
 * public int read(char[] cbuf, int off, int len) 不知道数据大小所以使用len来调节数据的输出长度
 */
public class InputStreamReaderDemo01 {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader
                (new FileInputStream(".\\src\\resource\\txt\\CopyData01.java"));
//        int ch = 0;
//        while ((ch = isr.read()) != -1)
//            System.out.print((char)ch);
        char[] chs = new char[1024];
        int len = 0;
        while ((len = isr.read(chs)) != -1) {
            System.out.print(new String(chs, 0, len));
        }


        isr.close();
    }
}
