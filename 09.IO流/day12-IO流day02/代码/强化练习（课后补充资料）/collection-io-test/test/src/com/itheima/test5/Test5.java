package com.itheima.test5;

import java.io.*;

public class Test5 {
    public static void main(String[] args) throws IOException {
        //明确一件事情,拷贝,一定是从文件开始,到文件结束的.

        File src = new File("D:\\itheima\\src");
        File dest = new File("D:\\itheima\\dest");

        copy(src,dest);
    }

    private static void copy(File src, File dest) throws IOException {
        dest.mkdirs();//创建一个多级文件夹,如果文件夹存在,就创建失败,如果不存在就创建成功.

        //1.进入数据源文件夹,得到里面每一个文件和文件夹的路径
        File[] files = src.listFiles();
        //2.遍历
        for (File file : files) {
            //file依次表示src文件夹里面的每一个文件和文件夹的路径
            if(file.isFile()){
                //3.判断 --- 拷贝
                FileInputStream fis = new FileInputStream(file);
                FileOutputStream fos = new FileOutputStream(new File(dest,file.getName()));
                int b;
                while((b = fis.read()) != -1){
                    fos.write(b);
                }
                fis.close();
                fos.close();
            }else{
                //4.判断 --- 递归
                copy(file,new File(dest,file.getName()));
            }
        }






    }
}
