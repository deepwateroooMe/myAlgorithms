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

public class mfourixed {
    public static class Solution {

        public int minimizeArrayValue(int [] a) { // 是自己可以独立完成，可是运行效率太低了。。。
            n = a.length;
            int min = Integer.MAX_VALUE;
            int l = 0, r = Arrays.stream(a).max().getAsInt();
            while (l + 1 <= r) {
                int m = l + (r - l) / 2;
                if (check(m, a)) r = m;
                else l = m+1;
            }
            return l;
        }
        int n;
        boolean check(int v, int [] a) {
            long [] r = new long [n];
            for (int i = n-1; i > 0; i--) 
                if (a[i] + r[i] > v) {
                    r[i-1] = a[i] + r[i] - v;
                }
            return r[0] + a[0] <= v;
        }
        // 可以抽象的理解成一个从右到左流通的flow
        // 如果右边值比较大左边比较小 可以从右边留到左边
        // 但如果左边比较大 右边比较小 就流不过去
        // 所以我们可以从左到右遍历 然后在过程中算prefix sum
        // 然后算平均数
        // 最大的平均数就是答案
        public int minimizeArrayValue(int[] a) { // 就算了个平均值
            int n = a.length;
            long ans = 0, prefix = 0;
            for (int i = 0; i < n; i++) {
                prefix += a[i];
                long prefixAvg = (long)Math.ceil(prefix / (double)(i + 1));
                ans = Math.max(ans, prefixAvg);
            }
            return (int)ans;
        }        

        【这个题：不是狠喜欢，简单过了下，没仔细看】
        static final int MOD = (int) 1e9 + 7, N = (int) 1e5 + 1;
        static final int[] f = new int[N], g = new int[N];
        static {
            f[0] = g[0] = 1;
            f[1] = g[1] = 1;
            f[2] = g[2] = 2;
            f[3] = g[3] = 4;
            for (var i = 4; i < N; i++) {
                f[i] = (int) (((long) f[i - 1] + f[i - 2] + f[i - 3]) % MOD);
                g[i] = (int) (((long) g[i - 1] + g[i - 2] + g[i - 3] + g[i - 4]) % MOD);
            }
        }
        public int countTexts(String s) {
            int ans = 1, cnt = 0;
            for (var i = 0; i < s.length(); i++) {
                cnt++;
                var c = s.charAt(i);
                if (i == s.length() - 1 || c != s.charAt(i + 1)) {
                    ans = (int) ((long) ans * (c != '7' && c != '9' ? f[cnt] : g[cnt]) % MOD);
                    cnt = 0;
                }
            }
            return ans;
        }

        static final int mod = (int)1e9 + 7;
        public int countGoodStrings(int lo, int hi, int zero, int one) {
            // long [][] f = new long [2][hi+2];
            // f[0][zero] = 1; // 假如第一个片段是 00: 【可是再怎么往后遍历呢？】
            // f[1][one] = 1;  // 假如第一个片段是 11:
            long r = 0;
            long [] f = new long [hi+1];
            f[0] = 1;
            for (int i = 1; i <= hi; i++) {
                if (i - zero >= 0) f[i] = (f[i] + f[i - zero]) % mod;
                if (i - one >= 0) f[i] = (f[i] + f[i - one]) % mod;
                if (lo <= i && i <= hi) r = (r + f[i]) % mod;
            }
            return (int)r;
        }

        public List<Integer> goodIndices(int[] a, int k) { // 【远古时代的最朴素的写法。。。。。】
            int n = a.length;
            boolean [] l = new boolean [n], r = new boolean [n];
            ArrayDeque<Integer> s = new ArrayDeque<>();
            // 从左往右遍历：按降序排列, 抛掉不合法的
            for (int i = 0; i < k; i++) {
                while (!s.isEmpty() && a[s.peek()] < a[i]) s.pollFirst();
                s.offerFirst(i);
            }
            for (int i = k; i < n-k; i++) {
                while (!s.isEmpty() && s.peekLast() < i-k) s.pollLast(); // 把栈中非 k 范围内的【不在考虑范围的过长片段】抛掉
                if (s.size() == k) l[i] = true; // 【取解】
                // 入队列
                while (!s.isEmpty() && a[s.peek()] < a[i]) s.pollFirst();
                s.offerFirst(i);
            }
            // 从右往左遍历：同样的方法，预处理结果是否合法, 这里双端队列按升序排序【非降序】
            s.clear();
            for (int i = n-1; i >= n-k; i--) {
                while (!s.isEmpty() && a[s.peek()] < a[i]) s.pollFirst();
                s.offerFirst(i);
            }
            for (int i = n-k-1; i >= k; i--) {
                while (!s.isEmpty() && s.peekLast() > i+k) s.pollLast();
                if (s.size() == k) r[i] = true;
                while (!s.isEmpty() && a[s.peek()] < a[i]) s.pollFirst();
                s.offerFirst(i);
            }
            List<Integer> ans = new ArrayList<>();
            for (int i = k; i < n-k; i++) 
                if (l[i] && r[i]) ans.add(i);
            return ans;
        }
        public List<Integer> goodIndices(int[] a, int k) { // 【动态规划：从左往右遍历，从右往左遍历，各扫一遍】
            int n = a.length;
            List<Integer> r = new ArrayList<>();
            int [] dec = new int [n], inc = new int [n];
            Arrays.fill(dec, 1);
            Arrays.fill(inc, 1);
            for (int i = 1; i < n; i++) 
                if (a[i-1] >= a[i])
                    dec[i] = dec[i-1] + 1;
            for (int i = n-2; i >= 0; i--)
                if (a[i] <= a[i+1])
                    inc[i] = inc[i+1] + 1;
            for (int i = k; i < n-k; i++)
                if (dec[i-1] >= k && inc[i+1] >= k) r.add(i);
            return r;
        }

        // LeftStep + rightStep = k
        // RightStep - leftStep = endPos - startPos 把这两行左右各相加，得到如下：
        //        2 * rightStep = k + endPos - startPos
        //            rightStep = (k + endPos - startPos) / 2
        public int numberOfWays(int l, int r, int k) {
            int val = k + r - l;
            if (val < 0 || val % 2 == 1) return 0;
            int rightStep = val / 2;
            int leftStep = k - rightStep;
            if (leftStep < 0) return 0;
            return nChooseK(leftStep + rightStep, Math.min(leftStep, rightStep)); // Cn+m^m 组合中的选择数，数学题
        }
        static final int mod = (int)1e9 + 7;
        // C(n, k) = C(n - 1, k) + C(n - 1, k - 1)
        int nChooseK(int n, int k) {
            int [] f = new int [n+1];
            f[0] = 1;
            while (n-- > 0)
                for (int j = k; j > 0; j--) {
                    f[j] += f[j-1];
                    f[j] %= mod;
                }
            return f[k];
        }

        public long appealSum(String s) {
            int [] last = new int[26];
            long res = 0;
            int total = 0;
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                total += i + 1 - last[c - 'a'];
                last[c - 'a'] = i + 1;
                res += total;
            }
            return res;
        }

