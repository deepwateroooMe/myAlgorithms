import com.TreeNode;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.Map.Entry;
import java.math.BigInteger;
import java.util.stream.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;
public class dpfive {
    public static class Solution {
// // 【主要是长整型溢出之类的细节】：这个题的细节，比我想像得要再多一点儿, 记忆化深搜，也会超时，会需要再优化。。。 // TODO TODO TODO: 1977 158/257
//         public int numberOfCombinations(String t) { 
//             n = t.length(); s = t.toCharArray();
//             if (n == 1) return s[0] == '0' ? 0 : 1;
//             return dfs(0, 0);
//         }
//         static final int mod = (int)1e9 + 7;
//         char [] s;
//         int n;
//         Map<String, Integer> m = new HashMap<>(); // 它可能还要记一下前面的数字是多少？如果这样，数据过于离散，是需要用字典的
//         int dfs(int i, long j) { // 【繁琐深搜：】这个记忆化深搜，的难点在， Integer.MAX_VALUE 待特殊数字的处理，狠繁琐，改天再写。。。
//             if (i == n) return 1;
//             String key = i + "-" + j;
//             if (m.containsKey(key)) return m.get(key);
//             if (i < n && s[i] == '0') // 以【0】打头, 不合法，直接返回
//                 return m.getOrDefault(key, 0);
//             long r = 0, v = 0;
//             int k = i;
//             for (k = i; k < n; k++) {
//                 v = v * 10 + (s[k] - '0');
//                 if (v > (long)Long.MAX_VALUE) {
//                     System.out.println("v: " + v);
//                     break;
//                 }
//                 if (j == 0 || v >= j) r = (r + (long)dfs(k+1, v)) % mod;
//             }
//             m.put(key, (int)r);
//             return (int)r;
//         }
//         String a = "3745299124190496631931491905";

        // public boolean splitArraySameAverage(int[] a) { // N: 【1,30】数据规模太大了，一定会超时的 // TLE TLE TLE: 
        //     n = a.length; this.a = a;  N = (1 << n);
        //     if (n == 2) return a[0] == a[1];
        //     int sum = Arrays.stream(a).sum();
        //     for (int i = 1; i < N; i++) {
        //         int cnt = Integer.bitCount(i), ss = getSum(i);
        //         if (cnt < n && ss * n == cnt * sum) {
        //             System.out.println("ss: " + ss);
        //             System.out.println("cnt: " + cnt);
        //             return true;
        //         }
        //     }
        //     return false;
        // }
        // int n, N; int [] a;
        // int getSum(int v) {
        //     int r = 0;
        //     for (int i = 0; i < n; i++) 
        //         if (((v >> i) & 1) == 1) r += a[i];
        //     return r;
        // }
        // // N: 【1,30】一分为二，将数组折分成左右两个半边，再来解决问题
        // public boolean splitArraySameAverage(int[] a) { // 感觉基本思路是对的，介理细节的处理上，存在一此小问题
        //     int n = a.length, m = n / 2, sum = Arrays.stream(a).sum();
        //     if (n == 1) return false;
        //     // 【对数组进行预处理】：既把题目转化为：找非空子集和为零，同时不能引入任何不方便处理的浮点数
        //     for (int i = 0; i < n; i++) a[i] = a[i] * n - sum;
        //     // 【遍历左半部分】：
        //     Set<Integer> left = new HashSet<>();
        //     for (int i = 1; i < (1 << m); i++) {
        //         int r = 0;
        //         for (int j = 0; j < m; j++) 
        //             if (((i >> j) & 1) == 1) r += a[j];
        //         if (r == 0) return true; // 【快速返回：】在左边已经找到了一个非空子集和为0
        //         left.add(r);
        //     }
        //     // 【遍历右半部分】：
        //     int rsum = 0;
        //     for (int i = m; i < n; i++) rsum += a[i];
        //     for (int i = 1; i < (1 << (n-m)); i++) {
        //         int r = 0;
        //         for (int j = 0; j < (n-m); j++) 
        //             if (((i >> j) & 1) == 1) r += a[j+m];
        //         if (r == 0) return true; // 【快速返回：】在右边已经找到了一个非空子集和为0
        //         // if (left.contains(-r)) return true; // 【BUG:】这个细节也狠重要。。。
        //         if (r != rsum && left.contains(-r)) return true; // 【r != rsum】：【1,3】＝＝》【－2,2】
        //     }
        //     return false; 
        // }

        // public boolean isMatch(String S, String T) { // 这个题的边边角角狠烦人。。。10 // TODO TODO TODO: 10
        //     m = S.length(); n = T.length();
        //     s = s.toCharArray(); t = T.toCharArray();
        //     f = new Boolean [m][n];
        //     return dfs(0, 0);
        // }
        // char [] s, t;
        // int m, n;
        // Boolean [][] f;
        // boolean dfs(int i, int j) {
        //     if (i == m && j == n) return true; // 【终止条件】
        //     if (i == m) { // j < n
        //         while (j < n && t[j] == '*') j++;
        //         return j == n ? true : false;
        //     }
        //     if (f[i][j] != null) return f[i][j];
        //     // 【处理当前下标】：各种可能性, 需要防备 t[j+1] == '*'
        //     if (j == n-1 || t[j+1] != '*') {
        //         if (s[i] == t[j] || t[j] == '.') return f[i][j] = dfs(i+1, j+1); // 都是字母
        //         else { // t[j] == '*'
        //             if (dfs(i+1, j)) return f[i][j] = true; // 不用×
        //             if (dfs(i+1, j+1)) return f[i][j] = true; // 配合成当前字符
        //             for (int k = i+1; k < m; k++) // 要用这个 × 来配一个，所有可能的片段
        //                 if (dfs(k, j+1)) return f[i][j] = true; // 配合成当前字符
        //         }                
        //     } else { // j < n-1 && t[j+1] == '*' 再想一下，这个死题目，要怎么处理，烦死了。。。
        //     }
        // }
        // // if (i == m-1 && j == n-1)
        // //     return f[i][j] = (s[i] == t[j] || t[j] == '.' || t[j] == '*');
        // // if (s[i] == t[j] || t[j] == '.') return f[i][j] = dfs(i+1, j+1);

