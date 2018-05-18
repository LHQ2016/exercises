package expriment.experiment06.udp.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendThread implements Runnable {
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
