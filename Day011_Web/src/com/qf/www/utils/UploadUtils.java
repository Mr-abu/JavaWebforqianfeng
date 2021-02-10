package com.qf.www.utils;

import java.io.File;
import java.util.HashMap;
import java.util.UUID;

public class UploadUtils {
    //为每一个上传的文件生成唯一的文件名
    //重名容易发生覆盖
    public static String newFileName(String fileName) {
        return UUID.randomUUID().toString().replaceAll("-","")+"_"+fileName;
    }

//    public static void main(String[] args) {
//        System.out.println(newFileName("q123"));
//    }

    //2.为防止一个目录下文件过多 hash算法打散
    public static String newFilePath(String basePath, String fileName) {
        //1.拿到文件的hashCode
        int hashCode = fileName.hashCode();
        //2.哈希码进行&运算， 生成2级目录
        int path2 = hashCode&15;
        //3.三级目录
        int path3 = (hashCode>>4)&15;
        //4.将一级 +二级 +三级 生成一个新的完整的目录
        String newPath = basePath + File.separator + path2 + File.separator + path3;
        File file = new File(newPath);
        if (! file.exists()) {
            file.mkdirs();  //注意：mkdirs可以创建多层目录 ，mkdir只能创建一层 。这里是Mkdirs
        }
        return newPath;
    }

    public static void getFileList(String path, HashMap<String, String> fileNames) {
        //1.路径当成文件对象
        File file = new File(path);
        //获取该目录（upload）下所有的内容，包括了文件夹或文件
        File[] files = file.listFiles();
        if (files != null ) {
            for (File file1 : files) {
                //如果是文件夹，递归
                if (file1.isDirectory()) {
                    getFileList(file1.getPath(), fileNames);
                } else {
                    String name = file1.getName();
                    //拿到UUID和源文件名称拼比_的下标
                    int index = name.indexOf("_");
                    //截取
                    String fileName = name.substring(index + 1);
                    //把需要的存放在集合里
                    fileNames.put(name, fileName);
                }
            }
        }
    }

}
