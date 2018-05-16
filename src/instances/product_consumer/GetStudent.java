package instances.product_consumer;

public class GetStudent implements Runnable {
    private Student s;

    public GetStudent(Student s) {
        this.s = s;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (s) {
                if (!s.flag) {
                    try {
                        s.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(s.name + "____" + s.age);
                s.flag = false;
                s.notify();
            }
        }
    }
}
