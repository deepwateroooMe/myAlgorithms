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

public class dpfour {
    public static class Solution {

        // 【内存溢出：】Memory Limit Exceeded 71/83 这里的意思就是说， max 取值过大，而实际存在的元素少，就成了为一个数据的离散化处理
        // 线段树数据【离散化处理】：意思是说，分布过散的数据，重样集中集合到【0,n-1】下标，不取实际的值了，而用相对集中的下标代替 // TODO TODO TODO: 这里还有点儿没想透彻。。。
        public int lengthOfLIS(int[] a, int k) {  // 动规：＋线段树来找前 f【i】【v-k】范围内的最大值【这个题仍然成了学习题】
            int n = a.length, m = Arrays.stream(a).max().getAsInt()+1, ans = 1;
            System.out.println("m: " + m); // 当 m 取到 100001 的时候，就会内存溢出，感觉卡到边界了，也只是稍微的内存占用增大一点儿而已
            t = new int [4 * m]; // 不是说，线段树？下标是从 1 开始的吗？最大值 m 元素在哪里 
            int [][] f = new int [n][m]; // 第二维表达的是以当前数 a[i] 为结尾的最长合法子序列长度，所以取最值
            for (int i = 0; i < n; i++) { // 注意【0】下标更新线段树。。。
                int v = a[i];
                f[i][v] = 1;
                // 这里要找：前所有 i 个数【0,i-1】中，以【v-k,v-1】结尾的最大值，最大长度，
// 这里我是在想要遍历，总复杂度为【O(N^2)】，线段树可以做到【O(NlogN)】线段树中的第一维就给消除掉，只累加更新【0,maxVal+1】范围内的最大值
                // for (int j = Math.max(0, v - k); j < v; j++) // 因为线段树区间求最大值：这里就不用遍历，一次【 O(logN)】查询就可以了
                    // f[i][v] = Math.max(f[i][v], f[i-1][j] + 1); // 【分不清：哪个 i?】
                f[i][v] = Math.max(f[i][v], getMax(0, 0, m-1, v-k, v-1, t) + 1); // 查询线段树【v-k,v-1】区间最大值：下标1 开始，左闭右闭区间
                // f[i][v] = Math.max(f[i][v], getMax(0, 0, n-1, v-k, v-1, t) + 1); // 查询线段树【v-k,v-1】区间最大值：下标1 开始，左闭右闭区间
                update(0, 0, m-1, v, f[i][v], t); // 更新线段树单点元素： v 下标值为 f[i][v]
                // update(0, 0, n-1, i, f[i][v], t); // 更新线段树单点元素： v 下标值为 f[i][v]
                // ans = Math.max(ans, f[i][v]);
            }
            System.out.println(Arrays.toString(t));
            return t[0];
        }
        int [] t;
        void update(int u, int l, int r, int idx, int v, int [] t) { // 我这里参考别人的奇葩写法，写得自己稀里糊涂的。。。重写一遍
            if (l == r) {
                t[u] = v;
                return ;
            }
            int m = l + (r - l) / 2;
            if (idx <= m) update(u << 1 | 1, l, m, idx, v, t);
            else update((u << 1) + 2, m+1, r, idx, v, t);
            t[u] = Math.max(t[u << 1 | 1], t[(u << 1) + 2]); // 最大值线段树：根节点最大值，取左右子节点最大值 
        }
        int getMax(int u, int l, int r, int L, int R, int [] t) { // 【 l,r】：现存线段树的有效区间跨度；【L,R】：查询区间跨度
            if (R < l || r < L) return 0;
            if (L <= l && r <= R) return t[u];
            int m = l + (r - l) / 2;
            int ll = getMax(u << 1 | 1, l, m, L, R, t);
            int rr = getMax((u << 1) + 2, m+1, r, L, R, t);
            return Math.max(ll, rr);
        }
        public int lengthOfLIS(int[] a, int k) {  // 动规：＋线段树来找前 f【i】【v-k】范围内的最大值【这个题仍然成了学习题】
            int n = a.length, m = Arrays.stream(a).max().getAsInt();
            t = new int [4 * m]; // 线段树？下标是从 1 开始的吗？
            for (int v : a) {
                System.out.println("\n v: " + v);
                if (v == 1) update(1, 1, m, 1, 1);
                else {
                    int res = 1 + query(1, 1, m, Math.max(1, v-k), v-1);
                    System.out.println("res: " + res);
                    update(1, 1, m, v, res);
               }
                System.out.println(Arrays.toString(t));
            }
            System.out.println(Arrays.toString(t));
            return t[1];
        }
        int [] t; // 线段树：最大值线段树，下标从1 开始的标准写法
        void update(int u, int l, int r, int i, int v) { // 更新下标为 i 元素的值为 v, 从 u 节点开始遍历
            if (l == r) {
                t[u] = v;
                return ;
            }
            int m = l + (r - l) / 2;
            if (i <= m) update(u << 1, l, m, i, v);
            else update(u << 1 | 1, m+1, r, i, v); // 【左右节点的下标：】 U 《 1 | 1 
            t[u] = Math.max(t[u << 1], t[u << 1 | 1]); // 根节点最大值：取左右节点的最大值 
        }
// 查询【L,R】范围内的最大值，线段树的跨越区间为【l,r】. L 和 R 在整个递归过程中均不变，将其大写，视作常量
        int query(int u, int l, int r, int L, int R) { // 返回区间 [L,R] 内的最大值
            if (L <= l && r <= R) return t[u];
            int m = l + (r - l) / 2, leftMax = 0, rightMax = 0;
            if (L <= m) leftMax = query(u << 1, l, m, L, R);
            if (m+1 <= R) rightMax = query(u << 1 | 1, m+1, r, L, R);
            return Math.max(leftMax, rightMax);
        }

