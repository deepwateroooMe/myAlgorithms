// import com.ListNode;

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

        // public String[] divideString(String s, int k, char fill) {
        //     int n = (s.length() / k + (s.length() % k == 0 ? 0 : 1)) * k, i = 0, idx = 0;
        //     s = new StringBuilder (s) + ("" + fill).repeat(n - s.length()).toString();
        //     // System.out.println("s: " + s);
        //     String [] ans = new String [n / k];
        //     char [] t = s.toCharArray();
        //     StringBuilder sb = new StringBuilder();
        //     while (i < n) {
        //         sb.append(t[i]);
        //         if (i % k == k-1) {
        //             ans[idx++] = sb.toString();
        //             sb = new StringBuilder (); //
        //         }
        //         i++;
        //     }            
        //     return ans;
        // }

        // public int minMoves(int target, int maxDoubles) {
        //     if (maxDoubles == 0) return target - 1;
        //     int v = target, ans = 0, ori = maxDoubles;
        //     while (maxDoubles > 0 && v > 1) {
        //         if (v % 2 == 1) {
        //             ans ++;
        //             v -= 1;
        //         }
        //         v /= 2;
        //         maxDoubles --;
        //     }
        //     return ans + v - 1 + ori - maxDoubles;
        // }

        // public long mostPoints(int[][] a) {
        //     int n = a.length;
        //     long [] dp = new long [n];
        //     for (int i = 0; i < n; i++) 
        //         dp[i] = a[i][0];
        //     long ans = dp[n-1];
        //     for (int i = n-2; i >= 0; i--) {
        //         if (i + 1 < n && i + a[i][1] + 1 < n)
        //             dp[i] = Math.max(dp[i+1], dp[i] + dp[i + a[i][1] + 1]);
        //         else if (i + 1 < n)
        //             dp[i] = Math.max(dp[i], dp[i+1]);
        //         ans = Math.max(ans, dp[i]);
        //     }
        //     return ans;
        // }

        // // 求和，取平均，以平均值为背包容量动归，
        // public long maxRunTime(int m, int [] a) { // 考场上的脑袋太发散了，根本就没有想到点儿上
        //     int n = a.length, i = 0;
        //     long sum = 0;
        //     for (int v : a) sum += (long)v;
        //     System.out.println("sum: " + sum);
        //     Arrays.sort(a);
        //     long [] cnt = new long [m];
        //     Queue<CusMap> q = new PriorityQueue<>((x, y)-> x.sum != y.sum ? x.sum - y.sum : x.size() - y.size());
        //     for ( i = n-1; i >= n-m; i--) {
        //         CusMap tmp = new CusMap();
        //         tmp.add(a[i]);
        //         q.offer(tmp);
        //     }
        //     for (; i >= 0; i--) {
        //         CusMap cur = q.poll();
        //         System.out.println("cur.sum: " + cur.sum);
        //         cur.add(a[i]);
        //         q.offer(cur);
        //     }
        //     int idx = 0, min = Integer.MAX_VALUE; // 这里你是又想把它们揉到一起了，可是会存在某种情况下某截就用完了的特例，这里没想透彻
        //     while (idx < m) {
        //         cnt[idx] = q.poll().sum;
        //         min = Math.min(min, cnt[idx++]);
        //     }
        //     Arrays.sort(cnt); // 这里有什么办法可以把它们补长一点儿吗？
        //     System.out.println("q.peek().sum: " + q.peek().sum);
        //     return q.peek().sum;
        // }
        // class CusMap {
        //     public int sum;
        //     TreeMap<Integer, Integer> m;
        //     public CusMap() {
        //         m = new TreeMap<>();
        //         sum = 0;
        //     }
        //     public void add(int v) {
        //         m.put(v, m.getOrDefault(v, 0) + 1);
        //         sum += v;
        //     }
        //     public int size() {
        //         return m.size();
        //     }
        // }

        // public long maxRunTime(int n, int[] a) {
        //     int m = a.length;
        //     long ans = 0;
        //     for (int v : a) ans += v;
        //     long l = 1, r = ans / n;
        //     while (l <= r) { // l <= r
        //         long mid = (l + r) >> 1;
        //         if (valid(mid, a, n)) {
        //             ans = mid;
        //             l = mid + 1;
        //         } else r = mid - 1;
        //     }
        //     return ans;
        // }
        // boolean valid(long v, int [] a, int n) { // v: time t
        //     long sum = 0, target = n * v;
        //     for (int bat : a) {
        //         if (bat < v) sum += bat;
        //         // During a simultaneous run of a minutes, each battery, no matter how long it can run,
        //         // can "contribute" a maximum of a minutes to the total running time.
        //         else sum += v; // 觉得这里浪费了很多电池，容易 false negative ???: 比赛的时候就是被卡在了这种点儿上
        //         if (sum >= target) return true;
        //     }
        //     return sum >= target;
        // }

    
    // public Solution(int[] a) {
    public Solution(int[] a) {
        
    }
    public int[] reset() {
        
    }
    public int[] shuffle() {
        
    }
    }   
    public static void main (String[] args) {
        Solution s = new Solution ();

        // int [] a = new int [] {3, 3, 3};
        int []  a = new int []  {10, 10, 3, 5};

        long r = s.maxRunTime(3, a);
        System.out.println("r: " + r);
    }
}

// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

 // ListNode r = s.deleteMiddle(head);
 // r.printList(r);

 // TreeNode root = new TreeNode(a[0]);
 // root.buildTree(root, a);
 // root.levelPrintTree(root);
        
 // String r = s.getDirections(root, 2, 1);
 // System.out.println("r: " + r);

