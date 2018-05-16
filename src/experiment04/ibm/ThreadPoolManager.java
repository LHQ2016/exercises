package experiment04.ibm;

import java.util.Vector;

public class ThreadPoolManager {

    private int threadNum;

    private int defaultThreadNum;

    private Vector workThreadVector;

    private Vector taskVector;

    public ThreadPoolManager(int i) {
        taskVector = new Vector(10, 10);

        defaultThreadNum = 10;
        if (i > 0)
            defaultThreadNum = i;

        CreateThreadPool(i);
    }

    public ThreadPoolManager() {
        this(10);
    }

    public boolean isAllTaskFinish() {
        return taskVector.isEmpty();
    }

    public int getThreadNum() {
        return threadNum;
    }


    private void CreateThreadPool(int i) {
        if (workThreadVector == null)
            workThreadVector = new Vector(i);
        Object obj = null;

        synchronized (workThreadVector) {
            for (int j = 0; j < i; j++) {
                threadNum++;
                WorkThread workThread = new WorkThread(taskVector, threadNum);
                workThreadVector.addElement(workThread);
            }

        }
    }


    public void addTask(Task taskObj) {
        if (taskObj == null)
            return;
        synchronized (taskVector) {
            taskVector.addElement(taskObj);
            taskVector.notifyAll();
        }
    }


    public void closeThread() {
        Object obj = null;

        while (!workThreadVector.isEmpty()) {


            try {
                WorkThread workThread = (WorkThread) workThreadVector.remove(0);
                workThread.closeThread();
                continue;
            } catch (Exception exception) {

                exception.printStackTrace();
            }
            break;
        }
    }
}
