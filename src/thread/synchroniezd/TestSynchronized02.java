package thread.synchroniezd;

public
class TestSynchronized02 implements Runnable {
    static TestSynchronized02 instance = new TestSynchronized02();
    static int count = 0;

    public synchronized void incrance(){
        count++;
    }
    @Override
    public
    void run() {
        for (int i = 0; i < 100000; i++) {
            incrance();
        }
    }


    public static
    void main(String[] args) {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        Thread thread3 = new Thread(instance);
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }
}