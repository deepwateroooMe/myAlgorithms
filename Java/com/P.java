package com;

public class P {
    public String name = "li si";
    public String sex = "female";
    public synchronized void set(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }
    public synchronized void get() {
        System.out.println(this.name + "---->" + this.sex);
    }
}
