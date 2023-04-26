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
public class dpthree {
    public static class Solution {

// 【 n<= 500, 2^10】【 o<= 50, 2^6】【YN:2^2】【YN:2^2】【可以建一个 20 （10+6+2+2）位的 mask】1397
        public int findGoodStrings(int n, String S, String T, String E) { // 【哪里没有写对，上下字符的处理，与受限字符的处理，可能不对】// TODO TODO TODO: 
            this.n = n;
            m = E.length();
            s = S.toCharArray();
            t = T.toCharArray();
            e = E.toCharArray();
            return dfs(0, 0, true, true);
        }
        Map<Integer, Integer> f = new HashMap<>(); // 动规：记忆化用它，因为2^20=(int)1e6 数据规模有点儿大，但是是离散化的，用字典比较好
        static final int mod = (int)1e9 + 7;
        char [] s, t, e;
        int m, n;
        int dfs(int i, int j, boolean lo, boolean hi) {
            if (j == m) return 0; // 是说，包含了 evil 字符串为子串，【不合法】
            if (i == n) return j < m ? 1 : 0;
            int key = getKey(i, j, lo, hi);
            if (f.containsKey(key)) return f.get(key);
            // 遍历当前下标 i 所有【可能，且合法】的字符选择并深搜：受最小最大限制，且不能出现在不可出现的字符串
            int x = lo ? s[i] - 'a' : 0;   // 【等于S:】最小字符受限，
            int y = hi ? t[i] - 'a' : 25; // 【等于T:】最大字符受限
            // System.out.println("x: " + x);
            // System.out.println("y: " + y);
            long r = 0;
            for (int k = x; k <= y; k++) {
                // System.out.println("k: " + k);
                r = (r + (long)dfs(i+1, j + (k == e[j] - 'a' ? 1 : 0), lo && k == s[i] - 'a', hi && k == t[i] - 'a')) % mod;
                // System.out.println("r: " + r);
            }
            f.put(key, (int)r);
            return (int)r;
        }
        int getKey(int i, int j, boolean l, boolean r) {
            // return ((1 << i) << 10) | ((1 << j) << 4) | ((1 << (l ? 1 : 0)) << 2) | (1 << (r ? 1 : 0));
            return (1 << i) << 10 | (1 << j) << 4 | (1 << (l ? 1 : 0)) << 2 | 1 << (r ? 1 : 0); // 【没括号】
        }

        public int minimumTime(String t) { // 不知道这个题说的是什么意思 // TODO TODO TODO: 
            int n = t.length(), l [] = new int [n+1], r [] = new int [n+1], i = 0;
            char [] s = t.toCharArray();
            System.out.println(Arrays.toString(s));
            while (i < n && s[i] == '1' && (i == 0 || s[i-1] == '1')) {
                // System.out.println("i: " + i);
                l[i+1] = l[i] + 1;
                i++;
            }
            // System.out.println("i: " + i);
            for (; i < n; i++)
                if (s[i] == '1') l[i+1] = l[i] + 2;
                else l[i+1] = l[i];
            // System.out.println(Arrays.toString(l));
            i = n-1;
            while (i >= 0 && s[i] == '1') {
                r[i] = r[i+1] + 1;
                i--;
            }
            for (; i >= 0; i--) 
                if (s[i] == '1') r[i] = r[i+1] + 2;
                else r[i] = r[i+1];
            // System.out.println(Arrays.toString(r));
            int min = Integer.MAX_VALUE;
            for (i = 1; i < n; i++)  // 【 l: 0...n-2】
                min = Math.min(min, (l[i] + r[i]));
            min = Math.min(min, Math.min(l[n], r[0]));
            return min;
        }

        public int checkRecord(int n) {
            this.n = n;
            this.m = 2;
            f = new Integer [n][m][m+1]; // 【N, A, L】
            return dfs(0, 1, 0);
        }
        static final int mod = (int)1e9 + 7;
        int n, m;
        Integer [][][] f;
        int dfs(int i, int j, int k) {
            if (j < 0 || k >= 3) return 0;
            if (i == n) return j >= 0 && k <= 2 ? 1 : 0;
            if (f[i][j][k] != null) return f[i][j][k];
            long r = 0;
            r = (r + dfs(i+1, j, 0)) % mod; // present
            r = (r + dfs(i+1, j-1, 0)) % mod; // absent
            if (k <= 1)
                r = (r + dfs(i+1, j, k+1)) % mod; // Late for 1 more day
            return f[i][j][k] = (int)r;
        }

        public int stoneGameV(int[] a) {
            n = a.length;
            r = new int [n+1];
            for (int i = 0; i < n; i++) r[i+1] = r[i] + a[i];
            System.out.println(Arrays.toString(r));
            f = new Integer [n][n];
            return dfs(0, n-1, a);
        }
        Integer [][] f;
        int n;
        int [] r;
        int dfs(int i, int j, int [] a) {
            // if (i == j) return f[i][j] = a[i]; // 【BUG:】这里算多了
            if (i == j) return f[i][j] = 0;
            if (f[i][j] != null) return f[i][j];
            int ans = 0;
            for (int x = i; x < j; x++) { // 在 x】下标后分两段
                int left = r[x+1] - r[i];
                int right = r[j+1] - r[x+1];
                int min = Math.min(left, right);
                if (left != right) 
                    ans = Math.max(ans, min + (min == left ? dfs(i, x, a) : dfs(x+1, j, a)));
                else 
                    ans = Math.max(ans, min + Math.max(dfs(i, x, a), dfs(x+1, j, a)));
            } 
            return f[i][j] = ans;
        }

        public int maxHappyGroups(int m, int[] a) { // 这个不太好理解，好像带点儿贪心思想在里面。。。 // TODO TODO TODO: 
            this.m = m;
            n = a.length;
            Arrays.sort(a);
            backTracking(n-1, 0, new ArrayList<Integer>(), a);
            return max;
        }
        int n, m, max = 0;
        void backTracking(int i, int j, List<Integer> l, int [] a) {
            if (i < 0) {
                if (j > max) max = j;
                return ;
            }
        }

