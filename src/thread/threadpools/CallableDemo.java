package thread.threadpools;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        executorService.submit(new MyCallable());
        executorService.submit(new MyCallable());
        executorService.submit(new MyCallable());
        executorService.submit(new MyCallable());
        executorService.submit(new MyCallable());

        executorService.shutdown();
    }

}

class MyCallable implements Callable{
    @Override
    public Object call() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
        return null;
    }
}
