package com;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;

public class Node {

    // public boolean val;
    // public boolean isLeaf;
    // public Node topLeft;
    // public Node topRight;
    // public Node bottomLeft;
    // public Node bottomRight;

    // public Node() {
    //     this.val = false;
    //     this.isLeaf = false;
    //     this.topLeft = null;
    //     this.topRight = null;
    //     this.bottomLeft = null;
    //     this.bottomRight = null;
    // }
    // public Node(boolean val, boolean isLeaf) {
    //     this.val = val;
    //     this.isLeaf = isLeaf;
    //     this.topLeft = null;
    //     this.topRight = null;
    //     this.bottomLeft = null;
    //     this.bottomRight = null;
    // }
    // public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
    //     this.val = val;
    //     this.isLeaf = isLeaf;
    //     this.topLeft = topLeft;
    //     this.topRight = topRight;
    //     this.bottomLeft = bottomLeft;
    //     this.bottomRight = bottomRight;
    // }
        
    // public void levelPrintTree(Node r) {
    //     Node p = r;
    //     Queue<Node> q = new LinkedList<>();
    //     q.add(p);
    //     System.out.println("\nTREE Level order traversal: \n");
    //     System.out.print("      [" + (p.isLeaf ? 1 : 0)+ ", "+ (p.val ? 1 : 0) + "]    -> root\n");
    //     // System.out.print("    ");
    //     int levelCnt = 1;
    //     int recnt = 0, tmpcnt = 0;

    //     while (!q.isEmpty()) {
    //         // System.out.println(" (recnt < levelCnt): " +  (recnt < levelCnt));
    //         while (recnt < levelCnt) {
    //             p = q.poll();
    //             ++recnt;
    //             if (!p.isLeaf) {
    //                 q.add(p.topLeft);
    //                 System.out.print("[" + (p.topLeft.isLeaf ? 1 : 0)+ ", "+ (p.topLeft.val ? 1 : 0) + "], ");
    //                 q.add(p.topRight);
    //                 System.out.print("[" + (p.topRight.isLeaf ? 1 : 0)+ ", "+ (p.topRight.val ? 1 : 0) + "], ");
    //                 q.add(p.bottomLeft);
    //                 System.out.print("[" + (p.bottomLeft.isLeaf ? 1 : 0)+ ", "+ (p.bottomLeft.val ? 1 : 0) + "], ");
    //                 q.add(p.bottomRight);
    //                 System.out.print("[" + (p.bottomRight.isLeaf ? 1 : 0)+ ", "+ (p.bottomRight.val ? 1 : 0) + "], ");
    //                 tmpcnt += 4;
    //             } else {
    //                 System.out.print("|####| ");
    //             }
    //             System.out.print(" -> \n");
    //         }
    //         levelCnt = tmpcnt;
    //         tmpcnt = 0;
    //         recnt = 0;
    //     }
    // }


    // public String val;
    // // public int dead;
    // public List<Node> children;
    // public Node() {}
    // public Node(String _val) {
    //     val = _val;
    //     // dead = 0;
    // }
    // public Node(String _val, List<Node> _children) {
    //     val = _val;
    //     children = _children;
    //     // dead = 0;
    // }
    public int val;
    public Node p;
    public boolean app;
    public int cnt;
    public List<Node> children;
    public Node() {}
    public Node(int _val) {
        val = _val;
        p = null;
        app = false;
        cnt = 0;
    }
    public Node(int _val, boolean app) {
        val = _val;
        this.app = app;
        if (app) cnt = 1;
    }
    public Node(int _val, Node p, List<Node> _children) {
        val = _val;
        this.p = p;
        children = _children;
    }
    
