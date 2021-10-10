import com.UnionFind;
// import com.MapUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;
import javafx.util.Pair;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toMap;

public class graph {
    public static class Solution {

        // public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        //     HashMap<Integer, List<Integer>> m = new HashMap<>();
        //     List<Integer> l = new ArrayList<>();
        //     for (int i = 0; i < n; i++) {
        //         l = new ArrayList<>();
        //         m.put(i, l);
        //     }
        //     for (int i = 0; i < n-1; i++) {
        //         m.get(edges[i][0]).add(edges[i][1]);
        //         m.get(edges[i][1]).add(edges[i][0]);
        //     }
        //     HashSet<Integer> leaf = new HashSet<>();
        //     while (leaf.size() < n - 2) {
        //         for (Integer key : m.keySet()) {
        //             if (!leaf.contains(key) && m.get(key).size() == 1 && m.get(m.get(key).get(0)).size() > 1) {
        //                 leaf.add(key);
        //             }
        //         }
        //         for (Integer val : leaf) {
        //             m.remove(val);
        //         }
        //         for (Integer key : m.keySet()) {
        //             List<Integer> lt = m.get(key);
        //             lt.removeAll(leaf);
        //             m.put(key, lt);
        //         }
        //     }
        //     List<Integer> res = new ArrayList<>(m.keySet());
        //     return res;
        // }


        // public class UnionFind {
        //     int [] pare; // 记录节点的根
        //     int [] rank; // 记录根节点的深度（用于优化）
        //     int cnt;     // ???
        //     public UnionFind(int n) {
        //         pare = new int[n];
        //         rank = new int[n];
        //         cnt = n;
        //         for (int i = 0; i < n; i++) {
        //             pare[i] = i;
        //         }
        //         // System.out.println("pare.length: " + pare.length);
        //         // for (int z = 0; z < pare.length; ++z) 
        //         // System.out.print(pare[z] + ", ");
        //         // System.out.println("");
        //     }
        //     public int find(int x) {
        //         if (x != pare[x]) { // 压缩方式：直接指向根节点
        //             pare[x] = find(pare[x]);
        //         }
        //         return pare[x];
        //     }
        //     public void merge(int x, int y) {
        //         int rootx = find(x);
        //         int rooty = find(y);
        //         if (rootx != rooty) {
        //             if (rank[rootx] < rank[rooty]) {
        //                 int tmp = rootx; // swap(rootx, rooty);
        //                 rootx = rooty;
        //                 rooty = tmp;
        //             }
        //             pare[rooty] = rootx;
        //             if (rank[rootx] == rank[rooty]) rank[rootx] += 1; // 表示父节点所在树的树深度，暂时 表示该节点的最大深度 
        //             cnt--;
        //         }
        //         // System.out.println("pare.length: " + pare.length);
        //         // for (int z = 0; z < pare.length; ++z) 
        //         // System.out.print(pare[z] + ", ");
        //         // System.out.println("");
        //     }
        //     public int get_cnt() {
        //         return cnt;
        //     }
        // }
        // public int removeStones(int[][] stones) {
        //     int n = stones.length;
        //     UnionFind ds = new UnionFind(n);
        //     for (int i = 0; i < n; i++) {
        //         for (int j = i + 1; j < n; j++) {
        //             if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
        //                 // System.out.println("\ni: " + i);
        //                 // System.out.println("j: " + j);
        //                 // System.out.println("(stones[i][0] == stones[j][0]): " + (stones[i][0] == stones[j][0]));
        //                 // System.out.println("(stones[i][1] == stones[j][1]): " + (stones[i][1] == stones[j][1]));
        //                 ds.merge(i, j);
        //             }
        //         }
        //     }
        //     return n - ds.get_cnt();
        // }


