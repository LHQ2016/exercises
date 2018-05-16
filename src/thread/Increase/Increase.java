package thread.Increase;

public
class Increase {
    public static
    void main(String[] args) {
        Data data = new Data();
        Worker worker1 = new Worker(data);
        Worker worker2 = new Worker(data);
        Thread thread1 = new Thread(worker1);
        Thread thread2 = new Thread(worker2);
        thread1.start();
        thread2.start();
        while (true)
        {
            data.isEqual();
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}