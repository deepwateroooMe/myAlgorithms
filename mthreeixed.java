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
// import javafx.util.Pair; // 这个库还是没有设置对，暂时不用
import static java.util.stream.Collectors.toMap;

public class mthreeixed {
    public static class Solution {

//         public boolean digitCount(String t) {
//             int n = t.length(), r [] = new int [10];
//             char [] s = t.toCharArray();
//             for (char c : s) 
//                 r[c-'0']++;
//             for (int i = 0; i < n; i++) 
//                 if (s[i] - '0' != r[i]) return false;
//             return true;
//         }

//         public int rearrangeCharacters(String s, String target) {
//             Map<Character, Integer> m = new HashMap<>();
//             Map<Character, Integer> n = new HashMap<>();
//             for (char c : s.toCharArray()) m.put(c, m.getOrDefault(c, 0) + 1);
//             for (char c : target.toCharArray()) n.put(c, n.getOrDefault(c, 0) + 1);
//             int r = Integer.MAX_VALUE;
//             for (Map.Entry<Character, Integer> en : n.entrySet()) {
//                 char k = en.getKey();
//                 int v = en.getValue();
//                 if (!m.containsKey(k)) return 0;
//                 r = Math.min(r, m.get(k) / v);
//             }
//             return r;
//         }

//         public int totalSteps(int[] a) {// TODO TODO TODO 糊糊糊。。。。。
//             int n = a.length, f [] = new int [n], max = 0; // f: dp
//             Deque<Integer> s = new ArrayDeque<>();
//             f[0] = 0;
//             for (int i = 0; i < n; i++) {
//                 while (!s.isEmpty() && a[s.peek()] < a[i]) {
//                     f[i] = Math.max(f[i] + 1, f[s.pollFirst()]);
//                     max = Math.max(max, f[i]);
//                 }
//                 s.offerFirst(i);
//             }
//             return max;
//         }

//         public int minimumObstacles(int[][] a) { 
//             int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
//             int m = a.length, n = a[0].length;
//             boolean [][] vis = new boolean [m][n];
//             // Deque<int []> q = new ArrayDeque<>(); // 【优先队列：】当要找一个最XXX 的时候，当要排序的时候，就一定得一定得用优先队列！！！
//             Queue<int []> q = new PriorityQueue<>((x, y) -> x[1] != y[1] ? x[1] - y[1] : x[0] - y[0]);
//             q.offer(new int [] {0, 0});
//             vis[0][0] = true;
//             while (!q.isEmpty()) {
//                 int [] cur = q.poll();
//                 int x = cur[0] / n, y = cur[0] % n;
//                 for (int [] d : dirs) {
//                     int i = x + d[0], j = y + d[1];
//                     if (i < 0 || i >= m || j < 0 || j >= n || vis[i][j]) continue;
//                     if (i == m-1 && j == n-1) return cur[1];
//                     q.offer(new int [] {i*n+j, cur[1] + a[i][j]});
//                     vis[i][j] = true;
//                 }
//             }
//             return -1;
//         }

//         public boolean strongPasswordCheckerII(String t) {
//             int n = t.length(), i = 0;
//             char [] s = t.toCharArray();
//             if (n < 8) return false;
//             boolean lo = false, hi = false, dg = false, sp = false, rp = false;
//             Set<Character> sc = new HashSet<>("!@#$%^&*()-+".chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
//             for (char c : s) {
//                 if (Character.isLowerCase(c)) lo = true;
//                 else if (Character.isUpperCase(c)) hi = true;
//                 else if (Character.isDigit(c)) dg = true;
//                 else if (sc.contains(c)) sp = true;
//                 if (i > 0 && s[i] == s[i-1]) rp = true;
//                 i++;
//             }
//             return lo && hi && dg && sp && !rp;
//         }

//         public int minOperations(int[] a, int[] b) {
//             int m = a.length, n = b.length;
//             int gcd = getGCD(b);
//             Arrays.sort(a);
//             for (int i = 0; i < m; i++) 
//                 if (gcd % a[i] == 0) return i;
//             return -1;
//         }
//         int getGCD(int [] a) {
//             int g = a[0];
//             for (int v : a) 
//                 g = gcd(g, v);
//             return g;
//         }
//         int gcd(int a, int b) {
//             return b == 0 ? a : gcd(b, a % b);
//         }

//         public int shortestSequence(int[] rolls, int k) { // TODO TODO TODO: 【读不懂这个题目说的是什么意思 】
//             int r = 1;// ans: r
//             Set<Integer> vis = new HashSet<>();
//             for (int v : rolls) {
//                 vis.add(v);
//                 if (vis.size() == k) {
//                     // Have all combinations that form `ans` length, and we are going to
//                     // Extend the sequence to `ans + 1` length
//                     ++r;
//                     vis.clear();
//                 }
//             }
//             return r;
//         }

//         public int longestIdealString(String t, int k) { // 感觉这是动态规划
//             int n = t.length(), f [] = new int [26], max = 0;
//             char [] s = t.toCharArray();
//             for (int i = 0; i < n; i++) {
//                 int idx = s[i] - 'a';
//                 int l = Math.max(0, idx - k);
//                 int r = Math.min(25, idx + k);
//                 int cur = 0;
//                 for (int j = l; j <= r; j++) 
//                     cur = Math.max(cur, f[j] + 1);
//                 f[idx] = cur;
//                 max = Math.max(max, f[idx]);
//             }
//             return max;
//         }

//         public boolean checkDistances(String s, int[] a) {
//             int n = a.length, i = 0;
//             Map<Character, List<Integer>> m = new HashMap<>();
//             for (char c : s.toCharArray()) {
//                 m.computeIfAbsent(c, z -> new ArrayList<>()).add(i);
//                 if (m.get(c).size() == 2) {
//                     List<Integer> l = m.get(c);
//                     if (l.get(1) - l.get(0)-1 != a[c-'a']) return false;
//                 }
//                 i++;
//             }
//             return true;
//         }

//         int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
//         int [] fa, size;
//         public int[] maxPoints(int[][] aa, int[] q) {// 【参考模板：】把并查集的知识点捡起来
//             int m = aa.length, n = aa[0].length, mn = m * n;
//             // 【并查集】: 初始化 
//             fa = new int [mn];
//             for (int i = 0; i < mn; i++) fa[i] = i;
//             size = new int [mn];
//             Arrays.fill(size, 1);
//             // 【矩阵元素：从小到大排列，方便离线】
//             var a = new int [mn][3];
//             for (int i = 0; i < m; i++) 
//                 for (int j = 0; j < n; j++) 
//                     a[i*n+j] = new int [] {aa[i][j], i, j};
//             Arrays.sort(a, (x, y) -> x[0] - y[0]);// 升序排列
//             // 【查询的下标按照查询值从小到大排序，方便离线】
//             var k = q.length;
//             var id = IntStream.range(0, k).boxed().toArray(Integer[]::new);
//             Arrays.sort(id, (i, j) -> q[i] - q[j]);// 这里就，很方便的排序了查询遍历顺序！！！
//             // 【构建答案】
//             int [] r = new int [k];
//             int j = 0;
//             for (int i : id) {// 这里就是按查询升序来遍历了。。。【通过使用并查集，也可以后续遍历，不用重新构建先前已经完成的结果】
//                 int v = q[i];
//                 for (; j < mn && a[j][0] < v; j++) {
//                     int x = a[j][1], y = a[j][2];
//                     for (int [] d : dirs) { // 枚举周围四个格子，值小于 q 才可以合并
//                         int ii = x + d[0], jj = y + d[1];
//                         if (ii >= 0 && ii < m && jj >= 0 && jj < n && aa[ii][jj] < v)
//                             merge(x*n+y, ii*n+jj); // 把坐标压缩成一维的编号
//                     }
//                 }
//                 if (aa[0][0] < v)
//                     r[i] = size[find(0)];
//             }
//             return r;
//         }
//         // 【并查集模板】
//         void merge(int from, int to) {
//             from = find(from);
//             to = find(to);
//             if (from != to) {
//                 fa[from] = to;
//                 size[to] += size[from];
//             }
//         }
//         int find(int v) {
//             if (fa[v] != v)
//                 fa[v] = find(fa[v]);
//             return fa[v];
//         }
//         static final int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
//         public int[] maxPoints(int[][] a, int[] q) {// 【参考模板：】使用优先队列
//             int m = a.length, n = a[0].length, cnt = 0, k = q.length;
//             // 查询的下标按照查询值从小到大排序，方便离线
//             var id = IntStream.range(0, k).boxed().toArray(Integer[]::new);
//             Arrays.sort(id, (i, j) -> q[i] - q[j]);
//             int [] r = new int [k];
//             Queue<int []> p = new PriorityQueue<>((x, y) -> x[0] - y[0]);
//             p.offer(new int [] {a[0][0], 0, 0});
//             a[0][0] = 0; // 充当 vis 数组的作用
//             for (int i : id) {
//                 int v = q[i];
//                 while (!p.isEmpty() && p.peek()[0] < v) {
//                     ++cnt;
//                     int [] cur = p.poll();
//                     for (int [] d : dirs) { // 枚举周围四个格子
//                         int x = cur[1] + d[0], y = cur[2] + d[1];
//                         if (x >= 0 && x < m && y >= 0 && y < n && a[x][y] > 0) {
//                             p.offer(new int [] {a[x][y], x, y});
//                             a[x][y] = 0; // 充当 vis 数组的作用
//                         }
//                     }
//                 }
//                 r[i] = cnt;
//             }
//             return r;
//         }

//         public int similarPairs(String[] ss) {
//             int n = ss.length, idx = 0, r = 0;
//             Set<Character> [] s = new HashSet [n];
//             for (String i : ss) 
//                 s[idx++] = new HashSet<Character>(i.chars().mapToObj(e->(char)e).collect(Collectors.toList()));
//             for (int i = 0; i < n; i++) 
//                 for (int j = i+1; j < n; j++) 
//                     if (contains(s[i], s[j])) ++r;
//             return r;
//         }
//         boolean contains(Set<Character> s, Set<Character> t) {
//             if (s.size() != t.size()) return false;
//             for (Character c : s) 
//                 if (!t.contains(c)) return false;
//             return true;
//         }

//         public int smallestValue(int n) {
//             int v = getPrimeSum(n);
//             while (n != v) { // 只要有变化，就一直循环 
//                 n = v;
//                 v = getPrimeSum(n);
//             }
//             return v;
//         }
//         int getPrimeSum(int v) {
//             int r = 0;
//             for (int i = 2; i <= v; i++) 
//                 while (v % i == 0) {
//                     v /= i;
//                     r += i;
//                 }
//             return r;
//         }

//         public boolean isPossible(int n, List<List<Integer>> edges) {
//             // 【建图】
//             var g = new Set [n+1];
//             Arrays.setAll(g, e -> new HashSet<Integer>()); // 初始化
//             for (var e : edges) {
//                 int u = e.get(0), v = e.get(1);
//                 g[u].add(v);
//                 g[v].add(u);
//             }
//             // 【数与列举：度数为奇数的节点】
//             var odd = new ArrayList<Integer>();
//             for (int i = 1; i <= n; i++) 
//                 if (g[i].size() % 2 > 0) odd.add(i);
//             var m = odd.size();
//             // 【对度数为奇数的节点，结果，进行分析】
//             if (m == 0) return true;
//             if (m == 2) {
//                 int x = odd.get(0), y = odd.get(1);
//                 if (!g[x].contains(y)) return true;
//                 for (int i = 1; i <= n; i++) 
//                     if (i != x && i != y && !g[x].contains(i) && !g[y].contains(i)) return true;
//                 return false;
//             }
//             if (m == 4) {
//                 int x = odd.get(0), y = odd.get(1), i = odd.get(2), j = odd.get(3);
//                 return !g[x].contains(y) && !g[i].contains(j) // [a, b], [c, d]
//                     || !g[x].contains(i) && !g[y].contains(j) // [a, c], [b, d]
//                     || !g[x].contains(j) && !g[y].contains(i);// [a, d], [b, c]
//             }
//             return false;
//         }

//         public List<Integer> topStudents(String[] pf, String[] nf, String[] r, int[] id, int k) {
//             Set<String> sp = new HashSet<>(Arrays.asList(pf));
//             Set<String> sn = new HashSet<>(Arrays.asList(nf));
//             List<int []> l = new ArrayList<>();
//             for (int i = 0; i < r.length; i++) {
//                 String [] si = r[i].split(" ");
//                 int cur = 0;
//                 for (String v : si) {
//                     if (sp.contains(v)) cur += 3;
//                     else if (sn.contains(v)) cur -= 1;
//                 }
//                 l.add(new int [] {id[i], cur});
//             }
//             Collections.sort(l, (x, y) -> x[1] != y[1] ? y[1] - x[1] : x[0] - y[0]);
//             List<Integer> ans = new ArrayList<>();
//             for (int i = 0; i < k; i++) 
//                 ans.add(l.get(i)[0]);
//             return ans;
//         }

//         public int minimizeSet(int d, int dd, int cnt, int ctt) { // 【不喜欢这类题，那些个数字会让人发昏。。。】
//             long divisorLcm = lcm(d, dd); // 这里算是：最小公倍数
//             // 【二分查找法：】去找一个可能存在的最小的最大值
//             long l = 0, r = Integer.MAX_VALUE;
//             while (l < r) {
//                 long m = l + (r - l) / 2;
//                 if (isPossible(m, divisorLcm, d, dd, cnt, ctt))
//                     r = m;
//                 else l = m + 1;
//             }
//             return (int)l;
//         }
//         // Returns true if we can take uniqueCnt1 integers from [1..m] to arr1 and
//         // take uniqueCnt2 integers from [1..m] to arr2.
//         boolean isPossible(long v, long divisorLcm, int d, int dd, int cnt, int ctt) {
//             long one = v - v / d;
//             long two = v - v / dd;
//             long totalCnt = v - v / divisorLcm;
//             return one >= cnt && two >= ctt && totalCnt >= cnt + ctt;
//         }
//         long lcm(int a, int b) {
//             return a * (b / gcd(a, b));
//         }
//         long gcd(int x, int y) {
//             return y == 0 ? x : gcd(y, x % y);
//         }

//         static final int mod = (int)1e9 + 7;
//         public int countAnagrams(String t) {
//             int n = t.length();
//             char [] s = t.toCharArray();
//             long r = 1l, mul = 1l;
//             var cnt = new int [26];
//             for (int i = 0, j = 0; i < n; i++) {
//                 if (s[i] == ' ') { // 下一个单词的开始，重置计数等
//                     Arrays.fill(cnt, 0);
//                     j = 0;
//                 } else {
//                     mul = mul * ++cnt[s[i] - 'a'] % mod;// 因为是算阶层，任何一次的累加都要相乘【这里是算分母，相同字母需要除的部分】
//                     r = r * ++j % mod;
//                 }
//             }
//             return (int)(r * pow(mul, mod - 2) % mod); // 这里没看明白：【其实是除以分母：重复字符可能存在的排列组合数】
//         }
//         long pow(long x, int n) { // 【快速幂： x^n】
//             var r = 1l;
//             for (; n > 0; n /= 2) {
//                 if (n % 2 > 0) r = r * x % mod;
//                 x = x * x % mod;
//             }
//             return r;
//         }

//         public int takeCharacters(String t, int k) { // TODO TODO TODO 2516：它说要，abc 每个字符至少各取走 k 个，最少要多久？
//             if (k == 0) return 0;
//             int n = t.length(), ans = n, cnt [] = new int [3];
//             char [] s = t.toCharArray();
//             for (char c : s) ++cnt[c-'a'];
//             if (cnt[0] < k || cnt[1] < k || cnt[2] < k) return -1;
//             for (int l = 0, r = 0; r < n; r++) {
//                 --cnt[s[r]-'a'];
//                 while (cnt[s[r]-'a'] < k) // 【这里是什么意思，没有看懂！！！】
//                     ++cnt[s[l++]-'a'];    // 【这里是什么意思，没有看懂！！！】
//                 ans = Math.min(ans, n - (r - l + 1));
//             }
//             return ans;
//         }

//         // 把问题转化为了给定 nums 求总和小于 k 的选取方式数目
//         // 可以通过动态规划求出（dp[i] 表示总和为 i 的方案数。最后计算 dp[0...k−1] 的和）
//         public int countPartitions(int[] a, int k) {
//             int n = a.length;
//             long sum = Arrays.stream(a).asLongStream().sum();
//             if (sum < 2l * (long)k) return 0;
//             long r = (long)quickPow(2, n); // 2^n % kMod
//             long [] f = new long [k];
//             // Arrays.sort(a);
//             // f[a[0]] = 1; // 初始化【这里好像自己初始化得不对！！！】
//             // for (int i = 1; i < n; i++) {
//             //     int v = a[i];
//             //     for (int j = i-1; j >= 0; j--) {
//             //         int vj = a[j];
//             //         if (vj + v < k)
//             //             f[vj+v] = f[vj] + 1;
//             //     }
//             // }
//             // long r = 0l;
//             // for (long v : f) 
//             //     r = (r + v) % mod;
//             // return (int)(quickPow(2, n) - r);
//             f[0] = 1;
//             for (int v : a) 
//                 for (int i = k-1; i >= v; i--) {
//                     f[i] += f[i-v];
//                     f[i] %= mod;
//                 }
//             // Minus cases that're not satisfied.
//             for (int i = 0; i < k; i++) // 【这里仍然是看得不明白】：什么时候减一遍，什么时候减两遍？？？
//                 if (sum - i < k) // Both group1 and group2 < k
//                     r -= f[i];
//                 else r -= f[i] * 2;
//             return (int)((r % mod + mod) % mod);
//         }
//         static final int mod = (int)1e9 + 7;
// // Returns base^k % kMod.
//         int quickPow(int base, int k) {
//             int res = 1;
//             for (int i = 0; i < k; ++i)
//                 res = res * base % mod;
//             return res;
//         }
//         // long quickPow(int v, int n) {// 【快速幂：为什么这里不能用？？？】
//         //     long r = 1l;
//         //     while (n > 0) {
//         //         if (n % 2 > 0) 
//         //             r = r * v % mod;
//         //         v = v * v % mod;
//         //         n /= 2;
//         //     }
//         //     return r;
//         // }

//         public int minimumPartition(String s, int k) {
//             int n = s.length(), i = 0, j = 1, r = 1;
//             long cur = 0l;
//             for (char c : s.toCharArray()) {
//                 cur = cur * 10 + c - '0';
//                 if (cur > k) {
//                     cur = c - '0';
//                     ++r;
//                 }
//                 if (cur > k) return -1;
//             }
//             return r;
//             // for (j = 1; j <= n; j++) {
//             //     if (Integer.parseInt(s.substring(i, j)) <= k) continue;// 这里不一定是整形了，可能是长整形的！！！
//             //     r++;
//             //     i = j-1;
//             //     if (Integer.parseInt(s.substring(i, j)) > k) return -1;
//             // }
//             // return (i < n && Integer.parseInt(s.substring(i, j-1)) <= k ? 1 : 0) + r;
//         }

//         public long maxPower(int[] a, int r, int k) {
//             int n = a.length;
//             long [] sum = new long [n+1]; // 前缀和
//             for (int i = 0; i < n; i++)
//                 sum[i+1] = sum[i] + a[i];
//             long mn = Long.MAX_VALUE, power [] = new long [n]; // 电量
//             for (int i = 0; i < n; i++) {
//                 power[i] = sum[Math.min(i+r+1, n)] - sum[Math.max(i-r, 0)];
//                 mn = Math.min(mn, power[i]);
//             }
//             // 【二分查找法：】
//             long left = mn, right = mn + k + 1; // 开区间写法
//             while (left + 1 < right) {
//                 long mid = left + (right - left) / 2;
//                 if (check(mid, power, n, r, k)) left = mid;
//                 else right = mid;
//             }
//             return left;
//         }
//         // 二分答案 minPower: 从左到右遍历 stations.stations[i] 电量不足 minPower，那么需要建供电站来补足。
//         // 由于 i 左侧的不需要补足，所以贪心地在 min(i+r,n−1) 处建是最合适的，恰好让 i 在覆盖范围的边界上。
//         // 设需要建 m 个供电站，那么需要把 min[i,min(i+2r,n−1)] 范围内的电量都增加 m。
//         // 方法很多，用差分数组来更新是最简单的。
//         // 最后判断修建的供电站是否超过 k，如果超过说明 minPower 偏大，否则说明偏小。
//         // 注：其实前缀和也不需要，可以改为长为 2r+1 的滑动窗口，但这样写有点麻烦，感兴趣的读者可以实现下。
//         boolean check(long minPower, long [] p, int n, int r, int k) {
//             long [] d = new long [n+1]; // diff: 【差分数组】：感觉这个题型还弄得不明不白。。。
//             long sumD = 0, need = 0;
//             for (int i = 0; i < n; i++) {
//                 sumD += d[i]; // 累加差分值
//                 long m = minPower - p[i] - sumD;
//                 if (m > 0) {  // 需要 m 个供电站
//                     need += m;
//                     if (need > k) return false;
//                     sumD += m; // 差分更新
//                     if (i + r * 2 + 1 < n) d[i+r*2+1] -= m; // 差分更新
//                 }
//             }
//             return true;
//         }

//         public long maxKelements(int[] a, int k) {
//             int n = a.length;
//             Arrays.sort(a);
//             Queue<Integer> q = new PriorityQueue<>((x, y) -> y - x);
//             for (int v : a) q.offer(v);
//             long r = 0l;
//             while (k > 0) {
//                 int cur = q.poll();
//                 r += cur;
//                 q.offer((cur % 3 > 0 ? 1 : 0) + cur / 3);
//                 k--;
//             }
//             return r;
//         }

//         public int[][] rangeAddQueries(int n, int[][] a) {
//             int [][] r = new int [n][n];
//             for (int [] e : a) {
//                 int i = e[0], j = e[1], x = e[2], y = e[3];
//                 for (int ii = i; ii <= x; ii++) 
//                     for (int jj = j; jj <= y; jj++) 
//                         r[ii][jj]++;
//             }
//             return r;
//         }

//         public long maxOutput(int n, int[][] edges, int[] price) {
//             g = new ArrayList [n];
//             Arrays.setAll(g, x -> new ArrayList<>());
//             for (int [] e : edges) {
//                 int x = e[0], y = e[1];
//                 g[x].add(y);
//                 g[y].add(x);
//             }
//             dfs(0, -1, price);
//             return ans;
//         }
//         List<Integer> [] g;
//         long ans;
//         // 返回【带叶子的最大路径和，不带叶子的最大路径和】
//         long [] dfs(int x, int fa, int [] price) {
//             long p = price[x], maxSone = p, maxStwo = 0;
//             for (int v : g[x]) 
//                 if (v != fa) {
//                     var res = dfs(v, x, price);
//                     long s = res[0], ss = res[1];
//                     // 前面最大  带叶子的路径和 + 当前不带叶子的路径和【  带 + 不带】
//                     // 前面最大不带叶子的路径和 + 当前  带叶子的路径和【不带 +   带】
//                     ans = Math.max(ans, Math.max(maxSone + ss, maxStwo + s));
//                     maxSone = Math.max(maxSone, s + p);
//                     maxStwo = Math.max(maxStwo, ss + p); // 这里加上 p 是因为 x 必然不是叶子【什么情况下是叶了的情况，我没想清楚】
//                 }
//             return new long [] {maxSone, maxStwo};
//         }

//         public long countGood(int[] a, int k) {
//             int n = a.length, j = 0, tmp = 0;
//             Map<Integer, Integer> m = new HashMap<>();
//             long r = 0;
//             for (int i = 0; i < n; i++) {
//                 if (!m.containsKey(a[i])) m.put(a[i], 1);// 如果第一次出现，map添加该元素
//                 else {
//                     tmp += m.get(a[i]);// 如果之前map里面有，那么与之前所有相同元素配对
//                     m.put(a[i], m.getOrDefault(a[i], 0) + 1);
//                 }
//                 while (tmp >= k) {
//                     r += n - i;// 配对数达到k，剩余i之后的所有终点均满足条件【从当前元素 i 起，后面所有的都可以成为一个合法子数组， n-i 个】
//                     int res = m.get(a[j]);// 起始位置j右侧滑动
//                     if (res > 1) {
//                         tmp -= res - 1; // j对应的配对全部减少
//                         m.put(a[j], m.getOrDefault(a[j], 0) - 1);// j位置元素滑出
//                     } else m.remove(a[j]);
//                     j++;
//                 }
//             }
//             return r;
//         }

//         public long minOperations(int[] a, int[] b, int k) {
//             if (k == 0)
//                 return Arrays.equals(a, b) ? 0 : -1;
//             int n = a.length;
//             long r = 0, cnt = 0; // cnt: # of increments - # of decrements
//             for (int i = 0; i < n; i++) {
//                 int dif = a[i] - b[i];
//                 if (dif == 0) continue;
//                 if (dif % k != 0) return -1;
//                 int ops = dif / k;
//                 cnt += ops;
//                 r += (long)Math.abs(ops);
//             }
//             return cnt == 0 ? r / 2 : -1;
//         }

//         public long maxScore(int[] a, int[] b, int k) {
//             int n = a.length;
//             long r = 0, sum = 0;
//             // (nums2[i], nums1[i]) sorted by nums2[i] in descending order.
//             List<int []> l = new ArrayList<>();
//             for (int i = 0; i < n; i++) // 【保证两个数组下标一致】
//                 l.add(new int [] {b[i], a[i]});
//             Collections.sort(l, (x, y) -> y[0] - x[0]); // 降序排序
//             Queue<Integer> q = new PriorityQueue<>();   // 升序排列
//             for (int [] v : l) {
//                 int y = v[0], x = v[1];
//                 q.offer(x);
//                 sum += x;
//                 if (q.size() > k) sum -= q.poll();
// // 【有点儿奇怪：下面一行，没想透的是，怎么保证，当扔去一个最小堆中最小值的时候，扔的就一定不是当前最小值 y 所对应的下标？】
//                 if (q.size() == k) r = Math.max(r, sum * y);
//             }            
//             return r;
//         }
//         // Same as 1383. Maximum Performance of a Team
//         static final int mod = (int)1e9 + 7;
//         public int maxPerformance(int n, int [] a, int [] e, int k) {
//             // (nums2[i], nums1[i]) sorted by nums2[i] in descending order.
//             List<int []> l = new ArrayList<>();
//             for (int i = 0; i < n; i++) 
//                 l.add(new int [] {e[i], a[i]});
//             Collections.sort(l, (x, y) -> y[0] - x[0]);
//             Queue<Integer> q = new PriorityQueue<>();
//             long r = 0, sum = 0;
//             for (int [] v : l) {
//                 int y = v[0], x = v[1];
//                 q.offer(x);
//                 sum += x;
//                 if (q.size() > k) sum -= q.poll();
//                 if (q.size() <= k) r = Math.max(r, sum * y);
//             }
//             return (int)(r % mod);
//         }

//         // 【不喜欢这种题：狠烦人！！！】
//         public boolean isReachable(int x, int y) {
//             int g = gcd(x, y);
//             return (g & (g-1)) == 0;
//         }
//         int gcd(int x, int y) {
//             while (x != 0) {
//                 int tmp = x;
//                 x = y % x;
//                 y = tmp;
//             }
//             return y;
//         }

//         public boolean makeStringsEqual(String s, String t) {
//             boolean one = s.chars().distinct().count() == 1 && s.charAt(0) == '0',
//                 two = t.chars().distinct().count() == 1 && t.charAt(0) == '0';
//             return !((one || two) && one != two);
//         }

//         public int minCost(int[] a, int k) {
//             int n = a.length;
//             int [] f = new int [n+1];
//             // dp[0] means optimal importance value for empty subarray,
//             // dp[1] means optimal importance value for array ending at[0, 1) i.e.[0, 0],
//             // dp[i] means optimal importance for array ending at i-1: [0, i) / [0, i-1]
//             Map<Integer, Integer> m = new HashMap<>(); // count map, a new one for each i
//             for (int i = 1; i <= n; i++) { // calc result for dp[1] to dp[n]
//                 f[i] = Integer.MAX_VALUE;
//                 m.clear();
//                 int cur = k; // importance score always start with k for each subarray
// // since we know the optimal value in dp[j] for j : [0, i-1], where to put j will we yield best score for dp[i]? (Note: j = 0 means two sub arrays: [0, 0) + [0, i) which means there's only one subarray which is the whole thing
//                 for (int j = i-1; j >= 0; j--) { 
//                     int cnt = m.getOrDefault(a[j], 0);
//                     m.put(a[j], ++cnt);
//                     if (cnt == 2) cur += 2; // only when we need a numnber for the second time, we start to add importance score, and it's going to be count as 2
//                     else if (cnt > 2) cur++;// for 3rd time and more, each time we count one more importance score
//                     f[i] = Math.min(f[i], f[j] + cur);
//                 }
//             }
//             return f[n];
//         }
//         public int minCost(int[] a, int k) { // 【不喜欢这个思路：不大众化】
//             n = a.length;
//             Map<Integer, Integer> m = new HashMap<>();
//             idx = 0;
//             for (int i = 0; i < n; i++) {
//                 int j = m.getOrDefault(a[i], -1);
//                 if (j == -1) {
//                     m.put(a[i], idx);
//                     a[i] = idx++; // 感觉这里的改装有点儿奇怪，不喜欢这个思路
//                 } else a[i] = j;
//             }
//             f = new int [n];
//             Arrays.fill(f, Integer.MAX_VALUE);
//             return dfs(0, k, a);
//         }
//         int [] f;
//         int idx, n;
//         int dfs(int ij, int k, int [] a) {
//             if (ij == n) return 0;
//             if (f[ij] != Integer.MAX_VALUE) return f[ij];
//             int [] m = new int [idx];
//             int cur = k; // 计算当前值 
//             for (int i = ij; i < n; i++) {
//                 if (++m[a[i]] == 2) cur += 2;
//                 else if (m[a[i]] > 2) cur++;
//                 f[ij] = Math.min(f[ij], dfs(i+1, k, a) + cur);
//             }
//             return f[ij];
//         }

//         // 把所有 n−1 个 weights[i]+weights[i+1] 算出来，排序，那么最大的 k−1 个数和最小的 k−1 个数相减，即为答案。
//         public long putMarbles(int[] a, int k) { // 这个是自己用了很多数据结构空间算的，可以直接改动原数组，节省空间。。。
//             int n = a.length;
//             Queue<Integer> qm = new PriorityQueue<>((x, y) -> y - x); // 最大堆
//             Queue<Integer> qn = new PriorityQueue<>(); // 最小堆
//             for (int i = 0; i < n-1; i++) {
//                 int cur = a[i] + a[i+1];
//                 qm.offer(cur);
//                 qn.offer(cur);
//             }
//             long max = 0, min = 0;
//             n = k-1;
//             while (n > 0) {
//                 max += (long)qm.poll();
//                 n--;
//             }
//             while (k > 1) {
//                 min += (long)qn.poll();
//                 k--;
//             }
//             return max - min;
//         }
//         public long putMarbles(int[] a, int k) { // 这个是自己用了很多数据结构空间算的，可以直接改动原数组，节省空间。。。
//             int n = a.length;
//             long r = 0;
//             for (int i = 0; i < n-1; i++) 
//                 a[i] += a[i+1];
//             Arrays.sort(a, 0, n-1); // 【排序：最后一个数不参与排序】相当于去掉最后一个数
//             for (int i = 0; i < k - 1; ++i)
//                 r += a[n - 2 - i] - a[i];
//             return r;
//         }

//         public long countQuadruplets(int[] a) {// TODO TODO TODO 【优化空间：】还有一种压缩掉 less 数组的解法，看不下去了，改天再看
//             int n = a.length;
//             int [][] g = new int [n][n+1]; // g : greater 两个数组的作用，就是用来数个数的 
//             for (int k = n-2; k >= 2; k--) {
//                 g[k] = g[k+1].clone();
//                 for (int x = a[k+1]-1; x > 0; x--) 
//                     g[k][x]++; // x < nums[k+1]，对于 x，大于它的数的个数 +1
//             }
//             long r = 0;
//             int [] l = new int [n+1]; // l: less
//             for (int j = 1; j < n-2; j++) {// 遍历 J 【遍历JK】O(N^2)
//                 for (int x = a[j-1]+1; x <= n; x++) 
//                     l[x]++; // x > nums[j-1]，对于 x，小于它的数的个数 +1
//                 for (int k = j+1; k < n-1; k++)// 遍历 K 
//                     if (a[j] > a[k])// 在遍历的【J, K】每一种有效组合下，累积 cnt[i]*cnt[l] 的可能个数
//                         r += l[a[k]] * g[k][a[j]];
//             }
//             return r;
//         }

//         // 既然要数的个数多，那就永远贪心地尽量选择尽可能小的数来填充。。。。。
//         public int maxCount(int[] a, int n, int maxSum) {
//             Set<Integer> s = new HashSet<>();
//             for (int v : a) if (v <= n) s.add(v);
//             int r = 0, sum = 0;
//             for (int i = 1; i <= n && sum < maxSum; i++) {
//                 if (!s.contains(i)) {
//                     sum += i;
//                     if (sum > maxSum) return r;
//                     r++;
//                 }
//             }
//         }

//          public int[] vowelStrings(String[] s, int[][] q) {
//             int n = s.length, cnt = 0;
//             int [] r = new int [n];
//             for (int i = 0; i < n; i++) {
//                 if (isVol(s[i])) cnt++;
//                 r[i] = cnt;
//             }
//             int [] ans = new int [q.length];
//             for (int i = 0; i < q.length; i++) {
//                 int x = q[i][0], y = q[i][1];
//                 ans[i] = r[y] - (x == 0 ? 0 : r[x-1]);
//             }
//             return ans;
//         }
//         boolean isVol(String s) {
//             Set<Character> sc = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
//             return s.length() > 0 && sc.contains(s.charAt(0)) && sc.contains(s.charAt(s.length()-1));
//         }

// // 把限制条件看丢了，窃有窃道，不偷相邻的人家。。。TODO TODO TODO: 没有写完
//         public int minCapability(int[] a, int k) {
//             int l = Arrays.stream(a).min().getAsInt(), r = Arrays.stream(a).max().getAsInt(), ans = r;
//             n = a.length;
//             while (l <= r) {
//                 int m = (l + r) / 2;
//                 if (check(m, k, a)) {
//                     ans = Math.min(ans, m);
//                     r = m;
//                 } else l = m + 1;
//             }
//             return ans;
//         }
//         int n;
//         boolean check(int v, int k, int [] a) {// 这种写法不对。。。漏掉了太多结果。。。
//             int r = 0, p = -1;
//             // List<Integer> l = new ArrayList<>();
//             for (int i = 0; i < n; i++) {
//                 if (a[i] <= v) {
//                     if (p == -1 || i > 0 && p < i-1) {
//                         r++;
//                         p = i;
//                     }
//                 }
//             }
//         }

//         // 下面是我，看了提示一知半解下写的，并没能真正理解题目的意思。。。
//         boolean myContains(List<List<Integer>> ll, List<Integer> l) {
//             for (List<Integer> li : ll) {
//                 if (li.size() != l.size()) continue;
//                 // if (li.get(0) == l.get(0)) return true; // 【不知道这个题目考察的犄角是在哪里。。。。。】
//                 boolean same = true;
//                 for (int i = 0; i < l.size(); i++) 
//                     if (li.get(i) != l.get(i)) {
//                         same = false;
//                         break;
//                     }
//                 if (same) return true;
//             }
//             return false;
//         }
//         boolean dfs(int x, int y, List<Integer> p, int [][] a) {
//             if (x < 0 || x >= m || y < 0 || y >= n || vis[x][y] || a[x][y] == 0) return false;
//             if (x == m-1 && y == n-1) {
//                 List<Integer> l = new ArrayList<>(p);
//                 if (!myContains(ll, l))
//                     ll.add(new ArrayList<>(p));
//                 return true;
//             }
//             vis[x][y] = true;
//             p.add(x*n+y);
//             for (int [] d : dirs) {
//                 int i = x + d[0], j = y + d[1];
//                 if (dfs(i, j, p, a) && ll.size() == 2) 
//                     return true; // 我忘记了，这里会藏一个 bug 吗？
//             }
//             p.remove(p.size()-1);
//             vis[x][y] = false;
//             return false;
//         }
//         public boolean isPossibleToCutPath(int[][] a) {
//             m = a.length;
//             n = a[0].length;
//             if (!hasPath(0, 0, a)) return true;
//             // Reassign (0, 0) as 1.
//             a[0][0] = 1;
//             return !hasPath(0, 0, a);
//         }
//         boolean [][] vis;
//         int m, n;
//         // Returns true is there's a path from (0, 0) to (m - 1, n - 1).
//         // Also mark the visited path as 0 except (m - 1, n - 1).
//         // 那么上面有个极其有效的独特路径的区分：就是第一遍走过，把路销毁；那么第二次再走的，就无论如何也不会与第一次的重复，而非自己写的同时找两条路径，总或多或少存在交叉。。。
//         boolean hasPath(int i, int j, int [][] a) {
//             if (i == m || j == n) return false;
//             if (i == m-1 && j == n-1) return true;
//             if (a[i][j] == 0) return false;
//             a[i][j] = 0;
//             // Go down first. Since we use OR logic, we'll only mark one path.
//             return hasPath(i+1, j, a) || hasPath(i, j+1, a);
//         }

//         public long minCost(int[] a, int[] b) {
//             int n = a.length;
//             long r = 0;
//             List<Integer> swapped = new ArrayList<>();
//             Map<Integer, Integer> m = new HashMap<>(); // m: cnt map
//             for (int v : a)
//                 m.put(v, m.getOrDefault(v, 0) + 1);
//              // m.merge(v, 1, Integer::sum); // 这些是一个道理，只是写得 fancy 一点儿。。。
//             for (int v : b) 
//                 m.put(v, m.getOrDefault(v, 0) - 1);
//              // m.merge(v, -1, Integer::sum);
//             for (Map.Entry<Integer, Integer> en : m.entrySet()) {
//                 Integer val = en.getKey(), freq = en.getValue();
//                 if (freq % 2 != 0) return -1;
//                 for (int i = 0; i < Math.abs(freq) / 2; i++) 
//                     swapped.add(val);
//             } // 下面找出的是全局的最小值 
//             int minVal = Math.min(Arrays.stream(a).min().getAsInt(), Arrays.stream(b).min().getAsInt());
//             Collections.sort(swapped);
//             for (int i = 0; i < swapped.size() / 2; i++)// 下面的意思就是说，任何时候，想要交换，怎么交换代价最小？永远拿一个最小的值来交换！！！ 
//                 r += Math.min(minVal * 2, swapped.get(i));
//             return r;
//         }
        
//         // 数对：数对就是说，固定其中的一个【或是遍历其中的一个】，来累积另一个的所有可能性
//         // lower <= nums[i] + nums[j] <= upper
//         // 把上面的变成一下，可以得到 lower - a[i] <= a[j] <= upper - a[i]
//         // 再把上面转换成开区间的话，就成为
//         public long countFairPairs(int[] a, int lo, int hi) {
//             long r = 0;
//             Arrays.sort(a); // 排序不影响数对的个数，但是排序后，才可以进行二分查找 
//             for (int i = 0; i < a.length; i++) {
//                 int right = lowerBound(a, i, hi - a[i] + 1);
//                 int left = lowerBound(a, i, lo - a[i]);
//                 r += right - left;
//             }
//             return r;
//         }
//         int lowerBound(int [] a, int r, int t) { // r: right. t: target
//             int l = -1; // 开区间：（left, right） ==> （ l,r）
//             while (l + 1 < r) { // 区间不为空
//                 // 循环不变量：
//                 // nums[left] < target
//                 // nums[right] >= target
//                 int m = (l + r) >>> 1;
//                 if (a[m] < t) // 【注意下面接下来，同样是开区间】
//                     l = m; // 范围缩小到 (mid, right)
//                 else
//                     r = m; // 范围缩小到 (left, mid)
//             }
//             return r;
//         }
//         // 【比赛时的原则：更相信千百年来的数据结构，如果二分法自己还会时不时地这里那里出错，就使用数据结构来帮助自己，至少在比赛的时候，二分的结果，借由数据结构，可以做到精确无误】
//         public long countFairPairs(int [] a, int lo, int hi) { // TLE TLE TLE : 48/53 PASSED 【也就是说，上面原始的二分法更快一些。。。】
//             TreeMap<Integer, Integer> m = new TreeMap<>();
//             long r = 0;
//             for (int v : a) {
//                 // 下面的：借助有序字典，自动筛选出范围内的条款，不是太方便了吗？
//                 for (Map.Entry<Integer, Integer> en : m.subMap(lo - v, hi - v + 1).entrySet())
//                     r += en.getValue();
//                 m.put(v, m.getOrDefault(v, 0) + 1);
//             }
//             return r;
//         }
//         public long countFairPairs(int[] a, int lo, int hi) { // 现在这个二分，该再透彻一点儿了吧？
//             int n = a.length;
//             long r = 0;
//             Arrays.sort(a);
//             for (int i = 0; i < n-1; i++) {
//                 int min = lo - a[i], max = hi - a[i];
//                 int bgn = binarySearchOne(i+1, n-1, min, a);// 去找，最左边的左边界【若有重复，最最左边】
//                 int end = binarySearchTwo(i+1, n-1, max, a);// 去找，最右边的右边界【若有重复，最最右边】
//                 r += end - bgn + 1;
//             }
//             return r;
//         }
//         int binarySearchOne(int l, int r, int v, int [] a) { // 找下界, 左边界 
//             while (l <= r) {
//                 int m = (l + r) / 2;
//                 if (a[m] < v) l = m+1;
//                 else r = m-1; // 感觉这里写得不对【与自己先前写的习惯不一样。。。】
//             }
//             return l;
//         }
//         int binarySearchTwo(int l, int r, int v, int [] a ) {  // 找上界, 找右边界
//             while (l <= r) {
//                 int m = (l + r) / 2;
//                 if (a[m] > v) r = m-1;
//                 else l = m+1; // 感觉这里写得不对【与自己先前写的习惯不一样。。。】
//             }
//             return r;
//         }
//         // 【TLE: 下面的，过不了，是因为我不曾预处理所有的长度《＝ 30 的子字符串】省时间的办法，永远是先把可能需要的东西数好记下来，备用，用来拿来直接用。。。
//         public int[][] substringXorQueries(String s, int[][] q) { // TLE TLE TLE : 55/59 
//             int n = s.length(), m = q.length, idx = 0;
//             int [][] r = new int [m][2];
//             for (int [] e : q) {
//                 int v = e[0] ^ e[1];
//                 String sv = Integer.toBinaryString(v);
//                 int i = s.indexOf(sv);
//                 r[idx][0] = i;
//                 r[idx++][1] = i == -1 ? -1 : i + sv.length()-1;
//             }
//             return r;
//         }
//         public int[][] substringXorQueries(String t, int[][] q) {
//             int n = t.length(), N = q.length, o = 30;
//             char [] s = t.toCharArray();
//             int [][] ans = new int [N][2];
//             // 【预处理：】用个字记住，所有相关值的，第一次出现在的，【左，右】边界的下标，备用！！！
//             // {val: (left, right)} := s[left..right]'s decimal value = val
//             Map<Integer, int []> m = new HashMap<>();
//             for (int i = 0; i < n; i++) {
//                 int v = 0;
//                 if (s[i] == '0') {
//                     // Edge case: save the index of first 0.
//                     if (!m.containsKey(v)) m.put(v, new int [] {i, i});
//                     continue;
//                 }
//                 int mj = Math.min(n, i + o);// 向右最远可以延伸到的下标 maxRight
//                 for (int j = i; j < mj; j++) {
//                     v = v * 2 + s[j] - '0';
//                     if (!m.containsKey(v)) m.put(v, new int [] {i, j});
//                 }
//             }
//             for (int i = 0; i < N; i++) {
//                 int x = q[i][0], y = q[i][1], v = x ^ y;
//                 if (!m.containsKey(v)) ans[i] = new int [] {-1, -1};
//                 else ans[i] = m.get(v);
//             }
//             return ans;
//         }

//         // 枚举 i，分别计算能够与 es[:i] 和 s[i:] 匹配的 t 的最长前缀和最长后缀，就知道要删除的子串的最小值了。这个技巧叫做「前后缀分解」。
//         // 那么删除的子串就是从 pre[i]+1 到 suf[i]−1 这段，答案就是 suf[i]−pre[i]−1 的最小值。
//         // 代码实现时，可以先计算 suf，然后一边计算 pre，一边更新最小值，所以 pre 可以省略
//         public int minimumScore(String ss, String tt) {
//             int n = ss.length(), m = tt.length();
//             char [] s = ss.toCharArray(), t = tt.toCharArray();
//             int [] suf = new int [n+1];
//             suf[n] = m;
//             for (int i = n-1, j = m-1; i >= 0; i--) {
//                 if (j >= 0 && s[i] == t[j]) --j;
//                 suf[i] = j+1;
//             }
//             int r = suf[0]; // 删除 t[:suf[0]]
//             if (r == 0) return 0;
//             for (int i = 0, j = 0; i < n; i++) {
//                 if (s[i] == t[j]) // 注意 j 不会等于 m，因为上面 suf[0]>0 表示 t 不是 s 的子序列
//                     r = Math.min(r, suf[i+1] - ++j); // ++j 后，删除 t[j:suf[i+1]]
//             }
//             return r;
//         }

//         public int minimizeSum(int[] a) {
//             int n = a.length;
//             Arrays.sort(a);
//             // Can always change the num to any other num in nums, so `low` becomes 0.
//             // So, we can rephrase the problem as finding the min `high`.
//             int hiOfChangingTwoMins = a[n-1] - a[2]; // a[0] == a[1]
//             int hiOfChangingTwoMaxs = a[n-3] - a[0]; // a[n-1] ==? a[n-2]
//             int hiOfChangingMinMax = a[n-2] - a[1];   // a[0] a[n-1]
//             return Math.min(Math.min(hiOfChangingTwoMins, hiOfChangingTwoMaxs), hiOfChangingMinMax);
//         }

//         public long[] handleQuery(int[] a, int[] b, int[][] queries) {
//             int n = a.length, m = 0, i = 0;
//             // 【线段树：】创建与初始化
//             cnt = new int [n * 4];
//             flip = new boolean [n * 4]; // 这个主要是用来作懒标记的
//             build(a, 1, 1, n); // 构建线段树 
//             var sum = Arrays.stream(b).asLongStream().sum(); // 快速算和，可以当作长整形数组来使用
//             for (var q : queries) 
//                 if (q[0] == 3) ++m;
//             var ans = new long [m];
//             for (var q : queries) {
//                 if (q[0] == 1) update(1, 1, n, q[1]+1, q[2]+1); // 更新线段树
//                 else if (q[0] == 2) sum += (long)q[1] * cnt[1]; // 对线段树的片段，进行求和
//                 else ans[i++] = sum;
//             }
//             return ans;
//         }
//         int [] cnt; // cnt A
//         boolean [] flip;
//         // 初始化线段树   o,l,r = 1,1,n
//         void build(int [] a, int o, int l, int r) {
//             if (l == r) {
//                 cnt[o] = a[l-1];
//                 return ;
//             }
//             int m = (l + r) / 2;
//             build(a, o * 2, l, m);
//             build(a, o * 2 + 1, m + 1, r);
//             maintain(o);
//         }
//         void maintain(int o) { // 自底向上回归更新：算的是父节点的值【这里求和，题目要求，求和】：为两子节点值的和
//             cnt[o] = cnt[o * 2] + cnt[o * 2 + 1]; 
//         }
//         // 反转区间 [L,R]   o,l,r=1,1,n
//         void update(int o, int l, int r, int L, int R) {
//             if (L <= l && r <= R) { // 对一个【整个区间】进行标记操作，因为作用于整个区间，不再需要分左右，所以这里可以打懒标记
//                 do_(o, l, r);
//                 return ;
//             }
//             int m = (l + r) / 2;// 必须得分左右两边来进行的操作
//             if (flip[o]) { // 因为曾经懒标记过，而这里又一个需要分左右的操作要下来，就不得不将先前的懒标记往下：左右子树向下执行，以方便当前分左右的标记能够执行到位
//                 do_(o * 2, l, m);
//                 do_(o * 2 + 1, m + 1, r);
//                 flip[o] = false;
//             }
//             if (m >= L) update(o * 2, l, m, L, R);
//             if (m < R) update(o * 2 + 1, m + 1, r, L, R); // 跟下面一句：同理，写法不同
//             // if (m+1 <= R) update(o * 2 + 1, m + 1, r, L, R);// 【m+1, R】是说，m+1 <= R, 所以仍然关切右子树，右子树同样必须回归
//             maintain(o);// 操作完了，仍然要更新父节点 
//         }
//         void do_(int o, int l, int r) {
//             cnt[o] = r - l + 1 - cnt[o];
//             flip[o] = !flip[o];
//         }

//         // 【二分查找法：】
//         // ai - aj <= bi - bj + diff 把这个等式改写一下，得到下面的：
//         // ai - bi <= aj - bj + diff 【可是改成这样的，仍然没有思路？？？】
//         // 所以我们生成一个 ai － bi 的新数组array对于每一个i我们用binary search找到它前面【??? 是前面！！！】所有小于等于A[i] + diff的值的个数
//         // 上面说得不透彻，从左往右遍历一遍差值数组A，数当前遍历的下标 j, 前面存在多少个 i 使得 A[i] 《＝ A[j] ＋ dif 【这就是上面改写表达式的执行逻辑】
//         public long numberOfPairs(int[] a, int[] b, int dif) {
//             int n = a.length;
//             for (int i = 0; i < n; i++) a[i] -= b[i]; // 直接更改了 a 数组的值，为差值 
//             List<Integer> d = new ArrayList<>(); // 升序排列，有序，可以二分查找
//             long r = 0;
//             for (int j = 0; j < n; j++) {
//                 r += binarySearch(d, a[j] + dif);
// // 重置d  链表中，那个 binarySearch 结果的下标位，的值为 a[j]. 就是 a[j] 在 d 链表中按照升序排列应该插入的位置
//                 d.add(binarySearch(d, a[j]), a[j]); 
//             }
//             return r;
//         }
//         int binarySearch(List<Integer> li, int v) { // 寻找左边界：严格大于 v 的【最左侧最小】下标
//             int l = 0, r = li.size(); // 半开半闭区间：【l, r）＝【0, n）
//             while (l < r) { // 半开半闭区间：【l, r）
//                 int m = l + (r - l) / 2;
//                 if (li.get(m) <= v) l = m + 1;
//                 else r = m;
//             }
//             return l;
//         }
//         // 【线段树：】感觉现在这个数据结构使用起来，仍然理解不够透彻！！！
//         class BID {
//             int [] cnt;
//             int n;
//             public BID(int n) {
//                 this.n = n;
//                 cnt = new int [n+1]; // 线段树：下标从1 开始
//             }
//             int lowbit(int x) {
//                 return x & -x;
//             }
//             void update(int x, int v) {
//                 while (x <= n) { // O(logN) ？并不是每个都更新
//                     cnt[x] += v;
//                     x += lowbit(x); // 而是跳着更新必要区间， O(logN)
//                 }
//             }
//             int query(int x) {
//                 int r = 0;
//                 while (x > 0) { // 仍然是，跳转着，从必要区间读值
//                     r += cnt[x];
//                     x -= lowbit(x); // 遍历必区间，从必要区间的根节点直接读值 
//                 }
//                 return r;
//             }
//         }
//         public long numberOfPairs(int[] a, int[] b, int dif) {
//             // 【构建最大线段树：】根据数组的最大长度 1e5 来建最大线段树
//             BID tree = new BID((int)1e5);
//             long r = 0;
//             for (int i = 0; i < a.length; i++) {
//                 int v = a[i] - b[i]; // 它的取值范围是：【－20000, 20000】， dif 的取值范围是：【－10000, 10000】
//                 r += tree.query(v + dif + 40000); // 【 v+dif】的取值范围是：【－30000, 30000】
//                 // 【 v + dif ＋ 400000】的取值范围是：【10000, 70000】我想目的应该是确保值是【在线段树的有效可更新范围内？】
//                 tree.update(v + 40000, 1);
//             }
//             return r;
//         }
//         public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
//             BinaryIndexedTree tree = new BinaryIndexedTree(100000);
//             long ans = 0;
//             for (int i = 0; i < nums1.length; ++i) {
//                 int v = nums1[i] - nums2[i];
//                 ans += tree.query(v + diff + 40000);
//                 tree.update(v + 40000, 1);
//             }
//             return ans;
//         }

//         class ST { // 【线段树：最值，元素最大值】【不知道为佳么，它的运行效率很低？！！！】
//             ST left, right; // 参二BST: 左右子节点
//             int l, r, val;  // 最大值线段树的节点属性：【l, r】 + 所属区间的，最大值 
//             public ST(int l, int r) {
//                 this.l = l;
//                 this.r = r;
//                 setup(this, l, r);
//             }
//             void setup(ST node, int l, int r) { // 构建线段树：自顶向下构建，自底向上回归更新父节点最大值 
//                 if (l == r) return ;
//                 int m = (l + r) / 2;
//                 if (node.left == null) { // 任何时候构建：左右子树总是蛮生同时存在，后续不用再判断空与非空的问题
//                     node.left = new ST(l, m);
//                     node.right = new ST(m+1, r);
//                 }
//                 setup(node.left, l, m);
//                 setup(node.right, m+1, r);
//                 node.val = Math.max(node.left.val, node.right.val); // 最大值线段树：根节点的值，为左右子树值的【最大值】
//             }
//             void update(ST node, int idx, int val) { // 更新线段树中某个节点的最值 ?
//                 if (idx < node.l || idx > node.r) return ; // 待更新节点 idx 不在当前区间【l, r】, 直接返回
//                 if (node.l == node.r && node.l == idx) { // 叶子节点：最小区间，直接更新
//                     node.val = val;
//                     return ;
//                 }
//                 update(node.left, idx, val);
//                 update(node.right, idx, val);
//                 node.val = Math.max(node.left.val, node.right.val); // 当 l+1==r 时，必定会存在左右两个子节点吗？怎么保证左右同时非空？
//             }
//             int rangeMaxQuery(ST node, int l, int r) {
//                 if (node.l > r || node.r < l) return 0;
//                 if (node.l >= l && node.r <= r) return node.val;
//                 return Math.max(rangeMaxQuery(node.left, l, r), rangeMaxQuery(node.right, l, r));
//             }
//         }
//         // O(NlogN): 有个带点儿贪心思路的解法？与先前，最长上升子序列是一样的吗？
//         // 动态规划： f[n][N=1e5+1==Val] 来算最长的可能的严格上升子序列
//         // 动态更新： f[i-1][V] ＝＝》 f[i][v] 需要从 f[i-1][k]k 是在【v-k, v）范围内来更新 f[i][v]
//         // 动态更新：因为要取 f[i-1][v-k] 。。。 f[i-1][v-1] 片段范围内的最大值，这里使用线段树来有效解决最值问题
//         public int lengthOfLIS(int[] a, int k) {
//             int n = a.length, N = (int)1e5;
//             // int [][] f = new int [n][N]; // 动态规划数组
//             // // 动态规划数组；初始化
//             // for (int i = 0; i < n; i++) // 假如以数组中每个元素作第一个，长度为1;
//             //     f[i][a[i]] = 1;
//             // for (int i = 1; i < n; i++) { // 动态更新 f[i][v]
//             //     int v = a[i];
//             //     // 如果不使用当前下标 i,
//             //     f[i][v] = Math.max(f[i][v], f[i-1][v]);
//             //     // 如果使用当前下标 i, 从 f[i-1][v-k,v-1] ＋ 1 取最大值【最大值，怎么取？】 
//             //     for (int j = Math.max(0, v-k); j < v; j++) { // 遍历 v 片段：【v-k, v-1】
//             //     }
//             // }
//             ST r = new ST(1, N);
//             int ans = 0;
//             for (int v : a) {
//                 int preMax = r.rangeMaxQuery(r, v-k, v-1);
//                 r.update(r, v, preMax+1); // 这里说，最长上升子序列，包含当前数 v, 并更新最大值线段树， v 取值 preMax+1
//                 ans = Math.max(ans, preMax + 1);
//             }
//             return ans;
//         }
//         class Node {
//             int l, r, v;
//         }
//         class ST {
//             Node [] tr;
//             public ST(int n) {
//                 tr = new Node[4 * n];
//                 for (int i = 0; i < tr.length; i++) tr[i] = new Node();
//                 build(1, 1, n);
//             }
//             void build(int idx, int l, int r) { // 彻底的自顶向下构建
//                 tr[idx].l = l;
//                 tr[idx].r = r;
//                 if (l == r) return ;
//                 int m = (l + r) >> 1;
//                 build(idx << 1, l, m);
//                 build(idx << 1 | 1, m+1, r);
//             }
//             void modify(int idx, int x, int v) {
//                 // 如果是叶子节点，最小区间，更新返回【叶子节点的最值，如何向上返回到父节点？？？】因为其它任何时候，都是先从根节点遍历，就是根节点只有一个值，无需返回！！！
//                 if (tr[idx].l == x && tr[idx].r == x) {
//                     tr[idx].v = v;
//                     return ;
//                 }
//                 // 非叶子节点，判断属于左右子树，的哪一半，并更新单侧子树
//                 int m = (tr[idx].l + tr[idx].r) >> 1;
//                 if (x <= m) modify(idx << 1, x, v);
//                 else modify(idx << 1 | 1, x, v);
//                 // 更新完单节点最值，向上返回更新父节点最大值 
//                 pushup(idx); // 只更新了一层，但是递归调用，仍然会涉及到的必逐层更新 
//             }
//             void pushup(int idx) {
//                 tr[idx].v = Math.max(tr[idx << 1].v, tr[idx << 1 | 1].v);
//             }
//             int query(int idx, int l, int r) {
//                 if (tr[idx].l >= l && tr[idx].r <= r) return tr[idx].v;
//                 // if (l <= tr[idx].l && tr[idx].r >= r) return tr[idx].v; // 为什么会感觉上面写反了？
//                 int m = (tr[idx].l + tr[idx].r) >> 1, v = 0;
//                 if (l <= m) v = query(idx << 1, l, r);
// // 右子树时，取左右子树的最大值【BUGGLY BUGGLY CODING:】【l, r】是可以跨左右两个子树的！！！【改成下面的！！！】
//                 // else v = Math.max(v, query(idx << 1 | 1, l, r)); 
//                 if (r > m) v = Math.max(v, query(idx << 1 | 1, l, r)); // 右子树时，取左右子树的最大值 
//                 return v;
//             }
//         }
//         public int lengthOfLIS(int[] a, int k) {
//             int max = Arrays.stream(a).max().getAsInt();
//             ST tr = new ST(max);
//             int ans = 0;
//             for (int v : a) {
//                 int t = tr.query(1, v-k, v-1) + 1;
//                 ans = Math.max(ans, t);
//                 tr.modify(1, v, t);
//             }
//             return ans;
//         }

//         class BookMyShow {
//             int n, m;
//             int [] min; // 标记：每个区间上观众数的最小值 
//             long [] sum;// 
//             public BookMyShow(int n, int m) {
//                 this.n = n;
//                 this.m = m;
//                 min = new int [n * 4];
//                 sum = new long [n * 4];
//             }
//             public int [] gather(int k, int maxRow) {
//                 int idx = index(1, 1, n, maxRow+1, m-k);
//                 if (idx == 0) return new int [] {}; // 不存在
//                 var seats = (int)query_sum(1, 1, n, idx, idx);
//                 add(1, 1, n, idx, k); // 占据 k 个座位
//                 return new int [] {idx-1, seats};
//             }
//             public boolean scatter(int k, int maxRow) {
//                 if ((long)(maxRow + 1) * m - query_sum(1, 1, n, 1, maxRow+1) < k) return false; // 剩余座位不足 k 个
//                 // 从第一个没有坐满的排开始占座
//                 for (var i = index(1, 1, n, maxRow+1, m-1); ; ++i) {
//                     var left_seats = m - (int)query_sum(1, 1, n, i, i);
//                     if (k <= left_seats) { // 剩余人数不够坐后面的排
//                         add(1, 1, n, i, k);
//                         return true;
//                     }
//                     k -= left_seats; // 这里是在干什么呢？
//                     add(1, 1, n, i, left_seats);
//                 }
//             }
//             // 返回区间 [L,R] 内的元素和
//             long query_sum(int idx, int l, int r, int L, int R) { // L 和 R 在整个递归过程中均不变，将其大写，视作常量
//                 if (L <= l && r <= R) return sum[idx];
//                 var sum = 0l;
//                 var m = (l + r) >> 1;
//                 if (L <= m) sum += query_sum(idx << 1, l, m, L, R);
//                 // if (m+1 <= R)
//                 if (m < R) sum += query_sum(idx << 1 | 1, m+1, r, L, R);
//                 return sum;
//             }
//             // 将 idx 上的元素值增加 val
//             void add(int o, int l, int r, int idx, int val) {
//                 if (l == r) {
//                     min[o] += val;
//                     sum[o] += val;
//                     return ;
//                 }
//                 val m = (l + r) >> 1;
//                 if (idx <= m) add(o << 1, l, m, idx, val);
//                 else add(o << 1 | 1, m+1, r, idx, val);
//                 min[o] = Math.min(min[o << 1], min[o << 1 | 1]);
//                 sum[o] = sum[o << 1] + sum[o << 1 | 1];
//             }
//             // 返回区间 [l, R] 中 <= val 的最靠左的位置，不存在时返回 0
//             int index(int o, int l, int r, int R, int val) { // R 在整个递归过程中均不变，将其大写，视作常量
//                 if (min[o] > val) return 0; // 说明整个区间的元素值都大于 val
//                 if (l == r) return l;
//                 var m = (l + r) >> 1;
//                 if (min[o*2] <= val) return index(o * 2, l, m, R, val); // 看看左半部分
//                 if (m < R) return index(o * 2 + 1, m+1, r, R, val);     // 看看右半部分
//                 return 0;
//             }
//         }
    }
    public static void main (String[] args) {
        Solution s  =  new Solution ();

        String a = "101101";
        int [][] b = new int [][] {{0,5},{1,2}};
        
        int [][] r = s.substringXorQueries(a, b);
        System.out.println("r.length: " + r.length);
        for (int z = 0; z < r.length; ++z) 
            System.out.println(Arrays.toString(r[z]));
    }
}

// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);