        // HashMap<Integer, List<Integer>> m = new HashMap<>();
        // HashSet<Integer> s = new HashSet<>();
        // boolean [] vis;
        // int [] gp;
        // boolean res;
        // public boolean possibleBipartition(int n, int[][] dislikes) {
        //     gp = new int [n+1];
        //     vis = new boolean[n+1];
        //     List<Integer> l = new ArrayList<>();
        //     Arrays.fill(gp, 0);
        //     for (int i = 0; i < n+1; i++) {
        //         l = new ArrayList<>();
        //         m.put(i, l);
        //     }
        //     for (int i = 0; i < dislikes.length; i++) {
        //         m.get(dislikes[i][0]).add(dislikes[i][1]);
        //         m.get(dislikes[i][1]).add(dislikes[i][0]);
        //     }
        //     for (Integer key : m.keySet()) {
        //         if (key != 0 && !s.contains(key) && !vis[key]) {
        //             vis[key] = true;
        //             gp[key] = 1;
        //             s.add(key);
        //             res = true;
        //             dfs(key);
        //             if (!res) return false;
        //         }
        //     }
        //     return true;
        // }
        // private void dfs(int i) {
        //     if (m.get(i).size() == 1 && gp[i] == gp[m.get(i).get(0)]) {
        //         res = false;
        //         return;
        //     }
        //     for (int j = 0; j < m.get(i).size(); j++) {
        //         if (gp[i] == gp[m.get(i).get(j)]) {
        //             res = false;
        //             return;
        //         }
        //     }
        //     for (int j = 0; j < m.get(i).size(); j++) {
        //         if (!vis[m.get(i).get(j)]) {
        //             vis[m.get(i).get(j)] = true;
        //             s.add(m.get(i).get(j));
        //             gp[m.get(i).get(j)] = -gp[i];
        //             dfs(m.get(i).get(j));
        //         }
        //     }
        // }

        
        // HashMap<Integer, List<Integer>> m = new HashMap<>();
        // int n;
        // int [] vis;
        // boolean res;
        // public boolean canFinish(int numCourses, int[][] prerequisites) {
        //     if (numCourses == 2 && prerequisites.length == 1) return true;
        //     List<Integer> l = new ArrayList<>();
        //     n = numCourses;
        //     for (int i = 0; i < n; i++) {
        //         l = new ArrayList<>();
        //         m.put(i, l);
        //     }
        //     for (int i = 0; i < prerequisites.length; i++) {
        //         m.get(prerequisites[i][0]).add(prerequisites[i][1]);
        //     }
        //     vis = new int[n];
        //     res = true;
        //     for (Integer key : m.keySet()) {
        //         if (vis[key] != 1) {
        //             for (int i = 0; i < n; i++) {
        //                 if (vis[i] == -1) vis[i] = 1;
        //             }
        //             vis[key] = -1;
        //             dfs(key);
        //             if (!res) return false;
        //             vis[key] = 1;
        //         }
        //     }
        //     return true;
        // }
        // private void dfs(int i) {
        //     if (m.get(i).size() == 0) return;
        //     for (int j = 0; j < m.get(i).size(); j++) {
        //         if (vis[m.get(i).get(j)] == -1) {
        //             res = false;
        //             return ;
        //         }
        //         if (vis[m.get(i).get(j)] == 0) {
        //             vis[m.get(i).get(j)] = -1;
        //             dfs(m.get(i).get(j));
        //             vis[m.get(i).get(j)] = 1;
        //         }
        //     }
        // }


