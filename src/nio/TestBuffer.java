package nio;

import java.nio.IntBuffer;
import java.util.Random;

public class TestBuffer {
    public static void main(String[] args) {
        Random random = new Random();
        IntBuffer buf = IntBuffer.allocate(10);
        for (int i = 0; i < 5; i++) {
            buf.put(random.nextInt(50));
        }//end for
        buf.position(5);
        buf.mark();
        buf.flip();
//        buf.clear();
        System.out.println(buf);
        System.out.println("-----------");
        for (int i = 0; i < buf.limit(); i++) {
            System.out.println(buf.get(i));
        }//end for
        System.out.println("-----------");
        System.out.println(buf);
        System.out.println(buf.capacity());
        System.out.println(buf.limit());

    }//end main
}
