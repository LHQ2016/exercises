package io.stream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * public void write(int b)
 * public void write(char[] cbuf)
 * public abstract void write(char[] cbuf, int off, int len)
 * public void write(String str)
 * public void write(String str, int off, int len)
 */

public class OutputStreamWriterDemo01 {
    public static void main(String[] args) throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(".\\src\\resource\\txt\\test.txt", true));

//        osw.write('中');

//        char[] bys = {'1','2','3','4','5'};
//        osw.write("\n");
//        osw.write(bys);
//        osw.write("\n123456789\n");
        osw.write("\n123456789\n", 5, 5);
        osw.flush();
        osw.close();

    }
}