        // private HashMap<Integer, List<Integer>> m;
        // private int [] res;
        // private void dfsFromRoot(int [] vis, int i, int [][] arr) {
        //     if (m.get(i).size() == 1 && vis[m.get(i).get(0)] == -1) {
        //         if (res == null)
        //         res = new int [] {i, m.get(i).get(0)};
        //         return ;
        //     } else if (m.get(i).size() > 1) {
        //         int cnt = 0;
        //         for (int j = 0; j < m.get(i).size(); j++) {
        //             if (vis[m.get(i).get(j)-1] == -1) ++cnt;
        //         }
        //         if (cnt == m.get(i).size()) {
        //             for (int j = arr.length-1; j >= 0; j--) {
        //                 if ((arr[j][0] == i && m.get(i).contains(arr[j][1])) || (arr[j][1] == i && m.get(i).contains(arr[j][0]))) {
        //                     if (res == null)
        //                     res = arr[j];
        //                     List<Integer> l = m.get(i);
        //                     int z = 0;
        //                     for ( z = 0; z < l.size(); z++) {
        //                         if (l.get(z) == (i == arr[j][0] ? arr[j][1] : arr[j][0])) break;
        //                     }
        //                     int tmp = l.get(z);
        //                     l.remove(z);
        //                     m.put(i, l);
        //                     l = m.get(tmp);
        //                     for ( z = 0; z < l.size(); z++) {
        //                         if (l.get(z) == i) break;
        //                     }
        //                     l.remove(z);
        //                     m.put(tmp, l);
        //                     for (int x = 0; x < vis.length; x++) {
        //                         if (vis[x]== -1) vis[x] = 1;
        //                     }
        //                     return;
        //                 }
        //             }
        //         }
        //         for (int j = 0; j < m.get(i).size(); j++) {
        //             vis[i-1] = -1;
        //             if (vis[m.get(i).get(j)-1] == -1 || vis[m.get(i).get(j)-1] == 1) continue;
        //             vis[m.get(i).get(j)-1] = -1;
        //             dfsFromRoot(vis, m.get(i).get(j), arr);
        //         }
        //     } else {
        //         vis[i-1] = -1;
        //         vis[m.get(i).get(0)-1] = -1;
        //         dfsFromRoot(vis, m.get(i).get(0), arr);
        //     }
        // }
        // public int[] findRedundantConnection(int[][] edges) {
        //     if (edges.length == 2) return edges[1];
        //     m = new HashMap<>();
        //     List<Integer> l = new ArrayList<>();
        //     int n = edges.length;
        //     for (int i = 0; i < n+1; i++) {
        //         l = new ArrayList<>();
        //         m.put(i, l);
        //     }
        //     for (int i = 0; i < edges.length; i++) {
        //         m.get(edges[i][0]).add(edges[i][1]);
        //         m.get(edges[i][1]).add(edges[i][0]);
        //     }
        //     int [] vis = new int[n];
        //     dfsFromRoot(vis, 1, edges);
        //     return res;
        // }


        // public int[] findRedundantConnection(int[][] edges) {
        //     int n = edges.length;
        //     UnionFind uf = new UnionFind(n+1);
        //     int [] res = new int [2];
        //     for (int i = 0; i < n; i++) {
        //         if (!uf.sameGroup(edges[i][0], edges[i][1]))
        //         uf.merge(edges[i][0], edges[i][1]);
        //         else {
        //             res = new int[] {edges[i][0], edges[i][1]};
        //             break;
        //         }
        //     }
        //     return res;
        // }



        // HashMap<Integer, List<Integer>> m = new HashMap<>();
        // HashSet<Integer> s = new HashSet<>();
        // public boolean isBipartite(int[][] graph) {
        //     int n = graph.length;
        //     l = new ArrayList<>();
        //     for (int i = 0; i < n; i++) {
        //         m.put(i, Arrays.stream(graph[i]).boxed().collect(Collectors.toList()));
        //     }
        //     gp = new int[n];
        //     vis = new int [n];
        //     res = true;
        //     for (int i = 0; i < n; i++) {
        //         if (vis[i] == 0 && !s.contains(i)) {
        //             vis[i] = -1;
        //             gp[i] = 1;
        //             s.add(i);
        //             dfs(i);
        //             vis[i] = 1;
        //             if (!res) break;
        //         } 
        //     }
        //     return res;
        // }
        // List<Integer> l = new ArrayList<>();
        // int [] gp;
        // int [] vis;
        // boolean res;
        // private void dfs(int i) {
        //     for (int j = 0; j < m.get(i).size(); j++) {
        //         if (gp[m.get(i).get(j)] == gp[i]) {
        //             res = false;
        //             return;
        //         }
        //         if (gp[m.get(i).get(j)] == 0) gp[m.get(i).get(j)] = -gp[i];
        //     }
        //     for (int j = 0; j < m.get(i).size(); j++) {
        //         if (vis[m.get(i).get(j)] == 0) {
        //             vis[m.get(i).get(j)] = -1;
        //             s.add(m.get(i).get(j));
        //             dfs(m.get(i).get(j));
        //             vis[m.get(i).get(j)] = 1;
        //         } 
        //     }
        // }

