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
public class dpeight {
    public static class Solution {

        public int[] countSubgraphsForEachDiameter(int n, int[][] egs) {
            m = egs.length; this.n = n; this.a = egs; 
            g = new ArrayList [n+1];
            Arrays.setAll(g, z -> new ArrayList<>());
            int [] r = new int [n-1];
            for (int i = 1; i < (1 << n); i++) { // 遍历，所有可能的子树：通过选择子树中节点的方式
                sur = 0; // 随便：找一个节点，作为当前子树的根节点
                if (buildTree(i)) { // 是一棵，可连通的子树
                    // 计算子树的最大直径，更新结果
                    max = 0;
                    dfsMaxWidth(sur, -1);
                    if (max > 0)
                        r[max-1]++;
                }
            }
            return r;
        }
        List<Integer> [] g;
        int [][] a;
        int m, n, max = 0, sur = 0;
        int dfsMaxWidth(int sur, int p) { // 【数边：】这里是数边，不是数路过的所有的节点
            int curSubTreeMax = 0; // 从当前节点出发，【带根节点，单侧最长路径】
            if (g[sur].size() == 1 && g[sur].get(0) == p) // 叶子节点： 0
                return curSubTreeMax;
            for (int v : g[sur])
                if (v != p) {
                    int curMax = dfsMaxWidth(v, sur);
                    max = Math.max(max, curSubTreeMax + curMax + 1); // 遍历过的，某现最长路径，与当前子树最长路径，的和
                    curSubTreeMax = Math.max(curSubTreeMax, 1 + curMax); // 更新：带根节点，最长路径
                }
            return curSubTreeMax;
        }
        Set<Integer> sv = new HashSet<>(); // 顶点集合
        boolean buildTree(int i) {
            Arrays.setAll(g, z -> new ArrayList<>());
            Set<Integer> si = new HashSet<>(); // mask: 有这些顶点
            for (int j = 0; j < n; j++)
                if ((i & (1 << j)) > 0) {
                    si.add(j+1);
                    if (sur == 0) sur = j+1;
                }
            for (int j = 0; j < m; j++) {
                int [] cur = a[j];
                int u = a[j][0], v = a[j][1];
                if (si.contains(u) && si.contains(v)) {
                    g[u].add(v);
                    g[v].add(u);
               }
            }
            sv.clear();
            dfs(sur, -1);
            return sv.size() == Integer.bitCount(i);
        }
        void dfs(int sur, int p) {
            sv.add(sur);
            if (g[sur].size() == 1 && g[sur].get(0) == p) 
                return ; // 叶子节点
            for (int v : g[sur])
                if (v != p) dfs(v, sur);
        }

        public int minimumOneBitOperations(int n) { // TLE TLE TLE: 
            if (n == 0) return 0;
            Map<Integer, Integer> m = new HashMap<>();
            m.put(1, 1);
            int last2pK = 1; // 记录上一个2^k的数值
            for (int i = 2; i <= n; i++) {
                if (i == 2 * last2pK) {
                    m.put(i, m.get(last2pK) * 2 + 1);
                    last2pK = i;
                } else
                    m.put(i, m.get(last2pK) - m.get(i % last2pK));
            }
            return m.get(n);
        }
        Map<Integer, Integer> m = new HashMap<>();
        TreeSet<Integer> s = new TreeSet<>();
        public int minimumOneBitOperations(int n) { // TLE TLE TLE: 
            m.put(0, 0);
            int last2pK = 1;
            while (last2pK <= n) {
                m.put(last2pK, m.get(last2pK / 2) * 2 + 1);
                s.add(last2pK);
                last2pK *= 2;
            }
            return helper(n);
        }
        int helper(int i) {
            if (m.containsKey(i)) return m.get(i);
            int low = s.floor(i); // 找到小于n的最大的2的整次幂
            return helper(low) - helper(i % low);
        }

        // 【记忆化深搜：】题目狠简单，就是最开始读不懂题目说的是什么意思。。。
        public int numOfArrays(int n, int m, int k) {
            this.n = n; this.m = m;
            f = new Integer [n][m+1][k+1];
            return dfs(0, 0, k);
        }
        Integer [][][] f;
        static final int mod = (int)1e9 + 7;
        int m, n; 
        int dfs(int i, int j, int k) { // i: idx  j: prevValue 之前 i 个元素用到过的最大值  k: cnt of compare left
            if (j > m || k < 0) return 0; // 数值，不能超过 m
            if (i == n) return k == 0 ? 1 : 0;  // 一定比较 k 次
            if (f[i][j][k] != null) return f[i][j][k];
            long ans = 0;
            for (int x = 1; x <= m; x++) { // 把当前可能的 m 个数，每个作为候选，遍历一遍
                if (x <= j) ans = (ans + dfs(i+1, j, k)) % mod;
                else ans = (ans + dfs(i+1, x, k-1)) % mod;
            }
            return f[i][j][k] = (int)ans;
        }

