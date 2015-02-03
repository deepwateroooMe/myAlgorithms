package com;

public class Producer implements Runnable {
    P q = null;

    public Producer(P q) {
        this.q = q;
    }

    public void run() {
        int i = 0;
        while (true) {
            if (i == 0) {
                q.name = "zhang san";
                q.sex = "male";
            } else {
                q.name = "li si";
                q.sex = "female";
            }
            i = (i + 1) % 2;
        }
    }
}