        // public int[] findOrder(int numCourses, int[][] prerequisites) {
        //     if (numCourses == 1 && prerequisites.length == 0) return new int[]{0};
        //     int [] arr = new int[numCourses];
        //     for (int i = 0; i < prerequisites.length; i++) {
        //         arr[prerequisites[i][0]]++;
        //     }
        //     List<Integer> l = new ArrayList<>();
        //     HashMap<Integer, List<Integer>> m = new HashMap<>();
        //     for (int i = 0; i < numCourses; i++) {
        //         l = new ArrayList<>();
        //         m.put(i, l);
        //     }
        //     for (int i = 0; i < prerequisites.length; i++) {
        //         m.get(prerequisites[i][1]).add(prerequisites[i][0]);
        //     }
        //     Deque<Integer> deque = new ArrayDeque<>();
        //     for (int i = 0; i < numCourses; i++) {
        //         if (arr[i] == 0) deque.offer(i);
        //     }
        //     l = new ArrayList<>();
        //     if (deque.size() == 0) return new int[0];
        //     while (!deque.isEmpty()) {
        //         int curr = deque.poll();
        //          System.out.println("curr: " + curr);
        //         l.add(curr);
        //         if (m.get(curr).size() == 0) continue;
        //         for (int i = 0; i < m.get(curr).size(); i++) {
        //             arr[m.get(curr).get(i)]--;
        //             if (arr[m.get(curr).get(i)] == 0) {
        //                 deque.offer(m.get(curr).get(i));
        //             }
        //         }
        //     }
        //     int [] res = l.stream().mapToInt(i -> i).toArray();
        //     return l.size() == numCourses ? res : new int[0];
        // }

        
        // HashMap<Integer, List<Integer>> m = new HashMap<>();
        // boolean [][] rea;
        // boolean [] vis;
        // boolean res = false;
        // private void bfs(boolean [][] arr, int x, int y, int cur) {
        //     if (m.get(cur).size() == 0) return;
        //     for (int i = 0; i < m.get(cur).size(); i++) {
        //         if (vis[m.get(cur).get(i)]) continue;
        //         if (m.get(cur).get(i) == y) {
        //             res = true;
        //             rea[x][m.get(cur).get(i)] = true;
        //             return;
        //         }
        //         vis[m.get(cur).get(i)] = true;
        //         bfs(arr, x, y, m.get(cur).get(i));
        //     }
        // }
        // public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        //     List<Boolean> lb = new ArrayList<>();
        //     if (prerequisites.length == 0) {
        //         for (int i = 0; i < queries.length; i++) {
        //             lb.add(false);
        //         }
        //         return lb;
        //     }
        //     List<Integer> l = new ArrayList<>();
        //     for (int i = 0; i < numCourses; i++) {
        //         l = new ArrayList<>();
        //         m.put(i, l);
        //     }
        //     for (int i = 0; i < prerequisites.length; i++) 
        //         m.get(prerequisites[i][0]).add(prerequisites[i][1]);
        //     rea = new boolean [numCourses][numCourses];
        //     vis = new boolean[numCourses];
        //     res = false;
        //     for (int i = 0; i < numCourses; i++) {
        //         for (int j = 0; j < numCourses; j++) {
        //             Arrays.fill(vis, false);
        //             if (j == i) {
        //                 rea[i][j] = true;
        //                 continue;
        //             }
        //             vis[i] = true;
        //             bfs(rea, i, j, i);
        //             rea[i][j] = res;
        //             res = false;
        //         }
        //     }
        //     for (int i = 0; i < queries.length; i++) {
        //         lb.add(rea[queries[i][0]][queries[i][1]]);
        //     }
        //     return lb;
        // }

        
        // HashMap<Integer, List<Integer>> m = new HashMap<>();
        // HashSet<Integer> s;
        // public int maximalNetworkRank(int n, int[][] roads) {
        //     if (n == 2 && roads.length == 2) return 1;
        //     else if (n == 2 && roads.length < 2) return roads.length;
            
