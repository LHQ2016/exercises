package thread.threadpools;

import java.util.concurrent.*;

public class Sum {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Future<Integer> future1 = executorService.submit(new Add(100));
        Future<Integer> future2 = executorService.submit(new Add(200));
        Future<Integer> future3 = executorService.submit(new Add(300));

        Integer a = future1.get();
        Integer b = future2.get();
        Integer c = future3.get();

        executorService.shutdown();

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(a + b + c);

    }
}

class Add implements Callable<Integer> {
    private int number;

    public Add(int number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            sum += i;
        }
        return sum;
    }
}
