import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import java.util.HashSet;
import java.util.Set;
import static java.util.stream.Collectors.toMap;

public class cmp { 
    public static class Solution {

        // public int fillCups(int[] a) {
        //     int n = a.length, cnt = 0;
        //     Queue<Integer> q = new PriorityQueue<>((x, y) -> y-x);
        //     for (int v : a) {
        //         if (v > 0)
        //             q.offer(v);
        //     }
        //     if (q.size() == 1) return q.peek();
        //     while (!q.isEmpty()) {
        //         int top = q.poll();
        //         if (top > 0) {
        //             cnt++;
        //             if (top >= 1) {
        //                 if (q.isEmpty()) return cnt + top - 1;
        //                 int cur = q.poll();
        //                 if (top > 1)
        //                     q.offer(top - 1);
        //                 if (cur > 1)
        //                     q.offer(cur - 1);
        //             }
        //         }
        //     }
        //     return cnt;
        // }

    // class SmallestInfiniteSet {
    //     TreeSet<Integer> s; // record the missing numbers <= 1000 elements
    //     public SmallestInfiniteSet() {
    //         s = new TreeSet<>();
    //     }
    //     public int popSmallest() {
    //         int v = 1;
    //         while (s.contains(v)) v++;
    //         s.add(v);
    //         return v;
    //     }
    //     public void addBack(int num) {
    //         if (s.contains(num)) 
    //             s.remove(num);
    //     }
    // }

// 动态规划，看着还是头比较大
        // public int idealArrays(int n, int maxValue) {
        // }

        // public boolean canChange(String ss, String tt) {
        //     int n = ss.length(), l = 0, r = 0, m = 0;
        //     char [] s = ss.toCharArray();
        //     char [] t = tt.toCharArray();
        //     for (int i = 0; i < n; i++) {
        //         if (s[i] == t[i]) continue;
        //     }
        // }
    }
    public static void main(String args[]) { 
        Solution s = new Solution();

        int [] a = new int [] {5,4,4};

        int r = s.fillCups(a);
        System.out.println("r: " + r);
    }
}
// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
