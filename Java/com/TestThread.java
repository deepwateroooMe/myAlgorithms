package com;

//public class TestThread extends Thread {
public class TestThread implements Runnable {

    private int tickets = 20;
    
    public void run() {
        //for (int i = 0; i < 10; i++) {
        /*
          try {
          Thread.sleep(10);                 //1000 milliseconds is one second.
          } catch(InterruptedException ex) {
          Thread.currentThread().interrupt();
          }
          // now I believe the thread is working because of produced interleaving string....
          */
        while (true) {
            if (tickets > 0) {
                try {
                    Thread.sleep(10);                 //1000 milliseconds is one second.
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                System.out.println(Thread.currentThread().getName() + "selling ticket " + tickets--);
            }
        }
    }
}
