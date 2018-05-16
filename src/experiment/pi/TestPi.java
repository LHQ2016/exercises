package experiment.pi;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class TestPi {
    private static long Time;
    private static int count = 10000000;

    public static void serial(){
        int ans = 0;
        Task task = new Task(count);

        long start = System.currentTimeMillis();
        try {
            ans = task.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        Time = end-start;
       System.out.println("串行所用时间为: "+Time+ "ms   值为: "+ (ans*4.0/count));
    }

    public static void parallel(int threadNumber){
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<FutureTask<Integer>> result = new ArrayList<FutureTask<Integer>>();

        long start = System.currentTimeMillis();
        Task task;
        int unit = count / threadNumber;
        for(int i=0 ; i<threadNumber ; i++){
            if(i!=threadNumber-1) {
                task = new Task(unit);
            }else{
                task = new Task(count-unit*i);
            }
            FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
            result.add(futureTask);
            executorService.submit(futureTask);
        }
        executorService.shutdown();

        int ans = 0;
        try {
            for (int i = 0; i < threadNumber; i++) {
                ans += result.get(i).get();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();

        System.out.println("并行线程数: "+threadNumber+ "消耗时间为: "+(end-start)+ "ms  \t加速比为:" +
                new DecimalFormat("#0.00").format(Time*1.0/(end-start))+ "  值为: "+ (ans*4.0/count));
    }


    public static void main(String[] args){
        serial();
        parallel(1);
        parallel(2);
        parallel(4);
        parallel(8);

    }
}
