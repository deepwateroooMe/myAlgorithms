import com.TreeNode;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.Map.Entry;
import java.math.BigInteger;
import java.util.stream.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;
public class dpnine {
    public static class Solution {
        // public String findTheString(int[][] a) { // 53/55: 自已写的: 不知道这里哪里写错了。。
        //     int n = a.length, i = 0;
        //     char [] s = new char [n];
        //     char c = 'a';
        //     boolean toIncrease = false;
        //     while (i < n && c -'a' <= 25) { // 这里，可以理解为，填充第 i 行
        //         toIncrease = false;
        //         for (int j = i; j < n; j++) 
        //             if (a[i][j] > 0 && s[j] == 0) {
        //                 toIncrease = true;
        //                 s[j] = c;
        //             }
        //         if (toIncrease)
        //             c++;
        //         i++;
        //     }
        //     if (c - 'a' > 25 || i < n) return "";
        //     // 构建现在字符串的 LCP, 与原 LCP 进行比较 
        //     int [][] f = new int [n][n];
        //     for ( i = n-1; i >= 0; i--) 
        //         f[i][i] = n-i; // 对角线
        //     for ( i = n-2; i >= 0; i--) 
        //         for (int j = i+1; j <= n-1; j++) 
        //             if (s[i] == s[j]) {
        //                 f[i][j] = (j == n-1 ? 0 : f[i+1][j+1]) + 1;
        //                 f[j][i] = f[i][j];
        //             }
        //     for ( i = 0; i < n; i++)
        //         for (int j = 0; j < n; j++)
        //             if (f[i][j] != a[i][j]) return "";
        //     return new String(s);
        // }
        // public String findTheString(int[][] a) { // 53/55
        //     int n = a.length, i = 0;
        //     char [] s = new char [n];
        //     for (char c = 'a'; c <= 'z'; c++) {
        //         while (i < n && s[i] > 0) ++i;
        //         if (i == n) break; // 构造完毕
        //         for (int j = i; j < n; j++) 
        //             if (a[i][j] > 0) s[j] = c;
        //     }
        //     while (i < n) if (s[i++] == 0) return ""; // 没有构造完
        //     // 直接在原数组上验证
        //     for ( i = n-1; i >= 0; i--)
        //         for (int j = n-1; j >= 0; j--) {
        //             int curLCP = s[i] != s[j] ? 0 : (i == n-1 || j == n-1 ? 1 : a[i+1][j+1] + 1);
        //             if (curLCP != a[i][j]) return "";
        //         }
        //     return new String(s);
        // }

        // public String largestMultipleOfThree(int[] a) { // 改天再写。。。
        //     int n = a.length;
        //     // 【降序排列：】要写三行，谁写？先前有个方法降序排列，找出来。。。
        //     for (int i = 0; i < n; i++) a[i] *= -1;
        //     Arrays.sort(a);
        //     for (int i = 0; i < n; i++) a[i] *= -1;
        //     if (a[0] == 0) return "0";
        //     System.out.println(Arrays.toString(a));
        //     for (int v : a) v *= -1;
        //     // 【动规：】先找最长序列长度. 因为这里参入了 0, 不能再初始化为 0
        //     int [][] f = new int [n][3];
        //     Arrays.stream(f).forEach(z -> Arrays.fill(z, -1));
        //     f[0][a[0] % 3] = 1;
        //     for (int i = 1; i < n; i++) {
        //         int j = a[i] % 3;
        //         // 先更新当前下标可能引起的
        //         for (int k = 0; k < 3; k++) 
        //             if (f[i-1][k] != -1)
        //                 f[i][(k+j)%3] = Math.max(f[i][(k+j)%3], Math.max(f[i-1][k] + 1, f[i-1][(k+j)%3]));
        //         for (int k = 0; k < 3; k++)
        //             if (f[i][k] == -1)
        //                 f[i][k] = f[i-1][k];
        //         f[i][j] = Math.max(f[i][j], 1);
        //     }
        //     System.out.println("f.length: " + f.length);
        //     for (int z = 0; z < f.length; ++z) 
        //         System.out.println(Arrays.toString(f[z]));
        //     // 【根据动规】结果，往回倒，构建字符串
        //     StringBuilder s = new StringBuilder("");
        //     int i = n-1, cur = 0;
        //     while (i >= 0 && a[i] == 0) { // 先把所有的 0 贴上
        //         s.append('0');
        //         i--;
        //     }
        //     if (i > 0 && f[i][cur] == f[i-1][cur]) --i;
        //     System.out.println("i: " + i);
        //     for (; i > 0; i--) {
        //          System.out.println("\n i: " + i);
        //          System.out.println("cur: " + cur);
        //         for (int j = 0; j < 3; j++) {
        //             int k = a[i] % 3;
        //             if ((j + k) % 3 == cur && (i == 1 && f[i-1][j] == -1 && cur != 0 ? 0 : f[i-1][j]) + 1 == f[i][cur]) {
        //                 s.append(a[i]);
        //                 cur = j;
        //                 break;
        //             }
        //         }
        //          System.out.println("s.toString(): " + s.toString());
        //     }
        //     System.out.println("cur: " + cur);
        //     if (a[0] % 3 == cur)
        //         s.append(a[0]);
        //     return new String(s.reverse());
        // }

        // // 【记忆化深搜：】深深惊讶，我这两天把记忆化深搜写得像 1+1=2 一样简单。。。。。
        // // Queue<Integer> q = new PriorityQueue<>(); 感觉确实能再快一点儿
        // public int minimumVisitedCells(int[][] a) { // 记忆化深搜： TLE 1028/1069 动态规划，应该也会超时
        //     m = a.length; n = a[0].length; this.a = a;
        //     f = new Integer [m][n];
        //     Arrays.stream(f).forEach(z -> Arrays.fill(z, Integer.MAX_VALUE / 2));
        //     int r = dfs(0, 0);
        //     return r == Integer.MAX_VALUE / 2 ? -1 : r;
        // }
        // Integer [][] f;
        // int [][] a;
        // int m, n;
        // int dfs(int i, int j) { // 记忆化揵从当前坐标到终点的最小步数
        //     if (i == m-1 && j == n-1) return f[i][j] = 1;
        //     if (f[i][j] != Integer.MAX_VALUE / 2) return f[i][j];
        //     if (a[i][j] == 0) return f[i][j] = Integer.MAX_VALUE / 2;
        //     int r = Integer.MAX_VALUE / 2;
        //     // if (j < n-1)
        //     //     r = Math.min(r, 1 + dfs(i, Math.min(j + a[i][j], n-1)));
        //     for (int y = Math.min(j + a[i][j], n-1); y > j; y--) 
        //         // if (a[i][j] != 0) {
        //             r = Math.min(r, 1 + dfs(i, y));
        //         //     break; // 这里断掉了，可是如果它到【m-1,n-1】走不通，不是该继续遍历吗？
        //         // }
        //     for (int x = Math.min(m-1, a[i][j] + i); x > i; x--)
        //         // if (a[i][j] != 0) {
        //             r = Math.min(r, 1 + dfs(x, j));
        //         //     break;
        //         // }
        //     // if (i < m-1)
        //     //     r = Math.min(r, 1 + dfs(Math.min(m-1, i + a[i][j]), j));
        //     return f[i][j] = r;
        // }
        // public int minimumVisitedCells(int[][] a) { // 【动规：】自底向上的动规
        //     int m = a.length, n = a[0].length, mn = 0;
        //     List<int []> [] colSt = new ArrayList [n]; // 每列的单调栈
        //     Arrays.setAll(colSt, z -> new ArrayList<>());
        //     for (int i = m-1; i >= 0; i--) {
        //         List<int []> s = new ArrayList<>(); // 当前行的单调栈
        //         for (int j = n-1; j >= 0; j--) {
        //             var st = colSt[j];
        //             mn = Integer.MAX_VALUE;
        //             int g = a[i][j];
        //             if (i == m-1 && j == n-1) mn = 0; // 特殊情况：已经是终点
        //             else if (g > 0) { // 在单调栈上二分
        //                 int k = search(s, j + g);
        //                 if (k < s.size()) mn = Math.min(mn, s.get(k)[0]);
        //                 k = search(st, i + g);
        //                 if (k < st.size()) mn = Math.min(mn, st.get(k)[0]);
        //             }
        //             if (mn == Integer.MAX_VALUE) continue;
        //             ++mn; // 加上 (i,j) 这个格子
        //             // 插入单调栈
        //             while (!s.isEmpty() && mn <= s.get(s.size()-1)[0])
        //                 s.remove(s.size()-1);
        //             s.add(new int [] {mn, j});
        //             while (!st.isEmpty() && mn <= st.get(st.size()-1)[0])
        //                 st.remove(st.size()-1);
        //             st.add(new int [] {mn, i});
        //         }
        //     }
        //     return mn < Integer.MAX_VALUE ? mn : -1;
        // }        
        // int search(List<int []> li, int v) {
        //     int l = -1, r = li.size(); // 开区间 (left, right)
        //     while (l + 1 < r) { // 区间不为空
        //         int m = l + (r - l) / 2;
        //         if (li.get(m)[1] > v) l = m;  // 范围缩小到 (mid, right)
        //         else r = m; // 范围缩小到 (left, mid)
        //     }
        //     return r;
        // }
        // public int minimumVisitedCells(int[][] a) { 
        //     int m = a.length, n = a[0].length, r = Integer.MAX_VALUE;
        //     if (m == 1 & n == 1) return 1;
        //     // int [][] f = new int [m][n]; // 因为用了栈，结果全都保存在了栈上，所以不再需要使用数组了
        //     // Arrays.stream(f).forEach(z -> Arrays.fill(z, Integer.MAX_VALUE / 2));
        //     // 【动规：】自底向上，为的是保证想要取用先前遍历过的结果的时候，子问题是解决好了，结果可以拿来使用的
        //     // 本质：这里带一点儿贪心，永远是一步可以跳得最远的，跳的步数最少？
        //     // 【二分查找】：需要二分查找，是因为并非每个格可达，所以会有顺序错乱？
        //     List<int []> [] colSt = new ArrayList [n]; // 【每列栈】：为每列分配一个栈，用链表模拟栈，方便二分查找【O(NlogN)】
        //     Arrays.setAll(colSt, z -> new ArrayList<>());
        //     for (int i = m-1; i >= 0; i--) { // 【自底向上】的动规：倒序遍历
        //         List<int []> s = new ArrayList<>(); // 【每行栈】：每一行求结果的使用
        //         for (int j = n-1; j >= 0; j--) {
        //             List<int []> st = colSt[j];
        //             int g = a[i][j], k = -1;
        //             r = Integer.MAX_VALUE;
        //             if (i == m-1 && j == n-1) r = 0;
        //             else if (g > 0) {
        //                 k = binarySearch(j+g, s); // 可以往右跳
        //                 if (k != s.size()) r = Math.min(r, s.get(k)[0]);
        //                 k = binarySearch(i+g, st); // 可以往下跳
        //                 if (k != st.size()) r = Math.min(r, st.get(k)[0]);
        //             }
        //             if (r == Integer.MAX_VALUE) continue; // 此路不通，就可以不用入栈添加麻烦了
        //             ++r; // 【更新当前下标入栈】
        //             while (!s.isEmpty() && r <= s.get(s.size()-1)[0]) s.remove(s.size()-1);
        //             s.add(new int [] {r, j});
        //             while (!st.isEmpty() && r <= st.get(st.size()-1)[0]) st.remove(st.size()-1);
        //             st.add(new int [] {r, i});
        //         }
        //     }
        //     return r == Integer.MAX_VALUE ? -1 : r;
        // }
        // int binarySearch(int v, List<int []> li) { // 二分查找右端点：【单调递减链表】
        //     int l = -1, r = li.size(); // 开区间的写法：（l,r）左右均为开，开区间
        //     while (l + 1 < r) { // 开区间（l,r）中至少有一个元素【l+1】
        //         int m = l + (r - l) / 2;
        //         if (li.get(m)[1] > v) l = m;
        //         else r = m;
        //     }
        //     return r; // 返回的是：右端点？【单调递减链表】
        // }

