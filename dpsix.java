import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.Arrays;
import java.util.stream.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;

public class dpsix {
    public static class Solution {

        // public int numberOfSets(int n, int k) { // bug
        //     this.n = n;
        //     dp = new long [n][k+1][2];
        //     dfs(0, k, 0);
        //     return (int)dp[0][k][0];
        // }
        // long mod = (int)1e9 + 7;
        // long [][][] dp;
        // int n;
        // private long dfs(int idx, int k, int ended) {
        //     if (idx == n-1 || k < 0) return 0;
        //     if (dp[idx][k][ended] != 0) return dp[idx][k][ended];
        //     long ans = 0;
        //     if (ended == 1) {
        //         for (int i = idx; i <= n-1-k; i++) 
        //             ans = (ans + dfs(i, k-1, 0)) % mod;
        //     } else {
        //         for (int i = idx+1; i <= n-1-k; i++) 
        //             ans = (ans + dfs(i, k-1, 1)) % mod;
        //     }
        //     return dp[idx][k][ended] = ans;
        // }

        // 在java里，List的哈希方式，是将其哈希成开头加个1后的31进制整数，例如对于列表[ 1 , 2 , 3 ]，java会将其哈希成31进制下的1123，也就是哈希成
        // 1*31^3 + 1 * 32^2 + 2 * 31 + 3 = 30817，而List里判断是否equals，是逐个比较列表里的值，如果值全相等就返回true。
        //     所以在记忆化的时候，可以直接把key设为是List类型的。
        // public int shoppingOffers(List<Integer> p, List<List<Integer>> of, List<Integer> need) {
        //     n = p.size();
        //     return dfs(p, of, need);
        // }
        // Map<List<Integer>, Integer> dp = new HashMap<>();
        // int n;
        // private int dfs(List<Integer> p, List<List<Integer>> of, List<Integer> need) {
        //     if (dp.containsKey(need)) return dp.get(need);  // 首先检查记忆
        //     int ans = 0;
        //     for (int i = 0; i < n; i++) 
        //         ans += p.get(i) * need.get(i);
        //     if (ans == 0) return ans; // ? 这里就不需要记忆了？
        //     for (List<Integer> cur : of) {
        //         if (cur.get(cur.size()-1) >= ans) continue; // >=
        //         List<Integer> newNeed = new ArrayList<>();
        //         for (int i = 0; i < n; i++) {
        //             if (cur.get(i) > need.get(i)) break;
        //             newNeed.add(need.get(i) - cur.get(i));
        //         }
        //         if (newNeed.size() == need.size()) // 即当前礼包合法
        //             ans = Math.min(ans, cur.get(cur.size()-1) + dfs(p, of, newNeed));
        //     }
        //     dp.put(need, ans);
        //     return ans;
        // }
        // public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) { // bug, todo
        //     n = price.size();
        //     int[][] dp = new int[special.size() + 1][1 << n * 3]; // 开一个记忆化数组，dp[i][s]表示如果只考虑前i个套餐的话，要买到s这个状态，至少需要多少花费
        //     for (int [] row : dp) Arrays.fill(row, -1); // 先初始化为-1
        //     int target = 0; // 求一下needs代表的状态，这里target的最低3位表示的是下标是0的商品要买多少个，以此类推
        //     for (int i = needs.size() - 1; i >= 0; i--) 
        //         target = (target << 3) + needs.get(i);
        //     return dfs(special.size(), target, special, price, dp);
        // }
        // int n;
        // // 返回的是，如果只考虑前count个套餐的话，要达到state这个状态的最小花费（当然单买也是考虑的）
        // private int dfs(int count, int state, List<List<Integer>> special, List<Integer> price, int[][] dp) {
        //     if (state >= (1 << n*3)) return 0;
        //     if (dp[count][state] != -1) return dp[count][state]; // 如果之前已经算出来过，则直接返回
        //     if (count == 0) { // 如果一个套餐都不考虑，那就是全单买
        //         dp[count][state] = 0;
        //         // 求一下每个商品买多少个，然后累加一下花费
        //         for (int i = 0; i < n; i++) {
        //             int c = state >> i * 3 & 7;
        //             dp[count][state] += c * price.get(i);
        //         }
        //         return dp[count][state];
        //     }
        //     dp[count][state] = dfs(count - 1, state, special, price, dp); // 考虑不选第count个套餐的情况
        //     List<Integer> sp = special.get(count - 1);                    // 考虑选第count个套餐的情况
        //     int nextState = 0; // 存一下考虑完当前套餐后的需求状态
        //     for (int i = n - 1; i >= 0; i--) { // 逆序遍历是为了方便nextState的计算
        //         int c = state >> i * 3 & 7;
        //         if (c < sp.get(i)) { // 小了，说明当前套餐是不能选的，标记为-1并退出循环
        //             nextState = -1;
        //             break;
        //         }
        //         nextState = (nextState << 3) + c - sp.get(i);
        //     }
        //     if (nextState != -1)  // 如果当前套餐能选，再算一下选了当前套餐的情况下的最小花费
        //         dp[count][state] = Math.min(dp[count][state], sp.get(n) + dfs(count, nextState, special, price, dp));
        //     return dp[count][state];
        // }

