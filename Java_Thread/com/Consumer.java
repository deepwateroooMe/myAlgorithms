package com;

public class Consumer implements Runnable {
    P q = null;

    public Consumer(P q) {
        this.q = q;
    }

    public void run() {
        int i = 0;
        while (true) {
            System.out.println(q.name + "---->>" + q.sex);
        }
    }
}
