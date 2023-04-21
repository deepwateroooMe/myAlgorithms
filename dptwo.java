// import com.UnionFind;
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
public class dptwo {
    public static class Solution {
        public int maxProductPath(int[][] a) { // 用记忆化深搜，会狠好写... // TODO TODO TODO: 不知道哪里写错了。。。
            m = a.length;
            n = a[0].length;
            f = new long [m][n][2]; // 【0,1】： 【min,max】
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++) {
                    f[i][j][0] = Integer.MAX_VALUE;
                    f[i][j][1] = Integer.MIN_VALUE;
                }
            // long [][] l = new long [m][n], r = new long [m][n]; // l < 0, r > 0
            // Arrays.stream(l).forEach(z -> Arrays.fill(z, Integer.MAX_VALUE));
            // for (int i = 0; i < n; i++) {
            //     l[0][i] = Math.min(l[0][i], a[0][i]);
            //     r[0][i] = Math.max(1, a[0][i]);
            // }
           long [] ans = dfs(0, 0, a);
            return ans[1] >= 0 ? (int)(ans[1] % mod) : -1;
        }
        static final int mod = (int)1e9 + 7;
        long [][][] f;
        int m, n;
        long [] dfs(int x, int y, int [][] a) {
            if (x < 0 || x >= m || y < 0 || y >= n) return new long [] {Integer.MAX_VALUE, Integer.MIN_VALUE};
            if (x == m-1 && y == n-1) {
                int v = a[x][y];
                return f[x][y] = new long [] {(long)v, (long)v};
            }
            if (f[x][y] != null && f[x][y][0] != Integer.MAX_VALUE && f[x][y][1] != Integer.MIN_VALUE) return f[x][y];
            long [] rt = dfs(x, y+1, a);
            long [] dn = dfs(x+1, y, a);
            long min, max;
            if (a[x][y] < 0) {
                min = Math.max(rt[1], dn[1]) * (long)a[x][y] % mod;
                max = Math.min(rt[0], dn[0]) * (long)a[x][y] % mod;
            } else if (a[x][y] > 0) {
                min = Math.min(rt[0], dn[0]) * (long)a[x][y] % mod;
                max = Math.max(rt[1], dn[1]) * (long)a[x][y] % mod;
            } else {
                min = 0l;
                max = 0l;
            }
            return f[x][y] = new long [] {min, max};
        }

        public int minSessions(int[] a, int sessionTime) { // n: 【1,14】一看这样的数字就知道是回塑
          n = a.length;
          min = n;
          Arrays.sort(a);
          backTracking(n-1, new ArrayList<Integer>(), sessionTime, a);
          return min;
        }
        int n, min;
        void backTracking(int idx, List<Integer> l, int t, int [] a) {
            if (l.size() >= min) return ;
            if (idx < 0) {
                if (l.size() < min) min = l.size();
                return ;
            }
            // 在现有的 session 里添加任务，就是添加到链表中的某个元素上去
            for (int j = 0; j < l.size(); j++) {
                if (j > 0 && l.get(j) == l.get(j-1)) continue;
                if (l.get(j) + a[idx] <= t) {
                    l.set(j, l.get(j) + a[idx]);
                    backTracking(idx-1, l, t, a);
                    l.set(j, l.get(j) - a[idx]);
                }
            }
            // 添加新的 session, 就是链表里【添加】一个新的元素
            l.add(a[idx]);
            backTracking(idx-1, l, t, a);
            l.remove(l.size()-1);
        }

        public int numDecodings(String t) {
            n = t.length();
            s = t.toCharArray();
            if (s[0] == '0') return 0;
            f = new Integer [n];
            dfs(0);
            System.out.println(Arrays.toString(f));
            return f[0];
        }
        char [] s;
        int n;
        Integer [] f;
        int dfs(int i) {
            if (i > n) return 0;
            if (i == n) return 1;
            if (f[i] != null) return f[i];
            if (s[i] == '0') return f[i] = 0;
            if (i == n-1) return f[i] = (s[i] == '0' ? 0 : 1);
            if (s[i+1] == '0') { // 必须反编两位，因为后面的 0 必须跟这一位一起破解
                if (s[i] == '1' || s[i] == '2') return f[i] = dfs(i+2);
                else return f[i] = 0;
            } else {
                int r = 0;
                r += dfs(i+1); // 破解当前一位
                if (s[i] - '0' <= 2 && (s[i] == '1' || s[i+1] - '0' < 7)) // 破解一位，或者【两位】都可以【这里狠容易出 bug, 要把条件都想清楚了】
                    r += dfs(i+2);
                return f[i] = r;
            }
        }