        // 早上从最难往最简单写，下午傍晚从最简单往最难写，哈哈哈哈哈
        public boolean divisorGame(int n) {
            this.n = n;
            f = new Boolean [n+1][2];
            return dfs(n, 0);
        }
        Boolean [][] f;
        int n;
        boolean dfs(int i, int j) {
            if (i == 1) return f[i][j%2] = (j % 2 == 0 ? false : true);
            if (f[i][j%2] != null) return f[i][j%2];
            boolean fst = j % 2 == 0;
            for (int k = 1; k < i; k++) {
                if (i % k != 0) continue;
                if (fst && dfs(i - k, j+1)) return f[i][j%2] = true;
                else if (!fst && !dfs(i - k, j+1)) return f[i][j%2] = false;
            }
            return f[i][j%2] = fst ? false : true;
        }

        public int getMaximumGenerated(int n) { // 鬼知道这个题说的是什么意思。。。。。
            if (n < 2) return n == 1 ? 1 : 0;
            int [] f = new int [n+1];
            f[1] = 1;
            for (int i = 1; i <= n/2; i++) {
                System.out.println("i: " + i);
                f[2 * i] = f[i];
                System.out.println(Arrays.toString(f));
            }
            for (int i = 1; i <= (n - 1) / 2; i++) {
                System.out.println("i: " + i);
                f[2 * i + 1] = f[i] + f[i+1];
                System.out.println(Arrays.toString(f));
            }
            System.out.println(Arrays.toString(f));
            return Arrays.stream(f).max().getAsInt();
        }

        Map<Integer, List<TreeNode>> m = new HashMap<>(); // 【记忆化】
        public List<TreeNode> allPossibleFBT(int n) { // 用昨天晚上的回塑：可是是怎么生成的呢？
            List<TreeNode> ans = new ArrayList<>();
            if (m.containsKey(n)) return m.get(n);
            if (n == 1) {
                ans.add(new TreeNode(0));
                return ans;
            } else if (n % 2 == 1) {
                for (int i = 0; i < n; i++) {
                    int y = n-1 - i;
                    for (TreeNode l : allPossibleFBT(i))
                        for (TreeNode r : allPossibleFBT(n-1-i)) {
                            TreeNode root = new TreeNode(0);
                            root.left = l;
                            root.right = r;
                            ans.add(root);
                        }
                }
                m.put(n, ans);
            }
            return ans;
        }

        public int minimumDeleteSum(String ss, String tt) {
            m = ss.length(); n = tt.length();
            s = ss.toCharArray(); t = tt.toCharArray();
            f = new Integer [m][n];
            return dfs(0, 0);
        }
        int m, n;
        char [] s, t;
        Integer [][] f;
        int dfs(int i, int j) {
            if (i == m || j == n) {
                if (i == m && j == n) return 0;
                int r = 0, k = j;
                if (i == m) {
                    k = j;
                    while (k < n) r += t[k++];
                } else {
                    k = i;
                    while (k < m) r += s[k++];
               }
                return r;
            }
            if (f[i][j] != null) return f[i][j];
            if (s[i] == t[j]) return f[i][j] = dfs(i+1, j+1);
            return f[i][j] = Math.min(s[i] + dfs(i+1, j), t[j] + dfs(i, j+1));
        }        
        
        public int change(int v, int[] a) {
            this.a = a; n = a.length;
            Arrays.sort(a);
            f = new Integer [n][v+1];
            return dfs(n-1, v);
        }
        Integer [][] f;
        int [] a;
        int n;
        int dfs(int i, int j) {
            if (j == 0 && i >= 0) return 1;
            if (i < 0) return (j > 0 ? 0 : 1);
            if (f[i][j] != null) return f[i][j];
            if (a[i] > j) return f[i][j] = dfs(i-1, j);
            int r = dfs(i-1, j), k = j;
            while (k - a[i] >= 0) {
                r += dfs(i-1, k - a[i]);
                k -= a[i];
            }
            return f[i][j] = r;
        }        

        public long getDescentPeriods(int[] a) {
            int n = a.length, i = 0, j = 0;
            long r = 0;
            while (i < n) {
                while (i < n-1 && a[i] - a[i+1] == 1) i++;
                int len = i - j + (i == n ? 0 : 1);
                r += getSum(len);
                if (i == n) return r;
                i += 1;
                j = i;
            }
            return r;
        }
       long getSum(int v) {
            if (v == 1) return 1l;
            return (long)v * ((long)v + 1l) / 2l;
        }

        public int rotatedDigits(int n) {
            r = new int [10];
            r[2] = 5; r[5] = 2; r[6] = 9; r[9] = 6; r[1] = 1; r[8] = 8;
            int ans = 0;
            for (int i = 2; i <= n; i++) {
                String cur = String.valueOf(i);
                if (cur.indexOf('3') != -1 || cur.indexOf('4') != -1 || cur.indexOf('7') != -1) continue;
                int v = getRotated(cur);
                if (i == v) continue;
                ans++;
            }
            return ans;
        }
        int [] r;
        int getRotated(String t) {
            int n = t.length(); char [] s = t.toCharArray();
            int cur = 0;
            for (int i = 0; i < n; i++)
                cur = cur * 10 + r[s[i] - '0'];
            return cur;
        }

