package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestAsList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("a1", "ab2", "a3", "ab4", "a5", "ab6", "a7", "ab8", "a9"));

        for (String str: list) {
            list.remove(str);
        }
    }//end of main
}
