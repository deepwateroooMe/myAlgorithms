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
//         public int maxStudents(char[][] s) { // todo: 再好好理解一下
//             // state代表某一行安排座椅的情况，用二进制表示
//             // int state = 1;
//             // // 求出state的最大值，即当前行每一列都安排座位的情况
//             // for (int c=0;c<s[0].length;c++){
//             //     state = ((1<<c) | state);
//             // }
//             // 利用行数和state的最大值初始化记忆数组
//             // memo=new int[s.length][state];
//             memo=new int[s.length][1 << s[0].length];
//             // 递归求解，从第0行第0列开始递归
//             // 即求出第0行第0列以及它后面一共最多可以安排座椅的最大数量
//             return help(s,0,0,0);
//         }
//         int[][] memo; // 记忆数组
// // r：当前行
// // c：当前列
// // rowState：当前行安排的座位状态
// // 返回值：当前位置及之后的位置一共可以安排座位的做大数量
//         int help(char[][] s, int r, int c, int rowState){
//             // 如果当前是某一行的第一列
//             if (c==0&&r>0){
//                 // 当前为第一列时，rowState值为上一行完整的座位安排情况
//                 // 查看记忆数组中是否存在上一行该座位安排情况的值
//                 // 如果存在，返回记忆数组中的值
//                 if (memo[r-1][rowState]>0) return memo[r-1][rowState];
//             }
//             // 当前位置字符
//             char ch = s[r][c];
//             // 计算下一个递归位置
//             int nextR=r, nextC=c;
//             // 如果当前列加一小于总列数
//             if (c+1<s[0].length){
//                 // 下一位置列数加一，行数不变
//                 nextC=c+1;
//             }else{ // 如果当前列加一超出总列数
//                 // 下一位置列数为0
//                 nextC=0;
//                 // 下一位置行数加一
//                 nextR=r+1;
//             }
//             // 查看当前位置是否可以安排座位
//             boolean canSit=canSit(s,r,c);
//             // 如果当前位置是矩阵最后一格（递归终止条件）
//             if (nextR==s.length){
//                 // 如果能安排座位返回1，否则返回0
//                 return canSit?1:0;
//             }
//             // 第一种选择，为当前位置安排座位
//             int count1=0;
//             // 如果当前位置能安排座位
//             if (canSit(s,r,c)){
//                 // 将当前位置设置为S，代表安排了座位
//                 s[r][c]='S';
//                 // 递归求解下一个位置以及之后位置一共能安排的做多座位数
//                 // 再加上一代表当前位置安排了一个座位
//                 count1=1+help(s, nextR,nextC,c==0?1:((rowState<<1)|1));
//                 // 递归结束后，将当前位置还原成原始字符，以便之后查询其他递归可能
//                 s[r][c]=ch;
//             }
//             // 第二种选择，不为当前位置安排座位
//             int count2=help(s, nextR,nextC,c==0?0:((rowState<<1)|0));
//             // 两种选择的最大值为当前结果
//             int res = Math.max(count1,count2);
//             // 如果当前是某一行的首列
//             if (c==0&&r>0){
//                 // 将当前结果计入记忆数组
//                 memo[r-1][rowState]=res;
//             }
//             return res;
//         }
// // 判断当前位置是否可以安排座位
//         boolean canSit(char[][] s, int r, int c){
//             if (s[r][c]=='#') return false;
//             if (r>0&&c>0) // 左前方有座位，当前不能安排座位
//                 if (s[r-1][c-1]=='S') return false;
//             if (r>0&&c<s[0].length-1) // 右前方有座位，当前不能安排座位
//                 if (s[r-1][c+1]=='S') return false;
//             // 右方有座位，当前不能安排座位
//             if (c>0)
//                 if (s[r][c-1]=='S') return false;
//             // 因为递归顺序是从上至下，从左至右，因此右方和下方都是空位不需判断
//             return true;
//         }

        // public String shortestSuperstring(String [] sa) { // 回塑: 暴搜+剪枝,但回塑仍然是最慢的方法
        //     n = sa.length;
        //     max = new int [n][n];
        //     for (int i = 0; i < n; i++) 
        //         for (int j = 0; j < n; j++) {
        //             if (i == j) continue;
        //             for (int k = Math.min(sa[i].length(), sa[j].length()); k >= 1; k--) // 不想遍历所有，找到一个有效最优解，就剪枝中断
        //                 if (sa[i].substring(sa[i].length()-k).equals(sa[j].substring(0, k))) {
        //                     max[i][j] = k; // sa[i] 的尾 与 sa[j]的头的 最长公共后前缀 长度
        //                     break;
        //                 }
        //         }                
        //     dp = new int [1 << n][n];
        //     ans = new int [n]; // 最终答案： 最小长度的字符串下标位置
        //     vis = new boolean [n];
        //     dfs(new int [n], 0, 0, 0);
        //     String s = sa[ans[0]];
        //     for (int i = 1; i < n; i++) { // 当前字符串的前缀已经被上一个字符串的后缀cover了，所以只取后没被覆盖住的后半部分
        //         int cmnLen = max[ans[i-1]][ans[i]];
        //         s += sa[ans[i]].substring(cmnLen);
        //     }
        //     return s;
        // }
        // int [][] dp;
        // int [][] max; // max common length between two strings
        // boolean [] vis;
        // int [] ans;
        // int n, maxLen = Integer.MIN_VALUE; // bug: has to be initialized 
        // private void dfs(int [] a, int idx, int sum, int state) {
        //     if (idx == n) {
        //         if (sum > maxLen) {
        //             maxLen = sum;
        //             // ans = Arrays.copyOf(a, n);
        //             ans = a.clone(); // 效果一样
        //         }
        //         return ;
        //     }
        //     for (int i = 0; i < n; i++) {
        //         if (vis[i]) continue;
        //         int mask = state | (1 << i);
        //         int curLen = sum + (idx == 0 ? 0 : max[a[idx-1]][i]);
        //         if (dp[mask][i] > 0 && dp[mask][i] >= curLen) continue; // == 的情况可以剪枝，因为dp[][]本来就是记忆着各路径状态下的全局最优解，不能更优就剪掉
        //         vis[i] = true;
        //         a[idx] = i;
        //         dp[mask][i] = curLen; // BUG: 需要这一行记忆化，加速搜索与剪枝，重中之重不可记忆, otherwise tle ！！！
        //         dfs(a, idx+1, curLen, mask);
        //         vis[i] = false;
        //     }
        // }
        // public String shortestSuperstring(String[] s) {
        //     int n = s.length;
        //     String [][] dp = new String [1 << n][n]; // 这个dp的设计还比较新颖奇特:
        //     int [][] max = new int [n][n];
        //     for (int i = 0; i < n; i++) 
        //         for (int j = 0; j < n; j++) {
        //             if (i == j) continue;
        //             for (int k = Math.min(s[i].length(), s[j].length()); k >= 1; k--) 
        //                  if (s[i].substring(s[i].length()-k).equals(s[j].substring(0, k))) {
        //                     max[i][j] = k;
        //                     break;
        //                 }
        //         }
        //     for (int i = 0; i < n; i++) dp[1 << i][i] = s[i]; // 初始化：每个字符串与自己的最长公共后前缀串就是它本身
        //     for (int r = 1; r < 1 << n; r++) 
        //         for (int i = 0; i < n; i++) {
        //             if (((r >> i) & 1) == 0) continue;
        //             for (int j = 0; j < n; j++) {
        //                 if (i == j || (((r >> j) & 1) == 0)) continue; // 保证状态r是包含了字符串i和j的有效state
        //                 String cur = dp[r ^ (1 << j)][i] + s[j].substring(max[i][j]);
        //                 if (dp[r][j] == null || dp[r][j].length() > cur.length()) // dp[i][j]: 这里比较字符串的长度操作起来就比较复杂一点儿
        //                     dp[r][j] = cur;
        //             }
        //         }
        //      int r = (1 << n) - 1;
        //     String ans = dp[r][0];
        //     for (int i = 1; i < n; i++) 
        //         if (dp[r][i].length() < ans.length()) ans = dp[r][i];
        //     return ans;
        // }
        // public String shortestSuperstring(String[] A) {
        //     int N = A.length;
        //     int[][] overlaps = new int[N][N];
        //     for (int i = 0; i < N; ++i)
        //         for (int j = 0; j < N; ++j) if (i != j) {
        //                 int m = Math.min(A[i].length(), A[j].length());
        //                 for (int k = m; k >= 0; --k)
        //                     if (A[i].endsWith(A[j].substring(0, k))) {
        //                         overlaps[i][j] = k;
        //                         break;
        //                     }
        //             }
        //     int[][] dp = new int[1<<N][N]; // dp[mask][i] = most overlap with mask, ending with ith element
        //     int[][] parent = new int[1<<N][N];
        //     for (int mask = 0; mask < (1<<N); ++mask) {
        //         Arrays.fill(parent[mask], -1);
        //         for (int bit = 0; bit < N; ++bit) if (((mask >> bit) & 1) > 0) {
        //                 // Let's try to find dp[mask][bit].  Previously, we had a collection of items represented by pmask.
        //                 int pmask = mask ^ (1 << bit);
        //                 if (pmask == 0) continue;
        //                 for (int i = 0; i < N; ++i) if (((pmask >> i) & 1) > 0) {
        //                         // For each bit i in pmask, calculate the value if we ended with word i, then added word 'bit'.
        //                         int val = dp[pmask][i] + overlaps[i][bit];
        //                         if (val > dp[mask][bit]) {
        //                             dp[mask][bit] = val;
        //                             parent[mask][bit] = i;
        //                         }
        //                     }
        //             }
        //     }
        //     // # Answer will have length sum(len(A[i]) for i) - max(dp[-1])
        //     // Reconstruct answer, first as a sequence 'perm' representing the indices of each word from left to right.
        //     int[] perm = new int[N];
        //     boolean[] vis = new boolean[N];
        //     int t = 0;
        //     int mask = (1 << N) - 1;
        //     // p: the last element of perm (last word written left to right)
        //     int p = 0;
        //     for (int j = 0; j < N; ++j)
        //         if (dp[(1<<N) - 1][j] > dp[(1<<N) - 1][p])
        //             p = j;
        //     // Follow parents down backwards path that retains maximum overlap
        //     while (p != -1) {
        //         perm[t++] = p;
        //         vis[p] = true;
        //         int p2 = parent[mask][p];
        //         mask ^= 1 << p;
        //         p = p2;
        //     }
        //     // Reverse perm
        //     for (int i = 0; i < t/2; ++i) {
        //         int v = perm[i];
        //         perm[i] = perm[t-1-i];
        //         perm[t-1-i] = v;
        //     }
        //     // Fill in remaining words not yet added
        //     for (int i = 0; i < N; ++i)
        //         if (!vis[i]) perm[t++] = i;
        //     // Reconstruct final answer given perm
        //     StringBuilder ans = new StringBuilder(A[perm[0]]);
        //     for (int i = 1; i < N; ++i) {
        //         int overlap = overlaps[perm[i-1]][perm[i]];
        //         ans.append(A[perm[i]].substring(overlap));
        //     }
        //     return ans.toString();
        // }
        // // String r = s.shortestSuperstring(a);
        // // String []  a = new String []  {"cedefifgstkyxfcuajfa", "ooncedefifgstkyxfcua", "assqjfwarvjcjedqtoz", "fcuajfassqjfwarvjc", "fwarvjcjedqtozctcd", "zppedxfumcfsngp", "kyxfcuajfassqjfwa", "fumcfsngphjyfhhwkqa", "fassqjfwarvjcjedq", "ppedxfumcfsngphjyf", "dqtozctcdk"};

        // public int minimumMountainRemovals(int[] a) {
        //     int n = a.length;
        //     int [] up = new int [n];
        //     int [] dn = new int [n];
        //     Arrays.fill(up, 1);
        //     Arrays.fill(dn, 1);
        //     for (int i = 1; i < n; i++) 
        //         for (int j = 0; j < i; j++) 
        //             if (a[j] < a[i])
        //                 up[i] = Math.max(up[i], up[j] + 1);
        //     for (int i = n-2; i >= 0; i--) 
        //         for (int j = i+1; j < n; j++) 
        //             if (a[i] > a[j])
        //                 dn[i] = Math.max(dn[i], dn[j] + 1);
        //     int min = n;
        //     for (int i = 1; i < n-1; i++)
        //         if (up[i] != 1 && dn[i] != 1)
        //             min = Math.min(min, n - (up[i] + dn[i] -1));
        //     return min;
        // }

        // public int maxSumBST(TreeNode root) { // 注意： 不要画蛇添足再嵌套一层树的遍历
        //     traverse(root);
        //     return max < 0 ? 0 : max;
        // }
        // int max = Integer.MIN_VALUE;
        // private Rn traverse(TreeNode r) {
        //     if (r == null) return null;
        //     if (r.left == null && r.right == null) {
        //         if (r.val > max) max = r.val;
        //         return new Rn(r.val, true, r.val, r.val);
        //     }
        //     Rn left = traverse(r.left);
        //     Rn right = traverse(r.right);
        //     if (left == null || right == null) {
        //         boolean isBst = left == null ? right.bst && right.min > r.val : left.bst && left.max < r.val;
        //         int sum = isBst ? (left == null ? right.sum : left.sum) + r.val : (left == null ? right.sum : left.sum);
        //         if (sum > max) max = sum;
        //         return new Rn(sum, isBst, 
        //                       Math.min(r.val, (left == null ? right.min : left.min)),
        //                       Math.max(r.val, (left == null ? right.max : left.max)));
        //     }
        //     boolean isBst = left.bst && left.max < r.val && right.bst && right.min > r.val;
        //     int sum = isBst ? left.sum + right.sum + r.val :
        //         (left.bst && right.bst ? Math.max(left.sum, right.sum) :
        //          (left.bst ? left.sum :
        //           (right.bst ? right.sum : Math.max(left.sum, right.sum))));
        //     if (isBst && sum > max) max = sum;
        //     else if (left.bst && left.sum > max || right.bst && right.sum > max) {
        //         // sum = left.bst ? left.sum : right.sum; // BUG: not suppose to change the sum value here, skip this line
        //         max = Math.max(max, left.bst ? left.sum : right.sum);
        //     }
        //     return new Rn(sum, isBst, 
        //                   Math.min(r.val, Math.min(left.min, right.min)),
        //                   Math.max(r.val, Math.max(left.max, right.max)));
        // }
        // public class Rn {
        //     int sum;
        //     boolean bst;
        //     int min, max;// from left
        //     public Rn(int a, boolean b, int c, int d) {
        //         sum = a;
        //         bst = b;
        //         min = c;
        //         max = d;
        //     }
        // }
        // private int res;
        // public int maxSumBST(TreeNode root) {
        //     dfs(root);
        //     return res;
        // }
        // private int[] dfs(TreeNode r) {
        //     if (r == null) return null; // [bst_1/0, sum, min, max]
        //     int[] left = dfs(r.left), right = dfs(r.right); // 递归求解左右子树的信息
        //     int[] ans = {1, r.val, r.val, r.val};
        //     // 判断一下r子树是否是BST，如果不是，就不用再继续了，直接返回
        //     if (left != null && (left[3] >= r.val || left[0] == 0) || right != null && (right[2] <= r.val || right[0] == 0)) {
        //         ans[0] = 0;
        //         return ans;
        //     }
        //     // 否则r节点构成的子树是BST，更新其信息
        //     ans[1] += (left != null ? left[1] : 0) + (right != null ? right[1] : 0); // sum
        //     if (left != null) ans[2] = left[2];   // min
        //     if (right != null) ans[3] = right[3]; // max
        //     // 由于r子树是BST，所以用其数值总和更新答案
        //     res = Math.max(res, ans[1]);
        //     return ans;
        // }

        // public int racecar(int t) { // 这个题： 什么时候考虑重复，跟扫描线、青蛙跳类一起总结一下
        //     Queue<int []> q = new LinkedList<>();
        //     Set<String> vis = new HashSet<>();
        //     q.offer(new int [] {0, 1});
        //     vis.add("0_1");
        //     vis.add("0_-1"); //
        //     int cnt = 0;
        //     while (true) {
        //         for (int size = q.size()-1; size >= 0; size--) {
        //             int [] cur = q.poll();
        //             int p = cur[0], s = cur[1];
        //             if (p + s == t) return cnt + 1;
        //             int pos = p + s, spe = s * 2;
        //             String tmp = pos + "_" + spe;
        //             if (pos > 0 && pos < t * 2)
        //                 q.offer(new int [] {pos, spe});
        //             pos = p; // 只有转换方向的时候才考虑重复的问题
        //             spe = s > 0 ? -1 : 1;
        //             tmp = pos + "_" + spe;
        //             if (!vis.contains(tmp)) {
        //                 q.offer(new int [] {pos, spe});
        //                 vis.add(tmp);
        //             }
        //         }
        //         cnt++;
        //     }
        // }

        // static final int mod = (int)1e9 + 7; // 感觉test case 很弱
        // public int distinctSubseqII(String t) { // 每个当前字符，可出现、或不出现在子序列中，两种情况 * 之前的结束，对重复出现字符的处理
        //     int n = t.length();
        //     char [] s = ("#" + t).toCharArray();
        //     int [] preIdx = new int [26];
        //     Arrays.fill(preIdx, -1);
        //     long [] dp = new long [n+1];
        //     dp[0] = 1; // 引子 {}
        //     for (int i = 1; i <= n; i++) {
        //         int j = preIdx[s[i] - 'a'];
        //         dp[i] = (2 * dp[i-1] % mod - (j != -1 ? dp[j-1] : 0) + mod) % mod; // 还没能想很透这里的j不是应该需要是 j >= 1 的吗？
        //         preIdx[s[i]-'a'] = i;
        //     }
        //     return (int)dp[n] - 1;
        // }

        // public String largestNumber(int[] cost, int target) { // bug
        //     n = cost.length;
        //     dp = new String [target + 1];
        //     return dfs(target, cost);
        // }
        // String [] dp;
        // int n;
        // private String dfs(int i, int [] a) {
        //     if (i == 0) return "";
        //     if (dp[i] != null) return dp[i];
        //     String ans = "";
        //     // for (int j = 0; j < a.length; j++) {
        //         for (int j = a.length-1; j >= 0; j--) {
        //         if (i < a[j]) continue;
        //         String cur = dfs(i - a[j], a);
        //         if (cur.equals("0")) continue;
        //         // cur = "" + (j+1) + cur; // 加在前面加在后面关系不大
        //         cur += (j+1); // 将子问题解加上当前选择的数字
        //         if (cur.length() >= ans.length()) {
        //             if (cur.length() > ans.length() || cur.length() == ans.length() && cur.compareTo(ans) > 0) // 如果当前解大于max，更新max值
        //                 ans = cur;
        //         }
        //     }
        //     if (ans.equals("")) ans = "0"; // 这个细节不能忘
        //     return dp[i] = ans;
        // }
        // // https://leetcode-cn.com/problems/form-largest-integer-with-digits-that-add-up-to-target/solution/shu-wei-cheng-ben-he-wei-mu-biao-zhi-de-dnh86/
        // public String largestNumber(int[] cost, int target) { // todo: 官方题解及优化
        //     int[][] dp = new int[10][target + 1];
        //     for (int i = 0; i < 10; ++i) 
        //         Arrays.fill(dp[i], Integer.MIN_VALUE);
        //     int [][] from = new int[10][target + 1];
        //     dp[0][0] = 0;
        //     for (int i = 0; i < 9; ++i) {
        //         int c = cost[i];
        //         for (int j = 0; j <= target; ++j) {
        //             if (j < c) {
        //                 dp[i + 1][j] = dp[i][j];
        //                 from[i + 1][j] = j;
        //             } else {
        //                 if (dp[i][j] > dp[i + 1][j - c] + 1) {
        //                     dp[i + 1][j] = dp[i][j];
        //                     from[i + 1][j] = j;
        //                 } else {
        //                     dp[i + 1][j] = dp[i + 1][j - c] + 1;
        //                     from[i + 1][j] = j - c;
        //                 }
        //             }
        //         }
        //     }
        //     if (dp[9][target] < 0) return "0";
        //     StringBuffer sb = new StringBuffer();
        //     int i = 9, j = target;
        //     while (i > 0) {
        //         if (j == from[i][j]) {
        //             --i;
        //         } else {
        //             sb.append(i);
        //             j = from[i][j];
        //         }
        //     }
        //     return sb.toString();
        // }
        // public String largestNumber(int[] cost, int target) {
        //     int n = cost.length;
        //     int [] dp = new int [target + 1];
        //     Arrays.fill(dp, -1);
        //     dp[0] = 0;
        //     for (int i = 0; i < n; i++) 
        //         for (int j = cost[i]; j <= target; j++) 
        //             if (dp[j - cost[i]] >= 0) // dp loop出由target可以组装出的最大长度
        //                 dp[j] = Math.max(dp[j], dp[j-cost[i]] + 1);
        //     if (dp[target] == -1) return "0";
        //     char [] a = new char [dp[target]];
        //     int leftOver = target;
        //     for (int i = 0; i < dp[target]; i++) // ans array a idx loop
        //         for (int j = n; j > 0; j--)      // tracing back the longest path,再根据dp出的最大长度找出原始最长及最大路径， 数字由大到小
        //             if (leftOver  >= cost[j-1] && dp[leftOver] == dp[leftOver - cost[j-1]] + 1) {
        //                 a[i] = (char)('0' + j);
        //                 leftOver -= cost[j-1];
        //                 break;
        //             }
        //     return String.valueOf(a);
        // }
        // public String largestNumber(int[] cost, int target) {
        //     int[] dp = new int[target + 1];
        //     Arrays.fill(dp, Integer.MIN_VALUE);
        //     dp[0] = 0;
        //     for (int c : cost) 
        //         for (int j = c; j <= target; ++j) 
        //             dp[j] = Math.max(dp[j], dp[j - c] + 1);
        //     if (dp[target] < 0) return "0";
        //     StringBuffer sb = new StringBuffer(); // 这种写法还是很流畅的
        //     for (int i = 8, j = target; i >= 0; i--) 
        //         for (int c = cost[i]; j >= c && dp[j] == dp[j - c] + 1; j -= c) 
        //             sb.append(i + 1);
        //     return sb.toString();
        // }

        // static final int mod = (int)1e9 + 7;
        // public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        //     int m = group.length, ans = 0;
        //     int [][][] dp = new int [m+1][n+1][minProfit+1];
        //     dp[0][0][0] = 1;
        //     for (int i = 1; i <= m; i++) {   // 遍历每桩案件
        //         int g = group[i-1], p = profit[i-1];
        //         for (int j = 0; j <= n; j++) // 遍历人数
        //             for (int k = 0; k <= minProfit; k++) {
        //                 dp[i][j][k] = dp[i-1][j][k];
        //                 if (j >= g)   // 在本桩案件人手够用的前提下，办与不办此案的方案数相加
        //                     dp[i][j][k] = (dp[i][j][k] + dp[i-1][j-g][Math.max(0, k-p)]) % mod;
        //             }
        //     }
        //     for (int i = 0; i <= n; i++) 
        //         ans = (ans + dp[m][i][minProfit]) % mod;
        //     return ans;
        // }
        // static final int mod = (int)1e9 + 7;
        // public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        //     int m = group.length, ans = 0;
        //     int [][] dp = new int [n+1][minProfit+1];
        //     dp[0][0] = 1;
        //     for (int i = 1; i <= m; i++) {   // 遍历每桩案件
        //         int g = group[i-1], p = profit[i-1];
        //         for (int j = n; j >= g; j--)  // 当压缩了一维空间，从后往前遍历以免产生赃数据
        //             for (int k = minProfit; k >= 0; k--) 
        //                 dp[j][k] = (dp[j][k] + dp[j-g][Math.max(0, k-p)]) % mod;
        //     }
        //     for (int i = 0; i <= n; i++) 
        //         ans = (ans + dp[i][minProfit]) % mod;
        //     return ans;
        // }
        // public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        //     m = group.length;
        //     this.n = n;
        //     this.minProfit = minProfit;
        //     dp = new int [m+1][n+1][minProfit+1];
        //     for (int i = 0; i <= m; i++) 
        //         for (int j = 0; j <= n; j++) 
        //             Arrays.fill(dp[i][j], Integer.MIN_VALUE);
        //     return dfs(m, n, minProfit, group, profit);
        // }
        // static final int mod = (int)1e9 + 7;
        // int m, n, minProfit;
        // int [][][] dp;
        // private int dfs(int i, int j, int k, int [] group, int [] profit) {
        //     if (i == 0) return k <= 0 ? 1 : 0;
        //     if (k < 0) k = 0;
        //     if (dp[i][j][k] != Integer.MIN_VALUE) return dp[i][j][k];
        //     int g = group[i-1], p = profit[i-1];
        //     int ans = dfs(i-1, j, k, group, profit);
        //     if (j >= g)
        //         ans = (ans + dfs(i-1, j-g, Math.max(0, k-p), group, profit)) % mod;
        //     return dp[i][j][k] = ans;
        // }

        // public boolean canDistribute(int [] a, int[] quantity) {
        //     for (Integer v : a)
        //         m.put(v, m.getOrDefault(v, 0) + 1);
        //     n = m.size();
        //     cnt = new int [n];
        //     int idx = 0;
        //     for (Integer v : m.values()) cnt[idx++] = v;
        //     Arrays.sort(cnt);
        //     Arrays.sort(quantity);
        //     if (quantity[quantity.length-1] > cnt[n-1]) return false;
        //     return dfs(quantity.length-1, quantity);
        // }
        // Map<Integer, Integer> m = new HashMap<>();
        // int [] cnt;
        // int n;
        // private boolean dfs(int i, int [] quantity) {
        //     if (i < 0) return true;
        //     Set<Integer> vis = new HashSet<>(); // 忘记这个了，是否与下面行效果一样呢？
        //     for (int j = n-1; j >= 0; j--) {
        //         if (vis.contains(cnt[j])) continue;
        //         vis.add(cnt[j]);
        //         // if (j < n-1 && cnt[j] == cnt[j+1]) continue; // 应该是用了vis.这个就可以不用了
        //         if (cnt[j] < quantity[i]) continue;
        //         cnt[j] -= quantity[i];
        //         if (dfs(i-1, quantity)) return true;
        //         cnt[j] += quantity[i];
        //     }
        //     return false;
        // }
        // public boolean canDistribute(int [] a, int[] quantity) { 
        //     Map<Integer, Integer> map = new HashMap<>();
        //     for (Integer v : a)
        //         map.put(v, map.getOrDefault(v, 0) + 1);
        //     int n = map.size(), idx = 0, m = quantity.length, r = 1 << m;
        //     int [] cnt = new int [n];
        //     for (Integer v : map.values()) cnt[idx++] = v;
        //     int [] sum = new int [r];
        //     for (int i = 1; i < r; i++) 
        //         for (int j = 0; j < m; j++) 
        //             if (((i >> j) & 1) == 1) {
        //                 int left = i - (1 << j);
        //                 sum[i] = sum[left] + quantity[j];
        //                 break;
        //             }
        //     boolean [][] dp = new boolean [n][r]; // dp[i][j] 表示：cnt 数组中的前i个元素，能否满足顾客的子集合 j 的订单需求
        //     for (int i = 0; i < n; i++) 
        //         dp[i][0] = true;
        //     for (int i = 0; i < n; i++)       // 遍历 cnt数组
        //         for (int j = 0; j < r; j++) { // 遍历客户组合子集
        //             if (i > 0 && dp[i-1][j]) {
        //                 dp[i][j] = true;
        //                 continue;
        //             }
        //             for (int k = j; k != 0; k = ((k-1) & j)) { // 子集s枚举，详见 https://oi-wiki.org/math/bit/#_14
        //                 int pre = j - k; // 前 i-1 个元素需要满足子集 prev = j-s
        //                 boolean last = (i == 0) ? (pre == 0) : dp[i-1][pre]; // cnt[0..i-1] 能否满足子集 prev
        //                 boolean need = sum[k] <= cnt[i]; // cnt[i] 能否满足子集 s
        //                 if (last && need) {
        //                     dp[i][j] = true;
        //                     break;
        //                 }
        //             }
        //         }
        //     return dp[n-1][r-1];
        // }

        // static final int mod = (int)1e9 + 7;
        // public int numPermsDISequence(String t) {
        //     int n = t.length(), ans = 0;
        //     char [] s = t.toCharArray();
        //     int [][] dp = new int [n+1][n+1];
        //     dp[0][0] = 1;
        //     for (int i = 1; i <= n; i++) 
        //         for (int j = 0; j <= i; j++) { // 当前最后一个元素是j
        //             if (s[i-1] == 'D')
        //                 for (int k = j; k <= i; k++)
        //                     dp[i][j] = (dp[i][j] + dp[i-1][k]) % mod;
        //             else for (int k = 0; k < j; k++)
        //                      dp[i][j] = (dp[i][j] + dp[i-1][k]) % mod;
        //         }
        //     for (int i = 0; i <= n; i++) 
        //         ans = (ans + dp[n][i]) % mod;
        //     return (int) ans;
        // }
        // static final int mod = (int)1e9 + 7;
        // public int numPermsDISequence(String t) {
        //     int n = t.length(), ans = 0;
        //     char [] s = t.toCharArray();
        //     int [][] dp = new int [n + 1][n + 1];
        //     dp[0][0] = 1;
        //     for (int i = 1; i <= n; i ++) 
        //         if (s[i - 1] == 'D') 
        //             for (int j = i - 1 ; j >= 0 ; j --)
        //                 dp[i][j] = (dp[i][j + 1] + dp[i - 1][j]) % mod;
        //         else for (int j = 1; j <= i; j ++)
        //                 dp[i][j] = (dp[i][j - 1] + dp[i - 1][j - 1]) % mod;
        //     for (int i = 0 ; i <= n ; i ++)
        //         ans = (ans + dp[n][i]) % mod;
        //     return ans;
        // }
        // static final int mod = (int)1e9 + 7;
        // public int numPermsDISequence(String t) {
        //     int n = t.length(), ans = 0;
        //     char [] s = t.toCharArray();
        //     long [][] dp = new long [n+1][n+1];
        //     long [][] c = new long [n+2][n+2];
        //     for (int i = 0; i <= n; i++)
        //         dp[i][i] = 1;
        //     for (int i = 0; i <= n+1; i++) {
        //         c[i][0] = 1;
        //         for (int j = 1; j <= i; j++) 
        //             c[i][j] = (int)((c[i-1][j] + c[i-1][j-1]) % mod);
        //     }
        //     for (int len = 2; len <= n+1; len++) 
        //         for (int i = 0; i+len-1 <= n; i++) {
        //             int j = i + len - 1;
        //             if (s[i] == 'D')   // 如果s[i] = 'D'，那么最大的元素可以放在p[i]上。dp[i][j] += dp[i + 1][j]
        //                 dp[i][j] = (dp[i][j] + dp[i+1][j]) % mod;
        //             if (s[j-1] == 'I') // 如果s[j - 1] = 'I'，那么最大的元素可以放在p[j]上。dp[i][j] += dp[i][j - 1]
        //                 dp[i][j] = (dp[i][j] + dp[i][j-1]) % mod;
        //             for (int k = i+1; k <= j-1; k++)
        //                 if (s[k-1] == 'I' && s[k] == 'D')
        //                     dp[i][j] = (dp[i][j] + (1l * c[len-1][k-i]) * dp[i][k-1] % mod * dp[k+1][j] % mod) % mod;
        //         }
        //     return (int)dp[0][n];
        // }

        // public int numMusicPlaylists(int n, int goal, int k) {
        //     long mod = (int)1e9 + 7;
        //     long [][] dp = new long [goal+1][n+1]; // dp[i][j]: 播完i首用了j首不同的曲子，分第i首播不播第j首两种情况 (i >= j for sure)
        //     for (int i = 1; i <= goal; i++) 
        //         for (int j = 1; j <= n; j++) {
        //             if (i < j) dp[i][j] = 0; // 这行不能省略   
        //             else if (i == 1 && j == 1) dp[i][j] = n; // 用1首歌放完1次，共有n种不同的选择
        //             else if (i > 1 && j == 1) {
        //                 if (k == 0) dp[i][j] = n; // 相当于没有任何外加限制条件
        //                 // else dp[i][1] = 0;     // 这行可略
        //             } else // 分两种情况： 第i首不播第j首歌（那么可以从前面j-k首里面选择一首），和第i首播第j首歌（第j首就可以从不曾播放过的n-(j-1)首里面选择一首播放）
        //                 dp[i][j] = (dp[i-1][j] * Math.max(j-k, 0) + (j == 0 ? 0 : dp[i-1][j-1] * (n - (j-1)))) % mod;
        //         }
        //     return (int)dp[goal][n];
        // }
        // static final int mod = (int)1e9 + 7;
        // public int numMusicPlaylists(int n, int goal, int k) {
        //     long [][] dp = new long [goal+1][n+1]; // dp[i][j]: 播完i首用了j首不同的曲子，分第i首播不播第j首两种情况 (i >= j for sure)
        //     dp[0][0] = 1;
        //     for (int i = 1; i <= goal; i++) 
        //         for (int j = 1; j <= n; j++) {
        //             dp[i][j] = (dp[i-1][j-1] * (n - (j-1))) % mod; // 第j首放新歌
        //             if (j > k)                                     // 第j首放（j-k）之前的某首歌
        //                 dp[i][j] = (dp[i][j] + dp[i-1][j] * (j-k)) % mod;
        //         }
        //     return (int)dp[goal][n];
        // }

        // public int findRotateSteps(String ring, String key) { // dfs
        //     m = ring.length();
        //     n = key.length();
        //     char [] s = ring.toCharArray();
        //     for (int i = 0; i < m; i++) {
        //         if (key.indexOf(s[i]) == -1) continue; // 只记录在key中出现过的字母的位置
        //         idx.computeIfAbsent(s[i], z -> new ArrayList<>()).add(i);
        //     }
        //     dp = new int [m][n];
        //     return dfs(0, 0, ring, key);
        // }
        // Map<Character, List<Integer>> idx = new HashMap<>();
        // int [][] dp;
        // int m, n;
        // private int dfs(int i, int j, String s, String t) {
        //     if (j == n) return 0;
        //     if (dp[i][j] > 0) return dp[i][j];
        //     int ans = Integer.MAX_VALUE;
        //     for (Integer v : idx.get(t.charAt(j))) 
        //         ans = Math.min(ans, dfs(v, j+1, s, t) + getDist(v, i) + 1); // + 1 for confirm push
        //     return dp[i][j] = ans;
        // }
        // private int getDist(int i, int j) {
        //     int min = Math.min(i, j), max = Math.max(i, j);
        //     return Math.min(Math.abs(i - j), Math.abs(m - max + min)); 
        // }
        // public int findRotateSteps(String ring, String key) { // dfs
        //     int m = key.length(), n = ring.length();
        //     char [] s = key.toCharArray();
        //     char [] t = ring.toCharArray();
        //     int [][] dp = new int [m+1][n];
        //     int dif = 0, cnt = 0;
        //     for (int i = m-1; i >= 0; i--) 
        //         for (int j = 0; j < n; j++) { // j 是固定在12点钟表盘的位置
        //             dp[i][j] = Integer.MAX_VALUE;
        //             for (int k = 0; k < n; k++) 
        //                 if (s[i] == t[k]) {
        //                     dif = Math.abs(j - k);
        //                     cnt = Math.min(dif, n - dif);
        //                     dp[i][j] = Math.min(dp[i][j], cnt + dp[i+1][k]);
        //                 }
        //         }
        //     return dp[0][0] + m;
        // }

        // public double new21Game(int n, int k, int m) { // m: maxPts
        //     if (k == 0 || n >= (k + m)) return 1.0;
        //     if (k > n) return 0;
        //     double [] dp = new double [n+1];
        //     dp[0] = 1.0;
        //     double sum = 1, ans = 0;
        //     for (int i = 1; i <= n; i++) {
        //         dp[i] = sum / m;
        //         if (i < k) sum += dp[i];
        //         else ans += dp[i];
        //         if (i >= m) sum -= dp[i-m];
        //     }
        //     return ans;
        // }

        // public int minimumOneBitOperations(int n) { // O(logN)
        //     if (n == 0) return 0;
        //     int k = 1;
        //     while (k << 1 <= n)
        //         k <<= 1;
        //     return minimumOneBitOperations(k ^ (k >> 1) ^ n) + k;
        // }
        // public int minimumOneBitOperations(int n) {
        //     int ans = 0;
        //     while (n > 0) {
        //         ans ^= n;
        //         n /= 2;
        //     }
        //     return ans;
        // }

        // public int dieSimulator(int n, int [] r) { // dfs记忆化搜索：数据传递时，自顶向下传递的同一个值出现的次数， 与自底向上返回的方案数的交互，要熟悉起来，
        //     dp = new Integer [7][16][n+1]; // 最开始的dp定义想的是对的， 与房子涂成几个街区类似
        //     return (int)dfs(0, 0, n, r);
        // }
        // static final int mod = (int)1e9 + 7;
        // Integer [][][] dp;
        // private long dfs(int i, int j, int k, int [] cnt) { // i: val, j: continuous cnt, k: cnt out of n times
        //     if (k == 0) return 1;
        //     if (dp[i][j][k] != null) return dp[i][j][k];
        //     long ans = 0;
        //     for (int x = 1; x <= 6; x++) {
        //         if (x == i && cnt[x-1] > j)
        //             ans = (ans + dfs(x, j+1, k-1, cnt)) % mod;
        //         else if (x != i)
        //             ans = (ans + dfs(x, 1, k-1, cnt)) % mod;
        //     }
        //     return dp[i][j][k] = (int)ans;
        // }
        // (动态规划) O(nm)
        // f(i,j,k) 表示前 i 次投，最后一次结果为 j 且最后的数字连续了 k 次的方案数。
        // 初始时，f(0,j,1) = 1，其余均为 0。
        // 转移时，对于每一个 i和 j，枚举上一次最后的结果 t，如果 j==t，则转移f(i,j,k)=f(i,j,k)+f(i−1,j,k−1)；否则f(i,j,1)=f(i,j,1)+f(i−1,t,k)。
        //     最终答案为f(n−1,j,k) 的总和。
        // static final long mod = (int)1e9 + 7;
        // public int dieSimulator(int n, int [] r) { // 因为第三个限制条件的出现，而增加到三维dp[i][j][k]题型 ，总结一下
        //     long [][][] dp = new long [n][6][16]; 
        //     for (int i = 0; i < 6; i++) dp[0][i][1] = 1; // 第一次投掷，各个数出现一次的次数均为1
        //     for (int i = 1; i < n; i++) 
        //         for (int j = 0; j < 6; j++) 
        //             for (int x = 0; x < 6; x++)  // x t: 把它当作上一次的最后结果 
        //                 if (j == x) 
        //                     for (int k = 2; k <= r[j]; k++) 
        //                         dp[i][j][k] = (dp[i][j][k] + dp[i-1][j][k-1]) % mod;
        //                 else for (int k = 1; k <= r[x]; k++) // 因为是新的数字出现，没有任何限制，所以把前面的结果全累积起来
        //                         dp[i][j][1] = (dp[i][j][1] +  dp[i-1][x][k]) % mod;
        //     long ans = 0;
        //     for (int j = 0; j < 6; j++)
        //         for (int k = 1; k <= r[j]; k++) 
        //             ans = (ans + dp[n-1][j][k]) % mod;
        //     return (int) ans;
        // }