    public void levelPrintTree(Node root) {
        // System.out.println("(root == null): " + (root == null));
        Node tmp = root;
        Queue<Node> q = new LinkedList<Node>();
        q.add(tmp);
        System.out.println("\nNode tree Level order traversal: \n");
        // System.out.print("      " + tmp.val + " -> root\n");
        System.out.print("      [" + tmp.val + "," + tmp.cnt + "] -> root\n");
        System.out.print("    ");
        Node p;

        Node curr;
        int levelCnt = 1;
        int recnt = 0, tmpcnt = 0;
        while (!q.isEmpty()) {
            while (recnt < levelCnt) {
                p = q.poll();
                ++recnt;
                if (p.children != null) {
                    for (int i = 0; i < p.children.size(); i++) {
                        q.add(p.children.get(i));
                        // System.out.print(p.children.get(i).val + ", ");
                        System.out.print("[" + p.children.get(i).val + "," + p.children.get(i).cnt + "], ");
                        ++tmpcnt;
                    }
                } else {
                    System.out.print("=,");
                }
            }
            System.out.print(" -> \n");
            levelCnt = tmpcnt;
            tmpcnt = 0;
            recnt = 0;
        }
        System.out.println("");
    }
    // public void buildTree(Node root, int [] a) {
    //     Node p = root, r, tmp;
    //     //  0  1     2  3  4   5    6  7 
    //     // {1, null, 3, 2, 4, null, 5, 6}
    //     // [1, nul 2, 3, 4, 5, nul   nul 6, 7, nul 8, nul 9, 10, nul    nul 11, nul 12, nul 13, nul nul 14]
    //     //  0   1  2  3  4  5   6     7  8  9  10 11  12  13  14  15    16  17  18  19  20  21  22  23  24
    //     Queue<Node> q = new LinkedList<Node>();
    //     q.add(p);
    //     int idx = 2;
    //     int cnt = 1, tmpcnt = 0, levelCnt = 1;
    //     // System.out.println("idx: " + idx);
    //     // System.out.println("(!q.isEmpty() && idx < a.length): " + (!q.isEmpty() && idx < a.length));
    //     while (!q.isEmpty() && idx < a.length) {
    //         cnt = 0;
    //         List<Node> c = new ArrayList<>();
    //         // System.out.println("tmpcnt: " + tmpcnt);
    //         // System.out.println("levelCnt: " + levelCnt);
            
    //         while (!q.isEmpty() && tmpcnt < levelCnt) {
    //             // System.out.println("idx 000: " + idx );
                
    //             p = q.poll();
    //             // System.out.println("p.val: " + p.val);
                
    //             ++tmpcnt;
    //             while (idx <= a.length -1 && a[idx] != -1) {
    //                 r = new Node(a[idx]);
    //                 // System.out.println("r.val: " + r.val);
                    
    //                 c.add(r);
    //                 q.add(r);
    //                 ++cnt;
    //                 ++idx;
    //             }
    //             p.children = c;
    //             c = new ArrayList<>();
    //             while (tmpcnt < levelCnt && idx < a.length) {
    //                 while (idx <= a.length -1 && a[idx] == -1 && tmpcnt < levelCnt) {
    //                     ++idx;
    //                     tmp = q.poll();
    //                     p = tmp;
    //                     ++tmpcnt;
    //                     while (idx <= a.length -1 && a[idx] != -1) {
    //                         r = new Node(a[idx]);
    //                         System.out.println("r.val: " + r.val);
                    
    //                         c.add(r);
    //                         q.add(r);
    //                         ++cnt;
    //                         ++idx;
    //                     }
    //                     p.children = c;
    //                     c = new ArrayList<>();
    //                 }
    //             }
    //         }
    //         ++idx;
    //         if (idx >= a.length ) break;
    //         levelCnt = cnt;
    //         tmpcnt = 0;
    //     }    
    // }


    
    // public int val;
    // public Node prev;
    // public Node next;
    // public Node child;
    // public Node(int a) {
    //     val = a;
    // }
    
