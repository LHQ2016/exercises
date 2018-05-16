package thread.join;

public class Index {
    static int sum = 0;

    public static
    void main(String[] args) {
        int[] arr = new int[100000];
        Thread thread1 = new Thread(new Product(arr));
        thread1.start();
        Thread thread2 = new Thread(new Worker(arr, thread1));
        thread2.start();
        Thread thread3 = new Thread(new PrintTask(thread2));
        thread3.start();
        try {
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int t = 0;
        for (int i = 0; i < arr.length; i++) {
            t += arr[i];
        }
        if (t == sum) {
            System.out.println("验证通过");
        } else {
            System.out.println("验证失败. t=" + t + ", sum = " + sum);
        }
    }

}