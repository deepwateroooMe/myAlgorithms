import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.Arrays;
import java.util.stream.*;
import java.util.stream.Collectors;
import java.math.BigInteger;

import static java.util.stream.Collectors.toMap;

public class dpfive {
    public static class Solution {

        // List<List<Integer>> ll = new ArrayList<>();
        // boolean [] vis;
        // int n;
        // public int numSquarefulPerms(int[] a) {
        //     n = a.length;
        //     if (Arrays.stream(a).distinct().count() == 1) {
        //         if (!isSquare(a[0] + a[1])) return 0;
        //         return 1;
        //     }
        //     vis = new boolean[n];
        //     dfs(a, 0, new ArrayList<>());
        //     return ll.size();
        // }
        // private void dfs(int [] a, int idx, List<Integer> l) { // tle tle tle
        //     if (l.size() >= 2 && !isValid(l)) return;
        //     if (l.size() == n) {
        //         if (isValid(l) && !ll.contains(l)) ll.add(new ArrayList<>(l));
        //         return ;
        //     }
        //     for (int i = 0; i < n; i++) {
        //         if (i > 0 && a[i] == a[i-1] && vis[i-1]) continue; // 很重要,总结
        //         if (!vis[i]) {
        //             vis[i] = true;
        //             l.add(a[i]);
        //            dfs(a, i+1, l);
        //             l.remove(l.size()-1);
        //             vis[i] = false;
        //         }
        //     }
        // }
        // private boolean isSquare(int v) {
        //     return Math.pow((int)Math.sqrt(v), 2) == v;
        // }
        // private boolean isValid(List<Integer> l) {
        //     for (int i = 0; i <= l.size()-2; i++) 
        //         if (!isSquare(l.get(i) + l.get(i+1))) return false;
        //     return true;
        // }


        // public class MinSeg {
        //     List<Integer> tree = new ArrayList<>();
        //     int n;
        //     public MinSeg (int [] arr) {
        //         n = arr.length;
        //         tree = new ArrayList<>(2 * n);
        //         for (int i = 0; i < n; i++)
        //             tree.add(0);
        //         for (int i = 0; i < n; i++)
        //             tree.add(arr[i]);
        //         for (int i = n-1; i >= 0; i--) // i >= 0
        //             tree.set(i, Math.min(tree.get(2 * i), tree.get(2 * i+1)));
        //     }
        //     public void update(int idx, int v) {
        //         idx += n;
        //         tree.set(idx, v);
        //         while (idx > 1) {
        //             idx /= 2;
        //             tree.set(idx, Math.min(tree.get(2 * idx), tree.get(2 * idx+1)));
        //         }
        //     }
        //     public int getMin(int l, int r) { // [l, r) include left, not included right
        //         l += n;
        //         r += n;
        //         int min = Integer.MAX_VALUE;
        //         while (l < r) {
        //             if ((l & 1) == 1) {
        //                 min = Math.min(min, tree.get(l));
        //                 l++;
        //             }
        //             if ((r & 1) == 1) {
        //                 r--; // order matters !!!
        //                 min = Math.min(min, tree.get(r));
        //             }
        //             l >>= 1;
        //             r >>= 1;
        //         }
        //         return min;
        //     }
        // }
        // public int minNumberOperations(int[] target) {
        //     n = target.length;
        //     minSeg = new MinSeg(target);
        //     return minNumberOperationsRecursive(target, 0, n-1, 0);
        // }
        // MinSeg minSeg;
        // int n;
        // private int minNumberOperationsRecursive(int [] a, int bgn, int end, int preMin) { // tle: 1st time write it right, but this time got tle tle tle 
        //     if (bgn == end) return a[bgn] - preMin;
        //     int min = minSeg.getMin(bgn, end+1), ans = min - preMin;
        //     List<Integer> minIdx = new ArrayList<>();
        //     for (int i = bgn; i <= end; i++) 
        //         if (a[i] == min) minIdx.add(i);
        //      if (minIdx.size() == end - bgn + 1) return ans;
        //     if (minIdx.size() == 2 && minIdx.get(0) == bgn && minIdx.get(1) == end)
        //         return ans + minNumberOperationsRecursive(a, bgn+1, end-1, min);
        //     else if (minIdx.size() == 1)
        //         return ans + (minIdx.get(0) == bgn ? minNumberOperationsRecursive(a, bgn+1, end, min) :
        //                       (minIdx.get(0) == end ? minNumberOperationsRecursive(a, bgn, end-1, min) :
        //                        minNumberOperationsRecursive(a, bgn, minIdx.get(0)-1, min) + minNumberOperationsRecursive(a, minIdx.get(0)+1, end, min)));
        //     else if (minIdx.size() >= 2) {
        //         for (int i = 0; i < minIdx.size(); i++) {
        //             if (i == 0) {
        //                 ans += (minIdx.get(0) == bgn ? 0 : minNumberOperationsRecursive(a, bgn, minIdx.get(i)-1, min));
        //                 continue;
        //             }
        //             if (minIdx.get(i) == minIdx.get(i-1) + 1) continue;
        //             ans += minNumberOperationsRecursive(a, minIdx.get(i-1)+1, minIdx.get(i)-1, min);
        //         }
        //         if (minIdx.get(minIdx.size()-1) < end) ans += minNumberOperationsRecursive(a, minIdx.get(minIdx.size()-1)+1, end, min);
        //         return ans;
        //     }
        //     return -1;
        // }
        // public int minNumberOperations(int[] target) {
        //     ArrayDeque<Integer> st = new ArrayDeque<>();
        //     int low = 0, ans = 0;
        //     for (int i = 0; i < target.length; i++) {
        //         if (!st.isEmpty() && st.peek() > target[i]) {
        //             ans += st.peek() - low;
        //             while (!st.isEmpty() && st.peek() > target[i]) st.pop();
        //             low = target[i];
        //         }
        //         st.push(target[i]);
        //     }
        //     if (!st.isEmpty() && st.peek() > low) ans += st.pop() - low;
        //     return ans;
        // }