        //     List<Integer> l = new ArrayList<>();
        //     for (int i = 0; i < n; i++) {
        //         l = new ArrayList<>();
        //         m.put(i, l);
        //     }
        //     for (int i = 0; i < roads.length; i++) {
        //         m.get(roads[i][0]).add(roads[i][1]);
        //         m.get(roads[i][1]).add(roads[i][0]);
        //     }
        //     int [][] arr = new int[n][n];
        //     for (int i = 0; i < n; i++) {
        //         for (int j = 0; j < n; j++) {
        //             if (j == i) continue;
        //             s = new HashSet<>(m.get(i));
        //             l = m.get(j);
        //             for (Integer val : l)
        //                 s.add(val);
        //             arr[i][j] = s.contains(i) && s.contains(j) ? m.get(i).size() + m.get(j).size()-1 : m.get(i).size() + m.get(j).size();
        //             s.clear();
        //         }
        //     }
        //     int max = Integer.MIN_VALUE;
        //     for (int i = 0; i < n; i++) 
        //         for (int j = 0; j < n; j++) 
        //             if (arr[i][j] > max) max = arr[i][j];
        //     return max;
        // }
        

        // private void helper(int i, int j, int [][] grid) {
        //     if (j < n-1 && grid[i][j] != 1) {
        //         s.get(i*n+j).add(i*n+j+1);
        //         t.get(i*n+j).add(1);
        //     }
        //     if (j > 1 && grid[i][j] != 2) {
        //         s.get(i*n+j).add(i*n+j-1);
        //         t.get(i*n+j).add(1);
        //     }
        //     if (i < m-1 && grid[i][j] != 3) {
        //         s.get(i*n+j).add((i+1)*n+j);
        //         t.get(i*n+j).add(1);
        //     }
        //     if (i > 1 && grid[i][j] != 4) {
        //         s.get(i*n+j).add((i-1)*n+j);
        //         t.get(i*n+j).add(1);
        //     }
        // }
        // HashMap<Integer, List<Integer>> s = new HashMap<>();
        // HashMap<Integer, List<Integer>> t = new HashMap<>();
        // int m, n;
        // public int minCost(int[][] grid) {
        //     m = grid.length;
        //     n = grid[0].length;
        //     if (m == 1 && n == 1) return 0;
        //     List<Integer> l = new ArrayList<>();
        //     for (int i = 0; i < m; i++) {
        //         for (int j = 0; j < n; j++) {
        //             l = new ArrayList<>();
        //             s.put(i * n + j, l);
        //             l = new ArrayList<>();
        //             t.put(i * n + j, l);
        //         }
        //     }
        //     for (int i = 0; i < m; i++) {
        //         for (int j = 0; j < n; j++) {
        //             switch(grid[i][j]) {
        //             case 1:
        //                 if (j < n-1) {
        //                     s.get(i*n+j).add(i*n+j+1);
        //                     t.get(i*n+j).add(0);
        //                 }
        //                 helper(i, j, grid);
        //                 break;
        //             case 2:
        //                 if (j > 0) {
        //                     s.get(i*n+j).add(i*n+j-1);
        //                     t.get(i*n+j).add(0);
        //                 }
        //                 helper(i, j, grid);
        //                 break;
        //             case 3:
        //                 if (i < m-1) {
        //                     s.get(i*n+j).add((i+1)*n+j);
        //                     t.get(i*n+j).add(0);
        //                 }
        //                 helper(i, j, grid);
        //                 break;
        //             case 4:
        //                 if (i > 0) {
        //                     s.get(i*n+j).add((i-1)*n+j);
        //                     t.get(i*n+j).add(0);
        //                 }
        //                 helper(i, j, grid);
        //                 break;
        //             default:
        //             }
        //         }
        //     }
        //     int [] dist = new int [m*n];
        //     dist = dijkstra(m*n);
        //     return dist[m*n-1];
        // }
        // private class Node {
        //     int i;
        //     int v;
        //     public Node(int a, int b) {
        //         i = a;
        //         v = b;
        //     }
        // }
        // Queue<Node> q = new PriorityQueue<>((a, b) -> (a.v - b.v));
        // public int [] dijkstra(int n) {
        //     int [] dist = new int[n];
        //     for (int i = 0; i <= n-1; i++) 
        //         dist[i] = Integer.MAX_VALUE;
        //     dist[0] = 0;
        //     int i = 0;
        //     q.add(new Node(i, 0));
        //     Node tmp = null;
        //     while (!q.isEmpty()) {
        //         tmp = q.poll();
        //         for (int j = 0; j < s.get(tmp.i).size(); j++) {
        //             if (tmp.v + t.get(tmp.i).get(j) < dist[s.get(tmp.i).get(j)]) {
        //                 dist[s.get(tmp.i).get(j)] = tmp.v + t.get(tmp.i).get(j);
        //                 q.add(new Node(s.get(tmp.i).get(j), dist[s.get(tmp.i).get(j)]));
        //             }
        //         }
        //     }
        //     System.out.println("dist.length: " + dist.length);
        //     for (int z = 0; z < dist.length; ++z) 
        //         System.out.print(dist[z] + ", ");
        //     System.out.println("");
        //     return dist;
        // }

        
        // public int shortestPathLength(int[][] graph) {
        //     int n = graph.length;
        //     int tar = 0, res = 0;
        //     HashSet<String> s = new HashSet<>();
        //     Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        //     for (int i = 0; i < n; i++) {
        //         int mask = (1 << i);
        //         tar |= mask;
        //         s.add(Integer.toString(mask) + "-" + Integer.toString(i));
        //         q.add(new Pair<>(mask, i));
        //     }
        //     while (!q.isEmpty()) {
        //         for (int i = q.size(); i > 0; i--) {
        //             Pair cur = q.remove();
        //             if ((int)cur.getKey() == tar) return res;
        //             for (int next : graph[(int)cur.getValue()]) {
        //                 int path = (int)cur.getKey() | (1 << next);
        //                 String str = Integer.toString(path) + "-" + Integer.toString(next);
        //                 if (s.contains(str)) continue;
        //                 s.add(str);
        //                 q.add(new Pair<>(path, next));
        //             }
        //         }
        //         ++res;
        //     }
        //     return -1;
        // }
// // 这个不过，还有bug
//         public int shortestPathLength(int[][] graph) { // 这个不过，还有bug
//             int n = graph.length;
//             int res = n*n;
//             int [][] dp = new int [1 << n][n];
//             for (int i = 0; i < n; i++) 
//                 Arrays.fill(dp[i], n*n);
//             for (int i = 0; i < n; i++) 
//                 dp[1 << i][i] = 0;
//             for (int cur = 0; cur < (1 << n); ++cur) {
//                 boolean repeat = true;
//                 while (repeat) {
//                     repeat = false;
//                     for (int i = 0; i < n; i++) {
//                         int dist = dp[cur][i];
//                         for (int next : graph[i]) {
//                             int path = cur | (1 << next);
//                             if (dist + 1 < dp[path][next]) {
//                                 dp[path][next] = dist + 1;
//                                 if (path == cur) repeat = true;
//                             }
//                         }
//                     }
//                 }
//             }
//             for (int num : dp[(1 << n) - 1])
//                 res = Math.min(res, num);
//             return res;
//         }


