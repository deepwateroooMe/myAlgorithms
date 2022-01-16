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

        // 求和，取平均，以平均值为背包容量动归，
        public long maxRunTime(int m, int [] a) {
            int n = a.length, i = 0;
            long sum = 0;
            for (int v : a) sum += (long)v;
            System.out.println("sum: " + sum);
            // if (sum % m == 0)
            //     return sum / m;
            Arrays.sort(a);
            long [] cnt = new long [m];
            // int idx = 0;
            // for ( i = n-1; i >= n-m; i--) 
            //     cnt[idx++] = a[i];
            // Arrays.sort(cnt);
            // idx = 0;
            // for (; i >= 0; i--) {
            //     while (idx < m-1 && ) {
            //     }
            //     int cur = q.poll();
            //     cur.add(a[i]);
            //     q.offer(cur);
            // }
            // System.out.println("q.peek().sum: " + q.peek().sum);
            // return q.peek().sum;
            

            Queue<CusMap> q = new PriorityQueue<>((x, y)-> x.sum != y.sum ? x.sum - y.sum : x.size() - y.size());
            for ( i = n-1; i >= n-m; i--) {
                CusMap tmp = new CusMap();
                tmp.add(a[i]);
                q.offer(tmp);
            }
            for (; i >= 0; i--) {
                CusMap cur = q.poll();
                System.out.println("cur.sum: " + cur.sum);
                cur.add(a[i]);
                q.offer(cur);
            }
            int idx = 0, min = Integer.MAX_VALUE; // 这里你是又想把它们揉到一起了，可是会存在某种情况下某截就用完了的特例，这里没想透彻
            while (idx < m) {
                cnt[idx] = q.poll().sum;
                min = Math.min(min, cnt[idx++]);
            }
            Arrays.sort(cnt); // 这里有什么办法可以把它们补长一点儿吗？
            

            System.out.println("q.peek().sum: " + q.peek().sum);
            return q.peek().sum;
        }
        // class MyMap { // 这里被我想复杂了，应该就是可以拆分的背包问题
        //     int n;
        //     TreeMap<Long, List<CusMap>> m;
        //     public MyMap(int n) {
        //         this.n = n;
        //         // m = new TreeMap<>((x, y)->x.sum != y.sum ? x.sum - y.sum : x.size() - y.size());
        //         m = new TreeMap<>();
        //     }
        //     public void add(int v) {
        //         if (m.size() == 1) {
        //             // if (v % n == 0) {
        //             List<CusMap> lc = ((Map.Entry<Long, List<CusMap>>)m.iterator().next()).getValue();
        //             for (int i = 0; i < n; i++) 
        //                 lc.get(i).add(v / n);
        //             // }
        //             if (v % n != 0) {
        //             }
        //         }
        //     }
        // }
        class CusMap {
            public int sum;
            TreeMap<Integer, Integer> m;
            public CusMap() {
                m = new TreeMap<>();
                sum = 0;
            }
            public void add(int v) {
                m.put(v, m.getOrDefault(v, 0) + 1);
                sum += v;
            }
            public int size() {
                return m.size();
            }
        }
    }
    public static void main (String[] args) {
        Solution s = new Solution ();

        // int [] a = new int [] {1,1,1,1};
        int [] a = new int [] {3, 3, 3};
        // int [] a = new int [] {10,10,3,5};

        long r = s.maxRunTime(2, a);
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

