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

        // // 这个是比较繁琐,有很多种角落里的情况,后面再来写这个题目
        // public int countTime(String t) {
        //     char [] s = t.toCharArray();
        //     int f = 1;
        //     for (int i = 0; i < 5; i++) 
        //         if (s[i] == '?') {
        //             if (i == 0) 
        //         }
        // }

        // static final int mod = (int)1e9 + 7;
        // public int[] productQueries(int n, int[][] a) {
        //     int m = Integer.bitCount(n), idx = 0;
        //     int [] f = new int [m];
        //     for (int i = 0; i < 30; i++) 
        //         if (((n >> i) & 1) == 1)
        //             f[idx++] = (1 << i);
        //     // System.out.println(Arrays.toString(f));
        //     // System.out.println("Arrays.stream(f).sum(): " + Arrays.stream(f).sum()); 
        //     List<int []> q = new ArrayList<>();
        //     idx = 0;
        //     for (var v : a)
        //         q.add(new int [] {idx++, v[0], v[1]});
        //     Collections.sort(q, (x, y) -> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
        //     int [] r = new int [a.length];
        //     long bgn = 1l, end =1l, cur = 1l;
        //     for (int i = 0; i < a.length; i++) {
        //         int [] v = q.get(i);
        //         if (i == 0) {
        //             for (int j = v[1]; j <= v[2]; j++) 
        //                 cur = (cur * f[j]) % mod;
        //         } else { // 左边右移,右边右移
        //         }
        //         r[v[0]] = cur;
        //     }                
        // }
        // //     for (var v : q) {
        // //         while (idx <= v[1]) {
        // //             pre  = (pre * f[idx-1]);
        // //             idx++;
        // //         }
        // //         cur = pre
        // //         r[v[0]] = (int)((long)(p[v[2]+1] + mod) / p[v[1]]) % mod; // 这里对大数的处理有点儿小问题
        // //     }
        // //     return r;
        // // }

        // public int minimizeArrayValue(int[] a) { // TLE TLE TLE: 如果每个数组是需要遍历好几遍,应该是会超时;
        //     // 可是还没有想出如果高效地达到题目所要求的目的的办法
        //     n = a.length;
        //     int max = a[0];
        //     // Deque<int []> s = new ArrayDeque<>();
        //     // Deque<int []> t = new ArrayDeque<>();
        //     // s.push(a[0]);
        //     // for (int i = 1; i < n; i++) {
        //     //     if (a[i] <= s.peek()) {
        //     //         s.push(a[i]);
        //     //         continue;
        //     //     }
        //     //     int v = (a[i] - a[i-1]) / 2;
        //     //     a[i-1] += v;
        //     //     a[i] -= v;
        //     // }
        //     while (canBeImproved(a)) {
        //         max = a[0];
        //         for (int i = 1; i < n; i++) {
        //             if (a[i] < a[i-1] + 1) {
        //                 max = Math.max(max, a[i]);
        //                 continue;
        //             } else if (a[i] == a[i-1] + 1) {
        //                 max = Math.max(max, a[i]);
        //                 a[i-1] = a[i];
        //                 a[i] = a[i-1] - 1;
        //                 continue;
        //             }
        //             int v = (a[i] - a[i-1]) / 2;
        //             a[i-1] += v;
        //             a[i] -= v;
        //             max = Math.max(max, a[i]);
        //         }
        //         // System.out.println(Arrays.toString(a));
        //     }
        //     return max;
        // }
        // int n;
        // boolean canBeImproved(int [] a) {
        //     for (int i = 1; i < n; i++) 
        //         if (a[i] - a[i-1] >= 1) return true;
        //     return false;
        // }

        public int componentValue(int[] a, int[][] edges) {
            int n = a.length;
            if (n == 1) return 0;
            
            int sum = Arrays.stream(a).sum(), max = Arrays.stream(a).max().getAsInt();
            System.out.println("sum: " + sum); 
            System.out.println("max: " + max); 
            // 要删除尽可能多的边数,就要使每个部分的和尽可能地小, 那么从最大节点值的这个值开始往上遍历,寻找可能性
            

        } 
    }
    public static void main (String[] args) {
        Solution s = new Solution ();

        // // int [][] a = new int [][] {{0,1},{2,2},{0,3}};
        // // int [][] a = new int [][] {{0, 0}};
        // // int [][] a = new int [][] {{2,3},{0,1},{0,1},{0,1},{0,0},{0,3},{3,3},{2,3},{1,1},{2,3}};
        // int [][] a = new int [][] {{5,5},{4,4},{0,1},{1,5},{4,6},{6,6},{5,6},{0,3},{5,5},{5,6},{1,2},{3,5},{3,6},{5,5},{4,4},{1,1},{2,4},{4,5},{4,4},{5,6},{0,4},{3,3},{0,4},{0,5},{4,4},{5,5},{4,6},{4,5},{0,4},{6,6},{6,6},{6,6},{2,2},{0,5},{1,4},{0,3},{2,4},{5,5},{6,6},{2,2},{2,3},{5,5},{0,6},{3,3},{6,6},{4,4},{0,0},{0,2},{6,6},{6,6},{3,6},{0,4},{6,6},{2,2},{4,6}};
        // int [] a = new int [] {3,7,1,6};
        // int []  a = new int []  {13, 13, 20, 0, 8, 9, 9};
        // int []  a = new int []  {6, 9, 3, 8, 14};
        int [] a = new int [] {3, 7, 1, 6};
        
        System.out.println(Arrays.toString(a));

        int r = s.minimizeArrayValue(a);
        System.out.println("r: " + r); 
    }
}
// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);


// [256,128,2,4194304,16777216,512,131072,128,256,131072,8,524288,268435456,256,128,2,8192,32768,128,131072,16384,16,16384,4194304,128,256,16777216,32768,16384,512,512,512,4,4194304,16384,128,8192,256,512,4,64,256,-147483634,16,512,128,1,8,512,512,268435456,16384,512,4,16777216]
// [256,128,2,4194304,16777216,512,131072,128,256,131072,8,524288,268435456,256,128,2,8192,32768,128,131072,16384,16,16384,4194304,128,256,16777216,32768,16384,512,512,512,4,4194304,16384,128,8192,256,512,4,64,256,147483634,16,512,128,1,8,512,512,268435456,16384,512,4,16777216]