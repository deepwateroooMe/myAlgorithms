package com;

public class ThreadTest implements Runnable {
    public void run() {
        String str = new String();
        int i = 0;
        for (int x = 0; x < 100; x++) {
            System.out.println(Thread.currentThread().getName() + "---->> " + i++);
        }
    }
}