        // // 【记忆化深搜：】深深惊讶，我这两天把记忆化深搜写得像 1+1=2 一样简单。。。。。
        // // Queue<Integer> q = new PriorityQueue<>(); 感觉确实能再快一点儿
        // public int minimumVisitedCells(int[][] a) { // 记忆化深搜： TLE 1028/1069 动态规划，应该也会超时
        //     m = a.length; n = a[0].length; this.a = a;
        //     f = new Integer [m][n];  // 自己认准某一个方向来遍历
        //     Arrays.stream(f).forEach(z -> Arrays.fill(z, Integer.MAX_VALUE));
        //     int r = dfs(0, 0);
        //     return r == Integer.MAX_VALUE ? -1 : r;
        // }
        // Integer [][] f;
        // int [][] a;
        // int m, n;
        // int dfs(int i, int j) { // 记忆化揵从当前坐标到终点的最小步数
        //     if (i == m-1 && j == n-1) return f[i][j] = 1;
        //     if (f[i][j] < Integer.MAX_VALUE ) return f[i][j];
        //     int r = Integer.MAX_VALUE;
        //     for (int y = Math.min(j + a[i][j], n-1); y > j; y--) 
        //         r = Math.min(r, 1 + dfs(i, y));
        //     for (int x = Math.min(m-1, a[i][j] + i); x > i; x--) 
        //         r = Math.min(r, 1 + dfs(x, j));
        //     return f[i][j] = r;
        // }
        // public int minimumVisitedCells(int[][] a) { // 带两个优先队列的动规写法：// TLE 1043/1069 改天再接着写。。。
        //     int m = a.length, n = a[0].length;
        //     if (m == 1 & n == 1) return 1;
        //     int [][] f = new int [m][n];
        //     Arrays.stream(f).forEach(z -> Arrays.fill(z, m+n));
        //     // Queue<int []> h = new PriorityQueue<>((x, y) -> x[0] - y[0]); // 水平方向【可以简化为只用一个】
        //     for (int i = 0; i < m; i++) {
        //         for (int j = 0; j < n; j++) { // 水平方向上的
        //             if (i == 0 && j == 0) {
        //                 f[i][j] = 1; continue;
        //             }
        //             // h.clear();
        //             // for (int k = Math.max(0, i - a[i][j]); k < i; k++) { // 上下方向【这里可能会漏掉一些相对优解】
        //             for (int k = 0; k < i; k++) // 上下方向
        //                 // if (f[k][j] != m+n && a[k][j] > 0 && a[k][j] + k >= i) h.offer(new int [] {f[k][j], k, j});
        //                 if (f[k][j] != m+n && a[k][j] > 0 && a[k][j] + k >= i)
        //                     f[i][j] = Math.min(f[i][j], f[k][j] + 1);
        //             // for (int k = Math.max(0, j - a[i][j]); k < j; k++) { // 左右方向【这里可能会漏掉一些相对优解】 
        //             for (int k = 0; k < j; k++) // 左右方向 
        //                 // if (f[i][k] != m+n && a[i][k] > 0 && a[i][k] + k >= j) h.offer(new int [] {f[i][k], i, k});
        //                 if (f[i][k] != m+n && a[i][k] > 0 && a[i][k] + k >= j) // h.offer(new int [] {f[i][k], i, k});
        //                     f[i][j] = Math.min(f[i][j], f[i][k] + 1);
        //             // if (!h.isEmpty()) f[i][j] = Math.min(f[i][j], f[h.peek()[1]][h.peek()[2]] + 1);
        //             // h.offer(new int [] {f[i][j], i, j});
        //         }
        //     }
        //     return f[m-1][n-1] == m+n ? -1 : f[m-1][n-1];
        // }

        // static final int mod = (int)1e9 + 7; // TODO TODO TODO: 得想办法，如何解决 *** 的处理？
        // public int numDecodings(String t) {
        //     n = t.length();
        //     s = t.toCharArray();
        //     f = new Integer [n];
        //     return dfs(0);
        // }
        // char [] s;
        // int n;
        // Integer [] f;
        // int dfs(int i) { // 这里，一定把‘×’所前面的一起处理
        //     if (i == n) return 1;
        //     if (s[i] == '0') return f[i] = 0; // 主要是防：哪里自己写漏了，没处理好这个逻辑
        //     if (f[i] != null) return f[i];
        //     if (i == n-1) {
        //         if (s[i] == '*') return f[i] = 9;
        //         // else if (s[i] == '0') return f[i] = 0; // 这种情况，不再考虑
        //         else return f[i] = s[i] - '0';
        //     }
        //     if (s[i+1] == '*') {
        //     } else { // s[i+1] != '*', j = 【【12】【3456789】】, k =【0,【12】？【3456】789】
        //         int j = s[i] - '0', k = s[i+1] - '0';
        //         if (s[i] == '*') { // k =【0,【12】？【3456】789】
        //             if (k == 0) return f[i][j] = 2 * dfs(i+2);     // 【10, 20】
        //             else if (k > 0 && k <= 6) return f[i][j] = 19; // 【 [12][123456],11-16,21-26,[3456789][123456]】
        //             else {
        //                 if (k == 7) return f[i][j] = 2 * dfs(i+2); // 【[1][7],【17】】
        //                 else return f[i][j] = 8 * dfs(i+2); // 【[23456789]-[89]】
        //             }
        //         } else {
        //             if (k == 0) return f[i][j] = (j > 0 && j < 3 ? dfs(i+2) : 0); // [10, 20]
        //             else if (k > 0 && k <= 6) return f[i][j] = (j > 0 && j < 3 ? 2 * dfs(i+2) : dfs(i+2));
        //             else { // k ＝【789】
        //                 if (j == 1) return f[i][j] = 2 * dfs(i+2); // [17]
        //                 else return f[i][j] = dfs(i+2);
        //             }
        //         }
        //     }
        //     return f[i] = (int)r;
        // }