        // public int catMouseGame(int[][] g) { // TLE TLE TLE: 56/92
        //     n = g.length; this.g = g;
        // 因为这里平局时要数这么多遍，比较浪费时间。下面这行
        //     f = new Integer [n][n][2*n*(n-1)]; // 这里，猫和老鼠各有 n 种【猫： n-1 种】不同走法，所以要数对了
        //     return dfs(1, 2, 0);
        // }
        // Integer [][][] f;
        // int [][] g;
        // int n; 
        // int dfs(int i, int j, int k) {
        //     if (k == 2 * n * (n-1)) return 0;
        //     if (i == j) return f[i][j][k] = 2; // 同一位置：猫赢
        //     if (i == 0) return f[i][j][k] = 1; // 老鼠：能够先进洞房...
        //     if (f[i][j][k] != null) return f[i][j][k];
        //     if (k % 2 == 0) { // 老鼠: 优先找，小老鼠可以赢的策略；小老鼠如果一定赢不了，那就只能退而求其次，看小老鼠可以平局吗？实在再不行，才算猫赢。。
        //         boolean catWin = true;
        //         for (int v : g[i]) {
        //             if (v == j) continue;  // 这里是直接：避开猫，是不算猫赢吗？
        //             int val = dfs(v, j, k+1);
        //             if (val == 1) return f[i][j][k] = 1;
        //             else if (val == 0) catWin = false;
        //         }
        //         return f[i][j][k] = (catWin ? 2 : 0);
        //     } else { // 猫
        //         boolean mouseWin = true;
        //         for (int v : g[j]) {
        //             if (v == 0) continue; // 猫：不许进老鼠房间...
        //             int val = dfs(i, v, k+1);
        //             if (val == 2) return f[i][j][k] = 2;
        //             else if (val == 0) mouseWin = false;
        //         }
        //         return f[i][j][k] = (mouseWin ? 1 : 0);
        //     }
        // }
        // static final int MOUSE_WIN = 1;
        // static final int CAT_WIN = 2;
        // static final int DRAW = 0;
        // int n;
        // int[][] graph;
        // int[][][] f;
        // public int catMouseGame(int[][] graph) {
        //     this.n = graph.length;
        //     this.graph = graph;
        //     this.f = new int[n][n][2 * n * (n - 1)];
        //     for (int i = 0; i < n; i++) 
        //         for (int j = 0; j < n; j++) 
        //             Arrays.fill(f[i][j], -1);
        //     return getResult(1, 2, 0);
        // }
        // public int getResult(int mouse, int cat, int turns) {
        //     if (turns == 2 * n * (n - 1)) return DRAW;
        //     if (f[mouse][cat][turns] < 0) {
        //         if (mouse == 0) 
        //             f[mouse][cat][turns] = MOUSE_WIN;
        //         else if (cat == mouse) 
        //             f[mouse][cat][turns] = CAT_WIN;
        //         else 
        //             getNextResult(mouse, cat, turns);
        //     }
        //     return f[mouse][cat][turns];
        // }
        // public void getNextResult(int mouse, int cat, int turns) { // 它说，这是【自顶向下】的动规实现。。
        //     int curMove = turns % 2 == 0 ? mouse : cat;
        //     int defaultResult = curMove == mouse ? CAT_WIN : MOUSE_WIN;
        //     int result = defaultResult;
        //     int[] nextNodes = graph[curMove];
        //     for (int next : nextNodes) {
        //         if (curMove == cat && next == 0) continue; // 猫：不可以进老鼠洞
        //         int nextMouse = curMove == mouse ? next : mouse;
        //         int nextCat = curMove == cat ? next : cat;
        //         int nextResult = getResult(nextMouse, nextCat, turns + 1);
        //         if (nextResult != defaultResult) {
        //             result = nextResult;
        //             if (result != DRAW) break;
        //         }
        //     }
        //     f[mouse][cat][turns] = result;
        // }
        // // 【拓朴排序法】：【O（N^3）】这个题目。。。
        // static final int MOUSE_TURN = 0, CAT_TURN = 1;
        // static final int DRAW = 0, MOUSE_WIN = 1, CAT_WIN = 2;
        // public int catMouseGame(int[][] g) { // 
        //     n = g.length; this.g = g;
        //     // 因为上面平局时要数这么多遍，比较浪费时间，所以会超时。这里它说，用拓朴排序，从可能的结果推断必胜必败状态，从而消除对平局无数次数的判断，来减少时间复杂度
        //     f = new int [n][n][2]; // 【默认结果：】平局 0
        //     r = new int [n][n][2]; // 入度
        //     Deque<int []> q = new ArrayDeque<>();
        //     // 【统计入度】
        //     for (int i = 0; i < n; i++)
        //         for (int j = 1; j < n; j++) { // <<<<<<<<<<<<<<<<<<<< 
        //             r[i][j][MOUSE_TURN] = g[i].length;
        //             r[i][j][CAT_TURN] = g[j].length;
        //         }
        //     // 【校正入度错误】：猫不能进老鼠洞。拓朴排序由当前状态推前一个状态，所以猫不能进老鼠洞是由 g【0】的后续结果来推：猫不能走 g[0]
        //     for (int v : g[0])
        //         for (int i = 0; i < n; i++)
        //             r[i][v][CAT_TURN]--;
        //     // 【拓朴排序：】由当前可知确认状态【必赢 || 必输】，如老鼠进洞，或是猫老鼠相撞，来推各种前导状态。。
        //     for (int j = 1; j < n; j++) { // 【老鼠进洞】：老鼠赢
        //         f[0][j][MOUSE_TURN] = MOUSE_WIN;
        //         f[0][j][CAT_TURN] = MOUSE_WIN;
        //         q.offer(new int [] {0, j, MOUSE_TURN});
        //         q.offer(new int [] {0, j, CAT_TURN});
        //     }
        //     for (int i = 1; i < n; i++) { // 猫、老鼠相撞：猫赢
        //         f[i][i][MOUSE_TURN] = CAT_WIN;
        //         f[i][i][CAT_TURN] = CAT_WIN;
        //         q.offer(new int [] {i, i, MOUSE_TURN});
        //         q.offer(new int [] {i, i, CAT_TURN});
        //     }
        //     while (!q.isEmpty()) {
        //         int [] cur = q.poll();
        //         int i = cur[0], j = cur[1], k = cur[2], res = f[i][j][k];
        //         List<int []> p = getPrevStates(i, j, k); // previous states
        //         for (int [] prevState : p) {
        //             int pi = prevState[0], pj = prevState[1], pk = prevState[2];
        //             if (f[pi][pj][pk] == DRAW) { // 如果上一个状态是平局，是默认结果
        //                 boolean canWin = (res == MOUSE_WIN && pk == MOUSE_TURN || res == CAT_WIN && pk == CAT_TURN);
        //                 if (canWin) { // 来了，新的上一轮的，可确认的结果，入队列
        //                     f[pi][pj][pk] = res;
        //                     q.offer(new int [] {pi, pj, pk});
        //                 } else {
        //                     r[pi][pj][pk]--;
        //                     if (r[pi][pj][pk] == 0) {
        //                         int loseResult = pk == MOUSE_TURN ? CAT_WIN : MOUSE_WIN;
        //                         f[pi][pj][pk] = loseResult;
        //                         q.offer(new int [] {pi, pj, pk});
        //                     }
        //                 }
        //             }
        //         }
        //     }
        //     return f[1][2][MOUSE_TURN];
        // }
        // int [][][] r, f;
        // int [][] g;
        // int n; 
        // List<int []> getPrevStates(int i, int j, int k) { // int mouse, int cat, int turn i j k 
        //     List<int []> p = new ArrayList<>();
        //     int prevTurn = k == MOUSE_TURN ? CAT_TURN : MOUSE_TURN;
        //     if (prevTurn == MOUSE_TURN) {
        //         for (int prev : g[i]) 
        //             p.add(new int [] {prev, j, prevTurn});
        //     } else {
        //         for (int prev : g[j])
        //             if (prev != 0) // <<<<<<<<<<<<<<<<<<<< 
        //                 p.add(new int [] {i, prev, prevTurn});
        //     }
        //     return p;
        // }

