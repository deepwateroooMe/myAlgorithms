import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.Arrays;
import java.util.stream.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;

public class dpten {
    public static class Solution {

        // public int numberOfGoodSubsets(int[] a) {
        //     int n = a.length, N = 31;
        //     int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        //     int [] mask = new int [N];
        //     int [] cnt = new int [N];
        //     for (Integer v : a) cnt[v]++;
        //     for (int i = 1; i < N; i++) 
        //         for (int j = 0; j < primes.length; j++) 
        //             if (i % primes[j] == 0) {
        //                 if (i / primes[j] % primes[j] == 0) {
        //                     mask[i] = 0; // 自己含有重复的质因子，这样的数不用考虑
        //                     break;
        //                 }
        //                 mask[i] |= (int)Math.pow(2, j);
        //             }
        //     long [] dp = new long [1 << primes.length];
        //     dp[0] = 1;
        //     for (int i = 1; i < N; i++) {
        //         if (mask[i] == 0) continue;
        //         for (int j = 0; j < (1 << primes.length); j++) 
        //             if ((mask[i] & j) == 0 && dp[j] > 0) // 没有公共质因子，且mask j代表已经是一种合理解的情况下，可以把i也组合进去
        //                 dp[mask[i] | j] = (dp[mask[i] | j] + dp[j] * cnt[i] % mod + mod) % mod; // 考虑进去了，同样包括数值 i 重复出现的次数cnt[i]
        //     }
        //     long ans = 0;
        //     for (int i = 1; i < (1 << primes.length); i++) 
        //         ans = (ans + dp[i]) % mod;
        //     ans = (ans * pow(2, cnt[1])) % mod;
        //     return (int)ans;
        // }
        // static final long mod = (int)1e9 + 7;
        // private static long pow(long a, long b) { // 这个快速幂不能忘记
        //     long ans = 1;
        //     while (b > 0) {
        //         if ((b & 1) == 1)
        //             ans = (ans * a) % mod;
        //         a = (a * a) % mod;
        //         b >>= 1;
        //     }
        //     return (ans + mod) % mod;
        // }

        // public boolean splitArraySameAverage(int[] a) { // 这个方法有点儿呆傻
        //     int n = a.length, sum = Arrays.stream(a).sum();
        //     boolean poss = false;
        //     for (int i = 1; i <= n/2; i++) 
        //         if (sum * i % n == 0) {
        //             poss = true;
        //             break;
        //         }
        //     if (!poss) return false;
        //     if (n < 2) return false;
        //     if (n == 2) return a[0] == a[1];
        //     double avg = (double)sum / n;
        //     int [] l = Arrays.copyOfRange(a, 0, n/2);
        //     int [] r = Arrays.copyOfRange(a, n/2, n);
        //     int [] cnt = new int [1 << (n/2+1)];
        //     for (int i = 0; i < (1 << (n/2+1)); i++)
        //         cnt[i] = Integer.bitCount(i);
        //     Map<Integer, Set<Integer>> left = new HashMap<>();
        //     for (int i = 1; i < (1 << l.length); i++) {
        //         int cur = 0;
        //         for (int j = 0; j < n/2; j++) 
        //             if (((i >> j) & 1) == 1) cur += l[j];
        //         if ((double)cur / (double)cnt[i] == avg) return true;
        //         left.computeIfAbsent(cnt[i], z -> new HashSet<>()).add(cur);
        //     }
        //     for (int i = 1; i < (1 << r.length); i++) {
        //         int cur = 0;
        //         for (int j = 0; j < r.length; j++) 
        //             if (((i >> j) & 1) == 1) cur += r[j];
        //         if ((double)cur / (double)cnt[i] == avg) return true;
        //         for (Integer key : left.keySet()) {
        //             Set<Integer> val = left.get(key);
        //             if (cnt[i] + key <= n/2 && sum * (cnt[i] + key) % n == 0 && val.contains((cnt[i] + key) * sum / n - cur))
        //                 return true;
        //         }
        //     }
        //     return false;
        // } 
        // public boolean splitArraySameAverage(int[] a) { // bug for 3 test cases
        //     int n = a.length, sum = Arrays.stream(a).sum(), m = n/2;
        //     boolean poss = false;
        //     for (int i = 1; i <= n/2; i++) 
        //         if (sum * i % n == 0) {
        //             poss = true;
        //             break;
        //         }
        //     if (!poss) return false;
        //     List<Set<Integer>> ls = new ArrayList<>();
        //     for (int i = 0; i <= m; i++) 
        //         ls.add(new HashSet<>());
        //     ls.get(0).add(0); // 引子：当包含数组中0个数的和为0
        //     for (Integer v : a) 
        //         for (int i = m; i >= 1; i--) // 全局数组考虑一半长度，已经可以函盖所有情况 
        //             for (Integer j : ls.get(i-1)) 
        //                 ls.get(i).add(j + v); // 增加子集中元素的个数
        //     for (int i = 1; i <= m; i++) 
        //         if (sum * i % n == 0 && ls.get(i).contains(sum * i / n))
        //             return true;
        //     return false;
        // }

        // Map<Integer, Integer> m = new HashMap<>();
        // public int minDays(int n) {
        //     if (n <= 2) return n;
        //     if (m.containsKey(n)) return m.get(n);
        //     int ans = 1 + Math.min(n % 2 + minDays(n / 2), n % 3 + minDays(n / 3));
        //     m.put(n, ans);
        //     return ans;
        // }

    // // https://leetcode.com/problems/count-the-repetitions/discuss/496150/Java-DP-like-Solution
    //     public int getMaxRepetitions(String s1, int n1, String s2, int n2) { // todo: to slow, 需要优化的方法
        //     char [] s = s1.toCharArray();
        //     char [] t = s2.toCharArray();
        //     int cnt = 0, ans = 0, idx = 0;
        //     while (cnt < n1) {
        //         for (int i = 0; i < s.length; i++) // 数每个（或每几个）子串s1里面可以出现在一个完整的子串S2
        //             if (s[i] == t[idx]) {
        //                 idx++;
        //                 if (idx == t.length) {
        //                     idx = 0;
        //                     ans++;
        //                 }
        //             }
        //         cnt++; // 当所有可以有的s1耗尽（n1）
        //     }
        //     return ans / n2;
        // }

        // static final int mod = (int)1e9 + 7;
        // public int numDecodings(String t) {
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     long [] dp = new long [Math.max(2, n+1)];
        //     dp[0] = 1;
        //     dp[1] = s[0] == '*' ? 9 : s[0] == '0' ? 0 : 1;
        //     for (int i = 2; i <= n; i++) {
        //         for (int j = 1; j <= 26; j++) {
        //             char c = s[i-1];
        //             if (j <= 9) {
        //                 if (c == '*' || c == '0' + j) // *, [1-9]: 可以单独解码的 
        //                     dp[i] += dp[i-1];
        //             } else {
        //                 char p = s[i-2];
        //                 int x = j / 10, y = j % 10; // p: [*, 1, 2] 可以与前一位合并解码的 ......
        //                 if ((p == '*' || p == x + '0') && ((c == '*' && y != 0) || c == y + '0'))
        //                     dp[i] += dp[i-2];             // [1/2][*, 0]           c: [0, 1, 2, .... 6]
        //             }
        //         }
        //         dp[i] %= mod;
        //     }
        //     return (int)dp[n];
        // }

