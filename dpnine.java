import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.Arrays;
import java.util.stream.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;

public class dpnine {
    public static class Solution {

        // public int minCost(int[] houses, int[][] cost, int m, int n, int target) { // bug
        //     this.m = m; // 就是最开始： 上一个房子的着色，自顶向下传递的着色 与 自底向上传递的答案之间的交错，最开始理解起来有些理不清楚
        //     this.n = n;
        //     dp = new Integer [m][n+1][target+1];
        //     return dfs(0, 0, target, houses, cost);
        // }
        // Integer [][][] dp;
        // int m, n;
        // private int dfs(int i, int j, int k, int [] h, int [][] c) { // i: idx, j: color, k: target
        //     if (k < 0) return -1; // return 0;
        //     if (i == m) return k == 0 ? 0 : -1;
        //     if (dp[i][j][k] != null) return dp[i][j][k];
        //     int ans = Integer.MAX_VALUE, v = 0;
        //     if (h[i] > 0) 
        //         return dp[i][j][k] = dfs(i+1, h[i], h[i] == j ? k : k-1, h, c); // 如果与上一间房屋颜色不同，开启新街区，target减一
        //     for (int x = 0; x < n; x++) {
        //         v = dfs(i+1, x+1, (x+1 == j ? k : k-1), h, c);
        //         if (v != -1)
        //             ans = Math.min(ans, v + c[i][x]);
        //     }
        //     return  dp[i][j][k] = ans == Integer.MAX_VALUE ? -1 : ans;
        // }
        // static final int INFTY = Integer.MAX_VALUE / 2; // 选择 Integer.MAX_VALUE / 2 的原因是防止整数相加溢出
        // public int minCost(int[] houses, int[][] cost, int m, int n, int target) { // todo: dp 优化解 官方
        //     // 将颜色调整为从 0 开始编号，没有被涂色标记为 -1
        //     for (int i = 0; i < m; ++i) --houses[i];
        //     // dp 所有元素初始化为极大值
        //     int[][][] dp = new int[m][n][target];
        //     for (int i = 0; i < m; ++i) 
        //         for (int j = 0; j < n; ++j) 
        //             Arrays.fill(dp[i][j], INFTY);
        //     for (int i = 0; i < m; ++i) 
        //         for (int j = 0; j < n; ++j) {
        //             if (houses[i] != -1 && houses[i] != j) continue;
        //             for (int k = 0; k < target; ++k) {
        //                 for (int x = 0; x < n; x++) {
        //                     if (j == x) {
        //                         if (i == 0) {
        //                             if (k == 0) dp[i][j][k] = 0;
        //                         } else
        //                             dp[i][j][k] = Math.min(dp[i][j][k], dp[i-1][j][k]);
        //                     } else if (i > 0 && k > 0)
        //                         dp[i][j][k] = Math.min(dp[i][j][k], dp[i-1][x][k-1]);
        //                 }
        //                 if (dp[i][j][k] != INFTY && houses[i] == -1)
        //                     dp[i][j][k] += cost[i][j];
        //             }
        //         }
        //     int ans = INFTY;
        //     for (int j = 0; j < n; ++j) 
        //         ans = Math.min(ans, dp[m - 1][j][target - 1]);
        //     return ans == INFTY ? -1 : ans;
        // }

