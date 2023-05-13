import com.TreeNode;
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

        // public boolean haveConflict(String[] s, String[] t) {
        //     int a = getVal(s[0]), b = getVal(s[1]);
        //     int c = getVal(t[0]), d = getVal(t[1]);
        //     if (a <= c) {
        //         if (b < c) return false;
        //         return true;
        //     } else return haveConflict(t, s);
        // }
        // int getVal(String t) {
        //     char [] s = t.toCharArray();
        //     return Integer.parseInt(t.substring(0, 2)) * 60 + Integer.parseInt(t.substring(3));
        // }
        // class Item implements Comparable<Item> {
        //     int v, f;
        //     public Item(int v, int f) {
        //         this.v = v;
        //         this.f = f;
        //     }
        //     @Override public int compareTo(Item other) { // 想要按值降序排列
        //         return this.v != other.v ? other.v - this.v : other.f - this.f;
        //     }
        //     public void print() {
        //         System.out.println("[v: " + v + ", f: " + f + "]"); 
        //     }
        // }
//         public long makeSimilar(int[] a, int[] b) {
//             int n = a.length, N = 1000001;
//             int [] cnt = new int [N];
//             for (var v : b) cnt[v]++;
//             TreeMap<Integer, Integer> ma = new TreeMap<>(Collections.reverseOrder());
//             TreeMap<Integer, Integer> mb = new TreeMap<>(Collections.reverseOrder());
//             for (int i = 1; i < N; i++) 
//                 if (cnt[i] > 0)
//                     // sb.add(new Item(i, cnt[i]));
//                     mb.put(i, cnt[i]);
//             Arrays.fill(cnt, 0);
//             for (var v : a) cnt[v]++;
//             for (int i = 1; i < N; i++) 
//                 if (cnt[i] > 0)
//                     // sa.add(new Item(i, cnt[i]));
//                     ma.put(i, cnt[i]);
//             System.out.println("ma.size(): " + ma.size());
//             for (Map.Entry<Integer, Integer> en : ma.entrySet()) 
//                 System.out.print(en.getKey() + ", " + en.getValue() + "\n");
//             System.out.println("mb.size(): " + mb.size());
//             for (Map.Entry<Integer, Integer> en : mb.entrySet()) 
//                 System.out.print(en.getKey() + ", " + en.getValue() + "\n");

//         // 这是最气人的一次比较，每个题目的时间被卡得极严，连最简单的题目也不给过。。。
//         public int diagonalPrime(int[][] a) {
//             int n = a.length;
//             List<int []> l = new ArrayList<>();
//             for (int i = 0; i < n; i++)
//                 for (int j = 0; j < n; j++)
//                     l.add(new int [] {a[i][j], i, j});
//             Collections.sort(l, (x, y)-> x[0] != y[0] ? y[0] - x[0] : x[1] - y[1]); // 降序排列
//             for (int [] v : l)
//                 if ((v[1] == v[2] || v[2] == n-1 - v[1]) && isPrime(v[0])) return v[0];
//             return 0;
//         }
//         public static boolean isPrime(int n) {
//             if (n < 3) {
//                 if (n == 2) 
//                     return true;
//                 else
//                     return false;
//             }
//             for (int i = 2; i < n; i++) 
//                 if (n % i == 0) 
//                     return false;
//             return true;
//         }

//         public long [] distance(int[] a) { // TLE TLE TLE: 就是想不到平时这类没要求的题目怎么会超时的？ 1066/1068 不知道是哪里错掉了？ 3 个不过【这个题我已经不想写它了。。。】
//             int n = a.length;
//             Map<Integer, List<Integer>> m = new HashMap<>();
//             for (int i = 0; i < n; i++) 
//                 m.computeIfAbsent(a[i], z -> new ArrayList<>()).add(i);
//             long [] r = new long [n];
//             for (Map.Entry<Integer, List<Integer>> en : m.entrySet()) {
//                 List<Integer> l = en.getValue();
//                 if (l.size() == 1) {
//                     r[l.get(0)] = 0;
//                     continue;
//                 }
//                 long [] s = new long [l.size()]; // 它说这里用 prefix 算。妈的。。。
//                 s[0] = l.get(0);
//                 for (int i = 1; i < l.size(); i++) 
//                     s[i] = s[i-1] + l.get(i);
//                 for (int i = 0; i < l.size(); i++) 
//                     r[l.get(i)] = (long)l.get(i) * (i+1) - s[i] + (s[l.size()-1] - (i == 0 ? 0 : s[i-1])) - l.get(i) * (l.size()-i);
//             }
//             return r;
//         }

//         // The recurrence relation is
//         //     fn(i, x) = min[ fn(i+1, x), max( abs(nums[i]-nums[i+1]), fn(i+2, p-1) )] ？没看懂，它在说什么？？？
//         // and fn(0,p) gives the desired answer.
//         public int minimizeMax(int[] a, int p) { // 这个就是看着题目，认不出来，没能认出来它是在考查什么。。。
//             int n = a.length;
//             Arrays.sort(a);// 先排序是对的 // sort to get minimum differences
//             int l = -1, h = 1000000007; // binary search logic: 直接二分查找这个最小可能存在的最大差值 
//             while (l < h - 1) {
//                 int m = l + (h-l) / 2;
//                 int cnt = 0; // to count total possible pairs if mid is the max value
//                 for (int i = 1; i < n; i++) 
//                     if (a[i] - a[i-1] <= m) { // counting only if difference is <= mid
//                         i++;
//                         cnt++;
//                     }
//                 if (cnt >= p) h = m; // store the last possible value in hi
//                 else l = m;
//             }
//             return h;
//         }

