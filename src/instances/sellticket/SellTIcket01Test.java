package instances.sellticket;

public class SellTIcket01Test {
    public static void main(String[] args) {
        SellTicketDemo01 std2 = new SellTicketDemo01();

        new Thread(std2,"窗口1").start();
        new Thread(std2,"窗口2").start();
        new Thread(std2,"窗口3").start();
    }
}