        // public int findMaxForm(String[] strs, int m, int p) { // m: 0 p: 1 dfs记忆化搜索
        //     n = strs.length;
        //     int [] one = new int [n]; // cnt 1s
        //     int [] two = new int [n]; // cnt 0s
        //     int cntOne = 0, cntZero = 0;
        //     for (int i = 0; i < n; i++) {
        //         String cur = strs[i];
        //         cntOne = 0;
        //         cntZero = 0;
        //         for (char c : cur.toCharArray()) {
        //             if (c == '0') cntZero++;
        //             else cntOne++;
        //         }
        //         one[i] = cntOne;
        //         two[i] = cntZero;
        //     }
        //     List<String> l = new ArrayList<>();
        //    cnt = new ArrayList<>();
        //     for (int i = 0; i < n; i++) {
        //         if (one[i] > p || two[i] > m) continue;
        //         l.add(strs[i]);
        //         cnt.add(new int [] {two[i], one[i]});
        //     }
        //     dp = new int [l.size()][m+1][p+1];
        //     return dfs(l, 0, m, p);
        // }
        // int [][][] dp;
        // List<int []> cnt;
        // int n;
        // private int dfs(List<String> l, int idx, int i, int j) { 
        //     if (idx >= l.size() || i < 0 || j < 0) return 0;
        //     if (i == 0 && j == 0) return 0;
        //     if (dp[idx][i][j] > 0) return dp[idx][i][j];
        //     int x = i - cnt.get(idx)[0], y = j - cnt.get(idx)[1];
        //     int ans = x >= 0 && y >= 0 ? 1 : 0;
        //     return dp[idx][i][j] = Math.max(ans + dfs(l, idx+1, x, y), dfs(l, idx+1, i, j));
        //  }
        // public int findMaxForm(String[] strs, int m, int n) { // m: 0 p: 1 
        //     int [][] dp = new int [m+1][n+1];
        //     for (String  s : strs) {
        //         int one = 0, zero = 0;
        //         for (char c : s.toCharArray()) 
        //             if (c == '0') zero++;
        //             else one++;
        //         // if (zero > m || one > n) continue;
        //         for (int i = m; i >= zero; i--) 
        //             for (int j = n; j >= one; j--) 
        //                 dp[i][j] = Math.max(dp[i][j], dp[i-zero][j-one] + 1);
        //         // dp[zero][cntOne] = Math.max(dp[zero][cntOne], 1);
        //         // for (int i = 0; i <= m-zero; i++) 
        //         //     for (int j = 0; j <= n-cntOne; j++) 
        //         //         if (dp[i][j] > 0)
        //         //             dp[i+zero][j+cntOne] = Math.max(dp[i+zero][j+cntOne], dp[i][j] + 1);
        //         // for (int i = zero; i <= m; i++) 
        //         //     for (int j = cntOne; j <= n; j++) 
        //         //         if (dp[i][j] > 0)
        //         //             dp[i][j] = Math.max(dp[i][j], dp[i-zero][j-cntOne] + 1);
        //     }
        //     return dp[m][n];
        // }
        // public int findMaxForm(String[] strs, int m, int n) {
        //     int [][] dp = new int [m+1][n+1];
        //     dp[0][0] = 0;
        //     for (String s : strs) {
        //         int one = 0, zoo = 0;
        //         for (int i = 0; i < s.length(); i++) 
        //             if (s.charAt(i) == '0') ++ zoo;
        //             else ++one;
        //         for (int i = m; i >= zoo; i--) 
        //             for (int j = n; j >= one; j--) 
        //                 dp[i][j] = Math.max(dp[i][j], dp[i-zoo][j-one] + 1);
        //     }
        //     return dp[m][n];
        // }

        // public int maximumSum(int[] a) { // bug
        //     int n = a.length, max = Integer.MIN_VALUE, locMax = Integer.MIN_VALUE;
        //     int [] l = new int [n+1], r = new int [n+1];
        //     Arrays.fill(l, Integer.MIN_VALUE);
        //     Arrays.fill(r, Integer.MIN_VALUE);
        //     l[0] = 0;
        //     for (int i = 0; i < n; i++) {
        //         locMax = Math.max((i == 0 ? 0 : locMax) + a[i], a[i]);
        //         l[i+1] = locMax;
        //     }
        //     r[n] = 0; locMax = Integer.MIN_VALUE;
        //     for (int i = n-1; i >= 0; i--) {
        //         locMax = Math.max(locMax + a[i], a[i]);
        //         r[i] = locMax;
        //     }
        //     max = Integer.MIN_VALUE;
        //     for (int i = 0; i <= n; i++) 
        //         max = Math.max(max, l[i] + r[i]);
        //     return max;
        // }

        // public int countRestrictedPaths(int n, int[][] edges) {
        //     this.n = n;
        //     for (int [] e : edges) {
        //         adj.computeIfAbsent(e[0], z -> new HashMap<>()).put(e[1], e[2]);
        //         adj.computeIfAbsent(e[1], z -> new HashMap<>()).put(e[0], e[2]);
        //     }
        //     dist = new int [n+1];
        //     Arrays.fill(dist, Integer.MAX_VALUE);
        //     dist[n] = 0;
        //     dijstra();
        //     dp = new int [n+1];
        //     Arrays.fill(dp, -1);
        //     return (int)dfs(1);
        // }
        // HashMap<Integer, Map<Integer, Integer>> adj = new HashMap<>();
        // int mod = (int)1e9 + 7;
        // int [] dist;
        // int [] dp;
        // int n;
        // private long dfs(int u) {
        //     if (u == n) return 1;
        //     if (dp[u] != -1) return dp[u];
        //     long ans = 0;
        //     Map<Integer, Integer> tmp = adj.get(u);
        //     if (tmp != null) 
        //         for (Integer v : tmp.keySet()) 
        //             if (dist[u] > dist[v])
        //                 ans = (ans + dfs(v)) % mod;
        //     return dp[u] = (int)ans;
        // }
        // private void dijstra() {
        //     // Queue<int []> q = new LinkedList<>(); // tle 
        //     Queue<int []> q = new PriorityQueue<>((a, b)->a[1] - b[1]); // 狠重要
        //     q.offer(new int [] {n, 0});
        //     while (!q.isEmpty()) {
        //         int [] u = q.poll();
        //         if (dist[u[0]] < u[1]) continue; // 狠重要
        //         Map<Integer, Integer> tmp = adj.get(u[0]);
        //         if (tmp == null) continue;
        //         for (Integer v : tmp.keySet()) 
        //             if (u[1] + tmp.get(v) < dist[v]) {
        //                 dist[v] = u[1] + tmp.get(v);
        //                 q.offer(new int [] {v, dist[v]});
        //             }
        //     }
        // }
 
