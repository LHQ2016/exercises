package master_worker;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Master master = new Master(new Worker(),100000);
        Random random = new Random(10);
        for (int i = 1; i <= 100; i++) {
            Task task = new Task();
            task.setId(i);
            task.setName("task"+i);
            task.setPrice(random.nextInt());
            master.submit(task);
        }//end for
        master.execute();

        long start = System.currentTimeMillis();

        while (true){
            if (master.isComplete()){
                long ret = master.getResult();
                System.out.println("执行结果："+ ret+"，耗时："+(System.currentTimeMillis()-start));
                break;
            }
        }
    }//end main
}
