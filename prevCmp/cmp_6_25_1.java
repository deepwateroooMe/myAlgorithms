// import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import java.util.HashSet;
import java.util.Set;
import static java.util.stream.Collectors.toMap;

public class cmp_6_25_1 { 
    public static class Solution {

        // public int countAsterisks(String t) {
        //     int n = t.length(), ans = 0, cnt = 0;
        //     char [] s = t.toCharArray();
        //     for (int i = 0; i < n; i++) {
        //         if (s[i] == '|') ++cnt;
        //         if (cnt % 2 == 0 && s[i] == '*') ans++;
        //     }
        //     return ans;
        // }

        // private class UnionFind { // 要再想一想这里为什么数多了
        //     int [] id; // parent
        //     int [] cnt;// size
        //     public UnionFind (int n) {
        //         id = new int [n];
        //         cnt = new int [n];
        //         for (int i = 0; i < n; i++) {
        //             id[i] = i;
        //             cnt[i] =  1;
        //         }
        //     }
        //     public int find(int i) {
        //         while (id[i] != i) {
        //             id[i] = id[id[i]];
        //             i = id[i];
        //         }
        //         return i;
        //     }
        //     public void union(int i, int j) {
        //         int rootI = find(i);
        //         int rootJ = find(j);
        //         if (rootI != rootJ) {
        //             id[rootI] = rootJ;
        //             cnt[rootJ] += cnt[rootI];
        //         }
        //     }
        //     public long getCnt() {
        //         Map<Integer, Integer> m = new HashMap<>(); // cnt map
        //         for (int i = 0; i < id.length; i++) {
        //             find(i);
        //             m.put(id[i], m.getOrDefault(id[i], 0) + 1);
        //         }
        //         long cnt = 0;
        //         for (Integer key : m.keySet()) 
        //             cnt += m.get(key) * (id.length - m.get(key));
        //         System.out.println("cnt: " + cnt);
        //         return cnt;
        //     }
        // }
        // public long countPairs(int n, int[][] a) {
        //     UnionFind uf = new UnionFind(n);
        //     for (int [] e : a) 
        //         uf.union(e[0], e[1]);
        //     return uf.getCnt();
        // }
        // // void getReachableCnt(int u, int [] vis) {
        // //     if (m.get(u) == null) return;
        // //     long ans = 0;
        // //     vis[u] = 1;
        // //     List<Integer> l = m.get(u);
        // //     for (int v : l) {
        // //         if (vis[v] == 1) continue;
        // //         getReachableCnt(v, vis);
        // //     }
        // // }
        // public long countPairs(int n, int[][] a) {
        //     m = new ArrayList[n];
        //     for (int i = 0; i < n; i++) 
        //         m[i] = new ArrayList<>();
        //     for (int [] e : a) {
        //         m[e[0]].add(e[1]);
        //         m[e[1]].add(e[0]);
        //     }
        //     long cnt = 0, sum = n;
        //     boolean [] vis = new boolean [n];
        //     for (int i = 0; i < n; i++) {
        //         // Arrays.fill(vis, 0); // BUG: 你这里好像是重复数了很多次
        //         // getReachableCnt(i, vis);
        //         // cnt += n - Arrays.stream(vis).sum(); // 这里面算的会有重复吗？
        //         if (vis[i]) continue;
        //         int cur = dfs(i, vis, new int [1]); // find size of connected component
        //         sum = sum - cur;
        //         cnt += cur * sum;
        //     }
        //     return cnt;
        // }
        // List<Integer> [] m;
        // int dfs(int u, boolean [] vis, int [] cnt) { // 这里一个长度的数组，我可能还需要再想一下
        //     if (vis[u]) return cnt[0];
        //     vis[u] = true;
        //     cnt[0]++;
        //     for (int v : m[u]) 
        //         dfs(v, vis, cnt);
        //     return cnt[0];
        // }

        // // 忘记这些位操作符的推算公式是怎样的了，里面应该早有规律可以推的
        // public int maximumXOR(int[] a) {
        //     int n = a.length, ans = 0;
        // }

//         // 看来这个问题还是没有想透。。。。。
//         public int distinctSequences(int n) {
//             long [][] dp = new long [n][6]; // 16 想不起来为什么是 16 了 ？？？1223 // == 2
//             // int [] idx = new int [6];
//             for (int i = 0; i < 6; i++) {
//                 dp[0][i] = 1;
//             }
// // f(i,j,k) 表示前 i 次投，最后一次结果为 j 且最后的数字连续了 k 次的方案数。
//             for (int i = 1; i < n; i++) { // 第 2 次到第 n 次
//                 for (int j = 0; j < 6; j++) { // 现在转出来的值
//                     for (int k = 0; k < 6; k++) { // 上一次转出来的值
//                         // 还没有想明白自己为什么会算多了 ？？？里面有大量的重复
//                         // 它不是两个独立的条件，而是两处揉和在一起的条件 ！！！
//                         if (gcd(j+1, k+1) == 1 && j != k) { // 跟最后一次的值相比
//                             if (i < 3)
//                                 dp[i][j] += dp[i-1][k];
//                             else // i >= 3
//                                 dp[i][j] += dp[i-1][k] - dp[i-3][j];
//                         }
//                         // if (j == k && i > 2) dp[i][j] += dp[i-3][j];
//                     }
//                     dp[i][j] %= mod;
//                 }
//             }
//             long ans = 0;
//             for (int i = 0; i < 6; i++) 
//                 ans = (ans + dp[n-1][i]) % mod;
//             return (int) ans;
//         }
//         static final int mod = (int)1e9 + 7;
//         int gcd(int x, int y) {
//             if (y == 0) return x;
//             return gcd(y, x % y);
//         }

