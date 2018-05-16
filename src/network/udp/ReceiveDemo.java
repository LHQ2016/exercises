package network.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 利用UDP接收数据
 * A.创建接收端Socket对象
 * B.创建一个数据打包用于接收数据包
 * C.调用Socket对象的接收方法接收数据包
 * D.解析数据包，并显示在控制台
 * E.释放资源
 */
public class ReceiveDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(23232);

        byte[] bytes = new byte[1024];
        int length = bytes.length;
        DatagramPacket dp = new DatagramPacket(bytes, length);

        ds.receive(dp);

        byte[] bys = dp.getData();
        int len = dp.getLength();
        InetAddress address = dp.getAddress();
        String ip = address.getHostAddress();
        System.out.println("IP为" + ip + "传送的数据是" + new String(bys, 0, len));

        ds.close();

    }
}
