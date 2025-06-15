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
public class cmp {
    public static class Solution {

        // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int maxSubstrings(String S) {
        //     n = S.length(); s = S.toCharArray();
        //     int [] a = new int [26]; r = new int [n];
        //     Arrays.fill(a, -1); Arrays.fill(r, -1);
        //     f = new Integer [n];
        //     for (int i = n-1; i >= 0; i--) {
        //         int j = s[i]-'a';
        //         if (a[j] == -1) {
        //             a[j] = i;
        //             continue;
        //         }
        //         r[i] = a[j];
        //         a[j] = i;
        //     }
        //     return dfs(0);
        // }
        // Integer [] f; int [] r;
        // char [] s;
        // int n;
        // int dfs(int i) {
        //     if (i == n) return 0;
        //     if (f[i] != null) return f[i];
        //     int j = i;
        //     while (j < n && r[j] != -1 && r[j] - i < 3) j = r[j];
        //     int ans = dfs(i+1);
        //     if (j < n && r[j] != -1) {
        //         ans = Math.max(ans, 1 + dfs(r[j] + 1));
        //         for (int k = i+2; k <= r[j]; k++) 
        //             ans = Math.max(ans, dfs(k));
        //     }
        //     return f[i] = ans;
        // }        

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // static final int mod = (int)1e9 + 7;
        // public int assignEdgeWeights(int[][] egs) {
        //     n = egs.length + 1;
        //     g = new ArrayList [n+1];
        //     Arrays.setAll(g, z -> new ArrayList<Integer>());
        //     for (int [] e : egs) {
        //         int u = e[0], v = e[1];
        //         g[u].add(v);
        //         g[v].add(u);
        //     }
        //     dfs(1, -1, 0);
        //     System.out.println("d: " + d);
        //     f = new Integer [d][2];
        //     return dfsMemory(0, 1);
        // }
        // List<Integer> [] g;
        // int n, d;
        // Integer [][] f;
        // int dfsMemory(int i, int j) {
        //     if (f[i][j] != null) return f[i][j];
        //     if (i == d-1) return f[i][j] = 1;
        //     return f[i][j] = 2 * dfsMemory(i+1, 1-j) % mod;
        // }        
        // void dfs(int u, int p, int h) {
        //     if (g[u].size() == 1 && g[u].get(0) == p) {
        //         d = Math.max(d, h);
        //         return ;
        //     }
        //     for (int v : g[u]) {
        //         if (v == p) continue;
        //         dfs(v, u, h+1);
        //     }
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // （无向图）变【有向图】：查找最近公共祖先，计算任意两节点间的、最短距离
        // // 【记忆化深搜】：是（自底向上）的；得写【动规】：（自顶向下），方便提取任意距离的结果
        // // 不知道哪里细节写错了，改天再写。。。
        // static final int mod = (int)1e9 + 7;
        // public int [] assignEdgeWeights(int[][] egs, int [][] qs) {
        //     n = egs.length + 1; int m = qs.length;
        //     gr = new HashSet [n+1];
        //     Arrays.setAll(gr, z -> new HashSet<Integer>());
        //     for (int [] e : egs) {
        //         int u = e[0], v = e[1];
        //         gr[u].add(v);
        //         gr[v].add(u);
        //     }
        //     // 变（无向图）为【有向图】；同步纪录【最近公共祖先】，定义是：子节点 v 的第2^j 个祖先 = 父节点 u 的第 2^j-1 级祖先的、第2^j-1 级祖先
        //     // 定义： f[v][j] = f[f[u][2]
        //     g = new int [n+1][16];
        //     d = new int [n+1];
        //     dfs(1, -1, 0);
        //     System.out.println(Arrays.toString(d));
        //     // 纪录【最近公共祖先】: 亲爱的表哥的活宝妹，好像这里哪里写错了。。
        //     g[1][0] = 1;
        //     // for (int i = 1; i <= n; i++)
        //     //     g[i][0] = i;
        //     dfsLCA(1);
        //     // 【动规】：（自顶向下）求结果
        //     int maxDepth = Arrays.stream(d).max().getAsInt();
        //     f = new Integer [maxDepth+1][2];
        //     // return dfsMemory(0, 1);
        //     f[0][0] = 1; // 2
        //     f[0][1] = 1; // 1
        //     for (int i = 1; i <= maxDepth; i++) 
        //         for (int j = 0; j < 2; j++) 
        //             f[i][j] = (f[i-1][1-j] + f[i-1][j]) % mod;
        //     int [] r = new int [m];
        //     for (int i = 0; i < m; i++) {
        //         int u = qs[i][0], v = qs[i][1], h = getShortestPath(u, v);
        //         System.out.println("u: " + u + " " + "v: " + v);
        //         System.out.println("h: " + h);
        //       r[i] = f[h][1];
        //     }
        //     return r;
        // }
        // Set<Integer> [] gr;
        // Integer [][] f;
        // int [][] g;
        // int [] d;
        // int n;
        // // 根据【最近公共祖先】求（有向图）上，任意两节点间的【最短距离】
        // int getShortestPath(int u, int v) {
        //     int p = LCA(u, v);
        //     System.out.println("p: " + p);
        //     return d[u] + d[v] - 2 * d[p];
        // }
        // int LCA(int u, int v) {
        //     // 强制 d[u] >= d[v]
        //     int tmp = u;
        //     u = (d[u] >= d[v] ? u : v);
        //     v = (u == tmp ? v : u);
        //     // 【最快节奏】地跳，将 U V 同层
        //     for (int i = 15; i >= 0; i--) 
        //         if (d[g[u][i]] >= d[v])
        //             u = g[u][i];
        //     System.out.println("LCA u: " + u + " " + "v: " + v);
        //    if (u == v) return v;
        //     // U V 同层后，共同同步往上跳，
        //     // 否则将a和b同时向上跳，直到跳到最近公共祖先下一层为止
        //     for (int k = 15; k >= 0; k--)
        //         if (g[u][k] != g[v][k]) {
        //             u = g[u][k];
        //             v = g[v][k];
        //         }
        //     return g[u][1];
        // }
        // void dfsLCA(int u) { // 自顶向下：从父节点遍历子节点
        //     for (int v : gr[u]) {
        //         for (int j = 1; g[u][j-1] > 0; j++) // 穷追塑源：一直找到整棵树的根节点：1
        //             g[v][j] = g[g[u][j-1]][j-1];
        //     }
        //     for (int v : gr[u]) 
        //         dfsLCA(v);
        // }
        // void dfs(int u, int p, int h) {
        //     d[u] = h;
        //     if (gr[u].size() == 1 && gr[u].contains(p)) {
        //         gr[u].remove(p);
        //         // d = Math.max(d, h);
        //         return ;
        //     }
        //     for (int v : gr[u]) {
        //         if (v == p) 
        //             continue;
        //         dfs(v, u, h+1);
        //     }
        //     gr[u].remove(p);
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 感觉大致思路清晰，但离解题、最后一个细节思路，还差最后一步、才算能写完整。。现在最后2 个题目都没能想透彻写完整。。
        // public String lexicographicallySmallestString(String S) {
        //     n = S.length(); s = S.toCharArray(); this.S = S; 
        //     f = new StringBuilder [n][n];
        //     return dfs(0, n-1).toString();
        // }
        // StringBuilder [][] f;
        // char [] s; String S;
        // int n;
        // // 过程中的细节，有出错，需要再写。。。
        // StringBuilder dfs(int i, int j) {
        //     System.out.println("\ni: " + i + " " + "j: " + j);
        //     if (f[i][j] != null) return f[i][j];
        //     if (i == j) {
        //         f[i][j] = new StringBuilder();
        //         f[i][j].append(s[i]); // <<<<<<<<<<<<<<<<<<<< 
        //         System.out.println("f[i][j]: " + f[i][j]);
        //         return f[i][j];
        //     }
        //     if (i+1 == j)
        //         return ((Math.abs(s[i] - s[j]) == 1
        //                 || s[i] == 'z' && s[j] == 'a'
        //                  || s[i] == 'a' && s[j] == 'z') ? new StringBuilder("") : new StringBuilder(S.substring(i, j+1)));
        //     StringBuilder r = new StringBuilder(S.substring(i, j+1)), cur = new StringBuilder("");
        //     System.out.println("\nr0: " + r);
        //     int k = i+1;
        //     if (Math.abs(s[i] - s[k]) == 1
        //         || s[i] == 'z' && s[k] == 'a'
        //         || s[i] == 'a' && s[k] == 'z') {
        //         cur = dfs(i+2, j);
        //         System.out.println("cur M: " + cur.toString());
        //         if (cur.compareTo(r) < 0)
        //             r = cur;
        //     }
        //     cur.setLength(0);
        //     cur.append(s[i]);
        //     cur.append(dfs(i+1, j));
        //     System.out.println("cur Outside: " + cur);
        //     while (cur.length() >= 2 && (Math.abs(cur.charAt(0) - cur.charAt(1)) == 1
        //                               || cur.charAt(0) == 'z' && cur.charAt(1) == 'a'
        //                               || cur.charAt(0) == 'a' && cur.charAt(1) == 'z')) {
        //         cur.deleteCharAt(1);
        //         cur.deleteCharAt(0);
        //     }
        //     System.out.println("cur Outside 2: " + cur);
        //     // 【TODO：】过程中结果，可以是大的；要最终结果，是最小的。。
        //     if (cur.compareTo(r) < 0) r = cur;
        //     System.out.println("\ni: " + i + " " + "j: " + j);
        //     System.out.println("r: " + r);
        //     return f[i][j] = r;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【树型动规】: 亲爱的表哥的活宝妹，这里没能想对，是【树上背包】。。因为没能想到是【背包问题】，所以就写得狠乱了。。
        // public int maxProfit(int n, int[] p, int[] nt, int[][] h, int b) {
        //     // 【有向图】：标记，上下司关系，树
        //     g = new ArrayList [n];
        //     Arrays.setAll(g, z -> new ArrayList<Integer>());
        //     for (int [] e : h) {
        //         int u = e[0], v = e[1];
        //         g[u].add(v);
        //     }
        //     // 【树型动规】：亲爱的表哥的活宝妹，先写【记忆化深搜】
        //     this.n = n; this.p = p; this.f = f; this.b = b;
        //     // 【TODO：】状态压缩：【第2 和第3 维：0/1】标记、上司与自己，买与不买；定义重复，只需要知道【上司】是否买就可以了。。
        //     f = new Integer [n][2][2][b+1]; // 【第2 和第3 维：0/1】标记、上司与自己，买与不买
        //     return Math.max(dfs(0, 0, 0, b), dfs(0, 1, 0, b));
        // }
        // List<Integer> [] g;
        // int [] p, nt; 
        // int n, b;
        // Integer [][][] f;
        // // 【自顶向下】: 好像写不出；得写（自底向上）？好像【自底向上】更好写 ==> 确实是【自底向上的、树上背包】，离解题还差相对比较关键的、【背包问题】相关的思路
        // int dfs(int i, int j, int k, int v) {
        //     if (f[i][j][k][v] != null) return f[i][j][k][v];
        //     int half = Math.floor(p[i] / 2);
        //     // 在设置前提下：【自己买不买、上司买没买、余额限定】(自己)当前，能够收获的利益。。
        //     int r = (j == 1 ? (k == 1 ? (half <= v ? nt[i] - half) : (p[i] <= v ? nt[i] - p[i] : 0)) : 0);
        //     boolean doBuy = (j == 1 && (k == 1 && half <= v || k == 0 && p[i] <= v));
        //     if (g[i].size() == 0) 
        //         return f[i][j][k][v] = r;
        //     // 【树型动规】：遍历子节点
        //     // 这里多一步的【筛选】：众多下司、总投资金额有限，哪些下司买，哪些不买？？？
        //     // 【TODO：】亲爱的表哥的活宝妹，动规的这一维、【总金额限定】在多个子节点中的分配，还没能想透彻，先写后一题目。。
        //     // 如果，把树、众多子节点按【重链排序】：如按（赢利/投资）从大到小排序。。这里的思路不清楚。。。
        //     for (int mes : g[i]) {
        //         // 不买
        //         int l = dfs(mes, 0, (j == 1 && doBuy ? 1 : 0), v - (doBuy ? (k == 1 ? half : p[i]) : 0));
        //         // 买
        //         int r = dfs(mes, 1, (j == 1 && doBuy ? 1 : 0), v - (doBuy ? (k == 1 ? half : p[i]) : 0));
        //         r += dfs(mes, )
        //             }
        //     return f[i][j][k][v] = r;
        // }
        // // 亲爱的表哥的活宝妹，参照别人的题解，重新自己再写一遍
        // // 知道是【树上背包】后，感觉解这个题目、就再也没有难度了。。。就是需要自己再手写出来一遍
        // // 【树上背包】。。因为没能想到是【背包问题】，所以就写得狠乱了。。
        // // 亲爱的表哥的活宝妹，今天晚上回住处前，需要把这个题目，想透彻、写会！！
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int maxProfit(int n, int[] p, int[] nt, int[][] h, int b) { // [1,n]==>[0,n-1]
        //     // 【有向图】：标记，上下司关系，树
        //     g = new ArrayList [n];
        //     Arrays.setAll(g, z -> new ArrayList<Integer>());
        //     for (int [] e : h) {
        //         int u = e[0]-1, v = e[1]-1;
        //         g[u].add(v);
        //     }
        //     // 【树型动规】：亲爱的表哥的活宝妹，先写【记忆化深搜】
        //     this.n = n; this.p = p; this.f = f; this.b = b;
        //     // f = new Integer [n][2][2][b+1]; // 【第2 和第3 维：0/1】标记、上司与自己，买与不买
        //     // return Math.max(dfs(0, 0, 0, b), dfs(0, 1, 0, b));
        //     return dfs(0);
        // }
        // List<Integer> [] g;
        // int [] p, nt; 
        // int n, b;
        // // 【TODO：】亲爱的表哥的活宝妹，感觉这里写得、抄得还是狠不透彻、、傍晚回来再弄。。
        // int dfs(int u) { // U: 树节点； i:budget 预算； j: 上司买与不买
        //     // 定义：u 的所有儿子子树 v 的最大利润总和 subF[j][k]。
        //     int [][] subF = new int [b+1][2];
        //     for (int v : g[u]) {
        //         // 【当前子节点】：买与不买的、【自底向上】返回的结果
        //         int [][] fv = dfs(v);
        //         // for (int x = 0; x <= b; x++) {
        //         for (int x = b; x >= 0; x--) {
        //             // // 【当前、子节点】：买与不买的预算
        //             // int cv = p[v] / (y + 1);
        //             // 【树上背包】：0/1 背包【当前子节点】，买与不买...
        //             // 枚举子树 v 的预算为 fy
        //             // 当作一个体积为 fy，价值为 fv[fy][k] 的物品
        //             for (int fy = 0; fy <= x; fy++) { // 【当前子节点】：买，与不买，取全局最大值
        //                 for (int y = 0; y < 2; y++) {
        //                     subF[x][y] = Math.max(subF[x - fy][y] + fv[fy][y], subF[x][y]);
        //                 }
        //             }
        //         }
        //     }
        //     // 当前【父节点 u】：
        //     int [][] f = new int [b+1][2];
        //     // 【当前、父节点】：买与不买的预算
        //     int cost = p[u] / (j + 1);
        //     for (int x = b; x >= 1; x--) 
        //         for (int y = 0; y < 2; y++) 
        //             // 【上司节点】：买，与不买，取最大值
        //             f[x][y] = Math.max(subF[x - cost][1] + nt[u] - p[u], subF[x][0]);
        //     return f[i][j];
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public boolean checkEqualPartitions(int[] f, long target) {
        //     long r = 1;
        //     for (int v : f) 
        //         r *= (long)v;
        //     if (r != target * target) return false;
        //     for (int j = 0; j < (1 << f.length); j++) {
        //         r = 1;
        //         for (int i = 0; i < f.length; i++) 
        //             if ((j & (1 << i)) > 0)
        //                 r *= (long)f[i];
        //         if (r == target * target) return true;
        //     }
        //     return false;
        // }

        // // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // // 思路，应该是把【距阵问题】转化成【图】？
        // // public int minMoves(String[] classroom, int energy) {
        // // }
        // // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // // 数组大小N[1,50000] 感觉这个，实时更新是要用到BIT 的
        // // // 但是 100,000 以内的质数，就只能查个质数 Set<Integer> s = new HashSet<>();
        // // public int[] maximumCount(int[] nums, int[][] queries) {
        // // }
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 就是【二维数组】上的相结动规，可是细节狠繁琐，不想再找这个错误掉的细节了。。。
        // public int[][] minAbsDiff(int[][] a, int k) {
        //     int m = a.length, n = a[0].length;
        //     if (k == 1) return new int [m][n];
        //     int [][] f = new int [m+1-k][n+1-k];
        //     r = new TreeMap<>();
        //     for (int i = 0; i < k-1; i++)
        //         for (int j = 0; j < k-1; j++) 
        //             r.put(a[i][j], r.getOrDefault(a[i][j], 0) + 1);
        //     for (int i = 0; i < m+1-k; i++) {
        //         // 【每一新行】：前【0,k-2】下标的数字
        //         for (int j = 0; j < k-1; j++) 
        //             r.put(a[i+k-1][j], r.getOrDefault(a[i+k-1][j], 0) + 1); 
        //         for (int j = 0; j <= n-k; j++) {
        //             // 【清理】：前一列【j-1】，行数为【i,i+k-1】
        //             if (j > 0) {
        //                 for (int x = i; x < i+k && x < m; x++) {
        //                     r.put(a[x][j-1], r.get(a[x][j-1])-1); 
        //                     if (r.get(a[x][j-1]) == 0) r.remove(a[x][j-1]);
        //                 }
        //             }
        //             // 新增：第【j+k-1】列，行数为【i,i+k-1】
        //             for (int x = i; x < i+k && x < m; x++) 
        //                 r.put(a[x][j+k-1], r.getOrDefault(a[x][j+k-1], 0) + 1);
        //             f[i][j] = getMinAbsDiff();
        //         }
        //         // 【每一旧行】：前【0,k-2】下标的数字
        //         if (i == 0) continue;
        //         // 清理上一行的存值 
        //         for (int j = n-k; j < n; j++) {
        //             r.put(a[i-1][j], r.get(a[i-1][j])-1);
        //             if (r.get(a[i-1][j]) == 0) r.remove(a[i-1][j]);
        //         }
        //     }
        //     return f;
        // }
        // TreeMap<Integer, Integer> r;
        // int getMinAbsDiff() {
        //     int f = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        //     for (int key : r.keySet()) {
        //         if (f == Integer.MIN_VALUE) {
        //             f = key;
        //             continue;
        //         }
        //         min = Math.min(min, Math.abs(key - f));
        //         f = key;
        //     }
        //     return min;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【TODO：】什么狗屁的细节地方，写错了，晚点儿再检查
        // public int maxSumDistinctTriplet(int[] a, int[] b) {
        //     int n = a.length, max = -1, idx = 0;
        //     Set<Integer> s = new HashSet<>(Arrays.stream(a).boxed().collect(Collectors.toList()));
        //     Set<Integer>[] m = new HashSet[s.size()];
        //     Arrays.setAll(m, z -> new HashSet<Integer>());
        //     Map<Integer, Integer> iis = new HashMap<>();
        //     s.clear();
        //     for (int i = 0; i < n; i++) 
        //         if (!s.contains(a[i])) {
        //             iis.put(a[i], idx);
        //             m[idx++].add(i);
        //             s.add(a[i]);
        //         } else 
        //             m[iis.get(a[i])].add(i);
        //     int ii = 0, jj = 0, kk = 0;
        //     for (int v = 0; v < (1 << m.length); v++) {
        //         if (Integer.bitCount(v) != 3) continue;
        //         for (int i = m.length-1; i > 0; i--) {
        //             if ((v & (i << 1)) > 0) {
        //                 ii = i;
        //                 for (int j = i-1; j > 0; j--) 
        //                     if ((v & (j << 1)) > 0) {
        //                         jj = j;
        //                         for (int k = j-1; k > 0; k--) 
        //                             if ((v & (k << 1)) > 0) {
        //                                 kk = k;
        //                                 for (int x : m[ii])
        //                                     for (int y : m[jj]) 
        //                                         for (int z : m[kk]) {
        //                                             System.out.println("x: " + x + " " + "y: " + y + " z: " + z);
        //                                             max = Math.max(max, b[x] + b[y] + b[z]);
        //                                         }
        //                             }
        //                     }
        //             }
        //         }
        //     }
        //     return max;
        // }

//         // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//         // 这个【股票】问题，是好红典的题型，可是亲爱的表哥的活宝妹，不确定自己是否还记得（背答案）这个题目的解法？？？
//         // 不要想复杂了，用个【贪心】，超过 k 次交易，再减去一些利润？
//         public long maximumProfit(int[] a, int k) {
//             int n = a.length;
//             TreeMap<Integer, Integer> m = new TreeMap<>();
//             int [] l = new int [n+1], r = new int [n+1];
//             for (int i = 1; i <= n; i++) 
// l[i] = l[i-1] + 
//         }
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public long maxGCDScore(int[] nums, int k) {
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【自底向上】遍历树，像是【树型动规】，可是又与普通一般【树形动规】涉及子集与组合的部分，不一样。。
        // // 亲爱的表哥的活宝妹，笨宝妹在想：这个要死不要活的破烂题目，同亲爱的表哥的活宝妹上个周末？【树上背包】问题，有什么不同？
        // // 不是【0/1 背包】、不是【完全背包】、是【集合的全局最值、集合与子集】上的动规。。
        // // 【0-9】10 个数位，任何可能组合的【最大值】动规。。
        // // 感觉，这个破烂题目还是狠简单的。。
        // // 不知道哪里细节写错了，傍晚再试着检查一下。。。
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // static final int mod = (int)1e9 + 7;
        // public int goodSubtreeSum(int[] a, int[] p) {
        //     n = a.length; nn = 10; this.a = a; 
        //     // 【有向图：树】说是无向图，但实际是（有向图）
        //     g = new ArrayList [n];
        //     Arrays.setAll(g, z -> new ArrayList<Integer>());
        //     for (int i = 1; i < n; i++) 
        //         g[p[i]].add(i);
        //     // 【背字典】：每个节点，背个字典，记住以【当前节点】为（根节点），（最大，任何？）的【0-9 及存在组合】的值
        //     m = new HashMap[n];
        //     Arrays.setAll(m, z -> new HashMap<Integer, Integer>());
        //     f = new Long [n];
        //     dfs(0);
        //     int r = 0;
        //     for (int i = 0; i < n; i++)
        //         r = (int)(((long)(r + f[i])) % mod);
        //     return r;
        // }
        // List<Integer> [] g;
        // int n, nn;
        // // 【背字典】：每个节点，背个字典，记住以【当前节点】为（根节点），（最大，任何？）的【0-9 及存在组合】的值
        // // 也就是，【每个节点的、字典】最多丰储（1<<10）个銉
        // Map<Integer, Integer> [] m;// 每个 Key: 代表 key 组合，所有可能组合里的最大值！！所以可以动规。。
        // Long [] f;
        // int [] a;
        // long dfs(int u) {
        //     // 【叶子节点】：最值固定
        //     if (g[u].size() == 0) {
        //         int binaryKey = getBinaryRepresentation(a[u]);
        //         m[u].put(binaryKey, a[u]);
        //         return f[u] = (long)a[u];
        //     }
        //     // 【非叶子节点】：集合，每个 Key: 代表 key 组合，所有可能组合里的最大值！！所以可以动规。。
        //     // 集合与子集的遍历，是怎么遍历来着？？？亲爱的表哥的活宝妹，去胀午餐，回头再想这个破烂题目。。
        //     // 【当前父节点】：复制、或（优化）取所有子节点中（1<<10）个不同键值的、所有子节点中的最优值；并结合自己的值，在当前父节点层面进一步优化
        //     // O(1<<10 * (1<<10) * N[1,500]) 应该不会超时
        //     for (int v : g[u]) {
        //         // 遍历：所有【子节点】
        //         dfs(v);
        //         // 整合：所有【子节点】中，各子节点中已经存在的键值的、最优解
        //         for (Map.Entry<Integer, Integer> en : m[v].entrySet()) {
        //             int k = en.getKey(), val = en.getValue();
        //             if (m[u].containsKey(k))
        //                 m[u].put(k, Math.max(m[u].get(k), val));
        //             else m[u].put(k, val);
        //         }
        //     }
        //     // 【父节点】：整合自己的值，更新以【当前父节点】为根的（全局最优解）
        //     // 【TODO：】感觉这里面还有机关，没想透彻。。。胀晚餐时再想一想
        //     int binaryKey = getBinaryRepresentation(a[u]);
        //     if (m[u].containsKey(binaryKey))
        //         m[u].put(binaryKey, Math.max(m[u].get(binaryKey), a[u]));
        //     else m[u].put(binaryKey, a[u]);
        //     // 【TODO：】更新已要存在的 k, 不能仅只更新 m[u] 里的键值；？？
        //     Map<Integer, Integer> t = new HashMap<>(m[u]);
        //     for (Map.Entry<Integer, Integer> en : m[u].entrySet()) {
        //         int k = en.getKey(), val = en.getValue();
        //         // 【父节点】层面，根据父节点 a[u] 的值，当前层面全部更新
        //         for (int kk : m[u].keySet()) {
        //             if (k == kk) continue;
        //             // if ((k & kk) == 0 && m[u].containsKey(k ^ kk))
        //             // 引入新键，用新键更新，所有其它可能的、合法组合健
        //             if ((k & kk) == 0) { 
        //                 int v = (k | kk);
        //                 // 不管 m[u] 存不存在 v, 存最优值；先前不存在就创建新键
        //                 // m[u].put(v, Math.max(m[u].getOrDefault(v, 0), a[u] + m[u].get(kk)));
        //                 t.put(v, Math.max(m[u].getOrDefault(v, 0), a[u] + m[u].get(kk)));
        //             // 引入更新值，用更优的键值，来更新，所有其它可能的、合法组合健
        //             } else if ((k & kk) == k) { //m[u] 中，来自于子节点的键中，早就存在键 a[u] ＝ binaryKey(a[u])
        //                 int v = kk - k; // 此健， m[u] 中，来自于其子节点，一定已经存在的？？？怎么确认？
        //                 // 用更优的、来自【当前父节点a[u] 】的值，更新来子节点的、非当前父节点全局最优的 kk 的值
        //                 // m[u].put(kk, Math.max(m[u].get(kk), val + m[u].get(v)));
        //                 t.put(kk, Math.max(m[u].get(kk), val + m[u].get(v)));
        //             }
        //         }
        //     }
        //     m[u] = t;
        //     return f[u] = (long)Collections.max(m[u].values());
        // }
        // int getBinaryRepresentation(int v) {
        //     int f = 0;
        //     for (char c : String.valueOf(v).toCharArray())
        //         f |= (1 << (c - '0'));
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public boolean canMakeEqual(int[] a, int k) {
        //     int n = a.length, i = 0, r = k, sum = 0;
        //     boolean f = false;
        //     // 试一遍：全变成 1
        //     i = 0;
        //     while (i < n-1 && r >= 0) {
        //         if (a[i] == -1 && f) {
        //             sum += a[i] * (-1);
        //             f = false;
        //             i++;
        //             continue;
        //         }
        //         if (a[i] == -1) {
        //             f = true;
        //             sum += a[i] * (-1);
        //             --r;
        //         } else if (a[i] == 1 && f) {
        //             sum += a[i];
        //             --r;
        //         }
        //         i++;
        //     }
        //     if (i == n-1 && r >= 0 && (a[i] == 1 && !f || a[i] == -1 && f)) return true;
        //     // 试一遍：全变成 -1
        //     i = 0; r = k; sum = 0; f = false;
        //     while (i < n-1 && r >= 0) {
        //         if (a[i] == -1 && f) {
        //             sum += a[i];
        //             --r;
        //             i++;
        //             continue;
        //         }
        //         if (a[i] == 1 && !f) {
        //             f = true;
        //             sum += a[i] * (-1);
        //             --r;
        //         } else if (a[i] == 1) {
        //             sum += a[i] * (-1);
        //             f = false;
        //         }
        //         i++;
        //     }
        //     if (i == n-1 && r >= 0 && (a[i] == 1 && f || a[i] == -1 && !f)) return true;
        //     return false;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，读不懂这个题目在说什么，先看其它题目
        // public int countPermutations(int[] complexity) {
        //     return 0;
        // }
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int minOperations(String word1, String word2) {
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【思路不对】：好像有狠多统计重复的地方。。。
        // static final int mod = (int)1e9 + 7;
        // public int countPartitions(int[] a, int k) {
        //     n = a.length; this.v = k; this.a = a; 
        //     f = new Integer [n][n];
        //     return dfs(0, n-1);
        // }
        // Integer [][] f;
        // int n, v; int [] a;
        // // 【思路不对】：好像有狠多统计重复的地方。。。
        // int dfs(int i, int j) {
        //     System.out.println("i: " + i + " " + "j: " + j);
        //     // if (i > j) return 0;
        //     if (i == j) return f[i][j] = 1;
        //     if (f[i][j] != null) return f[i][j];
        //     if (i+1 == j) {
        //         f[i][j] = (Math.max(a[i], a[j]) - Math.min(a[i], a[j]) <= v ? 2 : 1);
        //         System.out.println("i: " + i + " " + "j: " + j + " r: " + f[i][j]);
        //         return f[i][j];
        //     }
        //     int r = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        //     // 这里面，有细节错误。。【TODO：】
        //     for (int k = i; k < j; k++) {
        //         System.out.println("k: " + k);
        //         min = Math.min(min, a[k]);
        //         max = Math.max(max, a[k]);
        //         if (max - min <= v)
        //             r = (r + dfs(i, k) * dfs(k+1, j)) % mod;
        //         else {
        //             r = (r + dfs(i, k-1) * dfs(k, j)) % mod;
        //             break;
        //         }
        //     }
        //     System.out.println("i: " + i + " " + "j: " + j + " r: " + r);
        //     return f[i][j] = r;
        // }
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【动规】：
        // static final int mod = (int)1e9 + 7;
        // public int countPartitions(int[] a, int k) {
        //     int n = a.length;
        //     // 数据【预处理】：以每个下标 a[i] 为【最大值】【最小值】，（向左）可延伸的最远最小下标。。
        //     // 亲爱的表哥的活宝妹，这里【数据预处理】的思路是好的，可是感觉这里脑袋昏昏，实现方法细节未必对。。
        //     // l: 当前下标为【最小值】； r: 当前下标为（最大值）
        //     int [] l = new int [n+1], r = new int [n+1];
        //     ArrayDeque<Integer> s = new ArrayDeque<>();
        //     // 【降序排列】双端队列： l: 当前下标为【最小值】
        //     Arrays.fill(l, -1); // <<<<<<<<<<<<<<<<<<<< 对吗？
        //     for (int i = 0; i < n; i++) {
        //         if (s.isEmpty()) {
        //             s.offerFirst(i);
        //             continue;
        //         }
        //         // 去除：队头【超大非法值】
        //         while (!s.isEmpty() && a[s.peekFirst()] - a[i] > k)
        //             s.pollFirst();
        //         l[i+1] = (s.isEmpty() ? i : s.peekFirst());
        //         // 去除：队尾【小于当前 a[i] 的值】，以维护（降序排列）
        //         while (!s.isEmpty() && a[s.peekLast()] <= a[i])
        //             s.pollLast();
        //         // 【当前下标】：入队列
        //         s.offerLast(i);
        //     }
        //     System.out.println(Arrays.toString(l));
        //     // 【降序排列、倒序遍历】双端队列： l: 当前下标为【最大值】
        //     Arrays.fill(r, n);
        //     for (int i = n-1; i >= 0; i--) {
        //         if (s.isEmpty()) {
        //             s.offerFirst(i);
        //             continue;
        //         }
        //         // 去除：队头【超大非法值】
        //         while (!s.isEmpty() && a[s.peekFirst()] - a[i] > k)
        //             r[s.pollFirst()] = i+1;
        //         // 去除：队尾【小于当前 a[i] 的值】，以维护（降序排列）
        //         while (!s.isEmpty() && a[s.peekLast()] <= a[i])
        //             s.pollLast();
        //         // 【当前下标】：入队列
        //         s.offerLast(i);
        //     }
        //     System.out.println(Arrays.toString(r));

        //     // 【状态定义】：到下标 i, 把【0,i】划分成 j 个有效段的方法数
        //     int [][] f = new int [n+1][k+1];
        //     // for (int i = 0; i <= n; i++) 
        //     //     f[i][0] = 1;
        //     f[0][0] = 1;
        //     for (int i = 1; i <= n; i++) {
        //         // 每个下标，单独成一个子数组
        //         // f[i] = (f[i] + f[i-1]) % mod;
        //         // 【当前下标 i-1】：合并到先前由下标[0,i-2] 所构成的第 [i-1,i-2,i-3...3,2,1] 段的可能性、方法数
        //         // 【TODO：】想要使用（当前下标）为最大值最小值，来一定程度上约束缩小 j 可能遍历到的最小值，实现一点儿优化
        //         for (int j = i-1; j > 0; j--) {
        //             // 这里想得不透彻，暂时不写了。。
        //             // 【TODO：】感觉，遍历 i 时，需要【滑动窗口】维护一个以（当前下标 a[i] 值）为最大最小值的2 个不同窗口，来优化求解 f[i][j]
        //         }
        //     }
        //     return 0;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public String generateTag(String S) {
        //     S = S.trim();
        //     if (S.length() == 0) return "#";
        //     String [] s = S.split("\\s+");
        //     int i = 1, idx = 1;
        //     StringBuilder sb = new StringBuilder("#");
        //     for (int j = 0; j < s.length && i < 100; j++) {
        //         if (j == 0) 
        //             sb.append(Character.toLowerCase(s[j].charAt(0)));
        //         else 
        //             sb.append(Character.toUpperCase(s[j].charAt(0)));
        //         ++i;
        //         idx = 1;
        //         while (i < 100 && idx < s[j].length()) {
        //             sb.append(Character.toLowerCase(s[j].charAt(idx++)));
        //             ++i;
        //         }
        //     }
        //     return sb.toString();
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public long maximumProduct(int[] a, int m) {
        //     int n = a.length;
        //     long f = Long.MIN_VALUE;
        //     // 【自右往左】：到当前下标 i 的（最小值）与（最大值）
        //     int [] l = new int [n+1], r = new int [n+1];
        //     l[n] = Integer.MAX_VALUE; r[n] = Integer.MIN_VALUE;
        //     for (int i = n-1; i >= m-1; i--) {
        //         l[i] = Math.min(l[i+1], a[i]);
        //         r[i] = Math.max(r[i+1], a[i]);
        //     }
        //     System.out.println(Arrays.toString(l));
        //     System.out.println(Arrays.toString(r));
        //     // 【自左向右、遍历：左端点】：
        //     for (int i = 0; i <= n-m; i++) {
        //         if (a[i] >= 0) f = Math.max(f, (long)a[i] * r[i+m-1]);
        //         else f = Math.max(f, (long)a[i] * l[i + m-1]);
        //     }
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // static final int mod = (int)1e9 + 7;
        // public int specialTriplets(int[] a) {
        //     int n = a.length;
        //     TreeMap<Integer, TreeMap<Integer, Integer>> m = new TreeMap<>();
        //     for (int i = 0; i < n; i++) {
        //         if (!m.containsKey(a[i])) {
        //             m.put(a[i], new TreeMap<Integer, Integer>());
        //             // 【a[i]>=0】（从左到右）
        //             m.get(a[i]).put(i, 0);
        //             continue;
        //         }
        //         m.get(a[i]).put(i, m.get(a[i]).lastEntry().getValue() + 1);
        //     }
        //     long f = 0;
        //     // 【自左向右】：遍历下标 j, 数其左端与右端值为 2 × a[j] 的数的个数
        //     for (int i = 1; i < n-1; i++) {
        //         int v = a[i] * 2;
        //         if (!m.containsKey(v)) continue;
        //         Integer l = m.get(v).lowerKey(i);
        //         if (l == null || l > i) continue;
        //         int r = m.get(v).lastEntry().getValue() - m.get(v).get(l) - (v == a[i] ? 1 : 0);
        //         f = (f + (long)(m.get(v).get(l)+1) * r) % mod;
        //     }
        //     return (int)f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 这个题目，目前一时半会儿没有思路
        // // 今天晚上的比赛题目，前3 题都太简单，写得终究是没什么意思。。可是最后一个相对难的，亲爱的表哥的活宝妹一时半会儿也还是没有思路
        // // 等亲爱的表哥的活宝妹慢慢进化到可以、能够写出这类题目。。
        // public int[] findMedian(int n, int[][] egs, int[][] qs) {
        //     g = new ArrayList [n];
        //     Arrays.setAll(g, z -> new ArrayList<int []>());
        //     return new int [0]{};
        // }
        // List<int []> [] g;
        // int n;
    }
// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！ 
        public static void main (String[] args) { 
		Solution s = new Solution ();

        long r = s.specialTriplets(a);
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
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】