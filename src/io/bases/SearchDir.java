package io.bases;

import java.io.File;

/*
 * 先获取所有文件再遍历
 */
public class SearchDir {
    public static void main(String[] args) {
        File file =new File("E:\\图集");//获取指定文件名结尾的文件
        File[] files = file.listFiles();
        for (File fi :
                files) {
            if (fi.isFile()){
                if (fi.getName().endsWith(".jpg")){
                    System.out.println(fi.getName());
                }
            }
            }
    }
}
