package com.itheima.test4;


import java.io.*;
import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) throws IOException {
        //这个是正确的用户名和密码
        String rightUsername = "zhangsan";
        String rightPassword = "123";
        User rightUser = new User(rightUsername,rightPassword);

        File file = new File("cookie.txt");

        User user = null;
        if(file.exists()){
            //存在 --- 表示本次是第二次或者多次登录
            //从本地读取数据
           user =  readUserInfo(file);
        }else{
            //不存在 --- 表示本次是第一次登录
            //键盘录入用户名和密码
            user = getUserInputInfo();
        }
        //比较两者是否一致
        if(rightUser.equals(user)){
            //一致,提示登录成功,需要将正确的用户名和密码写到本地文件,
            //目的:为了下次的自动登录.
            System.out.println("登录成功");
            if(!file.exists()){
                writeUser(user);
            }
        }else{
            //不一致,提示登录失败
            System.out.println("登录失败");
        }
    }

    private static User readUserInfo(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String usernameInfo = br.readLine();//username=zhangsan
        String passwordInfo = br.readLine();//password=123
        br.close();
        String username = usernameInfo.split("=")[1];
        String password = passwordInfo.split("=")[1];
        return new User(username,password);
    }

    private static void writeUser(User user) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("cookie.txt"));
        bw.write("username="+user.getUsername());
        bw.newLine();
        bw.write("password="+user.getPassword());
        bw.close();
    }

    private static User getUserInputInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();
        return new User(username,password);
    }


}
