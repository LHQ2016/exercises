package expriment.experiment01.pi;

import java.util.concurrent.Callable;

public class Task implements Callable<Integer> {
    int count;

    public Task(){}
    public Task(int count){
        this.count = count;
    }

    public Integer call() throws Exception {
        double x,y;
        int ans=0;

        for(int i=0 ; i<count ; i++){
            x = Math.random();
            y = Math.random();
            if((x*x+y*y)<1){
                ans++;
            }
        }
        return ans;
    }
}
