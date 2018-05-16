package io.bases;

import java.io.File;
import java.io.FilenameFilter;
/*
 * 在遍历的同时选中符合条件的文件
 */
public class Search02 {
    public static void main(String[] args) {
        File file = new File("E:\\图集");

        String[] files = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                File file1 = new File(dir, name);
//                boolean flag1 = file1.isFile();
//                boolean flag2 = Name.endsWith(".jpg");
//                return flag1 && flag2;
                return file1.isFile() && name.endsWith(".jpg");
            }
        });
        for (String st :
                files) {
            System.out.println(st);
        }
    }
}