        // public boolean canMouseWin(String[] a, int catLen, int mouseLen) { // 为什么之前，这个题总是不过？没弄明白，之前为什么不过？
        //     this.catLen = catLen; this.mouseLen = mouseLen; m = a.length; n = a[0].length(); N = m * n;
        //     s = new char [m][n];
        //     for (int i = 0; i < m; i++) s[i] = a[i].toCharArray();
        //     f = new Boolean [N][N][2 * n * (n-1)];
        //     // f = new Boolean [N][N][1000];
        //     int mi = 0, mj = 0, ci = 0, cj = 0, fi = 0, fj = 0;
        //     for (int i = 0; i < m; i++)
        //         for (int j = 0; j < n; j++)
        //             if (s[i][j] == 'C') {
        //                 ci = i; cj = j;
        //             } else if (s[i][j] == 'M') {
        //                 mi = i; mj = j;
        //             } else if (s[i][j] == 'F') {
        //                 fi = i; fj = j;
        //             }
        //     fd = fi * n + fj;
        //     return dfs(mi * n + mj, ci * n + cj, 0);
        // }
        // Boolean [][][] f;
        // int m, n, fd, N, mouseLen, catLen;
        // char [][] s;
        // boolean dfs(int ii, int jj, int k) {
        //     boolean mouseTurn = (k % 2 == 0);
        //     int len = (mouseTurn ? mouseLen : catLen);
        //     int i = 0, j = 0;
        //     if (mouseTurn) { i = ii / n; j = ii % n; }
        //     else { i = jj / n; j = jj % n; }
        //     // if (k == 1000) return !mouseTurn;  // <<<<<<<<<<<<<<<<<<<< 
        //     if (k == 2 * n * (n-1)) return !mouseTurn;
        //     if (f[ii][jj][k] != null) return f[ii][jj][k];
        //     if (ii == jj) return f[ii][jj][k] = false;
        //     if (s[i][j] == 'F') return f[ii][jj][k] = mouseTurn;
        //     for (int x = j-1; x >= Math.max(0, j - len); x--) { // 向左
        //         if (s[i][x] == '#') break;
        //         if (i * n + x == fd) return f[ii][jj][k] = mouseTurn;
        //         if (mouseTurn && i * n + x == jj) continue; // 这就是从猫头上跳过了呀。。。
        //         else if (!mouseTurn && i * n + x == ii) return f[ii][jj][k] = false;
        //         if (mouseTurn && dfs(i * n + x, jj, k+1) || !mouseTurn && !dfs(ii, i * n + x, k+1)) return f[ii][jj][k] = mouseTurn;
        //     }
        //     for (int x = j+1; x <= Math.min(n-1, j + len); x++) { // 向右
        //         if (s[i][x] == '#') break;
        //         if (i * n + x == fd) return f[ii][jj][k] = mouseTurn; 
        //         if (mouseTurn && i * n + x == jj) continue;
        //         else if (!mouseTurn && i * n + x == ii) return f[ii][jj][k] = false;
        //         if (mouseTurn && dfs(i * n + x, jj, k+1) || !mouseTurn && !dfs(ii, i * n + x, k+1)) return f[ii][jj][k] = mouseTurn;
        //     }
        //     for (int x = i-1; x >= Math.max(0, i - len); x--) { // 向上
        //         if (s[x][j] == '#') break;
        //         if (x * n + j == fd) return f[ii][jj][k] = mouseTurn;
        //         if (mouseTurn && x * n + j == jj) continue;
        //         else if (!mouseTurn && x * n + j == ii) return f[ii][jj][k] = false;
        //         if (mouseTurn && dfs(x * n + j, jj, k+1) || !mouseTurn && !dfs(ii, x * n + j, k+1)) return f[ii][jj][k] = mouseTurn;
        //     }
        //     for (int x = i+1; x <= Math.min(m-1, i + len); x++) { // 向下
        //         if (s[x][j] == '#') break;
        //         if (x * n + j == fd) return f[ii][jj][k] = mouseTurn;
        //         if (mouseTurn && x * n + j == jj) continue;
        //         else if (!mouseTurn && x * n + j == ii) return f[ii][jj][k] = false;
        //         if (mouseTurn && dfs(x * n + j, jj, k+1) || !mouseTurn && !dfs(ii, x * n + j, k+1)) return f[ii][jj][k] = mouseTurn;
        //     }
        //     if (mouseTurn && dfs(ii, jj, k+1) || !mouseTurn && !(dfs(ii, jj, k+1))) // 【原地不动】
        //         return f[ii][jj][k] = mouseTurn;
        //     return f[ii][jj][k] = !mouseTurn;
        // }
        // // 【拓朴排序法】：【O（N^3）】这个题目。。。
        // static final int MOUSE_TURN = 0, CAT_TURN = 1;
        // static final int DRAW = 0, MOUSE_WIN = 1, CAT_WIN = 2;
        // public boolean canMouseWin(String[] a, int catLen, int mouseLen) {
        //     this.catLen = catLen; this.mouseLen = mouseLen; m = a.length; n = a[0].length(); N = m * n;
        //     s = new char [m][n];
        //     for (int i = 0; i < m; i++) s[i] = a[i].toCharArray();
        //     r = new int [N][N][2];
        //     f = new int [N][N][2];
        //     int mi = 0, mj = 0, ci = 0, cj = 0, fi = 0, fj = 0;
        //     for (int i = 0; i < m; i++)
        //         for (int j = 0; j < n; j++)
        //             if (s[i][j] == 'C') {
        //                 ci = i; cj = j;
        //             } else if (s[i][j] == 'M') {
        //                 mi = i; mj = j;
        //             } else if (s[i][j] == 'F') {
        //                 fi = i; fj = j;
        //             }
        //     fd = fi * n + fj;
        //     Deque<int []> q = new ArrayDeque<>();
        //     // 【初始化：】确定结果的三种主要状态可能：猫与老鼠同位；猫与食物；老鼠与食物
        //     for (int i = 0; i < N; i++) {
        //         if (i == fd) continue;
        //         // if (i != fd) {
        //         f[i][fd][CAT_TURN] = CAT_WIN; // 猫与食物同位
        //         q.offer(new int [] {i, fd, CAT_TURN});             
        //         f[fd][i][MOUSE_TURN] = MOUSE_WIN; // 老鼠与食物同位
        //         q.offer(new int [] {fd, i, MOUSE_TURN});             
        //         // }
        //         f[i][i][MOUSE_TURN] = CAT_WIN; // 猫与老鼠同位
        //         f[i][i][CAT_TURN] = CAT_WIN;
        //         q.offer(new int [] {i, i, CAT_TURN});             
        //         q.offer(new int [] {i, i, MOUSE_TURN});             
        //     }
        //     // 【入度统计：】改天再写这个方法，..
        //     return dfs(mi * n + mj, ci * n + cj, 0);
        // }
        // int [][][] f;
        // int [][][] r; // 入度
        // int m, n, fd, N, mouseLen, catLen; 
        // char [][] s;

