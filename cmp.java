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

        // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        public int maxTotalValue(int[] value, int[] decay, int m) {
        }
    }    // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！ 
    public static void main (String[] args) { 
        Solution s = new Solution (); 

        int [][] a = new int [][] {{3,2,9451},{2,0,1125},{2,3,3227},{2,0,2859},{0,1,8},{1,2,8},{2,3,8}};

        int r = s.shortestPath(4, a, "abab", 1);
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
