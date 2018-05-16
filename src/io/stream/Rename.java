package io.stream;
/**
 * 09_尚学堂_高淇_JAVA基础300集最全教程_char_字符串入门_boolean.mp4
 */

import java.io.File;

public class Rename {
    public static void main(String[] args) {
//        File srcFolder = new File("E:\\视频\\编程语言\\Java\\尚学堂视频\\尚学堂高淇java300集(280-300)【手写SORM框架】\\");
//        File[] files = srcFolder.listFiles();
//
//        int count = 0;
//
//        for (File file :
//                files) {
//            String name = file.getName();
//            if (name.endsWith(".mp4") || (name.endsWith(".flv")) || (name.endsWith(".wmv")) || (name.endsWith(".avi"))){
//                System.out.println(name);
//                int index = name.indexOf("_");
//                int endIndex = name.indexOf("程");
//                String newName = removeCharAt(name,index,endIndex);
//                System.out.println(newName);
//                count++;
//                System.out.println(file.renameTo(new File(srcFolder,newName)));
//            }
//        }
//        System.out.println(count);
    }
    public static String removeCharAt(String s, int begin, int end) {
        return s.substring(0, begin) + s.substring(end + 1);
    }
}
