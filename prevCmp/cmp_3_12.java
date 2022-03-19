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

        public List<Integer> findKDistantIndices(int[] a, int key, int k) {
            int n = a.length;
            TreeSet<Integer> s = new TreeSet<>();
            for (int i = 0; i < n; i++) 
                if (a[i] == key) s.add(i);
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (i == 0 && Math.abs(s.first()) <= k) {
                    ans.add(0);
                    continue;
                }
                Integer lo = s.floor(i);
                Integer hi = s.ceiling(i);
                if (lo != null && Math.abs(lo - i) <= k || hi != null && Math.abs(hi - i) <= k)
                    ans.add(i);
            }
            return ans;
        }

        public int digArtifacts(int n, int[][] a, int[][] d) { // artifacts dig
            int m = a.length;
            Arrays.sort(a, (x, y)->x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
            Arrays.sort(d, (x, y)->x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
            boolean [][] vis = new boolean [n][n];
            int ans = 0; // a
            for (int [] v : d) 
                vis[v[0]][v[1]] = true;
            boolean valid = true;
            for (int [] v : a) {
                valid = true;
                for (int i = v[0]; i <= v[2]; i++) {
                    for (int j = v[1]; j <= v[3]; j++)
                        if (!vis[i][j]) {
                            valid = false;
                            break;
                        }
                    if (!valid) break;
                }
                if (valid) ans++;
            }
            return ans;
        }

        public int maximumTop(int[] a, int k) { 
            int n = a.length;
            if (n == 1 && k  % 2 == 1) return -1;
            if (k > n) return Arrays.stream(a).max().getAsInt();
            int max = -1;
            for (int i = 0; i < k-1; i++) 
                max = Math.max(max, a[i]);
            if (n == k) return max; // = Math.max(max, a[k-1]);
            else if (a[k] < max) return max;
            return a[k];
        }

        public long minimumWeight(int n, int[][] edges, int sa, int sb, int dest) {
            Arrays.sort(edges, (x, y)->x[0] != y[0] ? x[0] - y[0] : x[1] != y[1] ? x[1] - y[1] : x[2] - y[2]);
            adj = new ArrayList [n];
            re = new ArrayList [n];
            for (int i = 0; i < n; i++) {
                adj[i] = new ArrayList<>();
                re[i] = new ArrayList<>();
            }
            int [] pre = null; // 把相同两个节点间同向重边去掉不用考虑
            for (int [] e : edges) {
                if (pre != null && e[0] == pre[0] && e[1] == pre[1]) continue;
                adj[e[0]].add(new int [] {e[1], e[2]});
                re[e[1]].add(new int [] {e[0], e[2]});
                pre = e;
            }
            // 剔除掉无法到达的情况：这里面应该还是会比较耗时的
            if (!dfs(sa, dest, new boolean [n]) || !dfs(sb, dest, new boolean [n])) return -1;
            // 主要剩余部分的处理：
            d = new long [3][n];
            for (int i = 0; i < 3; i++) 
                Arrays.fill(d[i], Long.MAX_VALUE);
            dijkstra(sa, 0);
            dijkstra(sb, 1);
            dijkstra(dest, 2);
            long min = Long.MAX_VALUE;
            for (int i = 0; i < n; i++)
                if (d[0][i] != Long.MAX_VALUE && d[1][i] != Long.MAX_VALUE && d[2][i] != Long.MAX_VALUE)
                    min = Math.min(min, d[0][i] + d[1][i] + d[2][i]);
            return min;
        }        
        List<int []>[] adj;
        List<int []>[] re; // reverse adj
        long [][] d;
        void dijkstra(int u, int i) {
            System.out.println("u: " + u);
            d[i][u] = 0;
            Queue<long []> q = new PriorityQueue<>((x, y) -> Long.compare(x[1], y[1]));
            q.offer(new long []{u, 0});
            while (!q.isEmpty()) {
                long [] cur = q.poll();
                if (d[i][(int)cur[0]] < cur[1]) continue;
                if (i < 2) {
                    for (int [] v : adj[(int)cur[0]]) {
                        System.out.println(Arrays.toString(v));
                        if (cur[1] + v[1] < d[i][v[0]]) {
                            d[i][v[0]] = cur[1] + v[1];
                            q.offer(new long [] {v[0], d[i][v[0]]});
                        }
                    }
                } else {
                    for (int [] v : re[(int)cur[0]]) {
                        if (cur[1] + v[1] < d[i][v[0]]) {
                            d[i][v[0]] = cur[1] + v[1];
                            q.offer(new long [] {v[0], d[i][v[0]]});
                        }
                    }
                }
            }
        }
        boolean dfs(int u, int t, boolean [] vis) { // 需要考虑是否形成一个环, 题目没有说是树；如果有环，会无限循环需要vis标记
            if (u == t) return true;
            vis[u] = true;
            for (int [] v : adj[u]) {
                if (vis[v[0]]) continue;
                if (dfs(v[0], t, vis)) return true;
            }
            return false;
        }
        List<int []>[] adj;// 这里的代码相对简洁一点：不会为了排除某些特殊可能性而先dfs扫一遍
        List<int []>[] re; // reverse adj
        public long minimumWeight(int n, int[][] edges, int sa, int sb, int dest) {
            buildGraph(n, edges);
            long [] a = new long [n], b = new long [n], d = new long [n];
            Arrays.fill(a, -1);
            Arrays.fill(b, -1);
            Arrays.fill(d, -1);
            dijkstra(sa, a, adj);
            dijkstra(sb, b, adj);
            dijkstra(dest, d, re);
            long ans = -1;
            for (int i = 0; i < n; i++) 
                if (a[i] != -1 && b[i] != -1 && d[i] != -1) {
                    long v = a[i] + b[i] + d[i];
                    if (ans == -1 || ans > v)
                        ans = v;
                }
            return ans;
        }
        void dijkstra(int src, long [] dist, List<int []>[] g) {
            Queue<long []> q = new PriorityQueue<>((a, b)->Long.compare(a[1], b[1]));
            q.offer(new long [] {src, 0});
            while (!q.isEmpty()) {
                long [] u = q.poll();
                if (dist[(int)u[0]] != -1 && dist[(int)u[0]] <= u[1]) continue;
                dist[(int)u[0]] = u[1];
                for (int [] v : g[(int)u[0]]) // 这里面把q塞得太满，还是会浪费时间的
                    q.offer(new long [] {v[0], u[1] + v[1]});
            }
        }
        void buildGraph(int n, int [][] edges) {
            adj = new List [n];
            re = new List [n];
            for (int i = 0; i < n; i++) {
                adj[i] = new ArrayList<>();
                re[i] = new ArrayList<>();
            }
            for (int [] e : edges) {
                adj[e[0]].add(new int [] {e[1], e[2]});
                re[e[1]].add(new int [] {e[0], e[2]});
            }
        }

        
    }
    public static void main(String args[]) {
        Solution s = new Solution();

        long r = s.minimumWeight(6, a, 4, 0, 3);
        System.out.println("r: " + r);
    }
}
// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
