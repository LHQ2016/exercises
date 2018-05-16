package io.copy;

import java.io.*;

/**
 * 将E:\Demo\stream下的以.java结尾的文件复制到E:\Test并将起改名为以.jad结尾的文件
 * <p>
 * 分析：
 * A:封装目录
 * B:获取该目录下的所有文本的File数组
 * C:遍历File数组，得到每一个File对象
 * D:将该文件进行复制
 * E:在目的地目录下改名
 */
public class CopyFolders01 {
    public static void main(String[] args) throws IOException {
        File srcFolder = new File("E:\\Demo\\stream");
        File targetFolder = new File("E:\\Test01");

        if (!targetFolder.exists()) {
            targetFolder.mkdir();
        }
        //获取所有以.java结尾的文件
        File[] filearray = srcFolder.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir, name).isFile() && name.endsWith(".java");
            }
        });

        for (File file :
                filearray) {
//            System.out.println(file.getName());
            String name = file.getName();
            File newFile = new File(targetFolder, name);
            copy(file, newFile);
        }
        File[] targetarray = targetFolder.listFiles();
        for (File file :
                targetarray) {
//          E:\Test01\BufferedReaderDemo.java
            String name = file.getName();
            String newName = name.replace(".java",".jad");
            File newFile = new File(targetFolder,newName);
            file.renameTo(newFile);
        }

    }

    private static void copy(File file, File newFile) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(newFile));
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));

        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }
        bis.close();
        bos.close();
    }

}