        // 【回塑：】这个方法一定会超时，完全没有认出来，这也是一隐藏狠深的【记忆化深搜】。。。
        // public int minimumIncompatibility(int[] a, int k) { // TLE TLE TLE: 优化不够，会超时, 主要是对重复数字的处理？
        //     n = a.length; m = n / k;  this.a = a;
        //     if (n % k != 0) return -1;
        //     if (k == 1) return Arrays.stream(a).distinct().count() == n ? Arrays.stream(a).max().getAsInt() - Arrays.stream(a).min().getAsInt() : -1;
        //     this.k = k;
        //     Arrays.sort(a);
        //     System.out.println(Arrays.toString(a));
        //     backTracking(n-1, 0);
        //     return min == Integer.MAX_VALUE ? -1 : min;
        // }
        // int n, m, k, min = Integer.MAX_VALUE;
        // int [] a;
        // List<List<Integer>> ll = new ArrayList<>();
        // void backTracking(int i, int j) {
        //     if (i < 0) {
        //         if (j < min) min = j;
        //         return ;
        //     }
        //     if (ll.size() == 0) ll.add(new ArrayList<>());
        //     for (int x = 0; x < ll.size(); x++) {
        //         if (ll.get(x).size() == n / k) continue; // 每个桶里个数相同
        //         int s = ll.get(x).size();
        //         if (s > 0 && ll.get(x).get(s-1) == a[i]) continue; // 同一个桶：不能有相同元素
        //         ll.get(x).add(a[i]);
        //         backTracking(i-1, j + (s == 0 ?  0 : ( s == 1 ? ll.get(x).get(0) - a[i] : ll.get(x).get(s-1) - a[i])));
        //         ll.get(x).remove(s);
        //     }
        //     if (ll.size() < k) {
        //         ll.add(new ArrayList<>());
        //         ll.get(ll.size()-1).add(a[i]);
        //         backTracking(i-1, j);
        //         ll.remove(ll.size()-1);
        //     }
        // }
// // 【记忆化深搜：】感觉还是不太有思路，昨天中午晚上吃多吃傻了，晚上可能是食物的原因没能休息好，今天脑袋是塞着的，是闷的。。。改天再写这个，。。
//         public int minimumIncompatibility(int[] a, int k) { 
//             Arrays.sort(a); n = a.length; this.m = k; 
//             f = new Integer [n][1 << n][16];
//             return dfs(0, 0, );
//         }
//         Integer [][][] f;
//         int n, m, min = 15; int [] a;
//         int dfs(int i, int j, int k) {
//         }

        //         // 【内存溢出：】Memory Limit Exceeded 71/83 这里的意思就是说， max 取值过大，而实际存在的元素少，就成了为一个数据的离散化处理
//         // 线段树数据【离散化处理】：意思是说，分布过散的数据，重样集中集合到【0,n-1】下标，不取实际的值了，而用相对集中的下标代替
//         public int lengthOfLIS(int[] a, int k) {  // 动规：＋线段树来找前 f【i】【v-k】范围内的最大值【这个题仍然成了学习题】
//             int n = a.length, m = Arrays.stream(a).max().getAsInt()+1, ans = 1;
//             t = new int [4 * m]; // 不是说，线段树？下标是从 1 开始的吗？最大值 m 元素在哪里 
//             int [][] f = new int [n][m]; // 第二维表达的是以当前数 a[i] 为结尾的最长合法子序列长度，所以取最值
//             for (int i = 0; i < n; i++) { // 注意【0】下标更新线段树。。。
//                 int v = a[i];
//                 f[i][v] = 1;
//                 // 这里要找：前所有 i 个数【0,i-1】中，以【v-k,v-1】结尾的最大值，最大长度，
// // 这里我是在想要遍历，总复杂度为【O(N^2)】，线段树可以做到【O(NlogN)】线段树中的第一维就给消除掉，只累加更新【0,maxVal+1】范围内的最大值
//                 // for (int j = Math.max(0, v - k); j < v; j++) // 因为线段树区间求最大值：这里就不用遍历，一次【 O(logN)】查询就可以了
//                     // f[i][v] = Math.max(f[i][v], f[i-1][j] + 1); // 【分不清：哪个 i?】
//                 f[i][v] = Math.max(f[i][v], getMax(0, 0, m-1, v-k, v-1, t) + 1); // 查询线段树【v-k,v-1】区间最大值：下标1 开始，左闭右闭区间
//                 // f[i][v] = Math.max(f[i][v], getMax(0, 0, n-1, v-k, v-1, t) + 1); // 查询线段树【v-k,v-1】区间最大值：下标1 开始，左闭右闭区间
//                 update(0, 0, m-1, v, f[i][v], t); // 更新线段树单点元素： v 下标值为 f[i][v]
//                 // update(0, 0, n-1, i, f[i][v], t); // 更新线段树单点元素： v 下标值为 f[i][v]
//                 // ans = Math.max(ans, f[i][v]);
//             }
//             return t[0];
//         }
//         int [] t; // 【奇葩线段树】：下标从 0 开始的
//         void update(int u, int l, int r, int idx, int v, int [] t) { // 我这里参考别人的奇葩写法，写得自己稀里糊涂的。。。重写一遍
//             if (l == r) {
//                 t[u] = v;
//                 return ;
//             }
//             int m = l + (r - l) / 2;
//             if (idx <= m) update(u << 1 | 1, l, m, idx, v, t);
//             else update((u << 1) + 2, m+1, r, idx, v, t);
//             t[u] = Math.max(t[u << 1 | 1], t[(u << 1) + 2]); // 最大值线段树：根节点最大值，取左右子节点最大值 
//         }
//         int getMax(int u, int l, int r, int L, int R, int [] t) { // 【 l,r】：现存线段树的有效区间跨度；【L,R】：查询区间跨度
//             if (R < l || r < L) return 0;
//             if (L <= l && r <= R) return t[u];
//             int m = l + (r - l) / 2;
//             int ll = getMax(u << 1 | 1, l, m, L, R, t);
//             int rr = getMax((u << 1) + 2, m+1, r, L, R, t);
//             return Math.max(ll, rr);
//         }
        // public int lengthOfLIS(int[] a, int k) {  // 动规：＋线段树来找前 f【i】【v-k】范围内的最大值
        //     int n = a.length, m = Arrays.stream(a).max().getAsInt();
        //     t = new int [4 * m]; // 线段树？下标是从 1 开始的吗？这里感觉取不到最大值【m】
        //     for (int v : a) {
        //         System.out.println("\n v: " + v);
        //         if (v == 1) update(1, 1, m, 1, 1); // 更新单点：【v, res】成 t[1] ＝ 1
        //         else {
        //             int res = 1 + query(1, 1, m, Math.max(1, v-k), v-1); // 查询区间：【v-k, v-1】
        //             update(1, 1, m, v, res); // 更新单点：【v, res】成 t[v] ＝ res
        //         }
        //         System.out.println("t[v]: " + t[v]);
        //         levelPrintTree();
        //     }
        //     return t[1];
        // }
        // int [] t; // 线段树：最大值线段树，下标从1 开始的标准写法
        // void update(int u, int l, int r, int i, int v) { // 更新下标为 i 元素的值为 v, 从 u 节点开始遍历
        //     if (l == r) {
        //         t[u] = v;
        //         return ;
        //     }
        //     int m = l + (r - l) / 2;
        //     if (i <= m) update(u << 1, l, m, i, v);
        //     else update(u << 1 | 1, m+1, r, i, v); // 【左右节点的下标：】 U 《 1 | 1 
        //     t[u] = Math.max(t[u << 1], t[u << 1 | 1]); // 根节点最大值：取左右节点的最大值 
        // }
        // // 查询【L,R】范围内的最大值，线段树的跨越区间为【l,r】. L 和 R 在整个递归过程中均不变，将其大写，视作常量
        // int query(int u, int l, int r, int L, int R) { // 返回区间 [L,R] 内的最大值
        //     if (L <= l && r <= R) return t[u]; // 整个线段树，处于查询区间内，返回根节点最大值 
        //     int m = l + (r - l) / 2, leftMax = 0, rightMax = 0;
        //     if (L <= m)   leftMax = query(u << 1, l, m, L, R);
        //     if (m+1 <= R) rightMax = query(u << 1 | 1, m+1, r, L, R);
        //     return Math.max(leftMax, rightMax);
        // }
        // // 【打印：】这里，感觉我还旧需要一个打印方法，来打印出来，帮助自己理解。因为下标总弄不清楚
        // void levelPrintTree() {
        //     Deque<Integer> q = new ArrayDeque<>();
        //     q.offer(1); // 下标从 1 开始
        //     // System.out.println("\nTREE Level order traversal:");
        //     // System.out.println("idx: " + 1);
        //     // System.out.println("{t[idx]: " + t[1] + "  -> root\n");
        //     //             System.out.print("    ");
        //     while (!q.isEmpty()) {
        //         for (int size = q.size()-1; size >= 0; size--) {
        //             int curr = q.poll();
        //             System.out.print("{" + Integer.toBinaryString(curr) + "," + t[curr] + "} ");
        //             if (curr * 2 + 1 < t.length) {
        //                 q.offer(curr << 1);
        //                 q.offer(curr << 1 | 1);
        //             }
        //         }
        //         System.out.println("");
        //     }
        // }

