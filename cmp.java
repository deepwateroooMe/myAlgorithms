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

        // public String digitSum(String s, int k) {
        //     int n = s.length(), cur = 0;
        //     if (n <= k) return s;
        //     String ns = "";
        //     for (int i = 0; i < n; i += k) {
        //         cur = 0;
        //         for (int j = i; j < i+k && j < n; j++) 
        //             cur += s.charAt(j) - '0';
        //         ns += String.valueOf(cur);
        //     }
        //     if (ns.length() <= k) return ns;
        //     return digitSum(ns, k);
        // }
        // int getSum(String t) {
        //     int n = t.length(), ans = 0;
        //     char [] s = t.toCharArray();
        //     for (char c : s) 
        //         ans += c - '0';
        //     return ans;
        // }

        // public int minimumRounds(int[] t) {
        //     int n = t.length, cnt = 0;
        //     Map<Integer, Integer> m = new HashMap<>();
        //     for (int v : t) 
        //         m.put(v, m.getOrDefault(v, 0) + 1);
        //     for (Integer v : m.values()) {// 这样的先行遍历一遍排查会浪费时间吗？
        //         System.out.println("\n v: " + v);
        //         // if (v % 3 != 0 && v % 3 % 2 != 0 && v % 2 != 0) return -1; // 这条件不对呀
        //         if (v == 1) return -1;
        //         if (v % 3 == 0) cnt += v / 3;
        //         else if (v % 3 != 0)
        //             cnt += v / 3 + 1;
        //         else cnt += v / 2;
        //         System.out.println("cnt: " + cnt);
        //     }
        //     return cnt;
        // }

        // public int longestPath(int[] p, String t) { // tle tle tle ???
        //     int n = t.length();
        //     if (n == 1) return 1;
        //     s = t.toCharArray();
        //     adj = new ArrayList [n];
        //     for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        //     for (int i = 0; i < n; i++) {
        //         if (p[i] != -1) {
        //             adj[p[i]].add(i); // 如果它有父节点，那么父节点的孩子链表加上当前的孩子
        //             adj[i].add(p[i]);
        //         }
        //     }
        //     // for (int i = 0; i < n; i++) // 这里面有大量的重复计算, 这里这种方法就tle了
        //     //     dfs(i, -1, 1);
        //     // dist = new int [n];
        //     return max;
        // }
        // List<Integer> [] adj;
        // char [] s;
        // // int [] dist;
        // int max = 0;
        // void dijkstra(int u) {
        //     Queue<int []> q = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        //     q.offer(new int [] {u, 1});
        //     while (!q.isEmpty()) { // 这里有点儿并不起来了：当求的是最长距离的时候，是不是应该用dfs记忆化搜索？？？
        //         int [] u = q.poll();
        //         // if (dist[u[0]] >= u[1]) continue; // 这里的剪枝忘记了。。。。。。
        //     }
        // }
        // void dfs(int u, int p, int cnt) {
        //     if (adj[u].size() == 1 && adj[u].get(0) == p) { // 叶子节点，可以返回
        //         if (cnt > max) max = cnt;
        //         return ;
        //     }
        //     for (int v : adj[u]) {
        //         if (s[v] == s[u] || v == p) continue; // 是父节点已经访问过了，或者相邻的字符是一样的，路过
        //         dfs(v, u, cnt+1);
        //     }
        // }

        public int maxTrailingZeros(int[][] a) { // 读不懂题目说的是什么意思
            int m = a.length, n = a[0].length;
            int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // 这个，对于题目所要求的方向该如何处理，想得不是很清楚。。。。。。前缀和？？？
            // 需要对每个格里的2与5质因子的个数分别作统计
            int [][][] cnt = new int [m][n][2]; // 0: 2, 1: 5的统计个数
            for (int i = 0; i < m; i++) 
                for (int j = 0; j < n; j++) 
                    if (a[i][j] % 2 == 0)
                        cnt[i][j][0] = getCnt(a[i][j], 2);
                    else if (a[i][j] % 5 == 0)
                        cnt[i][j][1] = getCnt(a[i][j], 5);
            int [][] u = new int [m+1][n+1], d = new int [m+1][n+1], l = new int [m+1][n+1], r = new int [m+1][n+1]; // up, down, left, right:
            for (int i = 1; i <= m; i++) 
                for (int j = 1; j <= n; j++) 
                    u[i][j] = getCnt(a[i][j]) + u[i-1][j] + // 这里还要分别统计2和5的个数，感觉这个题的思路没有想对，稍微想复杂了点
                        // 昨天晚上最后一晚大街边的房间休息，没有休息好，今天感觉整个的状态不对，希望下个周的情况能够好点儿
        }
        int getCnt(int v) {
            String t = String.valueOf(v);
            char [] s = t.toCharArray();
            int n = t.length(), i = n-1, cnt = 0;
            while (i >= 0 && s[i] == '0') {
                cnt++;
                i--;
            }
            return cnt;
        }
        int getCnt(int v, int m) {
            int cnt = 0;
            if (v % m == 0) {
                while (v % m == 0) {
                    cnt++;
                    v /= m;
                }
            }
            return cnt;
        }
    }
    public static void main(String args[]) {
        Solution s = new Solution();

        int [][] a = new int [][] {{23,17,15,3,20},{8,1,20,27,11},{9,4,6,2,21},{40,9,1,10,6},{22,7,4,5,3}};

        int r = s.maxTrailingZeros(a);
        System.out.println("r: " + r);
    }
}
// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
