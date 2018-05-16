package coremethodandframeworks.chapter01;

import java.util.concurrent.Semaphore;

public class Service {
    private Semaphore semaphore = new Semaphore(1);
    public void testMethod(){
        try{
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName()+" begin timer="+
            System.currentTimeMillis());
            Thread.sleep(500);
            print();
            System.out.println();
            System.out.println(Thread.currentThread().getName()+" end timer=" + System.currentTimeMillis());
            Thread.sleep(500);
            System.out.println("信号量释放");
            semaphore.release();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void print(){
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(i +" ");
        }
    }

}

class ThreadA extends Thread{
    private Service service;

    public ThreadA(Service service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}

class ThreadB extends Thread{
    private Service service;

    public ThreadB(Service service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}
class ThreadC extends Thread{
    private Service service;

    public ThreadC(Service service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}
