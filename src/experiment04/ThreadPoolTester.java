package experiment04;

import java.util.LinkedList;

class ThreadPool extends ThreadGroup {
    private boolean isClosed = false;
    private LinkedList<Runnable> workQueue;
    private static int threadPoolID;
    private int threadID;

    public ThreadPool(int poolSize) {
        super("IThreadPool-" + (threadPoolID++));
        setDaemon(true);
        workQueue = new LinkedList<Runnable>();
        for (int i = 0; i < poolSize; i++)
            new WorkThread().start();
    }

    /**
     *
     */
    public synchronized void execute(Runnable task) {
        if (isClosed) { //线程池被关则抛出IllegalStateException异常
            throw new IllegalStateException();
        }
        if (task != null) {
            workQueue.add(task);
            notify();  //
        }
    }

    /**
     *
     */
    protected synchronized Runnable getTask() throws InterruptedException {
        while (workQueue.size() == 0) {
            if (isClosed) return null;
            wait();  //
        }
        return workQueue.removeFirst();
    }

    /**
     *
     */
    public synchronized void close() {
        if (!isClosed) {
            isClosed = true;
            workQueue.clear();
            interrupt();
        }
    }

    /**
     *
     */
    public void join() {
        synchronized (this) {
            isClosed = true;
            notifyAll();
        }

        Thread[] threads = new Thread[activeCount()];
        int count = enumerate(threads);
        for (int i = 0; i < count; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException ex) {
            }
        }
    }

    /**
     *
     */
    private class WorkThread extends Thread {
        public WorkThread() {
            super(ThreadPool.this, "WorkThread-" + (threadID++));
        }

        public void run() {
            while (!isInterrupted()) {
                Runnable task = null;
                try {
                    task = getTask();
                } catch (InterruptedException ex) {
                }

                if (task == null) return;

                try {
                    task.run();
                } catch (Throwable t) {
                    t.printStackTrace();
                }
            }//#while
        }//#run()
    }//#WorkThread
}

public class ThreadPoolTester {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println(
                    "java ThreadPoolTest numTasks poolSize");
            System.out.println(
                    "  numTasks - integer: ");
            System.out.println(
                    "  numThreads - integer: ");
            return;
        }
        int numTasks = Integer.parseInt(args[0]);
        int poolSize = Integer.parseInt(args[1]);

        ThreadPool threadPool = new ThreadPool(poolSize);
        for (int i = 0; i < numTasks; i++)
            threadPool.execute(createTask(i));

        threadPool.join();
        // threadPool.close();
    }//#main()

    /**
     *
     */
    private static Runnable createTask(final int taskID) {
        return new Runnable() {
            public void run() {
                System.out.println("Task " + taskID + ": start");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                }
                System.out.println("Task " + taskID + ": end");
            }
        };
    }
}