//         // 我记忆化搜索的方向，与它动态规划的方向是反的。可是两个本来就是反着的。。。
//         public int minimumVisitedCells(int[][] a) { // TLE TLE TLE 已经是记忆化搜索了呀？！！！怎么会超时的呢？
//             m = a.length;
//             n = a[0].length;
//             f = new Integer [m][n];  
//             for (int i = 0; i < m; i++) // 这里有个可以 stream 一行搞定的写法，忘记了
//                 Arrays.fill(f[i], Integer.MAX_VALUE / 2);
//             int r = dfs(0, 0, a);
//             System.out.println("f.length: " + f.length);
//             for (int z = 0; z < f.length; ++z) 
//                 System.out.println(Arrays.toString(f[z]));
//             return r == Integer.MAX_VALUE / 2 ? -1 : r;
//         }
//         Integer [][] f;
//         int m, n;
//         int dfs(int ii, int jj, int [][] a) { // 记忆化揵从当前坐标到终点的最小步数
//             // if (ii >= m || jj >= n) return Integer.MAX_VALUE / 2; // 主要是免得溢出
//             if (ii == m-1 && jj == n-1) return f[ii][jj] = 1;
//             if (f[ii][jj] < Integer.MAX_VALUE / 2) return f[ii][jj];
//             int r = Integer.MAX_VALUE / 2;
//             // for (int j = Math.min(a[ii][jj] + jj, n-1); j > jj; j--) {
//             int max = Math.min(a[ii][jj] + jj, n-1);
//             for (int j = max; j > jj; j--) {
//                 int cur = 1 + dfs(ii, j, a);
//                 r = Math.min(r, cur);
//             }
//             max = Math.min(a[ii][jj] + ii, m-1);
//             for (int i = max; i > ii; i--) {
//                 int cur = 1 + dfs(i, jj, a);
//                 r = Math.min(r, cur);
//             }
//             return f[ii][jj] = r;
//         }
//         // BFS: 广度优先搜索: 这一种解法弄通了。。。。。【任何时候，活宝妹就是一定要嫁给亲爱的表哥！！！】
//             public int minimumVisitedCells(int[][] a) { // 这个解法：勉强可以过。。。
//                 int m = a.length, n = a[0].length, cnt = 1;
//                 if (m == 1 && n == 1) return 1;
//                 Deque<int []> q = new ArrayDeque<>();
//                 boolean [][] vis = new boolean [m][n];
//                 q.offerFirst(new int [] {0, 0});
//                 vis[0][0] = true;
//                 while (!q.isEmpty()) {
//                     for (int size = q.size()-1; size >= 0; size--) {
//                         int [] r = q.pollLast();
//                         int ii = r[0], jj = r[1];
//                         // if (ii == m-1 && jj == n-1) return cnt;     // 先行检查结果，每个测试用例省一点儿。。。。。
//                         // if (a[ii][jj] == 0 || vis[ii][jj]) continue;// 先行判断，可以省空间，妈呀。。。真过分
//                         // vis[ii][jj] = true;
//                         // 向右扫描扩展
//                         for (int j = jj+1; j <= a[ii][jj] + jj && j < n; j++) {
//                             if (ii == m-1 && j == n-1) return cnt+1;
//                             if (a[ii][j] != 0 && !vis[ii][j]) {
//                                 vis[ii][j] = true;
//                                 q.offerFirst(new int [] {ii, j});
//                             }
//                         }
//                         // 向下扫描扩展
//                         for (int i = ii+1; i <= a[ii][jj] + ii && i < m; i++) {
//                             if (i == m-1 && jj == n-1) return cnt+1;
//                             if (a[i][jj] != 0 && !vis[i][jj]) {
//                                 vis[i][jj] = true;
//                                 q.offerFirst(new int [] {i, jj});
//                             }
//                         }
//                     }
//                     cnt++;
//                 }
//                 return -1; 
//             }
//         // 我记忆化搜索的方向，与它动态规划的方向是反的。可是两个本来就是反着的。。。
//         public int minimumVisitedCells(int[][] a) { // TODO: TLE TLE TLE 动态规划，要跟上面的记忆化搜索的方向是反着遍历的，就是自顶向下，与自底向上的区别. 另外最后 11 个测试样例不过。。。
//             int m = a.length, n = a[0].length;
//             int [][] f = new int [m][n];
//             Arrays.stream(f).forEach(x -> Arrays.fill(x, Integer.MAX_VALUE / 2));  // 流式处理法
//             f[0][0] = 1; // 初始化：左上角，只遍历了当前一个格
//             // 开始遍历：从上到下，一行一行；从左到右，一列一列，计算到达 a[i][j] 的最小访问方格数 f[i][j]
//             for (int i = 0; i < m; i++) 
//                 for (int j = 0; j < n; j++) { // 计算能够到达当前方格 a[i][j] 的最小访问方格数 f[i][j]
//                     Queue<int []> q = new PriorityQueue<>((x, y) -> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]); // 我想不明白，为什么要分开用两个优先队列？
//                     for (int k = 0; k < j; k++) {
//                         if (a[i][k] + k < j) continue;
//                         q.offer(new int [] {f[i][k] + 1, k}); // 这里只统计一步跳过来的
//                     }
//                     for (int k = 0; k < i; k++) {
//                         if (a[k][j] + k < i) continue;
//                         q.offer(new int [] {f[k][j] + 1, k});
//                     }
//                     if (!q.isEmpty())
//                         f[i][j] = q.peek()[0];
//                 }
//             return f[m-1][n-1] >= Integer.MAX_VALUE / 2 ? -1 : f[m-1][n-1];
//         }
//         public int minimumVisitedCells(int[][] a) { // 感觉基本思路跟上面差不多，但是多了优化：保证每行每列的某个下标仅访问一次
//             int m = a.length, n = a[0].length;
//             boolean [][] vis = new boolean [m][n];
//             int [] h = new int [m], v = new int [n]; // 这里有步优化：记录每行每列的最远不曾遍历过的列、行所达的最远不曾遍历的下标记序号
//             Deque<int []> q = new ArrayDeque<>();
//             q.offerFirst(new int [] {0, 0});
//             h[0] = 1; // 初始化
//             v[0] = 1;
//             for (int cnt = 1; !q.isEmpty(); cnt++)
//                 for (int size = q.size()-1; size >= 0; size--) {
//                     int [] r = q.pollLast();
//                     int i = r[0], j = r[1];
//                     if (i == m-1 && j == n-1) return cnt;
//                     for (int k = Math.max(h[i], j+1); k <= a[i][j] + j && k < n; k++)// 这里有步优化：它不是每次都从 j+1 开始，而是从不曾遍历过的某个下标开始
//                         if (!vis[i][k]) {
//                             vis[i][k] = true;
//                             q.offerFirst(new int [] {i, k});
//                         }
//                     while (h[i] < n && vis[i][h[i]]) h[i]++;// 这里就是，平移到不曾遍历过的下标，每个下标只遍历一次
//                     for (int k = Math.max(v[j], i+1); k <= a[i][j] + i && k < m; k++)
//                         if (!vis[k][j]) {
//                             vis[k][j] = true;
//                             q.offerFirst(new int [] {k, j});
//                         }
//                     while (v[j] < m && vis[v[j]][j]) v[j]++;// 这里就是，平移到不曾遍历过的下标，每个下标只遍历一次
//                 }
//             return -1;
//         }
//         public int minimumVisitedCells(int[][] a) { // 感觉是条理清楚了，使用了数据结构，但是狠慢，效率低，不如上面的两个数组线性遍历记录不曾遍历的最小下标
//             int m = a.length, n = a[0].length;
//             TreeSet<Integer> []  h = new TreeSet[m], v = new TreeSet [n];
//             for (int i = 0; i < m; i++) {
//                 h[i] = new TreeSet<Integer>();
//                 for (int j = 0; j < n; j++) 
//                     h[i].add(j);
//             }
//             for (int j = 0; j < n; j++) {
//                 v[j] = new TreeSet<>();
//                 for (int i = 0; i < m; i++) 
//                     v[j].add(i);
//             }
//             Deque<int []> q = new ArrayDeque<>();
//             q.offerFirst(new int [] {0, 0, 1});
//             while (!q.isEmpty()) {
//                 int [] cur = q.pollLast();
//                 int i = cur[0], j = cur[1], d = cur[2];
//                 if (i == m-1 && j == n-1) return d;
//                 Integer k = h[i].ceiling(j+1); // 往右扫描: k < n FOR SURE
//                 while (k != null && k <= a[i][j] + j) {
//                     q.offerFirst(new int [] {i, k.intValue(), d+1});
//                     h[i].remove(k);            // 每遍历过一个格，就将相关，行记录与列记录里，遍历过的这个格清除掉，以避免重复遍历 
//                     v[k.intValue()].remove(i); // 每遍历过一个格，就将相关，行记录与列记录里，遍历过的这个格清除掉，以避免重复遍历 
//                     k = h[i].ceiling(j+1);     // 下一个，永远是有序集合里，下一个不曾遍历过的【遍历过的，都被清除掉了。。。】 
//                 }
//                 k = v[j].ceiling(i+1);// 往下扫描: k < m
//                 while (k != null && k <= a[i][j] + i) {
//                     q.offerFirst(new int [] {k.intValue(), j, d+1});
//                     v[j].remove(k);           // 每遍历过一个格，就将相关，行记录与列记录里，遍历过的这个格清除掉，以避免重复遍历 
//                     h[k.intValue()].remove(j);// 每遍历过一个格，就将相关，行记录与列记录里，遍历过的这个格清除掉，以避免重复遍历 
//                     k = v[j].ceiling(i+1);    // 下一个，永远是有序集合里，下一个不曾遍历过的【遍历过的，都被清除掉了。。。】 
//                 }
//             }
//             return -1;
//         }

//         public int[] findColumnWidth(int[][] a) {
//             int m = a.length, n = a[0].length, r [] = new int [n];
//             for (int i = 0; i < n; i++) {
//                 int cur = 0;
//                 for (int j = 0; j < m; j++) 
//                     cur = Math.max(cur, String.valueOf(a[j][i]).length());
//                 r[i] = cur;
//             }
//             return r;
//         }

