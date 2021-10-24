import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Stream.generate;

import static java.util.stream.Collectors.toMap;

public class depthtwoFirstSearch {
    public static class Solution {

        // private static void printArray (int [][] arr) {
        //     System.out.println("");
        //     System.out.println("arr.length: " + arr.length);
        //     for (int x = 0; x < arr.length; ++x) {
        //         for (int j = 0; j < arr[x].length; j++) {
        //             if (j % 5 == 4)
        //                 System.out.print(", ");
        //             if (arr[x][j] == 1)
        //                 System.out.print(" \\ ");
        //             else if (arr[x][j] == -1)
        //                 System.out.print( " / ");
        //             else 
        //                 System.out.print(" " + arr[x][j]+ " ");
        //         }
        //         System.out.print("\n");
        //     }
        //     System.out.println("");
        // }
        // boolean [][] vis;
        // int [] res;
        // int m, n;
        // public void dfs(int[][] arr, int i, int j, int pi, int pj, int oj) {
        //     if (vis[i][j]) return;
        //     if (i == m-1) {
        //         if (i == pi && (j == pj+1 || j == pj-1)) {
        //             res[oj] = j;
        //             return;
        //         }
        //         if (j < n-1 && arr[i][j] == arr[i][j+1] && arr[i][j] == 1) dfs(arr, i, j+1, i, j, oj);
        //         else if (j > 0 && arr[i][j] == arr[i][j-1] && arr[i][j] == -1) dfs(arr, i, j-1, i, j, oj);
        //     }
        //     vis[i][j] = true;
        //     if (i == pi && j == pj) {
        //         if (j < n-1 && arr[i][j] == arr[i][j+1] && arr[i][j] == 1) dfs(arr, i, j+1, i, j, oj);
        //         else if (j > 0 && arr[i][j] == arr[i][j-1] && arr[i][j] == -1) dfs(arr, i, j-1, i, j, oj);
        //         vis[i][j] = false;
        //         return;
        //     }
        //     if (i == pi && j != pj) { // j = pj -/+ 1
        //         dfs(arr, i+1, j, i, j, oj);
        //         vis[i][j] = false;
        //         return;
        //     }
        //     if (i == pi+1) {
        //         if (j < n-1 && arr[i][j] == arr[i][j+1] && arr[i][j] == 1) dfs(arr, i, j+1, i, j, oj);
        //         else if (j > 0 && arr[i][j] == arr[i][j-1] && arr[i][j] == -1) dfs(arr, i, j-1, i, j, oj);
        //     }
        //     vis[i][j] = false;
        // }
        // public int[] findBall(int[][] grid) {
        //     m = grid.length;
        //     n = grid[0].length;
        //     res = new int[n];
        //     Arrays.fill(res, -1);
        //     if (m == 1) {
        //         for (int j = 0; j < n; j++) {
        //             if (j <= n-1 && grid[0][j] == 1 && (j == n-1 || grid[0][j+1] == -1)) continue;
        //             if (j >= 0 && grid[0][j] == -1 && (j == 0 || grid[0][j-1] == 1)) continue;
        //             if (j < n-1 && grid[0][j] == grid[0][j+1] && grid[0][j] == 1) res[j] = j+1;
        //             else if (j > 0 && grid[0][j] == grid[0][j-1] && grid[0][j] == -1) res[j] = j-1;
        //         }
        //         return res;
        //     }
        //     vis = new boolean[m][n];
        //     for (int j = 0; j < n; j++) 
        //         dfs(grid, 0, j, 0, j, j);
        //     return res;
        // }


