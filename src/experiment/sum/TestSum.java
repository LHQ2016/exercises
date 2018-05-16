package experiment.sum;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TestSum {
    private static long Time;
    //串行求和
    public static void serial() {
        Task task = new Task(0, Array.disorder.length);
        Long ans = null;

        long start = System.currentTimeMillis();
        try {
            ans = task.call();
        } catch (Exception e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        Time = end-start;
        System.out.println("串行所用时间为: " + Time + "ms   值为: " + ans);
    }

    //线程求和
    public static void parallel(int threadNumber) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        List<FutureTask<Long>> result = new ArrayList<FutureTask<Long>>();

        long start = System.currentTimeMillis();
        int unit = Array.disorder.length/threadNumber;
        Task task;
        for (int i = 0; i < threadNumber; i++) {
            if(i!=threadNumber-1) {
                task = new Task(unit*i, unit*(i+1));
            }else {
                task = new Task(unit*i, Array.disorder.length);
            }
            FutureTask<Long> futureTask = new FutureTask<Long>(task);
            result.add(futureTask);
            executorService.submit(futureTask);
        }
        executorService.shutdown();

        long ans = 0;
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
        System.out.println("并行线程数:" + threadNumber + " 消耗时间:" + (end - start) + "ms \t加速比为: "+
                new DecimalFormat("#0.00").format(Time*1.0/(end-start))+"  值为: " + ans);
    }

    public static void main(String[] args) {
        serial();
        parallel(1);
        parallel(2);
        parallel(4);
        parallel(8);
    }
}
