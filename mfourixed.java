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

        // public int minimizeArrayValue(int [] a) { // 是自己可以独立完成，可是运行效率太低了。。。
        //     n = a.length;
        //     int min = Integer.MAX_VALUE;
        //     int l = 0, r = Arrays.stream(a).max().getAsInt();
        //     while (l + 1 <= r) {
        //         int m = l + (r - l) / 2;
        //         if (check(m, a)) r = m;
        //         else l = m+1;
        //     }
        //     return l;
        // }
        // int n;
        // boolean check(int v, int [] a) {
        //     long [] r = new long [n];
        //     for (int i = n-1; i > 0; i--) 
        //         if (a[i] + r[i] > v) {
        //             r[i-1] = a[i] + r[i] - v;
        //         }
        //     return r[0] + a[0] <= v;
        // }
        // // 可以抽象的理解成一个从右到左流通的flow
        // // 如果右边值比较大左边比较小 可以从右边留到左边
        // // 但如果左边比较大 右边比较小 就流不过去
        // // 所以我们可以从左到右遍历 然后在过程中算prefix sum
        // // 然后算平均数
        // // 最大的平均数就是答案
        // public int minimizeArrayValue(int[] a) { // 就算了个平均值
        //     int n = a.length;
        //     long ans = 0, prefix = 0;
        //     for (int i = 0; i < n; i++) {
        //         prefix += a[i];
        //         long prefixAvg = (long)Math.ceil(prefix / (double)(i + 1));
        //         ans = Math.max(ans, prefixAvg);
        //     }
        //     return (int)ans;
        // }        

        // 【这个题：不是狠喜欢，简单过了下，没仔细看】
        // static final int MOD = (int) 1e9 + 7, N = (int) 1e5 + 1;
        // static final int[] f = new int[N], g = new int[N];
        // static {
        //     f[0] = g[0] = 1;
        //     f[1] = g[1] = 1;
        //     f[2] = g[2] = 2;
        //     f[3] = g[3] = 4;
        //     for (var i = 4; i < N; i++) {
        //         f[i] = (int) (((long) f[i - 1] + f[i - 2] + f[i - 3]) % MOD);
        //         g[i] = (int) (((long) g[i - 1] + g[i - 2] + g[i - 3] + g[i - 4]) % MOD);
        //     }
        // }
        // public int countTexts(String s) {
        //     int ans = 1, cnt = 0;
        //     for (var i = 0; i < s.length(); i++) {
        //         cnt++;
        //         var c = s.charAt(i);
        //         if (i == s.length() - 1 || c != s.charAt(i + 1)) {
        //             ans = (int) ((long) ans * (c != '7' && c != '9' ? f[cnt] : g[cnt]) % MOD);
        //             cnt = 0;
        //         }
        //     }
        //     return ans;
        // }

        // static final int mod = (int)1e9 + 7;
        // public int countGoodStrings(int lo, int hi, int zero, int one) {
        //     // long [][] f = new long [2][hi+2];
        //     // f[0][zero] = 1; // 假如第一个片段是 00: 【可是再怎么往后遍历呢？】
        //     // f[1][one] = 1;  // 假如第一个片段是 11:
        //     long r = 0;
        //     long [] f = new long [hi+1];
        //     f[0] = 1;
        //     for (int i = 1; i <= hi; i++) {
        //         if (i - zero >= 0) f[i] = (f[i] + f[i - zero]) % mod;
        //         if (i - one >= 0) f[i] = (f[i] + f[i - one]) % mod;
        //         if (lo <= i && i <= hi) r = (r + f[i]) % mod;
        //     }
        //     return (int)r;
        // }

        // public List<Integer> goodIndices(int[] a, int k) { // 【远古时代的最朴素的写法。。。。。】
        //     int n = a.length;
        //     boolean [] l = new boolean [n], r = new boolean [n];
        //     ArrayDeque<Integer> s = new ArrayDeque<>();
        //     // 从左往右遍历：按降序排列, 抛掉不合法的
        //     for (int i = 0; i < k; i++) {
        //         while (!s.isEmpty() && a[s.peek()] < a[i]) s.pollFirst();
        //         s.offerFirst(i);
        //     }
        //     for (int i = k; i < n-k; i++) {
        //         while (!s.isEmpty() && s.peekLast() < i-k) s.pollLast(); // 把栈中非 k 范围内的【不在考虑范围的过长片段】抛掉
        //         if (s.size() == k) l[i] = true; // 【取解】
        //         // 入队列
        //         while (!s.isEmpty() && a[s.peek()] < a[i]) s.pollFirst();
        //         s.offerFirst(i);
        //     }
        //     // 从右往左遍历：同样的方法，预处理结果是否合法, 这里双端队列按升序排序【非降序】
        //     s.clear();
        //     for (int i = n-1; i >= n-k; i--) {
        //         while (!s.isEmpty() && a[s.peek()] < a[i]) s.pollFirst();
        //         s.offerFirst(i);
        //     }
        //     for (int i = n-k-1; i >= k; i--) {
        //         while (!s.isEmpty() && s.peekLast() > i+k) s.pollLast();
        //         if (s.size() == k) r[i] = true;
        //         while (!s.isEmpty() && a[s.peek()] < a[i]) s.pollFirst();
        //         s.offerFirst(i);
        //     }
        //     List<Integer> ans = new ArrayList<>();
        //     for (int i = k; i < n-k; i++) 
        //         if (l[i] && r[i]) ans.add(i);
        //     return ans;
        // }
        // public List<Integer> goodIndices(int[] a, int k) { // 【动态规划：从左往右遍历，从右往左遍历，各扫一遍】
        //     int n = a.length;
        //     List<Integer> r = new ArrayList<>();
        //     int [] dec = new int [n], inc = new int [n];
        //     Arrays.fill(dec, 1);
        //     Arrays.fill(inc, 1);
        //     for (int i = 1; i < n; i++) 
        //         if (a[i-1] >= a[i])
        //             dec[i] = dec[i-1] + 1;
        //     for (int i = n-2; i >= 0; i--)
        //         if (a[i] <= a[i+1])
        //             inc[i] = inc[i+1] + 1;
        //     for (int i = k; i < n-k; i++)
        //         if (dec[i-1] >= k && inc[i+1] >= k) r.add(i);
        //     return r;
        // }

        // // LeftStep + rightStep = k
        // // RightStep - leftStep = endPos - startPos 把这两行左右各相加，得到如下：
        // //        2 * rightStep = k + endPos - startPos
        // //            rightStep = (k + endPos - startPos) / 2
        // public int numberOfWays(int l, int r, int k) {
        //     int val = k + r - l;
        //     if (val < 0 || val % 2 == 1) return 0;
        //     int rightStep = val / 2;
        //     int leftStep = k - rightStep;
        //     if (leftStep < 0) return 0;
        //     return nChooseK(leftStep + rightStep, Math.min(leftStep, rightStep)); // Cn+m^m 组合中的选择数，数学题
        // }
        // static final int mod = (int)1e9 + 7;
        // // C(n, k) = C(n - 1, k) + C(n - 1, k - 1)
        // int nChooseK(int n, int k) {
        //     int [] f = new int [n+1];
        //     f[0] = 1;
        //     while (n-- > 0)
        //         for (int j = k; j > 0; j--) {
        //             f[j] += f[j-1];
        //             f[j] %= mod;
        //         }
        //     return f[k];
        // }

        // public long appealSum(String s) {
        //     int [] last = new int[26];
        //     long res = 0;
        //     int total = 0;
        //     for(int i = 0; i < s.length(); i++){
        //         char c = s.charAt(i);
        //         total += i + 1 - last[c - 'a'];
        //         last[c - 'a'] = i + 1;
        //         res += total;
        //     }
        //     return res;
        // }

        // static final int mod = (int)1e9 + 7;
        // public int countWays(int[][] a) {
        //     Arrays.sort(a, (x, y) -> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
        //     // List<int []> l = new ArrayList<>(); // 并不真的合并，或是构建了再数个数
        //     int ans = 1, prej = -1;
        //     for (int [] v : a) {
        //         int i = v[0], j = v[1];
        //         if (i > prej) 
        //             ans = ans * 2 % mod;
        //         prej = Math.max(prej, j);
        //     }
        //     return ans;
        // }

