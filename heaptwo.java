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
        //     // for (Pt zz : q) 
        //     //     System.out.println(zz.i + ", " + zz.j);
        //    int cnt = 0;
        //     Pt cur = null;
        //     Pt next = null;
        //     int day = 0; // 0 
        //     while (!q.isEmpty()) {
        //         cur = q.poll();
        //         if (cur.j < day) continue;
        //         ++cnt;
        //         if (day < cur.i) day = cur.i + 1;
        //         else {
        //             if (day == cur.j) day = cur.j+1;
        //             else day += 1;
        //         }
        //     }
        //     return cnt;
        // }


        // public int[] assignTasks(int[] servers, int[] tasks) {// bugy bugy bugy把它找出来。。。。。。
        //     int n = servers.length;
        //     int m = tasks.length;
        //     Queue<int []> s = new PriorityQueue<>((a, b)->(a[1] != b[1] ? a[1] - b[1] : a[0]-b[0])); // [serverIdx, serverWeight]
        //     for (int i = 0; i < n; i++) 
        //         s.offer(new int [] {i, servers[i]});
        //     Queue<int []> q = new PriorityQueue<>((a, b)->(a[4]+a[3]- (b[4] + b[3])));
        //     int [] ans = new int [m], cur = null, sv = null;
        //     int now = 0;
        //     for (int i = 0; i < m; i++) { // ith task insertion time needs some works too
        //         if (!s.isEmpty() && (q.isEmpty() || q.size() > 0 && now < q.peek()[3] + q.peek()[4])) {
        //             sv = s.poll();
        //             q.offer(new int [] {sv[0], sv[1], i, tasks[i], now}); // [serverIdx, serverWeight, taskIdx, taskTime, enQtime]
        //         } else { // update now
        //             if (!q.isEmpty() && q.peek()[4] + q.peek()[3] > now) {
        //                 cur = q.poll();
        //                 ans[cur[2]] = cur[0];
        //                 s.offer(new int [] {cur[0], cur[1]});
        //                 now = cur[3] + cur[4];
        //             } else {
        //                 while (!q.isEmpty() && q.peek()[4] + q.peek()[3] <= now) {
        //                     cur = q.poll();
        //                     ans[cur[2]] = cur[0];
        //                     s.offer(new int [] {cur[0], cur[1]});
        //                 }
        //             }
        //             sv = s.poll();
        //             q.offer(new int [] {sv[0], sv[1], i, tasks[i], now});
        //         }
        //         now++;
        //     }
        //     while (!q.isEmpty()) {
        //         cur = q.poll();
        //         ans[cur[2]] = cur[0];
        //     }
        //     return ans;
        // }
