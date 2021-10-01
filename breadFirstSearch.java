import com.UnionFind;
import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
// import javafx.util.Pair;

import static java.util.stream.Collectors.toMap;

public class breadFirstSearch {
    public static class Solution {


        // private void bfs(int [][] sur, int [][] arr, int i, int j) {
        //     if (i < 0 || i >= m || j < 0 || j >= n) return;
        //     if (i > 0 && sur[i-1][j] == 0 && arr[i-1][j] == -1) {
        //         arr[i-1][j] = arr[i][j] + 1;
        //         // bfs(sur, arr, i-1, j);
        //     }
        //     if (i < n-1 && sur[i+1][j] == 0 && arr[i+1][j] == -1) {
        //         arr[i+1][j] = arr[i][j] + 1;
        //         // bfs(sur, arr, i+1, j);
        //     }
        //     if (j > 0 && sur[i][j-1] == 0 && arr[i][j-1] == -1) {
        //         arr[i][j-1] = arr[i][j] + 1;
        //         // bfs(sur, arr, i, j-1);
        //     }
        //     if (j < n-1 && sur[i][j+1] == 0 && arr[i][j+1] == -1) {
        //         arr[i][j+1] = arr[i][j] + 1;
        //         // bfs(sur, arr, i, j+1);
        //     }
        // }
        // int m, n;
        // public int[][] highestPeak(int[][] isWater) {
        //     m = isWater.length;
        //     n = isWater[0].length;
        //     int [][] arr = new int[m][n];
        //     for (int [] val : arr)
        //         Arrays.fill(val, -1);
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) 
        //             if (isWater[i][j] == 1) 
        //                 arr[i][j] = 0;
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++)
        //             if (arr[i][j] == 0)
        //                 bfs(isWater, arr, i, j);
        //     return arr;
        // }

        
        // public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        //     HashMap<Integer, List<Integer>> m = new HashMap<>();
        //     List<Integer> l = new ArrayList<>();
        //     for (int i = 0; i < n; i++) 
        //         if (manager[i] == headID) l.add(i);
        //     m.put(headID, l);
        //     for (int i = 0; i < m.get(headID).size(); i++) {
        //         l = new ArrayList<>();
        //         for (int j = 0; j < n; j++) 
        //             if (manager[j] == m.get(headID).get(i)) l.add(j);
        //         m.put(m.get(headID).get(i), l);
        //     }
        // }


        // private class Pt {
        //     int i;
        //     int j;
        //     public Pt (int a, int b) {
        //         i = a;
        //         j = b;
        //     }
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
        //         // pare[0] = -1;
        //         Arrays.fill(rank, 0);
        //         // rank[0] = -1;
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
        //     public int getConnectedCounts() {
        //         System.out.println("getCnt(): " + getCnt());
        //         if (getCnt() == 1) return n;
        //         HashMap<Integer, Integer> m = new HashMap<>();
        //         for (int i = 0; i < n; i++) 
        //             m.put(pare[i], m.getOrDefault(pare[i], 0) + 1);
        //         int res = 0;
        //         for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
        //             if (entry.getValue() > 1) res += entry.getValue();
        //             else if (entry.getValue() == 1) {
        //                 for (int i = 0; i < n; i++) {
        //                     if (pare[i] == entry.getKey() && m.get(find(i)) > 1) res += entry.getValue();
        //                         break;
        //                     }
        //             }
        //         }
        //         return res;
        //     }
        //     private void swap(int x, int y) {
        //         int tmp = x;
        //         x = y;
        //         y = tmp;
        //     }
        // }
        // public int countServers(int[][] grid) {
        //     int m = grid.length;
        //     int n = grid[0].length;
        //     List<Pt> l = new ArrayList<>();
        //     int cnt = 0;
        //     for (int i = 0; i < m; i++) {
        //         for (int j = 0; j < n; j++) {
        //             if (grid[i][j] == 1) {
        //                 l.add(new Pt(i, j));
        //                 ++cnt;
        //             }
        //         }
        //     }
        //     UnionFind uf = new UnionFind(cnt);
        //     for (int i = 0; i < l.size(); i++) {
        //         for (int j = 1; j < l.size(); j++) {
        //             if (!uf.sameGroup(i, j) && (l.get(i).i == l.get(j).i || l.get(i).j == l.get(j).j)) {
        //                 uf.merge(i, j);
        //             }
        //         }
        //     }
        //     return uf.getConnectedCounts();
        // }


        // private boolean diffByOneOne(String x, String y) {
        //     int cnt = 0, dcnt = 0;
        //     for (int i = 0; i < x.length(); i++) {
        //         if (x.charAt(i) != y.charAt(i)) {
        //             if (Math.abs(x.charAt(i) - y.charAt(i)) == 1
        //                 || (x.charAt(i) == '0' && y.charAt(i) == '9')
        //                 || (x.charAt(i) == '9' && y.charAt(i) == '0'))
        //                 ++dcnt;
        //             ++cnt;
        //         }
        //     }
        //     return cnt == 1 && dcnt == 1 ? true : false;
        // }
        // HashMap<Integer, List<Integer>> m = new HashMap<>();
        // List<Integer> l = new ArrayList<>();
        // public int openLock(String[] deadends, String target) {
        //     HashSet<Integer> s = new HashSet<>();
        //     for (int i = 0; i < deadends.length; i++) 
        //         s.add(Integer.parseInt(deadends[i]));
        //     for (int i = 0; i < 10000; i++) {
        //         l = new ArrayList<>();
        //         m.put(i, l);
        //     }            
        //     for (int i = 0; i < 10000; i++) {
        //         for (int j = 0; j < 10000; j++) {
        //             if (j == i || s.contains(i) || s.contains(j)) continue;
        //             if (diffByOneOne(String.format("%04d", i), String.format("%04d", j))) {
        //                 m.get(i).add(j);
        //                 m.get(j).add(i);
        //             }
        //         }
        //     }
        //     return 0;
        // }

        // private class Pt {
        //     int i;
        //     int j;
        //     int v;
        //     public Pt(int a, int b, int c) {
        //         i = a;
        //         j = b;
        //         v = c;
        //     }
        // }
        // boolean [][] vis;
        // int m, n;
        // int max = 0;
        // public int orangesRotting(int[][] grid) {
        //     m = grid.length;
        //     n = grid[0].length;
        //     vis = new boolean[m][n];
        //     boolean needtime = false;
        //     Queue<Pt> q = new LinkedList<>();
        //     for (int i = 0; i < m; i++) {
        //         for (int j = 0; j < n; j++) {
        //             if (grid[i][j] == 1 && !needtime) needtime = true;
        //             if (grid[i][j] == 2) 
        //                 q.add(new Pt(i, j, 0));
        //         }
        //     }
        //     Pt cur = null;
        //     int i = 0, j = 0;
        //     while (!q.isEmpty()) {
        //         cur = q.poll();
        //         i = cur.i;
        //         j = cur.j;
        //         if (vis[i][j]) continue;
        //         vis[i][j] = true;
        //         if (i > 0 && !vis[i-1][j] && grid[i-1][j] == 1) {
        //             q.add(new Pt(i-1, j, cur.v + 1));
        //         }
        //         if (i < m-1 && !vis[i+1][j] && grid[i+1][j] == 1) {
        //             q.add(new Pt(i+1, j, cur.v + 1));
        //         }
        //         if (j > 0 && !vis[i][j-1] && grid[i][j-1] == 1) {
        //             q.add(new Pt(i, j-1, cur.v + 1));
        //         }
        //         if (j < n-1 && !vis[i][j+1] && grid[i][j+1] == 1) {
        //             q.add(new Pt(i, j+1, cur.v + 1));
        //         }
        //         if (cur.v > max) max = cur.v;
        //     }
        //     for ( i = 0; i < m; i++) {
        //         for ( j = 0; j < n; j++) {
        //             if (grid[i][j] == 1 && vis[i][j] == false)  return -1;
        //         }
        //     }
        //     if (!needtime) return 0;
        //     return max;
        // }


        // HashMap<Integer, List<TreeNode>> m = new HashMap<>();
        // List<TreeNode> res;
        // List<Integer> l;
        // private boolean isSame(TreeNode p, TreeNode q) {
        //     if (p == null && q == null) return true;
        //     if (p == null || q == null || p.val != q.val) return false;
        //     return isSame(p.left, q.left) && isSame(p.right, q.right);
        // }
        // private void preOrderTraversal(TreeNode r) {
        //     if (r == null) return;
        //     l.add(r.val);
        //     preOrderTraversal(r.left);
        //     preOrderTraversal(r.right);
        // }
        // private void preOrderTraversalCollectingNodes(TreeNode r) {
        //     if (r == null) return;
        //     if (m.keySet().contains(r.val))
        //         m.get(r.val).add(r);
        //     preOrderTraversalCollectingNodes(r.left);
        //     preOrderTraversalCollectingNodes(r.right);
        // }
        // private boolean contains(List<TreeNode> l, TreeNode p) {
        //     for (int i = 0; i < l.size(); i++) {
        //         if (isSame(l.get(i), p)) return true;
        //     }
        //     return false;
        // }
        // public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        //     res = new ArrayList<>();
        //     if (root.left == null && root.right == null) return res;
        //     l = new ArrayList<>();
        //     preOrderTraversal(root);
        //     HashSet<Integer> s = new HashSet<>();
        //     List<TreeNode> lt;
        //     for (int i = 0; i < l.size(); i++) {
        //         if (!s.contains(l.get(i))) s.add(l.get(i));
        //         else {
        //             lt = new ArrayList<>();
        //             m.put(l.get(i), lt);
        //         }
        //     }
        //     preOrderTraversalCollectingNodes(root);
        //     int x = 0;
        //     for (Map.Entry<Integer, List<TreeNode>> entry : m.entrySet()) {
        //         lt = entry.getValue();
        //         for (int i = 0; i < lt.size(); i++) {
        //             for (int j = lt.size()-1; j >= 0; j--) {
        //                 if (j == i) continue;
        //                 if (isSame(lt.get(i), lt.get(j)) && !contains(res, lt.get(i)) && !contains(res, lt.get(j)))
        //                     res.add(lt.get(i));
        //             }
        //         }
        //     }
        //     return res;
        // }




        // public class Pt {
        //     int i;
        //     int j;
        //     int v;
        //     public Pt(int a, int b, int c) {
        //         i = a;
        //         j = b;
        //         v = c;
        //     }
        // }
        // public int maxDistance(int[][] grid) {
        //     int m = grid.length;
        //     int n = grid[0].length;
        //     boolean [][]  vis = new boolean[m][n];
        //     Queue<Pt> q = new LinkedList<>();
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) 
        //             if (grid[i][j] == 1 && !vis[i][j]) {
        //                 q.add(new Pt(i, j, 0));
        //             }
        //     Pt cur = null;
        //     int i = 0, j = 0;
        //     int max = Integer.MIN_VALUE;
        //     while (!q.isEmpty()) {
        //         cur = q.poll();
        //         i = cur.i;
        //         j = cur.j;
        //         if (vis[i][j]) continue;
        //         vis[i][j] = true;
        //         if (i > 0 && !vis[i-1][j]) {
        //             q.add(new Pt(i-1, j, grid[i-1][j] == 0 ? cur.v + 1 : 0));
        //         }
        //         if (i < m-1 && !vis[i+1][j]) {
        //             q.add(new Pt(i+1, j, grid[i+1][j] == 0 ? cur.v + 1 : 0));
        //         }
        //         if (j > 0 && !vis[i][j-1]) {
        //             q.add(new Pt(i, j-1, grid[i][j-1] == 0 ? cur.v + 1 : 0));
        //         }
        //         if (j < n-1 && !vis[i][j+1]) {
        //             q.add(new Pt(i, j+1, grid[i][j+1] == 0 ? cur.v + 1 : 0));
        //         }
        //         if (grid[i][j] == 0 && cur.v > max) max = cur.v;
        //     }
        //     return max == Integer.MIN_VALUE ? -1 : max;
        // }

        
        // public class Pt {
        //     int i;
        //     int j;
        //     public Pt(int a, int b) {
        //         i = a;
        //         j = b;
        //     }
        // }
        // public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        //     int m = grid.length;
        //     int n = grid[0].length;
        //     boolean [][]  vis = new boolean[m][n];
        //     int [][] arr = new int[m][n];
        //     Queue<Pt> q = new LinkedList<>();
        //     Pt cur = null;
        //     int i = 0, j = 0, cnt = 0;
        //     q.add(new Pt(r0, c0));
        //     while (!q.isEmpty()) {
        //         cur = q.poll();
        //         i = cur.i;
        //         j = cur.j;
        //         if (vis[i][j]) continue;
        //         if (i == 0 || i == m-1 || j == 0 || j == n-1) arr[i][j] = color;
        //         vis[i][j] = true;
        //         cnt = 0;
        //         if (i > 0 && grid[i][j] == grid[i-1][j]) {
        //             if (!vis[i-1][j])
        //                 q.add(new Pt(i-1, j));
        //             ++cnt;
        //         }
        //         if (i < m-1 && grid[i][j] == grid[i+1][j]) {
        //             if (!vis[i+1][j])
        //                 q.add(new Pt(i+1, j));
        //             ++cnt;
        //         }
        //         if (j > 0 && grid[i][j] == grid[i][j-1]) {
        //             if (!vis[i][j-1])
        //                 q.add(new Pt(i, j-1));
        //             ++cnt;
        //         }
        //         if (j < n-1 && grid[i][j] == grid[i][j+1]) {
        //             if (!vis[i][j+1])
        //                 q.add(new Pt(i, j+1));
        //             ++cnt;
        //         }
        //         if (cnt < 4) arr[i][j] = color;
        //     }
        //     for ( i = 0; i < m; i++) 
        //         for ( j = 0; j < n; j++) 
        //             if (arr[i][j] == 0) arr[i][j] = grid[i][j];
        //     return arr;
        // }


        // public class Pt {
        //     int i;
        //     int j;
        //     int v;
        //     public Pt(int a, int b, int c) {
        //         i = a;
        //         j = b;
        //         v = c;
        //     }
        // }
        // public int[][] highestPeak(int[][] isWater) {
        //     int m = isWater.length;
        //     int n = isWater[0].length;
        //     int [][] arr = new int [m][n];
        //     for (int i = 0; i < m; i++)
        //         Arrays.fill(arr[i], -1);
        //     boolean [][] vis = new boolean[m][n];
        //     Queue<Pt> q = new LinkedList<>();
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) 
        //             if (isWater[i][j] == 1 && !vis[i][j]) 
        //                 q.add(new Pt(i, j, 0));
        //     Pt cur = null;
        //     int i = 0, j = 0;
        //     while (!q.isEmpty()) {
        //         cur = q.poll();
        //         i = cur.i;
        //         j = cur.j;
        //         if (vis[i][j]) continue;
        //         vis[i][j] = true;
        //         arr[i][j] = cur.v;
        //         if (i > 0 && !vis[i-1][j]) {
        //             q.add(new Pt(i-1, j, cur.v + 1));
        //         }
        //         if (i < m-1 && !vis[i+1][j]) {
        //             q.add(new Pt(i+1, j, cur.v + 1));
        //         }
        //         if (j > 0 && !vis[i][j-1]) {
        //             q.add(new Pt(i, j-1, cur.v + 1));
        //         }
        //         if (j < n-1 && !vis[i][j+1]) {
        //             q.add(new Pt(i, j+1, cur.v + 1));
        //         }
        //     }
        //     return arr;
        // }

        
        // private void dfs(int [][] arr, int i, int j, int cnt, boolean [][] vis) {
        //     if (i < 0 || i >= n || j < 0 || j >= n || vis[i][j] || arr[i][j] == 1) return;
        //     if (i == n-1 && j == n-1) {
        //         if (cnt < min) min = cnt;
        //         return;
        //     }
        //     vis[i][j] = true;
        //     dfs(arr, i+1, j+1, cnt+1, vis);
        //     dfs(arr, i-1, j+1, cnt-1, vis);
        //     dfs(arr, i+1, j-1, cnt-1, vis);
        //     dfs(arr, i-1, j-1, cnt-1, vis);
        //     dfs(arr, i-1, j, cnt+1, vis);
        //     dfs(arr, i+1, j, cnt+1, vis);
        //     dfs(arr, i, j+1, cnt+1, vis);
        //     dfs(arr, i, j-1, cnt+1, vis);
        // }
        // int min = Integer.MAX_VALUE;
        // int n;
        // public class Pt {
        //     int i;
        //     int j;
        //     int v;
        //     public Pt(int a, int b, int c) {
        //         i = a;
        //         j = b;
        //         v = c;
        //     }
        // }
        // public int shortestPathBinaryMatrix(int[][] grid) {
        //     if (grid[0][0] == 1) return -1;
        //     n = grid.length;
        //     boolean [][] vis = new boolean[n][n];
        //     Queue<Pt> q = new LinkedList<>(); // Pair
        //     q.add(new Pt(0, 0, 1));
        //     Pt cur = null;
        //     int [][] arr = new int[n][n];
        //     for (int i = 0; i < n; i++)
        //         Arrays.fill(arr[i], Integer.MAX_VALUE);
        //     while (!q.isEmpty()) {
        //         cur = q.poll();
        //         if (cur.v >= arr[cur.i][cur.j]) continue;
        //         if (cur.v < arr[cur.i][cur.j]) arr[cur.i][cur.j] = cur.v;
        //         int i = cur.i;
        //         int j = cur.j;
        //         if (i < n-1 && j < n-1 && grid[i+1][j+1] == 0 && !vis[i+1][j+1]) {
        //             q.add(new Pt(i+1, j+1, cur.v+1));
        //             vis[i+1][j+1] = true;
        //         }
        //         if (i > 0 && j > 0 && grid[i-1][j-1] == 0 && !vis[i-1][j-1]) {
        //             q.add(new Pt(i-1, j-1, cur.v+1));
        //             vis[i-1][j-1] = true;
        //         }
        //         if (i > 0 && j < n-1 && grid[i-1][j+1] == 0 && !vis[i-1][j+1]) {
        //             q.add(new Pt(i-1, j+1, cur.v+1));
        //             vis[i-1][j+1] = true;
        //         }
        //         if (i < n-1 && j > 0 && grid[i+1][j-1] == 0 && !vis[i+1][j-1]) {
        //             q.add(new Pt(i+1, j-1, cur.v+1));
        //             vis[i+1][j-1] = true;
        //         }
        //         if (i > 0 && grid[i-1][j] == 0 && !vis[i-1][j]) {
        //             q.add(new Pt(i-1, j, cur.v+1));
        //             vis[i-1][j] = true;
        //         }
        //         if (i < n-1 && grid[i+1][j] == 0 && !vis[i+1][j]) {
        //             q.add(new Pt(i+1, j, cur.v+1));
        //             vis[i+1][j] = true;
        //         }
        //         if (j > 0 && grid[i][j-1] == 0 && !vis[i][j-1]) {
        //             q.add(new Pt(i, j-1, cur.v+1));
        //             vis[i][j-1] = true;
        //         }
        //         if (j < n-1 && grid[i][j+1] == 0 && !vis[i][j+1]) {
        //             q.add(new Pt(i, j+1, cur.v+1));
        //             vis[i][j+1] = true;
        //         }
        //     }
        //     return arr[n-1][n-1] == Integer.MAX_VALUE ? -1 : arr[n-1][n-1];
        // }

        

        // // public class Pt {
        // //     int i;
        // //     int v;
        // //     public Pt(int a, int b) {
        // //         i = a;
        // //         v = b;
        // //     }
        // // }
        // static int [][] dir = {{-1, 0}, {1, 0},{0, -1}, {0, 1}};
        // boolean [][] vis;
        // int step;
        // int m, n;
        // private int bfs(char [][] arr, int x, int y, int step) {
        //     Queue<int []> q = new LinkedList<>();
        //     q.offer(new int[]{x, y});
        //     vis[x][y] = true;
        //     while (!q.isEmpty()) {
        //         int size = q.size();
        //         for (int i = 0; i < size; i++) {
        //             int [] c = q.poll();
        //             for (int d = 0; d < 4; d++) {
        //                 int nx = c[0] + dir[d][0];
        //                 int ny = c[1] + dir[d][1];
        //                 if (nx >= 0 && nx < m && ny >= 0 && ny < n && arr[nx][ny] == '.' && !vis[nx][ny]) {
        //                     vis[nx][ny] = true;
        //                     if (nx == 0 || nx == m-1 || ny == 0 || ny == n-1) return step;
        //                     q.offer(new int[]{nx, ny});
        //                 }
        //             }
        //         }
        //         ++step;
        //     }
        //     return -1;
        // }
        // public int nearestExit(char[][] maze, int[] entrance) {
        //     m = maze.length;
        //     n = maze[0].length;
        //     vis = new boolean[m][n];
        //     step = 1;
        //     int res = bfs(maze, entrance[0], entrance[1], step);
        //     return res;
        // }            
        //     // Queue<Pt> q = new LinkedList<>();
        //     // int i = 0, j = 0;
        //     // int min = Integer.MAX_VALUE;
        //     // Pt cur = null;
        //     // for (int x = 0; x < m; x++)
        //     //     Arrays.fill(vis[x], false);
        //     // q.add(new Pt(entrance[0]*n+entrance[1], 0));
        //     // vis[entrance[0]][entrance[1]] = true;
        //     // while (!q.isEmpty()) {
        //     //     cur = q.poll();
        //     //     i = cur.i / n;
        //     //     j = cur.i % n;
        //     //     vis[i][j] = true;
        //     //     if (cur.v > min) continue;
        //     //     if ((i == 0 || i == m-1 || j == 0 || j == n-1)
        //     //         && (i != entrance[0] || j != entrance[1])) {
        //     //         if (cur.v < min) min = cur.v;
        //     //         return min;
        //     //         // continue;
        //     //     }
        //     //     if (i > 0 && !vis[i-1][j] && maze[i-1][j] == '.')
        //     //         q.add(new Pt((i-1)*n+j, cur.v+1));
        //     //     if (i < m-1 && !vis[i+1][j] && maze[i+1][j] == '.')
        //     //         q.add(new Pt((i+1)*n+j, cur.v+1));
        //     //     if (j > 0 && !vis[i][j-1] && maze[i][j-1] == '.')
        //     //         q.add(new Pt(i*n+j-1, cur.v+1));
        //     //     if (j < n-1 && !vis[i][j+1] && maze[i][j+1] == '.')
        //     //         q.add(new Pt(i*n+j+1, cur.v+1));
        //     // }
        //     // return min == Integer.MAX_VALUE ? -1 : min;
        // // }

        
        // public class Pt {
        //     int i;
        //     int v;
        //     boolean l;
        //     public Pt(int a, int b) {
        //         i = a;
        //         v = b;
        //         l = false;
        //     }
        //     public Pt(int a, int b, boolean d) {
        //         i = a;
        //         v = c;
        //         l = d;
        //     }
        // }
        // // static int [][] dir = {{-1, 0}, {1, 0},{0, -1}, {0, 1}};
        // boolean [][] vis;
        // int step;
        // int n;
        // private int bfs(char [][] arr, int x, int y, int step) {
        //     Queue<int []> q = new LinkedList<>();
        //     q.offer(new int[]{x, y});
        //     vis[x][y] = true;
        //     while (!q.isEmpty()) {
        //         int size = q.size();
        //         for (int i = 0; i < size; i++) {
        //             int [] c = q.poll();
        //             for (int d = 0; d < 4; d++) {
        //                 int nx = c[0] + dir[d][0];
        //                 int ny = c[1] + dir[d][1];
        //                 if (nx >= 0 && nx < m && ny >= 0 && ny < n && arr[nx][ny] == '.' && !vis[nx][ny]) {
        //                     vis[nx][ny] = true;
        //                     if (nx == 0 || nx == m-1 || ny == 0 || ny == n-1) return step;
        //                     q.offer(new int[]{nx, ny});
        //                 }
        //             }
        //         }
        //         ++step;
        //     }
        //     return -1;
        // }
        // // public int snakesAndLadders(int[][] board) {
        // public int snakesAndLadders(int[][] arr) {
        //     int n = arr.length;
        //     Queue<Pt> q = new LinkedList<>();
        //     Pt cur = null;
        //     boolean [][] vis = new boolean[n][n];
        //     int min = Integer.MAX_VALUE;
        //     q.add(new Pt(n-1, 0, 0));
        //     vis[n-1][0] = true;
        //     int idx = 0, i = 0, j = 0;
        //     int x = 0, y = 0;
        //     boolean prel = false;
        //     while (!q.isEmpty()) {
        //         cur = q.poll();
        //         if (vis[cur.i][cur.j] || cur.v > min) continue;
        //         i = cur.i;
        //         j = cur.j;
        //         if (i == 0 && j == 0) {
        //             if (cur.v < min) min = cur.v;
        //             continue;
        //         }
        //         if (arr[i][j] > 0 && !prel) {
        //             prel = true;
        //             x = n-1 - (arr[i][j]-1) / n;
        //             if ((arr[i][j]-1) / n % 2 == 0)
        //                 y = (arr[i][j]-1) % n;
        //             else y = n-1 - (arr[i][j]-1) % n;
        //             q.add(new Pt(x, y, cur.v, true));
        //         }
        //         for (int k = ; k < n; k++) {
        //         }
        //     }
        // }


        // private boolean diffByOneDigitByOne(int x, int y) {
        //     System.out.println("x: " + x);
        //     System.out.println("y: " + y);
        //     if (Math.abs((x+"").length() - (y+"").length()) > 1) return false;
        //     if (Math.abs((x+"").length() - (y+"").length()) == 1) {
        //         if (Math.abs(x-y) % (x > y ? (y+"").length()*10 : (x+"").length()*10) == 0) {
        //             String i =  ((x+"").length() < (y+"").length() ? y : x) + "";
        //             if (i.charAt(0) == '1' || i.charAt(0) == '9') return true;
        //             else return false;
        //         } else return false;
        //     }
        //     String s = x+"";
        //     String t = y+"";
        //     int i = 0, j = 0;
        //     int cnt = 0;
        //     while (i < 4 && j < 4) {
        //         while (i < s.length() && j < t.length() && s.charAt(i) == t.charAt(j)) {
        //             ++i;
        //             ++j;
        //         }
        //         if (i == s.length() && j == t.length()) return cnt <= 1;
        //         if (Math.abs(s.charAt(i) - t.charAt(j)) > 1) {
        //             if ((s.charAt(i) == '0' && t.charAt(j) == '9')
        //                 || (s.charAt(i) == '9' && t.charAt(j) == '0')) {
        //                 ++cnt;
        //                 ++i;
        //                 ++j;
        //                 if (i == 4 && j == 4) return cnt <= 1;
        //             }
        //             else return false;
        //         } else if (Math.abs(s.charAt(i) - t.charAt(j)) == 1) {
        //             ++cnt;
        //             if (cnt > 1) return false;
        //             ++i;
        //             ++j;
        //             if (i == 4 && j == 4) return cnt <= 1;
        //         }
        //     }
        //     return false;
        // }
        // int N;
        // public int openLock(String[] deadends, String target) {
        //     if (Arrays.asList(deadends).contains("0000")) return -1;
        //     Set<Integer> s = new HashSet<>();
        //     for (String v : deadends) 
        //         s.add(Integer.parseInt(v));
        //     N = 10000;
        //     Map<Integer, List<Integer>> m = new HashMap<>();
        //     for (int i = 0; i < N; i++) 
        //         m.put(i, new ArrayList<Integer>());
        //     for (int i = 0; i < N; i++) {
        //         for (int j = 0; j < N; j++) {
        //             if (i == j || s.contains(i) || s.contains(j)) continue;
        //             boolean tmp = diffByOneDigitByOne(i, j);
        //             System.out.println("tmp: " + tmp);
        //             if (tmp) {
        //             // if (diffByOneDigitByOne(i, j)) {
        //                 m.get(i).add(j);
        //                 m.get(j).add(i);
        //             }                        
        //         }
        //     }
        //     // 从target往0000搜，同步判断deadend?
        //     return 0;
        // }


        // public int numBusesToDestination(int[][] routes, int source, int target) {
        //     int n = routes.length;
        //     Set<Integer> l = new HashSet<>();
        //     Queue<Pair<Integer, Integer>> q = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        //     int min = n;
        //     for (int i = 0; i < n; i++) {
        //         l = Arrays.stream(routes[i]).boxed().collect(Collectors.toSet());
        //         if (l.contains(source)) {
        //             if (l.contains(target)) return 1;
        //             q.add(new Pair<>(i, 1));
        //         }
        //     }
        //     Pair cur = null;
        //     while (!q.isEmpty()) {
        //         cur = q.poll();
        //         if (cur.getValue > min) continue; // 咸觉这里面还有大量的重复
        //         for (int i = 0; i < routes[i].length; i++) {
        //             if (routes[i] == target) {
        //                 if (cur.getValue() < min) min = cur.getValue();
        //                 continue;
        //             }
        //             if (routes[i] == source) continue;
        //         }
        //     }
        //     return 0;
        // }


        // 枚举所有可能的情况，取一个最小的。
        // 在初始字符串轮转i次的情况下，对字符串的奇数位累加j次，
        // 若可以使得字符串的偶数位变成奇数位，即b是奇数的情况下，再使得字符串的偶数位累加k次
        // -- （这里可以对偶数位累加是因为若b是奇数，则我们可以保证字符串的字符总体不变的情况下改变字符的顺序使得奇数位移动到偶数位）。
        // 每一次操作后都取一个最小值
        // public String findLexSmallestString(String s, int a, int b) {
        //     int n = s.length();
        //     String ans = s;
        //     StringBuilder tmp = new StringBuilder(s);
        //     for (int i = 1; i <= n; i++) { // 每次转b 位，连续转n次
        //         tmp = new StringBuilder(tmp.substring(n-b) + tmp.substring(0, n-b));
        //         ans = ans.compareTo(tmp.toString()) < 0 ? ans : tmp.toString();
        //         StringBuilder tt = tmp;
        //         for (int j = 1; j <= 10; j++) {
        //             for (int k = 1; k <= n; k += 2) {
        //                 tt.setCharAt(k, (char)((tt.charAt(k) - '0'+a) % 10 + '0'));
        //             }
        //             ans = ans.compareTo(tmp.toString()) < 0 ? ans : tmp.toString();
        //             if (b % 2 == 1) {
        //                 StringBuilder ttt = tt;
        //                 for (int p = 1; p <= 10; p++) {
        //                     for (int k = 0; k < n; k += 2) 
        //                         ttt.setCharAt(k, (char)((ttt.charAt(k) -'0'+a)% 10 +'0'));
        //                     ans = ans.compareTo(tmp.toString()) < 0 ? ans : tmp.toString();
        //                 }
        //             }
        //         }
        //     }
        //     return ans;
        // }

        // public void dfs(int[][] a, int i, int j, Queue<int[]> queue) {
        //     if (i < 0 || i >= a.length || j < 0 || j >= a[0].length) return;
        //     if (a[i][j] != 1) return;
        //     a[i][j] = 2;
        //     queue.add(new int[]{i,j});
        //     dfs(a, i+1, j, queue);
        //     dfs(a, i-1, j, queue);
        //     dfs(a, i, j+1, queue);
        //     dfs(a, i, j-1, queue);
        // }
        // public int shortestBridge(int[][] a) {
        //     Queue<int[]> queue = new LinkedList<>();
        //     for (int i = 0; i < a.length; ++i) {
        //         for (int j = 0;j < a[0].length; ++j) {
        //             if (a[i][j] == 1) {                    
        //                 dfs(a, i, j, queue);         
        //                 break;
        //             }
        //         }
        //         if (queue.size() > 0) break;
        //     }
        //     int step = 0;
        //     while(queue.size() > 0) {            
        //         int size = queue.size();
        //         for (int k = 0; k < size; ++k) {
        //             int[] pos = queue.poll();
        //             int i = pos[0], j = pos[1];                
        //             if (a[i][j] == 1) return step-1;
        //             add(queue, a, i+1, j);                    
        //             add(queue, a, i-1, j);
        //             add(queue, a, i, j+1);
        //             add(queue, a, i, j-1);                            
        //         }            
        //         step++;
        //     }        
        //     return -1;
        // }
        // public void add(Queue<int[]> queue, int[][] a, int i, int j) {
        //     if (i < 0 || i >= a.length || j < 0 || j >= a[0].length) return;
        //     if (a[i][j] == 0 || a[i][j] == 1) {
        //         if (a[i][j] == 0)  // key thing to update here rather than after queue.poll()
        //             a[i][j] = 2;   
        //         queue.add(new int[]{i, j});            
        //     }        
        // }
        // public class Pt {
        //     int i;
        //     int j;
        //     public Pt(int a, int b) {
        //         i = a;
        //         j = b;
        //     }
        // }
        // private void findFirstIsland(int [][] arr) {
        //     for (int i = 0; i < m; i++) {
        //         for (int j = 0; j < n; j++) {
        //             if (arr[i][j] == 1) {
        //                 dfs(i, j, arr);
        //                 return;
        //             }
        //         }
        //     }
        // }
        // private void dfs(int i, int j, int [][] grid) {
        //     if (i < 0 || i >= m || j < 0 || j >= n
        //         || grid[i][j] != 1) return; // vis[][] replaed by 1 2 values
        //     s.add(i*n+j);
        //     grid[i][j] = 2;
        //     dfs(i-1, j, grid);
        //     dfs(i+1, j, grid);
        //     dfs(i, j-1, grid);
        //     dfs(i, j+1, grid);
        // }        
        // HashSet<Integer> s = new HashSet<>();
        // Set<Integer> sb = new HashSet<>();
        // int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // int m, n;
        // int min;
        // private void bfs(int [][] arr) {
        //     Pt cur = null;
        //     int i = 0, j = 0;
        //     Queue<Pt> q = new LinkedList<>();
        //     for (int cnt = 0; cnt < m+n; cnt++) {
        //         for (Integer v : s) 
        //             q.add(new Pt(v/n, v%n));
        //         sb = new HashSet<>();
        //         for (int k = 0; k < s.size(); k++) {
        //             cur = q.poll();
        //             i = cur.i;
        //             j = cur.j;
        //             for (int [] d : dirs) {
        //                 if (i+d[0] >= 0 && i+d[0] < m && j+d[1] >= 0 && j+d[1] < n) {
        //                     if (arr[i+d[0]][j+d[1]] == 1) {
        //                         if (cnt < min) min = cnt;
        //                         return;
        //                     } else if (arr[i+d[0]][j+d[1]] == 0) {
        //                         arr[i+d[0]][j+d[1]] = 2;
        //                         sb.add((i+d[0])*n+j+d[1]);
        //                     }
        //                 } 
        //             }
        //         }
        //         s.clear();
        //         s.addAll(sb);
        //         sb.clear();
        //     }
        // }
        // public int shortestBridge(int[][] grid) {
        //     m = grid.length;
        //     n = grid[0].length;
        //     findFirstIsland(grid);
        //     min = Integer.MAX_VALUE;
        //     bfs(grid);
        //     return min;
        // }

        
        
        // private void flip(int [][] arr, int v) {
        //     int i = v / n;
        //     int j = v % n;
        //     arr[i][j] = 1 - arr[i][j];
        //     for (int [] d : dirs) {
        //         if (i+d[0] >= 0 && i+d[0] < m && j+d[1] >= 0 && j+d[1] < n)
        //             arr[i+d[0]][j+d[1]] = 1 - arr[i+d[0]][j+d[1]];
        //     }
        // }
        // private boolean isZeroMatrix(int [][] arr) {
        //     for (int i = 0; i < arr.length; i++) 
        //         for (int j = 0; j < arr[0].length; j++) 
        //             if (arr[i][j] == 1) return false;
        //     return true;
        // }
        // private void helper(int [][] arr, int idx, int cnt) {
        //     if (isZeroMatrix(arr)) {
        //         if (cnt < min) min = cnt;
        //         return;
        //     }
        //     int i = 0, j = 0;
        //     for (int x = idx; x < m*n; x++) {
        //         i = x / n;
        //         j = x % n;
        //         if (!vis[x]) {
        //             vis[x] = true;
        //             flip(arr, x);
        //             helper(arr, idx+1, cnt+1);
        //             flip(arr, x);
        //             vis[x] = false;
        //         }
        //     }
        // }
        // int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // int min = Integer.MAX_VALUE;
        // boolean [] vis;
        // int m, n;
        // public int minFlips(int[][] mat) {
        //     m = mat.length;
        //     n = mat[0].length;
        //     vis = new boolean[m*n];
        //     min = Integer.MAX_VALUE;
        //     helper(mat, 0, 0);
        //     return min == Integer.MAX_VALUE ? -1 : min;
        // }


        // public int[][] updateMatrix(int[][] mat) {
        //     int m = mat.length;
        //     int n = mat[0].length;
        //     int [][] arr = new int[m][n];
        //     for (int i = 0; i < m; i++) 
        //         Arrays.fill(arr[i], Integer.MAX_VALUE);
        //     Set<Integer> sc = new HashSet<>();
        //     for (int i = 0; i < m; i++) {
        //         for (int j = 0; j < n; j++) {
        //             if (mat[i][j] == 0) {
        //                 arr[i][j] = 0;
        //                 sc.add(i*n+j);
        //             }
        //         }
        //     }
        //     int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        //     Set<Integer> sn = new HashSet<>();
        //     Queue<Integer> q = new LinkedList<>();
        //     int cnt = 0, i = 0, j = 0, cur = 0;
        //     boolean [][] vis = new boolean [m][n];
        //     while (sc.size() > 0) {
        //         for (Integer v : sc) 
        //             q.add(v);
        //         while (!q.isEmpty()) {
        //             cur = q.poll();
        //             i = cur / n;
        //             j = cur % n;
        //             if (vis[i][j]) continue;
        //             vis[i][j] = true;
        //             arr[i][j] = cnt;
        //             for (int [] d : dirs) {
        //                 if (i+d[0] >= 0 && i+d[0] < m && j+d[1] >= 0 && j+d[1] < n
        //                     && mat[i+d[0]][j+d[1]] == 1 && !vis[i+d[0]][j+d[1]] && arr[i+d[0]][j+d[1]] == Integer.MAX_VALUE)
        //                     sn.add((i+d[0])*n+j+d[1]);
        //             }
        //         }
        //         sc.clear();
        //         sc.addAll(sn);
        //         sn.clear();
        //         ++cnt;
        //     }
        //     return arr;
        // }


        // int [][] jp = {
        //     {4, 6},    
        //     {6, 8},    
        //     {7, 9},    
        //     {4, 8},    
        //     {0, 3, 9},
        //     {}, 
        //     {0, 1, 7},    
        //     {2, 6},    
        //     {1, 3},    
        //     {2, 4} 
        // };
        // long [][] memo;
        // private long helper(int idx, int n) {
        //     if (memo[idx][n] > 0) return memo[idx][n];
        //     if (n == 1) {
        //         memo[idx][n] = jp[idx].length;
        //         return jp[idx].length;
        //     }
        //     long res = 0;
        //     for (Integer v : jp[idx]) {
        //         memo[v][n-1] = helper(v, n-1);
        //         res += memo[v][n-1];
        //     }
        //     if (res > Integer.MAX_VALUE) res %= 1000000007;
        //     memo[idx][n] = res;
        //     return res;
        // }
        // public int knightDialer(int n) {
        //     if (n == 1) return 10;
        //     if (n == 2) return 20;
        //     long res = 0;
        //     memo = new long [10][n];
        //     for (int i = 0; i < jp.length; i++) 
        //         res += helper(i, n-1);
        //     return (int)(res % 1000000007);
        // }


        // public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        //     int n = status.length; 
        //     Queue<Integer> q = new LinkedList<>();
        //     int res = 0;
        //     boolean [] vis = new boolean[n];
        //     Set<Integer> s = new HashSet<>(); // set of keys
        //     Set<Integer> sb = new HashSet<>(); // set of unopened boxes
        //     for (int i = 0; i < initialBoxes.length; i++) {
        //         if (status[initialBoxes[i]] == 1) {
        //             q.offer(initialBoxes[i]);
        //             res += candies[initialBoxes[i]];
        //         }
        //     }
        //     int cur = 0;
        //     int idx = 0;
        //     while (!q.isEmpty()) {
        //         cur = q.poll();
        //         vis[cur] = true;
        //         if (keys[cur].length > 0) {
        //             s.addAll(Arrays.stream(keys[cur]).boxed().collect(Collectors.toSet()));
        //         }
        //         for (int i = 0; i < containedBoxes[cur].length; i++) {
        //             if (!vis[containedBoxes[cur][i]] && (status[containedBoxes[cur][i]] == 1 || (s.size() > 0 && s.contains(containedBoxes[cur][i])))) {
        //                 q.add(containedBoxes[cur][i]);
        //                 res += candies[containedBoxes[cur][i]];
        //                 vis[containedBoxes[cur][i]] = true;
        //             } else if (status[containedBoxes[cur][i]] == 0 && (s.size() == 0 || !s.contains(containedBoxes[cur][i])))
        //                 sb.add(containedBoxes[cur][i]);
        //         }
        //         for (Integer v : sb) {
        //             if (!vis[v] && s.contains(v)) {
        //                 res += candies[v];
        //                 q.add(v);
        //             }
        //         }
        //     }
        //     return res;
        // }
        // public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        //     boolean [] hasKey = new boolean[status.length];
        //     Queue<Integer> q = new LinkedList<>();
        //     for (int box : initialBoxes) q.add(box);
        //     int res = 0;
        //     while (q.size() > 0) {
        //         int size = q.size();
        //         boolean isValid = false;
        //         int cur = 0; // cur box
        //         while (size-- > 0) {
        //             cur = q.poll();
        //             if (status[cur] == 1 || hasKey[cur]) {
        //                 res += candies[cur];
        //                 for (int k : keys[cur]) 
        //                     hasKey[k] = true;
        //                 for (int box : containedBoxes[cur]) 
        //                     q.add(box);
        //                 isValid = true;
        //             } else {
        //                 q.add(cur); // 当前盒子打不开时，将盒子重新加回到Queue中
        //             }
        //         }
        //         if (!isValid) break;
        //     }
        //     return res;
        // }
        // public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        //     List<Integer> boxes = new ArrayList<>(); //用来存放所有盒子的链表
        //     for (int i = 0; i < initialBoxes.length; i++) 
        //         boxes.add(initialBoxes[i]);
        //     for (int i = 0; i < keys.length; i++)   //遍历钥匙，如果有这个钥匙，则将对应的status设置为1
        //         for (int j = 0; j < keys[i].length; j++)   
        //             status[keys[i][j]] = 1;
        //     int idx = 0;
        //     int res = 0;
        //     while (idx < boxes.size()) {
        //         int box = boxes.get(idx);
        //         res += candies[box];
        //         for (int i = 0; i < containedBoxes[box].length; i++) {
        //             if (status[containedBoxes[box][i]] == 1) boxes.add(containedBoxes[box][i]);
        //         }
        //         ++idx;
        //     }
        //     return res;
        // }

    }

    public static void main(String[] args) {
        Solution s = new Solution();

            
        
        int res = s.maxCandies(a, b, c, d, e);
        System.out.println("res: " + res);
    }
}
