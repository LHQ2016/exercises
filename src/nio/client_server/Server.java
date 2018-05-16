package nio.client_server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;

public class Server implements Runnable {

    private Selector selector;

    private ByteBuffer readbuf = ByteBuffer.allocate(1024);

    public Server(int port) {
        try {
            this.selector = Selector.open();
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.configureBlocking(false);   //设置为非阻塞方式
            ssc.bind(new InetSocketAddress(port));
            ssc.register(this.selector, SelectionKey.OP_ACCEPT);
            System.out.println("Server start, port:" + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }   //end of Server

    @Override
    public void run() {
        while (true) {
            try {
                this.selector.select();
                Iterator<SelectionKey> keys = this.selector.selectedKeys().iterator();
                while (keys.hasNext()) {
                    SelectionKey key = keys.next();
                    keys.remove();
                    if (key.isValid()) {
                        if (key.isAcceptable()) {
                            this.accept(key);
                        }
                        if (key.isReadable()) {
                            this.read(key);
                        }
                    }//end of  if (key.isValid())
                }//end of while (keys.hasNext())
            } catch (IOException e) {
                e.printStackTrace();
            }
        }//end of while(true)
    }

    private void read(SelectionKey key) {
    }

    private void accept(SelectionKey key) {
    }
}