        // public long maxTaxiEarnings(int n, int[][] rides) {
        //     Arrays.sort(rides, (a, b)-> (a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]));
        //     Map<Integer, Set<int []>> m = new HashMap<>();
        //     for (int [] r : rides) 
        //         m.computeIfAbsent(r[1], z -> new HashSet<>()).add(r);
        //     long [] dp = new long [n+1];
        //     for (int i = 1; i <= n; i++) {
        //         dp[i] = dp[i-1];
        //         if (m.containsKey(i)) 
        //             for (int [] r : m.get(i)) 
        //                 dp[r[1]] = Math.max(dp[r[1]], dp[r[0]] + r[1] - r[0] + r[2]);
        //     }
        //     return dp[n];
        // }
        // Similar to 1235. Maximum Profit in Job Scheduling
        // Sort by the end time to get non-overlapping intervals.
        // Use the treemap to find the previous ride before the current ride.
        // public long maxTaxiEarnings(int n, int[][] rides) {
        //     if (rides == null || rides.length == 0) return 0;
        //     for (int[] r : rides) 
        //         r[2] = r[1] - r[0] + r[2];
        //     Arrays.sort(rides, (a, b) -> (a[1] - b[1]));
        //     TreeMap<Long, Long> map = new TreeMap<>();
        //     map.put((long)0, (long)0); 
        //     for (int[] r : rides) {
        //         long cur = map.floorEntry((long)r[0]).getValue() + r[2];
        //         if (cur > map.lastEntry().getValue()) {
        //             map.put((long)r[1], cur);
        //         }
        //     }
        //     return map.lastEntry().getValue();
        // }

        // public List<Integer> largestDivisibleSubset(int[] a) { // bug
        //     Set<Integer> s = new HashSet<>(Arrays.stream(a).boxed().collect(Collectors.toList()));
        //     int n = a.length;
        //     if (n < 2) return Arrays.stream(a).boxed().collect(Collectors.toList());
        //     int cnt = 0, max = 0, t = 0, next = 0;
        //     Set<Integer> ans = new HashSet<>();
        //     Set<Integer> tmp = new HashSet<>();
        //     for (int i = 0; i < n; i++) 
        //         for (int j = 0; j < n; j++) {
        //             if (i == j || a[i] % a[j] != 0 && a[j] % a[i] != 0) continue;
        //             if (a[i] % a[j] == 0) {
        //                 t = a[i] / a[j];
        //                 next = t * a[i];
        //             } else {
        //                 t = a[j] / a[i];
        //                 next = t * a[j];
        //             }
        //             tmp.add(a[i]);
        //             tmp.add(a[j]);
        //             cnt = 2;
        //             while (s.contains(next)) {
        //                 cnt++;
        //                 tmp.add(next);
        //                 next = t * next;
        //             }
        //             if (cnt > max) {
        //                 max = cnt;
        //                 ans.clear();
        //                 ans.addAll(tmp);
        //                 tmp.clear();
        //             }
        //         }
        //     if (ans.size() == 0) return new ArrayList<>(List.of(a[0]));
        //     return new ArrayList<>(ans);
        // }
        // public List<Integer> largestDivisibleSubset(int[] a) { // bug: todo
        //     int n = a.length, max = 0, maxIdx = 0, maxV = 0;
        //     Arrays.sort(a);
        //     Map<Integer, Integer>[] dp = new HashMap[n];
        //     dp[0] = new HashMap<>();
        //     for (int i = 1; i < n; i++) {
        //         dp[i] = new HashMap<>();
        //         for (int j = 0; j < i; j++) {
        //             int v = a[i] / a[j];
        //             if (a[i] % a[j] != 0) continue;
        //             int cnt = dp[j].getOrDefault(a[j], 1);
        //             dp[i].put(a[j], cnt + 1);
        //             if (cnt + 1 > max) {
        //                 max = cnt + 1;
        //                 maxIdx = i;
        //                 maxV = v;
        //             }
        //         }
        //     }
        //     System.out.println("max: " + max);
        //     List<Integer> ans = new ArrayList<>();
        //     for (int i = maxIdx; i >= 0; i--) 
        //         if (i > 0 && dp[i].getOrDefault(maxV, 0) == max) {
        //             ans.add(a[i]);
        //             max--;
        //             if (max == 1) ans.add(a[i] / maxV);
        //             continue;
        //         }
        //         // else if (i == 0) {
        //         //     if (a[i+1] / maxV == a[])
        //         // }
        //     return ans;
        // }

