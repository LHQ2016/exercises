package expriment.experiment07.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss1 = new ServerSocket(15151);
        ArrayList<String> list = new ArrayList<>();
        Socket s1 = ss1.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(s1.getInputStream()));

        ServerSocket ss2 = new ServerSocket(15152);
        Socket s2 = ss2.accept();
        InputStream is = s2.getInputStream();

        ServerSocket ss3 = new ServerSocket(15153);
        Socket s3 = ss3.accept();
        OutputStream os = s3.getOutputStream();

        ServerSocket ss4 = new ServerSocket(15154);
        Socket s4 = ss4.accept();

        String num;
        ArrayList<Integer> sendlist = new ArrayList<>();

        try {
            String line;
            while ((line = br.readLine()) != null) {
                String newString = line+"\r\n";
                list.add(newString);      //��������ӵ�������
            }
        } finally {
            s1.close();
        }
        //��֤���ظ�����
//        Iterator  iterator = list.iterator();
//        while (iterator.hasNext()) System.out.println(iterator.next());

        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        String string = new String(bytes, 0, len);
        try {
            //����sentense:1,2,3,...
            if (string.startsWith("sentense:")){
                num = string.substring(string.indexOf(":")+1);
                String[] numlist = num.split(",");
                for (String aNumlist : numlist) {
                    sendlist.add(Integer.parseInt(aNumlist));
                    System.out.print(Integer.parseInt(aNumlist) + " ");
                }
//                System.out.println();
                for (int i = 0; i < sendlist.size(); i++) {
                        os.write(list.get((sendlist.get(i))-1).getBytes());
                }
            }
            //����talk:���Ի����ݰ�װ��getOutputStream
            else if (string.startsWith("talk:")){
                //�Ƚ�client���͵����ݽ���
                //�ڽ�����ͻ��˵ĶԻ�����
                }
        }finally {
            s3.close();
            s2.close();
        }
    }




}
