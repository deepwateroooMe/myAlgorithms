import com.UnionFind;
// import com.NestedInteger;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;

public class depthFirstSearch {
    public static class Solution {

        // public void floodFillRecursive(int[][] image, int r, int c, int p, int nc) {
        //     int m = image.length;
        //     int n = image[0].length;
        //     if (r > m - 1|| r < 0 || c > n - 1 || c < 0) return;
        //     if (image[r][c] == nc) return;
        //     if (image[r][c] == p) image[r][c] = nc;
        //     else return;
        //     if (r >= 1 && r < m) floodFillRecursive(image, r - 1, c, p, nc);
        //     if (r >= 0 && r < m - 1) floodFillRecursive(image, r + 1, c, p, nc);
        //     if (c >= 1 && c < n) floodFillRecursive(image, r, c - 1, p, nc);
        //     if (c >= 0 && c < n - 1) floodFillRecursive(image, r, c + 1, p, nc);
        // }        
        // public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //     if (image.length == 1 && image[0].length == 1) {
        //         image[0][0] = newColor;
        //         return image;
        //     }
        //     floodFillRecursive(image, sr, sc, image[sr][sc], newColor);
        //     return image;
        // }

        // private List<List<Integer>> ll;
        // public void allPathsSourcRecursiveeTarget(int[][] arr, int i, int j, List<Integer> l) {
        //     if (arr[i] == null) {
        //         List<Integer> tmp = l;
        //         ll.add(tmp);
                
        //     }
        // }
        // public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        //     List<Integer> l = new ArrayList<>();
        //     ll = new ArrayList<List<>>();
        //     int n = graph.length;
        //     allPathsSourcRecursiveeTarget(graph, n, 0, 0, l);
        // }

        // public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // }

        // private boolean [][] vis;
        // private int res;
        // public void isIslandsDFS(char[][] arr, int i, int j) {
        //     int m = arr.length;
        //     int n = arr[0].length;
        //     vis[i][j] = true;
        //     if (i >= 1 && i < m && arr[i-1][j] == '1' && vis[i-1][j] == false) isIslandsDFS(arr, i-1, j);
        //     if (i >= 0 && i < m-1 && arr[i+1][j] == '1' && vis[i+1][j] == false) isIslandsDFS(arr, i+1, j);
        //     if (j >= 1 && j < n && arr[i][j-1] == '1' && vis[i][j-1] == false) isIslandsDFS(arr, i, j-1);
        //     if (j >= 0 && j < n-1 && arr[i][j+1] == '1' && vis[i][j+1] == false) isIslandsDFS(arr, i, j+1);
        // }
        // public int numIslands(char[][] grid) {
        //     int m = grid.length;
        //     int n = grid[0].length;
        //     if (m == 1 && n == 1) return grid[0][0] == '1' ? 1 : 0;
        //     vis = new boolean [m][n];
        //     res = 0;
        //     for (int i = 0; i < m; i++) {
        //         for (int j = 0; j < n; j++) {
        //             if (grid[i][j] == '1' && vis[i][j] == false) {
        //                 isIslandsDFS(grid, i, j);
        //                 ++res;
        //             }
        //         }
        //     }
        //     return res;
        // }

        // private int res;
        // private List<Integer> l;
        // public void kthSmallestRecursive(TreeNode r, List<Integer> l, int val) {
        //     // System.out.println("r.val: " + r.val);
        //     // System.out.println("l.size(): " + l.size());
        //     if (r.left != null) {
        //         l.add(0, r.val);
        //         kthSmallestRecursive(r.left, l, val);
        //         l.remove(0);
        //     }
        //     l.add(r.val);
        //     if (r.right != null) {
        //         kthSmallestRecursive(r.right, l, val);
        //     }
        // }
        // public int kthSmallest(TreeNode root, int k) {
        //     res = 0;
        //     l = new ArrayList<Integer>();
        //     kthSmallestRecursive(root, l, k);
        //     // System.out.println("");
        //     // System.out.println("l.size(): " + l.size());
        //     // for (int i = 0; i < l.size(); ++i) 
        //     // System.out.println(l.get(i));
        //     // System.out.println("");
        //     return l.get(k-1);
        // }


        // // This is the interface that allows for creating nested lists.
        // // You should not implement it, or speculate about its implementation
        // public interface NestedInteger {
        //     // Constructor initializes an empty nested list.
        //     public NestedInteger();
                
        //     // Constructor initializes a single integer.
        //     public NestedInteger(int value);
                
        //     // @return true if this NestedInteger holds a single integer, rather than a nested list.
        //     public boolean isInteger();
                
        //     // @return the single integer that this NestedInteger holds, if it holds a single integer
        //     // Return null if this NestedInteger holds a nested list
        //     public Integer getInteger();
                
        //     // Set this NestedInteger to hold a single integer.
        //     public void setInteger(int value);
                
        //     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        //     public void add(NestedInteger ni);
                
        //     // @return the nested list that this NestedInteger holds, if it holds a nested list
        //     // Return empty list if this NestedInteger holds a single integer
        //     public List<NestedInteger> getList();
        // }
        // public NestedInteger deserialize(String s) {
        //     if (s.length() == 1) return new NestedInteger(Integer.parseInt(s.substring(0, 1)));
        //     int n = s.length();
        //     int cnt = 0;
        //     int i = 0, j = i;
        //     if (s.charAt(0) != '[') {
        //         while (j < n && Character.isDigit(s.charAt(j))) ++j;
        //         if (j == n) return new NestedInteger(Integer.parseInt(s.substring(i, j)));
                
        //     }
        // }
        // private  List<Integer> deserializeToArray(String data) {
        //     List<Integer> l = new ArrayList<>();
        //     int n = data.length();
        //     int j = data.charAt(0) == '-' ? 1 : 0, i = 0;
        //     while (j < n) {
        //         while (j < n && (Character.isDigit(data.charAt(j)) || data.charAt(j) == '-')) j++;
        //         System.out.println("j: " + j);
        //         if (j > i && j < n) {
        //             l.add(Integer.parseInt(data.substring(i, j)));
        //             if (j == n) return l;
        //         }
        //         if (data.charAt(j) == '#') {
        //             l.add(-1111);
        //             ++j;
        //         }
        //         while (j < n && data.charAt(j) != '-' && data.charAt(j) != '#' && !Character.isDigit(data.charAt(j))) j++;
        //         if (j == n) return l;
        //         i = j;
        //         System.out.println("i: " + i);
        //     }
        //     return l;
        // }

        // private boolean filesOnly;
        // private List<String> l;
        // private void parseStringHelper(String s) {
        // }
        // public void lengthLongesPathRecursivet(String r) {
        // }
        // public int lengthLongestPath(String input) {
        // }

