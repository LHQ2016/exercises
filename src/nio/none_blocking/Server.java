package nio.none_blocking;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class Server implements Runnable {
    private Selector selector;

    private ByteBuffer readbuf = ByteBuffer.allocate(1024);


    public Server(int port) {
        try {
            this.selector = Selector.open();
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.configureBlocking(false);
            ssc.bind(new InetSocketAddress(port));
            ssc.register(this.selector, SelectionKey.OP_ACCEPT);

            System.out.println("Servet start, port: " + port);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

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
                    } //end of if (key.isValid())
                }//end of while(keys.hasNext())
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }//end of while(true)
    }

    private void read(SelectionKey key) {
        this.readbuf.clear();
        SocketChannel sc = (SocketChannel) key.channel();
        try {
            int count = sc.read(this.readbuf);
            if (count == -1){
                key.channel().close();
                key.cancel();
                return;
            }
            this.readbuf.flip();
            byte[] bytes = new byte[this.readbuf.remaining()];
            this.readbuf.get(bytes);
            String body = new String(bytes).trim();
            System.out.println("Server："+body);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void accept(SelectionKey key) {
        try {
            ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
            SocketChannel sc = ssc.accept();
            sc.configureBlocking(false);
            sc.register(this.selector, SelectionKey.OP_READ);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Thread(new Server(8765)).start();
    }//end of main
}