        // public int minNumberOfSemesters(int n, int[][] relations, int k) {
        //     int [] pre = new int [n];
        //     int r = 1 << n;
        //     for (int [] v : relations) {
        //         int x = v[0]-1, y = v[1] - 1;
        //         pre[y] |= 1 << x;
        //     }
        //     int [] cnt = new int [r];
        //     for (int i = 0; i < r; i++) cnt[i] = Integer.bitCount(i);
        //     int [] dp = new int [r];
        //     Arrays.fill(dp, n);
        //     dp[0] = 0;
        //     for (int i = 0; i < r; i++) {   // 遍历所有可能的状态，对每个状态进行最大可能地优化
        //         int cur = 0;
        //         for (int j = 0; j < n; j++) // 遍历课程，筛出当前子集mask下，可选课程的集全
        //             // if ((i & pre[j]) == pre[j]) // 这门课可选，但是可能已经选过
        //             if (((i >> j) & 1) == 0 && (i & pre[j]) == pre[j]) // 这门课可选，并且还没有选修过
        //                 cur |= 1 << j;
        //         // cur &= ~i;   // 这个最容易忽视： 选过的课程是不用再选的
        //         int next = cur; // 所有可选课程的集合
        //         while (next > 0) {
        //             if (cnt[next] <= k) // 寻找和遍历符合条件的子集
        //                 dp[i | next] = Math.min(dp[i | next], dp[i] + 1);
        //             next = (next - 1) & cur;
        //         }
        //     }
        //     return dp[r-1];
        // }
       //  public int minNumberOfSemesters(int n, int[][] relations, int k) {
       //      int [] pre = new int [n];
       //      int r = 1 << n;
       //      for (int [] v : relations) pre[v[1]-1] |= 1 << (v[0] - 1);
       //      f = new int [1 << n];
       //      Arrays.fill(f, Integer.MAX_VALUE);
       //      f[0] = 0;
       //      for (int i = 0; i < (1 << n); i++) {
       //          if (f[i] == Integer.MAX_VALUE) continue;
       //          int cur = 0;
       //          for (int j = 0; j < n; j++) {
       //              if (((i >> j) & 1) == 0 && ((pre[j] & i) == pre[j]))
       //                  cur |= 1 << j;
       //              solve(0, 0, i, cur, k, n);  // 看得很昏乎：
       //          }
       //      }
       //      return f[r-1];
       //  }
       //  int [] f; // dp
       //  private void solve(int i, int s, int state, int cur, int k, int n) {
       //      if (k == 0 || i == n) { // 看得很昏乎：int i: 通过对现可选课程cur一位一位遍历的方式找出最优级解，速度慢
       //          f[state | s] = Math.min(f[state | s], f[state] + 1);
       //          return ;
       //      }
       //      solve(i+1, s, state, cur, k, n);
       //      if (((cur >> i) & 1) == 1) // int i: 遍历已选课程state子集下，所有可选课程的子集合，通过遍历i优化每门可选课的时间来优化结果
       //          solve(i+1, s | 1 << i, state, cur, k-1, n);
       // }

        // public boolean possiblyEquals(String ss, String tt) {
        //     m = ss.length(); N = 1000;
        //     n = tt.length();
        //     s = ss.toCharArray();
        //     t = tt.toCharArray();
        //     dp = new Boolean [m+1][n+1][2001];
        //     return dfs(0, 0, 0);
        // }
        // Boolean [][][] dp;
        // char [] s, t;
        // int m, n, N;
        // private boolean dfs(int i, int j, int k) { // k: dif
        //     if (i == m && j == n) return k == 0;
        //     if (dp[i][j][k+N] != null) return dp[i][j][k+N];
        //     if (i < m && j < n && k == 0 && s[i] == t[j] && dfs(i+1, j+1, 0))   // Literal matching on s1[i] and s2[j]
        //         return dp[i][j][N] = true;
        //     if (i < m && !Character.isDigit(s[i]) && k > 0 && dfs(i+1, j, k-1)) // Literal matching on s1[i]
        //         return dp[i][j][k+N] = true;
        //     if (j < n && !Character.isDigit(t[j]) && k < 0 && dfs(i, j+1, k+1)) // Literal matching on s2[j]
        //         return dp[i][j][k+N] = true;
        //     for (int x = i, val = 0; x < m && Character.isDigit(s[x]); x++) {   // Wildcard matching on s1[i]
        //         val = val * 10 + s[x] - '0';
        //         if (dfs(x+1, j, k-val)) return dp[i][j][k+N] = true;
        //     }
        //     for (int x = j, val = 0; x < n && Character.isDigit(t[x]); x++) {   // Wildcard matching on s2[j]
        //         val = val * 10 + t[x] - '0';
        //         if (dfs(i, x+1, k+val)) return dp[i][j][k+N] = true;
        //     }
        //     return dp[i][j][k+N] = false;
        // }


    // Map<Integer, List<Integer>> adj;
    // int [][] par;
    // public TreeAncestor(int n, int[] parent) {
    //     par = new int [n][30]; // 30 , 16: 不能证它是一棵很平衡的二叉树
    //     adj = new HashMap<>();
    //     for (int i = 0; i < n; i++) {
    //         Arrays.fill(par[i], -1);
    //         adj.put(i, new ArrayList<>());
    //     }
    //     for (int i = 0; i < parent.length; i++) 
    //         if (parent[i] != -1) {
    //             adj.get(parent[i]).add(i); // 自顶向下： 父 --》子节点
    //             par[i][0] = parent[i];     // 每个子节点的第一个父节点（2^0 = 1），即为父节点 // 自底向上： 子节点： 2^0父节点、 2^1节点、 2^2节点
    //         }
    //     dfs(0);
    // }
    // public int getKthAncestor(int node, int k) {
    //     for (int i = 0; k > 0; i++, k >>= 1) // k /= 2
    //         if ((k & 1) == 1) {
    //             node = par[node][i];
    //             if (node < 0) return -1;
    //         }
    //     return node;
    // }
    // private void dfs(int idx) { // 自顶向下：从父节点遍历子节点
    //     for (int i = 1; par[idx][i-1] >= 0; i++) // 穷追塑源：一直找到整棵树的根节点： 0
    //         par[idx][i] = par[par[idx][i-1]][i-1]; // 这里多想想
    //     for (int next : adj.get(idx)) 
    //         dfs(next);
    // }
    // private int [][] p;
    // private int log;
    // public TreeAncestor(int n, int[] parent) {
    //     log = (int) (Math.log(n - 1) / Math.log(2)) + 1;
    //     p = new int[n][log];
    //     for (int i = 0; i < parent.length; i++) // 初始化p数组
    //         p[i][0] = parent[i];
    //     for (int i = 1; i < log; i++) // 按公式递推p数组
    //         for (int j = 0; j < n; j++) 
    //             if (p[j][i-1] != -1) 
    //                 p[j][i] = p[p[j][i-1]][i-1];
    //             else p[j][i] = -1;
    // }
    // public int getKthAncestor(int node, int k) {
    //     int pow = 0;
    //     while (k > 0) {
    //         if (pow >= log || node == -1) return -1;
    //         if ((k & 1) == 1) 
    //             node = p[node][pow];
    //         k >>= 1;
    //         pow++;
    //     }
    //     return node;
    // }