        // // 这个题：写出涂房子、分街区有街区数目的限制了的之后，应该就会写了，要背背带背背包，背个数组作状态。。。
        // // 背个数组背太多了，只要背：最后一次的数字和出现次数就可以了。。。【活宝妹就是一定要嫁给亲爱的表哥！！！】
        // static final int mod = (int)1e9 + 7;
        // public int dieSimulator(int n, int[] r) {
        //     this.r = r; m = 6;
        //     int max = Arrays.stream(r).max().getAsInt() + 1;
        //     f = new Integer [n+1][m][max];
        //     long ans = 0;
        //     return dfs(n, -1, 0);
        // }
        // Integer [][][] f;
        // int [] r; // 这里是，每个结果，最多可以连续出现的次数
        // int m;
        // int dfs(int i, int j, int k) { // j: 前一次扔出来的结果
        //     if (i == 0) return 1;
        //     if (j >= 0 && f[i][j][k] != null) return f[i][j][k];
        //     long ans = 0;
        //     for (int x = 0; x < m; x++) {
        //         if (x == j && k < r[j])
        //             ans = (ans + dfs(i-1, j, k+1)) % mod;
        //         else if (x != j) ans = (ans + dfs(i-1, x, 1)) % mod;
        //     }
        //     if (j >= 0) f[i][j][k] = (int)ans;
        //     return (int)ans;
        // }


        // // 算出最长公有子序列之后，要用这个东西把最短XX 给还原回来。。。。。
        // public String shortestCommonSupersequence(String S, String T) { // 1092
        //     int m = S.length(), n = T.length();
        //     char [] s = S.toCharArray();
        //     char [] t = T.toCharArray();
        //     int [][] f = new int [m+1][n+1];
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++)
        //             if (s[i] == t[j]) f[i+1][j+1] = f[i][j] + 1;
        //             else f[i+1][j+1] = Math.max(f[i+1][j], f[i][j+1]);
        //     if (f[m][n] == Math.max(m, n)) return S;
        //     System.out.println("f.length: " + f.length);
        //     for (int z = 0; z < f.length; ++z) 
        //         System.out.println(Arrays.toString(f[z]));
        //     // 然后根据上面的统计结果，往回倒。。。。。
        //     int i = 0, j = 0;
        //     StringBuilder sb = new StringBuilder("");
        //     while (i < m && j < n) {
        //         if (s[i] == t[j]) {
        //             sb.append(s[i]);
        //             i++;
        //             j++;
        //         } else if ()
        //     }            
        //     int i = m, j = n;
        //     while (i > 0 && j > 0) {
        //         if (s[i-1] == t[j-1]) {
        //             sb.insert(0, s[i]);
        //             i--;
        //             j--;
        //         } else { // (i > 0 && j > 0)
        //             if (f[i][j] == f[i-1][j]) 
        //                 i--;
        //             else if (f[i][j] == f[i][j-1]) 
        //                 j--;  
        //         }
        //     }
        //     System.out.println("sb.toString(): " + sb.toString());
        //     int o = m + n - f[m][n], k = 0;
        //     i = 0; j = 0;
        //     while (k < o) {
        //         // System.out.println("\n i: " + i);
        //         // System.out.println("j: " + j);
        //         // System.out.println("k: " + k);
        //         if (i < m && j < n && s[i] == t[j]) {
        //             i++;
        //             j++;
        //             k++;
        //         } else {
        //             while (i < m && k < o && (sb.length() == k || sb.charAt(k) != s[i])) {
        //                 sb.insert(k, s[i]);
        //                 k++;
        //                 i++;
        //             }
        //             while (j < n && k < o && (sb.length() == k || sb.charAt(k) != t[j])) {
        //                 sb.insert(k, t[j]);
        //                 k++;
        //                 j++;
        //             }
        //         }
        //     }
        //     return sb.toString();
        // }

