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

        public int maxProfit(int[] a, int v) { // TODO TODO TODO: 714
            int n = a.length;
            int [] buy = new int [n], sell = new int [n];
            buy[0] = -a[0];
            for (int i = 1; i < n; i++) {
                sell[i] = a[i] + buy[i-1] - v; // 如果卖
                buy[i] = Math.max(a, b)
            }
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