        // static final int mod = (int)1e9 + 7;
        // public int numberOfCombinations(String t) {
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     if (s[0] == '0') return 0;
        //     int [][] lcp = new int [n][n];   // 求的是： 以s[i]开始的后缀，与以s[j]开始的后缀，两字符串的最长公共前缀长度
        //     for (int i = n-1; i >= 0; i--) { // 预处理 lcp
        //         lcp[i][n-1] = s[i] == s[n-1] ? 1 : 0;
        //         for (int j = i+1; j < n-1; j++) 
        //             lcp[i][j] = s[i] == s[j] ? lcp[i+1][j+1] + 1 : 0;
        //     }
        //     int [][] dp = new int [n][n];
        //     for (int i = 0; i < n; i++) dp[0][i] = 1; // dp[0][...] = 1
        //     for (int i = 1; i < n; i++) {
        //         if (s[i] == '0') continue; // 有前导零，无需转移
        //         int preSum = 0;
        //         for (int j = i; j < n; j++) {
        //             int length = j - i + 1; // s[i,j]
        //             dp[i][j] = preSum;      // dp[i][j] = d[i][j-1] + (one item) // 这里是j 从 i开始累加的dp[...]前缀和
        //             if (i - length >= 0) {  // 使用 lcp 比较 s[2i-j-1,i-1] 与 s[i,j] 的大小关系
        //                 if (lcp[i-length][i] >= length || s[i - length + lcp[i-length][i]] < s[i + lcp[i-length][i]])
        //                     dp[i][j] = (dp[i][j] + dp[i-length][i-1]) % mod;
        //                 preSum = (preSum + dp[i-length][i-1]) % mod; // 更新前缀和,这里是 j 从 i 开始累加的dp[...]前缀和
        //             }
        //         }
        //     }
        //     int ans = 0;
        //     for (int i = 0; i < n; i++) // 最终答案即为所有 dp[..][n-1] 的和
        //         ans = (ans + dp[i][n-1]) % mod;
        //     return ans;
        // }

        // public int maxProfit(int[] p) { // bug, to be finished
        //     int n = p.length, lmin = 0, lmax = 0, gmax = 0;
        //     int [] l = new int [n];
        //     int [] r = new int [n];
        //     lmin = p[0];
        //     lmax = p[0];
        //     for (int i = 1; i < n; i++) {
        //         if (p[i] < lmin) {
        //             gmax = Math.max(gmax, lmax - lmin);
        //             lmin = p[i];
        //             lmax = 0;
        //         } else {
        //             lmax = Math.max(lmax, p[i]);
        //             gmax = Math.max(gmax, lmax - lmin);
        //         }
        //         l[i] = gmax;
        //     }
        //     lmin = p[n-1];
        //     lmax = p[n-1];
        //     gmax = 0;
        //     for (int i = n-2; i >= 0; i--) {
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
        //     }
        //     gmax = 0;
        //     for (int i = 1; i < n; i++) 
        //         gmax = Math.max(gmax, l[i] + r[i]);
        //     return gmax;
        // }

        // private void postOrderDfs(int idx, int  pre) { // post-order traversal 
        //     for (Integer v : adj[idx]) {
        //         if (v == pre) continue;
        //         postOrderDfs(v, idx);
        //         cnt[idx] += cnt[v];
        //         ans[idx] += ans[v] + cnt[v];
        //     }
        //     ++cnt[idx]; // 把根节点自己算进以此为根节点的树的总节点数里
        // }
        // private void preOrderDfs(int idx, int pre) { // pre-order traversal
        //     for (Integer v : adj[idx]) {
        //         if (v == pre) continue;
        //         // ans[i] = ans[root] - count[i] + N - count[i]
        //         ans[v] = ans[idx] - cnt[v] + n - cnt[v];
        //         preOrderDfs(v, idx);
        //     }
        // }
        // List<Integer> [] adj;
        // int [] cnt, ans;
        // int n;
        // public int [] sumOfDistancesInTree(int n, int[][] edges) {
        //     this.n = n;
        //     cnt = new int [n];
        //     ans = new int [n];
        //     adj = new ArrayList[n];
        //     for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        //     for (int [] e : edges) {
        //         int u = e[0], v = e[1];
        //         adj[u].add(v);
        //         adj[v].add(u);
        //     }
        //     postOrderDfs(0, -1);
        //     preOrderDfs(0, -1);
        //     return ans;
        // }

        // public int distinctEchoSubstrings(String t) { 
        //     int n = t.length(), j = 0;
        //     Set<String> ss = new HashSet<>();
        //     for (int d = 1; d <= n/2; d++) 
        //         for (int i = 0; i+d <= n-d; i++) {
        //             if (t.substring(i, i+d).equals(t.substring(i+d, i+d+d)))
        //                 ss.add(t.substring(i, i+d));
        //         }
        //     return ss.size();
        // }
        // static final int mod = (int)1e9 + 7;
        // public int distinctEchoSubstrings(String t) {  
        //     int n = t.length(), ans = 0;
        //     char [] s = t.toCharArray();
        //     int base = 31;
        //     int [] pre = new int [n+1], mul = new int [n+1];
        //     mul[0] = 1;
        //     for (int i = 1; i <= n; i++) {
        //         pre[i] = (int)(((long)pre[i-1] * base + s[i-1]) % mod);
        //         mul[i] = (int)((long)mul[i-1] * base % mod);
        //     }
        //     Set<Integer> [] vis = new HashSet[n];
        //     for (int i = 0; i < n; i++) vis[i] = new HashSet<>();
        //     for (int i = 0; i < n; i++) 
        //         for (int j = i+1; j < n; j++) {
        //             int l = j - i;
        //             if (j + l <= n) {
        //                 int hash_left = gethash(pre, mul, i, j-1);
        //                 if (!vis[l-1].contains(hash_left) && hash_left == gethash(pre, mul, j, j+l-1)) {
        //                     ++ans;
        //                     vis[l-1].add(hash_left);
        //                 }
        //             }
        //         }
        //     return ans;
        // }
        // private int gethash(int [] pre, int [] mul, int l, int r) {
        //     return (int)((pre[r+1] - (long)pre[l] * mul[r-l+1] % mod + mod) % mod);
        // }

