package io.copy;

import java.io.*;

public class CopyFolder {
    public static void main(String[] args) throws IOException {
        File srcFolder = new File("E:\\Demo");
        File targetFolder = new File("E:\\test");

        if (!targetFolder.exists()) {
            targetFolder.mkdir();
        }

        File[] files = srcFolder.listFiles();

        for (File file :
                files) {
            String name = file.getName();
            File newFile = new File(targetFolder, name);
            copy(file, newFile);
            System.out.println(newFile.getName());
        }

    }

    private static void copy(File srcFolder, File newFile) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFolder));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(newFile));

        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }

        bis.close();
        bos.close();

    }
}