        public int minimumDistance(String t) {// 1320: 我本来要【记忆化深搜】的，可是一看，它说让【暴搜】，想下感觉暴搜不该是天下最简单的事吗？
            int n = t.length(); char [] s = t.toCharArray(); int x = 5, y = 6;
            int [][][] f = new int [26][26][n];
            for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) Arrays.fill(f[i][j], Integer.MAX_VALUE);
            // f[0][0][0] = 0; // 【初始化：】这里不对，两个手指头的初始位置，代价为 0
            for (int i = 0; i < 26; i++) for (int j = 0; j < 26; j++) f[i][j][0] = 0;
            for (int i = 0; i < 26; i++) // 第一个手指头
                for (int j = 0; j < 26; j++) { // 第二个手指头
                    if (j == i) continue; // 不会笨到，两个手指头敲一个键吧。。。
                    for (int k = 0; k < n; k++) { // 第 k 个字符
                        int ii = (s[k] - 'A') / y, jj = (s[k] - 'A') % y;
                        int d = Math.abs(ii - i / y) + Math.abs(jj - i % y), dd = Math.abs(ii - j / y) + Math.abs(jj - j % y);
                        if (d <= dd) f[s[k]-'A'][j][k] = Math.min(f[s[k]-'A'][j][k], (k == 0 ? 0 : f[i][j][k-1]) + d);
                        else f[i][s[k]-'A'][k] = Math.min(f[i][s[k]-'A'][k], (k == 0 ? 0 : f[i][j][k-1]) + dd);
                    }
                }
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < 26; i++)
                for (int j = 0; j < 26; j++)
                    ans = Math.min(ans, f[i][j][n-1]);
            return ans;
        }
        public int minimumDistance(String t) { // 【记忆化深搜】: 瓣这两个手指头没什么意思，换个题写。。。
            n = t.length; s = t.toCharArray();
            f = new Integer [n][26][27];
            return dfs(0, 26, 26);
        }
        Integer [][][] f;
        int n; char [] s;
        int dfs(int i, int j, int k) {
            if (i == n) return 0;
            if (f[i][j][k] != null) return f[i][j][k];
        }

        public int[] sumOfDistancesInTree(int n, int[][] egs) { // TLE TLE TLE: 
            this.n = n; 
            g = new ArrayList [n];
            Arrays.setAll(g, z -> new ArrayList<>());
            for (int [] e : egs) {
                int u = e[0], v = e[1];
                g[u].add(v);
                g[v].add(u);
            }
            d = new int [n]; //vis = new boolean [n];
            // Arrays.fill(d, Integer.MAX_VALUE);
            // calculateShortestDist(0);
            int [] r = new int [n]; // 【必要的优化】：根节点的变化，所引起的改变的部分，以及原本根节点子树不变的部分，细节忘记了。。。
            for (int i = 0; i < n; i++) {
                Arrays.fill(d, Integer.MAX_VALUE);
                calculateShortestDist(i);
                r[i] = Arrays.stream(d).sum();
            }
            return r;
        }
        List<Integer> [] g;
        int [] d; //boolean [] vis; // 【求最短距离：】不需要这个数组
        int n;
        void calculateShortestDist(int sur) {
            d[sur] = 0; //vis[sur] = true;
            Queue<int []> q = new PriorityQueue<>((x, y) -> x[1] - y[1]);
            q.offer(new int [] {sur, 0});
            while (!q.isEmpty()) {
                int [] cur = q.poll();
                int u = cur[0], t = cur[1];
                for (int v : g[u]) 
                    // if (!vis[v]) {
                    if (t + 1 < d[v]) {
                        d[v] = t + 1;
                        q.offer(new int [] {v, t + 1}); // vis[v] = true;
                    }
            }
        }
        public int[] sumOfDistancesInTree(int n, int[][] egs) { // 【动规：】【O(N)】解题思路相对奇妙，是自己以前理解不深入，或是早忘记了的
            g = new ArrayList [n];
            Arrays.setAll(g, z -> new ArrayList<>());
            for (int [] e : egs) {
                int u = e[0], v = e[1];
                g[u].add(v);
                g[v].add(u);
            }
            f = new int [n]; r = new int [n]; ans = new int [n];
            // 【第一遍dfs】：以 0 为树根节点，自底向上，计算出，以每个节点为根的子树 f[i] 与节点数 r[i]
            dfs(0, -1);
            // 【第二遍dfs】：以 0 为树根节点，与其它子树节点，换根操作，自顶向下?
            // 在【O(1)】时间内，计算出换根后，距离和. u 与 v 换根，引起的只是 f[u] r[u] 与 f[v] r[v] 两个节点的相应变化
            dfsSec(0, -1);
            return ans;
        }
        List<Integer> [] g;
        int [] f, r, ans;
        void dfsSec(int u, int p) { // 这个分析方法，得掌握了。。。比较奇妙【爱表哥，爱生活！！！活宝妹就是一定要嫁给亲爱的表哥！！！】
            ans[u] = f[u];
            for (int v : g[u]) { // 原根节点 u 与子树根节点 v 的换根
                if (v == p) continue; // 【自顶向下】：执行完当前换根操作，再 dfs 与其它节点的换根。。。
                int fu = f[u], ru = r[u], fv = f[v], rv = r[v]; // 【精华：】都在这里，要记住，还要改回去的，树状 DP ！！！
                f[u] -= (f[v] + r[v]); // u 由原根节点，变为子树节点, 由大变小
                r[u] -= r[v]; // 已经变小了
                f[v] += (f[u] + r[u]); // 由子树节点，变根节点，由小变大
                r[v] += r[u];
                dfsSec(v, u); // 【自顶向下】：可以拿到当前子树根节点的 ans[v] 值 
                f[u] = fu; r[u] = ru;  // 【BUG：】对于 v 的 sibling 节点来说，需要与原根节点 u 换根，所以需要还原回去
                f[v] = fv; r[v] = rv;  // 效力同样 dfs 累加到子节点上。。。
            }
        }
        void dfs(int u, int p) {
            f[u] = 0;
            r[u] = 1;
            for (int v : g[u])
                if (v != p) {
                    dfs(v, u);
                    f[u] += f[v] + r[v]; // 动态更新：由以 v 为根节点的子树，所引起的，到现根节点的距离和
                    r[u] += r[v];
                }
        }

        public int stoneGameVIII(int[] a) { // 【记忆化深搜：】// TLE TLE TLE: 61/78 必须改写成【动规】的写法。。。
            n = a.length; this.a = a;
            p = new int [n+1];
            for (int i = 0; i < n; i++) p[i+1] = p[i] + a[i];
            f = new Integer [n];
            return dfs(0);
        }
        Integer [] f;
        int [] a, p;
        int n;
        int dfs(int i) {
            if (i == n) return 0;
            if (f[i] != null) return f[i];
            int r = Integer.MIN_VALUE;
            for (int j = i + (i == 0 ? 1 : 0); j < n; j++) 
                r = Math.max(r, p[j+1] - dfs(j+1));
            return f[i] = r;
        }
        static final int mod = (int)1e9 + 7;
        public int stoneGameVIII(int[] a) { // 【动规：】现在就慢慢瓣，把它改写成动规，应该就可以过了N =【10^5】写动规好别扭，早点儿习惯了动规，哈哈哈。。。
            int n = a.length;
            int [] p = new int [n+1];
            for (int i = 0; i < n; i++) p[i+1] = p[i] + a[i];
            int [] f = new int [n];
            int max = p[n];
            // if (n == 2) return max;
            f[n-1] = p[n];
            for (int i = n-2; i > 0; i--) {
                f[i] = Math.max(max, p[i+1] - f[i+1]);
                max = Math.max(max, f[i]);
            }
            System.out.println(Arrays.toString(f));
            return f[1];
        }

        public int maxJumps(int[] a, int d) {
            int n = a.length, j = 0;
            int [] f = new int [n]; // 仍然是原数组下标对应
            Arrays.fill(f, 1);
            Integer [] id = IntStream.range(0, n).boxed().toArray(Integer[]::new); // 升序排列
            Arrays.sort(id, (x, y)-> a[x] - a[y]);
            for (int x = 0; x < n; x++) { // 只把它当作一个遍历顺序: 保证想要用它来自顶向下更新的时候，它是已经遍历过的，结果可用的
                int i = id[x]; // 每个当前的坐标，可以往两边一直跳到前一个小矮坐标
                j = i - 1;
                while (j >= 0 && i-j <= d) { // 往左遍历
                    if (a[j] >= a[i]) break;
                    f[i] = Math.max(f[i], f[j] + 1);
                    j--;
                }
                j = i + 1;
                while (j < n && j <= i+d) {
                    if (a[j] >= a[i]) break; 
                    f[i] = Math.max(f[i], f[j] + 1);
                    j++;
                }
            }
            return Arrays.stream(f).max().getAsInt();
        }

        // 【记忆化深搜：自顶向下】现根据提示，反过来添加气球。【自顶向下的记忆化深搜】，与【自底向上的动规】，是回字的两样不同写法，只是方向不同
        public int maxCoins(int[] a) {
            n = a.length+2;
            r = new int [n];
            r[0] = 1; r[n-1] = 1;
            for (int i = 0; i < a.length; i++)
                r[i+1] = a[i];
            System.out.println(Arrays.toString(r));
            f = new Integer [n][n];
            return dfs(0, n-1);
        }
        Integer [][] f;
        int n; int [] r;
        int dfs(int i, int j) { // 开区间：（i,j）不包括两个端点
            if (i+1 >= j) return 0;  // 两年气球间没有空间，不能再添加新的气球
            if (f[i][j] != null) return f[i][j];
            int ans = 0;
            for (int k = i+1; k < j; k++) 
                ans = Math.max(ans, r[i] * r[k] * r[j] + dfs(i, k) + dfs(k, j));
            return f[i][j] = ans;
        }       
        public int maxCoins(int[] a) { // 【动规：】自底向上, 动规写得好别扭。。。
            int n = a.length;
            int [] r = new int [n+2];
            r[0] = 1; r[n+1] = 1;
            for (int i = 0; i < a.length; i++) r[i+1] = a[i];
            int [][] f = new int [n+2][n+2];
            for (int i = n-1; i >= 0; i--) // 【自底向上：】从后往前遍历
                for (int j = i+2; j <= n+1; j++)
                    for (int k = i+1; k < j; k++) { // 遍历中间的切点
                        int sum = r[i] * r[k] * r[j];
                        sum += f[i][k] + f[k][j];
                        f[i][j] = Math.max(f[i][j], sum);
                    }
            return f[0][n+1];
        }

        public int rearrangeSticks(int n, int k) { // 【动规：】这些都成了需要严格动规的题目。。。【记忆化深搜】先跑一遍。。。
            int [][] f = new int [n+1][k+1];
            f[0][0] = 1; // 初始化
            // 去找状态转移方程： f【i】【j】：前 i 个下标可以看见 j 根竹子，那么就去想，第 i 个下标的第 j 根可见筷子可以如何生成呢？第 i 个下标【可见】或是【不可见】
            // 这里， n 根筷子，哪些用去了，哪些没用去的关系，还没能想清楚。。【活宝妹就是一定要嫁给亲爱的表哥！！！】
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= k; j++) 
                    f[i][j] = f[i-1][j] + f[i-1][j-1];
            return f[n-1][k];
        }
        // 题目要求：每根筷子用一次，这里用了无数次
        public int rearrangeSticks(int n, int k) { // 【记忆化深搜】先跑一遍。。。跟早上比较 k 次的数组题是一样的
            f = new Integer [n][n+1][k+1]; this.n = n; 
            return dfs(0, 0, k);
        }
        Integer [][][] f;
        static final int mod = (int)1e9 + 7;
        int n;
        int dfs(int i, int j, int k) { // i: idx  j:maxVal  k: compareToLeft
            if (i == n) return j <= n && k == 0 ? 1 : 0;
            if (k < 0 || j > n) return 0;
            if (f[i][j][k] != null) return f[i][j][k];
            int r = 0;
            // 当前的筷子：两种情况：【从左能看见】＋【从左边看不见】
            for (int x = 1; x <= n; x++) { // 这里没限制住的是：如何保证，每根筷子只用一次？ i-j-k 三个数是有互相制约关系的，改天再写
                // 【从左边看不见】：被挡住了
                if (x <= j) r = (r + dfs(i+1, j, k)) % mod;
                // 【从左边能看见】：它比较高，挡不住
                else r = (r + dfs(i+1, x, k-1)) % mod;
            }
            return f[i][j][k] = r;
        }

        public int minDistance(int[] a, int k) { // 【中位数】：对于题目动规中要用到的区间中位数查询，要先预处理一下
            n = a.length; this.a = a; Arrays.sort(a);
            r = new int [n+1];
            for (int i = 0; i < n; i++) r[i+1] = r[i] + a[i];
            System.out.println(Arrays.toString(r));
            f = new Integer [n][k+1];
            return dfs(0, k);
        }
        Integer [][] f;
        int [] a, r;
        int n;
        int dfs(int i, int j) {
            if (i == n) return 0;
            if (j == 1) {
                int r = 0;
                for (int k = i; k < n; k++)
                    r += a[k] - a[i + (n - i + 1) / 2 - 1];
                return f[i][j] = r[n] - r[i] - (n-i) * a[i+(n-i) / 2 -1];
                // return f[i][j] = r[n] - r[i] - (n-i) * a[i+(n-i) / 2 -1];
            }
            if (f[i][j] != null) return f[i][j];
            int ans = Integer.MAX_VALUE;
            for (int k = i; k < n-(j-1); k++) { // 不会算中位数。。。
                ans = Math.min(ans, (k-i == 0 ? 0 : r[k+1] - r[i] - a[i + (k+1-i)/2 - 1] * (k + 1 - i)) + dfs(k+1, j-1));
                // ans = Math.min(ans, (k-i == 0 ? 0 : r[k+1] - r[i] - (a[k] + a[i]) / 2 * (k + 1 - i)) + dfs(k+1, j-1));
            }
            return f[i][j] = ans;
        }
        public int minDistance(int[] a, int k) {
            int n = a.length; Arrays.sort(a);
            int [][] r = new int [n][n]; // 【中位数】预处理 
            for (int i = n-2; i >= 0; i--) 
                for (int j = i+1; j < n; j++) 
                    r[i][j] = r[i+1][j-1] + a[j] - a[i];
            int [][] f = new int [n][k+1];
            Arrays.stream(f).forEach(z -> Arrays.fill(z, Integer.MAX_VALUE / 2));
            for (int i = 0; i < n; i++) {
                f[i][1] = r[0][i];
                for (int j = 2; j <= k && j <= i+1; j++)
                    for (int x = 0; x < i; x++) 
                        f[i][j] = Math.min(f[i][j], f[x][j-1] + r[x+1][i]);
            }
            return f[n-1][k];
        }

        static final int mod = (int)1e9 + 7;
        public int numberOfUniqueGoodSubsequences(String t) { // 写不习惯动规：还是先记忆化深搜
            int n = t.length(); char [] s = t.toCharArray();
            int [] l = new int [n], r = new int [n]; // l: one  r:zero
            int i = 0;
            while (i < n && s[i] == '0') i++; // 过滤掉头上一片 0
            l[i] = 1;
            for (; i < n; i++) {
                if (s[i] == '0')
            }
        }   
        static final int mod = (int)1e9 + 7;
        public int numberOfUniqueGoodSubsequences(String t) { // 写不习惯动规：还是先记忆化深搜
          n = t.length(); s = t.toCharArray();
            int i = 0;
            while (i < n && s[i] == '0') i++; // 过滤掉头上一片 0:
            if (i == n) return 1;
            for (int i = 0; i < n; i++) if (s[i] == '1') l.add(i);
            return dfs(i); // 确保以 1 打头
        }
        Integer [] f;
        int n; char [] s;
        List<Integer> l = new ArrayList<>(); // 1 idxes
        int dfs(int i) {
            if (i == n) return 0;
            if (f[i] != null) return f[i];
            int r = 0;
            for (int j = i+1; j < n; j++) 
        }        

        // 【记忆化深搜：】一定会超时。可是写不到动规，就先深搜一遍，启蒙一下。。。再改动规。。。改天再写 1955
        public int countSpecialSubsequences(int[] a) {
            n = a.length; this.a = a;
            // g = new ArrayList [3]; Arrays.setAll(g, z -> new ArrayList<>());
            // for (int i = 0; i < n; i++)
            //     g[a[i]].add(i);
            f = new Integer [n][3];
            return dfs(0, 0);
        }
        Integer [][] f;
        // List<Integer> [] g;
        static final int mod = (int)1e9 + 7; int [] a;
        int n; 
        int dfs(int i, int j) {
            if (i == n) return j >= 2 ? 1 : 0; // 这里有假阳性：当 j == 2 并不确定：是否一定包含
            if (j > 2) return 0;
            if (f[i][j] != null) return f[i][j];
            long ans = 0;
            if (a[i] == j) {
                ans = (ans + dfs(i+1, j+1)) % mod; // 有 j 了
                ans = (ans + dfs(i+1, j)) % mod; // 还没有 j
            } else if (a[i] < j) { // a[i] > j
                return f[i][j] = dfs(i+1, j);
            } else { // a[i] > j
                if (a[i] == j + 2) return f[i][j] = 0;
                // ans = (ans + dfs(i+1, j+2)) % mod; // 有 j+1 了 1
                ans = (ans + dfs(i+1, j)) % mod; // 还没有 j
                ans = (ans + dfs(i+1, j+1)) % mod; // 还没有 j+1
            }
            return f[i][j] = (int) ans;
        }

        // 【思路：】分解乘积的质因子，然后排列组合解题。就把这个题当，排列组合的启蒙题来参考写，以解决之后诸多写不出来的排列组合题。。。
        static final int mod = (int)1e9 + 7;
        int [][] r;  // 组合方案计算 
        public int[] waysToFillArray(int[][] a) {
            int maxSize = 0, maxNum = 0; // 这两个数，用来计算最大排列组合数
            for (int [] e : a) {
                maxSize = Math.max(maxSize, e[0]);
                maxNum = Math.max(maxNum, e[1]);
            }
            int tmp = maxNum;
            int maxPrimesCount = 0;
            while (tmp > 1) { // 最多可能的质因子 2 的个数，用来用作上限
                maxPrimesCount ++;
                tmp /= 2;
            }
            r = new int [maxSize + maxPrimesCount + 1][maxPrimesCount + 1];
            r[0][0] = 1;
            for (int i = 1; i <= maxSize + maxPrimesCount; i++) { // 遍历：数与挡板【x + n - 1】
                r[i][0] = 1; // j == 0,就是，什么也不选 
                if (i <= maxPrimesCount) r[i][i] = 1; // 从 i 个数中选 i 个数，选满，只有 1 种方案
                int maxVal = Math.min(i-1, maxPrimesCount); // 遍历：选择方案，选 j 个数，不是挡板
                for (int j = 1; j <= maxVal; j++)
                    r[i][j] = (r[i-1][j-1] + r[i-1][j]) % mod;
            }
            int [] ans = new int [a.length];
            for (int i = 0; i < a.length; i++) {
                int n = a[i][0], k = a[i][1];
                ans[i] = countWays(n, k);
            }
            return ans;
        }
        int countWays(int n, int k) {
            long ans = 1;
            for (int i = 2; i <= k; i = next(i, k)) {
                int exp = 0;
                while (k % i == 0) {
                    exp++;
                    k /= i;
                }
                if (exp > 0) { // 当乘积含某质因子的个数多于 1, 排列组合数。。。
                    int cur = r[exp + n - 1][exp];
                    ans = ans * cur % mod;
                }
            }
            return (int)ans;
        }
        int next(int v, int k) {
            if (v * v > k && v < k) return k;
            else return v == 2 ? v + 1 : v + 2;
        }

        // // 算出最长公有子序列之后，要用这个东西把最短XX 给还原回来。。。。。
        // 【字符串：】不怎么喜欢写字符串的题，觉得还不会灵活思考。。
        public String shortestCommonSupersequence(String S, String T) { // 1092
            int m = S.length(), n = T.length();
            char [] s = S.toCharArray();
            char [] t = T.toCharArray();
            int [][] f = new int [m+1][n+1];
            for (int i = 0; i < m; i++) 
                for (int j = 0; j < n; j++)
                    if (s[i] == t[j]) f[i+1][j+1] = f[i][j] + 1;
                    else f[i+1][j+1] = Math.max(f[i+1][j], f[i][j+1]);
            // 然后根据上面的统计结果，往回倒。。。。。可是就是写不对。。。破题目。。。
            int o = m + n - f[m][n]; int i = 0, j = 0;
            char [] r = new char [o];
            for (int k = 0; k < o; k++) {
                if (i < m && j < n && s[i] == t[j]) {
                    r[k] = s[i];
                    i++;
                    j++;
                } else if (i < m-1 && j < n-1 && f[i+1][j+2] > f[i+2][j+1]) {
                    r[k] = t[j]; j++;
                } else if (i < m-1 && j < n-1) {
                    r[k] = s[i]; i++;
                } else if (i < m || j < n) {
                    while (i < m) r[k++] = s[i++];
                    while (j < n) r[k++] = t[j++];
                }
            }
            return new String(r);
        }
        public String shortestCommonSupersequence(String S, String T) { // 【活宝妹就是一定要嫁给亲爱的表哥！！！爱表哥，爱生活！！！】
            int n = S.length(), m = T.length();
            char [] s = S.toCharArray(), t = T.toCharArray();
            // 我自己写的是，两个的最长公有序列；这里动规的是，两个的最短 superstring...
            int [][] f = new int [n+1][m+1]; // 初始化
            for (int i = 0; i < n; i++) f[i][m] = n - i;
            for (int i = 0; i < m; i++) f[n][i] = m - i;
            for (int i = n-1; i >= 0; i--) 
                for (int j = m-1; j >= 0; j--) {
                    if (s[i] == t[j]) f[i][j] = f[i+1][j+1] + 1;
                    else f[i][j] = Math.min(f[i+1][j], f[i][j+1]) + 1;
                }
            StringBuilder r = new StringBuilder("");
            int i = 0, j = 0;
            while (i < n && j < m) {
                if (s[i] == t[j]) {
                    r.append(s[i++]);
                    j++;
                } else if (f[i+1][j] == f[i][j] - 1)
                    r.append(s[i++]);
                else if (f[i][j+1] == f[i][j] - 1)
                    r.append(t[j++]);
            }
            while (i < n) r.append(s[i++]);
            while (j < m) r.append(t[j++]);
            return r.toString();
        }

        // 【动规：】写不习惯，还是可以先【记忆化深搜】，再试着改写成【动规】。。。1531
        public int getLengthOfOptimalCompression(String t, int k) {
            n = t.length(); s = t.toCharArray();
            f = new Integer [n][k+1];
            return dfs(0, k);
        }
        Integer [][] f;
        int n; char [] a;
        int dfs(int i, int j) {
            if (i == n) return 0;
            if (f[i][j] != null) return f[i][j];
            if (j == 0) { // 返回剩下下标能够压缩成为的长度
                int k = i+1, r = 0;
                while (k < n) {
                    while (k < n && s[k] == s[k-1]) k++;
                }
            }
            int r = Integer.MAX_VALUE;
            int k = i+1;
        }        

        // 【比较繁琐：】先用栈解出正确答案；再【区间型动规。。。】今天上午的加气球，真启发，怎么能够想到是添加气球呢？
        // 【真强大，居然就写出来了～～！！！活宝妹就是一定要嫁给亲爱的表哥！！！】
        public int scoreOfStudents(String t, int[] a) { 
            m = a.length; n = t.length(); s = t.toCharArray(); this.a = a; 
            int ans = getCorrectResult();
            // 【区间型动规】：写出来，仍然是， 1+1=2 的记忆化深搜。。。
            f = new HashSet [n][n];
            Set<Integer> s = dfs(0, n-1);
            int r = 0;
            for (int v : a)
                if (v == ans) r += 5;
                else if (s.contains(v)) r += 2;
            return r;
        }
        Set<Integer> [][] f;
        char [] s; int [] a;
        int n, m;
