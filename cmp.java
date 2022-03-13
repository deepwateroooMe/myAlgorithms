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

        // public List<Integer> findKDistantIndices(int[] a, int key, int k) {
        //     int n = a.length;
        //     TreeSet<Integer> s = new TreeSet<>();
        //     for (int i = 0; i < n; i++) 
        //         if (a[i] == key) s.add(i);
        //     List<Integer> ans = new ArrayList<>();
        //     for (int i = 0; i < n; i++) {
        //         if (i == 0 && Math.abs(s.first()) <= k) {
        //             ans.add(0);
        //             continue;
        //         }
        //         Integer lo = s.floor(i);
        //         Integer hi = s.ceiling(i);
        //         if (lo != null && Math.abs(lo - i) <= k || hi != null && Math.abs(hi - i) <= k)
        //             ans.add(i);
        //     }
        //     return ans;
        // }

        // public int digArtifacts(int n, int[][] a, int[][] d) { // artifacts dig
        //     int m = a.length;
        //     Arrays.sort(a, (x, y)->x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
        //     Arrays.sort(d, (x, y)->x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
        //     boolean [][] vis = new boolean [n][n];
        //     int ans = 0; // a
        //     for (int [] v : d) 
        //         vis[v[0]][v[1]] = true;
        //     boolean valid = true;
        //     for (int [] v : a) {
        //         valid = true;
        //         for (int i = v[0]; i <= v[2]; i++) {
        //             for (int j = v[1]; j <= v[3]; j++)
        //                 if (!vis[i][j]) {
        //                     valid = false;
        //                     break;
        //                 }
        //             if (!valid) break;
        //         }
        //         if (valid) ans++;
        //     }
        //     return ans;
        // }

        public int maximumTop(int[] a, int k) { // BUG: Hidden for this testcase during contest. 194/195 passed
            int n = a.length;
            if (n == 1 && k  % 2 == 1) return -1;
            if (k >= n) return Arrays.stream(a).max().getAsInt();
            int max = -1;
            for (int i = 0; i < k-1; i++) 
                max = Math.max(max, a[i]);
            if (n == k) max = Math.max(max, a[k-1]);
            else if (a[k] < max) return max;
            return a[k];
            // return max >= a[k] ? max : a[k];
        }

        public long minimumWeight(int n, int[][] edges, int sa, int sb, int dest) {
            Arrays.sort(edges, (x, y)->x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
            adj = new ArrayList [n];
            for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
            int [] pre = null; // 把相同两个节点间同向重边去掉不用考虑
            for (int [] e : edges) {
                if (pre != null && e[0] == pre[0] && e[1] == pre[1]) continue;
                adj[e[0]].add(new int [] {e[1], e[2]});
                pre = e;
            }
            // 剔除掉无法到达的情况
            if (!dfs(sa, dest) || !dfs(sb, dest)) return -1;
            // 主要剩余部分的处理：以前有增加一条边、减少一条边的最小生成树问题，思路还是想不太清楚
            
            return -1;
        }        
        List<int []>[] adj;
        boolean dfs(int u, int t) { // 这里面需要考虑是否形成一个环，如果有环，会无限循环需要vis标记
            if (u == t) return true;
            for (int [] v : adj[u]) 
                if (dfs(v[0], t)) return true;
            return false;
        }
    }
    public static void main(String args[]) {
        Solution s = new Solution();

        int [][] a = new int [][] {{0,2,2},{0,5,6},{1,0,3},{1,4,5},{2,1,1},{2,3,3},{2,3,4},{3,4,2},{4,5,1}};

        long r = s.minimumWeight(6, a, 0, 1, 5);
        System.out.println("r: " + r);

        // int [] a = new int [] {5,2,2,4,0,6};
        // int []  a = new int []  {35, 43, 23, 86, 23, 45, 84, 2, 18, 83, 79, 28, 54, 81, 12, 94, 14, 0, 0, 29, 94, 12, 13, 1, 48, 85, 22, 95, 24, 5, 73, 10, 96, 97, 72, 41, 52, 1, 91, 3, 20, 22, 41, 98, 70, 20, 52, 48, 91, 84, 16, 30, 27, 35, 69, 33, 67, 18, 4, 53, 86, 78, 26, 83, 13, 96, 29, 15, 34, 80, 16, 49};

        // int []  a = new int []  {91, 98, 17, 79, 15, 55, 47, 86, 4, 5, 17, 79, 68, 60, 60, 31, 72, 85, 25, 77, 8, 78, 40, 96, 76, 69, 95, 2, 42, 87, 48, 72, 45, 25, 40, 60, 21, 91, 32, 79, 2, 87, 80, 97, 82, 94, 69, 43, 18, 19, 21, 36, 44, 81, 99};
        // int r = s.maximumTop(a, 2);
        // System.out.println("r: " + r);
    }
}
// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