        static final int mod = (int)1e9 + 7;
        public int countWays(int[][] a) {
            Arrays.sort(a, (x, y) -> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
            // List<int []> l = new ArrayList<>(); // 并不真的合并，或是构建了再数个数
            int ans = 1, prej = -1;
            for (int [] v : a) {
                int i = v[0], j = v[1];
                if (i > prej) 
                    ans = ans * 2 % mod;
                prej = Math.max(prej, j);
            }
            return ans;
        }

        public int findValidSplit(int[] a) {
            int n = a.length;
            Map<Integer, Integer> left = new HashMap<>(); // left[p] 表示质数 p 首次出现的下标
            var right = new int [n]; // right[i] 表示左端点为 i 的区间的右端点的最大值, 是开区间，不包括取值【）
            for (int i = 0; i < n; i++) {
                int x = a[i];
                for (int d = 2; d * d <= x; d++) // 分解质因数
                    if (x % d == 0) {
                        if (left.containsKey(d))
                            right[left.get(d)] = i; // 记录左端点对应的右端点的最大值, 开区间，不包括）
                        else left.put(d, i); // 第一次遇到质数 d
// 【不明白：】为什么会需要这个步骤？【这里会把当前 x 的所有当前遍历的质因数 d 的倍数全部消掉！！！】
                        for (x /= d; x % d == 0; x /= d) ; // 消除当前数 x 的所有含 d 的质因子 
                    }
                if (x > 1) //x 值自己 
                    if (left.containsKey(x))
                        right[left.get(x)] = i;
                    else left.put(x, i);
            }
            for (int l = 0, maxR = 0; l < n; l++) { // 这里答案可能不唯一，但是因为要求返回最左边的，所以一旦找到第一个可分的，就返回 
                if (l > maxR) // 最远可以遇到 maxR
                    return maxR; // 也可以写 l-1
                maxR = Math.max(maxR, right[l]);
            }
            return -1;
        }

        public int collectTheCoins(int[] b, int[][] a) { // b: coins 【这个自己原始的方法没有写完。。。】
            n = b.length;
            // 构建无向图：先构建最完整的【因为这个时候，还无法判断是否是叶子节点】
            g = new ArrayList [n];
            Arrays.setAll(g, z -> new HashSet<>());
            for (int [] e : a) {
                int u = e[0], v = e[1];
                g[u].add(v);
                g[v].add(u);
            }
            // 删除掉；所有没有钱的叶子。。。
            for (int i = 0; i < n; i++)
                if (g[i].size() == 1 && b[i] == 0) { // 只有一个相边的节点，并且没钱，删除之。。。
                    int j = g[i].get(0);
                    g[j].remove(i);
                    g[i].remove(j); // g[i].size() == 0
                    if (g[j].size() == 0) // 不知道这么写会不会遍历漏掉什么？还是会比较多重复遍历呢？还是会把树砍掉精减到感觉意外？
                        i = Math.min(i, j) - 1;
                }
            // 再减一次树：去掉所有子叶，及其父节点
            // 【写了一半，发现参考提示的思路，仍然是不透彻。。。】
        }
        public int collectTheCoins(int[] b, int[][] a) { // b: coins
           int n = b.length;
           List<Integer> [] g = new ArrayList [n];
           Arrays.setAll(g, z -> new ArrayList<>());
           var cnt = new int [n]; // 标记每个节点上：连边的条数，用于判断是否为叶子
           for (int [] e : a) {
               int u = e[0], v = e[1];
               g[u].add(v);
               g[v].add(u);
               ++cnt[u];
               ++cnt[v];
           }
           // 用拓扑排序「剪枝」：去掉没有金币的子树
           ArrayDeque<Integer> q = new ArrayDeque<>();
           for (int i = 0; i < n; i++)
               if (cnt[i] == 1 && b[i] == 0) // 无金币叶子
                   q.offer(i);
           while (!q.isEmpty()) {
               int x = q.pop();
               for (int v : g[x])
                   if (--cnt[v] == 1 && b[v] == 0) // 这里把去掉叶子后，仍没钱的新叶子也去掉，所以去掉的是，没钱的子树，并不只是叶子节点
                       q.offer(v);
           }
           // 再次拓扑排序
           for (int i = 0; i < n; i++)
               if (cnt[i] == 1 && b[i] == 1) // 有金币叶子
                   q.offer(i);
           if (q.size() <= 1) return 0; // 至多一个有金币的叶子，直接收集
           var time = new int [n];
           while (!q.isEmpty()) {
               int x = q.poll();
               for (int v : g[x])
                   if (--cnt[v] == 1) {
                       time[v] = time[x] + 1; // 记录入队时间
                       q.offer(v);
                   }
           }
           // 统计答案
           int ans = 0;
           for (var e : a)
               if (time[e[0]] >= 2 && time[e[1]] >= 2)
                   ans += 2;
           return ans;
        }

        public long makeSubKSumEqual(int[] a, int k) {
            int n = a.length;
            k = gcd(k, n); // 解决了无限循环问题：每个元素只属于一个小组
            long ans = 0;
            for (int i = 0; i < k; i++) { // 把数组分成 k 组
                var b = new ArrayList<Integer>();
                for (int j = i; j < n; j += k) 
                    b.add(a[j]);
                Collections.sort(b); // 排序
                int mid = b.get(b.size() / 2); // 排序后就可以方便地取中位数了：为什么这里中位数取得不标准，也没关系了？
                for (int v : b)
                    ans += Math.abs(x - mid);
            }
            return ans;
        }
        int gcd(int a, int b) {
            while (a != 0) {
                int tmp = a;
                a = b % a;
                b = tmp;
            }
            return b;
        }

        public int findShortestCycle(int n, int[][] egs) {
            g = new ArrayList [n];
            Arrays.setAll(g, z -> new ArrayList<Integer>());
            for (var e : egs) {
                int u = e[0], v = e[1];
                g[u].add(v);
                g[v].add(u);
            }
            d = new int [n];
            int r = Integer.MAX_VALUE; // 【bug:】 r = n 不对，会出错！！！？？？？
            for (int i = 0; i < n; i++) 
                r = Math.min(r, bfs(i));
            return r == Integer.MAX_VALUE ? -1 : r;
        }
        List<Integer> [] g;
        int [] d;
        int bfs(int idx) {
            Arrays.fill(d, Integer.MAX_VALUE);
            d[idx] = 0;
            Deque<int []> q = new ArrayDeque<>();
            q.offerFirst(new int [] {idx, -1});;
            int r = Integer.MAX_VALUE;
            while (!q.isEmpty()) {
                // for (int size = q.size()-1; size >= 0; size--) {
                int [] cur = q.pollLast();
                int u = cur[0];
                for (int v : g[u]) {
                    // if (vis[v]) return d[u] + d[v] + 1; // 这里不是直接返回，因为可能不止一个，要取最小的。。。。。
                    // if (d[v] > step + 1) {
                    if (d[v] == Integer.MAX_VALUE) { // 第一次遇到
                        d[v] = d[u] + 1;
                        q.offerFirst(new int [] {v, u});
                        // vis[v] = true;
                    } else if (v != cur[1]) // 第二次遇到
                        r = Math.min(r, d[u] + d[v] + 1);
                }
                // }
                // step++;
            }
            return r;
        }

        Map<TreeNode, Integer> height = new HashMap<>(); // 每棵子树的高度
        int [] res; // 每个节点的答案
        public int[] treeQueries(TreeNode root, int[] queries) {
            getHeight(root);
            height.put(null, 0); // 简化 dfs 的代码，这样不用写 getOrDefault
            res = new int [height.size()];
            dfs(root, -1, 0);
            for (int i = 0; i < queries.length; i++) 
                queries[i] = res[queries[i]];
            return queries;
        }
        int getHeight(TreeNode r) {
            if (r == null) return 0;
            var h = 1 + Math.max(getHeight(r.left), getHeight(r.right));
            height.put(r, h); // 这里，把它存到字典里记住
            return h;
        }
        void dfs(TreeNode r, int d, int h) { // d: depth 当前节点的深度, h: restH 去掉节点后剩余的最大深度【从根节点往下、自顶向下数的】
            if (r == null) return ;
            ++d;
            res[r.val] = h;
            // 上面提到，这里 r.left=null 或者是 r.right=null 都是有可能的，所以当 height.get(null)=0 就可以不用判断了左右是否为空了。。。
            dfs(r.left, d, Math.max(h, d + height.get(r.right)));
            dfs(r.right, d, Math.max(h, d + height.get(r.left)));
        }

        public int[] minReverseOperations(int n, int p, int[] banned, int k) { // 这个题要再写一遍
            var ban = new boolean [n];
            ban[p] = true;
            for (int i : banned) ban[i] = true;
            TreeSet<Integer> [] ts = new TreeSet [2]; // 这里用两个有序集合来模拟一棵树？。。。
            Arrays.setAll(ts, z -> new TreeSet<>());
            for (int i = 0; i < n; i++)
                if (!ban[i]) ts[i % 2].add(i);
            ts[0].add(n);
            ts[1].add(n); // 哨兵
            var ans = new int [n];
            Arrays.fill(ans, -1);
            var q = new ArrayList<Integer>();
            q.add(p);
            for (int step = 0; !q.isEmpty(); step++) {
                var tmp = q;
                q = new ArrayList<>();
                for (int i : tmp) {
                    ans[i] = step;
                    // 从 mn 到 mx 的所有位置都可以翻转到
                    int mn = Math.max(i - k + 1, k - i -1);
                    int mx = Math.min(i + k - 1, n * 2 - k - i - 1);
                    var s = ts[mn % 2];
                    for (var j = s.ceiling(mn); j <= mx; j = s.ceiling(mn)) {
                        q.add(j);
                        s.remove(j);
                    }
                }
            }
            return ans;
        }

        public long [] distance(int[] a) { 
            int n = a.length;
            Map<Integer, List<Integer>> gp = new HashMap<>();
            for (int i = 0; i < n; i++) // 相同元素分到同一组，记录下标 
               gp.computeIfAbsent(a[i], z -> new ArrayList<>()).add(i);
            long [] r = new long [n];
            long [] s = new long [n+1]; // 用来计算 prefixSum 和
            for (Map.Entry<Integer, List<Integer>> en : gp.entrySet()) {
                List<Integer> l = en.getValue();
                int m = l.size();
                for (int i = 0; i < m; i++) 
                    s[i+1] = s[i] + l.get(i); // 前缀和【这里没有区分不用链表呀，没有清0 重置过？】【不用重置：因为】s[0] = 0 forever ！！！
                for (int i = 0; i < m; i++) {
                    int v = l.get(i);
                    long left = (long) v * i - s[i]; // 蓝色面积
                    long right = s[m] - s[i] - (long)v * (m - i); // 绿色面积
                    r[v] = left + right;
                }
            }
            return r;
        }
        public long [] distance(int[] a) { 
            int n = a.length;
            Map<Integer, List<Integer>> gp = new HashMap<>();
            for (int i = 0; i < n; i++) // 相同元素分到同一组，记录下标 
               gp.computeIfAbsent(a[i], z -> new ArrayList<>()).add(i);
            long [] r = new long [n];
            for (var l : gp.values()) { // 遍历字典里的值：各个链表 
                int m = l.size();
                long s = 0;
                for (int v : l) s += v - l.get(0); // a[0] 到其它下标的距离之和
                r[l.get(0)] = s;
                for (int i = 1; i < m; i++) 
                    // 从计算 a[i-1] 到计算 a[i]，考虑 s 增加了多少
                    r[l.get(i)] = s += (long)(i * 2 - m) * (l.get(i) - l.get(i-1));
            }
            return r;
        }

        public int maximumTastiness(int[] a, int k) {
            int n = a.length;
            Arrays.sort(a);
            System.out.println(Arrays.toString(a));
            int l = 0, r = a[n-1] - a[0], ans = 0;
            while (l <= r) {
                int m = l + (r - l) / 2;
                if (check(m, a, k)) {
                    ans = Math.max(ans, m);
                    l = m+1;
                } else r = m-1;
            }
            return ans;
        }
        boolean check(int v, int [] a, int k) {
            int n = a.length;
            // for (int i = 0; i+k <= n; i++) { // 永远贪心地去选第一个最小的，再先其它的。。。
            int r = 1, pre = 0;
            // for (int j = i+1; j < n; j++) 
            for (int j = 1; j < n; j++) 
                if (a[j] - a[pre] >= v) {
                    pre = j;
                    r++;
                }
            if (r >= k) return true;
            // }
            return false;
        }

        public boolean isItPossible(String S, String T) { // 97/99 passed.... who knows why???
            int m = S.length(), n = T.length();
            char [] s = S.toCharArray();
            char [] t = T.toCharArray();
            int [] one = new int [26], two = new int [26];
            for (char c : s) one[c-'a']++;
            for (char c : t) two[c-'a']++;
            int cntOne = 0, cntTwo = 0;
            for (int v : one)
                if (v > 0) cntOne++;
            for (int v : two)
                if (v > 0) cntTwo++;
            for (int i = 0; i < 26; i++) {
                if (one[i] == 0) continue;
                for (int j = 0; j < 26; j++) {
                    if (two[j] == 0) continue;
                    if (i == j && cntOne == cntTwo) return true;
                    int a = (one[j] == 0 ? 1 : 0) - (one[i] > 1 ? 0 : 1);
                    int b = (two[i] == 0 ? 1 : 0) - (two[j] > 1 ? 0 : 1);
                    if (cntOne + a == cntTwo + b) return true;
                }
            }
            return false;
        }
        public boolean isItPossible(String word1, String word2) {
            Map<Character, Integer> c1 = new HashMap<>(), c2 = new HashMap<>();
            for (char c : word1.toCharArray()) c1.merge(c, 1, Integer::sum);
            for (char c : word2.toCharArray()) c2.merge(c, 1, Integer::sum);
            for (var e : c1.entrySet())
                for (var f : c2.entrySet()) {
                    char x = e.getKey(), y = f.getKey();
                    if (x == y) {
                        if (c1.size() == c2.size()) return true;
                    } else if (c1.size() - (e.getValue() == 1 ? 1 : 0) + (c1.containsKey(y) ? 0 : 1) ==
                               c2.size() - (f.getValue() == 1 ? 1 : 0) + (c2.containsKey(x) ? 0 : 1)) // 基于长度计算变化量
                        return true;
                }
            return false;
        }

        static final int mod = (int)1e9 + 7;
        public int peopleAwareOfSecret(int n, int delay, int forget) {
            var f = new int [n];
            f[0] = 1;
            var r = 0;
            for (int i = 0; i < n; i++) {
                // 第 i 天产生了 f[i] 的利息，这些利息又可以在第 [i+delay,i+forget) 天产生新的利息
                if (i + delay >= n) r = (r + f[i]) % mod;
                // 第 i 天产生了 f[i] 的利息，这些利息又可以在第 [i+delay,i+forget) 天产生新的利息
                for (int j = i+delay; j < Math.min(i + forget, n); j++)
                    f[j] = (f[j] + f[i]) % mod;
            }
            return (f[n-1] + r) % mod;
        }

        public int minimumNumbers(int v, int k) {
            if (v == 0) return 0;
            for (int i = 1; i <= 10 && v - k * i >= 0; i++) 
                if ((v - k * i) % 10 == 0) return i;
            return -1;
        }

        public int maximumsSplicedArray(int[] a, int[] b) { // 自己的呆笨写法。。。。。
            int n = a.length;
            int [] d = new int [n];
            for (int i = 0; i < n; i++) d[i] = b[i] - a[i];
            int one = 0, cur = 0, neg = 0, two = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (cur < 0) cur = d[i];
                else cur += d[i];
                if (neg > 0) neg = d[i];
                else neg += d[i];
                one = Math.max(one, cur);
                two = Math.min(two, neg);
            }
            int sa = Arrays.stream(a).sum(), sb = Arrays.stream(b).sum();
            int ans = Math.max(sa, sb);
            ans = Math.max(ans, Math.max(one + sa, one * (-1) + sb));
            ans = Math.max(ans, Math.max(two * (-1) + sb, two + sa));
            return ans;
        }
        public int maximumsSplicedArray(int[] nums1, int[] nums2) { // 同样的方法，执行了两遍
            return Math.max(solve(nums1, nums2), solve(nums2, nums1));
        }
        int solve(int [] a, int [] b) {
            int n = a.length;
            int sa = 0, maxSum = 0;
            for (int i = 0, s = 0; i < n; i++) {
                sa += a[i];
                s = Math.max(s + b[i] - a[i], 0); // 《 0 时，重置为0. 否则下面总记最大值 
                maxSum = Math.max(maxSum, s);     // 过程中的最大值总被记录下来了
            }
            return sa + maxSum;
        }

