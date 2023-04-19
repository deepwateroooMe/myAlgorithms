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
public class dpone { // 【动规三刷：】从最简单Middle 到 Hard, 希望两个周能够快速再刷一遍，并这次理解更为透彻一点儿【爱表哥，爱生活！！！】
    public static class Solution {
        public int countVowelStrings(int n) { 
            return countVowelStringsRecursive(n, 0);
        }
        int countVowelStringsRecursive(int x, int y) {
            if (x == 0 || y > 4) return 1;
            int r = 0;
            for (int i = y; i <= 4; i++) 
                r += countVowelStringsRecursive(x-1, i);   
            return r;
        }
        public int countVowelStrings(int n) { // 把它改成 dp 的写法: 所以，动规的写法，是从尾巴往前遍历的
            int [][] f = new int [n+1][5];
            for (int i = 0; i < 5; i++)
                f[n][i] = 1;
            for (int i = n-1; i >= 0; i--) {
                int r = 0;
                for (int j = 4; j >= 0; j--) {
                    r += f[i+1][j];
                    f[i][j] = r;
                }
            }
            return f[0][0];
        }
        public int countVowelStrings(int n) { // 动规：压缩空间，成一维 dp 
            int [] f = new int [5];
            Arrays.fill(f, 1);
            for (int i = 0; i < n; i++)
                for (int j = 3; j >= 0; j--) 
                    f[j] += f[j+1];
            return f[0];
        }

        // 这里是前缀和的解法，但是动规应该能够更快 TODO TODO TODO
        public int countSquares(int[][] a) {
            int m = a.length, n = a[0].length;
            int [][] r = new int [m+1][n+1];
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    r[i+1][j+1] = r[i][j+1] + r[i+1][j] - r[i][j] + a[i][j];
            int ans = 0;
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++) // 以【 i,j】为左上角，边长为 k 的个数
                    for (int k = 1; k <= Math.min(m, n) && i+k <= m && j+k <= n; k++) {
                        int sum = r[i+k][j+k] - r[i+k][j] - r[i][j+k] + r[i][j]; // 【这里是最容易出错的地方】
                        if (sum == k * k) ans++;
                    }
            return ans;
        }

        // TODO TODO TODO: 回塑法
        public List<String> generateParenthesis(int n) {
            this.n = n;
            backTracking(n, n, new StringBuilder (""));
        }
        List<String> ans = new ArrayList<>();
        int n;
        void backTracking(int l, int r, StringBuilder s) {// l, r: 剩余左右括号的个娄
            if (l == 0 && r == 0) {
                ans.add(new String(s));
                return ;
            }
            if (l > r) return ;
            for (int i = 0; i <= l; i++) {
            }
        }

        // 读不懂提示说的是什么意思，读不懂，其实更多的是自己想不通。。。
        public int maxSumAfterPartitioning(int[] a, int k) {
            int n = a.length;
            int [] f = new int [n]; // 这里长度好像更应该是 n/k+1
        }

