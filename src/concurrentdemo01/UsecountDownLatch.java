package concurrentdemo01;

import java.util.concurrent.CountDownLatch;

public class UsecountDownLatch {
    public static void main(String[] args) {
        final CountDownLatch countdown = new CountDownLatch(2);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    System.out.println("进入线程1，等待其他线程处理完成");
                    countdown.await();
                    System.out.println("t1线程继续执行...");
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    System.out.println("t2线程执行初始化");
                    Thread.sleep(3000);
                    System.out.println("t2线程初始化完毕，通知t1线程继续...");
                    countdown.countDown();
                }catch(InterruptedException e ){
                    e.printStackTrace();
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    System.out.println("t3线程执行初始化");
                    Thread.sleep(3000);
                    System.out.println("t3线程初始化完毕，通知t1线程继续...");
                    countdown.countDown();
                }catch(InterruptedException e ){
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }//end main
}
