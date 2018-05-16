package io.bases;

import java.io.File;

public class DeleteDir {
    public static void main(String[] args) {
        File srcFolder = new File("F:\\Demo");
        deleteDir(srcFolder);
    }

    private static void deleteDir(File srcFolder) {

        File[] files = srcFolder.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                deleteDir(file);
            }
            else{
                System.out.println(file.getName()+"是否删除"+file.delete());
            }
        }
        System.out.println(srcFolder.getName()+"是否删除"+srcFolder.delete());
    }
}
