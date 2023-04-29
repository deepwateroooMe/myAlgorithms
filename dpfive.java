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

        public boolean splitArraySameAverage(int[] a) { // N: 【1,30】数据规模太大了，一定会超时的 // TLE TLE TLE: 
            n = a.length; this.a = a;  N = (1 << n);
            if (n == 2) return a[0] == a[1];
            int sum = Arrays.stream(a).sum();
            for (int i = 1; i < N; i++) {
                int cnt = Integer.bitCount(i), ss = getSum(i);
                if (cnt < n && ss * n == cnt * sum) {
                    System.out.println("ss: " + ss);
                    System.out.println("cnt: " + cnt);
                    return true;
                }
            }
            return false;
        }
        int n, N; int [] a;
        int getSum(int v) {
            int r = 0;
            for (int i = 0; i < n; i++) 
                if (((v >> i) & 1) == 1) r += a[i];
            return r;
        }
        // N: 【1,30】一分为二，将数组折分成左右两个半边，再来解决问题
        public boolean splitArraySameAverage(int[] a) { // 感觉基本思路是对的，介理细节的处理上，存在一此小问题
            int n = a.length, m = n / 2, sum = Arrays.stream(a).sum();
            if (n == 1) return false;
            // 【对数组进行预处理】：既把题目转化为：找非空子集和为零，同时不能引入任何不方便处理的浮点数
            for (int i = 0; i < n; i++) a[i] = a[i] * n - sum;
            // 【遍历左半部分】：
            Set<Integer> left = new HashSet<>();
            for (int i = 1; i < (1 << m); i++) {
                int r = 0;
                for (int j = 0; j < m; j++) 
                    if (((i >> j) & 1) == 1) r += a[j];
                if (r == 0) return true; // 【快速返回：】在左边已经找到了一个非空子集和为0
                left.add(r);
            }
            // 【遍历右半部分】：
            int rsum = 0;
            for (int i = m; i < n; i++) rsum += a[i];
            for (int i = 1; i < (1 << (n-m)); i++) {
                int r = 0;
                for (int j = 0; j < (n-m); j++) 
                    if (((i >> j) & 1) == 1) r += a[j+m];
                if (r == 0) return true; // 【快速返回：】在右边已经找到了一个非空子集和为0
                // if (left.contains(-r)) return true; // 【BUG:】这个细节也狠重要。。。
                if (r != rsum && left.contains(-r)) return true; // 【r != rsum】：【1,3】＝＝》【－2,2】
            }
            return false; 
        }

        // 【记忆化深搜：】深深惊讶，我这两天把记忆化深搜写得像 1+1=2 一样简单。。。。。
        // Queue<Integer> q = new PriorityQueue<>(); 感觉确实能再快一点儿
        public int minimumVisitedCells(int[][] a) { // 记忆化深搜： TLE 1028/1069 动态规划，应该也会超时
            m = a.length; n = a[0].length; this.a = a;
            f = new Integer [m][n];  // 自己认准某一个方向来遍历
            Arrays.stream(f).forEach(z -> Arrays.fill(z, Integer.MAX_VALUE));
            int r = dfs(0, 0);
            return r == Integer.MAX_VALUE ? -1 : r;
        }
        Integer [][] f;
        int [][] a;
        int m, n;
        int dfs(int i, int j) { // 记忆化揵从当前坐标到终点的最小步数
            if (i == m-1 && j == n-1) return f[i][j] = 1;
            if (f[i][j] < Integer.MAX_VALUE ) return f[i][j];
            int r = Integer.MAX_VALUE;
            for (int y = Math.min(j + a[i][j], n-1); y > j; y--) 
                r = Math.min(r, 1 + dfs(i, y));
            for (int x = Math.min(m-1, a[i][j] + i); x > i; x--) 
                r = Math.min(r, 1 + dfs(x, j));
            return f[i][j] = r;
        }
        public int minimumVisitedCells(int[][] a) { // 带两个优先队列的动规写法：// TLE 1043/1069 改天再接着写。。。
            int m = a.length, n = a[0].length;
            if (m == 1 & n == 1) return 1;
            int [][] f = new int [m][n];
            Arrays.stream(f).forEach(z -> Arrays.fill(z, m+n));
            // Queue<int []> h = new PriorityQueue<>((x, y) -> x[0] - y[0]); // 水平方向【可以简化为只用一个】
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) { // 水平方向上的
                    if (i == 0 && j == 0) {
                        f[i][j] = 1; continue;
                    }
                    // h.clear();
                    // for (int k = Math.max(0, i - a[i][j]); k < i; k++) { // 上下方向【这里可能会漏掉一些相对优解】
                    for (int k = 0; k < i; k++) // 上下方向
                        // if (f[k][j] != m+n && a[k][j] > 0 && a[k][j] + k >= i) h.offer(new int [] {f[k][j], k, j});
                        if (f[k][j] != m+n && a[k][j] > 0 && a[k][j] + k >= i)
                            f[i][j] = Math.min(f[i][j], f[k][j] + 1);
                    // for (int k = Math.max(0, j - a[i][j]); k < j; k++) { // 左右方向【这里可能会漏掉一些相对优解】 
                    for (int k = 0; k < j; k++) // 左右方向 
                        // if (f[i][k] != m+n && a[i][k] > 0 && a[i][k] + k >= j) h.offer(new int [] {f[i][k], i, k});
                        if (f[i][k] != m+n && a[i][k] > 0 && a[i][k] + k >= j) // h.offer(new int [] {f[i][k], i, k});
                            f[i][j] = Math.min(f[i][j], f[i][k] + 1);
                    // if (!h.isEmpty()) f[i][j] = Math.min(f[i][j], f[h.peek()[1]][h.peek()[2]] + 1);
                    // h.offer(new int [] {f[i][j], i, j});
                }
            }
            return f[m-1][n-1] == m+n ? -1 : f[m-1][n-1];
        }

        // 这个题：写出涂房子、分街区有街区数目的限制了的之后，应该就会写了，要背背带背背包，背个数组作状态。。。
        // 背个数组背太多了，只要背：最后一次的数字和出现次数就可以了。。。【活宝妹就是一定要嫁给亲爱的表哥！！！】
        static final int mod = (int)1e9 + 7;
        public int dieSimulator(int n, int[] r) {
            this.r = r; m = 6;
            int max = Arrays.stream(r).max().getAsInt() + 1;
            f = new Integer [n+1][m][max];
            long ans = 0;
            return dfs(n, -1, 0);
        }
        Integer [][][] f;
        int [] r; // 这里是，每个结果，最多可以连续出现的次数
        int m;
        int dfs(int i, int j, int k) { // j: 前一次扔出来的结果
            if (i == 0) return 1;
            if (j >= 0 && f[i][j][k] != null) return f[i][j][k];
            long ans = 0;
            for (int x = 0; x < m; x++) {
                if (x == j && k < r[j])
                    ans = (ans + dfs(i-1, j, k+1)) % mod;
                else if (x != j) ans = (ans + dfs(i-1, x, 1)) % mod;
            }
            if (j >= 0) f[i][j][k] = (int)ans;
            return (int)ans;
        }


        // 算出最长公有子序列之后，要用这个东西把最短XX 给还原回来。。。。。
        public String shortestCommonSupersequence(String S, String T) { // 1092
            int m = S.length(), n = T.length();
            char [] s = S.toCharArray();
            char [] t = T.toCharArray();
            int [][] f = new int [m+1][n+1];
            for (int i = 0; i < m; i++) 
                for (int j = 0; j < n; j++)
                    if (s[i] == t[j]) f[i+1][j+1] = f[i][j] + 1;
                    else f[i+1][j+1] = Math.max(f[i+1][j], f[i][j+1]);
            if (f[m][n] == Math.max(m, n)) return S;
            System.out.println("f.length: " + f.length);
            for (int z = 0; z < f.length; ++z) 
                System.out.println(Arrays.toString(f[z]));
            // 然后根据上面的统计结果，往回倒。。。。。
            int i = 0, j = 0;
            StringBuilder sb = new StringBuilder("");
            while (i < m && j < n) {
                if (s[i] == t[j]) {
                    sb.append(s[i]);
                    i++;
                    j++;
                } else if ()
            }            
            int i = m, j = n;
            while (i > 0 && j > 0) {
                if (s[i-1] == t[j-1]) {
                    sb.insert(0, s[i]);
                    i--;
                    j--;
                } else { // (i > 0 && j > 0)
                    if (f[i][j] == f[i-1][j]) 
                        i--;
                    else if (f[i][j] == f[i][j-1]) 
                        j--;  
                }
            }
            System.out.println("sb.toString(): " + sb.toString());
            int o = m + n - f[m][n], k = 0;
            i = 0; j = 0;
            while (k < o) {
                // System.out.println("\n i: " + i);
                // System.out.println("j: " + j);
                // System.out.println("k: " + k);
                if (i < m && j < n && s[i] == t[j]) {
                    i++;
                    j++;
                    k++;
                } else {
                    while (i < m && k < o && (sb.length() == k || sb.charAt(k) != s[i])) {
                        sb.insert(k, s[i]);
                        k++;
                        i++;
                    }
                    while (j < n && k < o && (sb.length() == k || sb.charAt(k) != t[j])) {
                        sb.insert(k, t[j]);
                        k++;
                        j++;
                    }
                }
            }
            return sb.toString();
        }

        // static final int mod = (int)1e9 + 7; // 【爱表哥，爱生活！！！活宝妹就是一定要嫁给亲爱的表哥！！！】
        public int distinctSequences(int n) {
            this.n = 7;
            f = new Integer [n+1][7][7];
            return dfs(n, 0, 0); 
        }
        Integer [][][] f;
        int n;
        int dfs(int i, int j, int k) {
            if (i == 0) return 1;
            if (f[i][j][k] != null) return f[i][j][k];
            long ans = 0;
            for (int x = 1; x < n; x++) {
                if (x == j || x == k) continue; // ...
                if (k != 0 && gcd(x, k) > 1) continue;
                ans = (ans + dfs(i-1, k, x)) % mod;
            }
            return f[i][j][k] = (int)ans;
        }
        int gcd(int x, int y) {
            if (y == 0) return x;
            return gcd(y, x % y);
        }

        public int minSideJumps(int[] a) {
            n = a.length; this.a = a;
            f = new Integer [n][4];
            return dfs(0, 2, false);
        }
        int n; int [] a;
        Integer [][] f;
        int dfs(int i, int j, boolean vis) { //vis:false 时可以往边上跳
            if (i == n-1) return 0;
            if (f[i][j] != null) return f[i][j];
            if (a[i] == j) return f[i][j] = Integer.MAX_VALUE / 2; // 小青蛙撞石头上了。。。
            int r = Integer.MAX_VALUE / 2;
            r = Math.min(r, dfs(i+1, j, false)); // 走直的
            for (int k = 1; k <= 3; k++) { // 往边上跳
                // if (a[i] == k) continue;
                if (!vis && k != j)
                    r = Math.min(r, 1 + dfs(i, k, true));
            }
            return f[i][j] = r;
        }

        public int secondsToRemoveOccurrences(String t) {
            char [] s = t.toCharArray();
            int n = t.length(), i = 0, cnt = 0;
            boolean noMore = true;
            while (t.indexOf("01") != -1) {
                while (i < n) {
                    while (i < n-1 && t.substring(i, i+2).equals("01")) {
                        s[i] = '1'; s[i+1] = '0';
                        i += 2;
                        noMore = false;
                    }
                    while (i < n-1 && t.substring(i, i+2).equals("11")) i += 2;
                    while (i < n-1 && !(t.substring(i, i+2).equals("01") || t.substring(i, i+2).equals("11"))) i++;
                    if (i == n-1) i = n;
                }            
                t = new String(s);
                s = t.toCharArray();
                i = 0;
                cnt++;
            }
            return cnt;
        }

        public int longestArithSeqLength(int[] a) { // 1027
            int n = a.length, m = Arrays.stream(a).max().getAsInt() + 1;
            if (n == 2) return a[0] != a[1] ? 2 : 0;
            int [] f = new int [m];
            // for (int v : a) f[v] = 1;
            f[a[0]] = 1;
            for (int i = 1; i < n; i++) {
                f[a[i]] = Math.max(f[a[i]], 1);
                for (int j = i-1; j >= 0; j--) {
                    System.out.println("\n a[i]: " + a[i]);
                    System.out.println("a[j]: " + a[j]);
                    int d = a[i] - a[j], v = d + a[i], x = 2;
                    System.out.println("d: " + d);
                    System.out.println("v: " + v);
                    while (d != 0 && v < m  && v >= 0 && f[v] > 0) {
                        System.out.println("v: " + v);
                        f[v] = Math.max(f[v], x + 1);
                        x = f[v];
                        v = d + v;
                    }
                    System.out.println(Arrays.toString(f));
                }
            }
            return Arrays.stream(f).max().getAsInt();
        }

        public long mostPoints(int[][] a) {
            n = a.length; this.a = a; 
            f = new Long [n];
            return dfs(0);
        }
        int n; int [][] a;
        Long [] f;
        long dfs(int i) {
            if (i >= n) return 0;
            if (f[i] != null) return f[i];
            long ans = dfs(i+1);
            ans = Math.max(ans, a[i][0] + dfs(i + a[i][1] + 1));
            return f[i] = ans;
        }

        public int maximalSquare(char[][] b) {
            int m = b.length, n = b[0].length;
            int [][] a = new int [m][n], r = new int [m+1][n+1];
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++) {
                    a[i][j] = b[i][j] - '0';
                    r[i+1][j+1] = r[i][j+1] + r[i+1][j] - r[i][j] + a[i][j];
                }
            for (int d = Math.min(m, n); d > 0; d--) {
                for (int i = 0; i+d <= m; i++)
                    for (int j = 0; j+d <= n; j++)
                        if (r[i+d][j+d] - r[i+d][j] - r[i][j+d] + r[i][j] == d * d) return d * d;
            }
            return 0;
        }

        public int coinChange(int[] a, int t) { // 边界条件，狠烦人。。。写不到了，再写记忆化深搜呀。。。
            if (t == 0) return 0;
            Arrays.sort(a);
            int n = a.length;
            if (t < a[0]) return -1;
            int [] f = new int [Math.max(t+1, Arrays.stream(a).max().getAsInt() + 1)];
            Arrays.fill(f, Integer.MAX_VALUE / 2);
            for (int v : a) f[v] = 1;
            f[0] = 0;
            for (int i = n-1; i >= 0; i--) { // 只是从大到小，来遍历硬币
                int v = a[i];
                f[v] = 1;
                for (int j = t; j >= v; j--) 
                    f[j] = Math.min(f[j], f[j-v] + 1);
            }
            return f[t] >= Integer.MAX_VALUE / 2 ? -1 : f[t];
        }
        public int coinChange(int[] a, int t) { // TLE TLE TLE: 
            Arrays.sort(a);
            // System.out.println(Arrays.toString(a));
            n = a.length; this.a = a;
            if (n == 1) return t % a[0] == 0 ? t / a[0] : -1;
            if (t < a[0]) return -1;
            return dfs(t, n-1);
        }
        Map<Integer, Integer> m = new HashMap<>(); // 防：题目叨钻，离散化数据 
        int n; int [] a;
        int dfs(int i, int j) {
            if (i == 0) return 0;
            if (j < 0) return Integer.MAX_VALUE / 2;
            String k = i + "-" + j;
            if (m.containsKey(k)) return m.get(k);
            if (a[j] > i) return m.getOrDefault(k, dfs(i, j-1));
            int ans = Integer.MAX_VALUE / 2, cnt = i / a[j];
            for (int x = cnt; x >= 0; x--) 
                ans = Math.min(ans, x + dfs(i - x * a[j], j-1));
            return m.getOrDefault(k, ans);
        }
        
        static final int mod = (int)1e9 + 7;
        public int countRestrictedPaths(int n, int[][] egs) {
            this.n = n; m = n + 1;
            g = new ArrayList [m];
            Arrays.setAll(g, z -> new ArrayList<>());
            for (int [] e : egs) {
                int u = e[0], v = e[1], w = e[2];
                g[u].add(new int [] {v, w});
                g[v].add(new int [] {u, w});
            }
            d = new long [m];
            Arrays.fill(d, Long.MAX_VALUE / 2);
            calculateMinimumHP(n); // 计算到节点 n 的最短距离
            System.out.println(Arrays.toString(d));
            // 根据最短距离先有用边，动规解题
            f = new Integer [m];
            return dfs(1); // 觉得这里是我不会写动规，写错写坏了【就是这样滴～】。。。去写记忆化深搜，不会写动规的娃。。。
        }
        int dfs(int u) {
            if (u == n) return 1;
            if (f[u] != null) return f[u];
            long ans = 0;
            for (int [] e : g[u]) {
                int v = e[0];
                if (d[v] >= d[u]) continue;
                ans = (ans + (long)dfs(v)) % mod;
            }
            return f[u] = (int)ans;
        }
        List<int []> [] g;
        int m, n;
       long [] d;
        Integer [] f;
        void calculateMinimumHP(int uu) {
            d[uu] = 0;
            // boolean [] vis = new boolean [m];
            Queue<long []> q = new PriorityQueue<>((x, y) -> Long.compare(x[1], y[1]));
            q.offer(new long [] {uu, 0});
            // vis[uu] = true;
            while (!q.isEmpty()) {
               long [] cur = q.poll();
               int u = (int)cur[0];
               long t = cur[1];
                for (int [] v : g[u]) 
                    if (t + v[1] < d[v[0]]) {
                        d[v[0]] = t + v[1];
                        // vis[v[0]] = true;
                        q.offer(new long [] {v[0], d[v[0]]});
                    }
            }
        }
        void dfsIsWrong(int u) { // 不知道这里错哪里了。。。大概又是不会写动规【动规】的更新方向写反了。。。
            if (u == n) return ;
            for (int [] e : g[u]) {
                int v = e[0];
                if (d[v] >= d[u]) continue;
                f[v] = (f[v] + f[u]) % mod;
                dfs(v);
            }
        }