        // // 先走一遍，采最多的走，再走一遍，能采多少采多少？那么第一遍走，就把采得最多的路径给改掉，变每格为0 【好像仍然会失掉最优解】
        // public int cherryPickup(int[][] a) {
        //     int n = a.length;
        //     // 【动规：】先找一条可以采最多的路径，动规解法，找到一遍的最大值 
        //     int [][] f = new int [n][n];
        //     Arrays.stream(f).forEach(z -> Arrays.fill(z, Integer.MIN_VALUE)); // 加了这个，多些判断，但不会出错【不会多走不能走的格】
        //     f[0][0] = a[0][0];
        //     for (int i = 0; i < n; i++)
        //         for (int j = 0; j < n; j++) {
        //             if (f[i][j] == Integer.MIN_VALUE) continue;
        //             if (j < n-1 && a[i][j+1] != -1) // 向右
        //                 f[i][j+1] = Math.max(f[i][j+1], f[i][j] + a[i][j+1]); 
        //             if (i < n-1 && a[i+1][j] != -1) // 向下
        //                 f[i+1][j] = Math.max(f[i+1][j], f[i][j] + a[i+1][j]);
        //         }
        //     System.out.println("f.length: " + f.length);
        //     for (int z = 0; z < f.length; ++z) 
        //         System.out.println(Arrays.toString(f[z]));
        //     int ans = f[n-1][n-1], r = ans;
        //     if (ans == Integer.MIN_VALUE) return 0;
        //     // 【清理路径：】把采过的路径，变 0
        //     for (int i = n-1; i >= 0; i--) 
        //         for (int j = n-1; j >= 0; j--) {
        //             if (f[i][j] == r) {
        //                 r -= a[i][j];
        //                 a[i][j] = 0;
        //             } else if (i > 0 && f[i-1][j] == r) {
        //                 r -= a[i-1][j];
        //                 a[i-1][j] = 0;
        //             } else if (j > 0 && f[i][j-1] == r) {
        //                 r -= a[i][j-1];
        //                 a[i][j-1] = 0;
        //             }
        //         }
        //     System.out.println("a.length: " + a.length);
        //     for (int z = 0; z < a.length; ++z) 
        //         System.out.println(Arrays.toString(a[z]));
        //     // 【再走第二遍】：找剩余的最多路径，累计和
        //     Arrays.stream(f).forEach(z -> Arrays.fill(z, Integer.MIN_VALUE));
        //     f[n-1][n-1] = a[n-1][n-1];
        //     for (int i = n-1; i >= 0; i--) 
        //         for (int j = n-1; j >= 0; j--) {
        //             if (f[i][j] == Integer.MIN_VALUE) continue;
        //             if (i > 0 && a[i-1][j] != -1) f[i-1][j] = Math.max(f[i-1][j], f[i][j] + a[i-1][j]);
        //             if (j > 0 && a[i][j-1] != -1) f[i][j-1] = Math.max(f[i][j-1], f[i][j] + a[i][j-1]);
        //         }
        //     System.out.println("f.length: " + f.length);
        //     for (int z = 0; z < f.length; ++z) 
        //         System.out.println(Arrays.toString(f[z]));
        //     return ans + f[0][0];
        // }
        // // 【不带记忆的深搜。。。】被自己打雷雷坏了吧。。。
        // public int cherryPickup(int[][] a) { // 能不能像那个类似题一样，一次起两个格呢？没说错了，但是严重超时, 
        //     n = a.length; this.a = a;
        //     if (n == 1) return a[0][0];
        //     vis = new boolean [n * n][n * n]; 
        //     dfs(0, 0, a[0][0]); // 这个方法太慢了，就直接动规
        //     return max;
        // }
        // int [][] dirs = {{1, 0}, {0, 1}};
        // boolean [][] vis; int [][] a;
        // int n, max = 0;
        // void dfs(int ij, int iijj, int cur) {
        //     int i = ij / n, j = ij % n, ii = iijj / n, jj = iijj % n;
        //     if (i < 0 || i >= n || j < 0 || j >= n || ii < 0 || ii >= n || jj < 0 || jj >= n
        //         || a[i][j] == -1 || a[ii][jj] == -1 || vis[ij][iijj]) return ;
        //     if (i == n-1 && j == n-1 && ii == n-1 && jj == n-1) {
        //         max = Math.max(max, cur + a[i][j]);
        //         return ;
        //     }
        //     vis[ij][iijj] = true;
        //     cur += (i != ii && j != jj) ? a[i][j] + a[ii][jj] : a[i][j];
        //     for (int [] d : dirs) {
        //         int x = i + d[0], y = j + d[1];
        //         for (int [] dd : dirs) {
        //             int xx = ii + dd[0], yy = jj + dd[1];
        //             dfs(x * n + y, xx * n + yy, cur);
        //         }
        //     }
        //     vis[ij][iijj] = false;
        // }
// // 【带记忆的深搜。。。】记忆化深搜。。。
//         public int cherryPickup(int[][] a) { 
//             n = a.length; this.a = a;
//             if (n == 1) return a[0][0];
//             // v = new boolean [n * n][n * n];  // 全局的，不要重复
//             f = new Integer [n*n][n*n];
//             return dfs(0, 0, new boolean [n][n]); // 不带记忆的，一定慢，为什么要记忆呢？！！！
//         }
//         int [][] dirs = {{1, 0}, {0, 1}};
//         // boolean [][] v;
//         int [][] a;
//         Integer [][] f;
//         int n, max = 0;
//         int dfs(int ij, int iijj, boolean [][] vis) {
//             int i = ij / n, j = ij % n, ii = iijj / n, jj = iijj % n;
//             if (i < 0 || i >= n || j < 0 || j >= n || ii < 0 || ii >= n || jj < 0 || jj >= n
//                 || a[i][j] == -1 || a[ii][jj] == -1) return 0;
//             if (f[ij][iijj] != null) return f[ij][iijj];
//             if (i == n-1 && j == n-1 && ii == n-1 && jj == n-1) return f[ij][iijj] = a[i][j];
//             // int cur = (vis[i][j] ? 0 : a[i][j]) + (i != ii || j != jj ? (vis[ii][jj] ? 0 : a[ii][jj]) : 0);
//             int cur = (vis[i][j] ? 0 : a[i][j]);
//             vis[i][j] = true;
//             cur += (i != ii || j != jj ? (vis[ii][jj] ? 0 : a[ii][jj]) : 0);
//             vis[ii][jj] = true;
//             // v[ij][iijj] = true;
//             int ans = 0;
//             for (int [] d : dirs) {  // 某个格会走到另一个踩过的格上去。。。
//                 int x = i + d[0], y = j + d[1];
//                 for (int [] dd : dirs) {
//                     int xx = ii + dd[0], yy = jj + dd[1];
//                     ans = Math.max(ans, cur + dfs(x*n+y, xx*n+yy, vis));
//                                    // a[i][j] + (i != ii || j != jj ? a[ii][jj] : 0) + dfs(x*n+y, xx*n+yy));
//                 }
//             }
//             return f[ij][iijj] = ans;
//         }
        // public int cherryPickup(int[][] a) { // 再想一下这个题目：如果记忆化搜索会出现踩到之前走过的，动规应该也会。。。
        //     n = a.length; this.a = a;
        //     if (n == 1) return a[0][0];
        //     vis = new boolean [n * n][n * n]; 
        //     // dfs(0, 0, a[0][0]); // 这个方法太慢了，就直接动规
        //     return max;
        // }
        // int [][] a = new int [][] {{1,1,1,1,0,0,0},{0,0,0,1,0,0,0},{0,0,0,1,0,0,1},{1,0,0,1,0,0,0},{0,0,0,1,0,0,0},{0,0,0,1,0,0,0},{0,0,0,1,1,1,1}};
        // System.out.println("a.length: " + a.length);
        // for (int z = 0; z < a.length; ++z) 
        //     System.out.println(Arrays.toString(a[z]));
        // int r = s.cherryPickup(a);