        // public int findSubstringInWraproundString(String p) {
        //     int n = p.length();
        //     char [] s = p.toCharArray();
        //     int [] cnt = new int [26];
        //     int [] a = new int [n];
        //     for (int i = 0; i < n; i++) 
        //         a[i] = s[i] - 'a';
        //     int validLen = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (i > 0 && (a[i-1] +1) % 26 == a[i])
        //             validLen++;
        //         else validLen = 1;
        //         cnt[a[i]] = Math.max(cnt[a[i]], validLen);
        //     }
        //     return Arrays.stream(cnt).sum();
        // }

        // // 如果是普通的DP方法，那么使用二维dp[i][j]表示子数组的起始和结束区间，能做到O(n^2)的时间复杂度，但是题目对时间复杂度要求的很死，必须O(N).
        // // 正确的做法也是动态规划，dp[i]表示以A[i]结尾的所有子数组的异或结果，其实是个set。
        // // 转移方程式: 
        // // dp[i] = [b | A[i] for b in dp[i - 1]] + A[i]，
        // //     即以A[i]结尾的所有子数组异或结果等于以A[i-1]结尾的所有子数组或的结果，和当前的A[i]相或，再加上A[i]这个结果。
        // //     同时使用一个set保存所有的异或结果。最后返回这个结果set的长度。
        // public int subarrayBitwiseORs(int[] a) { 
        //     int n = a.length;
        //     Set<Integer> ans = new HashSet<>();
        //     Set<Integer> [] dp = new HashSet[n];  // 以滚动数组的原理，继续压缩空间
        //     dp[0] = new HashSet<>(List.of(a[0])); // 这里应该不用加0的
        //     ans.add(a[0]);
        //     for (int i = 1; i < n; i++) {
        //         dp[i] = new HashSet<>();
        //         for (Integer v : dp[i-1]) 
        //             dp[i].add(v | a[i]);
        //         dp[i].add(a[i]);
        //         ans.addAll(dp[i]);
        //     }
        //     return ans.size();
        // }
        // public int subarrayBitwiseORs(int[] A) {
        //     Set<Integer> ans = new HashSet<>();
        //     Set<Integer> cur = new HashSet<>();
        //     for (int a : A) {
        //         Set<Integer> next = new HashSet<>();
        //         next.add(a);
        //         for (Integer b : cur)
        //             next.add(b | a);
        //         ans.addAll(next);
        //         cur = next;
        //     }
        //     return ans.size();
        // }
        // public int subarrayBitwiseORs(int[] arr) { // 这个方法写得好仙幻啊，看不懂呀看不懂～！！！ todo： 还是看不懂
        //     Set<Integer> set = new HashSet<>();
        //     for (int i = 0; i < arr.length; i++) {
        //         set.add(arr[i]);
        //         for (int j = i - 1; j >= 0; j--) {
        //             if ((arr[i] | arr[j]) == arr[j]) {
        //                 // arr[j]的置位位置包含了arr[i]的置位位置，
        //                 // 那么已经无需考虑arr[i]的加入与否
        //                 break;
        //             }
        //             // 求值的同时保留积累状态
        //             arr[j] |= arr[i];
        //             set.add(arr[j]);
        //         }
        //     }
        //     return set.size();
        // }

        // public int maxSubarraySumCircular(int[] a) { // 寻找全局最大子数组、和全局最小子数组
        //     int n = a.length;
        //     int sum = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, locMax = 0, locMin = 0;
        //     for (Integer v : a) {
        //         locMax = Math.max(locMax + v, v);
        //         max = Math.max(max, locMax);
        //         locMin = Math.min(locMin + v, v);
        //         min = Math.min(min, locMin);
        //         sum += v;
        //     }
        //     return max > 0 ? Math.max(max, sum - min) : max;
        // }
        
        // public int maximumSum(int[] a) { 
        //     int n = a.length, ans = a[0];
        //     int [] l = new int [n], r = new int [n];
        //     l[0] = a[0];
        //     for (int i = 1; i < n; i++) {// l[]: max ending at idx i
        //         l[i] = Math.max(l[i-1] + a[i], a[i]);
        //         ans = Math.max(ans, l[i]); // 这里取的是不行使删除一个元素操作的最大子数组和
        //     }
        //     r[n-1] = a[n-1];
        //     for (int i = n-2; i >= 0; i--)
        //         r[i] = Math.max(r[i+1] + a[i], a[i]);
        //     for (int i = 1; i < n-1; i++) 
        //         ans = Math.max(ans, l[i-1] + r[i+1]);
        //     return ans;
        // }
        // maximum subarray sum的变形，
        // 变形在于，答案在于咩有删除和有删除。
        // 没有删除：以每个index为结尾走一遍，得到最大值。
        // 有删除：以每个index为结尾和开头走一遍，然后删除i的结果 res = Math.max(res, end[i-1] + start[i+1]).
        // 再详细一点儿的分析： 
        // 这道题因为允许删除操作的存在，还是要记录每个位置的状态。
        // 若将i位置上的数字删除了，实际上原数组就被分为两个部分：[0, i-1] 和 [i+1, n-1]，
        // 由于是子数组，则 arr[i-1] 和 arr[i+1] 这两个数字一定要出现在子数组中，那这不就正好是 Kadane 算法定义的 dp 数组么（后半段的定义需要翻转一下），
        // 用个 maxEndHere[i] 表示在 [0, i] 范围内以 arr[i] 结尾的最大子数组之和，
        // 用个 maxStartHere[i] 表示在 [i, n-1] 范围内以 arr[i] 为起始的最大子数组之和，
        // 那么移除数字i的最大子数组之和就是 maxEndHere[i-1] + maxStartHere[i+1] 了
        // public int maximumSum(int[] arr) {
        //     int n = arr.length;
        //     int [] maxEndHere = new int [n];
        //     int [] maxBgnHere = new int [n];
        //     maxEndHere[0] = arr[0];
        //     int res = maxEndHere[0];
        //     for (int i = 1; i < n; i++) { // 以 i 为下标、从零至 i 的最大了序列和
        //         maxEndHere[i] = Math.max(maxEndHere[i-1]+arr[i], arr[i]);
        //         res = Math.max(res, maxEndHere[i]);
        //     }
        //     maxBgnHere[n-1] = arr[n-1];
        //     for (int i = n-2; i >= 0; i--) 
        //         maxBgnHere[i] = Math.max(maxBgnHere[i+1]+arr[i], arr[i]);
        //     for (int i = 1; i < n-1; i++) {
        //         if (arr[i] < 0) {
        //             res = Math.max(res, maxEndHere[i-1]+maxBgnHere[i+1]);
        //         }
        //     }
        //     return res;
        // }
        // 解法1：动态规划。跟 53. Maximum Subarray 比，多了一个变量，用来记录delete一个元素后的subarray最大值。
        // 题目中说删除一个元素是optional的，最终的结果在删除的最大值与不删除的最大值中出。思路比较曲折一点
        // public int maximumSum(int[] arr) {
        //     int sum = arr[0], sumWithDeletion = 0, ans = arr[0];
        //     for (int i = 1; i < arr.size(); ++i){
        //         ans = max(ans, sumWithDeletion + arr[i]);
        //         sumWithDeletion = max(sumWithDeletion + arr[i], sum);
        //         sum = sum < 0 ? 0 : sum;
        //         sum += arr[i];
        //         ans = max(ans, sum);
        //     }
        //     return ans;
        // }

