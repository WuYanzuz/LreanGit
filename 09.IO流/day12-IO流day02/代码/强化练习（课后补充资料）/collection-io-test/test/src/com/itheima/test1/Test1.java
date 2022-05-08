package com.itheima.test1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Test1 {
    //有一个文件里面存储了班级同学的姓名，每一个姓名占一行，要求通过程序实现随机点名器。
    public static void main(String[] args) throws IOException {
        //1.先把文件中的姓名读取到集合中.
        //字节流输入流 字节缓冲输入流  --- 拷贝 -- pass
        //字符输入流   字符缓冲输入流

        //单列 List(保留重复)
        ArrayList<String> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("names.txt"));
       String line;
       while((line = br.readLine()) != null){
           list.add(line);
       }
       br.close();
        System.out.println(list);

        //2.获取一个随机索引
        Random r = new Random();
        int index = r.nextInt(list.size());
        //3.通过这个随机索引获取对应的元素
        String name = list.get(index);
        System.out.println(name);
    }
}
