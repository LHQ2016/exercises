package io.copy;

import java.io.*;
import java.util.Arrays;

public class ChartoString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(".\\src\\resource\\txt\\111.txt"));
        String string = br.readLine();
        br.close();

        char[] chars =string.toCharArray();
        Arrays.sort(chars);
        BufferedWriter bw = new BufferedWriter(new FileWriter(".\\src\\resource\\txt\\222.txt"));
        bw.write(chars);
        bw.close();
    }
}
