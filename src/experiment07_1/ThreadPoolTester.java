package experiment07_1;

public class ThreadPoolTester {
    public static void main(String[] args) {
        if (args.length != 2){
            System.out.println("用法：java ThreadPoolTester numTasks poolSize");
            System.out.println("numTasks-integer:任务数目");
            System.out.println("numThreads-integer:线程池中线程的数目");
            return;
        }
        int numTasks = Integer.parseInt(args[0]);
        int poolSize = Integer.parseInt(args[1]);
        
        ThreadPool threadPool = new ThreadPool(poolSize);
        for (int i = 0; i < numTasks; i++) {
            threadPool.execute(createTask(i));
            threadPool.join();
        }
    }
    
    private static Runnable createTask(final int taskID){
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("Task"+taskID+":start");
                try{
                    Thread.sleep(500);
                }catch(InterruptedException ex){ }
                System.out.println("Task"+taskID+":end");
            }
        };
    }
}