        // public int bestTeamScore(int [] scores, int [] ages) {
        //     int n = scores.length, max = 0;
        //     int [][] a = new int [n][];
        //     for (int i = 0; i < n; i++) 
        //         a[i] = new int [] {ages[i], scores[i]};
        //     Arrays.sort(a, (x, y)->x[1] != y[1] ? x[1] - y[1] : x[0] - y[0]); // age increasing; score increasing
        //     int [] dp = new int [n]; // 这里的思路还没有想清楚
        //     for (int i = 0; i < n; i++) {
        //         dp[i] = a[i][1];
        //         for (int j = i-1; j >= 0; j--) 
        //             if (a[j][0] <= a[i][0]) // j年龄比i小，不存在冲突
        //                 dp[i] = Math.max(dp[i], dp[j] + a[i][1]);
        //         max = Math.max(max, dp[i]);
        //     }
        //     return max;
        // }

        // public boolean checkValidString(String t) { // bug: 不长记性，木有记忆！！！
        //     if (t.charAt(0) == ')') return false;
        //     while (t.startsWith("()") || t.startsWith("*)")) t = t.substring(2);
        //     int n = t.length();
        //     if (n == 1 && t.charAt(0) != '*') return false;
        //     char [] s = t.toCharArray();
        //     int l = 0, r = 0, i = 0, j = 0;
        //     while (i < n && s[i] != '*') {
        //         if (s[i] == '(') l++;
        //         else r++;
        //         if (r > l) return false;
        //         i++;
        //     }
        //     if (i == n && l == r) return true;
        //     if (i == n) return false;
        //     if (s[i] == '*') {
        //         String base = "";
        //         if (l > r) base = "(".repeat(l-r);
        //         if (checkValidString(base + t.substring(i+1))) return true;
        //         if (checkValidString(base + "(" + t.substring(i+1))) return true;
        //         if (checkValidString(base + ")" + t.substring(i+1))) return true;
        //         return false;
        //     }
        //     return false;
        // } 
        // public boolean checkValidString(String t) {
        //     n = t.length();
        //     s = t.toCharArray();
        //     dp = new Boolean [n][n];
        //     return dfs(0, 0);
        // }
        // Boolean [][] dp; // 这个状态，不要搞成一维数组了
        // char [] s;
        // int n;
        // private boolean dfs(int idx, int cnt) {
        //     if (cnt < 0) return false;
        //     if (idx == n) return cnt == 0;
        //     // if (idx < n && cnt < 0) return false;
        //     if (dp[idx][cnt] != null) return dp[idx][cnt];
        //     boolean ans = false;
        //     if (s[idx] == '(') ans = dfs(idx+1, cnt+1);
        //     else if (s[idx] == ')') ans = dfs(idx+1, cnt-1);
        //     else ans = dfs(idx+1, cnt-1) || dfs(idx+1, cnt) || dfs(idx+1, cnt+1);
        //     return dp[idx][cnt] = ans;
        // }


