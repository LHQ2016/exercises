package experiment.twoPointLookup;

import java.util.Arrays;

public class Task implements Runnable{
    int start,length,key;
    int number;
    int[] arr;
    public Task(int start, int length, int key,int number){
        this.length = length;
        this.start = start;
        this.key = key;
        this.number = number;
        arr = new int[length];
        System.arraycopy(Array.order,start,arr,0,length);
    }

    @Override
    public void run() {
        Find.result[number].val = Arrays.binarySearch(arr,key);
    }
}