//         public long[] findPrefixScore(int[] a) {
//             int n = a.length;
//             long [] s = new long [n], r = new long [n];
//             ArrayDeque<Integer> q = new ArrayDeque<>(); // 按照升序排列 
//             for (int i = 0; i < n; i++) {
//                 if (i == 0) {
//                     s[i] = a[i] * 2; // conversion
//                     r[i] = a[i] * 2; // prefix sum of conversion
//                     q.offerFirst(a[i]);
//                     continue;
//                 }
//                 while (!q.isEmpty() && q.peekFirst() <= a[i]) q.pollFirst();
//                 q.offerFirst(a[i]);
//                 s[i] = a[i] + q.peekLast();
//                 r[i] = r[i-1] + s[i];
//             }
//             return r;
//         }

//     // class Graph {
//             // 有向图: 【偶早上昏昏的脑袋呀。。。】
//         List<int []> [] g;
//         int n;
//         public Graph(int n, int[][] edges) {
//             this.n = n;
//             g = new ArrayList[n];
//             Arrays.setAll(g, z -> new ArrayList<int []>());
//             for (int [] e : edges) 
//                 g[e[0]].add(new int [] {e[1], e[2]});
//         }
//         public void addEdge(int[] edge) {
//             g[edge[0]].add(new int [] {edge[1], edge[2]});
//         }
//         public int shortestPath(int idx, int v) {
//             int [] d = new int [n];
//             Arrays.fill(d, Integer.MAX_VALUE);
//             d[idx] = 0;
//             Queue<int []> q = new PriorityQueue<>((x, y) -> x[0] - y[0]);
//             q.offer(new int [] {idx, d[idx]});
//             while (!q.isEmpty()) {
//                 int [] cur = q.poll();
//                 int u = cur[0], x = cur[1];
//                 if (u == v) continue;
//                 // if (u == v) return x;  // 这里并不一定是最佳值 
//                 for (int [] nt : g[u]) // nt: next
//                     if (x + nt[1] < d[nt[0]]) {
//                         d[nt[0]] = x + nt[1];
//                         q.offer(new int [] {nt[0], d[nt[0]]});
//                     }
//             }
//             return d[v] == Integer.MAX_VALUE ? -1 : d[v];
//         }

//         public int[] rowAndMaximumOnes(int[][] a) {
//             int m = a.length, n = a[0].length, i = 0;
//             List<int []> l = new ArrayList<>();
//             for (int [] v : a) 
//                 l.add(new int [] {i++, Arrays.stream(v).sum()});
//             Collections.sort(l, (x, y) -> x[1] != y[1] ? y[1] - x[1] : x[0] - y[0]);
//             return l.get(0);
//         }

//         public int maxDivScore(int[] a, int[] b) {
//             List<int []> l = new ArrayList<>();
//             for (int v : b) {
//                 int cur = 0;
//                 for (int x : a) 
//                     if (x % v == 0) cur++;
//                 l.add(new int [] {v, cur});
//             }
//             Collections.sort(l, (x, y) -> x[1] != y[1] ? y[1] - x[1] : x[0] - y[0]);
//             return l.get(0)[0];
//         }

//         public int addMinimum(String t) { 
//             int n = t.length(), r = 0, m = 3 * n;
//             if (t.chars().distinct().count() == 1) return 2 * n;
//             char [] s = t.toCharArray();
//             Set<String> ss = new HashSet<>(List.of("ab", "bc", "ca"));
//             for (int i = 0; i < n-1; i++) {
//                 String cur = t.substring(i, i+2);
//                 if (i == 0 && cur.equals("ab") || i > 0 && ss.contains(cur)) continue;
//                 if (cur.equals("ac")) r += 1;
//                 else if (cur.equals("aa")) r += 2;
//                 else if (cur.equals("bc")) r += 1;
//                 else if (cur.equals("ba")) r += (i == 0 ? 2 : 1);
//                 else if (cur.equals("bb")) r += (i == 0 ? 3 : 2);
//                 else if (cur.equals("ca")) r += (i == 0 ? 2 : 0);
//                 else if (cur.equals("cb")) r += (i == 0 ? 3 : 1);
//                 else if (cur.equals("cc")) r += (i == 0 ? 4 : 2);
//             }
//             return r + (s[n-1] == 'a' ? 2 : (s[n-1] == 'b' ? 1 : 0));
//         }
//         public int addMinimum(String T) { // 【最直观、方便的写法】
//             int n = T.length(), r = 0;
//             char [] t = T.toCharArray();
//             Deque<Character> s = new ArrayDeque<>();
//             for (char c : t) s.offerFirst(c);
//             while (!s.isEmpty()) {
//                 if (!s.isEmpty() && s.peekFirst() == 'c') s.pollFirst();
//                 else r++;
//                 if (!s.isEmpty() && s.peekFirst() == 'b') s.pollFirst();
//                 else r++;
//                 if (!s.isEmpty() && s.peekFirst() == 'a') s.pollFirst();
//                 else r++;
//             }
//             return r;
//         }
//         public int addMinimum(String S) {
//             int n = S.length(), k = 0;
//             char [] s = S.toCharArray();
//             char p = 'z';
//             for (int i = 0; i < n; i++) {
//                 k += (s[i] <= p ? 1 : 0);
//                 p = s[i];
//             }
//             return k * 3 - n;
//         }

//         List<Integer> [] g; 
//         Map<Integer, Integer> cnt = new HashMap<>(); // 字典更好：因为只记录必要的节点，不连续省空间，同样方便查询
//         int n;
//         public int minimumTotalPrice(int n, int[][] egs, int[] p, int[][] t) {
//             this.n = n;
//             // 【建图】
//             g = new ArrayList [n];
//             Arrays.setAll(g, z -> new ArrayList<>());
//             for (int [] e : egs) {
//                 int u = e[0], v = e[1];
//                 g[u].add(v);
//                 g[v].add(u);
//             }
//             // 【BFS 最短路径：统计必经节点的访问频率】: 这里没想明白的是：BFS 是可以求最短边数，但因为这个题目的权重要各个节点，感觉未必呀，没想透。。。
//             // 同样，DFS 也是可以求路径的，怎么最短，怎么最轻，得想透了。。。
//             // for (int [] v : t) bfs(v[0], v[1]);
//             // 【 dfs: 解法，也写一下】
//             for (int [] v : t) {
//                 List<Integer> path = new ArrayList<>();
//                 dfs(v[0], v[1], -1, path); // 这里找，一条路径，感觉可以是任意一条路径，也就是说，是题目自己得保证答案唯一？！！！
//                 for (int x : path) cnt.put(x, cnt.getOrDefault(x, 0) + 1);
//             }
//             // 【动态规划：计算最优结果】
//             // int [] currPrice = new int [n]; // 将【节点计数】同步到节点代价里去；同时将其它不需访问的节点代价【清零】
//             // for (int i = 0; i < n; i++) currPrice[i] = p[i] * cnt.getOrDefault(i, 0);
//             // int [] ans = helper(0, -1, currPrice); // (post-order) depth-first search 【】
//             int [] ans = dfs(-1, 0, p);
//             return Math.min(ans[0], ans[1]);
//         }
//         // 【下面的写法：代码写得更透一点儿】post order dfs
//         // return int[]{cost1, cost2}, 【cost1: HALVE current node; cost2: it is WHOLE. don't halve current node】
//         int [] dfs(int p, int src, int [] price) {
//             int [] ans = new int [2];
//             for (int dst : g[src]) {
//                 if (dst == p) continue;
//                 int [] oneChildAns = dfs(src, dst, price);
//                 // if HALVE the current node, then the child use WHOLE, cann't halve the price, 
//                 ans[0] += oneChildAns[1];
//                 // if WHOLE (doesn't halve) CURRENT node: then the child can 【HALVE || WHOLE】 the price or not, we choose the min one.
//                 ans[1] += Math.min(oneChildAns[0], oneChildAns[1]);
//             }
//             if (cnt.containsKey(src)) {
//                 ans[0] += price[src] * cnt.get(src) / 2;
//                 ans[1] += price[src] * cnt.get(src);
//             }
//             return ans;
//         }
//         // 【可以再参考再下面一种写法，代码写得更透一点儿】
//         int [] helper(int u, int p, int [] currPrice) { // u: curNode, 【 u ＝＝》 v】【 0:whole, 1:halved】
//             List<Integer> neighbors = g[u];
//             // When current node is halving, because its adjacent nodes must be whole (not havle), so that whole (not havle) contains neighbors whose values are whole.
//             // When current node is whole (not havle), its adjacent nodes can be either whole or halved, so that we take the minimum between whole (not havle) and havle.
//             int whole = 0, halved = 0; // 用来计算 u 的相邻节点的整与半
//             for (int v : neighbors) {
//                 if (v == p) continue;
//                 int [] neiAns = helper(v, u, currPrice);
//                 whole += neiAns[0];
//                 halved += Math.min(neiAns[0], neiAns[1]); 
//             } // 当前 u 取半，邻居节点就必须取整 whole; 当前 U 取整，邻居节点就可整可半，所以可以选择最小值
//             return new int [] {currPrice[u] + halved, currPrice[u] / 2 + whole} ;           
//         }
//         boolean dfs(int u, int v, int p, List<Integer> path) { // p: parent
//             path.add(u);
//             if (u == v) return true; // 找到一条路径。。。
//             for (int next : g[u]) {
//                 if (next == p) continue;
//                 if (dfs(next, v, u, path)) return true; // 返回：任意一条可通路径。。。任意的
//             }
//             path.remove(path.size()-1);
//             return false;
//         }
//         void bfs(int src, int dst) {
//             Deque<Integer> q = new ArrayDeque<>();
//             boolean [] vis = new boolean [n];
//             int [] p = new int [n]; // p: parent
//             Arrays.fill(p, -1);
//             q.offerFirst(src);
//             vis[src] = true;
//             while (!q.isEmpty()) {
//                 int cur = q.pollLast();
//                 if (cur == dst) break;
//                 for (int v : g[cur]) // cur 
//                     if (!vis[v]) {
//                         vis[v] = true;
//                         p[v] = cur; // cur
//                         q.offerFirst(v);
//                     }
//             }
//             int cur = dst; // 倒序：根据先前记录过的父节点，把过程节点全部计数一遍
//             while (cur != -1) {
//                 cnt.put(cur, cnt.getOrDefault(cur, 0) + 1);
//                 cur = p[cur];
//             }
//         }

