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


        // private void turnOffRegion(int [][] arr, int n, int x, int y) {
        //     for (int i = Math.max(0, x-1); i <= Math.min(n-1, x+1); i++) 
        //         for (int j = Math.max(0, y-1); j <= Math.min(n-1, y+1); j++) 
        //             if (arr[i][j] > 1) arr[i][j] = 0;
        //             else if (arr[i][j] == 1) dfs(arr, n, i, j, false);
        // }
        // public int[] gridIllumination(int n, int[][] lit, int[][] q) {
        //     int [][] arr = new int [n][n];
        //     for (int [] on : lit) {
        //         if (arr[on[0]][on[1]] != 1) arr[on[0]][on[1]] = 1;
        //         dfs(arr, n, on[0], on[1], true);
        //     }
        //     int [] ans = new int [q.length];
        //     for (int i = 0; i < q.length; i++) {
        //         System.out.println("\n i: " + i);
        //   ans[i] = arr[q[i][0]][q[i][1]] > 0 ? 1 : 0;
        //         turnOffRegion(arr, n, q[i][0], q[i][1]);
        //         for (int x = 0; x < n; x++) 
        //             for (int y = 0; y < n; y++) 
        //                 if (arr[x][y] == 1)
        //                     dfs(arr, n, x, y, true);
        //         System.out.println("arr.length: " + arr.length);
        //         for (int z = 0; z < arr.length; ++z) 
        //             System.out.println(Arrays.toString(arr[z]));
        //     }
        //     return ans;
        // }
        // private void dfs(int [][] arr, int n, int x, int y, boolean on) { // TLE TLE TLE
        //     for (int i = 0; i < n; i++) // same col : on
        //         if (arr[i][y] != 1) arr[i][y] = (on ? 2 : 0);
        //     for (int j = 0; j < n; j++)
        //         if (arr[x][j] != 1) arr[x][j] = (on ? 2 : 0);
        //     int i = x, j = y;
        //     while (i-1 >= 0 && j-1 >= 0) {
        //         i -= 1 ;
        //         j -= 1;
        //         if (arr[i][j] != 1) arr[i][j] = (on ? 2 : 0);
        //     }
        //     i = x; j = y;
        //     while (i+1 < n && j+1 < n) {
        //         i += 1;
        //         j += 1;
        //         if (arr[i][j] != 1) arr[i][j] = (on ? 2 : 0);
        //     }
        //     i = x; j = y;
        //     while (i+1 < n && j-1 >= 0) {
        //         i += 1;
        //         j -= 1;
        //         if (arr[i][j] != 1) arr[i][j] = (on ? 2 : 0);
        //     }
        //     i = x; j = y;
        //     while (i-1 >= 0 && j+1 < n) {
        //         i -= 1;
        //         j += 1;
        //         if (arr[i][j] != 1) arr[i][j] = (on ? 2 : 0);
        //     }
        //     if (!on) arr[x][y] = 0;
        // }
        // private Set<Integer> litInRegion(int [][] arr, int n, int x, int y) {
        //     Set<Integer> s = new HashSet<>();
        //     for (int i = Math.max(0, x-1); i <= Math.min(n-1, x+1); i++) 
        //         for (int j = Math.max(0, y-1); j <= Math.min(n-1, y+1); j++) 
        //             if (arr[i][j] == 1) s.add(i * n + j);
        //     return s;
        // }
        // public int[] gridIllumination(int n, int[][] lit, int[][] q) { // 倒着遍历的思路不对，受前面敲转块影响，独特的倒序在这里是行不通滴~
        //     int [][] arr = new int [n][n];
        //     for (int [] on : lit) 
        //         arr[on[0]][on[1]] = 1;
        //     System.out.println("arr.length: " + arr.length);
        //     for (int z = 0; z < arr.length; ++z) 
        //         System.out.println(Arrays.toString(arr[z]));
        //     Map<Integer, Set<Integer>> map = new HashMap<>();
        //     Set<Integer> cri = new HashSet<>();
        //     for (int i = 0; i < q.length-1; i++) {
        //         int [] v = q[i];
        //         Set<Integer> lits = litInRegion(arr, n, v[0], v[1]);
        //         map.put(i, lits);
        //         cri.addAll(lits);
        //     }
        //     for (int i = 0; i < n; i++) 
        //         for (int j = 0; j < n; j++) 
        //             if (arr[i][j]== 1 && cri.contains(i*n+j)) arr[i][j] = 0;
        //             // else if (arr[i][j] == 1)
        //             //     dfs(arr, n, i, j, true);
        //     // 这里bug造就不同的原因，真是让人百思不得其解。。。。。。
        //     for (int i = 0; i < n; i++) 
        //         for (int j = 0; j < n; j++) 
        //             if (arr[i][j]== 1)
        //                 dfs(arr, n, i, j, true);
        //     int [] ans = new int [q.length];
        //     for (int i = q.length-1; i >= 0; i--) { // 所以，这个倒序遍历，我并没能想得很彻底
        //         ans[i] = arr[q[i][0]][q[i][1]] > 0 ? 1 : 0;
        //         if (i == 0 || i > 0 && map.get(i-1).size() == 0) continue;
        //         for (Integer idx : map.get(i-1)) {
        //             int x = idx / n;
        //             int y = idx % n;
        //             arr[x][y] = 1; // // 这里的bug是：当倒序遍历，当我想要把这些灯打开，其实我并不能确定我可以在这个时候打开，还是它可以在原本更早的时候打开
        //             dfs(arr, n, x, y, true);
        //         }
        //     }
        //     return ans;
        // }
        // private Set<Integer> litInRegion(int [][] arr, int n, int x, int y) {
        //     Set<Integer> s = new HashSet<>();
        //     for (int i = Math.max(0, x-1); i <= Math.min(n-1, x+1); i++) 
        //         for (int j = Math.max(0, y-1); j <= Math.min(n-1, y+1); j++) 
        //             if (arr[i][j] == 1) s.add(i * n + j);
        //     return s;
        // }
        // private static final int [][] dirs = {{-1, -1}, {-1, 0}, {-1, 1},
        //                  {0, -1}, {0, 0}, {0, 1},
        //                  {1, -1}, {1, 0}, {1, 1}};
        // public int[] gridIllumination(int n, int[][] lit, int[][] q) {
        //     Set<Long> l = new HashSet<>(); // Storing lamps to prevent dupes
        //     Map<Integer, Integer> hor = new HashMap<>(); // Horizontal
        //     Map<Integer, Integer> ver = new HashMap<>(); // Vertical
        //     Map<Integer, Integer> dia = new HashMap<>(); // Diagonal
        //     Map<Integer, Integer> ant = new HashMap<>(); // Anti-Diagonal
        //     for (int [] v : lit)
        //         if (l.add((long)v[0]*n+v[1])) {
        //             hor.put(v[0], hor.getOrDefault(v[0], 0) + 1);
        //             ver.put(v[1], ver.getOrDefault(v[1], 0) + 1);
        //             dia.put(v[1]-v[0], dia.getOrDefault(v[1]-v[0], 0) + 1);
        //             ant.put(v[0]+v[1], ant.getOrDefault(v[0]+v[1], 0) + 1);
        //         }
        //     int [] ans = new int [q.length];
        //     for (int i = 0; i < q.length; i++) {
        //         int [] v = q[i];
        //         if (hor.getOrDefault(v[0], 0) > 0 || ver.getOrDefault(v[1], 0) > 0
        //             || dia.getOrDefault(v[1]-v[0], 0) > 0 || ant.getOrDefault(v[0]+v[1], 0) > 0)
        //             ans[i] = 1;
        //         for (int [] d : dirs) {
        //             int x = v[0] + d[0];
        //             int y = v[1] + d[1];
        //             if (x < 0 || x >= n || y < 0 || y >= n) continue;            
        //             if (l.contains((long)x*n+y)) { // 这个位置是灯塔
        //                 hor.put(x, hor.get(x)-1);
        //                 ver.put(y, ver.get(y)-1);
        //                 dia.put(y-x, dia.get(y-x)-1);
        //                 ant.put(x+y, ant.get(x+y)-1);
        //                 l.remove((long)x*n+y);
        //             } 
        //         }
        //     }
        //     return ans;
        // }


        // private long dfs(int cur, int n, int k) { // tle tle tle 有没有什么剪枝的优化呢？
        //     if (dp[cur][k] > 0) return dp[cur][k];
        //     if (k == 0) return 1;
        //     long ans = 0;
        //     for (int i = cur+1; i < n; i++) 
        //         ans += (i-cur) * dfs(i, n, k-1);
        //     return dp[cur][k] = ans % mod;
        // }
        // int mod = (int)1e9 + 7;
        // long [][] dp;
        // int n;
        // public int numberOfSets(int nn, int k) {
        //     if (k == nn-1) return 1;
        //     n = nn;
        //     dp = new long [n][k+1];
        //     return (int)dfs(0, n, k);
        // } 
        // public int numberOfSets(int n, int k) {
        //     int mod = (int)1e9 + 7;
        //     long [][][] dp = new long [n][k+1][2]; // dp[i][j][0/1]: 0, 1, 2 ... i形成j段线段，并且第j段线段是1（否0）以点i结尾
        //     dp[0][0][0] = 1;
        //     for (int i = 1; i < n; i++) {
        //         for (int j = 0; j <= k; j++) {
        //             dp[i][j][0] = (dp[i-1][j][0] + dp[i-1][j][1]) % mod;
        //             dp[i][j][1] = dp[i-1][j][1];
        //             if (j > 0)
        //                 dp[i][j][1] = (dp[i][j][1] + dp[i-1][j-1][0] + dp[i-1][j-1][1]) % mod; 
        //         }
        //     }
        //     return (int)((dp[n-1][k][0] + dp[n-1][k][1]) % mod);
        // }


        // public int countOrders(int n) {
        //     int mod = (int)1e9 + 7;
        //     int spots = n * 2;
        //     long ans = 1;
        //     for (int i = n; i >= 2; i--) {
        //         ans = (ans * spots * (spots - 1) / 2l) % mod;
        //         spots -= 2;
        //     }
        //     return (int)ans;
        // }


        // private boolean isValid(int val) {
        //     String s = String.valueOf(val);
        //     int n = s.length();
        //     for (char c : inval) 
        //         if (s.indexOf(c) != -1) return false;
        //     int cnt = 0;
        //     for (char c : valid) 
        //         if (s.indexOf(c) != -1) cnt++;
        //     return cnt > 0;
        // }
        // char [] valid = {'2', '5', '6', '9'};
        // char [] inval = {'3', '4', '7'};
        // public int rotatedDigits(int n) {
        //     int res = 0;
        //     for (int i = 1; i <= n; i++) 
        //         if (isValid(i)) 
        //             ++res;   
        //     return res;
        // }


        // private double dfs(int n, int i, int j, int k) {
        //     if (i < 0 || j < 0 || i >= n || j >= n) return 0;
        //     if (k == 0) return 1;
        //     if (dp[i][j][k] > 0) return dp[i][j][k];
        //     double ans = 0;
        //     for (int [] d : dirs) {
        //         int x = i + d[0];
        //         int y = j + d[1];
        //         ans += 0.125*dfs(n, x, y, k-1);
        //     }
        //     return dp[i][j][k] = ans;
        // }
        // double [][][] dp;
        // int [][] dirs = {{-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}};
        // public double knightProbability(int n, int k, int row, int column) {
        //     if (k == 0) return 1.0;
        //     dp = new double[n][n][k+1];
        //     return dfs(n, row, column, k);
        // }


        // public int countSpecialSubsequences(int[] arr) { // 去找个降维的参考一下
        //     int mod = (int)1e9 + 7;
        //     int n = arr.length;
        //     long [][] dp = new long [n][3];
        //     for (int i = 0; i < n; i++) 
        //         for (int j = 0; j < 3; j++) {
        //             if (arr[i] != j) dp[i][j] = (i == 0 ? 0 : dp[i-1][j]);
        //             else 
        //                 if (j == 0)
        //                     dp[i][j] = (i == 0 ? 0 : dp[i-1][j]) * 2 % mod + 1;
        //                 else
        //                     dp[i][j] = ((i == 0 ? 0 : dp[i-1][j]) * 2 % mod + (i == 0 ? 0 : dp[i-1][j-1])) % mod;
        //         }
        //     return (int)dp[n-1][2];
        // }

        
        // private long dfs(int [] group, int [] profit, int minProfit, int idx, int cur, int n) {
        //     // if (n == 0 || idx == m) return 0;
        //     if (n == 0) return 0;
        //     if (idx == m) return 1;
        //     if (dp[idx][cur][n] > 0) return dp[idx][cur][n];
        //     long ans = cur >= minProfit ? 1 : 0; //  这里还是有点儿没想清楚
        // }
        // long mod = (int)1e9 + 7;
        // long [][][] dp;
        // int m;
        // public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        //     m = group.length;
        //     dp = new long [m][minProfit+1][n+1];
        //     return (int)dfs(group, profit, minProfit, 0, 0, n);
        // }


        // public int findIntegers(int n) {
        //     String s = new StringBuilder(Integer.toBinaryString(n)).reverse().toString();
        //     int m = s.length();
        //     int [] one = new int [m];  // 1, the number of binary strings of length i which do not contain any two consecutive 1’s and which end in 1
        //     int [] zero = new int [m]; // 0, the number of binary strings of length i which do not contain any zero consecutive 1’s and which end in 0
        //     one[0] = 1;
        //     zero[0] = 1;
        //     for (int i = 1; i < m; i++) {
        //         zero[i] = zero[i-1] + one[i-1];
        //         one[i] = zero[i-1];
        //     }
        //     int ans = one[m-1] + zero[m-1];
        //     for (int i = m-2; i >= 0; i--) {
        //         if (s.charAt(i) == '1' && s.charAt(i+1) == '1') break;
        //         if (s.charAt(i) == '0' && s.charAt(i+1) == '0')
        //             ans -= one[i];
        //     }
        //     return ans;
        // }
        // public int findIntegers(int n) {
        //     int ans = 0, k = 31, pre = 0;
        //     int [] f = new int [32];
        //     f[0] = 1;
        //     f[1] = 2;
        //     for (int i = 2; i < 31; i++) 
        //         f[i] = f[i-1] + f[i-2];
        //     while (k >= 0) {
        //         if ((n & (1 << k)) > 0) { // > 0 不是 == 1
        //             ans += f[k];
        //             if (pre == 1) return ans;
        //             pre = 1;
        //         } else pre = 0;
        //         --k;
        //     }
        //     return ans + 1;
        // }


        // // dp[i][j] 表示途径 i 条道路跳过 j 次休息情况下的最小用时，遍历过程中根据上一道路是否休息选取最小值，结合状态转移方程求解。
        // public int minSkips(int[] dist, int speed, int hoursBefore) {
        //     int n = dist.length;
        //     double eps = 1e-8, inf = 1e10; // eps用于避免浮点数计算误差导致向上取整后出现错误，inf作为最大值初始化动态规划数组
        //     double[][] dp = new double[n+1][n+1];
        //     for (int i = 0; i <= n; i++) 
        //         Arrays.fill(dp[i], inf);
        //     dp[0][0] = 0;
        //     for (int i = 1; i <= n; i++) {
        //         double t = (double)dist[i-1] / speed;       // 第i条道路耗时
        //         dp[i][0] = Math.ceil(dp[i-1][0] - eps) + t; // 单独计算不跳过休息时的值
        //         dp[i][i] = dp[i-1][i-1] + t;                // 单独计算跳过所有休息时的值
        //         for (int j = i-1; j > 0; j--)               // 根据上一道路是否休息，确定最小值
        //             dp[i][j] = Math.min(Math.ceil(dp[i-1][j] - eps) + t, dp[i-1][j-1] + t);
        //     }
        //     for (int i = 0; i <= n; i++) 
        //         if (dp[n][i] <= hoursBefore + eps) return i;
        //     return -1;
        // }