        // int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // boolean [][] vis;
        // private boolean dfs(int [][] arr, int i, int j, int r, int c) {
        //     if (i < 0 || i >= r || j < 0 || j >= c || vis[i][j] || arr[i][j] == 1) return false;
        //     if (i == r-1) return true;
        //     vis[i][j] = true;
        //     for (int [] dir : dirs) {
        //         if (dfs(arr, i+dir[0], j+dir[1], r, c)) return true;
        //     }
        //     return false;
        // }
        // private boolean helperOrganizer(int [][] arr, int x, int r, int c) {
        //     System.out.println("x: " + x);
        //     int [][] g = new int [r][c];
        //     for (int j = 0; j < x; j++) // 这里有个反复填写的问题要优化
        //         g[arr[j][0]-1][arr[j][1]-1] = 1;
        //     int i = 0;
        //     for ( i = 0; i < c; i++) 
        //         if (g[0][i] != 1) break;
        //     if (i == c) return false;
        //     for ( i = 0; i < r; i++) 
        //         Arrays.fill(vis[i], false);
        //     for ( i = 0; i < c; i++) {
        //         if (g[0][i] != 1) {
        //             if (dfs(g, 0, i, r, c)) return true;
        //         }
        //     }
        //     return false;
        // }
        // private int binarySearch(int [][] arr, int l, int h, int r, int c) {
        //     if (l == h) {
        //         return l;
        //     } else if (l == h-1) {
        //         if (helperOrganizer(arr, h, r, c)) return h;
        //         return l;
        //     }
        //     int m = l + (h-l)/2;
        //     if (!helperOrganizer(arr, m, r, c))
        //         return binarySearch(arr, l, m-1, r, c);
        //     else
        //         return binarySearch(arr, m, h, r, c);
        // }
        // public int latestDayToCross(int row, int col, int[][] cells) {
        //     vis = new boolean[row][col];
        //     return binarySearch(cells, 0, cells.length-1, row, col);
        // }

        
        // 这个题目参考别人的，改天自己再写一下 
        // private List<Integer> topSort(int [] ins, List<List<Integer>> graph, List<Integer> items) {
        //     Queue<Integer> q = new LinkedList<>();
        //     for (int item : items) 
        //         if (ins[item] == 0) q.offer(item);
        //     List<Integer> res = new ArrayList<>();
        //     int cur = 0;
        //     while (!q.isEmpty()) {
        //         cur = q.poll();
        //         res.add(cur);
        //         for (Integer v : graph.get(cur)) 
        //             if (--ins[v] == 0) q.offer(v);
        //     }
        //     return res;
        // }
        // public int [] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        //     // 组间组内信赖图
        //     List<List<Integer>> groupItem = new ArrayList<>();
        //     List<List<Integer>> groupGraph = new ArrayList<>();
        //     List<Integer> id = new ArrayList<>();        // m+n .....
        //     for (int i = 0; i < m+n; i++) {
        //         id.add(i);
        //         groupItem.add(new ArrayList<Integer>()); // m+n
        //         groupGraph.add(new ArrayList<Integer>());// m+n
        //     }
        //     List<List<Integer>> itemGraph = new ArrayList<>();
        //     for (int i = 0; i < n; i++)                // n items only
        //         itemGraph.add(new ArrayList<Integer>());
        //     int [] insGroup = new int[n+m];     // 组间组内依敕入度级数
        //     int [] insItem = new int[n];
        //     int leftoverId = m;                 // reassign -1 groupped items to be groupped from [m, m+1, m+n)
        //     for (int i = 0; i < n; i++) {
        //         if (group[i] == -1)
        //             group[i] = leftoverId++;    // update group[] data
        //         groupItem.get(group[i]).add(i); // leftoverId i befores to new assigned group[i]
        //     }
        //     for (int i = 0; i < n; i++) {
        //         int curGroupId = group[i];
        //         for (int item : beforeItems.get(i)) {
        //             int befGroupId = group[item];   // ids bef item i belong to which group ?
        //             if (befGroupId == curGroupId) { // 属于同一个组，进行组内排序
        //                 insItem[i] ++;
        //                 itemGraph.get(item).add(i);
        //             } else { // 不属于同一个组：构建组间依赖关系
        //                 if (groupGraph.get(curGroupId).contains(befGroupId)) return new int [0]; // 4 1  {-1, 0, 0, -1}; {{},{0},{1,3},{2}};
        //                 insGroup[curGroupId]++;
        //                 groupGraph.get(befGroupId).add(curGroupId); // group befGroupId goes before group curGroupId
        //             }
        //         }
        //     }
        //     List<Integer> groupTopSort = topSort(insGroup, groupGraph, id);
        //     if (groupTopSort.size() == 0) return new int [0];
        //     int [] ans = new int[n];
        //     int idx = 0;
        //     for (int curGroupId : groupTopSort) {
        //         int size = groupItem.get(curGroupId).size();
        //         if (size == 0) continue;
        //         List<Integer> res = topSort(insItem, itemGraph, groupItem.get(curGroupId));
        //         if (res.size() == 0) return new int [0];
        //         for (int item : res) {
        //             ans[idx++] = item;
        //         }
        //     }
        //     return ans;
        // }