//         // 【方法一：两遍DFS 的解题解题思路】
//         public TreeNode replaceValueInTree(TreeNode r) {
//             dfs(r, 0);
//             return dfsSecondTime(r, new TreeNode(0), 0);
//         }
//         Map<Integer, Integer> m = new HashMap<>(); // 用来记录每层的和
//         // 这里的问题是，直接在原树上改，可以会存在这样那样同步的冲突问题，最简单的办法就是直接建棵新树。。。
//         TreeNode dfsSecondTime(TreeNode r, TreeNode root, int d) {
//             int nextLevelCousinSum = m.getOrDefault(d+1, 0) - (r.left != null ? r.left.val : 0) - (r.right != null ? r.right.val : 0);
//             if (r.left != null) {
//                 root.left = new TreeNode(nextLevelCousinSum);
//                 dfsSecondTime(r.left, root.left, d+1);
//             }
//             if (r.right != null) {
//                 root.right = new TreeNode(nextLevelCousinSum);
//                 dfsSecondTime(r.right, root.right, d+1);
//             }
//             return root;
//         }
//         void dfs(TreeNode r, int d) {
//             if (r == null) return ;
//             m.put(d, m.getOrDefault(d, 0) + r.val);
//             dfs(r.left, d+1);
//             dfs(r.right, d+1);
//         }
//         // 【方法二：】同样精巧轻巧的写法. 不用两遍DFS, 在原树上改
//         public TreeNode replaceValueInTree(TreeNode root) {
//             List<TreeNode> q = new ArrayList<>();
//             q.add(root);
//             root.val = 0; // 这里是，手动改的
//             while (!q.isEmpty()) {
//                 int nextLevelSum = 0;
//                 List<TreeNode> tmp = new ArrayList<>();
//                 for (int idx = 0; idx < q.size(); idx++) {
//                     TreeNode r = q.get(idx);
//                     if (r.left != null) {
//                         nextLevelSum += r.left.val;
//                         tmp.add(r.left);
//                     }
//                     if (r.right != null) {
//                         nextLevelSum += r.right.val;
//                         tmp.add(r.right);
//                     }
//                 }
//                 for (TreeNode r : q) {
//                     int sibSum = (r.left != null ? r.left.val : 0) + (r.right != null ? r.right.val : 0);
//                     if (r.left != null) r.left.val = nextLevelSum - sibSum;
//                     if (r.right != null) r.right.val = nextLevelSum - sibSum;
//                 }
//                 q.clear();
//                 q = tmp; //q 索引到 tmp
//                 // tmp.clear(); // 这里就不能再清理掉 tmp, 会把数据清空
//             }
//             return root;
//         }

//     // 【方法一：逆向思维】先用最简单的方法写一遍
//     Map<Character, String> m = new HashMap<>(); // 正向加密
//     Map<String, Integer> inv = new HashMap<>(); // 反向解密 
//     public Encrypter(char[] k, String[] v, String[] d) {
//     // public cmp(char[] k, String[] v, String[] d) {
//         // 正向加密字典
//         for (int i = 0; i < k.length; i++) m.put(k[i], v[i]);
//         // 反向解密字典
//         for (var s : d) {
//             String cur = encrypt(s);
//             if (!cur.equals(""))
//                 inv.put(cur, inv.getOrDefault(cur, 0) + 1);
//         }
//     }
//     public String encrypt(String s) {
//         String r = "";
//         for (char c : s.toCharArray()) 
//             if (!m.containsKey(c)) return "";
//             else r += m.get(c);
//         return r;
//     }
//     // 而对于 decrypt(word) 操作，如果我们直接按照题目中的要求进行分组、解密、判断是否在字典中，那么必然会使用深度优先搜索或者更高级的数据结构（例如字典树）。
//     // 一种更简单的方法是「逆向思考」：我们直接把字典中的所有单词进行加密，如果该单词可以被加密，
//     // 那么我们就将加密的结果存储在另一个哈希映射dec_count 中，键表示加密的结果，值表示该结果出现的次数（因为多个单词可以被加密成相同的结果）。
//     // 这样一来，我们只需要返回 word 作为键在哈希映射中对应的值即可。
//     public int decrypt(String t) {
//         return inv.getOrDefault(t, 0); // 这里就没想明白，怎么就变成这样了呢》？
//         // int n = t.length(); // 这里想当然地以为了，先前字典里的词只有 2 个长度，但实际上它的长度是狠长，可以狠长狠长，所以不用再分段。。。
//         // int r = 1;
//         // for (int i = 0; i < n-3; i++) 
//         //     r *= inv.getOrDefault(t.substring(i, i+4), 0);
//         // return r;
//     }
//     // 【方法二：字典树 trie】：逻辑也极其简单，不知道为什么先前就没写出来？
//     Map<Character, String> m = new HashMap<>();
//     Map<String, List<Integer>> in = new HashMap<>(); 
//     Set<String> sd = new HashSet<>(); // 可以帮助校验字典树中的遍历是否有效。。。
//     Node root;
//     public Encrypter(char[] k, String[] v, String[] d) {
//         for (int i = 0; i < k.length; i++) {
//             m.put(k[i], v[i]);
//             in.computeIfAbsent(v[i], z -> new ArrayList<>()).add(k[i]-'a');
//         }
//         for (var vi : d) sd.add(vi);
//         root = new Node();
//         for (String s : d) insert(s);
//     }
//     public String encrypt(String t) {
//         String r = "";
//         for (char c : t.toCharArray())
//             if (!m.containsKey(c)) return "";
//             else r += m.get(c);
//         return r;
//     }
//     public int decrypt(String t) {
//         return search(0, root, t);
//     }
//     int search(int idx, Node r, String t) {
//         char [] s = t.toCharArray();
//         if (idx == t.length()) // 终止条件: 
//             //  at the end of the string and checking if this is present in the dict
//             return sd.contains(r.w) ? 1 : 0; // 【 sd:】这里体现出要个字典集合的作用，以及带 w 参数的校验功能 
//         String cur = t.substring(idx, idx + 2);
//         if (!in.containsKey(cur)) return 0;
//         int ans = 0;
//         for (int v : in.get(cur))
//             if (r.c[v] != null) ans += search(idx+2, r.c[v], t);
//         return ans;
//     }
//     void insert(String t) {
//         char [] s = t.toCharArray();
//         Node r = root;
//         for (int i = 0; i < t.length(); i++) {
//             int j = s[i] - 'a';
//             if (r.c[j] == null) r.c[j] = new Node();
//             r = r.c[j];
//         }
//         r.end = true;
//         r.w = t;
//     }
//     class Node {
//         Node [] c = new Node[26];
//         boolean end = false;
//         String w;
//         Node () {}
//     }

