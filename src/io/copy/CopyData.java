package io.copy;
/**
 * 每次读取一个字节
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyData {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(".\\src\\resource\\txt\\红楼梦.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(".\\src\\resource\\txt\\second.txt");

        int by = 0;
        while ((by = fileInputStream.read()) != -1){
            fileOutputStream.write(by);
        }

        fileInputStream.close();
        fileOutputStream.close();
    }
}