        // // static final int mod = (int)1e9 + 7; // 【爱表哥，爱生活！！！活宝妹就是一定要嫁给亲爱的表哥！！！】
        // public int distinctSequences(int n) {
        //     this.n = 7;
        //     f = new Integer [n+1][7][7];
        //     return dfs(n, 0, 0); 
        // }
        // Integer [][][] f;
        // int n;
        // int dfs(int i, int j, int k) {
        //     if (i == 0) return 1;
        //     if (f[i][j][k] != null) return f[i][j][k];
        //     long ans = 0;
        //     for (int x = 1; x < n; x++) {
        //         if (x == j || x == k) continue; // ...
        //         if (k != 0 && gcd(x, k) > 1) continue;
        //         ans = (ans + dfs(i-1, k, x)) % mod;
        //     }
        //     return f[i][j][k] = (int)ans;
        // }
        // int gcd(int x, int y) {
        //     if (y == 0) return x;
        //     return gcd(y, x % y);
        // }

        // public int minSideJumps(int[] a) {
        //     n = a.length; this.a = a;
        //     f = new Integer [n][4];
        //     return dfs(0, 2, false);
        // }
        // int n; int [] a;
        // Integer [][] f;
        // int dfs(int i, int j, boolean vis) { //vis:false 时可以往边上跳
        //     if (i == n-1) return 0;
        //     if (f[i][j] != null) return f[i][j];
        //     if (a[i] == j) return f[i][j] = Integer.MAX_VALUE / 2; // 小青蛙撞石头上了。。。
        //     int r = Integer.MAX_VALUE / 2;
        //     r = Math.min(r, dfs(i+1, j, false)); // 走直的
        //     for (int k = 1; k <= 3; k++) { // 往边上跳
        //         // if (a[i] == k) continue;
        //         if (!vis && k != j)
        //             r = Math.min(r, 1 + dfs(i, k, true));
        //     }
        //     return f[i][j] = r;
        // }

        // public int secondsToRemoveOccurrences(String t) {
        //     char [] s = t.toCharArray();
        //     int n = t.length(), i = 0, cnt = 0;
        //     boolean noMore = true;
        //     while (t.indexOf("01") != -1) {
        //         while (i < n) {
        //             while (i < n-1 && t.substring(i, i+2).equals("01")) {
        //                 s[i] = '1'; s[i+1] = '0';
        //                 i += 2;
        //                 noMore = false;
        //             }
        //             while (i < n-1 && t.substring(i, i+2).equals("11")) i += 2;
        //             while (i < n-1 && !(t.substring(i, i+2).equals("01") || t.substring(i, i+2).equals("11"))) i++;
        //             if (i == n-1) i = n;
        //         }            
        //         t = new String(s);
        //         s = t.toCharArray();
        //         i = 0;
        //         cnt++;
        //     }
        //     return cnt;
        // }

        // public int longestArithSeqLength(int[] a) { // 1027
        //     int n = a.length, m = Arrays.stream(a).max().getAsInt() + 1;
        //     if (n == 2) return a[0] != a[1] ? 2 : 0;
        //     int [] f = new int [m];
        //     // for (int v : a) f[v] = 1;
        //     f[a[0]] = 1;
        //     for (int i = 1; i < n; i++) {
        //         f[a[i]] = Math.max(f[a[i]], 1);
        //         for (int j = i-1; j >= 0; j--) {
        //             System.out.println("\n a[i]: " + a[i]);
        //             System.out.println("a[j]: " + a[j]);
        //             int d = a[i] - a[j], v = d + a[i], x = 2;
        //             System.out.println("d: " + d);
        //             System.out.println("v: " + v);
        //             while (d != 0 && v < m  && v >= 0 && f[v] > 0) {
        //                 System.out.println("v: " + v);
        //                 f[v] = Math.max(f[v], x + 1);
        //                 x = f[v];
        //                 v = d + v;
        //             }
        //             System.out.println(Arrays.toString(f));
        //         }
        //     }
        //     return Arrays.stream(f).max().getAsInt();
        // }

        // public long mostPoints(int[][] a) {
        //     n = a.length; this.a = a; 
        //     f = new Long [n];
        //     return dfs(0);
        // }
        // int n; int [][] a;
        // Long [] f;
        // long dfs(int i) {
        //     if (i >= n) return 0;
        //     if (f[i] != null) return f[i];
        //     long ans = dfs(i+1);
        //     ans = Math.max(ans, a[i][0] + dfs(i + a[i][1] + 1));
        //     return f[i] = ans;
        // }

        // public int maximalSquare(char[][] b) {
        //     int m = b.length, n = b[0].length;
        //     int [][] a = new int [m][n], r = new int [m+1][n+1];
        //     for (int i = 0; i < m; i++)
        //         for (int j = 0; j < n; j++) {
        //             a[i][j] = b[i][j] - '0';
        //             r[i+1][j+1] = r[i][j+1] + r[i+1][j] - r[i][j] + a[i][j];
        //         }
        //     for (int d = Math.min(m, n); d > 0; d--) {
        //         for (int i = 0; i+d <= m; i++)
        //             for (int j = 0; j+d <= n; j++)
        //                 if (r[i+d][j+d] - r[i+d][j] - r[i][j+d] + r[i][j] == d * d) return d * d;
        //     }
        //     return 0;
        // }

