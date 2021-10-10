// import com.TreeNode;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

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

        
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        int [][] a = new int [][] {{0,1,4},{1,2,6},{0,2,8},{1,3,1}};

        int r = s.reachableNodes(a, 10, 4);
        System.out.println("r: " + r);
    }
}
