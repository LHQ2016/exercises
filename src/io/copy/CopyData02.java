package io.copy;
/**
 * 每次读取一个字节数组
 */

import java.io.FileInputStream;
import java.io.IOException;

public class CopyData02 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(".\\src\\resource\\txt\\first.txt");
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fileInputStream.read(bytes)) != -1) {
            System.out.print(new String(bytes, 0, len));
        }

        fileInputStream.close();
    }

}
