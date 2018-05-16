package io.stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class FortuneUser {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(".\\src\\resource\\txt\\aaa.txt"));
        ArrayList<String> lists = new ArrayList<String>();
        String line = null;
        while ((line = br.readLine()) != null){
            lists.add(line);
        }
        br.close();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            System.out.println(lists.get(random.nextInt(lists.size())));
        }

    }
}
