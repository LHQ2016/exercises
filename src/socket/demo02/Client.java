package socket.demo02;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        InetAddress ip = InetAddress.getLocalHost();
        System.out.println(ip);
        Socket client = new Socket(ip,8888);
        new Thread(new Send(client)).start();
        new Thread(new Receive(client)).start();
    }

}
