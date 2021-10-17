// import com.UnionFind;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.Collectors;
 
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import static java.util.stream.Collectors.toMap;

public class dynaeightmicProgramming {
    public static class Solution {

        // public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        //     int n = passingFees.length, maxFee = Integer.MAX_VALUE - (int)1e9;
        //     int [][] f = new int [1007][1007];
        //     for (int i = 0; i < 1007; i++)
        //         Arrays.fill(f[i], maxFee);
        //     f[0][0] = passingFees[0];
        //     for (int t = 0; t <= maxTime; t++) {
        //         for (int [] v : edges) {
        //             if (v[2] > t) continue;
        //             f[t][v[1]] = Math.min(f[t][v[1]], f[t-v[2]][v[0]] + passingFees[v[1]]);
        //             f[t][v[0]] = Math.min(f[t][v[0]], f[t-v[2]][v[1]] + passingFees[v[0]]);
        //         }
        //     }
        //     int ans = Integer.MAX_VALUE-1000000000;
        //     for (int i = 1; i <= maxTime; i++) 
        //         ans = Math.min(ans, f[i][n-1]);
        //     return ans == Integer.MAX_VALUE-1000000000 ? -1 : ans;
        // }


        // public int minDays(int n) {
        //     Queue<Integer> q = new LinkedList<>();
        //     Set<Integer> vis = new HashSet<>();
        //     q.offer(n);
        //     int size = 0, cur = 0, cnt = 0;
        //     while (!q.isEmpty()) {
        //         size = q.size();
        //         while (size-- > 0) {
        //             cur = q.poll();
        //             if (cur == 0) return cnt;
        //             if (cur == 1) return cnt + 1;
        //             if (cur % 2 == 0 && !vis.contains(cur / 2)) 
        //                 q.offer(cur / 2);
        //             if (cur % 3 == 0 && !vis.contains(cur / 3)) 
        //                 q.offer(cur / 3);
        //             if (!vis.contains(cur -1)) 
        //                 q.offer(cur - 1);
        //             vis.add(cur);
        //         }
        //         ++cnt;
        //     }
        //     return -1;
        // }
        // private int dfs(int n) {
        //     if (n <= 2) return n;
        //     if (m.containsKey(n)) return m.get(n);
        //     int res = n;
        //     res = Math.min(res, 1 + n % 2 + dfs(n / 2));
        //     res = Math.min(res, 1 + n % 3 + dfs(n / 3));
        //     m.put(n, res);
        //     return res;
        // }
        // Map<Integer, Integer> m = new HashMap<>();
        // public int minDays(int n) {
        //     return dfs(n);
        // }
        // Map<Integer, Integer> m = new HashMap<>();
        // public int minDays(int n) {
        //     if (m.containsKey(n)) return m.get(n);
        //     if (n <= 2) return n;
        //     m.put(n, 1 + Math.min(n % 2 + minDays(n / 2), n % 3 + minDays(n / 3)));
        //     return m.get(n);
        // }
//         public int minDays(int n) { // 这么写复杂度变成o(n2)了: 无脑动态规划， 扔了 !!!!
// // 这么写复杂度变成o(n2)了: 无脑动态规划， 扔了 !!!!
//             if (n <= 2) return n;
//             int [] dp = new int [n+1];
//             dp[1] = 1;
//             dp[2] = 2;
//             for (int i = 3; i <= n; i++) {
//                 dp[i] = i;
//                 for (int j = 0; j <= i; j++) { 
//                     if ((i-j) % 2 == 0)
//                         dp[i] = Math.min(dp[i], 1 + j + dp[(i-j) / 2]);
//                     if ((i-j) % 3 == 0)
//                         dp[i] = Math.min(dp[i], 1 + j + dp[(i-j) / 3]);
//                 }
//             }
//             // System.out.println("dp.length: " + dp.length);
//             // for (int z = 0; z < dp.length; ++z) 
//             //     System.out.print(dp[z] + ", ");
//             // System.out.println("");
//             return dp[n];
//         }

        
        // private int dfs(String s, int i) {
        //     System.out.println("\ni: " + i);
        //     if (i >= n) return 0;
        //     if (i == n-1) return s.charAt(i) == '*' ? (dp[i] = 9) : (s.charAt(i) == '0' ? (dp[i] = 0) : (dp[i] = 1));
        //     if (dp[i] > 0) return dp[i];
        //     int res = 0;
        //     if (s.charAt(i) == '0') return dp[i] = (int)dfs(s, i+1) % mod;
        //     if (s.charAt(i+1) == '0') 
        //         res = dfs(s, i+2) % mod; // 30 ? s.charAt(i+1) == '0'
        //     else { 
        //         res = (res + dfs(s, i+1)) % mod; // separate
        //         // System.out.println("\ni: " + i);
        //         // System.out.println("res 0: " + res);
        //         if (s.charAt(i) == '1' || ((s.charAt(i) == '2' || s.charAt(i) == '*') && (s.charAt(i+1) == '*' || s.charAt(i+1)-'a' <= 6))) // combine together with next digit
        //             if (s.charAt(i) == '1' || s.charAt(i+1) != '*')
        //                 res = (res + dfs(s, i+1)) % mod;
        //             // else if (s.charAt(i+1) != '*')
        //             //     res = (res + dfs(s, i+1)) % mod;
        //             else if ((s.charAt(i) == '2' || s.charAt(i) == '*') && s.charAt(i+1) == '*')
        //                 res = (res + (i+1 == n-1 ? 6 : 2 * dfs(s, i+1) / 3)) % mod;
        //         // System.out.println("\ni: " + i);
        //         // System.out.println("res 1: " + res);
        //     }
        //     return dp[i] = (int)res;
        // }
        // int mod = (int)(1e9 + 7);
        // int [] dp;
        // int n;
        // public int numDecodings(String s) {
        //     n = s.length();
        //     if (n == 1) return s.charAt(0) == '*' ? 9 : 1;
        //     dp = new int [n];
        //     dfs(s, 0);
        //     // System.out.println("dp.length: " + dp.length);
        //     // for (int z = 0; z < dp.length; ++z) 
        //     //     System.out.print(dp[z] + ", ");
        //     // System.out.println("");
        //     return dp[0];
        // }
        // String a = "**"; // 96


