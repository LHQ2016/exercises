package test;

import java.util.Arrays;
import java.util.Random;

public class TestAsList {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>(Arrays.asList("a1", "ab2", "a3", "ab4", "a5", "ab6", "a7", "ab8", "a9"));
//        for (String str: list) {
//            list.remove(str);
//        }

        int[] arr = new Random().ints(1000000000,1,1000000001).toArray();
        int[] array = Arrays.copyOf(arr, arr.length);
        Long start = System.currentTimeMillis();
        Arrays.sort(arr);
        Long end = System.currentTimeMillis();
        System.out.println((end-start)/1000.0);

        start = System.currentTimeMillis();
        Arrays.parallelSort(array);
        end = System.currentTimeMillis();
        System.out.println((end-start)/1000.0);
    }//end of main
}
