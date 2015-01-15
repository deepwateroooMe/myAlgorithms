package com;

import java.util.Queue;
import java.util.LinkedList;

// maxPathSum

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) {
        val = x;
    }

    public void buildTree(TreeNode root, int [] a) {
        if (a == null || a.length == 0) return;
        TreeNode curr = root;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(curr);
        int idx = 1;
        while (!queue.isEmpty() && idx < a.length) {
            curr = queue.poll();
            while (curr.val == -1) curr = queue.poll();
            if (idx % 2 == 1) { // left
                if (a[idx] != -1) {
                    curr.left = new TreeNode(a[idx]); 
                    queue.add(curr.left);
                    //} else curr.left = null;
                } else {
                    curr.left = new TreeNode(-1);
                    queue.add(curr.left);
                }
                idx++;
            }
            if (idx < a.length && idx % 2 == 0) {  // right
                if (a[idx] != -1) {
                    curr.right = new TreeNode(a[idx]); 
                    queue.add(curr.right);
                    //} else curr.right = null;
                } else {
                    curr.right = new TreeNode(-1);
                    queue.add(curr.right);
                }
                idx++;
            }
        }
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
    
    public void levelPrintTree(TreeNode root) {
        TreeNode tmp = root;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(tmp);
        TreeNode curr;
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