        // private int res;
        // public void islandPerimeterRecursive(int[][] arr, int i, int j) {
        //     int val = 0;
        //     int m = arr.length;
        //     int n = arr[0].length;
        //     if (i > 0 && i < m && arr[i-1][j] == 1) {
        //         ++val;
        //     }
        //     if (i >= 0 && i < m-1 && arr[i+1][j] == 1) {
        //         ++val;
        //     }
        //     if (j > 0 && j < n && arr[i][j-1] == 1) {
        //         ++val;
        //     }
        //     if (j >= 0 && j < n-1 && arr[i][j+1] == 1) {
        //         ++val;
        //     }
        //     if (val == 1) res += 3;
        //     else if (val == 2) res += 2;
        //     else if (val == 3) res += 1;
        //     else if (val == 0) res += 4;
        // }
        // public int islandPerimeter(int[][] grid) {
        //     int m = grid.length;
        //     int n = grid[0].length;
        //     if (m == 1 && n == 1) return grid[0][0] == 1 ? 4 : 0;
        //     res = 0;
        //     for (int i = 0; i < m; i++) {
        //         for (int j = 0; j < n; j++) {
        //             if (grid[i][j] == 1) {
        //                 islandPerimeterRecursive(grid, i, j);
        //             }
        //         }
        //     }
        //     return res;
        // }

        // private int res, val, maxIsland;
        // public void maxAreaORecursivefIsland(int[][] arr, boolean [][] vis, int i, int j) {
        //     int m = arr.length;
        //     int n = arr[0].length;
        //     vis[i][j] = true;
        //     if (i > m-1 || j > n-1 || i < 0 || j < 0) return;
        //     ++val;
        //     if (i >= 1 && i < m && arr[i-1][j] == 1 && vis[i-1][j] == false) maxAreaORecursivefIsland(arr, vis, i-1, j);
        //     if (i < m-1 && i >= 0 && arr[i+1][j] == 1 && vis[i+1][j] == false) maxAreaORecursivefIsland(arr, vis, i+1, j);
        //     if (j >= 1 && j < n && arr[i][j-1] == 1 && vis[i][j-1] == false) maxAreaORecursivefIsland(arr, vis, i, j-1);
        //     if (j >= 0 && j < n-1 && arr[i][j+1] == 1 && vis[i][j+1] == false) maxAreaORecursivefIsland(arr, vis, i, j+1);

        //     if (val > maxIsland) {
        //         maxIsland = val;
        //     }
        // }
        // public int maxAreaOfIsland(int[][] grid) {
        //     int m = grid.length;
        //     int n = grid[0].length;
        //     if (m == 1 && n == 1) return grid[0][0] == 1 ? 1 : 0;
        //     boolean [][] vis = new boolean[m][n];
        //     if (m == 1 && n == 1) return grid[0][0];
        //     maxIsland = Integer.MIN_VALUE;
        //     boolean noland = true;
        //     for (int i = 0; i < m; i++) {
        //         for (int j = 0; j < n; j++) {
        //             if (grid[i][j] == 1 && vis[i][j] == false) {
        //                 noland = false;
        //                 val = 0;
        //                 maxAreaORecursivefIsland(grid, vis, i, j);
        //             }
        //         }
        //     }
        //     if (noland) return 0;
        //     return maxIsland;
        // }

        // private int res, cnt, val;
        // private void floodFillAndCompare(int [][] arr, boolean [][] vis, int [][] ori, int i, int j) {
        //     int m = arr.length;
        //     int n = arr[0].length;
        //     vis[i][j] = true;
        //     if (i > m-1 || j > n-1 || i < 0 || j < 0) return;
        //     if (ori[i][j] == 1) ++cnt;
        //     ++val;
        //     if (i >= 1 && i < m && arr[i-1][j] == 1 && vis[i-1][j] == false) floodFillAndCompare(arr, vis, ori, i-1, j);
        //     if (i < m-1 && i >= 0 && arr[i+1][j] == 1 && vis[i+1][j] == false) floodFillAndCompare(arr, vis, ori, i+1, j);
        //     if (j >= 1 && j < n && arr[i][j-1] == 1 && vis[i][j-1] == false) floodFillAndCompare(arr, vis, ori, i, j-1);
        //     if (j >= 0 && j < n-1 && arr[i][j+1] == 1 && vis[i][j+1] == false) floodFillAndCompare(arr, vis, ori, i, j+1);
        // }
        // public int countSubIslands(int[][] grid1, int[][] grid2) {
        //     int m = grid1.length;
        //     int n = grid1[0].length;
        //     boolean [][] vis = new boolean [m][n];
        //     res = 0;
        //     for (int i = 0; i < m; i++) {
        //         for (int j = 0; j < n; j++) {
        //             if (grid2[i][j] == 1 && vis[i][j] == false) {
        //                 cnt = 0;
        //                 val = 0;
        //                 floodFillAndCompare(grid2, vis, grid1, i, j);
        //                 if (val == cnt) ++res;
        //             }
        //         }
        //     }
        //     return res;
        // }

        // private boolean [][] vis;
        // private int res, m, n;
        // private boolean surr;
        // private void closedIslandRecursive(int [][] arr, int i, int j) {
        //     vis[i][j] = true;
        //     if (i < 1 || i >= m-1 || j < 1 || j >= n-1) surr = false;
        //     if (j > 0 && j < n && arr[i][j-1] == 0 && vis[i][j-1] == false) closedIslandRecursive(arr, i, j-1);
        //     if (j >= 0 && j < n-1 && arr[i][j+1] == 0 && vis[i][j+1] == false) closedIslandRecursive(arr, i, j+1);
        //     if (i > 0 && i < m && arr[i-1][j] == 0 && vis[i-1][j] == false) closedIslandRecursive(arr, i-1, j);
        //     if (i >= 0 && i < m-1 && arr[i+1][j] == 0 && vis[i+1][j] == false) closedIslandRecursive(arr, i+1, j);
        // }
        // public int closedIsland(int[][] grid) {
        //     if (grid.length == 1 && grid[0].length == 1) return 0;
        //     m = grid.length;
        //     n = grid[0].length;
        //     vis = new boolean[m][n];
        //     res = 0;
        //     surr = true;
        //     for (int i = 1; i < m-1; i++) {
        //         for (int j = 1; j < n-1; j++) {
        //             if (grid[i][j] == 0 && vis[i][j] == false) {
        //                  closedIslandRecursive(grid, i, j);
        //                 if (surr) res += 1;
        //                 else surr = true;
        //             }
        //         }
        //     }
        //     /*            grid.length: 10
        //             1  2  3  4  5  6  7  8  9
        //          0, 0, 1, 1, 0,| 1, 0, 0, 1, 0, 
        //    1     1, 1, 0_ 1, 1,| 0x 1, 1, 1, 0, 
        //    2     1, 0_ 1, 1, 1,| 0, 0x 1, 1, 0, 
        //    3     0, 1, 1, 0, 0,| 0, 0, 1, 0_, 1, 
        //    4     0, 0, 0, 0, 0x| 0, 1, 1, 1, 0, 
        //    5     0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 
        //    6     1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 
        //    7     1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 
        //    8     1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 
        //    9     1, 1, 1, 0, 1, 1, 0, 1, 1, 0,  */
        //     // System.out.println("");
        //     // System.out.println("grid.length: " + grid.length);
        //     // for (int i = 0; i < grid.length; ++i) {
        //     //     for (int j = 0; j < grid[0].length; ++j)
        //     //     System.out.print(grid[i][j] + ", ");
        //     //     System.out.print("\n");
        //     // }
        //     return res;
        // }

