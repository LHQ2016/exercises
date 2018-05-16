package thread.daemon;

import java.util.LinkedList;

public class Index {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        Thread thread1 = new Worker(list);
        Thread thread2 = new Worker(list);
        Thread cleaner =new Cleaner(list);
        thread1.start();
        thread2.start();
        cleaner.start();
    }
}