        // public int[] countSubgraphsForEachDiameter(int n, int[][] edges) { // bug
        //     int m = n-1, range = 1 << m, root = 0, cnt = 0;
        //     int [] ans = new int [m];
        //     for (int i = 1; i < range; i++) {
        //         System.out.println("\n Integer.toBinaryString(i): " + Integer.toBinaryString(i));
        //         root = -1;
        //         Map<Integer, List<Integer>> adj = new HashMap<>();
        //         for (int j = 0; j < m; j++)  // m edges
        //             if (((i >> j) & 1) == 1) {
        //                 int [] e = edges[j];
        //                 if (root == -1) root = e[0];
        //                 adj.computeIfAbsent(e[0], z -> new ArrayList<>()).add(e[1]);
        //                 adj.computeIfAbsent(e[1], z -> new ArrayList<>()).add(e[0]);
        //             }
        //         cnt = Integer.bitCount(i);
        //         Set<Integer> vis = new HashSet<>();
        //         dia = new int [n];
        //         System.out.println("root: " + root);
                
        //         int d = dfs(root, -1, adj, vis);
        //         System.out.println("d: " + d);
        //         System.out.println("(vis.size() != cnt): " + (vis.size() != cnt + 1));
                
        //         if (vis.size() != cnt + 1) continue;
        //         // int d = maxWidth(adj);
        //         ans[d-1]++;
        //         System.out.println(Arrays.toString(ans));
        //     }
        //     System.out.println(Arrays.toString(dia));
        //     return ans;
        // }
        // int [] dia; // 这里需要记忆吗，应该不用吧。数据小，树在不断变化 
        // private int dfs(int u, int p, Map<Integer, List<Integer>> m, Set<Integer> vis) { // 这里树的最大直径算得不对，改天再写
        //     System.out.println("\n u: " + u);
            