        // private List<List<Integer>> ll;
        // private int n;
        // private void dfs(HashMap<Integer, List<Integer>> m, int val, List<Integer> l) {
        //     if (!m.containsKey(val) || val == n-1) {
        //         if (l.size() > 1 && val == n-1) {
        //             ll.add(l);
        //         }
        //     } else {
        //         if (m.get(val).size() == 1) {
        //             List<Integer> tmp = new ArrayList<>(l);
        //             tmp.add(m.get(val).get(0));
        //             dfs(m, m.get(val).get(0), tmp);
        //         } else {
        //             for (int i = 0; i < m.get(val).size(); i++) {
        //                 List<Integer> tmp = new ArrayList<>(l);
        //                 tmp.add(m.get(val).get(i));
        //                 dfs(m, m.get(val).get(i), tmp);
        //             }
        //         }
        //     }
        // }
        // public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        //     ll = new ArrayList<>();
        //     List<Integer> l = new ArrayList<>();
        //     Stack<Integer> s = new Stack<Integer>();
        //     Stack<Integer> t = new Stack<>();
        //     n = graph.length;
        //     HashMap<Integer, List<Integer>> m = new HashMap<Integer, List<Integer>>();
        //     int key = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (graph[i].length > 0) {
        //             // l = Arrays.stream(graph[i]).boxed().toList();
        //             for (int j = 0; j < graph[i].length; j++) {
        //                 l.add(graph[i][j]);
        //             }
        //             m.put(i, l);
        //             l = new ArrayList<>();
        //         }
        //     }
        //     l = new ArrayList<>();
        //     l.add(0);
        //     dfs(m, 0, l);
        //     return ll;
        // }

        // public int findCenter(int[][] edges) {
        //     return edges[0][(edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) ? 0 : 1];
        // }

        // public int findJudge(int n, int[][] trust) {
        //     if (n == 1) return 1;
        //     else if (n == 2 && trust.length == 1) return trust[0][1];
        //     HashMap<Integer, Integer> m = new HashMap<>();
        //     int tmp = 0;
        //     for (int i = 0; i < trust.length; i++) {
        //         if (m.containsKey(trust[i][1])) {
        //             tmp = m.get(trust[i][1]);
        //             tmp += 1;
        //             m.put(trust[i][1], tmp);
        //         } else m.put(trust[i][1], 1);
        //     }
        //     for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
        //         if  (entry.getValue() == n -1) {
        //             int cnt = 0;
        //             for (Integer val : m.values()) {
        //                 if (val == n-1) ++cnt;
        //             }
        //             //return cnt == 1 ? entry.getKey() : -1;
        //             if (cnt == 1) {
        //                 tmp = entry.getKey();
        //                 for (int i = 0; i < trust.length; i++) {
        //                     if (trust[i][0] == tmp) return -1;
        //                 }
        //                 return tmp;
        //             }
        //         }
        //     }
        //     return -1;
        // }

        // public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        //     List<Integer> res = new ArrayList<>();
        //     if (edges.size() == 1 && n == 2) {
        //         res = new ArrayList<>();
        //         res.add(edges.get(0).get(0));
        //         return res;
        //     }
        //     HashMap<Integer, List<Integer>> map = new HashMap<>();
        //     HashSet<Integer> reached = new HashSet<>();
        //     int m = edges.size();
        //     List<Integer> l = null, tmp = null;
        //     for (int i = 0; i < m; i++) {
        //         tmp = edges.get(i);
        //         if (!map.containsKey(tmp.get(0))) {
        //             l = new ArrayList<>();
        //             l.add(tmp.get(1));
        //             map.put(tmp.get(0), l);
        //         } else {
        //             l = map.get(tmp.get(0));
        //             l.add(tmp.get(1));
        //             map.put(tmp.get(0), l);
        //         }
        //     }
        //     for (List<Integer> val : map.values()) {
        //         if (val.size() == 1) reached.add(val.get(0));
        //         else {
        //             for (int i = 0; i < val.size(); i++) {
        //                 reached.add(val.get(i));
        //             }
        //         }
        //     }
        //     for (Integer key : map.keySet()) {
        //         if (!reached.contains(key)) res.add(key);
        //     }
        //     return res;
        // }


        
        // List<Integer> l;
        // boolean res = true;
        // private boolean bfs(HashMap<Integer, List<Integer>> m, HashSet<Integer> a, HashSet<Integer> b, int key, boolean ina, boolean [][] vis) {
        //     System.out.println("\nkey: " + key);
        //     System.out.println("ina: " + ina);
            
        //     if (m.containsKey(key)) {
        //         l = m.get(key);
        //         for (int i = 0; i < l.size(); i++) {
        //             if (ina && a.contains(l.get(i))) {
        //                 res = false;
        //                 return res;
        //             } else if (!ina && b.contains(l.get(i))) {
        //                 res = false;
        //                 return res;
        //             }
        //             if (vis[key][l.get(i)] || vis[l.get(i)][key]) continue;
                    
        //             if (ina && !b.contains(l.get(i)) && l.get(i) != 0) {
        //                 b.add(l.get(i));
        //             } else if (!ina && !a.contains(l.get(i)) && l.get(i) != 0) {
        //                 a.add(l.get(i));
        //             }
        //         }
        //         for (int i = 0; i < l.size(); i++) {
        //             if (vis[key][l.get(i)] || vis[l.get(i)][key]) continue;
        //             if (l.get(i) != 0 && !vis[key][l.get(i)] && !vis[l.get(i)][key]) {
        //                 vis[key][l.get(i)] = true;
        //                 bfs(m, a, b, l.get(i), !ina, vis);
        //             } else continue;
        //         }
        //     }
        //     res = true;
        //     return res;
        // }
        // public boolean isBipartite(int[][] graph) {
        //     int n = graph.length;
        //     if (n == 1) return false;
        //     HashMap<Integer, List<Integer>> m = new HashMap<>();
        //     HashSet<Integer> s = new HashSet<>();
        //     HashSet<Integer> t = new HashSet<>();
        //     l = new ArrayList<>();
        //     boolean ina = false;
        //     for (int i = 0; i < n; i++) {
        //         l = new ArrayList<>(Arrays.stream(graph[i]).boxed().toList());
        //         m.put(i, l);
        //     }
        //     System.out.println("");
        //     System.out.println("m.size(): " + m.size());
        //     for (Map.Entry<Integer, List<Integer>> entry : m.entrySet()) 
        //     System.out.print(entry.getKey() + ", " + entry.getValue() + "\n");
        //     System.out.println("");

        //     boolean[][] vis = new boolean[n][n];
        //     s.add(0);
        //     ina = true;
        //     res = true;
        //     return bfs(m, s, t, 0, ina, vis);
        //     // return res;
        // }