//         public int findValidSplit(int[] a) {
//             int n = a.length;
//             Map<Integer, Integer> left = new HashMap<>(); // left[p] 表示质数 p 首次出现的下标
//             var right = new int [n]; // right[i] 表示左端点为 i 的区间的右端点的最大值, 是开区间，不包括取值【）
//             for (int i = 0; i < n; i++) {
//                 int x = a[i];
//                 for (int d = 2; d * d <= x; d++) // 分解质因数
//                     if (x % d == 0) {
//                         if (left.containsKey(d))
//                             right[left.get(d)] = i; // 记录左端点对应的右端点的最大值, 开区间，不包括）
//                         else left.put(d, i); // 第一次遇到质数 d
// // 【不明白：】为什么会需要这个步骤？【这里会把当前 x 的所有当前遍历的质因数 d 的倍数全部消掉！！！】
//                         for (x /= d; x % d == 0; x /= d) ; // 消除当前数 x 的所有含 d 的质因子 
//                     }
//                 if (x > 1) //x 值自己 
//                     if (left.containsKey(x))
//                         right[left.get(x)] = i;
//                     else left.put(x, i);
//             }
//             for (int l = 0, maxR = 0; l < n; l++) { // 这里答案可能不唯一，但是因为要求返回最左边的，所以一旦找到第一个可分的，就返回 
//                 if (l > maxR) // 最远可以遇到 maxR
//                     return maxR; // 也可以写 l-1
//                 maxR = Math.max(maxR, right[l]);
//             }
//             return -1;
//         }

        // public int collectTheCoins(int[] b, int[][] a) { // b: coins 【这个自己原始的方法没有写完。。。】
        //     n = b.length;
        //     // 构建无向图：先构建最完整的【因为这个时候，还无法判断是否是叶子节点】
        //     g = new ArrayList [n];
        //     Arrays.setAll(g, z -> new HashSet<>());
        //     for (int [] e : a) {
        //         int u = e[0], v = e[1];
        //         g[u].add(v);
        //         g[v].add(u);
        //     }
        //     // 删除掉；所有没有钱的叶子。。。
        //     for (int i = 0; i < n; i++)
        //         if (g[i].size() == 1 && b[i] == 0) { // 只有一个相边的节点，并且没钱，删除之。。。
        //             int j = g[i].get(0);
        //             g[j].remove(i);
        //             g[i].remove(j); // g[i].size() == 0
        //             if (g[j].size() == 0) // 不知道这么写会不会遍历漏掉什么？还是会比较多重复遍历呢？还是会把树砍掉精减到感觉意外？
        //                 i = Math.min(i, j) - 1;
        //         }
        //     // 再减一次树：去掉所有子叶，及其父节点
        //     // 【写了一半，发现参考提示的思路，仍然是不透彻。。。】
        // }
        // public int collectTheCoins(int[] b, int[][] a) { // b: coins
        //    int n = b.length;
        //    List<Integer> [] g = new ArrayList [n];
        //    Arrays.setAll(g, z -> new ArrayList<>());
        //    var cnt = new int [n]; // 标记每个节点上：连边的条数，用于判断是否为叶子
        //    for (int [] e : a) {
        //        int u = e[0], v = e[1];
        //        g[u].add(v);
        //        g[v].add(u);
        //        ++cnt[u];
        //        ++cnt[v];
        //    }
        //    // 用拓扑排序「剪枝」：去掉没有金币的子树
        //    ArrayDeque<Integer> q = new ArrayDeque<>();
        //    for (int i = 0; i < n; i++)
        //        if (cnt[i] == 1 && b[i] == 0) // 无金币叶子
        //            q.offer(i);
        //    while (!q.isEmpty()) {
        //        int x = q.pop();
        //        for (int v : g[x])
        //            if (--cnt[v] == 1 && b[v] == 0) // 这里把去掉叶子后，仍没钱的新叶子也去掉，所以去掉的是，没钱的子树，并不只是叶子节点
        //                q.offer(v);
        //    }
        //    // 再次拓扑排序
        //    for (int i = 0; i < n; i++)
        //        if (cnt[i] == 1 && b[i] == 1) // 有金币叶子
        //            q.offer(i);
        //    if (q.size() <= 1) return 0; // 至多一个有金币的叶子，直接收集
        //    var time = new int [n];
        //    while (!q.isEmpty()) {
        //        int x = q.poll();
        //        for (int v : g[x])
        //            if (--cnt[v] == 1) {
        //                time[v] = time[x] + 1; // 记录入队时间
        //                q.offer(v);
        //            }
        //    }
        //    // 统计答案
        //    int ans = 0;
        //    for (var e : a)
        //        if (time[e[0]] >= 2 && time[e[1]] >= 2)
        //            ans += 2;
        //    return ans;
        // }

        // public long makeSubKSumEqual(int[] a, int k) {
        //     int n = a.length;
        //     k = gcd(k, n); // 解决了无限循环问题：每个元素只属于一个小组
        //     long ans = 0;
        //     for (int i = 0; i < k; i++) { // 把数组分成 k 组
        //         var b = new ArrayList<Integer>();
        //         for (int j = i; j < n; j += k) 
        //             b.add(a[j]);
        //         Collections.sort(b); // 排序
        //         int mid = b.get(b.size() / 2); // 排序后就可以方便地取中位数了：为什么这里中位数取得不标准，也没关系了？
        //         for (int v : b)
        //             ans += Math.abs(x - mid);
        //     }
        //     return ans;
        // }
        // int gcd(int a, int b) {
        //     while (a != 0) {
        //         int tmp = a;
        //         a = b % a;
        //         b = tmp;
        //     }
        //     return b;
        // }

        // public int findShortestCycle(int n, int[][] egs) {
        //     g = new ArrayList [n];
        //     Arrays.setAll(g, z -> new ArrayList<Integer>());
        //     for (var e : egs) {
        //         int u = e[0], v = e[1];
        //         g[u].add(v);
        //         g[v].add(u);
        //     }
        //     d = new int [n];
        //     int r = Integer.MAX_VALUE; // 【bug:】 r = n 不对，会出错！！！？？？？
        //     for (int i = 0; i < n; i++) 
        //         r = Math.min(r, bfs(i));
        //     return r == Integer.MAX_VALUE ? -1 : r;
        // }
        // List<Integer> [] g;
        // int [] d;
        // int bfs(int idx) {
        //     Arrays.fill(d, Integer.MAX_VALUE);
        //     d[idx] = 0;
        //     Deque<int []> q = new ArrayDeque<>();
        //     q.offerFirst(new int [] {idx, -1});;
        //     int r = Integer.MAX_VALUE;
        //     while (!q.isEmpty()) {
        //         // for (int size = q.size()-1; size >= 0; size--) {
        //         int [] cur = q.pollLast();
        //         int u = cur[0];
        //         for (int v : g[u]) {
        //             // if (vis[v]) return d[u] + d[v] + 1; // 这里不是直接返回，因为可能不止一个，要取最小的。。。。。
        //             // if (d[v] > step + 1) {
        //             if (d[v] == Integer.MAX_VALUE) { // 第一次遇到
        //                 d[v] = d[u] + 1;
        //                 q.offerFirst(new int [] {v, u});
        //                 // vis[v] = true;
        //             } else if (v != cur[1]) // 第二次遇到
        //                 r = Math.min(r, d[u] + d[v] + 1);
        //         }
        //         // }
        //         // step++;
        //     }
        //     return r;
        // }

        // Map<TreeNode, Integer> height = new HashMap<>(); // 每棵子树的高度
        // int [] res; // 每个节点的答案
        // public int[] treeQueries(TreeNode root, int[] queries) {
        //     getHeight(root);
        //     height.put(null, 0); // 简化 dfs 的代码，这样不用写 getOrDefault
        //     res = new int [height.size()];
        //     dfs(root, -1, 0);
        //     for (int i = 0; i < queries.length; i++) 
        //         queries[i] = res[queries[i]];
        //     return queries;
        // }
        // int getHeight(TreeNode r) {
        //     if (r == null) return 0;
        //     var h = 1 + Math.max(getHeight(r.left), getHeight(r.right));
        //     height.put(r, h); // 这里，把它存到字典里记住
        //     return h;
        // }
        // void dfs(TreeNode r, int d, int h) { // d: depth 当前节点的深度, h: restH 去掉节点后剩余的最大深度【从根节点往下、自顶向下数的】
        //     if (r == null) return ;
        //     ++d;
        //     res[r.val] = h;
        //     // 上面提到，这里 r.left=null 或者是 r.right=null 都是有可能的，所以当 height.get(null)=0 就可以不用判断了左右是否为空了。。。
        //     dfs(r.left, d, Math.max(h, d + height.get(r.right)));
        //     dfs(r.right, d, Math.max(h, d + height.get(r.left)));
        // }

        // public int[] minReverseOperations(int n, int p, int[] banned, int k) { // 这个题要再写一遍
        //     var ban = new boolean [n];
        //     ban[p] = true;
        //     for (int i : banned) ban[i] = true;
        //     TreeSet<Integer> [] ts = new TreeSet [2]; // 这里用两个有序集合来模拟一棵树？。。。
        //     Arrays.setAll(ts, z -> new TreeSet<>());
        //     for (int i = 0; i < n; i++)
        //         if (!ban[i]) ts[i % 2].add(i);
        //     ts[0].add(n);
        //     ts[1].add(n); // 哨兵
        //     var ans = new int [n];
        //     Arrays.fill(ans, -1);
        //     var q = new ArrayList<Integer>();
        //     q.add(p);
        //     for (int step = 0; !q.isEmpty(); step++) {
        //         var tmp = q;
        //         q = new ArrayList<>();
        //         for (int i : tmp) {
        //             ans[i] = step;
        //             // 从 mn 到 mx 的所有位置都可以翻转到
        //             int mn = Math.max(i - k + 1, k - i -1);
        //             int mx = Math.min(i + k - 1, n * 2 - k - i - 1);
        //             var s = ts[mn % 2];
        //             for (var j = s.ceiling(mn); j <= mx; j = s.ceiling(mn)) {
        //                 q.add(j);
        //                 s.remove(j);
        //             }
        //         }
        //     }
        //     return ans;
        // }

        // public long [] distance(int[] a) { 
        //     int n = a.length;
        //     Map<Integer, List<Integer>> gp = new HashMap<>();
        //     for (int i = 0; i < n; i++) // 相同元素分到同一组，记录下标 
        //        gp.computeIfAbsent(a[i], z -> new ArrayList<>()).add(i);
        //     long [] r = new long [n];
        //     long [] s = new long [n+1]; // 用来计算 prefixSum 和
        //     for (Map.Entry<Integer, List<Integer>> en : gp.entrySet()) {
        //         List<Integer> l = en.getValue();
        //         int m = l.size();
        //         for (int i = 0; i < m; i++) 
        //             s[i+1] = s[i] + l.get(i); // 前缀和【这里没有区分不用链表呀，没有清0 重置过？】【不用重置：因为】s[0] = 0 forever ！！！
        //         for (int i = 0; i < m; i++) {
        //             int v = l.get(i);
        //             long left = (long) v * i - s[i]; // 蓝色面积
        //             long right = s[m] - s[i] - (long)v * (m - i); // 绿色面积
        //             r[v] = left + right;
        //         }
        //     }
        //     return r;
        // }
        // public long [] distance(int[] a) { 
        //     int n = a.length;
        //     Map<Integer, List<Integer>> gp = new HashMap<>();
        //     for (int i = 0; i < n; i++) // 相同元素分到同一组，记录下标 
        //        gp.computeIfAbsent(a[i], z -> new ArrayList<>()).add(i);
        //     long [] r = new long [n];
        //     for (var l : gp.values()) { // 遍历字典里的值：各个链表 
        //         int m = l.size();
        //         long s = 0;
        //         for (int v : l) s += v - l.get(0); // a[0] 到其它下标的距离之和
        //         r[l.get(0)] = s;
        //         for (int i = 1; i < m; i++) 
        //             // 从计算 a[i-1] 到计算 a[i]，考虑 s 增加了多少
        //             r[l.get(i)] = s += (long)(i * 2 - m) * (l.get(i) - l.get(i-1));
        //     }
        //     return r;
        // }

        // public int maximumTastiness(int[] a, int k) {
        //     int n = a.length;
        //     Arrays.sort(a);
        //     System.out.println(Arrays.toString(a));
        //     int l = 0, r = a[n-1] - a[0], ans = 0;
        //     while (l <= r) {
        //         int m = l + (r - l) / 2;
        //         if (check(m, a, k)) {
        //             ans = Math.max(ans, m);
        //             l = m+1;
        //         } else r = m-1;
        //     }
        //     return ans;
        // }
        // boolean check(int v, int [] a, int k) {
        //     int n = a.length;
        //     // for (int i = 0; i+k <= n; i++) { // 永远贪心地去选第一个最小的，再先其它的。。。
        //     int r = 1, pre = 0;
        //     // for (int j = i+1; j < n; j++) 
        //     for (int j = 1; j < n; j++) 
        //         if (a[j] - a[pre] >= v) {
        //             pre = j;
        //             r++;
        //         }
        //     if (r >= k) return true;
        //     // }
        //     return false;
        // }

        // public boolean isItPossible(String S, String T) { // 97/99 passed.... who knows why???
        //     int m = S.length(), n = T.length();
        //     char [] s = S.toCharArray();
        //     char [] t = T.toCharArray();
        //     int [] one = new int [26], two = new int [26];
        //     for (char c : s) one[c-'a']++;
        //     for (char c : t) two[c-'a']++;
        //     int cntOne = 0, cntTwo = 0;
        //     for (int v : one)
        //         if (v > 0) cntOne++;
        //     for (int v : two)
        //         if (v > 0) cntTwo++;
        //     for (int i = 0; i < 26; i++) {
        //         if (one[i] == 0) continue;
        //         for (int j = 0; j < 26; j++) {
        //             if (two[j] == 0) continue;
        //             if (i == j && cntOne == cntTwo) return true;
        //             int a = (one[j] == 0 ? 1 : 0) - (one[i] > 1 ? 0 : 1);
        //             int b = (two[i] == 0 ? 1 : 0) - (two[j] > 1 ? 0 : 1);
        //             if (cntOne + a == cntTwo + b) return true;
        //         }
        //     }
        //     return false;
        // }
        // public boolean isItPossible(String word1, String word2) {
        //     Map<Character, Integer> c1 = new HashMap<>(), c2 = new HashMap<>();
        //     for (char c : word1.toCharArray()) c1.merge(c, 1, Integer::sum);
        //     for (char c : word2.toCharArray()) c2.merge(c, 1, Integer::sum);
        //     for (var e : c1.entrySet())
        //         for (var f : c2.entrySet()) {
        //             char x = e.getKey(), y = f.getKey();
        //             if (x == y) {
        //                 if (c1.size() == c2.size()) return true;
        //             } else if (c1.size() - (e.getValue() == 1 ? 1 : 0) + (c1.containsKey(y) ? 0 : 1) ==
        //                        c2.size() - (f.getValue() == 1 ? 1 : 0) + (c2.containsKey(x) ? 0 : 1)) // 基于长度计算变化量
        //                 return true;
        //         }
        //     return false;
        // }

        // static final int mod = (int)1e9 + 7;
        // public int peopleAwareOfSecret(int n, int delay, int forget) {
        //     var f = new int [n];
        //     f[0] = 1;
        //     var r = 0;
        //     for (int i = 0; i < n; i++) {
        //         // 第 i 天产生了 f[i] 的利息，这些利息又可以在第 [i+delay,i+forget) 天产生新的利息
        //         if (i + delay >= n) r = (r + f[i]) % mod;
        //         // 第 i 天产生了 f[i] 的利息，这些利息又可以在第 [i+delay,i+forget) 天产生新的利息
        //         for (int j = i+delay; j < Math.min(i + forget, n); j++)
        //             f[j] = (f[j] + f[i]) % mod;
        //     }
        //     return (f[n-1] + r) % mod;
        // }

        // public int minimumNumbers(int v, int k) {
        //     if (v == 0) return 0;
        //     for (int i = 1; i <= 10 && v - k * i >= 0; i++) 
        //         if ((v - k * i) % 10 == 0) return i;
        //     return -1;
        // }

        // public int maximumsSplicedArray(int[] a, int[] b) { // 自己的呆笨写法。。。。。
        //     int n = a.length;
        //     int [] d = new int [n];
        //     for (int i = 0; i < n; i++) d[i] = b[i] - a[i];
        //     int one = 0, cur = 0, neg = 0, two = Integer.MAX_VALUE;
        //     for (int i = 0; i < n; i++) {
        //         if (cur < 0) cur = d[i];
        //         else cur += d[i];
        //         if (neg > 0) neg = d[i];
        //         else neg += d[i];
        //         one = Math.max(one, cur);
        //         two = Math.min(two, neg);
        //     }
        //     int sa = Arrays.stream(a).sum(), sb = Arrays.stream(b).sum();
        //     int ans = Math.max(sa, sb);
        //     ans = Math.max(ans, Math.max(one + sa, one * (-1) + sb));
        //     ans = Math.max(ans, Math.max(two * (-1) + sb, two + sa));
        //     return ans;
        // }
        // public int maximumsSplicedArray(int[] nums1, int[] nums2) { // 同样的方法，执行了两遍
        //     return Math.max(solve(nums1, nums2), solve(nums2, nums1));
        // }
        // int solve(int [] a, int [] b) {
        //     int n = a.length;
        //     int sa = 0, maxSum = 0;
        //     for (int i = 0, s = 0; i < n; i++) {
        //         sa += a[i];
        //         s = Math.max(s + b[i] - a[i], 0); // 《 0 时，重置为0. 否则下面总记最大值 
        //         maxSum = Math.max(maxSum, s);     // 过程中的最大值总被记录下来了
        //     }
        //     return sa + maxSum;
        // }

        // Set<Long> s = new HashSet<>();
        // List<Integer> [] g;
        // int k, ans, cnt0;
        // public int rootCount(int[][] egs, int[][] gss, int k) { // TODO TODO TODO 
        //     this.k = k;
        //     // 建图
        //     g = new ArrayList [egs.length+1];
        //     Arrays.setAll(g, z -> new ArrayList<>());
        //     for (int [] e : egs) {
        //         int u = e[0], v = e[1];
        //         g[u].add(v);
        //         g[v].add(u);
        //     }
        //     for (var v : gss)  // guesses 转成哈希表
        //         s.add((long)v[0] << 32 | v[1]); // 两个 4 字节数压缩成一个 8 字节数
        //     dfs(0, -1); // 数一遍以 0 为节点时，猜对的边数 cnt0
        //     reroot(0, -1, cnt0); // 【换更动态DP:】这里还有点儿没能理解透彻，要再看一下
        //     return ans;
        // }
        // void dfs(int u, int p) {
        //     for (var v : g[u]) 
        //         if (v != p) {
        //             if (s.contains((long) u << 32 | v)) // 以 0 为根时，猜对了
        //                 ++cnt0;
        //             dfs(v, u);
        //         }
        // }
        // void reroot(int u, int p, int cnt) {
        //     if (cnt >= k) ++ans; // 此时 cnt 就是以 u 为根时的猜对次数
        //     for (var v : g[u]) 
        //         if (v != p) {
        //             int c = cnt;
        //             if (s.contains((long)u << 32 | v)) --c; // 原来是对的，现在错了
        //             if (s.contains((long)v << 32 | u)) ++c; // 原来是错的，现在对了
        //             reroot(v, u, c);
        //         }
        // }

        // static final int mod = (int)1e9 + 7;
        // public int numberOfPaths(int[][] a, int k) { // 【思路完全正确】就是代码还需要一点点优化。。。精减
        //     int m = a.length, n = a[0].length;
        //     long [][][] f = new long [m+1][n+1][k];
        //     for (int i = 1; i <= m; i++)
        //         for (int j = 1; j <= n; j++) {
        //             int v = a[i-1][j-1];
        //             if (i == 1 && j == 1) { // 这么写还是太复杂了。。。
        //                 f[i][j][v % k] = 1;
        //                 continue;
        //             }
        //             for (int x = 0; x < k; x++) { // 这里面就进行了无数次的重复？显得没有理解透彻，或是说思路不清晰透彻
        //                 int o = (x + v) % k;
        //                 f[i][j][o] = (f[i][j][o] + f[i][j-1][x]) % mod;
        //                 f[i][j][o] = (f[i][j][o] + f[i-1][j][x]) % mod;
        //             }
        //         }
        //     return (int)f[m][n][0];
        // }
        // static final int mod = (int)1e9 + 7;
        // public int numberOfPaths(int[][] a, int k) { // 【思路完全正确】就是代码还需要一点点优化。。。精减
        //     int m = a.length, n = a[0].length;
        //     int [][][] f = new int [m+1][n+1][k];
        //     // 此时可以设初始值 f[0][1][0]=1（或者 f[1][0][0]=1）简化一点点代码
        //     f[0][1][0] = 1; // f[1][0][0] = 1; // 前后两个哪个都可以的。。。
        //     for (int i = 0; i < m; i++)
        //         for (int j = 0; j < n; j++)
        //             for (int v = 0; v < k; v++) 
        //                 f[i+1][j+1][(v + a[i][j]) % k] = (f[i+1][j][v] + f[i][j+1][v]) % mod;
        //     return f[m][n][0];
        // }
        