        // public int minNumberOperations(int[] a) { // TLE TLE TLE: 127/129 弄个线段树，来区间型更新不好吗？ 1526
        //     n = a.length; this.a = a;
        //     if (Arrays.stream(a).distinct().count() == 1) return a[0];
        //     return minNumberOperations(0, n-1, 0);
        // }
        // int [] a; int n;
        // int minNumberOperations(int i, int j, int v) {
        //     if (i > j) return 0;
        //     if (i == j) return a[i] - v;
        //     int min = a[i];
        //     List<Integer> l = new ArrayList<>();
        //     for (int k = i; k <= j; k++) 
        //         if (a[k] < min) {
        //             min = a[k];
        //             l.clear();
        //             l.add(k);
        //         } else if (a[k] == min) l.add(k);
        //     int ans = min - v, pre = -1, idx = -1;
        //     for (int k = 0; k < l.size(); k++) {
        //         idx = l.get(k);
        //         ans += (k == 0 ? minNumberOperations(i, idx-1, min) :
        //                 minNumberOperations(pre + 1, idx-1, min));
        //         pre = idx;
        //     }
        //     ans += minNumberOperations(idx+1, j, min);
        //     return ans;
        // }
        // // 【最彻底的解法】：差分数组
        // public int minNumberOperations(int[] a) {
        //     int n = a.length, ans = a[0];
        //     for (int i = 1; i < n; i++)
        //         ans += Math.max(0, a[i] - a[i-1]);
        //     return ans;
        // }
        // // 【线段树】: 既然上面超时了，就用线段树来写吧【【BUG：】】这里有个下标的问题，// TODO TODO TODO: 
        // public int minNumberOperations(int[] a) {
        //     int n = a.length; N = Arrays.stream(a).max().getAsInt(); // m = 100000
        //     m = new HashMap<>(); // 用来记下标
        //     t = new int [4 * N]; // 初始化：不够，因为求最小值，就必须把其它所有的非空填为最大值。。。
        //     for (int i = 0; i < n; i++) {
        //         update(1, 1, N, i, a[i]);
        //         m.computeIfAbsent(a[i], z -> new ArrayList<>()).add(i);
        //     }
        //     for (int i = 0; i < N; i++)
        //         // if (t[i] == 0)
        //         if (!m.containsKey(i))
        //             update(1, 1, N, i, Integer.MAX_VALUE / 2);
        //     System.out.println(Arrays.toString(t));
        //     return minNumberOperationsRecursion(0, n-1);
        // }
        // int minNumberOperationsRecursion(int i, int j) {
        //     System.out.println("\n i: " + i);
        //     System.out.println("j: " + j);
        //     int min = query(1, 1, N, i, j), ans = min;
        //     System.out.println("min: " + min);
        //     List<Integer> l = m.get(min); // 升序排列：可以二分查找，找到在【i,j】范围内的下标，即左右端点
        //     for (int k = 0; k < l.size(); k++) {
        //         if (l.get(k) < i) continue;
        //         if (l.get(k) > j) break;
        //         // if (a[l.get(k)] == min) { // 以最小值来分片段
        //         if (l.get(k) < i) ans += minNumberOperationsRecursion(i, l.get(k)-1);
        //         if (k < l.size()-1) ans += minNumberOperationsRecursion(l.get(k)+1, l.get(k+1)-1);
        //         else if (k == l.size()-1 && l.get(k) < j) ans += minNumberOperationsRecursion(l.get(k)+1, j);
        //         // }
        //     }
        //     return ans;
        // }
        // Map<Integer, List<Integer>> m;
        // int [] t, a;
        // int N;
        // int query(int u, int l, int r, int L, int R) {
        //     if (L <= l && r <= R) return t[u];
        //     int m = (l + r) >> 1, left = 0, right = 0;
        //     if (L <= m) left = query(u << 1, l, m, L, R);
        //     if (m+1 <= R) right = query(u << 1 | 1, m+1, r, L, R);
        //     return Math.min(left, right); // 【最小值】
        // }
        // void update(int u, int l, int r, int i, int v) {
        //     if (l == r) {
        //         t[u] = v;
        //         return ;
        //     }
        //     int m = (l + r) >> 1;
        //     if (i <= m) update(u << 1, l, m, i, v);
        //     else update(u << 1 | 1, m+1, r, i, v);
        //     t[u] = Math.min(t[u << 1], t[u << 1 | 1]); // 【最小值线段树】
        // }

        // // 【栈：】这个好像与前面那个求数组的所有子数组最小值的和是类似的 // TODO TODO TODO: 
        // public int oddEvenJumps(int[] a) {
        //     int n = a.length;
        //     int [] l = new int [n], r = new int [n]; // l: odd -s - 从右往左降序； r: even-t 从右往左升序
        //     Arrays.fill(l, -1); Arrays.fill(r, -1);
        //     ArrayDeque<Integer> s = new ArrayDeque<>(), t = new ArrayDeque<>();
        //     // 【从左往右遍历】： s 升序， t 降序
        //     for (int i = 0; i < n; i++) {
        //         while (!s.isEmpty() && a[s.peekFirst()] > a[i]) s.pollFirst();
        //         if (!s.isEmpty()) l[s.peekFirst()] = i;
        //         while (!t.isEmpty() && a[t.peekFirst()] < a[i]) t.pollFirst();
        //         if (!t.isEmpty()) r[t.peekFirst()] = i;
        //         s.offerFirst(i);
        //         t.offerFirst(i);
        //     }
        //     // // 【从右往左遍历】： s 降序栈，t 升序栈 // 【这些写得仍然是错的】！！！
        //     // for (int i = n-1; i >= 0; i--) {
        //     //     while (!s.isEmpty() && a[s.peekFirst()] < a[i]) s.pollFirst();
        //     //     if (!s.isEmpty()) l[i] = s.peekFirst();
        //     //     while (!t.isEmpty() && a[t.peekFirst()] > a[i]) t.pollFirst();
        //     //     if (!t.isEmpty()) r[i] = t.peekFirst();
        //     //     s.offerFirst(i);
        //     //     t.offerFirst(i);
        //     // } 
        //     System.out.println(Arrays.toString(l));
        //     System.out.println(Arrays.toString(r));
        //     // 【动规：】因为分奇数跳与偶数跳，所以动规的数组，可能也要分奇数与偶数跳，【可以行用记忆化深搜写一遍，再试写动规！！！】
        //     boolean [] fl = new boolean [n], fr = new boolean [n];
        //     // 【初始化】：这点儿不够
        //     fl[n-1] = true; fr[n-1] = true;
        //     for (int i = 0; i < n; i++) { // 【初始化】：这些要全部补上
        //         if (l[i] == n-1) fl[i] = true;
        //         // if (r[i] == n-1) fr[i] = true;
        //     }
        //     int ans = 1;
        //     for (int i = n-2; i >= 0; i--) {
        //         if (r[i] == n-1) 
        //             fl[i] = true;
        //         for (int j = i+1; j < n; j++) {
        //             if (l[i] == j && r[j] == n-1) {
        //                 fl[i] = true;
        //                 fr[j] = true;
        //             }
        //         }
        //         if (fl[i] || fr[i]) ans++;
        //     }
        //     System.out.println(Arrays.toString(fl));
        //     System.out.println(Arrays.toString(fr));
        //     return ans;
        // }

