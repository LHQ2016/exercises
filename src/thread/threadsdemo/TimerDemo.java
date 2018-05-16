package thread.threadsdemo;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {
    public static void main(String[] args) {
        Timer timer = new Timer();
        MyTask task = new MyTask();
        timer.schedule(task, 500, 1000);
    }
}

class MyTask extends TimerTask {
    private int count = 0;

    @Override
    public void run() {
        count++;
        System.out.println(count);
    }
}