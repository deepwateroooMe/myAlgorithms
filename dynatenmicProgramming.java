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


        
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        String []  a = new String []  {"abba", "baab"};
        String b = "bab";

        // String []  a = new String []  {"acca", "bbbb", "caca"};
        // String b = "aba";

        // String []  a = new String []  {"abcd"};
        // String b = "abcd";

        int r = s.numWays( a, b);
        System.out.println("r: " + r);
    }
}