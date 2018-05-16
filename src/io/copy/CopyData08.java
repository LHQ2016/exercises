package io.copy;

import java.io.*;

/**
 * 源文件 .\src\resource\aaa.txt ———> 读取数据 ————>  .\src\resource\111.txt
 * 5种文件复制方式（推荐掌握第五种）
 * 1. 字符流一次复制一个字符
 * 2. 字符流一次复制一个字符数组
 * 3. Buffered字符流复制一次复制一个字符
 * 4. Buffered字符流复制一次复制一个字符数组
 * 5. Buffered字符流特殊复制方法
 */
public class CopyData08 {
    public static void main(String[] args) throws IOException {
        String srcfile = ".\\src\\resource\\txt\\aaa.txt";
        String targetfile = ".\\src\\resource\\txt\\111.txt";
//        method1(srcfile, targetfile);
//        method2(srcfile, targetfile);
//        method3(srcfile, targetfile);
//        method4(srcfile, targetfile);
        method5(srcfile, targetfile);
    }

    private static void method1(String srcfile, String targetfile) throws IOException {
        FileReader fr = new FileReader(srcfile);
        FileWriter fw = new FileWriter(targetfile);
        int ch = 0;
        while ((ch = fr.read()) != -1) {
            fw.write(ch);
        }
        fr.close();
        fw.close();

    }

    private static void method2(String srcfile, String targetfile) throws IOException {
        FileReader fr = new FileReader(srcfile);
        FileWriter fw = new FileWriter(targetfile);
        int len = 0;
        char[] chs = new char[1024];
        while ((len = fr.read(chs)) != -1) {
            fw.write(new String(chs, 0, len));
        }
        fr.close();
        fw.close();
    }

    private static void method3(String srcfile, String targetfile) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(srcfile));
        BufferedWriter bw = new BufferedWriter(new FileWriter(targetfile));
        int ch = 0;
        while ((ch = br.read()) != -1) {
            bw.write(ch);
            bw.flush();
        }
        br.close();
        bw.close();

    }

    private static void method4(String srcfile, String targetfile) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(srcfile));
        BufferedWriter bw = new BufferedWriter(new FileWriter(targetfile));
        int len = 0;
        char[] chs = new char[1024];
        while ((len = br.read(chs)) != -1) {
            bw.write(new String(chs, 0, len));
            bw.flush();
        }


        br.close();
        bw.close();
    }

    private static void method5(String srcfile, String targetfile) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(srcfile));
        BufferedWriter bw = new BufferedWriter(new FileWriter(targetfile));

        String line = null;
        while ((line = br.readLine()) != null){
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        br.close();
        bw.close();

    }
}
