package thread.Increase;

public
class Data {
    int a = 0;
    int b = 0;

    public synchronized
    void increase() {
        a++;
        b++;
    }

    public synchronized
    void isEqual() {
        System.out.println("a=" + a + "\tb=" + b + "\t" + (a == b));
    }
}