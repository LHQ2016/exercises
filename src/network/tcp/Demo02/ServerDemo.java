package network.tcp.Demo02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(12542);

        Socket s = ss.accept();

        InputStream is = s.getInputStream();
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        System.out.println("Server---" + new String(bytes, 0, len));

        OutputStream os = s.getOutputStream();
        os.write("�������յ�".getBytes());

        s.close();
    }
}