        // public int numOfArrays(int n, int m, int k) {
        //     dp = new Integer [n+1][m+1][k+1];
        //     return dfs(n, -1, k, m);
        // }
        // int mod = (int)1e9 + 7;
        // Integer [][][] dp;
        // private int dfs(int idx, int cur, int k, int limit) {
        //     if (k < 0 || idx < 0) return 0;
        //     if (idx == 0 && k == 0) return 1; // 唯一一种情况是空数组
        //     // if (idx == 0) return k == 0 ? 1 : 0;
        //     if (cur != -1 && dp[idx][cur][k] != null) return dp[idx][cur][k];
        //     long ans = 0;
        //     for (int i = 1; i <= limit; i++) 
        //         ans = (ans + dfs(idx-1, Math.max(cur, i), cur < i ? k-1 : k, limit)) % mod;
        //     if (cur != -1)
        //         dp[idx][cur][k] = (int)ans;
        //     return (int)ans;
        // }
        // public int numOfArrays(int n, int m, int k) {
        //     this.n = n;
        //     dp = new Integer [n][m+1][k+1];
        //     return dfs(0, 0, k, m);
        // }
        // int mod = (int)1e9 + 7;
        // Integer [][][] dp; // 这里不要用int
        // int n;
        // private int dfs(int idx, int cur, int k, int limit) {
        //     if (k < 0) return 0; 
        //     if (idx == n) return k == 0 ? 1 : 0;
        //     if (dp[idx][cur][k] != null) return dp[idx][cur][k]; // != null 就可以提速，原本解法没问题
        //     long ans = 0;
        //     for (int i = 1; i <= limit; i++) 
        //         ans = (ans + dfs(idx+1, Math.max(cur, i), cur < i ? k-1 : k, limit)) % mod;
        //     return dp[idx][cur][k] = (int)ans;
        // }
        // (动态规划) O(nkm)O(nkm)
        // 设 f(i,c,j)f(i,c,j) 表示填充了前 ii 个位置，search_cost 为 cc，且最大值为 jj 时的方案数。
        // 初始时 f(1,1,j)=1f(1,1,j)=1，其余为 0。
        //     转移时，对于 f(i,c,j)f(i,c,j)，
        //     如果上一个位置结尾时，最大值已经为 jj，则我们这个位置有 jj 种方案（即填 1 到 jj），且不需要增加花费，可以累加 f(i−1,c,j)∗jf(i−1,c,j)∗j。
        //     如果上一个位置结束时最大值不到 jj，则我们需要这个位置填 jj，即一种方案，且需要增加花费。此时可以累加 ∑j−1l=1f(i−1,c−1,l)∑l=1j−1f(i−1,c−1,l) 的和。
        //     我们不妨用 g(i,c,j)g(i,c,j) 来表示 f(i,c,j)f(i,c,j) 在第三维上的前缀和，则第二个转移就是累加 g(i−1,c−1,j−1)g(i−1,c−1,j−1)。
        //     最终答案为 g(n,k,m)g(n,k,m)。
        //     时间复杂度
        //     状态数为 O(nkm)O(nkm)，采用了辅助数组 gg，转移时间为常数，故总时间复杂度为 O(nkm)O(nkm)。
        //     空间复杂度
        //     需要额外 O(nkm)O(nkm) 的空间存储状态。
        //     可以通过滚动数组优化到 O(km)O(km)
        // public int numOfArrays(int n, int m, int k) { // todo: 动态规划的解法 1420
        //     int mod = 1_000_000_007;
        //     long[][][] dp = new long[n+1][k+1][m+1];
        //     long[][][] g = new long[n+1][k+1][m+1];
        //     Arrays.fill(dp[1][1], 1);
        //     for (int j = 1; j <= m; j++)
        //         g[1][1][j] = j;
        //     for (int i = 2; i <= n; i++) {
        //         for (int c = 1; c <= k; c++) {
        //             for (int j = 1; j <= m; j++) {
        //                 dp[i][c][j] = (dp[i-1][c][j] * j + g[i-1][c-1][j-1]) % mod;
        //                 g[i][c][j] = (g[i][c][j-1] + dp[i][c][j]) % mod;
        //             }
        //         }
        //     }
        //     return (int)g[n][k][m];
        // }

        // public int numMusicPlaylists(int n, int goal, int k) {
        //     long mod = (int)1e9 + 7;
        //     long [][] dp = new long [goal+1][n+1]; // dp[i][j]: 播完i首用了j首不同的曲子，分第爱首播不播第这首两种情况
        //     // 要怎么初始化呢？
        //     for (int j = 1; j <= k; j++) 
        //         dp[1][j] = n;
        //     return (int)dp[goal][n];
        // }