        Set<Long> s = new HashSet<>();
        List<Integer> [] g;
        int k, ans, cnt0;
        public int rootCount(int[][] egs, int[][] gss, int k) { // TODO TODO TODO 
            this.k = k;
            // 建图
            g = new ArrayList [egs.length+1];
            Arrays.setAll(g, z -> new ArrayList<>());
            for (int [] e : egs) {
                int u = e[0], v = e[1];
                g[u].add(v);
                g[v].add(u);
            }
            for (var v : gss)  // guesses 转成哈希表
                s.add((long)v[0] << 32 | v[1]); // 两个 4 字节数压缩成一个 8 字节数
            dfs(0, -1); // 数一遍以 0 为节点时，猜对的边数 cnt0
            reroot(0, -1, cnt0); // 【换更动态DP:】这里还有点儿没能理解透彻，要再看一下
            return ans;
        }
        void dfs(int u, int p) {
            for (var v : g[u]) 
                if (v != p) {
                    if (s.contains((long) u << 32 | v)) // 以 0 为根时，猜对了
                        ++cnt0;
                    dfs(v, u);
                }
        }
        void reroot(int u, int p, int cnt) {
            if (cnt >= k) ++ans; // 此时 cnt 就是以 u 为根时的猜对次数
            for (var v : g[u]) 
                if (v != p) {
                    int c = cnt;
                    if (s.contains((long)u << 32 | v)) --c; // 原来是对的，现在错了
                    if (s.contains((long)v << 32 | u)) ++c; // 原来是错的，现在对了
                    reroot(v, u, c);
                }
        }