        // static final int mod = (int)1e9 + 7;
        // public int numWays(String[] words, String target) {
        //     int m = target.length(), n = words[0].length();
        //     char [] s = target.toCharArray();
        //     int [][] cnt = new int [n][26];
        //     for (String w : words) 
        //         for (int j = 0; j < n; j++) 
        //             cnt[j][w.charAt(j)-'a']++;
        //     // long [][] dp = new long [m][n];
        //     // dp[0][0] = cnt[0][s[0]-'a'];
        //     // for (int i = 1; i < n; i++) // 初始化： 由前i列来构成target第一个字符的方案数
        //     //     dp[0][i] = (dp[0][i] + dp[0][i-1] + cnt[i][s[0]-'a']) % mod;
        //     // for (int i = 1; i < m; i++) 
        //     //     for (int j = i; j < n; j++) 
        //     //         dp[i][j] = (dp[i][j-1] + dp[i-1][j-1] * cnt[j][s[i]-'a']) % mod;
        //     // return (int)dp[m-1][n-1];
        //     long [][] dp = new long [m+1][n+1];
        //     Arrays.fill(dp[0], 1l);
        //     // dp[0] = LongStream.range(0, n+1).map(e->1).toArray(); // filling first row of array with 1
        //     for (int i = 1; i <= m; i++)
        //         for (int j = i; j <= n + i - m; j++) 
        //             dp[i][j] = (dp[i][j-1] + dp[i-1][j-1] * cnt[j-1][s[i-1]-'a'] % mod) % mod;
        //     return (int)dp[m][n];
        // }
        // static final int mod = (int)1e9 + 7;
        // public int numWays(String[] words, String target) { // dp降维，压缩空间，但二维dp仍然是思路最为清晰好理解的
        //     int m = target.length(), n = words[0].length();
        //     char [] s = target.toCharArray();
        //     long [] dp = new long [m];
        //     for (int i = 0; i < n; i++) {  // 遍历字符数组的各列
        //         int [] cnt = new int [26]; // 当前-列-所有字符的出现次数
        //         for (String w : words) 
        //             cnt[w.charAt(i)-'a']++;
        //         for (int j = Math.min(i, m-1); j >= 0; j--) // 记住： 降维就容易产生赃数据，需要倒序遍历
        //             dp[j] = (dp[j] + (j > 0 ? dp[j-1] : 1) * cnt[s[j]-'a']) % mod;
        //     }
        //     return (int)dp[m-1];
        // }

        // public int numberOfArrays(String s, int k) {
        //     n = s.length();
        //     dp = new Integer [n];
        //     return dfs(0, s, k);
        // }
        // static final int mod = (int)1e9 + 7;
        // Integer [] dp;
        // int n;
        // private int dfs(int idx, String s, int k) {
        //     if (idx >= n) return 1;
        //     if (s.charAt(idx) == '0') return dp[idx] = 0;
        //     if (dp[idx] != null) return dp[idx];
        //     long ans = 0;
        //     int m = ("" + k).length();
        //     for (int i = 1; i <= m && idx+i <= n; i++) 
        //         if (i < m || i == m && s.substring(idx, idx+m).compareTo(String.valueOf(k)) <= 0)
        //             ans = (ans + dfs(idx+i, s, k)) % mod;
        //     return dp[idx] = (int)ans;
        // }
        // static final int mod = (int)1e9 + 7;
        // public int numberOfArrays(String t, int k) { // top down
        //     int n = t.length(), m = ("" + k).length();
        //     char [] s = t.toCharArray();
        //     long [] dp = new long [n+1];
        //     dp[0] = 1;
        //     for (int i = 1; i <= n; i++) 
        //         for (int j = 0; j < Math.min(i, m); j++) {
        //             if (s[i-j-1] == '0') continue;
        //             long cur = Long.valueOf(t.substring(i-j-1, i));
        //             if (cur >= 1 && cur <= k) 
        //                 dp[i] = (dp[i] + dp[i-j-1]) % mod;
        //         }
        //     return (int)dp[n];
        // }
        // static final int mod = (int)1e9 + 7;
        // public int numberOfArrays(String s, int k) {
        //     int len = s.length();
        //     long [] dp = new long [n+1];
        //     dp[0]=1;
        //     for(int i=0; i<n; i++){
        //         long sum = 0;
        //         int j = i;
        //         while(j>=0 && i-j<9){
        //             if(s.charAt(j)!='0'){
        //                 int num = Integer.valueOf(s.substring(j, i+1));
        //                 if(num > k) break;
        //                 if(num>0)
        //                     sum+=dp[j];
        //             }
        //             j--;
        //         }
        //         if(sum == 0) return 0;
        //         dp[i+1] = sum%mod;
        //     }
        //     return (int)dp[n];
        // }
        // static final int mod = (int)1e9 + 7;
        // public int numberOfArrays(String s, int k) {
        //     int n = s.length();
        //     long[] dp = new long[n+1];
        //     dp[n]=1;
        //     for(int i=n-1; i>=0; i--){
        //         if(s.charAt(i)=='0') continue;
        //         long sum = 0;
        //         long num = 0;
        //         for(int sz=1; i+sz<=n; sz++){
        //             num = num*10 + s.charAt(i+sz-1)-'0';
        //             if(num>k) break;
        //             sum += dp[i+sz];
        //         }
        //         dp[i]=sum%mod;
        //     }
        //     return (int)dp[0];
        // }

        // // 设计一个动态规划数组 dp[maxTime + 1][n]，其中 dp[t][i] 表示第 t 分钟到达城市 i 时的最少费用，则状态转移方程为：
        // // dp[t][c1] = Math.min(dp[t][c1], dp[t - time][c2] + passingFees[c1])
        // // dp[t][c2] = Math.min(dp[t][c2], dp[t - time][c1] + passingFees[c2])
        // public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        //     int n = passingFees.length;
        //     int [][] dp = new int [maxTime+1][n];
        //     for (int i = 0; i <= maxTime; i++) 
        //         Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        //     dp[0][0] = passingFees[0];
        //     for (int t = 0; t <= maxTime; t++) 
        //         for (int [] e : edges) {
        //             if (e[2] > t) continue;
        //             int u = e[0], v = e[1], time = e[2];
        //             dp[t][u] = Math.min(dp[t][u], dp[t-time][v] + passingFees[u]); // v --> u
        //             dp[t][v] = Math.min(dp[t][v], dp[t-time][u] + passingFees[v]); // u --> v
        //         }
        //     int ans = Integer.MAX_VALUE / 2;
        //     for (int i = 1; i <= maxTime; i++)
        //         ans = Math.min(ans, dp[i][n-1]);
        //     return ans == Integer.MAX_VALUE / 2 ? -1 : ans;
        // }

