package instances.product_consumer;

public class SetStudent implements Runnable {
    private Student s;
    private int x = 0;

    public SetStudent(Student s) {
        this.s = s;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (s) {
                if (s.flag) {
                    try {
                        s.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (x % 2 == 0) {
                    s.name = "John";
                    s.age = 22;
                } else {
                    s.name = "Tom";
                    s.age = 33;
                }
                x++;
                s.flag = true;
                s.notify();
            }
        }
    }
}
