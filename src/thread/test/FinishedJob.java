package thread.test;

/**
 * 现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行
 */
public
class FinishedJob {
    public static void main(String[] args) {
        Worker a = new Worker("A");
        Thread thread1 = new Thread(a);
        Worker b = new Worker("B");
        Thread thread2 = new Thread(b);
        Worker c = new Worker("C");
        Thread thread3 = new Thread(c);
        try {
            thread3.start();
            thread3.join();
            thread1.start();
            thread1.join();
            thread2.start();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class Worker implements Runnable {
    private String name;

    public
    Worker(String name) {
        this.name = name;
    }

    @Override
    public
    void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "输出了" + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            System.out.println(Thread.currentThread().getName() + "输出完成！！！\n");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}