    // public void buildTree(Node root, int [] a) {
    //     Node p = root, tmp;
    //     //        0   1  2   3   4  5   6
    //     //        1,  2, 3,  4,  5, 6, -1,
    //     //       -1, -1, 7,  8,  9, 10, -1,
    //     //        7   8  9   10  11 12  13
    //     //               -1, 11, 12
    //     //               14  15  16
    //     Queue<Node> q = new LinkedList<Node>();
    //     q.add(root);
    //     int idx = 1, cnt = 0;
    //     while (!q.isEmpty() && idx < a.length) {
    //         cnt = 0;
    //         while (a[idx] != -1) {
    //             tmp = new Node(a[idx]);
    //             p.next = tmp;
    //             tmp.prev = p;
    //             q.add(tmp);
    //             p = tmp;
    //             ++idx;
    //         }
    //         ++idx; // level ended
    //         // System.out.println("idx: " + idx);
    //         // System.out.println("p.val: " + p.val);
            
    //         while (!q.isEmpty() && idx <= a.length-1) {
    //             while (a[idx] == -1) {
    //                 p = q.poll();
    //                 // System.out.println("p.val: " + p.val);
    //                 ++idx;
    //             }
    //             p = q.poll();
    //             // System.out.println("p.val: " + p.val);

    //             // System.out.println("idx: " + idx);
    //             tmp = new Node(a[idx]);
    //             p.child = tmp;
    //             // System.out.println("p.val: " + p.val);
    //             // System.out.println("tmp.val: " + tmp.val);
    //             q.clear();
    //             q.add(tmp);
    //             p = tmp;
    //             ++idx;
    //             // System.out.println("idx: " + idx);
    //             // System.out.println("p.val: " + p.val);
                
    //             while (idx <= a.length -1 && a[idx] != -1) {
    //                 Node r = new Node(a[idx]);
    //                 // System.out.println("r.val: " + r.val);
    //                 p.next = r;
    //                 r.prev = p;
    //                 q.add(r);
    //                 p = r;
    //                 ++idx;
    //             }
    //             // System.out.println("p.val: " + p.val);
    //             // System.out.println("idx E: " + idx);
    //             ++idx;
    //         }
    //         if (idx >= a.length ) break;
    //     }    
    // }
    
    // public void levelPrintTree(Node root) {
    //     Node tmp = root;
    //     Queue<Node> q = new LinkedList<Node>();
    //     q.add(tmp);
    //     System.out.println("\nNode tree Level order traversal:\n");
    //     Node p;
    //     Node curr;
    //     int levelCnt = 1;
    //     int recnt = 0, tmpcnt = 0, cnt = 0;

    //     while (!q.isEmpty() && tmpcnt < levelCnt) {
    //         p = q.poll();
    //         ++tmpcnt;
    //         q.add(p);
    //         ++cnt;
    //         while (p.next != null) {
    //             p = p.next;
    //             q.add(p);
    //             ++cnt;
    //         }
    //     }
    //     levelCnt = cnt;
    //     cnt = 0;
    //     tmpcnt = 0;
    //     while (!q.isEmpty()) {
    //         while (!q.isEmpty() && tmpcnt < levelCnt) {
    //             p = q.poll();
    //             System.out.print(p.val + ", ");
    //             ++tmpcnt;
    //             while (p.child == null && !q.isEmpty() && tmpcnt < levelCnt) {
    //                 p = q.poll();
    //                 System.out.print(p.val + ", ");
    //                 ++tmpcnt;
    //             }
    //             if (p.child != null) {
    //                 q.add(p.child);
    //                 ++cnt;
    //                 tmp = p.child.next;
    //                 if (tmp != null) {
    //                     q.add(tmp);
    //                     ++cnt;
    //                     while (tmp.next != null) {
    //                         tmp = tmp.next;
    //                         q.add(tmp);
    //                         ++cnt;
    //                     }
    //                 }
    //             }
    //         }
            
    //         System.out.print(" -> \n");
    //         levelCnt = cnt;
    //         tmpcnt = 0;
    //         cnt = 0;
    //     }
    //     System.out.println("");
    // }
    

};