package thread.join;

public
class PrintTask implements Runnable {
    Thread thread;

    public
    PrintTask(Thread thread) {
        this.thread = thread;
    }

    @Override
    public
    void run() {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sum=" + Index.sum);
    }
}