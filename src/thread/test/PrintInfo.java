package thread.test;

public
class PrintInfo {
    public static
    void main(String[] args) {
        Students stu1 = new Students("John", "00001");
        Students stu2 = new Students("Tom", "00002");
        Thread thread1 = new Thread(stu1);
        Thread thread2 = new Thread(stu2);
        thread1.start();
        try {
            thread2.start();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Students implements Runnable {

    private String name;
    private String id;

    public
    Students(String name, String id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public
    void run() {
        System.out.println("Name: " + name + ",\tID: " + id);
    }
}