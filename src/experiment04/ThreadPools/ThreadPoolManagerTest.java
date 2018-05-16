package experiment04.ThreadPools;

public class ThreadPoolManagerTest {


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Upload[] tasks = createBatchTask(7);
        ThreadPoolManager pool = ThreadPoolManager.getInstance();
        pool.BatchAddTask(tasks);
        pool.destory();
    }
    private static Upload[] createBatchTask(int n){
        Upload[] tasks = new TaskUpload[n];
        for(int i = 0;i<n ;i++ ){
            tasks[i] = new TaskUpload("task id is "+ i);
        }
        return tasks;
    }
}