        // private int [] getMin(int [] a, int [] b) { // 这个题最近需要再写一遍
        //     if (a[0] > b[0]) return b;
        //     if (a[0] < b[0]) return a;
        //     if (a[1] > b[1]) return b;
        //     return a;
        // }
        // // dp[mask] = {a, b} where
        // // a - minimum number of session
        // // b - minimum time of last session
        // // The idea is to go through all tasks who belong to mask and optimally choose the last task 't' that was added to last session.
        // public int minSessions(int[] tasks, int sessionTime) {
        //     int n = tasks.length;
        //     int [][] dp = new int [1 << n][2];  // 在[1, 1 << n)范围内枚举每一个mask 计算其包含的时间的总和
        //     dp[0][0] = 1;
        //     dp[0][1] = 0;
        //     for (int i = 1; i < 1 << n; i++) {
        //         dp[i][0] = Integer.MAX_VALUE;
        //         dp[i][1] = 0;
        //         int sum = 0;
        //         for (int t = 0; t < n; t++) {
        //             if ((i & (1 << t)) == 0) continue;
        //             int [] pre = dp[(1 << t) ^ i];
        //             if (pre[1] + tasks[t] <= sessionTime)
        //                 dp[i] = getMin(dp[i], new int [] {pre[0], pre[1] + tasks[t]});
        //             else dp[i] = getMin(dp[i], new int []{pre[0]+1, tasks[t]});
        //         }
        //     }
        //     return dp[(1 << n) -1][0];
        // }
        // private int dfs(int [] arr, int sessionTime, int mask, int remainTime) {
        //     if (mask == 0) return 0;  // 这里面还有bug, 可是今天不想再看这个题了
        //     if (dp[mask][remainTime] != null) return dp[mask][remainTime];
        //     int ans = n;
        //     for (int i = 0; i < n; i++) {
        //         if (((mask >> i) & 1) == 1) {
        //             int newMask = ~(1 << i) & mask; // clear i th bit
        //             if (arr[i] <= sessionTime)
        //                 ans = Math.min(ans, dfs(arr, sessionTime, newMask, remainTime - arr[i])); // Consume current session
        //             else ans = Math.min(ans, dfs(arr, sessionTime, newMask, sessionTime - arr[i]) + 1); // Create new session
        //         }
        //     }
        //     return dp[mask][remainTime] = ans;
        // }
        // Integer [][] dp;
        // int n;
        // public int minSessions(int[] tasks, int sessionTime) {
        //     int n = tasks.length;
        //     dp = new Integer [1 << n][2];  // 在[1, 1 << n)范围内枚举每一个mask 计算其包含的时间的总和
        //     return dfs(tasks, sessionTime, (1 << n)-1, 0);
        // }
        // private void dfs(int [] arr, int t, int i, int cnt) { // cnt: sessionCnt
        //     if (cnt > res) return;
        //     if (i < 0) {
        //         res = Math.min(res, cnt);
        //         return;
        //     }
        //     for (int j = 0; j < cnt; j++) 
        //         if (sessions[j] + arr[i] <= t) { // 把当前task 放入旧的sessions里
        //             sessions[j] += arr[i];
        //             dfs(arr, t, i-1, cnt);
        //             sessions[j] -= arr[i];
        //         }
        //     sessions[cnt] += arr[i]; // 把当前task 放入新的sessions里
        //     dfs(arr, t, i-1, cnt + 1);
        //     sessions[cnt] -= arr[i];
        // }
        // int [] sessions;
        // int n, res;
        // public int minSessions(int[] tasks, int sessionTime) {
        //     n = tasks.length;
        //     res = n;
        //     sessions = new int [n];
        //     Arrays.sort(tasks);
        //     dfs(tasks, sessionTime, n-1, 0);
        //     return res;
        // }

        
        // private int dfs(int [][] arr, int t, int i, int j) { // t: steps, i: mouse, j: cat, mouse goes first
        //     if (t == 2 * n) return 0;
        //     if (i == j) return dp[t][i][j] = 2;
        //     if (i == 0) return dp[t][i][j] = 1;
        //     if (dp[t][i][j] != -1) return dp[t][i][j];
        //     int tmp = 0;
        //     if (t % 2 == 0) { // mouse's turn
        //         boolean catWin = true;
        //         for (int k = 0; k < arr[i].length; k++) {
        //             tmp = dfs(arr, t+1, arr[i][k], j);
        //             if (tmp == 1) return dp[t][i][j] = 1;
        //             else if (tmp != 2) catWin = false;
        //         }
        //         if (catWin) return dp[t][i][j] = 2;
        //         else return dp[t][i][j] = 0;
        //     } else { // cat's turn, can NOT step on node # 0
        //         boolean mouseWin = true;
        //         for (int k = 0; k < arr[j].length; k++) {
        //             if (arr[j][k] == 0) continue;
        //             tmp = dfs(arr, t+1, i, arr[j][k]);
        //             if (tmp == 2) return dp[t][i][j] = 2;
        //             else if (tmp != 1) mouseWin = false;
        //         }
        //         if (mouseWin) return dp[t][i][j] = 1;
        //         else return  dp[t][i][j] = 0;
        //     }
        // }
        // int [][][] dp;
        // int n;
        // public int catMouseGame(int[][] graph) {
        //     n = graph.length;
        //     dp = new int [2*n][n][n];
        //     for (int i = 0; i < 2*n; i++) 
        //         for (int j = 0; j < n; j++)
        //             Arrays.fill(dp[i][j], -1);
        //     dfs(graph, 0, 1, 2);
        //     return dp[0][1][2];
        // }


        // private boolean dfs(String [] arr, int t, int i, int j) {
        //     if (dp[t][i][j] != null) return dp[t][i][j];
        //     if (t == m*n*2) return false;
        //     if (arr[i/n].charAt(i%n) == 'F') return true;
        //     if (arr[j/n].charAt(j%n) == 'F') return false;
        //     if (i == j) return false;
        //     int r = 0, c = 0;
        //     if (t % 2 == 0) { // mouse's turn 老鼠的：只要它能赢一个状态就是赢了
        //         for (int [] d : dirs) 
        //             for (int k = 0; k <= mj; k++) {
        //                 r = i / n + d[0] * k;
        //                 c = i % n + d[1] * k;
        //                 if (r >= 0 && r < m && c >= 0 && c < n && arr[r].charAt(c) != '#') {
        //                     if (dfs(arr, t+1, r*n+c, j))
        //                         return dp[t][i][j] = true; // Mouse could win
        //                 } else break;
        //             }
        //         return dp[t][i][j] = false;
        //     } else { // cat's turn：但是当是猎的：需要猫不能赢，老鼠才能赢；但是当猫哪怕是赢了只一局，老鼠也就输了
        //         for (int [] d : dirs) 
        //             for (int k = 0; k <= cj; k++) {
        //                 r = j / n + d[0] * k;
        //                 c = j % n + d[1] * k;
        //                 if (r >= 0 && r < m && c >= 0 && c < n && arr[r].charAt(c) != '#') {
        //                     if (!dfs(arr, t+1, i, r*n+c))  // Can cat find a path that mouse looses in it?
        //                         return dp[t][i][j] = false; // Cat wins = mouse loose
        //                 } else break; // 上面这一点儿狠重要
        //             }
        //         return dp[t][i][j] = true;
        //     }
        // }
        // int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // Boolean [][][] dp;
        // int m, n, cj, mj;
        // public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
        //     m = grid.length;
        //     n = grid[0].length();
        //     cj = catJump;
        //     mj = mouseJump;
        //     dp = new Boolean [1001][m*n][m*n];
        //     int x = 0, y = 0;
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) 
        //             if (grid[i].charAt(j) == 'M')
        //                 x = i * n + j;
        //             else if (grid[i].charAt(j) == 'C')
        //                 y = i * n + j;
        //     return dfs(grid, 0, x, y);
        // }

        
        public void dijkstra(int n) {
            Queue<int []> q = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
            q.add(new int [] {n, 0});
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[n] = 0;
            int [] cur = null;
            int u = 0, d = 0;
            while (!q.isEmpty()) {
                cur = q.poll();
                u = cur[0];
                d = cur[1];
                if (dist[u] < d) continue;
                if (m.get(u) != null) 
                    for (int v : m.get(u).keySet()) 
                        if (dist[v] > dist[u] + m.get(u).get(v)) {
                            dist[v] = dist[u] + m.get(u).get(v);
                            q.offer(new int [] {v, dist[v]});
                        }
            }
        }
        private int dfs(int n, int i) { 
            if (i == n) return 1;
            if (dp[i] != -1) return dp[i];
            long res = 0;
            if (m.get(i) != null) {
                for (int v : m.get(i).keySet()) {
                    if (dist[i] > dist[v])
                        res = (res + dfs(n, v)) % mod;
                }
            }
            return dp[i] = (int)res;
        }
        HashMap<Integer, Map<Integer, Integer>> m = new HashMap<>();
        int mod = (int)(1e9+7);
        int [] dist;
        int [] dp;
        public int countRestrictedPaths(int n, int[][] edges) {
            for (int [] v : edges) {
                m.computeIfAbsent(v[0], k->new HashMap<>()).put(v[1], v[2]);
                m.computeIfAbsent(v[1], k->new HashMap<>()).put(v[0], v[2]);
            }
            dist = new int[n+1];
            dijkstra(n);
            dp = new int [n+1];
            Arrays.fill(dp, -1);
            return dfs(n, 1);
        }