        static final int mod = (int)1e9 + 7;
        public int numberOfPaths(int[][] a, int k) { // 【思路完全正确】就是代码还需要一点点优化。。。精减
            int m = a.length, n = a[0].length;
            long [][][] f = new long [m+1][n+1][k];
            for (int i = 1; i <= m; i++)
                for (int j = 1; j <= n; j++) {
                    int v = a[i-1][j-1];
                    if (i == 1 && j == 1) { // 这么写还是太复杂了。。。
                        f[i][j][v % k] = 1;
                        continue;
                    }
                    for (int x = 0; x < k; x++) { // 这里面就进行了无数次的重复？显得没有理解透彻，或是说思路不清晰透彻
                        int o = (x + v) % k;
                        f[i][j][o] = (f[i][j][o] + f[i][j-1][x]) % mod;
                        f[i][j][o] = (f[i][j][o] + f[i-1][j][x]) % mod;
                    }
                }
            return (int)f[m][n][0];
        }
        static final int mod = (int)1e9 + 7;
        public int numberOfPaths(int[][] a, int k) { // 【思路完全正确】就是代码还需要一点点优化。。。精减
            int m = a.length, n = a[0].length;
            int [][][] f = new int [m+1][n+1][k];
            // 此时可以设初始值 f[0][1][0]=1（或者 f[1][0][0]=1）简化一点点代码
            f[0][1][0] = 1; // f[1][0][0] = 1; // 前后两个哪个都可以的。。。
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    for (int v = 0; v < k; v++) 
                        f[i+1][j+1][(v + a[i][j]) % k] = (f[i+1][j][v] + f[i][j+1][v]) % mod;
            return f[m][n][0];
        }
        
        // 第一种方法：原始，相对比较土。。。。。
        public boolean splitArraySameAverage(int[] a) {
            if (a.length == 1) return false;
            int n = a.length, sum = Arrays.stream(a).sum(), m = n / 2;
            // 把原数组和变0, 并且不引入任何浮点数
            for (int i = 0; i < n; i++) a[i] = a[i] * n - sum;
            // // 把原数组分成两个大小最接近的数组【再说一遍：概念上的，并不真的需要物理上的拆分为两个数组。。。】
            // int [] l = Arrays.copyOfRange(a, 0, n/2); // 【L-inclusive, r-excluesive）
            // int [] r = Arrays.copyOfRange(a, n/2, n);
            // 求一个数组可能取得的和 sum 集合
            Set<Integer> lsum = new HashSet<>();
            for (int i = 1; i < (1 << m); i++) {
                int s = 0;
                for (int j = 0; j < m; j++) // 这里可能会遍历多了
                    if (((i >> j) & 1) == 1) s += a[j];
// 【快速返回：】这里是可以优化提速的地方。左边非空集合和为0, 那么左边非空补集的和也一定为 0
                if (s == 0) return true; 
                lsum.add(s);
            }
            // 遍历：求右边数组可能取得的和 s，并一一去找左边是否存在和 -s
            int rsum = 0; // 先求右边的和：
            for (int i = m; i < n; i++) rsum += a[i];
            for (int i = 1; i < (1 << n - m); i++) {
                int s = 0;
                for (int j = m; j < n; j++) // 这里可能会遍历多了
                    if (((i >> (j - m)) & 1) == 1) s += a[j];
                // if (s == 0 || lsum.contains(-s)) return true; // 【BUG:】
                if (s == 0 || s != rsum && lsum.contains(-s)) return true; // 【为什么 s ！＝ rsum 重要？】【3, 1】＝＝》【2, －2】
            }
            return false;
        }
        public boolean splitArraySameAverage(int[] a) {
            if (a.length == 1) return false;
            int n = a.length, m = n / 2, sum = Arrays.stream(a).sum();
            boolean isPossible = false;
            for (int i = 1; i <= m; i++)
                if (sum * i % n == 0) {
                    isPossible = true;
                    break;
                }
            if (!isPossible) return false;
            Set<Integer> [] f = new HashSet [m+1];
            Arrays.setAll(f, z -> new HashSet<>());
            f[0].add(0);
            for (int v : a) 
                for (int i = m; i >= 1; i--) 
                    for (int x : f[i-1]) {
                        int cur = x + v;
                        if (cur * n == sum * i) return true;
                        f[i].add(cur);
                    }
            return false;
        }
        
        public int maxPalindromes(String t, int k) {
            int n = t.length();
            char [] s = t.toCharArray();
            int [] f = new int [n+1];
            for (int i = 0; i < 2 * n - 1; i++) {
                int l = i / 2, r = l + i % 2; // 中心扩展法【这个方法忘记了，或是没有彻底懂，要复习一下】
                f[l+1] = Math.max(f[l+1], f[l]);
                for (; l >= 0 && r < n && s[l] == s[r]; --l, ++r)     
                    if (r - l + 1 >= k) {
                        f[r+1] = Math.max(f[r+1], f[l]+1);
                        break;
                    }
            }
            return f[n];
        }

        // 活宝妹就是还一定要嫁给亲爱的表哥～～！！！【爱表哥，爱生活！！！】
        public int maxNumOfMarkedIndices(int[] a) {
            int n = a.length, ans = 0;
            int l = 0, r = n / 2;
            Arrays.sort(a);
            while (l <= r) { // 二分查找：查找到一个最大可能的操作次数，注意边界
                int m = (l + r) / 2;
                if (possible(m, a)) {
                    ans = Math.max(ans, m * 2);
                    l = m + 1;
                } else r = m-1;
            } 
            return ans;
        }
        boolean possible(int k, int [] a) {
            for (int i = 0; i < k; i++) // 遍历最小的K 个数，每个 i，与最大的 n-k+i 个数,组成对
                if (2 * a[i] > a[a.length - k + i]) return false;
            return true;
        }

        public int minimumDifference(int[] a) { // 还有点儿没有看懂。。。。。 
            int n = a.length, m = n / 2, N = (1 << m), sum [] = new int [N];
            // 设置初始值 sum[0]，全部分配给第一个子数组，全部做减法。
            for (int i = 0; i < m; i++) sum[0] -= a[i];
            TreeSet<Integer> [] l = new TreeSet[m+1];
            Arrays.setAll(l, z -> new TreeSet<Integer>()); // 改为只在必要的情况下才添加
            l[0].add(sum[0]);
            for (int i = 1; i < N; i++) { // 因为使用了前面的预处理数组，就可以一遍O(N) 时间找到左侧所有长度的所有答案。。。
                // 枚举一个先前的状态 prev = i ^ (1 << j)，相当于在 prev 的基础上将第 j 位分配给
                // 了第一个数组，原先 nums[j] 是减法的，现在要改成加法，则递推式为 sum[i] = sum[prev] + nums[j] + nums[j]。
                int bitsCnt = Integer.bitCount(i);
                // 计算后导零个数，1 << j 应该是一个 1，且 i - (1 << j) 是更新过的状态，可以利用该状态更新sums[i]。
                // （也可以枚举一个包含在 i 内的位 j 来更新）
                int j = Integer.numberOfTrailingZeros(i); // 【这里机关】，像是没看懂。。。这里像是从 i 的最高位，往 i 的低位添加新的数组元素。。。
                sum[i] = sum[i ^ (1 << j)] + 2 * a[j];
                // 将当前的和记录到对应的 1 的个数下面。
                l[bitsCnt].add(sum[i]);
                // int cur = 0, cnt = 0;
                // for (int j = 0; j < m; j++)  // 【O(NM)】太慢了。。。
                //     if (((i >> j) & 1) == 1) {
                //         cur += a[j];
                //         cnt++;
                //     }
                // l[cnt].add(cur);
            }     
            // for (int i = 0; i < (1 << n-m); i++) {
            //     int cnt = 0, cur = 0;
            //     for (int j = m; j < n; j++) 
            //         if (((i >> (j-m)) & 1) == 1) {
            //             cnt++;
            //             cur += a[j];
            //         }
            //     r[cnt].add(cur);
            // }
            int min = Integer.MAX_VALUE;
            // 再处理右边的同时直接检查左边部分对应的情况。
            Arrays.fill(sum, 0);
            for (int i = 0; i < m; i++) sum[0] -= a[m+i];
            for (int i = 0; i < N; i++) {
                int bitsCnt = Integer.bitCount(i);
                if (i != 0) {
                    int j = Integer.numberOfTrailingZeros(i);
                    sum[i] = sum[i ^ (1 << j)] + 2 * a[j+m];
                }
                // 寻找左侧 1 的个数位 n - bits 个的编码中和最接近 -sum[i] 的两个数。
                Integer v = l[m - bitsCnt].ceiling(-sum[i]); // 直接在两个有序集合中二分查找，快狠多（O(NlgN)）
                if (v != null) min = Math.min(min, Math.abs(v + sum[i]));
                v = l[m - bitsCnt].floor(-sum[i]);
                if (v != null) min = Math.min(min, Math.abs(v + sum[i]));
            }
            // for (int i = 0; i <= m; i++) {
            //     for (int x : l[i]) // 这里是顺序遍历，两个集合中所有元素的两两比较，太慢 O(N^2)
            //         for (int v : r[m-i]) 
            //             min = Math.min(min, Math.abs(sum - (x + v) * 2));
            // }
            return min;
        }

