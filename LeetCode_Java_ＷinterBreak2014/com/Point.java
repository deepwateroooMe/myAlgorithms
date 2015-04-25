package com;

public class Point {
    public int x;
    public int y;
    
    public Point() {
        x = 0;
        y = 0;
    }

    public Point(int a, int b) {
        x = a;
        y = b;
    }

    public Point [] buildArray(int [] src) {
        int n = src.length;
        Point [] res = new Point[n/2];
        int j = 0;
        for (int i = 0; i < n/2; i++) {
            res[i] = new Point(src[j++], src[j++]);
        }
        return res;
    }

    public void printPointArray(Point [] src) {
        for (int i = 0; i < src.length; i++) {
            System.out.println(src[i].x + ", " + src[i].y);
        }
        System.out.println("");
    }
}
