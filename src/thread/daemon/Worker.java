package thread.daemon;

import java.util.LinkedList;

public class Worker extends Thread {
    private LinkedList<Integer> list;

    public Worker(LinkedList<Integer> list) {
        this.list = list;
    }

    @Override
    public
    void run() {
        int newData;
        for (int i = 0; i < 1000000; i++) {
            newData = (int)(Math.random()*1000000);
            list.addFirst(newData);
            System.out.println("新的数据"+newData+"\t已经被加入到LinkedList");
        }
        try {
            sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
class Cleaner extends Thread{
    private LinkedList<Integer> list;

    public Cleaner(LinkedList<Integer> list) {
        this.list = list;
        this.setDaemon(true);
    }

    @Override
    public
    void run() {
        if(list.size() > 10){
            for (int i = 0; i < 2; i++) {
                list.removeLast();
                System.out.println("两个数据已被移除。");
            }
        }
    }
}