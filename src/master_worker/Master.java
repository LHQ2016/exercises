package master_worker;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Master {

    //盛装任务的集合
    private ConcurrentLinkedQueue<Task> workerQueue = new ConcurrentLinkedQueue<>();

    //使用hashmap盛装子任务
    private HashMap<String, Thread> workers = new HashMap<>();

    //盛装子任务的结果集
    private ConcurrentHashMap<String, Object> resoultMap = new ConcurrentHashMap<>();

    public Master(Worker worker, int workerCount) {
        worker.setWorkerQueue(this.workerQueue);
        worker.setResoultMap(this.resoultMap);
        for (int i = 0; i < workerCount; i++) {
            workers.put("子节点" + Integer.toString(i), new Thread(worker));
        }//end for
    }

    public void submit(Task task) {
        this.workerQueue.add(task);
    }

    public void execute() {
        for (Map.Entry<String, Thread> me : workers.entrySet()) {
            me.getValue().start();
        }
    }


    public boolean isComplete() {
        for (Map.Entry<String, Thread> me : workers.entrySet()) {
            if (me.getValue().getState() != Thread.State.TERMINATED) {
                return false;
            }
        }
        return true;
    }

    public long getResult() {
        long ret = 0L;
        for (Map.Entry<String, Object> me : resoultMap.entrySet()) {
            ret += (Long) me.getValue();
        }
        return ret;
    }
}
