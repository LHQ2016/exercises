package experiment03;
/**
 * ForkJoin实现求解递归求和
 */

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

    public class ForkJoinSum extends RecursiveTask<Long> {

    private static final int DEFAULT_CAPACITY = 10000;

    private long start;
    private long end;

    public ForkJoinSum(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Long compute() {
        long sum = 0L;
        if (end - start < DEFAULT_CAPACITY)
        {
            return end+sum(start,end-1);
        }
        long middle = (start + end)/2;
        ForkJoinSum task1 = new ForkJoinSum(start, middle);
        ForkJoinSum task2 = new ForkJoinSum(middle+1, end);
        task1.fork();
        task2.fork();
        return sum = task1.join()+task2.join();

    }

    private static long sum(long begin, long end)
    {
        return end - begin == 0 ? begin:end+sum(begin,end-1);
    }


    public static void main(String[] args) {
        int start = 1;
        int num = 4000000;
        //当递归计算超出41836时就会出现StackOverflowError
        //Fork/join
        long begintime1 = System.nanoTime();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinSum task = new ForkJoinSum(start,num);
        long sums1 = pool.invoke(task);
        long endtime1 = System.nanoTime();
//        System.out.println("ForkJoin计算结果耗时："+(endtime1 - begintime1)+"ns");
        System.out.println("ForkJoin计算结果耗时："+ TimeUnit.NANOSECONDS.toMillis(endtime1 - begintime1)+"ms");
        System.out.println(sums1);

        //非递归
//        long sums2 = 0;
//        long begintime2 = System.nanoTime();
//        for (int i = 0; i <= num; i++) {
//              sums2 += i;
//        }
//        long endtime2 = System.nanoTime();
//        System.out.println("非递归计算耗时："+TimeUnit.NANOSECONDS.toMillis(endtime2 - begintime2) + "ms");
//        System.out.println(sums2);

        //递归
//        long sums3 = 0L;
//        long begintime3 = System.nanoTime();
//        sums3 = sum(start,num);
//        long endtime3 = System.nanoTime();
//        System.out.println("递归计算耗时："+(endtime3 - begintime3)+"ns");
////        System.out.println("递归计算耗时："+TimeUnit.NANOSECONDS.toMillis(endtime3 - begintime3 )+"s");
//        System.out.println(sums3);


    }
}