        // public int maxProfit(int[] prices) {
        //     int n = prices.length;
        //     int [] sold = new int [n];
        //     int [] hold = new int [n];
        //     hold[0] = -prices[0];
        //     for (int i = 1; i < n; i++) {   // ith: do nothing, selling hold[i-1]
        //         sold[i] = Math.max((i >= 2 ? sold[i-1] : 0), hold[i-1] + prices[i]); // 今天卖了股票，或者今天什么也没有干
        //         hold[i] = Math.max(hold[i-1], (i >= 2 ? sold[i-2] : 0) - prices[i]); // 今天买了股票，或者今天什么也没有干
        //     }
        //     return Math.max(sold[n-1], hold[n-1]);
        // }

        
        // private int dfs(int i) {
        //     if (i < 0) return 0;
        //     if (i == 1) return dp[i] = 1;
        //     if (dp[i] > 0) return dp[i];
        //     int res = 0;
        //     for (int j = i/2; j >= 1; j--) 
        //         res = Math.max(res, Math.max(j, dfs(j)) * Math.max(i-j, dfs(i-j))); 
        //     return dp[i] = res;
        // }
        // int [] dp;
        // public int integerBreak(int n) {
        //     dp = new int [n+1];
        //     dfs(n);
        //     return dp[n];
        // }

        
        // public int nthUglyNumber(int n) {
        //     if (n <= 5) return n;
        //     int [] arr = new int [n];
        //     arr[0] = 1;
        //     int i = 0, ii = 0, iii = 0;
        //     int f = 2, ff = 3, fff = 5;
        //     for (int j = 1; j < n; j++) {
        //         int min = Math.min(Math.min(f, ff), fff);
        //         arr[j] = min;
        //         if (f == min) f = 2 * arr[++i];
        //         if (ff == min) ff = 3 * arr[++ii];
        //         if (fff == min) fff = 5 * arr[++iii];
        //     }
        //     return arr[n-1];
        // }
        
        // public int nthSuperUglyNumber(int n, int[] primes) { // 自己写的： Memory Limit Exceeded
        //     if (n == 1) return 1;
        //     int m = primes.length;
        //     Queue<Long> q = new PriorityQueue<>();
        //     q.offer(1l);
        //     long cur = 0;
        //     for (int i = 0; i < n; i++) {
        //         cur = q.poll();
        //         while (!q.isEmpty() && q.peek() == cur) q.poll(); // 下面一行，直接导致了这一行的再一次费力操作！！！
        //         for (int j = 0; j < m; j++) // 这一步重复加入数字了
        //             q.offer(cur * primes[j]);
        //     }
        //     return (int)cur;
        // }
        // static class Node implements Comparable<Node> {
        //     private int index;
        //     private int val;
        //     private int prime;
        //     public Node(int index, int val, int prime) {
        //         this.index = index;
        //         this.val = val;
        //         this.prime = prime;
        //     }
        //     public int compareTo(Node other) {
        //         return this.val - other.val;
        //     }
        // }
        // public int nthSuperUglyNumber(int n, int[] primes) {
        //     final int [] arr = new int[n];
        //     arr[0] = 1;              // 1 is the first ugly number
        //     final Queue<Node> q = new PriorityQueue<>();
        //     for (int i = 0; i < primes.length; ++i) 
        //         q.add(new Node(0, primes[i], primes[i]));
        //     for (int i = 1; i < n; ++i) {
        //         Node node = q.peek(); // get the min element and add to arr
        //         arr[i] = node.val;
        //         do {             // update top elements
        //             node = q.poll();
        //             node.val = arr[++node.index] * node.prime;
        //             q.add(node); // push it back
        //         } while (!q.isEmpty() && q.peek().val == arr[i]); // prevent duplicate
        //     }
        //     return arr[n - 1];
        // }
        // public int nthSuperUglyNumber(int n, int[] primes) {
        //     int m = primes.length;
        //     int [] ans = new int[n]; // 存放1-n个SuperUglyNumber
        //     ans[0] = 1;              // 第一个SuperUglyNumber是1
        //     int [] next = new int[m];
        //     for (int i=0; i < m; i++)
        //         next[i] = 0;         // 初始化
        //     int cnt = 1, min = Integer.MAX_VALUE, tmp = 0;
        //     while (cnt < n) {
        //         min = Integer.MAX_VALUE;
        //         for (int i = 0; i < m; i++){
        //              tmp = ans[next[i]] * primes[i];
        //              min = Math.min(min, tmp);
        //         }
        //         for (int i = 0; i < m; i++)
        //             if (min == ans[next[i]] * primes[i])
        //                 next[i]++;
        //         ans[cnt++] = min;			
        //     }
        //     return ans[n-1];		
        // }