        static final int mod = (int)1e9 + 7;
        Set<Character> pc = new HashSet<>(List.of('2', '3', '5', '7'));
        public int beautifulPartitions(String t, int k, int l) {
            int n = t.length();
            char [] s = t.toCharArray();
            // 【剪枝】: 所有可能出现的无解情况
            if (k * l > n || !pc.contains(s[0]) || pc.contains(s[n-1])) return 0;
            var f = new int [k+1][n+1]; // 这里一维好像不够用，怎么知道最后是有 k 个片段呢》？所以就自己再加一维嘛，你看题解也是这样的。。。
            f[0][0] = 1;
            for (int i = 1; i <= k; i++) {
                int sum = 0;
                // 优化：枚举的起点和终点需要给前后的子串预留出足够的长度. 也就是说，对于当前的第 i 个片段，必须留足给后面至少 (k-i) 个片段的最小长度 (k-i)*l 给它们用
                for (int j = i * l; j + (k - i) * l <= n; j++) { // 对于当前片段，遍历和统计，当前第 i 段所有可能取得的最多划分方法
                    if (canPartition(s, j-l)) sum = (sum + f[i-1][j-l]) % mod; // 对前第 i 段备选下标 j 中【 i*l,n-(k-i)*l】，所有先前拆分方法的累加和
                    if (canPartition(s, j)) f[i][j] = sum; // 如果【 i*l,n-(k-i)*l】中的某个当前 j 也为有效拆分，更新结果
                }
            }
            return f[k][n];
        }
        // 判断是否可以在 j-1 和 j 之间分割（开头和末尾也算）
        boolean canPartition(char [] s, int j) {
            return j == 0 || j == s.length || !pc.contains(s[j-1]) && pc.contains(s[j]);
        }

        public int longestCycle(int[] edges) {
            int n = edges.length, ans = -1;
            int [] time = new int [n];
            for (int i = 0, clock = 1 ; i < n; i++) { // 从每个节点出发，找自这个节点出发的最大环。。。
                if (time[i] > 0) continue; // 如果这个出发节点，是某个环，或是某个节点出发的过程中节点，可以跳过不用重复
                System.out.println("\n i: " + i);
                System.out.println(Arrays.toString(time));
                for (int x = i, startTime = clock; x >= 0; x = edges[x]) { // 是从 x 节点，有向往后遍历
                    if (time[x] > 0) { // 重复访问
                        if (time[x] >= startTime) // 找到了一个新的环
                            ans = Math.max(ans, clock - time[x]);
                        break;
                    }
                    time[x] = clock++;
                }
                System.out.println(Arrays.toString(time));
            }
            return ans;
        }

        // 【纯数学题：】这样的题目好恶心，能基本理解透彻就可以了。。。
        static final int mod = (int)1e9 + 7, MX = (int)1e4 + 1, MXK = 13; // 至多 13 个质因数
        static List[] ks = new List[MX]; // ks[x] 为 x 分解质因数后，每个质因数的个数列表
        static int [][] c = new int [MX + MXK][MXK + 1]; // 组合数
        static {
            // 预处理：【1, 13) 分解质因子的个数
            for (int i = 1; i < MX; i++) {
                ks[i] = new ArrayList<Integer>();
                int x = i;
                for (int p = 2; p * p <= x; p++) 
                    if (x % p == 0) {
                        var k = 1;
                        for (x /= p; x % p == 0; x /= p) ++k;
                        ks[i].add(k);
                    }
                if (x > 1) ks[i].add(1);
            }
            // 预处理：组合数组
            c[0][0] = 1;
            for (int i = 1; i < MX + MXK; i++) {
                c[i][0] = 1;
                for (int j = 1; j <= Math.min(i, MXK); j++) 
                    c[i][j] = (c[i-1][j] + c[i-1][j-1]) % mod;
            }
        }
        public int idealArrays(int n, int maxValue) {
            long ans = 0l;
            for (int i = 1; i <= maxValue; i++) {
                var mul = 1l;
                for (var k : ks[i]) mul = mul * c[n+(int)k-1][(int)k] % mod;
                ans += mul;
            }
            return (int)(ans % mod);
        }

        // 长度是5 的数字回文 [__X__] 那么前两位共有 100 种可能性，它说暴力所有可能性
        static final int mod = (int)1e9 + 7;
        public int countPalindromes(String T) {
            int n = T.length(), m = 10;
            char [] t = T.toCharArray();
            // 想到过用 l[n][0...9] 和 r[n][0...9] 来统计个数【但没能想透】
            int [] p = new int [m], s = new int [m]; // 记录：前缀后缀各数字出现的次数
            int [][] pr = new int [m][m], su = new int [m][m]; // 记录组合出现的次数
            // 从后往前遍历：统计后缀数组，数字出现的次数实时更新，以及组合在后缀中出现的累积次数，时实更新
            for (int i = n-1; i >= 0; i--) {
                int k = t[i] - '0';
                for (int j = 0; j < m; j++) // 因为当前数字 k 的存在， k_ 在后缀中的出现次数全部更新 for — in 【0...9】
                    su[k][j] += s[j];
                s[k]++;
            }
            // 从前往后遍历：统计前缀数组，数字出现的次数实时更新，以及组合在前缀中出现的累积次数，时实更新【把这一步的工作，转变成一次遍历，实时同步进行】
// 【100 种可能的组合：共多少种可能性 x】—X—【被固定了的100 种组合，共多少种可能性 y】＝ sum 【2,n-3】（x*y）
            long r = 0;
            for (var d : t) {
                d -= '0';
                --s[d]; // 【撤销：】这些撤销的细节，要注意 
                for (int j = 0; j < m; j++)
                    su[d][j] -= s[j]; // 【撤销：】由当前回文中间数字下标 d 所产生的所有后缀相关可能性
                for (int j = 0; j < m; j++) 
                    for (int k = 0; k < m; k++)
                        // r += (long)pr[j][k] * su[k][j]; // 枚举所有字符组合【这里想不通：后缀不是该乘 su[k][j] 才对吗？】
                        r += (long)pr[j][k] * su[j][k]; // 枚举所有字符组合【后缀不是该乘 su[k][j] 才对吗？？ pr 从左往右遍历， su 从右往左遍历】
                for (int j = 0; j < m; j++) // 【动态更新】：从左往右遍历的，变成了同步一遍从左往右遍历
                    pr[d][j] += p[j];
                p[d]++;
            }
            return (int)(r % mod);
        }

        // 【数位DP:】传说中的数位 DP 呀，就被我忘记得这么一干二净的？！！！【爱表哥，爱生活！！！】
        public int countSpecialNumbers(int n) { // 【DFS 记忆化搜索】？方法名的不同，这也是回字的四样写法？
            s = Integer.toString(n).toCharArray();
            int m = s.length;
            f = new int [m][1 << 10];
            Arrays.stream(f).forEach(z -> Arrays.fill(z, -1)); // -1 表示没有计算过
            return dfs(0, 0, true, false);
        }
        int f[][];
        char s[];
        // 【DFS 记忆化搜索】【数位DP】：带各种状态的，把这个模板理解透彻，记牢了。。。！！！
        int dfs(int idx, int mask, boolean isLimit, boolean isNum) {
            if (idx == s.length) return isNum ? 1 : 0; // isNum 为 true 表示得到了一个合法数字
            if (!isLimit && isNum && f[idx][mask] != -1) return f[idx][mask]; // 第二次遍历，直接返回先前算过的结果
            int ans = 0;
            if (!isNum) // 可以跳过当前数位
                ans = dfs(idx+1, mask, false, false);
            // 【当前 idx 位的上界：】最大取值：如果前面填的数字都和 n 的一样，那么这一位至多填数字 s[i]（否则就超过 n 啦）
            int up = isLimit ? s[idx] - '0' : 9;
            for (int d = isNum ? 0 : 1; d <= up; d++) // 枚举要填入当前位 idx 的合法数字 d 。【 isNum: 为真时，表示先前 <idx 位填入过数，所以当前可以填 0】
                if ((mask >> d & 1) == 0) // d 不在 mask 中
                    ans += dfs(idx+1, mask | (1 << d), isLimit && d == up, true); // 注意这里 d==up 限制条件的加入
            if (!isLimit && isNum) f[idx][mask] = ans;
            return ans;
        }

