package expriment.experiment08;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class RandomPort {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            ServerSocket serverSocket = new ServerSocket(5555);
            serverSocket.setSoTimeout(1000);
            socket = serverSocket.accept();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
