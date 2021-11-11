import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.Arrays;
import java.util.stream.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class dpfour {
    public static class Solution {
    
        // private int cnt(int n, char last) {
        // }
        // public int countVowelStrings(int n) {
        //     String t = "aeiou";
        //     char [] s = t.toCharArray();
        //     int ans = 0;
        //     for (char c : s) 
        //         ans += cnt(n, c);
        //     return ans;
        // }

        // public class Trie {
        //     private class Node {
        //         boolean end;
        //         Node [] next;
        //         public Node () {
        //             end = false;
        //             next = new Node [26];
        //         }
        //     }
        //     private Node root;
        //     public Trie () {
        //         root = new Node();
        //     }
        //     public void insert(String t) {
        //         Node r = root;
        //         char [] s = t.toCharArray();
        //         for (int i = 0; i < t.length(); i++) {
        //             if (r.next[s[i]-'a'] == null)
        //                 r.next[s[i]-'a'] = new Node();
        //             r = r.next[s[i]-'a'];
        //         }
        //         r.end = true;
        //     }
        //     public boolean search(String t) {
        //         int n = t.length();
        //         char [] s = t.toCharArray();
        //         Node r = root;
        //         for (int i = 0; i < n; i++) {
        //             if (r.next[s[i]-'a'] == null) return false;
        //             r = r.next[s[i]-'a'];
        //         }
        //         return r.end;
        //     }
        // }
        // private boolean difByOne(String ss, String tt) {
        //     if (ss.length() != tt.length()) return false;
        //     char [] s = ss.toCharArray();
        //     char [] t = tt.toCharArray();
        //     int cnt = 0;
        //     for (int i = 0; i < ss.length(); i++) 
        //         if (s[i] != t[i]) {
        //             ++cnt;
        //             if (cnt > 1)
        //                 return false;
        //         }
        //     return cnt == 1;
        // }
        // public int countSubstrings(String s, String t) {
        //     int m = s.length(), n = t.length(), ans = 0;
        //     Map<String, Integer> map = new HashMap<>(); // t's substring may have repeats, need to remember the cnts
        //     // Trie r = new Trie();
        //     for (int i = 0; i < n; i++) 
        //         for (int j = i+1; j <= n; j++) {
        //             map.put(t.substring(i, j), map.getOrDefault(t.substring(i, j), 0) + 1);
        //             // r.insert(t.substring(i, j));
        //         }
        //     for (int i = 0; i < m; i++) 
        //         for (int j = i+1; j <= m; j++) {
        //             String cur = s.substring(i, j);
        //             for (String v : map.keySet()) 
        //                 if (difByOne(v, cur))  ans += map.get(v);
        //             // for (int k = 0; k < cur.length(); k++) {
        //             //     for (char c = 'a'; c <= 'z'; c++) {
        //             //         if (cur.charAt(k) == c) continue;
        //             //         String tmp = (k == 0 ? "" : cur.substring(0, k)) + c + (k == cur.length()-1 ? "" : cur.substring(k+1));
        //             //         if (r.search(tmp)) ans += map.get(tmp);
        //             //     }
        //             // }
        //         }
        //     return ans;
        // }
        // public int countSubstrings(String ss, String tt) { // 字符串上的dp要好好熟悉一下
        //     int m = ss.length(), n = tt.length(), ans = 0;
        //     char [] s = ss.toCharArray();
        //     char [] t = tt.toCharArray();
        //     int [][] sam = new int [m][n];
        //     int [][] dif = new int [m][n];
        //     for (int i = 0; i < m; i++) { // 初始化
        //         sam[i][0] = s[i] == t[0] ? 1 : 0;
        //         dif[i][0] = s[i] == t[0] ? 0 : 1;
        //     }
        //     for (int j = 0; j < n; j++) { // 初始化
        //         sam[0][j] = s[0] == t[j] ? 1 : 0;
        //         dif[0][j] = s[0] == t[j] ? 0 : 1;
        //     }
        //     for (int i = 1; i < m; i++) 
        //         for (int j = 1; j < n; j++) {
        //             if (s[i] == t[j]) { // 字符相同
        //                 sam[i][j] = sam[i-1][j-1] + 1;
        //                 dif[i][j] = dif[i-1][j-1]; //  前面的数量跟我组合，以及 单个字符
        //             } else dif[i][j] = sam[i-1][j-1] + 1;
        //         }
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) 
        //             ans += dif[i][j];
        //     return ans;
        // }
        // public int countSubstrings(String ss, String tt) {
        //     int m = ss.length();
        //     int n = tt.length();
        //     char [] s = ss.toCharArray();
        //     char [] t = tt.toCharArray();
        //     int res = 0, dif = 0;
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) {
        //             dif = 0;
        //             for (int k = i, l = j; k < m && l < n; k++, l++) {
        //                 if (s[k] != t[l]) {
        //                     if (dif > 0) break;
        //                     res++;
        //                     dif++;
        //                 } else if (dif == 1) {
        //                     res++;
        //                 }
        //             }
        //         }
        //     return res;
        // }

        
        // public int numTeams(int[] a) { // 感觉leetcode这种卡时间的方法很坑人。。。。。。
        //     int n = a.length, ans = 0;
        //     // for (int i = 0; i < n-2; i++) { 
        //     //     for (int j = i+1; j < n-1; j++) { 
        //     for (int i = 0; i < n-2; i++) // 注意这里不需要 -2 -1
        //         for (int j = i+1; j < n-1; j++) 
        //             for (int k = j+1; k < n; k++) {
        //                 if (a[i] < a[j] && a[j] < a[k] || a[i] > a[j] && a[j] > a[k]) // 这些个条件的比较也会自动过滤重复
        //                     ans++;
        //             }
        //     return ans;
        // }
        // public int numTeams(int[] a) { // 出发点是对的，但是还是要去想：到底哪些信息是需要自己统计和纪录的
        //     int n = a.length, ans = 0;
        //     for (int i = 1; i < n-1; i++) {
        //         int lgt = 0, lls = 0;
        //         for (int j = 0; j < i; j++) {
        //             if (a[j] > a[i]) lgt ++;
        //             if (a[j] < a[i]) lls ++;
        //         }
        //         int rgt = 0, rls= 0;
        //         for (int j = i+1; j < n; j++) {
        //             if (a[j] > a[i]) rgt ++;
        //             if (a[j] < a[i]) rls ++;
        //         }
        //         ans += lgt * rls + lls * rgt;
        //     } 
        //     return ans;
        // }

//         private void dfs(int [][] a, int x, int y, boolean h, int oy) { // h: horizontal
//             if (x == m) {
//                 ans[oy] = y;
//                 return ;
//             }
// // [/  \/  \] 3 return cases
//             if (y == 0 && a[x][y] == -1 && !h || y == n-1 && a[x][y] == 1 && !h
//                 || a[x][y] == 1 && y < n-1 && a[x][y+1] == -1 && !h
//                 || a[x][y] == -1 && y > 0 && a[x][y-1] == 1 && !h) {
//                 ans[oy] = -1;
//                 return;
//             }
//             if (!h) { // move horizontally
//                 if (y < n-1 && a[x][y] == 1) dfs(a, x, y+1, true, oy);
//                 if (y > 0 && a[x][y] == -1) dfs(a, x, y-1, true, oy);
//             } else  // mover vertically
//                 dfs(a, x+1, y, false, oy);
//         }
//         int [] ans;
//         int m, n;
//         public int[] findBall(int[][] grid) {
//             m = grid.length;
//             n = grid[0].length;
//             ans = new int [n];
//             for (int i = 0; i < n; i++) 
//                 dfs(grid, 0, i, false, i);
//             return ans;
//         }

        // public double nthPersonGetsNthSeat(int n) { // bug 
        //     if (n == 1) return 1;
        //     double [] dp = new double [n+1];
        //     dp[1] = 1;
        //     for (int i = 2; i <= n; i++) 
        //         dp[i] = dp[i-1] * 0.5;
        //     return dp[n];
        // }

        // public int maxProfit(int[] p, int fee) {
        //     int n = p.length;
        //     int [] sold = new int [n];
        //     int [] hold = new int [n];
        //     hold[0] = -p[0]; // 因为买进投资了，还没有产出，所以是负数
        //     for (int i = 1; i < n; i++) {
        //         sold[i] = Math.max(p[i] + hold[i-1] - fee, sold[i-1]); // 卖或不卖
        //         hold[i] = Math.max(sold[i-1] - p[i], hold[i-1]);       // 买或不买
        //     }
        //     return Math.max(hold[n-1], sold[n-1]);
        // }

        // public int maxProfit(int[] p) { // bug
        //     int n = p.length;
        //     int [] sold = new int [n];
        //     int [] hold = new int [n];
        //     hold[0] = -p[0]; // 因为买进投资了，还没有产出，所以是负数
        //     for (int i = 1; i < n; i++) {
        //         sold[i] = Math.max(p[i] + hold[i-1], (i > 2 ? hold[i-2] : 0)); // 卖或不卖
        //         hold[i] = Math.max((i > 2 ? sold[i-2] - p[i] : 0), (i > 2 ? sold[i-2] : 0)); // 买或不买: 因为卖完要休息一天，只能是最早前2天的结果
        //     }
        //     System.out.println(Arrays.toString(sold));
        //     System.out.println(Arrays.toString(hold));
        //     return Math.max(hold[n-1], sold[n-1]);
        // }

        // public int maxProfit(int[] p) { // bug
        //     int n = p.length, lmin = 0, lmax = 0, gmax = 0;
        //     int [] l = new int [n];
        //     int [] r = new int [n];
        //     lmin = p[0];
        //     lmax = p[0];
        //     for (int i = 1; i < n; i++) {
        //          System.out.println("\n i: " + i);
        //         if (p[i] < lmin) {
        //             gmax = Math.max(gmax, lmax - lmin);
        //             lmin = p[i];
        //             lmax = 0;
        //         } else {
        //             lmax = Math.max(lmax, p[i]);
        //             gmax = Math.max(gmax, lmax - lmin);
        //         }
        //         l[i] = gmax;
        //          System.out.println(Arrays.toString(l));
        //     }
        //     lmin = p[n-1];
        //     lmax = p[n-1];
        //     gmax = 0;
        //     for (int i = n-2; i >= 0; i--) {
        //          System.out.println("\n i: " + i);
        //         if (p[i] < lmin) {
        //             lmin = Math.min(lmin, p[i]);
        //             gmax = Math.max(gmax, lmax - lmin);
        //             lmax = 0;
        //         } else {
        //             gmax = Math.max(gmax, lmax - lmin);
        //             lmax = Math.max(lmax, p[i]);
        //             // lmin = 0;
        //         }
        //         r[i] = gmax;
        //         // System.out.println("lmax: " + lmax);
        //         // System.out.println("lmin: " + lmin);
        //         //  System.out.println("r[i]: " + r[i]);
        //         //  System.out.println(Arrays.toString(r));
        //     }
        //     gmax = 0;
        //     for (int i = 1; i < n; i++) 
        //         gmax = Math.max(gmax, l[i] + r[i]);
        //     return gmax;
        // }

        // public int minimumDeleteSum(String ss, String tt) { // 字符串中的dp还是需要再多熟悉 712
        //     int m = ss.length(), n = tt.length();
        //     char [] s = ss.toCharArray();
        //     char [] t = tt.toCharArray();
        //     int [][] dp = new int [m+1][n+1]; // 设 dp[i][j] 表示 s1[:i] 和 s2[:j] 中删除元素之后相等所累积的 ASCII 码的总和
        //     // 初始化 dp[i][0] = sum(s1[:i]), 即 s1 的 ASCII 码前缀和, dp[0][j] = sum(s2[:j]), 即 s1 的 ASCII 码前缀和
        //     for (int i = 1; i <= m; i++) 
        //         dp[i][0] = dp[i-1][0] + s[i-1];
        //     for (int j = 1; j <= n; j++) 
        //         dp[0][j] = dp[0][j-1] + t[j-1];
        //     for (int i = 1; i <= m; i++) 
        //         for (int j = 1; j <= n; j++) 
        //             if (s[i-1] == t[j-1]) dp[i][j] = dp[i-1][j-1];
        //             else dp[i][j] = Math.min(dp[i-1][j] + s[i-1], dp[i][j-1] + t[j-1]);
        //     return dp[m][n];
        // }

        // public int getKth(int lo, int hi, int k) { 
        //     Map<Integer, Integer> m = new HashMap<>();
        //     for (int i = lo; i <= hi; i++) {
        //         if (m.containsKey(i)) continue;
        //         int cnt = 0, cur = i;
        //         while (cur > 1) {
        //             if (cur % 2 == 0) cur /= 2;
        //             else cur = cur * 3  + 1;
        //             if (cur == 1) break;
        //             // if (m.containsKey(cur)) { // ? bug: why these would cauase a bug ?
        //             //     cnt += m.get(cur);
        //             //     break;
        //             // }
        //             cnt++;
        //         }
        //         m.put(i, cnt);
        //     }
        //     List<List<Integer>> l = new ArrayList<>();
        //     m.forEach((key, v)-> { 
        //             l.add(List.of(key, v));
        //         });
        //     Collections.sort(l, (a, b)->a.get(1) != b.get(1) ? a.get(1) - b.get(1) : a.get(0) - b.get(0));
        //     return l.get(k-1).get(0);
        // }

        // public int minCost(String t, int[] cost) {
        //     int n = t.length(), i = 0, ans = 0;
        //     char [] s = t.toCharArray();
        //     while (i < n-1 && s[i+1] != s[i]) i++;
        //     if (i == n) return 0;
        //     int max = cost[i], sum = cost[i];
        //     while (i < n-1) {
        //         while (i < n-1 && s[i] == s[i+1]) {
        //             max = Math.max(max, cost[i+1]);
        //             sum += cost[i+1];
        //             i++;
        //         }
        //         ans += (sum - max);
        //         if (i == n-1) return ans;
        //         sum = 0;
        //         while (i < n-1 && s[i] != s[i+1]) i++;
        //         sum = cost[i];
        //         max = cost[i];
        //     }
        //     return ans;
        // }
        // public int minCost(String t, int[] cost) {
        //     char [] s = t.toCharArray();
        //     int minCost = 0;
        //     int i = 0;
        //     while (i < t.length() -1) {
        //         if (s[i] == s[i+1]) {
        //             minCost = minCost + Math.min(cost[i], cost[i+1]);
        //             if (cost[i+1] < cost[i]) // 把相临字母中代价较高的那一个保留为局部最大值，从而累加较小值
        //                 cost[i+1] = cost[i];
        //         }
        //         i++;
        //     }
        //     return minCost;
        // }

        // public int minHeightShelves(int[][] books, int shelfWidth) {
        //     int n = books.length;
        //     int [] dp = new int [n];
        //     dp[0] = books[0][1];
        //     for (int i = 2; i < n; i++) {
        //     }
        // }
        
        // private boolean isValid(List<Integer> l, List<Integer> s) { // bug
        //     for (int i = 0; i < l.size(); i++) 
        //         if (l.get(i) > s.get(i)) return false;
        //     return true;
        // }
        // public int shoppingOffers(List<Integer> p, List<List<Integer>> of, List<Integer> need) {
        //     int ans = Integer.MAX_VALUE, n = p.size(), cur = 0;
        //     for (List<Integer> vv : of) { // 这里需要考虑的是：一个offer可以用多次，以及合用几个offer，用回塑但太慢，用动态规划得
        //         List<Integer> v = new ArrayList<>(vv);
        //         while (isValid(v, need)) cur = v.get(n);
        //         for (int i = 0; i < n; i++) 
        //             if (need.get(i) > v.get(i))
        //                 cur += p.get(i) * (need.get(i) - v.get(i));
        //         ans = Math.min(ans, cur);
        //     }
        //     return ans;
        // }

        // public int minimumDeletions(String t) {
        //     int n = t.length(), cnt = 0;
        //     char [] s = t.toCharArray();
        //     int [] bb = new int [n]; // bs before it
        //     int [] aa = new int [n]; // as after it
        //     for (int i = 0; i < n; i++) 
        //         if (s[i] == 'b') {
        //             ++cnt;
        //             bb[i] = cnt;
        //         } else bb[i] = (i == 0 ? 0 : bb[i-1]);
        //     cnt = 0;
        //     for (int i = n-1; i >= 0; i--) 
        //         if (s[i] == 'a') {
        //             ++cnt;
        //             aa[i] = cnt;
        //         } else aa[i] = (i == n-1 ? 0 : aa[i+1]);
        //     int ans = 0;
        //     for (int i = 0; i < n; i++) { // 这里删与不删的标准再想一下
        //         if (s[i] == 'b' && bb[i] )
        //     }
        // }

        // public long countVowels(String t) {
        //     long n = t.length();
        //     char [] s = t.toCharArray();
        //     Set<Character> sc = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
        //     long ans = 0;
        //     for (long i = 0; i < n; i++)
        //         if (sc.contains(s[i]))
        //             ans += (i+1)*(n-i);
        //     return ans;
        // }

        // private int dfs(int [] a, int i, int j) { // 没有搞明白这个题目的划分到底是怎么回事，以及终止条件
        //     System.out.println("\n i: " + i);
        //     System.out.println("j: " + j);
        //     // if (i == j) return a[i];
        //     if (j - i == 2) return dp[i][j] = a[i] * a[i+1] * a[j];
        //     if (j - i == 3) return dp[i][j] = Math.min(a[i] * a[i+1] * a[i+2] + a[i] * a[j-1] * a[j],
        //                                                a[i] * a[i+1] * a[j] + a[i+1] * a[j-1] * a[j]);
        //     // if (i > j) return 0;
        //     if (dp[i][j] > 0) return dp[i][j];
        //     int ans = Integer.MAX_VALUE;
        //     for (int k = i+1; k < j; k++) {
        //         System.out.println("\n k: " + k);
        //         System.out.println("a[k]: " + a[k]);
        //         ans = Math.min(ans, a[i]*a[k]*a[j] + dfs(a, i, k) + dfs(a, k, j));
        //         System.out.println("ans: " + ans);
        //     }
        //     dp[i][j] = ans;
        //     return ans;
        //     // return dp[i][j] = ans;
        // }
        // int [][] dp;
        // int n;
        // public int minScoreTriangulation(int[] a) {
        //     n = a.length;
        //     dp = new int [n][n];
        //     return dfs(a, 0, n-1);
        // }

        // public int findLength(int[] a, int[] b) { // 这个题没想透 bug bug bug
        //     int m = a.length, n = b.length;
        //     int [][] dp = new int [m+1][n+1];
        //     for (int j = 1; j <= n; j++)
        //         if (a[0] == b[j-1]) dp[0][j] = 1;
        //         else dp[0][j] = dp[0][j-1];
        //     for (int i = 1; i <= m; i++) 
        //         if (a[i-1] == b[0]) dp[i][0] = 1;
        //         else dp[i][0] = dp[i-1][0];
        //     for (int i = 1; i <= m; i++) 
        //         for (int j = 1; j <= n; j++) {
        //             if (a[i-1] == b[j-1] && (i == 1 && j == 1 || i >= 2 && j >= 2 && a[i-2] == b[j-2]))
        //                 dp[i][j] = dp[i-1][j-1] + 1;
        //             else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        //         }
        //     System.out.println("dp.length: " + dp.length);
        //     for (int z = 0; z < dp.length; ++z) 
        //         System.out.println(Arrays.toString(dp[z]));
        //     return dp[m][n];
        // }
        // public int findLength(int[] a, int[] b) { 
        //     int m = a.length, n = b.length, max = 0;
        //     int [][] dp = new int [m+1][n+1];
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) {
        //             if (a[i] == b[j])
        //                 dp[i+1][j+1] = dp[i][j] + 1;
        //             // else dp[i+1][j+1] = Math.max(dp[i+1][j+1], max); // bug: 无效的，不用更新状态，default = 0
        //             max = Math.max(max, dp[i+1][j+1]);
        //         }
        //     return max;
        // }

        // public int countNumbersWithUniqueDigits(int n) {
        //     if (n == 0) return 1;
        //     if (n == 1) return 10;
        //     int [] dp = new int [n+1];
        //     dp[1] = 10;
        //     int cur = 1;
        //     for (int i = 2; i <= n; i++) {
        //         cur = 9;
        //         for (int j = 9-i+2; j <= 9; j++) 
        //             cur *= j;
        //         dp[i] = cur;
        //     }
        //     return Arrays.stream(dp).sum();
        // }

        // public int longestArithSeqLength(int[] a) { // 这里哪里可能想得不够清楚，再想想
        //     int n = a.length, max = 2;
            // Map<Integer, Map<Integer, Integer>> dp = new HashMap<>();
            // for (int i = 0; i < n; i++) {
            //     for (int j = i+1; j < n; j++) {
            //         int dif = a[j] - a[i];
            //         if (dp.containsKey(dif)) {
            //             Map<Integer, Integer> tmp = dp.get(dif);
            //             if (tmp.containsKey(a[i])) {
            //                 tmp.put(a[j], tmp.get(a[i]) + 1);
            //                 // tmp.remove(a[i]); // 为什么这里不能移掉？
            //                 max = Math.max(max, tmp.get(a[j]));
            //             } else tmp.put(a[j], 2);
            //         } else {
            //             Map<Integer, Integer> tmp = new HashMap<>();
            //             tmp.put(a[j], 2);
            //             dp.put(dif, tmp);
            //         }
            //     }
            // }
            // int [] dp = new int [n];
            // for (int i = 0; i < n; i++) {
            //     for (int j = i+1; j < n; j++) {
            //     }
            // }
        //     return max;
        // }

        // private int binarySearch(int [] a, int l, int r, int v) { 
        //     while (l <= r) {
        //         int m = (l+r) / 2;
        //         if (a[m] == v) return m;
        //         if (a[m] > v) r = m-1;
        //         else l = m + 1;
        //     }
        //     return -1;
        // }
        // public int lenLongestFibSubseq(int[] a) { // tle 
        //     int n = a.length, max = 0;
        //     int [] dp = new int [n];
        //     Arrays.fill(dp, 1);
        //     for (int i = 0; i < n; i++) {
        //         if (i + max > n) break;
        //         for (int j = i+1; j < n; j++) {
        //             Arrays.fill(dp, 1);
        //             int next = a[i] + a[j];
        //             int idx = binarySearch(a, j+1, n-1, next);
        //             int k = j;
        //             if (idx != -1) dp[k] = Math.max(dp[k], dp[i]+1);
        //             while (idx != -1) {
        //                 dp[idx] = Math.max(dp[idx], dp[k]+1);
        //                 max = Math.max(max, dp[idx]);
        //                 next = a[k] + a[idx];
        //                 k = idx;
        //                 idx = binarySearch(a, idx+1, n-1, next);
        //             }
        //         }
        //     }
        //     return max;
        // }

        // private int dfs(int [] a, int i, int j) { // i: idx, j: k
        //     if (i == n) return 0;
        //     if (j == 1)  return dp[i][j] = max[i] * (n - i) - (sum[n-1] - (i == 0 ? 0 : sum[i-1]));
        //     if (dp[i][j] > 0) return dp[i][j];
        //     int min = max[i] * (n-i) - (sum[n-1] - (i == 0 ? 0 : sum[i-1]));
        //     for (int k = i; k < n; k++) { // 中间resize一段的界限要如何确定呢？
        //     }
        // }
        // int [][] dp;
        // int [] sum;
        // int [] max;
        // int n;
        // public int minSpaceWastedKResizing(int[] a, int k) {
        //     if (k == 0) return max[0] * n - sum[n-1];
        //     n = a.length;
        //     dp = new int [n][k+1];
        //     sum = Arrays.copyOf(a, n);
        //     for (int i = 1; i < n; i++) sum[i] += sum[i-1];
        //     int curMax = a[n-1];
        //     max[n-1] = a[n-1];
        //     for (int i = n-2; i >= 0; i--) {
        //         curMax = Math.max(curMax, a[i]);
        //         max[i] = curMax;
        //     }
        //     return dfs(a, 0, k);
        //     // int [][] dp = new int [n][k+1];
        //     // dp[n-1][0] = Arrays.stream(a).max().getAsInt() * n - Arrays.stream(a).sum();
        //     // for (int i = n-1; i >= 0; i--) {
        //     //     for (int j = 1; j <= k; j++) {
        //     //     }
        //     // }
        // }

        // public int firstDayBeenInAllRooms(int[] nextVisit) { // bug
        //     int n = nextVisit.length;
        //     int [] dp = new int [n];
        //     dp[0] = 0;
        //     for (int i = 1; i < n; i++) {
        //         dp[i] = dp[i-1] + nextVisit[i-1] + 1;
        //     }
        // }
        
        // public boolean checkValidString(String t) {
        //     if (t.charAt(0) == ')') return false;
        //     int n = t.length();
        //     if (n == 1 && t.charAt(0) != '*') return false;
        //     // t = preprocess(t);
        //     ArrayDeque<Character> st = new ArrayDeque<>();
        //     while (t.startsWith("()") || t.startsWith("*)")) t = t.substring(2);
        //     n = t.length();
        //     char [] s = t.toCharArray();
        //     for (int i = 0; i < n; i++) {
        //         if (s[i] != ')') st.push(s[i]);
        //         else if (s[i] == ')' && !st.isEmpty() && st.peek() == '(') {
        //             st.pop();
        //         } else if (s[i] == ')' && st.isEmpty()) return false;
        //         else if (s[i] == ')') st.push(s[i]);
        //     }
        //     StringBuilder sb = new StringBuilder();
        //     while (!st.isEmpty()) 
        //         sb.append(st.pop());
        //     t = sb.reverse().toString();
        //     System.out.println("t: " + t);
        //     s = t.toCharArray();
        //     int l = 0, r = 0, i = 0, j = 0;
        //     // while (i < n && s[i] != '*') {
        //     //     if (s[i] == '(') l++;
        //     //     else r++;
        //     //     if (r > l) return false;
        //     //     i++;
        //     // }
        //     while (i < n && s[i] != '*') i++;
        //     // if (i == n && l == r) return true;
        //     if (i == n) return false;
        //     if (s[i] == '*') {
        //         String base = t.substring(0, i);
        //         // if (l > r) base = "(".repeat(l-r);
        //         if (checkValidString(base + t.substring(i+1))) return true; 
        //         if (checkValidString(base + "(" + t.substring(i+1))) return true;
        //         if (checkValidString(base + ")" + t.substring(i+1))) return true;
        //         return false;
        //     }
        //     return false;
        // }

        // private void backtracking(int [] a, int limit, int idx, List<Integer> list) { // 说明对回溯的原理理解得不够透彻
        //     if (list.size() >= ans) return;
        //     if (idx < 0) {
        //         if (sum == list.stream().collect(Collectors.summingInt(Integer::intValue))) // 这个前提条件一定不能忘记
        //             ans = list.size();
        //         return;
        //     }
        //     // for (int i = idx; i >= 0; i--) { // 画蛇添足： 第三次！！！
        //             for (int j = 0; j < list.size(); j++) {
        //                 if (list.get(j) + a[idx] > limit) continue;
        //                 if (j > 0 && list.get(j) == list.get(j-1)) continue;
        //                 list.set(j, list.get(j) + a[idx]);
        //                 backtracking(a, limit, idx-1, list);
        //                 list.set(j, list.get(j) - a[idx]);
        //             }
        //             list.add(a[idx]);
        //             backtracking(a, limit, idx-1, list);
        //             list.remove(list.size()-1); // backtracking: 这里是需要回缩的
        //         // 
        //     // }
        // }
        // // boolean [] vis; // 全排列的时候用vis，顺序遍历应该不用 
        // int n, ans, sum;
        // public int minSessions(int[] tasks, int sessionTime) {
        //     n = tasks.length;
        //     ans = n;
        //     Arrays.sort(tasks);
        //     sum = Arrays.stream(tasks).sum();
        //     // vis = new boolean[n];
        //     backtracking(tasks, sessionTime, n-1, new ArrayList<>());
        //     return ans;
        // }

        // private boolean dfs(int sum, int t, bint target, int max) { // 没有体会到这个题与其它类似题的不同，force a win到底是什么意思呢？
        //     if (sum >= target) return t % 2 == 0;                   // 感觉思路想得挺清楚的，不知道细节哪里错了，改天再回来写这题
        //     if (dp[sum][t%2] != null) return dp[sum][t%2];
        //     boolean res = (t % 2 == 0 ? false : true);
        //     for (int i = 1; i <= max; i++) {
        //         if (!vis[i]) {
        //             vis[i] = true;
        //             boolean tmp = dfs(sum + i, t+1, target, max);
        //             if (t % 2 == 0 && tmp)
        //                 res |= true;
        //                 // return dp[sum][t%2] = true;
        //             else if (t % 2 == 1 && !tmp)
        //                 res = false;
        //                 // return dp[sum][t%2] = false;
        //             vis[i] = false;
        //         }
        //     }
        //     return dp[sum][t%2] = res;
        //     // return dp[sum][t%2] = (t % 2 == 0 ? false : true);
        // }
        // Boolean [][] dp;
        // boolean [] vis;
        // public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        //     dp = new Boolean[desiredTotal+1][2];
        //     vis = new boolean [maxChoosableInteger + 1];
        //     return dfs(0, 0, desiredTotal, maxChoosableInteger);
        // }

        // 要点一：怎么求解某课程的最快完成时间
        //   要知道课程编号为k的最快完成时间，我们就得求它的所有前置课程的最快完成时间，递归求解即可，当某课程没有前置课程，那么它的最快完成时间就是time[k]
        // 要点二：怎么遍历
        //   从出度为0的节点，即没有后续课程的节点，开始递归，再递归过程中可以
        // Map<Integer, List<Integer>> map = new HashMap<>(); // key：某课程 value：某课程对应的所有先修课
        // Map<Integer,Integer> minMap = new HashMap<>();     // key：某课程 value：最小完成时间，记忆化处理
        // public int minimumTime(int n, int[][] relations, int[] time) {
        //     boolean [] start = new boolean [n+1]; // 用于标记出度为0的节点，从这些节点开始遍历
        //     Arrays.fill(start, true);
        //     for (int i = 0; i < relations.length; i++) {
        //         start[relations[i][0]] = false;
        //         map.computeIfAbsent(relations[i][1], z -> new ArrayList<>()).add(relations[i][0]);
        //     }
        //     int res = 0;
        //     for (int i = 1; i <= n; i++) 
        //         if (start[i]) // 从出度为0的节点，即没有后续课程的节点，开始遍历
        //             res = Math.max(res, minTime(i, time));
        //     return res;
        // }
        // private int minTime(int k, int [] time) { // 完成课程k所需的最小时间
        //     if (minMap.containsKey(k)) return minMap.get(k); // 如果之前有结果了就直接返回
        //     int res = time[k-1]; // 初始化为课程k所需时间
        //     List<Integer> pre = map.get(k);
        //     if (pre != null) { // 如果课程k有前置课程，加上所有前置课程都上完的最早时间
        //         int t = 0;
        //         for (int i = 0; i < pre.size(); i++) 
        //             t = Math.max(t, minTime(pre.get(i), time));
        //         res += t;
        //     }
        //     minMap.put(k, res);
        //     return res;
        // }
        // 课程的依赖关系上是一张图。对于任意一门课，该课程的最早完成事件＝前置课程的最晚完成时间+当前课程的事件，所以该问题可以转换为求最短路径的问题。只不过求最短路径是长度更小的时候更新并加入队列，该问题则是时间更长的时候更新并加入队列。
        // public int minimumTime(int n, int[][] relations, int[] time) { // 感觉这个思路理简洁一点儿，可是效率不如上面的方法
        //     int [] dis = new int[n];
        //     List<Integer> [] g = new ArrayList[n];
        //     for (int i = 0; i < n; i++) 
        //         g[i] = new ArrayList<>();
        //     for (int [] r : relations) {
        //         int u = r[0] - 1, v = r[1] - 1;
        //         dis[v] = -1; // 意味着有依赖的前置课程
        //         g[u].add(v);
        //     }
        //     Queue<Integer> q = new LinkedList<>();
        //     for (int i = 0; i < n; i++) 
        //         if (dis[i] == 0) { // 所有不依赖前置课程的课程时间更新为本身花费的时间并且加入队列
        //             dis[i] = time[i];
        //             q.offer(i);
        //         }
        //     while (!q.isEmpty()) {
        //         int cur = q.poll();
        //         for (Integer v : g[cur]) 
        //             if (dis[v] < dis[cur] + time[v]) { // 如果花费的时间更多，就更新时间并加入队列
        //                 dis[v] = dis[cur] + time[v];
        //                 q.offer(v);
        //             }
        //     }
        //     return Arrays.stream(dis).max().getAsInt();
        // }

        // public int longestDecomposition(String t) { // 土方法：要找些真正涉及算法的答案再参考一下
        //     if (t == null || t.length() == 0) return 0;
        //     int n = t.length();
        //     if (n == 1) return 1;
        //     if (t.chars().distinct().count() == 1) return n;
        //     char [] s = t.toCharArray();
        //     List<Integer> ids = new ArrayList<>();
        //     for (int i = 0; i < n-1; i++) 
        //         if (s[i] == s[n-1]) ids.add(i);
        //     if (ids.size() == 0) return 1;
        //     int max = 1;
        //     for (Integer idx : ids) 
        //         if (t.endsWith(t.substring(0, idx+1)) && n >= (idx+1)*2) {
        //             max = Math.max(max, 2 + longestDecomposition(t.substring(idx+1, n-(idx+1))));
        //             if ((idx + 1) * 2 == t.length())
        //                 break;
        //         }
        //     return max;
        // }
        
    } 
    public static void main(String[] args) {
        Solution s = new Solution();

        String a = "aaa";
        

        // // String a = "elvtoelvto";
        // String a = "nufbkflwjjlwjjnufbkf";

        int  r = s.longestDecomposition(a);
        System.out.println("r: " + r);
        
    }
}

//   TreeNode root = new TreeNode(a{0});
//   root.buildTree(root, a);
//   root.levelPrintTree(root);

//    for (TreeNode v : r) 
//        v.levelPrintTree(v);
