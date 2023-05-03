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


        // 【这个题目是参考的标准答案：】需要总结一下: 深度优先搜索 || 动规，两种方法。自己更熟悉习惯深搜. 这是自己之前两遍草草刷过不曾分析或是仔细看别人题解、不曾总结过的题目。。。。。
        // 【方法一：】深搜
        public int longestZigZag(TreeNode r) { 
            if (r.left == null && r.right == null) return 0;
            dfs(r, true, 0);
            dfs(r, false, 0);
            return max;
        }
        int max = 0;
        void dfs(TreeNode r, boolean lefting, int len) {
            max = Math.max(max, len); // 就这么一丝机关，就被卡住了，还是要多动脑筋想一想。。。
            if (lefting) {
                if (r.left != null) dfs(r.left, false, len+1);
                if (r.right != null) dfs(r.right, false, 0);
            } else {
                if (r.right != null) dfs(r.right, true, len+1);
                if (r.left != null) dfs(r.left, true, 0);
            }
        }
        // 【方法二：】动规
        Map<TreeNode, Integer> f = new HashMap<>(); // 记 f(u) 为从根到节点 u 的路径上以 u 结尾并且 u 是它父亲的左儿子的最长交错路径，
        Map<TreeNode, Integer> g = new HashMap<>(); // 记 g(u) 为从根到节点 u 的路径上以 u 结尾并且 u 是它父亲的右儿子的最长交错路径，
        Deque<TreeNode []> q = new ArrayDeque<>();  // 理论上我们可以用 DFS 或者 BFS 的任意一种框架来遍历这棵树。这里用的是【广搜】
        public int longestZigZag(TreeNode r) { 
            dp(r); // 深搜、广搜都可以，这里先用广搜法. 动规统计结果，备用
            int max = 0;
            for (TreeNode key : f.keySet())
                max = Math.max(max, Math.max(f.get(key), g.get(key)));
            return max;
        }
        void dp(TreeNode o) {
            f.put(o, 0);
            g.put(o, 0);
            q.offerFirst(new TreeNode [] {o, null}); // 【currNode, ParentOfCurrNode】：主要是方便晚点儿的时候来辨别左右子树关系
            while (!q.isEmpty()) {
                TreeNode [] cur = q.pollFirst();
                TreeNode r = cur[0], p = cur[1];
                f.put(r, 0);
                g.put(r, 0);
// 当父节点不为空，这里做的是：动态更新两个子节点的最大长度
                if (p != null) { 
                    if (r == p.left)
                        f.put(r, Math.max(f.get(r), g.get(p) + 1));
                    else
                        g.put(r, Math.max(g.get(r), f.get(p) + 1));
                }
                // 非空子节点入队列
                if (r.left != null) q.offerFirst(new TreeNode [] {r.left, r});
                if (r.right != null) q.offerFirst(new TreeNode [] {r.right, r});
            }
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
        
        // 自己写的，仍然感觉思路相对混乱，参看一下别人的写得极有条理的写法。。。
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
        // 【方法一：】动规：上面的最长 z 路径，也使用了这种方法，树状、树的动规题型，需要记住掌握了。。。时间复杂度：【O(N)】；空间复杂度：【O(N)】
        Map<TreeNode, Integer> f = new HashMap<>(); // 这个记：偷了根节点 r 的最大值 
        Map<TreeNode, Integer> g = new HashMap<>(); // 这个记：不偷根节点 r 的最大值 
        public int rob(TreeNode r) {
            dfs(r);
            return Math.max(f.getOrDefault(r, 0), g.getOrDefault(r, 0));
        }
        void dfs(TreeNode r) { // 对二叉树做了一次后序遍历，时间复杂度是 O(n)
            if (r == null) return ;
            dfs(r.left);
            dfs(r.right);
// 偷了根节点，左右节点就一定不能再偷
            f.put(r, r.val + g.getOrDefault(r.left, 0) + g.getOrDefault(r.right, 0)); 
            // 不偷根节点：就取，左右子节点，左右子节点，分别偷与不偷，的分别最大值，的和
            g.put(r, Math.max(f.getOrDefault(r.left, 0), g.getOrDefault(r.left, 0)) + Math.max(f.getOrDefault(r.right, 0), g.getOrDefault(r.right, 0)));
        }
        // 【方法二：】动规：对上面的方法进行空间压缩，时间复杂度：【O(N)】；空间复杂度：【O(N)】写法精简了狠多。。。
        public int rob(TreeNode r) {
            int [] ans = dfs(r);
            return Math.max(ans[0], ans[1]);
        }
        int [] dfs(TreeNode root) { // 返回值 int 【0,1】：【偷根节点，不偷根节点】
            if (root == null) return new int [] {0, 0};
            int [] l = dfs(root.left);
            int [] r = dfs(root.right);
            int robCur = root.val + l[1] + r[1];
            int notCur = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
            return new int [] {robCur, notCur};
        }

        TODO TODO TODO: 
        public double largestSumOfAverages(int[] a, int k) { // 把数组划分成最多 k 段，可以不划分【要一个一个地找吗？】
            int n = a.length, r [] = new int [n];
            for (int i = 0; i < n; i++) r[i] = (i == 0 ? 0 : r[i-1]) + a[i];
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

        public List<String> generateParenthesis(int n) { // 自己写的，参看一下别人写的。。。
            this.n = n;
            backTracking(n, n, new StringBuilder (""));
            return ans;
        }
        List<String> ans = new ArrayList<>();
        int n;
        void backTracking(int l, int r, StringBuilder s) {// l, r: 剩余左右括号的个娄
            if (l == 0 && r == 0) {
                if (s.length() == 2 * n)
                    ans.add(new String(s));
                return ;
            }
            if (l > r) return ;
            for (int i = 0; i <= l; i++) { // 【BUG:】自己的方法，之所以慢，就慢在这里，因为这个步骤，有着无数次的不必要的重复。。。。。
                s.append('(');
                backTracking(l-(i+1), r, s);
                s.deleteCharAt(s.length()-1);
            }
            if (l < r) { // 这里可以添加右括号
                for (int i = 0; i < r-l; i++) {
                    s.append(')');
                    backTracking(l, r-(i+1), s);
                    s.deleteCharAt(s.length()-1);
                }
            }
        }
        public List<String> generateParenthesis(int n) { // 快了狠多。。。【爱表哥，爱生活！！！】
            this.n = n;
            backTracking(0, 0, new StringBuilder (""));
            return ans;
        }
        List<String> ans = new ArrayList<>();
        int n;
        void backTracking(int open, int close, StringBuilder s) {
            if (s.length() == 2 * n) {
                ans.add(s.toString());
                // ans.add(new String(s));
                return ;
            }
            if (open < n) {
                s.append('(');
                backTracking(open+1, close, s);
                s.deleteCharAt(s.length()-1);
            }
            if (close < open) {
                s.append(')');
                backTracking(open, close+1, s);
                s.deleteCharAt(s.length()-1);
            }
        }

        // TODO TODO TODO: 
        public long maxAlternatingSum(int[] a) {
            int n = a.length;
            int [] l = new int [n+1], r = new int [n+1]; // l: odd r : even 反正是像树维护左右两边子树一样，分奇偶，可是还是没想清楚。。。
            for (int i = 0; i < n; i++) {
                l[i+1] = l[i] + 1
            }
        }

        // 【记忆化搜索：】这个写法相对比较熟悉，不太习惯写动规。。。。。
        public int numRollsToTarget(int n, int k, int t) { // 蛇子有K 面：【1,2...k】
            this.n = n;
            this.k = k;
            f = new Integer [n+1][t+1];
            return dfs(n, t);
        }
        static final int mod = (int)1e9 + 7;
        Integer [][] f;
        int n, k;
        int dfs(int x, int t) {
            if (t < 0 || x <= 0 && t > 0) return 0;
            if (x == 0 && t == 0) return 1;
            if (f[x][t] != null) return f[x][t];
            long ans = 0;
            for (int i = 0; i < k; i++) {
                int v = i + 1;
                ans = (ans + dfs(x-1, t-v)) % mod;
            }
            return f[x][t] = (int)ans;
        }
        // 【动规：】
        static final int mod = (int)1e9 + 7;
        public int numRollsToTarget(int n, int v, int t) { // 蛇子有v 面：【1,2...v】
            int min = Math.min(v, t); // 某些情况下，这个是保证结果正性的，当 t 《 v 时
            int [][] f = new int [n+1][t+1];
            // f[0][0] = 1; // 这里初始化得不对，扔一次，并不仅只这一个结果，结果有 k 个！！！
            for (int i = 1; i <= min; i++) f[1][i] = 1; // 【扔第一次】，可以得到这个和
            // 扔接下来的第【2,n】次：累计统计结果
            for (int i = 2; i <= n; i++)
                for (int j = i; j <= t; j++) // 最大范围的前 i 次累积和 
                    for (int k = 1; j - k >= 0 && k <= v; k++) // 进一步缩小合法扩张范围：【 i-1】【 j-k,j-1】 ==> 【 i,j】
                        f[i][j] = (f[i][j] + f[i-1][j-k]) % mod;
            return f[n][t];
        }

        static final int mod = (int)1e9 + 7;
        public int knightDialer(int n) { // 还可以使用【滚动数组】，继续压缩空间
            List<Integer> [] g = new ArrayList [10]; 
// 建的是：可以去到哪里
            g[0] = new ArrayList<>(List.of(4, 6)); 
            g[1] = new ArrayList<>(List.of(6, 8));
            g[2] = new ArrayList<>(List.of(7, 9));
            g[3] = new ArrayList<>(List.of(4, 8));
            g[4] = new ArrayList<>(List.of(0, 3, 9));
            g[5] = new ArrayList<>();
            g[6] = new ArrayList<>(List.of(0, 1, 7));
            g[7] = new ArrayList<>(List.of(2, 6));
            g[8] = new ArrayList<>(List.of(1, 3));
            g[9] = new ArrayList<>(List.of(2, 4));
            int [][] f = new int [n][10];
            for (int i = 0; i < 10; i++) f[0][i] = 1;
            for (int i = 0; i < n-1; i++)
                for (int j = 0; j < 10; j++) {
                    List<Integer> l = g[j];
                    for (int k = 0; k < l.size(); k++) {
                        int v = l.get(k);
                        f[i+1][v] = (f[i][j] + f[i+1][v]) % mod;
                    }
                }
            return (int)(Arrays.stream(f[n-1]).asLongStream().sum() % mod);
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
                Arrays.fill(f[~i & 1], 0); // 这里就写得狠聪明了。。。
                for (int j = 0; j < 10; j++) 
                    for (int k : g[j]) {
                        f[~i & 1][k] += f[i & 1][j];
                        f[~i & 1][k] %= mod;
                    }
            }
            return (int)(Arrays.stream(f[~n & 1]).asLongStream().sum() % mod);
        }

        public int maxSubArray(int[] a) {
            int n = a.length, r = 0, max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                r = Math.max(r + a[i], a[i]);
                max = Math.max(max, r);
            }
            return max;
        }

        // TODO TODO TODO: 
        public int secondsToRemoveOccurrences(String t) { // 这里步骤关系没有理对，过程中可能会有多的步骤，需要严格模拟，或是更精密的总结。。。
            int n = t.length(), cnt = 0, idx = -1;
            char [] s = t.toCharArray();
            for (int i = 0; i < n; i++)
                if (s[i] == '0') {
                    cnt++;
                    if (idx == -1) idx = i;
                }
            return n - cnt - idx;
        }

        public int addMinimum(String t) {
            int n = t.length(), k = 0;
            char p = 'z';
            char [] s = t.toCharArray();
            for (int i = 0; i < n; i++) {
                if (s[i] <= p) k++;
                p = s[i];
            }
            return k * 3 - n;
        }

        // 【DFS 剪枝深搜 || 动规】：动规的方法，晚点儿可以再补一下
        public int minimumPartition(String t, int k) {
            n = t.length();
            s = t.toCharArray();
            kk = String.valueOf(k);
            m = kk.length();
            f = new int [n];
            Arrays.fill(f, Integer.MAX_VALUE / 2);
            dfs(0, t, k);
            return f[0] == Integer.MAX_VALUE / 2 ? -1 : f[0];
        }
        char [] s;
        String kk;
        int n, m;
        int [] f;
        int dfs(int idx, String t, int k) {
            if (idx >= n) return 0;
            if (f[idx] != Integer.MAX_VALUE / 2) return f[idx];
            int ans = Integer.MAX_VALUE / 2;
            int v = 0;
            for (int i = idx; i < idx+m && i < n; i++) {
                v = v * 10 + s[i] - '0';
                if (v > k) break;
                ans = Math.min(ans, 1 + dfs(i+1, t, k));
            }
            return f[idx] = ans;
        }

        public boolean canPartition(int[] a) { // 这里至少也得降序排列一下呀。。。先试着分两组，往什么数组和小的一组里去添加之类的。。。
            n = a.length;
            if (n < 2) return false;
            int sum = Arrays.stream(a).sum(), max = Arrays.stream(a).max().getAsInt();
            if (sum % 2 != 0 || max > sum / 2) return false;
            if (Arrays.stream(a).distinct().count() == 1) return n % 2 == 0;
            return backTracking(0, 0, sum/2, a);
        }
        int n;
        boolean backTracking(int idx, int v, int target, int [] a) {
            if (v == target) return true;
            if (idx == n) return v == target;
            if (backTracking(idx+1, v+a[idx], target, a)) return true;
            return backTracking(idx+1, v, target, a);
        }
        // 【动规：】同拼硬币什么之类的题目是一样的. 所以，有了最基本的提醒之后，我是可以自己把它想出来的。。。
        public boolean canPartition(int[] a) { // 好慢，还没有上面的，自己瓣出来的一维的快
            int n = a.length;
            if (n < 2) return false;
            int sum = Arrays.stream(a).sum(), max = Arrays.stream(a).max().getAsInt(), target = sum / 2;
            if (sum % 2 != 0 || max > sum / 2) return false;
            Arrays.sort(a); // 子集：之类的，一般顺序不重要，所以解题时，可以排序，来帮助自己解答问题
            boolean [][] f = new boolean [n][target + 1];
            Arrays.stream(f).forEach(z -> Arrays.fill(z, false));
            for (int i = 0; i < n; i++) f[i][0] = true;
            f[0][a[0]] = true;
            for (int i = 1; i < n; i++) {
                int v = a[i];
                for (int j = 1; j <= target; j++) {
                    if (j < v) // 因为这些现取得的值 j, 不能通过当前数得到，只能取它们先前只能得到的结果
                        f[i][j] = f[i-1][j]; 
                    else // 这些取值，就可以通过添加一个当前数 a[i] 取得
                        f[i][j] = f[i-1][j] | f[i-1][j-v];
                }
            }
            return f[n-1][target];
        }
        public boolean canPartition(int[] a) { // 这里至少也得降序排列一下呀。。。先试着分两组，往什么数组和小的一组里去添加之类的。。。
            int n = a.length;
            if (n < 2) return false;
            int sum = Arrays.stream(a).sum(), max = Arrays.stream(a).max().getAsInt(), target = sum / 2;
            if (sum % 2 != 0 || max > sum / 2) return false;
            Arrays.sort(a); // 子集：之类的，一般顺序不重要，所以解题时，可以排序，来帮助自己解答问题
            boolean [] f = new boolean [target + 1];
            Arrays.fill(f, false);
            f[0] = true;
            // f[a[0]] = true; // 一维时，这个初始化也不必要了。。。
            // for (int i = 1; i < n; i++) {
            for (int i = 0; i < n; i++) {
                int v = a[i];
                for (int j = target; j >= v; j--)
                    f[j] |= f[j-v];
            }
            return f[target];
        }

        // 得弄三个带自更新功能的队列，相等的时候自动移除，忘记那个写法了，但写得出来。。。
        public int nthUglyNumber(int n) {
            int r = 0;
            while (n  > 0) {
                r = getMin();
                n--;
            }
            return r;
        } 
        int two = 2, tre = 3, fiv = 5;
        int l = 1, m = 1, r = 1;
        int getMin() {
            int ans = Math.min(two, Math.min(tre, fiv));
            if (ans == two) l++;
            else if (ans == tre) m++;
            else r++;
            two = 2 * l;
            tre = 3 * m;
            fiv = 5 * r;
            return ans;
        }

        public int maxResult(int[] a, int k) {
            int n = a.length;
            int [] f = new int [n];
            Arrays.fill(f, Integer.MIN_VALUE);
            // // 从左往右遍历：正着走是O 【N^2】会 // TLE TLE TLE: 
            // f[0] = a[0];
            // for (int i = 0; i < n-1; i++) {
            //     for (int j = i+1; j <= i + k && j < n; j++)
            //         f[j] = Math.max(f[j], f[i] + a[j]);
            // }
            // 那就倒着走：从右往左遍历
            f[n-1] = a[n-1];
            Queue<Integer> q = new PriorityQueue<>((x, y) -> f[y] - f[x]); // 按降序排列
            q.offer(n-1);
            for (int i = n-2; i >= 0; i--) {
                while (!q.isEmpty() && q.peek() > i+k) q.poll(); // 把不合法的扔出去
                if (q.isEmpty()) return -1;
                f[i] = a[i] + f[q.peek()]; // 【注意：】这里不能扔出去，只能偷看一下。。。【爱表哥，爱生活！！！】
                q.offer(i);
            }
            return f[0] == Integer.MIN_VALUE ? -1 : f[0];
        }

        这么写，狠好写，可是，如果是【动规，可以吗？》】，该如何写呢？ // TODO TODO TODO: 
         public int findTargetSumWays(int[] a, int target) {
            n = a.length;
            backTracking(0, 0, target, a);
            return cnt;
        }
        int n, cnt = 0;
        void backTracking(int idx, int cur, int target, int [] a) {
            if (idx == n) {
                if (cur == target) cnt++;
                return ;
            }
            backTracking(idx+1, cur + a[idx], target, a);
            backTracking(idx+1, cur - a[idx], target, a);
        }

        class Range implements Comparable<Range> { // 【重要：】只有这样，才可以借助 TreeSet 等数据结构简单查询，就不用自己再写二分搜索了。。。
            public int l, r, v;
            public Range(int l, int r, int v) {
                this.l = l;
                this.r = r;
                this.v = v;
            }
            @Override public int compareTo(Range other) { // 这里，我按结束时间升序排列 
                return this.r != other.r ? this.r - other.r : this.l - other.l;
            }
        }
        TreeSet<Range> s = new TreeSet<>();
        public int maxTwoEvents(int[][] a) { // 感觉还是不有想透：虽然可以找到第二个事件开始之前结束的所有事件，可是要找那些事件的最大最值得用线段树。。。
            int n = a.length;
            Arrays.sort(a, (x, y)-> x[1] != y[1] ? x[1] - y[1] : x[0] - y[0]);
            for (int [] e : a) s.add(new Range(e[0], e[1], e[2]));
        }

        // TODO TODO TODO: 
        public int minimumBuckets(String t) {
            int n = t.length(), r = 0;
            char [] s = t.toCharArray();
            if (n == 1 && s[0] != '.') return -1;
            boolean [] vis = new boolean [n];
            for (int i = 0; i < n; i++) {
                if (s[i] == 'H') {
                    if (i > 0 && vis[i-1] || i < n-1 && vis[i+1]) continue;
                    if (i == n-1 && !vis[i-1] && s[i-1] != '.' || i < n-1 && s[i+1] == 'H') return -1;
                    if (i < n-1)
                        vis[i+1] = true;
                    r++;
                } 
            }
            return r;
        }

        // 记得之前是 DFS 写的，可是现在不想再写 dfs, 尤其是这个题目这么繁琐的时候。。。
        public int findPaths(int m, int n, int max, int si, int sj) {
            this.m = m;
            this.n = n;
            f = new int [m][n][max+1];
            return dfs(si, sj, max);
        }
        int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        static final int mod = (int)1e9 + 7;
        int [][][] f;
        int dfs(int x, int y, int cnt) {
        }

        // 不知道这个题有没有动规的思路、？？？
        public int getMaxLen(int[] a) {
            int n = a.length;
            int [] r = new int [n+1], ir = new int [n+1];
            Arrays.fill(ir, -1);
            for (int i = n-1; i >= 0; i--) {
                if (a[i] < 0) {
                    r[i] = r[i+1] + 1;
                    if (ir[i+1] == -1) ir[i] = i;
                } else if (a[i] > 0) ir[i] = ir[i+1];
            }
            System.out.println(Arrays.toString(r));
            System.out.println(Arrays.toString(ir));
            return 0;
        }

        public long maxTaxiEarnings(int n, int[][] a) { // TODO TODO TODO: 
            int m = a.length, j = m-1;
            Arrays.sort(a, (x, y) -> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]); // 最普通的排序
            long [] f = new long [m];
            f[m-1] = a[m-1][1] - a[m-1][0] + a[m-1][2];
            long max = f[m-1];
            for (int i = m-2; i >= 0; i--) {
                int [] cur = a[i];
                f[i] = cur[1] - cur[0] + cur[2];
                for (; j > i && a[j][0] >= cur[1]; j--) { // 这里精巧的是：对所有的 i,j 是只遍历一次N. 但这里哪里制造了错误
                    f[i] = Math.max(f[i], cur[1] - cur[0] + cur[2] + f[j]);
                }
                f[i] = Math.max(f[i], f[i+1]);
                max = Math.max(max, f[i]);
            }
            return max;
        }

        static final int mod = (int)1e9 + 7;
        public int numOfSubarrays(int[] a) {
            int n = a.length, s = 0;
            int [] r = new int [2];
            r[0] = 1;
            long ans = 0;
            for (int i = 0; i < n; i++) {
                s += a[i];
                if (s % 2 == 0) ans = (ans + r[1]) % mod;
                else ans = (ans + r[0]) % mod;
                r[s%2]++;
            }
            return (int)ans;
        }

        public boolean makesquare(int[] a) {
            int n = a.length, sum = Arrays.stream(a).sum(), max = Arrays.stream(a).max().getAsInt();
            if (n < 4 || sum % 4 != 0 || max > sum / 4) return false;
            int target = sum / 4;
            int [] r = new int [4];
            Arrays.sort(a);
            return backTracking(n-1, r, a, target);
        }
        boolean backTracking(int idx, int [] r, int [] a, int target) {
            if (r[0] == target && r[1] == target && r[2] == target) return true;
            if (idx < 0) {
                for (int i = 0; i < 4; i++)
                    if (r[i] != target) return false;
                return true;
            }
            int v = a[idx];
            for (int i = 0; i < 4; i++) 
                if (r[i] + v <= target) {
                    r[i] += v;
                    if (backTracking(idx-1, r, a, target)) return true;
                    r[i] -= v;
                }
            return false;
        }

        public boolean validPartition(int[] a) {// TODO TODO TODO: 这里还有点儿小问题
            int n = a.length;
            long [] s = new long [n+1];
            for (int i = n-1; i >= 0; i--) s[i] = s[i+1] + a[i];
            boolean [] f = new boolean [n+1];
            f[n] = true;
            for (int i = n-2; i >= 0; i--) {
                for (int j = Math.min(n-1, i+2); j >= i+1; j--) {
                    int cnt = j - i + 1;
                    if (cnt == 2 && a[i] == a[j] || cnt == 3 && a[i] == a[i+1] && a[i+1] == a[j]) f[i] = f[i+cnt];
                    else if (cnt == 3 && s[i] - s[j+1] == (long) a[i+1] * 3l && (a[i] == a[i+1] || a[i+1] - a[i] == 1))
                        f[i] |= f[i+cnt];
                }
            }
            return f[0];
        }

        public int jump(int[] a) {
            int n = a.length;
            int [] f = new int [n];
            Arrays.fill(f, Integer.MAX_VALUE / 2);
            f[0] = 0;
            for (int i = 0; i < n; i++) {
                int v = a[i];
                for (int d = 1; d <= v && i + d < n; d++) {
                    int j = i + d;
                    f[j] = Math.min(f[j], f[i] + 1);
                }
            }
            return f[n-1];
        }

        public boolean canPartitionKSubsets(int[] a, int k) {
           n = a.length;
           int sum = Arrays.stream(a).sum(), max = Arrays.stream(a).max().getAsInt();
           if (n < k || sum % k != 0 || max > sum / k) return false;
           this.k = k;
           r = new int [k];
           Arrays.sort(a);
           return backTracking(n-1, a, sum / k);
        }
        int [] r;
        int n, k;
        boolean backTracking(int idx, int [] a, int target) {
            if (idx < 0) {
                for (int i = 0; i < k; i++)
                    if (r[i] != target) return false;
                return true;
            }
            for (int i = 0; i < k; i++) {
                if (i > 0 && r[i] == r[i-1]) continue; // 【优化：】当两个框里的和是一样的，不需要再重复，因为效果等价。。。【爱表哥，爱生活！！！】
                if (r[i] + a[idx] <= target) {
                    r[i] += a[idx];
                    if (backTracking(idx-1, a, target)) return true;
                    r[i] -= a[idx];
                }
            }
            return false;
        }

         public int longestSquareStreak(int[] a) {
            int n = a.length, max = -1;
            Arrays.sort(a);
            Set<Long> s = new HashSet<>(Arrays.stream(a).asLongStream().boxed().collect(Collectors.toList()));
            int r = 0;
            boolean once = false;
            for (long v : a) {
                r = 0;
                once = false;
                while (s.contains(v * v)) {
                    if (!once) once = true;
                    ++r;
                    v *= v;
                }
                if (once)
                    max = Math.max(max, r+1);
                if (max == 5) return 5;
            }
            return max;
        }

        public int uniquePathsWithObstacles(int[][] a) { // 还是不会写动规。。。
            m = a.length;
            n = a[0].length;
            f = new Integer [m][n];
            return dfs(0, 0, a);
        }
        int [][] dirs = {{1, 0}, {0, 1}};
        Integer [][] f;
        int m, n;
        int dfs(int x, int y, int [][] a) {
            if (x < 0 || x >= m || y < 0 || y >= n || a[x][y] == 1) return 0;
            if (x == m-1 && y == n-1) return f[x][y] = 1;
            if (f[x][y] != null) return f[x][y];
            int r = 0;
            for (int [] d : dirs)
                r += dfs(x + d[0], y + d[1], a);
            return f[x][y] = r;
        }

        public boolean canJump(int[] a) {
            int n = a.length;
            boolean [] f = new boolean [n];
            f[0] = true;
            for (int i = 0; i < n; i++) {
                int v = a[i];
                for (int j = i+1; j <= i+v && j < n; j++) 
                    f[j] |= f[i];
            }
            return f[n-1];
        }

        public int longestIdealString(String t, int th) { // 动规
            int n = t.length();
            char [] s = t.toCharArray();
            List<Integer> [] g = new ArrayList [26];
            Arrays.setAll(g, z -> new ArrayList<>());
            for (int i = 0; i < n; i++) g[s[i] - 'a'].add(i);
            int [] f = new int [n];
            Arrays.fill(f, 1);
            for (int i = 0; i < n; i++) {
                int idx = s[i] - 'a';
                g[idx].remove(0);
                for (int j = Math.max(0, idx - th); j <= idx + th && j < 26; j++) {
                    if (g[j].size() == 0) continue;
                    // for (int k : g[j]) f[k] = Math.max(f[k], f[i] + 1); // 这里用点儿贪心思想，每个只更新第一个？能保证答案正确性吗？【它居然就过了。。。】
                    f[g[j].get(0)] = Math.max(f[g[j].get(0)], f[i] + 1);
                }
            }
            return Arrays.stream(f).max().getAsInt();
        }

        public List<Integer> goodIndices(int[] a, int k) {
            int n = a.length, l [] = new int [n], r [] = new int [n];
            r[n-1] = 1;
            for (int i = n-2; i >= k; i--) // 对应到当前下标包括在内
                if (a[i] <= a[i+1]) r[i] = r[i+1] + 1;
                else r[i] = 1;
            l[0] = 1;
            for (int i = 1; i <= n-k; i++) // 对应到当前下标包括在内 
                if (a[i] <= a[i-1]) l[i] = l[i-1] + 1;
                else l[i] = 1;
            List<Integer> ans = new ArrayList<>();
            for (int i = k; i < n-k; i++) 
                if (l[i-1] >= k && r[i+1] >= k) ans.add(i);
            return ans;
        }

        public boolean isInterleave(String S, String SS, String T) { // TODO TODO TODO: 这个题目可能没读懂是什么意思
            int m = S.length(), n = SS.length(), mn = T.length();
            if (m + n != mn) return false;
            char [] s = S.toCharArray();
            char [] ss = SS.toCharArray();
            char [] t = T.toCharArray();
            int i = 0, j = 0, k = 0;
            while (i < m || j < n || k < mn) {
                while (i < m && k < mn && s[i] == t[k]) {
                    i++;
                    k++;
                }
                while (j < n && k < mn && ss[j] == t[k]) {
                    j++;
                    k++;
                }
                if (i == m) {
                    while (j < n && k < mn && ss[j] == t[k]) {
                        j++;
                        k++;
                    }
                    if (j < n && k < mn && ss[j] != t[k]) return false;
                }
                else if (j == n) {
                    while (i < m && k < mn && s[i] == t[k]) {
                        i++;
                        k++;
                    }
                    if (i < m && k < mn && s[i] != t[k]) return false;
                }
                else if (k == mn) break;
            }
            if (k == mn) return i == m && j == n;
            return false;
        }

        public int findCheapestPrice(int n, int[][] a, int src, int dst, int k) { // TODO TODO TODO: 可能需要换个方法来写
            for (int [] e : a) 
                m.computeIfAbsent(e[0], z -> new ArrayList<>()).add(new int [] {e[1], e[2]});
            f = new Integer [n];
            Arrays.fill(f, Integer.MAX_VALUE / 2);
            return dfs(src, dst, k);
        }
        Map<Integer, List<int []>> m = new HashMap<>();
        Integer [] f;
        int dfs(int u, int v, int k) {
            if (u == v && k >= 0) return 0;
            if (k < 0 && u != v) return Integer.MAX_VALUE / 2;
            if (f[u] != null) return f[u];
            if (!m.containsKey(u)) return Integer.MAX_VALUE / 2;
            int ans = Integer.MAX_VALUE / 2;
            for (int [] one : m.get(u)) {
                int nt = one[0], ct = one[1];
                ans = Math.min(ans, dfs(nt, v, k-1));
            }
            return f[u] = ans;
        }

        public int minSumOfLengths(int[] a, int target) {
            int n = a.length, sum = 0, ss = Arrays.stream(a).sum();
            int [] l = new int [n], r = new int [n];
            Map<Integer, Integer> m = new HashMap<>();
            m.put(0, -1);
            Arrays.fill(l, Integer.MAX_VALUE);
            for (int i = 0; i < n; i++) {
                sum += a[i];
                if (sum >= target && m.containsKey(sum - target))
                    l[i] = Math.min((i == 0 ? n : l[i-1]), i - m.get(sum - target));
                else if (i > 0) l[i] = l[i-1];
                m.put(sum, i);
            }
            Arrays.fill(r, Integer.MAX_VALUE);
            m.clear();
            m.put(0, n); sum = 0;
            for (int i = n-1; i >= 0; i--) {
                sum += a[i];
                if (sum >= target && m.containsKey(sum - target))
                    r[i] = Math.min((i == n-1 ? n : r[i+1]), m.get(sum - target) - i);
                else if (i < n-1) r[i] = r[i+1];
                m.put(sum, i);
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n-1; i++) 
                if (l[i] != Integer.MAX_VALUE && r[i+1] != Integer.MAX_VALUE) min = Math.min(min, l[i] + r[i+1]);
            return min == Integer.MAX_VALUE ? -1 : min;
        }

        public boolean checkValidString(String t) { 
            n = t.length();
            s = t.toCharArray();
            if (s[n-1] == '(') return false;
            f = new Boolean [n][n];
            return dfs(0, 0);
        }
        char [] s;
        int n;
        Boolean [][] f;
        Boolean dfs(int i, int j) {
            if (i == n) return j == 0;
            if (j < 0) return false; 
            if (f[i][j] != null) return f[i][j];
            int k = j;
            if (s[i] == '(') k++; // 【这里不能原位变】
            else if (s[i] == ')') k--;
            if (s[i] != '*') return f[i][j] = dfs(i+1, k);
            // '*' 还没有处理
            if (dfs(i+1, k+1)) return f[i][j] = true;
            if (dfs(i+1, k)) return f[i][j] = true;
            if (dfs(i+1, k-1)) return f[i][j] = true;
            return f[i][j] = false;
        }
    }  
    public static void main (String[] args) {
        Solution s  =  new Solution ();

        // String a = "((()))()(()) (*()()())**(())()()()()((*()*))((*()*)";
        String a = "(*()()())**(())()()()()((*()*))((*()*)";
        // String a = "**((*";

       boolean r = s.checkValidString(a);
        System.out.println("r: " + r);
    } 
}
// ListNode head = new ListNode(a[0]); 
// head.buildList(head, a);
// head.printList(head);
// TreeNode rr = new TreeNode(a[0]);
// rr.buildTree(rr, a);
// rr.levelPrintTree(rr);