        // private class Pt { // 自己写的就是完全暴力的解法，需要提升一下
        //     int i;
        //     int j;
        //     int v;
        //     public Pt(int a, int b, int c) {
        //         this.i = a;
        //         this.j = b;
        //         this.v = c;
        //     }
        // }
        // private int res, m, n; 
        // private boolean [][] vis;
        // private void dfs(int [][] arr, int i, int j, int val, int cnt) {
        //     if (vis[i][j]) return;
        //     vis[i][j] = true;
        //     if (i > 0 && arr[i-1][j] < val) dfs(arr, i-1, j, arr[i-1][j], cnt+1);
        //     if (i < m-1 && arr[i+1][j] < val) dfs(arr, i+1, j, arr[i+1][j], cnt+1);
        //     if (j > 0 && arr[i][j-1] < val) dfs(arr, i, j-1, arr[i][j-1], cnt+1);
        //     if (j < n-1 && arr[i][j+1] < val) dfs(arr, i, j+1, arr[i][j+1], cnt+1);
        //     if (cnt > res) res = cnt;
        //     vis[i][j] = false;
        // }
        // public int longestIncreasingPath(int[][] matrix) {
        //     m = matrix.length;
        //     n = matrix[0].length;
        //     Queue<Pt> q = new PriorityQueue<>((x, y) -> y.v - x.v);
        //     vis = new boolean[m][n];
        //     int max = 1;
        //     for (int i = 0; i < m; i++) {
        //         for (int j = 0; j < n; j++) {
        //             q.add(new Pt(i, j, matrix[i][j]));
        //         }
        //     }
        //     Pt cur = null;
        //     while (!q.isEmpty()) {
        //         cur = q.poll();
        //         res = 0;
        //         dfs(matrix, cur.i, cur.j, cur.v, 1);
        //         max = Math.max(max, res);
        //     }
        //     return max;
        // }
        // int[][] dirs=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        // boolean [][] vis;
        // int [][] memo; // 记忆数组: 使用cache保存已经访问过的位置，这样能节省了很多搜索的过程
        // int m, n; 
        // private int dfs(int [][] arr, int i, int j) {
        //     if (memo[i][j] > 0) return memo[i][j];
        //     int res = 0;
        //     vis[i][j] = true;
        //     for (int [] dir : dirs) {
        //         int x = dir[0]+i;
        //         int y = dir[1]+j;
        //         if (x >= 0 && x < m && y >= 0 && y < n && !vis[x][y] && arr[i][j] < arr[x][y])
        //             res = Math.max(res, dfs(arr, x, y));
        //     }
        //     vis[i][j] = false;
        //     memo[i][j] = res+1;
        //     return res+1;
        // }
        // public int longestIncreasingPath(int[][] matrix) {
        //     m = matrix.length;
        //     n = matrix[0].length;
        //     vis = new boolean[m][n];
        //     memo = new int[m][n];
        //     int max = 1;
        //     for (int i = 0; i < m; i++) {
        //         for (int j = 0; j < n; j++) 
        //             max = Math.max(max, dfs(matrix, i, j));
        //     }
        //     return max;
        // }
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        // int [][] a = new int [][] {{3,4,5},{3,2,6},{2,2,1}};
        int [][] a = new int [][] {{9,9,4},{6,6,8},{2,1,1}};

        System.out.println("a.length: " + a.length);
        for (int z = 0; z < a.length; ++z) {
            for (int w = 0; w < a[z].length; w++) 
                System.out.print(a[z][w] + ", ");
            System.out.print("\n");
        }
        int res = s.longestIncreasingPath(a);
        System.out.println("res: " + res);
    }
}
