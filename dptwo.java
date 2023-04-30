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

        public int cherryPickup(int[][] a) { // 【暴力解法：】不知道要怎么样才能再快一点儿呢？
            int m = a.length, n = a[0].length;
            int [][][] f = new int [m][n][n];
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    Arrays.fill(f[i][j], -1);
            f[0][0][n-1] = a[0][0] + a[0][n-1];
            for (int i = 0; i < m-1; i++) 
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) { // 这里注意处理： j == k 的情况：在一个格，只能取一次值【遍历上一行的【i,j】】
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

        public int maxValue(int[][] a, int k) { // 1751: 这个可以写写。。。
            int n = a.length;
            Arrays.sort(a, (x, y) -> x[0] - y[0]);
            int [] f = new int [n];
            f[n-1] = a[n-1][2];
            for (int i = n-2; i >= 0; i--) {
            }
        }

        static final int mod = (int)1e9 + 7; // 【动规：】试着用动规来写, 用动规还是写不到。。。
        public int waysToReachTarget(int t, int[][] a) { 
            n = a.length;
            this.t = t;
            f = new Integer [n][t+1];
            return dfs(0, t, a);
        }
        int n, t;
        Integer [][] f;
        int dfs(int i, int j, int [][] a) { // J: value left
            if (i == n) return j == 0 ? 1 : 0;
            if (j == 0) return i < n ? 1 : 0;
            if (f[i][j] != null) return f[i][j];
            long r = 0;
            int cnt = a[i][0], v = a[i][1];
            for (int k = 0; k <= cnt && k * v <= j; k++) 
                r = (r + dfs(i + 1, j - k * v, a)) % mod;
            return f[i][j] = (int)r;
        }
        
        static final int mod = (int)1e9 + 7;
        Set<Integer> s = new HashSet<>(); // 【活宝妹就是一定要嫁给亲爱的表哥！！！】
        public int numOfWays(int n) { // 刚刚摘桃子写了个多维数组，不想再写多维的。滚动数组。因为当前行结果只与前一行的结果相关
            Map<Integer, Integer> [] m = new HashMap[2]; // 滚动字典：要真的让它们可以滚动，才可以哟。。。【爱表哥，爱生活！！！】
            Arrays.setAll(m, z -> new HashMap<Integer, Integer>());
            // 构建每行的备选方案：12 种, 以及第一行的涂色【3 列】本题目所需要的
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
            // // 构建每行的备选方案：12 种, 以及第一行的涂色 【2,4 -5 列】下面一题借用的
            // for (int i = 0; i < 3; i++) {
            //     for (int j = 0; j < 3; j++) {
            //         if (j == i) continue;
            //         for (int k = 0; k < 3; k++) {
            //             if (k == j) continue;
            //             for (int x = 0; x < 3; x++) {
            //                 if (x == k) continue;
            //                 for (int y = 0; y < 3; y++) {
            //                     if (y == x) continue;
            //                     // int v = ((1 << i) << 3) | (1 << j);
            //                     int v = (((1 << i) << 12) | ((1 << j) << 9) | ((1 << k) << 6) | ((1 << x) << 3) | (1 << y));
            //                     s.add(v);
            //                     m[0].put(v, 1);
            //                 }
            //             }
            //         }
            //     }
            // }
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
        
        static final int mod = (int)1e9 + 7;
        public int colorTheGrid(int N, int n) {
            // 【构建候选与第一行】与先前不同的地方在于，宽度不固定。那么因为选择少《＝5, 那么可以以不变应万变，把2 3 4 5 的候选集合全列出来备用。。。
            Set<Integer> [] s = new HashSet[5]; // 【同一行】：任何相邻不同色
            // Arrays.setAll(s, z -> new HashSet<>());
            s[0]= new HashSet<>(List.of((1 << 0), (1 << 1), (1 << 2))); 
            s[1]= new HashSet<>(List.of(17, 33, 34, 20, 10, 12)); // 6 种
            s[2]= new HashSet<>(List.of(81, 97, 161, 273, 98, 162, 84, 276, 138, 266, 140, 268)); // 12 种
            s[3]= new HashSet<>(List.of(673, 1121, 2145, 2209, 674, 1122, 2146, 2210, 650, 778, 1290, 2186, 652, 780, 1292, 2188, 785, 1105, 1297, 2129, 788, 1108, 1300, 2132)); // 24 种 
            s[4]= new HashSet<>(List.of(5386, 6282, 8842, 8970, 10378, 17034, 17162, 17674, 5388, 6284, 8844, 8972, 10380, 17036, 17164, 17676, 5201, 5393, 6225, 8977, 10321, 17169, 17489, 17681, 5204, 5396, 6228, 8980, 10324, 17172, 17492, 17684, 5217, 6241, 6305, 8865, 10337, 10401, 17057, 17505, 5218, 6242, 6306, 8866, 10338, 10402, 17058, 17506)); // 48 种
            // 但还是探索一种新的解法吧【三维数组】: 暂时不写这个方法。用滚动数组先把这个题快速滚过去。。。
            Map<Integer, Integer> [] m = new HashMap[2];
            Arrays.setAll(m, z -> new HashMap<>());
            for (int v : s[N-1]) m[0].put(v, 1); // 初始化字典，以及第一行的涂色
            for (int i = 1; i < n; i++) { // 【2,n-1】行的涂色方案: 遍历每一行
                int j = i % 2;
                m[j].clear();
                for (Map.Entry<Integer, Integer> en : m[1-j].entrySet()) { // 遍历上一行的所有的涂色方案，来更新当前行可行的涂色方案数
                    int k = en.getKey(), v = en.getValue();
                    for (int mask : s[N-1]) // 遍历当前行所有的，可行的涂色方案
                        if ((k & mask) == 0) // 【保证：】上下行之间，任何一列不同色
                            m[j].put(mask, (int)((long)m[j].getOrDefault(mask, 0) + (long)v) % mod);
                }
            }
            long r = 0;
            for (Integer val : m[(n-1) % 2].values())
                r = (r + (long)val) % mod;
            return (int)r;
        }

        public int maxCoins(int[] a) { // 【区间型动规：】可是忘记了，是怎么回事？ 312
            n = a.length;
        }
        int n;

        public int minCost(int n, int[] a) { // 不知道这个死题目说的是什么意思，。。。1547
            Arrays.sort(a);
            m = a.length;
            f = new Integer [n+1][n+1][m]; // 每个木头块的首尾下标，被拒木头的长度有关系
            return dfs(0, n, 0, a); // 【i,j】木头首尾下标， k 当前遍历数组下标【区间型动规】：这个写法可能不对，再想一两天。。。
        }
        int m;
        Integer [][][] f;
        int dfs(int i, int j, int k, int [] a) {
        }        

        static final int mod = (int)1e9 + 7;
        public int countRoutes(int[] a, int l, int r, int v) { // 这个狠简单，机械写作。。。
            n = a.length;
            this.v = v;
            this.r = r;
            f = new Integer [n][v+1];
            return dfs(l, v, a);
        }
        int n, r, v;
        Integer [][] f;
        int dfs(int i, int j, int [] a) {
            if (j == 0) return f[i][j] = (i == r ? 1 : 0); // 当没有油的时候，是在终点站吗？
            if (f[i][j] != null) return f[i][j];
            long ans = 0;
            // 过程中，只要路过终点，哪怕还有油，也是算的。。。
            System.out.println("(i == r): " + (i == r));
            if (i == r) ans = (ans + 1) % mod; // 可是不知道，这步，写对了没有？
            // for (int k = 0; k < n && Math.abs(a[k] - a[i]) <= v; k++) { // 【BUGGLY CODING:】不能把限制条件这放里，会阻断选择。。。
            for (int k = 0; k < n; k++) {
                if (k == i || Math.abs(a[k] - a[i]) > j) continue;
                ans = (ans + dfs(k, j - Math.abs(a[k] - a[i]), a)) % mod;
            }
            return f[i][j] = (int)ans;
        }

        public long appealSum(String t) {
            int n = t.length();
            char [] s = t.toCharArray();
            int [] r = new int [26]; // last occurance idx
            long ans = 0;
            Arrays.fill(r, -1);
            for (int i = 0; i < n; i++) {
                int j = s[i] - 'a';
                r[j] = i;
                for (int k = 0; k < 26; k++)
                    // if (r[k] != -1)
                        ans = ans + 1l + (long)r[k];
            }
            return ans;
        }

        // 【总结：】相对特殊的地方在于，需要根据先前已经涂过色的房子来确定需要涂的街区数【亲爱的表哥的房子也涂色了，希望能够尽快嫁给亲爱的表哥！！！】
        public int minCost(int[] a, int[][] b, int m, int n, int k) { // k: k neighbourhoods
            this.m = m;
            this.n = n;
            f = new Integer [m][n+1][k+1]; // 【房子数】【涂色数】【街区数】
            int v = dfs(0, 0, k, a, b); // 这里初始化的 j, 就是点位符，为什么弄个 -1 给自己找不痛快呢？ 
            return v >= Integer.MAX_VALUE / 2 ? -1 : v;
        }
        int m, n;
       Integer [][][] f;
        int dfs(int i, int j, int k, int [] a, int [][] b) { // 这里J 是当作前一个房子的涂色吗？
            if (i == m) return k == 0 ? 0 : Integer.MAX_VALUE / 2;
            if (k == 0) { // i < m: 把剩余的房子全涂成跟之前一个同一个街区
                int ans = 0;
                for (int x = i; x < m; x++) {
                    if (a[x] > 0 && a[x] != j) return f[i][j][k] = Integer.MAX_VALUE / 2;
                    if (a[x] == 0)
                        ans += b[x][j-1];
                }
                return f[i][j][k] = ans;
            }
            if (f[i][j][k] != null) return f[i][j][k];
            int r = Integer.MAX_VALUE / 2;
            // if (a[i] > 0) r = Math.min(r, dfs(i+1, a[i], k - (j == 0 || a[i] == j ? 0 : 1), a, b));
            if (a[i] > 0) r = Math.min(r, dfs(i+1, a[i], k - (a[i] == j ? 0 : 1), a, b));
            else { // 房子必须涂色
                for (int x = 1; x <= n; x++) { // 遍历这些种不同的涂色
                    // int v = b[i][x-1] + dfs(i+1, x, k - (j == 0 || x == j ? 0 : 1), a, b);
                    int v = b[i][x-1] + dfs(i+1, x, k - (x == j ? 0 : 1), a, b);
                    r = Math.min(r, v);
                }
            }
            return f[i][j][k] = r; 
        }

        public int rearrangeSticks(int n, int k) { // 【动规：】这些都成了需要严格动规的题目。。。// TODO TODO TODO: 
            int [][] f = new int [n+1][k+1];
            f[0][0] = 1; // 初始化
            // 去找状态转移方程： f【i】【j】：前 i 个下标可以看见 j 根竹子，那么就去想，第 i 个下标的第 j 根可见筷子可以如何生成呢？第 i 个下标【可见】或是【不可见】
            // 这里， n 根筷子，哪些用去了，哪些没用去的关系，还没能想清楚。。【活宝妹就是一定要嫁给亲爱的表哥！！！】
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= k; j++) 
                    f[i][j] = f[i-1][j] + f[i-1][j-1];
            return f[n-1][k];
        }

        public int minDistance(String S, String T) { // 72: 这个思路好像不太对。。// TODO TODO TODO: 
            int m = S.length(), n = T.length();
            char [] s = S.toCharArray();
            char [] t = T.toCharArray();
            int [][] f = new int [m+1][n+1];
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    if (s[i] == t[j]) f[i+1][j+1] = f[i][j] + 1;
                    else f[i+1][j+1] = Math.max(f[i+1][j], f[i][j+1]);
            System.out.println("f[m][n]: " + f[m][n]);
            return Math.max(m - f[m][n], n - f[m][n]);
        }

        // 两个思路：【DFS 记忆化深搜】 || 【二分查找，并验证答案的正确性？】
        public int splitArray(int[] a, int k) { // 不知道为什么这么慢。过了
            n = a.length;
            s = new int [n+1];
            for (int i = 0; i < n; i++) s[i+1] = s[i] + a[i];
            f = new Integer [n][k+1];
            return dfs(0, k, a);
        }
        int n, min = Integer.MAX_VALUE;
        int [] s;
        Integer [][] f;
        int dfs(int i, int j, int [] a) {
            if (f[i][j] != null) return f[i][j];
            if (j == 1) // 剩下的所有的坐标，为一段子数组
                return f[i][j] = s[n] - s[i];
            int r = Integer.MAX_VALUE;
            for (int k = i; k < n - (j-1); k++) 
                r = Math.min(r, Math.max(s[k+1] - s[i], dfs(k+1, j-1, a)));
            return f[i][j] = r;
        }

        public int jobScheduling(int[] a, int[] b, int[] c) { // 不太喜欢这个二分查找，好像找得还有些问题 1235
            int n = a.length;
            List<int []> l = new ArrayList<>();
            for (int i = 0; i < n; i++) l.add(new int [] {a[i], b[i], c[i]});
            Collections.sort(l, (x, y) -> x[0] != y[0] ? x[0]- y[0] : y[2] - x[2]); // 开始时间升序
            int [] f = new int [n];
            f[n-1] = l.get(n-1)[2];
            // 这里说，用二分查找的方法，找到排序后，后序事件的下标。【但凡可以二分查找的地方，都可以线段树！！】
            for (int i = n-2; i >= 0; i--) {
                System.out.println("\n i: " + i);
                f[i] += l.get(i)[2];
                int j = binarySearch(i+1, n-1, l.get(i)[1], l);
                System.out.println("j: " + j);
                // if (j < n) f[i] += f[j];
                int k = j+1;
                while (k < n && l.get(k)[0] == l.get(j)[0]) {
                    f[i] = Math.max(f[i], f[j] + l.get(i)[2]);
                    k++;
                }
                System.out.println("f[i]: " + f[i]);
            }
            System.out.println(Arrays.toString(f));
            return f[0];
        }
        int binarySearch(int l, int r, int v, List<int []> ll) {
            while (l <= r) {
                int m = (l + r) >> 1;
                int bgn = ll.get(m)[0];
                if (bgn >= v) r= m;
                else l = m+1;
            }
            return l;
        }

        public int minDistance(int[] a, int k) { // 【记忆化深搜】: 用一个什么中位数？方法大致知道，具体中位数在这里的实现，忘记了 // TODO TODO TODO: 
            n = a.length;
            f = new Integer [n][k+1];
            return dfs(0, k, a);
        }
        Integer [][] f;
        int n;
        int dfs(int i, int j, int [] a) { 
            if (i == n) return j == 0 ? 0 : Integer.MAX_VALUE / 2;
            if (f[i][j] != null) return f[i][j];
        }

        public int longestIncreasingPath(int[][] a) {
            int [][] dirs = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
            int m = a.length, n = a[0].length;
            int [][] f = new int [m][n];
            Arrays.stream(f).forEach(z -> Arrays.fill(z, 1));
            Integer [] r = IntStream.range(0, m*n).boxed().toArray(Integer[]::new);
            Arrays.sort(r, (x, y)-> a[x/n][x%n] - a[y/n][y%n]);
            for (int w = 0; w < m*n; w++) {
                int idx = r[w], i = idx / n, j = idx % n;
                for (int [] d : dirs) {
                    int x = i + d[0], y = j + d[1];
                    if (x < 0 || x >= m || y < 0 || y >= n) continue;
                    if (a[x][y] > a[i][j])
                        f[x][y] = Math.max(f[x][y], f[i][j] + 1);
                }
            }
            int max = 1;
            for (int i = 0; i < m; i++) 
                for (int j = 0; j < n; j++)
                    max = Math.max(max, f[i][j]);
            return max;
        }

        public int largestPathValue(String t, int[][] egs) { // 【拓朴排序：】这个快要忘记光了。。。1857
            int n = t.length(), m = egs.length;
            // 【建图，统计入度】
            int [] r = new int [n]; // 统计：各节点【入度】
            List<Integer> [] g = new ArrayList[n];
            Arrays.setAll(g, z -> new ArrayList<>());
            for (int [] e : egs) {
                int u = e[0], v = e[1];
                r[v]++;
                g[u].add(v);
            }
            // 【判断环的存在与否】：根据入度中【？？】的个数或是奇偶性？来一步判断某计数，决定有环返回？【忘记了。。。】
            // 【拓朴排序】：是怎么排序的？怎么忘记得一干二净？构建必要的【动规数组等】数据结构，准备统计结果
            int [][] f = new int [n][26];
            Deque<Integer> q = new ArrayDeque<>();
            for (int i = 0; i < n; i++)
                if (r[i] == 0) {
                    q.offerFirst(i);
                    for (int v : g[i]) {
                        r[v]--;
                        if (r[v] == 0) q.offerFirst(v);
                    }
                }
            // 【出队列：】同步动态更新结果, 这里有点儿连不起来了，改天再写。。。
            while (!q.isEmpty()) {
                int u = q.pollLast();
            }
        }

        static final int mod = (int)1e9 + 7;
        public int numMusicPlaylists(int n, int g, int k) { // 【动规：】没消化透的动规, 【不知道是初始化，还是状态转移，嘯里写得不对】 // TODO TODO TODO: 920
            //f[i][j]:f【 n+1,goal+1】：从前 i 首歌里播放第 j 首：分第 i 首是选择【放过的】，和【不曾放过的】构成为第 j 首歌
            int [][] f = new int [n+1][g+1];
            f[0][0] = 1; // 空集，只有一种可能性
            for (int i = 0; i < n; i++) f[i][0] = 1; // 每首放第一遍都是一种可能性
            for (int i = 1; i <= n; i++) 
                for (int j = 1; j <= g; j++) // 从（ n-i）首不曾放过的选一首新的， + 从 i 首里先符合标准的
                    f[i][j] = ((n - i) * f[i-1][j-1] + (j >= k+1 ? f[i][j-(k+1)] : 0)) % mod;
            return (int)f[n-1][g];
        }

        public int maxSizeSlices(int[] a) { // 【动规：】不会写动规，写深搜
            n = a.length;
            m = n / 3;
            f = new Integer [n][n][m+1];
            return Math.max(dfs(0, n-2, m, a), dfs(1, n-1, m, a));
        }
        int n, m;
        Integer [][][] f;
        int dfs(int i, int j, int k, int [] a) {
            if (i > j || k <= 0) return 0;
            if (f[i][j][k] != null) return f[i][j][k];
            int r = 0;
            if (i == j && k == 1) return f[i][j][k] = a[i];
            r = Math.max(r, dfs(i+2, j, k-1, a) + a[i]);
            r = Math.max(r, dfs(i+1, j, k, a));
            return f[i][j][k] = r;
        }

        public int numSquarefulPerms(int[] a) { // TODO TODO TODO: 996
            Arrays.sort(a);
            n = a.length;
            backTracking(0, new ArrayList<Integer>(), a);
            return r * 2;
        }
        int n, r = 0;
        void backTracking(int u, List<Integer> l, int [] a) {
            if (l.size() >= 2) 
                if (!check(l)) return ;
            if (u == n) {
                if (l.size() == n) {
                    r++;
                }
                return ;
            }
            l.add(a[u]);
            backTracking(u+1, l, a);
            l.remove(l.size()-1);
            backTracking(u+1, l, a);
        }
        boolean check(List<Integer> l) {
            int r = l.get(l.size()-1) + l.get(l.size()-2);
            return isSquare(r);
        }
        boolean isSquare(int v) {
            int sr = (int)Math.sqrt(v);
            return sr * sr == v;
        }

        // 【动规：】用动规先找出三段的和的最大值，仍然一旦扫到最大值就退出。或是说动规找到最大值后，根据住处，再把下标倒出来？？？
        public int [] maxSumOfThreeSubarrays(int[] a, int l) { // 这是最土的暴力解法，怎么优化呢？ // TLE TLE TLE: 34/43
            int n = a.length, ans [] = new int [3]; 
            long [] r = new long [n+1];
            for (int i = 0; i < n; i++) r[i+1] = r[i] + a[i];
            long left, mid, rit, max = 0;
            for (int i = 0; i < n - 2 * l; i++) {
                left = r[i+l] - r[i];
                for (int j = i+l; j <= n-2 *l; j++) {
                    mid = r[j+l] - r[j];
                    for (int k = j+l; k+l <= n; k++) {
                        rit = r[k+l] - r[k];
                        if (left + mid + rit > max) {
                            max = left + mid + rit;
                            ans[0] = i;
                            ans[1] = j;
                            ans[2] = k;
                        }
                    }
                }
            }
            return ans; 
        }

        public int dieSimulator(int n, int[] a) { // 1223
            this.n = n;
            m = 7;
            k = 15;
            f = new Integer [n][m][k+1];
            return dfs(0, 0, 0, a);
        }
        int n, m, k;
        Integer [][][] f;
        int dfs(int i, int j, int k, int [] a) {
        }

        public int maximumANDSum(int[] a, int m) { // 需要考虑，对数组中重复数字的处理【可能要换个方法写】 // TODO TODO TODO: 
            this.m = m;
            n = a.length;
            g = new ArrayList [m];
            Arrays.setAll(g, z -> new ArrayList<Integer>());
            Arrays.sort(a);
            System.out.println(Arrays.toString(a));
            backTracking(n-1, 0, a);
            return max;
        }
        int n, m, max = 0;
        List<Integer> [] g;
        void backTracking(int i, int cur, int [] a) {
            if (i < 0) {
                if (cur > max) max = cur;
                return ;
            }
            // while (i > 0 && a[i] == a[i-1]) i++;
            for (int k = 0; k < m; k++) {
                List<Integer> l = g[k];
                if (l.size() < 2) {
                    l.add(a[i]);
                    backTracking(i-1, cur + (a[i] & (k+1)), a);
                    l.remove(l.size()-1);
                }
            }
        }

        public int constrainedSubsetSum(int[] a, int k) {
            int n = a.length, max = a[0];
            int [] f = new int [n];
            f[0] = a[0];
            Queue<Integer> q = new PriorityQueue<>((x, y)-> f[y] - f[x]);
            q.offer(0);
            for (int i = 1; i < n; i++) {
                while (!q.isEmpty() && q.peek() < i-k) q.poll();
                f[i] = a[i] + Math.max(0, f[q.peek()]);
                q.offer(i);
                max = Math.max(max, f[i]);
            }
            return max;
        }

        static final int mod = (int)1e9 + 7;
        int [][] dirs = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        public int countPaths(int[][] a) {
            int m = a.length, n = a[0].length, k = m  * n;
            long [][] f = new long [m][n];
            Arrays.stream(f).forEach(z -> Arrays.fill(z, 1));
            Integer [] r = IntStream.range(0, k).boxed().toArray(Integer[]::new);
            Arrays.sort(r, (x, y) -> a[x/n][x%n] != a[y/n][y%n] ? a[x/n][x%n] - a[y/n][y%n] : x - y);
            for (int w = 0; w < k; w++) {
                int i = r[w] / n, j = r[w] % n;
                // dfs(i, j, a);
                for (int [] d : dirs) {
                    int x = i + d[0], y = j + d[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || a[x][y] <= a[i][j]) continue;
                    // f[x][y] = Math.max(f[x][y], f[i][j] + 1);
                    if (f[x][y] == 1)
                        f[x][y] = (f[i][j] + 1) % mod;
                    else f[x][y] =  (f[i][j] + f[x][y]) % mod;
                }
            }
            long ans = 0;
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++) 
                ans = (ans + f[i][j]) % mod;
            return (int)ans;
        }

        public int minTaps(int n, int[] a) { // TODO TODO TODO: 暂时不想再写这个题目了
            int m = a.length;
            List<int []> l = new ArrayList<>();
            for (int i = 0; i < m; i++) 
                l.add(new int [] {i - a[i], i + a[i]});
            Collections.sort(l, (x, y) -> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
            int ans = 1, i = 1, r = l.get(0)[1], newRit = 0;
            while (r < n) {
                int [] cur = l.get(i);
                int j = i;
                while (l.get(j)[0] == cur[0]) {
                    r = Math.max(r, l.get(j)[1]);
                    j++;
                }
                if (l.get(j)[0] > r) return -1;
                ans++;
                newRit = r;
                while (l.get(j)[0] <= r) {
                    newRit = Math.max(newRit, l.get(j)[1]);
                    j++;
                }                
                r = newRit;
                if (r >= n) return ans;
            }
            return -1;
        }

        public long minimumDifference(int[] a) { // TODO TODO TODO: 
            int m = a.length, n = m / 3;
            long [] p = new long [m+1], l = new long [m], r = new long [m]; // 算中间一段的左 n 个数的最小和，与右 n 个数的最大和
            for (int i = 0; i < m; i++) p[i+1] = a[i] + p[i];
        }

        public int connectTwoGroups(List<List<Integer>> ll) { // 我记得我当初写过这个题目，忘记了
            m = ll.size();
            n = ll.get(0).size();
            f = new int [m][1 << n];
            return dfs(0, 0, ll);
        }
        int m, n;
        int [][] f;
        int dfs(int i, int j, List<List<Integer>> ll) {
        }

        public int maxScore(int[] a) { // TLE TLE TLE: 
            n = a.length;
            m = n / 2;
            g = new ArrayList [m];
            Arrays.setAll(g, z -> new ArrayList<Integer>());
            Arrays.sort(a);
            for (int i = 0; i < n; i++)
                for (int j = i+1; j < n; j++) {
                    int x = a[i], y = a[j], g = gcd(x, y);
                    String k = String.valueOf(x) + String.valueOf(y);
                    mg.put(k, g);
                }
            backTracking(0, 0, a);
            return max;
        }
        int n, m, max = 0;
        List<Integer> [] g;
        Map<String, Integer> mg = new HashMap<>();
        void backTracking(int i, int cur, int [] a) {
            if (i == n) {
                if (cur > max) max = cur;
                return ;
            }
            for (int k = 0; k < m; k++) {
                List<Integer> l = g[k];
                if (l.size() < 2) {
                    l.add(a[i]);
                    // backTracking(i+1, cur + (l.size() == 1 ? 0 : gcd(l.get(0), a[i]) * (k+1)), a);
                    String key = String.valueOf(Math.min(l.get(0), a[i])) + String.valueOf(Math.max(l.get(0), a[i]));
                    backTracking(i+1, cur + (l.size() == 1 ? 0 : mg.get(key) * (k+1)), a);
                    l.remove(l.size()-1);
                }
            }
        }
        int gcd(int x, int y) {
            if (y == 0) return x;
            return gcd(y, x % y);
        }

        public int numDistinct(String S, String T) {
            m = S.length();
            n = T.length();
            s = S.toCharArray();
            t = T.toCharArray();
            f = new Integer [m][n];
            return dfs(0, 0);
        }
        int m, n;
        char [] s;
        char [] t;
        Integer [][] f;
        int dfs(int i, int j) {
            if (j == n) return 1;
            if (i == m) return j == n ? 1 : 0;
            if (f[i][j] != null) return f[i][j];
            int r = 0;
            if (s[i] == t[j])
                r += dfs(i+1, j+1);
            r += dfs(i+1, j);
            return f[i][j] = r;
        }

        public int numberWays(List<List<Integer>> ll) { // TLE TLE TLE: 帽子太多了就会超时，得用动规。。。
            n = ll.size();
            backTracking(0, 0, ll);
            return ans;
        }
        int n, m, ans = 0;
        void backTracking(int i, int j, List<List<Integer>> ll) { // j: mask
            if (i == n) {
                if (Integer.bitCount(j) == n) // 一定要有这么多人顶帽子
                    ans++;
                return ;
            }
            for (int k = 0; k < ll.get(i).size(); k++) {
                int id = ll.get(i).get(k);
                if ((j & (1 << id)) == 0) // 这顶帽子还没人带
                    backTracking(i+1, j | (1 << id), ll);
            }
        }

        public boolean canCross(int[] a) {
            n = a.length;
            if (a[1] != 1) return false;
            f = new Boolean [n][n];
            return dfs(1, 1, a);
        }
        int n;
        Boolean [][] f;
        boolean dfs(int i, int j, int [] a) {
            if (i == n) return false;
            if (i == n-1) return true;
            if (f[i][j] != null) return f[i][j];
            boolean ans = false;
            for (int k = Math.max(1, j-1); k <= Math.min(n-1, j+1); k++) {
                int id = binarySearch(i+1, n-1, a[i] + k, a);
                if (id == -1) continue;
                if (dfs(id, k, a)) return true;
            }
            return f[i][j] = false;
        }
        int binarySearch(int l, int r, int v, int [] a) {
            if (v < a[l] || v > a[r]) return -1;
            while (l < r) {
                int m = (l + r) >> 1;
                if (a[m] >= v) r = m;
                else l = m+1;
            }
            return l <= r && a[l] == v ? l : -1;
        }

        public int minimumTimeRequired(int[] a, int k) {
            this.k = k;
            n = a.length;
            r = new int [k];
            Arrays.sort(a);
            backTracking(n-1, 0, a);
            return min;
        }
        int n, k, min = Integer.MAX_VALUE;
        int [] r;
        void backTracking(int i, int curMax, int [] a) {
            if (i < 0) {
                if (curMax < min) min = curMax;
                return ;
            }
            for (int j = 0; j < k; j++) {
                if (j > 0 && r[j] == r[j-1]) continue;
                r[j] += a[i];
                backTracking(i-1, Math.max(curMax, r[j]), a);
                r[j] -= a[i];
            }
        }        

        static final int mod = (int)1e9 + 7;
        int [][] dirs = {{1, 0}, {0, 1}};
        public int numberOfPaths(int[][] a, int v) { // 【动规：】用动规写了一次，但数多了，换方法写。。。// TODO TODO TODO: 
            int m = a.length, n = a[0].length;
            for (int i = 0; i < m; i++) 
                for (int j = 0; j < n; j++)
                    a[i][j] = a[i][j] % v;
            long [][][] f = new long [m][n][v];
            for (int j = 0; j < n; j++) 
                f[0][j][a[0][j]] = a[0][j];
            for (int i = 0; i < m-1; i++) {
                for (int j = 0; j < n; j++) { // 上一午的某个格
                    for (int k = 0; k < v; k++) { // 上一行的，某个余数
                        // 向右
                        if (j < n-1) {
                            int x = (k + a[i][j+1]) % v;
                            f[i][j+1][x] = (f[i][j+1][x] + f[i][j][k]) % mod;
                        }
                        // 向下
                        int x = (k + a[i+1][j]) % v;
                        f[i+1][j][x] = (f[i+1][j][x] + f[i][j][k]) % mod;
                    }
                }
            }
            // 最后一行，还有向右的可能性
            for (int j = 0; j < n-1; j++) // 上一午的某个格
                for (int k = 0; k < v; k++) { // 上一行的，某个余数
                    // 向右
                    int x = (k + a[m-1][j+1]) % v;
                    f[m-1][j+1][x] = (f[m-1][j+1][x] + f[m-1][j][k]) % mod;
                }
            return (int)f[m-1][n-1][0];
        }
        static final int mod = (int)1e9 + 7;
        int [][] dirs = {{1, 0}, {0, 1}};
        public int numberOfPaths(int[][] a, int v) { // 【记忆化深搜：】这个方法可以写过，动规写不过。。。
            this.v = v;
            this.a = a;
            m = a.length;
            n = a[0].length;
            f = new Integer [m][n][v];
            return dfs(0, 0, 0);
        }
        Integer [][][] f;
        int [][] a;
        int m, n, v;
        int dfs(int i, int j, int k) {
            if (i == m-1 && j == n-1 && (k + a[i][j]) % v == 0) return 1;
            if (i >= m || j >= n) return 0;
            if (f[i][j][k % v] != null) return f[i][j][k%v];
            long ans = dfs(i, j+1, a[i][j] + k);
            ans = (ans + dfs(i+1, j, a[i][j] + k)) % mod;
            return f[i][j][k%v] = (int)ans;
        }
    }
    public static void main (String[] args) { // 【爱表哥，爱生活！！！活宝妹就是一定要嫁给亲爱的表哥！！！】
        Solution s  =  new Solution ();

        int [][] a = new int [][] {{5,2,4},{3,0,5},{0,7,2}};

        int r = s.numberOfPaths(a, 3);
        System.out.println("r: " + r);
    }
}
// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);
// TreeNode rr = new TreeNode(a[0]);
// rr.buildTree(rr, a);
// rr.levelPrintTree(rr);








