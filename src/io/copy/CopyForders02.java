package io.copy;

import java.io.*;

/**
 * 分析：
 * A:封装数据源File
 * B:封装目的地File
 * C:判断该File是文件夹还是文件
 * a:是文件夹
 * 就在目的地目录下创建该文件夹
 * 获取该File对象下的所有文件或者文件夹File对象
 * 遍历得到每一个File对象
 * 回到C
 * b:是文件
 * 就复制(字节流)
 */
public class CopyForders02 {
    public static void main(String[] args) throws IOException {
        File srcFolder = new File("E:\\IODemo\\Demo");
        File targetFolder = new File("E:\\IODemo\\test01");

        copyFolder(srcFolder, targetFolder);

    }

    private static void copyFolder(File srcFolder, File targetFolder) throws IOException {
        if (srcFolder.isDirectory()) {
            //目录处理
            File newFolder = new File(targetFolder, srcFolder.getName());//在目标目录下创建与srcFolder同名的目录
            newFolder.mkdirs();
            File[] filearray = srcFolder.listFiles();
            for (File file :
                    filearray) {
                copyFolder(file, newFolder);
            }
        } else {
            //文件处理
            File newFile = new File(targetFolder, srcFolder.getName());//在目标目录下创建与srcFolder同名的文件
            copyFile(srcFolder, newFile);
        }
    }

    private static void copyFile(File srcFile, File targetFile) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(targetFile));
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }
        bis.close();
        bos.close();
    }
}
