package instances.sellticket;

public class SellTicketDemo02Test {
    public static void main(String[] args) {
        SellTicketDemo02 std = new SellTicketDemo02();

        Thread thread1 = new Thread(std, "窗口1");
        Thread thread2 = new Thread(std, "窗口2");
        Thread thread3 = new Thread(std, "窗口3");

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
