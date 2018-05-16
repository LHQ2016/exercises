package network.tcp.Demo02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket(InetAddress.getByName("Chenzi"), 12542);

        OutputStream os = s.getOutputStream();
        os.write("11223344556677889900".getBytes());

        InputStream is = s.getInputStream();
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        System.out.println("client--" + new String(bytes, 0, len));

        s.close();
    }
}
