package experiment07_1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ThreadedEchoServer {
    public static void main(String[] args) {
        try {
            int i = 0;
            ServerSocket s = new ServerSocket(8189);
            while (true) {
                Socket incoming = s.accept();
                System.out.println("Spawning " + i);
                Runnable t = new ThreadedEchoHandler(incoming);
                Thread r = new Thread(t);
                r.start();
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ThreadedEchoHandler implements Runnable {
    private Socket incoming;

    public ThreadedEchoHandler(Socket i) {
        incoming = i;
    }

    @Override
    public void run() {
        try {
            try {
                InputStream inStream = incoming.getInputStream();
                OutputStream outputStream = incoming.getOutputStream();
                Scanner in = new Scanner(inStream);
                PrintWriter out = new PrintWriter(outputStream, true);

                out.println("Hello! Enter BYE to exit.");
                boolean done = false;
                while (!done && in.hasNext()) {
                    String line = in.nextLine();
                    out.println("Echo: " + line);
                    if (line.trim().equals("BYE")) {
                        done = true;
                    }
                }
            } finally {
                incoming.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}