package network.tcp.Demo01;
/**
 * tcp实现网络套接字通信
 */

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        //将此处的"Chenzi"改为自己电脑的用户名或主使用下面第一种方式，第一字段是ip,第二是端口
//        Socket s = new Socket("192.168.137.1",55555)
        Socket s = new Socket(InetAddress.getByName("Chenzi"),55555);
        OutputStream os = s.getOutputStream();
        os.write("hello".getBytes());
        os.close();
    }
}
