package nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class ChannelDemo {
    public static void main(String[] args) throws IOException {
        RandomAccessFile fromFile = new RandomAccessFile(".\\src\\resource\\txt\\speak.txt","rw");
        FileChannel fromchannel = fromFile.getChannel();

        RandomAccessFile toFile = new RandomAccessFile("./src/resource/txt/tofile.txt","rw");
        FileChannel tochannel = toFile.getChannel();

        long pos = 0L;
        tochannel.transferFrom(fromchannel,pos,fromchannel.size());

    }//end of main
}