        public int minimizeTheDifference(int[][] a, int t) { // TLE TLE TLE: 14/81 .....
            m = a.length;
            n = a[0].length;
            System.out.println("n: " + n);
            
            v = new boolean [m][n];
            min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                v[0][i] = true;
                dfs(0, i, 0, a, t);
                v[0][i] = false;
            }
            return min;
        }
        int m, n, min = Integer.MAX_VALUE;
        boolean [][] v;
        void dfs(int x, int y, int r, int [][] a, int t) {
            r += a[x][y];
            if (x == m-1) {
                if (Math.abs(r - t) < min) min = Math.abs(r - t);
                // System.out.println("min: " + min);
                v[x][y] = false;
                return ;
            }
            // v[x][y] = true;
            for (int j = 0; j < n; j++) 
                if (!v[x+1][j]) {
                    v[x+1][j] = true;
                    dfs(x+1, j, r, a, t);
                    v[x+1][j] = false;
                }
            // v[x][y] = false;
        }
        
        // 【回塑方法】【这个方法，比赛结束后，当时是参考别人的】：现在自己再改写一下，按照题目最原始的提示来写。感觉别人写得好干净，没有一点儿 bug 与重复！！！
        public int beautifulSubsets(int[] a, int k) { // 【亲爱的表哥，活宝妹一定要嫁的亲爱的表哥！！！活宝妹就是一定要嫁给亲爱的表哥！！！】
            Arrays.sort(a);// 把它按照升序排列
            n = a.length;
            return dfs(0, a, k) - 1;
        }
        Map<Integer, Integer> m = new HashMap<>(); // 已经包含了的数【就是一定不要背着，太重。。。】
        int n;
        int dfs(int idx, int [] a, int k) {
            if (idx == n) return 1;
            int r = 0;
            if (m.getOrDefault(a[idx]-k, 0) == 0) {
                m.put(a[idx], m.getOrDefault(a[idx], 0) + 1);
                r += dfs(idx+1, a, k);
                m.put(a[idx], m.getOrDefault(a[idx], 0)-1);
            }
            r += dfs(idx+1, a, k);
            return r;
        }
        public int beautifulSubsets(int[] a, int k) { // 【亲爱的表哥，活宝妹一定要嫁的亲爱的表哥！！！活宝妹就是一定要嫁给亲爱的表哥！！！    
            n = a.length;
            Arrays.sort(a); // 因为是子集组成：顺序不重要，任何顺序不重要的地方，都是可能需要借助【排序】来帮助自己优化解题的！！！
            r = new int [1001]; // 辅助数组，就不用背个字典背来背去的写得好累。。。
            backTracking(0, a, k);
            return ans - 1; // 包含了一个空集
        }
        int [] r; // cnt frequence array to assist backTracking 这个东西可以不用背，身轻如燕。。。。。
        int n, ans = 0;
        void backTracking(int i, int [] a, int k) { // 【回塑法：】自动生成，所有可能存在的子集. 最重要的问题是：【不要产生重复！！！】不重复就不用 mask...
            if (i == n) {
                ans++;
                return ;
            }
// 数组排序了：前面子集中，只可能存在 a[i] － k 的数，不存在 a[i]+k 的数，排序就简化了问题
// 得数独特的。。。。。独特的，永远先想到 mask 。。。。。
            if (a[i] - k <= 0 || r[a[i] - k] == 0) { // 可以包含当前数的情况
                r[a[i]]++;
                backTracking(i+1, a, k);
                r[a[i]]--;
            }
            backTracking(i+1, a, k); // <<<<<<<<<<<<<<<<<<<< 其它情况都可以不包含。。。当前数
            // if (a[i] - k > 0 && r[a[i]-k] > 0) { // 一定不能再包含当前数【看似逻辑分明，仍制造了无数重复！！！】
            //     backTracking(i+1, mask, a, k); // <<<<<<<<<<<<<<<<<<<< 
            // } else { // 可包含，可不包含
            //     backTracking(i+1, mask, a, k); // <<<<<<<<<<<<<<<<<<<< 比较一下，上下两行，是不是重复了？【BUGGLY CODING】
            //     r[a[i]]++;
            //     backTracking(i+1, mask | (1 << i), a, k);
            //     r[a[i]]--;
            // }
        }

        public int squareFreeSubsets(int[] a) { // 这里回到了写动规的 baby 状态。。。
            n = a.length;
            p = new int [n];
            for (int i = 0; i < n; i++) p[i] = getPrimeFactors(a[i]);
            System.out.println(Arrays.toString(p));
            
            int m = (1 << 10);
            f = new Integer [n][m];
            return (int)dfs(0, 0, a) - 1;
        }
        static final int mod = (int)1e9 + 7;
        List<Integer> ip = List.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        int [] p;
        Integer [][] f;
        int n, ans = 0;
        int dfs(int i, int j, int [] a) { // J: mask
            if (i == n) return 1;
            if (f[i][j] != null) return f[i][j];
            long ans = 0;
            if ((j & p[i]) == 0) // 【包含】当前数，因为不存在公因子，乘积就不会产生平方因子
                ans = (ans + dfs(i+1, j | p[i], a)) % mod;
            // 【不包含】当前数：任何情况下都是可以不包含当前数的
            ans = (ans + dfs(i+1, j, a)) % mod;
            return f[i][j] = (int)ans;
        }
        // 刚才写糊了，是因为，回想一下，最开始不会写动规时，
        // 不总把动规自顶向下，与记忆化深搜自底向上【向下与向上，一起】写一起写糊吗？【一起不该是前两天，那个树 ZigZag 才向下与向上一起的吗？】
        // 用动规写起来，应该是最自然的，昨天的青蛙跳，就是单向从头跳到尾，这里两维与一维的本质相同，第一维下标就是单向跳，从头跳到尾，自头向尾更新。。。
        static final int mod = (int)1e9 + 7; // TODO TODO TODO: 这里还有点儿小问题
        List<Integer> ip = List.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        // int [] p;
        // Integer [][] f;
        // int n, ans = 0;
        public int squareFreeSubsets(int[] a) {
            int n = a.length;
            if (n == 1) return 1;
            int [] p = new int [n];
            for (int i = 0; i < n; i++) p[i] = getPrimeFactors(a[i]);
            int m = (1 << 10);
            int [][] f = new int [n+1][m];
            // 【初始化：】感觉有时候弄不清楚，怎么初始化？
            for (int i = 0; i < n; i++) f[i+1][0] = 1; // 每个元素单数，都是一个最小的子集
            // f[0][0] = 1; // 空集是 1 ？ 
            for (int i = 1; i <= n; i++) { // 遍历当前的下标 i
                int mask = p[i-1]; // 当前数 a[i] 的质因子掩码
                f[i][mask] = (f[i][0] + f[i][mask]) % mod;
                for (int j = m-1; j >= mask; j--) { // 遍历所有可能的子集：
                    if ((j & mask) == mask) // 掩码 j 可以通过添加一个当前元素 a[i], 或是或上当前掩码 mask 得到
                        f[i][j] = (f[i][j] + f[i-1][j ^ mask]) % mod; // 添加了由 f[j^mask] 而来的所有可能数
                }
            }
            return (int)(Arrays.stream(f[n]).asLongStream().sum() % mod) - 1;
        }
        int getPrimeFactors(int x) {
            int r = 0;
            for (int i = 0; i < 10; i++) {
                int v = ip.get(i);
                if (x >= v && x % v == 0) r |= (1 << i);
            }n
            return r;
        }

        // 这个题好像是两遍 dfs 的思路：第一遍后，将路径改掉
        public boolean isPossibleToCutPath(int[][] a) {
            m = a.length;
            n = a[0].length;
            int mn = m * n;
            dfs(0, 0, a);
            a[0][0] = 1; // 只有头被误改掉了。。。尾还正常
            return !dfs(0, 0, a);
        }
        int [][] dirs = {{1, 0}, {0, 1}};
        int m, n;
        boolean dfs(int i, int j, int [][] a) {
            if (i < 0 || i >= m || j < 0 || j >= n || a[i][j] == 0) return false;
            if (i == m-1 && j == n-1) return true;
            a[i][j] = 0;
            for (int [] d : dirs)
                if (dfs(i + d[0], j + d[1], a)) return true;
            return false;
        }

        public int maxScoreWords(String[] a, char[] cs, int[] b) {
            int n = a.length, m = (1 << n);
            for (char c : cs) r[c-'a']++;
            List<String> l = new ArrayList<>(Arrays.asList(a));
            for (int i = n-1; i >= 0; i--) 
                if (!check(a[i])) 
                    l.remove(i);
            int max = 0;
            for (int i = 0; i < (1 << l.size()); i++) {
                Arrays.fill(cnt, 0);
                for (int j = 0; j < l.size(); j++) 
                    if (((i >> j) & 1) == 1) addCnts(l.get(j));
                if (isValid()) max = Math.max(max, getScore(b));
            }
            return max;
        }
        int [] r = new int [26];
        int [] cnt = new int [26];
        int getScore(int [] a) {
            int ans = 0;
            for (int i = 0; i < 26; i++)
                ans += a[i] * cnt[i];
            return ans;
        }
        boolean isValid() {
            for (int i = 0; i < 26; i++)
                if (cnt[i] > r[i]) return false;
            return true;
        }
        void addCnts(String t) {
            int n = t.length();
            char [] s = t.toCharArray();
            for (char c : s) cnt[c-'a']++;
        }
        boolean check(String t) {
            int n = t.length();
            char [] s = t.toCharArray();
            Arrays.fill(cnt, 0);
            for (char c : s) cnt[c-'a']++;
            for (int i = 0; i < 26; i++)
                if (cnt[i] > r[i]) return false;
            return true;
        }

        public int cherryPickup(int[][] a) { // 741. Cherry Pickup 忘记这个题的思路了：怎么才能取到最多呢？ // TODO TODO TODO: 
            int n = a.length;
        }
        public int cherryPickup(int[][] a) { // 【暴力解法：】不知道要怎么样才能再快一点儿呢？
            int m = a.length, n = a[0].length;
            int [][][] f = new int [m][n][n];
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    Arrays.fill(f[i][j], -1);
            f[0][0][n-1] = a[0][0] + a[0][n-1];
            for (int i = 0; i < m-1; i++) 
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) { // 这里注意处理： j ＝＝ k 的情况：在一个格，只能取一次值【遍历上一行的【i,j】】
                        if (f[i][j][k] == -1) continue;
                        for (int x = Math.max(0, j-1); x <= Math.min(n-1, j+1); x++) 
                            for (int y = Math.max(0, k-1); y <= Math.min(n-1, k+1); y++) {
                                if (x == y)  f[i+1][x][y] = Math.max(f[i+1][x][y], f[i][j][k] + a[i+1][x]);
                                else f[i+1][x][y] = Math.max(f[i+1][x][y], f[i][j][k] + a[i+1][x] + a[i+1][y]);
                            }
                    }
                }
            int max = 0;
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    max = Math.max(max, f[m-1][i][j]);
            return max;
        }

        public int ways(String[] a, int k) {
            m = a.length;
            n = a[0].length();
            s = new char [m][n];
            for (int i = 0; i < m; i++) s[i] = a[i].toCharArray();
            p = new int [m+1][n+1];
            for (int i = 1; i <= m; i++)
                for (int j = 1; j <= n; j++)
                    p[i][j] = p[i-1][j] + p[i][j-1] - p[i-1][j-1] + (s[i-1][j-1] == 'A' ? 1 : 0);
            f = new Integer [m][n][k];
            return dfs(0, 0, k-1);
        }
        static final int mod = (int)1e9 + 7;
        char [][] s;
        int m, n;
        int [][] p; // p: prefix
        Integer [][][] f;
        int dfs(int i, int j, int k) {
            // if (i == m-1 || j == n-1 || k == 0) { // 【BUG:】这里未必就是终结：因为还可以切，只能说 k ＝＝0 时判断是否有苹果
            if (k == 0) {
                // 如果是最后一行，最后一列【不一定，因为还可以切！！！，只能说 k ＝＝ 0 时来判断】，是否剩余有荚果？
                int apples = p[m][n] - p[m][j] - p[i][n] + p[i][j];
                if (apples > 0 && k == 0) return f[i][j][k] = 1;
                return f[i][j][k] = 0;
            }
            if (f[i][j][k] != null) return f[i][j][k];
            long ans = 0;
            for (int x = i; x < m-1; x++) { // 遍历所有横切的可能性
                int apples = p[x+1][n] - p[i][n] - p[x+1][j] + p[i][j];
                if (apples > 0) ans = (ans + dfs(x+1, j, k-1)) % mod; // 这里没有检查，如果是最后一行，最后一列，是否剩余有荚果？
            }
            for (int x = j; x < n-1; x++) {
                int apples = p[m][x+1] - p[m][j] - p[i][x+1] + p[i][j];
                if (apples > 0) ans = (ans + dfs(i, x+1, k-1)) % mod;
            }
            return f[i][j][k] = (int)ans;
        }

        // 空间复杂度：如果使用滚动数组，则空间复杂度为 O(1)，也可以看成 O(10)。否则空间复杂度为 O(N)
        static final int mod = (int)1e9 + 7;
        public int knightDialer(int n) {
            int [][] g = new int [][] { // 建的是：可以去到哪里
            {4,6},{6,8},{7,9},{4,8},{3,9,0},
            {},{1,7,0},{2,6},{1,3},{2,4}};
            int [][] f = new int [2][10]; // 【滚动数组：】就可以压缩空间
            Arrays.fill(f[0], 1);
            for (int i = 0; i < n-1; i++) {
                Arrays.fill(f[~i & 1], 0); // 这里就写得狠聪明了。。。【搬过来，想看下它滚动是如何滚动的。。。】
                for (int j = 0; j < 10; j++) 
                    for (int k : g[j]) {
                        f[~i & 1][k] += f[i & 1][j];
                        f[~i & 1][k] %= mod;
                    }
            }
            return (int)(Arrays.stream(f[~n & 1]).asLongStream().sum() % mod);
        }
        
        static final int mod = (int)1e9 + 7;
        Set<Integer> s = new HashSet<>(); // 【活宝妹就是一定要嫁给亲爱的表哥！！！】
        public int numOfWays(int n) { // 刚刚摘桃子写了个多维数组，不想再写多维的。滚动数组。因为当前行结果只与前一行的结果相关
            Map<Integer, Integer> [] m = new HashMap[2]; // 滚动字典：要真的让它们可以滚动，才可以哟。。。【爱表哥，爱生活！！！】
            Arrays.setAll(m, z -> new HashMap<Integer, Integer>());
            // 构建每行的备选方案：12 种, 以及第一行的涂色 
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (j == i) continue;
                    for (int k = 0; k < 3; k++) {
                        if (k == j) continue;
                        int v = (((1 << i) << 6) | ((1 << j) << 3) | (1 << k));
                        s.add(v);
                        m[0].put(v, 1);
                    }
                }
            }
            for (int i = 1; i < n; i++) { // 构建剩余 n-1 行的涂色以结果 
                m[i % 2].clear();
                int j = i % 2; // j: idx
                for (Map.Entry<Integer, Integer> en : m[1-j].entrySet()) { // 遍历前一行所有可能的涂色方案
                    int k = en.getKey(), val = en.getValue();
                    for (int v : s) { // 遍历当前行所有的 12 种涂色方案
                        if ((k & v) > 0) continue;
                        m[j].put(v, (int)((m[j].getOrDefault(v, 0) + val) % mod));
                    }
                }
            }
            long r = 0;
            for (Integer val : m[(n-1)%2].values()) 
                r = (r + val) % mod;
            return (int)r;
        }

        public int maxJumps(int[] a, int d) { // TODO TODO TODO: 这里还有点儿搞不清楚是怎么分析
            int n = a.length, j = 0;
            int [] f = new int [n];
            Arrays.fill(f, 1);
            Integer [] id = IntStream.range(0, n).boxed().toArray(Integer[]::new);
            Arrays.sort(id, (x, y)-> a[x] - a[y]);
            // for (int i : id) {
            for (int x = 0; x < n; x++) {
                int i = id[x];
                // System.out.println("\n i: " + i);
                // System.out.println("a[i]: " + a[i]);
                // j = x-1;
                // while (j >= 0 && i - id[j] <= d) {
                //     if (a[id[j]] >= a[id[j] + 1]) break;
                //     f[i] = Math.max(f[i], f[j] + 1);
                //     j--;
                // }
                j = i - 1;
                while (j >= 0 && i-j <= d) {
                    if (a[j] >= a[j+1]) break;
                    f[i] = Math.max(f[i], f[j] + 1);
                    j--;
                }
                j = i + 1;
                while (j < n && j <= i+d) {
                    if (a[j] >= a[j-1]) break; 
                    f[i] = Math.max(f[i], f[j] + 1);
                    j++;
                }
                // System.out.println(Arrays.toString(f));
            }
            // System.out.println(Arrays.toString(f));
            return Arrays.stream(f).max().getAsInt();
        }

        // 【字符串：】一系列题目
        public String longestPalindrome(String t) { // TODO TODO TODO: 找不到这是哪个题目了。。。 // TODO TODO TODO: 
            int n = t.length();
            char [] s = t.toCharArray();
            boolean [][] f = new boolean [n][n]; // 用来记录：片段【i,j】是否是回文
            for (int i = 0; i < n; i++) f[i][i] = true;
            int [][] dp = new int [n][n]; // 记长度
            for (int i = n-2; i >= 0; i--) 
                for (int j = i+1; j < n; j++) { // 这里有两个关于回文的限制条件：
                    if (s[i] == s[j]) // 【aa】【aba】【 a-bbcbb-a】
                        if (j - i <= 2 || f[i+1][j-1]) f[i][j] = true;
                }
        }

        public boolean checkPartitioning(String t) { // 【判断回文：O(1)】：这个一定要记牢了
            int n = t.length();
            char [] s = t.toCharArray();
            boolean [][] f = new boolean [n][n]; // 用来记录：片段【i,j】是否是回文
            for (int i = 0; i < n; i++) f[i][i] = true;
            // 先建【O(1)】判断是否回文的：这次回来刷，终于把这个想出来了。。。。。昨天没能投入。。。
            for (int i = n-2; i >= 0; i--) 
                for (int j = i+1; j < n; j++) // 这里有两个关于回文的限制条件：
                    if (s[i] == s[j] && (j - i <= 2 || f[i+1][j-1])) // 【aa】【aba】【 a-bbcbb-a】
                        f[i][j] = true;
            // 构建答案
            for (int i = 1; i <= n-2; i++) 
                if (f[0][i-1]) // 【0,i）
                    for (int j = i+1; j <= n-1; j++) // 【i,j）【j,n-1】
                        if (f[i][j-1] && f[j][n-1]) return true;
            return false;
        }

        public int longestPalindromeSubseq(String T) { // 【最长回文子序列：】想一下，同最普通两个串间的，最长公有子序列有什么不同？
            int n = T.length();
            char [] s = T.toCharArray(), t = new char [n];
            for (int i = 0; i < n; i++) t[i] = s[n-1-i];
            int [][] f = new int [n+1][n+1];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) 
                    if (s[i] == t[j]) f[i+1][j+1] = f[i][j] + 1;
                    else f[i+1][j+1] = Math.max(f[i][j+1], f[i+1][j]);
            return f[n][n];
        }


        public boolean isSubsequence(String S, String T) {
            int m = S.length(), n = T.length(), i = 0, j = 0;
            if (m > n) return false;
            char [] s = S.toCharArray();
            char [] t = T.toCharArray();
            while (i < m && j < n) {
                while (i < m && j < n && s[i] == t[j]) {
                    i++;
                    j++;
                }
                while (i < m && j < n && s[i] != t[j]) j++;
            }
            return i == m;
        }

        static final int mod = (int)1e9 + 7; // TODO TODO TODO: 
        public int countPalindromes(String t) {
            int n = t.length(), m = 10;
            char [] s = t.toCharArray();
            int r [] = new int [m], rr [][] = new int [m][m]; // 这里今天晚上的脑袋有点儿昏，计数的地方不知道计对了没有？二四八四
            // 向右向左遍历
            for (int i = n-1; i >= 0; i--) {
                int j = s[i] - '0';
                r[j]++;
                for (int k = 0; k < m; k++) // 从右向左，【J-Xk】
                    // rr[k][j] += r[j];
                    rr[k][j] ++;
            }
            long ans = 0;
            int l [] = new int [m], ll [][] = new int [m][m];
            for (int i = 0; i < n; i++) {
                int j = s[i] - '0';
                --r[j]; // 【撤销：】右边计数，取消所有【当前下标字符】所造成的影响。。。
                for (int k = 0; k < m; k++)
                    // rr[k][j] -= r[j];
                    rr[k][j] --;
                for (int x = 0; x < m; x++)
                    for (int y = 0; y < m; y++)
                        ans = (ans + (ll[x][y] * rr[x][y]) % mod) % mod;
                l[j]++;
                for (int k = 0; k < m; k++)
                    // ll[k][j] += l[j];
                    ll[k][j] ++;
            }
            return (int)ans;
        }

        public int distinctSubseqII(String t) { // 记不得了，大概意思是说，当将下标，要与不要，与前一个下标的生成关系？ 940
            int n = t.length();
            char [] s = t.toCharArray();
            int [] f = new int [n+1], g = new int [n+1];
            int [] p = new int [26];
            Arrays.fill(p, -1);
            f[0] = 1; // 要当前字符
            g[0] = 1; // 不要当前字符，去考虑有哪些重复? 努力回想呀。。。再想两天。。。
            for (int i = 0; i < n; i++) {
                if (p[s[i] - 'a'] == -1) p[s[i] - 'a'] = i;
            }
        }

        public int minInsertions(String T) {
            int n = T.length();
            char [] s = T.toCharArray();
            char [] t = new char [n];
            for (int i = 0; i < n; i++) t[i] = s[n-1-i];
            int [][] f = new int [n+1][n+1];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) 
                    if (s[i] == t[j]) f[i+1][j+1] = f[i][j] + 1;
                    else f[i+1][j+1] = Math.max(f[i+1][j], f[i][j+1]);
            return n - f[n][n];
        }


        public int minInsertions(String t) { // 1312: 这里好像要把它调个头，来找最长回文子序列，用现长 n －回文子序列长度 x.
            int n = t.length(); // 现不知道怎么求最长回文子序列长度。。。
        }

        public int palindromePartition(String t, int k) { // 这里，改字符：是改一个，长度不变，不变长不变短。。。所以狠简单
            n = t.length();
            s = t.toCharArray();
            for (int i = 0; i < n; i++)
                for (int j = i+1; j <= n; j++) {
                    String cur = t.substring(i, j);
                    if (!m.containsKey(cur)) m.put(cur, getCnt(cur));
                }
            // 动规：这里用动规最好，可是写不到，用深搜，带记忆的
            f = new Integer [n][k+1];
            Arrays.stream(f).forEach(z -> Arrays.fill(z, Integer.MAX_VALUE / 2));
            return dfs(0, k, t);
        }
        Map<String, Integer> m = new HashMap<>();
        Integer [][] f;
        char [] s;
        int n;
        int dfs(int i, int j, String t) {
            // if (i == n) return j == 0 ? 0 : Integer.MAX_VALUE / 2;
            if (i == n) return Integer.MAX_VALUE / 2;
            if (j == 1 && i < n) { // 【终止条件：】把这里当尾巴，上面当不合法解。。。
                String cur = t.substring(i);
                return f[i][j] = m.get(cur);
            }
            if (f[i][j] != Integer.MAX_VALUE / 2) return f[i][j];
            int r = Integer.MAX_VALUE / 2;
            for (int k = i+1; k <= n - (j-1); k++) {
                String cur = t.substring(i, k);
                r = Math.min(r, m.get(cur) + dfs(k, j-1, t));
            }
            return f[i][j] = r;
        }
        int getCnt(String t) {
            int n = t.length(), i = 0, j = n-1, r = 0;
            char [] s = t.toCharArray();
            while (i < j) 
                if (s[i++] != s[j--]) r++;
            return r;
        }

        public int maxPalindromes(String t, int k) { // TODO TODO TODO: 
            int n = t.length();
            char [] s = t.toCharArray();
            boolean [][] f = new boolean [n][n];
            for (int i = 0; i < n; i++) f[i][i] = true;
            for (int i = n-2; i >= 0; i--) 
                for (int j = i+1; j < n; j++) 
                    if (s[i] == s[j] && (j - i <= 2 || f[i+1][j-1]))
                        f[i][j] = true;
            int [] dp = new int [n];
            for (int i = 0; i+k <= n; i++)  // 这不对，不是说只有固定的 k 长，可以超过的。。。
                if (f[i][i+k-1]) dp[i+k-1] = (i == 0 ? 0 : dp[i-1]) + 1;
            // System.out.println(Arrays.toString(dp));
            return dp[n-1];
        }

        public int longestPalindrome(String S, String T) { // 1771: 提示二没有看懂。。。// TODO TODO TODO: 
            int m = S.length(), n = T.length(), mn = m + n;
            String st = new String(S + T);
            String ts = new String(T + S);
            char [] s = st.toCharArray();
            char [] t = ts.toCharArray();
            int [][] f = new int [mn+1][mn+1];
            int r = 0;
            for (int i = 0; i < mn; i++)
                for (int j = 0; j < mn; j++) {
                    if (s[i] == t[j]) f[i+1][j+1] = f[i][j] + 1;
                    else f[i+1][j+1] = Math.max(f[i+1][j], f[i][j+1]);
                    // // 这个判断非空的条件可能不对
                    // if (i < m && j >= m || j < n && i >= n) r = Math.max(r, f[i+1][j+1]);
                }
            return f[mn][mn];
            // return r;
        }

        public int minCost(int[] a, int[][] b, int m, int n, int k) { // k: k neighbourhoods // TODO TODO TODO: 不知道哪里写错了，明天再改这个 
            this.m = m;
            this.n = n;
            f = new Integer [m][n+1][k+1];
            int v = dfs(0, -1, k, a, b); 
            return v >= Integer.MAX_VALUE / 2 ? -1 : v;
        }
        int m, n;
       Integer [][][] f;
        int dfs(int i, int j, int k, int [] a, int [][] b) { // 这里J 是当作前一个房子的涂色吗？
            // if (k < 0) return Integer.MAX_VALUE / 2;
            if (i == m) return k == 0 ? 0 : Integer.MAX_VALUE / 2;
            if (j != -1 && f[i][j][k] != null) return f[i][j][k];
            if (k == 1 && i < m) { // 最后一个特殊情况要处理一下
                boolean painted = false;
                int p = -1;
                for (int x = i; x < m; x++) 
                    if (a[x] > 0) {
                        if (a[x] == j) return Integer.MAX_VALUE / 2; // 无法独立街区
                        if (!painted) {
                            painted = true;
                            p = a[x];
                        } else if (a[x] != p) return Integer.MAX_VALUE / 2; // 无法成同一涂色
                    }
                int r = Integer.MAX_VALUE / 2;
                for (int x = 1; x <= n; x++) {
                    if (x == j) continue; // 因为要独立出一个街区来
                    r = Math.min(r, b[i][x-1]);
                }
                return f[i][j][k] = r;
            }
            int r = Integer.MAX_VALUE / 2;
            if (a[i] > 0) r = Math.min(r, dfs(i+1, a[i], k - (j == -1 || a[i] == j ? 0 : 1), a, b));
            else { // 房子必须涂色
                for (int x = 1; x <= n; x++) { // 遍历这些种不同的涂色
                    int v = b[i][x-1] + dfs(i+1, x, k - (j == -1 || x == j ? 0 : 1), a, b);
                    r = Math.min(r, v);
                }
            }
            if (j == -1) return r;
            return f[i][j][k] = r;
        }

        static final int mod = (int)1e9 + 7;
        public int countVowelPermutation(int n) {
            Map<Integer, int []> m = new HashMap<>();
            m.put(0, new int [] {1});
            m.put(1, new int [] {0, 2});
            m.put(2, new int [] {0, 1, 3, 4});
            m.put(3, new int [] {2, 4});
            m.put(4, new int [] {0});
            int [][] f = new int [n][5];
            Arrays.fill(f[0], 1);
            for (int i = 0; i < n-1; i++) // 自顶向下动态更新
                for (int j = 0; j < 5; j++) 
                    for (int v : m.get(j)) {
                        f[i+1][v] += f[i][j];
                        f[i+1][v] %= mod;
                    }
            long r = 0;
            for (int v : f[n-1]) 
                r = (r + (long)v) % mod;
            return (int)r;
        }

        public int minFallingPathSum(int[][] a) {
            int n = a.length, min = Integer.MAX_VALUE;
            int [][] f = new int [n][n];
            Arrays.stream(f).forEach(z -> Arrays.fill(z, Integer.MAX_VALUE));
            for (int i = 0; i < n; i++) f[0][i] = a[0][i];
            for (int i = 0; i < n-1; i++) 
                for (int j = 0; j < n; j++) 
                    for (int k = 0; k < n; k++) {
                        if (j == k) continue;
                        f[i+1][k] = Math.min(f[i+1][k], f[i][j] + a[i+1][k]);
                    }
            return Arrays.stream(f[n-1]).min().getAsInt();
        }

        // 这个死题目：算出最长公有子序列之后，要用这个东西把最短XX 给还原回来。。。。。
        public String shortestCommonSupersequence(String S, String T) { // 1092
            int m = S.length(), n = T.length();
            char [] s = S.toCharArray();
            char [] t = T.toCharArray();
            int [][] f = new int [m+1][n+1];
            for (int i = 0; i < m; i++) 
                for (int j = 0; j < n; j++)
                    if (s[i] == t[j]) f[i+1][j+1] = f[i][j] + 1;
                    else f[i+1][j+1] = Math.max(f[i+1][j], f[i][j+1]);
            // 然后根据上面的统计结果，往回倒。。。。。妈的。。。
            // TODO TODO TODO: 
        }

        // 根下午那个题目相比：不是一模一样的吗？
        public int colorTheGrid(int m, int n) {// 1931
            Set<Integer> s = new HashSet<>();
            Map<Integer, Integer> [] m = new HashMap [2];
            // 【构建候选与第一行】与先前不同的地方在于，宽度不固定。那么因为选择少《＝5, 那么可以以不变应万变，把2 3 4 5 的候选集合全列出来备用。。。
            Set<Integer> [] s = new HashSet[5];
            Arrays.setAll(s, z -> new HashSet<>());
            s[0].add(List.of()); // ?
            s[1].add(List.of()); // 
            s[2].add(List.of());
            s[3].add(List.of());
            s[4].add(List.of());
            // 但还是探索一种新的解法吧【三维数组】
        }

        public int maxValue(int[][] a, int k) { // 1751: 这个可以写写。。。
            int n = a.length;
            Arrays.sort(a, (x, y) -> x[0] - y[0]);
            int [] f = new int [n];
            f[n-1] = a[n-1][2];
            for (int i = n-2; i >= 0; i--) {
        
            }
        }
    }
    public static void main (String[] args) {
        Solution s  =  new Solution ();

        // int [] a = new int [] {0, 0, 0, 0, 0};
        // int [] a = new int [] {0, 2, 1, 2, 0};
        // int [][] b = new int [][] {{1,10},{10,1},{10,1},{1,10},{5,1}};
        int [] a = new int [] {3, 1, 2, 3};
        int [][] b = new int [][] {{1,1,1},{1,1,1},{1,1,1},{1,1,1}};

        int r = s.minCost(a, b, 4, 3, 3);
        System.out.println("r: " + r);
    }
}
// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);
// TreeNode rr = new TreeNode(a[0]);
// rr.buildTree(rr, a);
// rr.levelPrintTree(rr);















































































































