package edu.jxut.ThreadLocal;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyRunnable implements Runnable{

    @Override
    public void run() {
        User user = UserThreadLocal.get();
        if (user==null){
            user = new User("张三", "14");
            UserThreadLocal.setUser(user);
        }
        System.out.println(user.getClass());
    }
}
