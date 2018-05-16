package thread.Increase;

public
class Worker implements Runnable {
    private Data data;

    public
    Worker(Data data) {
        this.data = data;
    }

    @Override
    public
    void run() {
        while(true){
            data.increase();
        }
    }
}