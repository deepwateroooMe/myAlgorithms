import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import java.util.HashSet;
import java.util.Set;
import static java.util.stream.Collectors.toMap;

public class cmp { 
    public static class Solution {

        // public int arithmeticTriplets(int[] a, int d) {
        //     int n = a.length, cnt = 0;
        //     for (int i = 0; i < n; i++) 
        //         for (int j = i+1; j < n; j++) {
        //             if (a[j] - a[i] != d) continue;
        //             for (int k = j+1; k < n; k++) {
        //                 if (a[k] - a[j] == d) cnt++;
        //             }
        //         }
        //     return cnt;
        // }

        // public int reachableNodes(int n, int[][] edges, int[] restricted) {
        //     Set<Integer> s = new HashSet<>(Arrays.stream(restricted).boxed().collect(Collectors.toList())); // 写一下
        //     m = new ArrayList [n];
        //     for (int i = 0; i < n; i++) 
        //         m[i] = new ArrayList<>();
        //     for (int [] v : edges) {
        //         if (s.contains(v[0]) || s.contains(v[1])) continue;
        //         m[v[0]].add(v[1]);
        //         m[v[1]].add(v[0]);
        //     }
        //     Set<Integer> vis = new HashSet<>();
        //     dfs(0, vis);
        //     return vis.size();
        // }
        // List<Integer> [] m;
        // void dfs(int u, Set<Integer> vis) {
        //     vis.add(u);
        //     for (int v : m[u]) {
        //         if (vis.contains(v)) continue;
        //         dfs(v, vis);
        //     }
        // }

        // public boolean validPartition(int[] a) { // n: [2, 10^5] ==> O(NlogN) dfs记忆化搜索
        //     n = a.length;
        //     dp = new Boolean [n];
        //     return dfs(0, a);
        // }
        // int n;
        // Boolean [] dp;
        // Boolean dfs(int i, int [] a) {
        //     if (i >= n) return true;
        //     if (i == n-1) return dp[i] = false;
        //     if (dp[i] != null) return dp[i];
        //     for (int k = i+1; k <= Math.min(i+2, n-1); k++) {
        //         if (k - i == 1 && a[k] == a[i]
        //             || k - i == 2 && (a[i] == a[i+1] && a[i+1] == a[k] || a[i+1] - a[i] == 1 && a[k] - a[k-1] == 1)) {
        //             if (dfs(k+1, a)) return dp[i] = true;
        //         }
        //     }
        //     return dp[i] = false;
        // }

        public int longestIdealString(String ss, int k) { // n: [1, 10^5]; k: [0, 25]
            n = s.length(); m = 26;
            int idx = 0, max = 0, j = 0;
            int [] cnt = new int [26];
            s = ss.toCharArray();
            // for (int i = 0; i < n; i++) {
            //     j = s[i] - 'a';
            //     cnt[j]++;
            //     if (cnt[j] > max) {
            //         max = cnt[j];
            //         idx = j;
            //     }
            // }
            // if (k == 0) return max;
            dp = new Integer [m][m][n];
            // idx = new int [m][m][n]; // 这里预处理一遍，供提下来的搜索用
            // for (int i = 0; i < m; i++) 
            //     for (int j = 0; j < m; j++) 
            //         Arrays.fill(idx[i][j], -1);
            // for (int i = 0; i < m; i++) { // k
            //     for (int j = n-1; j >= 0; j--) {
            //         while (j >= 0 && s[j]-'a' != i) j--; // s[j] = 'a' + i
            //         preProcess(i, , j, k);
            //     }
            // }
            for (int i = 0; i < m; i++) {
                dfs(i, -1, 0, k);
                max = Math.max(max,)
            }
        }
        char [] s;
        int m, n;
        Integer [][][] dp; // ['a']['a'+/-k][startSearchingIdx]
        int [][][] idx;
        // 这里还需要一个类似跳表一样的优化：lps 之类的，不记得了：
        // 总之可以不是DFS记忆化搜索，而是那个优化的“跳表”; KMP马拉车算法吗？这里的好处是K是固定的值; 还是说，两者结合起来才是这个题的解法
        // 今天算是自己第一次来思考这个马拉车算法，希望以后有更多高难度一点儿的比赛题目帮助练习；今天的这个实在是没有思路了，下次再写
        // 这里题目没有理解对：acbd when k = 2 is OK, [ac][bd], NOT what I got [ac][cb][bd]XXXX
        int dfs(int i, int j, int k, int v) { // started with i+'a'; cur char is j+'a', cur idx is k
            if (k >= n) return 0;
            if (dp[i][j][k] != null) return dp[i][j][k];
            int x = k;
            while (x < n && s[x] != (char)('a' + j)) x++;
            if (x >= n) return dp[i][j][k] = 0;
            for (int x = k; x < n; x++) {
            }
        }
        // void preProcess(int i, int j, int k, int v) { // ['a'+i][j: idx]
        //     if (k < 0) return;
        //     int x = k;
        //     char cur = (char)('a' + j);
        //     while (x >= 0 && s[x] != cur) x--;
        //     if (x < 0) return ;
        //     idx[i][j][x] = k;
        // }
    }
    public static void main(String args[]) { 
        Solution s = new Solution();

        // int [] a = new int [] {4,4,4,5,6};
        int [] a = new int [] {1, 1, 1, 2};

        boolean r = s.validPartition(a);
        System.out.println("r: " + r);
    }
}

// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