        // static final int mod = (int)1e9 + 7;
        // static int [][] arr = {{}, {2,3,4,5,6},{1,3,5},{1,2,4,5},{1,3,5},{1,2,3,4,6},{1,5}};
        // int [][][] dp = new int [10001][7][7];
        // public int distinctSequences(int n) { // 结果好像是不太对呀
        //     if (n == 1) return 6;
        //     long ans = 0;
        //     for (int i = 1; i < 7; i++) 
        //         ans = (ans + dfs(2, n, i, 0)) % mod;
        //     return (int)ans;
        // }
        // int dfs(int idx, int n, int cur, int pre) {
        //     if (idx > n) return 1;
        //     if (dp[idx][cur][pre] != 0) return dp[idx][cur][pre];
        //     long ans = 0;
        //     for (int i = 0; i < arr[cur].length; i++) {
        //         // 也就是说，这里也还是需要再检查一下现在的值与上一次的值是一样吗？如果一样是不可以的，跳过
        //         if (arr[cur][i] == pre) continue;
        //         ans = (ans + dfs(idx+1, n, arr[cur][i], cur)) % mod;
        //     }
        //     return dp[idx][cur][pre] = (int)ans;
        // }
        // static final int mod = (int)1e9 + 7;
        // public int distinctSequences(int n) { // 结果好像是不太对呀: 感觉这里还有点儿什么地方没有想对，要再想想
        //     // 这里把因为公因了的约束条件直接转化成一个图表
        //     Map<Integer, List<Integer>> m = new HashMap<>();
        //     m.put(1, Arrays.asList(2, 3, 4, 5, 6));
        //     m.put(2, Arrays.asList(1, 3, 5));
        //     m.put(3, Arrays.asList(1, 2, 4, 5));
        //     m.put(4, Arrays.asList(1, 3, 5));
        //     m.put(5, Arrays.asList(1, 2, 3, 4, 6));
        //     m.put(6, Arrays.asList(1, 5));
        //     // 因为只关心最后一次，所以只需要记住最后一次的结果，前两次的结果呢？
        //     // We only care about the current position and previous position,
        //     // then we only care about the previous position with pre-previous position.
        //     // Once we have 2-dimensional array on both cases, we simply add 1 more check that no numbers same on current i index and i - 2 index.
        //     // 因为状态数组记录了现在和上一次得到的值，那么用两个滚去数组就可以节约空间地完成所有 dp 值的记录
        //     // int [][] dp[i][j]: 现在得到 i，上一次得到 j
        //     int [][] pre = new int [7][7]; // dp[i][j]: 现在得到 i，上一次得到 j
        //     for (int i = 1; i < 7; i++) 
        //         for (int j : m.get(i)) 
        //             pre[i][j] = 1;
        //     for (int cnt = 2; cnt <= n; cnt++) {
        //         int [][] cur = new int [7][7]; // dp[i][j]: 现在得到 i，上一次得到 j
        //         for (int i = 1; i < 7; i++) {
        //             for (int j : m.get(i)) {
        //                 for (int k = 1; k < 7; k++) {
        //                 // for (int k : m.get(j)) {
        //                     if (i != k) {
        //                         cur[j][i] += pre[k][j];
        //                         cur[j][i] %= mod;
        //                         // cur[i][j] += pre[j][k];
        //                         // cur[i][j] %= mod;
        //                     }
        //                 }
        //             }
        //         }
        //         pre = cur;
        //     }
        //     int ans = 0;
        //     for (int i = 1; i < 7; i++) 
        //         for (int j = 1; j < 7; j++) {
        //             if (i == j) continue;
        //             ans += pre[i][j];
        //             ans %= mod;
        //         }
        //     return ans;
        // }
    }
    public static void main(String args[]) { 
        Solution s = new Solution();
        
        int r = s.distinctSequences(4);
        System.out.println("r: " + r);
    }
}




// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
