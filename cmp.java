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

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public boolean isMiddleElementUnique(int[] a) {
        //     int n = a.length, v = a[n/2], f = 0;
        //     for (int vi : a)
        //         if (vi == v) f++;
        //     return f == 1;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【暴力】：O(N*N) TLE TLE TLE ？？？ 999/1002 test cases passed....
        // public int maxValidPairSum(int[] a, int k) {
        //     int n = a.length, f = 0;
        //     for (int i = 0; i+k < n; i++)
        //         for (int j = i+k; j < n; j++)
        //             f = Math.max(f, a[i] + a[j]);
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int minOperations(String S, String T) {
        //     int n = S.length(); char [] s = S.toCharArray(), t = T.toCharArray();
        //     int [] f = new int [n];
        //     for (int i = 0; i < n; i++) {
        //         if (s[i] == t[i]) {
        //             f[i] = (i == 0 ? 0 : f[i-1]);
        //             continue;
        //         } 
        //         if (s[i] == '0') { // t[i] = '1
        //             f[i] = (i == 0 ? 0 : f[i-1]) + 1;
        //             s[i] = '1';
        //             continue;
        //         }
        //         if (s[i] == '1') { // t[i] = '0'
        //             if (n == 1) return -1;
        //             // 优先：改后序：假定【0,i】都匹配完成
        //             if (i < n-1 && s[i+1] == '1') {
        //                 f[i] = (i == 0 ? 0 : f[i-1]) + 1;
        //                 s[i] = s[i+1] = '0';
        //                 continue;
        //             }
        //             // 再：考虑改前位
        //             // 【写错过】：前面不直接改，还需要尝试，试改后面
        //             // if (i == 0 || i > 0 && s[i-1] == '0') return -1;
        //             if (i > 0 && s[i-1] == '1') { // i > 0 && s[i-1] = '1'
        //                 f[i] = (i == 0 ? 0 : f[i-1]) + 1;
        //                 s[i] = s[i-1] = '0';
        //                 // f[i-1] += 1;
        //                 // s[i-1] = '1';
        //                 f[i] += 1;
        //                 continue;
        //             }
        //             if (i < n-1) { // s[i+1] == '0' "10"==>"00"
        //                 f[i] = f[i+1] = (i == 0 ? 0 : f[i-1]) + 1;
        //                 //s[i+1] = '1'; // "11"
        //                 f[i] += 1; // f[i+1] += 1;
        //                 s[i] = '0'; // "00"
        //                 continue;
        //             }
        //             //if (i == n-1) return -1; // 【写错过】：还得尝试改前面的
        //             if (i > 0) {// s[i-1] == '0' "01"==>"00"
        //                 f[i] = (i == 0 ? 0 : f[i-1]) + 2; // "01"==>"11"==>"00" 
        //                 s[i] = '0';
        //                 continue;
        //             }
        //         }
        //     }
        //     return f[n-1];
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【记忆化深搜】：狠像（左右边界串，不涉及毒串）
        // // 【TODO：】细节上存在小错误；亲爱的表哥的活宝妹，亲爱的表哥的活宝妹、笨宝妹，晚点儿再把这个破烂题目完整
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // static final int mod = (int)1e9 + 7;
        // public int interleaveCharacters(String S, String T, String tg) {
        //     m = S.length(); n = T.length(); o = tg.length(); s = S.toCharArray(); t = T.toCharArray(); tt = tg.toCharArray();
        //     qs = new ArrayList[26]; qt = new ArrayList[26];
        //     Arrays.setAll(qs, z -> new ArrayList<Integer>()); Arrays.setAll(qt, z -> new ArrayList<Integer>());
        //     for (int i = 0; i < m; i++) 
        //         qs[s[i]-'a'].add(i);
        //     for (int i = 0; i < n; i++) 
        //         qt[t[i]-'a'].add(i);
        //    f = new HashMap<>();
        //     return dfs(0, 0, 0, 0, 0);
        // }
        // // 【记忆化深搜】：记忆状态定义
        // Map<Integer, Integer> f;
        // char [] s, t, tt;
        // List<Integer> [] qs, qt;
        // int m, n, o;
        // // S T tg IDX:  i  j      k; a/b: S T 0/1; 
        // int dfs(int i, int j, int k, int a, int b) {
        //     if (k == o) return (a == 1 && b == 1 ? 1 : 0);
        //     if (i >= m && a == 0 || j >= n && b == 0) return 0; // 没有从S T 两个串中，都取字符
        //     int key = ((i << 10) | (j << 2) | (a << 1) | b); 
        //     if (f.containsKey(key)) return f.get(key);
        //     int idx = tt[k] - 'a';
        //     int xx = Collections.binarySearch(qs[idx], i), yy = Collections.binarySearch(qt[idx], j);
        //     int x = (xx >= 0 ? xx : -1 * (xx + 1)), y = (yy >= 0 ? yy : -1 * (yy + 1));
        //     System.out.println("i: " + i + " " + "j: " + j + " " + "k: " + k + " " + "x: " + x + " " + "y: " + y);
        //     long r = 0l;
        //     if (qs[idx].size() > 0)
        //         for (int w = x; w < qs[idx].size(); w++) {
        //             r = (r + dfs(qs[idx].get(w)+1, j, k+1, 1, b)) % mod;
        //             System.out.println("i: " + i + " " + "j: " + j + " " + "k: " + k + " " + "r: " + r);
        //         }
        //     if (qt[idx].size() > 0)
        //         for (int w = y; w < qt[idx].size(); w++) {
        //             r = (r + dfs(i, qt[idx].get(w)+1, k+1, a, 1)) % mod;
        //             System.out.println("i: " + i + " " + "j: " + j + " " + "k: " + k + " " + "r: " + r);
        //         }
        //     f.put(key, (int)r);
        //     return (int)r;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int maxDigitRange(int[] a) {
        //     int n = a.length, max = 0;
        //     for (int v : a)
        //         max = Math.max(max, range(v));
        //     int f = 0;
        //     for (int v : a)
        //         if (range(v) == max)
        //             f += v;
        //     return f;
        // }
        // int range(int v) {
        //     char [] s = String.valueOf(v).toCharArray();
        //     int min = 9, max = 0;
        //     for (char c : s) {
        //         int i = c - '0';
        //         min = Math.min(min, i);
        //         max = Math.max(max, i);
        //     }
        //     return max - min;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public boolean canMakeSubsequence(String S, String T) {
        //     int m = S.length(), n = T.length();
        //     char [] s = S.toCharArray(), t = T.toCharArray();
        //     if (m > n) return false;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int divisibleGame(int[] a) {
        //     int n = a.length;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public long getSum(int[] a) {
        //     n = a.length; this.a = a;
        //     // O(N*N)? TLE TLE TLE 有更好的遍历方法，经曲字符串回文 O(N)，被笨宝妹弄忘记了。。。O(N)
        //     boolean [][] f = new boolean [n][n/2], g = new boolean [n][n/2];
        //     // 以【当前下标 i】为（奇数长度对称）子数组 f
        //     for (int i = 0; i < n; i++)
        //         f[i][0] = true;
        //     for (int i = 1; i < n-1; i++) {
        //         // 中心点【左右驿称、半侧长度】： [1,i]
        //         for (int j = 1; i-j >= 0 && i+j < n; j++) {
        //             if (a[i-j] == a[i+j])
        //                 f[i][j] = true;
        //             else
        //                 break;
        //         }
        //     }
        // }
        // int [] a; int n;
        // boolean isPalindrome(int l, int r) {
        //     for (int i = l; i <= l + (r-l)/2; i++) 
        //         if (a[i] != a[r-(i-l)]) return false;
        //     return true;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，觉得，这个应该是【最简单直接的、2 个数组的动规】
        // public int minSwap(int[] a, int[] g) {
        //     int n = a.length;
        //     int [][] f = new int [n][2];
        //     for (int i = 0; i < n; i++)
        //         Arrays.fill(f[i], Integer.MAX_VALUE / 2);
        //     for (int i = 0; i < n; i++) {
        //         if (i == 0) {
        //             f[i][0] = 0;
        //             f[i][1] = 1;
        //             continue;
        //         }
        //         if (a[i] > a[i-1] && g[i] > g[i-1]) {
        //             f[i][0] = f[i-1][0];
        //             f[i][1] = Math.min(f[i][1], f[i-1][1] + 1); // 连续换 2 个，有必要吗？【有必要，否则答案会错】，就是特殊情况下，丢掉全局最优解
        //         }
        //         if (a[i] > g[i-1] && g[i] > a[i-1]) {
        //             f[i][0] = Math.min(f[i][0], f[i-1][1]);
        //             f[i][1] = Math.min(f[i][1], f[i-1][0] + 1);
        //         }
        //     }
        //     return Arrays.stream(f[n-1]).min().getAsInt();
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int secondsBetweenTimes(String S, String T) {
        //     int l = Integer.parseInt(S.substring(0, 2)) * 3600 + Integer.parseInt(S.substring(3, 5)) * 60 + Integer.parseInt(S.substring(6));
        //     int r = Integer.parseInt(T.substring(0, 2)) * 3600 + Integer.parseInt(T.substring(3, 5)) * 60 + Integer.parseInt(T.substring(6));
        //     return r - l;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 这个破烂题目出得真恶心人。。。。
        // static final int mod = (int)1e9 + 7;
        // public int minimumCost(int[] a, int k) {
        //     int n = a.length, i = 0, v = k;
        //     long f = 1l, ff = 0;
        //     while (i < n) {
        //         while (i < n && k >= a[i]) {
        //             k -= a[i];
        //             i++;
        //         }
        //         if (i == n) break;
        //         // i < n && k < a[i]
        //         int cnt = (a[i] - k) / v + ((a[i]-k) % v == 0 ? 0 : 1);
        //         ff = ((long)cnt  * (long)(f + f+cnt-1) / 2l + ff) % mod;
        //         f = (f + (long)cnt) % mod;
        //         k = (int)(((long)k + (long)v * cnt) - a[i]);
        //         i++; 
        //     }
        //     return (int)ff;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 把【二维数组题目，转化为: 有向图】来求：最长路径. 这个思路应该是对的
        // // 【TODO：】存在，暴力所有边，能够保障全局最优解，但会 TLE; 想要有效边只连一个，却不能保障全局最优解
        // public int maxConsistentColumns(int[][] a, int v) {
        //     int m = a.length, n = a[0].length;
        //     boolean [][] g = new boolean [n][n];
        //     for (int i = 0; i < n; i++) 
        //         for (int j = i+1; j < n; j++) {
        //             boolean connected = true;
        //             for (int k = 0; k < m; k++)
        //                 if (Math.abs(a[k][i] - a[k][j]) > v) {
        //                     connected = false;
        //                     break;
        //                 }
        //             if (connected)
        //                 g[i][j] = true;
        //         }
        //     int [] f = new int [n];
        //     Arrays.fill(f, 1);
        //     for (int j = 0; j < n; j++)
        //         for (int i = 0; i < j; i++)
        //             if (g[i][j])
        //                 f[j] = Math.max(f[j], f[i] + 1);
        //     return Arrays.stream(f).max().getAsInt();
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public String rearrangeString(String S, char x, char y) {
        //     int n = S.length(); char [] s = S.toCharArray();
        //     int l = 0, r = 0;
        //     StringBuilder sb = new StringBuilder();
        //     for (int i = 0; i < n; i++) {
        //         char c = s[i];
        //         if (c == x) l++;
        //         else if (c == y) r++;
        //         else sb.append(c);
        //     }
        //     for (int i = 0; i < r; i++)
        //         sb.append(y);
        //     for (int i = 0; i < l; i++)
        //         sb.append(x);
        //     return sb.toString();
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public long maximumValue(int n, int s, int m) {
        //     return (n % 2 == 0 ? (long)s + m + (n == 2 ? 0 : (long)(m-1) * (n-2)/2l) : (n == 1 ? (long)s : (long)s + (long)(m-1) * (n-1)/2l+1));
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【TODO：】感觉这个破烂题目，思路不太全。。。看提示看不懂。。。
        // static final int mod = (int)1e9 + 7;
        // public int minAdjacentSwaps(int[] a, int a, int b) {
        //     int n = a.length, l = 0, r = 0, f = 0;
        //     for (int v : a)
        //         if (v < a) l ++;
        //         else if (v > b) r ++;
        //     int j = l, k = n-r;
        //     for (int i = 0; i < n; i++) {
        //     }
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 858/999 passed... 不知道细节嘯城写错了，今天不想再写这个破烂题目了。。
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int minCost(String S, String T, List<List<String>> rules, int[] costs) {
        //     int n = S.length(), m = rules.size(); char [] s = S.toCharArray(), t = T.toCharArray();
        //     int [] f = new int [n+1]; Arrays.fill(f, Integer.MAX_VALUE / 2); f[0] = 0;
        //     Map<String, List<Integer>> [] ss = new HashMap[27];
        //     Arrays.setAll(ss, z -> new HashMap<String, Integer>());
        //     for (int i = 0; i < m; i++) {
        //         char c = rules.get(i).get(0).charAt(0);
        //         if (c != '*')
        //             ss[c-'a'].computeIfAbsent(rules.get(i).get(0), z -> new ArrayList<>()).add(i);
        //         else 
        //             ss[26].computeIfAbsent(rules.get(i).get(0), z -> new ArrayList<>()).add(i);
        //     }
        //     for (int i = 0; i < n; i++) {
        //         System.out.println("\n i: " + i);
        //        if (s[i] == t[i]) {
        //             f[i+1] = Math.min(f[i+1], f[i]);
        //             continue;
        //         }
        //        for (String p : ss[s[i]-'a'].keySet())
        //            if (i+p.length() <= n) {
        //                for (int j : ss[s[i]-'a'].get(p)) {
        //                    if (isMatched(p, S.substring(i, i+p.length())) && isMatched(rules.get(j).get(1), T.substring(i, i+p.length())))
        //                        f[i+p.length()] = Math.min(f[i+p.length()], f[i] + costs[j] + getCnt(p));
        //                }
        //            } 
        //        for (String p : ss[26].keySet())
        //            if (i+p.length() <= n) {
        //                for (int j : ss[26].get(p)) {
        //                    if (isMatched(p, S.substring(i, i+p.length())) && isMatched(rules.get(j).get(1), T.substring(i, i+p.length())))
        //                        f[i+p.length()] = Math.min(f[i+p.length()], f[i] + costs[j] + getCnt(p));
        //                }
        //            } 
        //        System.out.println(Arrays.toString(f));
        //     }
        //   return (f[n] == Integer.MAX_VALUE / 2 ? -1 : f[n]);
        // }
        // boolean isMatched(String S, String T) {
        //     int m = S.length(), n = T.length();
        //     if (m != n) return false;
        //     char [] s = S.toCharArray(), t = T.toCharArray();
        //     for (int i = 0; i < n; i++)
        //         if (s[i] != t[i] && s[i] != '*') return false;
        //     return true;
        // }
        // int getCnt(String S) {
        //     int n = S.length(), f = 0; char [] s = S.toCharArray();
        //     for (char c : s) 
        //         if (c == '*') f++;
        //     return f;
        // }
    }    // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！ 
    public static void main (String[] args) { 
        Solution s = new Solution (); 
        // String a = "sccgccc", b = "pnsfnsn";
        //          // pnsfnsn
        // List<List<String>> lls = new ArrayList<>();
        // lls.add(List.of("eth*zlbjt*jk*fs*yi*","qqyquiwhthiijrpnuxp"));
        // lls.add(List.of("c","s"));
        // lls.add(List.of("ts*jhxrxi*zb*euxjvfu","qoryrrrijfongynejtaa"));
        // lls.add(List.of("vastexmfbdych","tipshqfvkpesc"));
        // lls.add(List.of("g","f"));
        // lls.add(List.of("a*egap*j*r*ck","ktcawrutiyuxf"));
        // lls.add(List.of("fj**c**o*","zudrkqxov"));
        // lls.add(List.of("ldsdt*zydtla*obpmp","pgrjeuwxtwgbmmqmvf"));
        // lls.add(List.of("u*hobjsw**smlt","xsbpdclshgypcn"));
        // lls.add(List.of("xoiqwth*apzkwpm*ca","dgaggdekjxffyzzpng"));
        // lls.add(List.of("c","n"));
        // lls.add(List.of("s","p"));
        // lls.add(List.of("kwhybsl*f*fpoj","qehglwiklxfmxk"));
        //     int [] c = new int [] {82,818,136,176,206,14,230,512,176,98,672,559,250};

        "qhvpxyarqcwrxyobryhpghjqrbfmkpzunhyyhishjqrqivp"
            target =
            "jsxnxwiqgwuxznrjjhlwobxbpjuvpfbcxejhlwobxbpjsxn"
            rules =
            [["b","j"],
             ["vgzjtlhhfdiy**m*","szvdzgzyuikxadvr"],
             ["uifo*vktzdsj","ckmiazdpohmn"],
             ["*yh**hjqr","jhlwobxbp"],
             ["q*v*","jsxn"],
             ["****qcwrx*o","xwiqgwuxznr"],
             ["fmk*zunh","uvpfbcxe"],
             ["tjvwzdnglkckr*","ctncmmxdhfuolz"],
             ["*a*","sxu"],
             ["mhludrcowuckzdbbbh*","xbpmhypyvacjescsuxn"],
             ["vskds*w*i*sbw*qwk*a","pdblrviscwnrdztkurv"],
             ["*w*lj","lspfa"],
             ["euqh*rnfw","ehmvfttzo"]]
            costs =
            [133,195,595,585,942,234,625,927,969,217,511,958,336]
        int r = s.minCost(a, b, lls, c);
        System.out.println("r: " + r);
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
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】