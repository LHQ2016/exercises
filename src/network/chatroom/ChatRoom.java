package network.chatroom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ChatRoom {
    public static void main(String[] args) throws IOException {
        DatagramSocket dsSend = new DatagramSocket(); //发送数据端
        DatagramSocket dsReceive = new DatagramSocket(23232); //数据接收端

        SendThread sendThread = new SendThread(dsSend);
        ReceiveThread receiveThread = new ReceiveThread(dsReceive);

        Thread send = new Thread(sendThread);
        Thread receive = new Thread(receiveThread);

        send.start();
        receive.start();
    }
}

class SendThread implements Runnable {
    private DatagramSocket sendsocket;

    public SendThread(DatagramSocket sendsocket) {
        this.sendsocket = sendsocket;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            while ((line = br.readLine()) != null) {
                if ("exit".equals(line)) {
                    System.exit(0);
                }
                byte[] bytes = line.getBytes();
                DatagramPacket dp = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("Chenzi"), 23232);
                sendsocket.send(dp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sendsocket.close();
        }
    }
}

class ReceiveThread implements Runnable {
    private DatagramSocket receivesocket;

    public ReceiveThread(DatagramSocket receivesocket) {
        this.receivesocket = receivesocket;
    }

    @Override
    public void run() {
        try {
            while (true) {
                byte[] bytes = new byte[1024];
                DatagramPacket dp = new DatagramPacket(bytes, 0, bytes.length);
                receivesocket.receive(dp);
                String ip = dp.getAddress().getHostAddress();
                String info = new String(dp.getData(), 0, dp.getLength());
                System.out.println("from " + ip + "data is " + info);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}