//         private int getLargesetTimeNeeded(int [] arr, int mask) { // 存在一个bug，但是不知道怎么改
//             int max = 0;
//             for (int i = 0; i < arr.length; i++) 
//                 if (((mask >> i) & 1 ) == 1)
//                     max = Math.max(max, arr[i]);
//             return max;
//         }
//         public int minimumTime(int n, int[][] relations, int[] time) {
//             int [] pre = new int [n]; // bitmask representing prerequirements
//             for (int i = 0; i < relations.length; i++) {
//                 int u = relations[i][0] - 1;
//                 int v = relations[i][1] - 1;
//                 pre[v] |= (1 << u);
//             }
//             int range = (1 << n);
//             int [] dp = new int [range];          // dp[state] = minimum semesters to complete all the courses of 'state'.
//             Arrays.fill(dp, Integer.MAX_VALUE/3);
//             dp[0] = 0;
//             for (int i = 0; i < range; i++) {
//                 int available = 0;
//                 for (int j = 0; j < n; j++)
//                     if ((i & pre[j]) == pre[j]) // 可是包含了已经选过的课程: 这个bug可能是：有一门耗时很长的课，可以现在选，但我大概可以把它推后到同耗时长的课一起选以减少总消耗时间,可一时半会儿还是想不出来这个bug该如何改
//                         available |= (1 << j); // Can study course j next, since all required courses have been studied.
//                 available &= ~i; // Don't want to study those already studied courses.
//                 int nextCourses = available;
//                 // dp[i | nextCourses] = Math.min(dp[i | nextCourses], dp[i] + getLargesetTimeNeeded(time, nextCourses));
//                 while (nextCourses > 0) {
//                     // System.out.println("Integer.toBinaryString(nextCourses): " + Integer.toBinaryString(nextCourses));
//                     // System.out.println("getLargesetTimeNeeded(time, nextCourses): " + getLargesetTimeNeeded(time, nextCourses));
//                     dp[i | nextCourses] = Math.min(dp[i | nextCourses], dp[i] + getLargesetTimeNeeded(time, nextCourses));
// // 遍历现在可选课程的所有子集： Enumerate all subsets. E.g, available = 101, next: 100 -> 001 -> 000
//                     nextCourses = (nextCourses -1) & available;
//                 }
//             }
//             return dp[range-1];
//         }
        // int [][] a = new int [][] {{2,7},{2,6},{3,6},{4,6},{7,6},{2,1},{3,1},{4,1},{6,1},{7,1},{3,8},{5,8},{7,8},{1,9},{2,9},{6,9},{7,9}};
        // int []  b = new int []  {9, 5, 9, 5, 8, 7, 7, 8, 4};
        // int r = s.minimumTime(9, a, b);
        // 这个题回头再多看看，感觉有思维定势，并且很严重
        // T = O(V+E) 
        // S = O(V+E)
        // public long dfs(int u, List<Integer> [] list, int [] time, long [] comp) {
        //     long val = 0l;
        //     for (int v : list[u]) {
        //         if (comp[v] == -1)
        //             dfs(v, list, time, comp);
        //         val = Math.max(val, comp[v]);
        //     }
        //     return comp[u] = val + time[u-1];
        // }
        // public int minimumTime(int n, int[][] relations, int[] time) {
        //     List<Integer> list [] = new ArrayList[n+1];
        //     for (int i = 0; i <= n; i++) 
        //         list[i] = new ArrayList<>();
        //     for (int [] r : relations) 
        //         list[r[1]].add(r[0]);
        //     long [] comp = new long [n+1];
        //     Arrays.fill(comp, -1l);
        //     long ans = 0l;
        //     for (int i = 1; i <= n; i++) {
        //         if (comp[i] == -1)
        //             dfs(i, list, time, comp);
        //         ans = Math.max(ans, comp[i]);
        //     }
        //     return (int)ans;
        // }

        // 思路：
        // dp[i][j] 表示：words字符串列表的前 j 列来构造目标字符串target的前 i 个字符；
        // cnt[i][j] 表示：words字符串列表的第 i 列 一共有多少 字符 j ；
        // 那dp公式就很好推出来了：
        // 1.第i个字符不使用第j列时，即通过前 j - 1 列得到
        //   dp[i][j] = dp[i][j-1];
        // 2.第i个字符使用第j列时
        // *   dp[i][j] = dp[i-1][j-1] * cnt[j][第i个字符]；
        //     dp[i][j] = dp[i][j-1] + dp[i-1][j-1] * cnt[j][第i个字符]
        // public int numWays(String[] words, String target) {
        //     int m = target.length(), n = words[0].length();
        //     int mod = (int)1e9 + 7;
        //     int [][] cnt = new int [n][26];
        //     for (int i = 0; i < words.length; i++) 
        //         for (int j = 0; j < n; j++) 
        //             cnt[j][words[i].charAt(j)-'a']++;
        //     long [][] dp = new long [m][n];
        //     dp[0][0] = cnt[0][target.charAt(0)-'a'] % mod;
        //     for (int i = 1; i < n; i++) 
        //         dp[0][i] = (dp[0][i] + dp[0][i-1] + cnt[i][target.charAt(0)-'a']) % mod;
        //     for (int i = 1; i < m; i++) 
        //         for (int j = i; j < n; j++) 
        //             dp[i][j] = (dp[i][j-1] + dp[i-1][j-1]*cnt[j][target.charAt(i)-'a']) % mod;
        //     return (int)dp[m-1][n-1];
        // }
        // public int numWays(String[] words, String target) {
        //     int m = target.length(), n = words[0].length();
        //     int mod = (int)1e9 + 7;
        //     long [] dp = new long [m];
        //     for (int i = 0; i < n; i++) {
        //         int [] cnt = new int [26];
        //         for (String s : words) 
        //             cnt[s.charAt(i)-'a']++;
        //         for (int j = Math.min(i, m-1); j >= 0; j--) 
        //             dp[j] = (dp[j] + (j > 0 ? dp[j-1] : 1) * cnt[target.charAt(j)-'a']) % mod;
        //     }
        //     return (int)dp[m-1];
        // }


        // private int [] computeLongestPrefixSuffix (char [] s) { // 这个要再理解一下
        //     int n = s.length;
        //     int [] lps = new int [n];
        //     for (int i = 1, j = 0; i < n; i++) {
        //         while (j > 0 && s[i] != s[j]) j = lps[j-1];  // 转向它 j 的前一位字符(在 j-1 下标)所指向的匹配位置 lps[j-1]
        //         if (s[i] == s[j]) lps[i] = ++j;
        //     }
        //     return lps;
        // }
        // private int getKey(int i, int j, boolean l, boolean r) { // bits occupied: i 9, j 6, l 1, r 1
        //     // 9 bits store n (2^9=512), 6 bits for m (2^6=64), 1 bit ro b1, 1 bit for b2
        //     return (i << 8) | (j << 2) | ((l ? 1 : 0) << 1) | (r ? 1 : 0); // 这是一个压缩空间存key的聪明技巧
        // } 
        // private int dfs(int n, int i, int evilMatched, boolean leftBound, boolean rightBound) {
        //     if (evilMatched == e.length) return 0; // matched evil string, no good
        //     if (i == n) return 1;                  // DIDN'T match evil string, great
        //     int key = getKey(i, evilMatched, leftBound, rightBound); // state: represented by <= 17 bits integer
        //     if (dp[key] > 0) return dp[key];
        //     char from = leftBound ? s[i] : 'a';
        //     char to = rightBound ? t[i] : 'z';
        //     int ans = 0;
        //     for (char c = from; c <= to; c++) { 
        //         int j = evilMatched; // j means the next match between current string (end at char `c`) and `evil` string
        //         while (j > 0 && e[j] != c) j = lps[j-1]; // 向左回塑寻找match字符c的上一个位置 ？
        //         if (c == e[j]) j++;
        //         ans += dfs(n, i+1, j, leftBound && (c == from), rightBound && (c == to));
        //         ans %= mod;
        //     }
        //     return dp[key] = ans;
        // }
        // int mod = (int)1e9 + 7;
        // char [] s, t, e;
        // int [] dp, lps;
        // public int findGoodStrings(int n, String s1, String s2, String evil) {
        //     dp = new int [1 << 17]; // Need total 17 bits, according to data limits
        //     s = s1.toCharArray();
        //     t = s2.toCharArray();
        //     e = evil.toCharArray();
        //     lps = computeLongestPrefixSuffix(e);
        //     return dfs(n, 0, 0, true, true);
        // }
        // public int findGoodStrings(int n, String s1, String s2, String evil) {
        //     dp = new int [1 << 17]; // Need total 17 bits, according to data limits
        //     s = s1.toCharArray();
        //     t = s2.toCharArray();
        //     e = evil.toCharArray();
        //     lps = computeLongestPrefixSuffix(e);
        //     return dfs(n, 0, 0, true, true);
        // }
        // static final int mod = 1000000007;
        // public int findGoodStrings(int n, string s1, string s2, string evil) {
        //     int m = evil.size();
        //     int [] next = new int [m + 1];
        //     next[0] = -1;
        //     for (int j = 0, k = -1; j < m; ) {
        //         if (k == -1 || evil[j] == evil[k]) next[++j] = ++k;
        //         else k = next[k];
        //     }
        //     int f = s1.find(evil) == -1 ? 1 : 0;
        //     return (cal(n, s2, evil, next) - cal(n, s1, evil, next) + f + mod) % mod;
        // }
        // int cal(int n, string s, string evil, int [] next) {
        //     int m = evil.size();
        //     int [][][] dp = new int [n + 1][m][2];
        //     // dp[i][j][0] 前i个字符 和evil有j个相同 0不和s相等 1和s相等
        //     // memset(dp, 0, sizeof dp);
        //     dp[0][0][1] = 1;
        //     for (int i = 0; i < n; i++) {
        //         for (int j = 0; j < m; j++) {
        //             for (char c = 'a'; c <= 'z'; c++) {
        //                 int len = getNextLen(evil, next, j, c);
        //                 if (len < m) {
        //                     if (c < s[i]) {
        //                         up(dp[i+1][len][0], dp[i][j][1]);
        //                     } 
        //                     if (c == s[i]) {
        //                         up(dp[i+1][len][1], dp[i][j][1]);
        //                     }
        //                     up(dp[i+1][len][0], dp[i][j][0]);
        //                 }
        //             }
        //         }
        //     }
        //     int ans = 0;
        //     for (int i = 0; i < m; i++) {
        //         up(ans, dp[n][i][0]);
        //         up(ans, dp[n][i][1]);
        //     }
        //     return ans;
        // }
        // int getNextLen(string &evil, int nt[], int len, char c) {
        //     while (len != -1 && evil[len] != c) len = nt[len];
        //     return len + 1;
        // }
        // void up(int &x, int add) {
        //     x = (x + add) % mod;
        // }


        // public String longestPrefix(String s) {
        //     int n = s.length(), hashPre = 0, hashSuf = 0;
        //     int left = 0, right = n-1, pow = 1, maxLen = 0;
        //     String res = "";
        //     while (left < n-1) {
        //         hashPre = hashPre * 31 + s.charAt(left);
        //         hashSuf = hashSuf + s.charAt(right)*pow;
        //         if (hashPre == hashSuf) maxLen = left + 1;
        //         left ++;
        //         right --;
        //         pow *= 31;
        //     }
        //     return maxLen == 0 ? "" : s.substring(0, maxLen);
        // }
        // public String longestPrefix(String ss) {
        //     int n = ss.length();
        //     char [] s = ss.toCharArray();
        //     int [] lps = new int [n];
        //     for (int i = 1, j = 0; i < n; i++) {
        //         while (j > 0 && s[i] != s[j])
        //             j = lps[j-1];
        //         if (s[i] == s[j])
        //             lps[i] = ++j;
        //     }
        //     return ss.substring(0, lps[n-1]);
        // }

        
        // public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) { // 0-1背包问题：每场罪恶在每个状态里最多只能存在一次
        //     int mod = (int)1e9 + 7, ans = 0;
        //     int m = group.length;
        //     int [][][] dp = new int [m+1][n+1][minProfit + 1]; 
        //     dp[0][0][0] = 1;
        //     for (int k = 1; k <= m; k++) {
        //         int p = profit[k-1], g = group[k-1];
        //         for (int i = 0; i <= n; i++) 
        //             for (int j = 0; j <= minProfit; j++) {
        //                 dp[k][i][j] = dp[k-1][i][j];
        //                 if (i >= g)
        //                     dp[k][i][j] = (dp[k][i][j] + dp[k-1][i-g][Math.max(0, j-p)]) % mod;
        //             }
        //     }
        //     for (int i = 0; i <= n; i++) 
        //         ans = (ans + dp[m][i][minProfit]) % mod;
        //     return ans;
        // }
        // 设计一个动态规划数组 dp[i][j], 表示参与员工不超过 i 人且利润不小于 j 的计划数，则对所需员工数为 g、利润值为 p 的任务，状态转移方程为 dp[i][j] = dp[i][j] + dp[i - g][Math.max(j - p, 0)]。
        // public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) { // 0-1背包问题：每场罪恶在每个状态里最多只能存在一次
        //     int mod = (int)1e9 + 7, ans = 0;
        //     int m = group.length;
        //     int [][] dp = new int [n+1][minProfit + 1]; 
        //     dp[0][0] = 1;
        //     for (int k = 1; k <= m; k++) {
        //         int p = profit[k-1], g = group[k-1];
        //         for (int i = n; i >= g; i--)  // i >= 
        //             for (int j = minProfit; j >= 0; j--) 
        //                 dp[i][j] = (dp[i][j] + dp[i-g][Math.max(0, j-p)]) % mod; // 保证了这一行覆盖原数组的正确性
        //     }
        //     for (int i = 0; i <= n; i++) 
        //         ans = (ans + dp[i][minProfit]) % mod;
        //     return ans;
        // }
        // 记忆搜索。记 flag[G][P][k] 为从第 k 个犯罪开始， G 个罪犯， P 的收益， 最大的可能性。 深度优先搜索，并将计算的结果记录下来，下次出现时，直接返回。
        // private int dfs(int [] group, int [] profit, int n, int j) {
        // } 


