package network.tcp.Demo05;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class clientDemo {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket(InetAddress.getByName("Chenzi"), 15151);

        BufferedReader br = new BufferedReader(new FileReader(".\\src\\resource\\txt\\fighter.txt"));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

        String line = null;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        br.close();
        s.close();
    }
}
