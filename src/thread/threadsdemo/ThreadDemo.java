package thread.threadsdemo;

/**
 * 使用匿名内部类进行多线程程序的创建
 */
public class ThreadDemo {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                }
            }
        }.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    System.out.println(Thread.currentThread().getName() + "---" + i);
                }
            }
        }){
//            public void run() {
//                for (int i = 0; i < 50; i++) {
//                    System.out.println("hello" + "---" + i);
//                }
//            }
        }.start();

    }
}