//         public int[] assignTasks(int[] servers, int[] tasks) {
//             int n = servers.length, m = tasks.length;
//             int[][] s = new int[n][3];// 扩展服务器数组，添加编号和结束工作的时间点信息
//             for (int i = 0; i < n; i++) {
//                 s[i][0] = servers[i];
//                 s[i][1] = i;
//                 s[i][2] = 0;// 初始所有服务器处于空闲状态
//             }
// // 当前空闲的服务器队列，按权重、下标排序
//             PriorityQueue<int[]> free = new PriorityQueue<int[]>((ser1, ser2) -> (ser1[0] != ser2[0] ? ser1[0] - ser2[0] : ser1[1] - ser2[1]));
// // 当前工作的服务器队列，按结束工作的时间点排列
//             PriorityQueue<int[]> work = new PriorityQueue<int[]>((ser1, ser2) -> (ser1[2] - ser2[2]));
//             for (int i = 0; i < n; i++) free.offer(s[i]);
//             int[] ans = new int[m];      // 答案数组
//             int t = 0;              // 当前时刻
//             for (int i = 0; i < m; i++) {// 依次处理各任务
//                 if (free.isEmpty())      // 当前无服务器空闲，时间点直接跳到最早完成工作的服务器开始空闲的时刻
//                     t = work.peek()[2];
//                 t = Math.max(t, i);      // 时间点小于i则直接跳到i, 开启第i个任务
//                 while (!work.isEmpty() && work.peek()[2] <= t) {// 将当前已完成工作的服务器加入空闲队列
//                     free.offer(work.poll());
//                 }
//                 int[] ser = free.poll();// 从空闲队列选择优先级最高的服务器
//                 ser[2] = t + tasks[i];  // 记录该服务器结束工作的时间
//                 ans[i] = ser[1];
//                 work.offer(ser);        // 加入工作队列
//             }
//             return ans;
//         }


        // public int[] minInterval(int[][] intervals, int[] queries) {
        //     Arrays.sort(intervals, (a, b)-> (a[0] != b[0] ? a[0]-b[0] : a[1]-b[1])); // left, right increasing
        //     Queue<int []> q = new PriorityQueue<>((a, b)->(a[1]-a[0]-(b[1]-b[0]))); // size increasing
        //     Map<Integer, List<Integer>> map = new HashMap<>();
        //     for (int i = 0; i < queries.length; i++) 
        //         map.computeIfAbsent(queries[i], k->new ArrayList<>()).add(i);
        //     Map<Integer, List<Integer>> m = map.entrySet().stream()
        //         .sorted(Map.Entry.comparingByKey()) // Comparator.reverseOrder()
        //         .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
        //     int n = intervals.length;
        //     int [] ans = new int[queries.length];
        //     int k = 0, i = 0, j = 0;
        //     List<Integer> v = new ArrayList<>();
        //     for (Map.Entry<Integer, List<Integer>> en : m.entrySet()) {
        //         k = en.getKey();
        //         v = en.getValue(); // idx
        //         while (i < n && intervals[i][0] <= k) {
        //             q.offer(intervals[i]);
        //             i++;
        //         }
        //         while (!q.isEmpty() && (q.peek()[0] > k || q.peek()[1] < k)) q.poll();
        //         if (!q.isEmpty()) {
        //             int [] cur = q.peek();
        //             for (Integer idx : v) 
        //                 ans[idx] = cur[1] - cur[0] + 1;
        //         } else
        //             for (Integer idx : v) ans[idx] = -1;
        //     }
        //     return ans;
        // }
        // public int[] minInterval(int[][] intervals, int[] queries) {
        //     Arrays.sort(intervals, (a, b)-> (a[0] != b[0] ? a[0]-b[0] : a[1]-b[1])); // left, right increasing
        //     int [][] qy = new int [queries.length][];
        //     for (int i = 0; i < queries.length; i++) 
        //         qy[i] = new int [] {queries[i], i};
        //     Arrays.sort(qy, (a, b)->a[0]-b[0]); // increasing
        //     int [] ans = new int[queries.length];
        //     Arrays.fill(ans, -1);
        //     Queue<int []> q = new PriorityQueue<>((a, b)->(a[1]-a[0]-(b[1]-b[0]))); // size increasing
        //     int idx = 0;
        //     for (int i = 0; i < queries.length; i++) {
        //         while (idx < intervals.length && intervals[idx][0] <= qy[i][0]) {
        //             q.offer(intervals[idx]);
        //             idx++;
        //         }
        //         while (!q.isEmpty() && q.peek()[1] < qy[i][0]) q.poll();
        //         if (!q.isEmpty()) {
        //             int [] cur = q.peek();
        //             ans[qy[i][1]] = cur[1] - cur[0] + 1;
        //         }
        //     }
        //     return ans;
        // }


        // public int[] kthSmallestPrimeFraction(int [] arr, int k) {
        //     int n = arr.length;
        //     Queue<int []> q = new PriorityQueue<>((a, b)->Double.compare(((double)a[0]/(double)a[1]), (double)b[0]/((double)b[1])));
        //     for (int i = 0; i < n; i++) 
        //         for (int j = i+1; j < n; j++) 
        //             q.offer(new int [] {arr[i], arr[j]});
        //     int [] cur = null;
        //     while (k > 1) {
        //         cur = q.poll();
        //         System.out.println(Arrays.toString(cur));
        //         k--;
        //     }
        //     cur = q.poll();
        //     // System.out.println(Arrays.toString(cur));
        //     return cur;
        // }


        // public int trapRainWater(int[][] heightMap) {
        //     int m = heightMap.length;
        //     int n = heightMap[0].length;
        //     boolean [][] vis = new boolean [m][n];
        //     Queue<int []> q = new PriorityQueue<>((a, b)->a[2] - b[2]);
        //     for (int i = 0; i < n; i++) {
        //         q.offer(new int [] {0, i, heightMap[0][i]});
        //         q.offer(new int [] {m-1, i, heightMap[m-1][i]});
        //         vis[0][i] = true;
        //         vis[m-1][i] = true;
        //     }
        //     for (int i = 1; i < m-1; i++) {
        //         q.offer(new int [] {i, 0, heightMap[i][0]});
        //         q.offer(new int [] {i, n-1, heightMap[i][n-1]});
        //         vis[i][0] = true;
        //         vis[i][n-1] = true;
        //     }
        //     int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        //     int [] cur = null;
        //     int i, j, max = 0, ans = 0;
        //     while (!q.isEmpty()) {
        //         cur = q.poll();
        //         max = Math.max(max, cur[2]);
        //         for (int [] d : dirs) {
        //             i = cur[0] + d[0];
        //             j = cur[1] + d[1];
        //             if (i < 0 || i >= m || j < 0 || j >= n || vis[i][j]) continue; 
        //             vis[i][j] = true;
        //             if (heightMap[i][j] < max) 
        //                 ans += max - heightMap[i][j];
        //             q.offer(new int [] {i, j, heightMap[i][j]});
        //         }
        //     }
        //     return ans;
        // }


        // public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        //     Queue<int []> q = new PriorityQueue<>((a, b)->(a[0] != b[0] ? a[0]-b[0] : b[1]-a[1]));
        //     int n = s.length, ans = 0, max = 0;
        //     for (int i = 0; i < n; i++) 
        //         q.offer(new int [] {capital[i], profits[i]});
        //     while (!q.isEmpty() && w >= q.peek()[0]) { // 遍历
        //         max = q.poll()[1];
        //     }
        // }


        // public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        //     int mod = (int)1e9 + 7;
        //     int [][] eng = new int [n][2];
        //     for (int i = 0; i < n; i++) {
        //         eng[i][0] = speed[i];
        //         eng[i][1] = efficiency[i];
        //     }
        //     Arrays.sort(eng, (a, b)->(b[1] - a[1]));
        //     long res = 0, sum = 0, max = 0;
        //     int idx = 0;
        //     Queue<int []> q = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        //     while (q.size() < k) {
        //         q.offer(eng[idx]);
        //         sum += (long)eng[idx][0];
        //         max = Math.max(max, sum * eng[idx++][1]);
        //     }
        //     while (idx < n) {
        //         sum -= (long)q.poll()[0];
        //         q.offer(eng[idx]);
        //         sum += (long)eng[idx][0];
        //         max = Math.max(max, sum * eng[idx++][1]);
        //     }
        //     return (int)(max % mod);
        // }


        // public List<Integer> busiestServers(int k, int [] arrival, int[] load) {
        //     int n = arrival.length;
        //     TreeSet<Integer> ts = new TreeSet<>();
        //     for (int i = 0; i < k; i++) 
        //         ts.add(i);
        //     int [] cnt = new int [k];
        //     Queue<int []> q = new PriorityQueue<>((a, b)->(a[1]+a[2]-(b[1]+b[2])));
        //     int [] sv = null, cur = null;
        //     int  t = 0;
        //     for (int i = 0; i < n; i++) {
        //         t = Math.max(t, arrival[i]);
        //         if (i < k) {
        //             ts.remove(i);
        //             cnt[i]++;
        //             q.offer(new int [] {i, t, load[i]}); // serverIdx, arrival, processTime
        //             continue;
        //         }
        //         while (q.size() > 0 && q.peek()[1] + q.peek()[2] <= t) {
        //             cur = q.poll();
        //             ts.add(cur[0]);
        //         }
        //         if (ts.size() == 0 && q.peek()[1] + q.peek()[2] > t) continue;
        //         Integer higher = ts.ceiling(i % k);
        //         if (higher != null) {
        //             ts.remove(higher);
        //             cnt[higher]++;
        //             q.offer(new int [] {higher,  arrival[i], load[i]}); // arrival, processTime
        //         } else {
        //             higher = ts.ceiling(0);
        //             if (higher != null) {
        //                 ts.remove(higher);
        //                 cnt[higher]++;
        //                 q.offer(new int [] {higher,  arrival[i], load[i]}); // arrival, processTime
        //             }
        //         }
        //     }
        //     int max = Arrays.stream(cnt).max().getAsInt();
        //     List<Integer> res = new ArrayList<>();
        //     for (int i = 0; i < k; i++) 
        //         if (cnt[i] == max) res.add(i);
        //     return res;
        // }


        // public boolean isPossible(int[] arr) {
        //     if (arr.length == 1) return arr[0] == 1;
        //     long sum = 0;
        //     Queue<Integer> q = new PriorityQueue<>((a, b)-> b-a);
        //     for (int v : arr) {
        //         q.offer(v);
        //         sum += v;
        //     }
        //     int max = 0;
        //     while (q.peek() != 1) {
        //         max = q.poll();
        //         if (max <= sum - max) return false;
        //         int pre = (int)(max % (int)(sum - max));
        //         // int pre = max - (int)(sum - max); // max的前身可能经历了万水千山的重复
        //         // 如果前身是0时(max与rest余数为0)。
        //         // 说明max的前身与剩余数字和相同。
        //         // 如果剩余数字和是为1，说明前身也是1，返回true
        //         if (pre == 0) return sum - max == 1;
        //         // sum -= (sum - max);
        //         sum -= (max - pre);
        //         q.offer(pre);
        //     }
        //     return true;
        // }


        // private boolean couldGetTarget(int [] arr, int t, int v) {
        //     int cnt = 0;
        //     long sum = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (arr[i] > v) {
        //             sum += arr[i]-v;
        //             ++cnt;
        //         } else if (arr[i] == v) ++cnt;
        //     }
        //     return sum >= t || sum < t && sum + cnt >= t;
        // }
        // private int binarySearch(int [] arr, int t, int l, int h) {
        //     if (l == h) return couldGetTarget(arr, t, l) ? l : -1;
        //     if (l == h-1) return couldGetTarget(arr, t, h) ? h : (couldGetTarget(arr, t, l) ? l : -1);
        //     int m = l + (h-l)/2;
        //     if (couldGetTarget(arr, t, m)) return binarySearch(arr, t, m, h);
        //     return binarySearch(arr, t, l, m-1);
        // }
        // int mod = (int)1e9 + 7, n;
        // public int maxProfit(int[] inventory, int orders) {  // bug bug bug
        //     n = inventory.length;
        //     long res = 0;
        //     if (n == 1) {
        //         if (orders >= inventory[0]) {
        //             res = (int)(((inventory[0]+1)*inventory[0]) % mod /2 );
        //             return (int)res;
        //         }
        //         return (int)((inventory[0]*(inventory[0]+1) % mod /2 - (inventory[0]-orders)*(inventory[0]-orders+1) % mod /2) % mod);
        //     }
        //     Arrays.sort(inventory);
        //     int min = Arrays.stream(inventory).min().getAsInt();
        //     int max = Arrays.stream(inventory).max().getAsInt();
        //     long sum = 0;
        //     for (int v : inventory) sum += v;
        //     int cnt = 0;
        //     if (orders == (int)sum) {
        //         sum = 0;
        //         for (int i = 0; i < n; i++) 
        //             sum += ((long)(inventory[i]*(inventory[i]+1))) % mod /2;
        //     } else if (orders < sum && orders > sum-min) min -= sum-orders;
        //     int k = binarySearch(inventory, orders, 0, max);
        //     for (int i = 0; i < n; i++) {
        //         if (inventory[i] > k) {
        //             res += ((long)((inventory[i]+k+1)*(inventory[i]-k)) % mod + mod) % mod / 2l;
        //             cnt += inventory[i]-k;
        //         }
        //     }
        //     res = (res + (cnt < orders ? (orders - cnt) * k : 0)) % mod;
        //     return (int)res;
        // }
        // public int maxProfit(int[] inventory, int orders) { // bug bug bug
        //     Arrays.sort(inventory);
        //     int mod = (int)1e9 + 7, n = inventory.length, i = 0;
        //     long res = 0;
        //     while (orders > 0) {
        //         while (i < n && inventory[i] >= inventory[0]) i++; // [0, j) 范围内的颜色的球数 == MAX
        //         int next = 0;
        //         if (i < n) next = inventory[i]; // 可从MAX一直卖到next + 1
        //         long bucks = i, delta = inventory[0] - next;
        //         long rem = bucks * delta;  // 可卖的次数
        //         if (rem > orders) {
        //             int del = (int)(orders / bucks); // 每种球可卖的次数
        //             long a = inventory[0], b = a - del + 1;
        //             res += ((a + b) * del / 2) * bucks;
        //             res += (inventory[0] - del) * (orders % bucks);
        //         } else {
        //             long a = inventory[0], b = next + 1;
        //             res += ((a + b) * delta / 2) * bucks;
        //             inventory [0] = next;
        //         }
        //         orders -= rem;
        //         res %= mod;
        //     }
        //     return (int)res;
        // }
        // private boolean valid(int [] arr, int v, int orders) {
        //     for (int cur : arr) {
        //         if (cur > v) orders -= (cur - v);
        //         if (orders < 0) return false;
        //     }
        //     return orders >= 0;
        // }
        // public int maxProfit(int[] inventory, int orders) {
        //     int mod = (int)1e9 + 7;
        //     int l = 0, r = Arrays.stream(inventory).max().getAsInt();
        //     while (l <= r) {
        //         int m = l + (r-l)/2;
        //         if (valid(inventory, m, orders)) r = m-1;
        //         else l = m+1;
        //     } // 返回边界l
        //     long ans = 0;
        //     for (int v : inventory) {
        //         if (v > l) {
        //             long one = v, two = l +1, n = v - l;
        //             ans += ((one + two) * n / 2) % mod;
        //             orders -= n;
        //         }
        //     }
        //     if (orders > 0) ans += l * orders;
        //     ans %= mod;
        //     return (int)ans;
        // }

        
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        // int []  a = new int []  {2, 8, 4, 10, 6};
        int []  a = new int []  {565259708, 715164401, 716563713, 958255469, 844600740, 823949511, 180479359, 287829385, 164248818, 73361150, 230686692, 322986846, 598720034, 338241127, 748922260, 181241085, 833659853, 509571179, 250093451, 690995620, 703292727, 595636202};

        int r = s.maxProfit(a, 650114768); 
        System.out.println("r: " + r);

    }
}