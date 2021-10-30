// import com.UnionFind;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class NumArray {

    private class Node {
        private int bgn;
        private int end;
        private int sum;
        private Node left;
        private Node right;
        public Node(int bgn, int end, int sum, Node left, Node right) {
            this.bgn = bgn;
            this.end = end;
            this.sum = sum;
            this.left = left;
            this.right = right;
        }
    }

    private Node root;
        
    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length-1);
        levelPrintTree(root); 
    }
    
    public void update(int index, int val) {
        updateTree(root, index, val);
    }
    
    public int sumRange(int left, int right) {
        return sumRangeFromTree(root, left, right);
    }
    private int sumRangeFromTree(Node r, int i, int j) {
        if (r == null || j < r.bgn || i > r.end) return 0;
        else if (i <= r.bgn && j >= r.end) return r.sum;
        else {
            return sumRangeFromTree(r.left, i, j) + sumRangeFromTree(r.right, i, j);
        }
    }
    private void updateTree(Node r, int i, int va) {
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
    private Node buildTree(int [] arr, int i, int j) { // i : start; j : end
        if (i > j) return null;
        else if (i == j)
            return new Node(i, i, arr[i], null, null);
        else {
            int mid = i + (j-i)/2;
            Node left = buildTree(arr, i, mid);
            Node right = buildTree(arr, mid+1, j);
            int sum = left.sum;
            if (right != null) sum += right.sum;
            return new Node(i, j, sum, left, right);
        }
    }

    public void levelPrintTree(Node root) {
        Node tmp = root;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(tmp);
        System.out.println("\nTREE Level order traversal: \n");
        System.out.print("                  {[" + tmp.bgn + "," + tmp.end + ")," + tmp.sum + "}  -> root\n");
        System.out.print("    ");
        Node curr;
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

         
    public static void main(String[] args) {
        
        // int [] a = new int [] {1, 3, 5}; 
        int []  a = new int []  {0, 9, 5, 7, 3}; 

        NumArray s = new NumArray(a);

        int r0 = s.sumRange(4, 4);
        System.out.println("r0: " + r0);

        int r2 = s.sumRange(2, 4);
        System.out.println("r2: " + r2);

        // int r3 = s.sumRange(3, 3);
        // System.out.println("r: " + r3);


        // s.update(1, 2);
        
        // int r = s.sumRange(0, 2);
        // System.out.println("r: " + r);
        
    }
}

// ["NumArray","sumRange","sumRange","sumRange","update","update","update","sumRange","update","sumRange","update"]
// [[],[4,4],[2,4],[3,3],                        [4,5],[1,7],[0,8],         [1,2],[1,9],         [4,4],[3,4]]