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
        static final int mod = (int)1e9 + 7;
        public int numberOfArrays(String t, int k) { // top down
            int n = t.length(), m = ("" + k).length();
            char [] s = t.toCharArray();
            long [] dp = new long [n+1];
            dp[0] = 1;
            for (int i = 1; i <= n; i++) 
                for (int j = 0; j < Math.min(i, m); j++) {
                    if (s[i-j-1] == '0') continue;
                    long cur = Long.valueOf(t.substring(i-j-1, i));
                    if (cur >= 1 && cur <= k) 
                        dp[i] = (dp[i] + dp[i-j-1]) % mod;
                }
            return (int)dp[n];
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        // String a = "1317";
        String a = "1234567890";

            int r = s.numberOfArrays(a, 90);
        System.out.println("r: " + r);
    }
}