//         // 把二维数组按行或列拆成多个一维数组，然后利用一维数组的累加和来找符合要求的数字，
//         // 这里用了 lower _ bound 来加快的搜索速度，也可以使用二分搜索法来替代。
//         public int maxSumSubmatrix(int[][] mat, int target) {
//             int x = mat.length, y = mat[0].length, ans = Integer.MIN_VALUE;
//             boolean flag = x <= y;
//             int m = Math.min(x, y), n = Math.max(x, y);
//             int [] sum = new int [n]; // 定义一维大的数组
//             TreeSet<Integer> ts = new TreeSet<>();
//             for (int i = 0; i < m; i++) { // 找从第 i 行开始一直到第 0 行这 i+1 行的可能组成的矩形长度
//                 Arrays.fill(sum, 0);
//                 for (int j = i; j >= 0; j--) { // 遍历行: 行的和的累加是通过每列列的和的累加sum数组的值来实现的
//                     ts.clear();
//                     ts.add(0);
//                     int cur = 0;
// // 因为要满足 （ sum-set 中的元素） <=target,
// // 而且 sum-set 中的元素的值要尽可能的大，sum - target <= setElement(要set中的元素，尽可能地小)
// // 所以也就是在求大于等于 sum-target 中满足条件的元素的最小的一个
// // 正好 TreeSet 中提供了这个方法 ceil() ，可以很方便的找出这个元素： 返回大于或等于e的最小元素；如果没有这样的元素，则返回null
//                     for (int k = 0; k < n; k++) { // 遍历列： 原始矩阵的行的和，或者是列的和，比较长的大的那一维的和
//                         if (flag) sum[k] += mat[j][k];
//                         else sum[k] += mat[k][j];
//                         cur += sum[k];
//                         Integer tmp = ts.ceiling(cur - target);
//                         if (tmp != null) ans = Math.max(ans, cur - tmp);
//                         ts.add(cur);
//                     }
//                 }
//             }
//             return ans;
//         }
        // public int maxSumSubmatrix(int[][] mat, int target) { // 这么再看一下，就清清楚楚地啦
        //     int m = mat.length, n = mat[0].length, ans = Integer.MIN_VALUE;
        //     int M = Math.min(m, n), N = Math.max(m, n);
        //     for (int i = 0; i < M; i++) {
        //         int [] sum = new int [N];
        //         for (int j = i; j < M; j++) {
        //             TreeSet<Integer> ts = new TreeSet<>();
        //             int cur = 0;
        //             for (int k = 0; k < N; k++) {
        //                 sum[k] += m > n ? mat[k][j] : mat[j][k];
        //                 cur += sum[k];
        //                 if (cur <= target) ans = Math.max(ans, cur);
        //                 Integer tmp = ts.ceiling(cur - target);
        //                 if (tmp != null) ans = Math.max(ans, cur - tmp);
        //                 ts.add(cur);
        //             }
        //         }
        //     }
        //     return ans;
        // }

        // static final int mod = (int)1e9 + 7;
        // public int numberWays(List<List<Integer>> hats) {
        //     int n = hats.size(), r = 1 << n;
        //     Map<Integer, List<Integer>> m = new HashMap<>(); // [k, v]: [帽子id, List<Integer> persons]
        //     List<Integer> id = new ArrayList<>();
        //     for (int i = 0; i < n; i++) {
        //         List<Integer> l = hats.get(i);
        //         for (Integer v : l) {
        //             m.computeIfAbsent(v, z -> new ArrayList<>()).add(i);
        //             if (!id.contains(v)) id.add(v);
        //         }
        //     }
        //     int [][] dp = new int [r][id.size()+1];
        //     dp[0][0] = 1;
        //     for (int j = 1; j <= id.size(); j++) // 遍历帽子id
        //         for (int i = 0; i < r; i++) {    // 遍历人戴帽子的子集状态mask
        //             dp[i][j] = dp[i][j-1];       // 这顶帽子是可以——不分配出去——的
        //             List<Integer> candi = m.get(id.get(j-1)); // 分配出去：遍历子集状态mask里的每个戴帽子的人，假如第j顶帽子是分给这个人的方案数
        //             for (Integer p : candi) 
        //                 if (((i >> p) & 1) == 1)
        //                     dp[i][j] = (dp[i][j] + dp[i ^ (1 << p)][j-1]) % mod;
        //         }
        //     return (int)dp[r-1][id.size()];
        // }

        // public int minimumXORSum(int[] a, int[] b) { // 就像前面有题可以一个字母一个字母地match寻找最少单词个数，这里有每增加一个数对的异或都优化结果的细节在
        //     int n = a.length, r = 1 << n;
        //     int [] dp = new int [r]; // dp[]: 这个设计奇特，最开始居然没能想起来，要熟悉起来
        //     Arrays.fill(dp, Integer.MAX_VALUE);
        //     dp[0] = 0; // 每一个数对取最小值结果的优化是从0开始
        //     for (int i = 0; i < r; i++) 
        //         for (int j = 0; j < n; j++) 
        //             if (((i >> j) & 1) == 1)
        //                 dp[i] = Math.min(dp[i], dp[i ^ (1 << j)] + (a[Integer.bitCount(i)-1] ^ b[j])); 
        //                 // dp[i] = Math.min(dp[i], dp[i ^ (1 << j)] + a[Integer.bitCount(i)-1] ^ b[j]); // BUG: ^ 位操作符优先给很低，需要（）起来
        //     return dp[r-1];
        // }
        // public int minimumXORSum(int[] a, int[] b) { // 自顶向下
        //     int n = a.length, r = 1 << n;
        //     int [] dp = new int [r]; 
        //     Arrays.fill(dp, Integer.MAX_VALUE);
        //     for (int i = 0; i < n; i++) 
        //         dp[1 << i] = a[0] ^ b[i];
        //     int [] cnt = new int [r];
        //     for (int i = 0; i < r; i++)
        //         cnt[i] = Integer.bitCount(i);
        //     for (int i = 1; i < n; i++) 
        //         for (int j = r-1; j > 0; j--) { // 为避免产生赃数据，这里需要倒序遍历
        //             if (dp[j] == Integer.MAX_VALUE) continue;
        //             if (cnt[j] == i) // 原状态的 1 的个数 为 i 个，可以进行状态转移
        //                 for (int k = 0; k < n; k++) 
        //                     if (((j >> k) & 1) == 0 && (j | (1 << k)) < r) // 遍历所有的位，碰到 state 0 的位置可以放一个异或
        //                         dp[j | (1 << k)] = Math.min(dp[j | (1 << k)], dp[j] + (a[i] ^ b[k])); // 新产生的数据向后覆盖
        //         }
        //     return dp[r-1];
        // }

        // public int oddEvenJumps(int [] a) { // 写出这种状况：就该强调，选对数据结构，事半功倍！
        //     int n = a.length, ans = 1; // n-1算答案里的一个
        //     boolean [] odd = new boolean [n]; 
        //     boolean [] evn = new boolean [n];
        //     TreeMap<Integer, Integer> m = new TreeMap<>(); // 这里用treemap就比用ArrayDeque好用
        //     odd[n-1] = evn[n-1] = true;
        //     m.put(a[n-1], n-1);
        //     for (int i = n-2; i >= 0; i--) {
        //         Integer higher = m.ceilingKey(a[i]); // higherKey() 返回的是键key
        //         Integer lower = m.floorKey(a[i]);    // lowerKey()
        //         if (higher != null) odd[i] = evn[m.get(higher)]; // 仍需取值，而非用键
        //         if (lower != null) evn[i] = odd[m.get(lower)];
        //         if (odd[i]) ans++;
        //         m.put(a[i], i);
        //     }
        //     return ans;
        // }
        // public int oddEvenJumps(int [] a) { 
        //     int n = a.length, ans = 1;
        //     ArrayDeque<Integer> s = new ArrayDeque<>();
        //     Integer [] idx = new Integer [n];       // idx存储的都是A数组的下标
        //     for (int i = 0; i < n; i++) idx[i] = i;
        //     Arrays.sort(idx, (x, y)-> a[x] - a[y]); // 将A数组的下标按A中的元素的大小进行排序
        //     int [] odIdx = new int [n]; 
        //     for (int i = 0; i < n; i++) {
        //         while (!s.isEmpty() && s.peekLast() < idx[i]) // 利用单调栈获取每一个元素进行奇数跳时所到达的位置
        //             odIdx[s.pollLast()] = idx[i];
        //         s.offerLast(idx[i]);
        //     }
        //     Arrays.sort(idx, (x, y) -> a[y] - a[x]);
        //     s.clear();
        //     int [] enIdx = new int [n];
        //     for (int i = 0; i < n; i++) {
        //         while (!s.isEmpty() && s.peekLast() < idx[i])
        //             enIdx[s.pollLast()] = idx[i];
        //         s.offerLast(idx[i]);
        //     }
        //     boolean [] odd = new boolean [n], evn = new boolean [n];
        //     odd[n-1] = evn[n-1] = true;
        //     for (int i = n-2; i >= 0; i--) {
        //         odd[i] = evn[odIdx[i]];
        //         evn[i] = odd[enIdx[i]];
        //         if (odd[i]) ans++;
        //     }
        //     return ans;
        // }

        // public int minSwap(int[] a, int[] b) {
        //     int n = a.length;
        //     int [][] dp = new int [n][2]; // 0: 不换， 1: 换
        //     for (int i = 0; i < n; i++) 
        //         Arrays.fill(dp[i], Integer.MAX_VALUE);
        //     dp[0][0] = 0;
        //     dp[0][1] = 1;
        //     for (int i = 1; i < n; i++) {
        //         if (a[i] > a[i-1] && b[i] > b[i-1]) {
        //             dp[i][0] = Math.min(dp[i][0], dp[i-1][0]);     // 不换，取一个较小值
        //             dp[i][1] = Math.min(dp[i][1], dp[i-1][1] + 1); // 换就两个都换
        //         }
        //         if (a[i] > b[i-1] && b[i] > a[i-1]) {
        //             dp[i][0] = Math.min(dp[i][0], dp[i-1][1]); 
        //             dp[i][1] = Math.min(dp[i][1], dp[i-1][0] + 1);
        //         }
        //     }
        //     return Math.min(dp[n-1][0], dp[n-1][1]);
        // }

        //  public int numberOfArithmeticSlices(int [] a) {
        //     int n = a.length, ans = 0;
        //     Map<Integer, Integer> [] dp = new HashMap[n];
        //     dp[0] = new HashMap<>();
        //     for (int i = 1; i < n; i++) {
        //         dp[i] = new HashMap<>();
        //         for (int j = 0; j < i; j++) {
        //         // for (int j = i-1; j >= 0; j--) { // BUG： 反向遍历不可以
        //             long diff = (long)a[i] - a[j];  // bug: (long)a[i]
        //             if (diff > Integer.MAX_VALUE || diff < Integer.MIN_VALUE) continue;
        //             int dif = (int)diff;
        //             dp[i].put(dif, dp[i].getOrDefault(dif, 0) + 1); // bug: 这里加的是1，不是2
        //             if (dp[j].containsKey(dif)) {
        //                 ans += dp[j].get(dif); // 只自增1（而不是记为2），为的是方便这里统计结果
        //                 dp[i].put(dif, dp[i].get(dif) + dp[j].get(dif));
        //             }
        //         }
        //     }
        //     return ans;
        // }

        // public int minSkips(int [] dist, int speed, int hoursBefore) {
        //     int n = dist.length;
        //     double [][] dp = new double [n+1][n+1]; // dp[i][j]: 途经i条道路，跳过j次休息下的最小用时
        //     for (int i = 0; i <= n; i++) 
        //         Arrays.fill(dp[i], Integer.MAX_VALUE);
        //     dp[0][0] = 0;
        //     double eps = 1e-8;
        //     for (int i = 1; i <= n; i++) {
        //         double t = (double)dist[i-1] / speed;       
        //         dp[i][0] = Math.ceil(dp[i-1][0] - eps) + t;
        //         dp[i][i] = dp[i-1][i-1] + t;
        //         for (int j = i-1; j > 0; j--) // 根据上一条路是否休息，来优化最小值
        //             dp[i][j] = Math.min(Math.ceil(dp[i-1][j] - eps) + t, dp[i-1][j-1] + t);
        //     }
        //     for (int i = 0; i <= n; i++) 
        //         if (dp[n][i] <= hoursBefore + eps) return i;
        //     return -1;
        // }

        // static final int mod = (int)1e9 + 7;
        // public int[] pathsWithMaxScore(List<String> a) {
        //     int m = a.size(), n = a.get(0).length();
        //     int [][] dirs = {{-1, -1}, {-1, 0}, {0, -1}};
        //     int [][] dp = new int [m][n];
        //     long [][] cnt = new long [m][n];
        //     cnt[m-1][n-1] = 1;
        //     for (int i = m-1; i >= 0; i--) {
        //         for (int j = n-1; j >= 0; j--) {
        //             if (a.get(i).charAt(j) == 'X') continue;
        //             for (int [] d : dirs) {
        //                 int x = i + d[0], y = j + d[1];
        //                 if (x < 0 || x >= m || y < 0 || y >= n) continue;
        //                 if (a.get(x).charAt(y) == 'X') continue;
        //                 if (dp[x][y] == 0) {
        //                     dp[x][y] = dp[i][j] + a.get(x).charAt(y) - '0';
        //                     cnt[x][y] = cnt[i][j];
        //                 } else if (dp[x][y] < dp[i][j] + a.get(x).charAt(y) - '0') {
        //                     dp[x][y] = dp[i][j] + a.get(x).charAt(y) - '0';
        //                     cnt[x][y] = cnt[i][j];
        //                 } else if (dp[x][y] == dp[i][j] + a.get(x).charAt(y) - '0')
        //                     cnt[x][y] = (cnt[x][y] + cnt[i][j]) % mod;
        //             }
        //         }
        //     }
        //     if (cnt[0][0] == 0) return new int [2];
        //     return new int [] {dp[0][0]-('E'-'0'), (int)cnt[0][0]} ;
        // }

        // public int cherryPickup(int[][] a) { // 时间复杂度:  O(N^3) 空间复杂度: O(N^3)
        //     int n  = a.length;
        //     int [][][] dp = new int [n+1][n+1][n+1];
        //     for (int i = 0; i <= n; i++) 
        //         for (int j = 0; j <= n; j++) 
        //             Arrays.fill(dp[i][j], -1);
        //     dp[1][1][1] = a[0][0];
        //     for (int i = 1; i <= n; i++) 
        //         for (int j = 1; j <= n; j++) 
        //             for (int x = 1; x <= n; x++) {
        //                 int y = i + j - x;
        //                 if (dp[i][j][x] != -1 || y < 1 || y > n || a[i-1][j-1] < 0 || a[x-1][y-1] < 0) continue;
        //                 int m = Math.max(dp[i-1][j][x], dp[i][j-1][x]);      // [i-1,j][x,y-1] [i,j-1][x,y-1] 目的就是cover住现两格分别来自于两个方向的四种组合
        //                 int mi = Math.max(dp[i-1][j][x-1], dp[i][j-1][x-1]); // [i-1,j][x-1,y] [i,j-1][x-1,y]
        //                 int max = Math.max(m, mi);
        //                 if (max == -1) continue;
        //                 dp[i][j][x] = max + a[i-1][j-1];
        //                 if (x != i) dp[i][j][x] += a[x-1][y-1];
        //             }
        //     return Math.max(0, dp[n][n][n]);
        // }
        // public int cherryPickup(int[][] gd) { // bug: 想不出来是哪里出错了 todo 把自己的bug给找出来
        //     m = gd.length;
        //     n = gd[0].length;
        //     if (m == 1 && n == 1) return gd[0][0] != -1 ? gd[0][0] : 0;
        //     dp = new Integer [m][n][m]; // dp[i][j][x]: 一个机器人的坐标[i,j]和另一个机器人的坐标[x, y] i+j == x+y
        //     dfs(0, 0, 0, gd);
        //     return valid ? dp[0][0][0] : 0;
        // }
        // int [][] dirs = {{1, 0}, {0, 1}};
        // Integer [][][] dp;
        // boolean valid = false;
        // int m, n;
        // private int dfs(int i, int j, int k, int [][] a) {
        //     if (i == m-1 && j == n-1 || k == m-1 && i +j == m+n-2) {
        //         valid = true;
        //         return a[m-1][n-1] + (i == m-1 && j == n-1 ? a[k][m+n-2-k] : a[i][j]);
        //     }
        //     if (dp[i][j][k] != null) return dp[i][j][k];
        //     int ans = 0;
        //     for (int [] d : dirs) {
        //         int x = i + d[0], y = j + d[1];
        //         if (x < 0 || x >= m || y < 0 || y >= n || a[x][y] == -1) continue;
        //         for (int [] c : dirs) {
        //             int u = k + d[0], v = i + j - k + d[1];
        //             if (u < 0 || u >= m || v < 0 || v >= n || a[u][v] == -1) continue;
        //             ans = Math.max(ans, dfs(x, y, u, a) + (i == k && j == i+j-k ? a[i][j] : a[i][j] + a[k][i+j-k]));
        //         }
        //     }
        //     return dp[i][j][k] = ans;
        // }
        // public int cherryPickup(int[][] grid) {
        //     n = grid.length;
        //     dp = new Integer[n][n][n][n];
        //     int ans = dfs(0, 0, 0, 0, grid);
        //     return ans < 0 ? 0 : ans;
        // }
        // Integer [][][][] dp;
        // int n;
        // private int dfs(int i, int j, int x, int y, int [][] a) {
        //     if (i < 0 || i >= n || j < 0 || j >= n || x < 0 || x >= n || y < 0 || y >= n) return Integer.MIN_VALUE;
        //     if (a[i][j] == -1 || a[x][y] == -1) return Integer.MIN_VALUE;
        //     if (i == n-1 && j == n-1) return a[i][j];
        //     if (dp[i][j][x][y] != null) return dp[i][j][x][y];
        //     int ans = 0;
        //     if (i == x && j == y) ans += a[i][j];
        //     else ans += a[i][j] + a[x][y];
        //     int f1 = dfs(i, j+1, x, y+1, a);
        //     int f2 = dfs(i+1, j, x+1, y, a);
        //     int f3 = dfs(i, j+1, x+1, y, a);
        //     int f4 = dfs(i+1, j, x, y+1, a);
        //     ans += Math.max(Math.max(f1, f2), Math.max(f3, f4));
        //     return dp[i][j][x][y] = ans;
        // }

        // public int minRefuelStops(int target, int startFuel, int[][] stations) {
        //     int n = stations.length;
        //     if (startFuel >= target) return 0;
        //     if (startFuel < target && n == 0 || startFuel < stations[0][0]) return -1;
        //     Queue<Integer> q = new PriorityQueue<>((a, b)->b-a); // 这里有一种贪心
        //     q.offer(startFuel);
        //     int idx = 0, gas = 0, cur = 0, cnt = 0;
        //     while (!q.isEmpty()) {
        //         gas = q.poll();
        //         cur += gas;
        //         if (cur >= target) return cnt; // 在目前测量允许、路过的所有可以加油的加油站里，选择站里油量最多的那个加油站加，以最大限度在减少加油次数
        //         while (idx < n && stations[idx][0] <= cur) q.offer(stations[idx++][1]);
        //         cnt++;
        //     }
        //     return -1;
        // }

        // public int calculateMinimumHP(int[][] g) {
        //     int m = g.length, n = g[0].length;
        //     int [][] f = new int [m][n];
        //     f[m-1][n-1] = Math.max(1 - g[m-1][n-1], 1);
        //     for (int i = m-2; i >= 0; i--) 
        //         f[i][n-1] = Math.max(f[i+1][n-1] - g[i][n-1], 1);
        //     for (int j = n-2; j >= 0; j--) 
        //         f[m-1][j] = Math.max(f[m-1][j+1] - g[m-1][j], 1);
        //     for (int i = m-2; i >= 0; i--) 
        //         for (int j = n-2; j >= 0; j--) {
        //             int fromDown = Math.max(f[i+1][j] - g[i][j], 1);
        //             int fromRight = Math.max(f[i][j+1] - g[i][j], 1);
        //             f[i][j] = Math.min(fromDown, fromRight);
        //         }
        //     return f[0][0];
        // }

        public int minimumIncompatibility(int[] a, int k) {
            n = a.length;
            if (n < k || n % k != 0) return -1;
            dp = new TreeSet [k];
            for (int i = 0; i < k; i++) 
                dp[i] = new TreeSet<>();
            Arrays.sort(a);
            dfs(n-1, a, k);
            return min == Integer.MAX_VALUE ? -1 : min;
        }
        TreeSet<Integer> [] dp;
        int n, min = Integer.MAX_VALUE;
        private void dfs(int idx, int [] a, int k) {
            if (idx < 0) {
                int sum = 0;
                for (int i = 0; i < k; i++) {
                    if (dp[i].size() != n / k) return ;
                    sum += dp[i].last() - dp[i].first();
                }
                min = sum;
                return ;
            }
            for (int i = 0; i < k; i++) {
                if (dp[i].contains(a[idx])) continue;
                // int last = dp[i].size() > 0 ? dp[i].last() : 0;
                dp[i].add(a[idx]);
                dfs(idx-1, a, k);
                dp[i].remove(a[idx]);
            }
        }           
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        // int [] a = new int [] {5,3,3,6,3,3};

        int []  a = new int []  {6, 3, 8, 1, 3, 1, 2, 2};
        // int [] a = new int [] {1,2,1,4};

        int r = s.minimumIncompatibility(a, 4);
        System.out.println("r: " + r);
    }
}