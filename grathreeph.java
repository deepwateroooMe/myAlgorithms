// import com.TreeNode;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;

public class grathreeph {
    public static class Solution {
        // HashMap<Integer, Integer> m = new HashMap<>();
        // public int minSwapsCouples(int[] row) {
        //     int n = row.length;
        //     for (int i = 1; i < n/2 + 1; i++) {
        //         m.put(2*i-2, 2*i-1);
        //         m.put(2*i-1, 2*i-2);
        //     }
        //     int cnt = 0, tmp = 0;
        //     for (int i = 1; i < n; i += 2) {
        //         if (m.get(row[i-1]) != row[i]) {
        //             for (int j = 0; j < row.length; j++) {
        //                 if (row[j] == m.get(row[i-1])) {
        //                     tmp = row[i];
        //                     row[i] = row[j];
        //                     row[j] = tmp;
        //                     break;
        //                 }
        //             }
        //             ++cnt;
        //         }
        //     }
        //     return cnt;
        // }

        // public class UnionFind {
        //     int [] pare;
        //     int [] rank;
        //     int n;
        //     int cnt;
        //     public UnionFind(int x) {
        //         n = x;
        //         cnt = n;
        //         pare = new int[n];
        //         rank = new int[n];
        //         for (int i = 0; i < n; i++) {
        //             pare[i] = i;
        //         }
        //         Arrays.fill(rank, 0);
        //     }
        //     public int find(int val) {
        //         while (val != pare[val]) {
        //             pare[val] = pare[pare[val]];
        //             val = pare[val];
        //         }
        //         return val;
        //     }
        //     public void merge(int p, int q) {
        //         int rp = find(p);
        //         int rq = find(q);
        //         if (rank[rp] < rank[rq]) {
        //             swap(rp, rq);
        //         }
        //         pare[rq] = rp;
        //         rank[rp] += rank[rq];
        //         --cnt;
        //     }
        //     public boolean sameGroup(int x, int y) {
        //         return find(x) == find(y);
        //     }
        //     public int getCnt() {
        //         return cnt;
        //     }
        //     private void swap(int x, int y) {
        //         int tmp = x;
        //         x = y;
        //         y = tmp;
        //     }
        // }
        // public class Node {
        //     int val;
        //     int x;
        //     int y;
        //     Node() {}
        //     Node(int x, int y, int val) {
        //         this.x = x;
        //         this.y = y;
        //         this.val = val;
        //     }
        // }
        // Comparator<Node> compare = new Comparator<Node>() {
        //     @Override public int compare(Node a, Node b) {
        //         return a.val - b.val;
        //     }
        // };
        // int [][] rowRank;
        // int [][] colRank;
        // int [][] arr;
        // int [] f;
        // int [] v;
        // int [] row;
        // int [] col;
        // int [][] tag;
        // int m, n;
        // Node[] a;
        // Node[] b;
        // Node [] c;
        // int find(int x) {
        //     if (f[x] != x)
        //         f[x] = find(f[x]);
        //     return f[x];
        // }
        // void merge(int x, int y) {
        //     int fx = find(x);
        //     int fy = find(y);
        //     f[fy] = fx;
        // }
        // public int[][] matrixRankTransform(int[][] matrix) {
        //     m = matrix.length; // 这些个变量、结构组织等太琐碎了，改天再重新写一遍
        //     n = matrix[0].length;
        //     rowRank = new int[m][n];
        //     colRank = new int[m][n];
        //     arr = new int[m][n];
        //     f = new int[m*n];
        //     v = new int[m*n];
        //     row = new int[m];
        //     col = new int[n];
        //     tag = new int[m][n];
        //     a = new Node[n*m];
        //     b = new Node[n]; // 
        //     c = new Node[m]; // 
            
