package io.copy;

import java.io.*;


/**
 * 将.\src\resource下的CopydataDemo.java复制到桌面
 * 源数据 .src\resource\CopyData01.java — 目标 桌面
 */
public class CopyDate04 {
    public static void main(String[] args) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter
                (new FileOutputStream("C:\\Users\\李华强\\test.txt"));
        InputStreamReader inputStreamReader = new InputStreamReader
                (new FileInputStream(".\\src\\resource\\txt\\红楼梦.txt"));

        int ch = 0;
        while ((ch = inputStreamReader.read()) != -1){
            outputStreamWriter.write(ch);
        }

        char[] chs = new char[1024];
        int len = 0;
        while ((len = inputStreamReader.read(chs)) != -1){
            outputStreamWriter.write(chs,0,len);
            outputStreamWriter.flush();
        }
        inputStreamReader.close();
        outputStreamWriter.close();

        outputStreamWriter.close();
        inputStreamReader.close();
    }
}