        // 记 dp[i][j] = v 表示s[0:j]区间内分割成j段，只需要改变v个字符就可以使得每一段的子串都是回文串。
        //     要求dp[i][j]的值，关键就是找出j和j-1的分割点。
        //     很显然有dp[i][j] = min(dp[m][j-1] + s[m:j]需要改变的字符的个数)，只需要找出最小的分割点m即可。        
        // public int palindromePartition(String t, int k) { // todo: 不知道哪里的细节错了，改天再改 dfs记忆化搜索 会写，可是dp不太会写 
        //     int n = t.length();
        //     // if (k == n) return 0;
        //     char [] s = t.toCharArray();
        //     Map<String, Integer> m = new HashMap<>();
        //     for (int i = 0; i < n; i++) 
        //         for (int j = i+1; j <= n; j++) {
        //             String cur = t.substring(i, j);
        //             if (!m.containsKey(cur)) m.put(cur, getCnt(cur));
        //         }
        //     int [][] dp = new int [n][k+1];
        //     for (int i = 0; i < n; i++) 
        //         Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        //     dp[0][0] = 0;
        //     // for (int i = 0; i < n; i++) 
        //     //     dp[i][1] = m.get(t.substring(0, i+1));
        //     for (int d = 1; d <= k; d++) 
        //         for (int i = 0; i < n; i++) {
        //             int min = Integer.MAX_VALUE;
        //             for (int j = 0; j < i; j++) 
        //                 min = Math.min(min, dp[j][d-1] + m.get(t.substring(j+1, i+1)));
        //             dp[i][d] = Math.min(dp[i][d], min);
        //         }
        //     System.out.println("dp.length: " + dp.length);
        //     for (int z = 0; z < dp.length; ++z) 
        //         System.out.println(Arrays.toString(dp[z]));
        //     return dp[n-1][k];
        // }
        // private int getCnt(String t) {
        //     int n = t.length(), cnt = 0;
        //     char [] s = t.toCharArray();
        //     int i = 0, j = n-1;
        //     while (i < j) {
        //         if (s[i] != s[j]) cnt++;
        //         i++;
        //         j--;
        //     }
        //     return cnt;
        // }
        // // 记 dp[i][j] = v 表示s[0:j]区间内分割成j段，只需要改变v个字符就可以使得每一段的子串都是回文串。
        // //     要求dp[i][j]的值，关键就是找出j和j-1的分割点。
        // //     很显然有dp[i][j] = min(dp[m][j-1] + s[m:j]需要改变的字符的个数)，只需要找出最小的分割点m即可。        
        // public int palindromePartition(String t, int k) { // 不知道哪里的细节错了，改天再改
        //     n = t.length();
        //     s = t.toCharArray();
        //     m = new HashMap<>();
        //     this.t = t;
        //     for (int i = 0; i < n; i++) 
        //         for (int j = i+1; j <= n; j++) {
        //             String cur = t.substring(i, j);
        //             if (!m.containsKey(cur)) m.put(cur, getCnt(cur));
        //         }
        //     dp = new Integer [n][k+1];
        //     return dfs(0, k);
        // }
        // Map<String, Integer> m;
        // Integer [][] dp;
        // String t;
        // char [] s;
        // int n;
        // private int dfs(int i, int k) {
        //     if (i == n) return 0;
        //     if (k == 1) return m.get(t.substring(i));
        //     if (dp[i][k] != null) return dp[i][k];
        //     int ans = Integer.MAX_VALUE;
        //     for (int j = i+1; j <= n-k+1; j++) 
        //         ans = Math.min(ans, dfs(j, k-1) + m.get(t.substring(i, j)));
        //     return dp[i][k] = ans;
        // }

        // public int countRoutes(int[] locations, int start, int finish, int fuel) {
        //     n = locations.length;
        //     dp = new Integer [n][fuel+1];
        //     return dfs(start, fuel, finish, locations);
        // }
        // int mod = (int)1e9 + 7;
        // Integer [][] dp; // 第二次： Integer 狠重要，otherwise tle !
        // int n;
        // private int dfs(int u, int f, int end, int [] a) {
        //     // if (f < 0) return 0; // 因为前面检查过，这个状态不存在了
        //     if (f == 0) return u == end ? 1 : 0;
        //     if (dp[u][f] != null) return dp[u][f];
        //     long ans = 0;
        //     if (u == end) ans = 1;
        //     for (int i = 0; i < a.length; i++) {
        //         if (i == u || Math.abs(a[i] - a[u]) > f) continue;
        //         ans = (ans + dfs(i, f - Math.abs(a[i]-a[u]), end, a)) % mod;
        //     }
        //     return dp[u][f] = (int)ans;
        // }

        // public int minDeletionSize(String[] ss) { // 寻找每个字符串的最长递增子序列--》寻找多个字符串的递增子序列
        //     int m = ss.length, n = ss[0].length(), max = 1;
        //     int [] dp = new int [n];
        //     Arrays.fill(dp, 1); // 不要忘记了 ！！！
        //     boolean valid = true;
        //     for (int i = 0; i < n; i++) {
        //         for (int j = 0; j < i; j++) {
        //             valid = true;
        //             for (int k = 0; k < m; k++) 
        //                 if (ss[k].charAt(j) > ss[k].charAt(i)) {
        //                     valid = false;
        //                     break;
        //                 }
        //             if (valid)
        //                 dp[i] = Math.max(dp[i], dp[j] + 1);
        //         }
        //         max = Math.max(max, dp[i]);
        //     }
        //     return n - max;
        // }

        // public int maxValue(int[][] en, int k) {
        //     n = en.length;
        //     dp = new int [n][k+1];
        //     Arrays.sort(en, (a, b)->a[0] - b[0]);
        //     return dfs(en, 0, k);
        // }
        // int [][] dp;
        // int n;
        // private int dfs(int [][] a, int i, int k) {
        //     if (i == n || k == 0) return 0;
        //     if (dp[i][k] > 0) return dp[i][k];
        //     int idx = binarySearch(a, i+1, a[i][1]);
        //     return dp[i][k] = Math.max(a[i][2] + (idx == -1 ? 0 : dfs(a, idx, k-1)), dfs(a, i+1, k));
        // }
        // private int binarySearch(int [][] a, int l, int v) {
        //     int r = a.length-1;
        //     int ans = -1;
        //     while (l <= r) {
        //         int m = l + (r - l) / 2;
        //         if (a[m][0] > v) {
        //             ans = m;
        //             r = m-1;
        //         } else l = m + 1;
        //     }
        //     return ans;
        // }

        // public int minCost(int[] houses, int[][] cost, int m, int n, int target) { 
        //     this.m = m;
        //     this.n = n;
        //     dp = new Integer [m][n+1][target+1];
        //     return dfs(0, -1, target, houses, cost);
        // }
        // Integer [][][] dp; // dp[i][j][k]: the minimum cost where we have k neighborhoods in the first i houses and the i-th house is painted with the color j.
        // int m, n;
        // private int dfs(int i, int j, int k, int [] h, int [][] c) {
        //     if (target < 0) return 0;
        //     if (i == m) return target == 0 ? 1 : 0;
        //     if (dp[i][j][k] != null) return dp[i][j][k];
        //     int ans = 0;
        //     if (h[i] > 0 && h[i] != j) return dp[i][j][k] = Integer.MAX_VALUE;
        //     // 这里的递推 还有点儿不清楚
        // }

