package io.copy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class CopyData11 {
    private static final int BSIZE = 10240;

    public static void main(String[] args) throws IOException {
        long starttime = System.currentTimeMillis();
        File file = new File(".\\src\\resource\\aaa\\03、版本控制SVN&GIT.rar");
        System.out.println(file.length()/1024/1024+"MB");
        method1(".\\src\\resource\\aaa\\03、版本控制SVN&GIT.rar",
                ".\\src\\resource\\aaa\\test.rar", BSIZE);
        long endtime = System.currentTimeMillis();
        System.out.println("使用FileInputStream的数组(数组大小为)" + BSIZE + "复制方式，用时：" + (endtime - starttime) + "ms");
        starttime = System.currentTimeMillis();
        method2(".\\src\\resource\\aaa\\03、版本控制SVN&GIT.rar",
                ".\\src\\resource\\aaa\\test1.rar");
        endtime = System.currentTimeMillis();
        System.out.println("使用 FileChannel + Buffer(缓冲区大小为)" + BSIZE + "复制方式，用时：" + (endtime - starttime)  + "ms");
        starttime = System.currentTimeMillis();
        method3(".\\src\\resource\\aaa\\03、版本控制SVN&GIT.rar", ".\\src\\resource\\aaa\\test.rar");
        endtime = System.currentTimeMillis();
        System.out.println("使用 FileChannel + MappedByteBuffer复制方式，用时：" + (endtime - starttime)  + "ms");

    }//end main


    private static void method1(String srcfile, String targetFile, int size) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(srcfile);
        FileOutputStream fileOutputStream = new FileOutputStream(targetFile);
        byte[] bys = new byte[size];
        int len = 0;
        while ((len = fileInputStream.read(bys)) != -1) {
            fileOutputStream.write(bys, 0, len);
        }
        fileOutputStream.close();
        fileInputStream.close();
    }

    private static void method2(String srcFile, String targetFile) throws IOException {

        FileChannel in = new FileInputStream(srcFile).getChannel(),
                out = new FileOutputStream(targetFile).getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        while ((in.read(buffer)) != -1) {
            buffer.flip();//做好被写的准备
            out.write(buffer);
            buffer.clear();//做好被读的准备
        }

    }

    private static void method3(String srcFile, String targetFile) throws IOException {

        FileInputStream fis = new FileInputStream(srcFile);
        FileOutputStream fos = new FileOutputStream(targetFile);
        FileChannel fc = fis.getChannel();
        MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
        mbb.flip();
        fos.flush();
        fc.close();
        fis.close();

    }
}
