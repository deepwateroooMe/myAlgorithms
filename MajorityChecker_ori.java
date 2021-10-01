// package com;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class MajorityChecker {
    // System.out.print("                  {[" + tmp.bgn + "," + tmp.end + ")," + tmp.cnt + "}  -> root\n");
    // System.out.print("      {[" + curr.left.bgn + "," + curr.left.end + ")," + curr.left.val + "}");
    // System.out.print("      {[" + curr.left.bgn + "," + curr.left.end + ")," + curr.left.val + "}");
    // System.out.print("      {[" + curr.right.bgn + "," + curr.right.end + ")," + curr.right.val + "}");
    public void levelPrintTree(Node root) {
        Node tmp = root;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(tmp);
        System.out.println("\nTREE Level order traversal: \n");
        System.out.print("                  {[" + tmp.bgn + "," + tmp.end + "],(" + tmp.val + "," + tmp.cnt + ")}  -> root\n");
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
                    System.out.print(" {[" + curr.left.bgn + "," + curr.left.end + "],(" + curr.left.val + "," + curr.left.cnt + ")}");
                    ++tmpcnt;
                } else
                    System.out.print("[#####]");
                if (curr.right != null) {
                    queue.add(curr.right);
                    System.out.print(" {[" + curr.right.bgn + "," + curr.right.end + "],(" + curr.right.val + "," + curr.right.cnt + ")}");
                    ++tmpcnt;
                } else
                    System.out.print("[#####] | ");
            }
            System.out.print(" -> \n");
            levelCnt = tmpcnt;
            tmpcnt = 0;
            recnt = 0;
        }
        System.out.println("");
    }
    private class Node {
        private int bgn;
        private int end;
        private int val;
        private int cnt; // sum
        private Node left;
        private Node right;
        public Node(int bgn, int end, int val, int cnt) {
            this.bgn = bgn;
            this.end = end;
            this.val = val;
            this.cnt = cnt;
            this.left = null;
            this.right = null;
        }
        public Node(int bgn, int end, int val, int cnt, Node left, Node right) {
            this.bgn = bgn;
            this.end = end;
            this.val = val;
            this.cnt = cnt;
            this.left = left;
            this.right = right;
        }
    }
    public void update(int index, int val) {
        updateTree(root, index, val);
    }
    public int cntRange(int left, int right) {
        return cntRangeFromTree(root, left, right);
    }
    private int cntRangeFromTree(Node r, int i, int j) {
        if (r == null || i < r.bgn || i > r.end) return 0;
        else if (i <= r.bgn && j >= r.end) return r.cnt;
        else return cntRangeFromTree(r.left, i, j) + cntRangeFromTree(r.right, i, j);
    }
    private void updateTree(Node r, int i, int va) {
        if (r == null || i < r.bgn || i > r.end) return;
        else if (r.bgn == r.end && r.bgn == i) r.cnt = va; 
        else {
            updateTree(r.left, i, va);
            updateTree(r.right, i, va);
            int cnt = 0;
            if (r.left != null) cnt += r.left.cnt;
            if (r.right != null) cnt += r.right.cnt;
            r.cnt = cnt;
        }
    }
    private Node buildTree(int [] arr, int i, int j) { 
        if (i > j) return null;
        else if (i == j)
            return new Node(i, i, arr[i], 1);
        else {
            int mid = i + (j-i)/2;
            Node left = buildTree(arr, i, mid);
            Node right = buildTree(arr, mid+1, j);
            if (left.val == right.val)
                return new Node(i, j, left.val, left.cnt + right.cnt, left, right);
            else {
                if (left.cnt > right.cnt)
                    return new Node(i, j, left.val, left.cnt-right.cnt, left, right);
                else return new Node(i, j, right.val, right.cnt-left.cnt, left, right);
            }
        }
    }
    // 排序数组中 第一个大于tar的下标
    int upper_bound(List<Integer> list, int tar) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = l + (r-l)/2;
            if (list.get(mid) <= tar) l = mid+1;
            else r = mid;
        }
        return l;
    }
    // 排序数组中 第一个大于等于tar的下标
    int lower_bound(List<Integer> list, int tar) {
        int l = 0, r = list.size()-1;
        while (l < r) {
            int mid = l + (r-l)/2;
            if (list.get(mid) < tar) l = mid+1;
            else r = mid;
        }
        return l;
    }
    /**
     * 构建线段树
     * @param arr 被构建数组
     * @param l 构建节点的左值 表示查询区域左边界
     * @param r 构建节点的右值 表示查询区域右边界
     * @return 以构建完成的线段树节点
     * */
    private SegTreeNode buildTree(int[] arr, int l, int r) {
        if (l > r) return null;
        // 初始一个线段树节点
        SegTreeNode root = new SegTreeNode(l, r);
        // 叶子节点
        if (l == r) {
            // 众数就是当前值 计数为1
            root.val = arr[l]; root.count = 1;
            return root;
        }
        
        int mid = (l+r)/2;
        // 构建左子节点
        root.left = buildTree(arr, l, mid);
        // 构建右子节点
        root.right = buildTree(arr, mid+1, r);
        // 整合父节点
        makeRoot(root);
        return root;
    }
    /**
     * 整合一个父节点
     * @param root 被整合节点
     * */
    private void makeRoot(SegTreeNode root) {
        if (null == root) return;
        // 如果该节点有左子节点 该节点的值"先"等于左子节点
        if (root.left != null) {
            root.val = root.left.val;
            root.count = root.left.count;
        }
        // 如果该节点还有右子节点 融合父节点和子节点
        if (root.right != null) {
            if (root.val == root.right.val) 
                root.count = root.count + root.right.count;
            else {
                if (root.count >= root.right.count) 
                    root.count = root.count - root.right.count;
                else {
                    root.val = root.right.val; 
                    root.count = root.right.count - root.count;
                }
            }
        }
    }    
    /**
     * 查询线段树
     * @param root 被查询节点
     * @param l 需要查询的范围左边界
     * @param r 需要查询的范围右边界
     * */
    private void searchSegTree(Node root, int l, int r) {
        if (root == null || l > r) return;
        if (root.bgn > r || root.end < l) return;
        
        // 当查询边界 覆盖 节点边界 该节点就是查询区域
        if (root.bgn >= l && root.end <= r) {
            if (key == root.val) cnt += root.cnt;
            else if (cnt <= root.cnt) {
                key = root.val;
                cnt = root.cnt - cnt;
            } else cnt = cnt - root.cnt;
            return;
        }
        
        int mid = (root.end + root.bgn)/2;
        // root.bgn <= l <= mid 左节点也可以是查询区域
        if (l <= mid)  // 这两个查询条件再好好想想 ！！！！！！！！！！！！！！！
            searchSegTree(root.left, l, r);
        // mid+1 <= r <= root.end 右节点也可以是查询区域
        if (r >= mid+1) 
            searchSegTree(root.right, l, r);
    }
