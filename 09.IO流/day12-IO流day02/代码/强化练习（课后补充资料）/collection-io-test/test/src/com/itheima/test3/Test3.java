package com.itheima.test3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) throws IOException {
        //1.得到文件中正确的用户名和密码
        User rightUserInfo = getRightUserInfo();

        //2.得到用户键盘录入的用户名和密码
        User userInputInfo  = getUserInputInfo();

        //3.比较两者是否一致.
        //if(rightUserInfo.getUsername().equals(userInputInfo.getUsername())  && ){
        if(rightUserInfo.equals(userInputInfo)){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }
    }

    private static User getUserInputInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();
        return new User(username,password);
    }

    private static User getRightUserInfo() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("userinfo.txt"));
        String line = br.readLine();
        br.close();
        System.out.println(line);//username=zhangsan&password=123
        String[] split = line.split("&");
        //0索引:username=zhangsan
        //1索引:password=123
        String username = split[0].split("=")[1];
        String password = split[1].split("=")[1];
        //可以把用户名和密码封装成一个javabean对象,直接返回这个对象就可以了.
        return new User(username,password);
    }
}
