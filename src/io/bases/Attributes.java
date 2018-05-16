package io.bases;

import java.io.File;
import java.io.IOException;

public class Attributes {
    public static void main(String[] args) throws IOException {
        File file1= new File("D:\\");
        String[] strings = file1.list();
        for (String st: strings) {
            System.out.println(st);
        }
        File[] files = file1.listFiles();
        for (File file : files) {
            System.out.println(file.getCanonicalPath());
        }

    }
}