        // // by saving the previous best like-time coefficient and its corresponding element sum.
        // private int dfs(int [] arr, int i) { // 不知道这里的best like-time coefficient是什么
        //     if (i == n-1) return dp[i] = arr[i];
        //     if (dp[i] != -1) return dp[i];
        //     int res = Integer.MIN_VALUE;
        // }
        // int [] dp; // 这里的状态应该是不对的，可是不知道怎么存第一个参数
        // int n;
        // public int maxSatisfaction(int[] arr) {
        //     n = arr.length;
        //     Arrays.sort(arr);
        //     dp = new int [n];
        //     Arrays.fill(dp, -1);
        //     return dfs(arr, 0);
        // }

//         // 先预处理得到单行的所有有效涂色方案，
//         // 再进一步计算得到每种单行方案对应的有效邻行方案
//         // 在此基础上，结合动态规划方法，逐行求解各种涂色状态对应的方案总数，最后统计得到总方案数。
//         public int colorTheGrid(int m, int n) {
// // 获得单行所有涂色方案
//             Map<Integer, List<Integer>> line = new HashMap<>(); //  3^m ways of paying one row
//             int range = (int)Math.pow(3, m); // 用0、1、2表示各个网格的颜色，key为方案对应的数值，value为方案对应的数组
//             for (int i = 0; i < range; i++) {
//                 List<Integer> list = new ArrayList<>(); //  val val values (0, 1, 2) of every m cols into list
//                 int val = i;
//                 for (int j = 0; j < m; j++) {
//                     list.add(val % 3);
//                     val /= 3;
//                 }
//                 boolean valid = true; // 确认该数组中是否存在相邻位置颜色相同
//                 for (int j = 1; j < m; j++) 
//                     if (list.get(j-1) == list.get(j)) {
//                         valid = false;
//                         break;
//                     }
//                 if (valid) line.put(i, list); // 相邻网格颜色均不同，为有效方案，加入哈希表
//             }
// // 预处理得到每种单行方案对应的有效邻行方案
//             Map<Integer, List<Integer>> adj = new HashMap<>();
//             Iterator it = line.entrySet().iterator();
//             while (it.hasNext()) {     //  3^m ways of paying one row
//                 Map.Entry entry = (Map.Entry)it.next();
//                 int va = (int)entry.getKey();
//                 List<Integer> lva = (List<Integer>)entry.getValue();
//                 adj.put(va, new ArrayList<Integer>());
//                 Iterator itb = line.entrySet().iterator();
//                 while (itb.hasNext()) { //  3^m ways of paying one row
//                     Map.Entry enb = (Map.Entry)itb.next(); 
//                     int vb = (int)enb.getKey();
//                     List<Integer> lvb = (List<Integer>)enb.getValue();
//                     boolean valid = true;
//                     for (int i = 0; i < m; i++) 
//                         if (lva.get(i) == lvb.get(i)) {
//                             valid = false;
//                             break;
//                         }
//                     if (valid) adj.get(va).add(vb); // among 3^m ways of painting one row, how many is valid, and valid mask into adj.get(va);
//                 }
//             }
// // 动态规划，逐行求解方案数
//             int mod = (int)(1e9+7);
//             long [] dp = new long [range];  // 上一行各种涂色方案对应的总方法数
//             for (int i = 0; i < range; i++) // 初始化
//                 dp[i] = line.containsKey(i) ? 1 : 0;
//             for (int i = 1; i < n; i++) {   // 从第二行开始动态规划
//                 long [] cur = new long [range];  // 新一行各种涂色方案对应的总方法数
//                 for (int j = 0; j < range; j++) 
//                     if (adj.containsKey(j)) {    // 该方案有效
//                         for (int v : adj.get(j)) // 遍历有效的相邻方案
//                             cur[j] = (cur[j] + dp[v]) % mod; // 总方法数累加
//                     }
//                 System.arraycopy(cur, 0, dp, 0, range);
//             }
//             long ans = 0;
//             for (int i = 0; i < range; i++) 
//                 ans = (ans + dp[i]) % mod;
//             return (int)ans;
//         }
        // time O( (2^5) *2 * N)
        // SPACE O(N)
        //     For m = 5, there are at most 48 valid states for a single column so we can handle it column by column.
        //     We encode the color arrangement by bit mask (3 bit for a position) and use dfs to generate the all valid states.
        //         Then for each column, we iterator all the states and check if its still valid with the previous column.
// time O( (2^5) *2 * N)
// SPACE O(N)
//     For m = 5, there are at most 48 valid states for a single column so we can handle it column by column.
//     We encode the color arrangement by bit mask (3 bit for a position) and use dfs to generate the all valid states.
//         Then for each column, we iterator all the states and check if its still valid with the previous column.
        // public void helper(int m, int pos, HashMap<Integer, Long> dic, int pre, int cur) {
        //     if (pos == m) {
        //         dic.put(cur, 1L);
        //         return;
        //     }
        //     //不需要{1, 2, 4} {0, 1, 2} is ok 每个格（实际占用2个bit?）
        //     for (int i = 0; i < 3; i++) {
        //         if (i == pre) continue;
        //         helper(m, pos + 1, dic, i, (cur << 3) | (1 << i)); // 每处理一格，将当前状态左移3位（实际占用2个bit?）
        //     }
        // }
        // static int mod = (int) 1e9 + 7;
        // public int colorTheGrid(int m, int n) {
        //     HashMap<Integer,Long> dic = new HashMap<>();
        //     helper(m, 0, dic, -1, 0);     // 这应该就是我想找的精巧不占多少空间的mask了，可是有点儿看不懂
        //     HashSet<Integer> set = new HashSet<>(dic.keySet());
        //     for (int i = 1; i < n; i++) { // 动态规划： 用两个图像滚动数组一样轮流记载得出答案
        //         HashMap<Integer, Long> tmp = new HashMap<>();
        //         for (int x: set) 
        //             for (int y : set) 
        //                 if ((x & y) == 0) // 相邻涂色方案为有效方案
        //                     tmp.put(y, (tmp.getOrDefault(y, 0L) + dic.get(x)) % mod);
        //         dic = tmp;
        //     }
        //     long res = 0L;
        //     for (Long x : dic.values()) {
        //         res += x;
        //         res %= mod;
        //     }
        //     return (int) res;
        // }


