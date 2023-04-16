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
        // 这是最气人的一次比较，每个题目的时间被卡得极严，连最简单的题目也不给过。。。
        // public int diagonalPrime(int[][] a) {
        //     int n = a.length;
        //     List<int []> l = new ArrayList<>();
        //     for (int i = 0; i < n; i++)
        //         for (int j = 0; j < n; j++)
        //             l.add(new int [] {a[i][j], i, j});
        //     Collections.sort(l, (x, y)-> x[0] != y[0] ? y[0] - x[0] : x[1] - y[1]); // 降序排列
        //     for (int [] v : l)
        //         if ((v[1] == v[2] || v[2] == n-1 - v[1]) && isPrime(v[0])) return v[0];
        //     return 0;
        // }
        // public static boolean isPrime(int n) {
        //     if (n < 3) {
        //         if (n == 2) 
        //             return true;
        //         else
        //             return false;
        //     }
        //     for (int i = 2; i < n; i++) 
        //         if (n % i == 0) 
        //             return false;
        //     return true;
        // }

        // public long [] distance(int[] a) { // TLE TLE TLE: 就是想不到平时这类没要求的题目怎么会超时的？ 1066/1068 不知道是哪里错掉了？ 3 个不过【这个题我已经不想写它了。。。】
        //     int n = a.length;
        //     Map<Integer, List<Integer>> m = new HashMap<>();
        //     for (int i = 0; i < n; i++) 
        //         m.computeIfAbsent(a[i], z -> new ArrayList<>()).add(i);
        //     long [] r = new long [n];
        //     for (Map.Entry<Integer, List<Integer>> en : m.entrySet()) {
        //         List<Integer> l = en.getValue();
        //         if (l.size() == 1) {
        //             r[l.get(0)] = 0;
        //             continue;
        //         }
        //         long [] s = new long [l.size()]; // 它说这里用 prefix 算。妈的。。。
        //         s[0] = l.get(0);
        //         for (int i = 1; i < l.size(); i++) 
        //             s[i] = s[i-1] + l.get(i);
        //         for (int i = 0; i < l.size(); i++) 
        //             r[l.get(i)] = (long)l.get(i) * (i+1) - s[i] + (s[l.size()-1] - (i == 0 ? 0 : s[i-1])) - l.get(i) * (l.size()-i);
        //     }
        //     return r;
        // }

        // // The recurrence relation is
        // //     fn(i, x) = min[ fn(i+1, x), max( abs(nums[i]-nums[i+1]), fn(i+2, p-1) )] ？没看懂，它在说什么？？？
        // // and fn(0,p) gives the desired answer.
        // public int minimizeMax(int[] a, int p) { // 这个就是看着题目，认不出来，没能认出来它是在考查什么。。。
        //     int n = a.length;
        //     Arrays.sort(a);// 先排序是对的 // sort to get minimum differences
        //     int l = -1, h = 1000000007; // binary search logic: 直接二分查找这个最小可能存在的最大差值 
        //     while (l < h - 1) {
        //         int m = l + (h-l) / 2;
        //         int cnt = 0; // to count total possible pairs if mid is the max value
        //         for (int i = 1; i < n; i++) 
        //             if (a[i] - a[i-1] <= m) { // counting only if difference is <= mid
        //                 i++;
        //                 cnt++;
        //             }
        //         if (cnt >= p) h = m; // store the last possible value in hi
        //         else l = m;
        //     }
        //     return h;
        // }

        // // 我记忆化搜索的方向，与它动态规划的方向是反的。可是两个本来就是反着的。。。
        // public int minimumVisitedCells(int[][] a) { // TLE TLE TLE 已经是记忆化搜索了呀？！！！怎么会超时的呢？
        //     m = a.length;
        //     n = a[0].length;
        //     f = new Integer [m][n];  
        //     for (int i = 0; i < m; i++) // 这里有个可以 stream 一行搞定的写法，忘记了
        //         Arrays.fill(f[i], Integer.MAX_VALUE / 2);
        //     int r = dfs(0, 0, a);
        //     System.out.println("f.length: " + f.length);
        //     for (int z = 0; z < f.length; ++z) 
        //         System.out.println(Arrays.toString(f[z]));
        //     return r == Integer.MAX_VALUE / 2 ? -1 : r;
        // }
        // Integer [][] f;
        // int m, n;
        // int dfs(int ii, int jj, int [][] a) { // 记忆化揵从当前坐标到终点的最小步数
        //     // if (ii >= m || jj >= n) return Integer.MAX_VALUE / 2; // 主要是免得溢出
        //     if (ii == m-1 && jj == n-1) return f[ii][jj] = 1;
        //     if (f[ii][jj] < Integer.MAX_VALUE / 2) return f[ii][jj];
        //     int r = Integer.MAX_VALUE / 2;
        //     // for (int j = Math.min(a[ii][jj] + jj, n-1); j > jj; j--) {
        //     int max = Math.min(a[ii][jj] + jj, n-1);
        //     for (int j = max; j > jj; j--) {
        //         int cur = 1 + dfs(ii, j, a);
        //         r = Math.min(r, cur);
        //     }
        //     max = Math.min(a[ii][jj] + ii, m-1);
        //     for (int i = max; i > ii; i--) {
        //         int cur = 1 + dfs(i, jj, a);
        //         r = Math.min(r, cur);
        //     }
        //     return f[ii][jj] = r;
        // }
        // // BFS: 广度优先搜索: 这一种解法弄通了。。。。。【任何时候，活宝妹就是一定要嫁给亲爱的表哥！！！】
        //     public int minimumVisitedCells(int[][] a) { // 这个解法：勉强可以过。。。
        //         int m = a.length, n = a[0].length, cnt = 1;
        //         if (m == 1 && n == 1) return 1;
        //         Deque<int []> q = new ArrayDeque<>();
        //         boolean [][] vis = new boolean [m][n];
        //         q.offerFirst(new int [] {0, 0});
        //         vis[0][0] = true;
        //         while (!q.isEmpty()) {
        //             for (int size = q.size()-1; size >= 0; size--) {
        //                 int [] r = q.pollLast();
        //                 int ii = r[0], jj = r[1];
        //                 // if (ii == m-1 && jj == n-1) return cnt;     // 先行检查结果，每个测试用例省一点儿。。。。。
        //                 // if (a[ii][jj] == 0 || vis[ii][jj]) continue;// 先行判断，可以省空间，妈呀。。。真过分
        //                 // vis[ii][jj] = true;
        //                 // 向右扫描扩展
        //                 for (int j = jj+1; j <= a[ii][jj] + jj && j < n; j++) {
        //                     if (ii == m-1 && j == n-1) return cnt+1;
        //                     if (a[ii][j] != 0 && !vis[ii][j]) {
        //                         vis[ii][j] = true;
        //                         q.offerFirst(new int [] {ii, j});
        //                     }
        //                 }
        //                 // 向下扫描扩展
        //                 for (int i = ii+1; i <= a[ii][jj] + ii && i < m; i++) {
        //                     if (i == m-1 && jj == n-1) return cnt+1;
        //                     if (a[i][jj] != 0 && !vis[i][jj]) {
        //                         vis[i][jj] = true;
        //                         q.offerFirst(new int [] {i, jj});
        //                     }
        //                 }
        //             }
        //             cnt++;
        //         }
        //         return -1; 
        //     }
        // // 我记忆化搜索的方向，与它动态规划的方向是反的。可是两个本来就是反着的。。。
        // public int minimumVisitedCells(int[][] a) { // TODO: TLE TLE TLE 动态规划，要跟上面的记忆化搜索的方向是反着遍历的，就是自顶向下，与自底向上的区别. 另外最后 11 个测试样例不过。。。
        //     int m = a.length, n = a[0].length;
        //     int [][] f = new int [m][n];
        //     Arrays.stream(f).forEach(x -> Arrays.fill(x, Integer.MAX_VALUE / 2));  // 流式处理法
        //     f[0][0] = 1; // 初始化：左上角，只遍历了当前一个格
        //     // 开始遍历：从上到下，一行一行；从左到右，一列一列，计算到达 a[i][j] 的最小访问方格数 f[i][j]
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) { // 计算能够到达当前方格 a[i][j] 的最小访问方格数 f[i][j]
        //             Queue<int []> q = new PriorityQueue<>((x, y) -> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]); // 我想不明白，为什么要分开用两个优先队列？
        //             for (int k = 0; k < j; k++) {
        //                 if (a[i][k] + k < j) continue;
        //                 q.offer(new int [] {f[i][k] + 1, k}); // 这里只统计一步跳过来的
        //             }
        //             for (int k = 0; k < i; k++) {
        //                 if (a[k][j] + k < i) continue;
        //                 q.offer(new int [] {f[k][j] + 1, k});
        //             }
        //             if (!q.isEmpty())
        //                 f[i][j] = q.peek()[0];
        //         }
        //     return f[m-1][n-1] >= Integer.MAX_VALUE / 2 ? -1 : f[m-1][n-1];
        // }
        // public int minimumVisitedCells(int[][] a) { // 感觉基本思路跟上面差不多，但是多了优化：保证每行每列的某个下标仅访问一次
        //     int m = a.length, n = a[0].length;
        //     boolean [][] vis = new boolean [m][n];
        //     int [] h = new int [m], v = new int [n]; // 这里有步优化：记录每行每列的最远不曾遍历过的列、行所达的最远不曾遍历的下标记序号
        //     Deque<int []> q = new ArrayDeque<>();
        //     q.offerFirst(new int [] {0, 0});
        //     h[0] = 1; // 初始化
        //     v[0] = 1;
        //     for (int cnt = 1; !q.isEmpty(); cnt++)
        //         for (int size = q.size()-1; size >= 0; size--) {
        //             int [] r = q.pollLast();
        //             int i = r[0], j = r[1];
        //             if (i == m-1 && j == n-1) return cnt;
        //             for (int k = Math.max(h[i], j+1); k <= a[i][j] + j && k < n; k++)// 这里有步优化：它不是每次都从 j+1 开始，而是从不曾遍历过的某个下标开始
        //                 if (!vis[i][k]) {
        //                     vis[i][k] = true;
        //                     q.offerFirst(new int [] {i, k});
        //                 }
        //             while (h[i] < n && vis[i][h[i]]) h[i]++;// 这里就是，平移到不曾遍历过的下标，每个下标只遍历一次
        //             for (int k = Math.max(v[j], i+1); k <= a[i][j] + i && k < m; k++)
        //                 if (!vis[k][j]) {
        //                     vis[k][j] = true;
        //                     q.offerFirst(new int [] {k, j});
        //                 }
        //             while (v[j] < m && vis[v[j]][j]) v[j]++;// 这里就是，平移到不曾遍历过的下标，每个下标只遍历一次
        //         }
        //     return -1;
        // }
        // public int minimumVisitedCells(int[][] a) { // 感觉是条理清楚了，使用了数据结构，但是狠慢，效率低，不如上面的两个数组线性遍历记录不曾遍历的最小下标
        //     int m = a.length, n = a[0].length;
        //     TreeSet<Integer> []  h = new TreeSet[m], v = new TreeSet [n];
        //     for (int i = 0; i < m; i++) {
        //         h[i] = new TreeSet<Integer>();
        //         for (int j = 0; j < n; j++) 
        //             h[i].add(j);
        //     }
        //     for (int j = 0; j < n; j++) {
        //         v[j] = new TreeSet<>();
        //         for (int i = 0; i < m; i++) 
        //             v[j].add(i);
        //     }
        //     Deque<int []> q = new ArrayDeque<>();
        //     q.offerFirst(new int [] {0, 0, 1});
        //     while (!q.isEmpty()) {
        //         int [] cur = q.pollLast();
        //         int i = cur[0], j = cur[1], d = cur[2];
        //         if (i == m-1 && j == n-1) return d;
        //         Integer k = h[i].ceiling(j+1); // 往右扫描: k < n FOR SURE
        //         while (k != null && k <= a[i][j] + j) {
        //             q.offerFirst(new int [] {i, k.intValue(), d+1});
        //             h[i].remove(k);            // 每遍历过一个格，就将相关，行记录与列记录里，遍历过的这个格清除掉，以避免重复遍历 
        //             v[k.intValue()].remove(i); // 每遍历过一个格，就将相关，行记录与列记录里，遍历过的这个格清除掉，以避免重复遍历 
        //             k = h[i].ceiling(j+1);     // 下一个，永远是有序集合里，下一个不曾遍历过的【遍历过的，都被清除掉了。。。】 
        //         }
        //         k = v[j].ceiling(i+1);// 往下扫描: k < m
        //         while (k != null && k <= a[i][j] + i) {
        //             q.offerFirst(new int [] {k.intValue(), j, d+1});
        //             v[j].remove(k);           // 每遍历过一个格，就将相关，行记录与列记录里，遍历过的这个格清除掉，以避免重复遍历 
        //             h[k.intValue()].remove(j);// 每遍历过一个格，就将相关，行记录与列记录里，遍历过的这个格清除掉，以避免重复遍历 
        //             k = v[j].ceiling(i+1);    // 下一个，永远是有序集合里，下一个不曾遍历过的【遍历过的，都被清除掉了。。。】 
        //         }
        //     }
        //     return -1;
        // }

        // public int[] findColumnWidth(int[][] a) {
        //     int m = a.length, n = a[0].length, r [] = new int [n];
        //     for (int i = 0; i < n; i++) {
        //         int cur = 0;
        //         for (int j = 0; j < m; j++) 
        //             cur = Math.max(cur, String.valueOf(a[j][i]).length());
        //         r[i] = cur;
        //     }
        //     return r;
        // }

        // public long[] findPrefixScore(int[] a) {
        //     int n = a.length;
        //     long [] s = new long [n], r = new long [n];
        //     ArrayDeque<Integer> q = new ArrayDeque<>(); // 按照升序排列 
        //     for (int i = 0; i < n; i++) {
        //         if (i == 0) {
        //             s[i] = a[i] * 2; // conversion
        //             r[i] = a[i] * 2; // prefix sum of conversion
        //             q.offerFirst(a[i]);
        //             continue;
        //         }
        //         while (!q.isEmpty() && q.peekFirst() <= a[i]) q.pollFirst();
        //         q.offerFirst(a[i]);
        //         s[i] = a[i] + q.peekLast();
        //         r[i] = r[i-1] + s[i];
        //     }
        //     return r;
        // }

        // public TreeNode replaceValueInTree(TreeNode r) {
        //     dfs(r, 0);
        //     return dfsSecondTime(r, new TreeNode(0), 0);
        // }
        // Map<Integer, Integer> m = new HashMap<>(); // 用来记录每层的和
        // // 这里的问题是，直接在原树上改，可以会存在这样那样同步的冲突问题，最简单的办法就是直接建棵新树。。。
        // TreeNode dfsSecondTime(TreeNode r, TreeNode root, int d) {
        //     int nextLevelCousinSum = m.getOrDefault(d+1, 0) - (r.left != null ? r.left.val : 0) - (r.right != null ? r.right.val : 0);
        //     if (r.left != null) {
        //         root.left = new TreeNode(nextLevelCousinSum);
        //         dfsSecondTime(r.left, root.left, d+1);
        //     }
        //     if (r.right != null) {
        //         root.right = new TreeNode(nextLevelCousinSum);
        //         dfsSecondTime(r.right, root.right, d+1);
        //     }
        //     return root;
        // }
        // void dfs(TreeNode r, int d) {
        //     if (r == null) return ;
        //     m.put(d, m.getOrDefault(d, 0) + r.val);
        //     dfs(r.left, d+1);
        //     dfs(r.right, d+1);
        // }        

    // // class Graph {
    //         // 有向图: 【偶早上昏昏的脑袋呀。。。】
    //     List<int []> [] g;
    //     int n;
    //     public Graph(int n, int[][] edges) {
    //         this.n = n;
    //         g = new ArrayList[n];
    //         Arrays.setAll(g, z -> new ArrayList<int []>());
    //         for (int [] e : edges) 
    //             g[e[0]].add(new int [] {e[1], e[2]});
    //     }
    //     public void addEdge(int[] edge) {
    //         g[edge[0]].add(new int [] {edge[1], edge[2]});
    //     }
    //     public int shortestPath(int idx, int v) {
    //         int [] d = new int [n];
    //         Arrays.fill(d, Integer.MAX_VALUE);
    //         d[idx] = 0;
    //         Queue<int []> q = new PriorityQueue<>((x, y) -> x[0] - y[0]);
    //         q.offer(new int [] {idx, d[idx]});
    //         while (!q.isEmpty()) {
    //             int [] cur = q.poll();
    //             int u = cur[0], x = cur[1];
    //             if (u == v) continue;
    //             // if (u == v) return x;  // 这里并不一定是最佳值 
    //             for (int [] nt : g[u]) // nt: next
    //                 if (x + nt[1] < d[nt[0]]) {
    //                     d[nt[0]] = x + nt[1];
    //                     q.offer(new int [] {nt[0], d[nt[0]]});
    //                 }
    //         }
    //         return d[v] == Integer.MAX_VALUE ? -1 : d[v];
    //     }

        // public int[] rowAndMaximumOnes(int[][] a) {
        //     int m = a.length, n = a[0].length, i = 0;
        //     List<int []> l = new ArrayList<>();
        //     for (int [] v : a) 
        //         l.add(new int [] {i++, Arrays.stream(v).sum()});
        //     Collections.sort(l, (x, y) -> x[1] != y[1] ? y[1] - x[1] : x[0] - y[0]);
        //     return l.get(0);
        // }

        // public int maxDivScore(int[] a, int[] b) {
        //     List<int []> l = new ArrayList<>();
        //     for (int v : b) {
        //         int cur = 0;
        //         for (int x : a) 
        //             if (x % v == 0) cur++;
        //         l.add(new int [] {v, cur});
        //     }
        //     Collections.sort(l, (x, y) -> x[1] != y[1] ? y[1] - x[1] : x[0] - y[0]);
        //     return l.get(0)[0];
        // }

        // public int addMinimum(String t) {
        //     int n = t.length(), r = 0, m = 3 * n;
        //     if (t.chars().distinct().count() == 1) return 2 * n;
        //     char [] s = t.toCharArray();
        //     Set<String> ss = new HashSet<>(List.of("ab", "bc", "ca"));
        //     for (int i = 0; i < n-1; i++) {
        //         String cur = t.substring(i, i+2);
        //         if (i == 0 && cur.equals("ab") || i > 0 && ss.contains(cur)) continue;
        //         if (cur.equals("ac")) r += 1;
        //         else if (cur.equals("aa")) r += 2;
        //         else if (cur.equals("bc")) r += 1;
        //         else if (cur.equals("ba")) r += (i == 0 ? 2 : 1);
        //         else if (cur.equals("bb")) r += (i == 0 ? 3 : 2);
        //         else if (cur.equals("ca")) r += (i == 0 ? 2 : 0);
        //         else if (cur.equals("cb")) r += (i == 0 ? 3 : 1);
        //         else if (cur.equals("cc")) r += (i == 0 ? 4 : 2);
        //     }
        //     return r + (s[n-1] == 'a' ? 2 : (s[n-1] == 'b' ? 1 : 0));
        // }

        public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] t) {
            g = new HashSet [n];
            Arrays.setAll(g, z -> new HashSet<Integer>());
            for (var e : edges) {
                int u = e[0], v = e[1];
                g[u].add(v);
                g[v].add(u);
            }
            List<int []> p = new ArrayList<>();
            cnt = new int [n];
            for (int i = 0; i < n; i++) p.add(new int [] {i, price[i]});
            Collections.sort(l, (x, y) -> y[1] - x[1]);
            // 这里重量减半的时候不知道减哪些？我应该反过来算，先算节点权重，再减重量  也不知道有没有环之类的
            // 我把所有的最短路径标记下来, 然后减最大权重
            Arrays.sort(t, (x, y) -> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
            for (int [] e : t) {
                int u = e[0], v = e[1];
                cnt[u]++;
                cnt[v]++;
                
            }
        }
        Set<Integer> [] g;
        int [] cnt;
        void getLightWeightedPath(int u, int v, int [] p) {
            int [] d = new int [n];
            Arrays.fill(d, Integer.MAX_VALUE);
            Queue<int []> q = new PriorityQueue<>((x, y) -> x[1] - y[1]);
            q.offer(new int [] {u, -1, 0});
            d[u] = 0;
            List<Integer> [] l = new ArrayList[n]; // 我想要把走过的最轻路径穿起来，帮助决定哪些最重的节点减半
            Arrays.setAll(l, z -> new ArrayList<>());
            while (!q.isEmpty()) {
                int [] cur = q.poll();
                int i = cur[0], dist = cur[1];
                if (i == v) {
                    
                }
                for (int j : g[i]) {
                    if (p[j] + dist < d[j]) {
                        d[j] = p[j] + dist;
                        q.offer(new int [] {j, d[j]});
                    }
                }
            }
        }
    }
    public static void main (String[] args) { 
        Solution s = new Solution ();

        String a = "ba";

        int r = s.addMinimum(a);
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

































































