        // public int getMaxGridHappiness(int m, int n, int introvertsCount, int extrovertsCount) {
        //     int r = (int)Math.pow(3, n), rless = (int)Math.pow(3, n-1);
        //     int [][] offset = {{0, 0, 0}, {0, -60, -10}, {0, -10, 40}};
        //     int [][][][] dp = new int [m*n+1][introvertsCount+1][extrovertsCount+1][r]; // [m*n+1]：+1为的是去处理dp[i+1][j][k][cur]的i=m*n-1格的特殊情况
        //     for (int i = m*n-1; i >= 0; i--) { // i: idx, coordinates
        //         int x = i / n, y = i % n;
        //         for (int j = 0; j <= introvertsCount; j++) 
        //             for (int k = 0; k <= extrovertsCount; k++) {
        //                 for (int pre = 0; pre < r; pre++) { //  pre 就是前 n 个格子的状态（三进制）
        //                     int cur = (pre * 3) % r;
        //                     if (j > 0) { // 当前格安放一个内向的人
        //                         int dif = 120 + (y != 0 ? 1 : 0) * offset[1][pre % 3] + offset[1][pre / rless];
        //                         dp[i][j][k][pre] = Math.max(dp[i][j][k][pre], dif + dp[i+1][j-1][k][cur + 1]);
        //                     }
        //                     if (k > 0) { // 当前格安放一个外向的人
        //                         int dif = 40 + (y != 0 ? 1 : 0) * offset[2][pre % 3] + offset[2][pre / rless];
        //                         dp[i][j][k][pre] = Math.max(dp[i][j][k][pre], dif + dp[i+1][j][k-1][cur + 2]);
        //                     }
        //                     dp[i][j][k][pre] = Math.max(dp[i][j][k][pre], dp[i+1][j][k][cur]); // 当前格不安放任何人
        //                 }
        //             }
        //     }
        //     return dp[0][introvertsCount][extrovertsCount][0];
        // }
        // public int getMaxGridHappiness(int m, int n, int introvertsCount, int extrovertsCount) {
        //     this.m = m; this.n = n;
        //     dp = new Integer [m][n][introvertsCount+1][extrovertsCount+1][243]; // 3^5=243
        //     return dfs(0, 0, introvertsCount, extrovertsCount, 0);
        // }
        // Integer [][][][][] dp;
        // int m, n, mod = 243;
        // private int dfs(int i, int j, int inCnt, int exCnt, int preMask) {
            // if (inCnt == 0 && exCnt == 0) return 0;
            // if (j == n) return dfs(i+1, 0, inCnt, exCnt, preMask); // 有到达边界，直接看下一行
            // if (i == m) return 0;
        //     if (dp[i][j][inCnt][exCnt][preMask] != null) return dp[i][j][inCnt][exCnt][preMask];
        //     int up = getBit(preMask, n-1), left = getBit(preMask, 0);
        //     int ans = dfs(i,  j+1, inCnt, exCnt, setBit(preMask, 0)); // 不安排任何人在这个格
        //     if (inCnt > 0) { // 考虑安放一个内向的人在这个格子，算最优可能性
        //         int addon = 120, cur = setBit(preMask, 1);
        //         if (i >= 1 && up != 0) { // up: 1 / 2
        //             addon -= 30; // 当前格内向的人，上面有人他不开心
        //             if (up == 1) addon -= 30; // 当前格上一格，如果是内向的人，他不开心
        //             else addon += 20;         // 当前格上一格，如果是外向的人，他很开心
        //         }
        //         if (j >= 1 && left != 0) {
        //             addon -= 30;
        //             if (left == 1) addon -= 30;
        //             else addon += 20;
        //         }
        //         ans = Math.max(ans, addon + dfs(i, j+1, inCnt-1, exCnt, cur));
        //     }
        //     if (exCnt > 0) { // 考虑安放一个外向的人在这个格子，算最优可能性
        //         int addon = 40, cur = setBit(preMask, 2);
        //         if (i >= 1 && up != 0) {
        //             addon += 20;
        //             if (up == 1) addon -= 30;
        //             else addon += 20;
        //         }
        //         if (j >= 1 && left != 0) {
        //             addon += 20;
        //             if (left == 1) addon -= 30;
        //             else addon += 20;
        //         }
        //         ans = Math.max(ans, addon + dfs(i, j+1, inCnt, exCnt-1, cur));
        //     }
        //     return dp[i][j][inCnt][exCnt][preMask] = ans;
        // }
        // private int getBit(int v, int i) {
        //     v /= (int)Math.pow(3, i);
        //     return v % 3;
        // }
        // private int setBit(int v, int i) {
        //     return (v * 3 + i) % mod;
        // }
        // private int statemax = 1, mod = 0, R = 0, C = 0;
        // private int [][][][][] dp;
        // public int getMaxGridHappiness(int m, int n, int introvertsCount, int extrovertsCount) {
        //     R = m;
        //     C = n;
        //     for (int i = 0; i < n; i ++) statemax *= 3;
        //     mod = statemax / 3;
        //     dp = new int[m][n][introvertsCount + 1][extrovertsCount + 1][statemax];
        //     return dfs(0, 0, introvertsCount, extrovertsCount, 0);
        // }
        // private int dfs(int x, int y, int in, int ex, int last){
        //     if (x == R) return 0;
        //     if (y == C) return dfs(x + 1, 0, in, ex, last); 
        //     if (dp[x][y][in][ex][last] != 0) return dp[x][y][in][ex][last];
        //     int res = dfs(x, y + 1, in, ex, last % mod * 3); // 不安排
        //     if (in != 0) { // 安排内向
        //         int addon = 120, up = last / mod, left = last % 3;
        //         if (x - 1 >= 0 && up != 0) {
        //             addon -= 30;
        //             addon += up == 1 ? -30 : 20;
        //         }
        //         if (y - 1 >= 0 && left != 0) {
        //             addon -= 30;
        //             addon += left == 1 ? -30 : 20;
        //         }
        //         res = Math.max(res, addon + dfs(x, y + 1, in - 1, ex, last % mod * 3 + 1));
        //     }
        //     if (ex != 0) { // 安排外向
        //         int addon = 40, up = last / mod, left = last % 3;;
        //         if (x - 1 >= 0 && up != 0) {
        //             addon += 20;
        //             addon += up == 1 ? -30 : 20;
        //         }
        //         if (y - 1 >= 0 && left != 0) {
        //             addon += 20;
        //             addon += left == 1 ? -30 : 20;
        //         }
        //         res = Math.max(res, addon + dfs(x, y + 1, in, ex - 1, last % mod * 3 + 2));
        //     }
        //     return dp[x][y][in][ex][last] = res;
        // }

        // public int maxHappyGroups(int batchSize, int[] groups) { // tle 
        //     int n = groups.length;
        //     int [] dp = new int [1 << n];
        //     for (int mask = 0; mask < 1 << n; mask++) {
        //         int s = 0;
        //         for (int i = 0; i < n; i++)
        //             if ((mask & (1 << i)) > 0)
        //                 s = (s + groups[i]) % batchSize;
        //         for (int i = 0; i < n; i++)
        //             if ((mask & (1 << i)) == 0)
        //                 dp[mask | (1<<i)] = Math.max(dp[mask | (1<<i)], dp[mask] + (s == 0 ? 1 : 0));
        //     }
        //     return dp[(1 << n) -1];
        // }
        // public int maxHappyGroups(int batchSize, int [] groups) { // DFS + 记忆化搜索
        //     this.batchSize = batchSize;
        //     n = groups.length;
        //     cnt = new int [batchSize];  // group size 30 is too large for backtracking WITHOUT modifications
        //     for (Integer v : groups)    // 预处理： 压缩输入以便回塑
        //         cnt[v % batchSize] ++;
        //     int ans = cnt[0], min = 0;  // 优化：通过这里的优化，将回塑的数据规模大副减小
        //     for (int i = 1; i < batchSize / 2; i++) {
        //         min = Math.min(cnt[i], cnt[batchSize-i]);
        //         cnt[i] -= min;
        //         cnt[batchSize-i] -= min;
        //         ans += min;
        //     }
        //     return dfs(0, n - cnt[0]) + ans;
        // }
        // Map<String, Integer> dp = new HashMap<>();
        // int [] cnt;
        // int n, batchSize;
        // private int dfs(int sum, int leftOver) {
        //     if (leftOver == 0) return 0;
        //     String key = Arrays.toString(cnt);
        //     if (dp.containsKey(key)) return dp.get(key);
        //     int ans = 0;
        //     for (int i = 1; i < batchSize; i++) {
        //         if (cnt[i] == 0) continue;
        //         cnt[i]--;                                      // 上一批顾客恰好买完一批甜甜圈，当前组开心
        //         ans = Math.max(ans, dfs(sum + i, leftOver-1) + (sum % batchSize == 0 ? 1 : 0));
        //         cnt[i]++;
        //         if ((sum + i) % batchSize == 0) break; // 当前顾客恰好能买完一批甜甜圈，已是最优情况之一，可剪枝 <<<======               
        //     }
        //     dp.put(key, ans);
        //     return ans;
        // }