        //     int p = 0, pp = 0;
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) 
        //             a[p++] = new Node(i, j, matrix[i][j]);
        //     Arrays.sort(a, compare);
        //     for (int i = 0; i < p; i++) {
        //         tag[a[i].x][a[i].y] = i; // 新的rank数组
        //         f[i] = i;
        //     }
        //     for (int i = 0; i < m; i++) { // 遍历行
        //         pp = 0;
        //         for (int j = 0; j < n; j++) // 遍历列
        //             b[pp++] = new Node(i, j, matrix[i][j]);
        //         Arrays.sort(b, compare);
        //         for (int j = 1; j < pp; j++) {
        //             if (b[j].val != b[j-1].val) continue;
        //             else {
        //                 int rx = find(tag[i][b[j-1].y]);
        //                 int ry = find(tag[i][b[j].y]);
        //                 f[rx] = ry;
        //             }
        //         }
        //     }
        //     for (int i = 0; i < n; i++) { // 列
        //         pp = 0;
        //         for (int j = 0; j < m; j++) // 行
        //             c[pp++] = new Node(j, i, matrix[j][i]);
        //         Arrays.sort(c, compare);
        //         for (int j = 1; j < pp; j++) {
        //             if (c[j].val != c[j-1].val) continue;
        //             else {
        //                 int rx = find(tag[c[j-1].x][i]);
        //                 int ry = find(tag[c[j].x][i]);
        //                 f[rx] = ry;
        //             }
        //         }
        //     }
        //     int bgn = 0;
        //     for (int i = 0; i < p; i++) {
        //         int rank = Math.max(row[a[i].x], col[a[i].y])+1;
        //         int ff = find(i);
        //         if (v[ff] < rank) v[ff] = rank;
        //         if (i == p-1 || a[i+1].val != a[i].val) {
        //             for (int j = bgn; j <= i; j++) {
        //                 int xx = v[find(j)];
        //                 rowRank[a[j].x][a[j].y] = xx;
        //                 row[a[j].x] = xx;
        //                 col[a[j].y] = xx;
        //             }
        //             bgn = i+1;
        //         }
        //     }
        //     int [][] arr = new int [m][n];
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++)
        //             arr[i][j] = rowRank[i][j];
        //     return arr;
        // }


        // private int dfs(int [] arr, int idx) { // 求出比start更富，并且quiet值最小的人的编号；如果不存在则返回start本人
        //     if (ans[idx] != -1) return ans[idx];
        //     int res = idx, minQuiet = arr[idx];
        //     if (tree.containsKey(idx))
        //         for (int next : tree.get(idx)) {
        //             int q = dfs(arr, next);
        //             if (arr[q] < minQuiet) {
        //                 minQuiet = arr[q];
        //                 res = q;
        //             }
        //         }
        //     return ans[idx] = res;
        // }
        // int [] ans;
        // Map<Integer, List<Integer>> tree = new HashMap<>(); // key: a person, v: persons ricker than key
        // public int[] loudAndRich(int[][] richer, int[] quiet) {
        //     int n = quiet.length;
        //     for (int i = 0; i < richer.length; i++) {
        //         int u = richer[i][0];
        //         int v = richer[i][1];
        //         tree.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        //     }            
        //     ans = new int [n];
        //     Arrays.fill(ans, -1);
        //     for (int i = 0; i < n; i++) 
        //         dfs(quiet, i);
        //     return ans;
        // }


        // public int[] gardenNoAdj(int n, int[][] paths) {
        //     HashMap<Integer, List<Integer>> m = new HashMap<>();
        //     for (int i = 0; i < paths.length; i++) {
        //         m.computeIfAbsent(paths[i][0], k -> new ArrayList<>()).add(paths[i][1]);
        //         m.computeIfAbsent(paths[i][1], k -> new ArrayList<>()).add(paths[i][0]);
        //     }
        //     int [] ans = new int [n];
        //     Set<Integer> s = new HashSet<>();
        //     for (int i = 1; i <= n; i++) {
        //         if (!m.containsKey(i) || ans[i-1] != 0) continue;
        //         s.clear();
        //         for (int v : m.get(i)) 
        //             if (ans[v-1] != 0) s.add(ans[v-1]);
        //         for (int j = 1; j <= 4 && ans[i-1] == 0; j++) 
        //             if (!s.contains(j)) 
        //                 ans[i-1] = j;
        //     }
        //     for (int i = 0; i < n; i++) 
        //         if (ans[i] == 0) ans[i] = 1;
        //     return ans;
        // }


        // private class Node {
        //     int i;
        //     double v;
        //     public Node(int a, double c) {
        //         i = a;
        //         v = c;
        //     } 
        // }
        // public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        //     HashMap<Integer, List<Node>> m = new HashMap<>();
        //     for (int i = 0; i < edges.length; i++) {
        //         m.computeIfAbsent(edges[i][0], k-> new ArrayList<>()).add(new Node(edges[i][1], succProb[i]));
        //         m.computeIfAbsent(edges[i][1], k-> new ArrayList<>()).add(new Node(edges[i][0], succProb[i]));
        //     }
        //     double [] dist = new double [n];
        //     dist[start] = 1;
        //     ArrayDeque<Node> q = new ArrayDeque<>();
        //     q.offer(new Node(start, 1));
        //     boolean [] inQueue = new boolean [n];
        //     inQueue[start] = true;
        //     while (!q.isEmpty()) {
        //         Node cur = q.poll();
        //         inQueue[cur.i] = false;
        //         List<Node> neighbours = m.get(cur.i);
        //         if (neighbours == null) continue;
        //         for (Node next : neighbours) {
        //             if (dist[next.i] < dist[cur.i] * next.v) { // 
        //                 dist[next.i] = dist[cur.i] * next.v;
        //                 if (!inQueue[next.i]) {
        //                     q.offer(new Node(next.i, dist[next.i]));
        //                     inQueue[next.i] = true;
        //                 }
        //             }
        //         }
        //     }
        //     return dist[end];
        // }


        