//         // 第一种方法：原始，相对比较土。。。。。
//         public boolean splitArraySameAverage(int[] a) {
//             if (a.length == 1) return false;
//             int n = a.length, sum = Arrays.stream(a).sum(), m = n / 2;
//             // 把原数组和变0, 并且不引入任何浮点数
//             for (int i = 0; i < n; i++) a[i] = a[i] * n - sum;
//             // // 把原数组分成两个大小最接近的数组【再说一遍：概念上的，并不真的需要物理上的拆分为两个数组。。。】
//             // int [] l = Arrays.copyOfRange(a, 0, n/2); // 【L-inclusive, r-excluesive）
//             // int [] r = Arrays.copyOfRange(a, n/2, n);
//             // 求一个数组可能取得的和 sum 集合
//             Set<Integer> lsum = new HashSet<>();
//             for (int i = 1; i < (1 << m); i++) {
//                 int s = 0;
//                 for (int j = 0; j < m; j++) // 这里可能会遍历多了
//                     if (((i >> j) & 1) == 1) s += a[j];
// // 【快速返回：】这里是可以优化提速的地方。左边非空集合和为0, 那么左边非空补集的和也一定为 0
//                 if (s == 0) return true; 
//                 lsum.add(s);
//             }
//             // 遍历：求右边数组可能取得的和 s，并一一去找左边是否存在和 -s
//             int rsum = 0; // 先求右边的和：
//             for (int i = m; i < n; i++) rsum += a[i];
//             for (int i = 1; i < (1 << n - m); i++) {
//                 int s = 0;
//                 for (int j = m; j < n; j++) // 这里可能会遍历多了
//                     if (((i >> (j - m)) & 1) == 1) s += a[j];
//                 // if (s == 0 || lsum.contains(-s)) return true; // 【BUG:】
//                 if (s == 0 || s != rsum && lsum.contains(-s)) return true; // 【为什么 s ！＝ rsum 重要？】【3, 1】＝＝》【2, －2】
//             }
//             return false;
//         }
        // public boolean splitArraySameAverage(int[] a) {
        //     if (a.length == 1) return false;
        //     int n = a.length, m = n / 2, sum = Arrays.stream(a).sum();
        //     boolean isPossible = false;
        //     for (int i = 1; i <= m; i++)
        //         if (sum * i % n == 0) {
        //             isPossible = true;
        //             break;
        //         }
        //     if (!isPossible) return false;
        //     Set<Integer> [] f = new HashSet [m+1];
        //     Arrays.setAll(f, z -> new HashSet<>());
        //     f[0].add(0);
        //     for (int v : a) 
        //         for (int i = m; i >= 1; i--) 
        //             for (int x : f[i-1]) {
        //                 int cur = x + v;
        //                 if (cur * n == sum * i) return true;
        //                 f[i].add(cur);
        //             }
        //     return false;
        // }
        
        // public int minimumDifference(int[] a) { // 2035 这个题很好，可是今天不想再写这个题目了。。。明天再写。。
        //     int n = a.length, m = n / 2;
        //     Set<Integer> [] l = new HashSet [m];
        //     Arrays.setAll(l, z -> new HashSet<>());
        //     l[0].add(0);
        //     for (int i = 1; i < m; i++)     
        // }

        // public int maxPalindromes(String t, int k) {
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     int [] f = new int [n+1];
        //     for (int i = 0; i < 2 * n - 1; i++) {
        //         int l = i / 2, r = l + i % 2; // 中心扩展法【这个方法忘记了，或是没有彻底懂，要复习一下】
        //         f[l+1] = Math.max(f[l+1], f[l]);
        //         for (; l >= 0 && r < n && s[l] == s[r]; --l, ++r)     
        //             if (r - l + 1 >= k) {
        //                 f[r+1] = Math.max(f[r+1], f[l]+1);
        //                 break;
        //             }
        //     }
        //     return f[n];
        // }

        // // 活宝妹就是还一定要嫁给亲爱的表哥～～！！！【爱表哥，爱生活！！！】
        // public int maxNumOfMarkedIndices(int[] a) {
        //     int n = a.length, ans = 0;
        //     int l = 0, r = n / 2;
        //     Arrays.sort(a);
        //     while (l <= r) { // 二分查找：查找到一个最大可能的操作次数，注意边界
        //         int m = (l + r) / 2;
        //         if (possible(m, a)) {
        //             ans = Math.max(ans, m * 2);
        //             l = m + 1;
        //         } else r = m-1;
        //     } 
        //     return ans;
        // }
        // boolean possible(int k, int [] a) {
        //     for (int i = 0; i < k; i++) // 遍历最小的K 个数，每个 i，与最大的 n-k+i 个数,组成对
        //         if (2 * a[i] > a[a.length - k + i]) return false;
        //     return true;
        // }
    }
    public static void main (String[] args) {
        Solution s  =  new Solution ();

        int [] a = new int [] {9,2,5,4};

      int r = s.maxNumOfMarkedIndices(a);
        System.out.println("r: " + r);
    }
}

// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);