        public int tallestBillboard(int[] a) { // 这里，简单地分左右两半，在原数组有序的情况下，会丢掉最优解，错误答案。。。 // TODO TODO TODO: 
            int m = a.length, n = m / 2, max = 0;
            TreeSet<Integer> l = new TreeSet<>();
            for (int i = 1; i < (1 << n); i++) {
                int r = 0;
                for (int j = 0; j < n; j++) 
                    if (((i >> j) & 1) == 1) r += a[j];
                l.add(r);
            }
            for (int i = 1; i < (1 << (m - n)); i++) {
                int r = 0;
                for (int j = 0; j < m-n; j++) 
                    if (((i >> j) & 1) == 1)
                        r += a[n+j];
                if (l.contains(r)) max = Math.max(max, r);
            }
            return max;
        }

        class Node { // TODO TODO TODO: 55/58
            int s, ll, rr; // ll: maxLeft, rr: minRight: 主要是用来帮助父节点判断是否是 BST 来用来着。。。
            boolean b;
            Node l, r;
            public Node() {
                // l = new Node(); // 栈溢出
                // r = new Node();
            }
        }
        boolean allNeg = true;
        public int maxSumBST(TreeNode root) {
            Node r = new Node();
            traversal(root, r);
            if (allNeg) return 0;
            return getMax(r);
        }
        int max = 0;
        int getMax(Node r) {
            if (r == null) return 0;
            if (r.b) max = Math.max(max, r.s);
            return Math.max(max, Math.max(getMax(r.l), getMax(r.r)));
        }
        void traversal(TreeNode r, Node p) {
            if (r == null) {
                p.b = true;
                p = null; // <<<<<<<<<<<<<<<<<<<< 不起效？
                return ;
            }
            // System.out.println("\n r.val: " + r.val);
            if (r.val >= 0 && allNeg) allNeg = false;
            if (r.left == null && r.right == null) {
                p.s = r.val;
                p.b = true;
                p.ll = p.s; // 【叶子节点：】左右最值，是自己
                p.rr = p.s;
                return;
            }
            p.l = new Node();
            p.r = new Node();
            // p.l.b = true;
            // p.r.b = true;
            traversal(r.left, p.l);
            traversal(r.right, p.r);
            // System.out.println("\n r.val: " + r.val);
            p.s = p.l.s + p.r.s + r.val; // 左右子树，与父节点和
            // p.b = (p.l == null || p.l.b && p.l.ll < r.val) && (p.r == null || p.r.b && r.val < p.r.rr); // BST: 左中右，小大关系
            p.b = (p.l.b || p.l.s == 0) && (p.r.b || p.r.s == 0) && (p.l.ll == 0 || p.l.ll < r.val) && (p.r.rr == 0 || r.val < p.r.rr);
            // System.out.println("p.b: " + p.b);
            // System.out.println("p.s: " + p.s);
            p.ll = Math.max(p.l.ll, r.val); // 【这里不要更新到根节点】：
            // p.rr = Math.min(Math.min(p.l.ll, p.r.rr), r.val);
            p.rr = Math.min(p.r.rr, r.val);
            // p.rr = Math.min((p.r.s == 0 ? Integer.MAX_VALUE : p.r.rr), r.val);
        }

        public int maxSum(int[] a, int[] b) { // // TODO TODO TODO: 35/82 1537
            int m = a.length, n = b.length, i = 0, j = 0, x = -1, y = -1;
            long [] l = new long [m+1], r = new long [n+1];
            for ( i = 0; i < m; i++) l[i+1] = l[i] + a[i];
            for ( i = 0; i < n; i++) r[i+1] = r[i] + b[i];
            // System.out.println(Arrays.toString(l));
            // System.out.println(Arrays.toString(r));
            Map<Integer, List<Integer>> mi = new HashMap<>();
            i = 0; j = 0;
            while (i < m && j < n) {
                if (a[i] == b[j]) {
                    mi.put(a[i], List.of(i, j));
                    i++;
                    j++;
                } else if (a[i] < b[j]) i++;
                else j++;
            }
            // System.out.println("mi.size(): " + mi.size());
            // for (Map.Entry<Integer, List<Integer>> en : mi.entrySet()) {
            //     System.out.print(en.getKey() + ": ");
            //     System.out.println(Arrays.toString(en.getValue().toArray()));
            // }
            long ans = 0;
            i = 0; j = 0;
            for (Map.Entry<Integer, List<Integer>> en : mi.entrySet()) {
                int k = en.getKey();
                List<Integer> li = en.getValue();
                if (x == -1 && y == -1) {
                    x = li.get(0);
                    y = li.get(1);
                    ans = Math.max(l[x], r[y]); // 不带公共点
                } else {
                    ans += Math.max(l[li.get(0)] - l[x], r[li.get(1)] - r[y]); // 带一端公共点：带头，不带尾。。。
                    x = li.get(0);
                    y = li.get(1);
                }
            }
            if (x != -1 && y != -1)
                ans += Math.max(l[m] - l[x], r[n] - r[y]);
            else return (int)Math.max(l[m], r[n]);
            return (int)ans;
        }

        public boolean isScramble(String S, String T) {
            if (S.equals(T)) return true;
            int m = S.length(), n = T.length();
            char [] s = S.toCharArray();
            char [] t = T.toCharArray();
        }

        static final int mod = (int)1e9 + 7;
        int [][] dirs = {{-1, 0}, {0, -1}, {-1, -1}};
        public int[] pathsWithMaxScore(List<String> l) {
            int m = l.size(), n = l.get(0).length(), i = 0, j = 0;
            int [][] f = new int [m][n];
            Arrays.stream(f).forEach(z -> Arrays.fill(z, -1));
            f[m-1][n-1] = 0;
            long [][] r = new long [m][n];
            r[m-1][n-1] = 1;
            for (i = m-1; i >= 0; i--) 
                for (j = n-1; j >= 0; j--) {
                    if (f[i][j] == -1) continue;
                    char c = l.get(i).charAt(j);
                    if (c == 'X') continue;
                    if (c == 'S' || c != 'X' || c == 'E') {
                        for (int [] d : dirs) {
                            int x = i + d[0], y = j + d[1];
                            if (x < 0 || y < 0 || l.get(x).charAt(y) == 'X') continue;
                            int v = f[i][j] + (Character.isDigit(l.get(x).charAt(y)) ? l.get(x).charAt(y) - '0' : 0);
                            if (v > f[x][y]) {
                                f[x][y] = v;
                                r[x][y] = 1;
                            } else if (v == f[x][y])
                                r[x][y]++;
                            // else
                            //     r[x][y] = (r[x][y] + r[i][j]) % mod;
                        }
                    }
                }
            System.out.println("f.length: " + f.length);
            for (int z = 0; z < f.length; ++z) 
                System.out.println(Arrays.toString(f[z]));
            if (i < 0 && j < 0 && f[0][0] != -1) return new int [] {f[0][0], (int)r[0][0]};
            else return new int [] {0, 0};
        }
        List<String> a = List.of("E11345","X452XX","3X43X4","422812","284522","13422S"); // "E11","XXX","11S"

