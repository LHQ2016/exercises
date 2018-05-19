package nio.time;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class MultiplexerTimeServer implements Runnable {

    private Selector selector;
    private ServerSocketChannel servChannel;
    private volatile boolean isStoped;

    public MultiplexerTimeServer(int port) {
        try {
            selector = Selector.open();
            servChannel = ServerSocketChannel.open();
            servChannel.configureBlocking(false);
            servChannel.socket().bind(new InetSocketAddress(port), 1024);
            servChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("The time server ids start in port : " + port);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void stop() {
        this.isStoped = true;
    }

    @Override
    public void run() {

        while (true){
            try{
                selector.select(1000);

            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
    }
}
