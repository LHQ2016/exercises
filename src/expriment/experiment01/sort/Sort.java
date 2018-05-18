package expriment.experiment01.sort;

import java.util.ArrayList;
import java.util.concurrent.*;

public class Sort {

    public static void sort(int threadNumber,String type){
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<FutureTask<Integer[]>> result = new ArrayList<FutureTask<Integer[]>>();

        Task task;
        long start = System.currentTimeMillis();
        int unit = Array.disorder.length/threadNumber;
        for(int i=0 ; i<threadNumber ; i++){
            if(i!=threadNumber-1) {
                Integer[] arr = new Integer[unit];
                System.arraycopy(Array.disorder,unit*i,arr,0,unit);
                task = new Task(arr,type);

            }else{
                Integer[] arr = new Integer[Array.disorder.length-unit*i];
                System.arraycopy(Array.disorder,unit*i,arr,0,Array.disorder.length-unit*i);
                task = new Task(arr,type);
            }
            FutureTask<Integer[]> futureTask = new FutureTask<Integer[]>(task);
            result.add(futureTask);
            executorService.submit(futureTask);
        }
        executorService.shutdown();

        Integer[] ans = null;

        try {

            Integer[] tem1 = new Integer[result.get(0).get().length + result.get(1).get().length];
            Array.join(result.get(0).get(), result.get(1).get(), tem1);
            Integer[] tem2 = new Integer[result.get(2).get().length + result.get(3).get().length];
            Array.join(result.get(2).get(), result.get(3).get(), tem2);

            ans = new Integer[tem1.length+tem2.length];
            Array.join(tem1, tem2, ans);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();


        System.out.println(type+"并行线程数:" + threadNumber + " 消耗时间:" + (end - start) + "ms 数据量: "+Array.disorder.length);

    }

    public static void main(String[] args) {
        sort(16,"qsort");
//        sort(2,"qsort");
        sort(4,"qsort");
//        sort(1,"qsort");
        sort(8,"merge");
    }
}
