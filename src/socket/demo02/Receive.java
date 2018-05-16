package socket.demo02;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Receive implements Runnable {

    private DataInputStream dis;
    private boolean isRunning = true;

    public Receive() {
    }

    public Receive(Socket socket) {
        this();
        try {
            dis = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
//            e.printStackTrace();
            isRunning = false;
            CloseUtil.closedAll(dis);
        }
    }

    public String receiveMsg() {
        String msg = "";
        try {
            msg = dis.readUTF();
        } catch (IOException e) {
//            e.printStackTrace();
            isRunning = false;
            CloseUtil.closedAll(dis);
        }
        return msg;
    }

    @Override
    public void run() {
        while (isRunning) {
            System.out.println(receiveMsg());
        }

    }
}
