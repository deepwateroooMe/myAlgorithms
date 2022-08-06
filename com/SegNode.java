package com;

import java.util.*;

public class SegNode {

    private int bgn;
    private int end;
    private int sum;
    private SegNode left;
    private SegNode right;
    public SegNode(int bgn, int end, int sum, SegNode left, SegNode right) {
        this.bgn = bgn;
        this.end = end;
        this.sum = sum;
        this.left = left;
        this.right = right;
    }

    private SegNode root;
        
    public SegNode(SegNode r, int[] nums) {
        root = r;
//        buildTree(r, nums, 0, nums.length-1);
        buildTree(nums, 0, nums.length - 1);
        levelPrintTree(root); 
    }
    
    public void update(int index, int val) {
        updateTree(root, index, val);
    }
    
    public int sumRange(int left, int right) {
        return sumRangeFromTree(root, left, right);
    }
    private int sumRangeFromTree(SegNode r, int i, int j) {
        if (r == null || j < r.bgn || i > r.end) return 0;
        else if (i <= r.bgn && j >= r.end) return r.sum;
        else {
            return sumRangeFromTree(r.left, i, j) + sumRangeFromTree(r.right, i, j);
        }
    }
    private void updateTree(SegNode r, int i, int va) {
        if (r == null || i < r.bgn || i > r.end) return;
        else if (r.bgn == r.end && r.bgn == i) r.sum = va; // 需要更新的节点是根本身，整棵树只有一个节点
        else {
            updateTree(r.left, i, va);
            updateTree(r.right, i, va);
            int sum = 0;
            if (r.left != null) sum += r.left.sum;
            if (r.right != null) sum += r.right.sum;
            r.sum = sum;
        }
    }
    private SegNode buildTree(int [] arr, int i, int j) { // i : start; j : end
        if (i > j) return null;
        else if (i == j)
            return new SegNode(i, i, arr[i], null, null);
        else {
            int mid = i + (j-i)/2;
            SegNode left = buildTree(arr, i, mid);
            SegNode right = buildTree(arr, mid+1, j);
            int sum = left.sum;
            if (right != null) sum += right.sum;
            return new SegNode(i, j, sum, left, right);
        }
    }

    public void levelPrintTree(SegNode root) {
        SegNode tmp = root;
        Queue<SegNode> queue = new LinkedList<SegNode>();
        queue.add(tmp);
        System.out.println("\nTREE Level order traversal: \n");
        System.out.print("                  {[" + tmp.bgn + "," + tmp.end + ")," + tmp.sum + "}  -> root\n");
        System.out.print("    ");
        SegNode curr;
        int levelCnt = 1;
        int recnt = 0, tmpcnt = 0;
        while (!queue.isEmpty()) {
            while (recnt < levelCnt) {
                curr = queue.poll();
                ++recnt;
                if (curr.left != null) {
                    queue.add(curr.left);
                    System.out.print("      {[" + curr.left.bgn + "," + curr.left.end + ")," + curr.left.sum + "}");
                    // System.out.print(curr.left.val + ", ");
                    ++tmpcnt;
                } else
                    System.out.print("#.");
                if (curr.right != null) {
                    queue.add(curr.right);
                    System.out.print("      {[" + curr.right.bgn + "," + curr.right.end + ")," + curr.right.sum + "}");
                    // System.out.print(curr.right.val + ", ");
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
         
// public static void main(String[] args) {
        
//     // int [] a = new int [] {1, 3, 5}; 
//     int []  a = new int []  {0, 9, 5, 7, 3}; 

//     NumArray s = new NumArray(a);

//     int r0 = s.sumRange(4, 4);
//     System.out.println("r0: " + r0);

//     int r2 = s.sumRange(2, 4);
//     System.out.println("r2: " + r2);

//     // int r3 = s.sumRange(3, 3);
//     // System.out.println("r: " + r3);

//     // s.update(1, 2);
        
//     // int r = s.sumRange(0, 2);
//     // System.out.println("r: " + r);
        
// }