        // public int numOfWays(int [] a) { // 这个思路很直白
        //     int n = a.length;
        //     f = new int [n+1][n+1];
        //     f[1][0] = 1; // C_1^0 = 1
        //     f[1][1] = 1; // C_1^1 = 1
        //     for (int i = 2; i <= n; i++) // DP 求解组合数
        //         for (int j = 0; j <= i; j++) 
        //             if (j == 0 || j == i) f[i][j] = 1; // C_n^0 = C_n^n = 1
        //             else f[i][j] = (f[i-1][j-1] + f[i-1][j]) % mod; // 选与不选第j个数
        //     return (int)((dfs(Arrays.stream(a).boxed().collect(Collectors.toList())) - 1) % mod);
        // }
        // int mod = (int)1e9 + 7;
        // int [][] f;
        // private long dfs(List<Integer> a) {
        //     if (a.size() <= 1) return 1;
        //     int root = a.get(0), n = a.size();
        //     List<Integer> l = new ArrayList<>();
        //     List<Integer> r = new ArrayList<>();
        //     for (int v : a) 
        //         if (v < root) l.add(v);
        //         else if (v > root) r.add(v);
        //     long cntLeft = dfs(l), cntRight = dfs(r);
        //     return ((f[n-1][l.size()] * cntLeft % mod) * cntRight) % mod;
        // }
        // static final int mod = (int)1e9 + 7;
        // long [][] c;
        // public int numOfWays(int [] a) {
        //     int n = a.length;
        //     if (n == 1) return 0;
        //     c = new long [n][n];
        //     c[0][0] = 1;
        //     for (int i = 1; i < n; ++i) {
        //         c[i][0] = 1;
        //         for (int j = 1; j < n; ++j) 
        //             c[i][j] = (c[i - 1][j - 1] + c[i - 1][j]) % mod;
        //     }
        //     TreeNode root = new TreeNode(a[0]);
        //     for (int i = 1; i < n; ++i) {
        //         int val = a[i];
        //         insert(root, val);
        //     }
        //     dfs(root);
        //     return (root.ans - 1 + mod) % mod;
        // }
        // public void insert(TreeNode root, int v) {
        //     TreeNode r = root;
        //     while (true) {
        //         ++r.size;
        //         if (v < r.val) {
        //             if (r.left == null) {
        //                 r.left = new TreeNode(v);
        //                 return;
        //             }
        //             r = r.left;
        //         } else {
        //             if (r.right == null) {
        //                 r.right = new TreeNode(v);
        //                 return;
        //             }
        //             r = r.right;
        //         }
        //     }
        // }
        // public void dfs(TreeNode r) {
        //     if (r == null) return;
        //     dfs(r.left);
        //     dfs(r.right);
        //     int lsize = r.left != null ? r.left.size : 0;
        //     int rsize = r.right != null ? r.right.size : 0;
        //     int lans = r.left != null ? r.left.ans : 1;
        //     int rans = r.right != null ? r.right.ans : 1;
        //     r.ans = (int) (c[lsize + rsize][lsize] % mod * lans % mod * rans % mod);
        // }
        // class TreeNode {
        //     TreeNode left;
        //     TreeNode right;
        //     int val;
        //     int size;
        //     int ans;
        //     TreeNode(int v) {
        //         this.val = v;
        //         this.size = 1;
        //         this.ans = 0;
        //     }
        // }
        // static final int mod = (int)1e9 + 7;
        // long [] fac;
        // long [] inv;
        // long [] facInv;
        // public int numOfWays(int[] a) { // 这个方法还要再消化一下
        //     int n = a.length;
        //     if (n == 1) return 0;
        //     fac = new long[n];
        //     inv = new long[n];
        //     facInv = new long[n];
        //     fac[0] = inv[0] = facInv[0] = 1;
        //     fac[1] = inv[1] = facInv[1] = 1;
        //     for (int i = 2; i < n; ++i) {
        //         fac[i] = fac[i - 1] * i % mod;
        //         inv[i] = (mod - mod / i) * inv[mod % i] % mod;
        //         facInv[i] = facInv[i - 1] * inv[i] % mod;
        //     }
        //     Map<Integer, TreeNode> found = new HashMap<Integer, TreeNode>();
        //     UnionFind uf = new UnionFind(n);
        //     for (int i = n - 1; i >= 0; --i) {
        //         int val = a[i] - 1;
        //         TreeNode node = new TreeNode();
        //         if (val > 0 && found.containsKey(val - 1)) {
        //             int lchild = uf.getroot(val - 1);
        //             node.left = found.get(lchild);
        //             node.size += node.left.size;
        //             uf.findAndUnite(val, lchild);
        //         }
        //         if (val < n - 1 && found.containsKey(val + 1)) {
        //             int rchild = uf.getroot(val + 1);
        //             node.right = found.get(rchild);
        //             node.size += node.right.size;
        //             uf.findAndUnite(val, rchild);
        //         }
        //         int lsize = node.left != null ? node.left.size : 0;
        //         int rsize = node.right != null ? node.right.size : 0;
        //         int lans = node.left != null ? node.left.ans : 1;
        //         int rans = node.right != null ? node.right.ans : 1;
        //         node.ans = (int) (fac[lsize + rsize] * facInv[lsize] % mod * facInv[rsize] % mod * lans % mod * rans % mod);
        //         found.put(val, node);
        //     }

