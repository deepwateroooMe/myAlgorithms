package com;

public class TestThread implements Runnable {
    private int tickets = 200;
    
    public void run() {
        while (true) {
            sale();
        }
    }
    public synchronized void sale() {
        if (tickets > 0) {
            try {
                Thread.sleep(100);
            } catch(InterruptedException ex) {
            }                
            System.out.println(Thread.currentThread().getName() + " is selling ticket " + tickets--);
        }
    }
}
