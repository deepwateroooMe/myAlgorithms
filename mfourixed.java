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
    }
    public static void main (String[] args) {
        Solution s  =  new Solution ();

        int [][] a = new int [][] {{0,1},{1,2},{2,0},{3,4},{4,5},{5,6},{6,3}};
        
        int r = s.findShortestCycle(7, a);
        System.out.println("r: " + r);
    }
}

// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);