        //     vis.add(u);
        //     if (m.get(u).size() == 1 && m.get(u).get(0) == p) return 0;
        //     int max = 0, sec = -1;
        //     for (Integer v : m.get(u)) {
        //         if (v == p) continue;
        //         System.out.println("\n v: " + v);
        //         int cur = 1 + dfs(v, u, m, vis);
        //         System.out.println("cur: " + cur);
        //         if (cur > max) {
        //             sec = max;
        //             max = cur;
        //         } else if (cur > sec) sec = cur;
        //         // System.out.println("max: " + max);
        //         // System.out.println("sec: " + sec);
        //     }
        //     // System.out.println("max: " + max);
        //     // System.out.println("sec: " + sec);
        //     dia[u-1] = max + (sec == -1 ? 0 : sec);
        //     return max + (sec == -1 ? 0 : sec);
        // }

        // private static int [] cnts = new int [31];
        // public int minimumOneBitOperations(int n) { // 2^30 > 1e9 可能思路理得还不是太清楚吧，改天再写这个
        //     if (n == 0) return 0;
        //     String t = Integer.toBinaryString(n);
        //     char [] s = t.toCharArray();
        //     int m = t.length(), cnt = Integer.bitCount(n), ans = 0;
        //     if (cnt == 1) {
        //         if (cnts[n] > 0) return cnts[n];
        //         int i = m-1;
        //         while (cnt < m) {
        //             s[i] = '1';
        //             --i;
        //             cnt++;
        //         }
        //         cnts[n] = cnt * 2 + 1;
        //         return cnt * 2 + 1;
        //     }
        //     int tmp = 0, i = ;
        //     while (Integer.bitCount(n) > 1) {
        //         for (int i = 0; i <= 30; i++) {
        //             if ((n & 1) == 0) {
        //                 n |= 1;
        //                 tmp++;
        //             }
        //         }
        //     char [] s = t.toCharArray();
        //     int i = m-1;
        //     while (i >= 0 && s[i] == '0') i--;
        //     int [] cnt = new int [31];
        //     return 0;
        // }

        // public int shortestPathLength(int[][] g) { // 主要考点：对状态的遍历，以及对重复节点、反复遍历的调控
        //     int n = g.length;
        //     int target = 0, cnt = 0;
        //     Set<String> vis = new HashSet<>();
        //     Queue<int []> q = new LinkedList<>();
        //     for (int i = 0; i < n; i++) { // 从这些个节点起始
        //         int mask = (1 << i);
        //         target |= mask;
        //         vis.add(Integer.toBinaryString(mask) + "_" + Integer.toString(i));
        //         q.offer(new int [] {mask, i});
        //     }
        //     while (!q.isEmpty()) {
        //         for (int size = q.size()-1; size >= 0; size--) {
        //             int [] cur = q.poll();
        //             if (cur[0] == target) return cnt;
        //             for (int v : g[cur[1]]) {
        //                 int state = cur[0] | (1 << v);
        //                 String tmp = Integer.toString(state) + "_" + Integer.toString(v);
        //                 if (vis.contains(tmp)) continue;
        //                 vis.add(tmp);
        //                 q.offer(new int [] {state, v});
        //             }
        //         }
        //         cnt++;
        //     }
        //     return -1;
        // }
        // int min = Integer.MAX_VALUE;
        // int[][] vis;
        // int target;
        // public int shortestPathLength(int[][] graph){
        //     target = (1 << graph.length) - 1; 
        //     vis = new int [graph.length][1 << graph.length]; // For each node's possible binary state, keep path length.
        //     for (int i = 0; i < graph.length; i++) {
        //         for (int [] v : vis) Arrays.fill(v, Integer.MAX_VALUE); // Set initial length to Max
        //         traverse(0, i, graph, 0);
        //     }
        //     return min;
        // }
        // private void traverse(int st, int u, int [][] g, int cnt) {
        //     if (cnt >= min) return ; // 还是有关系的，能一定程度上提高运行效率
        //     st |= 1 << u;
        //     if (st == target) {
        //         min = Math.min(min, cnt);
        //         return ;
        //     }
        //     for (Integer v : g[u]) 
        //         if (vis[v][st] > cnt) {
        //             vis[v][st] = cnt;
        //             traverse(st, v, g, cnt+1);
        //         }
        // }