        // public int minChanges(int [] a, int k) {
        //     int n = a.length;
        //     Map<Integer, Integer> [] group = new HashMap[k]; // 存储 k 个组、各组中各个数字数量
        //     int [] cnt = new int [k]; // k元素片段里，每个下标对应的所有元素总个数 // 各组大小,它们会有可能不同吗？
        //     for (int i = 0; i < k; i++) {
        //         group[i] = new HashMap<>();
        //         for (int j = i; j < n; j += k) { // 将数组中的每个元素分布到其在k元素片段中下标位置所在的组里去，并统计重复出现次数
        //             group[i].put(a[j], group[i].getOrDefault(a[j], 0) + 1);
        //             cnt[i]++;
        //         }
        //     }
        //     int r = 1 << 10; // 题中nums[i] < 2^10， 为的是遍历所有可能更改值，以取最小
        //     int [] dp = new int [r], curDp = new int [r]; // 当前组异或到对应数字时的更改次数
        //     Arrays.fill(dp, Integer.MAX_VALUE);
        //     dp[0] = 0;
        //     for (int i = 0; i < k; i++) { // 遍历k个元素的片段——中的每个元素，逐元素优化出全局最优解
        //         int minVal = Arrays.stream(dp).min().getAsInt(); // 累积到上一个元素的全局最优解
        //         Arrays.fill(curDp, minVal + cnt[i]); // 变为当前组中不存在数字的改变次数：之前的最小改变次数+当前组元素个数
        //         for (int j = 0; j < r; j++) {
        //             if (dp[j] == Integer.MAX_VALUE) continue;
        //             for (Map.Entry<Integer, Integer> en : group[i].entrySet()) {
        //                 int num = en.getKey(), v = en.getValue(), xorNum = num ^ j;
        //                 curDp[xorNum] = Math.min(curDp[xorNum], dp[j] + cnt[i] - v);
        //             }
        //         }
        //         dp = Arrays.copyOf(curDp, r); // 将遍历到当前组、累积较优解的curDp复制入全局最优解dp数组中
        //     }
        //     return dp[0];
        // }

        // public int largestPathValue(String colors, int[][] edges) { // contains bug: 大体思路是对的，但是方法很慢，就不再浪费时间在这个上面了
        //     s = colors.toCharArray();
        //     n = colors.length(); m = 26;
        //     int root = -1;
        //     ins = new int [n];
        //     for (int [] e : edges) {
        //         if (e[0] == e[1]) return -1;
        //         ins[e[1]]++;
        //         adj.computeIfAbsent(e[0], z -> new ArrayList<>()).add(e[1]);
        //     }
        //     for (int i = 0; i < n; i++) 
        //         if (ins[i] == 0) root = i;
        //     dp = new Integer [n][26];
        //     dfs(root, s[root]-'a');
        //     int ans = 0;
        //     for (int i = 0; i < m; i++)
        //         if (dp[root][i] != null)
        //             ans = Math.max(ans, dp[root][i]);
        //     return ans;
        // }
        // Map<Integer, List<Integer>> adj = new HashMap<>();
        // char [] s;
        // int [] ins;
        // Integer [][] dp;
        // int m, n;
        // private int dfs(int idx, int j) {
        //     if (!adj.containsKey(idx)) return dp[idx][j] = (s[idx]-'a' == j ? 1 : 0);
        //     if (dp[idx][j] != null) return dp[idx][j];
        //     int ans = 0;
        //     for (Integer v : adj.get(idx)) {
        //         for (int k = 0; k < m; k++) 
        //             ans = Math.max(ans, dfs(v, k) + (k == j ? 1 : 0));
        //     }
        //     return dp[idx][j] = ans;
        // }
        // public int largestPathValue(String colors, int[][] edges) {
        //     List<List<Integer>> adj = new ArrayList<>();
        //     int n = colors.length(), cnt = 0; 
        //     int [] ins = new int [n], topo = new int [n]; 
        //     for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        //     for (int [] e : edges) {
        //         ins[e[1]]++;
        //         adj.get(e[0]).add(e[1]);
        //     }
        //     Queue<Integer> q = new LinkedList<>();
        //     for (int i = 0; i < n; i++)
        //         if (ins[i] == 0)
        //             q.offer(i);
        //     while (!q.isEmpty()) {
        //         int u = q.poll();
        //         topo[cnt++] = u; // 将所有的节点按照拓扑排序
        //         for (Integer v : adj.get(u)) 
        //             if (--ins[v] == 0)
        //                 q.offer(v);
        //     }
        //     if (cnt < n) return -1; // 说明图中有环
        //     int ans = 0;
        //     char [] s = colors.toCharArray();
        //     for (int i = 0; i < 26; i++) {
        //         char c = (char)(i + 'a');
        //         int [] dp = new int [n];
        //         for (int j = n-1; j >= 0; j--) {
        //             int u = topo[j];
        //             for (Integer v : adj.get(u)) 
        //                 dp[u] = Math.max(dp[u], dp[v]);
        //             if (s[u] == c) dp[u]++;
        //             ans = Math.max(ans, dp[u]);
        //         }
        //     }
        //     return ans;
        // }
        // public int largestPathValue(String colors, int[][] edges) {
        //     int n = colors.length(), ans = 0, processed = 0;
        //     int[] ins = new int[n];
        //     ArrayList<Integer> [] adj = new ArrayList[n];
        //     Queue<Integer> q = new LinkedList<>();
        //     int[][] cnt = new int[n][26];
        //     for (int i = 0; i < n; ++i) adj[i] = new ArrayList<>();
        //     for (int [] e : edges) {
        //         adj[e[0]].add(e[1]);
        //         ++ins[e[1]];
        //     }
        //     for (int i = 0; i < n; ++i)
        //         if (ins[i] == 0)
        //             q.offer(i);
        //     char [] s = colors.toCharArray();
        //     while (!q.isEmpty()) {
        //         int u = q.poll();
        //         ++processed;
        //         ans = Math.max(ans, ++cnt[u][s[u] - 'a']);
        //         for (int v : adj[u]) {
        //             for (int i = 0; i < 26; ++i)
        //                 cnt[v][i] = Math.max(cnt[v][i], cnt[u][i]); // 这里是不是可以再简化一下？
        //             if (--ins[v] == 0)
        //                 q.offer(v);
        //         }
        //     }
        //     return processed == n ? ans : -1;
        // }

