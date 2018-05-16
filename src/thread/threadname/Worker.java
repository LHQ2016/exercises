package thread.threadname;

public class Worker extends Thread {
    String name;
    public Worker(String name){
        this.name = name;
    }

    @Override
    public
    void run() {
        for (int i = 0; i < 100; i++) {
            if (i == 50)
                this.setName(name);
            System.out.println(this.getName() + " print " + i);
        }
    }
}