package io.bases;

import java.io.File;
import java.io.IOException;

public class FirstDir {
    public static void main(String[] args) throws IOException {
        File file1 = new File(".\\src\\resource\\aaa");
        System.out.println("aaa是否创建" + file1.mkdir());
        File file2 = new File(".\\src\\resource\\b.txt");
        System.out.println("b.txt是否创建" + file2.createNewFile());
//        File file3 = new File(".\\src\\resource\\222\\111");
//        System.out.println(file3.mkdirs());
//        file1.delete();
//        file2.delete();
//        file3.delete();

        //重命名要先将名称包装成类,如果名称为绝对路径则将其剪切到对应的路径下
//        File file4 = new File(".\\src\\resource\\红楼梦.txt");
//        File file5 = new File(".\\src\\resource\\三国演义.txt");
        //将file4改为file5
//        System.out.println(file4.renameTo(file5));
        System.out.println("b.txt is File？: " + file2.isFile());
        System.out.println("b.txt is Directory？: " + file2.isDirectory());
        System.out.println("b.txt is Absolute ？: " + file2.isAbsolute()); //创建时是否以绝对路径创建
        System.out.println("b.txt exists？: " + file2.exists());
        System.out.println("b.txt canRead？: " + file2.canRead());
        System.out.println("b.txt Path: " + file2.getPath());   //创建时的路径
        System.out.println("b.txt路径：" + file2.getAbsolutePath());    //创建时的路径
        System.out.println("b.txt路径：" + file2.getAbsoluteFile());    //创建时的路径
        System.out.println("b.txt路径：" + file2.getCanonicalPath());   //获取绝对路径
    }
}
