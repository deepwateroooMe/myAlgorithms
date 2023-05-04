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
        // 感觉自己写得好原始：完全没有想要，要把它转化成图来写。。。
        // 【转化为图】来解决的题目：感觉像是今天上午的树形DP, 思路新颖奇特，值得好好学习一下，明天上午再看这题 996 热爱学习喜欢挑战的活宝妹喜欢996! 要不然不996 不努力学习也没什么意思。【爱表哥，爱生活！！！活宝妹就是一定要嫁给亲爱的表哥！！！】     
        Map<Integer, Integer> count;
        Map<Integer, List<Integer>> graph;
        public int numSquarefulPerms(int[] A) {
            int N = A.length;
            count = new HashMap();
            graph = new HashMap();
            // count.get(v) : 数组 A 中值为 v 的节点数量
            for (int x: A)
                count.put(x, count.getOrDefault(x, 0) + 1);
            // graph.get(v) : 在 A 中的值 w 满足 v + w 是完全平方数
            //                (ie., "vw" is an edge)
            for (int x: count.keySet())
                graph.put(x, new ArrayList());
            for (int x: count.keySet())
                for (int y: count.keySet()) {
                    int r = (int) (Math.sqrt(x + y) + 0.5);
                    if (r * r == x + y)
                        graph.get(x).add(y);
                }
            // 增加从 x 开始的可行路径数量
            int ans = 0;
            for (int x: count.keySet())
                ans += dfs(x, N - 1);
            return ans;
        }
        public int dfs(int x, int todo) {
            count.put(x, count.get(x) - 1);
            int ans = 1;  
            if (todo != 0) {
                ans = 0;
                for (int y: graph.get(x)) if (count.get(y) != 0) {
                        ans += dfs(y, todo - 1);
                    }
            }
            count.put(x, count.get(x) + 1);
            return ans;
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
    }
    public static void main (String[] args) { // 【爱表哥，爱生活！！！活宝妹就是一定要嫁给亲爱的表哥！！！】
        Solution s  =  new Solution ();

        String a = "3+5*2";
        int [] b = new int [] {13, 0, 10, 13, 13, 16, 16};

        int r = s.scoreOfStudents(a, b);
        System.out.println("r: " + r);
    } 
}
// ListNode head = new ListNode(a[0]); 
// head.buildList(head, a);  
// head.printList(head);
// TreeNode rr = new TreeNode(a[0]);
// rr.buildTree(rr, a);
// rr.levelPrintTree(rr);














