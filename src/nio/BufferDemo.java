package nio;

import java.nio.IntBuffer;
import java.util.Random;

public class BufferDemo {
    public static void main(String[] args) {
        Random random = new Random();
        IntBuffer buf = IntBuffer.allocate(10);
        for (int i = 0; i < 5; i++) {
            buf.put(random.nextInt(30));
        }//end of for
        System.out.println(buf);
        buf.flip(); //将pos置为0
        for (int i = 0; i < buf.limit(); i++) {
            System.out.print(buf.get(i) + "  ");
        }//end of for
        System.out.println("\n_______________");
        buf.clear(); //clear清除数据
        System.out.println("调用clear方法后，buf改变：" + buf);
        for (int i = 0; i < buf.limit(); i++) {
            System.out.print(buf.get(i) + "  ");
        }
        System.out.println();

        System.out.println("调用compact方法后，buf改变：" + buf);
    }//end of main
}
