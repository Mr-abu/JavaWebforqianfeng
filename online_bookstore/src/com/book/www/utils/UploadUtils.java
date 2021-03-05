package com.book.www.utils;

import java.io.File;
import java.util.UUID;

public class UploadUtils {
    public static String newFileName(String fileName) {
        return UUID.randomUUID().toString().replaceAll("-","")+"_"+fileName;
    }

    public static String newFilePath(String basePath ,String fileName) {

        //1.拿到文件名称的hash码
        int hashCode = fileName.hashCode();
        //2.哈希码进行&运算，生成二级目录
        int path2 = hashCode&15;
        //3.三级目录
        int path3 = (hashCode>>4)&15;
        //4.将一级+二级+三级  生成一个完整的目录
        String newPath = basePath+ File.separator +path2 + File.separator +path3;
        File file = new File(newPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        return newPath;
    }


    public static void main(String[] args) {
        System.out.println(newFileName("123.jsp"));
    }
}