//         【活宝妹就是一定要嫁给亲爱的表哥！！！爱表哥，爱生活！！！】
//         public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
//             int v = arrivalTime + delayedTime;
//             return v == 24 ? 0 : (v > 24 ? v -24 : v);
//         }

//         public int sumOfMultiples(int n) {
//             int r = 0;
//             for (int i = 1; i <= n; i++)
//                 if (i >= 3 && i % 3 == 0 || i >= 5 && i % 5 == 0 || i >= 7 && i % 7 == 0)
//                     r += i;
//             return r;
//         }

//         public int minOperations(int [] a) {
//             n = a.length; this.a = a;
//             int min = Arrays.stream(a).min().getAsInt(), max = Arrays.stream(a).max().getAsInt();
//             int com = gcd(min, max), r = 0;
//             if (com >= 2) {
//                 boolean hasAns = false;
//                 for (int i = 0; i < n; i++) {
//                     if (a[i] % com != 0) hasAns = true;
//                     if (a[i] > 1) r |= (1 << i);
//                     if (i < n-1) {
//                         int val = gcd(a[i], a[i+1]);
//                         g.put(i, val);
//                     }
//                 }
//                 if (!hasAns) return -1;
//             }
//             return dfs(r);
//         }
//         Map<Integer, Integer> f = new HashMap<>();
//         Map<Integer, Integer> g = new HashMap<>();
//         int n, m;
//         int dfs(int i) {
//             int v = Integer.bitCount(i);
//             if (v == 0) {
//                 m.put(v, 0);
//                 return 0;
//             } else if (v == 1) {
//                 m.put(i, 1);
//                 return 1;
//             }
//             if (m.containsKey(i)) return m.get(i);
//             int ans = Integer.MAX_VALUE;
//             for (int j = 0; j < n-1; j++) {
//                 if ((i & (1 << j)) > 0) {
//                     int v = g[j]; // gcd
//                     int one = i ^ (1 << j); // 这里状态不唯一，不能这么写，写深搜写疯了。。。
//                     ans = Math.min(ans, 1 + dfs(one));
//                     if ((i && (1 << (j+1))) > 0)
//                         ans = Math.min(ans, dfs(i ^ (1 << (j+1))));
//                 }
//             }
//         }        
//         int gcd(int x, int y) {
//             if (y == 0) return x;
//             return gcd(y, x % y);
//         }

// // TODO TODO TODO: 703/717 这个题目出得太恶心人了。
//         // 最近的比较狠 EVIL... 出题者居心何在呢？
//         // 【活宝妹就是一定要嫁给亲爱的表哥！！！爱表哥，爱生活！！！】
//         public int [] getSubarrayBeauty(int[] a, int k, int v) { 
//             int n = a.length, min = Arrays.stream(a).min().getAsInt();
//             int [] r = new int [n - k + 1];
//             if (min >= 0) return r;
//             int idx = 0, cnt = 0, val = 0;
//             for (int i = 0; i < n; i++)
//                 if (a[i] >= 0) a[i] = 0;
//             System.out.println(Arrays.toString(a));
//             Queue<Integer> q;
//             ArrayDeque<Integer> s = new ArrayDeque<>();
//             boolean larger = false;
//             q = new PriorityQueue<>((x, y)-> a[x] - a[y]); // 按值【升序】排列
//             for (int i = 0; i < k-1; i++)
//                 q.offer(i);
//             for (int i = k-1; i < n; i++) {
//                 while (!q.isEmpty() && q.peek() <= i-k) q.poll();  // 这些不合法，扔掉。。。
//                 cnt = 0;
//                 while (!q.isEmpty() && a[q.peek()] <= a[i]) {
//                     while (!q.isEmpty() && q.peek() <= i-k) {
//                         q.poll();
//                         continue;
//                     }
//                     if (!q.isEmpty() && a[q.peek()] <= a[i]) {
//                         val = a[q.peek()];
//                         s.offerFirst(q.poll());
//                         cnt++;
//                         if (cnt == v) {
//                             r[idx] = val;
//                         }
//                     }
//                 }
//                 q.offer(i);
//                 while (cnt < v && !q.isEmpty()) {
//                     while (!q.isEmpty() && q.peek() <= i-k) {
//                         q.poll();
//                         continue;
//                     }
//                     // if (!q.isEmpty() && a[q.peek()] <= a[i]) {
//                     if (!q.isEmpty()) {
//                         val = a[q.peek()];
//                         s.offerFirst(q.poll());
//                         cnt++;
//                         if (cnt == v) {
//                             r[idx] = val;
//                         }
//                     }
//                 }
//                 idx++;
//                 while (!s.isEmpty())
//                     if (s.peekFirst() <= i-k) s.pollFirst();
//                     else
//                         q.offer(s.pollFirst());
//             }
//             return r;
//         }

//         public int maximizeSum(int[] a, int k) {
//             int n = a.length, max = Arrays.stream(a).max().getAsInt();
//             return max * k + k * (k-1) / 2;
//         }

//         public int [] findThePrefixCommonArray(int [] a, int [] b) {
//             int l = 0, r = 0, ll = 0, rr = 0;
//             int n = a.length;
//             int [] ans = new int [n];
//             for (int i = 0; i < n; i++) {
//                 if (a[i] < 32) l |= (1 << a[i]); else ll |= (1 << (a[i] - 32));
//                 if (b[i] < 32) r |= (1 << b[i]); else rr |= (1 << (b[i] - 32));
//                 int v = Integer.bitCount(l & r) + Integer.bitCount(ll & rr);
//                ans[i] = v;
//             }
//             return ans;
//         }

//         public int findMaxFish(int[][] a) {
//             m = a.length; n = a[0].length; this.a = a; 
//             f = new boolean [m][n];
//             for (int i = 0; i < m; i++)
//                 for (int j = 0; j < n; j++)  // 这里是要写连通块，也可以用 BFS 来做
//                     if (a[i][j] > 0) 
//                         max = Math.max(max, bfs(i, j));
//             return max;
//         }
//         int [][] dirs = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
//         int [][] a;
//         boolean [][] f;
//         int m, n, max = 0;
//         int bfs(int u, int v) {
//             int r = 0;
//             Deque<int []> q = new ArrayDeque<>();
//             q.offer(new int [] {u, v});
//             f[u][v] = true;
//             while (!q.isEmpty()) {
//                 int [] cur = q.poll();
//                 int x = cur[0], y = cur[1];
//                 r += a[x][y];
//                 a[x][y] = 0;
//                 for (int [] d : dirs) {
//                     int i = x + d[0], j = y + d[1];
//                     if (i < 0 || i >= m || j < 0 || j >= n || f[i][j] || a[i][j] == 0) continue;
//                     f[i][j] = true;
//                     q.offer(new int [] {i, j});
//                 }
//             }
//             return r;
//         }

