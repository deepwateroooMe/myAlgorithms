package com;

public class SleepInterrupt extends Thread {
    public void run() {
        try {
            System.out.println("in run() - this thread sleep 20 sec");
            Thread.sleep(20000);
            System.out.println("in run() - continue running...");
        } catch (InterruptedException e) {
            System.out.println("in run() - interrupt thread");
            return;
        }
        System.out.println("in run() - after sleep continuing...");
        System.out.println("in run(), quit normally");
    }
}

