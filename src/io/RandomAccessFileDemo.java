package io;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {
    public static void main(String[] args) throws IOException {
        write();
        read();

    }

    private static void write() throws IOException {
        RandomAccessFile raf = new RandomAccessFile(".\\src\\resource\\txt\\ccc.txt", "rw");
        raf.writeInt(40);
        raf.writeChar('a');
        raf.writeUTF("中国");
    }

    private static void read() throws IOException {
        RandomAccessFile raf = new RandomAccessFile(".\\src\\resource\\txt\\ccc.txt", "rw");

        System.out.println(raf.readInt());
        System.out.println("当前文件指针位置：" + raf.getFilePointer());//int类型占4个字节
        System.out.println(raf.readChar());
        System.out.println("当前文件指针位置：" + raf.getFilePointer());//char占2个字节
        System.out.println(raf.readUTF());
        System.out.println("当前文件指针位置：" + raf.getFilePointer());//每个utf-8字符占3个字节，但需要两个字节进行记录
        raf.seek(7);
        System.out.println(raf.read());
        System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId());
//        System.out.println((char)40);
        System.out.println(2 << 1);

    }
}
