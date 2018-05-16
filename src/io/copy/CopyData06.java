package io.copy;

import java.io.*;

public class CopyData06 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(".\\src\\resource\\txt\\bbb.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\李华强\\Desktop\\test.txt"));

        int len = 0;
        char[] chs = new char[1024];
        while ((len = br.read(chs)) != -1) {
            bw.write(new String(chs, 0, len));
            bw.flush();
        }
        bw.close();
        br.close();
    }
}