        // 【方法一：记忆化搜索】：为什么会感觉这个题跟记忆化搜索对应不起来呢？
        public long minimumTotalDistance(List<Integer> ro, int[][] factory) {
            Arrays.sort(factory, (x, y) -> x[0] - y[0]); // 升序排列
            var r = ro.stream().mapToInt(i -> i).toArray();
            Arrays.sort(r); // 升序排列
            n = r.length;
            m = factory.length;
            f = new long [n][m];
            Arrays.stream(f).forEach(z -> Arrays.fill(z, (long)1e13));
            return dfs(0, 0, r, factory);
        }
        long [][] f;
        int m, n;
        long dfs(int u, int v, int [] r, int [][] factory) {
// 所有的机器人，都修理完了
            if (u == n) return 0;
// 记忆化返回            
            if (v < m && f[u][v] != (long)1e13) return f[u][v];
// 处理最后一个工厂的工作任务
            if (v == m-1) { 
                if (factory[v][1] < n - u) return (long)1e13; // 永远无法完成
                // 计算最后一个修配厂：处理最后这些所有剩余待处理机器人的总代价
                long ans = 0;
                for (int i = u; i < n; i++) 
                    ans += Math.abs(r[i] - factory[v][0]);
                return f[u][v] = ans;
            }
// 处理所有过程中状态转移
            long ans = dfs(u, v+1, r, factory), cost = 0; // 当前工厂不想做事：本工罢工！！！
            for (int i = u; i < Math.min(u + factory[v][1], n); i++) { // 注意这里的取值上限。。。
                cost += Math.abs(factory[v][0] - r[i]);
                ans = Math.min(ans, cost + dfs(i+1, v+1, r, factory));
            }
            return f[u][v] = ans;
        }        
        // 【方法二：动规】
        public long minimumTotalDistance(List<Integer> ro, int[][] factory) {
            Arrays.sort(factory, (x, y) -> x[0] - y[0]); // 升序排列
            var r = ro.stream().mapToInt(i -> i).toArray();
            Arrays.sort(r); // 升序排列
            int m = factory.length, n = r.length;
            var f = new long [n+1]; // 原本是二维 dp, 第一维被优化掉了。第一维度表示 i 个工厂
            Arrays.fill(f, (long)1e18);
            f[0] = 0;
            // 枚举每个工厂可以修理 k 个在【0,v[1]】范围内的 k 个机器人的最小移动距离
            for (var v : factory) // 第一维度表示 i 个工厂 
                for (int j = n; j > 0; j--) { // 不知道这里为什么 j 会倒序遍历？【它说，可以选 n 台电脑里的任意最多 k 台给第 i 个工厂来修】取全局最小。。【O(NNM)】。
                    var cost = 0l;
                    for (int k = 1; k <= Math.min(j, v[1]); k++) { // 这里为什么 k 没有取 0 呢？【0, min【 j,v[1]】】
                        cost += Math.abs(r[j-k] - v[0]);
                        f[j] = Math.min(f[j], f[j-k] + cost);
                    }
                }
            return f[n];
        }

        public long maximumBeauty(int[] a, long cnt, int target, int full, int partial) {
            long n = a.length;
            Arrays.sort(a);
            if (a[0] >= target) return n * full; // 剪枝，此时所有花园都是完善的
            long leftFlowers = cnt - target * n; // 填充后缀后，剩余可以种植的花
            for (int i = 0; i < n; i++) {
                a[i] = Math.min(a[i], target); // 去掉多余的花
                leftFlowers += a[i]; // 补上已有的花: 在填充后缀之后，剩余 leftFlowers朵花可以种植
            }
            long ans = 0;
            long sumFlowers = 0;
            for (int i = 0, x = 0; i <= n; i++) { // 枚举后缀长度 n-i: 完美花园枚举为 (n-i) 个
                if (leftFlowers >= 0) {
                    // 计算最长前缀的长度: x 是右指针，尽可能地右移
                    while (x < i && (long)a[x] * x - sumFlowers <= leftFlowers)
                        sumFlowers += a[x++]; // 注意 x 只增不减，二重循环的时间复杂度为 O(n) 【对所有的 i 从【0,n】来说】，共是O(N^2)
                    long beauty = (n - i) * full; // 计算总美丽值
                    if (x > 0) beauty += Math.min((leftFlowers + sumFlowers) / x, (long)target - 1) * partial;
                    ans = Math.max(ans, beauty);
                }
                if (i < n) leftFlowers += target - a[i];
            }
            return ans;
        }

        // 【方法一：】完全按照提示：二分查找窗口宽度 + 滑动窗口
        public int maximumRobots(int[] a, int[] b, long v) {
            n = a.length;
            int ans = 0;
            p = new long [n];// prefixSum for cost b[]
            for (int i = 0; i < n; i++) 
                p[i] = (i == 0 ? 0 : p[i-1]) + b[i];
            // 二分查找：找一个存在的最大可能片段的最大长度
            int l = 1, r = n;
            while (l <= r) {
                int m = (l + r) / 2;
                if (exist(m, a, v)) {
                    ans = Math.max(ans, m);
                    l = m+1;
                } else r = m-1;
            }
            return ans;
        }
        long [] p;
        int n;// deque 【 offerFirst--> pollLast-->】【下面的代码写得还是太繁琐了一点儿】
        boolean exist(int v, int [] a, long t) { // 用滑动窗口遍历，来找长度为 v 的片段是否存在
            ArrayDeque<Integer> q = new ArrayDeque<>();   // 单调递增？双向队列？【目的是做到：O(N) 遍历O(1) 取最值？】
            for (int i = 0; i < v-1; i++) {
                while (!q.isEmpty() && a[q.peekFirst()] <= a[i]) q.pollFirst(); // 入队列时，为维护单调递增，把所有《＝的元素扔出去。。。
                q.offerFirst(i); // 入队列
            }
            for (int i = v-1; i < n; i++) {
                while (!q.isEmpty() && a[q.peekFirst()] <= a[i]) q.pollFirst(); // 入队列时，为维护单调递增，把所有《＝的元素扔出去。。。
                q.offerFirst(i); // 入队列
                if (q.peekLast() == i-v) q.pollLast();
// 【取解】片段长度，达标，检测结果是否合法
                if (t - ((long)a[q.peekLast()] + (long)v * (p[i] - (i == v-1 ? 0 : p[i-v]))) >= 0) return true;
            }
            return false;
        }
        // 【方法二：】长度不固定的动态滑动窗口
        public int maximumRobots(int[] a, int[] b, long v) {
            int n = a.length;
            int ans = 0;
            long sum = 0;
            ArrayDeque<Integer> q = new ArrayDeque<>(); // 【单调升序；】从左到右上升，First【左右】Last
            for (int i = 0, j = 0; i < n; i++) {
                while (!q.isEmpty() && a[q.peekFirst()] <= a[i]) q.pollFirst(); // 维护队列单调上升
                q.offerFirst(i);
                sum += b[i];
                while (!q.isEmpty() && j < i && (long)a[q.peekLast()] + (i - j + 1) * sum > v) {
                    if (!q.isEmpty() && q.peekLast() == j) q.pollLast();
                    sum -= b[j++]; // 【BUG:】这里的情况下，当左边往外扔，若有在队列里的，队列里得同步更新
                }
                if (!q.isEmpty() && (long)a[q.peekLast()] + (i - j + 1l) * sum <= v)
                    ans = Math.max(ans, i - j + 1);
            }
            return ans;
        }

        // 现在看，不是极其简单吗？为什么之前一直没写呢？这些数据结构都是再简单不过的。。。【爱表哥，爱生活！！！活宝妹就是还一定要嫁给亲爱的表哥～～】
        public int mostBooked(int n, int[][] a) {
            Arrays.sort(a, (x, y) -> x[0] - y[0]);
            Queue<Integer> r = new PriorityQueue<>();
            Queue<int []> m = new PriorityQueue<>((x, y) -> x[1] != y[1] ? x[1] - y[1] : x[0] - y[0]);
            int [] cnt = new int [n];
            for (int i = 0; i < n; i++) r.add(i);
            for (int [] e : a) {
                int i = e[0], j = e[1];
                while (!m.isEmpty() && m.peek()[1] <= i) r.add(m.poll()[0]); // 【BUGGLY:】这里要把及时空出来的房间回归再利用
                if (r.size() > 0) {
                    int v = r.poll();
                    cnt[v]++;
                    m.add(new int [] {v, j});
                } else {
                    int [] cur = m.poll();
                    int v = cur[0];
                    m.add(new int [] {v, cur[1] + j - i}); // 【BUGGLY:】注意这里的延迟时间，需要加上
                    cnt[v]++;
                } 
            }
            int ans = 0;
            for (int i = 0; i < n; i++)
                if (cnt[i] > cnt[ans]) ans = i;
            return ans;
        }

        public long minCost(int[] a, int[] b) {
            n = a.length;
            if (n == 1 || Arrays.stream(a).distinct().count() == 1) return 0;
            long ans = Long.MAX_VALUE;
            // 这里要演算、推算：从第 i 个元素变到第 i+1 个元素后，和的变化？
            int l = 1, r = (int)1e6 + 1;
            while (l <= r) {
                int m = (l + r) >> 1;
        // 每次取mid和mid+1对应的总cost，如果前者总cost小于后者，说明最优解在左边，如果大于，则在右边
                long left = getCost(m, a, b), right = getCost(m+1, a, b);
                if (left <= right) {
                    ans = Math.min(ans, left);
                    r = m-1;
                } else l = m+1;
            }
            return ans;
        }
        int n;
        long getCost(int v, int [] a, int [] b) {
            long r = 0;
            for (int i = 0; i < n; i++)
                r += (long)Math.abs(a[i] - v) * b[i];
            return r;
        }