        // public int coinChange(int[] a, int t) { // 边界条件，狠烦人。。。写不到了，再写记忆化深搜呀。。。
        //     if (t == 0) return 0;
        //     Arrays.sort(a);
        //     int n = a.length;
        //     if (t < a[0]) return -1;
        //     int [] f = new int [Math.max(t+1, Arrays.stream(a).max().getAsInt() + 1)];
        //     Arrays.fill(f, Integer.MAX_VALUE / 2);
        //     for (int v : a) f[v] = 1;
        //     f[0] = 0;
        //     for (int i = n-1; i >= 0; i--) { // 只是从大到小，来遍历硬币
        //         int v = a[i];
        //         f[v] = 1;
        //         for (int j = t; j >= v; j--) 
        //             f[j] = Math.min(f[j], f[j-v] + 1);
        //     }
        //     return f[t] >= Integer.MAX_VALUE / 2 ? -1 : f[t];
        // }
        // public int coinChange(int[] a, int t) { // TLE TLE TLE: 
        //     Arrays.sort(a);
        //     // System.out.println(Arrays.toString(a));
        //     n = a.length; this.a = a;
        //     if (n == 1) return t % a[0] == 0 ? t / a[0] : -1;
        //     if (t < a[0]) return -1;
        //     return dfs(t, n-1);
        // }
        // Map<Integer, Integer> m = new HashMap<>(); // 防：题目叨钻，离散化数据 
        // int n; int [] a;
        // int dfs(int i, int j) {
        //     if (i == 0) return 0;
        //     if (j < 0) return Integer.MAX_VALUE / 2;
        //     String k = i + "-" + j;
        //     if (m.containsKey(k)) return m.get(k);
        //     if (a[j] > i) return m.getOrDefault(k, dfs(i, j-1));
        //     int ans = Integer.MAX_VALUE / 2, cnt = i / a[j];
        //     for (int x = cnt; x >= 0; x--) 
        //         ans = Math.min(ans, x + dfs(i - x * a[j], j-1));
        //     return m.getOrDefault(k, ans);
        // }
        
       //  static final int mod = (int)1e9 + 7;
       //  public int countRestrictedPaths(int n, int[][] egs) {
       //      this.n = n; m = n + 1;
       //      g = new ArrayList [m];
       //      Arrays.setAll(g, z -> new ArrayList<>());
       //      for (int [] e : egs) {
       //          int u = e[0], v = e[1], w = e[2];
       //          g[u].add(new int [] {v, w});
       //          g[v].add(new int [] {u, w});
       //      }
       //      d = new long [m];
       //      Arrays.fill(d, Long.MAX_VALUE / 2);
       //      calculateMinimumHP(n); // 计算到节点 n 的最短距离
       //      System.out.println(Arrays.toString(d));
       //      // 根据最短距离先有用边，动规解题
       //      f = new Integer [m];
       //      return dfs(1); // 觉得这里是我不会写动规，写错写坏了【就是这样滴～】。。。去写记忆化深搜，不会写动规的娃。。。
       //  }
       //  int dfs(int u) {
       //      if (u == n) return 1;
       //      if (f[u] != null) return f[u];
       //      long ans = 0;
       //      for (int [] e : g[u]) {
       //          int v = e[0];
       //          if (d[v] >= d[u]) continue;
       //          ans = (ans + (long)dfs(v)) % mod;
       //      }
       //      return f[u] = (int)ans;
       //  }
       //  List<int []> [] g;
       //  int m, n;
       // long [] d;
       //  Integer [] f;
       //  void calculateMinimumHP(int uu) {
       //      d[uu] = 0;
       //      // boolean [] vis = new boolean [m];
       //      Queue<long []> q = new PriorityQueue<>((x, y) -> Long.compare(x[1], y[1]));
       //      q.offer(new long [] {uu, 0});
       //      // vis[uu] = true;
       //      while (!q.isEmpty()) {
       //         long [] cur = q.poll();
       //         int u = (int)cur[0];
       //         long t = cur[1];
       //          for (int [] v : g[u]) 
       //              if (t + v[1] < d[v[0]]) {
       //                  d[v[0]] = t + v[1];
       //                  // vis[v[0]] = true;
       //                  q.offer(new long [] {v[0], d[v[0]]});
       //              }
       //      }
       //  }
       //  void dfsIsWrong(int u) { // 不知道这里错哪里了。。。大概又是不会写动规【动规】的更新方向写反了。。。
       //      if (u == n) return ;
       //      for (int [] e : g[u]) {
       //          int v = e[0];
       //          if (d[v] >= d[u]) continue;
       //          f[v] = (f[v] + f[u]) % mod;
       //          dfs(v);
       //      }
       //  }

// // 写【记忆化深搜：】写得行云流水、、、写动规，就写得各种别扭。。。。【爱表哥，爱生活！！！活宝妹就是一定要嫁给亲爱的表哥！！！】
//         static final int mod = (int)1e9 + 7;
//         public int peopleAwareOfSecret(int n, int d, int e) { 
//             int [] f = new int [n+1];
//             f[1] = 1;
//             int ans = 1;
//             for (int i = 2; i <= n; i++) {
//                 System.out.println("\n i: " + i);
//                 for (int j = Math.max(1, i-e); j <= Math.min(n-1, i-d); j++) {
//                     f[i] += f[j];
//                     // f[i] -= f[i-e];
//                 }
//                 System.out.println(Arrays.toString(f));
//                 ans = (ans + f[i] - (i < e ? 0 : f[i-e]));
//                 System.out.println("ans: " + ans);
//             }
//             return ans;
//         }

        // static final int mod = (int)1e9 + 7;
        // public int firstDayBeenInAllRooms(int[] a) { // 不知道这个题目说的是什么意思。。。
        //     int n = a.length, r = 0, i = 0;
        //     int [] f = new int [n];
        //     f[0] = 1;
        //     while (f[n-1] == 0) {
        //         if (f[i] > 0 && f[i] % 2 == 1) {
        //             i = a[i];
        //             f[i]++;
        //         } else if (f[i] > 0 && f[i] % 2 == 0) {
        //             i = (i + 1) % n;
        //             f[i]++;
        //         }
        //         r = (r + 1) % mod;
        //         // r++;
        //     }
        //     return r;
        // }