        // public int minLen(int len, int i, int j) {
        //     int min = Math.min(i, j);
        //     int max = Math.max(i, j);
        //     return Math.min(Math.abs(i - j), Math.abs(len + min - max));
        // }
        // public int helper(String ring, int i, String key, int j) {
        //     if (j >= n) return 0;
        //     if (dp[i][j] > 0) return dp[i][j];
        //     List<Integer> nextPos = map.get(key.charAt(j));
        //     int min = Integer.MAX_VALUE;
        //     for (int k = 0; k < nextPos.size(); k++) 
        //         min = Math.min(min, helper(ring, nextPos.get(k), key, j+1) + minLen(m, nextPos.get(k), i) + 1);
        //     dp[i][j] = min;
        //     return dp[i][j];
        // }
        // Map<Character, List<Integer>> map = new HashMap<>(); // 这个图把钥匙中每个字母的出现位置记住了，以后拿去用不搜
        // int[][] dp;
        // int m, n;
        // public int findRotateSteps(String ring, String key) {
        //     m = ring.length();
        //     n = key.length();
        //     dp = new int[m][n];
        //     for (int i = 0; i < m; i++) {
        //         if (key.indexOf(ring.charAt(i)) == -1) continue;
        //         char c = ring.charAt(i);
        //         List<Integer> li = map.get(c);
        //         if (li == null) {
        //             li = new ArrayList<>();
        //             map.put(c, li);
        //         }
        //         li.add(i);
        //     }
        //     return helper(ring, 0, key, 0);
        // }
        // public int findRotateSteps(String ring, String key) {
        //     int m = key.length(); 
        //     int n = ring.length();
        //     int [][] dp = new int[m+1][n];
        //     int diff = 0, step = 0;
        //     for (int i = m-1; i >= 0; i--) {
        //         for (int j = 0; j < n; j++) {
        //             dp[i][j] = Integer.MAX_VALUE;
        //             for (int k = 0; k < n; k++) {
        //                 if (ring.charAt(k) == key.charAt(i)) {
        //                     diff = Math.abs(j - k);
        //                     step = Math.min(diff, n-diff);
        //                     dp[i][j] = Math.min(dp[i][j], step + dp[i+1][k]);
        //                 }
        //             }
        //         }
        //     }
        //     return dp[0][0] + m;
        // }
        // private int helper(String s, String t, int i, int j) { // s: ring, t: key, i: idxRing, j: idxKey
        //     Map<Integer, Integer> locMap = mem.get(i);
        //     if (locMap != null) 
        //         if (locMap.get(j) != null) return locMap.get(j);
        //     if (j == n) return 0;
        //     int step = 0, k = i;
        //     boolean foundK = false;
        //     for (; step <= m/2; ++step) {
        //         k = (i + step + m) % m;
        //         if (s.charAt(k) == t.charAt(j)) {
        //             foundK = true;
        //             break;
        //         }
        //     }
        //     int rstep = 0, x = i;
        //     boolean foundX = false;
        //     while (rstep <= m/2) {
        //         x = (i - rstep + m) % m;
        //         if (s.charAt(x) == t.charAt(j)) {
        //             foundX = true;
        //             break;
        //         }
        //         rstep++;
        //     }
        //     int min = Integer.MAX_VALUE;
        //     if (foundK) min = helper(s, t, k, j+1) + step + 1;
        //     if (foundX) min = Math.min(min, helper(s, t, x, j+1) + rstep + 1);
        //     if (locMap == null) {
        //         locMap = new HashMap<>();
        //         mem.put(i, locMap);
        //     }
        //     locMap.put(j, min);
        //     return min;
        // }
        // Map<Integer, Map<Integer, Integer>> mem = new HashMap<>();
        // int m, n;
        // public int findRotateSteps(String ring, String key) {
        //     m = ring.length();
        //     n = key.length();
        //     return helper(ring, key, 0, 0);
        // }


        // public int findSubstringInWraproundString(String p) {
        //     int n = p.length();
        //     int [] arr = new int [n];
        //     int [] cnt = new int [26];
        //     for (int i = 0; i < n; i++) 
        //         arr[i] = p.charAt(i) - 'a';
        //     int res = 0, maxLen = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (i > 0 && (arr[i-1]+1) % 26 == arr[i]) // 判断前一个位置上的字符比现位字符小1
        //             ++maxLen;
        //         else maxLen = 1;
        //         cnt[arr[i]] = Math.max(cnt[arr[i]], maxLen);
        //     }
        //     for (int i = 0; i < 26; i++) 
        //         res += cnt[i];
        //     return res;
        // }


        // // 自顶向下 （记忆化搜索）
        // // 每个dfs搜索当前状态为城市i，油量f到达终点的方案数。这样决策的时候就很直观：当前这个状态的方案数，由可去的城市的，且油量为剩余油量的到达终点方案数加起来。
        // // 初始化：每个状态都初始化为-1。
        // // 当走到终点时，这个状态的可走到终点的方案数+1。
        // private int dfs(int [] arr, int end, int idx, int fu) {
        //     if (dp[idx][fu] != -1) return dp[idx][fu];
        //     dp[idx][fu] = 0;
        //     if (idx == end) {
        //         dp[idx][fu] += 1;
        //         dp[idx][fu] %= mod;
        //     }
        //     for (int i = 0; i < n; i++) {
        //         if (i == idx || Math.abs(arr[i] - arr[idx]) > fu) continue;
        //         dp[idx][fu] = (dp[idx][fu] + dfs(arr, end, i, fu-Math.abs(arr[i]-arr[idx]))) % mod;
        //     }
        //     return dp[idx][fu];
        // }
        // int mod = (int)1e9 + 7;
        // int [][] dp;
        // int n;
        // public int countRoutes(int[] locations, int start, int finish, int fuel) {
        //     n = locations.length;
        //     if (fuel < Math.abs(locations[start] - locations[finish])) return 0;
        //     dp = new int[n][fuel+1];
        //     for (int i = 0; i < n; i++) 
        //         Arrays.fill(dp[i], -1);
        //     dfs(locations, finish, start, fuel);
        //     return dp[start][fuel];
        // }
        // // 自底向上
        // // 为什么想到动态规划：最优子结构：到达终点的方案数肯定由到达其他点的,不同油量的方案数求和。
        // //     如何定义状态：城市肯定在状态里，因为其他城市有不同的剩余油量的状态，且油量为0无法到达，也成为限制之一。所以油量也必须在状态里：
        // //     d p ( i , f ) dp(i, f)dp(i,f)表示到达第 i ii个城市，剩余油量为f ff 的方案数。
        // //     状态转移：第i ii个城市，可以由除本身外的城市转移过来，只要剩余的油量不小于所用的油量就够了，最后答案是求总共的个数，所以只要方案数相加就行:
        // //     dp(i,f−dist)=dp(i,f−dist)+dp(k,f)(f−dist>=0)
        // //     枚举顺序：每个城市肯定都要枚举一遍，因为还需要从另一个城市转移过来，所以除本身外的城市肯定还要再枚举一遍。
        // //     关键是油量的枚举，因为油量肯定是慢慢减少的，可以想到是逆序枚举，而且油量要放在最外层枚举。因为如果先枚举城市i ii，再枚举城市j jj，再枚举油量的话，只是不断更新了i ii城市方案数，而j jj城市不同油量的方案数根本没变化。
        // // dp：最优子结构 到达终点的方案数肯定由到达其他点的,不同油量的方案数求和
        // // 搜索：反过来 在第 i 个城市到达 fin 的方案数，也可以由其他的点到达 fin 的方案数转移过来， 但是油量有限制，所以油量肯定在状态里
        // // 所以城市 和 剩余油量肯定在状态里
        // // dp(i, j) 表示到达第 i 个城市，剩余油量为 j 的方案数
        // // dp(i, j) = dp(i, j) + dp(k, j - dist)
        // public int countRoutes(int[] locations, int start, int finish, int fuel) {
        //     int n = locations.length;
        //     if (fuel < Math.abs(locations[start] - locations[finish])) return 0;
        //     int [][] dp = new int[n][fuel+1];
        //     dp[start][fuel] = 1; // 初始点且燃料满的点方案数为1
        //     int leftFu = 0, mod = (int)1e9 + 7;
        //     for (int j = fuel; j >= 0; j--) { // fuel leftover
        //         for (int i = 0; i < n; i++) { // cur city
        //             for (int k = 0; k < n; k++) { // next city
        //                 if (i == k) continue;
        //                 leftFu = j - Math.abs(locations[i] - locations[k]);
        //                 if (leftFu < 0) continue;
        //                 dp[i][leftFu] = (dp[i][leftFu] + dp[k][j]) % mod; // 这里好别扭呀
        //             }
        //         }
        //     }
        //     int ans = 0;
        //     for (int i = 0; i <= fuel; i++) 
        //         ans = (ans + dp[finish][i]) % mod;
        //     return ans;
        // }


