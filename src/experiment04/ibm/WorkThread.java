package experiment04.ibm;

import java.io.PrintStream;
import java.util.Vector;


public class WorkThread extends Thread {

    public int threadNum;
    private boolean flag;

    private Vector taskVector;
    private Task task;


    public WorkThread(Vector vector, int i) {
        flag = true;
        threadNum = i;
        taskVector = vector;

        super.start();
    }

    public void run() {
        while (flag && taskVector != null) {
            synchronized (taskVector) {
                while (taskVector.isEmpty() && flag)
                    try {
                        taskVector.wait();
                    } catch (Exception exception) {
                    }
                try {
                    task = (Task) taskVector.remove(0);
                } catch (Exception ex) {
                    task = null;
                }
                if (task == null)
                    continue;
            }
            try {
                task.setEnd(false);
                task.startTask();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            try {
                if (!task.isEnd()) {
                    task.setEnd(true);
                    task.endTask();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }

    public void closeThread() {
        flag = false;
        try {
            if (task != null)
                task.endTask();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        synchronized (taskVector) {
            taskVector.notifyAll();
        }
    }
}
