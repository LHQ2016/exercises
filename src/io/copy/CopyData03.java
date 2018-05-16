package io.copy;

import java.io.*;

public class CopyData03 {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bis = new BufferedInputStream
                (new FileInputStream(".\\src\\resource\\txt\\first.txt"));
        BufferedOutputStream bos = new BufferedOutputStream
                (new FileOutputStream(".\\src\\resource\\txt\\third.txt"));
        int read = 0;
        while ((read = bis.read()) != -1){
            bos.write(read);
        }
        bos.close();
        bis.close();
    }
}