        public int maxPalindromes(String t, int k) { // TODO TODO TODO: 
            int n = t.length();
            char [] s = t.toCharArray();
            boolean [][] f = new boolean [n][n]; // 方便 O[1] 查询是否为回文
            for (int i = 0; i < n; i++) f[i][i] = true;
            for (int i = n-1; i >= 0; i--) 
                for (int j = i+1; j < n; j++) 
                    if (s[i] == s[j] && (j - i <= 2 || f[i+1][j-1]))
                        f[i][j] = true;
            int [] dp = new int [n];
            for (int i = k-1; i < n; i++) {
                if (i == k-1 && f[0][i]) {
                    dp[i] = 1;
                    continue;
                }
                for (int j = 0; j < i; j++) 
                    if (f[j+1][i] && (i - j - 1 >= k)) dp[i] = Math.max(dp[i], dp[j] + 1);
                dp[i] = Math.max(dp[i], dp[i-1]);
            }
            // System.out.println(Arrays.toString(dp));
            return dp[n-1];
        }

// 【记忆化深搜：】什么题用记忆，什么可以不用记忆，看来现在还是傻傻分不清楚。。【爱表哥，爱生活！！！活宝妹就是一定要嫁给亲爱的表哥！！！】
        public boolean hasValidPath(char[][] a) {
            this.a = a;
            m = a.length;
            n = a[0].length;
            f = new Boolean [m][n][m+n];
            return dfs(0, 0, 0, 0);
        }
        int [][] dirs = {{1, 0}, {0, 1}};
        Boolean [][][] f; 
     
        char [][] a;
        int m, n;
        boolean dfs(int x, int y, int l, int r) {
            if (x >= m || y >= n) return false;
            l += a[x][y] == '(' ? 1 : 0;
            r += a[x][y] == ')' ? 1 : 0;
            if (r > l) return false;
            if (f[x][y][l-r] != null) return f[x][y][l-r];
            if (x == m-1 && y == n-1 && l == r) return f[x][y][0] = true;
            if (dfs(x+1, y, l, r)) return f[x][y][l-r] = true;
            return f[x][y][l-r] = dfs(x, y+1, l, r);
        }

        public int maximumScore(int[] a, int[] b) { // 【注意记忆化数组降维：】原本用三维会内存溢出，用二维就可以了
            this.a = a; this.b = b;
            n = a.length; m = b.length;
            f = new Integer [n][m];
            return dfs(0, 0);
        }
        Integer [][] f;
        int [] a, b;
        int n, m;
        int dfs(int i, int j) {
            if (j == m) return 0;
            if (f[i][j] != null) return f[i][j];
            return f[i][j] = Math.max(a[i] * b[j] + dfs(i+1, j+1), a[n-(j-i)-1] * b[j] + dfs(i, j+1));
        }

        int [][] dirs = {{0, -1}, {-1, 0}}; // 思路可能想错了。。。
        public int calculateMinimumHP(int[][] a) {
            int m = a.length, n = a[0].length;
            int [][] f = new int [m][n];
            Arrays.stream(f).forEach(z -> Arrays.fill(z, Integer.MIN_VALUE / 2));
            f[m-1][n-1] = a[m-1][n-1];
            for (int i = m-1; i >= 0; i--) 
                for (int j = n-1; j >= 0; j--) {
                    if (f[i][j] == Integer.MIN_VALUE / 2) continue;
                    for (int [] d : dirs) {
                        int x = i + d[0], y = j + d[1];
                        if (x < 0 || y < 0) continue;
                        f[x][y] = Math.max(f[x][y], f[i][j] + a[x][y]);
                    }
                }
            return f[0][0] + 1;
        }

        public int minAbsDifference(int[] a, int goal) {
            n = a.length; m = n / 2; this.a = a;
            TreeSet<Integer> l = new TreeSet<>(), r = new TreeSet<>();
            backTracking(0, 0, m, l);
            backTracking(m, 0, n, r);
            int min = Integer.MAX_VALUE;
            for (int v : r) {
                Integer lo = l.floor(goal - v);
                Integer hi = l.ceiling(goal - v);
                if (lo != null) min = Math.min(min, Math.abs(lo + v - goal));
                if (hi != null) min = Math.min(min, Math.abs(hi + v - goal));
            }
            return min;
        }
        int [] a;
        int n, m;
        void backTracking(int i, int j, int end, TreeSet<Integer> l) {
            if (i == end) {
                l.add(j);
                return ;
            }
            backTracking(i+1, j + a[i], end, l);
            backTracking(i+1, j, end, l);
        }

