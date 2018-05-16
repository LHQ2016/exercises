package experiment.sum;

import java.util.concurrent.Callable;

class Task implements Callable<Long> {
    int start;
    int end;

    public Task(){}
    public Task(int start,int end){
        this.start = start;
        this.end=end;
    }

    public Long call() throws Exception {
        long result = 0;
        for (int i = start; i < end; i++) {
            result += Array.disorder[i];
        }
        return result;
    }
}