// https://books.halfrost.com/leetcode/ChapterFour/1100~1199/1157.Online-Majority-Element-In-Subarray/ 也有一个直观图
// https://www.cnblogs.com/slowbirdoflsh/p/11381565.html 思路比较清晰
    HashMap<Integer, List<Integer>> idx = new HashMap<>();
    private Node root;
    int key = 0, cnt = 0;
    public MajorityChecker(int[] arr) {
        root = buildTree(arr, 0, arr.length-1);
        levelPrintTree(root);
        idx = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!idx.containsKey(arr[i]))
                idx.put(arr[i], new ArrayList<>());
            idx.get(arr[i]).add(i);
        }
    }
    public int countRangeSum(int[] nums, int lower, int upper) {
        MajorityChecker mc = new MajorityChecker(nums);
    }
    public int query(int left, int right, int threshold) {
        // 初始化 所查询众数key 及辅助判断的计数cnt
        key = 0; cnt = 0;
        // 查询线段树
        searchSegTree(root, left, right);
        // 如果查询区域没有众数 即key没被更改
        // 或者
        // 所查询出来的众数 在原数组中根本没有超出阈值的能力
        System.out.println("key: " + key);
        System.out.println("(idx.get(key) == null): " + (idx.get(key) == null));
        
        if (key == 0 || idx.get(key).size() < threshold) return -1;
        
        // 上确界 排序数组中 第一个大于right的下标
        int r = upper_bound(idx.get(key), right);
        // 下确界 排序数组中 第一个大于等于left的下标
        int l = lower_bound(idx.get(key), left);
        cnt = r - l;
        return cnt >= threshold ? key : -1;
    }

    
    
    public static void main(String[] args) {
        // int []  a = new int []  {1,  1,  2,  2,  1,  1}; 
        int []  a = new int []  {1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1}; 

        MajorityChecker s = new MajorityChecker(a);
        int r = s.query(3, 12, 6);
        System.out.println("r: " + r);
        
    }
}