// 【区间型动规：】记忆化深搜。如何划分区间：【用符号】来划分区间. 只要找到一个符号，就把它当数组一个下标一样划分区间
        Set<Integer> dfs(int i, int j) {
            Set<Integer> ans = new HashSet<>();
            if (f[i][j] != null) return f[i][j];
            if (i == j) { // 应该是：一个数字. 【把它当，折分的最小粒度单位】
                ans.add(s[i] - '0');
                return f[i][j] = ans;
            } 
            for (int k = i+1; k < j; k++) // 遍历下标，去找符号，用来划分成左右两个区间
                if (!Character.isDigit(s[k])) {
                    Set<Integer> l = dfs(i, k-1), r = dfs(k+1, j);
                    for (int ll : l) {
                        if (ll > 1000) continue;
                        for (int rr : r) {
                            if (rr > 1000) continue;
                            int v = 0;
                            switch(s[k]) {
                                case '+': v = ll + rr; break;
                                case '*': v = ll * rr; break;
                            }
                            if (v <= 1000)
                                ans.add(v);
                        }
                    }
                }
            return f[i][j] = ans;
        }
        int getCorrectResult() {
            Stack<Integer> si = new Stack<>(); 
            Stack<Character> sc = new Stack<>();
            for (int i = 0; i < n; i++) {
                char c = s[i];
                if (Character.isDigit(c)) {
                    if (!sc.isEmpty() && sc.peek() == '*') { // 计算一步结果: 先算乘法 
                        int v = si.pop() * (c - '0');
                        sc.pop();  // 把乘号，扔出去
                        si.push(v); // 把当前结果，入数字栈
                    } else si.push(c-'0'); // 数字栈
                } else sc.push(c); // 符号栈
            }
            int r = 0; // 当前，只剩下加法来做
            while (!si.isEmpty()) r += si.pop();
            return r;
        }

        // 【主要是长整型溢出之类的细节】：这个题的细节，比我想像得要再多一点儿，TLE LCP 等优化细节。。。 // 数少了: 1977 157/257 晚点儿再强大点儿的时候再写这个
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
                v = v * 10 + (s[k] - '0');
                if (v >= j) r = (r + dfs(k+1, v)) % mod;
            }
            // if (k < n) r = (r + dfs(k, v)) % mod; // 这里不对，不需要
            m.put(key, (int)r);
            return (int)r;
        }

        static final int mod = (int)1e9 + 7;
        public int idealArrays(int n, int m) { // TLE: 记忆化深搜，要再改回动规来写。。。
            this.m = m; this.n = n;
            f = new Integer [n][m+1]; //f[i][j]: 到第 i 个数，最大值用到 j 的数组的数目
            dfs(0, 0);
            System.out.println("f.length: " + f.length);
            for (int z = 0; z < f.length; ++z) 
                System.out.println(Arrays.toString(f[z]));
            return f[0][0];
        }
        Integer [][] f;
        int m, n;
        int dfs(int i, int j) { // i: idx , k: maxVal
            if (i == n) return j <= m ? 1 : 0;
            if (f[i][j] != null) return f[i][j];
            long r = 0;
            for (int k = j + (j == 0 ? 1 : 0); k <= m; k++)
                if (j == 0 || k % j == 0) 
                    r = (r + dfs(i+1, k)) % mod;
            return f[i][j] = (int)r;
        }
        static final int mod = (int)1e9 + 7; // 【动规：】自底向上，对应记忆化深搜的改写. 就照着【记忆化深搜】的写法，自底向上，往回倒着写
        public int idealArrays(int n, int m) { // m: maxVal 写不到动规，写记忆化深搜
            int [][] f = new int [n][m+1]; // f[i][j]: 到第 i 个数，最大值用到 j 的数组的数目
            // 【初始化：】这里初始化得不对。。。
            for (int i = 0; i <= m; i++) f[n-1][i] = 1;
            for (int j = m-1; j >= 0; j--)
                if (j == 0 || m % j == 0) f[n-1][j] += 1;
            for (int i = n-2; i >= 0; i--) // 【自底向上：】是往回倒着写的
                for (int j = 0; j <= m; j++) // j ：仍然是正着往后遍历
                    for (int k = j + (j == 0 ? 1 : 0); k <= m; k++) 
                        if (j == 0 || k % j == 0)
                            f[i][j] = (f[i][j] + f[i+1][k]) % mod;
            System.out.println("f.length: " + f.length);
            for (int z = 0; z < f.length; ++z) 
                System.out.println(Arrays.toString(f[z]));
            return f[0][0];
        }

        public boolean isMatch(String S, String T) {
            m = S.length(); n = T.length();
            s = S.toCharArray(); t = T.toCharArray();
            f = new Boolean [m][n];
            return dfs(0, 0);
        }
        Boolean [][] f;
        char [] s, t;
        int m, n;
