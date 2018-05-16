package io.stream;

import java.io.*;
import java.util.ArrayList;

public class FileToArrayList {
    public static void main(String[] args)  throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(".\\src\\resource\\txt\\aaa.txt"));
        ArrayList<String> lists = new ArrayList<String>();

        String line = null;
        while ((line = br.readLine()) != null){
            lists.add(line);
        }
        br.close();
        for (String str :
                lists) {
            System.out.println(str);
        }
    }
}