// // 找最短路径应该用queue来做，入队列的时候需要标记红边或是蓝边以便找交替路径
//         public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
//             HashMap<Integer, List<Integer>> [] maps = new HashMap [2]; // 0 : red; 1: blue
//             for (int i = 0; i < 2; i++) 
//                 maps[i] = new HashMap<>();
//             for (int i = 0; i < red_edges.length; i++) 
//                 maps[0].computeIfAbsent(red_edges[i][0], k->new ArrayList<>()).add(red_edges[i][1]);
//             for (int i = 0; i < blue_edges.length; i++) 
//                 maps[1].computeIfAbsent(blue_edges[i][0], k->new ArrayList<>()).add(blue_edges[i][1]);
//             int [] ans = new int[n];
//             Arrays.fill(ans, -1);
//             Queue<int []> q = new LinkedList<>();
//             q.offer(new int [] {0, 0}); // red edge         
//             q.offer(new int [] {0, 1}); // blue edge
//             boolean [][] inQueue = new boolean [n][2]; // 0: red, 1: blue
//             inQueue[0][0] = true;
//             inQueue[0][1] = true;
//             int cnt = 0, color = 0;
//             while (!q.isEmpty()) {
//                 for (int size = q.size(); size > 0; size--) {
//                     int [] cur = q.poll();
//                     System.out.println(Arrays.toString(cur));
//                     color = cur[1];
//                     if (ans[cur[0]] == -1) ans[cur[0]] = cnt;
//                     List<Integer> nextNodes = maps[1-color].get(cur[0]);
//                     if (nextNodes == null) continue;
//                     for (Integer next : nextNodes) 
//                         if (!inQueue[next][1-color]) {
//                             q.offer(new int [] {next, 1-color});
//                             inQueue[next][1-color] = true;
//                         }
//                 }
//                 ++cnt;
//             }
//             return ans;
//         }
        // public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        //     int [][] red = new int[n][2]; // 红 0 蓝 1
        //     int [][] blue = new int[n][2];
        //     for (int i = 1; i < n; i++) {
        //         red[i][0] = i;
        //         red[i][1] = 0x0fffffff;   // 初始化红边权值
        //     }
        //     red [0][0] = 0;
        //     red [0][1] = 0;
        //     for (int i = 1; i < n; i++) {
        //         blue[i][0] = i;
        //         blue[i][1] = 0x0fffffff;
        //     }
        //     blue [0][0] = 0;
        //     blue [0][1] = 0;
        //     dfs(red, blue, 0, 0, red_edges, blue_edges);
        //     dfs(red, blue, 1, 0, red_edges, blue_edges);
        //     int [] ans = new int[n];
        //     for(int i = 0; i < n; i++){
        //         ans[i] = Math.min(red[i][1], blue[i][1]);
        //         if (ans[i] == 0x0fffffff) // 没有改变说明不存在
        //             ans[i] = -1;
        //     }
        //     return ans;
        // }
        // public void dfs(int [][] red, int [][] blue, int color, int node, int[][] red_edges, int[][] blue_edges){
        //     if (color == 0) {
        //         for (int [] blue_to : blue_edges) // 以node为from to 为终 的边
        //             if (node == blue_to[0] && red[node][1]+1 < blue[blue_to[1]][1]) {// 0到from点加1是否小于0到to的距离
        //                 blue[blue_to[1]][1] = red[node][1]+1; // 作距离的更新
        //                 dfs(red, blue, 1-color, blue_to[1], red_edges, blue_edges);
        //             }
        //     } else for (int [] red_to : red_edges) //以node为from to 为终 的边
        //                if (node == red_to[0] && blue[node][1]+1 < red[red_to[1]][1]) {//0到from点加1是否小于0到to的距离
        //                    red[red_to[1]][1] = blue[node][1]+1;
        //                    dfs(red, blue, 1-color, red_to[1], red_edges, blue_edges);
        //                }
        // }
        // private void dfs(int t, int i, boolean cur, int cnt) { // 是不是dfs就应该长点儿记忆呢？// bugy bugy bugy......
        //     if (cur && (m.get(i) == null || m.get(i).size() == 0) || !cur && (o.get(i) == null || o.get(i).size() == 0)) 
        //         return;
        //     if (cnt + 1 >= max) return;
        //     if (cur) {
        //         for (int j = 0; j < m.get(i).size(); j++) {
        //             if (m.get(i).get(j) == t) {
        //                 ++cnt;
        //                 if (cnt < max) max = cnt;
        //                 vp[t] = -1;
        //                 return;
        //             }
        //             if (vp[m.get(i).get(j)] == -1) continue;
        //         }
        //         for (int j = 0; j < m.get(i).size(); j++) {
        //             if (vp[m.get(i).get(j)] == -1) continue;
        //             vp[m.get(i).get(j)] = -1;
        //             dfs(t, m.get(i).get(j), !cur, cnt+1);
        //             vp[m.get(i).get(j)] = 1;
        //         }
        //     } else {
        //         for (int j = 0; j < o.get(i).size(); j++) {
        //             if (o.get(i).get(j) == t) {
        //                 ++cnt;
        //                 if (cnt < max) max = cnt;
        //                 vq[t] = -1;
        //                 return;
        //             }
        //             if (vq[o.get(i).get(j)] == -1) continue;
        //         }
        //         for (int j = 0; j < o.get(i).size(); j++) {
        //             if (vq[o.get(i).get(j)] == -1) continue;
        //             vq[o.get(i).get(j)] = -1;
        //             dfs(t, o.get(i).get(j), !cur, cnt+1);
        //             vq[o.get(i).get(j)] = 1;
        //         }
        //     }
        // }
        // HashMap<Integer, List<Integer>> m = new HashMap<>();
        // HashMap<Integer, List<Integer>> o = new HashMap<>();
        // HashSet<Integer> s = new HashSet<>();
        // HashSet<Integer> t = new HashSet<>();
        // int [] vp;
        // int [] vq;
        // int max; // 找最短路径应该用queue来做，入队列的时候需要标记红边或是蓝边以便找交替路径
        // public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        //     for (int i = 0; i < red_edges.length; i++) {
        //         m.computeIfAbsent(red_edges[i][0], k->new ArrayList<>()).add(red_edges[i][1]);
        //         s.add(red_edges[i][0]);
        //     }
        //     for (int i = 0; i < blue_edges.length; i++) {
        //         o.computeIfAbsent(blue_edges[i][0], k->new ArrayList<>()).add(blue_edges[i][1]);
        //         t.add(blue_edges[i][0]);
        //     }
        //     vp = new int[n];
        //     vq = new int[n];
        //     int [] res = new int[n];
        //     for (int i = 1; i < n; i++) {
        //         max = Integer.MAX_VALUE;
        //         Arrays.fill(vp, 0);
        //         Arrays.fill(vq, 0);
        //         vp[0] = -1;
        //         dfs(i, 0, s.contains(0) ? true : false, 0);
        //         if (s.contains(0) && t.contains(0))
        //             dfs(i, 0, false, 0);
        //         if (max == Integer.MAX_VALUE) res[i] = -1;
        //         else res[i] = max;
        //     }
        //     return res;
        // }


        // private void dfs(int k, int i, int cnt) {
        //     if (m.get(i).size() == 0) {
        //         if (cnt > res) res = cnt;
        //         return;
        //     }
        //     int j = 0;
        //     for ( j = 0; j < m.get(i).size(); j++) {
        //         if (vis[m.get(i).get(j)] == -1) continue;
        //         if (o.get(i).get(j) <= k-1) {
        //             if (o.get(i).get(j) == k-1) {
        //                 res += o.get(i).get(j) + 1;
        //                 continue;
        //             } else {
        //                 vis[m.get(i).get(j)] = -1;
        //                 dfs(k-o.get(i).get(j)-1, m.get(i).get(j), cnt + o.get(i).get(j) + 1);
        //                 vis[m.get(i).get(j)] = 1;
        //             }
        //         } else {
        //             res += k;
        //             continue;
        //         }
        //     }
        //     if (j == m.get(i).size()) res = cnt + res;
        // }
        // HashMap<Integer, List<Integer>> m = new HashMap<>();
        // HashMap<Integer, List<Integer>> o = new HashMap<>();
        // List<Integer> l;
        // int [] vis;
        // int res; // 为什么那个时候的自己，会dfs bfs傻傻分不清楚呢？？！！！
        // public int reachableNodes(int[][] edges, int maxMoves, int n) {
        //     for (int i = 0; i < n; i++) {
        //         l = new ArrayList<>();
        //         m.put(i, l);
        //         l = new ArrayList<>();
        //         o.put(i, l);
        //     }
        //     for (int i = 0; i < edges.length; i++) {
        //         m.get(edges[i][0]).add(edges[i][1]);
        //         o.get(edges[i][0]).add(edges[i][2]);
        //         m.get(edges[i][1]).add(edges[i][0]);
        //         o.get(edges[i][1]).add(edges[i][2]);
        //     }
        //     res = 0;
        //     vis = new int [n];
        //     vis[0] = -1;
        //     dfs(maxMoves, 0, 1);
        //     return res;
        // }
        // public int reachableNodes(int[][] edges, int maxMoves, int n) {
        //     int [][] graph = new int  [n][n];
        //     for (int i = 0; i < n; i++) 
        //         Arrays.fill(graph[i], -1);
        //     for (int [] v : edges) {
        //         graph[v[0]][v[1]] = v[2];
        //         graph[v[1]][v[0]] = v[2];
        //     }
        //     Queue<int []> q = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
        //     boolean [] vis = new boolean [n];
        //     q.offer(new int [] {maxMoves, 0});
        //     int res = 0;
        //     while (!q.isEmpty()) {
        //         int [] cur = q.poll();
        //         int cnt = cur[0], u = cur[1];
        //         if (vis[u]) continue;
        //         vis[u] = true;
        //         ++res;
        //         for (int i = 0; i < n; i++) {
        //             if (graph[u][i] == -1) continue;
        //             if (cnt > graph[u][i] && !vis[i])
        //                 q.offer(new int [] {cnt - graph[u][i]-1, i});
        //             graph[i][u] -= Math.min(cnt, graph[u][i]);
        //             res += Math.min(cnt, graph[u][i]);
        //         }
        //     }
        //     return res;
        // }
        // public int reachableNodes(int[][] edges, int maxMoves, int n) {
        //     Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        //     for (int [] v : edges) {
        //         graph.computeIfAbsent(v[0], k->new HashMap<>()).put(v[1], v[2]);
        //         graph.computeIfAbsent(v[1], k->new HashMap<>()).put(v[0], v[2]);
        //     }
        //     Queue<int []> q = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
        //     boolean [] vis = new boolean [n];
        //     q.offer(new int [] {maxMoves, 0});
        //     int res = 0;
        //     while (!q.isEmpty()) {
        //         int [] cur = q.poll();
        //         int cnt = cur[0], u = cur[1];
        //         if (vis[u]) continue;
        //         vis[u] = true;
        //         ++res;
        //         for (int i = 0; i < n; i++) {
        //             if (!graph.containsKey(u) || !graph.get(u).containsKey(i) || graph.get(u).get(i) == -1) continue;
        //             if (cnt > graph.get(u).get(i) && !vis[i])
        //                 q.offer(new int [] {cnt - graph.get(u).get(i)-1, i});
        //             graph.get(i).put(u, graph.get(u).get(i) - Math.min(cnt, graph.get(u).get(i)));
        //             res += Math.min(cnt, graph.get(u).get(i));
        //         }
        //     }
        //     return res;
        // }


        // private void dfs(String cur, List<String> list) {
        //     Queue<String> next = m.get(cur);
        //     while (next != null && next.size() > 0) 
        //         dfs(next.poll(), list);
        //     list.add(cur);
        // }
        // Map<String, PriorityQueue<String>> m = new HashMap<>();      // TreeSet does not handle repeats, use queue
        // public List<String> findItinerary(List<List<String>> tickets) {
        //     for (int i = 0; i < tickets.size(); i++) 
        //         m.computeIfAbsent(tickets.get(i).get(0), k -> new PriorityQueue<>()).offer(tickets.get(i).get(1));
        //     List<String> res = new ArrayList<>();
        //     dfs("JFK", res);
        //     Collections.reverse(res);
        //     return res;
        // }


        // private boolean dfs(String cur, String tar, Set<String> vis) {
        //     if (cur.equals(tar)) return true;
        //     vis.add(cur);
        //     if (m.get(cur) == null) return false;
        //     for (String next : m.get(cur)) {
        //         if (vis.contains(next)) continue;
        //         if (dfs(next, tar, vis)) return true;
        //     }
        //     return false;
        // }
        // Map<String, Set<String>> m = new HashMap<>();
        // public boolean equationsPossible(String[] equations) {
        //     int n = equations.length;
        //     Set<String> notEq = new HashSet<>();
        //     for (String s : equations) {
        //         String key = s.substring(0, 1);
        //         String val = s.substring(3);
        //         if (key.equals(val)) {
        //             if (s.substring(1, 3).equals("!=")) return false;
        //             continue;
        //         }
        //         if (s.substring(1, 3).equals("==")) {
        //             m.computeIfAbsent(key, k->new HashSet<>()).add(val);
        //             m.computeIfAbsent(val, k->new HashSet<>()).add(key);
        //         } else notEq.add(s);
        //     }
        //     for (String s : notEq) {
        //         String key = s.substring(0, 1);
        //         String val = s.substring(3);
        //         if (dfs(key, val, new HashSet<>())) return false;
        //     }
        //     return true;
        // }


        // 本体主要利用了 边的数目少于点的数目的平方个
        // 先模糊计算有多少对点
        // 然后去掉单个点的度*2大于目标值的情况
        // 再去掉某对点度的和大于目标值但是减去出现频率之后小于等于目标值的情况（一次减2）
        // 最终将结果除以2即得最终结果（因为会重复算一遍，(a,b), (b,a)）
        // 小结：困难的题目重要的在于优化的技巧，可能本身用到的大框架思路是可以凭自己想出来的，
        // 但是从题目给出的条件中，找到复杂度较低的解题方法，
        // 并且合理处理其中遇到的边界条件是有一定的难度的。
        // public int[] countPairs(int n, int[][] edges, int[] queries) { // bug bug bug
        //     Map<Integer, Integer> [] m = new HashMap[n+1];
        //     for (int i = 1; i <= n; i++) 
        //         m[i] = new HashMap<>();
        //     for (int [] cur : edges) {
        //         m[cur[0]].put(cur[1], m[cur[0]].getOrDefault(cur[1], 0) + 1);
        //         m[cur[1]].put(cur[0], m[cur[1]].getOrDefault(cur[0], 0) + 1);
        //     }
        //     // // System.out.println("m[2].size(): " + m[2].size());
        //     // for (Map.Entry<Integer, Integer> en : m[2].entrySet()) 
        //     //     System.out.print(en.getKey() + ", " + en.getValue() + "\n");
        //     int [] cnt = new int [n+1];
        //     for (int i = 1; i <= n; i++) 
        //         cnt[i] = m[i].size() == 0 ? 0 : m[i].values().stream().reduce(0, Integer::sum);
        //     // System.out.println(Arrays.toString(cnt));
        //     int [] pre = new int [Arrays.stream(cnt).max().getAsInt()+1];
        //     for (int v : cnt) pre[v]++; //
        //     for (int i = pre.length-2; i >= 0; i--) 
        //         pre[i] += pre[i+1]; // 计算出大于等于某个值出入边总数值的点数
        //     // System.out.println(Arrays.toString(pre));
        //     int [] ans = new int [queries.length];
        //     int res = 0, cur = 0;
        //     for (int i = 0; i < queries.length; i++) {
        //         res = 0;
        //         for (int j = 1; j <= n; j++) {
        //             cur = 0;
        //             int target = queries[i] - cnt[j];
        //             for (Map.Entry<Integer, Integer> en : m[j].entrySet()) {
        //                 int k = en.getKey();
        //                 if (j >= k) break;
        //                 int v = en.getValue();
        //                 if (cnt[k] > target) cur--;
        //                 int count = cnt[i] + cnt[k] - v;
        //                 if (count > queries[i]) cur++;
        //             }
        //             if (cnt[i] > target) cur--;
        //             cur += pre[target < 0 ? 0 : target+1]; // + 1
        //             res += cur;
        //         }
        //         ans[i] = res / 2;
        //     } 
        //     return ans;
        // }
        // // https://leetcode.com/problems/count-pairs-of-nodes/discuss/1096740/C%2B%2BJavaPython3-Two-Problems-O(q-*-(n-%2B-e))
        // public int[] countPairs(int n, int[][] edges, int[] queries) { // 别人家的思路好清晰
        //     int [] cnt = new int [n+1], sortedCnt = new int [n+1], ans = new int [queries.length];
        //     Map<Integer, Integer> [] m = new HashMap[n+1];
        //     for (var e : edges) {
        //         sortedCnt[e[0]] = cnt[e[0]] = cnt[e[0]] + 1;
        //         sortedCnt[e[1]] = cnt[e[1]] = cnt[e[1]] + 1;
        //         int min = Math.min(e[0], e[1]), max = Math.max(e[0], e[1]);
        //         m[min] = m[min] == null ? new HashMap<>() : m[min];
        //         m[min].put(max, m[min].getOrDefault(max, 0) + 1); // 仍然是当作有向图、单向图来做
        //     }
        //     Arrays.sort(sortedCnt);
        //     int res = 0, cur = 0;
        //     for (int k = 0; k < queries.length; k++) {
        //         for (int i = 1, j = n; i < j;) 
        //             if (queries[k] < sortedCnt[i] + sortedCnt[j])
        //                 ans[k] += (j--) - i;
        //             else ++i;
        //         for (int i = 1; i <= n; i++) 
        //             if (m[i] != null) 
        //                 for (var en : m[i].entrySet()) {
        //                     int j = en.getKey(), sharedCnt = en.getValue();
        //                     if (queries[k] < cnt[i] + cnt[j] && cnt[i] + cnt[j] - sharedCnt <= queries[k])
        //                         ans[k]--;
        //                 }
        //     } 
        //     return ans;
        // }
    // https://leetcode.com/problems/count-pairs-of-nodes/discuss/1096432/Java-or-Two-Steps-or-O(NlgN-%2B-Q(N%2BE))
