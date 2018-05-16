package thread.priority;

public class Index {
    public static void main(String[] args) {
        Thread thread001 = new Worker("Thread001", Thread.MIN_PRIORITY);
        Thread thread002 = new Worker("Thread002", Thread.MIN_PRIORITY);
        Thread thread003 = new Worker("Thread003", Thread.MAX_PRIORITY);
        Thread thread004 = new Worker("Thread004", Thread.MAX_PRIORITY);
        thread001.start();
        thread002.start();
        thread003.start();
        thread004.start();
    }
}