        // // 动态规划，递归可以使逻辑简单（本质还是动态规划）将多边形起
        // // 始位置设为start，end, 用一个数组dp来记录任意起始位置的score
        // // 为了计算dp[start][end], 我们用一个index k在start到end之间遍
        // // 历dp[start][end] = min(dp[start][k] + dp[k][end] + A[start]
        // // * A[k] * A[end])结果为dp[0][n - 1]注意：相邻的dp[i][i + 1]
        // // = 0, 因为两条边无法组成三角形
        // private int dfs(int [] arr, int x, int y) {
        //     if (y - x < 2) return dp[x][y] = 0;
        //     if (dp[x][y] > 0) return dp[x][y];
        //     int min = Integer.MAX_VALUE;
        //     for (int i = x+1; i < y; i++) 
        //         min = Math.min(min, dfs(arr, x,  i) + dfs(arr, i, y) + arr[x]*arr[i]*arr[y]);
        //     return dp[x][y] = min;
        // }
        // int [][] dp;
        // int n;
        // public int minScoreTriangulation(int[] arr) {
        //     n = arr.length;
        //     dp = new int [n][n];
        //     return dfs(arr, 0, n-1);
        // }


        // When the draws sum up to K, it stops, calculate the possibility K<=sum<=N.
        //     Think about one step earlier, sum = K-1, game is not ended and draw largest card W.
        //     K-1+W is the maximum sum could get when game is ended. If it is <= N, then for sure the possiblity when games end ans sum <= N is 1.
        //     Because the maximum is still <= 1.
        //     Otherwise calculate the possibility sum between K and N.
        //     Let dp[i] denotes the possibility of that when game ends sum up to i.
        //     i is a number could be got equally from i - m and draws value m card.
        //     Then dp[i] should be sum of dp[i-W] + dp[i-W+1] + ... + dp[i-1], devided by W.
        //     We only need to care about previous W value sum, accumlate winSum, reduce the possibility out of range.
        //     Time Complexity: O(N).
        //     Space: O(N).
        // public double new21Game(int n, int k, int w) { // k : threshold
        //     if (k == 0 || n >= (k + w)) return 1.0;
        //     if (k > n) return 0;
        //     double [] dp = new double [n+1];
        //     dp[0] = 1.0;
        //     double winSum = 1;
        //     double res = 0;
        //     for (int i = 1; i <= n; i++) {
        //         dp[i] = winSum / w;
        //         if (i < k) winSum += dp[i];
        //         else res += dp[i];
        //         if (i >= w) winSum -= dp[i-w];
        //     }
        //     return res;
        // }

        
        // public int firstDayBeenInAllRooms(int [] nextVisit) {
        //     int n = nextVisit.length, mod = (int)1e9 + 7;
        //     long [] dp = new long [n];
        //     dp[0] = 0;
        //     for (int i = 1; i < n; i++) 
        //         dp[i] = (2 * dp[i-1] % mod + mod - dp[nextVisit[i-1]] + 2) % mod;
        //     return (int)dp[n-1];
        // }


        // Map<String, String> dp = new HashMap<>();
        // int m, n;
        // public String kthSmallestPath(int[] destination, int k) {
        //     m = destination[0];
        //     n = destination[1];
        //     return dfs(m, n, k);
        // }


        // public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        //     int m = group.length;
        //     int [][] dp = new int [minProfit + 1][m];
        // }


        // 设 dp[0][i] 表示不交换 A[i] 和 B[i] 在下标 i 的交换次数
        // 设 dp[1][i] 表示交换 A[i] 和 B[i] 在下标 i 的交换次数
        // 可以看到交换与否只取决与前一个状态, 可以将空间复杂度压缩到 O(1)
        //     时间复杂度为 O(n), 空间复杂度为 O(1)
        // public int minSwap(int[] a, int[] b) {
        //     int n = a.length;
        //     int [][] dp = new int [2][n];
        //     for (int [] row : dp) 
        //         Arrays.fill(row, Integer.MAX_VALUE);
        //     dp[0][0] = 0;
        //     dp[1][0] = 1;
        //     for (int i = 1; i < n; i++) {
        //         if (a[i] > a[i-1] && b[i] > b[i-1]) {
        //             dp[0][i] = Math.min(dp[0][i], dp[0][i-1]);    // 不需要交换不用增加交换次数
        //             dp[1][i] = Math.min(dp[1][i], dp[1][i-1] + 1);// 如果要交换前一个也必须交换才能满足递增的条件
        //         }
        //         if (a[i] > b[i-1] && b[i] > a[i-1]) {
        //             dp[0][i] = Math.min(dp[0][i], dp[1][i-1]);    // 表示 i - 1 位置发生交换  
        //             dp[1][i] = Math.min(dp[1][i], dp[0][i-1] + 1);// 表示在 i - 1 不换的基础上, i 发生了交换 
        //         }
        //     }
        //     return Math.min(dp[0][n-1], dp[1][n-1]);
        // }


        // public int maxSatisfaction(int[] arr) {
        //    int n = arr.length;
        //     Arrays.sort(arr);
        //     int sum = 0, max = 0;
        //     for (int i = n-1; i >= 0; i--) {
        //         sum = 0;
        //         for (int j = i; j < n; j++) 
        //             sum += (j-i+1)*arr[j];
        //         max = Math.max(max, sum);
        //     }
        //     return max;
        // }

        // 求摆放前i本书需要的最小高度，首先需要求摆放前i-1书需要的最小高度，以此类推，最初需要计算的是摆放第0本书需要的最小高度，也就是0。
        // 根据前i-1本书求前i书需要的最小高度的思路是：
        // 尝试①将第i本书放在前i-1本书的下面
        // 以及②将前i-1本书的最后几本和第i本书放在同一层两种方案，看哪种方案高度更小就用哪种方案，依次求出摆放前1,…,n本书需要的最小高度。
        // public int minHeightShelves(int[][] books, int shelfWidth) {
        //     int [] dp = new int [books.length + 1];
        //     for (int i = 1; i < dp.length; i++) { // 依次求摆放前i本书的最小高度
        //         int width = books[i-1][0];
        //         int height = books[i-1][1];
        //         dp[i] = dp[i-1] + height;
        //         // 将前i - 1本书从第i - 1本开始放在与i同一层，直到这一层摆满或者所有的书都摆好
        //         for (int j = i-1; j > 0 && width + books[j-1][0] <= shelfWidth; j--) {
        //             height = Math.max(height, books[j-1][1]); // 每层的高度由最高的那本书决定
        //             width += books[j-1][0];
        //             dp[i] = Math.min(dp[i], dp[j-1] + height);// 选择高度最小的方法
        //         }
        //     }            
        //     return dp[books.length];
        // }


