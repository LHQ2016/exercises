package socket.demo01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(8888);
        Socket client = server.accept();

        DataInputStream dis = new DataInputStream(client.getInputStream());
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());

        try {
            while (true) {
                String msg = dis.readUTF();
                if (!msg.equalsIgnoreCase("bye")) {
                    dos.writeUTF("服务器转发--->" + msg);
                    dos.flush();
                }
                else {
//                    dos.writeUTF("服务器退出");
//                    dos.flush();
                    System.exit(0);
                }
            }//end while
        } finally {
            dis.close();
            dos.close();
            client.close();
        }
    }//end main
}
