package com;

public class TestThread implements Runnable {
    private int tickets = 200;
    private boolean bFlag = true;
    public void stopMe() {
        bFlag = false;
    }
    public void run() {
        while (bFlag) {
            //System.out.println(Thread.currentThread().getName() + " is running .....");
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
