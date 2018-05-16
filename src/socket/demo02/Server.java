package socket.demo02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(8888);
        while (true) {
            Socket client = server.accept();
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());
            DataInputStream dis = new DataInputStream(client.getInputStream());

            try {
                while (true) {
                    String msg = dis.readUTF();
                    dos.writeUTF("服务器转发--->" + msg);
                    dos.flush();
//                    dos.writeUTF("服务器退出");
//                    dos.flush();
//                    System.exit(0);
                }//end while
            } finally {
                CloseUtil.closedAll(dos, dis, client);
            }
        }//end while
    }//end main
}