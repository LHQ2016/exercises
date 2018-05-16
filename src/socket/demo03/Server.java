package socket.demo03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private List<MyChannel> lists = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        new Server().start();
    }//end main

    public void start() throws IOException {
        ServerSocket server = new ServerSocket(8888);
        while (true) {
            Socket client = server.accept();
            MyChannel channel = new MyChannel(client);
            lists.add(channel);
            new Thread(channel).start();
        }
    }

    private class MyChannel implements Runnable {

        private DataInputStream dis;
        private DataOutputStream dos;
        private boolean isRunning = true;

        public MyChannel(Socket client) {
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());
            } catch (IOException e) {
                CloseUtil.closedAll(dos, dis, client);
                isRunning = false;
            }
        }

        public String receive() {
            String msg = "";
            try {
                msg = dis.readUTF();
            } catch (IOException e) {
                CloseUtil.closedAll(dis);
                isRunning = false;
                lists.remove(this);
            }
            return msg;
        }

        private void send(String msg) {
            if (null == msg && msg.equals("")) {
                return;
            }
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                CloseUtil.closedAll(dos);
                isRunning = false;
                lists.remove(this);
            }
        }

        private void sendAll() {
            String msg = this.receive();
            for (MyChannel others : lists) {
                if (others == this) {
                    continue;
                }
                others.send(msg);
            }
        }

        @Override
        public void run() {
            while (isRunning) {
//            send(receive());
                sendAll();
            }
        }
    }
}