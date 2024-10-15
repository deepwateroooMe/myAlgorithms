package com;

import java.util.Queue;
import java.util.LinkedList;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;
    public TreeNode(int x) {
        val = x;
    }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public TreeNode pp, qq;
        
    public void buildTree(TreeNode root, int [] a) {
        if (a == null || a.length == 0) return;
        TreeNode curr = root;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(curr);
        int idx = 1;
        while (!queue.isEmpty() && idx < a.length) {
            curr = queue.poll();
            if (idx % 2 == 1) { 
                if (a[idx] != -1) {
                    curr.left = new TreeNode(a[idx]); 
                    queue.add(curr.left);
                } else curr.left = null;
                /*
                  } else {  //
                  curr.left = new TreeNode(-1);
                  queue.add(curr.left);
                  } */  //
                idx++;
            }
            if (idx < a.length && idx % 2 == 0) {  // right
                if (a[idx] != -1) {
                    curr.right = new TreeNode(a[idx]); 
                    queue.add(curr.right);
                } else curr.right = null;
                /*
                  } else {  //
                  curr.right = new TreeNode(-1);
                  queue.add(curr.right);
                  } */ //
                idx++;
            }
        }
    }

    public void buildTree(TreeNode root, int [] a, int x) {
        if (a == null || a.length == 0) return;
        TreeNode curr = root;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(curr);
        int idx = 1;
        while (!queue.isEmpty() && idx < a.length) {
            curr = queue.poll();
            //while (curr.val == -1) curr = queue.poll();    //
            if (idx % 2 == 1) { // left
                if (a[idx] != -1) {
                    curr.left = new TreeNode(a[idx]); 
                    queue.add(curr.left);
                    if (a[idx] == x) {
                        pp = curr.left;
                    }
                    // } else if (a[idx] == y) {
                    //     qq = curr.left;
                    // }
                } else curr.left = null;
                /*
                } else {  //
                    curr.left = new TreeNode(-1);
                    queue.add(curr.left);
                    } */  //
                idx++;
            }
            if (idx < a.length && idx % 2 == 0) {  // right
                if (a[idx] != -1) {
                    curr.right = new TreeNode(a[idx]); 
                    queue.add(curr.right);
                    if (a[idx] == x) {
                        pp = curr.right;
                    }
                    // } else if (a[idx] == y) {
                    //     qq = curr.right;
                    // }
                } else curr.right = null;
                /*
                } else {  //
                    curr.right = new TreeNode(-1);
                    queue.add(curr.right);
                    } */ //
                idx++;
            }
        }
        if (x == root.val) pp = root;
        // if (y == root.val) qq = root;
    }

    public void buildTree(TreeNode root, int [] a, int x, int y) {
        if (a == null || a.length == 0) return;
        TreeNode curr = root;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(curr);
        int idx = 1;
        while (!queue.isEmpty() && idx < a.length) {
            curr = queue.poll();
            //while (curr.val == -1) curr = queue.poll();    //
            if (idx % 2 == 1) { // left
                if (a[idx] != -1) {
                    curr.left = new TreeNode(a[idx]); 
                    queue.add(curr.left);
                    if (a[idx] == x) {
                        pp = curr.left;
                    } else if (a[idx] == y) {
                        qq = curr.left;
                    }
                } else curr.left = null;
                /*
                  } else {  //
                  curr.left = new TreeNode(-1);
                  queue.add(curr.left);
                  } */  //
                idx++;
            }
            if (idx < a.length && idx % 2 == 0) {  // right
                if (a[idx] != -1) {
                    curr.right = new TreeNode(a[idx]); 
                    queue.add(curr.right);
                    if (a[idx] == x) {
                        pp = curr.right;
                    } else if (a[idx] == y) {
                        qq = curr.right;
                    }
                } else curr.right = null;
                /*
                  } else {  //
                  curr.right = new TreeNode(-1);
                  queue.add(curr.right);
                  } */ //
                idx++;
            }
        }
        if (x == root.val) pp = root;
        if (y == root.val) qq = root;
    }

    public void preOrderPrintTree(TreeNode root) {
        if (root == null) return;
        TreeNode curr = root;
        if (curr.val != -1)
            System.out.print(curr.val + ", ");
        else
            System.out.print("#, ");

        if (curr.left != null)
            preOrderPrintTree(curr.left);
        if (curr.right != null)
            preOrderPrintTree(curr.right);
    }

    public void inOrderPrintTree(TreeNode root) {
        if (root == null) return;
        TreeNode curr = root;
        if (curr.left != null)
            inOrderPrintTree(curr.left);
        if (curr.val != -1)
            System.out.print(curr.val + ", ");
        else
            System.out.print("#, ");
        if (curr.right != null)
            inOrderPrintTree(curr.right);
    }
    
    public void postOrderPrintTree(TreeNode root) {
        if (root == null) return;
        TreeNode curr = root;
        if (curr.left != null)
            postOrderPrintTree(curr.left);
        if (curr.right != null)
            postOrderPrintTree(curr.right);
        if (curr.val != -1)
            System.out.print(curr.val + ", ");
        else
            System.out.print("#, ");
    }

    public void levelPrintTree(TreeNode root) {
        TreeNode tmp = root;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(tmp);
        System.out.println("\nTREE Level order traversal: \n");
        System.out.print("      " + tmp.val + " -> root\n");
        System.out.print("    ");
        TreeNode curr;
        int levelCnt = 1;
        int recnt = 0, tmpcnt = 0;
        while (!queue.isEmpty()) {
            // System.out.print("    ");
            while (recnt < levelCnt) {
                curr = queue.poll();
                ++recnt;
                // if (curr.val != -1 && tmpcnt > 1 && recnt < levelCnt)
                //     System.out.print(curr.val + ", ");
                // else
                // System.out.print("#, ");
                if (curr.left != null) {
                    queue.add(curr.left);
                    System.out.print(curr.left.val + ", ");
                    ++tmpcnt;
                } else
                    System.out.print("#.");
                if (curr.right != null) {
                    queue.add(curr.right);
                    System.out.print(curr.right.val + ", ");
                    ++tmpcnt;
                } else
                    System.out.print("#| ");
            }
            System.out.print(" -> \n");
            levelCnt = tmpcnt;
            tmpcnt = 0;
            recnt = 0;
        }
        System.out.println("");
    }
}