        // 基本思路：
        // 在本题中，应该假设节点是从小到大存储的。
        // 本题有两个难点，第一个怎么把所有的可能性都列出来？由于节点数小于15，可以考虑用枚举法，一共N位，每一位对应0或者1，组成的数值表示一个状态，
        // 对于1<state<=2^15,对于每一个状态state，当其有两个以上的节点，且对应的节点构成一棵子树才算合理的。
        // 但是怎么判断那？首先采用邻接表存储节点信息，只有下一个节点在邻接表中和当前的状态state中才可以。
        //     第二个难点，怎么找到当前state的最大距离，以当前树为根节点，可以分为两种状态，
        //     a)以当前节点为根节点的树的最大距离:l_depth+r_depth+1==》sub_d1+sub_2-2*d;
        //     b)以当前树的某一节点为根节点的树;
        // public int [] countSubgraphsForEachDiameter(int n, int[][] edges) {
        //     int [] res = new int [n-1];
        //     List<List<int []>> subsets = new ArrayList<>();
        //     generateSubsets(edges, new ArrayList<int []>(), subsets, 0);
        //     for (List<int []> subset : subsets) 
        //         solve(subset, res);
        //     return res;
        // }
        // private void solve(List<int []> subset, int [] res) {
        //     if (!isValidGraph(subset)) return;
        //     Map<Integer, List<Integer>> graph = new HashMap<>();
        //     for (int [] eg : subset) {
        //         graph.computeIfAbsent(eg[0], k -> new ArrayList<>()).add(eg[1]);
        //         graph.computeIfAbsent(eg[1], k -> new ArrayList<>()).add(eg[0]);
        //     }
        //     int max = 1;
        //     for (Integer key : graph.keySet()) {
        //         if (graph.get(key).size() == 1) {
        //             int [] longest = new int [] {1}; // 减少global变量的数量
        //             Set<Integer> vis = new HashSet<>();
        //             vis.add(key);
        //             dfs(graph, vis, key, longest, 0);
        //             max = Math.max(max, longest[0]);
        //         }
        //     }
        //     res[max - 1]++;
        // }
        // private void dfs(Map<Integer, List<Integer>> graph, Set<Integer> vis, int idx, int [] longest, int level) {
        //     longest[0] = Math.max(longest[0], level);
        //     for (Integer node : graph.get(idx)) 
        //         if (vis.add(node)) // Set.add(element) return false if it contains element already
        //             dfs(graph, vis, node, longest, level + 1);
        // }
        // private boolean isValidGraph(List<int []> subset) {
        //     Set<Integer> nodes = new HashSet<>();
        //     for (int [] cur : subset) {
        //         nodes.add(cur[0]);
        //         nodes.add(cur[1]);
        //     }
        //     return nodes.size() - 1 <= subset.size();
        // }
        // private void generateSubsets(int [][] arr, List<int []> cur, List<List<int []>> res, int idx) {
        //     if (idx == arr.length) return; // arr.length <= 15, 用回塑法直接生成subsets,但是这是相对耗时的操作
        //     for (int i = idx; i < arr.length; i++) {
        //         cur.add(arr[i]);
        //         res.add(new ArrayList<>(cur));
        //         generateSubsets(arr, cur, res, i+1);
        //         cur.remove(cur.size()-1);
        //     }
        // }
        // One way in which we can find the diameter of a tree is using DFS, just like if our tree is represented using tree nodes instead of as grpah
        //     1. Make a call to DFS from any node as root, lets say 1 as root
        //     2. Maintain a global max parameter
        //     3. For each call to dfs, of all current node's children (excluding parent)
        //        find top two distances from current node to any leaf reachable from current node
        //     4. Sum of these top two distances froms the longes path passing through current node to all its children. Update if this path is maximum
        //     5. return 1 + top distance for this dfs call. Need to add 1 since,
        //        max length of path that can be reached from current ndoe is current ndoe + max distance reachable from current ndoes's children
//         int ans = 0, vis = 0;
//         int [] res;
//         public int [] countSubgraphsForEachDiameter(int n, int[][] edges) {
//             res = new int [n-1];
//             ans = 0; vis = 0;
//             Map<Integer, List<Integer>> graph = new HashMap<>();
//             for (int [] i : edges) { // if our node is 5, we store it as 1 << 4 which is 2^4
//                 graph.computeIfAbsent(1 << (i[0]-1), ArrayList::new).add(1 << (i[1]-1));
//                 graph.computeIfAbsent(1 << (i[1]-1), ArrayList::new).add(1 << (i[0]-1));
//             }
//             int range = (1 << n) - 1;  // (int)Math.pow(2, n) - 1;
//             for (int subset = 3; subset <= range; subset++) {
//                 boolean isPowerOf2 = subset != 0 && (subset & (subset - 1)) == 0; // is power of 2
//                 if (isPowerOf2) continue;      // Single node subtrees can be excluded.
//                 ans = 0; vis = 0;
//                 dfs(graph, subset, Integer.highestOneBit(subset), -1); // Integer.highestOneBit(subset): subset: 0b1100, highest: 0b1000
//                 if (vis == subset)   // If visited is not equal to our current subset, all nodes are not reachable.
//                     res[ans - 1] ++; // In otherwords is not a proper subtree, hence dont include in the answer
//             }
//             return res;
//         }
//         // we can pass any node in this subset as root for dfs, we are passing node represented with highest set bit as root
//         // pass -1 as parent of root, since it has no root
//         private int dfs(Map<Integer, List<Integer>> graph, int subset, int cur, int pre) {
//             if ((subset & cur) == 0) return 0;
//             vis = vis | cur; 
//             int fstMax = 0, sndMax = 0;
//             for (Integer next : graph.get(cur)) {
//                 if (next == pre) continue;
//                 int dist = dfs(graph, subset, next, cur);
//                 if (dist > fstMax) {
//                     sndMax = fstMax;
//                     fstMax = dist;
//                 } else sndMax = Math.max(sndMax, dist);
//             }
//             ans = Math.max(ans, fstMax + sndMax); // top two distances from this node c
// // top distance this cur node to any leaf is topdistance from c's children + 1. Adding 1 since we need to include cur node
//             return 1 + fstMax; // 这里要再想一下 ？？？
//         }


