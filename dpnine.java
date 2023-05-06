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

        // 【栈：】这个好像与前面那个求数组的所有子数组最小值的和是类似的
        public int oddEvenJumps(int[] a) {
            int n = a.length;
            int [] l = new int [n], r = new int [n]; // l: odd -s - 从右往左降序； r: even-t 从右往左升序
            Arrays.fill(l, -1); Arrays.fill(r, -1);
            ArrayDeque<Integer> s = new ArrayDeque<>(), t = new ArrayDeque<>();
            // 【从右往左遍历】： s 降序栈，t 升序栈
            for (int i = n-1; i >= 0; i--) {
                while (!s.isEmpty() && a[s.peekFirst()] > a[i]) s.pollFirst();
                if (!s.isEmpty()) l[i] = s.peekFirst();
                while (!t.isEmpty() && a[t.peekFirst()] < a[i]) t.pollFirst();
                if (!t.isEmpty()) r[i] = s.peekFirst();
                s.offerFirst(i);
                t.offerFirst(i);
            }
            // 【动规：】因为分奇数跳与偶数跳，所以动规的数组，可能也要分奇数与偶数跳，【可以行用记忆化深搜写一遍，再试写动规！！！】
        }
    }
    public static void main (String[] args) { // 【爱表哥，爱生活！！！活宝妹就是一定要嫁给亲爱的表哥！！！】
        Solution s  =  new Solution ();

        int [] a = new int [] {7,3,16,15,1,13,1,2,14,5,3,10,6,2,7,15};

        int r = s.minimumIncompatibility(a, 8);
        System.out.println("r: " + r);
    } 
}
// ListNode head = new ListNode(a[0]); 
// head.buildList(head, a);  
// head.printList(head);
// TreeNode rr = new TreeNode(a[0]);
// rr.buildTree(rr, a);
// rr.levelPrintTree(rr);




