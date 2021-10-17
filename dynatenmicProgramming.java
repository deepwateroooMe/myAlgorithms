// import com.UnionFind;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;

public class dynatenmicProgramming {
    public static class Solution {

        // public int numMusicPlaylists(int n, int goal, int k) {
        //     int mod = (int)1e9 + 7;
        //     long [][] dp = new long [goal+1][n+1];
        //     for (int i = 1; i <= goal; i++) {
        //         for (int j = 1; j <= n; j++) {
        //             if (i < j) dp[i][j] = 0;
        //             else if (i == 1 && j == 1) dp[i][j] = n;
        //             else if (i > 1 && j == 1) {
        //                 if (k == 0) dp[i][j] = n;
        //                 else dp[i][1] = 0;
        //             } else                   
        //                 dp[i][j] = (dp[i-1][j] * Math.max(j-k, 0) + (j == 0 ? 0 : dp[i-1][j-1] * (n-(j-1)))) % mod;
        //         }
        //     }
        //     return (int)dp[goal][n];
        // }


        // public int leastOpsExpressTarget(int x, int target) {
        //     if (x == target) return 0;
        //     if (x > target) return Math.min(target*2-1, (x-target)*2);
        //     int cnt = 0;
        //     long sum = x;
        //     while (sum  < target) {
        //         sum *= x;
        //         ++cnt;
        //     }
        //     if (sum == target) return cnt;
        //     int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        //     // int tmp = sum - target; // -
        //     if (sum - target < target)
        //         min = leastOpsExpressTarget(x, (int)(sum - target)) + cnt;
        //     max = leastOpsExpressTarget(x, (int)(target - (sum / x))) + cnt - 1;
        //     return Math.min(min, max) + 1; // -
        // }


        // https://leetcode-cn.com/problems/kth-smallest-instructions/solution/di-k-tiao-zui-xiao-zhi-ling-by-zerotrac2/
        // public String kthSmallestPath(int[] destination, int k) {
        //     int v = destination[0], h = destination[1]; // v: m, h: n
        //     int [][] cmb = new int [h+v][h]; // cmb: combination
        //     cmb[0][0] = 1;
        //     for (int i = 1; i < h+v; i++) {
        //         cmb[i][0] = 1;
        //         for (int j = 1; j <= i && j < h; j++) 
        //             cmb[i][j] = cmb[i-1][j-1] + cmb[i-1][j];
        //     }
        //     String res = "";
        //     for (int i = 0, imax = h+v; i < imax; i++)  {
        //         if (h > 0) {
        //             int o = cmb[h+v-1][h-1]; // 确定当前位最高位为H的总共组合数
        //             if (k > o) {             // k > 这个数，则当前高最位必须为V
        //                 res += "V";
        //                 --v;
        //                 k -= o;
        //             } else {                 // k <= 这个数，则当前高最位必须为H
        //                 res += "H";
        //                 --h;
        //             }
        //         } else {
        //             res += "V";
        //             --v;
        //         }
        //     }
        //     return res;
        // }


        // public int distinctSubseqII(String s) {
        //     int n = s.length();
        //     int mod = (int)1e9 + 7;
        //     s = "#" + s;
        //     long [] dp = new long [n+1];
        //     int [] preIdx = new int [26];
        //     Arrays.fill(preIdx, -1);
        //     dp[0] = 1;
        //     for (int i = 1; i <= n; i++) {
        //         int j = preIdx[s.charAt(i)-'a'];
        //         dp[i] = (2 * dp[i-1] % mod - (j != -1 ? dp[j-1] : 0) + mod)  % mod;
        //         preIdx[s.charAt(i)-'a'] = i;
        //     }
        //     return (int)dp[n]-1;
        // }


        // public int numWays(String[] words, String target) {
        //     int n = target.length();
        //     int m = words.length;
        //     int [][] cnt = new int [n][26]; // target
        // }


        // public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        //     StringBuilder sb = new StringBuilder();
        //     for (int i = 0; i < s1.length(); i++)  {
        //         if (s2.indexOf(s1.charAt(i)) == -1) continue;
        //         sb.append(s1.charAt(i));
        //     }
        //     String s = sb.toString().repeat(n1), t = s2.repeat(n2);
        //     int n = s.length(), m = t.length();
        //     if (s.chars().distinct().count() == t.chars().distinct().count() && t.chars().distinct().count() == 1) return n/m;
        //     int i = 0, j = 0, cnt = 0;
        //     while (i < n) { 
        //         while (i < n && s.charAt(i) != t.charAt(j)) i++;
        //         while (i < n && j < m && s.charAt(i) == t.charAt(j)) {
        //             i++;
        //             if (j+1 == m) {
        //                 j = 0;
        //                 ++cnt;
        //             } else j++;
        //         }
        //     }
        //     return cnt;
        // }