        // public int numberWays(List<List<Integer>> ll) { // 【回塑：】一定会超时。。。: 帽子太多了就会超时，得用动规。。。
        //     n = ll.size(); this.ll = ll; 
        //     backTracking(0, 0);
        //     return ans;
        // }
        // List<List<Integer>> ll = new ArrayList<>();
        // int n, m, ans = 0;
        // void backTracking(int i, int j) { // j: mask
        //     if (i == n) {
        //         if (Integer.bitCount(j) == n) // 一定要有这么多人顶帽子
        //             ans = (ans + 1) % mod;
        //         return ;
        //     }
        //     for (int k : ll.get(i)) { // 这个人喜欢的所有的帽子：
        //         if (((j & (1 << k)) == 0) // 这顶帽子还没人带
        //             backTracking(i+1, j | (1 << k));
        //     }
        // }
        // static final int mod = (int)1e9 + 7; 
        // public int numberWays(List<List<Integer>> ll) { // 【动规：】比较习惯写【自顶向下】，仍然是从没有帽子开始，遍历到所有的人都有帽子，感觉是自顶向下
        //     int n = ll.size(), m = 0;
        //     for (int i = 0; i < n; i++)
        //         m = Math.max(m, Collections.max(ll.get(i)));
        //     m++;
        //     // 因为要遍历帽子，需要简单重构：每顶帽子，是有哪些人比较喜欢它？
        //     List<Integer> [] g = new ArrayList [m];
        //     Arrays.setAll(g, z -> new ArrayList<>());
        //     Set<Integer> hats = new HashSet<>();
        //     for (int i = 0; i < n; i++) 
        //         for (int v : ll.get(i)) {
        //             g[v].add(i); // 【每顶帽子：】有这些人会比较喜欢它。。。
        //             hats.add(v);
        //         }
        //     List<Integer> l = new ArrayList<>();
        //     for (int v : hats) l.add(v);
        //     System.out.println("l.size(): " + l.size());
        //     System.out.println(Arrays.toString(l.toArray()));
        //     m = l.size();
        //     int [][] f = new int [m][1 << n];
        //     f[0][0] = 1;
        //     for (int j = 0; j < m; j++) { // 遍历帽子：当前这顶帽子 j, 可以给谁带？它说前面的【1,j-1】的帽子已经有人带了
        //         System.out.println("\n j: " + l.get(j));
        //         System.out.println("g[l.get(j)].size(): " + g[l.get(j)].size());
        //         System.out.println(Arrays.toString(g[l.get(j)].toArray()));
        //         for (int i = 0; i < (1 << n); i++) { // 遍历：人的带与没带，帽子的状态
        //             for (int k : g[l.get(j)]) { // 遍历：喜欢这顶帽子 j 的所有可能会带它的人
        //                 System.out.println("k: " + k);
        //                 if ((i & (1 << k)) == 0) { // 喜欢这顶帽子的，这个当前人，还没带帽子，可以给它带下【自顶向下】
        //                     f[j][i | (1 << k)] = (f[j][i | (1 << k)] + (j == 0 ? 1 : f[j-1][i])) % mod;
        //                 }
        //             }
        //         }
        //         System.out.println("f.length: " + f.length);
        //         for (int z = 0; z < f.length; ++z) 
        //             System.out.println(Arrays.toString(f[z]));
        //     }
        //     System.out.println("f.length: " + f.length);
        //     for (int z = 0; z < f.length; ++z) 
        //         System.out.println(Arrays.toString(f[z]));
        //     return f[m-1][(1 << n)-1];
        // }

        // public int minSteps(int n) {
        //     int [] f = new int [n+1];
        //     for (int i = 2; i <= n; i++) {
        //         f[i] = Integer.MAX_VALUE;
        //         for (int j = 1; j * j <= i; j++) 
        //             if (i % j == 0) {
        //                 f[i] = Math.min(f[i], f[j] + i / j);
        //                 f[i] = Math.min(f[i], f[i / j] + j);
        //              }
        //     }
        //     return f[n];
        // }

        // static final int mod = (int)1e9 + 7;
        // public int numTilings(int n) {
        //     long [][] f = new long [n+1][4];
        //     f[0][3] = 1;
        //     for (int i = 1; i <= n; i++) {
        //         f[i][0] = f[i-1][3];
        //         f[i][1] = (f[i-1][0] + f[i-1][2]) % mod;
        //         f[i][2] = (f[i-1][0] + f[i-1][1]) % mod;
        //         f[i][3] = (f[i-1][0] + f[i-1][1] + f[i-1][2] + f[i-1][3]) % mod;
        //     }
        //     return (int)f[n][3];
        // }

        // public int combinationSum4(int[] a, int k) {
        //     int [] f = new int [k + 1];
        //     f[0] = 1;  // 代表空集
        //     for (int i = 1; i <= k; i++) 
        //         for (int v : a) 
        //             if (v <= i) f[i] += f[i-v];
        //     return  f[k];
        // }

        // // 【记忆化深搜：】: 要搜的是，最差情况下，花费最少的钱，来保证猜对，所需要的最少的钱。。最差情况下的，最小花费？
        // public int getMoneyAmount(int n) {
        //     f = new Integer [n+1][n+1]; // 一维可能不够用，需要一个大致的范围
        //     Arrays.stream(f).forEach(z -> Arrays.fill(z, Integer.MAX_VALUE / 2));
        //     return dfs(1, n);
        // }
        // Integer [][] f;
        // int dfs(int i, int j) {
        //     if (i > j) return Integer.MAX_VALUE / 2;
        //     if (f[i][j] != Integer.MAX_VALUE / 2) return f[i][j];
        //     if (i == j) return f[i][j] = 0; // 这是终止条件：猜对了，确定到最后一个数字。。。
        //     int ans = Integer.MAX_VALUE / 2;
        //     for (int k = i; k <= j; k++)  // 猜错了，最差情况下最多的花费，取最小值 
        //         ans = Math.min(ans, k + Math.max(k == i ? 0 : dfs(i, k-1), k == j ? 0 : dfs(k+1, j)));
        //     return f[i][j] = ans;
        // }

        // public int longestArithSeqLength(int[] a) { // 1027: 二维思路出发点是对的，数据结构没选对。。
        //     int n = a.length, m = Arrays.stream(a).max().getAsInt() + 1;
        //     if (n == 2) return a[0] != a[1] ? 2 : 0;
        //     int [][] f = new int [n][m]; // 这里是对的：当公差为负数的时候，不好处理【负数不好处理，就把负数转正！！】，也可以改用字典。。。
        //     for (int i = 0; i < n; i++) 
        //         for (int j = 0; j < i; j++) {
        //         }
        //     for (int j = i-1; j >= 0; j--) {
        //         f[a[i]] = Math.max(2, f[a[i]]);
        //         int d = a[i] - a[j], v = d + a[i], x = a[i];
        //         while (d != 0 && v < m  && v >= 0 && f[v] > 0) {
        //             f[v] = Math.max(f[v], f[x] + 1);
        //             x = v;
        //             v = d + v;
        //         }
        //     }
        //     return Arrays.stream(f).max().getAsInt();
        // }
        // public int longestArithSeqLength(int[] a) { // 1027: 二维思路出发点是对的，数据结构没选对。。
        //     int n = a.length, max = 0;
        //     int [][] f = new int [n][1001];
        //     for (int i = 0; i < n; i++)
        //         for (int j = 0; j < i; j++) {
        //             int d = a[i] - a[j] + 500;
        //             f[i][d] = Math.max(Math.max(2, f[i][d]), f[j][d] + 1);
        //             max = Math.max(max, f[i][d]);
        //         }
        //     return max;
        // }
        // public int longestArithSeqLength(int[] a) { // 1027: 【自顶向下】的动规：这么看来，简单的题，动规也是信手拈来，就是复杂的动规不会。。。。
        //     int n = a.length, max = 0;
        //     Map<Integer, Integer> [] m = new HashMap [n]; // 每个下标对应一个字典！！！忘记了吧，破记性！！
        //     Arrays.setAll(m, z -> new HashMap<>());
        //     for (int i = 1; i < n; i++) // 遍历所有可以组对的下标
        //         for (int j = 0; j < i; j++) { // 遍历所有可能产生的公差
        //             int d = a[i] - a[j];
        //             m[i].put(d, m[j].getOrDefault(d, 1) + 1); // 更新存储
        //             max = Math.max(max, m[i].get(d));
        //         }
        //     return max;
        // }

        // public int maxTwoEvents(int[][] a) {
        //     n = a.length;
        //     // 按开始时间升序，【从右往左遍历】：方便接下来【从左往右遍历】遍历时，找第二个发生在后面的事件
        //     Arrays.sort(a, (x, y) -> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
        //     // 【最大值线段树】：【离散化的数据：】必缩对应到下标，对应到下标，就需要把排序过的重新再加到一个数据结构中，方便树去离散化。。
        //     li = new ArrayList<>();
        //     t = new int [4 * n]; // 对应到【下标】【O(logN)】查找最大值 
        //     for (int i = 0; i < n; i++) {
        //         li.add(new int [] {i, a[i][0], a[i][2]}); // 二分查找下标
        //         update(1, 1, n, i, a[i][2]);
        //     }
        //     // 按结束时间升序，【从左往右遍历】：遍历当前事件，与选择最优第二事件，所有可能优化全局最值 
        //     Arrays.sort(a, (x, y) -> x[1] - y[1]);
        //     int ans = 0;
        //     for (int i = 0; i < n; i++) {
        //         int [] r = a[i];
        //         int j = binarySearch(r[1] + 1);
        //         if (j != li.size()) ans = Math.max(ans, r[2] + query(1, 1, n, li.get(j)[0], n));
        //         else ans = Math.max(ans, r[2]);
        //     }
        //     return ans;
        // }
        // int binarySearch(int v) { // 这里写得不标准 
        //     int l = 0, r = li.size()-1; 
        //     if (v > li.get(r)[1]) return r+1;
        //     while (l < r) { 
        //         int m = l + (r - l) / 2;
        //         if (li.get(m)[1] < v) l = m + 1;
        //         else r = m;
        //     }
        //     return l;
        // }
        // List<int []> li;
        // int [] t;
        // int n;
        // int query(int u, int l, int r, int L, int R) {
        //     if (L <= l && r <= R) return t[u];
        //     int m = (l + r) >> 1, ll = 0, rr = 0;
        //     if (L <= m) ll = query(u << 1, l, m, L, R);
        //     if (m+1 <= R) rr = query(u << 1 | 1, m+1, r, L, R);
        //     return Math.max(ll, rr);
        // }
        // void update(int u, int l, int r, int i, int v) {
        //     if (l == r) {
        //         t[u] = v;
        //         return ;
        //     }
        //     int m = (l + r) / 2;
        //     if (i <= m) update(u << 1, l, m, i, v);
        //     else update(u << 1 | 1, m+1, r, i, v);
        //     t[u] = Math.max(t[u << 1], t[u << 1 | 1]);
        // }
        // class Event { // 把起始结束统一成了一起排序
        //     int ts, op, val;
        //     Event(int ts, int op, int val) {
        //         this.ts = ts; this.op = op; this.val = val; 
        //     }
        // }
        // public int maxTwoEvents(int[][] a) {
        //     List<Event> li = new ArrayList<>();
        //     for (int [] v : a) {
        //         li.add(new Event(v[0], 0, v[2]));
        //         li.add(new Event(v[1], 1, v[2]));
        //     }
        //     Collections.sort(li, (x, y) -> x.ts != y.ts ? x.ts - y.ts : x.op - y.op);
        //     int ans = 0, maxFstEvent = 0;
        //     for (Event e : li) {
        //         if (e.op == 0) ans = Math.max(ans, maxFstEvent + e.val);
        //         else maxFstEvent = Math.max(maxFstEvent, e.val);
        //     }
        //     return ans;
        // }
        // public int maxTwoEvents(int[][] a) {
        //     // 【最小堆最大堆的解法：】这个是最大众化的解法
        //     Queue<int []> q = new PriorityQueue<>((x, y) -> x[1] != y[1] ? y[1] - x[1] : x[0] - y[0]);
        //     for (int [] e : a) q.offer(new int [] {e[0], e[2]});
        //     int ans = 0;
        //     Arrays.sort(a, (x, y) -> x[1] - y[1]);
        //     for (int [] e : a) {
        //         while (!q.isEmpty() && q.peek()[0] < e[1] + 1) q.poll();
        //         if (!q.isEmpty()) ans = Math.max(ans, e[2] + q.peek()[1]);
        //         else ans = Math.max(ans, e[2]);
        //     }
        //     return ans;
        // }