        // private void dfs(int [][] arr, int i, int j, int v) {
        //     if (i < 0 || i >= n || j < 0 || j >= n || arr[i][j] != 1) return;
        //     arr[i][j] = v;
        //     for (int [] d : dirs) 
        //         dfs(arr, i+d[0], j+d[1], v);
        // }
        // int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // int [] dp;
        // int n;
        // public int largestIsland(int[][] grid) {
        //     n = grid.length;
        //     dp = new int [n*n];
        //     int idx = 2;
        //     int cnt = 0;
        //     int max = 0, tmp = 0;
        //     Set<Integer> s = new HashSet<>(); // neighbours of each grid
        //     Set<Integer> sv = new HashSet<>(); // group marks
        //     for (int i = 0; i < n; i++) {
        //         for (int j = 0; j < n; j++) {
        //             if (grid[i][j] == 1) {
        //                 dfs(grid, i, j, idx);
        //                 cnt = 0;
        //                 for (int x = 0; x < n; x++) 
        //                     for (int y = 0; y < n; y++) 
        //                         if (grid[x][y] == idx) ++cnt;
        //                 dp[idx-2] = cnt;
        //                 ++idx;
        //             }
        //         }
        //     }
        //     if (idx == 3 && dp[0] == n*n) return n*n;
        //     else if (idx == 2 && dp[0] == 0) return 1;
        //     Set<Integer> sp = new HashSet<>(); // collect necessary 0 poss
        //     for (int i = 0; i < n; i++) {
        //         for (int j = 0; j < n; j++) {
        //             if (grid[i][j] != 0) {
        //                 for (int [] d : dirs) 
        //                     if (i+d[0] >= 0 && i+d[0] < n && j+d[1] >= 0 && j+d[1] < n && grid[i+d[0]][j+d[1]] == 0)
        //                         sp.add((i+d[0])*n+j+d[1]);
        //             }
        //         }
        //     }
        //     int i = 0, j = 0;
        //     for (Integer va : sp) {
        //         i = va / n;
        //         j = va % n;
        //         cnt = 0;
        //         s.clear();
        //         sv.clear();
        //         for (int [] d : dirs) 
        //             if (i+d[0] >= 0 && i+d[0] < n && j+d[1] >= 0 && j+d[1] < n
        //                 && grid[i+d[0]][j+d[1]] != 0 && !sv.contains(grid[i+d[0]][j+d[1]])) {
        //                 s.add((i+d[0])*n+j+d[1]);
        //                 sv.add(grid[i+d[0]][j+d[1]]);
        //                 ++cnt;
        //             }
        //         tmp = 0;
        //         for (Integer v : s) 
        //             tmp += dp[grid[v/n][v%n]-2];
        //         max = Math.max(max, tmp+1);
        //     }
        //     return max;
        // }
        // 这种方法更慢，最后交了一个python的方法，改天再复习一下这道题目
        // private int dfs(int [][] arr, int i, int j, boolean [][] vis) { 
        //     if (i < 0 || i >= n || j < 0 || j >= n || arr[i][j] != 1 || vis[i][j]) return 0;
        //     vis[i][j] = true;
        //     return 1 + dfs(arr, i+1, j, vis) + dfs(arr, i-1, j, vis) + dfs(arr, i, j-1, vis) + dfs(arr, i, j+1, vis);
        // }
        // int n;
        // public int largestIsland(int[][] grid) {
        //     n = grid.length;
        //     int res = 0;
        //     boolean hasZero = false;
        //     boolean [][] vis = new boolean[n][n];
        //     for (int i = 0; i < n; i++) {
        //         for (int j = 0; j < n; j++) {
        //             if (grid[i][j] == 1) continue;
        //             grid[i][j] = 1;
        //             for (int k = 0; k < n; k++)
        //                 Arrays.fill(vis[k], false);
        //             res = Math.max(res, dfs(grid, i, j, vis));
        //             grid[i][j] = 0;
        //             hasZero = true;
        //         }
        //     }
        //     return hasZero ? res : n*n;
        // } 

        
        // int N;
        // Set<List<String>> ssg = new HashSet<>();
        // String res;
        // int min = Integer.MAX_VALUE;
        // boolean [] vis;
        // private void dfs(int n, int k, StringBuilder s, StringBuilder cur, List<String> ss) {
        //     if (cur.length() == n) {
        //         ss.add(cur.toString());
        //         if (ss.size () == N) {
        //             if (s.length() < min) min = s.length();
        //             ssg.add(new ArrayList<>(ss));
        //             return;
        //         }
        //     }
        //     for (int i = 0; i < N; i++) {
        //         char c = (char)(i%k + '0');
        //         char z = ' ';
        //         if (!vis[i]) {
        //             vis[i] = true;
        //             StringBuilder cc = new StringBuilder(cur);
        //             cc.append(c);
        //             if (cc.length() > n) {
        //                 z = cc.charAt(0);
        //                 cc.deleteCharAt(0);
        //             }
        //             s.append(c);
        //             dfs(n, k, s, cc, ss);
        //             s.deleteCharAt(s.length()-1);
        //             vis[i] = false;
        //         }
        //     }
        // }
        // public String crackSafe(int n, int k) {
        //     N = (int)Math.pow(n, k);
        //     res = null;
        //     vis = new boolean[N];
        //     dfs(n, k, new StringBuilder(), new StringBuilder (), new ArrayList<String>());
        //     return res;
        // }