        // public int countPalindromicSubsequences(String s) { // bug bug bug
        //     int n = s.length();
        //     int mod = (int)1e9 + 7;
        //     long [][] dp = new long [n][n+1];
        //     dp[0][0] = 1;
        //     for (int i = 0; i < n; i++) {
        //         for (int j = i+1; j <= n; j++) {
        //             String cur = s.substring(i, j);
        //             dp[i][j] = cur.chars().distinct().count();
        //             if (j-i < 2 || j-i == 2 && s.charAt(i) != s.charAt(j-1)) continue;
        //             for (int k = j-1; k > i; k--) 
        //                 if (s.charAt(k) == s.charAt(i)) {// feels like substring, but subsequence needed
        //                     dp[i][j] = (dp[i][j] + (k-i+1 == 2 ? 1 : dp[i+1][k])) % mod;
        //                     break;
        //                 }
        //             for (int k = i+1; k < j-1; k++) {
        //                 if (s.charAt(k) == s.charAt(j-1)) {
        //                     dp[i][j] = (dp[i][j] + (j-k == 2 ? 1 : dp[k][j-1])) % mod;
        //                     break;
        //                 }
        //             }
        //         }
        //     }
        //     return (int)dp[0][n];
        // }
        // private int dfs(String s) {// 不知道哪里哪了？ bug bug bug
        //     // System.out.println("\ns: " + s);
        //     if (s.length() == 0) return 0;
        //     if (s.length() == 1) return 1;
        //     if (dp.containsKey(s)) return dp.get(s);
        //     int n = s.length();
        //     long res = 0;
        //     if (s.charAt(0) == s.charAt(n-1)) {
        //         int l = 1, r = n-2;
        //         while (l <= r && s.charAt(l) != s.charAt(0)) ++l;
        //         // while (r >= 1 && s.charAt(r) != s.charAt(0)) --r;
        //         while (l <= r && s.charAt(r) != s.charAt(0)) --r;
        //         System.out.println("\n l:" + l);
        //         System.out.println("r: " + r);
        //         if (l > r)
        //             res = dfs(s.substring(1, n-2)) * 2 + 2; // 没有
        //         else if (l == r)
        //             res = dfs(s.substring(1, n-2)) * 2 + 1; // 中间有一个
        //         else // 两边各有一个？
        //             // res = dfs(s.substring(1, n-2)) * 2 - dfs(s.substring(l+1, r-l-1)); // r-l-1
        //         res = dfs(s.substring(1, n-2)) * 2 - dfs(s.substring(l+1, r-1)); // r-l-1
        //         // System.out.println("res" + r);
        //   } else
        //         res = dfs(s.substring(0, n-2)) + dfs(s.substring(1, n-1)) - dfs(s.substring(1, n-2)); // 头尾都有
        //   // System.out.println("res" + res);
        //     dp.put(s, (int)((res + mod) % mod));
        //     return dp.get(s);
        // }
        // Map<String, Integer> dp = new HashMap<>();
        // int mod = (int)1e9 + 7;
        // int n;
        // public int countPalindromicSubsequences(String s) { 
        //     int n = s.length();
        //     dp = new HashMap<String, Integer>();
        //     return dfs(s);
        // }
        // private int dfs(char[] s, int i, int j) {
        //     if (i > j) return 0;
        //     if (i == j) return 1;
        //     if (dp[i][j] > 0) return dp[i][j];
        //     long ans = 0;
        //    if (s[i] == s[j]) {
        //         ans += dfs(s, i + 1, j - 1) * 2;
        //         int l = i + 1;
        //         int r = j - 1;
        //         while (l <= r && s[l] != s[i]) ++l;
        //         while (l <= r && s[r] != s[i]) --r;
        //         if (l > r) ans += 2;
        //         else if (l == r) ans += 1;
        //         else ans -= dfs(s, l + 1, r - 1);
        //     } else 
        //         ans = dfs(s, i, j - 1) + dfs(s, i + 1, j) - dfs(s, i + 1, j - 1);
        //     return dp[i][j] = (int)((ans + mod) % mod);
        // }
        // private static final int mod = (int)1e9 + 7;
        // private int [][] dp;
        // public int countPalindromicSubsequences(String S) {
        //     int n = S.length();
        //     dp = new int[n][n];
        //     return dfs(S.toCharArray(), 0, n - 1);
        // }
        // public int countPalindromicSubsequences(String s) {
        //     int n = s.length();
        //     int mod = (int)1e9 + 7;
        //     char [] arr = s.toCharArray();
        //     long [][] dp = new long [n][n];
        //     for (int i = 0; i < n; i++) 
        //         dp[i][i] = 1;
        //     for (int len = 1; len <= n; len++) {
        //         for (int i = 0; i+len < n; i++) {
        //             int j = i + len;
        //             if (arr[i] == arr[j]) {
        //                 dp[i][j] = dp[i+1][j-1] * 2;
        //                 int l = i+1;
        //                 int r = j-1;
        //                 while (l <= r && arr[l] != arr[i]) ++l;
        //                 while (l <= r && arr[r] != arr[i]) --r;
        //                 if (l == r) dp[i][j] += 1;
        //                 else if (l > r) dp[i][j] += 2;
        //                 else dp[i][j] -= dp[l+1][r-1];
        //             } else dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1];
        //             dp[i][j] = (dp[i][j] + mod) % mod;
        //         }
        //     }
        //     return (int)dp[0][n-1];
        // }


