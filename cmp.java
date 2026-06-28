import com.TreeNode;
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import java.util.HashSet;
import java.util.Set;
import java.math.BigInteger;
import static java.util.stream.Collectors.toMap;
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
public class cmp {
    // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
    public static class Solution { 
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public String[] createGrid(int m, int n) {
        //     char [][] f = new char [m][n];
        //     for (int i = 0; i < m; i++)
        //         Arrays.fill(f[i], '#');
        //     f[0][0] = '.';
        //     for (int i = 1; i < m; i++)
        //         f[i][0] = '.';
        //     for (int i = 1; i < n; i++) 
        //         f[m-1][i] = '.';
        //     String [] r = new String [m];
        //     for (int i = 0; i < m; i++)
        //         r[i] = String.valueOf(f[i]);
        //     return r;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // TLE TLE TLE 959/999 passed...
        // // 【差分数组】：可以简单实现（区间更新）；不再用 vis[true/false], 用计数 counter 差分数组
        // // 亲爱的表哥的活宝妹，亲爱的表哥的活宝妹、笨宝妹，晚点儿再写这个破烂题目。。。
        // public int minLights(int[] a) {
        //     int n = a.length;
        //     boolean [] g = new boolean [n];
        //     for (int i = 0; i < n; i++) {
        //         if (a[i] == 0) continue;
        //         int l = Math.max(0, i - a[i]), r = Math.min(n-1, i + a[i]);
        //         for (int j = l; j <= r; j++)
        //             if (!g[j]) g[j] = true;
        //     }
        //     int [] f = new int [n];
        //     for (int i = 0; i < n; i++) {
        //         System.out.println("\n i: " + i);
        //         if (g[i]) {
        //             f[i] = (i == 0 ? 0 : f[i-1]);
        //             continue;
        //         }
        //         if (i == 0)
        //             f[i] = (n == 1 ? 1 : (g[i+1] ? 1 : 0));
        //         else if (i > 0 && g[i-1]) {
        //             if (i < n-1 && g[i+1])
        //                 f[i] = f[i-1] + 1;
        //             else
        //                 f[i] = f[i-1] + (i == n-1 ? 1 : 0);
        //         } else if (i > 0 && !g[i-1]) {
        //             f[i] = f[i-1] + 1;
        //             g[i] = true;
        //             if (i < n-1) 
        //                 g[i+1] = true;
        //         }
        //         System.out.println(Arrays.toString(g));
        //         System.out.println(Arrays.toString(f));
        //     }
        //     return f[n-1];
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public class Node {
        //     long l, r, f;
        //     List<Node> n;
        //     public Node(int v) {
        //         this.f = (long)v;
        //         this.l = this.r = 0;
        //         this.n = new ArrayList<Node>();
        //     }
        // }
        // public long finishTime(int n, int[][] egs, int[] a) {
        //     this.n = n; this.a = a; 
        //     g = new ArrayList [n];
        //     Arrays.setAll(g, z -> new ArrayList<Integer>());
        //     for (int [] e : egs) {
        //         int u = e[0], v = e[1];
        //         g[u].add(v);
        //     }
        //     Node r = new Node(a[0]);
        //     dfs(0, r);
        //     return r.f;
        // }
        // List<Integer> [] g;
        // int n; int [] a;
        // void dfs(int u, Node r) {
        //     if (g[u].size() == 0) { // 【叶子节点】
        //         r.l = r.r = r.f;
        //         return ;
        //     }
        //     Queue<Long> min = new PriorityQueue<>((x, y) -> x.compareTo(y));
        //     Queue<Long> max = new PriorityQueue<>((x, y) -> -1 * x.compareTo(y));
        //     for (int v : g[u]) {
        //         Node c = new Node(a[v]);
        //         r.n.add(c);
        //         dfs(v, c);
        //         min.offer(c.f);
        //         max.offer(c.f);
        //     }
        //     r.l = min.peek(); r.r = max.peek();
        //     long duration = r.r - r.l + a[u];
        //     r.f = r.r + duration;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【数位 DP 动规：左右边界串】，没有（非毒串）；按数位遍历，数合法数的个数；当左右边界长度 m n 不同（m<n），需要数所有 o >= m && o <= n 这些长度的、合法数的个数
        // public long goodIntegers(long l, long r, int k) {
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int maxDistance(String S) {
        //     int n = S.length(); char [] s = S.toCharArray();
        //     Map<Character, Integer> m = new HashMap<>();
        //     for (char c : s) 
        //         m.put(c, m.getOrDefault(c, 0) + 1);
        //     int l = Math.abs(m.getOrDefault('U', 0) - m.getOrDefault('D', 0)), r = Math.abs(m.getOrDefault('L', 0) - m.getOrDefault('R', 0));
        //     int ll = Math.max(l, r) + m.getOrDefault('_', 0);
        //     return ll + Math.min(l, r);
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int countValidSubarrays(int[] a, int x) {
        //     int n = a.length;
        //     long [] f = new long [n+1];
        //     for (int i = 0; i < n; i++)
        //         f[i+1] = f[i] + (long)a[i];
        //     int r = 0;
        //     // 遍历：【子数组、左端点】
        //     for (int i = 0; i < n; i++) 
        //         for (int j = i; j < n; j++) {
        //             if (isValid(f[j+1] - f[i], x))
        //                 r++;
        //         }
        //     return r;
        // }
        // boolean isValid(long v, int x) {
        //     String S = String.valueOf(v); char [] s = S.toCharArray();
        //     return (s[0] == s[s.length-1] && s[0] - '0' == x);
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // TLE TLE TLE: 992/1001 passed... 不知道哪里还能优化，暂时不写这个破烂题目了
        // public int shortestPath(int n, int[][] egs, String S, int k) {
        //     this.n = n; this.k = k; s = S.toCharArray();
        //     g = new ArrayList[n];
        //     Arrays.setAll(g, z -> new ArrayList<int []>());
        //     for (int [] e : egs) {
        //         int u = e[0], v = e[1], w = e[2];
        //         g[u].add(new int [] {v, w});
        //     }
        //     // 【DFS 一遍】：断开（连续第 k+1 个字符）的无效边;
        //     // 【TODO：】当（有向图：有还）时，会无限循环，所以需要添加 vis[]boolean 标记是否已经遍历过了
        //     vis = new boolean [n];
        //     dfs(0, 0, s[0]-'a');
        //     d = new int [n];
        //     Arrays.fill(d, Integer.MAX_VALUE);
        //     int min = dij(0, n-1);
        //     return (min == Integer.MAX_VALUE ? -1 : min);
        // }
        // List<int []> [] g;
        // int n, k, min; char [] s;
        // int [] d; boolean [] vis;
        // void dfs(int uu, int cnt, int c) {
        //     System.out.println("uu: " + uu + " " + "cnt: " + cnt + " " + "c: " + c);
        //     if (vis[uu]) return ;
        //     vis[uu] = true;
        //     if (g[uu].size() == 0) return;
        //     for (int i = g[uu].size()-1; i >= 0; i--) {
        //         System.out.println("i: " + i);
        //         int [] nt = g[uu].get(i);
        //         int v = nt[0], ci = s[v]-'a';
        //         if (cnt == k && ci == c) {
        //             g[uu].remove(i);
        //             if (i == 0) continue ;
        //             if (i < g[uu].size()-1)
        //                 i++;
        //             continue;
        //         }
        //         dfs(v, (ci == c ? cnt + 1 : 1), ci);
        //     }
        // }
        // int dij(int uu, int vv) {
        //     d[uu] = 0;
        //     Queue<int []> q = new PriorityQueue<>((x, y) -> (x[0] != y[0] ? x[0] - y[0] : (x[1] != y[1] ? x[1] - y[1] : x[2] - y[2])));
        //     //        totalWeight,cnt,uu, charC 
        //     q.offer(new int [] {0, 1, 0, s[uu]-'a'});
        //     while (!q.isEmpty()) {
        //         int [] r = q.poll();
        //         int w = r[0], cnt = r[1], u = r[2], c = r[3];
        //         if (u == vv) return w;
        //         for (int [] next : g[u]) {
        //             int v = next[0], wi = next[1], ci = s[v]-'a';
        //             if (cnt == k && ci == c) continue;
        //             if (w + wi <= d[v]) {
        //                 d[v] = w + wi;
        //                 q.offer(new int [] {d[v], (ci == c ? cnt + 1 : 1), v, ci});
        //             }
        //         }
        //     }
        //     return -1;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public long maxSum(int[] a, int k, int mul) {
        //     int n = a.length;
        //     Arrays.sort(a);
        //     long f = 0;
        //     for (int i = n-1; i >= 0 && k > 0; i--, k--, mul--) {
        //         if (mul >= 1)
        //             f += (long)mul * a[i];
        //         else f += (long)a[i];
        //     }
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 这个破烂题目出得真恶心人，亲爱的表哥的活宝妹，亲爱的表哥的活宝妹、笨宝妹，晚点儿再写这个破烂题目。。。
        // public class Range implements Comparable<Range> {
        //     int l, r;
        //     public Range(int [] a) {
        //         l = a[0];
        //         r = a[1];
        //     }
        //     public void print() {
        //         System.out.println("[" + this.l + ", " + this.r + "]");
        //     }
        //     @Override public int compareTo(Range other) {
        //         return (this.l != other.l ? this.l - other.l : this.r - other.r);
        //     }
        // }
        // public class RangeMgr {
        //     TreeSet<Range> s;
        //     public RangeMgr() {
        //         s = new TreeSet<Range>();
        //     }
        //     public void mergeRange(int [] a) {
        //         System.out.println("\n Insert:" + Arrays.toString(a));
        //         Range cur = new Range(a);
        //         Range bef = s.floor(cur), aft = s.ceiling(cur);
        //         if (bef != null && bef.r + 1 >= cur.l) {
        //             cur.l = bef.l;
        //             cur.r = Math.max(bef.r, cur.r);
        //             s.remove(bef);
        //         }
        //         if (aft != null && cur.r + 1 >= aft.l) {
        //             cur.r = Math.max(cur.r, aft.r);
        //             s.remove(aft);
        //         }
        //         s.add(cur);
        //         for (Range v : s) 
        //             v.print();
        //     }
        //     public List<List<Integer>> removeRange(int [] a) {
        //         System.out.println("\n removeRange(): " + Arrays.toString(a));
        //         Range cur = new Range(a);
        //         Range bef = s.floor(cur), aft = s.ceiling(cur);
        //         if (bef != null && bef.r > cur.l - 1) {
        //             int befR = bef.r;
        //             bef.r = cur.l - 1;
        //             if (cur.r < befR)
        //                 mergeRange(new int [] {cur.r + 1, befR});
        //         }
        //         while (aft != null && cur.r > aft.l - 1) { // while ? 多个单数？
        //             aft.print(); // <<<<<<<<<<<<<<<<<<<<
        //             if (cur.r >= aft.r) {
        //                 s.remove(aft);
        //                 aft = s.ceiling(cur);
        //             } else { // (aft != null && cur.r < aft.r)
        //                 if (cur.r > aft.l - 1) {
        //                     aft.l = cur.r + 1;
        //                     break;
        //                 }
        //             }
        //         }
        //         // if (aft != null && cur.r < aft.r) {
        //         // }
        //         List<List<Integer>> f = new ArrayList<>();
        //         for (Range v : s) 
        //             f.add(List.of(v.l, v.r));
        //         return f;
        //     }
        // }
        // public List<List<Integer>> filterOccupiedIntervals(int[][] a, int l, int r) {
        //     int n = a.length;
        //     Arrays.sort(a, (x, y)->(x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]));
        //     RangeMgr f = new RangeMgr();
        //     for (int [] v : a) 
        //         f.mergeRange(v);
        //     return f.removeRange(new int [] {l, r});
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 717/718 passed
        // // 【TODO：感觉，还需要一个【整合数组 f 与 g: 遍历两数组的交叉整合点 i] 来求最大值的过程
        // public long maxSubarraySum(int[] a, int k) {
        //     int n = a.length, min = Arrays.stream(a).min().getAsInt(), max = Arrays.stream(a).max().getAsInt();
        //     // 只有【非负数】
        //     if (min >= 0) {
        //         long f = 0;
        //         for (int v : a) f += (long)v;
        //         return f * (long)k;
        //     }
        //     // 只有【负数】
        //     if (max < 0) return (long)Math.ceil(max / k);
        //     // 【有负数，有正数】
        //     long [] f = new long [n+1], g = new long [n+1];
        //     for (int i = 0; i < n; i++) {
        //         f[i+1] = f[i] + (long)a[i];
        //         if (a[i] > 0)
        //             a[i] = (int)Math.floor(a[i] / k);
        //         else if (a[i] < 0)
        //             a[i] = (int)Math.ceil(a[i] / k);
        //         g[i+1] = g[i] + (long)a[i];
        //     }
        //     System.out.println(Arrays.toString(f));
        //     System.out.println(Arrays.toString(a));
        //     System.out.println(Arrays.toString(g));
        //     long r = getMaxSubSum(f) * (long)k;
        //     System.out.println("r 1: " + r);
        //     r = Math.max(r, getMaxSubSum(g));
        //     System.out.println("r 2: " + r);
        //     // 【TODO：】这里不是这么求（子数组片段晨大和）的，得【线段树】动态更新 g[] 数组区间值。。。
        //     for (int i = 1; i <= n; i++)
        //         r = Math.max(r, f[i] + (g[n] - g[i]));
        //     return r;
        // }
        // long getMaxSubSum(long [] a) {
        //     long f = Long.MIN_VALUE;
        //     TreeMap<Long, Integer> m = new TreeMap<>();
        //     for (int i = 1; i < a.length; i++) {
        //         if (i == 1) {
        //             m.put(a[i], 0);
        //             f = Math.max(f, a[i]);
        //             continue;
        //         }
        //         if (a[i] > f)
        //             f = a[i];
        //         if (a[i] - m.firstKey() > f) 
        //             f = a[i] - m.firstKey();
        //         m.put(a[i], i);
        //     }
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 633/641 passed faild 掉的测试案例，节点无限多，真烦人。。。它们的贱鸡、贱畜牲们，真贱！！！
        // public long [] minTimeMaxPower(int n, int[][] egs, int po, int[] a, int uu, int vv) {
        //     g = new ArrayList [n]; Arrays.setAll(g, z -> new ArrayList<int []>());
        //     this.n = n; this.a = a; this.uu = uu; this.vv = vv; this.po = po; 
        //     for (int [] e : egs) {
        //         int u = e[0], v = e[1], t = e[2];
        //         g[u].add(new int [] {v, t});
        //     }
        //     minT = Long.MAX_VALUE; maxP = Long.MIN_VALUE;
        //     f = new long [n]; Arrays.fill(f, Long.MAX_VALUE / 2);
        //     // 【最短时间、最小能量消耗】等，使用Dij 算法；但不能使用简单标记[0,n-1] 的vis[] 数组，简单数组状态可能会有交叉。。。
        //     // vis = new boolean [n];
        //     s = new TreeMap [n];
        //     Arrays.setAll(s, z -> new TreeMap<Long, Long>());
        //     dij();
        //     System.out.println("minT: " + minT + " " + "maxP: " + maxP);
        //     return (minT == Long.MAX_VALUE ? new long [] {-1, -1} : new long [] {minT, maxP});
        // }
        // List<int []> [] g;
        // int n, uu, vv, po; int [] a;
        // // boolean [] vis;
        // TreeMap<Long, Long> [] s;
        // long [] f; // d: time
        // long minT, maxP;
        // void dij() {
        //     f[uu] = 0;
        //     Queue<long []> q = new PriorityQueue<long []>((x, y) -> (x[0] != y[0] ? Long.compare(x[0], y[0]) : Long.compare(y[1], x[1])));
        //     //           timeSpent, powerLeft
        //     q.offer(new long [] {0, po, uu});
        //     while (!q.isEmpty()) {
        //         long [] cur = q.poll();
        //         long t = cur[0], p = cur[1]; int u = (int)cur[2];
        //         s[u].put(t, p);
        //         if (u == vv) {
        //             if (t < minT) {
        //                 minT = Math.min(minT, t);
        //                 maxP = p;
        //             } else if (t == minT) 
        //                 maxP = Math.max(maxP, p);
        //             return ;
        //         }
        //         if (p < a[u]) continue; // 下一个路径方案等
        //         for (int [] nt : g[u]) {
        //             // || s[u].contains(new long []{t, p});
        //             int v = nt[0]; long ti = nt[1];
        //             if (t + ti < f[v]) {
        //                 f[v] = t + ti;
        //                 q.offer(new long [] {f[v], p - a[u], v});
        //             } else if (t + ti == f[v] && s[v].containsKey(f[v]) && p - a[u] > s[v].get(f[v])) {
        //                 s[v].put(f[v], p - a[u]);
        //                 q.offer(new long [] {f[v], p - a[u], v});
        //             }
        //         }
        //     }
        // }
    }    // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！ 
    public static void main (String[] args) { 
        Solution s = new Solution (); 
        // int []  a = new int []  {-8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10, -8, 5, -8, 10};// 5

        long [] r = s.minTimeMaxPower(...);
        System.out.println(Arrays.toString(r));
    }
}
// ListNode head = new ListNode(a0]);   
// head.buildList(head, a);
// head.printList(head);
// TreeNode rr = new TreeNode(a[0]);
// rr.buildTree(rr, a);
// rr.levelPrintTree(rr);
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