//         // 不知道这个题目说的是什么意思，怎么办呢？先试着用万能的【记忆化深搜】搜寻试试看？试着用用【最小值－线段树】，看看？
//         public long countOperationsToEmptyArray(int[] a) {
//             n = a.length; this.a = a; max = Arrays.stream(a).max().getAsInt(); m = 2 * n + 1;
//             // 【最小值线段树】：这里我是要把值全填进去，构建这棵树先？
//             buildTree(0, n-1);
//             f = new Long [m][m];
//             return dfs(0, n-1);
//         }
//         Long [][] f; int [] t; // 线段树
//         int [] a; int m, n, max;
//         long dfs(int i, int j) {
//             if (i == j) return 1;
//             if (f[i][j] != null) return f[i][j];
//            long ans = Long.MAX_VALUE;
//             int min = query(1, 1, m, i+1, j+1); // 查询整个区间的最小值 
//             // if (a[i] == min) return dfs(i+1, j); // 这里 i 就会越界，必须区间查询最小值
//             int curVal = query(1, 1, m, i+1, i+1);
//             if (min == curVal) return f[i][j] = 1 + dfs(i+1, j);
//             update(1, 1, m, j+2, curVal);  // 把这个当前元素贴尾巴上去
//             return f[i][j] = 1 + dfs(i+1, j+1);
//         }
//         int query(int u, int l, int r, int L, int R) { // 查询，区间【L,R】的最小值 
//             if (L <= l && r <= R) return t[u];
//             int m = l + (r - l) / 2;
//             int leftMin = Integer.MAX_VALUE, rightMin = Integer.MAX_VALUE;
//             if (L <= m) leftMin = query(u << 1, l, m, L, R);
//             if (m+1 <= R) rightMin = query(u << 1 | 1, m+1, r, L, R);
//             return Math.min(leftMin, rightMin);
//         }
//         void buildTree(int l, int r) {
//             t = new int [8 * n]; // 这里，我想给足它空间最长，以空间换时间，不用数组左移，而是自动向右增长, 最差情况，数组变2 倍长【变成一个自动右滑的滑动窗口】？
//             for (int i = 0; i < m; i++) // 这个题目，占用的空间还是太多了，可能不适合
//                 update(1, 1, m, i+1, (i < n ? a[i] : Integer.MAX_VALUE)); // 通过每个值更新的方式，构建了这树
//             System.out.println(Arrays.toString(t));
//         }
//         void update(int u, int l, int r, int i, int v) {
//             if (l == r) {
//                 t[u] = v;
//                 return ;
//             }
//             int m = l + (r - l) / 2;
//             if (i <= m) update(u << 1, l, m, i, v);
//             else update(u << 1 | 1, m+1, r, i, v);
//             t[u] = Math.min(t[u << 1], t[u << 1 | 1]); // 更新父节点的最小值 
//         }

//         public int isWinner(int[] a, int[] b) {
//             int n = a.length;
//             if (n == 1) return a[0] > b[0] ? 1 : (a[0] < b[0] ? 2 : 0);
//             int [] l = new int [n], r = new int [n];
//             l[0] = a[0]; r[0] = b[0];
//             l[1] = (a[0] == 10 ? 2 * a[1] : a[1]) + l[0];
//             r[1] = (b[0] == 10 ? 2 * b[1] : b[1]) + r[0];
//             for (int i = 2; i < n; i++) {
//                 int x = (a[i-1] == 10 || a[i-2] == 10 ? a[i] * 2 : a[i]);
//                 int y = (b[i-1] == 10 || b[i-2] == 10 ? b[i] * 2 : b[i]);
//                 l[i] = l[i-1] + x;
//                 r[i] = r[i-1] + y;
//             }             
//             return l[n-1] > r[n-1] ? 1 : (l[n-1] <r[n-1] ? 2 : 0);
//         }

