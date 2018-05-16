package instances.sellticket;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SellTicketDemo01 implements Runnable {
    private int ticket = 100;
    private Lock lock = new ReentrantLock();
    @Override
    public void run() {
            while (true){
                try {
                lock.lock();
                if (ticket > 0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"卖出第" + ticket-- + "张票");
                }else {
                    System.out.println("售票结束");
                    System.exit(0);
                }
                }
                finally {
                    lock.unlock();
                }
            }
    }
}