        // private int res;
        // private int n;
        // HashSet<Integer> vd;
        // private void dfs(HashMap<Integer, List<Integer>> m, int [] vis, int val) {
        //     if (m.get(val).size() == 0) {
        //         for (int i = 0; i < n; i++) {
        //             if (vis[i] == -1) vis[i] = 1;
        //         }
        //         return;
        //     } else {
        //         for (int i = 0; i < m.get(val).size(); i++) {
        //             if (vis[m.get(val).get(i)] == -1 || vis[m.get(val).get(i)] == 1) continue;
        //             vis[m.get(val).get(i)] = -1;
        //             vd.add(m.get(val).get(i));
        //             dfs(m, vis, m.get(val).get(i));
        //         }
        //     }
        // }
        // public int findCircleNum(int[][] isConnected) { // path and cycles
        //     if (isConnected.length == 1) return 1;
        //     n = isConnected.length;
        //     vd = new HashSet<>();
        //     HashMap<Integer, List<Integer>> map = new HashMap<>();
        //     List<Integer> l = new ArrayList<>();
        //     for (int i = 0; i < n; i++) {
        //         l = new ArrayList<>();
        //         map.put(i, l);
        //     }
        //     for (int i = 0; i < n; i++) {
        //         for (int j = i+1; j < n; j++) {
        //             if (isConnected[i][j] == 1) {
        //                 map.get(i).add(j);
        //                 map.get(j).add(i);
        //             }
        //         }
        //     }
        //     int [] vis = new int[n];
        //     for (Integer key : map.keySet()) {
        //         if (vd.size() < n && !vd.contains(key)) {
        //             vd.add(key);
        //             vis[key] = -1;
        //             dfs(map, vis, key);
        //             ++res;
        //             Arrays.fill(vis, 0);
        //         }
        //     }
        //     return res;
        // }

        // private HashMap<Integer, List<Integer>> m;
        // private HashMap<Integer, List<Integer>> o;
        // private HashSet<Integer> s;
        // private int res;
        // private void dfsFromRoot(HashMap<Integer, List<Integer>> m, HashMap<Integer, List<Integer>> o, int [] vis, int i) {
        //     for (int j = 0; j < m.get(i).size(); j++) {
        //         if (vis[m.get(i).get(j)] == -1 || vis[m.get(i).get(j)] == 1) continue;
        //         if (o.get(i).size() > 0 && o.get(i).contains(m.get(i).get(j))) ++res;
        //         vis[m.get(i).get(j)] = -1;
        //         s.add(m.get(i).get(j));
        //         dfsFromRoot(m, o, vis, m.get(i).get(j));
        //     }
        // }
        // public int minReorder(int n, int[][] connections) {
        //     if (n == 2) return connections[0][0] == 0 ? 1 : 0;
        //     m = new HashMap<>();
        //     o = new HashMap<>();
        //     List<Integer> l = new ArrayList<>();
        //     s = new HashSet<>();
        //     HashSet<Integer> reached = new HashSet<>();
        //     res = 0;

        //     for (int i = 0; i < n; i++) {
        //         l = new ArrayList<>();
        //         m.put(i, l);
        //         l = new ArrayList<>();
        //         o.put(i, l);
        //     }
        //     for (int i = 0; i < connections.length; i++) {
        //         m.get(connections[i][0]).add(connections[i][1]);
        //         m.get(connections[i][1]).add(connections[i][0]);
        //         o.get(connections[i][0]).add(connections[i][1]);
        //     }
        //     int [] vis = new int[n];
        //     vis[0] = -1;
        //     s.add(0);
        //     dfsFromRoot(m, o, vis, 0);
        //     return res;
        // }                    


        
        // private int res;
        // private int n;
        // private boolean more = false;
        // private int dfs(int [][] arr, boolean [] vis, int idx, int val) {
        //     for (int i = 0; i < n && vis[i] == false; i++) {
        //          System.out.println("arr[i]: [" + arr[i][0] + ", " + arr[i][1] + "]");
        //         if  ((arr[i][0] == arr[idx][0] || arr[i][1] == arr[idx][1]) && vis[i] == false) {
        //             vis[i] = true;
        //             dfs(arr, vis, i, val + 1);
        //         }
        //     }
        //     for (int i = 0; i < n && i != idx && vis[i] == false; i++) {
        //         vis[i] = true;
        //         dfs(arr, vis, i, val+ 1);
        //     }
        //     return val;
        // }
        // public int removeStones(int[][] stones) {
        //     if (stones.length == 1) return 0;
        //     n = stones.length;
        //     boolean [] vis = new boolean[n];
        //     res = 0;
        //     int val = 0;
        //     for (int i = 0; i < n; i++) {
        //         Arrays.fill(vis, false);
        //         vis[i] = true;
        //         val = dfs(stones, vis, i, 0);
        //         if (val > res) res = val;
        //         System.out.println("res: " + res);
        //     }
        //     return res;
        // }

        // class Employee {
        //     public int id;
        //     public int importance;
        //     public List<Integer> subordinates;
        // };
        // HashMap<Integer, List<Integer>> m;
        // HashMap<Integer, Integer> o;
        // public int getImportanceRecursive(int id) {
        //     if (m.get(id).size() == 0) {
        //         return o.get(id);
        //     }
        //     int res = 0;
        //     for (int i = 0; i < m.get(id).size(); i++) {
        //         res += getImportanceRecursive(m.get(id).get(i));
                
        //     }
        //     res += o.get(id);
        //     return res;
        // }
        // public int getImportance(List<Employee> employees, int id) {
        //     if (employees.size() == 1) return employees.get(0).importance;
        //     int n = employees.size();
        //     m = new HashMap<>();
        //     o = new HashMap<>();
        //     List<Integer> l = new ArrayList<>();
        //     for (int i = 0; i < n+1; i++) {
        //         l = new ArrayList<>();
        //         m.put(i, l);
        //     }
        //     for (int i = 0; i < n; i++) {
        //         m.put(employees.get(i).id, employees.get(i).subordinates);
        //         o.put(employees.get(i).id, employees.get(i).importance);
        //     }
        //     int res = 0;
        //     Stack<Integer> s = new Stack<>();
        //     return getImportanceRecursive(id);
        // }

        // public class Ret {
        //     int cnt;
        //     int val;
        //     public Ret(int a, int b) {
        //         cnt = a;
        //         val = b;
        //     }
        //     public void print() {
        //         System.out.println("Ret: " + cnt + ", " + val);
        //     }
        // }
        // private int res;
        // private Ret getSum(TreeNode r) {
        //     if (r == null) return new Ret(0, 0);
        //     if (r.left == null && r.right == null) return new Ret(1, r.val);
        //     if (r.left != null) {
        //         Ret left = getSum(r.left);
        //     }
        //     if (r.right != null) {
        //         Ret right = getSum(r.right);
        //     }
        //     return new Ret(1 + (r.left != null ? left.cnt : 0) + (r.right != null ? right.cnt : 0),
        //                    r.val + (r.left != null ? left.val : 0) + (r.right != null ? right.val : 0));
        // }
        // Ret left, right;
        // public int distributeCoinsRecursive(TreeNode r, int val) {
        //     if (r == null) return 0;
        //     if (r.left == null && r.right == null) {
        //         if (r.val == 0 && val == 1) return 1;
        //         else if (r.val == 1) return 0;
        //         // else if (r.val > 1) return r.val - 1;
        //     }
        //     if (r.left == null || r.right == null) {
        //         return (val + r.val == 0 ? 1 : val + r.val -1)
        //             + distributeCoinsRecursive(r.left == null ? r.right : r.left, val + r.val - 1);
                                               