        public int maximumScore(int[] a, int[][] egs) {
            int n = a.length;
            List<int []> [] g = new ArrayList [n];
            Arrays.setAll(g, z -> new ArrayList<>());
            for (int [] e : egs) {
                int u = e[0], v = e[1];
                g[u].add(new int [] {v, a[v]});
                g[v].add(new int [] {u, a[u]});
            }
            for (int i = 0; i < n; i++) {
                g[i].sort((x, y) -> y[1] - x[1]);
                if (g[i].size() > 3) g[i] = new ArrayList<>(g[i].subList(0, 3));
            }
            int r = -1;
            for (int [] e : egs) {
                int u = e[0], v = e[1];
                for (var x : g[u]) {
                    int c = x[0];
                    for (var y : g[v]) {
                        int b = y[0];
                        if (c != v && b != u && c != b)
                            r = Math.max(r, x[1] + y[1] + a[u] + a[v]);
                    }
                }
            }
            return r;
        }

        // 真想恋亲爱的表哥呀，今天晚上要去路过一下看看。。。。。【活宝妹就是还一定要嫁给亲爱的表哥～～】
        // 用两个栈，用第一个栈，当是搭了个桥。。。
        private static int[] s = new int[100000], t = new int[100000]; // 由于有一个整体拷贝的过程，用数组模拟栈
        public int[] secondGreaterElement(int[] a) {
            int n = a.length, i = 0, j = 0;
            int [] r = new int [n];
            Arrays.fill(r, -1);
            // ArrayDeque<Integer> s = new ArrayDeque<>(), t = new ArrayDeque<>(); // 【递减单调栈】
            // for (int i = 0; i < n; i++) {
            //     if (!s.isEmpty() && a[s.peekFirst()] < a[i]) // 当 while 循环时
            //         t.offerFirst(s.pollFirst()); // 【想不清楚：】怎么保持原顺序入栈，当元素多于 1 时
            // }
            for (int k = 0; k < n; k++) {
                int v = a[k];
                while (j > 0 && a[t[j-1]] < v)
                    r[t[--j]] = v;
                int ii = i;
                while (i > 0 && a[s[i-1]] < v]) --i;
                System.arraycopy(s, i, t, j, ii - i);
                j += ii - i;
                s[i++] = k;
            }
            return r;
        }

        public long kSum(int[] a, int k) {
            int n = a.length;
            long sum = 0;
            for (int i = 0; i < n; i++)
                if (a[i] > 0) sum += a[i];
                else a[i] = -a[i];
            Arrays.sort(a); // 取绝对值后，排序【升序】好的数组
            Queue<long []> q = new PriorityQueue<>((x, y) -> Long.compare(y[0], x[0]));
            q.offer(new long [] {sum, 0});
            while (--k > 0) { // 遍历去找第 k 大的返回值
                long [] cur = q.poll();
                long curSum = cur[0];
                int idx = (int)cur[1];
                if (idx < n) {
                    q.offer(new long [] {curSum - a[idx], idx + 1}); // 保留 nums[i-1]
                    if (idx > 0) q.offer(new long [] {curSum - a[idx] + a[idx-1], idx + 1}); // 不保留 nums[i-1]，把之前减去的加回来
                }
            }
            return q.peek()[0];
        }
        // 【方法二：二分搜索法】：感觉还有一点儿不透。。。再多想一想
        int [] a;
        long limit;
        int k, cnt;
        void f(int i, long s) {
            if (i == a.length || cnt >= k || s + a[i] > limit) return;
            ++cnt;
            f(i+1, s+a[i]); // 选
            f(i+1, s); // 不选
        }
        public long kSum(int [] a, int k) {
            int n = a.length;
            long sum = 0, tt = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] > 0) sum += a[i];
                else a[i] = -a[i];
                tt += a[i];
            }
            Arrays.sort(a);
            this.a = a;
            this.k = k - 1;
            long l = 0, r = tt;
            while (l < r) {
                long mid = (l + r) >> 1;
                this.limit = mid;
                cnt = 0;
                f(0, 0l);
                if (cnt >= k-1) r = mid;
                else l = mid + 1;
            }
            return sum - l;
        }

        // 这个题看了半天的题解，也没搞懂说的是什么？！！！
        public long minimumReplacement(int[] a) {
            int n = a.length, min = a[n-1];
            long r = 0;
            for (int i = n-2; i >= 0; i--) {
                int v = (a[i] - 1) / min;
                r += v;
                min = a[i] / (v + 1);
            }
            return r;
        }

        public long minimumMoney(int[][] a) {
            int n = a.length;
            if (n == 1) return a[0][0];
            List<int []> l = new ArrayList<>(), r = new ArrayList<>();
            for (int [] x : a) {
                int u = x[0], v = x[1];
                if (v >= u) l.add(x);
                else r.add(x);
            }
            Collections.sort(l, (x, y) -> y[0] != x[0] ? y[0] - x[0] : y[1] - x[1]);
            if (r.size() == 0) return l.get(0)[0]; // 还是需要的
            Collections.sort(r, (x, y) -> x[1] - y[1]);
            int i = 0, j = 0;
            long cur = 0, max = -1;
            while (j < r.size()) {
                int [] x = r.get(j);
                if (cur < x[0]) {
                    int tmp =  x[0] - (int)cur;
                    cur += tmp;
                    if (max == -1) max = cur;
                    else max += (long)tmp;
                }
                cur += -x[0] + x[1];
                j++;
            }
            if (l.size() > 0 && cur < l.get(0)[0]) max += l.get(0)[0] - cur;
            return max;
        }
        // 【这个方法没有看：】不知道它在说什么。。。。。
        public long minimumMoney(int[][] transactions) {
            var totalLose = 0L;
            var mx = 0;
            for (var t : transactions) {
                totalLose += Math.max(t[0] - t[1], 0);
                mx = Math.max(mx, Math.min(t[0], t[1]));
            }
            return totalLose + mx;
        }

        public int countSubarrays(int[] a, int k) {
            int n = a.length, idx = -1;
            for (int i = 0; i < n; i++)
                if (a[i] == k) {
                    idx = i;
                    break;
                } 
            int r = 0, sum = 0;
            Map<Integer, Integer> m = new HashMap<>();
            m.put(0, 1);
            for (int i = 0, j = 0; i < n; i++) {
                sum += (a[i] < k ? -1 : (a[i] == k ? 0 : 1));
                if (i < idx) m.put(sum, m.getOrDefault(sum, 0) + 1);
                else if (i >= idx) r += m.getOrDefault(sum, 0) + m.getOrDefault(sum-1, 0);
            }
            return r;
        }

        //TODO TODO TODO: 不知道这个题目说的是什么意思。。。
        public long minimumTotalCost(int[] a, int[] b) {
            long ans = 0;
            int n = a.length, swapCnt = 0, modeCnt = 0, mode = 0;
            int [] cnt = new int [n+1];
            for (int i = 0; i < n; i++) {
                int v = a[i];
                if (v == b[i]) {
                    ans += i;
                    ++swapCnt;
                    ++cnt[v];
                    if (cnt[v] > modeCnt) {
                        modeCnt = cnt[v];
                        mode = v;
                    }
                }
            }
            for (int i = 0; i < n && modeCnt * 2 > swapCnt; i++) {
                int x = a[i], y = b[i];
                if (x != y && x != mode && y != mode) {
                    ans += i;
                    ++swapCnt;
                }
            }
            return modeCnt * 2 > swapCnt ? -1 : ans;
        }

        public int componentValue(int[] a, int[][] egs) {
            int n = a.length, sum = Arrays.stream(a).sum(), max = sum / Arrays.stream(a).max().getAsInt();
            // 一，建图
            g = new ArrayList [n];
            Arrays.setAll(g, z -> new ArrayList<>());
            for (int [] e : egs) {
                int u = e[0], v = e[1];
                g[u].add(v);
                g[v].add(u);
            }
            this.a = a;
            // 二、从大到小枚举可能存在的答案
            for (int i = max; i > 0; i--) { // 这里【从大到小】枚举：可以将整棵树拆分成的小树个数
                if (sum % i == 0) {
                    target = sum / i;
                    // 为什么只遍历了以 0 为树根的一棵【子树、小树、所有的小树？】树，就保证了原本大树，能被分成 i 段，每段都和为 target？
                    // 【注意，这里返回 0 是说：】以0 为根节点的小树，也返回了0, 说它的子树和是 target, 而过程中还有（ i-1）棵小树也说，它们自成小树，和为 target!!!
                    if (dfs(0, -1) == 0) return i-1; // 返回的断开边数，为小树个数 - 1
                }
            }
            return -1;
        }
        List<Integer>[] g;
        int[] a;
        int target, cnt = 0;
        int dfs(int idx, int p) { // DFS 这棵树，统计子树的价值
            // 如果这个当前节点 idx, 与某自成小树的子节点子树【子树和为 target】，也要断开，怎么处理呢？
            int r = a[idx]; // 价值
            for (int v : g[idx]) {
                if (v == p) continue;
                int curSubTree = dfs(v, idx);
                if (curSubTree < 0) return -1;
                r += curSubTree;
            }
            return r == target ? 0 : (r > target ? -1 : r);
        }

