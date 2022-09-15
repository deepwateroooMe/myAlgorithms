import com.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toMap;

public class cmp {
    public static class Solution {
        
        // public static List<Integer> minimalHeaviestSetA(List<Integer> a) { // N: [1, 10^5] 降序排列
        //     int n = a.size();
        //     // Collections.sort(a, (x, y) -> y - x);
        //     Collections.sort(a); // 升序排列
        //     long [] s = new long [n];
        //     long t = s[n-1], cur = 0l;
        //     for (int i = 0; i < n; i++) 
        //         s[i] = (i == 0 ? 0 : s[i-1]) + a.get(i);
        //     for (int i = n-1; i > 0; i--) {
        //         cur = t - s[i-1];
        //         if (cur > s[i-1])
        //             return a.subList(i, n);
        //     }
        //     return new ArrayList<>();
        // }
        
        // public static int countGroups(List<String> a) {
        //     int m = a.size(), n = a.get(0).length();
        //     char [][] arr = new char [m][n];
        //     for (int i = 0; i < m; i++) 
        //         arr[i] = a.get(i).toCharArray();
        //     DSU uf = new DSU(n);
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < i; j++) {
        //             if (arr[i][j] == 1 && !uf.areConnected(i, j))
        //                 uf.union(i, j);
        //         }
        //     return uf.getCnt();
        // }
        // private static class DSU {
        //     private int N;
        //     private int [] parent, rank;
        //     public DSU( int n) {
        //         this.N = n;
        //         this.parent = new int [N];
        //         this.rank = new int [N];
        //         for (int i = 0; i < N; i++) {
        //             this.parent[i] = i;
        //             this.rank[i] = 1;
        //         }
        //     }
        //     public int getCnt() {
        //         Set<Integer> s = new HashSet<>();
        //         for (int i = 0; i < N; i++) {
        //             find(i);
        //             if (!s.contains(parent[i])) s.add(parent[i]);
        //         }
        //         return s.size();
        //     }
        //     public boolean areConnected(int u, int v) {
        //         return find(u) == find(v);
        //     }
        //     public void union(int u, int v) { // O(Log(N))
        //         if (u != v) {
        //             int p = find(u);
        //             int q = find(v);
        //                 if (p != q) {
        //                     if (rank[p] > rank[q]) {
        //                         parent[q] = p;
        //                         rank[p] += rank[q];
        //                     } else {
        //                         parent[p] = q;
        //                         rank[q] += rank[p];
        //                     }
        //                 }
        //         }
        //     }
        //     private int find(int v) {
        //         int x = v;
        //         while (x != parent[x])
        //             x = parent[x];
        //         parent[v] = x;
        //         return x;
        //     }
        // }

        // public static long getHeaviestPackage(List<Integer> l) {
        //     ArrayDeque<Long> s = new ArrayDeque<>();
        //     int n = l.size();
        //     long max = 0l, cur = 0l;
        //     for (int i = n-1; i >= 0; i--) {
        //         System.out.println("\n i: " + i);
        //         if (s.isEmpty() || l.get(i) < s.peekLast()) {
        //             s.offerLast((long)l.get(i) + (s.isEmpty() ? 0 : s.pollLast()));
        //             continue;
        //         }
        //         if (l.get(i) >= s.peekLast())
        //             s.offerLast((long)l.get(i));
        //         else if (i == 0 || l.get(i) <= l.get(i-1)) {
        //             cur = l.get(i);
        //             while (!s.isEmpty() && cur < s.peekLast()) {
        //                 cur += s.pollLast();
        //             }
        //             max = Math.max(max, cur);
        //             s.offerLast(cur);
        //         }
        //     }
        //     for (var v : s) 
        //         max = Math.max(max, v);
        //     return max;
        // }

        // public int findMaximumSustainableClusterSize(List<Integer> pl, List<Integer> bl, long pmax) {
        //     p = pl.stream().mapToInt(Integer::intValue).toArray();
        //     b = bl.stream().mapToInt(Integer::intValue).toArray();
        //     n = p.length;
        //     s = new int [n];
        //     for (int i = 0; i < n; i++) 
        //         s[i] = (i == 0 ? 0 : s[i-1]) + p[i];
        //     int l = 1, r = n, ans = 0;
        //     while (l <= r) { // O(NlogN) sliding window for maximum O(N)
        //         int m = l + (r - l) / 2;
        //         System.out.println("\n m: " + m);
        //         System.out.println("l: " + l);
        //         System.out.println("r: " + r);
        //         if (isPossible(m, pmax)) {
        //             ans = m;
        //             l = m + 1;
        //             System.out.println("ans: " + ans);
        //         } else r = m-1;
        //     }
        //     return ans;
        // }
        // int [] p, b, s;
        // int n;
        // boolean isPossible(int v, long limit) { // sliding window to find a matched one
        //     ArrayDeque<Integer> q = new ArrayDeque<>(); // 好像是双端队列，可排序的，升序排列吧(那就是一个最大堆，但是比堆效率高O(N)而不是堆的O(NlogN))
        //     for (int l = 0, r = 0; r < n; r++) { // left right
        //         while (!q.isEmpty() && r - q.peekFirst() >= v) 
        //             q.pollFirst(); // 左出不在窗口内的(最大)值
        //         if (q.isEmpty() || b[r] > b[q.peekLast()]) // 保证升序排列
        //             q.offerLast(r); // 当前入列
        //         while (r > l + v -1) l++;
        //         if (r == l + v - 1) {
        //             if ((long)((s[r] - (l == 0 ? 0 : s[l-1])) * v + b[q.peekLast()]) <= limit)
        //                 return true;
        //         }
        //     }
        //     return false;
        // }
        
        // public int mostFrequentEven(int[] a) {
        //     int n = a.length, ans = -1, max = 0;
        //     Map<Integer, Integer> m = new HashMap<>();
        //     for (var v : a) {
        //         if (v % 2 == 0) {
        //             m.put(v, m.getOrDefault(v, 0) + 1);
        //             if (m.get(v) >= max) {
        //                 if (m.get(v) == max)
        //                     ans = Math.min(ans, v);
        //                 else ans = v;
        //                 max = m.get(v);
        //             }
        //         }
        //     }
        //     return ans;
        // }

        // public int partitionString(String t) {
        //     int n = t.length(), cnt = 0;
        //     char [] s = t.toCharArray();
        //     Set<Character> m = new HashSet<>();
        //     for (int l = 0, i = 0; i < n; i++) { // i: right
        //         if (!m.contains(s[i])) {
        //             m.add(s[i]);
        //             continue;
        //         } else {
        //             m.clear();
        //             cnt++;
        //             m.add(s[i]);
        //         }
        //     }
        //     return cnt + 1;
        // }

        // public int lengthOfLIS(int[] a, int k) { // N: [1, 10^5] 有个贪心的O(NlogN)算法，但是一时半会儿想不起来了
        //     int n = a.length, max = 1;
        //     int [] f = new int [n];
        //     Arrays.fill(f, 1); // 初始化
        //     for (int i = 0; i < n; i++) 
        //         for (int j = i+1; j < n; j++) {
        //             if (a[j] > a[i] && a[j] - a[i] <= k) {
        //                 if (f[i] + 1 > f[j]) {
        //                     f[j] = f[i] + 1;
        //                     max = Math.max(max, f[j]);
        //                 }
        //             }
        //         }
        //     return max;
        // }
        // public int lengthOfLIS(int[] a, int k) { // N: [1, 10^5] 有个贪心的O(NlogN)算法，但是一时半会儿想不起来了
        //     int n = a.length, max = 1, N = Arrays.stream(a).max().getAsInt() + 1;
        //     // List<Integer>[] ll = new ArrayList[N];
        //     // Arrays.setAll(ll, z -> new ArrayList<>());
        //     // ll[a[0]].add(a[0]);
        //     int [][] f = new int [N][2];
        //     for (var v : a) {
        //         f[v][0] = v; // 队尾的值 
        //         f[v][1] = 1; // 初始化，以当前值为头的最大长度
        //     }
        //     // System.out.println("f.length: " + f.length);
        //     // for (int z = 0; z < f.length; ++z) 
        //     //     System.out.println(Arrays.toString(f[z]));

        //     for (int i = 1; i < n; i++) {
        //         System.out.println("\n i: " + i);
        //         for (int j = a[i]-1; j >= Math.max(1, a[i]-k); j--) {
        //             System.out.println("j: " + j); 
        //             if (f[j][1] > 0 && f[j][0] >= a[i] - k && f[j][1] + 1 >= f[i][1]) {
        //                 if (f[j][1] + 1 > f[i][1]) {
        //                     f[i][1] = f[j][1] + 1;
        //                     max = Math.max(max, f[i][1]);
        //                     System.out.println("max: " + max); 
        //                 } // 没想明白其它情况下要如何再优化一下
        //             }
        //         }
        //         // if (a[i] > l.get(l.size()-1) && a[i] - l.get(l.size()-1) <= k) {
        //         //     l.add(a[i]);
        //         //     max = l.size();
        //         // } else {
        //         //     int bgn = 0, end = l.size()-1, m = -1;
        //         //     while (bgn <= end) {
        //         //         int mid = bgn + (end - bgn) / 2;
        //         //         if (a[i] <= l.get(mid)) {
        //         //             m = mid;
        //         //             end = mid - 1;
        //         //         } else bgn =  mid + 1;
        //         //     }
        //         //     if (m != -1 && l.get(m) > a[i]) // 贪心法：总是填最小可能的值在一个位置上
        //         //         l.set(m, a[i]);
        //         // }
        //         System.out.println("max: " + max); 
        //     }
        //     return max;
        // }

        // TreeSet<Range> ts;
        // public RangeModule() {
        //     ts = new TreeSet<>((a, b) -> a.l != b.l ? a.l - b.l : a.r - b.r);
        // }
        // public void addRange(int left, int right) {
        //     int l = left, r = right;
        //     Range hi = new Range(r, Integer.MAX_VALUE);
        //     while (true) { // 相当于是合并有交集的子集
        //         Range lower = ts.lower(hi);
        //         if (lower == null || lower.r < l) break;
        //         if (lower.r > r) r = lower.r;
        //         if (lower.l < l) l = lower.l;
        //         ts.remove(lower);
        //     }
        //     ts.add(new Range(l, r));
        // }
        // // floor(E e) 方法返回在这个集合中小于或者等于给定元素的最大元素，如果不存在这样的元素,返回null.
        // // ceiling(E e) 方法返回在这个集合中大于或者等于给定元素的最小元素，如果不存在这样的元素,返回null.
        // public boolean queryRange(int left, int right) {
        //     Range cur = ts.floor(new Range(left, Integer.MAX_VALUE));
        //     return cur != null && cur.l <= left && cur.r >= right;
        // }
        // public void removeRange(int left, int right) {
        //     Range hi = new Range(right, right);
        //     while (true) {
        //         Range lower = ts.lower(hi);
        //         if (lower == null || lower.r <= left) break;
        //         if (lower.r > right) ts.add(new Range(right, lower.r));
        //         if (lower.l < left) ts.add(new Range(lower.l, left));
        //         ts.remove(lower);
        //     }
        // }
        // // 不知道哪里写错了: 好像这里思路不对呀；如果能从错误例子里把这个问题弄明白，倒是还有点儿帮助，现在看没有
        // class Range implements Comparable<Range> {
        //     int l, r;
        //     public Range(int l, int r) {
        //         this.l = l;
        //         this.r = r;
        //     }
        //     @Override public int compareTo(Range other) {
        //         return this.l - other.l;
        //     }
        // }
        // boolean vis = false;
        // public int minGroups(int[][] a) {
        //     int n = a.length;
        //     List<TreeSet<Range>> l = new ArrayList<>();
        //     for (var i : a) {
        //         Range r = new Range(i[0], i[1]);
        //         vis = false;
        //         for (var ts : l) {
        //             Range lower = ts.floor(r);
        //             Range higher = ts.ceiling(r);
        //             if ((lower == null || lower.r < r.l) && (higher == null || higher.l > r.r)) {
        //                 ts.add(r);
        //                 vis = true;
        //                 break;
        //             }
        //         }
        //         if (!vis) {
        //             TreeSet<Range> s = new TreeSet<>(); // 升序排列
        //             s.add(r);
        //             l.add(s);
        //         }
        //     }
        //     return l.size();
        // }
// // 这里是数会议室问题：用一个主计数器来数任何时间点，最多的会议室的使用个数        
//         public int minGroups(int[][] a) { // 计数器的思路，但本质仍然是等差数列
//             int n = a.length, m = n * 2;
//             int [] cnt = new int [m][2];
//             for (int i = 0; i < n; i++) {
//                 cnt[i*2][0] = a[i][0];
//                 cnt[i*2][1] = 1;
//                 cnt[i*2+1][0] = a[i][1] + 1;
//                 cnt[i*2+1][1] = -1;
//             }
//             Arrays.sort(cnt, Comparator.comparingInt(o -> o[0] * 3 + o[1])); // 这个比较方法没有看懂
//             int max = 0, cur = 0;
//             for (var v : cnt) {
//                 max = Math.max(max, cur += v[1]);
//             }
//             return max;
//         }
//         public int minGroups(int[][] a) { // 等差数列的思路
//             int n = a.length, N = 1000002, max = 0;
//             int [] cnt = new int [N];
//             for (var v : a) {
//                 cnt[v[0]]++;
//                 cnt[v[1]+1]--; // 1000002
//             }
//             for (int i = 1; i < N; i++) 
//                 max = Math.max(max, cnt[i] += cnt[i-1]);
//             return max;
//         }
//         public int minGroups(int[][] a) { // 
//             Queue<Integer> q = new PriorityQueue<>();
//             Arrays.sort(a, (x, y) -> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
//             for (var v : a) {
//                 int l = v[0], r = v[1];
// // 完全没有交差，就把前一个扔掉(贪心思路，保留的都是最有可能与接下来的可能会发生交差的值)                
//                 if (!q.isEmpty() && l > q.peek())
//                     q.poll();
//                 q.offer(r);
//             }
//             return q.size();
//         }

        // public int maximumRows(int[][] a, int cnt) {
        //     m = a.length;
        //     n = a[0].length;
        //     N = (1 << n);
        //     int cur = 0, k = 0, max = 0;
        //     for (int i = 1; i < N; i++) {
        //         if (getCnt(i) == cnt) {
        //             cur = 0;
        //             for (int j = 0; j < m; j++) {
        //                 int sum = Arrays.stream(a[j]).sum();
        //                 if (sum == 0) {
        //                     cur ++;
        //                     continue;
        //                 } else if (sum > cnt) continue;
        //                 for ( k = 0; k < n; k++) 
        //                     if (((i >> k) & 1) == 0 && a[j][k] == 1) break;
        //                 if (k == n) cur++;
        //             }
        //             max = Math.max(max, cur);
        //         }
        //     }
        //     return max;
        // }
        // public int lengthOfLIS(int[] a, int k) { // N: [1, 10^5] 有个贪心的O(NlogN)算法，但是一时半会儿想不起来了
        //     int n = a.length, max = 1, N = Arrays.stream(a).max().getAsInt() + 1;
        //     // List<Integer>[] ll = new ArrayList[N];
        //     // Arrays.setAll(ll, z -> new ArrayList<>());
        //     // ll[a[0]].add(a[0]);
        //     int [][] f = new int [N][2];
        //     for (var v : a) {
        //         f[v][0] = v; // 队尾的值 
        //         f[v][1] = 1; // 初始化，以当前值为头的最大长度
        //     }
        //     // System.out.println("f.length: " + f.length);
        //     // for (int z = 0; z < f.length; ++z) 
        //     //     System.out.println(Arrays.toString(f[z]));

        //     for (int i = 1; i < n; i++) {
        //         System.out.println("\n i: " + i);
        //         for (int j = a[i]-1; j >= Math.max(1, a[i]-k); j--) {
        //             System.out.println("j: " + j); 
        //             if (f[j][1] > 0 && f[j][0] >= a[i] - k && f[j][1] + 1 >= f[i][1]) {
        //                 if (f[j][1] + 1 > f[i][1]) {
        //                     f[i][1] = f[j][1] + 1;
        //                     max = Math.max(max, f[i][1]);
        //                     System.out.println("max: " + max); 
        //                 } // 没想明白其它情况下要如何再优化一下
        //             }
        //         }
        //         // if (a[i] > l.get(l.size()-1) && a[i] - l.get(l.size()-1) <= k) {
        //         //     l.add(a[i]);
        //         //     max = l.size();
        //         // } else {
        //         //     int bgn = 0, end = l.size()-1, m = -1;
        //         //     while (bgn <= end) {
        //         //         int mid = bgn + (end - bgn) / 2;
        //         //         if (a[i] <= l.get(mid)) {
        //         //             m = mid;
        //         //             end = mid - 1;
        //         //         } else bgn =  mid + 1;
        //         //     }
        //         //     if (m != -1 && l.get(m) > a[i]) // 贪心法：总是填最小可能的值在一个位置上
        //         //         l.set(m, a[i]);
        //         // }
        //         System.out.println("max: " + max); 
        //     }
        //     return max;
        // }

        // public long sellingWood(int m, int n, int[][] prices) {
        //     long[][] dp = new long[m+1][n+1];
        //     for(int [] price:prices){
        //         int x = price[0];
        //         int y = price[1];
        //         int p = price[2];
        //         dp[x][y] = Math.max(dp[x][y],p);
        //         for(int i = x; i <= m; i++){
        //             for(int j = y; j <= n; j++){
        //                 dp[i][j] = Math.max(dp[i][j],Math.max(dp[i-x][j]+dp[x][j],dp[i][j-y]+dp[i][y]));
        //             }
        //         }
        //     }
        //     return dp[m][n];
        // }
        // public long sellingWood(int m, int n, int[][] a) { // PASS
        //     long [][] f = new long [m+1][n+1];
        //     for (var v : a) 
        //         f[v[0]][v[1]] = v[2];
        //     for (int i = 1; i <= m; i++) 
        //         for (int j = 1; j <= n; j++) {
        //             for (int h = 1; h <= i / 2; h++) // 再多横切一刀的情况下，最优化的解
        //                 f[i][j] = Math.max(f[i][j], f[h][j] + f[i-h][j]);
        //             for (int w = 1; w <= j / 2; w++)  // 再多竖切一刀的情况下，最优化的解
        //                 f[i][j] = Math.max(f[i][j], f[i][w] + f[i][j-w]);
        //         }
        //     return f[m][n];
        // }
        // // 下面的这个解法里感觉可能还有死角，我也还没能够想得很透彻，等过段时间网上的解法比较多的时候再搜索好好想一下
        // public long sellingWood(int m, int n, int[][] a) { // FAILED
        //     long [][] f = new long [m+1][n+1];
        //     for (var v : a) {
        //         int x = v[0], y = v[1];
        //         f[x][y] = Math.max(f[x][y], v[2]);
        //         for (int i = x; i <= m; i++) 
        //             for (int j = y; j <= n; j++) 
        //                 f[i][j] = Math.max(f[i][j], Math.max(f[i-x][j] + f[x][j], f[i][j-y] + f[i][y]));
        //     }
        //     return f[m][n];
        // }

        // public long minSumSquareDiff(int[] a, int[] b, int k1, int k2) {
        //     int n = a.length;
        //     long k = k1 + k2, sum = 0, ans = 0l;
        //     long [] d = new long [n];
        //     for (int i = 0; i < n; i++) {
        //         d[i] = Math.abs(a[i] - b[i]);
        //         sum += d[i];
        //         ans += d[i] * d[i];
        //     }
        //     if (sum <= k) return 0;
        //     Arrays.sort(d);
        //     for (int i = n-1; i >= 0; i--) {
        //         int m = n - i; // 从 i开始到后共有 n-i个数
        //         long v = d[i], c = m * (v - (i > 0 ? d[i-1] : 0));
        //         ans -= v * v; // <<<<<<<<<< 
        //         if (c < k) { // 能把当前数以及之后的所有数都减少到 a[i-1]和程度，结束退出
        //             k -= c;
        //             continue;
        //         }
        //         // 所有的m个数都能够减少 k / m;
        //         // k % m个数可能再多减少1； m - k % m
        //         v -= k / m; // 不够减少到a[i-1], 但是仍然能够减少几个值
        //         return ans + k % m * (v-1) * (v-1) + (m - k % m) * v * v;
        //     }
        //     return 0l;
        // }

        // int m, n, N;
        // int getCnt(int v) {
        //     int cnt = 0;
        //     for (int i = 0; i < n; i++) 
        //         if (((v >> i) & 1) == 1) cnt++;
        //     return cnt;
        // }

        // public boolean findSubarrays(int[] a) {
        //     int n = a.length, cur = 0;
        //     Set<Integer> s = new HashSet<>();
        //     for (int i = 0; i < n-1; i++) {
        //         cur = a[i] + a[i+1];
        //         if (s.contains(cur)) return true;
        //         s.add(cur);
        //     }
        //     return false;
        // }

        // 并查集和单调本的解法，今天晚上只会写单调栈的; 并查集的解法读不懂解释，也看不懂代码
        public int validSubarraySize(int[] a, int k) {
            int n = a.length;
            ArrayDeque<Integer> s = new ArrayDeque<>(); 
            int [] l = new int [n], r = new int [n];
            for (int i = 0; i < n; i++) { // 从左往右遍历，找左边小于当前元素的下标
                while (!s.isEmpty() && a[s.peekLast()] >= a[i]) s.pollLast();
                l[i] = s.isEmpty() ? -1 : s.peekLast();
                s.offerLast(i);
            }
            s.clear();
            for (int i = n-1; i >= 0; i--) { // 从右往左遍历，找右边小于当前元素的下标
                while (!s.isEmpty() && a[s.peekLast()] >= a[i]) s.pollLast();
                r[i] = s.isEmpty() ? n : s.peekLast();
                s.offerLast(i);
            }
            for (int i = 0; i < n; i++) {
                int len = r[i] - l[i] -1 ;
                if (a[i] > k / len) return len;
            }
            return -1;
        }
        // 看不懂： https://ssg.leetcode-cn.com/problems/subarray-with-elements-greater-than-varying-threshold/solution/by-endlesscheng-j6pp/
        // 用并查集，遍历到 nums[i] 时，用并查集合并 i 和 i+1，这样可以把连续访问过的位置串起来；怎么来确保访问过的从大到小遍历过的元素都是连续分布的呢？没想明白。。。。。
        // 同时维护链的长度。(这一步没有问题)
        public int validSubarraySize(int[] a, int k) {
            int n = a.length;
            p = new int [n+1];
            int [] size = new int [n+1]; // component count
            for (int i = 0; i <= n; i++) p[i] = i;
            Integer [] ids = IntStream.range(0, n).boxed().toArray(Integer[]::new); 
            Arrays.sort(ids, (i, j) -> a[j] - a[i]); // 数值降序排列，数组元素的值是各idx
            for (var i : ids) { // 当从最大元素往最小元素遍历
                int j = find(i+1);
                p[i] = j; // 合并 i 和 i+1
                size[j] += size[i] + 1;
                if (a[i] > k / size[j]) return size[j];
            }
            return -1;
        } 
        int [] p; // 并查集里的parent数组

        int find(int v) { // 并查集里这里的原理忘得好干净呀。。。
            if (p[v] != v) p[v] = find(p[v]);
            return p[v];
        }        
    }
    public static void main (String[] args) {
        Solution s = new Solution ();

        int []  a = new int []  {1, 3, 4, 3, 1};

        int r = s.validSubarraySize(a, 6);
        System.out.println("r: " + r); 
   }
}

// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