        // 不知道怎么写；先走一遍，采最多的走，再走一遍，能采多少采多少？ // TODO TODO TODO: 
        public int cherryPickup(int[][] a) {
            int n = a.length;
            int [][] f = new int [n][n];
            Arrays.stream(f).forEach(z -> Arrays.fill(z, Integer.MIN_VALUE));
            f[0][0] = a[0][0];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) {
                    if (f[i][j] == Integer.MIN_VALUE) continue;
                    // 向下
                    if (j < n-1 && a[i][j+1] != -1) f[i][j+1] = Math.max(f[i][j+1], f[i][j] + a[i][j+1]);
                    // 向右
                    if (i < n-1 && a[i+1][j] != -1) f[i+1][j] = Math.max(f[i+1][j], f[i][j] + a[i+1][j]);
                }
            int ans = f[m-1][n-1];
            if (ans == Integer.MIN_VALUE) return 0;
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
            }
            return r;
        }

        public int minCut(String t) { // 最小切割数：那么每个回文子串，尽可能地最长。。。132 // TODO TODO TODO: 
            int n = t.length();
            char [] s = t.toCharArray();
            boolean [][] f = new boolean [n][n]; // 方便O[1] 查询是否为回文
            for (int i = 0; i < n; i++) f[i][i] = true;
            for (int i = n-2; i >= 0; i--)
                for (int j = i+1; j < n; j++)
                    if (s[i] == s[j] && (j - i <= 2 || f[i+1][j-1])) f[i][j] = true;
            int [][] r = new int [n][n]; // 统计最少切割等: 还是不知道怎么算最长回文。。。
            for (int i = 0; i < n; i++) r[0][i] = 1;
            for (int i = 0; i < n; i++) 
                for (int j = i+1; j < n; j++) {
                }
        }

        static final int mod = (int)1e9 + 7; // 注意数、计数的原理：生成与撤销的原理
        public int countPalindromes(String t) {
            int n = t.length(), m = 10;
            System.out.println("n: " + n);
            char [] s = t.toCharArray();
            int r [] = new int [m], rr [][] = new int [m][m]; // 这里今天晚上的脑袋有点儿昏，计数的地方不知道计对了没有？二四八四
            // 向右向左遍历
            for (int i = n-1; i >= 0; i--) {
                int j = s[i] - '0';
                for (int k = 0; k < m; k++) // 从左向右，【J-Xk】
                    rr[j][k] += r[k];
                r[j]++;
            }
            long ans = 0;
            int l [] = new int [m], ll [][] = new int [m][m];
            for (int i = 0; i < n; i++) {
                // 右侧更新：撤销所有由当前下标的结果，对后续统计造成的错误影响
                int j = s[i] - '0';
                --r[j]; // 【撤销：】右边计数，取消所有【当前下标字符】所造成的影响。。。
                for (int k = 0; k < m; k++) // 由当前 j 字符所计入的所有必要撤销
                    rr[j][k] -= r[k];
                for (int x = 0; x < m; x++)
                    for (int y = 0; y < m; y++)
                        ans = (ans + (long)ll[x][y] * (long)rr[x][y]) % mod;
                // 左侧更新：加入当前下标的结果入后续统计
                for (int k = 0; k < m; k++)
                    ll[j][k] += l[k];
                l[j]++;
            }
            return (int)ans;
        }

        public int minimumDifference(int[] a) {
            m = a.length; n = m / 2; this.a = a;
            l = new TreeSet [n+1]; r = new TreeSet [n+1];
            Arrays.setAll(l, z -> new TreeSet<>());
            Arrays.setAll(r, z -> new TreeSet<>());
            backTracking(0, 0, n, 0, l); // 生成左半边的所有可能的和
            backTracking(n, 0, m, 0, r);
            int min = Integer.MAX_VALUE, sum = Arrays.stream(a).sum(), half = sum / 2;
            for (int i = 0; i <= n; i++) {
                int j = n - i;
                if (i == 0) {
                    for (int v : l[j]) 
                        min = Math.min(min, Math.abs(sum - v * 2));
                    continue;
                }
                for (int right : r[i]) {
                    // for (int left : l[j]) min = Math.min(min, Math.abs(sum - (right + left) * 2)); // TLE TLE TLE: 这里不要暴力查找，二分查找提速
                    Integer lo = l[j].floor(half - right), hi = l[j].ceiling(half - right);
                    if (lo != null) min = Math.min(min, Math.abs(sum - (lo + right) * 2));
                    if (hi != null) min = Math.min(min, Math.abs(sum - (hi + right) * 2));
                }
            }
            return min;
        }
        int [] a;
        int m, n;
        TreeSet<Integer> [] l, r;
        void backTracking(int i, int cnt, int end, int sum, Set<Integer> [] l) {
            if (i == end) {
                if (cnt == 0) l[cnt].add(sum);
                else l[cnt].add(sum);
                return ;
            }
            backTracking(i+1, cnt+1, end, sum + a[i], l); // 包含当前数 a[i]
            backTracking(i+1, cnt, end, sum, l);          // 不包含当前数 a[i]
        }

        public boolean splitArraySameAverage(int[] a) { // 805
            this.a = a; sum = Arrays.stream(a).sum();
            n = a.length; m = n / 2 + n % 2; avg = sum / n;
            int max = Arrays.stream(a).max().getAsInt();
            if (n == 2) return a[0] == a[1];
            // if (max > avg) return false;
            // if (n % 2 != 0) return false;
            l = new TreeSet[m+1]; r = new TreeSet[m+1];
            Arrays.setAll(l, z -> new TreeSet<>()); Arrays.setAll(r, z -> new TreeSet<>());
             System.out.println("avg: " + avg);
            if (backTracking(0, m, 0, 0, l)) return true;
            System.out.println("0 avg: " + avg);
            if (backTracking(m, n, 0, 0, r)) return true;
            for (int i = 0; i <= m; i++) { // TODO TODO TODO: 这里的部分不知道错哪时了
                int j = m - i;
                for (int right : r[i]) {
                    if (right <= avg * m) {
                         Integer v = l[j].ceiling(avg * m - right);
                         Integer vv = l[j].floor(avg * m - right);
                         // if ((v != null || vv != null) && (i != 0 && j != 0 || (v != null ? v == avg * m : vv == avg * m))){
                         //     return true;
                         // }
                    }
                }
            }
            return false; 
        }
        TreeSet<Integer> [] l, r;
        int [] a;
        int m, n, avg, sum;
        boolean backTracking(int i, int end, int cur, int cnt, TreeSet<Integer> [] l) {
            if (i == end) {
                // if (cnt == m && cnt * avg == cur) return true;
                if (cnt > 0 && cnt * (sum - cur) == cur * (n - cnt)) {
                    System.out.println("cnt: " + cnt);
                    System.out.println("cur: " + cur);
                    return true;
                }
                l[cnt].add(cur);
                return false;
            }
            if (backTracking(i+1, end, cur + a[i], cnt+1, l)) return true;
            return backTracking(i+1, end, cur, cnt, l);
        }
        public boolean splitArraySameAverage(int[] a) {
            int n = a.length, m = n / 2 + n % 2, N = (1 << m);
            for (int i = 0; i < N; i++) {
                int cnt = Integer.bitCount(i);
            }
        }

        public boolean isMatch(String S, String T) { // 这个题的边边角角狠烦人。。。10 // TODO TODO TODO: 
            m = S.length(); n = T.length();
            s = s.toCharArray(); t = T.toCharArray();
            f = new Boolean [m][n];
            return dfs(0, 0);
        }
        char [] s, t;
        int m, n;
        Boolean [][] f;
        boolean dfs(int i, int j) {
            if (i == m && j == n) return true;
            if (f[i][j] != null) return f[i][j];
            if (i == m-1 && j == n-1)
                return f[i][j] = (s[i] == t[j] || t[j] == '.' || t[j] == '*');
            if (s[i] == t[j] || t[j] == '.') return f[i][j] = dfs(i+1, j+1);
            if (t[j] == '*')
        }

        public int longestValidParentheses(String t) { // TODO TODO TODO: 
            int n = t.length(), max = 1;
            char [] s = t.toCharArray();
            boolean [][] f = new boolean [m][n];
            for (int i = 0; i < n; i++) f[i][i] = true;
            for (int i = n-2; i >= 0; i--)
                for (int j = i+1; j < n; j++)
                    if (s[i] == s[j] && (j - i <=2 || f[i+1][j-1])) { // 这不对，不能套用
                        f[i][j] = true;
                        // max = Math.max(max, j - i + 1);
                    }
        }

        public int countPartitions(int[] a, int k) { // 2518 这个题目可能思路不太对
            int n = a.length; this.a = a;
            long sum = Arrays.stream(a).asLongStream().sum();
            if (sum < 2l * k) return 0;
            f = new Integer [n][k+1];
            return quickPow(2, n) - dfs(0, k) + 1;
        }
        static final int mod = (int)1e9 + 7;
        int [] a;
        Integer [][] f;
        int n;
        int dfs(int i, int j) { // sum < j
            if (i == n) return 0;
            if (j == 0) return f[i][j] = 0; // ？
            if (f[i][j] != null) return f[i][j];
            long r = dfs(i+1, j);
            if (a[i] <= j)
                r = (r + dfs(i+1, j - a[i])) % mod;
            return f[i][j] = (int)r;
        }
        int quickPow(int v, int n) {
            long r = 1;
            while (n > 0) {
                if (n % 2 == 1) {
                    r *= v;
                    r %= mod;
                }
                v *= v;
                n /= 2;
            }
            return (int)r;
        }

        public int[] countBits(int n) {
            int [] r = new int [n+1];
            for (int i = 0; i <= n; i++) 
                r[i] = Integer.bitCount(i);
            return r;
        }

        public int fib(int n) {
            if (n < 2) return n == 1 ? 1 : 0;
            int [] f = new int [n+1];
            f[1] = 1;
            for (int i = 2; i <= n; i++)
                f[i] = f[i-1] + f[i-2];
            return f[n];
        }

        public int tribonacci(int n) {
            if (n < 3) return n == 0 ? 0 : 1;
            int [] f = new int [n+1];
            f[1] = f[2] = 1;
            for (int i = 3; i <= n; i++)
                f[i] = f[i-3] + f[i-2] + f[i-1];
            return f[n];
        }

        public int minCostClimbingStairs(int[] a) {
            int n = a.length;
            int [] f = new int [n+1];
            f[n-1] = a[n-1];
            for (int i = n-2; i >= 0; i--)
                f[i] = a[i] + Math.min(f[i+1], f[i+2]);
            return Math.min(f[0], f[1]);
        }

         public List<Integer> getRow(int rowIndex) {
            List<List<Integer>> ll = generate(rowIndex+1);
            return ll.get(rowIndex);
        }
        public List<List<Integer>> generate(int n) {
            List<List<Integer>> ll = new ArrayList<>();
            for (int i = 0; i < n; i++) ll.add(new ArrayList<>());
            for (int i = 0; i < n; i++) {
                List<Integer> l = ll.get(i);
                for (int j = 0; j <= i; j++) l.add(1);
                if (i == 0) continue;
                for (int j = 1; j < l.size()-1; j++)
                    l.set(j, ll.get(i-1).get(j-1) + ll.get(i-1).get(j));
            }
            return ll;
        }

        public int maxProfit(int[] a) {
            int n = a.length, l [] = new int [n], r [] = new int [n], max = 0;
            l[0] = a[0]; r[n-1] = a[n-1];
            for (int i = 1; i < n; i++)
                l[i] = Math.min(l[i-1], a[i]);
            for (int i = n-2; i >= 0; i--)
                r[i] = Math.max(r[i+1], a[i]);
            for (int i = 1; i < n; i++) 
                max = Math.max(max, r[i] - l[i-1]);
            return max;
        }

        public int climbStairs(int n) {
            int [] f = new int [n+1];
            f[0] = f[1] = 1;
            for (int i = 2; i <= n; i++)
                f[i] = f[i-1] + f[i-2];
            return f[n];
        }

        public int getMaximumGenerated(int n) { // damit it ... // TODO TODO TODO: 
            if (n < 2) return n == 1 ? 1 : 0;
            int [] f = new int [n+1];
            f[1] = 1;
            for (int i = 1; i <= n/2; i++) 
                f[2 * i] = f[i];
            for (int i = 1; i <= (n - 1) / 2; i++) 
                f[2 * i + 1] = f[i] + f[i+1];
            return Arrays.stream(f).max().getAsInt();
        }

        public List<TreeNode> allPossibleFBT(int n) { // TODO TODO TODO: 894
            List<TreeNode> l = new ArrayList<>();
            l.add(new TreeNode());
            if (n % 2 == 0) return l;
            if (n == 1) {
                return l;
            }
            g = new ArrayList [n+1];
            Arrays.setAll(g, z -> new ArrayList<>());
            int i = 1;
            g[1] = l
            while (i < n) {
                g[i+2] = allPossibleFBT(g[i]);
                i += 2;
            }
            return g[n];
        }
        List<TreeNode> [] g;
        List<TreeNode> allPossibleFBT(List<TreeNode> ll) { // 3 ==> 5 要复制一遍，还得判断是否是一样的树；可是加两个叶子，怎么知道加哪里才好呢？
            List<TreeNode> rr = new ArrayList<>();
            for (TreeNode r : ll) {
                TreeNode p = 
            }
        }
        boolean isSame(TreeNode r, TreeNode p) { // 是否一样的树，狠简单
            if (r == null && p == null) return true;
            if (r == null || p == null) return false;
            return isSame(r.left, p.left) && isSame(r.right, p.right);
        }
        
        // TLE TLE TLE: 60/63, 大概数的时候，还是不需要改变一个，只数改一个的
        public int countSubstrings(String s, String t) {
            Node trie = new Node();
            int m = s.length(), n = t.length();
            for (int i = 0; i < n; i++)
                for (int j = i+1; j <= n; j++) 
                    insert(t.substring(i, j), trie);
            Map<String, Integer> ms = new HashMap<>();
            int r = 0;
            for (int i = 0; i < m; i++)
                for (int j = i+1; j <= m; j++) {
                    String cur = s.substring(i, j);
                    if (ms.containsKey(cur)) {
                        r += ms.get(cur);
                        continue;
                    }
                    int sum = 0;
                    for (int k = 0; k < cur.length(); k++) {
                        int idx = cur.charAt(k) - 'a';
                        for (int x = 0; x < 26; x++) {
                            if (x == idx) continue;
                            char c = (char)(x + 'a');
                            String curMade = (k == 0 ? "" : cur.substring(0, k)) + c + (k == cur.length()-1 ? "" : cur.substring(k+1));
                            int v = search(curMade, trie);
                            if (v > 0) {
                                r += v;
                                sum += v;
                            }
                        }
                    }
                    ms.put(cur, sum);
                }
            return r;
        }
        int search(String t, Node r) {
            int n = t.length();
            char [] s = t.toCharArray();
            for (int i = 0; i < n; i++) {
                int j = s[i] - 'a';
                if (r.c[j] == null) return 0;
                r = r.c[j];
            }
            return r.v;
        }
        void insert(String t, Node r) {
            int n = t.length();
            char [] s = t.toCharArray();
            for (int i = 0; i < n; i++) {
                int j = s[i] - 'a';
                if (r.c[j] == null) r.c[j] = new Node();
                r = r.c[j];
            }
            r.end = true;
            r.w = t;
            r.v++;
        }  
        class Node {
            Node [] c = new Node [26];
            boolean end;
            String w;
            int v; // cnt 计数个数
            Node() {}
        }
        public int countSubstrings(String S, String T) { // 【O(MN × min(M,N))】
            int m = S.length(), n = T.length();
            char [] s = S.toCharArray(), t = T.toCharArray();
            int ans = 0;
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++) {
                    int dif = 0;
                    for (int k = 0; i + k < m && j + k < n; k++) { // 这里还有个循环
                        dif += s[i+k] == t[j+k] ? 0 : 1;
                        if (dif > 1) break;
                        else if (dif == 1) ans++;
                    }
                }
            return ans;
        }
        public int countSubstrings(String S, String T) {
            int m = S.length(), n = T.length();
            char [] s = S.toCharArray(), t = T.toCharArray();
            int ans = 0;
            int [][] l = new int [m+1][n+1], r = new int [m+1][n+1];
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    if (s[i] == t[j]) l[i+1][j+1] = l[i][j] + 1;
            for (int i = m-1; i >= 0; i--) 
                for (int j = n-1; j >= 0; j--) 
                    if (s[i] == t[j]) r[i][j] = r[i+1][j+1] + 1;
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    if (s[i] != t[j]) ans += (l[i][j] + 1) * (r[i+1][j+1] + 1);
            return ans;
        }
        
        // public int maxSumAfterPartitioning(int[] a, int k) { // TODO TODO TODO: 脑袋昏昏。。。 1043
        //     int n = a.length, max = 0;
        //     int [] f = new int [n+1];
        //     f[1] = a[0];
        //     for (int i = 1; i < n; i++) {
        //         max = a[i];
        //         // max = 0;
        //         for (int j = 1; j <= k && i-k >= 0; j++) {
        //             max = Math.max(max, a[i-j]);
        //             f[i] = Math.max(f[i-j] + max * j, f[i]);
        //         }
        //     }
        //     return f[n-1];
        // }
        public int maxSumAfterPartitioning(int[] a, int k) { // 记忆化深搜：还是太好用了。。。
            this.a = a; n = a.length; this.k = k;
            f = new Integer [n];
            return dfs(0);
        }
        int [] a;
        int n, k;
        Integer []  f;
        int dfs(int i) {
            if (i == n) return 0;
            if (f[i] != null) return f[i];
            int r = 0, max = 0;
            for (int j = i; j < i+k && j < n; j++) { // 区间：【 i,j】包括 j
                max = Math.max(max, a[j]);
                r = Math.max(r, max * (j - i + 1) + dfs(j+1));
            }
            return f[i] = r;
        }

        public int twoEggDrop(int n) { // 1884 // TODO TODO TODO: 
            this.n = n; m = 2;
            f = new Integer [m][n+1];
            return dfs(0, 0);
        }
        int n, m;
        Integer [][] f;
        int dfs(int i, int j) {
            if (i == m) return Integer.MAX_VALUE / 2;
            if (f[i][j] != null) return f[i][j];
            int r = Integer.MAX_VALUE / 2;
        }

        public int getKth(int l, int h, int k) {
            f = new Integer [ 273227];
            f[2] = 1;
            for (int i = l; i <= h; i++)
                if (f[i] == null) dfsGetPow(i);
            Integer [] ids = IntStream.range(l, h+1).boxed().toArray(Integer[]::new);
            Arrays.sort(ids, (x, y) -> f[x] != f[y] ? f[x] - f[y] : x - y);
            return ids[k - 1];
        }
        Integer [] f;
        int dfsGetPow(int i) {
            if (i == 1) return f[i] = 0;
            if (f[i] != null) return f[i];
            if (i % 2 == 0) return f[i] = 1 + dfsGetPow(i / 2);
            else return f[i] = 1 + dfsGetPow(i * 3 + 1);
        }

        public int mctFromLeafValues(int[] a) {
            n = a.length; this.a = a;
            f = new Integer [n][n];
            return dfs(0, n-1);
        }
        int [] a;
        int n;
        Integer [][] f;
        int dfs(int i, int j) {
            if (i == j) return f[i][j] = 0;
            if (i + 1 == j) return f[i][j] = a[i] * a[j];
            if (f[i][j] != null) return f[i][j];
            int r = Integer.MAX_VALUE, max = 0, maxx = 0;
            for (int k = i; k < j; k++) {
                max = Math.max(max, a[k]);
                for (int x = k+1; x <= j; x++)
                    maxx = Math.max(maxx, a[x]);
                r = Math.min(r, max * maxx + dfs(i, k) + dfs(k+1, j));
            }
            return f[i][j] = r;
        }

        public int countSubstrings(String t) {
            int n = t.length(); char [] s = t.toCharArray();
            boolean [][] f = new boolean [n][n];
            for (int i = 0; i < n; i++) f[i][i] = true;
            int ans = n;
            for (int i = n-2; i >= 0; i--) 
                for (int j = i+1; j < n; j++) 
                    if (s[i] == s[j] && (j - i <= 2 || f[i+1][j-1])) {
                        f[i][j] = true;
                        ans++;
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
        int [] a = new int [] {1,4,6,7,8,20};
        int [] b = new int [] {7, 2, 15};

        public int maxProfit(int[] a, int v) { // TODO TODO TODO: 714
            int n = a.length;
            int [] buy = new int [n], sell = new int [n];
            buy[0] = -a[0];
            for (int i = 1; i < n; i++) {
                sell[i] = a[i] + buy[i-1] - v; // 如果卖
                buy[i] = Math.max(a, b)
            }
        }

        public int numberOfArithmeticSlices(int[] a) { // TODO TODO TODO: 
            int n = a.length, i = 1, j = 0, r = 0, d = a[1] - a[0];
            if (n == 1) return 0;
            while (i < n) {
                while (i < n-1 && a[i+1] - a[i] == d) i++;
                r++; // 数得不对。。。413
                ++i;
                if (i == n) return r;
                d = a[i] - a[i-1];
            }
            return r;
        }

        public int countArrangement(int n) {
            this.n = n;
            backTracking(0, new ArrayList<Integer>(), new boolean [n]);
            return ans;
        }
        int n, ans = 0;
        void backTracking(int i, List<Integer> l, boolean [] vis) {
            if (i == n) {
                if (l.size() == n) 
                    ans++;
                return ;
            }
            for (int j = 0; j < n; j++) {
                int v = j + 1, s = l.size();
                if (!vis[j] && (v % (s + 1) == 0 || (s+1) % v == 0)) {
                    l.add(v);
                    vis[j] = true;
                    backTracking(i+1, l, vis);
                    vis[j] = false;
                    l.remove(s);
                }
            }
        }

        public int waysToMakeFair(int[] a) { // 1664 // TODO TODO TODO: 
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
            // System.out.println(Arrays.toString(l));
            // System.out.println(Arrays.toString(r));
            int ans = 0, oddSum = (n % 2 == 0 ? l[n-1] : l[n-2]);
            int evnSum = (n % 2 == 0 ? r[n-2] : r[n-1]);
            for (int i = 0; i < n; i++) {
                // System.out.println("\n i: " + i);
                if (i == 0) {
                    if (evnSum - r[0] == oddSum) ans++;
                    continue;
                } else if (i == n-1) {
                    if (i % 2 == 0 && oddSum - l[n-1] == evnSum
                        || i % 2 == 1 && evnSum - r[n-1] == oddSum) ans++;
                    continue;
                } else {
                    if (i % 2 == 0 && r[i-2] + oddSum - l[i] == l[i] + evnSum - r[i]) ans++;
                    else if (i % 2 == 1 && l[i-1] + evnSum - r[i] == r[i] + oddSum - l[i]) ans++;
                }
            }
            return ans;
        }

        public int uniquePaths(int m, int n) { // 不知道写错在哪里，换
            this.m = m; this.n = n;
            dfs(0, 0);
            return r;
        }
        int [][] dirs = {{1, 0}, {0, 1}};
        int m, n;
        int r = 0;
        void dfs(int x, int y) {
            if (x < 0 || x >= m || y < 0 || y >= n) return ;
            if (x == m-1 && y == n-1) {
                r++;
                return ;
            }
            for (int [] d : dirs)
                dfs(x + d[0], y + d[1]);
        }
        public int uniquePaths(int m, int n) { // 这不是一下子就过了吗？脑袋怎么在想问题？
            int [][] f = new int [m][n];
            f[0][0] = 1;
            for (int j = 0; j < n; j++) f[0][j] = 1;
            for (int i = 0; i < m; i++) f[i][0] = 1;
            for (int i = 1; i < m; i++)
                for (int j = 1; j < n; j++) 
                    f[i][j] = f[i][j-1] + f[i-1][j];
            return f[m-1][n-1];
        }

        public int minFlipsMonoIncr(String t) {
            int n = t.length(), min = n;
            char [] s = t.toCharArray();
            int [] l = new int [n+1], r = new int [n+1];
            for (int i = 1; i <= n; i++)
                if (s[i-1] == '1') l[i] = l[i-1] + 1;
                else l[i] = l[i-1];
            for (int i = n-1; i >= 0; i--) 
                if (s[i] == '0') r[i] = r[i+1] + 1;
                else r[i] = r[i+1];
            for (int i = 1; i < n; i++) // 把片段分三段
                min = Math.min(min, l[i] + r[i+1]);
            return min;
        }

        public int maxCompatibilitySum(int[][] s, int[][] tt) {
            n = s.length; m = s[0].length;
            a = new int [n]; b = new int [n];
            int r = 0, t = 0;
            for (int i = 0; i < n; i++) {
                r = 0; t = 0;
                for (int j = 0; j < m; j++) {
                    if (s[i][j] == 1) r |= (1 << j);
                    if (tt[i][j] == 1) t |= (1 << j);
                }
                a[i] = r; b[i] = t;
            }
            backTracking(0, 0, new ArrayList<Integer>(), new boolean [n]);
            return max;
        }
        int [] a, b;
        int m, n, max = 0;
        void backTracking(int i, int j, List<Integer> l, boolean [] vis) {
            if (i == n) {
                if (j > max && l.size() == n) max = j;
                return ;
            }
            for (int k = 0; k < n; k++) { // n 个学生分给 n 个森头桩, 木头桩遍历过了吗？
                // if (k > 0 && b[k] == b[k-1]) continue; // 【不能加这句：】会过滤掉正确答案。。。
                if (!vis[k]) {
                    int v = getSameBitCnt(a[i], b[k]);
                    vis[k] = true;
                    l.add(v);
                    backTracking(i+1, j + v, l, vis);
                    l.remove(l.size()-1);
                    vis[k] = false;
                }
            }
        }
        int getSameBitCnt(int i, int j) {
            int r = 0;
            for (int k = 0; k < m; k++) 
                if (((i >> k) & 1) == ((j >> k) & 1)) r++;
            return r;
        }

        public int minDistance(String S, String T) {
            int m = S.length(), n = T.length();
            char [] s = S.toCharArray(), t = T.toCharArray();
            int [][] f = new int [m+1][n+1];
            for (int i = 1; i <= m; i++) 
                for (int j = 1; j <= n; j++) 
                    if (s[i-1] == t[j-1]) f[i][j] = f[i-1][j-1] + 1;
                    else f[i][j] = Math.max(f[i-1][j], f[i][j-1]);
            return m + n - f[m][n] * 2;
        }

        public int maxUncrossedLines(int[] a, int[] b ) {
            int m = a.length, n = b.length;
            int [][] f = new int [m+1][n+1];
            for (int i = m-1; i >= 0; i--) 
                for (int j = n-1; j >= 0; j--) 
                    if (a[i] == b[j]) f[i][j] = f[i+1][j+1] + 1;
                    else f[i][j] = Math.max(f[i+1][j], f[i][j+1]);
            return f[0][0];
        }

        public int minimumDeletions(String t) {
            int n = t.length(); char [] s = t.toCharArray();
            int [] l = new int [n+1], r = new int [n+1];
            for (int i = 0; i < n; i++)
                if (s[i] == 'b') l[i+1] = l[i] + 1;
                else l[i+1] = l[i];
            for (int i = n-1; i >= 0; i--)
                if (s[i] == 'a') r[i] = r[i+1] + 1;
                else r[i] = r[i+1];
            int ans = n;
            for (int i = 0; i < n; i++) 
                ans = Math.min(ans, l[i] + r[i+1]);
            return ans;
        }

        public int stoneGameVII(int[] a) {
            this.a = a; n = a.length;
            f = new Integer [n][n];
            return dfs(0, n-1, Arrays.stream(a).sum());
        }
        int [] a;
        int n;
        Integer [][] f;
        int dfs(int i, int j, int k) {
            if (i > j) return 0;
            if (f[i][j] != null) return f[i][j];
            int r = 0;
            return f[i][j] = Math.max(k - a[i] - dfs(i+1, j, k-a[i]), k - a[j] - dfs(i, j-1, k - a[j]));
        }

        public int findLongestChain(int[][] a) {
            int n = a.length;
            Arrays.sort(a, (x, y) -> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
            int [] f = new int [n];
            Arrays.fill(f, 1);
            for (int i = n-2; i >= 0; i--) {
                int u = a[i][0], v = a[i][1];
                for (int j = i+1; j < n; j++) {
                    int x = a[j][0], y = a[j][1];
                    if (x > v) f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            return Arrays.stream(f).max().getAsInt();
        }

        public int minScoreTriangulation(int[] a) { // 完全没能回想起来是怎么回事 // TODO TODO TODO: 
            this.a = a; n = a.length;
            f = new Integer [n][n];
            return dfs(0, n-1);
        }
        int [] a;
        int n;
        Integer [][] f;
        int dfs(int i, int j) {
            // System.out.println("\n i: " + i);
            // System.out.println("j: " + j);
            if (i > j) return 0;
            // if (j - i < 2) return 0;
            // if (i == j) return f[i][j] = a[i];
            if (i + 2 == j) return f[i][j] = a[i] * a[i+1] * a[j];
            if (i + 3 == j) return f[i][j] = Math.min(a[i] * a[i+1] * a[j] + a[j] * a[i+1] * a[j-1], a[i] * a[i+1] * a[j-1] + a[j-1] * a[j] * a[i]);
            if (f[i][j] != null) return f[i][j];
            int r = Integer.MAX_VALUE;
            for (int k = i; k <= j; k++) {
                // System.out.println("k: " + k);
                // r = Math.min(r, a[i] * a[k] * a[j] + dfs(i+1, k-1) + (k+2 == j ? a[k] * a[k+1] * a[j] : dfs(k+1, j-1)));
                r = Math.min(r, a[i] * a[k] * a[j] + dfs(i+1, k) + dfs(k+1, j));
                // System.out.println("r: " + r);
            }
            // System.out.println("\n i: " + i);
            // System.out.println("j: " + j);
            // System.out.println("r: " + r);
            return f[i][j] = r;
        }

        public List<TreeNode> generateTrees(int n) {
            List<TreeNode> l = generateTrees(1, n);
            return l;
        }
        List<TreeNode> generateTrees(int bgn, int end) {
            List<TreeNode> l = new ArrayList<>();
            if (bgn > end) {
                l.add(null);
                return l;
            }
            for (int i = bgn; i <= end; i++) { // 遍历根节点
                List<TreeNode> left = generateTrees(bgn, i-1);
                List<TreeNode> right = generateTrees(i+1, end);
                for (TreeNode ll : left)
                    for (TreeNode rr : right) {
                        TreeNode r = new TreeNode(i);
                        r.left = ll;
                        r.right = rr;
                        l.add(r);
                    }
            }
            return l;
        }

        public int lengthOfLIS(int[] a) {
            int n = a.length;
            int [] f = new int [n];
            Arrays.fill(f, 1);
            for (int i = 1; i < n; i++) 
                for (int j = i-1; j >= 0; j--) 
                    if (a[j] < a[i]) f[i] = Math.max(f[i], f[j] + 1);
            return Arrays.stream(f).max().getAsInt();
        }

        public int combinationSum4(int[] a, int t) { // 它有些地方要 * 2.... // TODO TODO TODO: 377
            n = a.length; this.a = a;
            Arrays.sort(a);
            f = new Integer [n][t+1];
            return dfs(n-1, t);
        }
        Integer [][] f;
        int [] a;
        int n;
        int dfs(int i, int j) {
            if (i < 0) return j == 0 ? 1 : 0;
            if (j == 0) return 1;
            if (f[i][j] != null) return f[i][j];
            int r = dfs(i-1, j);  // 不用当前的数
            if (a[i] > j) return f[i][j] = r;
            while (j - a[i] >= 0) {
                r += dfs(i-1, j - a[i]);
                j -= a[i];
            }
            return f[i][j] = r;
        }
    }
    public static void main (String[] args) { // 【爱表哥，爱生活！！！活宝妹就是一定要嫁给亲爱的表哥！！！】
        Solution s  =  new Solution ();
        int [] a = new int [] {1, 2, 3};

        int r = s.combinationSum4(a, 4);
        System.out.println("r: " + r);
    }
}
// ListNode head = new ListNode(a[0]); 
// head.buildList(head, a);
// head.printList(head);
// TreeNode rr = new TreeNode(a[0]);
// rr.buildTree(rr, a);
// rr.levelPrintTree(rr);











