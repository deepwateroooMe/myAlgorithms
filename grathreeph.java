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


        // void dfs(String cur, List<String> list) {
        //     Queue<String> next = m.get(cur);
        //     while (next != null && next.size() > 0) {
        //         dfs(next.poll(), list);
        //     }
        //     list.add(cur);
        // }
        // Map<String, PriorityQueue<String>> m = new HashMap<>(); // TreeSet does not handle repeats, use queue
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
    // https://leetcode.com/problems/count-pairs-of-nodes/discuss/1096740/C%2B%2BJavaPython3-Two-Problems-O(q-*-(n-%2B-e))
        // public int[] countPairs(int n, int[][] edges, int[] queries) { // 感觉被别人这么写了，思路好清晰
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

        
        
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        // int [][] a = new int [][] {{1,2},{2,4},{1,3},{2,3},{2,1}};
        // int [] b = new int [] {2, 3};
        int [][] a = new int [][] {{1,5},{1,5},{3,4},{2,5},{1,3},{5,1},{2,3},{2,5}};
        int [] b = new int [] {1, 2, 3, 4, 5};
        
        int [] r = s.countPairs(5, a, b);
        System.out.println(Arrays.toString(r));
    }
}
