package com;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;

public class UnionFind {

    int [] pare;
    int [] rank;
    int n;
    int cnt;
    
    public UnionFind(int x) {
        n = x;
        cnt = n;
        pare = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            pare[i] = i;
        }
        // pare[0] = -1;
        Arrays.fill(rank, 0);
        // rank[0] = -1;
    }

    public int find(int val) {
        //System.out.println("val: " + val);
        
        while (val != pare[val]) {
            pare[val] = pare[pare[val]];
            val = pare[val];
        }
        return val;
    }

    public void merge(int p, int q) {
        int rp = find(p);
        int rq = find(q);
        // System.out.println("rp: " + rp);
        // System.out.println("rq: " + rq);
        // System.out.println("(rank[rp] < rank[rq]): " + (rank[rp] < rank[rq]));

        // if (rank[rp] < rank[rq]) {
        //     swap(rp, rq);
        // }
        pare[rq] = rp;
        rank[rp] += rank[rq];
        --cnt;

        // System.out.println("pare.length: " + pare.length);
        // for (int z = 0; z < pare.length; ++z) 
        // System.out.print(pare[z] + ", ");
        // System.out.println("");
        // System.out.println("rank.length: " + rank.length);
        // for (int z = 0; z < rank.length; ++z) 
        // System.out.print(rank[z] + ", ");
        // System.out.println("cnt: " + cnt);
    }

    public boolean sameGroup(int x, int y) {
        // System.out.println("pare.length: " + pare.length);
        // for (int z = 0; z < pare.length; ++z) 
        //     System.out.print(pare[z] + ", ");
        // System.out.println("");
        return find(x) == find(y);
    }
    
    public int getCnt() {
        return cnt;
    }

    private void swap(int x, int y) {
        int tmp = x;
        x = y;
        y = tmp;
    }

    // public static void main(String[] args) {
    //     Solution s = new Solution();

    //     int [] a = new int [] {};
    //     TreeNode root = new TreeNode(a[0]);
    //     root.buildTree(root, a);
    //     root.levelPrintTree(root);

    //     TreeNode res = s.(root );
    //     res.levelPrintTree(res);
    // }
}