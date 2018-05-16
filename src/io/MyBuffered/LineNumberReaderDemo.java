package io.MyBuffered;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class LineNumberReaderDemo {
    public static void main(String[] args) throws IOException {
        LineNumberReader linr = new LineNumberReader(new FileReader(".\\src\\resource\\txt\\aaa.txt"));
        String line = null;
        linr.setLineNumber(50);
        while ((line = linr.readLine()) != null) {
            System.out.println(linr.getLineNumber() + ":" + line);
        }
        linr.close();
    }

}