        //     }
        //     left = getSum(r.left);
        //     right = getSum(r.right);
        //     left.print();
        //     right.print();

        //     if (val + r.val -1 != left.cnt - left.val + right.cnt - right.val)
        //     System.out.println(" (val + r.val -1 != left.cnt - left.val + right.cnt - right.val:) " +  (val + r.val -1 != left.cnt - left.val + right.cnt - right.val));

        //     if (left.cnt == left.val && right.cnt == right.val) {
        //         System.out.println("(val + r.val != 1): " + (val + r.val != 1));
        //         return distributeCoinsRecursive(r.left, 0) + distributeCoinsRecursive(r.right, 0);
        //     } else if (left.cnt == left.val || right.cnt == right.val) {
        //         return left.cnt == left.val ? distributeCoinsRecursive(r.left, 0) : distributeCoinsRecursive(r.right, 0)
        //             + (val + r.val == 0 ? 1 : val + r.val -1)
        //             + distributeCoinsRecursive(left.cnt == left.val ? r.right : r.left, val + r.val - 1);
        //     }
        //     return val + r.val - 1 == 0 ? 2 * Math.abs(left.cnt - left.val) :  
        //         + distributeCoinsRecursive(r.left, Math.abs(left.cnt - left.val))
        //         + distributeCoinsRecursive(r.right, Math.abs(right.cnt - right.val));
        // }
        // public int distributeCoins(TreeNode root) {
        //     if (root.left == null && root.right == null) return 0;
        //     res = 0;
        //     return distributeCoinsRecursive(root, 0);
        // }

        // int m;
        // int n;
        // private int getMax(char [][] arr, int a, int b) {
        //     int cnt = 1, res = 0;
        //     int i = 0;
        //     int prev = 0;
        //     if (a < 2) {
        //         prev = a;
        //         for (int j = a + 2; j < m; j++) {
        //             if (arr[j][b] == 'X' && j - prev >= 2) {
        //                 ++cnt;
        //                 prev = j;
        //             }
        //         }
        //     } else if (a >= n-2) {
        //         prev = a;
        //         for (int j = a-1; j >= 0; j--) {
        //             if (arr[j][b] == 'X' && prev - j >= 2) {
        //                 ++cnt;
        //                 prev = j;
        //             }
        //         }
        //     } else {
        //         prev = a;
        //         for (int j = a + 2; j < m; j++) {
        //             if (arr[j][b] == 'X' && j - prev >= 2) {
        //                 ++cnt;
        //                 prev = j;
        //             }
        //         }
        //         prev = a;
        //         for (int j = a-1; j >= 0; j--) {
        //             if (arr[j][b] == 'X' && prev - j >= 2) {
        //                 ++cnt;
        //                 prev = j;
        //             }
        //         }
        //     }
        //     res = cnt;
        //     cnt = 1;
        //     if (b < 2) {
        //         prev = b;
        //         for (int j = b+2; j < n; j++) {
        //             if (arr[a][j] == 'X' && j - prev >= 2) {
        //                 ++cnt;
        //                 prev = j;
        //             }
        //         }
        //     } else if (b >= n-2) {
        //         prev = b;
        //         for (int j = b-2; j >= 0; j--) {
        //             if (arr[a][j] == 'X' && j - prev >= 2) {
        //                 ++cnt;
        //                 prev = j;
        //             }
        //         }
        //     } else {
        //         prev = b;
        //         for (int j = b+2; j < n; j++) {
        //             if (arr[a][j] == 'X' && j - prev >= 2) {
        //                 ++cnt;
        //                 prev = j;
        //             }
        //         }
        //         prev = b;
        //         for (int j = b-2; j >= 0; j--) {
        //             if (arr[a][j] == 'X' && j - prev >= 2) {
        //                 ++cnt;
        //                 prev = j;
        //             }
        //         }
        //     }
        //     System.out.println("cnt: " + cnt);
        //     if (cnt > res) res = cnt;
        //     System.out.println("res: " + res);
        //     return res;
        // }
        // public int countBattleships(char[][] board) {
        //     if (board.length == 1 && board[0].length == 1) return board[0][0] == 'X' ? 1 : 0;
        //     m = board.length;
        //     n = board[0].length;
        //     int res = 0;
        //      // System.out.println("");
        //      // System.out.println("board.length: " + board.length);
        //      // for (int z = 0; z < board.length; ++z) {
        //      //     for (int w = 0; w < board[z].length; w++) {
        //      //         System.out.print(board[z][w] + ", ");
        //      //     }
        //      //     System.out.print("\n");
        //      // }
        //      // System.out.println("");
        //     for (int i = 0; i < m; i++) {
        //         for (int j = 0; j < n; j++) {
        //             if (board[i][j] == 'X') {
        //                  System.out.println("\ni: " + i);
        //                  System.out.println("j: " + j);
        //                  res = Math.max(getMax(board, i, j), res);
        //             }
        //         }
        //     }
        //     return res;
        // }

        // int n;
        // HashMap<Integer, List<Integer>> m;
        // HashSet<Integer> s;
        // private void dfs(boolean [] vis, int key) {
        //     if (m.get(key).size() == 0 && s.size() == n) return;
        //     for (int i = 0; i < m.get(key).size(); i++) {
        //         if (vis[m.get(key).get(i)]) continue;
        //         s.add(m.get(key).get(i));
        //         vis[m.get(key).get(i)] = true;
        //         dfs(vis, m.get(key).get(i));
        //     }
        // }
        // public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        //     n = rooms.size();
        //     m = new HashMap<>();
        //     s = new HashSet<>();
        //     List<Integer> l = new ArrayList<>();
        //     boolean [] vis = new boolean[n];
        //     for (int i = 0; i < n; i++) {
        //         m.put(i, rooms.get(i));
        //     }
        //     s.add(0);
        //     vis[0] = true;
        //     dfs(vis, 0);
        //     return s.size() == n ? true : false;
        // }