        // public int minTaps(int n, int[] r) {
        //     int [][] a = new int [n+1][];
        //     for (int i = 0; i <= n; i++) 
        //         a[i] = new int [] {i-r[i], i + r[i]};
        //     Arrays.sort(a, (x, y)-> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
        //     int j = 0, cnt = 0;
        //     if (a[0][0] > 0) return -1;
        //     for (int i = 0; i < n; i++) {
        //         j = i+1;
        //         while (j < n && a[j][0] < a[i][1]) {
        //         }
        //     }
        // }

        // // public int [] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        // public int smallestSufficientTeam(String[] req_skills, List<List<String>> people) { // bug: 有些什么地方没有写对
        //     Map<String, Integer> m = new HashMap<>();
        //     for (int i = 0; i < req_skills.length; i++) 
        //         m.put(req_skills[i], i);
        //     int range = 1 << req_skills.length;
        //     int [] dp = new int [range];
        //     Arrays.fill(dp, Integer.MAX_VALUE);
        //     dp[0] = 0;
        //     for (int i = 0; i < people.size(); i++) {
        //         // for (List<String> p : people) {
        //         int cur = 0;
        //         for (String s : people.get(i)) 
        //             if (m.keySet().contains(s)) cur |= (1 << m.get(s));
        //         // System.out.println("Integer.toBinaryString(cur): " + Integer.toBinaryString(cur));
        //         dp[cur] = 1;
        //         for (int j = 0; j < range; j++) {
        //             if ((j & cur) == cur)
        //                 dp[j] = Math.min(dp[j], dp[j ^ cur] + 1 ); // 有可能遍历的方向可以反着来？
        //         }
        //         // for (int i = range-1; i >= cur; i--) {
        //         //     // if (dp[i] != Integer.MAX_VALUE && (i & cur) == cur)
        //         //     if ((i & cur) == cur)
        //         //         dp[i] = Math.min(dp[i], dp[i ^ cur] + 1);
        //         // }
        //     }
        //     System.out.println(Arrays.toString(dp));
        //     return dp[range-1];
        // }
        // String []  a = new String []  {"algorithms", "math", "java", "reactjs", "csharp", "aws"};
        // String [][] b = new String [][] {{"algorithms","math","java"},{"algorithms","math","reactjs"},{"java","csharp","aws"},{"reactjs","csharp"},{"csharp","math"},{"aws","java"}};
        // String []  a = new String []  {"java", "nodejs", "reactjs"};
        // String [][] b = new String [][] {{"java"},{"nodejs"},{"nodejs","reactjs"}};
        // List<List<String>> ll = new ArrayList<>();
        // for (int i = 0; i < b.length; i++) 
        //     ll.add(Arrays.asList(b[i]));

        // public int dieSimulator(int n, int [] r) { // DP(pos, last) which means we are at the position pos having as last the last character seen.
        //     long mod = (int)1e9 + 7;
        //     long [][] dp = new long [n][7];
        //     int [] cnt = new int [7];
        //     Arrays.fill(cnt, 1);
        //     for (int i = 1; i < 7; i++) dp[0][i] = 1;
        //     for (int i = 1; i < n; i++) {
        //         for (int j = 1; j < 7; j++) {
        //             if (dp[i-1][j] == 0) continue;
        //             for (int k = 1; k < 7; k++) {
        //                 if (j != k) {
        //                     dp[i][k] = (dp[i][k] + dp[i-1][j]) % mod;
        //                     cnt[k] = 1;
        //                 } else if (j == k && cnt[j] < r[j-1]) {
        //                     dp[i][k] = (dp[i][k] + dp[i-1][k]) % mod;
        //                     cnt[k]++;
        //                 } else if ()  // 这么着好像没有纪录连续多少次同一个数字
        //             }
        //         }
        //     }
        // }
       //  public int dieSimulator(int n, int [] r) { // DP(pos, last) which means we are at the position pos having as last the last character seen.
       //      this.n = n;
       //      dp = new long [n+1][7][16];
       //      long ans = 0;
       //      // for (int i = 1; i < 7; i++) 
       //      //     ans = (ans + dfs(n-1, i, 1, r)) % mod;
       //      // return (int)ans;
       //      return (int)dfs(n, -1, 0, r);
       //  }
       //  int mod = (int)1e9 + 7;
       // long [][][] dp;
       //  int n;
       //  private long dfs(int i, int j, int k, int [] a) { // 感觉自项向下、自底向上，这里的上下方向有些混乱，条理不清楚
       //      if (i <= 0) return 0;
       //      if (i == 1) return k < a[j-1] ? 1 : 0;
       //      if (j != -1 && dp[i][j][k] > 0) return dp[i][j][k];
       //      long ans = 0;
       //      for (int x = 1; x < 7; x++) {
       //          if (j == -1 || j != x)
       //              ans = (ans + dfs(i-1, x, 1, a)) % mod;
       //          if (j == x && k < a[j-1])
       //              ans = (ans + dfs(i-1, j, k+1, a)) % mod;
       //          // else if (j == x && k = a[j-1])
       //      }
       //      if (j != -1)
       //          dp[i][j][k] = ans;
       //      return ans;
       //      // return dp[i][j][k] = ans;
       //  }


        
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        int [] a = new int [] {1,1,2,2,2,3};

        int r = s.dieSimulator(2, a);
        System.out.println("r: " + r);
    }
}

// TreeNode root = new TreeNode(a{0});
// root.buildTree(root, a);
// root.levelPrintTree(root);
