package com.itheima.test2;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Test2 {
    public static void main(String[] args) throws IOException {
       // int count = 0;//第一次运行代码的时候,定义了一个count
                      //第二次运行代码的时候,重新定义了一个count
       // count++;

        //1.先把文件中的数据读到集合中
        BufferedReader br = new BufferedReader(new FileReader("names.txt"));
        String line;
        ArrayList<String> list = new ArrayList<>();
        while((line = br.readLine())!=null){
            list.add(line);
        }
        br.close();
        System.out.println(list);


        //读取本程序已经运行了多少次.
        BufferedReader brCount = new BufferedReader(new FileReader("count.txt"));
        String countStr = brCount.readLine();
        //表示程序已经运行了多少次.
        int count = Integer.parseInt(countStr);
        brCount.close();

        //表示当前程序又运行了一次.
        count++;

        if(count == 3){
            System.out.println("张三");
        }else{
            //2.随机获取一个索引
            Random r = new Random();
            int index = r.nextInt(list.size());
            //3.通过随机索引获取元素
            String name = list.get(index);
            System.out.println(name);
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter("count.txt"));
        //是不能直接写一个count的值.
        bw.write(count + "");//表示先将数字变成字符串,然后将字符串原样写出. 1
        bw.close();

    }
}
