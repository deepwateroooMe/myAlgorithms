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

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public long maxArea(int[][] a) {
        //     int n = a.length, i = 1, j = 0, len = 0;
        //     // 【X 轴升序排列】：求，平行于Y 轴，最大山角形面积
        //     long f = -1;
        //     Arrays.sort(a, (x, y)->x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]); 
        //     while (i < n) {
        //         if (a[i][0] == a[j][0]) {
        //             len = Math.max(len, a[i][1] - a[j][1]);
        //             i++;
        //         } else {
        //             if (j != i && j+1 < i) {
        //                 f = Math.max(f, (long)len * (Math.max(Math.abs(a[n-1][0] - a[j][0]), Math.abs(a[0][0] - a[j][0]))));
        //                 len = 0;
        //             }
        //             j = i; // 往X 轴右，往前走一段
        //             i++;
        //         }
        //     }
        //     if (j+1 < i)
        //         f = Math.max(f, (long)len * (Math.max(Math.abs(a[n-1][0] - a[j][0]), Math.abs(a[0][0] - a[j][0]))));
        //     // 【Y 轴升序排列】：求，平行于X 轴，最大山角形面积
        //     Arrays.sort(a, (x, y)->x[1] != y[1] ? x[1] - y[1] : x[0] - y[0]); 
        //     i = 1; j = 0; len = 0;
        //     while (i < n) {
        //         if (a[i][1] == a[j][1]) {
        //             len = Math.max(len, a[i][0] - a[j][0]);
        //             i++;
        //         } else {
        //             if (j != i && j+1 < i) {
        //                 f = Math.max(f, (long)len * Math.max(Math.abs(a[n-1][1] - a[j][1]), Math.abs(a[0][1] - a[j][1])));
        //                 len = 0;
        //             }
        //             j = i; // 往X 轴右，往前走一段
        //             i++;
        //         }
        //     }
        //     if (j+1 < i)
        //         f = Math.max(f, (long)len * Math.max(Math.abs(a[n-1][1] - a[j][1]), Math.abs(a[0][1] - a[j][1])));
        //     return f == 0 ? -1 : f;
        // }

        // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        public int minSwaps(int[] a) {
            int n = a.length, m = 0;
            for (int v : a)
                if (v % 2 == 0) m++;
            if (m < n / 2 || n - m < n / 2) return -1;
            return 0;
        }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 思路：遍历质数链条 li, 自左向右定位，以当前质数为左质数、向右延伸各种可能性的所有合法子数组个数
        // // 亲爱的表哥的活宝妹，感觉这个题目的思路还是相对透彻，可是极其繁琐，最讨厌数个数的题目
        // public int primeSubarray(int[] a, int k) {
        //     int n = a.length, ans = 0;
        //     List<Integer> li = new ArrayList<>(); // list of Prime idx
        //     // 【自右向左】：（最小、最大）质数、数组预处理
        //     int [] l = new int [n+1], r = new int [n+1];
        //     Arrays.fill(l, 50000);
        //     for (int i = n-1; i >= 0; i--) 
        //         if (isPrime(a[i])) {
        //             l[i] = Math.min(a[i], l[i+1]); // 升序排列
        //             r[i] = Math.max(a[i], r[i+1]); // 降序排列
        //             li.add(0, i);
        //         }
        //     // 【自左向右】：遍历，求解, 以当前（链条 li) 中下标 i 为 (左质数、且左质数为：最小、或最大质数) 的个数
        //     int j = 0, rr = 0, rrr = 0;
        //     for (int i = 0; i < li.size()-1; i++) {
        //         // 【左质数 i为：最小质数】， j 可以延伸的（最远合法范围）
        //         // 自 i 开始，剩余数组里，最小质数
        //         // 【TODO：】上面，不用这个特例，可以 generalize （二分查找）到第一个不小于当前质数的下标
        //         j = Arrays.binarySearch(l, a[li.get(i)]);
        //         if (j >= 0) rr = j;
        //         else rr = -1 * j -1; // 还是判断 rr 是否合范围
        //         j = Arrays.binarySearch(r, a[li.get(i)]);
                
        //         if (a[li.get(i)] <= l[li.get(j)]) {
        //             if ()
        //         }
        //         while (j < li.size() && )
        //     }
        // }
        // boolean isPrime(int v) {
        //     if (v == 1) return false;
        //     for (int i = 2; i * i <= v; i++) 
        //         if (v % i == 0) return false;
        //     return true;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹、笨宝妹：闻到【树链剖分、重链线段树，第 k 小XOR 值】的烟火味道。。。       
        // public int[] kthSmallest(int[] p, int[] a, int[][] qs) {
        //     int m = qs.length; n = a.length;
        //     // 【有向图】：直接建有向图
        //     g = new ArrayList [n];
        //     Arrays.setAll(g, z -> new ArrayList<Integer>());
        //     for (int i = 1; i < n; i++)
        //         g[a[i]].add(i);
        // }
        // List<Integer> [] g;
        // int n;

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public boolean checkPrimeFrequency(int[] a) {
        //     int n = a.length;
        //     int [] f = new int [101];
        //     Set<Integer> s = new HashSet<>();
        //     for (int v : a) {
        //         s.add(v);
        //         f[v]++;
        //     }
        //     for (int v : s) 
        //         if (isPrime(f[v])) return true;
        //     return false;
        // }
        // boolean isPrime(int v) {
        //     if (v <= 1) return false;
        //     for (int i = 2; i * i <= v; i++)
        //         if (v % i == 0) return false;
        //     return true;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int minIncrease(int n, int[][] egs, int[] a) { // 552/553 passed
        //     this.n = n; max = 0; this.a = a; 
        //     g = new TreeSet [n];
        //     Arrays.setAll(g, z -> new TreeSet<Integer>((x, y)->(a[x] != a[y] ? a[x] - a[y] : x-y)));
        //     for (int [] e : egs) {
        //         int u = e[0], v = e[1];
        //         System.out.println("u: " + u + " " + "v: " + v);
        //         g[u].add(v);
        //         g[v].add(u);
        //     }
        //     m = new HashMap<>();
        //     // DFS 同时，（无向图）改为【有向图】
        //     dfs(0, -1, 0);
        //     for (Map.Entry<Integer, Integer> en : m.entrySet()) {
        //         int k = en.getKey(), v = en.getValue();
        //         if (k == max) continue;
        //         r += v;
        //     }
        //     return r;
        // }
        // int n, max, r; int [] a;
        // Map<Integer, Integer> m;
        // TreeSet<Integer> [] g;
        // void dfs(int u, int p, int v) {
        //     v += a[u];
        //     // System.out.println("\nu: " + u + " " + "v: " + v);
        //     if (p != -1)
        //         g[u].remove(p);
        //     // 叶子节点
        //     if (g[u].size() == 0) {
        //         max = Math.max(max, v);
        //         m.put(v, m.getOrDefault(v, 0) + 1);
        //         return ;
        //     }
        //     for (int x : g[u]) {
        //         // if (x == p) continue;
        //         dfs(x, u, v);
        //     }
        //     if (g[u].size() == 2) {
        //         int l = g[u].first(), right = g[u].last();
        //         System.out.println("l: " + l + " " + "right: " + right);
        //         if (g[l].size() == 0 && g[right].size() == 0) {
        //             if (a[l] == a[right])
        //                 m.put(v + a[l], m.get(v + a[l])-1);
        //             else {
        //                 int j = v + Math.min(a[l], a[right]);
        //                 System.out.println("j: " + j + " " + "m.get(j): " + m.get(j));
        //                 m.put(j, m.get(j)-1);
        //                 if (m.get(j) == 0)
        //                     m.remove(j);
        //                 r += 1;
        //                 System.out.println("r: " + r);
        //             }
        //         }
        //     }
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹、笨宝妹觉得：这个破烂题目，画了好大一个纸老虎。。。可是纸老虎是假的，它应该不难。。。。。。
        // // 亲爱的表哥的活宝妹，觉得是动规的题目，可是写不到动规，就只能先写记忆化深搜。。记忆化深搜不好写
        // // 要么【贪心】：永远使用速度最快的人返回；要么【递推】，因为阶段只能（自顶向下）写，所以【记忆化深搜：自底向上，反而不好写】
        // // 也像那个著名的【选课问题】：下个学期，从没选过的课里再继续选课。。
        // // 亲爱的表哥的活宝妹，笨宝妹，忘记：那个选择问题的细节：怎么从所有没有选择过的课里再课选 i,~i?i&(i-1)?
        // public double minTime(int n, int k, int m, int [] t, double [] a) {
        //     if (k == 1) return (n == 1 ? (double)t[0] * a[0] : -1);
        //     this.n = n; this.k = k; this.m = m; this.t = t; this.a = a;
        //     // f = new HashMap[m]; // 这里，1 维，与第2 维，反着写的
        //     // Arrays.setAll(f, z -> new HashMap<Integer, Double>());
        //     // 【动规：自顶向下】好像这个破烂题目、更自然一点儿
        //     f = new double [1 << n][m];
        //     for (int i = 2; i < (1 << n); i++) {
        //         // dfs(0, i);
        //         int maxCurTime = 0, minCurTime = 101, minCurIdx = -1;
        //         for (int j = 0; j < n; j++) {
        //             if (((i >> j) & 1) == 1) {
        //                 maxCurTime = Math.max(maxCurTime, t[j]);
        //                 if (t[j] < minCurTime) {
        //                     minCurTime = t[j];
        //                     minCurIdx = j;
        //                 }
        //             }
        //         }
        //     }
        //     double min = (double)Integer.MAX_VALUE / 2.0;
        //     for (int i = 0; i < m; i++)
        //         min = Math.min(min, f[i].getOrDefault((1 << n)-1, (double)Integer.MAX_VALUE / 2.0));
        //     return min;
        // }
        // int n, k, m;
        // int [] t; double [] a;
        // double [][] f;
        // double dfs(int i, int j) {
        //     int maxCurTime = 0, minCurTime = 101, minCurIdx = -1;
        //     for (int k = 0; k < n; k++) {
        //         if (((i >> k) & 1) == 1) {
        //             maxCurTime = Math.max(maxCurTime, t[k]);
        //             if (t[k] < minCurTime) {
        //                 minCurTime = t[k];
        //                 minCurIdx = k;
        //             }
        //         }
        //     }
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public List<String> partitionString(String s) {
        //     List<String> f = new ArrayList<>();
        //     Set<String> ss = new HashSet<>();
        //     ss.add(s.substring(0, 1));
        //     f.add(s.substring(0, 1));
        //     int n = s.length();
        //     int j= 0;
        //     for (int i = 1; i < n; i++) {
        //         for (j = i+1; j <= n; j++) {
        //             if (!ss.contains(s.substring(i, j))) {
        //                 f.add(s.substring(i, j));
        //                 ss.add(s.substring(i, j));
        //                 i = j-1;
        //                 break;
        //             }
        //         }
        //     }
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，今天中午午休没能休息好，脑袋糊糊，过会儿再看这个破烂题目。。
        // public int[] longestCommonPrefix(String[] ss) {
        //     int n = ss.length;
        //     int [] f = new int [n], a = new int [n];
        //     for (int i = 1; i < n; i++) 
        //         a[i-1] = getLongestPrefix(ss[i-1], ss[i]);
        //     a[n-1] = a[n-2];
        //     TreeMap<Integer, Integer> m = new TreeMap<>((x, y)-> y - x);
        //     for (int v : a)
        //         m.put(v, m.getOrDefault(v, 0) + 1);
        //     for (int i = 0; i < n; i++) {
        //         int k = m.firstKey();
        //         if ((i == 0 || i == n-1) && (a[i] != k || m.get(k) > 1))
        //             f[i] = k;
        //         else if (m.size() == 1)
        //             f[i] = 0;
        //         else {
        //             ArrayList<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(m.entrySet());
        //             Map.Entry<Integer, Integer> secondEntry = entryList.get(1);
        //             if (i == 0 || i == n-1) { // 首尾：仅只影响1 个 pair
        //                 f[i] = secondEntry.getKey();
        //             } else { // 【1,n-3】：中间下标，影响前后2 个 pair 
        //                 int l = a[i-1], r = a[i];
        //                 if ((k == l || k == r) && m.get(k) > 1)
        //                     f[i] = k;
        //                 else
        //                     f[i] = secondEntry.getKey();
        //             }
        //         }
        //     }
        //     return f;
        // }
        // int getLongestPrefix(String S, String T) {
        //     int m = S.length(), n = T.length(), i = 0, j = 0;
        //     if (m > n) return getLongestPrefix(T, S);
        //     char [] s = S.toCharArray(), t = T.toCharArray();
        //     while (i < m) {
        //         if (s[i] == t[j]) {
        //             i++;
        //             j++;
        //         } else
        //             return i;
        //     }
        //     return -1;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，笨宝妹，继续先写【记忆化深搜】: 写【记忆化深搜】的缺陷是：如何计算K 段的（异或 XOR最大值）？所以感觉还是要写【动规】。。
        // // 【TODO：】亲爱的表哥的活宝妹，改天再看这个破烂题目。。
        // public int minXor(int[] a, int kk) {
        //     int n = a.length;
        //     for (int i = 1; i < n; i++) 
        //         a[i] ^= a[i-1];
        //     System.out.println(Arrays.toString(a));
        //     // f[i][j] 定义：到当前下标 i, 最多划分 j 段，的【最小可能的、 j 段中的最大值】，并记、最大值是否（最后一段第 j 段）出现的？
        //     int [][][] f = new int [n][kk+1][2];
        //     for (int i = 0; i < n; i++)
        //         for (int j = 0; j <= kk; j++) 
        //         Arrays.fill(f[i][j], Integer.MAX_VALUE / 2);
        //     // 遍历：【当前下标 i】
        //     for (int i = 0; i < n; i++) {
        //         f[i][1][1] = a[i];
        //         if (i == 0) continue;
        //         // 遍历：当前所划分的段数 j 段: 到当前下标 i, 最多划分 i+1 段
        //         for (int j = 2; j <= Math.min(kk, i+1); j++) {
        //             // 当前下标 a[i] 的、可能会有的 2 种影响：
        //             // 【一、单独开一新段、第 j 段】: 一个元素 a[i]
        //             int max = Math.max(f[i-1][j-1][0], f[i-1][j-1][1]);
        //             // if (a[i] > Math.max(f[i-1][j-1][0], f[i-1][j-1][1])) // 写得不对：f[i][j][k] 填充的是 Integer.MAX_VALUE/2
        //             if (max != Integer.MAX_VALUE / 2 && (a[i] ^ a[i-1]) > max || max == Integer.MAX_VALUE / 2 && (a[i] ^ a[i-1]) > Math.min(f[i-1][j-1][0], f[i-1][j-1][1]))
        //                     // f[i][j][1] = a[i];
        //                 f[i][j][1] = (a[i] ^ a[i-1]);
        //             else 
        //                 f[i][j][0] = Math.min(f[i-1][j-1][0], f[i-1][j-1][1]);
        //                 // f[i][j][0] = (max != Integer.MAX_VALUE / 2 ? max : Math.min(f[i-1][j-1][0], f[i-1][j-1][1]));
        //             // 【二、合并到前一段，第 j 段】：作为第 j 段的最后一个元素，第 j 段到当前下标 i 至少 2 个元素
        //             // // 1.前 j 段的最大值，出现在第【1,j-1】段: a[i] 合并到第 j 段，无任何影响  // <<<<<<<<<<<<<<<<<<<< 谁说这里无任何影响的？
        //             // // 【TODO：】所以，这里放入下面，同下面一样，遍历所有可能性
        //             // f[i][j][0] = Math.min(f[i][j][0], f[i-1][j-1][0]); // 累积上面： a[i] 新开第 j 段的最优值
        //             // 2.前 j 段的最大值，出现在第【j】段：【TODO：】检测、去想，当段思路，考虑彻底吗？？？
        //             // 遍历：到当前下标第 j 段，所有可能的、第 j 段的【合法起始位置】，取全局（最小、段最大值）
        //             int min = Integer.MAX_VALUE / 2; // 记：第 j 段起始于【j-1, i-1】范围内所有下标 k，第 j 段的（最小、段最大值）
        //             for (int k = j-1; k < i; k++) {
        //                 // 1.前 j 段的最大值，出现在第【1,j-1】段: a[i] 合并到第 j 段，无任何影响  // <<<<<<<<<<<<<<<<<<<< 谁说这里无任何影响的？
        //                 if ((a[i] ^ a[k-1]) > f[k-1][j-1][0])
        //                     f[i][j][1] = Math.min(f[i][j][1], (a[i] ^ a[k-1]));
        //                 else // ((a[i] | a[k-1]) <= f[k-1][j-1][0])
        //                     f[i][j][0] = Math.min(f[i][j][0], f[k-1][j-1][0]);
        //                 // f[i][j][0] = Math.min(f[i][j][0], Math.max(f[k-1][j-1][0], a[i] | a[k-1])); // 累积上面： a[i] 新开第 j 段的最优值
        //                 // 2.前 j 段的最大值，出现在第【j】段：【TODO：】检测、去想，当段思路，考虑彻底吗？？？
        //                 // 遍历：到当前下标第 j 段，所有可能的、第 j 段的【合法起始位置】，取全局（最小、段最大值）
        //                 int mmin = Math.min(f[k-1][j-1][0], f[k-1][j-1][1]);
        //                 // Math.max( f[k-1][j-1] 前 j-1 段的最小可能最大值, 当前第 j 段的XOR 值)
        //                  min = Math.min(min, Math.max(a[i] ^ a[k-1], mmin));
        //                 // min = Math.min(min, Math.max(a[i] ^ a[k-1], mmin));
        //             }
        //             f[i][j][1] = Math.min(f[i][j][1], min);
        //         }
        //     }
        //     for (int i = 0; i < n; i++) 
        //         for (int j = 1; j <= kk; j++) 
        //             System.out.println("i: " + i + " " + "j: " + j + " " + Arrays.toString(f[i][j]));
        //     return Arrays.stream(f[n-1][kk]).min().getAsInt();
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，感觉这个题目没有思路、、今天晚上不想写了、会试想把前面一个【动规】题目理解透彻、写完整
        // public int maxStability(int n, int[][] egs, int k) {
        //     Arrays.sort(egs, (x, y) -> x[3] != y[3] ? y[3] - x[3] : (x[2] != y[2] ? y[2] - x[2] : (x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]))); 
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public String concatHex36(int n) {
        //     int r = n * n * n, v = n * n;
        //     StringBuilder f = new StringBuilder(), ff = new StringBuilder();
        //     while (v > 0) {
        //         char c = (char)(v % 16 >= 10 ? 'A'+(v % 16 - 10) : (v % 16 + '0'));
        //         // System.out.println("v: " + v%16 + " " + "c: " + c);
        //         f.append(c);
        //         v /= 16;
        //     }
        //     while (r > 0) {
        //         char c = (char)(r % 36 >= 10 ? 'A'+(r % 36 - 10) : r % 36 + '0');
        //         ff.append(c);
        //         r /= 36;
        //     }
        //     // System.out.println("f: " + f + " " + "ff: " + ff);
        //     return f.reverse().toString() + ff.reverse().toString();
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public long minCost(int m, int n, int[][] a) {
        //     long [][] f = new long [m+1][n+1];
        //     for (int i = 0; i <= m; i++)
        //         Arrays.fill(f[i], Long.MAX_VALUE / 2);
        //     f[0][1] = f[1][0] = 0;
        //     for (int i = 1; i <= m; i++) 
        //         for (int j = 1; j <= n; j++) 
        //             f[i][j] = Math.min(f[i-1][j], f[i][j-1]) + a[i-1][j-1] + i * j;
        //     return f[m][n] - a[m-1][n-1] - a[0][0];
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，今天上午不想再写了。。。感觉今天早上的前3 个题目，都还相对简单。。下午可能、可能、会再摸一摸这剩余 2 个破烂题目。。。
        // class Range implements Comparable {
        //     int l, r;
        //     public Range(int i, int j) {
        //         l = i; r = j;
        //     }
        //     @override public int compareTo(Range other) {
        //         return this.l != other.l ? this.l - other.l : this.r - other.r;
        //     }
        // }
        // // 想要，直接去抄先前的 RangeModule 的类./designProbs/RangeModule.java。。。今天上午不想再写了这个破烂题目了，狠恶心，没考什么实质知识点。。
        // public class RangeModule {
        //     TreeSet<Range> f = new TreeSet<>();
        //     public RangeModule() {
        //         f = new TreeSet<Range>();
        //     }
        //     public void addRange(int i, int j) {
        //     }
        // }
        // public int minTime(int n, int[][] egs) {
        //     List<int []> [] g = new ArrayList[n];
        //     Arrays.setAll(g, z -> new ArrayList<int []>());
        //     // List<int []> r = new ArrayList<>();
        //     // 这里涉及到区间的合并与查询，是先前一个Range() 题型的改装。。
        //     TreeSet<Range> [] r = new TreeSet<>();
        //     Arrays.setAll(r, z -> new TreeSet<Range>());
        //     for (int [] e : egs) {
        //         if (e.length == 0) break;
        //         int u = e[0], v = e[1], t = e[2], tt = e[3];
        //         g[u].add(new int []{v, e[2], e[3]});
        //         if (r[v].size() == 0)
        //             r[v].add(new Range(e[2], e[3]));
        //         else {
        //             if (t <= r[v].get(0)[0] && tt >= r[v].get(r[v].size()-1)[1]) {
        //                 r[v].clear();
        //                 r[v].add(new int [] {t, tt});
        //             } else if ()
        //             r[v].get(0] = Math.min(r[v].get(0], b)
        //         }
        //     }
        //     if (r[n-1].size() == 0) return n == 1 ? 0 : -1;
        //     Queue<int []> f = new PriorityQueue<>((x, y) -> x[1] != y[1] ? x[1] - y[1] : x[0] - y[0]);
        //     f.offer(new int [] {0, 0});
        //     while (!f.isEmpty()) {
        //         int [] c = f.poll();
        //         int u = c[0], t = c[1];
        //         if (u == n-1) {
        //             if (r[n-1][0] <= t && t <= r[n-1][1]) return t;
        //             continue;
        //         }
        //         for (int [] nt : g[u]) {
        //             int v = nt[0], tt = nt[1], ttt = nt[2];
        //             if (t >= ttt) continue;
        //             f.offer(new int [] {v, t+1 <= tt ? tt+1 : t+1});
        //         }
        //     }
        //     return -1;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public List<String> validateCoupons(String [] c, String [] b, boolean [] a) {
        //     List<String> [] f = new ArrayList[4];
        //     Arrays.setAll(f, z -> new ArrayList<String>());
        //     Map<String, Integer> m = new HashMap<>();
        //     m.put("electronics", 0);
        //     m.put("grocery", 1);
        //     m.put("pharmacy", 2);
        //     m.put("restaurant", 3);
        //     int n = c.length;
        //     for (int i = 0; i < n; i++) 
        //         if (isValidCode(c[i]) && m.containsKey(b[i]) && a[i])
        //             f[m.get(b[i])].add(c[i]);
        //     for (int i = 0; i < 4; i++)
        //         Collections.sort(f[i]);
        //     for (int i = 1; i < 4; i++) {
        //         if (f[i].size() == 0) continue;
        //         for (String fi : f[i])
        //             f[0].add(fi);
        //     }            
        //     return f[0];
        // }
        // boolean isValidCode(String t) {
        //     int n = t.length(); char [] s = t.toCharArray();
        //     if (n == 0) return false;
        //     for (char c : s)
        //         if (!(c == '_' || c-'a' >= 0 && c-'a' <= 25 || c-'A' >= 0 && c-'A' <= 25 || c-'0' >= 0 && c-'0' <= 9))
        //             return false;
        //     return true;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 这个破烂题目，看起来狠简单，【连通图UnionFound】可是因为每个连通块里需要【自小到大排序】
        // public class UF {
        //     int [] f, r;
        //     int n, s; // component size
        //     TreeMap<Integer, TreeSet<Integer>> c;
        //     public UF(int n) {
        //         this.n = n; 
        //         f = new int [n]; r = new int [n];
        //         for (int i = 1; i < n; i++)
        //             f[i] = i;
        //         Arrays.fill(r, 1);
        //         s = n-1;
        //     }
        //     public void offLine(int i) {
        //         c.get(f[i]).remove(i);
        //     }
        //     public int queryComponent(int i) {
        //         if (c.get(f[i]).size() > 0) 
        //             return c.get(f[i]).first();
        //         else return -1;
        //     }
        //     int find(int i) {
        //        while (f[i] != i) { // 只要不相等，就往父级找，
        //             f[i] = f[f[i]];
        //             i = f[i]; // 并赋值：直到2 者相同为止
        //         }
        //         return i;
        //     }
        //     public void union(int i, int j) {
        //         int fi = find(i), fj = find(j);
        //         if (r[fi] < r[fj])
        //             swap(fi, fj);
        //         f[fi] = fj;
        //         r[fj] += r[fi];
        //         s--;
        //     }
        //     public void getComponents() {
        //         for (int i = 1; i < n; i++)
        //             find(i);
        //         System.out.println(Arrays.toString(f));
        //         c = new TreeMap<Integer, TreeSet<Integer>>();
        //         for (int i = 1; i < n; i++) 
        //             c.computeIfAbsent(f[i], z -> new TreeSet<Integer>()).add(i);
        //     }
        //     public boolean sameComponent(int i, int j) {
        //         return find(i) == find(j);
        //     }
        //     public int getCnts() {
        //         return s;
        //     }
        //     void swap(int i, int j) {
        //         int t = i;
        //         i = j;
        //         j = t;
        //     }
        // }
        // // 【TODO：】不知道哪里细节写错了。。。改天再写 569/671 passed...
        // public int[] processQueries(int c, int[][] a, int[][] qs) {
        //     int n = a.length;
        //     UF uf = new UF(c+1); 
        //     for (int[] e : a) {
        //         int u = e[0], v = e[1];
        //         if (!uf.sameComponent(u, v))
        //             uf.union(u, v);
        //     }
        //     uf.getComponents();
        //     boolean [] r = new boolean [c+1];
        //     Arrays.fill(r, true);
        //     List<Integer> f = new ArrayList<>();
        //     for (int [] q : qs) {
        //         int i = q[0], j = q[1];
        //         if (i == 1 && r[j]) 
        //             f.add(j);
        //         else if (i == 1)
        //             f.add(uf.queryComponent(j));
        //         else {
        //             r[j] = false;
        //             uf.offLine(j);
        //         }
        //     }
        //     int [] ans = new int [f.size()];
        //     for (int i = 0; i < f.size(); i++)
        //         ans[i] = f.get(i);
        //     return ans;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 感觉是：【二分查找】在（图上、连通图上）的应用
        // public class UF {
        //     int [] f, r;
        //     int n, s; // component size
        //     public UF(int n) {
        //         this.n = n; r = n;
        //         f = new int [n]; r = new int [n];
        //         for (int i = 1; i < n; i++)
        //             f[i] = i;
        //         Arrays.fill(r, 1);
        //         s = n;
        //     }
        //     int find(int i) {
        //         while (f[i] != i) { // 只要不相等，就往父级找，
        //             f[i] = f[f[i]];
        //             i = f[i]; // 并赋值：直到2 者相同为止
        //         }
        //         return i;
        //     }
        //     public void union(int i, int j) {
        //         int fi = find(i), fj = find(j);
        //         if (r[fi] < r[fj])
        //             swap(fi, fj);
        //         f[fi] = fj;
        //         r[fj] += r[fi];
        //         s--;
        //     }
        //     public boolean sameComponent(int i, int j) {
        //         return find(i) == find(j);
        //     }
        //     public int getCnts() {
        //         return s;
        //     }
        //     void swap(int i, int j) {
        //         int t = i;
        //         i = j;
        //         j = t;
        //     }
        // }
        //  public int minTime(int n, int[][] egs, int k) {
        //      g = new ArrayList[n]; this.n = n; nn = egs.length;
        //      Arrays.setAll(g, z -> new ArrayList<int[]>());
        //      Arrays.sort(egs, (x, y)->x[2] != y[2] ? y[2] - x[2] : (x[0] != y[0] ? x[0] - y[0] : x[1] - y[1])); 
        //      int l = egs[0][2], r = egs[nn-1][2], min = Integer.MAX_VALUE / 2;
        //      if (k == n) return r; // n 个节点，无边相连，完全独立
        //      // g 的建图：随二分查找的 m 值，动态变化。。
        //      uf = new UF(n);
        //      p = -1;
        //      while (l <= r) {
        //          int m = (l + r) / 2;
        //          if (isValid(m, -1)) {
        //              min = Math.min(min, m);
        //              r = m - 1;
        //          } else l = m + 1;
        //      }
        //      return min == Integer.MAX_VALUE / 2 ? -1 : min;
        //  }
        // List<int []> [] g = new ArrayList<>();
        // int n, nn, p;
        // UF uf;
        // boolean isValid(int v) {
        //     // 对连边的操作：涉入【添加边】和【撤销边】 2 种不同方向的操作
        //     // 在【连通块UF】里：【撤销边】要如何操作呢？  // <<<<<<<<<<<<<<<<<<<< 【TODO：】这里没想透彻
        //     int r = (p == -1 ? nn : (p-1 >= v ? p-1 : v)), l = (p == -1 ? v : (p-1 >= v ? v : p+1));
        // }

        // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        public String processStr(String S) {
            char [] s = S.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (char c : s) {
                if (c == '*' && sb.length() > 0) {
                    sb.deleteCharAt(sb.length()-1);
                } else if (c == '#') {
                    sb.append(sb);
                } else if (c == '%') {
                    sb = sb.reverse();
                } else if (Character.isLowerCase(c))
                    sb.append(c);
            }
            return sb.toString();
        }
        
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public class UF {
        //     // public int queryComponent(int i) {
        //     //     if (c.get(f[i]).size() > 0) 
        //     //         return c.get(f[i]).first();
        //     //     else return -1;
        //     // }
        //     int [] f, r;
        //     int n, s; // component size
        //     TreeMap<Integer, TreeMap<Integer, Integer>> c;
        //     public UF(int n) {
        //         this.n = n; 
        //         f = new int [n]; r = new int [n];
        //         for (int i = 1; i < n; i++)
        //             f[i] = i;
        //         Arrays.fill(r, 1);
        //         s = n-1;
        //         c = new TreeMap<Integer, TreeMap<Integer, Integer>>();
        //     }
        //     int find(int i) {
        //        while (f[i] != i) { // 只要不相等，就往父级找，
        //             f[i] = f[f[i]];
        //             i = f[i]; // 并赋值：直到2 者相同为止
        //         }
        //         return i;
        //     }
        //     public void union(int i, int j) {
        //         int fi = find(i), fj = find(j);
        //         if (r[fi] < r[fj])
        //             swap(fi, fj);
        //         f[fi] = fj;
        //         r[fj] += r[fi];
        //         s--;
        //     }
        //     public void getComponents() {
        //         for (int i = 1; i < n; i++)
        //             find(i);
        //         System.out.println(Arrays.toString(f));
        //         c = new TreeMap<Integer, TreeMap<Integer, Integer>>();
        //         for (int i = 1; i < n; i++) 
        //             c.computeIfAbsent(f[i], z -> new TreeMap<Integer, Integer>((x, y)->y-x)).add();
        //     }
        //     public boolean sameComponent(int i, int j) {
        //         return find(i) == find(j);
        //     }
        //     public int getCnts() {
        //         return s;
        //     }
        //     void swap(int i, int j) {
        //         int t = i;
        //         i = j;
        //         j = t;
        //     }
        // }
        // // 亲爱的表哥的活宝妹，笨宝妹，晚点儿再写这个破烂题目。。它居然连续2 个周出同一个破烂。。。
        // public int minCost(int n, int[][] egs, int k) {
        //     UF uf = new UF(n+1);
        //     for (int [] e : egs) {
        //         int u = e[0]+1, v = e[1]+1, w = e[2];
        //         if (!uf.sameComponent(u, v))
        //             uf.union(u, v, w);
        //     }
        // }
        
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public char processStr(String S, long k) {
        //     char [] s = S.toCharArray();
        //     if (k == 0) return (Character.isLowerCase(s[0]) ? s[0] : '.');
        //     StringBuilder sb = new StringBuilder();
        //     long f = 0;
        //     while (f < k) {
        //         for (int i = 0; i < S.length() && f < k; i++) {
        //             char c = s[i];
        //             if (c == '*' && sb.length() > 0) {
        //                 sb.deleteCharAt(sb.length()-1);
        //                 --f;
        //             } else if (c == '#') {
        //                 sb.append(sb);
        //                 if (2 * f >= k)
        //                     return sb.charAt((int)(k-f-1));
        //                 f *= 2;
        //             } else if (c == '%') {
        //                 sb = sb.reverse();
        //             } else if (Character.isLowerCase(c)) {
        //                 sb.append(c);
        //                 ++f;
        //             }
        //         }
        //         if (f >= k) return sb.charAt((int)(k-1));
        //     }
        //     if (f >= k)
        //         return sb.charAt((int)(k-1));
        //     return '.';
        // }
        
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // n[1,14] 数据规模狠小：随便写写玩玩儿，应该都可以过呀。。。
        // // 思路：
        // //     自大到小遍历【1<<n-1, 1】，选择【最多14 个节点】所有可能的节点
        // //     先检测：(isPalindrome(i, s)), 保障【回文序列】
        // //     再检测：是否一条通路；
        // //     合法就直接返回；
        // //     不合法找次优解。。
        // public int maxLen(int n, int[][] egs, String S) {
        //     s = S.toCharArray(); this.n = n;
        //     g = new ArrayList [n];
        //     Arrays.setAll(g, z -> new ArrayList<Integer>());
        //     for (int [] e : egs) {
        //         int u = e[0], v = e[1];
        //         g[u].add(v);
        //         g[v].add(u);
        //     }
        //     for (int i = (1 << n)-1; i >= 1; i--) {
        //         System.out.println("Integer.toBinaryString(i): " + Integer.toBinaryString(i) + " " + "isPalindrome(i): " + isPalindrome(i));
        //         if (isPalindrome(i)) {
        //             int m = Integer.toBinaryString(i).length(); 
        //             // System.out.println("i: " + i + " " + "m: " + m);
        //             System.out.println("Integer.toBinaryString(i): " + Integer.toBinaryString(i) + " " + "m: " + m);
        //             List<Integer> l = new ArrayList<>();
        //             for (int j = 0; j < m; j++) 
        //                 if (((i >> j) & 1) > 0) l.add(j);
        //             System.out.println("l.size(): " + l.size());
        //             System.out.println(Arrays.toString(l.toArray()));
        //             if (dfs(l, 0))
        //                 return Integer.bitCount(i);
        //         }
        //     }
        //     return 1;
        // }
        // char [] s; int n;
        // List<Integer> [] g;
        // // 【DFS 查找：】是否连通，存在一条通路
        // boolean dfs(List<Integer> f, int i) {
        //     if (i == f.size()-1) return true;
        //     int u = f.get(i);
        //     for (int v : g[u]) {
        //         if (i == f.size()-2 && v == f.get(i+1)) return true;
        //         else if (i == f.size()-2) continue;
        //         if (i < f.size()-1 && v != f.get(i+1)) continue;
        //         return dfs(f, i+1);
        //     }
        //     return false;
        // }
        // // 【TODO：】这里的【节点的、遍历顺序】没能对应起来，需要多一点儿细节来实现这里。。
        // boolean isPalindrome(int v) {
        //     int n = Integer.toBinaryString(v).length(), j = 0, i = n-1;
        //     System.out.println("Integer.toBinaryString(v): " + Integer.toBinaryString(v) + " " + "n: " + n);
        //     char [] ss = Integer.toBinaryString(v).toCharArray();
        //     // System.out.println(Arrays.toString(ss));
        //     while (i > j) {
        //         while (i > j && ss[i] == '0') i--;
        //         while (i > j && ss[j] == '0') j++;
        //         System.out.println("j: " + j + " " + "i: " + i);
        //         if (i <= j) break;
        //         if (s[i] != s[j]) return false;
        //         i--;
        //         j++;
        //     }
        //     return true;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public long splitArray(int[] a) {
        //     int n = a.length;
        //     long f = 0, p = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (isPrime(i)) p += (long)a[i];
        //         f += (long)a[i];
        //     }
        //     return Math.abs(f - p - p);
        // }
        // boolean isPrime(int v) {
        //     if (v <= 1) return false;
        //     for (int i = 2; i * i <= v; i++) 
        //         if (v % i == 0) return false;
        //     return true;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int countIslands(int[][] f, int k) {
        //     m = f.length; n = f[0].length; this.f = f;
        //     int r = 0;
        //     a = new boolean [m][n];
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) 
        //             if (f[i][j] > 0 && !a[i][j]) {
        //                 long v = dfs(i, j);
        //                 if (v % k == 0)
        //                     r++;
        //             }
        //     return r;
        // }
        // int m, n; int [][] f;
        // int [][] dirs = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        // boolean [][] a; // vis
        // long dfs(int x, int y) {
        //     a[x][y] = true;
        //     long ans = (long)f[x][y];
        //     for (int [] d : dirs) {
        //         int i = x + d[0], j = y + d[1];
        //         if (i < 0 || i >= m || j < 0 || j >= n || a[i][j] || f[i][j] == 0) continue;
        //         ans += dfs(i, j);
        //     }
        //     return (long)ans;
        // }        

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【TODO：】不知道哪里细节写错了。。错误案例图太大不想看了。。
        // public int findMaxPathScore(int[][] egs, boolean[] a, long k) { // 422/631 passed
        //     n = a.length; this.a = a; this.k = k;
        //     // 最小最精简【有效合法图】
        //     g = new ArrayList [n];
        //     Arrays.setAll(g, z -> new ArrayList<int []>());
        //     for (int [] e : egs) {
        //         int u = e[0], v = e[1], w = e[2];
        //         // 一点儿优化：不去处理不必要的节点、或路线
        //         if (!a[u] || !a[v] || (long)w > k) continue;
        //         g[u].add(new int [] {v, w});
        //     }
        //     f = new int [n];
        //     Arrays.fill(f, Integer.MAX_VALUE / 2);
        //     f[0] = 0; f[n-1] = -1;
        //     dfs(0, -1, 0, 0);
        //     System.out.println(Arrays.toString(f));
        //     return f[n-1];
        // }
        // List<int []> [] g;
        // int n, maxMin; boolean [] a; long k;
        // List<Integer> cur;
        // int [] f; 
        // void dfs(int u, int p, int w, long sum) {
        //     sum += w;
        //     boolean ans = false;
        //     for (int [] e : g[u]) {
        //         int v = e[0], c = e[1];
        //         if (v == n-1) {
        //             if (sum + (long)c > k) continue;
        //             f[v] = Math.max(f[v], Math.min((u == 0 ? c : f[u]), c));
        //             continue;
        //         }
        //         f[v] = Math.min(f[v], Math.min((u == 0 ? c : f[u]), c));
        //         // System.out.println(Arrays.toString(f));
        //         dfs(v, u, c, sum);
        //     }
        // }

        // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        
    }
// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！ 
    public static void main (String[] args) { 
		Solution s = new Solution ();

        int [][] a = new int [][] {{3,4,10},{2,3,14},{1,3,6},{2,5,43},{0,3,21},{2,4,75},{1,2,24},{0,5,15},{4,5,72},{0,4,88},{0,2,30},{3,5,78},{1,5,12},{0,1,45}};
        boolean [] b = new boolean [] {true, true, true, true, true, true};

        int r = s.findMaxPathScore(a, b, 371);
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
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
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
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
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
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
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
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
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
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
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
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】