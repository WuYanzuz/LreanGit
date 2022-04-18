package edu.jxut.ThreadLocal;

import lombok.Data;


public class UserThreadLocal {
    private static final ThreadLocal<User> LOCAL=new ThreadLocal<>();

    public static User get(){
        return LOCAL.get();
    }

    public static void setUser(User user){
        LOCAL.set(user);
    }

    /**
     * 删除当前线程中的User对象
     */
    public static void remove() {
        LOCAL.remove();
    }
}