        // public int countArrangement(int n) { // 当数据量很小，又没有思路如何下口的时候，就试试backtracking吧
        //     this.n = n;
        //     vis = new boolean [n+1];
        //     backTracking(new ArrayList<>());
        //     return ll.size();
        // }
        // List<List<Integer>> ll = new ArrayList<>();
        // boolean [] vis;
        // int n;
        // private void backTracking(List<Integer> l) {
        //     if (l.size() == n) {
        //         // if (!ll.contains(l)) // 这句不用写，写了就超时
        //             ll.add(new ArrayList<>(l));
        //         return ;
        //     }
        //     for (int i = 1; i <= n; i++) 
        //         if (!vis[i] && (l.size() + 1 >= i && (l.size()+1) % i == 0
        //                         || l.size() + 1 < i && i % (l.size()+1) == 0))  {
        //             vis[i] = true;
        //             l.add(i);
        //             backTracking(l);
        //             l.remove(l.size()-1);
        //             vis[i] = false;
        //         }                    
        // }

        // public int numberOfArithmeticSlices(int[] a) {
        //     int n = a.length, cnt = 0, addend = 0;
        //     for (int i = 2; i < n; i++) {
        //         if (a[i] - a[i-1] == a[i-1] - a[i-2]) 
        //             cnt += ++addend;
        //         else addend = 0;
        //     }
        //     returncnt;
        // }
        // public int numberOfArithmeticSlices(int[] a) {
        //     int n = a.length;
        //     int [] dp = new int [n];
        //     for (int i = 1; i < n-1; i++) {
        //         if (a[i-1] + a[i+1] == 2 * a[i])
        //             dp[i] = dp[i-1] + 1;
        //     }
        //     return Arrays.stream(dp).sum();
        // }