        // public int findMinStep(String b, String h) { // tle !!! dfs 记忆化搜索： 遍历所有的可能性，别把它当成简单的回塑游戏
        //         if (b.length() == 0) return 0;
        //         if (h.length() == 0) return -1;
        //         char [] s = h.toCharArray();
        //         int all = 0;
        //         for (int i = 0; i < h.length(); i++) {
        //             cnt.put(s[i], cnt.getOrDefault(s[i], 0) + 1);
        //             all++;
        //         }
        //         int ans = dfs(b);
        //         return ans == Integer.MAX_VALUE ? -1 : ans;
        //     }
        //     char [] arr = new char [] {'R', 'W', 'B', 'Y', 'G'};
        //     Map<String, Integer> dp = new HashMap<>();
        //     Map<Character, Integer> cnt = new HashMap<>();
        //     private int dfs(String bd) {
        //         String key = getHashCode(bd); 
        //         if (dp.containsKey(key)) return dp.get(key);
        //         if (bd.chars().distinct().count() == 1 && bd.length() >= 3) return 0; // 如果所有的株子都一样，它们会自动消失
        //         if (bd.length() == 0) return 0;
        //         if (cnt.size() > 0 && Collections.max(cnt.values()) == 0) return Integer.MAX_VALUE; // 手里没有株子了
        //         int ans = Integer.MAX_VALUE;
        //         for (int i = 0; i < bd.length(); i++)      // 遍历面板上的每个字母
        //             for (int j = 0; j < arr.length; j++) { // 遍历手里每种株子的可能性
        //                 int cur = arr[j] - 'A';
        //                 if (cnt.containsKey(arr[j])) { // 投入一粒株子
        //                     cnt.put(arr[j], cnt.get(arr[j])-1); // 投入一粒株子
        //                     if (cnt.get(arr[j]) == 0) cnt.remove(arr[j]);
        //                     StringBuilder sb = new StringBuilder(bd);
        //                     sb.insert(i+1, arr[j]);
        //                     String res = getStr(bd, i, arr[j]);
        //                     int tmp = dfs(res);
        //                     ans = Math.min(ans, tmp != Integer.MAX_VALUE ? tmp + 1 : Integer.MAX_VALUE);
        //                     cnt.put(arr[j], cnt.getOrDefault(arr[j], 0) + 1);
        //                 }
        //             }
        //         dp.put(key, ans);
        //         return ans;
        //     }
        //     private String getStr(String t, int idx, char c) { // c: 从手里塞入的一颗株子, 对投入一粒株子后的片段进行预处理
        //         char [] s = t.toCharArray();
        //         int i = idx, j = idx + 1;
        //         int one = 0, two = 0, tri = 1;
        //         while (i >= 0 && j < s.length) {
        //             while (i >= 0 && s[i] == c) {       // (0 ...idx]
        //                 one++;
        //                 i--;
        //             }
        //             while (j < s.length && s[j] == c) { // [idx+1, n)
        //                 two++;
        //                 j++;
        //             }
        //             if (one + two + tri >= 3) { // 消除一部分（>=3颗）一样的株子之后
        //                 one = 0;
        //                 two = 0;
        //                 tri = 0;
        //                 if (i >= 0) c = s[i]; // 接下来消除株子的种类
        //             } else break;
        //         }
        //         String ss = "", tt = "";
        //         i += one;
        //         j -= two;
        //         if (i >= 0) ss = t.substring(0, i+1);    // 连接剩余片段（如果曾经消除过几个株子的话），包括加入的那棵侏子
        //         if (j < t.length()) tt = t.substring(j);
        //         return tri == 1 ? ss + c + tt : ss + tt;
        //     }
        //     private String getHashCode(String s) {
        //         StringBuilder sb = new StringBuilder(s);
        //         for (int i = 0; i < arr.length; i++) 
        //             sb.append("_" + arr[i] + "_" + cnt.get(arr[i])); // cnt [] 数组太长，只存关键字母的个数
        //         return sb.toString(); // 面板上剩下的，和手里剩下的个数 一起作为状态 比较
        //     }
        // Map<String, Integer> dp = new HashMap<String, Integer>();
        // public int findMinStep(String b, String h) {
        //     char [] s = h.toCharArray();
        //     Arrays.sort(s);
        //     h = new String(s);
        //     int ans = dfs(b, h);
        //     return ans <= 5 ? ans : -1;
        // }
        // private int dfs(String b, String h) {
        //     if (b.length() == 0) return 0;
        //     String key = b + "_" + h;
        //     if (dp.containsKey(key)) return dp.get(key);
        //     int ans = 6;
        //     for (int j = 0; j < h.length(); j++) {
        //         if (j > 0 && h.charAt(j) == h.charAt(j - 1)) continue; // 第 1 个剪枝条件: 当前球的颜色和上一个球的颜色相同
        //         for (int i = 0; i <= b.length(); ++i) {
        //             if (i > 0 && b.charAt(i - 1) == h.charAt(j)) continue; // 第 2 个剪枝条件: 只在连续相同颜色的球的开头位置插入新球, 代码不懂 b[i] == b[i-1]?
        //             boolean choose = false; // 第 3 个剪枝条件: 只在以下两种情况放置新球
        //             //  - 第 1 种情况 : 当前球颜色与后面的球的颜色相同
        //             if (i < b.length() && b.charAt(i) == h.charAt(j)) 
        //                 choose = true;
        //             //  - 第 2 种情况 : 当前后颜色相同且与当前颜色不同时候放置球 (在两个相同着色的中间放置不同着色的球？)
        //             if (i > 0 && i < b.length() && b.charAt(i - 1) == b.charAt(i) && b.charAt(i - 1) != h.charAt(j)) 
        //                 choose = true;
        //             if (choose) {
        //                 String newB = clean(b.substring(0, i) + h.charAt(j) + b.substring(i));
        //                 String newH = h.substring(0, j) + h.substring(j + 1);
        //                 ans = Math.min(ans, dfs(newB, newH) + 1);
        //             }
        //         }
        //     }
        //     dp.put(key, ans);
        //     return dp.get(key);
        // }
        // public String clean(String t) {
        //     Deque<Character> charSt = new ArrayDeque<Character>();
        //     Deque<Integer> cntSt = new ArrayDeque<Integer>();
        //     StringBuffer sb = new StringBuffer();
        //     char [] s = t.toCharArray();
        //     for (int i = 0; i < s.length; ++i) {
        //         char c = s[i];
        //         while (!charSt.isEmpty() && c != charSt.peek() && cntSt.peek() >= 3) { // 把能消除的先消除掉
        //             charSt.pop();
        //             cntSt.pop();
        //         }
        //         if (charSt.isEmpty() || c != charSt.peek()) { // 要么栈空了，要么字符不同，入栈（2个）
        //             charSt.push(c);
        //             cntSt.push(1); // 记数为1
        //         } else // 栈顶有相同的字符，但计数不够3，入栈，加数
        //             cntSt.push(cntSt.pop() + 1);
        //     }
        //     if (!cntSt.isEmpty() && cntSt.peek() >= 3) {
        //         charSt.pop();
        //         cntSt.pop();
        //     }
        //     while (!charSt.isEmpty()) {
        //         char letter = charSt.pop();
        //         int count = cntSt.pop();
        //         sb.append(String.valueOf(letter).repeat(count));
        //         // for (int i = 0; i < count; ++i) sb.append(letter);
        //     }
        //     sb.reverse();
        //     return sb.toString();
        // }
        // class St {
        //     String b, h;
        //     int cnt;
        //     public St(String bd, String hd, int cnt) {
        //         this.b = bd;
        //         this.h = hd;
        //         this.cnt = cnt;
        //     }
        // }
        // public int findMinStep(String board, String hand) {
        //     char[] arr = hand.toCharArray();
        //     Arrays.sort(arr);
        //     hand = new String(arr);
        //     // 初始化用队列维护的状态队列：其中的三个元素分别为桌面球状态、手中球状态和回合数
        //     Queue<State> queue = new ArrayDeque<State>();
        //     queue.offer(new State(board, hand, 0));
        //     // 初始化用哈希集合维护的已访问过的状态
        //     Set<String> visited = new HashSet<String>();
        //     visited.add(board + " " + hand);
        //     while (!queue.isEmpty()) {
        //         State state = queue.poll();
        //         String curBoard = state.board;
        //         String curHand = state.hand;
        //         int step = state.step;
        //         for (int i = 0; i <= curBoard.length(); ++i) {
        //             for (int j = 0; j < curHand.length(); ++j) {
        //                 // 第 1 个剪枝条件: 当前球的颜色和上一个球的颜色相同
        //                 if (j > 0 && curHand.charAt(j) == curHand.charAt(j - 1)) 
        //                     continue;
        //                 // 第 2 个剪枝条件: 只在连续相同颜色的球的开头位置插入新球
        //                 if (i > 0 && curBoard.charAt(i - 1) == curHand.charAt(j)) 
        //                     continue;
        //                 // 第 3 个剪枝条件: 只在以下两种情况放置新球
        //                 boolean choose = false;
        //                 //  - 第 1 种情况 : 当前球颜色与后面的球的颜色相同
        //                 if (i < curBoard.length() && curBoard.charAt(i) == curHand.charAt(j)) 
        //                     choose = true;
        //                 //  - 第 2 种情况 : 当前后颜色相同且与当前颜色不同时候放置球
        //                 if (i > 0 && i < curBoard.length() && curBoard.charAt(i - 1) == curBoard.charAt(i) && curBoard.charAt(i - 1) != curHand.charAt(j))
        //                     choose = true;
        //                 if (choose) {
        //                     String newBoard = clean(curBoard.substring(0, i) + curHand.charAt(j) + curBoard.substring(i));
        //                     String newHand = curHand.substring(0, j) + curHand.substring(j + 1);
        //                     if (newBoard.length() == 0) return step + 1;
        //                     String str = newBoard + " " + newHand;
        //                     if (visited.add(str)) 
        //                         queue.offer(new State(newBoard, newHand, step + 1));
        //                 }
        //             }
        //         }
        //     }
        //     return -1;
        // }
        // public String clean(String s) {
        //     StringBuffer sb = new StringBuffer();
        //     Deque<Character> letterStack = new ArrayDeque<Character>();
        //     Deque<Integer> countStack = new ArrayDeque<Integer>();
        //     for (int i = 0; i < s.length(); ++i) {
        //         char c = s.charAt(i);
        //         while (!letterStack.isEmpty() && c != letterStack.peek() && countStack.peek() >= 3) {
        //             letterStack.pop();
        //             countStack.pop();
        //         }
        //         if (letterStack.isEmpty() || c != letterStack.peek()) {
        //             letterStack.push(c);
        //             countStack.push(1);
        //         } else countStack.push(countStack.pop() + 1);
        //     }
        //     if (!countStack.isEmpty() && countStack.peek() >= 3) {
        //         letterStack.pop();
        //         countStack.pop();
        //     }
        //     while (!letterStack.isEmpty()) {
        //         char letter = letterStack.pop();
        //         int count = countStack.pop();
        //         for (int i = 0; i < count; ++i) 
        //             sb.append(letter);
        //     }
        //     sb.reverse();
        //     return sb.toString();
        // }
        // class State {
        //     String board;
        //     String hand;
        //     int step;
        //     public State(String board, String hand, int step) {
        //         this.board = board;
        //         this.hand = hand;
        //         this.step = step;
        //     }
        // }