//         public int firstCompleteIndex(int[] b, int[][] a) {
//             int m = a.length, n = a[0].length;
//             Map<Integer, int []> mi = new HashMap<>();
//             for (int i = 0; i < m; i++)
//                 for (int j = 0; j < n; j++)
//                     mi.put(a[i][j], new int [] {i, j});
//             int [] r = new int [m], l = new int [n];
//             for (int i = 0; i < m*n; i++) {
//                 int [] cur = mi.get(b[i]);
//                 r[cur[0]]++;
//                 l[cur[1]]++;
//                 if (r[cur[0]] == n || l[cur[1]] == m) return i;
//             }
//             return -1;
//         }

        // public String smallestBeautifulString(String t, int k) { // 走生成的思路，按照它的要求，去努力生成一个比较大的字符串
        //     int n = t.length(); char [] s = t.toCharArray();
        //     char maxChar = (char)('a' + k - 1);
        //     for (int index = n-1; index >= 0; index--) { // 从后往前遍历 
        //         if (index == maxChar) continue;
        //         char newChar = (char)(s[index] + 1);
        //         while (newChar <= maxChar) { // 从最小，到往大遍历，因为想找最小的
        //             if (index > 0 && s[index-1] == newChar || index - 2 >= 0 && s[index - 2] == newChar) {
        //                 newChar = (char)(newChar + 1);
        //                 continue;
        //             }
        //             s[index] = newChar;
        //             fixSuffix(s, index, maxChar);
        //             return String.valueOf(s);
        //         }
        //     }
        //     return "";
        // }
        // void fixSuffix(char [] s, int idx, char maxChar) {
        //     for (int i = idx+1; i < s.length; i++) {
        //         for (char minValidChar = 'a'; minValidChar <= maxChar; minValidChar = (char)(minValidChar + 1)) {
        //             if (i > 0 && s[i-1] == minValidChar || i >= 2 && s[i-2] == minValidChar) continue;
        //             s[i] = minValidChar;
        //             break;
        //         }
        //     }
        // }

        // public int minimumCost(int[] s, int[] t, int[][] p) { // 自己写的，什么乱七八糟的。。。
        //     int n = (int)1e5 + 1;
        //     int si = s[0], sj = s[1], ti = t[0], tj = t[1];
        //     int [][] f = new int [n][n];
        //     for (int i = 0; i < n; i++) Arrays.fill(f, Integer.MAX_VALUE);
        //     f[si][sj] = 0;
        //     Queue<int []> q = new PriorityQueue<>((x, y) -> x[2] - y[2]);
        //     int min = Math.abs(ti - si) + Math.abs(tj - sj);
        //     q.offer(new int [] {si, sj, min});
        //     Arrays.sort(p, (x, y)-> x[0] != y[0] ? x[0] - y[0] : (x[1] != y[1] ? x[1] - y[1] : x[2] - y[2]));
        //     while (!q.isEmpty()) {
        //         int [] cur = q.poll();
        //         int a = cur[0], b = cur[1], ww = cur[2];
        //         if (ww < min) min = ww;
        //         // min = Math.min(min, Math.abs(a - ti) + Math.abs(b - tj) + ww);
        //         for (int [] e : p) {
        //             int i = e[0], j = e[1], x = e[2], y = e[3], w = e[4];
        //             int d = Math.abs(a - si) + Math.abs(b - sj);
        //             int curVal = ww + d + w + Math.abs(x - ti) + Math.abs(y - tj);
        //             if (curVal < min) {
        //                 min = curVal;
        //                 // q.offer(new int [] {x, y, ww + d + w});
        //             }
        //         }
        //     }
        //     return r;
        // }

        // // 不知道这个P 题目说的是什么意思
        // public int[] minReverseOperations(int n, int p, int[] b, int k) {
        //     int m = b.length;
        //     Set<Integer> s = new HashSet<>(Arrays.stream(b).boxed().collect(Collectors.toList()));
        //     int [] r = new int [n];
        //     Arrays.fill(r, -1);
        //     r[p] = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (s.contains(i) || i == p) continue; // -1 0
        //     }
        // }
        // int getCnt(int idx, int n, int p, Set<Integer> s, int k) { // 这个巅倒片段，不知道说的是什么意思 
        // }

        // public int[] distinctDifferenceArray(int[] a) {
        //     int n = a.length, cnt = 0;
        //     int [] ll = new int [51], rr = new int [51];
        //     int [] l = new int [n], r = new int [n], ans = new int [n];
        //     for (int i = 0; i < n; i++) {
        //         int v = a[i];
        //         if (ll[v] == 0) {
        //             cnt++;
        //             ll[v]++;
        //         }
        //         l[i] = cnt;
        //     }
        //     cnt = 0;
        //     for (int i = n-1; i >= 0; i--) {
        //         int v = a[i];
        //         r[i] = cnt;
        //         if (rr[v] == 0) {
        //             cnt++;
        //             rr[v]++;
        //         } 
        //     }
        //     for (int i = 0; i < n; i++)
        //         ans[i] = l[i] - r[i];
        //     return ans;
        // }

        // Map<Integer, Integer> m = new HashMap<>();
        // Map<Integer, Set<Integer>> cnt = new HashMap<>();
        // public FrequencyTracker() {
        // }
        // public void add(int v) {
        //     m.put(v, m.getOrDefault(v, 0) + 1);
        //     int f = m.get(v);
        //     if (f > 1) { // 原来的减少，现在的增加
        //         cnt.get(f-1).remove(v);
        //         cnt.computeIfAbsent(f, z -> new HashSet<>()).add(v);
        //     } else {
        //         cnt.computeIfAbsent(1, z -> new HashSet<>()).add(v);
        //     }
        // }
        // public void deleteOne(int v) {
        //     if (!m.containsKey(v)) return;
        //     int f = m.get(v);
        //     if (f == 1){
        //         m.remove(v);
        //         cnt.get(1).remove(v);
        //     } else {
        //         m.put(v, f-1);
        //         cnt.get(f).remove(v);
        //         cnt.computeIfAbsent(f-1, z -> new HashSet<>()).add(v);
        //     }
        // }
        // public boolean hasFrequency(int frequency) {
        //     return cnt.containsKey(frequency) && cnt.get(frequency).size() > 0;
        // }

        // public int minIncrements(int n, int[] a) {
        //     this.n = n; this.a = a; 
        //     buildTree();
        //     // 【自底向上】：一遍，更新全局最大值 
        //     f = new int [n+1];
        //     dfs(root);
        //     // 【自顶向下一遍】求结果
        //     int max = f[1];
        //     dfs(root, max);
        //     return ans;
        // }
        // TreeNode root;
        // int n, ans = 0;
        // int [] f, a; // 需要把动规的思路，习惯到树上来
        // void dfs(TreeNode r, int v) {
        //     if (r == null) return ;
        //     if (r.left == null && r.right == null) {
        //         ans += v - f[r.val];
        //         return ;
        //     }
        //     ans += v - f[r.val];
        //     dfs(r.left, f[r.val] == v ? v - a[r.val-1] : f[r.val] - a[r.val-1]);
        //     dfs(r.right, f[r.val] == v ? v - a[r.val-1] : f[r.val] - a[r.val-1]);
        // }        
        // int dfs(TreeNode r) {
        //     if (r == null) return 0;
        //     if (r.left == null && r.right == null) {
        //         f[r.val] = a[r.val-1];
        //         return f[r.val];
        //     }
        //     int ll = dfs(r.left);
        //     int rr = dfs(r.right);
        //     f[r.val] = Math.max(ll, rr) + a[r.val-1];
        //     return f[r.val];
        // }
        // void buildTree() {
        //     root = new TreeNode(1);
        //     Deque<TreeNode> q = new ArrayDeque<>();
        //     q.offer(root);
        //     while (!q.isEmpty()) {
        //         TreeNode r = q.poll();
        //         if (r.val * 2 <= n-1) {
        //             r.left = new TreeNode(r.val * 2);
        //             r.right = new TreeNode(r.val * 2 + 1);
        //             q.offer(r.left);
        //             q.offer(r.right);
        //         } else break;
        //     }
        // }

        // int [] t;
        // void update(int u, int l, int r, int i, int v) {
        //     if (l == r) {
        //         t[u] = v;
        //         return ;
        //     }
        //     int m = (l + r) >> 1;
        //     if (i <= m) update(u << 1, l, m, i, v);
        //     else update(u << 1 | 1, m+1, r, i, v);
        //     t[u] = Math.max(t[u << 1], t[u << 1 | 1]); // 【最大值线段树】
        // }
        // int query(int u, int l, int r, int L, int R) {
        //     if (L <= l && r <= R) return t[u];
        //     int m = (l + r) >> 1, ll = 0, rr = 0;
        //     if (L <= m) ll = query(u << 1, l, m, L, R);
        //     if (m+1 <= R) rr = query(u << 1 | 1, m+1, r, L, R);
        //     return Math.max(ll, rr);
        // }
        // // 感觉好像是线段树，可是怎么求最大相同元素的片段和呢？【最大值线段树】：作用在 f[n] 上 ?
        // // 感觉这里想复杂了，并且浪费了很多时间，最后一个简单题，也没时间写
        // public int[] colorTheArray(int n, int[][] a) {
        //     int m = a.length, max = 0;
        //     int [] r = new int [n], ans = new int [m], f = new int [n];
        //     t = new int [n * 4];
        //     for (int j = 0; j < m; j++) {
        //         int [] cur = a[j];
        //         int i = cur[0], v = cur[1];
        //         if (r[i] == 0 || r[i] == v) {
        //             r[i] = v;
        //             if (i == 0 || v == r[i-1]) {
        //                 f[i] = (i == 0 ? 0 : f[i-1]) + 1; // 包括了当前的元素
        //                 // 向后更新
        //                 if (i < n-1 && r[i+1] == r[i]) {
        //                     int k = i+1;
        //                     while (k < n && r[k] == r[i]) {
        //                         f[k] = f[k-1] + 1;
        //                         update(1, 1, n, k+1, f[k]);
        //                         k++;
        //                     }
        //                 }
        //             } else f[i] = 1;
        //             update(1, 1, n, i+1, f[i]);  // <<<<<<<<<<<<<<<<<<<< 
        //             // 这里可以是断点儿更新，所以必须求左右最大值
        //             int ll = query(1, 1, n, 1, i+1);
        //             int rr = query(1, 1, n, i+2, n);
        //             // max = Math.max(Math.max(ll, max), f[i] > 0 ? f[i]-1 : 0);
        //             max = Math.max(Math.max(ll-1, max), rr-1);
        //         } else { // 这里还有必要的更新工作
        //             r[i] = v;
        //             if (i > 0 && r[i] == r[i-1]) {
        //                 f[i] = f[i-1] + 1;
        //             }
        //             update(1, 1, n, i+1, f[i]);  // <<<<<<<<<<<<<<<<<<<< 
        //             if (i < n-1 && r[i] == r[i+1]) {
        //                 int k = i+1;
        //                 while (k < n && r[k] == r[i]) {
        //                     f[k] = f[k-1] + 1;
        //                     update(1, 1, n, k+1, f[k]);
        //                     k++;
        //                 }
        //             }
        //             if (max == f[i]-1) { // 问题是：最大片段，不一定只出现一次，所以还需要求最大连续片段和
        //                 int maxRight = query(1, 1, n, i+2, n);
        //                 max = Math.max(maxRight-1, max-1);
        //                 // f[i] = max;
        //                 f[i]--;
        //             }
        //             update(1, 1, n, i+1, f[i]);  // <<<<<<<<<<<<<<<<<<<< 
        //             // 这里可以是断点儿更新，所以必须求左右最大值
        //             int ll = query(1, 1, n, 1, i+1);
        //             int rr = query(1, 1, n, i+2, n);
        //             // max = Math.max(Math.max(ll, max), f[i] > 0 ? f[i]-1 : 0);
        //             max = Math.max(Math.max(ll-1, max), rr-1);
        //         }
        //         // ans[j] = f[i] > 0 ? f[i] - 1 : f[i]; // -1
        //         ans[j] = max; // 不一定是连续的，可是先前的
        //     }
        //     return ans;
        // }
        // public int[] colorTheArray(int n, int[][] a) {
        //     int m = a.length, cnt = 0;
        //     int [] r = new int [n], ans = new int [m];
        //     for (int j = 0; j < m; j++) {
        //         int i = a[j][0], v = a[j][1];
        //         int ll = (i == 0) ? 0 : r[i-1];
        //         int rr = (i == n-1) ? 0 : r[i+1];
        //         if (r[i] != 0 && (r[i] == ll)) cnt--;
        //         if (r[i] != 0 && (r[i] == rr)) cnt--;
        //         r[i] = v;
        //         if (ll == r[i]) cnt++;
        //         if (rr == r[i]) cnt++;
        //         ans[j] = cnt;
        //     }
        //     return ans;
        // }

        // public int countSeniors(String[] a) {
        //     int n = a.length, r = 0;
        //     for (String s : a) 
        //         if (Integer.parseInt(s.substring(11, 13)) > 60) r++;
        //     return r;
        // }

        // public int matrixSum(int[][] a) {
        //     int m = a.length, n = a[0].length, r = 0;
        //     Queue<List<Integer>> q = new PriorityQueue<>((x, y) -> y.get(y.size()-1) - x.get(x.size()-1));
        //     for (int [] v : a) {
        //         List<Integer> l = Arrays.stream(v).boxed().collect(Collectors.toList());
        //         Collections.sort(l);
        //         q.offer(l);
        //     }
        //     for (int i = n-1; i >= 0; i--) {
        //         List<Integer> l = q.poll();
        //         r += l.get(l.size()-1);
        //         for (List<Integer> li : q) {
        //             li.remove(l.size()-1);
        //             q.offer(li);
        //         }
        //         q.offer(l);
        //     }
        //     return r;
        // }
        // public int matrixSum(int[][] a) {
        //     int m = a.length, n = a[0].length, r = 0;
        //     List<List<Integer>> ll = new ArrayList<>();
        //     for (int [] v : a) 
        //         ll.add(Arrays.stream(v).boxed().collect(Collectors.toList()));
        //     for (List<Integer>  l : ll)
        //         Collections.sort(l);
        //     List<Integer> li = new ArrayList<>();
        //     for (int i = n-1; i >= 0; i--) {
        //        li.clear();
        //         for (List<Integer> l : ll) 
        //             li.add(l.get(i));
        //         r += Collections.max(li);
        //     }
        //     return r;
        // }

        // // 因为 N 的数量级比较大，【记忆化深搜】一定会超时，这个时候只能写动规
        // public long maximumOr(int[] a, int k) {
        //     int n = a.length;
        //     // int [][] f = new int [n][1 << k];// 这里的问题是：每个数可以重复用，并且数值是在变化的
        //     long [] f = new long [1 << k];
        //     for (int v : a) {
        //     // for (int i = 0; i < n; i++) { // 遍历每个下标
        //         v *= 2; // 一次操作
        //         for (int j = (1 << k)-1; j > 0; j--) { // 遍历每个可能的状态
        //             System.out.println("j: " + j);
        //             if ((j & v) == v && (j ^ v) < (1 << k))
        //                 f[j] = Math.max(f[j], f[j ^ v] | (long)v);
        //         }
        //     }
        //     return Arrays.stream(f).max().getAsLong();
        // }
        // // 【记忆化深搜】：先搜一遍 这里的问题是：每个数可以重复用，并且数值是在变化的
        // public long maximumOr(int[] a, int k) {
        //     n = a.length; this.a = a; 
        //     f = new Integer [k+1];
        //     return dfs(k);
        // }
        // Integer [] f; // 仍然跟数组取值相关，状态不对
        // int [] a;
        // int n;
        // int dfs(int i) {
        //     if (i >= 0) return 
        // }

