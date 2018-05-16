package io.stream;

import java.io.*;

/**
 * 字符流的特殊功能用法
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        write();
        reader();
    }

    private static void reader() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(".\\src\\resource\\txt\\aaa.txt"));
        String string = null;
        while ((string = br.readLine()) != null){
            System.out.println(string);
        }
        br.close();
    }

    public static void write() throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter(".\\src\\resource\\txt\\aaa.txt"));
        for (int i = 0; i < 30; i++) {
            bw.write("java"+i);
            bw.newLine();
            bw.flush();
    }
        bw.close();
    }
}