//         public int numberOfArithmeticSlices(int [] arr) { // 有一个类似的题目，找3个什么的个数，用几个map
//             int n = arr.length;
//             Map<Integer, Integer> need = new HashMap<>(); // k, v: val, needCnt
//             Map<Integer, List<Integer>> difList = new HashMap<>(); // list 有很多种打头元素的可能性 Set<List<Integer>> to record all same diff differnt lists
//             for (int i = 0; i < n; i++) { //
//                 for (int j = i+1; j < n; j++) {
//                     int dif = arr[j] - arr[i]; // 
//                     int next = arr[j] + dif;
//                     need.put(next, need.getOrDefault(next, 0) + 1);
//                     difList.computeIfAbsent(dif, z -> new ArrayList<>()).add(arr[i]);
//                     difList.get(dif).add(arr[j]);
//                 }
//             }
// // after getting all different available dif lists, cnt number of subsequences 
//         }
        // public int numberOfArithmeticSlices(int [] arr) {
        //     int n = arr.length, ans = 0;
        //     Map<Integer, Integer> [] dp = new HashMap[n];
        //     dp[0] = new HashMap<>();
        //     for (int i = 1; i < n; i++) {
        //         dp[i] = new HashMap<>();
        //         for (int j = 0; j < i; j++) {
        //             long diff = (long)arr[i] - arr[j];
        //             if (diff > Integer.MAX_VALUE || diff < Integer.MIN_VALUE) continue;
        //             int dif = (int)diff;
        //             int cntI = dp[i].getOrDefault(dif, 0);
        //             int cntJ = dp[j].getOrDefault(dif, 0);
        //             ans += cntJ; // 更新结果
        //             dp[i].put(dif, cntI + cntJ + 1);
        //         }
        //     }
        //     return ans;
        // }


        // private int dfs(int i) {
        //     if (i >= n) return 0;
        //     if (i == n-1) return s[i] == '*' ? (dp[i] = 9) : (s[i] == '0' ? (dp[i] = 0) : (dp[i] = 1));
        //     if (dp[i] > 0) return dp[i];
        //     int res = 0;
        //     if (s[i] == '0') return dp[i] = (int)dfs(i+1) % mod;
        //     if (s[i+1] == '0') 
        //         res = dfs(i+2) % mod; // 30 ? s[i+1] == '0'
        //     else { 
        //         res = (res + dfs(i+1)) % mod; // separate
        //         if (s[i] == '1' || ((s[i] == '2' || s[i] == '*') && (s[i+1] == '*' || s[i+1]-'a' <= 6))) // combine together with next digit
        //             if (s[i] == '1' || s[i+1] != '*')
        //                 res = (res + dfs(i+1)) % mod;
        //             // else if (s[i+1] != '*')
        //             //     res = (res + dfs(s, i+1)) % mod;
        //             else if ((s[i] == '2' || s[i] == '*') && s[i+1] == '*')
        //                 res = (res + (i+1 == n-1 ? 6 : 2 * dfs(i+1) / 3)) % mod;
        //     }
        //     return dp[i] = (int)res;
        // }
        // int mod = (int)(1e9 + 7);
        // char [] s;
        // int [] dp;
        // int n;
        // public int numDecodings(String t) {
        //     n = t.length();
        //     s = t.toCharArray();
        //     if (n == 1) return s[0] == '*' ? 9 : 1;
        //     dp = new int [n];
        //     dfs(0);
        //     return dp[0];
        // }

        
        // private int dfs(String t, int idx, int pre) {
        //     if (dp[idx][pre] > 0) return dp[idx][pre];
        //     if (s[idx] == '0') return 0;
        //     if (idx == n) return 1;
        //     int ans = 0;
        //     for (int j = idx; j < n; j++) {
        //         int cur = Integer.parseInt(t.substring(idx, j+1));
        //         // if (cur < pre) continue;
        //         if (cur >= pre) continue;
        //         ans = (ans + dfs(t, j+1, cur)) % mod;
        //     }
        //     return dp[idx][pre] = ans;
        // }
        // int mod = (int)1e9 + 7;
        // int [][] dp;
        // char [] s;
        // int n;
        // public int numberOfCombinations(String t) {
        //     n = t.length();
        //     s = t.toCharArray();
        //     dp = new int [n][];
        //     return dfs(t, 0, 0);
        // }
        // // memory limit exceeded
        // private void getLongestCommonPrefixLength() { // Pre compute Longest Common Prefix sequence for each index in the string
        //     for (int i = n-1; i >= 0; i--)            // 从右向左遍历，计算最长公共前缀序列长度
        //         for (int j = n-1; j >= 0; j--) 
        //             if (s[i] == s[j])
        //                 lcp[i][j] = lcp[i+1][j+1] + 1;
        // }
        // private boolean compare(int i, int j, int len) { // compare substring of same length for value, 
        //     int commonLength = lcp[i][j];                // 返回以i开始长度为len的序列 是否 比以j开始长度为len的序列（数值）小
        //     if (commonLength >= len) return true;
        //     if (s[i + commonLength] <= s[j + commonLength]) // <= ? 为什么不可以等于呢？
        //         return true;
        //     return false;
        // }
        // long mod = (int)1e9 + 7;
        // int [][] lcp;
        // long [][] dp;
        // long [][] dps;
        // char [] s; 
        // int n;
        // public int numberOfCombinations(String t) {
        //     if (t.charAt(0) == '0') return 0;
        //     n = t.length();
        //     this.s = t.toCharArray();
        //     lcp = new int[n + 1][n + 1];
        //     dp = new long[n + 1][n + 1];
        //     dps = new long[n + 1][n + 1];   // 从右向左的累加和
        //     getLongestCommonPrefixLength(); // 计算从右向左遍历的最长公共前缀（右边，其实是后缀）
        //     for (int i = n-1; i >= 0; i--) {
        //         if (s[i] == '0') continue; // leading zero at current current index
        //         long sum = 0; // for substring starting at index i
        //         for (int j = n-1; j >= i; j--) {
        //             if (j == n-1) {
        //                 dp[i][j] = 1; // whole substring from index i is a valid possible list of interger (single integer in this case)
        //             //     dp[i][j] = sum = (sum + dp[i][j]) % mod;
        //             //     continue;  // 为什么我这里不可以continue呢？太奇怪了,再想一想
        //             // }
        //             } else {
        //                 int len = j-i + 1;   // length of first integer (i-j) cur integer
        //                 int bgn = j + 1;     // second integer bgnart index
        //                 int end = bgn + len-1;// second integer end index
        //                 dp[i][j] = 0; // equal length integers should be comparend for value 这里 dp[i][j]是对于每个i每个j都重置结果吗？
        //                 if (end < n && compare(i, bgn, len)) // 为什么第一个数不可以等于后面的数呢？
        //                     dp[i][j] = dp[bgn][end];
        //                 if (end + 1 < n)  // including the second integers possibilities with length greater than 1bgn one.
        //                     dp[i][j] = (dp[i][j] + dps[bgn][end + 1]) % mod; // 从右向左，这里 dps[bgn][end + 1]实际上累积了右边第二个数长度大于第一个数的所有可能性
        //                 // dps[bgn][end + 1]  = > dp[bgn][end + 1].......dp[bgn][n-1]
        //             }
        //             dps[i][j] = sum = (sum + dp[i][j]) % mod; // 从右向左，累加所有的可能性，直到idx 为0
        //         }
        //     }
        //     return (int)dps[0][0];
        // }
        // private void getLongestCommonPrefixLength() { // Pre compute Longest Common Prefix sequence for each index in the string
        //     for (int i = n-1; i >= 0; i--)            // 从右向左遍历，计算最长公共前缀序列长度
        //         for (int j = n-1; j >= 0; j--) 
        //             if (s[i] == s[j]) {
        //                 if (i >= n-1 || j >= n-1) lcp[i][j] = 1;
        //                 else lcp[i][j] = lcp[i+1][j+1] + 1;
        //             } else lcp[i][j] = 0;
        // }
        // private boolean compare(int i, int j, int len) { // compare substring of same length for value, 
        //     int commonLength = lcp[i][j];                // 返回以i开始长度为len的序列 是否 比以j开始长度为len的序列（数值）小
        //     if (commonLength >= len) return true;
        //     return  s[i + commonLength] <= s[j + commonLength]; // <= ? 为什么不可以等于呢？
        // }
        // long mod = (int)1e9 + 7;
        // int [][] lcp;
        // char [] s; 
        // int n;
        // public int numberOfCombinations(String t) {
        //     if (t.charAt(0) == '0') return 0;
        //     n = t.length();
        //     this.s = t.toCharArray();
        //     lcp = new int[n][n];
        //     int [][] f = new int [n][n];
        //     int [][] pre = new int [n][n];  // 从右向左的累加和
        //     getLongestCommonPrefixLength(); // 计算从右向左遍历的最长公共前缀（右边，其实是后缀）
        //     for (int i = 0; i < n; i++) {
        //         f[0][i] = 1;
        //         pre[0][i] = 1;
        //     }
        //     for (int j = 1; j < n; j++) { // 跟上面超内存的写法是反着走，这次是从左向右遍历，可是两种方法，为什么就有一个会超内存呢？
        //         for (int i = 1; i <= j; i++) {
        //             if (s[i] == '0') {
        //                 f[i][j] = 0;
        //                 // continue;
        //             } else {
        //                 f[i][j] = pre[i-1][i-1];
        //                 if (i - (j-i+1) >= 0) // 现在长度为 i-j+1 的数，前面是否存在一个同样长度的数，即前一个数的第一个位下标是否 >= 0
        //                     f[i][j] -= pre[2*i-j-1][i-1];
        //                 if (i - (j-i+1) >= 0 && compare(i-(j-i+1), i, j-i+1)) {
        //                     f[i][j] = (int)((f[i][j] + pre[i-(j-i+1)][i-1]) % mod);
        //                     if (i - (j-i+1) - 1 >= 0)
        //                         f[i][j] -= pre[i-(j-i+1)-1][i-1];
        //                 }
        //             }
        //             f[i][j] = (int)((f[i][j] + mod) % mod);
        //             pre[i][j] = (int)((pre[i-1][j] + f[i][j]) % mod);
        //         }
        //     }
        //     return pre[n-1][n-1];
        // }
        // https://leetcode.com/problems/number-of-ways-to-separate-numbers/discuss/1417910/Java-O(N2)-Suffix-Array-%2B-Bottom-Up-DP-with-Explanation-(366-ms-beats-100)
        // https://leetcode.com/problems/number-of-ways-to-separate-numbers/discuss/1418347/Java-Two-solution-using-dp-and-suffix-arrays.-Algorithm-heavy
        // http://42.192.146.13/problems/number-of-ways-to-separate-numbers/solution/1977-hua-fen-shu-zi-de-fang-an-shu-by-le-lpus/
        // https://leetcode.com/problems/number-of-ways-to-separate-numbers/discuss/1424340/c-1977-number-of-ways-to-separate-numbers
        // static int mod = (int) 1e9 + 7;
        // public int numberOfCombinations(String num) {
        //     char[] s = num.toCharArray();
        //     int n = s.length;
        //     int [][] rank = new int[n][n + 1];
        //     PriorityQueue<int[]> pq = new PriorityQueue<int[]>(1, (a, b) -> a[1] - b[1]);
        //     for (int i = 1; i <= n; ++i) {
        //         int c = 0, prev = 0;
        //         for (int j = 0; j + i <= n; ++j)
        //             pq.add(new int [] {j, rank[j][i - 1] * 10 + s[i + j - 1] - '0'});
        //         while (!pq.isEmpty()) {
        //             int [] cur = pq.poll();
        //             if (cur[1] != prev) c++;
        //             rank[cur[0]][i] = c;
        //             prev = cur[1];
        //         }
        //     }
        //     int[][] dp = new int[n][n + 1];
        //     for (int j = n - 1; 0 <= j; --j) {
        //         if ('0' == s[j]) continue;
        //         int len = n - j;
        //         dp[j][len] = 1;
        //         for (int i = len - 1; 1 <= i; --i) {
        //             // dp[j][i] means the valid number that can start from j and the length of the first number is at least i
        //             // thus here I aggregate dp[j][i + 1] into dp[j][i]
        //             dp[j][i] = dp[j][i + 1];
        //             int next = i + j;                
        //             if (next >= n || next + i > n) continue;
        //             // if the rank of the next part is greater than the current one
        //             if (rank[j][i] <= rank[next][i]) dp[j][i] = (dp[j][i] + dp[next][i]) % mod;
        //             // otherwise we append the larger length as it's always greater than the current one
        //             else if (next + i < n) dp[j][i] = (dp[j][i] + dp[next][i + 1]) % mod;
        //         }
        //         dp[j][0] = dp[j][1];
        //     }
        //     return dp[0][0];
        // }


        // public int numDecodings(String t) { // 这里面要考虑的状态好多呀
        //     if (t.charAt(0) == '0') return 0;
        //     int n = t.length() + 1;
        //     if (n == 1) return t.charAt(0) != '*' ? 1 : 9;
        //     int mod = (int)1e9 + 7;
        //     t = "#" + t;
        //     char [] s = t.toCharArray();
        //     int [] dp = new int [n+1];
        //     dp[0] = 1;
        //     dp[1] = s[1] == '*' ? 9 : 1;
        //     for (int i = 2; i <= n; i++) { // 要把 * 号的考虑情况加进去
        //         char c = s[i], p = s[i-1];
        //         if (c == '0') {
        //             if (p != '*' && p-'0' >= 3) return 0;
        //             if (p != '*' && p - '0' <= 2)
        //                 dp[i] = dp[i-2];
        //             if (p == '*') dp[i] = dp[i-2] * 2;
        //         } else if (c != '*') { // [1, 9]
        //             dp[i] = dp[i-1];
        //             if (p != '*' && Integer.parseInt(t.substring(i-1, i+1) <= 26))
        //                 dp[i] += dp[i-2];
        //             else if (p == '*') {
        //                 if (c - '0' <= 6)     
        //                     dp[i] += dp[i-2] * 2;
        //                 else dp[i] += dp[i-2];
        //             }
        //         } else { // p == '*'
        //             if (c == '*') dp[i] = 9 * dp[i-1];
        //             else if (c == '1') dp[i] += 9 * dp[i-2];
        //             else if (c == '2') {
        //                 if ()
        //             }
        //         }
        //     }
        // }
        // public int numDecodings(String t) {
        //     int mod = (int)1e9 + 7;
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     System.out.println(Arrays.toString(s));
        //     int [] dp = new int [Math.max(2, n+1)];
        //     dp[0] = 1;
        //     dp[1] = s[0] == '*' ? 9 : s[0] == '0' ? 0 : 1;
        //     for (int i = 2; i <= n; i++) {
        //         System.out.println("i: " + i);
        //         for (int j = 1; j <= 26; j++) { // 枚举s的长i前缀的末尾可以解码为哪个大写字母
        //             char c = s[i-1];
        //             if (j <= 9) { // 如果是要解码为A到I，那么最后一个数字得单独解码
        //                 if (c == '*' || c == '0' + j)
        //                     dp[i] += dp[i-1];
        //             } else {      // 否则最后两个数字得一起解码
        //                 char p = s[i-2];
        //                 int x = j % 10, y = j / 10;
        //                 if ((p == '*' || p == y+ '0') && ((c == '*' && x != 0) || c == x + '0')) 
        //                     dp[i] += dp[i-2];
        //             }
        //             dp[i] %= mod;
        //         }
        //     }
        //     return dp[n];
        // }


        // public int getMaxRepetitions(String s1, int n1, String s2, int n2) { // tle tle tle
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
        // public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        //     char [] s = s1.toCharArray();
        //     char [] t = s2.toCharArray();
        //     int cnt = 0, ans = 0, idx = 0; // idx: index for s2
        //     while (cnt < n1) {
        //         for (int i = 0; i < s.length; i++)
        //             if (s[i] == t[idx]) {
        //                 idx++;
        //                 if (idx == t.length) {
        //                     idx = 0;
        //                     ans++;
        //                 }
        //             }
        //         cnt++;
        //     }
        //     return ans / n2;
        // }

         
        // public int kInversePairs(int n, int k) {
        //     int mod = (int)1e9 + 7;
        //     long [][] dp = new long [n+1][k+1];
        //     dp[0][0] = 1;
        //     for (int i = 1; i <= n; i++) {
        //         dp[i][0] = 1;
        //         for (int j = 1; j <= k; j++)  {
        //             dp[i][j] = dp[i][j-1] + dp[i-1][j];
        //             if (j >= i)
        //                 dp[i][j] -= dp[i-1][j-i];
        //             dp[i][j] = (dp[i][j] + mod) % mod;
        //         }
        //     }
        //     return (int)dp[n][k];
        // }
        // public int kInversePairs(int n, int k) {
        //     int mod = (int)1e9 + 7;
        //     int [][] dp = new int [n+1][k+1];
        //     dp[0][0] = 1;
        //     for (int i = 1; i <= n; i++) {
        //         long sum = 0;
        //         for (int j = 0; j <= k; j++) {
        //             sum += dp[i-1][j];
        //             if (j >= i)
        //                 sum -= dp[i-1][j-i];
        //             dp[i][j] = (int)(sum % mod);
        //         }
        //     }
        //     return (int)dp[n][k];
        // }

        
        // public int minChanges(int[] nums, int k) {
        //     int n = nums.length;
        //     int [][] cnt = new int [2007][1025];
        //     for (int v : nums) cnt[v]++;
        //     int [][] dp = new int [2007][1025];
        //     return dp[k][n];
        // }

        // public int minChanges(int[] arr, int k) {
        //     int n = arr.length;
        //     List<Map<Integer, Integer>> groups = new ArrayList<>();
        //     for (int i = 0; i < k; i++) 
        //         groups.add(new HashMap<>());
        //     int [] cnt = new int [k];
        //     for (int i = 0; i < k; i++) {
        //         for (int j = i; j < n; j += k) {
        //             groups.get(i).put(arr[j], groups.get(i).getOrDefault(arr[j], 0) + 1);
        //             cnt[i]++;
        //         }
        //     }
        //     int [] dp = new int [1 << 10]; // dp[val]表示处理到当前组时，异或值为val的最小修改次数
        //     Arrays.fill(dp, Integer.MAX_VALUE);
        //     dp[0] = 0;
        //     for (int i = 0; i < k; i++) {
        //         int lo = Arrays.stream(dp).min().getAsInt();
        //         int [] ndp = new int [1 << 10]; // 对每一组分别进行计数
        //         Arrays.fill(ndp, lo + cnt[i]);
        //         for (int j = 0; j < (1 << 10); j++) { // 遍历数组中每个元素的候选更换最小次数，相当于是暴搜
        //             if (dp[j] == Integer.MAX_VALUE) continue;
        //             for (Map.Entry<Integer, Integer> en : groups.get(i).entrySet()) {
        //                 int key = en.getKey(), v = en.getValue();
        //                 int next = key ^ j;
        //                 ndp[next] = Math.min(ndp[next], dp[j] + cnt[i] - v);
        //             }
        //         }
        //         dp = ndp;
        //     }
        //     return dp[0];
        // }
        // public int minChanges(int[] arr, int k) {
        //     int n = arr.length;
        //     List<Map<Integer, Integer>> group = new ArrayList<>(); // 存储 k 个组、各组中各个数字数量
        //     int [] size = new int [k];                             // 各组大小,它们会有可能不同吗？
        //     for (int i = 0; i < k; i++) {
        //         Map<Integer, Integer> map = new HashMap<>();
        //         for (int j = i; j < n; j += k) {
        //             map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
        //             size[i]++;
        //         }
        //         group.add(map);
        //     }
        //     int range = 1 << 10;          //  题中nums[i] < 2^10， 为的是遍历所有可能更改值，以取最小
        //     int [] dp = new int [range];  // 当前组异或到对应数字时的更改次数
        //     Arrays.fill(dp, Integer.MAX_VALUE);
        //     dp[0] = 0;
        //     for (int i = 0; i < k; i++) {
        //         int minVal = Arrays.stream(dp).min().getAsInt();
        //         int [] newDp = new int [range];       //  遍历每一个个组，暴搜、取最小
        //         Arrays.fill(newDp, minVal + size[i]); // 变为当前组中不存在数字的改变次数：之前的最小改变次数+当前组元素个数
        //         for (int j = 0; j < range; j++) {
        //             if (dp[j] == Integer.MAX_VALUE) continue; // 对第0组，保证dp[i]是异或到0的最小改变数
        //             Iterator it = group.get(i).entrySet().iterator();
        //             while (it.hasNext()) {
        //                 Map.Entry en = (Map.Entry)it.next();
        //                 int num = (int)en.getKey(), v = (int)en.getValue();
        //                 int xorNum = num ^ j;
        //                 newDp[xorNum] = Math.min(newDp[xorNum], dp[j] + size[i] - v);
        //             }
        //         }
        //         dp = Arrays.copyOf(newDp, range); // 将遍历到当前组、累积较优解的newDp复制入全局最优解dp数组中
        //     }
        //     return dp[0];
        // }

        
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        // int [] a = new int [] {1,2,0,3,0};
        int [] a = new int [] {1,2,4,1,2,5,1,2,6};

        int r = s.minChanges(a, 3);
        System.out.println("r: " + r);
    }
}