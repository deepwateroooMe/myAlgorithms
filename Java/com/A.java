package com;

import com.B;

public class A {
    public synchronized void funA(B b) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " enter A.funA(B b)");
        try {
            Thread.sleep(1000);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(name + "calling B's last() method");
        b.last();
    }

    public synchronized void last() {
        System.out.println("A's last() method definition");
    }
}
