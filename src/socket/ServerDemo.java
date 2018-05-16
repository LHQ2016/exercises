package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    private int port = 4443;

    public void setPort(int port) {
        this.port = port;
    }

    public int getPort() {
        return this.port;
    }

    public void servers() {
        try {
            ServerSocket server = new ServerSocket(this.getPort());
            int i = 0;
            while (true) {

                Socket socket = server.accept();
                i++;
                System.out.println("客户端" + i + "已经连接");

                new Thread(new ThreadServer(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        new ServerDemo().servers();
    }

}

class ThreadServer implements Runnable {
    private Socket socket;

    public ThreadServer(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return this.socket;
    }

    public void run() {
        BufferedReader in = null;
        PrintWriter write = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {

            write = new PrintWriter(this.socket.getOutputStream());

            in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            String str = in.readLine();

            while (!(str == null || str.equals("end") || str.equals(""))) {
                System.out.println(str);
                write.println("客户端（转发）" + str);
                write.flush();
                str = in.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                write.close();
                in.close();
                this.getSocket().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