        // private boolean dfs(Set<String> ss, int n, int k) {
        //     if (ss.size() == N) return true;
        //     String pre = s.substring(s.length()-(n-1));
        //     for (int i = 0; i < k; i++) {
        //         String next = pre + i;
        //         if (ss.contains(next)) continue;
        //         s.append(i+"");
        //         ss.add(next);
        //         if (dfs(ss, n, k)) return true;
        //         s.deleteCharAt(s.length()-1);
        //         ss.remove(next);
        //     }
        //     return false;
        // }
        // StringBuilder s;
        // int N;
        // public String crackSafe(int n, int k) {
        //     N = (int)Math.pow(k, n);
        //     s = new StringBuilder("0".repeat(n));
        //     Set<String> ss = new HashSet<>();
        //     ss.add(s.toString());
        //     dfs(ss, n, k);
        //     return s.toString();
        // }


        // private boolean bfs(Set<String> visited,Set<String> blockedSet, 
        //                     int[] source, String target,int blockSize){
        //     Queue<int[]> q = new LinkedList<>(); // 建立bfs用的Queue
        //     q.offer(source); // 将起始节点加入Queue
        //     while(q.size()>0){ // 如果Queue的size大于0，保持循环。
        //         int[] point =q.poll(); // 从Queue中取出一个节点元素
        //         for(int[]direction : directions){ // 将此节点向四周扩散
        //             // 得到扩散后的节点
        //             int row = point[0]+direction[0], col=point[1]+direction[1];
        //             String key=row+"_"+col; // 利用坐标生成一个key
        //             // 如果该节点没有越界，并且不是block，并且没被访问过
        //             if(row>=0 && col>=0 && row <1000000 && col<1000000
        //                && !blockedSet.contains(key) && !visited.contains(key)){
        //                 // 如果该节点即是target，说明找到联通路径，返回true。
        //                 if(key.equals(target)){
        //                     return true;
        //                 }
        //                 // 将该节点的key加入已访问列表
        //                 visited.add(key);
        //                 // 将该节点加入bfs的Queue
        //                 q.offer(new int[]{row, col});
        //                 // 如果当前Queue中的数量大于blockSize，说明block无法封锁source节点
        //                 if(q.size() >= blockSize){
        //                     // 返回true。
        //                     return true;
        //                 }
        //             }
        //         }
        //     }
        //     return false;
        // }
        // int[][] directions={{1,0},{0,1},{-1,0},{0,-1}}; // 定义bfs四个方向
        // public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        //     int blockSize = blocked.length;           // blocked数量
        //     Set<String> blockedSet = new HashSet<>(); // 将blocked转化为set
        //     for(int[] b : blocked) {
        //         blockedSet.add(b[0]+"_"+b[1]);
        //     }
        //     Set<String> visited = new HashSet<>(); // 记录已访问节点
        //     visited.add(source[0]+"_"+source[1]); // 将source加入已访问节点
        //     // 以source为起点开始bfs
        //     boolean res1 = bfs(visited,blockedSet, source, target[0]+"_"+target[1], blockSize);
        //     if(!res1){ // 如果source被封锁，直接返回false
        //         return false;
        //     }
        //     visited.clear(); // 清空已访问列表
        //     visited.add(target[0]+"_"+target[1]); // 将target加入已访问列表
        //     // 以target为起点开始bfs
        //     boolean res2 = bfs(visited,blockedSet, target, source[0]+"_"+source[1], blockSize);
        //     return res2;
        // }
        // private boolean bfsUnblockable(Set<String> sb, Set<String> ss, int [] source, String target) {
        //     Queue<int []> q = new LinkedList<>();
        //     q.add(source);
        //     int [] cur = null;
        //     int i = 0, j = 0;
        //     while (!q.isEmpty()) {
        //         cur = q.poll();
        //         for (int [] d : dirs) {
        //             i = cur[0] + d[0];
        //             j = cur[1] + d[1];
        //             if (i >= 0 && i < N && j >= 0 && j < N
        //                 && !sb.contains((i + "_" + j))
        //                 && !ss.contains((i + "_" + j))) {
        //                 if (target.equals(i + "_" + j))
        //                     return true;
        //                 q.add(new int [] {i, j});
        //                 ss.add(i + "_" + j);
        //             }
        //         }
        //         if (q.size() > n) return true;
        //     }
        //     return false;
        // }
        // int [][] dirs =  {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // boolean [][] vis;
        // int N = 1000000;
        // int n;
        // public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        //     n = blocked.length;
        //     if (n == 0) return true;
        //     Set<String> sb = new HashSet<>(); // visited
        //     for (int[] arr : blocked) 
        //         sb.add(arr[0] + "_" + arr[1]);
        //     Set<String> ss = new HashSet<>(); // visited
        //     ss.add(source[0] + "_" + source[1]);
        //     if (!bfsUnblockable(sb, ss, source, target[0] + "_" + target[1])) return false;
        //     ss.clear();
        //     ss.add(target[0] + "_" + target[1]);
        //     return bfsUnblockable(sb, ss, target, source[0] + "_" + source[1]);
        // }