        //     return (found.get(a[0] - 1).ans - 1 + mod) % mod;
        // }
        // class UnionFind {
        //     public int[] parent;
        //     public int[] size;
        //     public int[] root;
        //     public int n;
        //     public UnionFind(int n) {
        //         this.n = n;
        //         parent = new int[n];
        //         size = new int[n];
        //         root = new int[n];
        //         Arrays.fill(size, 1);
        //         for (int i = 0; i < n; i++) {
        //             parent[i] = i;
        //             root[i] = i;
        //         }
        //     }
        //     public int findset(int x) {
        //         return parent[x] == x ? x : (parent[x] = findset(parent[x]));
        //     }
        //     public int getroot(int x) {
        //         return root[findset(x)];
        //     }
        //     public void unite(int x, int y) {
        //         root[y] = root[x];
        //         if (size[x] < size[y]) {
        //             int temp = x;
        //             x = y;
        //             y = temp;
        //         }
        //         parent[y] = x;
        //         size[x] += size[y];
        //     }
        //     public boolean findAndUnite(int x, int y) {
        //         int i = findset(x);
        //         int j = findset(y);
        //         if (i != j) {
        //             unite(i, j);
        //             return true;
        //         }
        //         return false;
        //     }
        // }
        // class TreeNode {
        //     TreeNode left;
        //     TreeNode right;
        //     int size;
        //     int ans;
        //     TreeNode() {
        //         size = 1;
        //         ans = 0;
        //     }
        // }

        // public int maxStudents(char[][] s) {
        //     int m = s.length, n = s[0].length, r = 1 << n;
        //     int [] rowMax = new int [m+1];
        //     for (int i = 0; i < m; i++) {
        //         int cur = 0;
        //         for (int j = 0; j < n; j++) 
        //             cur =  cur * 2 + (s[i][j] == '.' ? 1 : 0); // bug: () important
        //         // cur = (cur << 1) | (s[i][j] == '.' ? 1 : 0);// 上下两行：效果一样
        //         rowMax[i+1] = cur;
        //     }
        //     int [][] dp = new int [m+1][r];
        //     for (int i = 0; i <= m; i++) 
        //         Arrays.fill(dp[i], -1);
        //     dp[0][0] = 0;
        //     for (int i = 1; i <= m; i++) 
        //         for (int j = 0; j <= rowMax[i]; j++) // 遍历curMask（的所有子集）: 要保证它是rowMax[i]的有效子集
        //             if ((j & rowMax[i]) == j && (j & (j >> 1)) == 0) // 是每行可坐最多人数与布位的有效子集（&后=本身），并保证set位的左右无人
        //                 for (int k = 0; k <= rowMax[i-1]; k++)  // 遍历preMask（的所有子集）k是（i-1行的）有效子集，并且保证了当前位的左上方、和右上方无人
        //                     if (dp[i-1][k] != -1 && (j & (k >> 1)) == 0 && ((j >> 1) & k) == 0)
        //                         dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + Integer.bitCount(j));
        //     int max = 0;
        //     for (int i = 0; i < r; i++) 
        //         max = Math.max(max, dp[m][i]);
        //     return max;
        // }
        // public int maxStudents(char[][] seats) {
        //     m = seats.length;
        //     n = seats[0].length;
        //     int r = 1 << n;
        //     int [][] dp = new int [m+1][r];
        //     for (int i = 0; i <= m; i++) 
        //         Arrays.fill(dp[i], -1);
        //     dp[0][0] = 0;
        //     for (int i = 1; i <= m; i++) 
        //         for (int k = 0; k < r; k++) { 
        //             if (!isValid(seats, k, i-1)) continue; 
        //             if ((k & (k >> 1)) != 0) continue;  // BUG: 要保证每个set过的位左右无人,这一行不可少
        //             for (int j = 0; j < r; j++) {  
        //                 if (dp[i-1][j] == -1) continue; // 前一排坐位的遍历,j可能不是有效子集，比如坐墙上或左右有人
        //                 if (((k >> 1) & j) == 0 && (k & (j >> 1)) == 0)
        //                     dp[i][k] = Math.max(dp[i][k], dp[i-1][j] + Integer.bitCount(k));
        //             }
        //         }
        //     int max = 0;
        //     for (int i = 0; i < r; i++) 
        //         max = Math.max(max, dp[m][i]);
        //     return max;
        // }
        // int m, n;
        // private boolean isValid(char [][] arr, int v, int idx) { // 只是检查不会坐在樯上: 方法应该是对的，但可能会比较慢
        //     for (int i = 0; i < n; i++) 
        //         if (((v >> i) & 1) == 1 && arr[idx][i] != '.') return false;
        //     return true; 
        // }

        
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        // char [][] a = new char [][] {{'#','.','.','.','#'},{'.','#','.','#','.'},{'.','.','#','.','.'},{'.','#','.','#','.'},{'#','.','.','.','#'}};
        char [][] a = new char [][] {{'.','#','#'},{'#','#','#'},{'#','#','#'}}; 

        int r = s.maxStudents(a);
        System.out.println("r: " + r);
    }
}