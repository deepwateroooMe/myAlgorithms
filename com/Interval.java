package com;

import java.util.List;
import java.util.ArrayList;

public class Interval {
    public int start;
    public int end;
    public Interval() {
        start = 0;
        end = 0;
    }
    /*    
    public Interval Interval(int s, int e) {
        Interval res = new Interval();
        res.start = s;
        res.end = e;
        return res;
    }
    */
    public Interval(int s, int e) {
        start = s;
        end = e;
    }

    public ArrayList<Interval> buildInterval(Interval b, int [] a) {
        ArrayList<Interval> list = new ArrayList<Interval>();
        list.add(b);
        if (a.length == 2) return list;   

        //list.add(b);
        Interval tmp;
        for (int i = 2; i < a.length; i += 2) {
            tmp = new Interval(a[i], a[i+1]);
            list.add(tmp);
        }
        return list;
    }

    public void printInterval(List<Interval> res) {
        for (int i = 0; i < res.size(); i++) 
            System.out.println(res.get(i).start + ", " + res.get(i).end);
        System.out.println("");
    }
}
