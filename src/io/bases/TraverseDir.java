package io.bases;

import java.io.File;
import java.io.IOException;

public class TraverseDir {
    public static void main(String[] args) throws IOException {
        File srcFolder = new File("E:\\视频\\编程语言\\Java\\尚学堂视频");

        getAllPaths(srcFolder);
    }

    private static void getAllPaths(File srcFolder) throws IOException {
        File[] files = srcFolder.listFiles();
        int count = 0;
        for (File file :
                files) {
            if (file.isDirectory()) {
                getAllPaths(file);
            } else {

                if (file.getName().endsWith(".mp4") || file.getName().endsWith(".avi") || file.getName().endsWith("flv") || file.getName().endsWith("wmv")) {
                    System.out.println(file.getCanonicalPath());
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}