        // // 对于每个节点，有一下三种case：
        // // case（1）：如果它有一个孩子，且这个孩子是叶子（状态0），则它需要摄像头，res ++，然后返回1，表示已经给它装上了摄像头。
        // // case（2）：如果它有一个孩子，且这个孩子是叶子的父节点（状态1），那么它已经被覆盖，返回2。
        // // case（0）：否则，这个节点无孩子，或者说，孩子都是状态2，那么我们将这个节点视为叶子来处理。
        // // 由于dfs最终返回后，整棵树的根节点的状态还未处理，因此需要判断，若根节点被视为叶子，需要在其上加一个摄像头。
        // private int dfs(TreeNode r) {
        //     // 空节点不需要被覆盖，归入情况2
        //     if (r == null) return 2; // do not need cover
        //     int left = dfs(r.left);  // 递归求左右孩子的状态
        //     int right = dfs(r.right);
        //     // 获取左右孩子状态之后的处理
        //     // 有叶子孩子，加摄像头，归入情况1
        //     if (left == 0 || right == 0) {
        //         res ++;
        //         return 1;
        //     }
        //     // 孩子上有摄像头，说明此节点已被覆盖，情况2; 
        //     if (left == 1 || right == 1) return 2;
        //     return 0;
        // }
        // int res = 0;
        // public int minCameraCover(TreeNode root) {
        //     // 若根节点被视为叶子，需要在其上加一个摄像头
        //     return (dfs(root) == 0 ? 1 : 0) + res;
        // }


        // // 时隔这么久，再回来写这类图题，居然还有点儿晕晕的： 和前段时间用到的 dfs + 记忆数组 有什么区别？
        // private boolean dfs(int end, int i, int p) { // p: pre
        //     if (i == end) return true;
        //     if (ll.get(i).size() == 1 && p != -1 && ll.get(i).get(0) == p) return false;
        //     vis[i] = true;
        //     int v = 0;
        //     for (int j = 0; j < ll.get(i).size(); j++) {
        //         v = ll.get(i).get(j);
        //         if (v == p || vis[v]) continue;
        //         if (v == end) return true;
        //         if (dfs(end, v, i)) return true;
        //     }
        //     return false;
        // }
        // List<List<Integer>> ll;
        // boolean [] vis;
        // public boolean validPath(int n, int[][] edges, int start, int end) {
        //     if (start == end) return true;
        //     ll = new ArrayList<>();
        //     for (int i = 0; i < n; i++) 
        //         ll.add(new ArrayList<>());
        //     for (int i = 0; i < edges.length; i++) {
        //         ll.get(edges[i][0]).add(edges[i][1]);
        //         ll.get(edges[i][1]).add(edges[i][0]);
        //     }
        //     vis = new boolean[n];
        //     return dfs(end, start, -1);
        // }


