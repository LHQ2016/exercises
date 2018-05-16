package thread.join;

import java.util.Map;

public
class Product implements Runnable {
    int arr[];

    public
    Product(int[] arr) {
        this.arr = arr;
    }

    @Override
    public
    void run() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
    }
}

class Worker implements Runnable {
    int arr[];
    Thread thread;

    public
    Worker(int[] arr, Thread thread) {
        this.arr = arr;
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
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        Index.sum = sum;
    }
}