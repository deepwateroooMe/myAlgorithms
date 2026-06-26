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
    }    // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！ 
    public static void main (String[] args) { 
        Solution s = new Solution (); 

        int [][] a = new int [][] {{0,1},{1,2}};
        int [] b = new int [] {9, 5, 3};

        long r = s.finishTime(3, a, b);
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
