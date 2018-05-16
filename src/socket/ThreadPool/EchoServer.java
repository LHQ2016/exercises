package socket.ThreadPool;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * 使用JDK线程池类进行通信
 */
public class EchoServer {
    private  int port = 8000;
    private ServerSocket serverSocket;
    private ExecutorService executorService;
    private final int POOL_SIZE = 4;

    public EchoServer() throws IOException {
        serverSocket = new ServerSocket(port);
        executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()*POOL_SIZE);
        System.out.println("服务器启动");
    }
    public void service(){
        while (true){
            Socket socket= null;
            try{
                socket = serverSocket.accept();
                executorService.execute(new Handler(socket));
            }catch(IOException e ){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new EchoServer().service();
    }
}

class Handler implements Runnable{
    private Socket socket;

    public Handler(Socket socket) {
        this.socket = socket;
    }
    private PrintWriter getWriter(Socket socket)throws IOException{
        OutputStream socketOut = socket.getOutputStream();
        return new PrintWriter(socketOut,true);
    }

    private BufferedReader getRedaer(Socket socket) throws IOException{
        InputStream socketIn = socket.getInputStream();
        return new BufferedReader(new InputStreamReader(socketIn));
    }

    public String echo(String msg){
        return msg;
    }

    @Override
    public void run() {
        try{
            System.out.println("New connection accepted"+socket.getInetAddress()+":"
            +socket.getPort());
            BufferedReader br = getRedaer(socket);
            PrintWriter pw = getWriter(socket);

            String msg = null;
            while ((msg = br.readLine()) != null){
                System.out.println(msg);
                pw.println(echo(msg));
                if (msg.equalsIgnoreCase("BYE")){
                    break;
                }
            }
        }catch(IOException  e ){
            e.printStackTrace();
        }finally{
            try{
                if (socket != null)socket.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