//         //  最小值子数组和的变形题。只是这个不再只是子数组，而是子序列
//         static final int mod = (int)1e9 + 7;
//         public int sumOfPower(int[] a) {
//             int n = a.length;
//             int [] l = new int [n], r = new int [n];// min
//             Arrays.fill(l, -1); Arrays.fill(r, n);
//             Deque<Integer> s = new ArrayDeque<>();
//             // 【从左往右遍历】：维护单调递增栈
//             for (int i = 0; i < n; i++) {
//                 while (!s.isEmpty() && a[s.peekFirst()] >= a[i]) s.pollFirst();
//                 if (!s.isEmpty()) l[i] = s.peekFirst();
//                 s.offerFirst(i);
//             }
//             s.clear();
//             // 【从右往左遍历】：单调递增
//             for (int i = n-1; i >= 0; i--) {
//                 while (!s.isEmpty() && a[s.peekFirst()] > a[i]) s.pollFirst();
//                 if (!s.isEmpty()) r[i] = s.peekFirst();
//                 s.offerFirst(i);
//             }
// // 我想要用同样的方法，处理一遍 max 值 
//             int [] ll = new int [n], rr = new int [n];// max: 以当前元素为最右且最大，左片段最远延伸
//             Arrays.fill(ll, -1); Arrays.fill(rr, n);
//             // 【从左往右遍历】：维护单调递增栈
//             for (int i = 0; i < n; i++) {
//                 while (!s.isEmpty() && a[s.peekFirst()] <= a[i]) s.pollFirst();
//                 if (!s.isEmpty()) ll[i] = s.peekFirst();
//                 s.offerFirst(i);
//             }
//             s.clear();
//             // 【从右往左遍历】：单调递增，以当前元素为最左且最大，向右延伸的最远下标
//             for (int i = n-1; i >= 0; i--) {
//                 while (!s.isEmpty() && a[s.peekFirst()] < a[i]) s.pollFirst();
//                 if (!s.isEmpty()) r[i] = s.peekFirst();
//                 s.offerFirst(i);
//             }
//             System.out.println(Arrays.toString(l));
//             System.out.println(Arrays.toString(r));
//             System.out.println(Arrays.toString(ll));
//             System.out.println(Arrays.toString(rr));
//             // 接下来需要把最小最大两个合并起来，并考虑所有子序列？的个数, 这里感觉还有点儿没想透，脑袋有点儿酱。。
//             long ans = 0;
//             for (int w = 0; w < n; w++) {
//                 int i = l[w], j = r[w], x = ll[w], y = rr[w];
//             }
//             return (int)ans;
//         }

        // 这里永远是先操作最大的数，再补其它可能的位, 每个数字要用一个 19 位的 mask
        public long maximumOr(int[] a, int k) {
            // long r = 0;
            // for (int v : a) r |= v;
            // System.out.println("\n Integer.toBinaryString(v): " + Integer.toBinaryString(v));
            li = Arrays.stream(a).boxed().collect(Collectors.toList());
            Collections.sort(li);
            // long max = Arrays.stream(a).asLongStream().max().getAsLong();
            // 【回归】：用下个回归的方法，在当前数 r的基础上，最多 k 次，能够取得的最大值 . 记装链表后【记忆化深搜】
            // f = new Long [n][k+1];
            return dfs(0, n-1, k);
            // long max = l.get(l.size()-1);
            // l.remove(l.size()-1);
            // while (k > 0) {
            //     while (k > 0 && max * 2l <= Long.MAX_VALUE) {
            //         k--;
            //         max *= 2l;
            //     }
            //     r |= max;
            //     System.out.println("r: " + r);
            // }
            // int cnt = Integer.bitCount(r);
            // if (cnt + k) >
        }
        // Long [][] f;
        Map<String, Long> m = new HashMap<>();
        List<Integer> li;
        int n;
        long dfs(int i, int j, int k) { // i r  j idx k: times 从右往左遍历每个数
            if (j < 0) return 0; // 遍历完了
            String key = i + "-" + j + "-" + k;
            if (m.containsKey(key)) return m.get(key);
            int cnt = 0;
            long r = 0, v = (long)li.get(j);
            r = Math.max(r, v | dfs(i | v, j-1, k-cnt)); // 当前的数，不能不要，至少用上 cnt ＝ 0
            while (v * 2l <= Long.MAX_VALUE) {
                ++cnt;
                r = Math.max(r, v | dfs(i | v × 2l, j-1, k-cnt));
            }
            m.put(key, r);
            return r;
        }
    }             
    public static void main (String[] args) { 
        Solution s = new Solution ();

        int [] a = new int [] {2,1,4};
        System.out.println(Arrays.toString(a));

        int r = s.sumOfPower(a);
        System.out.println("r: " + r);
    }
}
// 【爱表哥，爱生活！！！活宝妹就是一定要嫁给亲爱的表哥！！！】
// ListNode head = new ListNode(a[0]); 
// head.buildList(head, a);
// head.printList(head);
// TreeNode rr = new TreeNode(a[0]);
// rr.buildTree(rr, a);
// rr.levelPrintTree(rr);