// 这个也可以再参考一下


        // public boolean isPrintable(int[][] targetGrid) { // 觉得这个题思路奇特
        //     int m = targetGrid.length, n = targetGrid[0].length, max = Math.max(m, n);
        //     for (int i = 0; i < m; i++) 
        //         max = Math.max(max, Arrays.stream(targetGrid[i]).max().getAsInt());
        //     int [] top = new int [max+1], bot = new int [max+1], left = new int [max+1], right = new int [max+1];
        //     Arrays.fill(top, max+1);
        //     Arrays.fill(left, max+1);
        //     Arrays.fill(bot, -1);
        //     Arrays.fill(right, -1);
        //     for (int i = 0; i < m; i++) // 建立每个颜色的矩阵边界: 界定每种颜色的上下左右边界，每种颜色最早（上左）最晚（下右）出现的位置
        //         for (int j = 0; j < n; j++) {
        //             int color = targetGrid[i][j];
        //             top[color] = Math.min(top[color], i);
        //             bot[color] = Math.max(bot[color], i);
        //             left[color] = Math.min(left[color], j);
        //             right[color] = Math.max(right[color], j);
        //         }
        //     // 根据矩阵建立有向图，遍历targetGrid，
        //     // 当前位置颜色X在某个矩阵A中但是不为矩阵A的颜色时，建立从A到X的边
        //     // X可以存在于多个矩阵中
        //     // 变量：是否存在边-防止重复建立边；入度，便于后期判断是否拓扑排序；邻接表，从i出发到达的点
        //     boolean [][] eg = new boolean [max+1][max+1];
        //     int [] ins = new int [max+1];
        //     List<List<Integer>> adj = new ArrayList<>();
        //     for (int i = 0; i <= max; i++) 
        //         adj.add(new ArrayList<>());
        //     int cur = 0; // 建立图
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) {
        //             cur = targetGrid[i][j]; // 当前格子的最终打印顔色
        //             for (int color = 1; color <= max; color++) // 遍历所有颜色：暴搜当前格子颜色是否可能后打印
        //                 if (i >= top[color] && i <= bot[color] && j >= left[color] && j <= right[color])
        //                     if (cur != color && !eg[color][cur]) {
        //                         adj.get(color).add(cur); // color 先染后，cur后染色
        //                         ins[cur]++;
        //                         eg[color][cur] = true;
        //                     }
        //         }
        //     // 寻找入度为0的颜色点，减小该点连结的点的入度，直到所有点的入度都为0
        //     List<Integer> l = new ArrayList<>();
        //     while (true) {
        //         int i;
        //         for (i = 1; i <= max; i++) 
        //             if (ins[i] == 0) {
        //                 l.add(i);
        //                 for (int v : adj.get(i)) ins[v]--;
        //                 ins[i] = -1;
        //                 break;
        //             }
        //         if (i == max+1) break;
        //     }
        //     return l.size() == max;
        // }
        // private boolean topologicalSort(Set<Integer> visited, Set<Integer> visiting, int c, Map<Integer, Set<Integer>> graph) {
        //     if (visited.contains(c)) return true;
        //     if (visiting.contains(c)) return false;
        //     visiting.add(c);
        //     for (Integer nei : graph.getOrDefault(c, Collections.emptySet())) 
        //         if (!topologicalSort(visited, visiting, nei, graph)) return  false;
        //     visiting.remove(c);
        //     visited.add(c);
        //     return true;
        // }
        // // 1. For each color, find left top corner and right bottom corner
        // // 2. All colors interfering with given color means they should go after given
        // // 3. Create dependencies (1 -> [2,3])
        // // 4. TopSort. Loops mean it is not possible
        // public boolean isPrintable(int[][] targetGrid) {
        //     Map<Integer, Set<Integer>> graph = new HashMap<>();
        //     Set<Integer> colors = new HashSet<>();
        //     int m = targetGrid.length, n = targetGrid[0].length;
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) 
        //             colors.add(targetGrid[i][j]);
        //     for (Integer c : colors) {
        //         int fi = -1, fj = Integer.MAX_VALUE, li = -1, lj = -1; // f: first, f row, f col, l: last, l row, l col
        //         for (int i = 0; i < m; i++) 
        //             for (int j = 0; j < n; j++) 
        //                 if (targetGrid[i][j] == c) {
        //                     if (fi == -1) fi = i;
        //                     fj = Math.min(fj, j);
        //                     li = i;
        //                     lj = Math.max(lj, j);
        //                 }
        //         for (int i = fi; i <= li; i++) 
        //             for (int j = fj; j <= lj; j++) 
        //                 if (targetGrid[i][j] != c) 
        //                     graph.computeIfAbsent(c, z -> new HashSet<>()).add(targetGrid[i][j]);
        //     }
        //     Set<Integer> visited = new HashSet<>();
        //     Set<Integer> visiting = new HashSet<>();
        //     for (Integer c : colors) 
        //         if (!topologicalSort(visited, visiting, c, graph)) return false;
        //     return true;
        // }

        // public int checkWays(int[][] pairs) { // 自顶向下
        //     int max = 0; // [1, 500]
        //     for (int [] p : pairs) // 求出节点的最大值
        //         max = Math.max(max, Math.max(p[0], p[1]));
        //     int [] cnt = new int [max+1]; // 记录每个节点的祖先关系数量
        //     int [][] adj = new int [max+1][max+1]; // 是否存在祖孙关系的图
        //     for (int [] p : pairs) {
        //         cnt[p[0]]++;
        //         cnt[p[1]]++;
        //         adj[p[0]][p[1]] = 1;
        //         adj[p[1]][p[0]] = 1;
        //     }
        //     Integer [] nodes = new Integer [max+1]; // 创建一个新的数组，可以方便后面的按祖先关系数量大小将节点排序，和将零散的节点集中到前面。
        //     int idx = 0; // length: idx             // 使用包装整数类型，方便后面调用API排序
        //     for (int i = 1; i <= max; i++) 
        //         if (cnt[i] > 0) nodes[idx++] = i;
        //     Arrays.sort(nodes, 0, idx, (a, b)->cnt[b] - cnt[a]); // 按照祖先关系数量从大到小排序
        //     if (cnt[nodes[0]] != idx-1) return 0; // 当根节点不满足要求
        //     int [] par = new int [max+1];
        //     int [][] allPar = new int [max+1][max+1];
        //     for (int i = 0; i < idx; i++) 
        //         for (int j = i-1; j >= 0; j--) 
        //             if (adj[nodes[i]][nodes[j]] == 1) {
        //                 par[nodes[i]] = nodes[j]; // 记录父节点
        //                 for (int f = nodes[j]; f != 0; f = par[f]) // 记录祖先节点，循环遍历直到根节点
        //                     allPar[nodes[i]][f] = 1;
        //                 break;
        //             }
        //     int ans = 1;
        //     for (int i = 1; i <= max; i++)
        //         for (int j = i+1; j <= max; j++) {
        //             if (adj[i][j] == 1 && cnt[i] == cnt[j]) ans = 2; // 可以调换位置，有多个解
        //             if (adj[i][j] != (allPar[i][j] | allPar[j][i]))
        //                 return 0; // 有冲突，无解，出现在已经记录了当前节点和祖先节点的关系，但是pairs中没有该关系
        //         }
        //     return ans;
        // }
        // Map<Integer, Set<Integer>> adj = new HashMap<>();
        // public int checkWays(int[][] pairs) { // 这个方法好慢
        //     for (int [] p : pairs) {
        //         adj.computeIfAbsent(p[0], z -> new HashSet<>()).add(p[1]);
        //         adj.computeIfAbsent(p[1], z -> new HashSet<>()).add(p[0]);
        //     }
        //     return helper(adj.keySet());
        // }
        // private int helper(Set<Integer> nodes) {
        //     Map<Integer, List<Integer>> lenMap = new HashMap<>();
        //     for (Integer v : nodes) 
        //         lenMap.computeIfAbsent(adj.get(v).size(), z -> new ArrayList<>()).add(v);
        //     if (!lenMap.containsKey(nodes.size()-1)) return 0; // 不存在合法的根节点
        //     Integer root = lenMap.get(nodes.size()-1).get(0);  // 这个任命为根的节点是否带有随机性
        //     for (Integer v : adj.get(root)) // 因为需要dfs自顶向下深度遍历，这些东西需要移掉
        //         adj.get(v).remove(root);
        //     Set<Integer> vis = new HashSet<>();
        //     Set<Set<Integer>> group = new HashSet<>(); // 以每个节点作为根节点的子树子节点集合
        //     for (Integer v : nodes)
        //         if (!v.equals(root) && !vis.contains(v)) {
        //             Set<Integer> cur = new HashSet<>();
        //             dfs(vis, v, cur);
        //             group.add(cur);
        //         }
        //     int ans = lenMap.get(nodes.size()-1).size() > 1 ? 2 : 1; // 如果根节点不止不一个，就可能有并行答案
        //     for (Set<Integer> g : group) { // 自顶向下：遍历根节点下每个节点的建树是否合法、是否唯一
        //         int tmp = helper(g);
        //         if (tmp == 0) return 0; // 不存在合法的根节点
        //         if (tmp == 2) ans = 2;
        //     }
        //     return ans;
        // }
        // private void dfs(Set<Integer> vis, int node, Set<Integer> cur) {
        //     vis.add(node);
        //     cur.add(node);
        //     for (int next : adj.get(node)) 
        //         if (!vis.contains(next))
        //             dfs(vis, next, cur);
        // }
        // public int checkWays(int [][] pairs) {
        //     Map<Integer, Integer> cnt = new HashMap<>(); // 统计结点对中各个结点出现的次数
        //     Map<Integer, List<Integer>> adj = new HashMap<>();
        //     for (int [] pair : pairs) {
        //         int from = pair[0], to = pair[1];
        //         cnt.put(from, cnt.getOrDefault(from, 0) + 1);
        //         cnt.put(to, cnt.getOrDefault(to, 0) + 1);
        //         adj.computeIfAbsent(from, x -> new ArrayList<>()).add(to);
        //         adj.computeIfAbsent(to, x -> new ArrayList<>()).add(from);
        //     }
        //     List<Integer> list = new ArrayList<>(cnt.keySet()); // list of ori nodes 将结点对中的结点存储在List集合中
        //     list.sort((a, b) -> cnt.get(b) - cnt.get(a)); // 对list集合进行排序
        //     // pairs中给出了树中所有具有祖孙关系的结点对，很显然，根节点是其他所有结点的祖先
        //     // 所以根结点在pairs出现的次数应该为为总结点数-1，找不到符合这个关系的结点，那就不符合题目中构树的要求
        //     if (cnt.get(list.get(0)) != list.size() - 1) return 0;
        //     // 判断已排序后的结点集合是否有两个结点具有相同出现次数，
        //     // 如果存在，那么这两个结点可以互换，即为两颗树
        //     int ans = 1;
        //     for (int [] p : pairs) 
        //         if (cnt.get(p[0]).equals(cnt.get(p[1]))) {
        //             ans = 2;
        //             break;
        //         }
        //     // 将所有结点的父结点置为出现结点最多的结点，即根结点
        //     // 在没有确定除根结点之外的其它结点真正父结点之前，根结点就是它们的祖先
        //     Map<Integer, Integer> farMap = new HashMap<>();
        //     Set<Integer> set = new HashSet<>(); // 存储所有父结点
        //     set.add(list.get(0));
        //     for (Integer i : list) // 
        //         farMap.put(i, list.get(0));
        //     // 处理除最大结点数外，按着构树规则处理其它结点
        //     for (int i = 1; i < list.size(); ++i) {
        //         for (Integer s : adj.get(list.get(i))) 
        //             // 判断当前结点是否为父结点
        //             if (!set.contains(s)){
        //                 // 如果s不是父结点，那么就是当前list.get(i)结点的子结点
        //                 // 在没有更新父结点之前，s的父结点和list.get(i)的父结点是相同的(父子在一条链上)
        //                 // 如果父结点不相同，可以理解为s的父结点list.get(i)有多个父结点，显然是不合理的
        //                 //  同样也可以把树理解为图，除根结点之外，所有结点的入度都为1，而上边的情况表示存在一个入度为2的结点
        //                 // 明显与树的构建原理相悖
        //                 if (farMap.get(s) != farMap.get(list.get(i)))
        //                     return 0;
        //                 farMap.put(s, list.get(i));
        //             }
        //         set.add(list.get(i));
        //     }
        //     return ans;
        // }

    }
    public static void main(String[] args) {
        Solution s = new Solution();

        int [][] a = new int [][] {{1,2},{2,3},{1,3}};
 
        int r = s.checkWays(a);
        System.out.println("r: " + r);
    }
}