        // 这里我先前第一次写，自己想出来的 dfs 带剪枝的写法，现在大概是需要用动规来写的. 那么还是用 dfs 来写
        public int[] findBall(int[][] a) {
            m = a.length;
            n = a[0].length;
            r = new int [n];
            for (int i = 0; i < n; i++)
                r[i] = dfs(0, i, -1, i, a);
            return r;
        }
        int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}}; // 向左右下，不能向上
        int [] r;
        int m, n;
        int dfs(int x, int y, int px, int py, int [][] a) {
            if (x < 0 || x >= m || y < 0 || y >= n) return -1;
            if (x == m-1) { // 到最后一行了：它仍然是可能向左或是向右移动的
                if (x == px) { // 最后一行：向左向右能够移动的，已经移动过了
                    // r[y]++;
                    return y;
                }
            }
            if (x != px) { // 从上面掉下来的：当前，本行，只考虑向左向右
                if (a[x][y] == -1 && (y == 0 || a[x][y-1] == 1)
                    || a[x][y] == 1 && (y == n-1 || a[x][y+1] == -1)) return -1; // 小球被卡在这里
                if (a[x][y] == -1 && y > 0 && a[x][y-1] == -1)
                    return dfs(x, y-1, x, y, a);
                else if (a[x][y] == 1 && y < n-1 && a[x][y+1] == 1)
                    return dfs(x, y+1, x, y, a);
            } else { // 本行向左向右移动过了，只能往下掉
                return dfs(x+1, y, x, y, a);
            }
            return -1;
        }

        // TLE TLE TLE: 60/63, 大概数的时候，还是不需要改变一个，只数改一个的 // TODO TODO TODO: 
        public int countSubstrings(String s, String t) {
            Node trie = new Node();
            int m = s.length(), n = t.length();
            for (int i = 0; i < n; i++)
                for (int j = i+1; j <= n; j++) 
                    insert(t.substring(i, j), trie);
            // Set<String> ss = new HashSet<>();
            Map<String, Integer> ms = new HashMap<>();
            int r = 0;
            for (int i = 0; i < m; i++)
                for (int j = i+1; j <= m; j++) {
                    String cur = s.substring(i, j);
                    // if (ss.contains(cur)) continue;
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
                    // ss.add(cur);
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
            int v;
            Node() {}
        }

        TODO TODO TODO: 
        // 忘记：这个题目是记忆化搜索，还是 min-max 差值题？感觉狠久没有刷动规，还要点儿适应时间。。。。。
        public boolean stoneGame(int[] a) {
            n = a.length;
            f = new Integer [n][n];
            return dfs(0, n-1, a);
        }
        int n;
        Integer [][] f;
        int dfs(int x, int y, int [] a) { // 记住：这个记忆化搜索，是从第一个玩家 Alice 的眼光来看问题
            if (x > y) return 0; // 石头都拿完了，可是怎么判断输赢呢？
            if (f[x][y] != null) return f[x][y];
        }

        public int minFallingPathSum(int[][] a) {
            int n = a.length;
            int [][] f = new int [n][n];
            Arrays.stream(f).forEach(z -> Arrays.fill(z, Integer.MAX_VALUE));
            for (int i = 0; i < n; i++) f[0][i] = a[0][i]; // 也可以直接把这个数组复制过来
            for (int i = 0; i < n-1; i++)
                for (int j = 0; j < n; j++)
                    for (int k = Math.max(0, j-1); k <= j+1 && k < n; k++) 
                        f[i+1][k] = Math.min(a[i+1][k] + f[i][j], f[i+1][k]);
            return Arrays.stream(f[n-1]).min().getAsInt();
        }

        // 自己写的原始一点儿：速度就比较慢
        public int numSplits(String t) {
            int n = t.length();
            char [] s = t.toCharArray();
            int ans = 0;
            Map<Integer, Integer> r = new HashMap<>(), l = new HashMap<>();
            for (int i = n-1; i > 0; i--) {
                int j = s[i] - 'a';
                r.put(j, r.getOrDefault(j, 0) + 1);
            }
            for (int i = 0; i < n; i++) {
                int j = s[i] - 'a';
                l.put(j, l.getOrDefault(j, 0) + 1);
                if (l.size() == r.size()) ans++;
                if (i < n-1) {
                    int idx = s[i+1] - 'a';
                    if (r.containsKey(idx) && r.get(idx) == 1) r.remove(idx);
                    else if (r.get(idx) > 1) r.put(idx, r.getOrDefault(idx, 0)-1);
                }
            }
            return ans;
        }
        public int numSplits(String t) {
            int n = t.length();
            char [] s = t.toCharArray();
            int [] l = new int [n+2], r = new int [n+2];
            boolean [] ll = new boolean [26], rr = new boolean [26];
            for (int i = 1; i <= n; i++) {
                int j = s[i-1] - 'a';
                if (ll[j]) l[i] = l[i-1]; // 动规：实现 O(1) 时间更新左右统计次数
                else {
                    l[i] = l[i-1] + 1;
                    ll[j] = true; // 当前字符左侧第一次出现
                }
            }
            for (int i = n; i >= 1; i--) {
                int j = s[i-1] - 'a';
                if (rr[j]) r[i] = r[i+1];
                else {
                    rr[j] = true;
                    r[i] = r[i+1] + 1;
                }
            }
            int ans = 0;
            for (int i = 1; i < n; i++) 
                if (l[i] == r[i+1]) ans++;
            return ans;
        }

        // floor(E e)   （《＝ e】方法返回在这个集合中【小于或者等于给定元素的最大元素】，如果不存在这样的元素,返回null.
        // ceiling(E e) 【 e 》＝）方法返回在这个集合中【大于或者等于给定元素的最小元素】，如果不存在这样的元素,返回null.
        // 【方法一：】先写暴力法【O(N^3)】
        public int numTeams(int[] a) {
            int n = a.length, ans = 0;
            for (int j = 1; j < n-1; j++) 
                for (int i = 0; i < j; i++) {
                    if (a[i] == a[j]) continue; // 暴力法中：这点儿优化也是要滴。。。。！！！
                    for (int k = j+1; k < n; k++) {
                        if (a[i] < a[j] && a[j] < a[k]) ans++;
                        else if (a[i] > a[j] && a[j] > a[k]) ans++;
                    }
                }
            return ans;
        }
        // 【离散化树状数组：】将数值离散化处理为，数组中元素下标，将 logMax ＝＝》 logN;
        // 两将使用线段树来logN 计数：从左往右一次，从右往左一次
        // O【NlogN 两次遍历：二分查找 logN  线段树求和logN＋】这里还有点儿搞不清楚是怎么分析 bigO
        int maxN;
        int [] c;
        List<Integer> disc;
        int [] lless, lmore, rless, rmore;
        public int numTeams(int[] a) {
            int n = a.length, ans = 0;
            maxN = n + 2;
            c = new int [maxN];
            disc = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) disc.add(a[i]);
            disc.add(-1); // 这个是：线段树的 0 位占位符吗？
            Collections.sort(disc); // 升序排列的链表：方便二分查找
            lless = new int [n];
            lmore = new int [n];
            rless = new int [n];
            rmore = new int [n];
            for (int i = 0; i < n; i++) {
                int id = getId(a[i]); // 二分查找链表中，插入位置下标
                lless[i] = get(id); // 线段树中，现【0,i) 中现存元素计数和，个数
                lmore[i] = get(n+1) - get(id); // 是 j 之前比 a[i] 大的数，不是整个数组中比 a[i] 大的数，因为目前只从左到右遍历到 i 了而已
                add(id, 1); // 【线段树元素更新：】所以，这里离散化处理，是把线段树中，链表插入位置的下标 idx 位的线段树元素，从 0 更新为 1
            }
            c = new int [maxN]; // 这里是线段树重置了一遍
            for (int i = n-1; i >= 0; i--) {
                int id = getId(a[i]);
                rless[i] = get(id);
                rmore[i] = get(n+1) - get(id);
                add(id, 1);
            }
            int ans = 0;
            for (int i = 0; i < n; i++) 
                ans += lless[i] * rmore[i] + lmore[i] * rless[i];
            return ans;
        }
        int getId(int v) { // 二分查找左边界
            int l = 0, r = disc.size()-1;
            while (l < r) {
                int m = (r - l) / 2 + l;
                if (disc.get(m) < v) l = m + 1;
                else r = m;
            }
            return l;
        }
        int get(int v) { // 统计求到达 v 的片段的和，计数个数
            int r = 0;
            while (v > 0) {
                r += c[v];
                v -= lowbit(v);
            }
            return r;
        }
        void add(int idx, int v) { // 线段树的元素更新
            while (idx < maxN) {
                c[idx] += v;
                idx += lowbit(idx);
            }
        }
        int lowbit(int v) { // 线段树下标的跳转
            return v & -v;
        }

        TODO TODO TODO: 
        public int countSubstrings(String t) {
            int n = t.length();
            char [] s = t.toCharArray();
            int [][] f = new int [n][n];
            for (int i = 0; i < n; i++) f[0][i] = 1;
            // 大概知道回文的奇偶两种情况，怎么更新还有点儿搞不清楚
        }

        public int minPathCost(int[][] a, int[][] cost) {
            int m = a.length, n = a[0].length, mn = m * n;
            int [][] f = new int [m][n];
            Arrays.stream(f).forEach(z -> Arrays.fill(z, Integer.MAX_VALUE));
            for (int j = 0; j < n; j++) f[0][j] = a[0][j];
            int min = Arrays.stream(f[0]).min().getAsInt();
            for (int i = 1; i < m; i++) 
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) 
                        f[i][j] = Math.min(f[i][j], f[i-1][k] + cost[a[i-1][k]][j] + a[i][j]);
                }
            return Arrays.stream(f[m-1]).min().getAsInt();
        }

        TODO TODO TODO: 
        public int mincostTickets(int[] a, int [] b) {
            int n = a.length, f [] = new int [n];
            f[0] = b[0];
            for (int i = 1; i < n; i++) {
                if (a[i] - a[i-1] <= 7)
            }
        }

        public List<List<String>> partition(String s) {
            partitionBackTracking(0, new ArrayList<String>(), s);
            return ll;
        }
        List<List<String>> ll = new ArrayList<>();
        void partitionBackTracking(int idx, List<String> l, String s) {
            if (idx == s.length()) {
                ll.add(new ArrayList<String>(l));
                return ;
            }
            for (int i = idx+1; i <= s.length(); i++) {
                String cur = s.substring(idx, i);
                if (check(cur)) {
                    l.add(cur);
                    partitionBackTracking(i, l, s);
                    l.remove(l.size()-1);
                }
            }
        }
        boolean check(String t){
            int n = t.length(), i = 0, j = n-1;
            char [] s = t.toCharArray();
            while (i < j) 
                if (s[i++] != s[j--]) return false;
            return true;
        }

        // TODO TODO TODO: 
        // 感觉这类题之前都想通过，可是现在再写，就感觉全忘记了。。。。。
        // 记忆化搜索: 这里引入了次序，怎么知道是甲方赢了？ alice ？
        // 这里有点儿理解上的欠缺：所有的石头给一个人了，是给两个人的，得 - 另一个人拿走的。。。
        public int stoneGameII(int[] a) {
            n = a.length;
            f = new Integer [n][n];
            return dfs(0, 1, a);
        }
        Integer [][] f;
        int n;
        int dfs(int idx, int v, int [] a) {
            if (idx == n) return 0;
            if (f[idx][v] != null) return f[idx][v];
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

        // TLE TLE TLE: 37/63 不知道写错在哪里
        public int uniquePaths(int m, int n) {
            this.m = m;
            this.n = n;
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
        public int uniquePaths(int m, int n) {
            int [][] f = new int [m][n];
        }

        public int minPathSum(int[][] a) {// TLE TLE TLE: 25/61
            m = a.length;
            n = a[0].length;
            // vis = new boolean [m][n];
            dfs(0, 0, 0, a);
            return min;
        }
        int [][] dirs = {{1, 0}, {0, 1}};
        int m, n, min = Integer.MAX_VALUE;
        // boolean [][] vis;
        void dfs(int x, int y, int v, int [][] a) {
            // if (x < 0 || x >= m || y < 0 || y >= n || vis[x][y]) return;
            if (x < 0 || x >= m || y < 0 || y >= n) return;
            // vis[x][y] = true;
            v += a[x][y];
            if (x == m-1 && y == n-1) {
                min = Math.min(min, v);
                return ;
            }
            for (int [] d : dirs)
                dfs(x + d[0], y + d[1], v, a);
            // vis[x][y] = false;
        }
        public int minPathSum(int[][] a) {
            int m = a.length, n = a[0].length;
            // 感觉下面这个数组，被今天半下午昏昏的脑袋，填得不知道是什么乱七八糟的了。。。。。【可以在原数组上改呀。。。】
            int [][] f = new int [m+1][n+1];
            Arrays.stream(f).forEach(z -> Arrays.fill(z, Integer.MAX_VALUE));
            Arrays.fill(f[0], 0);
            for (int i = 0; i <= m; i++) f[i][0] = 0;
            f[0][0] = 0;
            for (int j = 1; j <= n; j++) f[1][j] = f[1][j-1] + a[0][j-1];
            for (int i = 1; i <= m; i++) f[i][1] = f[i-1][1] + a[i-1][0];
            for (int i = 2; i <= m; i++) 
                for (int j = 2; j <= n; j++) 
                    f[i][j] = Math.min(f[i][j] , Math.min(f[i][j-1], f[i-1][j]) + a[i-1][j-1]);
            return f[m][n];
        }
        public int minPathSum(int[][] a) { // 在原数组上改出来的。同样，也可以设置同样维度的动规数组
            int m = a.length, n = a[0].length;
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j == 0) continue;
                    else if (i == 0) a[i][j] += a[i][j-1];
                    else if (j == 0) a[i][j] += a[i-1][j];
                    else a[i][j] += Math.min(a[i-1][j], a[i][j-1]);
                }
            return a[m-1][n-1];
        }

        // 最经典的回塑：
        public int distributeCookies(int[] a, int k) {
            n = a.length;
            if (n == k) return Arrays.stream(a).max().getAsInt(); // 这个优化需要，不然不过
            f = new int [k];
            backTracking(0, k, a);
            return min;
        }
        int n, min = Integer.MAX_VALUE;
        int [] f;
        void backTracking(int j, int k, int [] a) {
            int max = Arrays.stream(f).max().getAsInt();
            if (max >= min) return ;
            if (j == n) {
                if (max < min) min = max;
                return ;
            }
            for (int i = 0; i < k; i++) {
                f[i] += a[j];
                backTracking(j+1, k, a);
                f[i] -= a[j];
            }
        }

        // TODO TODO TODO: 这个思路好像是不对的。。。。。
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
            for (int i = 0; i < n; i++)
                min = Math.min(min, l[i+1] + r[i+1]);
            return min;
        }

         // TODO TODO TODO: 
        public int change(int k, int[] a) {
            int n = a.length;
            int [] f = new int [k+1];
            Arrays.sort(a);
            for (int i = 0; i < n; i++) f[a[i]] = 1;
            f[0] = 1;
            for (int i = 0; i < n; i++) {
                int v = a[i];
                for (int j = k; j >= Math.max(0, k-v); j--) 
                    f[j] += f[j-v];
            }
            return f[k];
        }

        TODO TODO TODO: 
        public int longestSubarray(int[] a) {
            int n = a.length, max = 0, i = 0, j = 0, nj = -1;
            boolean d = false;
            while (i < n && a[i] == 0) i++;
            if (i == n) return 0;
            j = i; 
            for (; i < n; i++) {
                while (i < n && a[i] == 1) i++;
                System.out.println("i0: " + i);
                System.out.println("j0: " + j);
                if (i == n) return Math.max(max, i - j - 1);
                if (a[i] == 0 && !d) {
                    d = true;
                    nj = i;
                    i++;
                } else if (a[i] == 0) { // d == true
                    int ii = i;
                    max = Math.max(max, i - j - 1);
                    System.out.println("i1: " + i);
                    System.out.println("max: " + max);
                    while (i < n && a[i] == 0) 
                        i++;
                    // j = i; // 左端点没有滑动，可能会丢掉失去正确答案
                    j = nj + 1;
                    while (a[j] == 0) j++;
                    if (j > ii) d = false;
                    // d = false;
                    System.out.println("j: " + j);
                }
                System.out.println("max: " + max);
            }
            if (i == n && a[n-1] == 1) max = Math.max(max, i - j - 1);
            return max;
        }
        int [] a = new int [] {1,1,0,0,1,1,1,0,1};

        TODO TODO TODO: 不知道哪里写错了。。。。。感觉看见链表和树的题，都感觉好简单，可是写的时候，一个测试用例，因为树太大，不知道该怎么 debug 了。。。
        public int longestZigZag(TreeNode r) {
            if (r.left == null && r.right == null) return 0;
            // if (r.left == null || r.right == null) {
            //     if (r.left != null) return Math.max(1 + maxZigZag(r.left, false), maxZigZag(r.left, true));
            //     if (r.right != null) return Math.max(1 + maxZigZag(r.right, true), maxZigZag(r.right, false));
            // }
            return Math.max(maxZigZag(r, true), maxZigZag(r, false));
        }
        int maxZigZag(TreeNode r, boolean left) { // boolean isLefting.....outgoing downwards.....
            if (r == null) return 0;
            if (left) return r.left == null ? 0 : Math.max(1 + maxZigZag(r.left, false), maxZigZag(r.left, true));
            else return r.right == null ? 0 : Math.max(1 + maxZigZag(r.right, true), maxZigZag(r.right, false));
        }
        int [] a = new int [] {6, 9, 7, 3, -1, 2, 8, 5, 8, 9, 7, 3, 9, 9, 4, 2, 10, -1, 5, 4, 3, 10, 10, 9, 4, 1, 2, -1, -1, 6, 5, -1, -1, -1, -1, 9, -1, 9, 6, 5, -1, 5, -1, -1, 7, 7, 4, -1, 1, -1, -1, 3, 7, -1, 9, -1, -1, -1, -1, -1, -1, -1, -1, 9, 9, -1, -1, -1, 7, -1, -1, -1, -1, -1, -1, -1, -1, -1, 6, 8, 7, -1, -1, -1, 3, 10, -1, -1, -1, -1, -1, 1, -1, 1, 2};

        public int maxSumTwoNoOverlap(int[] a, int one, int two) {
            int n = a.length, r [] = new int [n+1], max = 0;
            for (int i = 0; i < n; i++) r[i+1] = r[i] + a[i];
            for (int i = 0; i + one <= n; i++) { // 遍历 one 长度的子树组
                int oneSum = r[i+one] - r[i];
                for (int j = 0; j + two < i; j++) {
                    int twoSum = r[j+two] - r[j];
                    max = Math.max(max, oneSum + twoSum);
                }
                for (int j = i+one; j + two <= n; j++) {
                    int twoSum = r[j+two] - r[j];
                    max = Math.max(max, oneSum + twoSum);
                }
            }
            return max;
        }

        // TODO TODO TODO: 
        public int minimumDeletions(String t) {
            int n = t.length();
            char [] s = t.toCharArray();
            int [] l = new int [n+1], r = new int [n+1];
            for (int i = 0; i < n; i++)
                if (s[i] == 'b') l[i+1] = l[i] + 1;
                else l[i+1] = l[i];
            for (int i = n-1; i >= 0; i--)
                if (s[i] == 'a') r[i] = r[i+1] + 1;
                else r[i] = r[i+1];
        }

        public int maxAbsoluteSum(int[] a) {
            int n = a.length, r = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                r = Math.max(a[i], r + a[i]);
                max = Math.max(max, r);
            }
            r = 0;
            for (int i = 0; i < n; i++) {
                r = Math.min(a[i], r + a[i]);
                min = Math.min(min, r);
            }
            return Math.max(max, Math.abs(min));
        }

        public int longestCommonSubsequence(String S, String T) {
            int m = S.length(), n = T.length();
            char [] s = S.toCharArray();
            char [] t = T.toCharArray();
            int [][] f = new int [m+1][n+1];
            for (int i = 0; i < m; i++) 
                for (int j = 0; j < n; j++) 
                    if (s[i] == t[j]) f[i+1][j+1] = f[i][j] + 1;
                    else f[i+1][j+1] = Math.max(f[i][j+1], f[i+1][j]);
            return f[m][n];
        }

        // TODO TODO TODO: 
        public int findLongestChain(int[][] a) {
            int n = a.length;
            Arrays.sort(a, (x y) -> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
            // 这里接下来好像是可以二分查找了，但仍然要结合动规来做
        }

        public int maximumCostSubstring(String S, String chars, int[] a) {
            int n = S.length(), m = chars.length();
            int [] r = new int [26];
            char [] sc = chars.toCharArray();
            char [] s = S.toCharArray();
            Arrays.fill(r, 2027);
            for (int i = 0; i < m; i++)
                r[sc[i] - 'a'] = a[i];
            for (int i = 0; i < 26; i++)
                if (r[i] == 2027) r[i] = i+1;
            System.out.println(Arrays.toString(r));
            int ans = Integer.MIN_VALUE, cur = 0;
            for (int i = 0; i < n; i++) {
                int v = r[s[i] - 'a'];
                cur = Math.max(v, cur + v);
                ans = Math.max(ans, cur);
            }
            return ans >= 0 ? ans : 0;
        }

        public int minimumTotal(List<List<Integer>> ll) {
            int n = ll.size();
            int [][] f = new int [n][n];
            Arrays.stream(f).forEach(z -> Arrays.fill(z, Integer.MAX_VALUE));
            f[0][0] = ll.get(0).get(0);
            for (int i = 0; i < n-1; i++) // 遍历当前行
                for (int j = 0; j < ll.get(i).size(); j++) { // 遍历当前行的所有列
                    f[i+1][j] = Math.min(f[i+1][j], f[i][j] + ll.get(i+1).get(j)); // 更新下一行的，当前列，与再右一列
                    f[i+1][j+1] = Math.min(f[i+1][j+1], f[i][j] + ll.get(i+1).get(j+1));
                }
            return Arrays.stream(f[n-1]).min().getAsInt();
        }

        public int rob(int[] a) {
            n = a.length;
            f = new Integer [n];
            return Math.max(dfs(0, a), dfs(0, a));
        }
        int n;
        Integer [] f;
        int dfs(int idx, int [] a) {
            if (idx >= n) return 0;
            if (f[idx] != null) return f[idx];
            return f[idx] = Math.max(a[idx] + dfs(idx + 2, a), dfs(idx+1, a));
        }

        public int rob(int[] a) {
            n = a.length;
            if (n == 1) return a[0];
            f = new Integer [n][n];
            return Math.max(dfs(0, n-2, a), dfs(1, n-1, a));
        }
        Integer [][] f;
        int n;
        int dfs(int i, int j, int [] a) {
            if (i > j) return 0;
            if (f[i][j] != null) return f[i][j];
            if (i == j) return f[i][j] = a[i];
            return f[i][j] = Math.max(dfs(i+2, j, a) + a[i], dfs(i+1, j, a));
        }

        // 虽然还是有点儿慢，三个窃贼呀。。。
        public int rob(TreeNode r) { // 硬是吭吭吭自己把它写出来了。。。。【爱表哥，爱生活！！！活宝妹就是一定要嫁给亲爱的表哥！！！】
            if (r == null) return 0;
            if (r.left == null && r.right == null) return r.val;
            return Math.max(dfs(r, true), dfs(r, false));
        }
        Map<TreeNode, int []> m = new HashMap<>();
        int dfs(TreeNode r, boolean y) {
            if (r == null) return 0;
            if (m.containsKey(r) && (y && m.get(r)[0] != -1 || !y && m.get(r)[1] != -1)) return m.get(r)[y ? 0 : 1];
            m.computeIfAbsent(r, z -> new int [] {-1, -1});
            int [] cur = m.get(r);
            if (r.left == null && r.right == null) {
                if (y) cur[0] = r.val;
                return y ? r.val : 0;
            }
            int v = Math.max(dfs(r.left, !y) + dfs(r.right, !y), // 左右节点
                             Math.max(Math.max(dfs(r.left, !y) + dfs(r.right, y), dfs(r.right, !y) + dfs(r.left, y)),
                                      dfs(r.left, y) + dfs(r.right, y)));
            if (!y) {
                cur[1] = v;
                return v;
            }
            cur[0] = Math.max(v, r.val + dfs(r.left, !y) + dfs(r.right, !y));  
            return cur[0];
        }

        // TODO TODO TODO: 
        public int numRollsToTarget(int n, int k, int t) { // 蛇子有K 面：【1,2...k】感觉现在 dfs 与动规的方向，自上向下，还是自下向上，这个时候脑袋就昏了，明天再写这个。。。。。
            // this.n = n;
            long [][] f = new long [n][t+1];
            // 初始化：扔一次可能出现在的 k 种结果
            for (int j = 1; j <= k; j++) f[0][j] = 1;
            for (int i = 1; i < n; i++)
                for (int j = 0; j < k; j++) {
                }
        }
        // int [][] f;
        // int n;

        TODO TODO TODO: 
        public double largestSumOfAverages(int[] a, int k) { // 把数组划分成最多 k 段，可以不划分【要一个一个地找吗？】
            int n = a.length, r [] = new int [n];
            for (int i = 0; i < n; i++) r[i] = (i == 0 ? 0 : r[i-1]) + a[i];
        }

        // TLE TLE TLE: 34/39 O(N^2)
        public int longestSubsequence(int[] a, int dif) {
            int n = a.length, f [] = new int [n], max = 1;
            Arrays.fill(f, 1);
            for (int i = 1; i < n; i++) {
                int v = a[i];
                for (int j = 0; j < i; j++) 
                    if (a[j] + dif == v) f[i] = Math.max(f[i], f[j] + 1);
                max = Math.max(max, f[i]);
            }
            return max;
        }

        // 这个题：就真正到了不得不考虑玩家顺序的时候了【两个元家轮流的问题】忘记了，要好好想一下，如何处理两个玩家轮流的？。。。
        public boolean PredictTheWinner(int[] a) {
            int n = a.length;
            f = new Integer [n][n][2];
            return dfs(0, n-1, 0, a);
        }
        Integer [][][] f;
        int n;
        int dfs(int i, int j， int k, int [] a) {
            if (i > j) return 0;
            if (i == j) return f[i][j][k%2] = a[i];
            if (f[i][j][k % 2] != null) return f[i][j][k%2];
            if (k % 2 == 0) { // 第一个玩家：它想赢，返回的也是，【是否是第一个玩家赢了？亲爱的表哥一定会赢！！！】
                int v = a[i] + dfs(i+1, j, k+1, a);
            }
        }

        public int findLength(int[] a, int[] b) {
            int m = a.length, n = b.length, max = 0;
            int [][] f = new int [m+1][n+1];
            for (int i = m-1; i >= 0; i--)
                for (int j = n-1; j >= 0; j--) {
                    if (a[i] == b[j]) {
                        f[i][j] = f[i+1][j+1] + 1;
                        max = Math.max(max, f[i][j]);
                    } 
                }
            return max;
        }

        // 这个题，不是跟前两天【爱亲爱的表哥 10000 年的题目长得狠像吗 10 × 10 —X— 10 × 10】所以从左往右，从右往左数个数
        // 比那个题目简单了狠多，只简单左右数下就可以了
        public long numberOfWays(String t) {
            int n = t.length();
            char [] s = t.toCharArray();
            // 从右往左往前遍历 
            int r [] = new int [2];
            for (int i = n-1; i >= 0; i--) r[s[i] - '0']++; // 更新相应的个数
            // 从左往右遍历：一次遍历，同步更新答案
            int l [] = new int [2];
            long ans = 0;
            for (int i = 0; i < n-1; i++) { // 我想要遍历的是，当前最中间的下标
                // 对于右侧统计过的，这里需要先撤销右则的，再统计结果，再更新左边的
                int k = s[i] - '0';
                r[k]--;
                if (i > 0) ans += (long)l[1-k] * r[1-k];
                l[k]++; // 要统计完当前下标的结果了才更新
            }
            return ans;
        }

// TODO TODO TODO:         
        public int maxSumDivThree(int[] a) {
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
            // System.out.println("f.length: " + f.length);
            // for (int z = 0; z < f.length; ++z) 
            //     System.out.println(Arrays.toString(f[z]));
            return f[0][0];
        }
    } 
    public static void main (String[] args) {
        Solution s  =  new Solution ();

        int [] a = new int [] {1,2,3,4,4};
        System.out.println(Arrays.toString(a));
        
        int r = s.maxSumDivThree(a);
        System.out.println("r: " + r);
    } 
}
// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);
// TreeNode rr = new TreeNode(a[0]);
// rr.buildTree(rr, a);
// rr.levelPrintTree(rr);













































