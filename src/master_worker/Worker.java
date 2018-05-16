package master_worker;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Worker implements Runnable {

    private ConcurrentHashMap<String, Object> resoultMap;
    private ConcurrentLinkedQueue<Task> workerQueue;

    public void setResoultMap(ConcurrentHashMap<String, Object> resoultMap) {
        this.resoultMap = resoultMap;
    }

    public void setWorkerQueue(ConcurrentLinkedQueue<Task> workerQueue) {
        this.workerQueue = workerQueue;
    }


    @Override
    public void run() {

        while (true){
            Task input = this.workerQueue.poll();
            if (input == null)break;
            Object output = handle(input);
            this.resoultMap.put(Integer.toString(input.getId()),output);
        }
    }

    private Object handle(Task input) {
        Object out = null;
        try {
            Thread.sleep(500);
            out = input.getPrice();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return out;
    }
}
