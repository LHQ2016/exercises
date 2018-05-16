package thread.priority;

public class Worker extends Thread {
    private String name;

    public Worker(String name, int priority) {
        this.name = name;
        if(priority > 10 || priority < 1)
        {
            System.out.println("警告：优先级的取值在1-10之间");
            this.setPriority(Thread.NORM_PRIORITY);
        }else{
            this.setPriority(priority);
        }
    }

    @Override
    public
    void run() {
        System.out.println(name + "的优先级为"+this.getPriority());
        for (int i = 0; i < 10; i++) {
            System.out.println(name+" 正在打印"+i);
        }
    }
}