        // int m;
        // int n;
        // char[][] res;
        // private void dfs(char [][] arr, int i, int j) {
        //     if (i < 0 || i >= m || j < 0 || j >= n) return;
        //     switch(arr[i][j]) {
        //     case 'M':
        //         res[i][j] = 'X';
        //         break;
        //     case 'E':
        //         res[i][j] = 'B'; // 1-8
        //         break;
        //     case '1':
        //     case '2':
        //     case '3':
        //     case '4':
        //     case '5':
        //     case '6':
        //     case '7':
        //     case '8':
        //         res[i][j] = arr[i][j];
        //         break;
        //     default: 
        //         res[i][j] = arr[i][j];
        //         break;
        //     }
        //     if (arr[i][j] == 'E') {
        //         res[i][j] = "B";
        //         for (int x = i-1; x <= i+1; x++) {
        //             for (int y = j-1; y <= j+1; y++) {
        //                 if (x == i && y == j) continue;
        //                 dfs(arr, x, y);
        //             }
        //         }
        //     } else if (arr[i][j] >= '1' && arr[i][j] <= '8') {
        //         int cnt = 0;
        //         for (int x = i-1; x <= i+1; x++) {
        //             for (int y = j-1; y <= j+1; y++) {
        //                 if (x < 0 || y < 0 || (x == i && y == j)) continue;
        //                 if (arr[x][y] == 'X') ++cnt;
        //             }
        //         }
        //         if (cnt == arr[i][j] - '0') {
        //             for (int x = i-1; x <= i+1; x++) {
        //                 for (int y = j-1; y <= j+1; y++) {
        //                     if (x < 0 || y < 0 || (x == i && y == j)) continue;
        //                     if (arr[x][y] == 'E') res[x][y] = 'B';
        //                 }
        //             }
        //         }
        //     }
        // }
        // public char[][] updateBoard(char[][] board, int[] click) {
        //     m = board.length;
        //     n = board[0].length;
        //     res = new char [m][n];
        //     // for (int i = 0; i < m; i++) {
        //     //     for (int j = 0; j < n; j++) {
        //     //         if (board[i][j] == 'B') res[i][j] = 'B';
        //     //         else if (board[i][j] == 'M') res[i][j] = 'M';
        //     //         else if (board[i][j] == 'E') res[i][j] = 'E';
        //     //         else if (board[i][j] >= '1' && board[i][j] <= '8') res[i][j] = board[i][j];
        //     //     }
        //     // }
        //     dfs(board, click[0], click[1]);
        //     return arr;
        // }


        // int m, n;
        // boolean [][] vis;
        // private void dfs(int [][] arr, int i, int j) {
        //     if (i >= 1 && arr[i-1][j] == 1 && !vis[i-1][j]) {
        //         vis[i-1][j] = true;
        //         dfs(arr, i-1, j);
        //     }
        //     if (i < m-1 && arr[i+1][j] == 1 && !vis[i+1][j]) {
        //         vis[i+1][j] = true;
        //         dfs(arr, i+1, j);
        //     }
        //     if (j >= 1 && arr[i][j-1] == 1 && !vis[i][j-1]) {
        //         vis[i][j-1] = true;
        //         dfs(arr, i, j-1);
        //     }
        //     if (j < n-1 && arr[i][j+1] == 1 && !vis[i][j+1]) {
        //         vis[i][j+1] = true;
        //         dfs(arr, i, j+1);
        //     }
        // }
        // public int numEnclaves(int[][] grid) {
        //     m = grid.length;
        //     n = grid[0].length;
        //     vis = new boolean[m][n];
        //     for (int i = 0; i < m; i++) {
        //         for (int j = 0; j < n; j++) {
        //             if ((i == 0 || i == m-1 || j == 0 || j == n-1) && grid[i][j] == 1 && vis[i][j] == false) {
        //                 vis[i][j] = true;
        //                 dfs(grid, i, j);
        //             }
        //         }
        //     }
        //     int cnt = 0;
        //     for (int i = 1; i < m-1; i++) {
        //         for (int j = 1; j < n-1; j++) {
        //             if (grid[i][j]== 1 && !vis[i][j]) ++cnt;
        //         }
        //     }
        //     return cnt;
        // }

        // HashMap<Integer, List<Integer>> m = new HashMap<>();
        // HashSet<Integer> s = new HashSet<>();
        // boolean [] vis;
        // private void dfs(int i) {
        //     // if (!m.containsKey(i) ||  m.get(i).size() == 0) return;
        //     if (m.get(i).size() == 1 && vis[m.get(i).get(0)]) return;
        //     for (int j = 0; j < m.get(i).size(); j++) {
        //         if (vis[m.get(i).get(j)]) continue;
        //         vis[m.get(i).get(j)] = true;
        //         s.add(m.get(i).get(j));
        //         dfs(m.get(i).get(j));
        //     }
        // }
        // public int makeConnected(int n, int[][] connections) {
        //     if (n == 1) return 0;
        //     if (connections.length < n-1) return -1;
        //     m = new HashMap<>();
        //     List<Integer> l = new ArrayList<>();
        //     for (int i = 0; i < connections.length; i++) {
        //         l = new ArrayList<>();
        //         m.put(i, l);
        //     }
        //     for (int i = 0; i < connections.length; i++) {
        //         m.get(connections[i][0]).add(connections[i][1]);
        //         m.get(connections[i][1]).add(connections[i][0]);
        //     }
        //     // System.out.println("");
        //     // System.out.println("m.size(): " + m.size());
        //     // for (Map.Entry<Integer, List<Integer>> entry : m.entrySet()) 
        //     // System.out.print(entry.getKey() + ", " + entry.getValue() + "\n");
        //     // System.out.println("");
        //     s = new HashSet<>();
        //     vis = new boolean[n];
        //     int cnt = 1;
        //     vis[0] = true;
        //     s.add(0);
        //     dfs(0);
        //     if (s.size() == n) return 0;
        //     for (Integer key : m.keySet()) {
        //         if (!s.contains(key)) {
        //             dfs(key);
        //             ++cnt;
        //         }
        //     }
        //     return cnt;
        // }
        // int [][] a = new int [][] {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}}; 
        // int [][] a = new int [][] {{0,1},{0,2},{0,3},{1,2},{1,3}};
        // int [][] a = new int [][] {{0,1},{0,2},{3,4},{2,3}}; 
        // int [][] a = new int [][] {{1,5},{1,7},{1,2},{1,4},{3,7},{4,7},{3,5},{0,6},{0,1},{0,4},{2,6},{0,3},{0,2}}; 