        // // 在找出每个变量的上界之后，就可以在O(maxn}{maxc}^2)的时间内预处理dp 数组。
        // //     随后，我们还要预先求出 [2, maxn] 之间的全部质数，复杂度为 O(maxn)。
        // public int[] waysToFillArray(int[][] q) {
        //     int n = q.length;
        //     int mod = (int)1e9 + 7;
        //     int maxC = 15;          // 找出「加和」的最大值cmax。根据前面的描述，cmax 即为质因数数量的最大值。
        //     int maxN = 0, maxK = 0; // 而由于质因数最小为 22，maxkmaxk 最大为 10^4因此质因数数量不会超过log_2 10^4 < 15
        //     for (int i = 0; i < n; i++) { // 需要遍历数组，找到所有 n, kn,k 的最大值maxn,maxk
        //         maxN = Math.max(maxN, q[i][0]);
        //         maxK = Math.max(maxK, q[i][1]);
        //     }
        //     long [][] dp = new long [maxN + 1][maxC + 1]; // dp[i][j] 代表给定一个正整数 jj，满足长度为 ii，且加和为 jj的非负整数排列的数量。
        //     for (int i = 1; i <= maxC; i++) 
        //         dp[1][i] = 1;
        //     for (int i = 1; i <= maxN; i++) 
        //         dp[i][0] = 1;
        //     for (int i = 2; i <= maxN; i++) 
        //         for (int j = 1; j <= maxC; j++) 
        //             for (int k = 0; k <= j; k++) { // 为了求解dp[i][j]，我们考虑排列中的第一个整数，它的取值范围为 [0,j][0,j]，
        //                 dp[i][j] += dp[i-1][j-k];  // 若它取值为 kk，则余下 i-1i−1 个整数的加和需要为 j-kj−k，对应的方案数目为dp[i−1][j−k]
        //                 dp[i][j] %= mod;
        //             }
        //     int [] isPrime = new int [maxK + 1]; // 分解乘积的质因子
        //     Arrays.fill(isPrime, 1);
        //     List<Integer> primes = new ArrayList<>();
        //     for (int i = 2; i <= maxK; i++) {
        //         if (isPrime[i] == 1) 
        //             primes.add(i);
        //         for (int j = i*2; j <= i*i && j <= maxK; j += i) // 最大乘积为maxK的数组，分解出小的质因子了，那么凡是小质因子的乘积倍数的数都不是质数
        //             isPrime[j] = 0;
        //     }
        //     int [] ans = new int [n];
        //     for (int i = 0; i < n; i++) {
        //         int m = q[i][0], k = q[i][1];
        //         List<Integer> cs = new ArrayList<>(); // 乘积k的质因子表
        //         for (int p : primes) {
        //             if (p > k) break;
        //             int cnt = 0, left = k;
        //             while (left % p == 0) {
        //                 left /= p;
        //                 cnt++;
        //             }
        //             if (cnt > 0) cs.add(cnt); // 乘积k中各质因子的个数（指数）
        //         }
        //         long res = 1;
        //         for (int c : cs) {
        //             res *= dp[m][c]; // 数组长度为n,数组和为质因子c的指数个数的所有可能的分布数合数，各质因子之间个数之间相乘
        //             res %= mod;
        //         }
        //         ans[i] = (int)res;
        //     }
        //     return ans;
        // }
        // public int[] waysToFillArray(int[][] queries) {
        //     int[] result = new int[queries.length];
        //     int resultIdx = 0;
        //     Combination combination = new Combination(10030, 20);
        //     for (int[] q : queries) {
        //         int n = q[0]; // 长度为n
        //         int k = q[1]; // 乘积为k
        //         long product = 1L;
        //         for (int power : getPrimeFactors(k).values()) {
        //             // power个球，分到n个位置，每个位置可以为空
        //             // 等价于：（power+n）个球，分到n个位置，每个位置不能为空  
        //             // Why？ 等价后得到一种分法，每组减去1，就是原来的解
        //             // 插板法可得 C（power + n - 1， n - 1） = C（power + n - 1， power）
        //             product = (product * combination.get(n + power - 1, power)) % mod;
        //         }
        //         result[resultIdx++] = (int)(product);
        //     }
        //     return result;
        // }
        // long mod = (int)1e9 + 7;
        // public HashMap<Integer, Integer> getPrimeFactors(int n) {
        //     HashMap<Integer, Integer> map = new HashMap();
        //     for(int i = 2; i <= n; i++) {
        //         if (n % i == 0) {
        //             int cnt = 0;
        //             while (n % i == 0) {
        //                 cnt++;
        //                 n = n / i;
        //             }
        //             map.put(i, cnt);
        //         }
        //     }
        //     return map;
        // }
        // class Combination {
        //     long[][] c;
        //     Combination (int n, int m) {
        //         c = new long[n + 1][m + 1];
        //         c[0][0] = 1;
        //         for(int i = 1; i <= n; i++){
        //             c[i][0] = 1;
        //             for(int j = 1; j <= m; j++) 
        //                 c[i][j] = (c[i-1][j-1] + c[i-1][j]) % mod;
        //         }
        //     }
        //     public long get(int n, int m) {
        //         return c[n][m];
        //     }
        // }
        // public long getCombination(int n, int r) {
        //     BigInteger value = new BigInteger("1");
        //     long toDivide = 1;
        //     for(int i = 1; i <= r; ++i) {
        //         value = value.multiply(new BigInteger((n - i + 1) + ""));
        //         toDivide *= i;
        //     }
        //     value = value.divide(new BigInteger(toDivide + ""));
        //     value = value.remainder(new BigInteger("mod"));
        //     return value.longValue();
        // }

        
    }
    public static void main(String[] args) {
        Solution s  =  new Solution();

        int [][] a = new int [][] {{2,6},{5,1},{73,660}};

        int [] r  =  s.waysToFillArray(a);
        System.out.println(Arrays.toString(r));
    }
}