// 写【记忆化深搜：】写得行云流水、、、写动规，就写得各种别扭。。。。【爱表哥，爱生活！！！活宝妹就是一定要嫁给亲爱的表哥！！！】
        static final int mod = (int)1e9 + 7;
        public int peopleAwareOfSecret(int n, int d, int e) { 
            int [] f = new int [n+1];
            f[1] = 1;
            int ans = 1;
            for (int i = 2; i <= n; i++) {
                System.out.println("\n i: " + i);
                for (int j = Math.max(1, i-e); j <= Math.min(n-1, i-d); j++) {
                    f[i] += f[j];
                    // f[i] -= f[i-e];
                }
                System.out.println(Arrays.toString(f));
                ans = (ans + f[i] - (i < e ? 0 : f[i-e]));
                System.out.println("ans: " + ans);
            }
            return ans;
        }

        static final int mod = (int)1e9 + 7;
        public int firstDayBeenInAllRooms(int[] a) { // 不知道这个题目说的是什么意思。。。
            int n = a.length, r = 0, i = 0;
            int [] f = new int [n];
            f[0] = 1;
            while (f[n-1] == 0) {
                if (f[i] > 0 && f[i] % 2 == 1) {
                    i = a[i];
                    f[i]++;
                } else if (f[i] > 0 && f[i] % 2 == 0) {
                    i = (i + 1) % n;
                    f[i]++;
                }
                r = (r + 1) % mod;
                // r++;
            }
            return r;
        }

        public int sumSubarrayMins(int[] a) { // 这么算不准：要用栈
            int n = a.length;
            int [] l = new int [n], r = new int [n];
            Deque<int []> s = new ArrayDeque<>();
            for (int i = 0; i < n; i++) { // 【从左往右：】用个【递减】队列
                while (!s.isEmpty() && a[s.peekFirst()] <= a[i]) s.pollFirst();
                l[i] = (s.isEmpty() ? -1 : i - s.peekFirst() + 1);
                s.offerFirst(i);
            }
            int ans = 0;
            for (int i = 0; i < n; i++) 
                ans += a[i] * l[i] * r[i];
            return ans;
        }

        public String longestPalindrome(String t) {
            int n = t.length(); char [] s = t.toCharArray();
            if (n == 1) return t;
            int max = 1, si = 0, sj = 0;
            boolean [][] f = new boolean [n][n];
            for (int i = 0; i < n; i++) f[i][i] = true;
            for (int i = n-2; i >= 0; i--)
                for (int j = i+1; j < n; j++) 
                    if (s[i] == s[j] && (j - i <= 2 || f[i+1][j-1])) {
                        f[i][j] = true;
                        if (j - i + 1 > max) {
                            max = j - i + 1;
                            si = i; sj = j;
                        }
                    }            
            return t.substring(si, sj+1);
        }

        static final int mod = (int)1e9 + 7;
        public int countPaths(int n, int[][] egs) {
            g = new ArrayList [n]; this.n = n; 
            Arrays.setAll(g, z -> new ArrayList<>());
            for (int [] e : egs) {
                int u = e[0], v = e[1], w = e[2];
                g[u].add(new int [] {v, w});
                g[v].add(new int [] {u, w});
            }
            d = new long [n];
            calculateMinimumHP(0);
            // 【根据上面的最短距离：】把图清理一下，精简到最小图: 【不知道这里有没有更好的办法】这里重新建了一遍
            g = new ArrayList [n];
            Arrays.setAll(g, z -> new ArrayList<>());
            for (int [] e : egs) {
                int u = e[0], v = e[1], w = e[2];
                if (Math.abs(d[u] - d[v]) == (long)w) {
                    g[u].add(new int [] {v, w});
                    g[v].add(new int [] {u, w});
                }
            }
            f = new Integer [n][n];
            return dfs(0, -1);
        }
        List<int []> [] g;
        Integer [][] f;
        long [] d; int n;
        int dfs(int i, int j) {
            if (i == n-1) return 1;
            if (j >= 0 && f[i][j] != null) return f[i][j];
            long ans = 0;
            for (int [] e : g[i]) {
                int v = e[0], w = e[1];
                if (v == j) continue;
                if (d[i] < d[v]) ans = (ans + dfs(v, i)) % mod;
            }
            if (j >= 0) f[i][j] = (int)ans;
            return (int)ans;
        }
        void calculateMinimumHP(int w) { // 计算从 0 出发，到各节点的最短时间 
            Arrays.fill(d, Long.MAX_VALUE);
            d[w] = 0;
            Queue<long []> q = new PriorityQueue<>((x, y) -> Long.compare(x[1], y[1]));
            q.offer(new long [] {w, 0});
            while (!q.isEmpty()) {
                long [] cur = q.poll();
                int u = (int)cur[0]; long t = cur[1];
                for (int [] e : g[u]) {
                    int v = e[0], dist = e[1];
                    if (t + dist < d[v]) {
                        d[v] = t + dist;
                        q.offer(new long [] {v, d[v]});
                    }
                }
            }
        }

        public boolean canIWin(int n, int t) { // 不知道这里是不是位操作的时候弄错了，再写一遍
            this.t = t; this.n = n; m = n+1;
            return dfs(0, 0);
        }
        Map<Integer, Boolean> map = new HashMap<>();
        int m, n, t;
        boolean dfs(int i, int j) { // i: mask 【这里要带玩家顺序】, j: sum
            boolean fstPlayer = (((i >> m) & 1) == 0);
            System.out.println("\n Integer.toBinaryString(i): " + Integer.toBinaryString(i));
            System.out.println("j: " + j);
            System.out.println("fstPlayer: " + fstPlayer);
            if (j >= t) {
                map.put(i, fstPlayer);
                return fstPlayer; // 【第一个玩家】赢
            }
            if (map.containsKey(i)) return map.get(i);
            if (fstPlayer) {
                for (int k = 1; k <= n; k++) 
                    if ((i & (1 << k)) == 0) {
                        int v = (i | (1 << k) | (fstPlayer ? (1 << m) : 0));
                        if (dfs(v, j + k)) {
                            map.put(i, true);
                            return true;
                        }
                    }
            } else {
                for (int k = 1; k <= n; k++) 
                    if ((i & (1 << k)) == 0) {
                        int v = (i | (1 << k));
                        v ^= (1 << m); // 把那一位的 1 拿掉
                        if (!dfs(v, j + k)) {
                            map.put(i, false);
                            return false;
                        }
                    }
            }
            map.put(i, !fstPlayer);
            return !fstPlayer;
        }        
        public boolean canIWin(int n, int t) { // 可能哪里没有想对？
            this.t = t; this.n = n; m = n+1;
            return dfs(new boolean [n+1], 0);
        }
        Map<String, Boolean> f = new HashMap<>();
        int m, n, t;
        boolean dfs(boolean [] r, int j) { // i: mask 【这里要带玩家顺序】, j: sum
            System.out.println("\n j: " + j);
            System.out.println(Arrays.toString(r));
            String key = Arrays.toString(r) + "-" + j;
            if (j >= t) {
                f.put(key, !r[0]);
                return !r[0]; // 【第一个玩家】赢
            }
            if (f.containsKey(key)) return f.get(key);
            if (!r[0]) {
                for (int k = 1; k <= n; k++) {
                    if (r[k]) continue;
                    boolean [] cur = r.clone();
                    cur[0] = true;
                    cur[k] = true;
                    if (dfs(cur, j + k)) {
                        f.put(key, true);
                        return true;
                    }
                }
            } else {
                for (int k = 1; k <= n; k++) {
                    if (r[k]) continue;
                    boolean [] cur = r.clone();
                    cur[0] = false;
                    cur[k] = true;
                    if (!dfs(cur, j + k)) {
                        f.put(key, false);
                        return false;
                    } 
                }
            }
            f.put(key, !r[0]);
            return !r[0];
        }        

        public int minimumNumbers(int v, int k) { // TODO TODO TODO: 
            if (v < k) return 0;
            if (v == k) return 1;
            this.k = k;
            f = new Integer [v+1];
            return dfs(v);
        }
        int k;
        Integer [] f;
        int dfs(int i) {
            if (i == 0) return f[i] = Integer.MAX_VALUE / 2;
            if (i == k) return f[i] = 1;
            if (f[i] != null) return f[i];
            int ans = Integer.MAX_VALUE;
            for (int j = k; j <= i-k; j = j + 10) 
                ans = Math.min(ans, 1 + dfs(i - j));
            return f[i] = ans;
        }

        static final int mod = (int)1e9 + 7;
        int [] primes = new int [] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        public int squareFreeSubsets(int[] a) {
            int n = a.length, m = 31;
            int [] cnt = new int [m];
            for (int v : a) cnt[v]++;
            int [] f = new int [1 << 10]; // 遍历所有乘积的可能性
            f[0] = 1; // 这个初始化：是说，空集当作一种可能，作为起始
            // 【细节：】无论有多少个 1, 都是不影响结果的，所这所有 1 的影响【引起的数目基变】放在初始化的 f[0] 里
            for (int i = 0; i < cnt[1]; i++) f[0] = (f[0] * 2) % mod; //f[0]: 想一下，cnt[1] 的频率累积效应可以加在 f[0] 上
            for (int v = 2; v < m; v++) { // 每个数：只处理一遍
                if (cnt[v] == 0) continue;
                int r = 0;
                boolean valid = true;
                for (int j = 0; j < 10; j++) {
                    int x = primes[j];
                    if (v >= x * x && v % (primes[j] * primes[j]) == 0) {
                        valid = false;
                        break; // 它不合法
                    }
                    if (v % x == 0) r |= (1 << j);
                }
                if (!valid) continue;
                for (int j = (1 << 10)-1; j > 0; j--) 
                    if ((j & r) == r)
                        f[j] = (int)((f[j] + ((long)f[j ^ r]) * cnt[v]) % mod); // 这里犯糊涂：我要把每个数的 cnt 效应放这里吗？【为什么这样不可以呢？】
            }
           int ans = 0;
            for (int i = 0; i < (1 << 10); i++) 
                ans = (ans + f[i]) % mod;
            return (ans == 0 ? mod : ans)-1;
        }

        public boolean isMatch(String S, String T) { // 昨天想了一天，今天弱于会写这两个题目了。。。扔了那么多舍子。。。293/354 改天再写
            m = S.length(); n = T.length();
            s = S.toCharArray(); t = T.toCharArray();
            f = new Boolean [m][n][26];
            return dfs(0, 0, -1);
        }
        Boolean [][][] f; // 【机关：】这里，就像扔舍子、房子涂街区，狠多时候会需要记住前一个舍子或是房子的涂色，要把前一个字母给记住。。。
        char [] s, t;
        int m, n;
        boolean dfs(int i, int j, int k) {
            System.out.println("\n i: " + i);
            System.out.println("j: " + j);
            System.out.println("k: " + (char)(k + 'a'));
            if (i == m && j == n) return true; // 【终止条件】
            if (i == m) { // j < n
                while (j < n && t[j] == '*') j++;
                return j == n ? true : false;
            }
            if (j == n) return false;
            if (k >= 0 && f[i][j][k] != null) return f[i][j][k];
            // 【处理当前下标】：各种可能性
            if (s[i] == t[j] || t[j] == '.') {
                boolean v = dfs(i+1, j+1, s[i]-'a');
                if (k >= 0) f[i][j][k] = v;
                return v;
            } else if (s[i] != t[j] && t[j] != '.' && t[j] != '*') { // 【坑人不眨眼】×还有个特效：它能把带×字符的前一个字符给消除了。。。
                if (j == n-1 || t[j+1] != '*') { // 后面不可能再跟 *
                    if (k >= 0) f[i][j][k] = false;
                    return false;
                } else { // (j < n-1 && t[j+1] == '*')
                    // int x = i; // 这里考虑的是：【t[j]*】来匹配【s[i]+[12...9m...]】
                    // while (x < m && s[x] == s[i]) {  // 【坑人不眨眼】×还有个特效：它能把带×字符的前一个【严格地说是，如果连续，前一片同字符重复的片段】字符给消除了。。。
                    if (dfs(i+1, j, s[i]-'a') || dfs(i, j+2, k)) { // 这里记的是： t[j] 中消除掉的前一个字符，因为以后可能还需要消除。。。
                        if (k >= 0) f[i][j][k] = true;
                        return true;
                    }
                    //     x++;
                    // }
                    if (k >= 0) f[i][j][k] = false;
                    return false;
                }
            } else { // s[i] != t[j] && t[j] == '*': 【这里应该还需要考虑 * 的消除作用。。。】 // TODO TODO TODO: 
                System.out.println("\n i: " + i);
                System.out.println("j: " + j);
                int x = i;
                while (x < m && s[x] == s[i]) { // 用‘×’来配【0, 或是剩下的【i,i+1...m-1】】序列
                    // if (dfs(x, j + 1, s[i] - 'a')) return f[i][j][k] = true;
                    if (dfs(x, j + 1, s[i] - 'a')) return f[i][j][k] = true;
                    x++;
                }
                // if (x == m && j == n-1) { // 【BUG:】这只是一个特例
                //     if (k >= 0) f[i][j][k] = true;
                //     return true;
                // }
                if (dfs(x, j+1, s[i]-'a')) return f[i][j][k] = true;
                return f[i][j][k] = false;
            }
        }
        String a =  "mississippi";
        String b = "mis*is*p*.";

        public boolean isMatch(String S, String T) { // 【爱表哥，爱生活！！！活宝妹就是一定要嫁给亲爱的表哥！！！】
            m = S.length(); n = T.length(); s = S.toCharArray(); t = T.toCharArray();
            f = new Boolean [m][n];
            return dfs(0, 0);
        }
        Boolean [][] f;
        char [] s, t;
        int m, n;
        boolean dfs(int x, int y) {
            int i = x, j = y;
            if (y == n) return x == m;
            if (x == m) {
                while (j < n && t[j] == '*') j++;
                return j == n;
            }
            if (f[x][y] != null) return f[x][y];
            while (i < m && j < n && (s[i] == t[j] || t[j] == '?')) {
                i++;
                j++;
            }
            if (i < m && j < n && s[i] != t[j] && t[j] != '?' && t[j] != '*') return f[x][y] = false;
            if (i < m && j < n && t[j] == '*') {
                for (int k = i; k < m; k++)
                    if (dfs(k, j+1) || dfs(k+1, j+1) || dfs(k+1, j)) return f[x][y] = true;
                return f[x][y] = false;
            } else if (i == m && j == n) return f[x][y] = true;
            else if (j < n) {
                int k = j;
                while (k < n && t[k] == '*') k++;
                return f[x][y] = (k == n);
            }
            return f[x][y] = false;
        }

        // 【主要是长整型溢出之类的细节】：这个题的细节，比我想像得要再多一点儿，改天上午再写一下。。。 // TODO TODO TODO: 1977 157/257
        public int numberOfCombinations(String t) { 
            n = t.length(); s = t.toCharArray();
            if (n == 1) return s[0] == '0' ? 0 : 1;
            return dfs(0, 0);
        }
        static final int mod = (int)1e9 + 7;
        char [] s;
        int n;
        Map<String, Integer> m = new HashMap<>(); // 它可能还要记一下前面的数字是多少？如果这样，数据过于离散，是需要用字典的
        int dfs(int i, long j) { // 【繁琐深搜：】这个记忆化深搜，的难点在， Integer.MAX_VALUE 待特殊数字的处理，狠繁琐，改天再写。。。
            if (i == n) return 1;
            String key = i + "-" + j;
            if (m.containsKey(key)) return m.get(key);
            if (i < n && s[i] == '0') { // 以【0】打头, 不合法，直接返回
                m.put(key, 0);
                return 0;
            }
            long r = 0, v = 0;
            int k = i;
            for (k = i; k < n; k++) {
                // if (v > (Long.MAX_VALUE - (s[k] - '0')) / 10l) break;
                v = v * 10 + (s[k] - '0');
                if (v >= j) r = (r + dfs(k+1, v)) % mod;
            }
            if (k < n) r = (r + dfs(k, v)) % mod;
            m.put(key, (int)r);
            return (int)r;
        }
        String a = "3745299124190496631931491905";

        // 记忆化搜索: 这里引入了次序，怎么知道是甲方赢了？ alice ？这好像是个 min-max 的题型：但是感觉这个题型没有吃透。。。 // TODO TODO TODO:  1140
        public int stoneGameII(int[] a) {
            n = a.length; this.a = a; 
            f = new Integer [n][n][2];
            return dfs(0, 0, 0);
        }
        Integer [][] f;
        int [] a; int n;
        int dfs(int i, int j, int k) { // i: idx j: M, k: turn
            if (idx == n) return 0;
            if (f[i][j][k] != null) return f[i][j][k];
            int ans = 0, sum = 0;
            for (int x = 1; x <= 2 * j && i+x-1 < n; x++) {
                int idx = i + x - 1;
                sum += a[idx];
                ans = Math.max(ans, sum + )
            }
            int r = 0, sum = 0;
            for (int i = 1; i <= 2 * v && idx + i - 1 < n; i++) {
                int j = idx + i -1;
                sum += a[j];
                int x = sum + dfs(j+1, Math.max(v, i), a);
                System.out.println("x: " + x);
                r = Math.max(r, x);
            }
            return f[idx][v] = r;
        }

        public int waysToMakeFair(int[] a) { 
            int n = a.length;
            int [] l = new int [n], r = new int [n];
            for (int i = 0; i < n; i++)
                if (i % 2 == 0) {
                    r[i] = (i == 0 ? 0 : r[i-2]) + a[i];
                    if (i > 0)
                        l[i] = l[i-1];
                } else {
                    l[i] = (i == 1 ? 0 : l[i-2]) + a[i];
                    if (i > 0) r[i] = r[i-1];
                }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    if (r[n-1] - r[0] == l[n-1]) ans++;
                    continue;
                } else if (i == n-1) {
                    // if (i % 2 == 0 && l[n-1] - l[n-1] == r[n-1] // 这里好像写反了。。。。
                    //     || i % 2 == 1 && r[n-1] - r[n-1] == l[n-1]) ans++;
                    if (i % 2 == 0 && r[n-1] - a[n-1] == l[n-1]
                        || i % 2 == 1 && l[n-1] - a[n-1] == r[n-1]) ans++;
                    continue;
                } else {
                    if (i % 2 == 0 && r[i-2] + l[n-1] - l[i] == l[i] + r[n-1] - r[i]) ans++;
                    else if (i % 2 == 1 && l[i-1] + r[n-1] - r[i] == r[i] + l[n-1] - l[i]) ans++;
                }
            }
            return ans;
        }

        public int mincostTickets(int[] a, int[] b) {
            int n = a.length;
            int [] f = new int [n];
            f[0] = b[0];
            for (int i = 1; i < n; i++) {
                System.out.println("\n i: " + i);
                System.out.println("a[i]: " + a[i]);
                f[i] = f[i-1] + b[0];
                for (int j = i-1; j >= 0; j--) {
                    if (a[i] - a[j] <= 7) f[i] = Math.min(f[i], (j == 0 ? 0 : f[j-1]) + b[1]);
                    if (a[i] - a[j] == 30) f[i] = Math.min(f[i], f[j] + b[2]);
                }
                System.out.println(Arrays.toString(f));
            }
            System.out.println(Arrays.toString(f));
            return f[n-1];
        }

        public double nthPersonGetsNthSeat(int n) {
            if (n == 1) return 1;
            if (n == 2) return 0.5;
            double [] f = new double [n];
            f[1] = 1;
            f[2] = 0.5;
            for (int i = 3; i < n; i++)
                f[i] = 0.5 * f[i-1];
            return f[n-1];
        }

        public int minCost(String t, int[] a) {
            int n = a.length; char [] s = t.toCharArray();
            int max = a[0], sum = a[0], i = 1, cnt = 1, globalSum = Arrays.stream(a).sum(), ans = 0;
            while (i < n) {
                while (i < n && s[i] == s[i-1]) { // 统计同一色的：最大值，与和
                    cnt++;
                    max = Math.max(max, a[i]);
                    sum += a[i];
                    i++;
                }
                if (cnt == 1) {
                    sum = a[i];
                    max = a[i];
                    cnt = 1;
                    if (i == n-1) return ans;
                } else if (cnt > 1) {
                    ans += sum - max;
                    sum = (i == n ? 0 : a[i]);
                    max = (i == n ? 0 : a[i]);
                    cnt = (i == n ? 0 : 1);
                }
                i++;
            }
            return ans;
        }

        public int longestSubarray(int[] a) { // 【滑动窗口：】里面最多一个0
            int n = a.length, cnt = 0, max = 0, i = 0, j = 0;
            while (i < n ) {
                while (i < n && a[i] == 1) i++;
                if (i == n) return Math.max(max, i - j - 1); // 必须要有 1 个删除操作
                if (a[i] == 0) {
                    if (cnt == 1) max = Math.max(max, i-1 - j);
                    cnt++;
                    while (j < i && cnt > 1) { // 左端点右移
                        if (a[j] == 0) --cnt;
                        ++j; // 到 0 后面的，那一个不是 0 的下标 
                    }
                }
                i++;
            }
            if (i == n && a[n-1] == 1) max = Math.max(max, i - j - (cnt == 1 ? 0 : 1));
            return max;
        }

        public int longestStrChain(String[] a) { // TODO: 这里要找的是同一个词的一连串的桥接下来，不能两三个混搭，想想怎么写
            int n = 16, m = a.length, max = 0, min = n, ans = 1;
            Set<String> [] s = new HashSet[n];
            Arrays.setAll(s, z -> new HashSet<>());
            int [] f = new int [n];
            Arrays.fill(f, 1);
            for (String v : a) {
                int i = v.length();
                max = Math.max(max, i);
                min = Math.min(min, i);
                s[i].add(v);
            }
            for (int i = max; i >= min+1; i--) 
                for (String v : s[i]) {
                    int cnt = 0;
                    for (int j = 0; j < i; j++) {
                        String cur = (j == 0 ? "" : v.substring(0, j)) + (j == i-1 ? "" : v.substring(j+1, i));
                        if (s[i-1].contains(cur)) f[i-1] = Math.max(f[i-1], f[i] + 1);
                    }
                }
            return Arrays.stream(f).max().getAsInt();
        }
        String [] a = new String [] {"ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"};

        public int deleteAndEarn(int[] a) { // TODO TODO TODO: 740
            int n = a.length, m = 10001, max = Arrays.stream(a).max().getAsInt();
            int [] r = new int [m];
            for (int v : a) r[v]++;
            int [][] f = new int [m][2]; // 0 不选 1 选
            f[max][1] = max * r[max];
            for (int i = max-1; i >= 0; i--) {
                // if (r[i] == 0) continue; // 这个数，数组中不存在
                f[i][0] = f[i+1][1];
                f[i][1] = (i == max-1 ? 0 : f[i+2][1]) + i * r[i];
            }
            return Math.max(a, b)
        }

        public int maxProfit(int[] a) { // 122 理不清这些乱东西。。。
            int n = a.length, min = Arrays.stream(a).min().getAsInt(), ma = Arrays.stream(a).max().getAsInt();
            int max = ma - min; // 全局只一次交易的最大利润。再扫一遍，去找多次交易，是否可以获得更多利润
            int localMin = a[0], localSum = 0, localMax = 0;
            for (int i = 1; i < n; i++) {
                if (a[i] > a[i-1]) {
                    localSum += a[i] - a[i-1];
                    localMax = Math.max(localMax, Math.max(localSum, a[i] - localMin));
                } else {
                    localMin = Math.min(localMin, a[i]);
                }
            }
        }

        public int maxProfit(int[] a, int fee) { // 【或买或卖】：这是自己能够想出来的，最原始的解题出发点
            int n = a.length;
            int [] b = new int [n+1], s = new int [n+1]; // buy sell
            for (int i = 0; i < n; i++) {
                b[i+1] = Math.max((i == 0 ? Integer.MIN_VALUE : b[i]), s[i] - a[i] - fee); // 这里是，这天，买，或是不买 
                s[i+1] = Math.max(s[i], i == 0 ? 0 : b[i] + a[i]); // 今天卖，或是不卖
            }
            return Arrays.stream(s).max().getAsInt();
        }

        public int maxProfit(int[] a) { // 前一笔卖出后，要间隔一天才能再买进
            int n = a.length;
            int [] b = new int [n+1], s = new int [n+1];
            for (int i = 0; i < n; i++) { // 就是，【买进】的时候，需要在前一题的基础中【在上一次卖出之后隔一天】，两笔交易间隔一天
                b[i+1] = Math.max((i == 0 ? Integer.MIN_VALUE : b[i]), (i == 0 ? 0 : s[i-1]) - a[i]); // 这一天，或不买【取前一天买进的】，或买
                s[i+1] = Math.max(s[i], i == 0 ? 0 : b[i] + a[i]); // 今天不卖【取前一天的】，或是卖出
            }
            return Arrays.stream(s).max().getAsInt();
        }

        public int maxProfit(int[] a) { // 前一笔卖出后，当天就可以再买进 122...
            int n = a.length;
            int [] b = new int [n+1], s = new int [n+1];
            for (int i = 0; i < n; i++) { // 就是，【买进】的时候，需要在前一题的基础中【在上一次卖出之后隔一天】，两笔交易间隔一天
                s[i+1] = Math.max(s[i], b[i] + a[i]); // 今天不卖【取前一天的】，或是卖出
                b[i+1] = Math.max(b[i], s[i+1] - a[i]); // 这一天，或不买【取前一天买进的】，或买
            }
            return Arrays.stream(s).max().getAsInt();
        }

        public int findTheCity(int n, int[][] egs, int t) { // 【基本功：】感觉这类题目就是最基本的基本功，供自己下午晚上头脑不清醒的时候写写玩玩。。。
            g = new ArrayList [n]; this.n = n; this.t = t; 
            Arrays.setAll(g, z -> new ArrayList<>());
            for (int [] e : egs) {
                int u = e[0], v = e[1], w = e[2];
                g[u].add(new int [] {v, w});
                g[v].add(new int [] {u, w});
            }
            d = new int [n];
            int ans = n-1, min = n, cnt = 0;
            for (int i = n-1; i >= 0; i--) {
                Arrays.fill(d, Integer.MAX_VALUE);
                calculateMinimumHP(i);
                cnt = 0;
                for (int j = 0; j < n; j++) 
                    if (d[j] <= t) cnt++;
                if (cnt < min) {
                    ans = i;
                    min = cnt;
                }
            }
            return ans;
        }
        List<int []> [] g;
        int n, t; int [] d;
        void calculateMinimumHP(int x) {
            d[x] = 0;
            Queue<int []> q = new PriorityQueue<>((w, y) -> w[1] - y[1]);
            q.offer(new int [] {x, 0});
            while (!q.isEmpty()) {
                int [] cur = q.poll();
                int u = cur[0], w = cur[1];
                for (int [] v : g[u]) {
                    if (v[1] + w < d[v[0]]) {
                        d[v[0]] = w + v[1];
                        q.offer(new int [] {v[0], d[v[0]]});
                    }
                }
            }
        }

        public int shoppingOffers(List<Integer> p, List<List<Integer>> s, List<Integer> a) {
            this.p = p; this.s = s; this.a = a; n = a.size();
            int [] r = new int [n];
            for (int i = 0; i < n; i++) r[i] = a.get(i);
            return dfs(r);
        }
        Map<String, Integer> m = new HashMap<>(); // 记忆化深搜: 可以用个 mask, 但是位操作还是太繁琐了，这里就背个数组。。。
        List<List<Integer>> s;
        List<Integer> p, a;
        int n;
        int dfs(int [] r) {
            if (Arrays.stream(r).sum() == 0) return 0;
            String k = Arrays.toString(r);
            if (m.containsKey(k)) return m.get(k);
            int ans = 0;
            for (int i = 0; i < n; i++)
                ans += r[i] * p.get(i);
            for (int i = 0; i < s.size(); i++) {
                boolean valid = true;
                for (int j = 0; j < n; j++)
                    if (s.get(i).get(j) > r[j]) {
                        valid = false; break;
                    }
                if (valid) {
                    int [] cur = r.clone();
                    for (int j = 0; j < n; j++)
                        cur[j] -= s.get(i).get(j);
                    ans = Math.min(ans, s.get(i).get(n) + dfs(cur));
                }
            }
            m.put(k, ans);
            return ans;
        }

        // public int longestSubsequence(int[] a, int dif) { // TLE TLE TLE: 34/39 O(N^2) 可能还需要一点儿特殊处理与优化 
        //     int n = a.length, f [] = new int [n], max = 1;
        //     Arrays.fill(f, 1);
        //     for (int i = 1; i < n; i++) {
        //         int v = a[i];
        //         for (int j = i-1; j >= 0; j--) { // 我觉得这里一步步找太浪费时间了，换个字典用
        //             if (a[i] - a[j] == dif) {
        //                 f[i] = Math.max(f[i], f[j] + 1);
        //                 break;
        //             } else if (a[i] == a[j])
        //                 f[i] = Math.max(f[i], f[j]);
        //         }
        //         max = Math.max(max, f[i]);
        //     }
        //     return max;
        // }
        public int longestSubsequence(int[] a, int d) { // 换个字典就可以过了。。。
            int n = a.length, max = 1;
            Map<Integer, Integer> m = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int u = a[i], v = u - d;
                if (m.containsKey(v)) 
                    m.put(u, Math.max(m.getOrDefault(u, 2), m.get(v) + 1));
                else m.put(u, 1);
            }
            return Collections.max(m.values());
        }

        public int maxSumDivThree(int[] a) { // 记忆化深搜：这里感觉失效了呀。。。
            this.a = a; n = a.length; m = 3;
            f = new Integer [n][3];
            return dfs(0, 0);
        }
        Integer [][] f;
        int [] a;
        int n, m;
        int dfs(int i, int j) {
            if (f[i][j] != null) return f[i][j];
            if (i == n-1) return f[i][j] = (a[i] % m == j ? a[i] : 0); // 感觉这里需要一个标记，怎么知道有效与无效，所以得去用动规来写
            int ans = dfs(i+1, j), v = 0; // 不要当前的数
            int curMod = a[i] % m;
            if (curMod == 0) {
                if (j == 0) v = dfs(i+1, 0); 
                else if (j == 1) v = dfs(i+1, 1); 
                else v = dfs(i+1, 2);
            } else if (curMod == 1) {
                if (j == 0) v = dfs(i+1, 2); // 1+2
                else if (j == 1) v = dfs(i+1, 0); //1+0
                else v = dfs(i+1, 1);// 2:1+1
            } else { // (curMod == 2)
                if (j == 0) v = dfs(i+1, 1); 
                else if (j == 1) v = dfs(i+1, 2); 
                else v = dfs(i+1, 0);
            }
            if (v > 0) ans = Math.max(ans, a[i] + v);
            return f[i][j] = ans;
        }
        public int maxSumDivThree(int[] a) { // 感觉这里，是写得脑袋一团浆糊。。。
            int n = a.length;
            int [][] f = new int [n][3];
            Arrays.stream(f).forEach(z -> Arrays.fill(z, -1));
            f[n-1][a[n-1]%3] = a[n-1];
            for (int i = n-2; i >= 0; i--) {
                int m = a[i] % 3; // 接下来，想糊了，其实狠简单, 明天再改这个
                if (m == 0) {
                    f[i][0] = (f[i+1][0] == -1 ? 0 : f[i+1][0]) + a[i];
                    for (int j = 1; j < 3; j++)
                        f[i][j] = f[i+1][j];
                } else if (m == 1) {
                    f[i][0] = Math.max(f[i+1][2] != -1 ? f[i+1][2] + a[i] : -1, f[i+1][0]);
                    f[i][1] = Math.max(f[i+1][0] == -1 ? 0 : f[i+1][0] + a[i], Math.max(f[i+1][1], a[i]));
                    f[i][2] = Math.max(f[i+1][2], f[i+1][1] == -1 ? 0 : f[i+1][1] + a[i]);
                } else { // m == 2
                    f[i][0] = Math.max(f[i+1][1] == -1 ? 0 : f[i+1][1] + a[i], f[i+1][0]);
                    f[i][1] = Math.max(f[i+1][1], f[i+1][2] == -1 ? 0 : f[i+1][2] + a[i]);
                    f[i][2] = Math.max(f[i+1][2], f[i+1][0] == -1 ? 0 : f[i+1][0] + a[i]);
                }
            }
            return f[0][0];
        }

        public int minOperations(int v) { // 54 情况比较特殊，它好像是以四个位为单位的。。。
            System.out.println("\n Integer.toBinaryString(v): " + Integer.toBinaryString(v));
            System.out.println("\n Integer.toBinaryString(56): " + Integer.toBinaryString(56));
            if (Integer.bitCount(v) == 1) return 1;
           String t = Integer.toBinaryString(v);
           int n = t.length(); char [] s = t.toCharArray();
            // if (t.chars().distinct().count() == 1) return 2;// "1111111"
            int j = n-1, right = 0;
            while (j >= 0 && s[j] == '1') --j;
            if (j < 0) return 2;
            if (j < n-1) right = n - j - 1;  // 右边连续1 的个数
            int left = Integer.bitCount(v) - right;
            System.out.println("n: " + n);
            System.out.println("right: " + right);
            System.out.println("left: " + left);
            int ans = n;  // 左边一个一个移右边一片移 | 补少的一
            return ans = Math.min(Math.min(left + 2, n - (left + right) + 2), left + right);
        }

        boolean valid(String t, int l, int n) { // n 1s
            int m = t.length(), cnt = 0;
            if (m > l) return false;
            char [] s = t.toCharArray();
            for (char c : s) cnt += c - '0'; // sum of 1s
            if (cnt <= n) {         // 【cnt0s,cnt1s】
                ms.put(t, new int [] {m-cnt, cnt}); // 一边检查，一边加这里记下来备用 
                return true;
            }
            return false;
        }
        Map<String, int []> ms = new HashMap<>(); // 【0-cnt, 1-cnt】
        List<String> ll = new ArrayList<>();
        public int findMaxForm(String[] sa, int m, int n) { // 动规：
            for (String s : sa) 
                if (valid(s, m+n, n)) ll.add(s);
            Collections.sort(ll, (x, y) -> x.length() - y.length()); // 长度从小到大排列
            o = ll.size(); this.m = m; this.n = n; 
            f = new Integer [o][m+1][n+1];
            return dfs(0, 0, 0);
        }
        Integer [][][] f;
        int m, n, o;
        int dfs(int i, int j, int k) {
            if (j > m || k > n) return Integer.MIN_VALUE / 2;
            if (i == o) return j <= m && k <= n ? 0 : Integer.MIN_VALUE / 2;
            if (f[i][j][k] != null) return f[i][j][k];
            int r = dfs(i+1, j, k);
            int [] cur = ms.get(ll.get(i));
            r = Math.max(r, 1 + dfs(i+1, j+cur[0], k+cur[1]));
            return f[i][j][k] = r;
        }

        public int coinChange(int[] a, int t) {
            Arrays.sort(a);
            System.out.println(Arrays.toString(a));
            n = a.length; this.a = a;
            if (n == 1) return t % a[0] == 0 ? t / a[0] : -1;
            int v = dfs(t, n-1); 
            return v == Integer.MAX_VALUE / 2 ? -1 : v;
        }
        Map<String, Integer> m = new HashMap<>(); // 防：题目叨钻，离散化数据 
        int n; int [] a;
        int dfs(int i, int j) {
            if (i == 0) return 0;
            if (j < 0) return (i > 0 ? Integer.MAX_VALUE / 2 : 0);
            String k = i + "-" + j;
            if (m.containsKey(k)) return m.get(k);
            if (a[j] > i) {
                m.put(k, dfs(i, j-1));
                return m.get(k);
            }
            int ans = Integer.MAX_VALUE / 2, cnt = i / a[j];
            for (int x = cnt; x >= Math.max(0, cnt/10); x--)  // 深搜：就有这些不方便优化？的问题？ 186/189 最后几个过不了。。。
                ans = Math.min(ans, x + dfs(i - x * a[j], j-1));
            m.put(k, ans);
            return ans;
        }

        static final int mod = (int)1e9 + 7; // 这个死题目，把人数疯了。。。改天再写
        public int numDecodings(String t) { // 就是没有想明白：哪里出错了。。。今天的脑袋不适合想这些数来数去的题目。。。
            n = t.length(); this.t = t; 
            s = t.toCharArray();
            f = new Integer [n][11]; // 【傻傻数不清楚：】这下可以数了吗？该死的“×××”这个榆木脑袋，真是一根筋呀。。。
            return dfs(0, 10);
        }
        char [] s; String t;
        int n;
        Integer [][] f;
        int dfs(int i, int j) { // 【机关：】把前面一位数字给记住，当前位就狠好判断了。。。
            if (i == n) return 1;
            if (s[i] == '0') return f[i][j] = 0; // 主要是防：哪里自己写漏了，没处理好这个逻辑
            if (f[i][j] != null) return f[i][j];
            if (i == n-1) {
                if (s[i] == '*') {
                    // return f[i][j] = 9;
                    if (j % 10 == 0 || 3 <= j && j <= 9) return f[i][j] = 9;
                    else if (j == 1) return f[i][j] = 18;
                    else return f[i][j] = 15;
                } else { // s[i] != '*"  s[i] ==【0X-123456789-10】
                    return f[i][j] = 1;
                    // if (j % 10 == 0 || 3 <= j && j <= 9) return f[i][j] = 1;
                    // else if (j == 1) return f[i][j] = 2;
                    // else return f[i][j] = (s[i] - '0' > 0 && s[i] - '0' <= 6 ? 2 : 1);
                } 
            }
            int k = s[i] - '0', x = s[i+1] - '0'; // x: '*'
            if (0 < k && k <= 2) { // 这里是在，按 s[i+1] 分情况讨论
                if (s[i+1] == '0') return f[i][j] = dfs(i+2, 0);
                // 这里，为什么要去管下位的事？
                return f[i][j] = (int)(dfs(i+1, k) % mod);
                // else if (0 < x && x <= 6) return f[i][j] = (dfs(i+2, x) + dfs(i+1, k)) % mod;
                // // 【789】
                // else if (s[i+1] != '*') { // x 【789】 17 18 19
                //     if (k == 1) return f[i][j] = (dfs(i+2, x) + dfs(i+1, k)) % mod; 
                //     // else return f[i][j] = dfs(i+2, x); // 【这里写得不对】
                //     else return f[i][j] = (dfs(i+1, k) + dfs(i+2, x)) % mod; // k == 2
                // } else { // s[i+1] == '*'
                //     long ans = 0;
                //     for (int y = 1; y <= 9; y++) // 当前位【单独】解码
                //         ans = (ans + dfs(i+1, k)) % mod;
                //     if (k == 1)
                //         for (int y = 1; y <= 9; y++) 
                //             ans = (ans + dfs(i+2, y)) % mod; // 【连续两位一起解码】
                //     else { // k==2
                //         for (int y = 1; y <= 6; y++) // 当前位＋下一位一起
                //             ans = (ans + dfs(i+2, y)) % mod;
                //     }
                    // return f[i][j] = (int)ans;
                // }
            } else if (3 <= k && k <= 9) return f[i][j] = dfs(i+1, k);
            else { // s[i] = '*'
                long ans = 0; // 当前位单独解码【通用】
                for (int y = 1; y <= 9; y++) 
                    ans = (ans + dfs(i+1, y)) % mod;
                // if (j % 10 == 0 || 3 <= j && j <= 9) // 【0,[3456789],10】
                //     return f[i][j] = (int)ans;
                // else { // (0 < j && j <= 2) { // 【【12】：1-【123456789】，2-【123456】】
                //     for (int y = 1; y <= 6; y++) ans = (ans + dfs(i+1, y)) % mod;
                //     if (j == 1) {
                //         for (int y = 7; y <= 9; y++) ans = (ans + dfs(i+1, y)) % mod;
                //     }
                //     // j == 2: 这里前面公用部分已经写了
                    return f[i][j] = (int)ans;
                // }
            }
        }
    }
    public static void main (String[] args) { // 【爱表哥，爱生活！！！活宝妹就是一定要嫁给亲爱的表哥！！！】
        Solution s  =  new Solution ();

        String a = "***";

        int r = s.numDecodings(a);
        System.out.println("r: " + r);
    } 
}
// ListNode head = new ListNode(a[0]); 
// head.buildList(head, a);  
// head.printList(head);
// TreeNode rr = new TreeNode(a[0]);
// rr.buildTree(rr, a);
// rr.levelPrintTree(rr);







