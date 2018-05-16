package thread.threadname;

public class ThreadName {
    public static void main(String[] args) {
        Thread thread1 = new Worker("Nomal Worker");
        Thread thread2 = new Worker("Skilled worker");
        thread1.start();
        thread2.start();
    }
}