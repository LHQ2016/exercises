package io.copy;

import java.io.*;

/**
 * 将文件aaa.txt和文件bbb.txt写到同意文件eee.txt中
 */
public class CopyData10 {
    public static void main(String[] args) throws IOException {
        InputStream s1 = new FileInputStream(".\\src\\resource\\txt\\aaa.txt");
        InputStream s2 = new FileInputStream(".\\src\\resource\\txt\\bbb.txt");
        SequenceInputStream sis = new SequenceInputStream(s1, s2);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(".\\src\\resource\\txt\\eee.txt"));

        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = sis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }

        sis.close();
        bos.close();
    }
}