        // public int sumSubarrayMins(int[] a) { // 这么算不准：要用栈
        //     int n = a.length;
        //     int [] l = new int [n], r = new int [n];
        //     Deque<int []> s = new ArrayDeque<>();
        //     for (int i = 0; i < n; i++) { // 【从左往右：】用个【递减】队列
        //         while (!s.isEmpty() && a[s.peekFirst()] <= a[i]) s.pollFirst();
        //         l[i] = (s.isEmpty() ? -1 : i - s.peekFirst() + 1);
        //         s.offerFirst(i);
        //     }
        //     int ans = 0;
        //     for (int i = 0; i < n; i++) 
        //         ans += a[i] * l[i] * r[i];
        //     return ans;
        // }

        // public String longestPalindrome(String t) {
        //     int n = t.length(); char [] s = t.toCharArray();
        //     if (n == 1) return t;
        //     int max = 1, si = 0, sj = 0;
        //     boolean [][] f = new boolean [n][n];
        //     for (int i = 0; i < n; i++) f[i][i] = true;
        //     for (int i = n-2; i >= 0; i--)
        //         for (int j = i+1; j < n; j++) 
        //             if (s[i] == s[j] && (j - i <= 2 || f[i+1][j-1])) {
        //                 f[i][j] = true;
        //                 if (j - i + 1 > max) {
        //                     max = j - i + 1;
        //                     si = i; sj = j;
        //                 }
        //             }            
        //     return t.substring(si, sj+1);
        // }

        // static final int mod = (int)1e9 + 7;
        // public int countPaths(int n, int[][] egs) {
        //     g = new ArrayList [n]; this.n = n; 
        //     Arrays.setAll(g, z -> new ArrayList<>());
        //     for (int [] e : egs) {
        //         int u = e[0], v = e[1], w = e[2];
        //         g[u].add(new int [] {v, w});
        //         g[v].add(new int [] {u, w});
        //     }
        //     d = new long [n];
        //     calculateMinimumHP(0);
        //     // 【根据上面的最短距离：】把图清理一下，精简到最小图: 【不知道这里有没有更好的办法】这里重新建了一遍
        //     g = new ArrayList [n];
        //     Arrays.setAll(g, z -> new ArrayList<>());
        //     for (int [] e : egs) {
        //         int u = e[0], v = e[1], w = e[2];
        //         if (Math.abs(d[u] - d[v]) == (long)w) {
        //             g[u].add(new int [] {v, w});
        //             g[v].add(new int [] {u, w});
        //         }
        //     }
        //     f = new Integer [n][n];
        //     return dfs(0, -1);
        // }
        // List<int []> [] g;
        // Integer [][] f;
        // long [] d; int n;
        // int dfs(int i, int j) {
        //     if (i == n-1) return 1;
        //     if (j >= 0 && f[i][j] != null) return f[i][j];
        //     long ans = 0;
        //     for (int [] e : g[i]) {
        //         int v = e[0], w = e[1];
        //         if (v == j) continue;
        //         if (d[i] < d[v]) ans = (ans + dfs(v, i)) % mod;
        //     }
        //     if (j >= 0) f[i][j] = (int)ans;
        //     return (int)ans;
        // }
        // void calculateMinimumHP(int w) { // 计算从 0 出发，到各节点的最短时间 
        //     Arrays.fill(d, Long.MAX_VALUE);
        //     d[w] = 0;
        //     Queue<long []> q = new PriorityQueue<>((x, y) -> Long.compare(x[1], y[1]));
        //     q.offer(new long [] {w, 0});
        //     while (!q.isEmpty()) {
        //         long [] cur = q.poll();
        //         int u = (int)cur[0]; long t = cur[1];
        //         for (int [] e : g[u]) {
        //             int v = e[0], dist = e[1];
        //             if (t + dist < d[v]) {
        //                 d[v] = t + dist;
        //                 q.offer(new long [] {v, d[v]});
        //             }
        //         }
        //     }
        // }

        // public boolean canIWin(int n, int t) { // 不知道这里是不是位操作的时候弄错了，再写一遍
        //     this.t = t; this.n = n; m = n+1;
        //     return dfs(0, 0);
        // }
        // Map<Integer, Boolean> map = new HashMap<>();
        // int m, n, t;
        // boolean dfs(int i, int j) { // i: mask 【这里要带玩家顺序】, j: sum
        //     boolean fstPlayer = (((i >> m) & 1) == 0);
        //     System.out.println("\n Integer.toBinaryString(i): " + Integer.toBinaryString(i));
        //     System.out.println("j: " + j);
        //     System.out.println("fstPlayer: " + fstPlayer);
        //     if (j >= t) {
        //         map.put(i, fstPlayer);
        //         return fstPlayer; // 【第一个玩家】赢
        //     }
        //     if (map.containsKey(i)) return map.get(i);
        //     if (fstPlayer) {
        //         for (int k = 1; k <= n; k++) 
        //             if ((i & (1 << k)) == 0) {
        //                 int v = (i | (1 << k) | (fstPlayer ? (1 << m) : 0));
        //                 if (dfs(v, j + k)) {
        //                     map.put(i, true);
        //                     return true;
        //                 }
        //             }
        //     } else {
        //         for (int k = 1; k <= n; k++) 
        //             if ((i & (1 << k)) == 0) {
        //                 int v = (i | (1 << k));
        //                 v ^= (1 << m); // 把那一位的 1 拿掉
        //                 if (!dfs(v, j + k)) {
        //                     map.put(i, false);
        //                     return false;
        //                 }
        //             }
        //     }
        //     map.put(i, !fstPlayer);
        //     return !fstPlayer;
        // }        
        // public boolean canIWin(int n, int t) { // 可能哪里没有想对？
        //     this.t = t; this.n = n; m = n+1;
        //     return dfs(new boolean [n+1], 0);
        // }
        // Map<String, Boolean> f = new HashMap<>();
        // int m, n, t;
        // boolean dfs(boolean [] r, int j) { // i: mask 【这里要带玩家顺序】, j: sum
        //     System.out.println("\n j: " + j);
        //     System.out.println(Arrays.toString(r));
        //     String key = Arrays.toString(r) + "-" + j;
        //     if (j >= t) {
        //         f.put(key, !r[0]);
        //         return !r[0]; // 【第一个玩家】赢
        //     }
        //     if (f.containsKey(key)) return f.get(key);
        //     if (!r[0]) {
        //         for (int k = 1; k <= n; k++) {
        //             if (r[k]) continue;
        //             boolean [] cur = r.clone();
        //             cur[0] = true;
        //             cur[k] = true;
        //             if (dfs(cur, j + k)) {
        //                 f.put(key, true);
        //                 return true;
        //             }
        //         }
        //     } else {
        //         for (int k = 1; k <= n; k++) {
        //             if (r[k]) continue;
        //             boolean [] cur = r.clone();
        //             cur[0] = false;
        //             cur[k] = true;
        //             if (!dfs(cur, j + k)) {
        //                 f.put(key, false);
        //                 return false;
        //             } 
        //         }
        //     }
        //     f.put(key, !r[0]);
        //     return !r[0];
        // }        