        public double largestSumOfAverages(int[] a, int k) {
            this.a = a; n = a.length;
            r = new int [n+1];
            for (int i = 0; i < n; i++) r[i+1] = r[i] + a[i];
            System.out.println(Arrays.toString(r));
            f = new Double [n][k+1];
            return dfs(0, k);
        }
        int n; int [] a, r;
        Double [][] f;
        double dfs(int i, int j) { // 这里是最多分成 j 片
            if (i == n) return 0;
            if (j == 1) return f[i][j] = (double)(r[n] - r[i]) / (n - i);
            if (f[i][j] != null) return f[i][j];
            double ans = (double)((r[n]  - r[i])/ n);
            for (int k = 1; k < j; k++) 
                for (int x = i+1; x <= n-k; x++) 
                    ans = Math.max(ans, (double)(r[x] - r[i]) / (x - i) + dfs(x, k));
            return f[i][j] = ans;
        }

        public double knightProbability(int n, int k, int row, int column) {
            if (k == 0) return 1; this.n = n;
            f = new Double [n][n][k+1];
            return dfs(row, column, k);
        }
        int [][] dirs = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1},
                         {-1, -2}, {1, -2}, {-1, 2}, {1, 2}};
        Double [][][] f;
        int n;
        double dfs(int i, int j, int k) {
            if (k == 1) {
                int cnt = 0;
                for (int [] d : dirs) {
                    int x = i + d[0], y = j + d[1];
                    if (x < 0 || x >= n || y < 0 || y >= n) continue;
                    cnt++;
                }
                return f[i][j][k] = (double)(cnt / 8.0);
            }
            if (f[i][j][k] != null) return f[i][j][k];
            int cnt = 0; double p = 0d;
            for (int [] d : dirs) {
                int x = i + d[0], y = j + d[1];
                if (x < 0 || x >= n || y < 0 || y >= n) continue;
                cnt++;
                p += (1.0 / 8.0) * dfs(x, y, k-1);
            }
            return f[i][j][k] = p;
        }

        int [][] dirs = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        public int maxDistance(int[][] a) {
            int n = a.length, max = 0;
            Deque<int []> q = new ArrayDeque<>();
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) 
                    if (a[i][j] == 1) q.offerFirst(new int [] {i, j, 0});
            if (q.isEmpty() || q.size() == n * n) return -1;
            boolean [][] v = new boolean [n][n];
            while (!q.isEmpty()) {
                for (int size = q.size()-1; size >= 0; size--) {
                    int [] cur = q.pollLast();
                    int i = cur[0], j = cur[1], k = cur[2];
                    max = Math.max(max, k);
                    for (int [] d : dirs) {
                        int x = i + d[0], y = j + d[1];
                        if (x < 0 || x >= n || y < 0 || y >= n || a[x][y] == 1 || v[x][y]) continue;
                        v[x][y] = true;
                        q.offerFirst(new int [] {x, y, k + Math.abs(x - i) + Math.abs(y - j)});
                    }
                }
            }
            return max;
        }

        // public int bestTeamScore(int[] a, int[] b) { // TLE TLE TLE: 131/149 记忆化深搜会，TLE 
        //     n = a.length;
        //     for (int i = 0; i < n; i++)
        //         l.add(new int [] {b[i], a[i]});
        //     Collections.sort(l, (x, y)-> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
        //     return dfs(0, 0);
        // }
        // List<int []> l = new ArrayList<>();
        // int n;
        // Map<String, Integer> m = new HashMap<>();
        // int dfs(int i, int j) {
        //     if (i == n) return 0;
        //     String k = i + "-" + j;
        //     if (m.containsKey(k)) return m.get(k);
        //     int [] r = l.get(i);
        //     if (j > 0 && r[1] < j) {
        //         int v = dfs(i+1, j);
        //         m.put(k, v);
        //         return v;
        //     }
        //     int ans = r[1] + dfs(i+1, r[1]);
        //     int v = Math.max(ans, dfs(i+1, j));
        //     m.put(k, v);
        //     return v;
        // }        
        public int bestTeamScore(int[] a, int[] b) { // 动规就不会。。。
            int n = a.length;
            List<int []> l = new ArrayList<>();
            for (int i = 0; i < n; i++)
                l.add(new int [] {b[i], a[i]});
            Collections.sort(l, (x, y)-> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
            int [] f = new int [n];
            for (int i = 0; i < n; i++) f[i] = l.get(i)[1];
            for (int i = n-2; i >= 0; i--) {
                int u = l.get(i)[1];
                for (int j = i+1; j < n; j++) {
                    int v = l.get(j)[1];
                    if (u <= v) {
                        f[i] = Math.max(f[i], f[j] + u);
                        // break; // 【BUG:】会舍掉最优解，不能加
                    }
                }
            }
            return Arrays.stream(f).max().getAsInt();
        }

        public int videoStitching(int[][] a, int t) {
            int n = a.length;
            int [][] f = new int [n][t+1];
            Arrays.sort(a, (x, y) -> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
            if (a[0][0] > 0 || a[n-1][1] < t) return -1;
            Arrays.stream(f).forEach(z -> Arrays.fill(z, Integer.MAX_VALUE));
            f[0][a[0][1]] = 1;
            for (int i = 1; i < n; i++) {
                int u = a[i][0], v = a[i][1];
                for (int j = i-1; j >= 0; j--) {
                    int x = a[j][0], y = a[j][1];
                    if (y < u) return -1;
                    f[i][v] = Math.min(f[i][v], f[j][y] + 1);
                }
            }
        }

        public int eraseOverlapIntervals(int[][] a) {
            int n = a.length;
            Arrays.sort(a, (x, y) -> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
            int [] f = new int [n];
            Arrays.fill(f, 1);
            for (int i = 1; i < n; i++) {
                int u = a[i][0], v = a[i][1];
                for (int j = i-1; j >= 0; j--) {
                    int x = a[j][0], y = a[j][1];
                    if (u >= y) {
                        f[i] = Math.max(f[i], f[j] + 1);
                        break;
                    }
                }
            }
            return n - Arrays.stream(f).max().getAsInt();
        }

        public List<Integer> goodDaysToRobBank(int[] a, int t) {
            int n = a.length;
            int [] l = new int [n], r = new int [n];
            for (int i = 1; i < n; i++) 
                if (a[i-1] >= a[i]) l[i] = l[i-1] + 1;
            for (int i = n-2; i >= 0; i--)
                if (a[i] <= a[i+1]) r[i] = r[i+1] + 1;
            List<Integer> ans = new ArrayList<>();
            for (int i = t; i + t < n; i++)             
                if (l[i] >= t && r[i] >= t) ans.add(i);
            return ans;
        }

        public int orderOfLargestPlusSign(int n, int[][] b) {
            int [][] a = new int [n][n];
            Arrays.stream(a).forEach(z -> Arrays.fill(z, 1));
            for (int [] v : b) a[v[0]][v[1]] = 0;
            if (n == 1) return a[0][0];
            int [][] l = new int [n+1][n+1], r = new int [n+1][n+1], u = new int [n+1][n+1], d = new int [n+1][n+1];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    if (a[i][j] == 1) l[i+1][j+1] = l[i+1][j] + 1;
                for (int j = n-1; j >= 0; j--)
                    if (a[i][j] == 1) r[i+1][j] = r[i+1][j+1] + 1;
            }
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < n; i++)
                    if (a[i][j] == 1) u[i+1][j+1] = u[i][j+1] + 1;
                for (int i = n-1; i >= 0; i--)
                    if (a[i][j] == 1) d[i][j+1] = d[i+1][j+1] + 1;
            }
            int max = (n * n > b.length ? 1 : 0);
            for (int i = 0; i < n-1; i++)
                for (int j = 0; j < n-1; j++) {
                    if (a[i][j] == 1) {
                        int minLR = Math.min(l[i+1][j+1], r[i+1][j]);
                        int minUD = Math.min(u[i+1][j+1], d[i][j+1]);
                        max = Math.max(max, Math.min(minLR, minUD));
                    }
                }
            return max;
        }

        public int lenLongestFibSubseq(int[] a) {
            int n = a.length, max = 0, cnt = 0; this.a = a;
            if (n == 3) return a[0] + a[1] == a[2] ? 3 : 0;
            for (int i = 1; i < n; i++) {
                for (int j = i-1; j >= 0; j--) {
                    int x = i, y = j;
                    int u = a[y], v = a[x];
                    cnt = 2;
                    int idx = binarySearch(x+1, n-1, u + v);
                    while (idx != -1 && idx <= n-1) {
                        cnt++;
                        u = v; v = a[idx];
                        if (idx == n-1) break;
                        idx = binarySearch(idx+1, n-1, u + v);
                    }
                    max = Math.max(max, cnt);
                }
            }
            return max >= 3 ? max : 0;
        }
        int [] a;
        int binarySearch(int l, int r, int v) {
            if (l > r) return -1;
            if (v < a[l] || v > a[r]) return -1;
            while (l < r) {
                int m = (l + r) >> 1;
                if (a[m] >= v) r = m;
                else l = m+1;
            }
            return (l <= r && a[l] == v) ? l : -1;
        }

        public int closestCost(int[] a, int[] b, int t) {
            n = a.length; m = b.length; this.t = t; this.a = a; this.b = b;
            Arrays.sort(a); Arrays.sort(b);
            for (int i = n-1; i >= 0; i--) 
                backTracking(m-1, a[i]);
            return val;
        }
        int [] a, b;
        int m, n, t, min = Integer.MAX_VALUE, val = 0;
        void backTracking(int i, int cur) {
            int v = Math.abs(cur - t);
            if (v > min && cur > t) return;
            if (v == 0) {
                min = 0;
                val = cur;
                return ;
            }
            if (v == min && min > 0) val = Math.min(val, cur);
            else if (v < min) {
                min = v;
                val = cur;
                if (min == 0) return;
            }
            if (i < 0) return;
            if (cur < t) {
                backTracking(i-1, cur + b[i] * 2);
                backTracking(i-1, cur + b[i]);
                backTracking(i-1, cur);
            }
        }

        public int maxTurbulenceSize(int [] a) {
            int n = a.length;
            if (n < 3) return n < 2 || a[0] != a[1] ? n : 1;
            int [] f = new int [n];
            Arrays.fill(f, 1); f[1] = (a[1] == a[0] ? 1 : 2);
            for (int i = 2; i < n; i++) {
                if (a[i-2] < a[i-1] && a[i-1] > a[i] || a[i-2] > a[i-1] && a[i-1] < a[i])
                    f[i] = f[i-1] + 1;
                else if (a[i] != a[i-1]) f[i] = Math.max(f[i], 2);
            }
            return Arrays.stream(f).max().getAsInt();
        }

        static final int mod = (int)1e9 + 7;
        public int countTexts(String t) {
            n = t.length(); s = t.toCharArray();
            f = new Integer [n];
            r = new int [10];
            for (int i = 2; i < 7; i++) r[i] = 3;
            r[8] = 3; r[7] = 4; r[9] = 4;
            return dfs(0);
        }
        Integer [] f;
        char [] s;
        int n, r [];
        int dfs(int i) {
            if (i == n) return 1;
            if (f[i] != null) return f[i];
            if (i == n-1) return f[i] = 1;
            long ans = 0;
            int j = i+1;
            while (j < n && j < i+r[s[i]-'0'] && s[j] == s[i]) j++;
            for (int k = i; k < j; k++) 
                ans = (ans + dfs(k+1)) % mod;
            return f[i] = (int)ans;
        }

        public int minNumberOfSemesters(int n, int[][] a, int k) { // TLE TLE TLE: 应该主要是回塑的过程中，状态太多，会超时，动规应该就不会了
            this.n = n; this.k = k; min = n;
            if (a.length == 0) return n / k + (n % k > 0 ? 1 : 0);
            for (int [] e : a) {
                int u = e[0]-1, v = e[1]-1;
                m.put(v, m.getOrDefault(v, 0) | (1 << u));
            }
            backTracking(0, 0);
            return min;
        }
        Map<Integer, Integer> m = new HashMap<>(); // 每门课的选课前提
        int n, k, min;
        void backTracking(int i, int j) { // i: 已经选过课的mask, j: 用到的学期数
            if (j >= min) return ;  // 剪枝
            if (Integer.bitCount(i) == n) {
                min = Math.min(min, j);
                return ;
            }
            int max = 0; 
            for (int x = 0; x < n; x++) 
               // if (r[x]== 0 && ((i >> x) & 1) == 0) // 当前课：【( 没有其它必选课要求，或是有且全选过了 )可选，还没有选过】
                if ((i & (1 << x)) == 0 && (!m.containsKey(x) || (i & m.get(x)) == m.get(x))) // 当前课：【还没有选过, 可以选】: 所有必须的前提课都选过了。。。
                   max |= (1 << x);
           int bitCnts = Integer.bitCount(max);
// 【遍历 max-bit 位的所有的子集：】这里用了个奇招：对一个 bit-mask, 怎么去掉一个 bit 位，并取到当前数的所有可能的 bit 位子集的？？？忘光了。。。【这个深搜方向写不到】用个动规也该会写呀。。。
           // for (int x = max; x > 0; x--) {
           //     if (Integer.bitCount(x) > k || ((max & x) != x)) continue; // 【BUGLLY CODING】
           for (int x = max; x > 0; x = ((x-1) & max)) {
               if (Integer.bitCount(x) > k) continue; // 【BUGLLY CODING】
               int y = i | x;
               backTracking(y, j+1);
           }
        }
        public int minNumberOfSemesters(int n, int[][] a, int k) { // 动规写法
            int [] p = new int [n], f = new int [1 << n];
            for (int [] e : a) p[e[1]-1] |= (1 << (e[0] - 1));
            Arrays.fill(f, n);
            f[0] = 0;
            for (int i = 0; i < (1 << n); i++) {
                int max = 0; // 【筛选出所有备选课程：】: 这里先是，可能包含了已经选过的课程 
                for (int x = 0; x < n; x++) 
                    // if (((i >> x) & 1) == 0 && (i & p[x]) == p[x]) // 当前课：【还没有选过, 可以选】: 所有必须的前提课都选过了【逻辑是清楚完整的，但太慢了】
                    if ((i & p[x]) == p[x]) // 当前课：【没有选课前提，或是前提全满足了】: 这门课可能【还没选过】，可能【已经选过了】
                        max |= 1 << x;
                max = max & (~i); // 【过滤掉：所有已经选过的课】
                // for (int j = max; j > 0 && Integer.bitCount(j) <= k && ((max & j) == j); j--) { // 这里的写法又会中断循环BUGGLY CODING....
                for (int j = max; j > 0; j = (j - 1) & max) { // 这里的写法又会中断循环
                    if  (Integer.bitCount(j) > k) continue;
                    f[i | j] = Math.min(f[i | j], f[i] + 1);
                }
            }
            return f[(1 << n) - 1];
        }

        static final int mod = (int)1e9 + 7; // TLE TLE TLE: 68/74 记忆化深搜：总涉及这些超时问题。动规就不会。。。
        public int beautifulPartitions(String t, int k, int minLength) {
            n = t.length(); this.minLength = minLength;
            if (k * minLength > n) return 0;
            s = t.toCharArray();
            if (!sc.contains(s[0]) || sc.contains(s[n-1])) return 0;
            f = new Integer [n][k+1];
            return dfs(0, k);
        }
        Set<Character> sc = new HashSet<>(List.of('2', '3', '5', '7'));
        int n, k, minLength;
        char [] s;
        Integer [][] f;
        int dfs(int i, int j) {
            if (j == 1) {
                if (i + minLength > n) return f[i][j] = 0; // 最后一段不够长度
                return f[i][j] = 1;
            }
            if (i < n && !sc.contains(s[i])) return f[i][j] = 0; // 不是太质数打头
            if (i < n && i + minLength >= n && j > 1) return f[i][j] = 0;
            if (f[i][j] != null) return f[i][j];
            long r = 0;
            for (int k = i+minLength; k < n; k++) 
                if (!sc.contains(s[k-1]) && sc.contains(s[k]))
                    r = (r + dfs(k, j-1)) % mod;
            return f[i][j] = (int)r;
        }
        public int beautifulPartitions(String t, int k, int minLength) { // 【动规：】现在就是感觉动规的写法，写得好别扭。。。
            n = t.length(); s = t.toCharArray();
            if (k * minLength > n || !isPrime(s[0]) || isPrime(s[n-1])) return 0; // 剪枝
            int [][] f = new int [k+1][n+1];
            f[0][0] = 1;
            for (int i = 1; i <= k; i++) {
                var sum = 0;
                // 【遍历前 i 段中的某段，寻找一个新的可能的切割点】：优化：枚举的起点和终点需要给前后的子串预留出足够的长度
                for (int j = i * minLength; j + (k - i) * minLength <= n; j++) {
                    // 从前一段，第 i-1 的片段，再划分的结果：它可能是个长片段 >minLength, 从中找到一个切割点，更新累计和
                    if (canPartition(j - minLength)) sum = (sum + f[i-1][j - minLength]) % mod; // j'=j-l 双指针
                    // 遍历当前第 i 段，的所有有效合法下标集合：给前后片段留出最小长度，给当前片段留下最大选择空间
                    if (canPartition(j)) f[i][j] = sum; // 当前段，每段可能的结果，都是前一段再切割的累计和
                }
            }
            return f[k][n];
        }
        Set<Character> sc = new HashSet<>(List.of('2', '3', '5', '7'));
        static final int mod = (int)1e9 + 7; int n; char [] s;
        boolean isPrime(char c) {
            return sc.contains(c);
        }
        boolean canPartition(int j) { // 能否以 j 下标为头，划分出一个片段。 j包含【0,n-1】：包括了开头和结尾. 判断是否可以在 j-1 和 j 之间分割（开头和末尾也算）
            return j == 0 || j == n || !isPrime(s[j-1]) && isPrime(s[j]);
        }

        public long countQuadruplets(int[] a) { 
            int n = a.length;
            int [][] r = new int [n][n+1]; // 在 k 右侧的比 a[j] 大的元素个数，记作 r[k][a[j]]
            for (int i = n-2; i >= 0; i--) { // 处理的是，当前下标 i 之后（i,n-1] 内，比 a【i+1】小的数的个数
                r[i] = r[i+1].clone();
                for (int x = a[i+1]-1; x >= 0; x--) // 因为添加了当前元素 a[i+1], 所以所有比它小的数，个数＋1
                    r[i][x]++; // x < a[i+1], 对于 x, 大于它的数的个数 +1
            }
            long ans = 0;
            int [] l = new int [n+1];
            for (int j = 1; j < n-2; j++) { // 处理的是当前下标【0,j）范围内，比 a[j-1] 大的数的个数
                for (int x = a[j-1]+1; x <= n; x++) // 因为添加了，当前遍历数 a[j-1], 所以所有比它大的数，添加一个
                    l[x]++;
                for (int k = j+1; k < n-1; k++)
                    if (a[j] > a[k])
                        ans += l[a[k]] * r[k][a[j]];
            }
            return ans;
        }
        // 上面有个限制条件： n 个数是【1,n】的全排列，所以当 j 的右边【1,x】的个数固定为： n-(j+1)-g[j][x], 又只有 x 个【1,x】的数，又x 在 j 的右边
        // 所以左侧：可以清楚知道，有 x － [n-(j+1)-g[j][x]] 个小于 x 即【0,x）的数
        // 就可以把 l[] 数组给优化掉
        public long countQuadruplets(int[] a) { 
            int n = a.length;
            int [][] r = new int [n][n+1];
            for (int i = n-2; i > 0; i--) { // 想要更新的是：（i+1,n) 下标下
                r[i] = r[i+1].clone();
                for (int x = a[i+1]-1; x > 0; x--) // （i 的右侧，所有比当前下标值 a[i+1] 大的数的个数，＋1 因为添加了大数 a[i+1]
                    r[i][x]++;
            }
            long ans = 0;
            for (int j = 1; j < n-2; j++) { // 遍历当前 j: 实际对应于 j+1 下标，后面留个 k
                for (int k = j+1; k < n-1; k++) { // 遍历的是中间【j,k】对，数左右两边的数
                    // int x = a[k];
                    if (a[k] < a[j]) // 注意下边：在 j 的右边，比 x=a[k] 大的数，应该是 r[j][a[k]], 不能写错了。。。
                        ans += (a[k] - (n - (j+1) - r[j][a[k]])) * r[k][a[j]];
                }
            }
            return ans;
        }

        Map<Integer, Integer> m = new HashMap<>();
        public int minDays(int i) {
            if (i == 1) return 1;
            if (i == 2) return 2;
            if (i == 3) return 2;
            if (m.containsKey(i)) return m.get(i);
            int v = 1 + Math.min((i % 2) + minDays(i / 2), (i % 3) + minDays(i / 3));
            m.put(i, v);
            return v;
        }

        static final int mod = (int)1e9 + 7; // 1994: 结果的集合是遍历【1 《 10】，但每个合法 mask 的可产生频率仍跟上一题相关。。。
        static final int[] ip = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        public int numberOfGoodSubsets(int [] a) { // 这个应该不用考虑数组里是否有重得的好数，没意义。。。
            int n = a.length, m = 31;
            int [] freq = new int [m];
            for (int v : a) freq[v]++;
// 遍历：所有可能的质数乘积，约有 1000 个数：然后对于每个可能的质数组成，如何选数，方案数统计【这里有点儿没有想透】
            int [] f = new int [1 << 10]; // 动规：这是所有可能的结果
            f[0] = 1;
            for (int i = 0; i < freq[1]; i++) f[0] = f[0] * 2 % mod; // 初始化为： f[0] ＝ 数值 1 出现在的频率2^freq[1]
            for (int i = 2; i < m; i++) {
                if (freq[i] == 0) continue; // 数值不曾出现
                // 检查 i 的每个质因数是否均不超过 1 个
                int subset = 0, x = i;
                boolean check = true;
                for (int j = 0; j < ip.length; j++) {
                    int prime = ip[j];
                    if (x % (prime * prime) == 0) {
                        check = false;
                        break;
                    }
                    if (x % prime == 0)
                        subset |= (1 << j);
                }
                if (!check) continue;
                // 动态规划: 以每个单数，来更新所有可能的结果
                for (int j = (1 << 10)-1; j > 0; j--) 
                    if ((j & subset) == subset) // 以每个单数，来更新所有可能的结果
                        f[j] = (int) ((f[j] + ((long) f[j ^ subset]) * freq[i]) % mod);
            }
            int ans = 0;
            for (int i = 1; i < (1 << 10); i++)
                ans = (ans + f[i]) % mod;
            return ans;
        }

        int [][] dirs = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        public int[][] updateMatrix(int[][] a) {
            int m = a.length, n = a[0].length, step = 1;
            Deque<int []> q = new ArrayDeque<>();
            boolean [][] v = new boolean [m][n];
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++) 
                    if (a[i][j] > 0) {
                        if (i > 0 && a[i-1][j] == 0 || i < m-1 && a[i+1][j] == 0
                            || j > 0 && a[i][j-1] == 0 || j < n-1 && a[i][j+1] == 0) {
                            v[i][j] = true; 
                            q.offerFirst(new int [] {i, j});
                        }
                    }
            while (!q.isEmpty()) {
                for (int size = q.size()-1; size >= 0; size--) {
                    int [] cur = q.pollLast();
                    int i = cur[0], j = cur[1];
                    a[i][j] = step;
                    for (int [] d : dirs) {
                        int x = i + d[0], y = j + d[1];
                        if (x < 0 || x >= m || y < 0 || y >= n || a[x][y] == 0 || v[x][y]) continue;
                        v[x][y] = true;
                        q.offerFirst(new int [] {x, y});
                    }
                }
                step++;
            }
            return a;
        }

        public int getMaxLen(int[] a) {
            int n = a.length, max = 0, ll = -1, rr = -1, cnt = 0, i = 0, j = 0;
            while (i < n && a[i] == 0) i++;
            j = i;
            for (; i < n; i++) {
                if (a[i] < 0) {
                    if (ll == -1) ll = i;
                    rr = i;
                    cnt++;
                } else if (a[i] == 0) {
                    if (cnt % 2 == 0) max = Math.max(max, i - j);
                    else max = Math.max(max, Math.max(rr - j, i - ll - 1));
                    ll = -1; rr = -1;
                    while (i < n && a[i] == 0) i++;
                    j = i;
                    --i;
                    cnt = 0;
                }
            }
            max = Math.max(max, (cnt % 2 == 0 ? i - j : Math.max(rr - j, i - ll - 1)));
            return max;
        }

        public int minimizeArrayValue(int[] a) {
            n = a.length;
            int ans = Integer.MAX_VALUE;
            int l = 0, r = (int)1e9;
            while (l <= r) {
                int m = l + (r - l) / 2;
                if (check(m, a)) {
                    ans = Math.min(ans, m);
                    r = m-1;
                } else l = m + 1;
            } 
            return ans;
        }
        int n;
        boolean check(int v, int [] a) {
            long r = 0;
            for (int i = n-1; i >= 0; i--) 
                if ((long)a[i] + r > (long)v) r = (long)a[i] + r - (long)v;
                else r = 0l;
            return r == 0;
        }

        public int minSpaceWastedKResizing(int[] a, int k) {
            n = a.length; this.k = k; this.a = a;
            int max = 1;
            r = new int [n]; p = new int [n+1];
            for (int i = n-1; i >= 0; i--) {
                max = Math.max(max, a[i]);
                r[i] = max;
            }
            for (int i = 0; i < n; i++) p[i+1] = p[i] + a[i];
            f = new Integer [n][k+1];
            return dfs(0, k);
        }
        int n, k; int [] a;
        int [] r, p;
        Integer [][] f;
        int dfs(int i, int j) {
            if (i == n) return 0;
            if (j == 0) return f[i][j] = r[i] * (n - i) - (p[n] - p[i]);
            if (f[i][j] != null) return f[i][j];
            int max = 1, ans = Integer.MAX_VALUE, cur = 0;
            for (int k = i; k < n-(j-1); k++) {
                max = Math.max(max, a[k]);
                ans = Math.min(ans, max * (k - i + 1) - (p[k+1] - p[i]) + dfs(k+1, j-1));
            }
            return f[i][j] = ans;
        }

        public int countGoodStrings(int lo, int hi, int zoo, int one) {
            f = new int [hi+1];
            int v = dfs(hi, 0, zoo, one);
            Arrays.fill(f, 0);
            return (int)((v + mod - dfs(lo-1, 0, zoo, one)) % mod);
        }
        static final int mod = (int)1e9 + 7;
        int [] f;
        int dfs(int t, int cur, int zoo, int one) {
            if (cur > t) return 0;
            if (cur == t) return f[cur] = 1;
            if (t - cur < zoo && t - cur < one) return f[cur] = 1;
            if (f[cur] != 0) return f[cur];
            long ans = 1;
            if (t - cur >= Math.max(zoo, one)) {
                ans = (ans + dfs(t, cur + zoo, zoo, one)) % mod;
                ans = (ans + dfs(t, cur + one, zoo, one)) % mod;
            } else if (t - cur >= Math.min(zoo, one))
                ans = (ans + dfs(t, cur + Math.min(zoo, one), zoo, one)) % mod;
            return f[cur] = (int)ans;
        }

        public int maximumSum(int[] a) { // 1186
            int n = a.length, max = Integer.MIN_VALUE, cur = 0, j = 0, l = 0, r = 0;
            if (n == 1) return a[0]; //prefixSum 之类的
            for (int i = 0; i < n; i++) {
                cur = Math.max(cur + a[i], a[i]);
                max = Math.max(max, cur);
            }
            for (int i = 0; i < n; i++) {
                if (i < n-1) {
                    j = i+1;
                    r = a[j++];
                    while (j < n && r + a[j] >= r) r += a[j++]; // 这里在某个负数的时候会中断掉，中断了不是最优解，因为后面可能会有更大的正数。。。
                }
                if (i > 0) {
                    j = i-1;
                    l = a[j--];
                    while (j >= 0 && l + a[j] >= l) l += a[j--];
                }
                max = Math.max(max, (i > 0 && i < n-1 ? Math.max(l+r, Math.max(l, r)) : (i == 0 ? r : (i == n-1 ? l : Integer.MIN_VALUE))));
                // System.out.println("max: " + max);
            }
            return max;
        }

        public boolean validPartition(int[] a) {
            int n = a.length; this.a = a;
            return validPartition(0, n-1);
        }
        Map<String, Boolean> m = new HashMap<>();
        int [] a;
        boolean validPartition(int i, int j) {
            if (i >= j) return false;
            String k = i + "-" + j;
            if (m.containsKey(k)) return m.get(k);
            if (i + 1 == j) return m.getOrDefault(k, a[i] == a[j]);
            if (i + 2 == j) return m.getOrDefault(k, a[i] == a[i+1] && a[i+1] == a[j] || a[i+1] - a[i] == 1 && a[j] - a[i+1] == 1);
            boolean r = validPartition(i, i+1) && validPartition(i+2, j)
                || validPartition(i, i+2) && validPartition(i+3, j);
            m.put(k, r);
            return r;
        }

        public int findCheapestPrice(int n, int[][] a, int src, int d, int k) {
            this.d = d; this.k = k; g = new ArrayList [n];
            Arrays.setAll(g, z -> new ArrayList<>());
            for (int [] e : a) {
                int u = e[0], v = e[1], w = e[2];
                g[u].add(new int [] {v, w});
            }
            f = new Integer [n][k+1];
            int v = dfs(src, k); 
            return v >= Integer.MAX_VALUE / 2 ? -1 : v;
        }
        List<int []> [] g;
        int d, k;
        Integer [][] f;
        int dfs(int i, int j) {
            if (i == d) return 0;
            if (j < 0) return Integer.MAX_VALUE / 2;
            if (f[i][j] != null) return f[i][j];
            int ans = Integer.MAX_VALUE / 2;
            for (int [] e : g[i]) {
                int v = e[0], t = e[1];
                ans = Math.min(ans, t + dfs(v, j-1));
            }
            return f[i][j] = ans;
        }        

        static final int mod = (int)1e9 + 7;
        int [][] dirs = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        public int findPaths(int m, int n, int k, int si, int sj) {
            this.m = m; this.n = n; this.k = k;
            f = new Integer [m][n][k+1];
            return dfs(si, sj, k);
        }
        int m, n, k;
        Integer [][][] f;
        int dfs(int i, int j, int k) { // 瓣不清楚了。。。576
            if (i < 0 || i >= m || j < 0 || j >= n || k < 0) return 0;
            if (f[i][j][k] != null) return f[i][j][k];
            if (k == 1) {
                if ((i == 0 || i == m-1) && (j == 0 || j == n-1))
                    return f[i][j][k] = (m > 1 && n > 1 ? 2 : (m == 1 && n == 1 ? 4 : 3));
                else if ((i == 0 || i == m-1) || (j == 0 || j == n-1))
                    return f[i][j][k] = (m == 1 || n == 1 ? 3 : 1);
            }
        }

        public int integerReplacement(int n) {
            return dfs((long)n);
        }
        Map<Long, Integer> m = new HashMap<>();
        int n;
        int dfs(long i) {
            if (i == 1) return 0;
            if (m.containsKey(i)) return m.get(i);
            if (i % 2 == 0) return m.getOrDefault(i, 1 + dfs(i / 2));
            return m.getOrDefault(i, 1 + Math.min(dfs(i+1), dfs(i-1)));
        }

        static final int mod = (int)1e9 + 7;
        public int numberOfWays(int s, int e, int k) { // 大致有个什么其它操作
            this.n = e; 
            return dfs(s, k);
        }
        Map<String, Integer> m = new HashMap<>();
       int n;
        int dfs(int i, int j) {
            if (j < 0) return 0;
            String k = i + "-" + j;
            if (m.containsKey(k)) return m.get(k);
            if (i == n && j == 0) return m.getOrDefault(k, 1);
            if (j == 1) return m.getOrDefault(k, Math.abs(i-n) == 1 ? 1 : 0);
            if (Math.abs(i - n) > j) return m.getOrDefault(k, 0);
            long ans = 0;
            ans = (ans + dfs(i+1, j-1)) % mod;
            ans = (ans + dfs(i-1, j-1)) % mod;
            return m.getOrDefault(k, (int) ans);
        }        
    }
    public static void main (String[] args) { // 【爱表哥，爱生活！！！活宝妹就是一定要嫁给亲爱的表哥！！！】
        Solution s  =  new Solution ();

        int r = s.numberOfWays(989, 1000, 99);
        System.out.println("r: " + r);
    } 
}
// ListNode head = new ListNode(a[0]); 
// head.buildList(head, a); 
// head.printList(head);
// TreeNode rr = new TreeNode(a[0]);
// rr.buildTree(rr, a);
// rr.levelPrintTree(rr);
































