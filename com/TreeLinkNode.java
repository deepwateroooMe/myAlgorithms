package com;

import java.util.Queue;
import java.util.LinkedList;

public class TreeLinkNode {
    public int val;
    public TreeLinkNode left, right, next;
    
    public TreeLinkNode(int x) {
        val = x;
    }

    public void buildTree(TreeLinkNode root, int [] a) {
        if (a == null || a.length == 0) return;
        TreeLinkNode curr = root;
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.add(curr);
        int idx = 1;
        while (!queue.isEmpty() && idx < a.length) {
            curr = queue.poll();
            while (curr.val == -1) curr = queue.poll();
            if (idx % 2 == 1) { // left
                if (a[idx] != -1) {
                    curr.left = new TreeLinkNode(a[idx]); 
                    queue.add(curr.left);
                    //} else curr.left = null;
                } else {
                    curr.left = new TreeLinkNode(-1);
                    queue.add(curr.left);
                }
                idx++;
            }
            if (idx < a.length && idx % 2 == 0) {  // right
                if (a[idx] != -1) {
                    curr.right = new TreeLinkNode(a[idx]); 
                    queue.add(curr.right);
                    //} else curr.right = null;
                } else {
                    curr.right = new TreeLinkNode(-1);
                    queue.add(curr.right);
                }
                idx++;
            }
        }
    }

    public void preOrderPrintTree(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode curr = root;
        if (curr.val != -1)
            System.out.print(curr.val + ", ");
        else
            System.out.print("#, ");

        if (curr.left != null)
            preOrderPrintTree(curr.left);
        if (curr.right != null)
            preOrderPrintTree(curr.right);
    }

    public void inOrderPrintTree(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode curr = root;
        if (curr.left != null)
            inOrderPrintTree(curr.left);
        if (curr.val != -1)
            System.out.print(curr.val + ", ");
        else
            System.out.print("#, ");
        if (curr.right != null)
            inOrderPrintTree(curr.right);
    }
    
    public void levelPrintTree(TreeLinkNode root) {
        TreeLinkNode tmp = root;
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.add(tmp);
        TreeLinkNode curr;
        System.out.println("");
        while (!queue.isEmpty()) {
            curr = queue.poll();
            if (curr.val != -1)
                System.out.print(curr.val + ", ");
            else
                System.out.print("#, ");
            if (curr.left != null)
                queue.add(curr.left);
            if (curr.right != null)
                queue.add(curr.right);
        }
        System.out.println("");
    }

}