        // public int minimumNumbers(int v, int k) { // TODO TODO TODO: 
        //     if (v < k) return 0;
        //     if (v == k) return 1;
        //     this.k = k;
        //     f = new Integer [v+1];
        //     return dfs(v);
        // }
        // int k;
        // Integer [] f;
        // int dfs(int i) {
        //     if (i == 0) return f[i] = Integer.MAX_VALUE / 2;
        //     if (i == k) return f[i] = 1;
        //     if (f[i] != null) return f[i];
        //     int ans = Integer.MAX_VALUE;
        //     for (int j = k; j <= i-k; j = j + 10) 
        //         ans = Math.min(ans, 1 + dfs(i - j));
        //     return f[i] = ans;
        // }

        // static final int mod = (int)1e9 + 7;
        // int [] primes = new int [] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        // public int squareFreeSubsets(int[] a) {
        //     int n = a.length, m = 31;
        //     int [] cnt = new int [m];
        //     for (int v : a) cnt[v]++;
        //     int [] f = new int [1 << 10]; // 遍历所有乘积的可能性
        //     f[0] = 1; // 这个初始化：是说，空集当作一种可能，作为起始
        //     // 【细节：】无论有多少个 1, 都是不影响结果的，所这所有 1 的影响【引起的数目基变】放在初始化的 f[0] 里
        //     for (int i = 0; i < cnt[1]; i++) f[0] = (f[0] * 2) % mod; //f[0]: 想一下，cnt[1] 的频率累积效应可以加在 f[0] 上
        //     for (int v = 2; v < m; v++) { // 每个数：只处理一遍
        //         if (cnt[v] == 0) continue;
        //         int r = 0;
        //         boolean valid = true;
        //         for (int j = 0; j < 10; j++) {
        //             int x = primes[j];
        //             if (v >= x * x && v % (primes[j] * primes[j]) == 0) {
        //                 valid = false;
        //                 break; // 它不合法
        //             }
        //             if (v % x == 0) r |= (1 << j);
        //         }
        //         if (!valid) continue;
        //         for (int j = (1 << 10)-1; j > 0; j--) 
        //             if ((j & r) == r)
        //                 f[j] = (int)((f[j] + ((long)f[j ^ r]) * cnt[v]) % mod); // 这里犯糊涂：我要把每个数的 cnt 效应放这里吗？【为什么这样不可以呢？】
        //     }
        //    int ans = 0;
        //     for (int i = 0; i < (1 << 10); i++) 
        //         ans = (ans + f[i]) % mod;
        //     return (ans == 0 ? mod : ans)-1;
        // }

        public int minNumberOperations(int[] a) {
            n = a.length; this.a = a;
            if (Arrays.stream(a).distinct().count() == 1) return a[0];
            return minNumberOperations(0, n-1, 0);
        }
        int [] a; int n;
        int minNumberOperations(int i, int j, int v) {
            if (i == j) return a[i] - v;
            int min = a[i], idx = -1;
            for (int k = i; k <= j; k++) 
                if (a[k] < min) {
                    min = a[k];
                    idx = k;
                }
            if (min == a[i] || min == a[j]) {
                if (a[i] == a[j]) return min - v + minNumberOperations(i+1, j-1, min);
                if (min == a[i]) {
                    int x = i+1;
                    while (x < j && a[x] == min) x++;
                    return min - v + minNumberOperations(x, j, min);
                } else {
                    int x = j-1;
                    while (x > i && a[x] == min) x--;
                    // System.out.println("x: " + x);
                    return min - v + minNumberOperations(i, x, min);
                }
            } else if (idx > i && idx < j) {
                return min + minNumberOperations(i, idx-1, min) + minNumberOperations(idx+1, j, min);
            }
            return -1;
        }
    }
    public static void main (String[] args) { // 【爱表哥，爱生活！！！活宝妹就是一定要嫁给亲爱的表哥！！！】
        Solution s  =  new Solution ();

        int [] a = new int [] {5, 5, 3};
        System.out.println(Arrays.toString(a));

        int r = s.minNumberOperations(a);
        System.out.println("r: " + r);
    } 
}
// ListNode head = new ListNode(a[0]); 
// head.buildList(head, a);  
// head.printList(head);
// TreeNode rr = new TreeNode(a[0]);
// rr.buildTree(rr, a);
// rr.levelPrintTree(rr);
// 任何时候，活宝妹就是一定要嫁给亲爱的表哥！！！【爱表哥，爱生活！！！活宝妹就是一定要嫁给亲爱的表哥！！！】
