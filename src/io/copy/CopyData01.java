package io.copy;

import java.io.*;

/**
 * 源文件 .\src\resource\aaa.txt ———> 读取数据 ————>  .\src\resource\bbb.txt
 * 4种方式复制文件
 * 1. 字节流一次复制一个字节
 * 2. 字节流一次复制一个字节数组
 * 3. buffer字符流一次复制一个字节
 * 4. buffer字符流一次复制一个字节数组
 */
public class CopyData01 {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        method1(".\\src\\resource\\aaa.txt", ".\\src\\resource\\txt\\bbb.txt");
//        method2(".\\src\\resource\\aaa.txt", ".\\src\\resource\\txt\\bbb.txt");
//        method3(".\\src\\resource\\aaa.txt", ".\\src\\resource\\txt\\bbb.txt");
//        method4(".\\src\\resource\\aaa.txt", ".\\src\\resource\\txt\\bbb.txt");

        long endTime = System.currentTimeMillis();
        System.out.println("共耗时：" + (endTime - startTime));
    }

    private static void method1(String srcfile, String targetFile) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(srcfile);
        FileOutputStream fileOutputStream = new FileOutputStream(targetFile);
        int by = 0;
        while ((by = fileInputStream.read()) != -1) {
            fileOutputStream.write(by);
        }

        fileInputStream.close();
        fileOutputStream.close();
    }

    private static void method2(String srcfile, String targetFile) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(srcfile);
        FileOutputStream fileOutputStream = new FileOutputStream(targetFile);
        byte[] bys = new byte[1024];
        int len = 0;
        while ((len = fileInputStream.read(bys)) != -1) {
            fileOutputStream.write(bys, 0, len);
        }
        fileOutputStream.close();
        fileInputStream.close();
    }

    private static void method3(String srcfile, String targetFile) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream
                (new FileOutputStream(srcfile));
        BufferedInputStream bis = new BufferedInputStream
                (new FileInputStream(targetFile));
        int by = 0;
        while ((by = bis.read()) != -1) {
            bos.write(by);
        }
        bis.close();
        bos.close();

    }

    private static void method4(String srcfile, String targetFile) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream
                (new FileOutputStream(srcfile));
        BufferedInputStream bis = new BufferedInputStream
                (new FileInputStream(targetFile));
        byte[] bys = new byte[1024];
        int len = 0;
        while ((len = bis.read(bys)) != -1) {
            bos.write(bys, 0, len);
        }

        bos.close();
        bis.close();
    }
}
