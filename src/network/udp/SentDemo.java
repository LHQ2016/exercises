package network.udp;
/**
 * 利用UDP发送数据
 * A.创建发送端Socket对象
 * B.创建数据，并将数据打包
 * C.调用Socket对象的发送方法发送数据包
 * D.释放资源
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SentDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();

        byte[] bytes = "hello, java".getBytes();
        int length = bytes.length;
        InetAddress address = InetAddress.getByName("172.20.65.244");
        int port = 23232;
        DatagramPacket dp = new DatagramPacket(bytes, length, address, port);

        ds.send(dp);

        ds.close();

    }
}
