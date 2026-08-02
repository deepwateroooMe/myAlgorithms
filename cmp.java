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

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public boolean canReach(int[] s, int[] t) {
        //     int [][] dirs = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {2, -1}, {2, 1}, {1, -2}, {1, 2}};
        //     Deque<int []> q = new ArrayDeque<>();
        //     q.offerFirst(new int [] {s[0], s[1], 0});;
        //     int n = 8;
        //     while (!q.isEmpty()) {
        //         int [] r = q.pollLast();
        //         if (r[0] == t[0] && r[1] == t[1] && r[2] % 2 == 0) return true;
        //         else if (r[0] == t[0] && r[1] == t[1]) return false;
        //         for (int [] d : dirs) {
        //             int i = r[0] + d[0], j = r[1] + d[1];
        //             if (i < 0 ||i >= n || j < 0 || j >= n) continue;
        //             q.offerFirst(new int [] {i, j, r[2]+1});
        //         }
        //     }
        //     return false;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public class Node {
        //     TreeNode f;
        //     int v, cnt;
        //     Node l, r;
        //     public Node(TreeNode root) {
        //         this.f = root;
        //         v = root.val;
        //         // l = null; r = null;
        //         cnt = 0;
        //     }
        // }
        // void buildNodeTree(Node f, TreeNode r) {
        //     if (r.left == null && r.right == null) {
        //         f.v = r.val;
        //         f.cnt = 1; // 叶子节点
        //         return ;
        //     }
        //     if (r.left != null) {
        //         f.l = new Node(r.left);
        //         buildNodeTree(f.l, r.left);
        //     }
        //     if (r.right != null) {
        //         f.r = new Node(r.right);
        //         buildNodeTree(f.r, r.right);
        //     }
        //     f.cnt = (f.l != null ? f.l.cnt : 0) + (f.r != null ? f.r.cnt : 0) + (f.v >= Math.max((f.l != null ? f.l.v : 0), (f.r != null ? f.r.v : 0)) ? 1 : 0);
        //     f.v = Math.max(f.v, Math.max((f.l != null ? f.l.v : 0), (f.r != null ? f.r.v : 0)));
        // }
        // public int countDominantNodes(TreeNode root) {
        //     Node r = new Node(root);
        //     buildNodeTree(r, root);
        //     return r.cnt;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int maximalRectangle(char [][] a) {
        //     int m = a.length, n = a[0].length, r = 0;
        //     // col                        row
        //     int [][] f = new int [m][n+1], g = new int [m+1][n];
        //     for (int i = 0; i < m; i++)
        //         for (int j = n-1; j >= 0; j--) {
        //             if (a[i][j] == '1') f[i][j] = f[i][j+1] + 1;
        //             else f[i][j] = 0;
        //         }
        //     for (int j = 0; j < n; j++)
        //         for (int i = m-1; i >= 0; i--) {
        //             if (a[i][j] == '1') g[i][j] = g[i+1][j] + 1;
        //             else g[i][j] = 0;
        //         }
        //     System.out.println("f.length: " + f.length);
        //     for (int z = 0; z < f.length; ++z)
        //         System.out.println(Arrays.toString(f[z]));
        //     System.out.println("g.length: " + g.length);
        //     for (int z = 0; z < g.length; ++z)
        //         System.out.println(Arrays.toString(g[z]));
        //     for (int i = 0; i < m; i++)
        //         for (int j = 0; j < n; j++) {
        //             if (a[i][j] == '0') continue;
        //             // 确定长方形的两条边长
        //             // 【长条：某边为 1】
        //             if (f[i][j] == 1 || g[i][j] == 1) {
        //                 r = Math.max(r, f[i][j] * g[i][j]);
        //                 continue;
        //             }
        //             // 两条边都大于 1: 【TODO：】遍历两条边上所有可能性——每种可能性都要确认此长方形的合法性，是否全为1 等
        //         }
        //     return r;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【TODO：】不知道这个破烂题目要怎么 debug 晚点儿再写这个破烂题目
        // public int oddEvenJumps(int[] a) {
        //     n = a.length;
        //     f = new int [n]; g = new int [n];
        //     Arrays.fill(f, -1); Arrays.fill(g, -1);
        //     ArrayDeque<Integer> q = new ArrayDeque<>(), t = new ArrayDeque<>();
        //     // 【单调递减队列】：
        //     for (int i = n-1; i >= 0; i--) {
        //         while (!q.isEmpty() && a[i] > a[q.peekFirst()]) 
        //             t.offerFirst(q.pollFirst());
        //         if (!q.isEmpty())
        //             f[i] = q.peekFirst();
        //         q.offerFirst(i);
        //         while (!t.isEmpty())
        //             q.offerFirst(t.pollLast());
        //     }
        //     q.clear(); t.clear();
        //     // 【单调递增队列】：
        //     for (int i = n-1; i >= 0; i--) {
        //         while (!q.isEmpty() && a[i] < a[q.peekFirst()]) 
        //             t.offerFirst(q.pollFirst());
        //         if (!q.isEmpty())
        //             g[i] = q.peekFirst();
        //         q.offerFirst(i);
        //         while (!t.isEmpty())
        //             q.offerFirst(t.pollLast());
        //     }
        //     System.out.println(Arrays.toString(f));
        //     System.out.println(Arrays.toString(g));
        //   int ans = 0;
        //     for (int i = 0; i < n; i++) 
        //         if (canReach(i)) {
        //             ans++;
        //             System.out.println("i: " + i + " " + "ans: " + ans);
        //         }
        //     return ans;
        // }
        // int [] f, g;
        // int n;
        // boolean canReach(int idx) {
        //     int i = 1;
        //     while (idx != n-1) {
        //         if (i % 2 == 1 && f[idx] != -1) {
        //             idx = f[idx];
        //             i++;
        //         } else if (i % 2 == 0 && g[idx] != -1) {
        //             idx = g[idx];
        //             i++;
        //         } else // if (f[idx] == -1 && g[idx] == -1)
        //             return false;
        //     }
        //     return true;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，还晃习惯与动规，先写【记忆化深搜】
        // // 【TODO：】感觉，明明是【区间型动规】可是却不知道怎么实时更新累加后的和。。。
        // // 一方面，亲爱的表哥的活宝妹，确实猊主没有练习动规，忘记了狠多算法和细节；另一方面，感觉现在睡眠状态不佳的笨宝妹，脑袋昏昏。。。
        // // 亲爱的表哥的活宝妹，晚上或是明天再接着写这些破烂动规！！！
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int mergeStones(int[] a, int k) {
        //     n = a.length; this.k = k; 
        //     if (k != 2 && n % k != k-1) return -1;
        //     g = new int [n+1];
        //     for (int i = 0; i < n; i++)
        //         g[i+1] = g[i] + a[i];
        //     f = new int [n][n];
        //     for (int i = 0; i < n; i++)
        //         Arrays.fill(f[i], Integer.MAX_VALUE / 2);
        //     dfs(0, n-1);
        //     System.out.println("f.length: " + f.length);
        //     for (int z = 0; z < f.length; ++z)
        //         System.out.println(Arrays.toString(f[z]));
        //     return f[0][n-1];
        //     // return dfs(0, n-1);
        // }
        // int [][] f;
        // int [] g;
        // int n, k;
        // int dfs(int i, int j) {
        //     if (j-i < k-1) return Integer.MAX_VALUE / 2;
        //     if (f[i][j] != Integer.MAX_VALUE / 2) return f[i][j];
        //     if (j - i == k-1) return f[i][j] = g[j+1] - g[i];
        //     int r = Integer.MAX_VALUE / 2;
        //     for (int x = i+k-1; x <= j; x++) 
        //         r = Math.min(r, (x == i+k-1 ? 0 : dfs(i, x-k)) + g[x+1] - g[x-k+1] + dfs(x+1, j));
        //     return f[i][j] = r;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【TODO：】晚点儿再写这个破烂题目
        // public int minTaps(int n, int[] a) {
        //     int r = 1;
        //     List<int []> l = new ArrayList<>();
        //     for (int i = 0; i <= n; i++) {
        //         if (a[i] == 0) continue;
        //         l.add(new int [] {i-a[i], i+a[i]});
        //     }
        //     Collections.sort(l, (x, y)->x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
        //     if (l.size() == 0 || l.get(0)[0] > 0) return -1;

        //     for (int i = 0; i < l.size(); i++)
        //         System.out.println(Arrays.toString(l.get(i)));

        //     int i = 0, j = l.get(0)[1], left = l.get(i)[0];
        //     while (j < n) {
        //         // 【左端点：相同】选（右端点，能够延伸的最远处）
        //         while (i < l.size() && l.get(i)[0] == left) {
        //             j = Math.max(j, l.get(i)[1]);
        //             i++;
        //         }
        //         if (j >= n) return r;
        //         // 【左端点右移】，但（右端点，仍在被覆盖范围内）
        //         while (i < l.size() && l.get(i)[1] <= j) i++;
        //         if (i >= l.size()) return (j >= n ? r : -1);
        //         if (l.get(i)[0] > j) return -1;
        //         r++;
        //         left = l.get(i)[0];
        //     }
        //     return r;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public class Node {
        //     TreeNode f;
        //     Node l, r;
        //     int s;
        //     boolean isBST;
        //     int minL, maxL, minR, maxR; // <<<<<<<<<<<<<<<<<<<< 这四个变量，写得昏昏的。。。
        //     public Node(TreeNode r) {
        //         this.f = r;
        //         s = r.val;
        //     }
        // }
        // void buidNodeTree(Node f, TreeNode g) {
        //     if (g.left == null && g.right == null) {
        //         f.isBST = true;
        //         return ;
        //     }
        //     if (g.left != null) {
        //         f.l = new Node(g.left);
        //         buildNodeTree(f.l, g.left);
        //         // f.minL = (f.l.l == null ? f.l.)
        //         // f.maxL = f.l.maxL; // 【TODO：】这里像是写得不对
        //     }
        //     if (g.right != null) {
        //         f.r = new Node(g.right);
        //         buildNodeTree(f.r, g.right);
        //         // f.minR = f.r.min
        //     }
        //     // 【左子节点。或、右子节点：单侧为空】
        //     if (g.left == null || g.right == null) {
        //         if (g.left == null) {
        //             if (f.r.isBST && f.f.val < f.r.minL) { // 这里写得不对。。。
        //                 f.isBST = true;
        //                 f.minR = (f.r.l == null ? f.r.f.val : f.r.minL);
        //             }
        //         }
        //     }
        // }
        // public int maxSumBST(TreeNode root) {
        //     Node r = new Node(root);
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 明明应该是最经典、最典型的【动规】：人数狠少 n[1,2,...10]
        // // 亲爱的表哥的活宝妹，亲爱的表哥的活宝妹、笨宝妹的脑袋真昏：就不知道细节上哪里写错了。。看来晚餐得少吃一点儿了；调整几天，再不行晚餐得在学校里解决
        // // 亲爱的表哥的活宝妹，今天不想再写这个破烂题目了，明天再接着这里写；看明天能否把这个细节自己纠正过来
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // static final int mod = (int)1e9 + 7;
        // public int numberWays(List<List<Integer>> l) {
        //     int n = l.size(), m = 40, max = 0;
        //     List<Integer> [] a = new ArrayList [m];
        //     Arrays.setAll(a, z -> new ArrayList<Integer>());
        //     for (int j = 0; j < n; j++) 
        //         for (int i : l.get(j)) {
        //             a[i-1].add(j); // 【每顶帽子】：有哪些人爱戴
        //             max = Math.max(max, i);
        //         }
        //     System.out.println("a.size(): " + a.length);
        //     for (int i = 0; i < max; i++) {
        //         // System.out.println("a[i].size(): " + a[i].size());
        //         System.out.println(Arrays.toString(a[i].toArray()));
        //     }

        //         int [][] f = new int [max][1 << n];
        //         // f[0][0] = 1;
        //         for (int i = 0; i < max; i++)
        //             f[i][0] = 1;
        //     // 【遍历帽子】
        //     for (int i = 0; i < max; i++) {
        //         if (a[i].size() == 0) continue;
        //         // 遍历：【1 << n】 peopleMask
        //         for (int j = 0; j < (1 << n); j++) {
        //             // 遍历：【爱戴：此顶帽子的人】
        //             for (int k : a[i]) {
        //                 if ((j & (1 << k)) == 0) { // 可以把此帽子，给它戴
        //                     // System.out.println("i: " + i + " " + "Integer.toBinaryString(j): " + Integer.toBinaryString(j) + " " + "k: " + k);
        //                     f[i][j | (1 << k)] = (f[i][j | (1 << k)] + (i == 0 ? 1 : f[i-1][j])) % mod;
        //                     // if (i > 0)
        //                     //     System.out.println("f[i-1][j]: " + f[i-1][j] + " " + "f[i][j|(1 <<k)]: " + f[i][j|(1 <<k)]);
        //                     // else System.out.println("f[i][j | (1 << k)]: " + f[i][j | (1 << k)]);
        //                 } 
        //             }
        //         }
        //     }
        //     System.out.println("f.length: " + f.length);
        //     for (int z = 0; z < f.length; ++z)
        //         System.out.println(Arrays.toString(f[z]));
        //    return f[max-1][(1 << n)-1];
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int largestInteger(int n, int s) {
        //     if (s > 45 || s == 45 && n < 5) return -1;
        //     StringBuilder sb = new StringBuilder();
        //     while (s >= 0 && n > 0) {
        //         if (s < 10) {
        //             sb.append((char)(s+'0'));
        //             s = 0;
        //             n--;
        //         } else {
        //             sb.append('9');
        //             s -= 9;
        //             n--;
        //         }
        //     }
        //     if (n == 0) return (s == 0 ? Integer.parseInt(sb.toString()) : -1);
        //     return Integer.parseInt(sb.toString());
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public List<List<Integer>> aggregateTimeSeries(int[][] a, int[][] g) {
        //     int m = a.length, n = g.length, i = 0, j = 0, s = 0, t = 0, ti = 0, v = 0;
        //     List<List<Integer>> ll = new ArrayList<>();
        //     while (i < m || j < n) {
        //         if (i >= m || j >= n) {
        //             if (i >= m)
        //                 while (j < n) {
        //                     ll.add(List.of(g[j][0], g[j][1]));
        //                     j++;
        //                 }
        //             if (j >= n) 
        //                 while (i < m) {
        //                     ll.add(List.of(a[i][0], a[i][1]));
        //                     i++;
        //                 }
        //             break;
        //         }
        //         s = a[i][0];
        //         t = g[j][0];
        //         ti = 0;
        //         v = 0;
        //         if (s < t) {
        //             ti = s;
        //             v = a[i][1] + g[j][1];
        //             i++;
        //         } else if (s == t) {
        //             ti = s;
        //             v = a[i][1] + g[j][1];
        //             i++; j++;
        //         } else { // s > t
        //             ti = t;
        //             v = a[i][1] + g[j][1];
        //             j++;
        //         }
        //         ll.add(List.of(ti, v));
        //     }
        //     return ll;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，不知道细节哪里写错了。。。晚点儿再写这个破烂题目...
        // // 亲爱的表哥的活宝妹，亲爱的表哥的活宝妹、笨宝妹，【多少年来。。。】终于自己 debug 写过一个破烂题目。。。瞎吃海胀把自己脑袋胀傻的笨宝妹。。。
        // public long minCost(int m, int n, int[][] a) {
        //     f = new long [m][n][2]; this.m = m; this.n = n; this.a = a;
        //     for (int i = 0; i < m; i++)
        //         for (int j = 0; j < n; j++)
        //             Arrays.fill(f[i][j], Long.MAX_VALUE / 2);
        //     Arrays.fill(f[0][0], 1);
        //     dij(0, 0, 1);
        //     dij(0, 0, 0);
        //     return Math.min(f[m-1][n-1][0], f[m-1][n-1][1]); 
        // }
        // long [][][] f;
        // int [][] a;
        // int m, n;
        // int [][] dirs = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        // void dij(int x, int y, int pp) {
        //     Queue<long []> q = new PriorityQueue<>((u, v) -> (Long.compare(u[3], v[3])));
        //     q.offer(new long [] {(long)x, (long)y, (long)pp, (pp == 1 ? 1l : 1l+(long)a[0][0])});
        //     long val = 0;
        //     boolean [][] vis = new boolean [m][n];
        //     while (!q.isEmpty()) {
        //         long [] cur = q.poll();
        //         int i = (int)cur[0], j = (int)cur[1], p = (int)cur[2]; long v = cur[3];
        //         if (i == m-1 && j == n-1) {
        //             f[i][j][p] = v;
        //             return ;
        //         }
        //         if (f[i][j][1-p] > v + (long)a[i][j] || a[i][j] == 0 && !vis[i][j]) {
        //             f[i][j][1-p] = v + (long)a[i][j];
        //             q.offer(new long [] {i, j, 1-p, v + (long)a[i][j]}); // for waiting
        //             vis[i][j] = true;
        //         }
        //         for (int [] d : dirs) {
        //             int ii = i + d[0], jj = j + d[1];
        //             if (ii < 0 || ii >= m || jj < 0 || jj >= n) continue;
        //             if (p == 0) { // Left Up
        //                 if (d[0] == -1 && d[1] == 0 || d[0] == 0 && d[1] == -1) 
        //                     val = v + (long)(ii + 1) * (jj + 1);
        //                 else // breaking rules
        //                     val = v + (long)(ii + 1) * (jj + 1) + (long)a[i][j];
        //             } else { // p = 1;
        //                 if (d[0] == -1 && d[1] == 0 || d[0] == 0 && d[1] == -1) // breaking rules
        //                     val = v + (long)(ii + 1) * (jj + 1) + (long)a[i][j];
        //                 else 
        //                     val = v + (long)(ii + 1) * (jj + 1);
        //             }
        //             if (f[ii][jj][1-p] > val) {
        //                 f[ii][jj][1-p] = val;
        //                 q.offer(new long [] {ii, jj, 1-p, val});
        //             }
        //         }
        //     }
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int maxCollectedFruits(int[][] a) {
        //     int n = a.length;
        //     int [][][] f = new int [n][n][n]; // 三维 MLE MLE MLE 。。。
        //     f[0][n-1][n-1] = a[0][0] + a[0][n-1] + a[n-1][0];
        //     for (int i = 0; i < n-1; i++) // 遍历：【右上角】当前所在的（行 i）
        //         for (int j = 0; j < n; j++)  // 遍历：【右上角】当前所在的（列 j）
        //             // 遍历：【左下角】当前所在的（行 k）: 【TODO：】不知道这个变昌是否 work
        //             for (int k = 0; k < n; k++) {
        //                 for (int x = -1; x <= 1; x++) {
        //                     if (j+x < 0 || j+x >= n) continue; // 右上角的下一行：在列上越界
        //                     for (int y = -1; y <= 1; y++) {
        //                         if (k+y < 0 || k+y >= n) continue; // 左上角的下一列：在行上越界
        //                         if (f[i][j][k] == 0) continue;
        //                         // if (j+x <= i+1 || k+y <= i+1) continue; // <<<<<<<<<<<<<<<<<<<<
        //                         if (i == j || k == i) continue; // 无效。。。
        //                         // if (i+1 == n-1 && j+x == n-1 && k+y == n-1) 
        //                         if (i+1 == n-1) 
        //                             f[i+1][j+x][k+y] = Math.max(f[i+1][j+x][k+y], f[i][j][k] + a[i+1][i+1]);
        //                         else
        //                             f[i+1][j+x][k+y] = Math.max(f[i+1][j+x][k+y], f[i][j][k] + a[i+1][i+1] + a[i+1][j+x] + a[k+y][i+1]);
        //                         // if (i+1 == n-1 && j+x == n-1 && k+y == n-1)
        //                         // if (i+1 == 3 && j+x == 4 && k+y == 4 || i+1 == n-1 && j+x == n-1 && k+y == n-1 && f[i][j][k] >= 139)
        //                         //     System.out.println("(i+1): " + (i+1) + " " + "(j+x): " + (j+x) + " " + "(k+y): " + (k+y) + " f[i+1][j+x][k+y]: " + f[i+1][j+x][k+y]);
        //                     }
        //                 }
        //             }
        //     return f[n-1][n-1][n-1];
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 这个题目，像是【树上偷的小偷：树型动规】
        // // 亲爱的表哥的活宝妹，亲爱的表哥的活宝妹、笨宝妹，只认得出来像【村上小偷】却认不出它是【树上背包】。。。
        // // 亲爱的表哥的活宝妹，亲爱的表哥的活宝妹、笨宝妹，【明天：一定】自己把这个（树上背包）自己亲手，写一遍。。。
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，今天晚上脑袋好好想想这个破烂题目，亲爱的表哥的活宝妹，明天自己把这个破烂题目写一遍！！！
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int maxProfit(int n, int[] a, int[] b, int[][] egs, int v) {
        //     this.n = n; this.v = v; this.c = a; //this.d = b; 
        //     for (int i = 0; i < n; i++) {
        //         this.a[i] = b[i] - a[i]; // 【全价】
        //         this.b[i] = b[i] - Math.floor(a[i] / 2); // 【半价】
        //         this.d[i] = Math.floor(a[i] / 2); 
        //     }
        //     g = new ArrayList [n];
        //     Arrays.setAll(g, z -> new ArrayList<Integer>());
        //     for (int [] e : egs) {
        //         int u = e[0], v = e[1];
        //         g[u].add(v);  // 【TODO：】感觉这里应该排序，像是【轻重链树、重链剖分】之类的。。。
        //     }
        //     f = new Integer [n][v+1][2]; // 【第三给 0/1】：直接上司，是1/否0 购买过股票
        //     dfs(0, v, 0);
        //     return f[0][v];
        // }
        // Integer [][][] f;
        // List<Integer> [] g;
        // int [] a, b, c, d;
        // int n, v;
        // int dfs(int i, int j, int k) {
        //     if (f[i][j][k] != null) return f[i][j][k];
        //     if (g[i].size() == 0) { // 【叶子节点】
        //         if (k == 0 && j >= a[i] || k == 1 && j >= Math.floor(a[i] / 2)) 
        //             return f[i][j][k] = (k == 0 ? b[i] - a[i] : b[i] - Math.floor(a[i] / 2));
        //         else return f[i][j][k] = 0;
        //     }
        //     int r = 0, jj = j;
        //     // 【上司不买】：它的 N 个下属，买与不买，是否有选择性？这个点，是否是上次笨宝妹没能写出来的原因？？？排序：最佳投入产出效率。。。
        //     Collections.sort(g[i], (x, y)->a[y]-a[x]); // 【下属：全价买】
        //     boolean enoughBudget = true;
        //     while (jj > 0) {
        //         for (int v : g[i]) {
        //             if (jj < a[v]) {
        //                 enoughBudget = false;
        //                 break;
        //             }
        //             // 【TODO：】每个下属的股票投资，这里还是没能想透彻。。。
        //         }
        //     }
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int maximumWidth(int[] a) {
        //     int n = a.length, v = -1, cnt = 0;
        //     Arrays.sort(a); // 【升序排列】
        //     System.out.println(Arrays.toString(a));
        //     // Map<Integer, Integer> m = new HashMap<>();
        //     // 数组里【某个】单值作为高度
        //     for (int i = 0; i < n; i++) {
        //     // for (int i = n-1; i >= 0; i--) {
        //         int curCnt = getCnts(a, a[i], i);
        //         System.out.println("\n i: " + i + "; a[i]: " + a[i] + "; curCnt: " + curCnt);
        //         System.out.println();
        //         // if (a[i] < v && m.containsKey((v - a[i]))) 
        //         //     m.put(v, m.getOrDefault(v, 0) + Math.min(m.getOrDefault(a[i], 0), m.getOrDefault(v-a[i], 0)));
        //         // m.put(a[i], m.getOrDefault(a[i], 0) + 1);
        //         if (curCnt > cnt) {
        //             cnt = curCnt;
        //             v = a[i];
        //             System.out.println("cnt: " + cnt + " " + "a[i]: " + a[i]);
        //         }
        //     }
        //     // 数组里【某 2 个组合值】作为高度 715/856 passed...
        //     // cnt = Math.max(cnt, getMaxDoubleCnts(a));
        //     return cnt;
        // }
        // // 【TODO：】这个方法里，对重复数字的处理，有【BUG：】
        // int getMaxDoubleCnts(int [] a) {
        //     int n = a.length;
        //     Map<Integer, Integer> m = new HashMap<>();
        //     for (int i = 0; i < n; i++)
        //         for (int j = 0; j < n; j++) {
        //             if (i == j) continue;
        //             m.put(a[i]+a[j], m.getOrDefault(a[i]+a[j], 0)+1);
        //         }
        //     System.out.println("Collections.max(m.values()): " + Collections.max(m.values()));
        //     return Collections.max(m.values()) / 2;
        // }
        // int getCnts(int [] a, int v, int idx) {
        //     Map<Integer, Integer> m = new HashMap<>();
        //     for (int i = 0; i <= idx; i++) {
        //         m.put(a[i], m.getOrDefault(a[i], 0) + 1);
        //         if (a[i] < v && m.containsKey((v - a[i]))) {
        //             m.put(v, m.getOrDefault(v, 0) +
        //                   (i > 0 && a[i] == a[i-1] ?
        //                    (a[i] == v-a[i] ? (m.get(a[i])%2 == 0 ? 1 : 0) : (m.get(a[i]) <= m.get(v-a[i]) ? 1 : 0))
        //                    : (a[i] == v-a[i] ? m.get(a[i])/2 : Math.min(m.getOrDefault(a[i], 0), m.getOrDefault(v-a[i], 0)))));
        //             // System.out.println("a[i]: " + a[i] + " " + "(v-a[i]): " + (v-a[i]) + " " + "m.get(v): " + m.get(v));
        //         }
        //         // System.out.println("idx: " + idx + " " + "a[idx]: " + a[idx] + " " + "m.get(a[idx]): " + m.get(a[idx]));
        //   }
        //     return m.get(v);
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int countValidPrefixes(String S) {
        //     int n = S.length(), r = 0; char [] s = S.toCharArray();
        //     int [] f = new int [n+1];
        //     for (int i = 0; i < n; i++)
        //         f[i+1] = f[i] + s[i] - '0';
        //     for (int i = 0; i < n; i++) 
        //         if (Math.abs(f[i+1] -(i+1 - f[i+1])) <= 1) r++;
        //     return r;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【TODO：】用在（数组）上的快速区间更新，是用什么数据结构？差分数组？
        // // 亲爱的表哥的活宝妹，亲爱的表哥的活宝妹、笨宝妹，读不懂题目：什么时候减少力气，什么时候不减少力气？？？
        // public long minInitialStrength(int[] b, int[][] a) {
        //     int n = b.length, m = (int)Math.pow(10, 9);
        //     long [] f = new long [n]; //f[0] = (long)b[0]; 
        //     for (int i = 1; i < n; i++)
        //         f[i] = (long)(b[i] - b[i-1]);
        //     Arrays.sort(a, (x, y)->x[0] != y[0] ? x[0] - y[0] : (x[1] != y[1] ? x[1] - y[1] : x[2] - y[2]));
        //     for (int [] e : a) {
        //         int i = e[0], j = e[1], v = e[2];
        //         f[i] += v;
        //         f[j+1] -= v;
        //     }
        //     int [] ff = new int [n]; 
        //     long r = 0l;
        //     for (int i = 0; i < n; i++) {
        //         r += (long)f[i];
        //         ff[i] = (r >= b[i] ? 0 : (int)(r == 0 ? b[i] : r));
        //     }
        //     int i = n-1;
        //     r = 0l;
        //     // System.out.println(Arrays.toString(b));
        //     // System.out.println(Arrays.toString(f));
        //     // System.out.println(Arrays.toString(ff));
        //     while (i >= 0 && ff[i] == 0) --i;
        //     if (i < 0) return (ff[0] == 0 ? 0 : b[0]);
        //     r += (long)b[i] - ff[i];
        //     while (--i >= 0) {
        //         r += b[i];
        //     }
        //     return r;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int minMaxWaitingTime(int[] a, int[] b) {
        //     int n = a.length, m = b.length;
        //     int [] ff = new int [n]; Arrays.fill(ff, -1);
        //     if (a[0] <= Arrays.stream(b).max().getAsInt()) ff[0] = 0;
        //     else return -1;
        //     int [][] f = new int [n][2];
        //     for (int i = 0; i < m; i++)
        //         if (a[0] <= b[i])
        //             f[0][i] = 0;
        //         else f[0][i] = Integer.MAX_VALUE / 2;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public long maxPairStrength(int[] a) {
        //     int n = a.length;
        //     long f = Long.MIN_VALUE;
        //     for (int i = 0; i < n; i++)
        //         for (int j = 0; j < n; j++) {
        //             if (i == j) continue;
        //             int v = gcd(a[i], a[j]);
        //             f = Math.max(f, (long)a[i] * a[j] / ((long)(v * v)));
        //         }
        //     return f;
        // }
        // int gcd(int x, int y) {
        //     if (y == 0) return x;
        //     return gcd(y, x % y);
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int countRatioSubarrays(int[] a, int x, int y) {
        //     int n = a.length, r = 0;
        //     int [] f = new int [n];
        //     f[0] = (a[0] % 2 == 1 ? 1 : 0);
        //     for (int i = 1; i < n; i++)
        //         if (a[i] % 2 == 1)
        //             f[i] = f[i-1] + 1;
        //         else f[i] = f[i-1];
        //     for (int i = 0; i < n; i++)
        //         for (int j = i; j < n; j++) {
        //             int o = f[j] - (i == 0 ? 0 : f[i-1]), e = j - i + 1 - o;
        //             if (o > 0 && e * y <= x * o)
        //                 r++;
        //         }
        //     return r;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 这个破烂题目出得真恶心人，亲爱的表哥的活宝妹，晚点儿再写这个破烂题目
        // public int[] countTasks(int[] a, int[] b) {
        //     int n = a.length, m = b.length, idx = 0, t = 0;
        //     long [] p = new long [n]; p[0] = (long)a[0];
        //     for (int i = 1; i < n; i++) 
        //         p[i] = p[i-1] + (long)a[i];
        //     int [] r = new int [m];
        //     for (int i = 0; i < m; i++) {
        //         System.out.println("\n i: " + i);
        //         if (i == 0 || p[i-1] == 0) {
        //             if (b[i] >= p[n-1]) {
        //                 r[i] = 0;
        //                 idx = 0;
        //                 t = a[idx];
        //                 continue;
        //             }
        //             int j = Arrays.binarySearch(p, (long)b[i]);
        //             if (j >= 0) {
        //                 idx = (j == n-1 ? 0 : j+1); // idx 完全没有开始
        //                 t = a[idx];
        //                 r[i] = n-1 - j;
        //             } else {
        //                 idx = -1 * j - 1;
        //                 r[i] = n-1 - idx + 1;
        //                 System.out.println("idx: " + idx + " " + "i: " + i); // <<<<<<<<<<<<<<<<<<<<
        //                 // if (idx == n) 
        //                 //     r[i] = 0;
        //                 t = (int)(p[idx] - (long)b[i]); // <<<<<<<<<<<<<<<<<<<< 
        //             }
        //         } else {
        //             int j = Arrays.binarySearch(p, idx, n, p[idx] + (long)b[i] - (long)t);
        //             System.out.println("j: " + j);
        //             if (j >= 0) {
        //                 r[i] = n-1 - j - (j == idx ? 1 : 0);
        //                 idx = (j == n-1 ? 0 : j+1); // idx 完全没有开始
        //                 t = a[idx];
        //             } else {
        //                 idx = -1 * j - 1;
        //                 r[i] = n-1 - idx + 1; 
        //                 System.out.println("idx 二: " + idx + " " + "i: " + i + "; r[i]: " + r[i]); // <<<<<<<<<<<<<<<<<<<<
        //                 if (idx == n) {
        //                     idx = 0; t = a[idx];
        //                     // r[i] = 0;
        //                 } else 
        //                     t = (int)(p[idx] - (long)b[i]); // <<<<<<<<<<<<<<<<<<<< 
        //             }
        //         }
        //     }
        //     return r;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int countRatioSubarrays(int[] a, int x, int y) { // TLE TLE TLE: Time Limit Exceeded 561 / 601 testcases passed
        //     int n = a.length, r = 0;
        //     int [] f = new int [n];
        //     f[0] = (a[0] % 2 == 1 ? 1 : 0);
        //     for (int i = 1; i < n; i++)
        //         if (a[i] % 2 == 1)
        //             f[i] = f[i-1] + 1;
        //         else f[i] = f[i-1];
        //     for (int i = 0; i < n; i++)
        //         for (int j = i; j < n; j++) {
        //             int o = f[j] - (i == 0 ? 0 : f[i-1]), e = j - i + 1 - o;
        //             if (o > 0 && (long)e * y <= (long)x * o)
        //                 r++;
        //         }
        //     return r;
        // }
    }    // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！ 
    public static void main (String[] args) { 
        Solution s = new Solution (); 

        int [] r = s.countTasks(a, b);
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