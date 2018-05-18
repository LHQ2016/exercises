package expriment.experiment07.client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
//        InetAddress ip = InetAddress.getLocalHost();//��ȡ����IP��ַ
//        System.out.println(ip);
        Socket s1 = new Socket(InetAddress.getLocalHost(), 15151);
        BufferedReader br = new BufferedReader(new FileReader(".\\src\\expriment.experiment07\\speak.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s1.getOutputStream()));

        Socket s2 = new Socket(InetAddress.getLocalHost(), 15152);
        OutputStream os = s2.getOutputStream();
//        InputStream is = s2.getInputStream();

        Socket s3 = new Socket(InetAddress.getLocalHost(), 15153);
        InputStream is = s3.getInputStream();

        Socket s4  = new Socket(InetAddress.getLocalHost(),15154);
        InputStream in = s4.getInputStream();

        String target = null;

        try {
            String line = null;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
                bw.flush();
            }
        } finally {
            s1.close();
            br.close();
        }
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        if (str.matches("sentense:([0-9]*,)*[0-9]*")) {
            //����sentense:
            target = str;
            try {
                os.write(target.getBytes());
            } finally {
                os.close();
            }
        } else if (str.matches("talk:.*")) {
            //����talk:��s3����ͨ��
            BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));      //����̨��ȡ����
            PrintWriter writer = new PrintWriter(s4.getOutputStream());  //��ͻ���д����
            BufferedReader reader = new BufferedReader(new InputStreamReader(s4.getInputStream()));
            try{

                String line = cin.readLine();
                while (!line.equals("exit")){
                    writer.println(line);
//                    writer.println("�ͻ���1"+line);
                    writer.flush();
                    line = reader.readLine();
                }
            }finally{
                writer.close();
                cin.close();
                reader.close();
                s4.close();
            }

        } else {
            System.out.println("�������˽��ܵ�sentense�ĸ�ʽ��sentense:1,2,3,4...");
            System.out.println("��������˵ĶԻ��ĸ�ʽ��talk:hello...");
            System.exit(0);
        }

        try {
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = is.read(bytes)) != -1) {
                System.out.print(new String(bytes, 0, len));
            }
        } finally {
            is.close();
        }
    }
}
