package thread.sleep;

public
class SleepTest {
    public static
    void main(String[] args) {
        Thread thread1 = new Worker("thread1");
        Thread thread2 = new Worker("thread2");
        thread1.start();
        thread2.start();

    }
}
class Worker extends Thread{

    String name;

    public
    Worker(String name) {
        this.name = name;
    }

    @Override
    public
    void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.print("  "+ i +" "+ this.name + "\n");
            try {
                sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}