// package com;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class MajorityChecker {
    public static class Solution {
        // System.out.print("                  {[" + tmp.bgn + "," + tmp.end + "],(" + tmp.val + "," + tmp.sum + ")}  -> root\n");
        // System.out.print(" {[" + curr.left.bgn + "," + curr.left.end + "],(" + curr.left.val + "," + curr.left.sum + ")}");
        // System.out.print(" {[" + curr.right.bgn + "," + curr.right.end + "],(" + curr.right.val + "," + curr.right.sum + ")}");
        public void levelPrintTree(Node root) {
            Node tmp = root;
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(tmp);
            System.out.println("\nTREE Level order traversal: \n");
            System.out.print("                  {[" + tmp.bgn + "," + tmp.end + ")," + tmp.val + "}  -> root\n");
            System.out.print("    ");
            Node curr;
            int levelSum = 1;
            int resum = 0, tmpsum = 0;
            while (!queue.isEmpty()) {
                while (resum < levelSum) {
                    curr = queue.poll();
                    ++resum;
                    if (curr.left != null) {
                        queue.add(curr.left);
                        System.out.print("      {[" + curr.left.bgn + "," + curr.left.end + ")," + curr.left.val + "}");
                        ++tmpsum;
                    } else
                        System.out.print("[#####]");
                    if (curr.right != null) {
                        queue.add(curr.right);
                        System.out.print("      {[" + curr.right.bgn + "," + curr.right.end + ")," + curr.right.val + "}");
                        ++tmpsum;
                    } else
                        System.out.print("[#####] | ");
                }
                System.out.print(" -> \n");
                levelSum = tmpsum;
                tmpsum = 0;
                resum = 0;
            }
            System.out.println("");
        }
        private class Node {
            private int bgn;
            private int end;
            private int val;
            private Node left;
            private Node right;
            public Node(int bgn, int end, int val) {
                this.bgn = bgn;
                this.end = end;
                this.val = val;
                this.left = null;
                this.right = null;
            }
            public Node(int bgn, int end, int val, Node left, Node right) {
                this.bgn = bgn;
                this.end = end;
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }
        public void update(int index, int val) {
            updateTree(root, index, val);
        }
        public int sumRange(int left, int right) {
            return sumRangeFromTree(root, left, right);
        }
        private int sumRangeFromTree(Node r, int i, int j) {
            if (r == null || i < r.bgn || i > r.end) return 0;
            else if (i <= r.bgn && j >= r.end) return r.val;
            else return sumRangeFromTree(r.left, i, j) + sumRangeFromTree(r.right, i, j);
        }
        private void updateTree(Node r, int i, int va) {
            if (r == null || i < r.bgn || i > r.end) return;
            else if (r.bgn == r.end && r.bgn == i) r.val = va; 
            else {
                updateTree(r.left, i, va);
                updateTree(r.right, i, va);
                int sum = 0;
                if (r.left != null) sum += r.left.val;
                if (r.right != null) sum += r.right.val;
                r.val = sum;
            }
        }
        private Node buildTree(int [] arr, int i, int j) { 
            if (i > j) return null;
            else if (i == j)
                return new Node(i, i, arr[i]);
            else {
                int mid = i + (j-i)/2;
                Node left = buildTree(arr, i, mid);
                Node right = buildTree(arr, mid+1, j);
                return new Node(i, j, left.val + right.val, left, right);
            }
        }
        private Node root;
        public int countRangeSum(int[] nums, int lower, int upper) {
            root = buildTree(nums, 0, nums.length-1);
            int j = 0;
            int res = 0;
            int sum = 0;
            HashSet<Integer> s = new HashSet<>();
            while (j < nums.length) {
                for (int i = 0; i < nums.length; i++) {
                    sum = sumRange(i, Math.min(i+j, nums.length-1));
                    if (!s.contains(sum)){
                        s.add(sum);  
                        if (sum >= lower && sum <= upper) ++res;
                    } 
                }
                ++j;
            }
            return res;
        }
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();
        
        int []  a = new int []  {0}; 

        int r = s.countRangeSum(a, 0, 0);
        System.out.println("r: " + r);
        
    }
}
