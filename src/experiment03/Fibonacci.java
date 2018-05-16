package experiment03;
/**
 * ForkJoin实现递归求解Fibonacci数列
 */

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

public class Fibonacci extends RecursiveTask<Long> {

    long n;
    public Fibonacci(long n) {
        this.n = n;
    }

    public Long compute() {
        if(n <= 10) {  //小于10不再分解
            return Fibonacci.calc(n);
        }
        Fibonacci f1 = new Fibonacci(n - 1);  //分解出计算n-1斐波那契数的子任务
        f1.fork();  //由ForkJoinPool分配线程执行子任务
        Fibonacci f2 = new Fibonacci(n - 2);  //分解出计算n-2斐波那契数的子任务
        return f2.compute() + f1.join();
    }

    public static long calc(long n) {
        if(n < 0) {
            return 0;
        }
        if(n == 0 || n == 1) {
            return n;
        } else {
            return calc(n - 1) + calc(n - 2);
        }
    }
    public static long test(long num)
    {
        if (num < 0)
        {
            return 0;
        }
        if (num == 0 || num ==1){
            return num;
        }
        else
            return test(num-1)+test(num-2);
    }

    public static void main(String[] args) {
        long n = 15;
        long begin = System.nanoTime();
        Fibonacci fibonacci = new Fibonacci(n);
        ForkJoinPool pool = new ForkJoinPool();
        long f = pool.invoke(fibonacci);
        long end = System.nanoTime();
        System.out.println("Fork/Join计算斐波那契数列第" + n + "个斐波那契数是" + f +
                ", 耗时" + TimeUnit.NANOSECONDS.toMillis(end - begin) + "ms");
//        long starttime =System.nanoTime();
//        long sum = test(n);
//        long endtimes= System.nanoTime();
//        System.out.println("递归计算斐波那契数列第" + n + "个斐波那契数是" + sum +
//                ", 耗时" + TimeUnit.NANOSECONDS.toMillis(endtimes - starttime) + "ms");
    }
}