        // private int sum;
        // public void robRecursive(TreeNode r, boolean vis) {
        //     if (r == null) return;
        //     if (vis) sum += r.val;
        //     if (r.left != null) robRecursive(r.left, !vis);
        //     if (r.right != null) robRecursive(r.right, !vis);
        // }
        // public int rob(TreeNode root) {
        //     if (root.left == null && root.right == null) return root.val;
        //     int res = 0;
        //     sum = 0;
        //     robRecursive(root, true);
        //     res = sum;
        //     sum = 0;
        //     robRecursive(root, false);
        //     res = Math.max(res, sum);
        //     return res;
        // }
        // int [] a = new int [] {4, 1, -1, 2, -1, 3}; 

        
        // HashMap<Integer, List<Integer>> m = new HashMap<>();
        // HashSet<Integer> s = new HashSet<>();
        // List<Integer> res;
        // public void dfs(int [] vis, int i, List<Integer> p) {
        //      // System.out.println("\ni: " + i);
        //      // System.out.println("");
        //      // System.out.println("p.size(): " + p.size());
        //      // for (int z = 0; z < p.size(); ++z) 
        //      // System.out.print(p.get(z) + ", ");
        //      // System.out.print("\n");
        //     if (m.get(i).size() == 0) {
        //         for (int j = 0; j < p.size(); j++) {
        //             if (!s.contains(p.get(j)) && !res.contains(p.get(j))) {
        //                 res.add(p.get(j));  
        //             }
        //         }
        //          // System.out.println("");
        //          // System.out.println("res.size(): " + res.size());
        //          // for (int z = 0; z < res.size(); ++z) 
        //          // System.out.print(res.get(z) + ", ");
        //          // System.out.print("\n");
        //         return;
        //     }
        //     for (int j = 0; j < m.get(i).size(); j++) {
        //         // System.out.println("m.get(i).get(j): " + m.get(i).get(j));
        //          // System.out.println("(vis[m.get(i).get(j)] == -1): " + (vis[m.get(i).get(j)] == -1));
        //         if (vis[m.get(i).get(j)] == -1) {
        //              // System.out.println("");
        //              // System.out.println("p.size(): " + p.size());
        //              // for (int z = 0; z < p.size(); ++z) 
        //              // System.out.print(p.get(z) + ", ");
        //              // System.out.print("\n");
        //             for (int x = 0; x < p.size(); x++) {
        //                 s.add(p.get(x));
        //                 if (res.contains(p.get(x))) res.remove(new Integer(p.get(x)));
        //             }
        //              // for (Integer val : s) {
        //              //     System.out.print(val + ", ");
        //              // }
        //              // System.out.println("");
        //              // System.out.println("res.size(): " + res.size());
        //              // for (int z = 0; z < res.size(); ++z) 
        //              // System.out.print(res.get(z) + ", ");
        //              // System.out.print("\n");
        //             continue;
        //         }
        //         // System.out.println("(m.get(i).get(j) == i): " + (m.get(i).get(j) == i));
        //         if (m.get(i).get(j) == i) {
        //             // System.out.println("");
        //             // System.out.println("p.size(): " + p.size());
        //             // for (int z = 0; z < p.size(); ++z) 
        //             // System.out.print(p.get(z) + ", ");
        //             // System.out.print("\n");
        //             for (int o = 0; o < p.size(); o++) {
        //                 s.add(p.get(o));
        //                 if (res.contains(p.get(o))) res.remove(new Integer(p.get(o)));
        //             }
        //             continue;
        //         }
        //         // if (vis[m.get(i).get(j)] != -1 && !s.contains(m.get(i).get(j))) {
        //         if (vis[m.get(i).get(j)] != -1) {
        //             vis[m.get(i).get(j)] = -1;
        //             p.add(0, m.get(i).get(j));
        //             dfs(vis, m.get(i).get(j), p);
        //             p.remove(0);
        //             vis[m.get(i).get(j)] = 1;
        //         }
        //     }
        // }
        

        // public List<Integer> eventualSafeNodes(int[][] graph) {
        //     int n = graph.length;
        //     List<Integer> l = new ArrayList<>();
        //     res = new ArrayList<>();
        //     for (int i = 0; i < n; i++) {
        //         l = Arrays.stream(graph[i]).boxed().collect(Collectors.toList());
        //         m.put(i, l);
        //     }
        //      // System.out.println("");
        //      // System.out.println("m.size(): " + m.size());
        //      // for (Map.Entry<Integer, List<Integer>> entry : m.entrySet()) 
        //      // System.out.print(entry.getKey() + ", " + entry.getValue() + "\n");
        //      // System.out.println("");
        //     int [] vis = new int[n];
        //     List<Integer> p = new ArrayList<>();
        //     for (Integer key : m.keySet()) {
        //         if (!s.contains(key)) {
        //             p = new ArrayList<>();
        //             p.add(key);
        //             vis[key] = -1;
        //             dfs(vis, key, p);
        //             vis[key] = 1;
        //         }
        //     }
        //      for (Integer val : s) {
        //          System.out.print(val + ", ");
        //      }
        //     Collections.sort(res);
        //     return res;
        // }

        // int n;
        // int [] vis;
        // boolean res;
        // public void canReachRecursive(int[] arr, int i, int ori, boolean stt) {
        //     if (i < 0 || i >= n) return;
        //     if (arr[i] == 0) {
        //         res = true;
        //         return;
        //     }
        //     if (i == ori && stt) return;
        //     stt = true;
        //     if (i - arr[i] >= 0) {
        //         if (arr[i-arr[i]] == 0) {
        //             res = true;
        //             return;
        //         }
        //     }
        //     if (i + arr[i] < n) {
        //         if (arr[i+arr[i]] == 0) {
        //             res = true;
        //             return;
        //         }
        //     }
        //     if (i-arr[i] >= 0 && vis[i-arr[i]] == 0) {
        //         vis[i-arr[i]] = -1;
        //         canReachRecursive(arr, i - arr[i], ori, stt);
        //     }
        //     if (i+arr[i] < n && vis[i+arr[i]] == 0) {
        //         vis[i+arr[i]] = -1;
        //         canReachRecursive(arr, i + arr[i], ori, stt);
        //     }
        // }
        // public boolean canReach(int[] arr, int start) {
        //     n = arr.length;
        //     vis = new int[n];
        //     vis[start] = -1;
        //     res = false;
        //     canReachRecursive(arr, start, start, false);
        //     return res;
        // }


        // public List<Integer> lexicalOrder(int n) {
        //     List<Integer> l = new ArrayList<>();
        //     for (int i = 1; i <= n; i++) 
        //         l.add(i);
        //     Collections.sort(l, new Comparator<Integer>() {
        //             public int compare( Integer x, Integer y ) {
        //                 int a = (int)x;
        //                 int b = (int)y;
        //                 while (a > 2) a >>= 1;
        //                 while (b > 2) b >>= 1;
        //                 int c = (int)x;
        //                 int d = (int)y;
        //                 while (c > 4) c >>= 1;
        //                 while (d > 4) d >>= 1;
        //                 if (a != b) return a - b;
        //                 else return c - d;
        //             }
        //         });
        //     System.out.println("l.size(): " + l.size());
        //     for (int z = 0; z < l.size(); ++z) 
        //         System.out.print(l.get(z) + ", ");
        //     System.out.print("\n");
        //     return l;
        // }

        // public int arrayNesting(int[] nums) {
        //     int n = nums.length;
        //     if (n == 1) return 1;
        //     boolean [] vis  = new boolean [n];
        //     int tmp = 0;
        //     HashSet<Integer> s = new HashSet<>();
        //     int max = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (!vis[i]) {
        //             vis[i] = true;
        //             s.clear();
        //             s.add(nums[i]);
        //             tmp = nums[i];
        //             while (tmp < n && !s.contains(nums[tmp])) {
        //                 s.add(nums[tmp]);
        //                 vis[nums[tmp]] = true;
        //                 tmp = nums[tmp];
        //             }
        //             if (s.size() > max) max = s.size();
        //         } 
        //     }
        //     return max;
        // }

        // public int flipLights(int n, int presses) {
        //     if (presses == 0) return 1;
        //     List<Integer> ori = new ArrayList<>();
        //     List<Integer> l = new ArrayList<>();
        //     List<List<Integer>> ll = new ArrayList<>();
        //     for (int i = 0; i < n+1; i++) 
        //         ori.add(1);

