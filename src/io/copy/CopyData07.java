package io.copy;

import java.io.*;

/**
 * 将aaa.txt复制为bbb.txt
 */
public class CopyData07 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(".\\src\\resource\\txt\\bbb.txt"));
        BufferedReader br = new BufferedReader(new FileReader(".\\src\\resource\\txt\\aaa.txt"));

        String line = null;
        while ((line = br.readLine()) != null){
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        br.close();
        bw.close();
    }
}
