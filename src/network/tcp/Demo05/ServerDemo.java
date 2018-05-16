package network.tcp.Demo05;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ServerDemo {
    public static void main(String[] args) throws IOException {

        Set set = new HashSet();
        ServerSocket ss = new ServerSocket(15151);

        Socket s = ss.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

//        BufferedWriter bw = new BufferedWriter(new FileWriter(".\\src\\resource\\txt\\15151.txt"));

        String line = null;

        while ((line = br.readLine()) != null){
//            bw.write(line);
//            bw.newLine();
//            bw.flush();
            set.add(line);
        }
//        bw.close();
//        Object[] sets = set.toArray();
        for (Object str : set) {
            System.out.println(str);

        }

//        Iterator it1 = set.iterator();
//        while(it1.hasNext()){
//            System.out.println(it1.next());
//        }
        s.close();

    }
}