// 活宝妹的根在亲爱的表哥这里。。。
        public int longestPath(int[] p, String t) {
            if (p.length == 1) return 1;
            
            s = t.toCharArray();
            // 【一，建个有向图】
// 【有向图；】这里说是无向图，但只是个幌子，把它当【有向图】来处理。但它返回的路径可以是左右子树之和。。。
// 然后还可以不经过根节点。。。【不是，必须经过根节点的】题目是说根在0 节点，但题目没有说，路径一定要过根节点。。。。。
            g = new ArrayList[p.length]; 
            Arrays.setAll(g, z -> new ArrayList<>());
            for (int i = 1; i < p.length; i++) g[p[i]].add(i);
            // 【二，DFS 找个合法有效的最长路径】
            max = 0; // 全局最大：可以不经过根节点
            dfs(0);
            // int [] a = new int [] {-1,0};
            // String b = "mm";
            return max == 0 ? 1 : max;
        }
        List<Integer> [] g;
        char [] s;
        int max;
        int dfs(int idx) {
            var maxLen = 1; // 子树中的最长路径节点数，包括当前根节点。但这里更多是，是否已经存在一条先前的，最长路径的记录
            for (int v : g[idx]) {
// 【BUGGLY CODING:】这里可能出现了 BUGGLY, 就是会漏掉部分不过根节点的最优解？【可能吗？不可能吗？】是可以的！！！
                // if (s[v] == s[idx]) continue; // 【BUGGLY CODING:】这里可能出现了 BUGGLY, 就是会漏掉部分不过根节点的最优解？【可能吗？不可能吗？】是可以的！！！
                int curLen = dfs(v) + 1; // 子树最长路径的节点数 + 当前节点数 1
                if (s[v] != s[idx]) { // 这里可能产生：全局，无有效合法解的情况
                    max = Math.max(max, maxLen + curLen - 1); // 根节点,数了两遍, 所以减去 1 个
                    maxLen = Math.max(maxLen, curLen); // 记录：子树最长路径的节点数，包括当前根节点
                }
            }
            return maxLen; // 对当前节点：最长路径节点数 = 子树中最长路径节点数 + 当前根节点数 1
        }

        // TODO TODO TODO: 感觉这个题还不够透彻，要再看再想一想。。。
        public int numberOfGoodPaths(int[] a, int[][] egs) {
            n = a.length;
            g = new ArrayList [n];
            Arrays.setAll(g, z -> new ArrayList<>());
            for (int [] e : egs) {
                int u = e[0], v = e[1];
                g[u].add(v);
                g[v].add(u);
            }
            f = new int [n];
            for (int i = 0; i < n; i++) f[i] = i;
            // size[x] 表示节点值等于 vals[x] 的节点个数，如果按照节点值从小到大合并，size[x] 也是连通块内的等于最大节点值的节点个数
            int [] size = new int [n];
            Arrays.fill(size, 1);
            Integer [] id = IntStream.range(0, n).boxed().toArray(Integer[]::new);
            Arrays.sort(id, (x, y) -> a[x] - a[y]);
            int ans = n;
            for (int idx : id) {
                int vx = a[idx], fx = find(idx);
                for (int y : g[idx]) {
                    y = find(y);
                    if (y == fx || a[y] > vx) continue; // 只考虑最大节点值比 vx 小的连通块
                    if (a[y] == vx) { // 可以构成好路径
                        ans += size[fx] * size[y]; // 乘法原理
                        size[fx] += size[y]; // 统计连通块内节点个数值，等于 vx 的节点个数
                    }
                    f[y] = fx; // 把小的节点值合并到大的节点值上
                }
            }
            return ans;
        }
        List<Integer> [] g;
        int [] f; // 并查集中的父数组
        int n;
        int find(int x) {
            if (f[x] != x) f[x] = find(f[x]);
            return f[x];
        }
        
        // 【方法一：】单调递减栈：狠好写，贵在想法想通，提示了还想不通，南墙在哪里，找得到才撞得到。。。。。
        public int totalSteps(int[] a) {
            int n = a.length, ans = 0;
            Deque<int []> s = new ArrayDeque<>(); // 【单调递减栈】
            for (int v : a) {
                var maxT = 0;
                while (!s.isEmpty() && s.peek()[0] <= v)
                    maxT = Math.max(maxT, s.pollFirst()[1]); // 更新前面《＝元素的最大删除轮数
                maxT = s.isEmpty() ? 0 : maxT + 1;
                ans = Math.max(ans, maxT);
                s.offerFirst(new int [] {v, maxT}); // 当前下标遍历：入栈
            }
            return ans;
        }
        // 【方法二：单调栈 + 线段树】：想找一个这个解法的思路，写法，但是感觉本题作者写得古灵精怪地诲涩难懂。。。。。
        public int totalSteps(int[] a) {
            int n = a.length, ans = 0;
            ArrayDeque<Integer> s = new ArrayDeque<>();
            int [] tr = new int [4 * n]; // 【最大值线段树】：求取区间最大值: 线段树大概需要占用约 4 倍的空间
            for (int i = 0; i < n; i++) {
                while (!s.isEmpty() && a[s.peekFirst()] <= a[i]) s.pollFirst(); //将比它小的元素都弹出栈
                // 如果为空，说明当前元素不需要被弹出，本来在线段树中对应的值就为0，不做处理。
                if (!s.isEmpty()) { //说明有比当前元素大的数。
                    //如果栈中还有元素，说明有比它大的元素在
                    int idx = s.peekFirst();
                    if (i - idx == 1) {//上述的第一种情况: 就是被第一轮立即删除掉的那种 
                        update(tr, 0, 0, n-1, i, 1);
                        ans = Math.max(ans, 1);
                    } else { // 上述的第二种情况，通过线段树求解区间的最大值btMax
                        int bitMax = getMax(tr, 0, 0, n-1, idx+1, i-1);
                        update(tr, 0, 0, n-1, i, bitMax+1);
                        ans = Math.max(ans, bitMax + 1);
                    }
                }
                s.offerFirst(i);
            }
            return ans;
        }
        void update(int [] tr, int u, int l, int r, int idx, int v) {
            if (l == r) {
                tr[u] = v;
                return ;
            }
            int m = l + (r - l) / 2;
            // 【线段树的下标：】从 1 开始，爷？！！！
            // if (idx <= m)
            //     update(tr, u << 1, l, m, idx, v);
            // else update(tr, u << 1 | 1, l, m, idx, v);
            // tr[u] = Math.max(tr[u << 1], tr[u << 1 | 1]);
            if (idx <= m)
                update(tr, u << 1 | 1, l, m, idx, v);
            else update(tr, (u << 1) + 2, m+1, r, idx, v);
            // tr[u] = Math.max(tr[u << 1 | 1], tr[u << 1 | 2]); // 更新根节点：取左右节点的最大值 
            tr[u] = Math.max(tr[u << 1 | 1], tr[(u << 1) + 2]); // 更新根节点：取左右节点的最大值 
        }
        int getMax(int [] tr, int u, int l, int r, int L, int R) { // 【 l,r】：现存的有效区间跨度；【L,R】：查询区间跨度
            // if (R < l || r > L) return 0; // 【BUG:】这里写反了。。。
            if (R < l || r < L) return 0; // 完全没有交集，不存在
            if (L <= l && r <= R) return tr[u]; // 查询区间【L,R】落在，现根节点完全区间，就地取值，返回 
            int m = l + (r - l) / 2;
            // int ll = getMax(tr, u << 1, l, m, L, R);
            // int rr = getMax(tr, u << 1 | 1, m+1, r, L, R);
            // return Math.max(ll, rr);
            int ll = getMax(tr, u << 1 | 1, l, m, L, R);
            // int rr = getMax(tr, u << 1 | 2, m+1, r, L, R);
            int rr = getMax(tr, (u << 1) + 2, m+1, r, L, R);
            return Math.max(ll, rr);
        }
    } 
    public static void main (String[] args) {
        Solution s  =  new Solution ();

        int [] a = new int [] {-1,0};
        String b = "mm";

        int r = s.longestPath(a, b);
        System.out.println("r: " + r);
    }
}

// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);


