        //     if (presses % 2 == 0 && !ll.contains(l)) ll.add(new ArrayList<>(ori));
        //     else if (presses % 2 == 1) {
        //         l = new ArrayList<>(ori);
        //         for (int i = 1; i < n+1; i++) 
        //             l.set(i, 0);
        //         if (!ll.contains(l)) ll.add(new ArrayList<>(l));
        //         l = new ArrayList<>(ori);
        //         for (int i = 1; i < n+1; i++)
        //             if (i % 2 == 0)
        //                 l.set(i, 0);
        //         if (!ll.contains(l)) ll.add(new ArrayList<>(l));
        //         l = new ArrayList<>(ori);
        //         for (int i = 1; i < n+1; i++) 
        //             if (i % 2 == 1)
        //                 l.set(i, 0);
        //         if (!ll.contains(l)) ll.add(new ArrayList<>(l));
        //         l = new ArrayList<>(ori);
        //         for (int i = 1; i < n+1; i++)
        //             for (int j = 0; j <= n/3; j++) 
        //                 if (i == 3 * j + 1)
        //                     l.set(i, 0);
        //         if (!ll.contains(l)) ll.add(new ArrayList<>(l));
        //     }
        //     // System.out.println("ll.size(): " + ll.size());
        //     // for (int z = 0; z < ll.size(); ++z) {
        //     //     for (int q = 0; q < ll.get(z).size(); q++) 
        //     //         System.out.print(ll.get(z).get(q) + ", ");
        //     //     System.out.print("\n ");
        //     // }
        //     return ll.size();
        // }

        
        // private HashMap<Integer, List<Integer>> m;
        // private int [] res;
        // private void dfsFromRoot(int [] vis, int i, int [][] arr) {
        //     if (m.get(i).size() == 1 && vis[m.get(i).get(0)] == -1) {
        //         if (res == null)
        //             res = new int [] {i, m.get(i).get(0)};
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
        //                         res = arr[j];
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


        // boolean[][] p;
        // boolean[][] a;
        // boolean[][] vis;
        // int  m, n;
        // public void dfs(int [][] arr, int i, int j, boolean [][] v, boolean mp) {
        //     if (i < 0 || i >= m || j < 0 || j >= n || vis[i][j]) return;
        //     vis[i][j] = true;
        //     if ((i == 0 || j == 0) && mp) v[i][j] = true;
        //     if ((i == m-1 || j == n-1) && !mp) v[i][j] = true;
        //     if(i > 0 && arr[i][j] <= arr[i-1][j]) {
        //         v[i-1][j] = true;
        //         dfs(arr, i-1, j, v, mp);
        //     }
        //     if(j > 0 && arr[i][j] <= arr[i][j-1]) {
        //         v[i][j-1] = true;
        //         dfs(arr, i, j-1, v, mp);                    
        //     }
        //     if(i < arr.length-1 && arr[i][j] <= arr[i+1][j]) {
        //         v[i+1][j] = true;
        //         dfs(arr, i+1, j, v, mp);            
        //     }
        //     if(j < n-1 && arr[i][j] <= arr[i][j+1]) {
        //         v[i][j+1] = true;
        //         dfs(arr, i, j+1, v, mp);
        //     }
        // }
        // public List<List<Integer>> pacificAtlantic(int[][] heights) {
        //     List<List<Integer>> ll = new ArrayList<>();
        //     List<Integer> l = new ArrayList<>();
        //     m = heights.length;
        //     n = heights[0].length;
        //     if (m == 1 && n == 1) {
        //         l = new ArrayList<>();
        //         l.add(0);
        //         l.add(0);
        //         ll.add(l);
        //         return ll;
        //     }
        //     p = new boolean[m][n]; // pacific
        //     a = new boolean[m][n]; // attlantic
        //     vis = new boolean[m][n];
        //     for(int i = 0; i < n; ++i)
        //         dfs(heights, 0, i, p, true);            
        //     for(int i = 0; i < m; ++i) 
        //         dfs(heights, i, 0, p, true);            
        //     vis = new boolean[m][n];
        //     for(int i = 0; i < n; ++i) 
        //         dfs(heights, m-1, i, a, false);            
        //     for(int i = 0; i < m; ++i) 
        //         dfs(heights, i, n-1, a, false);                        
        //     for(int i = 0; i < m;++i) {
        //         for(int j = 0; j < n; ++j) {
        //             if(p[i][j] && a[i][j]) {
        //                 l = new ArrayList<>();
        //                 l.add(i);
        //                 l.add(j);
        //                 ll.add(l);
        //             }
        //         }
        //     }
        //     return ll;
        // }

       //  private boolean isMultiIsland(int [][] arr) {
       //      Set<Integer> s = new HashSet<>();
       //      for (int i = 0; i < m; i++) {
       //          for (int j = 0; j < n; j++) {
       //              if (!s.contains(arr[i][j])) {
       //                  s.add(arr[i][j]);
       //                  if (s.size() == 3) return true;
       //              }
       //          }
       //      }
       //      return false;
       //  }
       //  private void recover(int [][] arr) {
       //      for (int i = 0; i < m; i++) 
       //          for (int j = 0; j < n; j++) 
       //              if (arr[i][j] == 2) arr[i][j] = 1;
       //  }
       //  private void dfs (int [][] arr, int i, int j) {
       //      if (i < 0 || i >= m || j < 0 || j>= n || arr[i][j] != 1) return;
       //      arr[i][j] = 2;
       //      for (int [] d : dirs) 
       //          dfs(arr, i+d[0], j+d[1]);
       //  }
       //  int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
       //  int m, n;
       //  private boolean isMultiIslandControl(int [][] arr) {
       //      for (int i = 0; i < m; i++) {
       //          for (int j = 0; j < n; j++) {
       //              if (arr[i][j] == 1) {
       //                  dfs(arr, i, j);
       //                  return isMultiIsland(arr);
       //              }
       //          }
       //      }
       //      hasOne = false;
       //      return false;
       //  }
       // boolean hasOne = true;
       //  public int minDays(int[][] grid) {
       //      m = grid.length;
       //      n = grid[0].length;
       //      if (isMultiIslandControl(grid)) return 0;
       //      recover(grid);
       //      hasOne = true;
       //      for (int i = 0; i < m; i++) {
       //          for (int j = 0; j < n; j++) {
       //              if (grid[i][j] == 1) {
       //                  grid[i][j] = 0;
       //                  if (isMultiIslandControl(grid) || !hasOne) return 1;
       //                  recover(grid);
       //                  grid[i][j] = 1;
       //              }
       //          }
       //      }
       //      return 2;
       //  }

        
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();

        // int [][] a = new int [][] {{1,1},{1,0}};
        // int [][] a = new int [][] {{0,1,1,0},{0,1,1,0},{0,0,0,0}};
        // int [][] a = new int [][] {{1,1,0,1,1},{1,1,1,1,1},{1,1,0,1,1},{1,1,0,1,1}};
        int [][] a = new int [][] {{0,0,0},{0,1,0},{0,0,0}};
        

        System.out.println("a.length: " + a.length);
        for (int z = 0; z < a.length; ++z) {
            for (int w = 0; w < a[z].length; w++) 
                System.out.print(a[z][w] + ", ");
            System.out.print("\n");
        }
        

        int res = s.minDays(a);
        System.out.println("res: " + res);
    }
}
