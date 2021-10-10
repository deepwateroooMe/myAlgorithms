// import com.UnionFind;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class heaptwo {
    public static class Solution {

        // private class Pt {
        //     int i;
        //     int x;
        //     int y;
        //     int v;
        //     public Pt(int a, int b, int c, int d) {
        //         i = a;
        //         x = b;
        //         y = c;
        //         v = d; // chairs
        //     }
        // }
        // public int smallestChair(int[][] times, int targetFriend) {
        //     int n = times.length;
        //     Map<Integer, List<Integer>> m = new HashMap<>();
        //     for (int i = 0; i < n; i++) 
        //         m.put(i, Arrays.stream(times[i]).boxed().collect(Collectors.toList()));
        //     Comparator<Map.Entry<Integer, List<Integer>>> c = new Comparator<Map.Entry<Integer, List<Integer>>> () {
        //         @Override 
        //             public int compare(Map.Entry<Integer, List<Integer>> a, Map.Entry<Integer, List<Integer>> b) {
        //             int cmp1 = a.getValue().get(0) - b.getValue().get(0);
        //             if (cmp1 != 0) {
        //                 return cmp1;
        //             } else {
        //                 return a.getValue().get(1) - b.getValue().get(1);
        //             }
        //         }
        //     };
        //     Map<Integer, List<Integer>> map = m.entrySet().stream().sorted(c)
        //         .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        //     Queue<Pt> q = new PriorityQueue<>((x, y) -> x.y - y.y);
        //     Queue<Integer> p = new PriorityQueue<>();
        //     for (int i = 0; i < n; i++) 
        //         p.add(i);
        //     List<Integer> l = new ArrayList<>();
        //     int idx = 0;
        //     Pt cur = null;
        //     for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
        //         l = entry.getValue();
        //         if (q.size() == 0) {
        //             if (entry.getKey() == targetFriend) return p.peek();
        //             q.add(new Pt(entry.getKey(), l.get(0), l.get(1), p.poll()));
        //         } else {
        //             if (q.size() > 0) {
        //                 cur = q.peek();
        //                 if (l.get(0) >= cur.y) {
        //                     while (l.get(0) >= cur.y && q.size() > 0) {
        //                         p.add(cur.v);
        //                         q.poll();
        //                         if (q.size() > 0)
        //                             cur = q.peek();
        //                         else break;
        //                     }
        //                 }
        //             }
        //             if (entry.getKey() == targetFriend) return p.peek();
        //             q.add(new Pt(entry.getKey(), l.get(0), l.get(1), p.poll()));
        //         }
        //     }
        //     return -1;
        // }

        
        // private class Pt {
        //     int i; // server index
        //     int j; // tasks idx
        //     int v; // time weight
        //     int t;
        //     public Pt(int a, int b) {
        //         i = a; 
        //         v = b;
        //     }
        //     public Pt(int a, int b, int c, int d) {
        //         i = a;
        //         j = b;
        //         v = c;
        //         t = d;
        //     }
        // }
        // public int[] assignTasks(int[] servers, int[] tasks) {
        //     int n = servers.length;
        //     int m = tasks.length;
        //     Queue<Pt> q = new PriorityQueue<>(new Comparator<Pt>() {
        //             @Override public int compare(Pt a, Pt b) {
        //                 int cmp = a.v - b.v;
        //                 if (cmp != 0) return cmp;
        //                 return a.t - b.t;
        //             }
        //         });
        //     Queue<Pt> p = new PriorityQueue<Pt>(new Comparator<Pt>() {
        //             @Override public int compare(Pt a, Pt b) {
        //                 int cmp = a.v - b.v;
        //                 if (cmp != 0) return cmp;
        //                 return a.i - b.i;
        //             }
        //         });
        //     for (int i = 0; i < n; i++) 
        //         p.add(new Pt(i, servers[i]));
        //     Pt top = null;
        //     int [] arr = new int [m];
        //     int waitResidual = 0;
        //     for (int i = 0; i < m; i++) { // ith task insertion time needs some works too
        //         waitResidual = 0;
        //         if (q.isEmpty()) {
        //             arr[i] = p.peek().i;
        //             q.add(new Pt(p.poll().i, i, i + tasks[i], i));
        //         } else {
        //             top = q.peek();
        //             if (i >= top.v) {
        //                 while (i >= top.v) {
        //                     p.add(new Pt(top.i, servers[top.i]));
        //                     q.poll();
        //                     if (!q.isEmpty()) top = q.peek();
        //                     else break;
        //                 }
        //             }
        //             // System.out.println("p.size(): " + p.size());
        //             if (p.size() == 0) {
        //                 top = q.poll();
        //                 waitResidual = top.v - i;
        //                 p.add(new Pt(top.i, servers[top.i]));
        //                 // while (q.size() > 0 && q.peek().v == top.v) {
        //                 //     top = q.poll();
        //                 //     p.add(new Pt(top.i, servers[top.i]));
        //                 // }
        //             }
        //             arr[i] = p.peek().i;
        //             q.add(new Pt(p.poll().i, i, waitResidual + i + tasks[i], i + waitResidual));
        //         }
        //         waitResidual = 0;
        //     }
        //     return arr;
        // }
        // int []  a = new int []  {338, 890, 301, 532, 284, 930, 426, 616, 919, 267, 571, 140, 716, 859, 980, 469, 628, 490, 195, 664, 925, 652, 503, 301, 917, 563, 82, 947, 910, 451, 366, 190, 253, 516, 503, 721, 889, 964, 506, 914, 986, 718, 520, 328, 341, 765, 922, 139, 911, 578, 86, 435, 824, 321, 942, 215, 147, 985, 619, 865};
        // int []  b = new int []  {773, 537, 46, 317, 233, 34, 712, 625, 336, 221, 145, 227, 194, 693, 981, 861, 317, 308, 400, 2, 391, 12, 626, 265, 710, 792, 620, 416, 267, 611, 875, 361, 494, 128, 133, 157, 638, 632, 2, 158, 428, 284, 847, 431, 94, 782, 888, 44, 117, 489, 222, 932, 494, 948, 405, 44, 185, 587, 738, 164, 356, 783, 276, 547, 605, 609, 930, 847, 39, 579, 768, 59, 976, 790, 612, 196, 865, 149, 975, 28, 653, 417, 539, 131, 220, 325, 252, 160, 761, 226, 629, 317, 185, 42, 713, 142, 130, 695, 944, 40, 700, 122, 992, 33, 30, 136, 773, 124, 203, 384, 910, 214, 536, 767, 859, 478, 96, 172, 398, 146, 713, 80, 235, 176, 876, 983, 363, 646, 166, 928, 232, 699, 504, 612, 918, 406, 42, 931, 647, 795, 139, 933, 746, 51, 63, 359, 303, 752, 799, 836, 50, 854, 161, 87, 346, 507, 468, 651, 32, 717, 279, 139, 851, 178, 934, 233, 876, 797, 701, 505, 878, 731, 468, 884, 87, 921, 782, 788, 803, 994, 67, 905, 309, 2, 85, 200, 368, 672, 995, 128, 734, 157, 157, 814, 327, 31, 556, 394, 47, 53, 755, 721, 159, 843};

        // private int binarySearch(int [] arr, int k, int i, int j) {
        // }
        // public int maxProfit(int[] inventory, int orders) {
        //     int n = inventory.length;
        //     if (n == 1) {
        //         long sum = orders * (inventory[0] - orders + 1 + inventory[0]) / 2 % 1000000007;
        //         return (int)sum;
        //     }
        //     Arrays.sort(inventory); // val;
        //     int k = binarySearch(inventory, orders, 0, n-1);
        // }

        // private class Pt {
        //     int i;
        //     int j;
        //     public Pt(int a, int b) {
        //         i = a;
        //         j = b;
        //     }
        // }
        // public int maxEvents(int[][] events) {
        //     int n = events.length;
        //     if (n == 1) return 1;
        //     Queue<Pt> q = new PriorityQueue<>(new Comparator<Pt>() {
        //             @Override public int compare(Pt x, Pt y) {
        //                 int cp = x.j - y.j;
        //                 if (cp != 0) return cp;
        //                 return x.i - y.i;
        //             }
        //         });
        //     for (int i = 0; i < events.length; i++) 
        //         q.add(new Pt(events[i][0], events[i][1]));
        //     int cnt = 0;
        //     Pt cur = null;
        //     Pt next = null;
        //     int day = 0;
        //     while (!q.isEmpty()) {
        //         cur = q.poll();
        //         // System.out.println("\ncur.i: " + cur.i);
        //         // System.out.println("cur.j: " + cur.j);
        //         // System.out.println("(cur.j < day): " + (cur.j < day));
        //         if (cur.j < day) continue;
        //         ++cnt;
        //         if (day == cur.j) day = cur.j+1;
        //         else if (day < cur.i) day = cur.i + 1;
        //         else if (day >= cur.i) day += 1;
        //         // System.out.println("cnt: " + cnt);
        //         // System.out.println("day: " + day);
        //     }
        //     return cnt;
        // }


        // public int minimumDeviation(int[] nums) {
        //     int n = nums.length;
        //     Set<Integer> s = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        //     TreeSet<Integer> ts = new TreeSet<>();
        //     int max = Integer.MIN_VALUE;
        //     int min = Integer.MAX_VALUE;
        //     for (Integer v : s) {
        //         if (v % 2 == 1) ts.add(v * 2); // 将所有的数先变成偶数先
        //         else ts.add(v);
        //         min = Math.min(min, v);
        //         max = Math.max(max, v);
        //     }
        //     int maxdiff = ts.last() - ts.first();
        //     int last = Integer.MAX_VALUE;
        //     max = ts.last();
        //     min = Integer.MAX_VALUE;
        //     while (maxdiff != last) {
        //         if (max % 2 == 0) {
        //             ts.remove(max);
        //             ts.add(max / 2);
        //         }
        //         max = ts.last();
        //         last = maxdiff;
        //         maxdiff = ts.last() - ts.first();
        //         min = Math.min(min, maxdiff);
        //     }
        //     return min;
        // }

        // class Range {
        //     int left, right, size;
        //     public Range(int left, int right) {
        //         this.left = left;
        //         this.right = right;
        //         this.size = right - left + 1;
        //     }
        //     public String toString() {
        //         return "Range(" + left + "," + right + "," + size + ")";
        //     }
        // }
        // public int[] minInterval(int[][] intervals, int[] queries) {
        //     // Arrays.sort(intervals, new Comparator<int []>(){
        //     //         @Override public int compare(int [] x, int [] y) {
        //     //             int cmp = x[0] - y[0];
        //     //             if (cmp != 0) return cmp;
        //     //             return x[1]-x[0] - (y[1]-y[0]);
        //     //         }
        //     //     });
        //     TreeSet<Range> ts = new TreeSet<Range>(new Comparator<Range>() {
        //             @Override public int compare(Range one, Range two) {
        //                 int cmp = one.left - two.left;
        //                 if (cmp != 0) return cmp;
        //                 return one.size - two.size;
        //             }
        //         });
        //     for (int i = 0; i < intervals.length; i++) 
        //         ts.add(new Range(intervals[i][0], intervals[i][1]));
        //     Map<Integer, Integer> q = new HashMap<>();
        //     for (int i = 0; i < queries.length; i++) 
        //         q.put(i, queries[i]);
        //     Map<Integer, Integer> m = q.entrySet().stream()
        //         .sorted(Map.Entry.comparingByValue()) // Comparator.reverseOrder()
        //         .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
        //     int [] res = new int[queries.length];
        //     int v = 0;
        //     for (int i = 0; i < queries.length; i++) {
        //         v = m.get(i);
        //         // 想想这里如何从treeset中查询想要找的答案
        //     }
        // }


    // https://www.acwing.com/solution/LeetCode/content/6358/
        // private void dfs(char [][] arr, int x, int y, int i, int j, boolean mk) { // target pos , cur position
        //     if (i < 0 || i >= m || j < 0 || j >= n || vis[i][j] || arr[i][j] == '#') return;
        //     if (mk && arr[i][j] == 'B') return;
        //     if (i == x && y == j) {
        //         res = true;
        //         return;
        //     }
        //     vis[i][j] = true;
        //     for (int [] d : dirs) {
        //         if (!res)
        //             dfs(arr, x, y, i+d[0], j+d[1], mk);
        //     }
        // }
        // private int getPlayerRelaPosIdx(int v) {
        //     switch (v) {
        //     case 0: return 2;
        //     case 1: return 3;
        //     case 2: return 0;
        //     case 3: return 1;
        //     }
        //     return -1;
        // }
        // private void modifyPos(char [][] arr, int x, int y, int a, int b, boolean fw) { // box + player
        //     if (fw) {
        //         arr[bi][bj] = '.';
        //         arr[si][sj] = '.';
        //         arr[x][y] = 'B';
        //         arr[a][b] = 'S';
        //     } else {
        //         arr[bi][bj] = 'B';
        //         arr[si][sj] = 'S';
        //         arr[x][y] = '.';
        //         arr[a][b] = '.';
        //     }
        // }
        // // 角落里转换方向时的判断仍有误地，思路清楚：思路是很清楚，可是写着写着把自己写死了？！！！怎么才能用思路清晰的代码表达出来，越写越简洁？？？
        // private boolean isValid(char [][] arr, int i, int j, int k, int pi, int pj, int pk) { // cur state & pre state
        //     if (i < 0 || i >= m || j < 0 || j >= n
        //         || i+dirs[k][0] < 0 || i+dirs[k][0] >= m || j+dirs[k][1] < 0 || j+dirs[k][1] >= n) return false;
        //     if (arr[i+dirs[k][0]][j+dirs[k][1]] == '#' || arr[i][j] == '#') return false;
        //     if ((k == 0 && pk == 2) || (k == 2 && pk == 0) || (k == 1 && pk == 3) || (k == 3 && pk == 1)) return true;
        //     if (i+dirs[k][0]*2 >= 0 && i+dirs[k][0]*2 < m && j+dirs[k][1]*2 >= 0 && j+dirs[k][1]*2 < n
        //         && arr[i+dirs[k][0]*2][j+dirs[k][1]*2] == '#') return false;
        //     if (k == getPlayerRelaPosIdx(pk) && i+dirs[getPlayerRelaPosIdx(k)][0]*2 >= 0 && i+dirs[getPlayerRelaPosIdx(k)][0]*2 < m
        //         && j+dirs[getPlayerRelaPosIdx(k)][1]*2 >= 0 && j+dirs[getPlayerRelaPosIdx(k)][1]*2 < n
        //         && arr[i+dirs[getPlayerRelaPosIdx(k)][0]*2][j+dirs[getPlayerRelaPosIdx(k)][1]*2] == '#') return false;
        //     res = false;
        //     for (int x = 0; x < m; x++) 
        //         Arrays.fill(vis[x], false);
        //     modifyPos(arr, pi, pj, pi+dirs[pk][0], pj+dirs[pk][1], true);
        //     dfs(arr, pi+dirs[k][0], pj+dirs[k][1], pi+dirs[pk][0], pj+dirs[pk][1], true);
        //     modifyPos(arr, pi, pj, pi+dirs[pk][0], pj+dirs[pk][1], false);
        //     return res;
        // }
        // private int bfs(char [][] arr, Set<int []> sc) { // int px, int py, int x, int y
        //     Queue<int []> q = new LinkedList<>();
        //     Set<int []> sn = new HashSet<>();
        //     int [] cur = null;
        //     int i = 0, j = 0, pi = 0 , pj = 0, cnt = 0;
        //     while (sc.size() > 0) {
        //         for (int [] v : sc) // bi, bj, [0123]
        //             q.add(v);
        //         while (!q.isEmpty()) {
        //             cur = q.poll();
        //             i = cur[0];
        //             j = cur[1];
        //             pi = i + dirs[cur[2]][0];
        //             pj = j + dirs[cur[2]][1];
        //             if (vb[i][j][cur[2]]) continue;
        //             vb[i][j][cur[2]] = true;
        //             for (int k = 0; k < dirs.length; k++) {
        //                 // if (k == getPlayerRelaPosIdx(cur[2])) continue; // ????
        //                 if (i+dirs[k][0] >= 0 && i+dirs[k][0] < m && j+dirs[k][1] >= 0 && j+dirs[k][1] < n
        //                     && !vb[i+dirs[k][0]][j+dirs[k][1]][getPlayerRelaPosIdx(k)]
        //                     && isValid(arr, i+dirs[k][0], j+dirs[k][1], getPlayerRelaPosIdx(k), i, j, cur[2])) {
        //                     if (arr[i+dirs[k][0]][j+dirs[k][1]] == 'T') 
        //                         return cnt+1;
        //                     sn.add(new int [] {i+dirs[k][0], j+dirs[k][1], getPlayerRelaPosIdx(k)});
        //                 }
        //             }
        //         }
        //         sc.clear();
        //         sc.addAll(sn);
        //         sn.clear();
        //         ++cnt;
        //     }
        //     return -1;
        // }
        // int [][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 0, 1, 2, 3, clockwise
        // Set<int []> s = new HashSet<>();
        // boolean res = false;
        // boolean [][] vis;
        // boolean [][][] vb; // player + box
        // int bi, bj, si, sj;
        // int m, n;
        // public int minPushBox(char[][] grid) {
        //     m = grid.length;
        //     n = grid[0].length;
        //     boolean fb = false;
        //     boolean fs = false;
        //     bi = 0;
        //     bj = 0;
        //     si = 0;
        //     sj = 0;
        //     for (int i = 0; i < m; i++) {
        //         for (int j = 0; j < n; j++) {
        //             if (grid[i][j] == 'B') {        // box position
        //                 bi = i;
        //                 bj = j;
        //                 fb = true;
        //                 if (fb && fs) break;
        //             } else if (grid[i][j] == 'S') { // player position
        //                 si = i;
        //                 sj = j;
        //                 fs = true;
        //                 if (fb && fs) break;
        //             }
        //         }
        //     }
        //     vis = new boolean[m][n];
        //     s = new HashSet<>();
        //     for (int i = 0; i < dirs.length; i++) {
        //         res = false;
        //         dfs(grid, si, sj, bi+dirs[i][0], bj+dirs[i][1], false);
        //         if (res) s.add(new int[] {bi, bj, i}); // valid initial box + player relative position
        //     }
        //     if (!res && s.size() == 0) return -1;
        //     vb = new boolean[m][n][4];
        //     return bfs(grid, s);
        // }
    // // https://leetcode.jp/leetcode-1263-minimum-moves-to-move-a-box-to-their-target-location-%E8%A7%A3%E9%A2%98%E6%80%9D%E8%B7%AF%E5%88%86%E6%9E%90/
    //     private boolean canPlayerMove(int pi, int pj, int ti, int tj, int bi, int bj, boolean [][] vis, char [][] arr) {
    //         vis[pi][pj] = true;
    //         if (pi == ti && pj == tj) return true;
    //         int i = 0, j = 0;
    //         for (int [] d : dirs) {
    //             i = pi + d[0];
    //             j = pj + d[1];
    //             if (i >= 0 && i < m && j >= 0 && j < n
    //                 && arr[i][j] != '#' && !vis[i][j]
    //                 && (i != bi && j != bj)) { // 也不可以是箱子所在的位置: 这里没有更改面板，直接记住位置就可以了
    //                 if (canPlayerMove(i, j, ti, tj, bi, bj, vis, arr))
    //                     return true;
    //             }
    //         }
    //         return false;
    //     }
    //     private int dfs(char [][] arr, int bi, int bj, int pi, int pj) {
    //         if (arr[bi][bj] == 'T') return 0;
    //         if (memo[bi][bj][pi][pj] != 0) return memo[bi][bj][pi][pj];
    //         vis[bi][bj][pi][pj] = true;
    //         int res = Integer.MAX_VALUE;
    //         if (bi+1 < m && arr[bi+1][bj] != '#' && bi-1 >= 0 && arr[bi-1][bj] != '#') { // 箱子上下两格为空地时
    //             // 如果箱子没有从当前位置向上推动过，并且人能够移动到箱子下方
    //             if (!vis[bi-1][bj][bi][bj] && canPlayerMove(pi, pj, bi+1, bj, bi, bj, new boolean[m][n], arr)) 
    //                 res = Math.min(res, 1+dfs(arr, bi-1, bj, bi, bj));
    //             // 如果箱子没有从当前位置向下推动过，并且人能够移动到箱子上方
    //             if (!vis[bi+1][bj][bi][bj] && canPlayerMove(pi, pj, bi-1, bj, bi, bj, new boolean[m][n], arr))
    //                 res = Math.min(res, 1+dfs(arr, bi+1, bj, bi, bj));
    //         }
    //         if (bj+1 < n && arr[bi][bj+1] != '#' && bj-1 >= 0 && arr[bi][bj-1] != '#') {  // 箱子左右两格为空地时
    //             // 如果箱子没有从当前位置向左推动过，并且人能够移动到箱子右方
    //             if (!vis[bi][bj-1][bi][bj] && canPlayerMove(pi, pj, bi, bj+1, bi, bj, new boolean[m][n], arr))
    //                 // dfs向左移动箱子一格，人移动到原先箱子位置
    //                 res = Math.min(res, 1+dfs(arr, bi, bj-1, bi, bj));
    //             // 如果箱子没有从当前位置向右推动过，并且人能够移动到箱子左方
    //             if (!vis[bi][bj+1][bi][bj] && canPlayerMove(pi, pj, bi, bj-1, bi, bj, new boolean[m][n], arr))
    //                 res = Math.min(res, 1+dfs(arr, bi, bj+1, bi, bj));
    //         }
    //         vis[bi][bj][pi][pj] = false;
    //         memo[bi][bj][pi][pj] = res;
    //         return res;
    //     }
    //     int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    //     boolean [][][][] vis;
    //     int [][][][] memo;
    //     int m, n;
    //     public int minPushBox(char[][] grid) {
    //         m = grid.length;
    //         n = grid[0].length;
    //         boolean fb = false;
    //         vis = new boolean [m][n][m][n];
    //         memo = new int [m][n][m][n];
    //         int bi = 0, bj = 0, pi = 0, pj = 0;
    //         for (int i = 0; i < m; i++) {
    //             for (int j = 0; j < n; j++) {
    //                 if (grid[i][j] == 'B') {
    //                     bi = i;
    //                     bj = j;
    //                 } else if (grid[i][j] == 'S') {
    //                     pi = i;
    //                     pj = j;
    //                 }
    //             }
    //         }
    //         int res = dfs(grid, bi, bj, pi, pj);
    //         return res == Integer.MAX_VALUE ? -1 : res;
    //     }


        // public String longestDiverseString(int a, int b, int c) {
        //     StringBuilder sb = new StringBuilder();
        //     int size = a + b + c;
        //     int ca = 0, cb = 0, cc = 0;
        //     for (int i = 0; i < size; i++) {
        //         if ((a >= b && a >= c && ca != 2) || a > 0 && cb == 2 || a > 0 && cc == 2) {
        //             sb.append('a');
        //             a--;
        //             ca++;
        //             cb = 0;
        //             cc = 0;
        //         } else if (b >= a && b >= c && cb != 2 || b > 0 && ca == 2 || b > 0 && cc == 2) {
        //             sb.append('b');
        //             b--;
        //             cb++;
        //             ca = 0;
        //             cc = 0;
        //         } else if (c >= a && c >= b && cc != 2 || c > 0 && ca == 2 || c > 0 && cb == 2) {
        //             sb.append('c');
        //             c--;
        //             cc++;
        //             ca = 0;
        //             cb = 0;
        //         }
        //     }
        //     return sb.toString();
        // }


        // public String reorganizeString(String s) {
        //     int n = s.length();
        //     if (n == 1 || (n == 2 && s.charAt(0) != s.charAt(1)) || s.chars().distinct().count() == n) return s;
        //     int [] cnt = new int [26];
        //     for (int i = 0; i < n; i++)
        //         cnt[s.charAt(i)-'a']++;
        //     Queue<int []> q = new PriorityQueue<>((a, b) -> b[1]-a[1]);
        //     for (int i = 0; i < 26; i++)
        //         if (cnt[i] > 0)
        //             q.offer(new int [] {i, cnt[i]});
        //     StringBuilder t = new StringBuilder();
        //     int [] cur = null, next = null;
        //     while (!q.isEmpty()) {
        //         cur = q.poll();
        //         if (t.length() == 0 || t.charAt(t.length()-1) != (char)(cur[0] + 'a')) {
        //             t.append((char)(cur[0] + 'a'));
        //             if (cur[1] > 1)
        //                 q.offer(new int [] {cur[0], cur[1]-1});
        //         } else {
        //             if (!q.isEmpty()) {
        //                 next = q.poll();
        //                 t.append((char)(next[0] + 'a'));
        //                 q.offer(cur);
        //                 if (next[1] > 1)
        //                     q.offer(new int [] {next[0], next[1]-1});
        //             } else return "";
        //         }
        //     }
        //     return t.toString();
        // }


        // public double maxAverageRatio(int[][] classes, int extraStudents) {
        //     Queue<int []> q = new PriorityQueue<int []>((x, y) -> ((double)(y[0]+1) / (y[1]+1)) - (double)y[0] / y[1]
        //                                                 - ((double)(x[0]+1) / (x[1]+1) - (double)x[0] / x[1]) > 0 ? 1 : -1);
        //     for (int [] v : classes) q.offer(v);
        //     int [] cur = null;
        //     for (; extraStudents > 0; extraStudents--) {
        //         cur = q.poll();
        //         cur[0]++;
        //         cur[1]++;
        //         q.offer(cur);
        //     }
        //     double res = 0d;
        //     for (int [] v : classes) 
        //         res += (double)v[0] / (double)v[1];
        //     return (double)(res / (double)classes.length);
        // }


        // private class Pt {
        //     int i;
        //     int v;
        //     public Pt(int a, int b) {
        //         i = a;
        //         v = b;
        //     }
        // }
        // public int[] rearrangeBarcodes(int[] barcodes) {
        //     int n = barcodes.length;
        //     if (n == 1) return barcodes;
        //     HashMap<Integer, Integer> map = new HashMap<>();
        //     for (int i = 0; i < n; i++) 
        //         map.put(barcodes[i], map.getOrDefault(barcodes[i], 0) + 1);
        //     Queue<Pt> q = new PriorityQueue<>((x, y) -> y.v - x.v); // Queue<int []> q = new PriorityQueue<>(); is convenient too
        //     for (Map.Entry<Integer, Integer> entry : map.entrySet()) 
        //         q.add(new Pt(entry.getKey(), entry.getValue()));
        //     int [] arr = new int[n];
        //     int idx = 0;
        //     Pt cur = null, next = null;
        //     while (!q.isEmpty()) {
        //         cur = q.poll();
        //         if (idx == 0 || arr[idx-1] != cur.i) {
        //             arr[idx++] = cur.i;
        //             if (cur.v > 1)
        //                 q.offer(new Pt(cur.i, cur.v-1));
        //             continue;
        //         }
        //         next = q.poll();
        //         arr[idx++] = next.i;
        //         if (next.v > 1)
        //             q.offer(new Pt(next.i, next.v-1));
        //         q.offer(cur);
        //     }
        //     return arr;
        // }


        // public boolean isPossible(int[] arr) {
        //     if (arr == null || arr.length == 0) return false;
        //     int n = arr.length;
        //     Map<Integer, Integer> m = new HashMap<>(); // frequency map
        //     for (int i = 0; i < n; i++) 
        //         m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
        //     Map<Integer, Integer> need = new HashMap<>(); // frequency map
        //     for (int v : arr) {
        //         if (m.get(v) <= 0) continue;
        //         if (need.getOrDefault(v, 0) > 0) {
        //             m.put(v, m.get(v)-1);
        //             need.put(v, need.get(v)-1);
        //             need.put(v+1, need.getOrDefault(v+1, 0) + 1);
        //         } else {
        //             if (m.getOrDefault(v+1, 0) > 0 && m.getOrDefault(v+2, 0) > 0) {
        //                 m.put(v, m.get(v)-1);
        //                 m.put(v+1, m.get(v+1)-1);
        //                 m.put(v+2, m.get(v+2)-1);
        //                 need.put(v+3, need.getOrDefault(v+3, 0) + 1);
        //             } else return false;
        //         } 
        //     }
        //     return true;
        // }
        // private PriorityQueue<Integer> getOrPut(int v) {
        //     PriorityQueue<Integer> q = dmap.get(v);
        //     if (q == null) {
        //         q = new PriorityQueue<Integer>();
        //         dmap.put(v, q);
        //     }
        //     return q;
        // }
        // private Map<Integer, PriorityQueue<Integer>> dmap;
        // public boolean isPossible(int[] arr) {
        //     dmap = new HashMap<>();
        //     for (int v : arr) {
        //         PriorityQueue<Integer> q = getOrPut(v-1);
        //         int len = q.isEmpty() ? 0 : q.poll();
        //         PriorityQueue<Integer> p = getOrPut(v);
        //         p.offer(len+1);
        //     }
        //     for (int key : dmap.keySet()) 
        //         for (int len : dmap.get(key)) 
        //             if (len < 3) return false;
        //     return true;
        // }


    }
    
    public static void main(String[] args) {
        Solution s = new Solution();

        int [][] a = new int [][] {{0,1},{1,2},{0,2}};
        double[] b = new double[] {0.5, 0.5, 0.2};

        double res = s.maxProbability(2, a, b, 0, 2);
        System.out.println("res: " + res);
    }
}