        // public int minHeightShelves(int[][] a, int k) { 
        //     int n = a.length;
        //     int [] f = new int [n+1];
        //     Arrays.fill(f, 1000000);
        //     f[0] = 0;
        //     for (int i = 0; i < n; i++) {
        //         int maxHeight = 0, curWidth = 0;
        //         for (int j = i; j >= 0; j--) { // 【把当前下标的书：】也一起努力塞进当前层，或是前一层书里。。
        //             curWidth += a[j][0];
        //             if (curWidth > k) break;
        //             maxHeight = Math.max(maxHeight, a[j][1]);
        //             f[i+1] = Math.min(f[i+1], f[j] + maxHeight);
        //         }
        //     }
        //     return f[n];
        // }

        // // 因为是偶数下标和，减去奇数下标和，两个动规数组，分别记：偶数和最大值 , 与奇数和最小值【不对，应该记，到当前下标的，答案差值】
        // public long maxAlternatingSum(int[] a) {
        //     int n = a.length, max = Integer.MIN_VALUE;
        //     long [] f = new long [n+1], d = new long [n+1]; // f even  d odd 当前下标: 是当作奇数下标，还是当作偶数下标，分别记到当前下标的差值最大值，而不是记和。。。
        //     for (int i = 0; i < n; i++) {
        //         // 当前下标当作奇数：选【前 i-1 的偶数f[i] - a[i]】，与不选
        //         d[i+1] = Math.max(f[i] - a[i], d[i]);
        //         // f[i+1] = Math.max(f[i] + (i > 1 ? a[i] - d[i] : (i == 1 ? 0 : a[i])), f[i]); // 【这里，这里那里不对。。。】
        //         f[i+1] = Math.max(d[i] + a[i], f[i]); // 因为奇偶都记着全局最优值，直接从前一个奇数来。。。
        //     }
        //     return Math.max(f[n], d[n]);
        // }

        // public int numSubmat(int[][] a) {
        //     int m = a.length, n = a[0].length, ans = 0, cnt = 0;
        //     // 一点儿优化：横轴方向上个数的预处理，优化出一个【O(N)】
        //     int [][] r = new int [m][n+1];
        //     for (int i = 0; i < m; i++)
        //         for (int j = 0; j < n; j++) // r[i][j+1]
        //             if (a[i][j] == 1) r[i][j+1] = r[i][j] + 1;
        //     for (int i = 0; i < m; i++)
        //         for (int j = 0; j < n; j++) { // 枚举以 [i][j] 为右下角的子数组的个数
        //             cnt = r[i][j+1];
        //             for (int k = i; k >= 0 && r[k][j+1] > 0; k--) {
        //                 cnt = Math.min(cnt, r[k][j+1]);
        //                 ans += cnt; // 每一行都数过，第 i 当前行，与第 k[<i] 行，意义不一样。。。
        //             }
        //         }
        //     return ans;
        //     // for (int i = 0; i < m; i++)
        //     //     for (int j = 0; j < n; j++) { // 枚举以 [i][j] 为右下角的子数组的个数
        //     //         int maxWidth = r[i][j+1]; // 当前行的最大宽度
        //     //         ans += r[i][j+1]; // 当前行的，以 [i,j] 为结尾的【横子矩形】个数
        //     //         if (maxWidth < 1) continue; // 最多一个格
        //     //         // 优化横轴【一个轴】后，只需要遍历另一个轴上的【O(N)】，全局可以是【O(M N * Math.min(M, N))】
        //     //         for (int k = i-1; k >= 0 && r[k][j+1] > 0; k--) {
        //     //             maxWidth = Math.min(maxWidth, r[k][j+1]);
        //     //             // ans += r[k][j+1]; // 这里算重复了，每行都会数的。。。
        //     //             ans += maxWidth; // 考虑两个轴上的扩展, 横轴上的扩展，每行不一样。。。
        //     //         }
        //     //         // ans += maxWidth * (i - k - 1); // 【BUG：】考虑两个轴上的扩展，横轴上的扩展，每行不一样。。。
        //     //     }
        //     // return ans;
        // }

        // // 【缺点：】占用空间大，因为需要存储过多的丑丑的数。。。。。
        // public int nthUglyNumber(int n) {
        //     Queue<Long> q = new PriorityQueue<>();
        //     q.offer(1l);
        //     long r = 0;
        //     while (n > 0) {
        //         r = q.poll();
        //         while (!q.isEmpty() && q.peek() == r) q.poll();
        //         q.offer(r * 2);
        //         q.offer(r * 3);
        //         q.offer(r * 5);
        //         n--;
        //     }
        //     return (int)r;
        // }        
        // // 【动规：】只占用必要的空间
        // public int nthUglyNumber(int n) {
        //     int [] f = new int [n+1];
        //     f[1] = 1;
        //     int i = 1, j = 1, k = 1; // index for 2 3 5 
        //     for (int x = 2; x <= n; x++) {
        //         f[x] = Math.min(f[i] * 2, Math.min(f[j] * 3, f[k] * 5));
        //         if (f[x] == f[i] * 2) i++;
        //         if (f[x] == f[j] * 3) j++;
        //         if (f[x] == f[k] * 5) k++;
        //     }
        //     return f[n];
        // }

        // // 这里好像是有个 queue[] 但想不起来了，连不起来。。。【动规】：要怎么解决呢？ // TODO TODO TODO:
        // // 【可能是我记错题目了 】这个这里瓣不出来。。。改天再把这个题目的原题，找出来看一下
        // public int nthSuperUglyNumber(int n, int[] a) {
        //     int m = a.length;
        //     int [] f = new int [n+1], r = new int [m];
        //     Arrays.fill(r, 1);
        //     Integer [] id = IntStream.range(0, m).boxed().toArray(Integer[]::new); // 这么用不好
        //     Queue<Integer> q = new PriorityQueue<>((x, y) -> a[x] * r[x] - a[y] * r[y]); // 这样就把质数与 r[] 动态绑定了？
        //     // Queue<Integer> q = new PriorityQueue<>((x, y) -> a[x] * f[r[x]] - a[y] * f[r[y]]); // 这样就把质数与 r[] 动态绑定了？
        //     for (int i = 0; i < m; i++) q.offer(i);
        //     f[1] = 1;
        //     for (int i = 2; i <= n; i++) {
        //         int t = q.poll(); // idx
        //         // int t = q.peek(); // idx 跟下面一起统一管理，会存在重复问题？
        //         f[i] = a[t] * r[t];  // 更新答案
        //         while (!q.isEmpty() && a[q.peek()] * r[q.peek()] == a[t] * r[t]) {
        //             int cur = q.poll();
        //             r[cur]++; // 这里不能是简单倍数。因为会制造其它，非允许质因子
        //             // r[cur] = f[r[cur]+1];
        //             // r[cur] = f[r[cur]];
        //             q.offer(cur);
        //         } 
        //         r[t]++;
        //         // r[t] = f[r[t]+1]; // 这个，还没有算出来。。。【要怎么处理呢？】
        //         // r[t] = f[r[t]]; // 这个，还没有算出来。。。【要怎么处理呢？】
        //         q.offer(t);
        //     }
        //     return f[n];
        // }
        // public int nthSuperUglyNumber(int n, int[] a) {
        //     int m = a.length;
        //     int [] f = new int [n+1], r = new int [m];
        //     long [] nums = new long [m];
        //     Arrays.fill(nums, 1l);
        //     for (int i = 1; i <= n; i++) {
        //         int minNum = (int)Arrays.stream(nums).min().getAsLong();
        //         f[i] = minNum;
        //         for (int j = 0; j < m; j++) 
        //             if (nums[j] == minNum) {
        //                 r[j]++;
        //                 nums[j] = (long)f[r[j]] * a[j];
        //             }
        //     }
        //     return f[n];
        // }