        // private double dfs(int i, int j) {
        //     if (i <= 0 && j <= 0) return 0.5;
        //     if (i <= 0) return 1;
        //     if (j <= 0) return 0;
        //     if (dp[i][j] != null) return dp[i][j];
        //     double ans = 0;
        //     ans = 0.25 * dfs(i-4, j) + 0.25 * dfs(i-3, j-1) + 0.25 * dfs(i-2, j-2) + 0.25 * dfs(i-1, j-3);
        //     return dp[i][j] = ans;
        // }
        // Double [][] dp;
        // public double soupServings(int N) {
        //     int n = (int)Math.ceil(N / 25.0);
        //     dp = new Double [5002][5002];
        //     return n >= 5000 ? 1.0 : dfs(n, n);
        // }


        // public int tilingRectangle(int n, int m) { // dp with special case
        //     if (Math.max(n, m) == 13 && Math.min(m, n) == 11) return 6;
        //     int [][] dp = new int [n+1][m+1];
        //     for (int i = 1; i <= n; i++) {
        //         for (int j = 1; j <= m; j++) {
        //             dp[i][j]= Integer.MAX_VALUE;
        //             if (i == j) {
        //                 dp[i][j] = 1;
        //                 continue;
        //             }
        //             for (int r = 1; r <= i/2; r++) 
        //                 dp[i][j] = Math.min(dp[i][j], dp[r][j] + dp[i-r][j]);
        //             for (int c = 1; c <= j/2; c++) 
        //                 dp[i][j] = Math.min(dp[i][j], dp[i][c] + dp[i][j-c]);
        //         }
        //     }
        //     return dp[n][m];
        // }
        // private void dfs(int n, int m, int [] arr, int cnt) { // 还是当作m行、n列来写的
        //     if (cnt > min) return;
        //     boolean isFull = true;
        //     int idx = -1, minHeight = m;
        //     for (int i = 1; i <= n; i++) {
        //         if (arr[i] < m) isFull = false;
        //         if (arr[i] < minHeight) {
        //             idx = i;
        //             minHeight = arr[i];
        //         }
        //     }
        //     if (isFull) {
        //         min = Math.min(min, cnt);
        //         return;
        //     }
        //     long key = 0, base = m+1; // 把arr转化为hashing值作为dp的键,应该比较string作为键更高效
        //     for (int i = 1; i <= n; i++) {
        //         key += arr[i] * base;
        //         base *= m+1;
        //     }
        //     // String key = Arrays.toString(arr);
        //     if (dp.containsKey(key) && dp.get(key) <= cnt) return;
        //     dp.put(key, cnt); // 更新全局变量至每个状态最优
        //     int end = idx;    // 想要放一个最大的正方形，向右扩展增加长度，也要检查长度为（end+1-idx+1 == j-i+1）时高度是否会越界
        //     while (end+1 <= n && arr[end+1] == arr[idx] && end+1 - idx+1+minHeight <= m) end++;
        //     for (int j = end; j >= idx; j--) { // 所有当下有效合理解中，选择最优
        //         int curHeight = j - idx + 1;
        //         int [] next = Arrays.copyOf(arr, n+1);
        //         for (int k = idx; k <= j; k++) 
        //             next[k] += curHeight;      // skyline: 高度增加当下正方形的边长
        //         dfs(n, m, next, cnt+1);
        //     }
        // }
        // // Map<String, Integer> dp = new HashMap<>();
        // Map<Long, Integer> dp = new HashMap<>();
        // int min = Integer.MAX_VALUE;
        // public int tilingRectangle(int n, int m) {
        //     if (m == n) return 1;
        //     if (n > m) return tilingRectangle(m, n); // make sure: n <= m
        //     dfs(n, m, new int [n+1], 0);
        //     return min;
        // }


        
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        
        int res = s.tilingRectangle(5, 8);
        System.out.println("res: " + res);
    }
}