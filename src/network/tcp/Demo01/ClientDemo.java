package network.tcp.Demo01;
/**
 * tcpʵ�������׽���ͨ��
 */

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        //���˴���"Chenzi"��Ϊ�Լ����Ե��û�������ʹ�������һ�ַ�ʽ����һ�ֶ���ip,�ڶ��Ƕ˿�
//        Socket s = new Socket("192.168.137.1",55555)
        Socket s = new Socket(InetAddress.getByName("Chenzi"),55555);
        OutputStream os = s.getOutputStream();
        os.write("hello".getBytes());
        os.close();
    }
}
