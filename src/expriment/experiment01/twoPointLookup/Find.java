package expriment.experiment01.twoPointLookup;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Find {
    private static int key =(int)(Math.random()*1024*1024);

    public static  Share[] result = new Share[10];
    static {
        for (int i = 0; i < 10; i++) {
            result[i]  = new Share();
        }
    }

    public static void serach(int threadNumber){
        ExecutorService executorService = Executors.newCachedThreadPool();
        Task task;
        long start = System.currentTimeMillis();

        int unit = Array.order.length/threadNumber;
        for(int i=0 ; i<threadNumber ; i++){
            if(i!=threadNumber-1) {
                task = new Task(i*unit, unit,key,i);
            }else{
                task = new Task(i*unit,Array.order.length-unit*i,key,i);
            }
            executorService.submit(task);
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();

        long ans = 0;
        for(int i=0 ; i<threadNumber ; i++){
            if(result[i].val>=0) {
                ans = i*unit+result[i].val;
                break;
            }
        }
        if(ans < 0) {
            System.out.println("并行线程数:" + threadNumber + " 消耗时间:" + (end - start) + "ms  没有找到");
        }else{
            System.out.println("并行线程数:" + threadNumber + " 消耗时间:" + (end - start) + "ms 下标为: " + ans);
        }
    }

    public static void main(String[] args) {
        serach(1);
        serach(2);
        serach(4);
        serach(8);
    }
}