        // public double getProbability(int[] balls) {
        //     int sum = Arrays.stream(balls).sum();
        //     double all = allCases(balls, 0, 0, 0, 0, 0, sum);
        //     double valid = casesWithEqualDistinctBalls(balls, 0, 0, 0, 0, 0, sum);
        //     return (1.0 * valid / all);
        // }
        // // disF = distinct balls in first bin
        // // disS = distinct balls in second bin
        // // f = number of balls in first bin
        // // s = number of balls in second bin
        // public double allCases(int [] arr, int pos, int f, int s, int disF, int disS, int sum) {
        //     if (pos == arr.length) {
        //         // for all cases, we just need to check if both bins have same number of balls or not
        //         if (f == s) return fact(sum / 2) * fact(sum / 2); // numerator of our permutations
        //         return 0;
        //     }
        //     // we put all balls in second bin
        //     double ans = 1.0 * allCases(arr, pos+1, f, s+arr[pos], disF, disS+1, sum) / fact(arr[pos]);
        //     // we put all balls in first bin
        //     ans += 1.0 * allCases(arr, pos+1, f+arr[pos], s, disF+1, disS, sum) / fact(arr[pos]);
        //     for (int i = 1; i < arr[pos]; i++) // 把每一种颜色的球放到两个里面盒子里都有
        //         ans += 1.0 * allCases(arr, pos+1, f+i, s+arr[pos]-i, disF+1, disS+1, sum) / (fact(i) * fact(arr[pos]-i));
        //     return ans;
        // }
        // public double casesWithEqualDistinctBalls(int [] arr, int pos, int f, int s, int disF, int disS, int sum) {
        //     if (pos == arr.length) {
        //         if (f == s && disF == disS) return fact(sum / 2) * fact(sum / 2);
        //         return 0;
        //     }
        //     double ans = 1.0 * casesWithEqualDistinctBalls(arr, pos+1, f, s+arr[pos], disF, disS+1, sum) / fact(arr[pos]);
        //     ans += 1.0 * casesWithEqualDistinctBalls(arr, pos+1, f+arr[pos], s, disF+1, disS, sum) / fact(arr[pos]);
        //     for (int i = 1; i < arr[pos]; i++) 
        //         ans += 1.0 * casesWithEqualDistinctBalls(arr, pos+1, f+i, s+arr[pos]-i, disF+1, disS+1, sum) / (fact(i) * fact(arr[pos]-i));
        //     return ans;
        // }
        // private double fact(double n) {
        //     double res = 1;
        //     for (int i = 2; i <= n; i++) 
        //         res = res * i;
        //     return res;
        // }

        // private long dfs(String s, Set<Integer> si, int idx, )
        // long [] dp;
        // int n, mod = (int)1e9 + 7;
        // public int numPermsDISequence(String s) {
        //     n = s.length();
        //     dp = new long [n+1];
        //     Set<Integer> si = new HashSet<>();
        //     for (int i = 0; i <= n; i++) 
        //         si.add(i);
        //     return dfs(s, si, 0, -1);
        // }

        
        // public int numPermsDISequence(String s) {
        //     int n = s.length(), mod = (int)1e9 + 7, res = 0;
        //     int [][] dp = new int [n+1][n+1];
        //     dp[0][0] = 1;
        //     for (int i = 1; i <= n; i++) 
        //         for (int j = 0; j <= i; j++) // 考虑当前最后一个元素为j
        //             if (s.charAt(i-1) == 'D')
        //                 // 可以把序列中所有大于等于j的元素都加上1得到新序列（这个时候是不会改变当前序列的大小关系的），再把j添加到序列末尾得到
        //                 for (int k = j; k <= i; k++) 
        //                     dp[i][j] = (dp[i][j] + dp[i-1][k]) % mod;
        //             else // 考虑当前最后一个元素为j
        //                 // 把该序列中所有大于等于j(k < j <= i)的数字都加上1，并在末尾添加一个j得到dp[i][j]中的一种方案
        //                 for (int k = 0; k < j; k++) // 把序列中所有大等于j的元素都加上1,再把j放在序列末尾得到
        //                     dp[i][j] = (dp[i][j] + dp[i-1][k]) % mod;
        //     for (int i = 0; i <= n; i++) 
        //         res = (res + dp[n][i]) % mod;
        //     return (int)res;
        // }


        // public String getLongestCommonSubsequence(String S, String T) { // 标准模板，记住
        //     int m = S.length();
        //     int n = T.length();
        //     int [][] dp = new int [m+1][n+1];
        //     for (int i = 1; i <= m; i++) 
        //         for (int j = 1; j <= n; j++) 
        //             if (S.charAt(i-1) == T.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
        //             else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        //     int i = m, j = n;
        //     StringBuilder sb = new StringBuilder();
        //     while (i-1 >= 0 && j-1 >= 0 && dp[i][j] > 0) {
        //         if (S.charAt(i-1) == T.charAt(j-1)) {
        //             sb.insert(0, S.charAt(i-1));
        //             --i;
        //             --j;
        //         } else {
        //             if (dp[i-1][j] >= dp[i][j-1]) --i;
        //             else --j;
        //         }
        //     }
        //     return sb.toString();
        // }
        // public String shortestCommonSupersequence(String s, String t) {
        //     int m = s.length();
        //     int n = t.length();
        //     int i = 0, j = 0;
        //     String sub = getLongestCommonSubsequence(s, t);
        //     String res = "";
        //     for (char c : sub.toCharArray()) {
        //         while (s.charAt(i) != c) {
        //             res += s.charAt(i);
        //             i++;
        //         }
        //         while (t.charAt(j) != c) {
        //             res += t.charAt(j);
        //             j++;
        //         }
        //         res += c;
        //         i++;
        //         j++;
        //     }
        //     return res + s.substring(i) + t.substring(j);
        // }
        // public void longestCommonSubsequence(String S, String T) { // 标准模板，记住
        //     int m = S.length();
        //     int n = T.length();
        //     for (int i = 1; i <= m; i++) 
        //         for (int j = 1; j <= n; j++) 
        //             if (S.charAt(i-1) == T.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
        //             else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        // }
        // int [][] dp;
        // public String shortestCommonSupersequence(String s, String t) {
        //     int m = s.length();
        //     int n = t.length();
        //     dp = new int [m+1][n+1];
        //     longestCommonSubsequence(s, t); // fill dp table
        //     int i = m, j = n;
        //     StringBuilder sb = new StringBuilder();
        //     while (i-1 >= 0 && j-1 >= 0) {
        //         if (s.charAt(i-1) == t.charAt(j-1)) {
        //             sb.append(s.charAt(i-1));
        //             --i;
        //             --j;
        //         } else {
        //             if (dp[i][j] == dp[i-1][j]) {
        //                 sb.append(s.charAt(i-1));
        //                 --i;
        //             } else {
        //                 sb.append(t.charAt(j-1));
        //                 --j;
        //             }
        //         }
        //     }
        //     if (i > 0) sb.append((new StringBuilder(s.substring(0, i))).reverse());
        //     if (j > 0) sb.append((new StringBuilder(t.substring(0, j))).reverse());
        //     return sb.reverse().toString();
        // }


        
    }

    public static void main(String[] args) {
        Solution s  =  new Solution();

        String a = "abac";
        String b = "cab";

        String r = s.shortestCommonSupersequence(a, b);
        System.out.println("r: " + r);
    }
}