        // static final int mod = (int)1e9 + 7;
        // public int peopleAwareOfSecret(int n, int d, int fg) {
        //     int [] f = new int [n]; // 【定义：】第 i 天的可以产生利息的钱，是本金，没带利息
        //     f[0] = 1; // 【自顶向下：】向后更新，但是区分清楚，哪些可以产生哪些。。。
        //     int cnt = 0; // 这部分要分开统计：是因为现数组的下标，容不下了。。。
        //     // 就是节省一点儿空间【这是不能产生利息的钱，但它也是钱，是知道了秘密的人，只是还不能分享】
        //     for (int i = 0; i < n; i++) {
        //         if (i + d >= n) cnt = (cnt + f[i]) % mod; // 为什么要把 >= n 的也全部统计上 ?
        //             for (int j = i + d; j < Math.min(n, i + fg); j++) // 左闭右开区间：【i+d, i+fg）
        //             // 【自顶向下】：向后更新
        //             f[j] = (f[j] + f[i]) % mod;
        //     }
        //     return (f[n-1] + cnt) % mod;
        //     // int [] f = new int [n + 1000];
        //     // for (int i = 0; i < n; i++) {
        //     //     for (int j = i + d; j < i + fg; j++) // 左闭右开区间：【i+d, i+fg）
        //     //         f[j] = (f[j] + f[i]) % mod;
        //     // return f[n-1];
        // }

//         // 跟以前的思路有点儿不一样：这里提示说：遍历每个格，知道这个格出发【上下左右】各最少格数，再根据四个边的边长是否合法来判断 
//         public int largest1BorderedSquare(int[][] a) {
//             int m = a.length, n = a[0].length, ans = 0;
//             // 【代码优化】：并不真的需要四个数组，两个就够用了；并且可以一次遍历过程中，动态更新，而非三四次遍历数组。。。。。
//             int [][] u = new int [m+1][n], d = new int [m+1][n];
//             int [][] l = new int [m][n+1], r = new int [m][n+1];
//             // 从当前格出发：【左右、上下】连续1 的最多个数
//             for (int i = 0; i < m; i++) {
//                 for (int j = 0; j < n; j++)
//                     if (a[i][j] == 1)
//                         l[i][j+1] = l[i][j] + 1; // 【左】【i,j+1】
//                 for (int j = n-1; j >= 0; j--) 
//                     if (a[i][j] == 1)
//                         r[i][j] = r[i][j+1] + 1; // 【右】【i,j】
//             }
//             for (int j = 0; j < n; j++) {
//                 for (int i = 0; i < m; i++)
//                     if (a[i][j] == 1) u[i+1][j] = u[i][j] + 1; // 【上】【i+1,j】
//                 for (int i = m-1; i >= 0; i--) 
//                     if (a[i][j] == 1) d[i][j] = d[i+1][j] + 1;   // 【下】【i,j】
//             }
//             int max = 0;
//             for (int i = 0; i < m; i++)
//                 for (int j = 0; j < n; j++) { // 不是以【i, j】为中心点，而是以 [i,j] 为右下点，来计算四条边是否都合法
//                     if (a[i][j] == 0) continue;
//                     int k = Math.min(l[i][j+1], u[i+1][j]); // 右下角连续1 的最短边长
//                     // k = Math.min(k, Math.min(i+1, j+1)); // 限制在矩阵范围内【这步也可以优化掉】
// // 左上角的顶点坐标：【i-d+1, j-d+1】
//                     while (k > 0) {
//                         if (k > 0 && Math.min(r[i-k+1][j-k+1], d[i-k+1][j-k+1]) >= k) {
//                             ans = Math.max(ans, k * k);
//                             break;
//                         }
//                         k--;
//                     } 
//                 }
//             return ans;
//         }
        // public int largest1BorderedSquare(int[][] grid) {
        //     int m = grid.length, n = grid[0].length;
        //     int[][] left = new int[m + 1][n + 1];
        //     int[][] up = new int[m + 1][n + 1];
        //     int maxBorder = 0;
        //     for (int i = 1; i <= m; i++) {
        //         for (int j = 1; j <= n; j++) {
        //             if (grid[i - 1][j - 1] == 1) {
        //                 left[i][j] = left[i][j - 1] + 1;
        //                 up[i][j] = up[i - 1][j] + 1;
        //                 int border = Math.min(left[i][j], up[i][j]);
        //                 while (left[i - border + 1][j] < border || up[i][j - border + 1] < border) 
        //                     border--;
        //                 maxBorder = Math.max(maxBorder, border);
        //             }
        //         }
        //     }
        //     return maxBorder * maxBorder;
        // }
        // public int largest1BorderedSquare(int[][] a) {
        //     int m = a.length, n = a[0].length, ans = 0;
        //     int [][] u = new int [m+1][n], l = new int [m][n+1];
        //     int max = 0;
        //     for (int i = 0; i < m; i++)
        //         for (int j = 0; j < n; j++) { // 不是以【i, j】为中心点，而是以 [i,j] 为右下点，来计算四条边是否都合法
        //             if (a[i][j] == 0) continue;
        //             u[i+1][j] = u[i][j] + 1; // 【上】 [i+1,j]
        //             l[i][j+1] = l[i][j] + 1; // 【左】 [i,j+1]
        //             int k = Math.min(l[i][j+1], u[i+1][j]); // 右下角连续1 的最短边长
        //             // 左上角的顶点坐标：【i-k+1, j-k+1】这里扫的不是左上顶点。扫的是左边边往上，顶上边往左。。。
        //             // 【理解：】这里是顶上的边，往左扫；左边的边，往上扫，来递减，边长。这才是【只用两个动规矩阵】的原因。。。
        //             while (k >= 0 && (l[i-k+1][j+1] < k || u[i+1][j-k+1] < k)) k--;
        //             if (k > 0) ans = Math.max(ans, k * k);
        //         }
        //     return ans;
        // }
        // public int largest1BorderedSquare(int[][] grid) { // 上面瓣那些边，感觉官方写法，这个还算是比较简洁的
        //     int m = grid.length, n = grid[0].length;
        //     int[][] left = new int[m + 1][n + 1];
        //     int[][] up = new int[m + 1][n + 1];
        //     int maxBorder = 0;
        //     for (int i = 1; i <= m; i++) 
        //         for (int j = 1; j <= n; j++) 
        //             if (grid[i - 1][j - 1] == 1) {
        //                 left[i][j] = left[i][j - 1] + 1;
        //                 up[i][j] = up[i - 1][j] + 1;
        //                 int border = Math.min(left[i][j], up[i][j]);
        //                 while (left[i - border + 1][j] < border || up[i][j - border + 1] < border) 
        //                     border--;
        //                 maxBorder = Math.max(maxBorder, border);
        //             }
        //     return maxBorder * maxBorder;
        // }

        public int findNumberOfLIS(int [] a) { // 【经典题型：】
            int n = a.length, max = 0, ans = 0;
            int [] f = new int [n], r = new int [n+1]; // 分别记：以当前下标 i 为结尾最后一个元素的，最长序列长度，与最长序列个数
            Arrays.fill(f, 1);
            // f[0] = 1;
            // r[1] = 1;
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (a[j] < a[i]) {
                        System.out.println("\n i: " + i);
                        if (f[i] < f[j] + 1) {
                            f[i] = f[j] + 1;
                            r[f[i]] = r[f[j]];
                        } else if (f[i] == f[j] + 1 && f[i] > 2) // 找到了添加的新途径
                            r[f[i]] += r[f[j]];
                    }
                }
                System.out.println(Arrays.toString(f));
                System.out.println(Arrays.toString(r));
            }
            for (int i = 0; i < n; i++) 
                if (f[i] > max) {
                    max = f[i];
                    ans = r[i];
                }
            return ans;
        }
    }
    public static void main (String[] args) { // 【爱表哥，爱生活！！！活宝妹就是一定要嫁给亲爱的表哥！！！】
        Solution s  =  new Solution ();

        int [] a = new int [] {1,3,5,4,7};
        System.out.println(Arrays.toString(a));

        int r = s.findNumberOfLIS(a);
        System.out.println("r: " + r);
    } 
}
// ListNode head = new ListNode(a[0]); 
// head.buildList(head, a);  
// head.printList(head);
// TreeNode rr = new TreeNode(a[0]);
// rr.buildTree(rr, a);
// rr.levelPrintTree(rr);