        // static final int mod = (int)1e9 + 7;
        // public int waysToBuildRooms(int[] prevRoom) {
        //     int n = prevRoom.length;
        //     fac = new int [n];
        //     inv = new int [n];
        //     fac[0] = inv[0] = 1;
        //     for (int i = 1; i < n; i++) {
        //         fac[i] = (int)((long)fac[i-1] * i % mod); // 算阶层
        //         inv[i] = quickMultiply(fac[i], mod - 2);  // 乘法逆元：费马小定理 : (fac[i]^(-1))%mod = (fac[i]^(mod-2))%mod 转换成快速幂操作
        //     }
        //     for (int i = 0; i < n; i++)
        //         m.computeIfAbsent(prevRoom[i], z -> new ArrayList<>()).add(i);
        //     return dfs(0)[1];
        // }
        // Map<Integer, List<Integer>> m = new HashMap<>();
        // int [] fac, inv;
        // private int [] dfs(int idx) { // 返回以当前节点为根的子树节点个数 及 内部排列数
        //     if (!m.containsKey(idx)) return new int [] {1, 1};
        //     int cnt = 1, ans = 1; // 子树的结点个数、内部排列数
        //     for (Integer next : m.get(idx)) {
        //         int [] cur = dfs(next); // 递归得到子节点对应树的节点个数和排列数
        //         cnt += cur[0];
        //         ans = (int)((long)ans * cur[1] % mod * inv[cur[0]] % mod);
        //     }
        //     ans = (int)((long)ans * fac[cnt-1] % mod);
        //     return new int [] {cnt, ans} ;
        // }
        // private int quickMultiply(int x, int y) { // 快速幂
        //     long ans = 1, base = x;
        //     while (y > 0) {
        //         if ((y & 1) == 1)
        //             ans = (ans * base) % mod; // 指数是奇数次，就先乘一次底数
        //         base = base * base % mod; // 指数剩偶数次了，就可以直接底数先平方，指数除以2
        //         y >>= 1; // 指数除2
        //     }
        //     return (int) ans;
        // }

        // public int[] countSubgraphsForEachDiameter(int n, int[][] edges) { 
        //     int m = n-1, range = 1 << m, root = 0, cnt = 0;
        //     int [] ans = new int [m];
        //     for (int i = 1; i < range; i++) {
        //         root = -1;
        //         Map<Integer, List<Integer>> adj = new HashMap<>();
        //         for (int j = 0; j < m; j++)  // m edges
        //             if (((i >> j) & 1) == 1) {
        //                 int [] e = edges[j];
        //                 if (root == -1) root = e[0];
        //                 adj.computeIfAbsent(e[0], z -> new ArrayList<>()).add(e[1]);
        //                 adj.computeIfAbsent(e[1], z -> new ArrayList<>()).add(e[0]);
        //             }
        //         cnt = Integer.bitCount(i);
        //         Set<Integer> vis = new HashSet<>();
        //         max = 1;
        //         dfs(root, -1, adj, vis);
        //         if (vis.size() != cnt + 1) continue;
        //         ans[max-1]++;
        //     }
        //     return ans;
        // }
        // int max = 1;
        // private int dfs(int u, int p, Map<Integer, List<Integer>> m, Set<Integer> vis) { // 树的最大直径:
        //     vis.add(u);
        //     if (m.get(u).size() == 1 && m.get(u).get(0) == p) return 1; // 叶子节点 
        //     int fst = 0, sec = 0;
        //     for (Integer v : m.get(u)) {
        //         if (v == p) continue;
        //         int cur = dfs(v, u, m, vis);
        //         if (cur >= fst) {
        //             sec = fst;
        //             fst = cur;
        //         } else sec = Math.max(sec, cur);
        //     }
        //     max = Math.max(max, fst + sec); // bug: 这里 fst + sec 不需要 +1
        //     return fst + 1;
        // }

    }
    public static void main(String[] args) {
        Solution s = new Solution();

        int [] a = new int [] {2,1,1};

        double r = s.getProbability(a);
        System.out.println(Arrays.toString(r));
    }
}
