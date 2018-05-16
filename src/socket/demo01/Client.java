package socket.demo01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket client = new Socket("localhost", 8888);
        Scanner scan = new Scanner(System.in);


        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        DataInputStream dis = new DataInputStream(client.getInputStream());
        try {
            while (true) {
                dos.writeUTF(scan.nextLine());
                dos.flush();
                System.out.println(dis.readUTF());
            }
        } catch (IOException e) {
//            e.printStackTrace();
            System.exit(0);
        } finally {
            dis.close();
            dos.close();
            client.close();
        }//end finally


    }//end main
}
