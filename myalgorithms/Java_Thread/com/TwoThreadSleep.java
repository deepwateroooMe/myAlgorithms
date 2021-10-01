package com;

public class TwoThreadSleep extends Thread {
    public void run() {
        loop();
    }

    public void loop() {
        String name = Thread.currentThread().getName();
        System.out.println("---->> enter its loop() method: " + name);
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("name: " + name);
            }
            System.out.println("name ----> leave loop(): " + name);
        }
    }
}

