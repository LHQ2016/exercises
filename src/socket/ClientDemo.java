package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientDemo {

    public static void main(String[] args) {
        try {
            Socket socket=new Socket("127.0.0.1",4443);
            System.out.println("客户端已经连接.......");
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            PrintWriter write=new PrintWriter(socket.getOutputStream());
            BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //System.out.println(in.readLine());
            String line=br.readLine();
            //System.out.println(line);
            while(!line.equals("end")){
                //System.out.println(line);
                write.println("客户端1"+line);
                write.flush();
                System.out.println(in.readLine());
                line=br.readLine();
            }
            write.close();
            in.close();
            br.close();
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}