        // private void dfs(int [][] arr, int ox, int oy, int x, int y, int [] max) {
        //     if (x < 0 || x >= m || y < 0 || y >= n
        //         || arr[x][y] == 0 || vis[x][y]) return;
        //     vis[x][y] = true;
        //     if (x >= max[0] && y >= max[1]) {
        //         max[0] = x;
        //         max[1] = y;
        //     }
        //     for (int [] d : dirs)
        //         dfs(arr, ox, oy, x+d[0], y+d[1], max);
        // }
        // int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // boolean [][] vis;
        // int m, n;
        // public int[][] findFarmland(int[][] land) {
        //     m = land.length;
        //     n = land[0].length;
        //     vis = new boolean [m][n];
        //     List<int []> res = new ArrayList<>();
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) 
        //             if (land[i][j] == 1 && !vis[i][j]) {
        //                 int [] loc = new int [2];
        //                 dfs(land, i, j, i, j, loc);
        //                 res.add(new int [] {i, j, loc[0], loc[1]});
        //             }
        //     int [][] ans = new int [res.size()][4];
        //     for (int i = 0; i < res.size(); i++) 
        //         ans[i] = res.get(i);
        //     return ans;
        // }


        // public int countBattleships(char[][] board) {
        //     int m = board.length, n = board[0].length;
        //     boolean [][] vis = new boolean [m][n];
        //     int cnt = 0;
        //     boolean hori = false, vert = false;
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) 
        //             if (board[i][j] == 'X' && !vis[i][j]) {
        //                 ++cnt;
        //                 hori = false;
        //                 vert = false;
        //                 for (int k = j+1; k < n; k++) {
        //                     if (!vis[i][k] && board[i][k] == 'X') {
        //                         if (!hori) hori = true;
        //                         vis[i][k] = true;
        //                     } else break;
        //                 }
        //                 if (hori) continue;
        //                 for (int k = i+1; k < m; k++) {
        //                     if (!vis[k][j] && board[k][j] == 'X') {
        //                         if (!vert) vert = true;
        //                         vis[k][j] = true;
        //                     } else break;
        //                 }
        //             }
        //     return cnt;
        // }


        // public class UnionFind {
        //     int [] pare;
        //     int [] rank;
        //     int n;
        //     int cnt;
        //     public UnionFind(int x) {
        //         this.n = x;
        //         cnt = this.n;
        //         pare = new int[this.n];
        //         rank = new int[this.n];
        //         for (int i = 0; i < n; i++) pare[i] = i;
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
        //         if (rank[rp] < rank[rq]) 
        //             swap(rp, rq);
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
        //     private void isolatedInfectedMax(int [][] arr) {
        //         int i = 0, j = 0;
        //         for (int k = 0; k < this.n; k++) {
        //             if (pare[k] == maxCorresKey) {
        //                 i = k / arr[0].length;
        //                 j = k % arr[0].length;
        //                 arr[i][j] = 2;
        //             }
        //         }
        //     }
        //     private void infectingNeighbours(int [][] arr, int v) {
        //         int m = arr.length;
        //         int n = arr[0].length;
        //         for (int i = 0; i < arr.length; i++) {
        //             for (int j = 0; j < arr[0].length; j++) {
        //                 if (arr[i][j] == 1 && pare[i*n+j] != v) {
        //                     if (i > 0 && pare[(i-1)*n+j] != pare[i] && arr[i-1][j] == 0) {
        //                         arr[i-1][j] = 3;
        //                         merge(i*n+j, (i-1)*n+j);
        //                     }
        //                     if (i < m-1 && pare[(i+1)*n+j] != pare[i] && arr[i+1][j] == 0) {
        //                         arr[i+1][j] = 3;
        //                         merge(i*n+j, (i+1)*n+j);
        //                     }
        //                     if (j > 0 && pare[i*n+j-1] != pare[i] && arr[i][j-1] == 0) {
        //                         arr[i][j-1] = 3;
        //                         merge(i*n+j, i*n+j-1);
        //                     }
        //                     if (j < n-1 && pare[i*n+j+1] != pare[i] && arr[i][j+1] == 0) {
        //                         arr[i][j+1] = 3;
        //                         merge(i*n+j, i*n+j+1);
        //                     }
        //                 }
        //             }
        //         }
        //         for (int i = 0; i < arr.length; i++) 
        //             for (int j = 0; j < arr[0].length; j++) 
        //                 if (arr[i][j] == 3) arr[i][j] = 1;
        //     }
        //     private void processInfectingNeighbour(int [][] arr) {
        //         isolatedInfectedMax(arr);
        //         infectingNeighbours(arr, maxCorresKey);                
        //     }
        //     int maxCorresKey = 0;
        //     public int getMaxGroupedPerimeter(int [][] arr) {
        //         int m = arr.length;
        //         int n = arr[0].length;
        //         Map<Integer, Integer> ma = new HashMap<>();
        //         for (int i = 0; i < this.n; i++) {
        //             find(i);
        //             if (arr[i/n][i%n] != 2)
        //                 ma.put(pare[i], ma.getOrDefault(pare[i], 0) + 1);
        //         }
        //         Map<Integer, Integer> map = ma.entrySet().stream()
        //             .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        //             .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
        //         HashSet<Integer> s = new HashSet<>();
        //         int x = 0, y = 0;
        //         int max = Integer.MIN_VALUE;
        //         int res = 0, cnt = 0, wood = 0;
        //         for (Integer key : map.keySet()) {
        //             for (int i = 0; i < this.n; i++) {
        //                 if (pare[i] == key) {
        //                     x = i/n;
        //                     y = i % n;
        //                     cnt = 0;
        //                     if (x > 0 && pare[(x-1)*n+y] != pare[i]) { s.add((x-1)*n+y); ++cnt; }
        //                     if (x < m-1 && pare[(x+1)*n+y] != pare[i]) { s.add((x+1)*n+y); ++cnt; }
        //                     if (y > 0 && pare[x*n+y-1] != pare[i]) { s.add(x*n+y-1); ++cnt; }
        //                     if (y < n-1 && pare[x*n+y+1] != pare[i]) { s.add(x*n+y+1); ++cnt; }
        //                     if (x == 0) ++cnt;
        //                     if (y == 0) ++cnt;
        //                     if (x == m-1) ++cnt;
        //                     if (y == n-1) ++cnt;
        //                     res += 4-cnt; // 这里数得不对，改天再写
        //                 }
        //             }
        //             if (s.size() > max) {
        //                 max = s.size();
        //                 maxCorresKey = key;
        //                 wood = res;
        //             }
        //             s.clear();
        //             res = 0;
        //         }
        //         return wood;
        //     }
        //     private void swap(int x, int y) {
        //         int tmp = x;
        //         x = y;
        //         y = tmp;
        //     }
        // }
        // private boolean allTwo(int [][] arr) {
        //     int m = arr.length;
        //     int n = arr[0].length;
        //     for (int i = 0; i < m; i++) {
        //         for (int j = 0; j < n; j++) {
        //             if (arr[i][j] == 1) return false;
        //         }
        //     }
        //     return true;
        // }
        // public int containVirus(int[][] arr) { 
        //     int m = arr.length;
        //     int n = arr[0].length;
        //     UnionFind uf = new UnionFind(m*n);
        //     for (int i = 0; i < m*n; i++) {
        //         for (int j = 0; j < m*n; j++) {
        //             if (i == j) continue;
        //             if (arr[i/n][i%n] == 1 && arr[i/n][i%n] == arr[j/n][j%n] && !uf.sameGroup(i, j)
        //                 && ((Math.abs(i/n-j/n) == 1 && i%n == j%n) || (Math.abs(i%n-j%n) == 1 && i/n==j/n)))
        //                 uf.merge(i, j);
        //         }
        //     }
        //     int res = 0;
        //     int tmp = 0;
        //     while (!allTwo(arr)) {
        //         tmp =  uf.getMaxGroupedPerimeter(arr); // 这个邻居个数是对的，对应的边或需要的板是不对的，要更新，不知道剩下的板要怎么数才好
        //         System.out.println("tmp: " + tmp);
        //         res += tmp;
        //         uf.isolatedInfectedMax(arr); // 1--> 2
        //         uf.processInfectingNeighbour(arr);
        //     }
        //     return res/2;
        // }
        // private class Region {
        //     Set<Integer> infected = new HashSet<>();
        //     Set<Integer> uninfected = new HashSet<>();
        //     int wallsRequired = 0;
        // }
        // private void dfs(int [][] arr, int i, int j, boolean [][] vis, Region region) {
        //     if (i < 0 || i >= m || j < 0 || j >= n || arr[i][j] == 2) return;
        //     if (arr[i][j] == 1) {
        //         region.infected.add(i*n+j); // 1 is already infected.
        //         if (vis[i][j]) return;
        //     }
        //     vis[i][j] = true;
        //     if (arr[i][j] == 0) {
        //         // If 0 it is uninfected neighbor, we need a wall.
        //         // Remeber we can reach this 0 multiple times from different infected neighbors i.e. 1s,
        //         // and this will account for numbers of walls need to be built around this 0.
        //         region.wallsRequired++; // 这是我数不清樯板的地方:四个方向上，哪几个方向上有还未感染的邻居，就会数几个边上需要板
        //         region.uninfected.add(i*n+j);
        //         return ;
        //     }
        //     for (int [] d : dirs) 
        //         dfs(arr, i+d[0], j+d[1], vis, region);
        // }
        // // 1.Find all the regions.
        // // 2.Get the region which has most number of uninfected neighbors. This region will cause maximum damage.
        // // 3.For region in (2) contain the region. Mark all the infected nodes in this region as 2 to denote that these nodes are now contained and will not cause any more damage.
        // // 4.For the remaining regions, expand by infecting the uninfected neighbors around these regions.
        // // 5.Repeat steps (1) to (4) until there are no more regions with uninfected neighbors.
        // int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}} ;
        // int m, n;
        // public int containVirus(int[][] arr) { 
        //     m = arr.length;
        //     n = arr[0].length;
        //     int res = 0;
        //     while (true) {
        //         List<Region> regions = new ArrayList<>();
        //         boolean [][] vis = new boolean [m][n];
        //         for (int i = 0; i < m; i++) 
        //             for (int j = 0; j < n; j++) 
        //                 if (arr[i][j] == 1 && !vis[i][j]) {
        //                     Region region =  new Region();
        //                     dfs(arr, i, j, vis, region);
        //                     if (region.uninfected.size() > 0)
        //                         regions.add(region);
        //                 }
        //         if (regions.size() == 0) break;
        //         Collections.sort(regions, (a, b)->b.uninfected.size() - a.uninfected.size());
        //         Region mostDangerous = regions.remove(0);
        //         res += mostDangerous.wallsRequired;
        //         for (Integer nb : mostDangerous.infected) {
        //             int x = nb / n;
        //             int y = nb % n;
        //             arr[x][y] = 2;
        //         }
        //         for (Region region : regions) 
        //             for (Integer nb : region.uninfected) {
        //                 int x = nb / n;
        //                 int y = nb % n;
        //                 arr[x][y] = 1;
        //             }
        //     }
        //     return res;
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
// 这个题目好悲催：是leetcode里到目前为止几乎唯一一个没法本地测试的题目，不知道本地要如何测试这种无头无尾的程序
        // int i = 0;
        // public NestedInteger deserialize(String s) {
        //     if (i >= s.length()) return null;
        //     if (s.charAt(i) == '-' || Character.isDigit(s.charAt(i))) {
        //         int val = 0;
        //         boolean isPos = true; // positive or Negative +/1 sign
        //         if (s.charAt(i) == '-') {
        //             isPos = false;
        //             ++i;
        //         }
        //         while (i < s.length() && Character.isDigit(s.charAt(i))) {
        //             val = val * 10 + s.charAt(i) - '0';
        //             ++i;
        //         }
        //         return new NestedInteger(isPos ? val : -val);
        //     }
        //     NestedInteger ans = new NestedInteger();
        //     ++i;
        //     while (i < s.length() && s.charAt(i) != ']') {
        //         NestedInteger kid = deserialize(s); // 这里看疯了。。。。。。？？？
        //         ans.add(kid);
        //         if (i < s.length() && s.charAt(i) == ',') ++i;
        //     }
        //     ++i;
        //     return ans;
        // }

    }
    public static void main(String[] args) {
        Solution s = new Solution();

        // int [][] a = new int [][] {{1,1,1,0,0,0,0,0,0},{1,0,1,0,1,1,1,1,1},{1,1,1,0,0,0,0,0,0}};
        String a = "dlkfjd";;
        NestedInteger r = s.deserialize(a);
    }
}