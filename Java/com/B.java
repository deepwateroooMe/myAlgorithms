package com;
//import com.A;

public class B {
    public synchronized void funB(A a) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " enter B.funB(A a)");
        try {
            Thread.sleep(1000);
        } catch (Exception ex) {
            System.out.println(e.getMessage());
        }
        System.out.println(name + "calling A's last() method");
        a.last();
    }
    
    public synchronized void last() {
        System.out.println("B's last() method definition");
    }
}
