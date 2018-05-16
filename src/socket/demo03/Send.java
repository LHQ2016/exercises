package socket.demo03;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Send implements Runnable {

    private BufferedReader scan;
    private DataOutputStream dos;
    private boolean isRunning = true;

    public Send() {
        scan = new BufferedReader(new InputStreamReader(System.in));
    }

    public Send(Socket socket) {
        this();
        try {
            dos = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
//            e.printStackTrace();
            isRunning = false;
            CloseUtil.closedAll(dos, scan);
        }
    }

    private String getMsg() {
        try {
            return scan.readLine();
        } catch (IOException e) {
//            e.printStackTrace();
        }
        return "";
    }

    public void sendMsg() {
        String msg = getMsg();
        try {
            if (null != msg && !msg.equals("")) {
                if (msg.equalsIgnoreCase("bye")){
                    System.exit(0);
                }
                else {
                    dos.writeUTF(msg);
                    dos.flush();
                }
            }
        } catch (IOException e) {
            isRunning = false;
            CloseUtil.closedAll(dos, scan);
        }
    }

    @Override
    public void run() {
        while (isRunning) {
            sendMsg();
        }
    }
}
