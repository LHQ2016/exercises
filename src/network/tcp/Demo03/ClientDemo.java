package network.tcp.Demo03;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket(InetAddress.getByName("Chenzi"),11111);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        String line = null;

        while ((line = br.readLine()) != null){
            if ("exit".equals(line)){//键盘录入数据惊醒自定义结束标记
                break;
            }
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

//        bw.close();
//        br.close();
        s.close();
    }
}
