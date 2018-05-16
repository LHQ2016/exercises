package instances.sellticket;

public class SellTicketDemo02 implements Runnable {
    private int ticket = 100;
    @Override
    public void run() {
        while (true){
            synchronized (SellTicketDemo02.class) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖出第" + ticket-- + "张票");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("票已售完");
                    System.exit(0);
                }
            }
        }
    }
}
