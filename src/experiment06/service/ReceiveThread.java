package experiment06.service;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveThread implements Runnable {
        private DatagramSocket receive;

        public ReceiveThread(DatagramSocket receive) {
            this.receive = receive;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    byte[] bytes = new byte[1024];
                    DatagramPacket dp = new DatagramPacket(bytes, 0, bytes.length);
                    receive.receive(dp);
                    String ip = dp.getAddress().getHostAddress();
                    String info = new String(dp.getData(), 0, dp.getLength());

                }
            } catch (IOException  e) {
                e.printStackTrace();
            }
        }
}