// 读不懂题目：【.*】特例：可以匹配【任意片长】，【01234567...】谁读得懂这样的题目，说的是什么意思？活宝妹就是一定要嫁给亲爱的表哥！！！
        boolean dfs(int i, int j) { 
            if (i == m && j == n) return true;
            if (i == m && j != n) { // 处理，另一个片段可能可以缩为 0 的片段
                if ((n - j) % 2 == 1) return false;
                while (j < n-1 && t[j+1] == '*') j += 2;
                return j == n;
            }
            if (j >= n) return false;
            if (f[i][j] != null) return f[i][j]; 
            if (j < n-1 && t[j+1] == '*') {
                if (dfs(i, j+2)) return f[i][j] = true; // 0 个，把这两个字符跳过去
                if (t[j] == '.') { // 【.*】特例：可以匹配任意两个字符【错了，匹配一个也可以！！！】，仍然没有理解对，它是万能的，可以匹配任意长度片段。。。
                    // if (dfs(i, j+2)) return f[i][j] = true; // 0: 上面写了，包括了
                    int k = i+1;
                    while (k <= m) {
                        if (dfs(k, j+2)) return f[i][j] = true; // 如果不是 0, 最短片长是 2, 之后可以是【34567...】
                        k++;
                    }
                    return f[i][j] = false;
                }
                if (s[i] == t[j] || t[j] == '.') { // 在当前字符一样的前提下：看能够重复
                    int k = i;
                    while (k < m && s[k] == s[i]) {
                        if (dfs(k+1, j+2))  return f[i][j] = true;
                        k++;
                    }
                }
                return f[i][j] = false;
            } else if (s[i] == t[j] || t[j] == '.') return f[i][j] = dfs(i+1, j+1);
            else return f[i][j] = false;
        }

        【动规：】思路明明是正确的，就是傻傻数不清楚呀。。。
        // 以后为了这个傻傻数不清楚的原因，也该早点儿改写【动规】为第一解决方案。【爱表哥，爱生活！！！活宝妹就是一定要嫁给亲爱的表哥！！！】
        // 去数划分后，至少一个组的和小于 k 的所有的可能性数目，打算用总数目（2^n）来减它，可是数不对。。。
        static final int mod = (int)1e9 + 7; // TODO TODO TODO: 现在初步尝试，还想不清楚哪里出错了。。。 // TODO TODO TODO: 
        public int countPartitions(int[] a, int k) {
            n = a.length; this.a = a; 
            long sum = 0;
            for (int v : a) sum += v;
            if (sum < 2 * k) return 0;
            // int [] f = new int [k]; // 去数和记：和不超过 k 的所有的可能性【O(10^6)】可能是苛以过的
            // f[0] = 1;
            // for (int i = 0; i < n; i++) { // 遍历每个当前数：把这个数，加与不加
            //     int v = a[i];
            //     for (int j = k-1; j - v >= 0; j--) // 对于每个出现的数值，不管是不是 v 的重复出现，累计更新重复效果。。
            //         if (f[j-v] > 0) f[j] = (f[j] + f[j-v]) % mod;
            //     if (v < k) f[v] = Math.max(f[v], 1); // 更新当前和的可能性：最小为 1
            // }
            Arrays.sort(a);
            f = new Integer [n][k];
            dfs(n-1, k-1); // 记忆化深搜
            // int ans = 0;
            // for (int i = 0; i < k; i++)
            //     if (f[n-1][i] != null) ans = (ans + f[n-1][i]) % mod;
            // return quickPow(2, n) - ans;
            return quickPow(2, n) - dfs(n-1, k-1);
        }
        Integer [][] f;
        int n; int [] a;
        int dfs(int i, int j) { // 搜和 <= j
            if (j < 0) return 0;
            if (i < 0) return 1;
            if (f[i][j] != null) return f[i][j];
            return f[i][j] = (int)(dfs(i-1, j-a[i]) + dfs(i-1, j)) % mod;
        }
        long quickPow(long v, int n) { // 【BUG：】注意，这里长整型 
            long r = 1;
            while (n > 0) {
                if (n % 2 == 1)
                    r = (r * v) % mod;
                v = (v * v) % mod;
                n >>= 1;
            }
            return r;
        }
        static final int mod = (int)1e9 + 7; // 【动规：】试着用动规写一下
        public int countPartitions(int [] a, int k) {
            int n = a.length;
            long sum = Arrays.stream(a).asLongStream().sum(); // 【BUG：】long
            if (k * 2 > sum) return 0;
            int [] f = new int [k];
            f[0] = 1;
            for (int i = 0; i < n; i++) {
                int v = a[i];
                for (int j = k-1; j >= v; j--) 
                    f[j] = (f[j] + f[j-v]) % mod;
            }
            long r = 0;
            for (int v : f) r = (r + v) % mod;
            // return (int)(((int)Math.pow(2, n) % mod - (2 * Arrays.stream(f).asLongStream().sum())) % mod); // 【BUG：】注意这里也有长整型的问题
            return (int)((quickPow(2, n) + mod - (2l * r % mod)) % mod);
        }

        public int minimumWhiteTiles(String t, int m, int k) { // 【记忆化深搜】：数据规模小，可能也能搜得过。。
            n = t.length(); s = t.toCharArray(); this.k = k; 
            r = new int [n+1];
            for (int i = 0; i < n; i++) r[i+1] = r[i] + s[i] - '0';
            f = new Integer [n][m+1];
            Arrays.stream(f).forEach(z -> Arrays.fill(z, Integer.MAX_VALUE / 2));
            return dfs(0, m);
        }
        Integer [][] f;
        char [] s;
        int n, k; int [] r;
        int dfs(int i, int j) {
            if (i >= n) return j >= 0 ? 0 : Integer.MAX_VALUE / 2;
            if (j == 0) return f[i][j] = r[n] - r[i]; // 可有东西可以盖：剩余 1 的和
            if (f[i][j] != Integer.MAX_VALUE / 2) return f[i][j];
            int ans = Integer.MAX_VALUE / 2;
            // 分：从当前下标，盖，与不盖，这个毯子的最小值
            return f[i][j] = Math.min(dfs(i+k, j-1), s[i] - '0' + dfs(i+1, j));
        }
        public int minimumWhiteTiles(String t, int m, int k) { // 【动规：】学习和适应写动规。。。// TODO TODO TODO: 
            int n = t.length(); char [] s = t.toCharArray();
            int [] r = new int [n+1];
            for (int i = 0; i < n; i++) r[i+1] = r[i] + (s[i] - '0'); // 将动规数组，求最小值，效果是一样的
            int [][] f = new int [n][k+1];
            Arrays.stream(f).forEach(z -> Arrays.fill(z, Integer.MAX_VALUE / 2));
            // 【初始化：】什么也不盖，就是片段和
            for (int i = 0; i < n; i++) f[i][0] = r[i+1];
            for (int i = n-1; i >= 0; i--) { // 遍历当前下标：【自底向上】的动规
                for (int j = 1; j <= k; j++) { // 遍历可用的毯子
                }
            }
            return 0;
        }

        // 这个题：读不懂题目，读不懂提示，看下别人的提示，应该还是可以自己写出来的。和我昨天参考过的树题，还是狠像。。。
        public long maxOutput(int n, int[][] egs, int[] a) { // 【动规：】按昨天的理解思路来写，这里跟昨天类似，但仍然要自己再分析一下，改天接着写 2538
            this.n = n; this.a = a; 
            g = new ArrayList [n]; // 【树：】树是固定不变的，变的只是【动规优化】过程中的根节点，以及最大路径和时两端点的关系 P[UV]-P[VU]-[UPV-VPU]
            Arrays.setAll(g, z -> new ArrayList<>());
            for (int [] e : egs) {
                int u = e[0], v = e[1];
                g[u].add(v);
                g[v].add(u);
            }
            f = new long [n][2]; // 和昨天的题不同：每节点的重量变化了，就是子树的节点个数没有关系了【因为每个节点重量不一，数了节点数也没用。。。】
// 【以0 为根节点】：自底向上 DFS, 解决一个 base case
            dfs(0, -1);
            ans = f[0][1] - a[0]; // 以 0 为根节点，最重最轻路径差值
            System.out.println("ans: " + ans);
            // 【动规：】考虑所有节点为根节点，搜索全局最优解；【分三种情况优化】优化：并不真的需要每个节点作根重算一遍，
            // 第一第二种简单情况：【u 是 v 的父节点，或是， v 是 u 的父节点】：【】
            dfsSec(0, -1); // 这里跟昨天类似，但仍然要自己再分析一下，改天接着写
            // 复杂情况：【 u-v 都有其它共同或是不同的父节点】这种大概是说：不过根节点？？
            return ans;
        }
        List<Integer> [] g;
        long [][] f;
        int n; int [] a;
        long ans = 0;
        void dfsSec(int u, int p) { // 根昨天上午的换根节点，算路径和题是一样的【感觉还是不一定对？每节点重量变了。。】，计算遍历 u 与 v 动态更换根节点
            ans = Math.max(ans, f[u][1] - a[u]); // 【动规：】动态计算【UV 某个为根节点时】全局最优解
            // System.out.println("\n u: " + u);
            // System.out.println("f[u][1]: " + f[u][1]);
            // System.out.println("ans: " + ans);
            for (int v : g[u]) {
                if (v == p) continue;
                long preU = f[u][1], preV = f[v][1];
                f[u][1] -= f[v][1];
                f[v][1] += f[u][1];
                dfsSec(v, u);
                f[u][1] = preU; // 还原：方便原树根节点 U 再与其它子树节点，更换根节点
                f[v][1] = preV;
            }
        }
        void dfs(int u, int p) { // 【自底向上】的 DFS
            f[u][1] = a[u]; // 当前节点的重量: 还没有加任何子树路径重量和
            for (int v : g[u]) {
                if (v == p) continue;
                dfs(v, u); // 【自底向上】：先把叶子、子树等，子问题解决了
                f[u][1] = Math.max(f[u][1], f[v][1] + a[u]); 
            }
        }

        // public int minCost(int t, int [][] egs, int[] a) { // 【动规：】
        //     // 我可能还是需要一个图：带时间的图
        //     List<Integer> [][] g = new ArrayList [N][t+1];
        //     for (int i = 0; i < N; i++) 
        //         Arrays.setAll(g[i], z -> new ArrayList<>());
        //     int N = 1001;
        //     int [][] f = new int [N][t+1];
        // }
        // 没有读懂题目的提示：是什么意思，为什么传统的方法不可以？【每个节点有重量】可以在时间允许范围内，以时间换金钱，走远路多花点儿时间，少花点儿钱，但仍能到达。。。
        public int minCost(int t, int [][] egs, int[] a) {
            n = egs.length; g = new ArrayList [n]; this.a = a; this.t = t; 
            Arrays.setAll(g, z -> new ArrayList<>());
            n = 0;
            for (int [] e : egs) {
                int u = e[0], v = e[1], w = e[2];
                g[u].add(new int [] {v, w});
                g[v].add(new int [] {u, w});
                n = Math.max(n, Math.max(u, v));
            }
            ++n;
            // 【记忆化深搜：】这是我比较习惯的写法。。。
            f = new Integer [n][t+1];
            Arrays.stream(f).forEach(z -> Arrays.fill(z, Integer.MAX_VALUE / 2));
            int v = dfs(0, t);
            if (v == Integer.MAX_VALUE / 2) return -1;
            return a[0] + v; // 【暴搜：】t 这个时间内，可到达终点 n-1 的最便宜路径
        }
        int dfs(int i, int j) { // 不知道哪里没有写对，下午再改。。。
            System.out.println("\n i: " + i);
            System.out.println("j: " + j);
            if (j < 0) return Integer.MAX_VALUE / 2;
            if (i == n-1) return a[i];
            if (f[i][j] != Integer.MAX_VALUE / 2) return f[i][j];
            int ans = Integer.MAX_VALUE / 2;
            for (int [] e : g[i]) {
                // if (j + e[1] > t) continue; // 时间不够用，不可到达终点
                if (e[1] > j) continue;
                ans = Math.min(ans, a[e[0]] + dfs(e[0], j - e[1]));
            }
            System.out.println("\n i: " + i);
            System.out.println("j: " + j);
            System.out.println("ans: " + ans);
            return f[i][j] = ans;
        }
        List<int []> [] g;
        Integer [][] f;
        int n, t;
        int [] d, a;
        void calculateShortestDist(int uu) {
            d[uu] = 0;
            Queue<int []> q = new PriorityQueue<>((x, y) -> x[1] - y[1]);
            q.offer(new int [] {uu, 0});
            while (!q.isEmpty()) {
                int [] cur = q.poll();
                int u = cur[0], t = cur[1];
                for (int [] v : g[u])
                    if (t + v[1] < d[v[0]]) {
                        d[v[0]] = t + v[1];
                        q.offer(new int [] {v[0], d[v[0]]});
                    }
            }
        }

        public int numberOfArithmeticSlices(int[] a) {
            int n = a.length, i = 1, j = 0, r = 0, d = a[1] - a[0];
            if (n < 3) return 0;
            while (i < n) {
                while (i < n-1 && a[i+1] - a[i] == d) i++;
                r++; // 数得不对。。。413
                ++i;
                if (i == n) return r;
                d = a[i] - a[i-1];
            }
            return r;
        }

        public int minScoreTriangulation(int[] a) { // 鬼知道这个提示会误导人。。。
            this.a = a; n = a.length;
            f = new Integer [n][n];
            return dfs(0, n-1);
        }
        Integer [][] f;
        int [] a;
        int n;
        int dfs(int i, int j) {
            if (i + 2 > j) return 0;
            if (i + 2 == j) return f[i][j] = a[i] * a[i+1] * a[j];
            if (f[i][j] != null) return f[i][j];
            int r = Integer.MAX_VALUE;
            for (int k = i+1; k < j; k++) {
                r = Math.min(r, a[i] * a[k] * a[j] + dfs(i, k) + dfs(k, j));
            }
            return f[i][j] = r;
        }

        // 看到【N=[1,30]】就先想把数组折成两半：建左右两个链表；对左右所有的可能性，再左右配对暴搜最小值 
        public int lastStoneWeightII(int[] a) {
            int n = a.length, m = n / 2;
            TreeSet<Integer> l = new TreeSet<>(), r = new TreeSet<>();
            for (int i = 0; i < (1 << m); i++) {
                int cur = 0;
                for (int j = 0; j < m; j++) // 设置：当位上是 1, 加，是0 减
                    if ((i & (1 << j)) > 0) cur += a[j];
                    else cur -= a[j];
                l.add(cur);
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < (1 << (n- m)); i++) {
                int cur = 0;
                for (int j = 0; j < (n-m); j++) 
                    if ((i & (1 << j)) > 0) cur += a[m + j];
                    else cur -= a[m+j];
                Integer hi = l.floor(cur), lo = l.ceiling(cur);
                if (hi != null) min = Math.min(min, Math.abs(cur - hi));
                if (lo != null) min = Math.min(min, Math.abs(cur - lo));
            }
            return min;
        }

        public int numSquares(int n) {
            int [] f = new int [n+1];
            Arrays.fill(f, Integer.MAX_VALUE);
            f[0] = 0;
            f[1] = 1;
            for (int i = 2; i <= n; i++) 
                for (int j = 1; j * j <= i; j++) 
                    f[i] = Math.min(f[i], 1 + f[i - j * j]);
            return f[n];
        }

        // 当因为重复数字，回塑会超时，或是记忆化深搜失效的时候，就得去写动规。。。 377
        public int combinationSum4(int[] a, int t) { // 【动规：】因为顺序相关，重复数字. 没处理的因素：【数字可以被重复使用。。。】
            int n = a.length;
            int [] f = new int [t+1];
            for (int v : a) f[v]++; // 添加数组里重复元素的重复效应
            f[0] = 1; // 初始化：这个可能初始化得不够？
            for (int i = 0; i < n; i++) {
                int v = a[i];
                // f[v] = Math.max(f[v], 1); // 这里的问题是：数组里的重复元素，重复效应，被消除了。。。
                for (int j = t; j >= v; j--)
                    f[j] += f[j-v];
            }
            System.out.println(Arrays.toString(f));
            return f[t];
        }

        public int maxSumDivThree(int[] a) { // 【动规：】自顶向下，不是说是石头啃不动吗？不是还是瓣出来了？
            int n = a.length;
            int [][] f = new int [n][3];
            f[0][a[0] % 3] = a[0];
            for (int i = 1; i < n; i++) {
                int j = a[i] % 3;
// 根据前一位的结果，更新当前的
                for (int k = 0; k < 3; k++) {  // 这里更新不全
                    if (f[i-1][k] != 0) // 这里，想用当前下标更新，但不能覆盖，先前忆有的较优解序列  
                        f[i][(k+j)%3] = Math.max(f[i][(k+j)%3], Math.max(f[i-1][k] + a[i], f[i-1][(k+j)%3]));
                }
                for (int k = 0; k < 3; k++)
                    if (f[i][k] == 0) f[i][k] = f[i-1][k];
                f[i][j] = Math.max(f[i][j], a[i]); // 如果之前还不存在这个余数的话
            }
            return f[n-1][0];
        }

        public int minHeightShelves(int[][] a, int k) { // 【动规：】应该是最好的办法
            n = a.length; this.k = k; 
            f = new Integer [n];
            return dfs(0);
        }
        Integer [] f; // 数据规模，相对大，不可以回塑，只能先试【记忆化深搜】
        int n, k;
        int dfs(int i) {
            if (i == n) return 0;
            if (f[i] != null) return f[i];
            int r = Integer.MAX_VALUE;
        }        
        public int minHeightShelves(int[][] a, int k) { // 【动规：】这里难理解和实现的是：怎么分层 1105
            int n = a.length; 
            int [][] f = new int [n][n];
            Arrays.stream(f).forEach(z -> Arrays.fill(z, Integer.MAX_VALUE / 2));
            f[0][0] = 0;
            for (int i = 0; i < n; i++) { // 遍历这些书：顺序不能打乱
                for (int j = 0; j < n; j++) {
                }
            }
        }

        public int integerBreak(int n) { // 这种题，就是这么瓣的吗？瓣得手指头痛。。。
            if (n == 2) return 1;
            if (n == 3) return 2;
            if (n == 4) return 4;
            int [] f = new int [n+1];
            f[1] = 1;
            f[2] = 1;
            f[3] = 2;
            f[4] = 4;
            for (int i = 5; i <= n; i++) {
                for (int j = i / 2 + 1; j >= 1; j--) 
                    f[i] = Math.max(f[i], Math.max(j * (i - j), f[j] * f[i - j]));
                if (i % 3 == 0)
                    f[i] = Math.max(f[i], (i / 3) * (i / 3) * (i / 3));
                else 
                    f[i] = Math.max(f[i], (i / 3) * (i / 3 + 1) * (i / 3 + (i % 3 - 1)));
            }
            return f[n];
        }

        public int videoStitching(int[][] a, int t) {
            int n = a.length;
            Arrays.sort(a, (x, y) -> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
            int [][] f = new int [n][t+1];
            Arrays.stream(f).forEach(z -> Arrays.fill(z, Integer.MAX_VALUE / 2));
            if (a[0][0] > 0 || a[n-1][1] < t) return -1; // 两端：够不着. 任何时候，活宝妹就是一定要嫁给亲爱的表哥！！！
            f[0][0] = 1;
            for (int i = 0; i < n; i++) {
                int [] r = a[i];
                if (f[i-1][r[0]] == Integer.MAX_VALUE / 2) return -1;
                for (int j = r[0]; j <= r[1]; j++) { // 这里还是不知道，怎么更新。。。
                    f[i][j] 
                }
            }
        }

        static final int mod = (int)1e9 + 7;
        public int numFactoredBinaryTrees(int[] a) {
            int n = a.length;
            Arrays.sort(a); // 既然这样：排序就可以帮忙！！！
            Map<Integer, Integer> m = new HashMap<>();
            for (int i = 0; i < n; i++) m.put(a[i], i);
            long [] f =  new long [n];
            Arrays.fill(f, 1l);
            for (int i = 0; i < n; i++) 
                for (int j = 0; j < i; j++) 
                    if (a[i] % a[j] == 0 && m.containsKey(a[i] / a[j]))
                        f[i] = (f[i] + f[j] * f[m.get(a[i] / a[j])]) % mod;
            long ans = 0;
            for (long v : f) ans = (ans + v) % mod;
            return (int)ans;
            // long r = 1;
            // Map<Integer, Long> m = new HashMap<>(); // 用来记：以某个元素作根节点的树的个数
            // m.put(a[0], 1l);
            // // 主要考虑：当非叶子节点，必须是叶子节点的乘积
            // for (int i = 1; i < n; i++) {
            //     long cur = 1;
            //     for (int j = i-1; j >= 0; j--) {
            //         if (a[i] % a[j] == 0 && m.containsKey(a[i] / a[j])) { // 考虑： a[i] 作为非叶子节点的树
            //             if (a[i] / a[j] == a[j])
            //                 // cur = (cur + m.get(a[j])) % mod; // 【BUG：】为什么这么简单的错。。。
            //                 cur = (cur + m.get(a[j]) * m.get(a[j])) % mod;
            //             else
            //                 cur = (cur + m.get(a[j]) * m.get(a[i] / a[j])) % mod; // 左右子树，可是调换一下左右位置 
            //         }
            //     }
            //     m.put(a[i], cur);
            //     r = (r + cur) % mod;
            // }
            // return (int)r;
        }

        public int nthUglyNumber(int n) { // 2, 3, 5
            List<Integer> [] g = new ArrayList[3];
            Arrays.setAll(g, z -> new ArrayList<>());
            for (int i = 1; i <= n; i++) {
                g[0].add(2 * i);
                g[1].add(3 * i);
                g[2].add(5 * i);
            }
            // Integer [] id = IntStream.range(0, 3).boxed().toArray(Integer[]::new);
            // Arrays.sort(id, (x, y)-> g[x].get(0) - g[y].get(0));
            // Queue<List<Integer> []> q = new PriorityQueue<>((x, y) -> x.get(0) - y.get(0));
            // q.offer(g);
            int [] r = new int [] {0, 0, 0}; // 忘记这里是怎么写的了。。。
            Queue<Integer> q = new PriorityQueue<>((x, y)->g[x].get(0));
        }

        Node root = new Node();
        public boolean wordBreak(String t, List<String> wordDict) { // TLE TLE TLE: 
            int n = t.length();
            boolean [] f = new boolean [n];
            for (String s : wordDict) insert(s);
            int i = n-1;
            List<Integer> l = startsWith(t);
            for (int v : l) {
                f[v] = true;
                if (v == 0) return true;
            }
            for (int v : l) 
                if (wordBreak(t.substring(0, v), wordDict)) return true;
            return false;
        }
        List<Integer> startsWith(String t) {
            int n = t.length(); char [] s = t.toCharArray();
            Node r = root;
            List<Integer> l = new ArrayList<>();
            for (int i = n-1; i >= 0; i--) {
                int j = s[i] - 'a';
                if (r.n[j] == null) return l;
                if (r.n[j].w) l.add(i);
                r = r.n[j];
            }
            return l;
        }
        void insert(String t) { // 倒序插入
            int n = t.length();
            char [] s = t.toCharArray();
            Node r = root;
            for (int i = n-1; i >= 0; i--) {
                int j = s[i] - 'a';
                if (r.n[j] == null) r.n[j] = new Node();
                r = r.n[j];
            }
            r.w = true;
        }
        class Node {
            boolean w = false;
            Node [] n;
            public Node() {
                n = new Node[26];
            }
        }

        public int numberOfSets(int n, int k) { // TODO TODO TODO: 
            f = new Integer [n][k+1]; this.n = n; 
            return dfs(0, k);
        }
        Integer [][] f;
        int n;
        static final int mod = (int)1e9 + 7;
        int dfs(int i, int j) {
            if (i == n || j < 0 || i > n-(j+1)) return 0;
            if (j == 0 && i < n) return 1;
            if (f[i][j] != null) return f[i][j];
            long r = 0;
            for (int k = i+1; k < n - (j-2); k++) {
                r = (r + dfs(k, j-1)) % mod;
                r = (r + dfs(k, j)) % mod;
            }
            return f[i][j] = (int)r;
        }

        public int coinChange(int[] a, int t) { // 【动规：】仍然是不太会写。。。
            if (t == 0) return 0;
            Arrays.sort(a);
            int n = a.length;
            if (t < a[0]) return -1;
            int [] f = new int [t+1];
            Arrays.fill(f, Integer.MAX_VALUE / 2);
            for (int v : a) if (v <= t) f[v] = 1;
            f[0] = 0;
            System.out.println(Arrays.toString(f));
            for (int i = n-1; i >= 0; i--) { // 只是从大到小，来遍历硬币
                int v = a[i];
                if (v > t) continue;
                // f[v] = 1;
                for (int j = t; j >= v; j--) 
                    // f[j] = Math.min(f[j], f[j-v] + 1);
                    f[j] = Math.min(f[j], f[j % v] + j /v); // 重复使用
            }
            System.out.println(Arrays.toString(f));
            return f[t] >= Integer.MAX_VALUE / 2 ? -1 : f[t];
        }
        public int coinChange(int[] a, int t) { // TLE TLE TLE: 
            if (t == 0) return 0;
            Arrays.sort(a);
            n = a.length; this.a = a;
            if (n == 1) return t % a[0] == 0 ? t / a[0] : -1;
            if (t < a[0]) return -1;
            f = new Integer [n][t+1];
            Arrays.stream(f).forEach(z -> Arrays.fill(z, Integer.MAX_VALUE / 2));
            return dfs(n-1, t);
        }
        Integer [][] f;
        int n; int [] a;
        int dfs(int i, int j) {
            if (i < 0) return j == 0 ? 0 : Integer.MAX_VALUE / 2; 
            if (j < 0) return Integer.MAX_VALUE / 2;
            if (f[i][j] != Integer.MAX_VALUE / 2) return f[i][j];
            int ans = Integer.MAX_VALUE / 2, cnt = j / a[i];
            for (int x = cnt; x >= 0; x--) 
                ans = Math.min(ans, x + dfs(i-1, j - x * a[i]));
            //ans = Math.min(ans, dfs(i-1, j));
            return f[i][j] = ans;
        }

        static final int mod = (int)1e9 + 7;
        public int countHousePlacements(int n) {
            int [] f = new int [n+1];
            f[0] = 1; // 空着，不放，也是一种方案
            f[1] = 2; // 放，与不放，2 种
            for (int i = 2; i <= n; i++)
                f[i] = (f[i-1] + f[i-2]) % mod;
            return (int)(mod + (long)f[n] * (long)f[n] % mod) % mod;
        }

        static final int mod = (int)1e9 + 7;
        public int sumSubarrayMins(int[] a) {
            int n = a.length;
            int [] l = new int [n], r = new int [n];
            Arrays.fill(l, -1); Arrays.fill(r, n);
            Deque<Integer> s = new ArrayDeque<>();
            // 【从左往右遍历】：维护单调递增栈
            for (int i = 0; i < n; i++) {
                while (!s.isEmpty() && a[s.peekFirst()] >= a[i]) s.pollFirst();
                if (!s.isEmpty()) l[i] = s.peekFirst();
                s.offerFirst(i);
            }
            s.clear();
            // 【从右往左遍历】：单调递增
            for (int i = n-1; i >= 0; i--) {
               while (!s.isEmpty() && a[s.peekFirst()] > a[i]) s.pollFirst();
                if (!s.isEmpty()) r[i] = s.peekFirst();
                s.offerFirst(i);
            }
            long ans = 0;
            for (int i = 0; i < n; i++) 
                ans = (ans + (long)a[i] * (i - l[i]) * (r[i] - i)) % mod;
            return (int)ans;
        }

        static final int mod = (int)1e9 + 7;
        public int profitableSchemes(int n, int t, int[] g, int[] p) { // 【记忆化深搜：】数据规模狠小，我可以暴搜之。。。// TLE TLE TLE: 就搞不懂，为什么它就会超时？
            m = g.length; this.n = n; this.g = g; this.p = p; this.t = t; 
            return dfs(n, 0, 0);
        }
        Map<String, Integer> f = new HashMap<>();
        int [] g, p;
        int n, m, t;
        int dfs(int i, int j, int k) {
            if (i <= 0 || j == m) return k < t ? 0 : 1; // 没窃贼可用了
            // if (k >= t) return 1; // 这样不对，没有遍历到尾巴，计数可能远不止 1 种，好多种。。。
            String key = i + "-" + j + "-" + k;
            if (f.containsKey(key)) return f.get(key);
            long ans = dfs(i, j+1, k); // 放弃，第 j 个案件，不作此案
            if (i >= g[j]) // 作案前提：此案参案人数得足够
                ans = (ans + dfs(i - g[j], j+1, k + p[j])) % mod; // 第 j 件案：参与了
            f.put(key, (int)ans);
            return (int)ans;
        }
        static final int mod = (int)1e9 + 7; // TODO TODO TODO: 用动规，仍然不熟悉，瓣不出来。。。
        public int profitableSchemes(int n, int t, int[] g, int[] p) { // 【动规：】应该就是个最基本的动规题型，可是为什么会没有思路呢？
            int m = g.length;
            int [][][] f = new int [m][n][t+1]; // 【自顶向下：】所有的参数用最压缩的空间，应该不会暴栈。。。
            f[0][0][0] = 1;
            for (int i = 0; i < m; i++) // 遍历案件
                for (int j = 0; j + g[i] < n; j++) // 遍历可用人选方案：这里遍历的是所有的人，还在这些人可用吗？
                    for (int k = 0; k + p[i] <= t; k++) // 这里糊涂：统计少了吗？
                        f[i][j+g[i]][k+p[i]] = (f[i][j+g[i]][k+p[i]] + f[i][j][k]) % mod;
            return f[m-1][n-1][t];
        }

                // 【暴搜：】这个题的数据规模小，可以先试着暴搜一下, 特殊情况下的优化。。。最后两三个特例不过。。。
        public int numSquarefulPerms(int[] a) {
            n = a.length; this.a = a;
            if (Arrays.stream(a).distinct().count() == 1) return isSquare(a[0] + a[1]) ? 1 : 0;
            backTracking(0, new ArrayList<Integer>(), new boolean [n]);
            return ll.size();
        }
        List<List<Integer>> ll = new ArrayList<>();
        int [] a;
        int n;
        void backTracking(int u, List<Integer> l, boolean [] v) {
            if (l.size() >= 2) 
                if (!check(l)) return ;
            if (u == n) { // 前面已经确认：链表满足要求
                if (l.size() == n) {
                    if (!ll.contains(l)) 
                        ll.add(new ArrayList<>(l));
                }
                return ;
            }
            for (int i = 0; i < n; i++) 
                if (!v[i]) {
                    v[i] = true;
                    l.add(a[i]);
                    backTracking(u+1, l, v);
                    l.remove(l.size()-1);
                    v[i] = false;
                }
        }
        boolean check(List<Integer> l) {
            int r = l.get(l.size()-1) + l.get(l.size()-2);
            return isSquare(r);
        }
        boolean isSquare(int v) {
            int sr = (int)Math.sqrt(v);
            return sr * sr == v;
        }
        感觉自己写得好原始：完全没有想要，要把它转化成图来写。。。
        【转化为图】来解决的题目：感觉像是今天上午的树形DP, 思路新颖奇特，值得好好学习一下，明天上午再看这题 996 热爱学习喜欢挑战的活宝妹喜欢996! 要不然不996 不努力学习也没什么意思。【爱表哥，爱生活！！！活宝妹就是一定要嫁给亲爱的表哥！！！】
        Map<Integer, Integer> cnt = new HashMap<>(); // 早上要再理解消化一下
        Map<Integer, List<Integer>> g = new HashMap<>();
        public int numSquarefulPerms(int[] a) {
            int n = a.length;
            // count.get(v) : 数组 A 中值为 v 的节点数量
            for (int v : a)
                cnt.put(v, cnt.getOrDefault(v, 0) + 1);
            // graph.get(v) : 在 A 中的值 w 满足 v + w 是完全平方数
            //                (ie., "vw" is an edge)
            for (int v : cnt.keySet()) g.put(x, new ArrayList<>());
            for (int x : cnt.keySet())
                for (int y: cnt.keySet()) {
                    int r = (int)(Math.sqrt(x + y) + 0.5); // 这里 +0.5: 应该是【四舍五入】的意思
                    if (r * r == x + y)
                        g.get(x).add(y);
                }
            // 增加从 x 开始的可行路径数量
            int ans = 0;
            for (int v : cnt.keySet()) 
                ans += dfs(v, n-1);
            return ans;
        }
        int dfs(int x, int todo) { // DFS 深搜 : 从 x 出发，再经过 todo 个节点的路径数
            cnt.put(x, cnt.get(x) - 1);
            int ans = 1;
            if (todo != 0) {
                ans = 0;
                for (int y : g.get(x))
                    if (cnt.get(y) != 0) 
                        ans += dfs(y, todo-1);
            }
            cnt.put(x, cnt.get(x) + 1); // 这里与【回塑】的写法一样，再改回来
            return ans;
        }
        public int numSquarefulPerms(int[] a) {
            n = a.length;
            // 【构建图】
            g = new ArrayList [n];
            Arrays.setAll(g, z -> new ArrayList<>());
            for (int i = 0; i < n; i++)
                for (int j = i+1; j < n; j++) {
                    int r = (int)(Math.sqrt(a[i] + a[j]) + 0.5);
                    if (r * r == a[i] + a[j]) {
                        g[i].add(j);
                        g[j].add(i);
                    }
                }
            // 【记忆化深搜】求解：只是用掩码来标记状态
            int [] factorial = new int [20]; // 消除重复数字的影响？
            factorial[0] = 1;
            for (int i = 1; i < 20; i++)
                factorial[i] = i * factorial[i-1];
            f = new Integer [n][1 << n];
            int ans = 0;
            for (int i = 0; i < n; i++)
                ans += dfs(i, 1 << i);
            for (int v : a) m.put(v, m.getOrDefault(v, 0) + 1);
            for (int val : m.values()) 
                ans /= factorial[val];
            return ans;
        }
        Map<Integer, Integer> m = new HashMap<>(); 
        List<Integer> [] g;
        Integer [][] f; // 【记忆化深搜】
        int n;
        int dfs(int i, int j) {
            if (j == (1 << n) - 1) return f[i][j] = 1; // 能搜到这个状态，终点就一定对
            if (f[i][j] != null) return f[i][j];
            int r = 0;
            for (int v : g[i])
                if ((j & (1 << v)) == 0) 
                    r += dfs(v, j | (1 << v));
            return f[i][j] = r;
        }
    }
    public static void main (String[] args) { // 【爱表哥，爱生活！！！活宝妹就是一定要嫁给亲爱的表哥！！！】
        Solution s  =  new Solution ();

        int [] a = new int [] {1,17,8};

        int r = s.numSquarefulPerms(a);
        System.out.println("r: " + r);
    } 
}
// ListNode head = new ListNode(a[0]); 
// head.buildList(head, a);  
// head.printList(head);
// TreeNode rr = new TreeNode(a[0]);
// rr.buildTree(rr, a);
// rr.levelPrintTree(rr);








