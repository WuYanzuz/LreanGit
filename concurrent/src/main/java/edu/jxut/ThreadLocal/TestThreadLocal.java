package edu.jxut.ThreadLocal;

public class TestThreadLocal {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        Thread thread2 = new Thread(new MyRunnable());

        thread.start();
        thread2.start();
    }
}
