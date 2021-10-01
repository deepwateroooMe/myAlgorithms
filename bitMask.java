import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class bitMask {
    public static class Solution {

        // private boolean isValid(String s, int val) {
        //     if (Integer.bitCount(val) == 1) return true;
        //     for (int l = 0, r = 31; l < r; l++, r--) {
        //         while (((val >> l) & 1) != 1) l ++;
        //         while (((val >> r) & 1) != 1) r --;
        //         if (l < r && s.charAt(l) != s.charAt(r)) return false;
        //     }
        //     return true;
        // }
        // public int maxProduct(String s) {
        //     int n = s.length();
        //     int mask = (1 << n);
        //     int [] dp = new int [mask];
        //     for (int i = 1; i < mask; i++) 
        //         if (isValid(s, i))
        //             dp[i] = Integer.bitCount(i);
        //     int max = 0;
        //     for (int i = 1; i < mask; i++) {
        //         if (dp[i] == 0) continue;
        //         for (int j = i+1; j < mask; j++) {
        //             if (dp[j] == 0 || (i & j) != 0) continue;
        //             max = Math.max(max, dp[i]*dp[j]);
        //         }
        //     }
        //     return max;
        // }

        
        // public int [] smallestSufficientTeam(String [] req_skills, List<List<String>> people) {
        //     int n = req_skills.length;
        //     int [] dp = new int [1 << n];
        //     Arrays.sort(req_skills);
        //     int mask = 0, j = 0;
        //     for (int i = 0; i < people.size(); i++) {
        //         mask = 0;
        //         for (String ski : people.get(i)) {
        //             j = Arrays.asList(req_skills).indexOf(ski);
        //             if (j == -1) continue;
        //             mask |= (1 << j);
        //         }
        //         dp[mask] = Integer.bitCount(mask);
        //         if (dp[mask] == n) return 1;
        //     }
        //     for (int i = 1; i < 1 << n; i++) {
        //         if (dp[i] == 0) continue;
        //         for (int j = i-1; j >= 1; j--) { // subset: 遍历mask的各位相反的所有子集， 取mask个数最少
        //             if (dp[j] == 0 || (i | j) != (1 << n) -1) continue; // 这里的位操作还不是很熟悉
        //         }
        //     }            
        // }

        
        // public int minStickers(String[] stickers, String target) {
        //     int m = target.length(), n = 1 << m;
        //     int [] dp = new int [1 << m];
        //     Arrays.fill(dp, Integer.MAX_VALUE);
        //     dp[0] = 0;
        //     int cur = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (dp[i] == Integer.MAX_VALUE) continue;
        //         for (String s : stickers) {
        //             cur = i; // 关键代码（下面：在i上面加入一个单词后的效果）
        //             for (char c : s.toCharArray()) // for each char in the sticker, try apply it on a missing char in the subset of target
        //                 for (int j = 0; j < m; j++) 
        //                     if (target.charAt(j) == c && ((cur >> j) & 1) == 0) {
        //                         cur |= 1 << j; // 在cur中相应位置，加入c，形成新的集合。
        //                         break;
        //                     }
        //             dp[cur] = Math.min(dp[cur], dp[i]+1); // 判断是否需要替换原来cur中的值。
        //         }
        //     }
        //     return dp[n-1] == Integer.MAX_VALUE ? -1 : dp[n-1];
        // }
        // private int helper(String s) {
        //     if (dp.containsKey(s)) return dp.get(s);
        //     int ans = Integer.MAX_VALUE;
        //     int [] tar = new int [26];
        //     for (char c : s.toCharArray())
        //         tar[c-'a']++;
        //     for (int i = 0; i < m; i++) {
        //         if (map[i][s.charAt(0)-'a'] == 0) continue;
        //         StringBuilder sb = new StringBuilder();
        //         for (int j = 0; j < 26; j++) {
        //             if (tar[j] > 0)
        //                 for (int k = 0; k < Math.max(0, tar[j]-map[i][j]); k++)
        //                     sb.append((char)('a'+j));
        //         }
        //         int tmp = helper(sb.toString());
        //         if (tmp != -1) ans = Math.min(ans, 1+tmp);
        //     }
        //     dp.put(s, ans == Integer.MAX_VALUE ? -1 : ans);
        //     return dp.get(s);
        // }
        // Map<String, Integer> dp;
        // int [][] map;
        // int m;
        // public int minStickers(String[] stickers, String target) {
        //     m = stickers.length;
        //     map = new int [m][26];
        //     dp = new HashMap<>();
        //     for (int i = 0; i < m; i++) 
        //         for (char c : stickers[i].toCharArray()) 
        //             map[i][c-'a']++;
        //     dp.put("", 0);
        //     return helper(target);
        // }

        // private void helper (int [] arr, List<List<Integer>> ll, int [] jobs, int k, int idx, int ind, int cnt) {
        //     if (cnt == jobs.length) {
        //         Arrays.sort(arr);
        //         int max = 0;
        //         int locMin = Integer.MAX_VALUE;
        //         int locMindiff = arr[0];
        //         for (int j = 0; j < arr.length; j++) {
        //             if (arr[j] == 0) return;
        //             max = Math.max(max, arr[j]);
        //             locMin = Math.min(locMin, arr[j]);
        //         }
        //         if (locMindiff < minDiff &&  max < min) {
        //             min = max;
        //             minDiff = locMindiff;
        //         }                
        //         return;
        //     }
        //     for (int i = 0; i < jobs.length; i++) {
        //         if (!vis[i]) {
        //             vis[i] = true;
        //             for (int j = 0; j < arr.length; j++) {
        //                 if (!visj[j]) {
        //                     vis[j] = true;
        //                     arr[j] += jobs[i];
        //                     ll.get(j).add(jobs[i]);
        //                     helper(arr, new ArrayList<List<Integer>>(ll), jobs, k, i+1, ind, cnt+1);
        //                     ll.get(j).remove(ll.get(j).size()-1);
        //                     arr[j] -= jobs[i];
        //                     visj[j] = false;
        //                 }
        //             }
        //             vis[i] = false;
        //         }                
        //     }
        // }
        // int min = Integer.MAX_VALUE;
        // int minDiff = Integer.MAX_VALUE;
        // boolean [] vis;
        // boolean [] visj;
        // public int minimumTimeRequired(int[] jobs, int k) {
        //     int n = jobs.length;
        //     int sum = 0;
        //     int max = 0;
        //     for (int i = 0; i < n; i++) {
        //         max = Math.max(max, jobs[i]);
        //         sum += jobs[i];
        //     }
        //     int target = sum / k + (sum % k == 0 ? 0 : 1);
        //     int ind = sum % k == 0 ? 0 : 1;
        //     if (max > target) return max;
        //     int [] arr = new int[k];
        //     List<List<Integer>> ll = new ArrayList<>();
        //     for (int i = 0; i < k; i++) 
        //         ll.add(new ArrayList<Integer>());
        //     vis = new boolean[n];
        //     visj = new boolean[k];
        //     Arrays.sort(jobs);
        //     int [] sorted = IntStream.rangeClosed(1, jobs.length).map(i -> jobs[jobs.length-i]).toArray();
        //     helper(arr, ll, jobs, k, 0, ind, 0);
        //     return min;
        // }
        // private int cntOnes(int v) {
        //     int cnt = 0;
        //     while (v > 0) {
        //         if (v % 2 == 1) ++cnt;
        //         v >>= 1;
        //     }
        //     return cnt;
        // }

        
        // private backTracking(List<List<Integer>> ll, int v, int idx, Set<Integer> vis, int cnt) {
        //     if (vis.size() == m) return cnt;
        //     for (int i = 0; i < n; i++) { // backTracking people，但这里想得还不是很清楚
        //     }
        // }
        // int mod = (int)(1e9 + 7);
        // Set<Integer> ids;
        // int [] peo;
        // int n, m;
        // public int numberWays(List<List<Integer>> hats) {
        //     n = hats.size();
        //     Set<Integer> ids = new HashSet<>();
        //     for (int i = 0; i < n; i++) 
        //         ids.addAll(hats.get(i));
        //     m = ids.size();
        //     peo = new int [n];
        //     int res = 0;
        //     for (int v : ids) 
        //         res = (res + backTracking(hats, v, 0, new HashSet<Integer>())) % mod;
        //     return (int)res;
        // }
        // public int numberWays(List<List<Integer>> hats) { // 感觉这个题的逻辑想得不清不楚
        //     int n = hats.size(), m = 1 << n;
        //     Map<Integer, Set<Integer>> dp = new HashMap<>();
        //     dp.put(0, new HashSet<Integer>());
        //     for (int i = 1; i < m; i++) { // people mask
        //     }
        // }

        // private void backTracking(int [] arr, int k, int idx, int total) {
        //     if (total >= min) return; // early termination
        //     if (idx == n) {
        //         min = total; // With early termination, Math.min() is no longer needed.
        //         return;
        //     }
        //     for (int i = 0; i < dp.size(); i++) {
        //         LinkedList<Integer> bucket = dp.get(i);
        //         int dist = 0;
        //         if (bucket.size() < n/k && bucket.peekLast() < arr[idx]) {
        //             dist = arr[idx] - bucket.peekLast(); // ......
        //             bucket.addLast(arr[idx]);
        //             backTracking(arr, k, idx+1, total + dist);
        //             bucket.removeLast();
        //         }
        //     }
        //     if (dp.size() < k) {
        //         LinkedList<Integer> bucket = new LinkedList<>();
        //         bucket.add(arr[idx]);
        //         dp.addLast(bucket);
        //         backTracking(arr, k, idx+1, total);
        //         dp.removeLast();
        //     }
        // }
        // int min = Integer.MAX_VALUE;
        // LinkedList<LinkedList<Integer>> dp;
        // int n;
        // public int minimumIncompatibility(int[] arr, int k) {
        //     n = arr.length;
        //     dp = new LinkedList<>();
        //     Arrays.sort(arr);
        //     backTracking(arr, k, 0, 0);
        //     return min == Integer.MAX_VALUE ? -1 : min;
        // }

        // static int mod = (int) 1e9 + 7;
        // static int [] map = new int [31];
        // static {
        //     int [] prime = new int [] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29}; // length: 10
        //     for (int i = 2; i <= 30; ++i) {
        //         if (i % 4 == 0 || i % 9 == 0 || i == 25) continue;
        //         int mask = 0;
        //         for (int j = 0; j < 10; ++j) 
        //             if (i % prime[j] == 0)
        //                 mask |= 1 << j;
        //         map[i] = mask;
        //     }
        // }
        // public int numberOfGoodSubsets(int[] nums) {
        //     int n = nums.length, one = 0;
        //     int[] dp = new int[1024], cnt = new int[31]; // 1024 ?
        //     dp[0] = 1;
        //     for (int i : nums) {
        //         if (i == 1) one++;
        //         else if (map[i] != 0) cnt[i]++;
        //     }
        //     for (int i = 0; i < 31; ++i) {
        //         if (cnt[i] == 0) continue;
        //         for (int j = 0; j < 1024; ++j) {
        //             if ((j & map[i]) != 0) continue; // 含有某个公共质因子  val子集的统计数 * 当前val的重复次数   
        //             dp[j | map[i]] = (int) ((dp[j | map[i]] + dp[j] * (long) cnt[i]) % mod);
        //         }
        //     }
        //     long res = 0;
        //     for (int i : dp) res = (res + i) % mod;
        //     res--; // 应该是减去一个1吧
        //     if (one != 0) res = res * pow(one) % mod;
        //     return (int) res;
        // }
        // private long pow(int n) { // 快速幂
        //     long res = 1, m = 2;
        //     while (n != 0) {
        //         if ((n & 1) == 1) res = (res * m) % mod;
        //         m = m * m % mod;
        //         n >>= 1;
        //     }
        //     return res;
        // }
        // long f(int n, long mask) {
        //     if (n > 30) return mask == 0 ? 0L : 1L;
        //     long rst = f(n + 1, mask) % MOD;
        //     if (n == 2 || n == 3 || n == 5 || n == 7 || n == 11 || n == 13 || n == 17 || n == 19 || n == 23 || n == 29) 
        //         rst = (rst + cnts[n] * f(n + 1, mask | (1 << n))) % MOD;
        //     else if (n == 6) 
        //         if ((mask & (1 << 2)) == 0 && (mask & (1 << 3)) == 0)
        //             rst = (rst + cnts[n] * f(n + 1, mask | (1 << 2) | (1 << 3))) % MOD;
        //     else if (n == 10) 
        //         if ((mask & (1 << 2)) == 0 && (mask & (1 << 5)) == 0)
        //             rst = (rst + cnts[n] * f(n + 1, mask | (1 << 2) | (1 << 5))) % MOD;
        //     else if (n == 14) 
        //         if ((mask & (1 << 2)) == 0 && (mask & (1 << 7)) == 0)
        //             rst = (rst + cnts[n] * f(n + 1, mask | (1 << 2) | (1 << 7))) % MOD;
        //     else if (n == 22) 
        //         if ((mask & (1 << 2)) == 0 && (mask & (1 << 11)) == 0)
        //             rst = (rst + cnts[n] * f(n + 1, mask | (1 << 2) | (1 << 11))) % MOD;
        //     else if (n == 26) 
        //         if ((mask & (1 << 2)) == 0 && (mask & (1 << 13)) == 0)
        //             rst = (rst + cnts[n] * f(n + 1, mask | (1 << 2) | (1 << 13))) % MOD;
        //     else if (n == 15) 
        //         if ((mask & (1 << 3)) == 0 && (mask & (1 << 5)) == 0)
        //             rst = (rst + cnts[n] * f(n + 1, mask | (1 << 3) | (1 << 5))) % MOD;
        //     else if (n == 21) 
        //         if ((mask & (1 << 3)) == 0 && (mask & (1 << 7)) == 0)
        //             rst = (rst + cnts[n] * f(n + 1, mask | (1 << 3) | (1 << 7))) % MOD;
        //     else if (n == 30) 
        //         if ((mask & (1 << 2)) == 0 && (mask & (1 << 3)) == 0 && (mask & (1 << 5)) == 0)
        //             rst = (rst + cnts[n] * f(n + 1, mask | (1 << 2) | (1 << 3) | (1 << 5))) % MOD;
        //     return rst;
        // }
        // int MOD = 1_000_000_007;
        // long[] cnts = new long[31];
        // public int numberOfGoodSubsets(int[] nums) {
        //     for (int n : nums) cnts[n]++;
        //     long rst = f(1, 0L);
        //     for (int i = 0; i < cnts[1]; i++) // 没有快速幂，稍慢
        //         rst = rst * 2 % MOD;
        //     return (int) rst;
        // }
        // private static final long MOD=(long) (1e9+7);
        // private static long add(long a, long b){ a+=b; return a<MOD?a:a-MOD;}
        // private static long mul(long a, long b){ a*=b; return a<MOD?a:a%MOD;}
        // private static long pow(long a, long b) {
        //         //a %= MOD;
        //         //b%=(MOD-1);//if MOD is prime
        //         long res = 1;
        //         while (b > 0) {
        //             if ((b & 1) == 1)
        //                 res = mul(res, a);
        //             a = mul(a, a);
        //             b >>= 1;
        //         }
        //         return add(res, 0);
        // }
        // public int numberOfGoodSubsets(int[] nums) {
        //     int N = nums.length, i;
        //     int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        //     int[] mask = new int[31];
        //     int[] freq = new int[31];
        //     for (int x : nums) freq[x]++;
        //     for (i = 1; i <= 30; i++) 
        //         for (int j = 0; j < primes.length; j++) 
        //             if (i % primes[j] == 0) {
        //                 if ((i / primes[j]) % primes[j] == 0) {
        //                     mask[i] = 0;
        //                     break;
        //                 }
        //                 mask[i] |= (int) pow(2, j);
        //             }
        //     long[] dp = new long[1024];
        //     dp[0] = 1;
        //     for (i = 1; i <= 30; i++) {
        //         if (mask[i] == 0) continue;
        //         for (int j = 0; j < 1024; j++) 
        //             if ((mask[i] & j) == 0 && dp[j] > 0)
        //                 dp[(mask[i] | j)] = add(dp[(mask[i] | j)], mul(dp[j], freq[i]));
        //     }
        //     long ans = 0;
        //     for (i = 1; i < 1024; i++) ans = add(ans, dp[i]);
        //     ans = mul(ans, pow(2, freq[1]));
        //     ans = add(ans, 0);
        //     return (int) ans;
        // }


        // private void backTracking(int [] arr, int k, int idx) { 
        //     if (Arrays.stream(dp).max().getAsInt() >= min) return;
        //     if (idx < 0) {
        //         min = Math.min(min, Arrays.stream(dp).max().getAsInt());
        //         return;
        //     }
        //     for (int i = 0; i < k; i++) {
        //         if (i > 0 && dp[i] == dp[i-1]) continue;
        //         dp[i] += arr[idx];
        //         backTracking(arr, k, idx-1);
        //         dp[i] -= arr[idx];
        //     }
        // }
        // int sum, min, n;
        // int [] dp;
        // public int minimumTimeRequired(int[] jobs, int k) {
        //     n = jobs.length;
        //     sum = Arrays.stream(jobs).sum();
        //     min = sum;
        //     dp = new int [k];
        //     Arrays.sort(jobs);
        //     backTracking(jobs, k, n-1);
        //     return min;
        // }


        // public int maxStudents(char[][] seats) {
        //     int m = seats.length;
        //     int n = seats[0].length;
        //     int range = 1 << n, mask = 0;
        //     int [] rowMax = new int [m+1]; // 相比于我的第一行，他是先生成了每一行的mask base
        //     for (int i = 0; i < m; i++) { 
        //         mask = 0;
        //         for (int j = 0; j < n; j++) 
        //             mask = mask * 2 + (seats[i][j] == '.' ? 1 : 0);
        //         rowMax[i+1] = mask;
        //     }
        //     int [][] dp = new int [m+1][range];
        //     for (int i = 0; i <= m; i++) 
        //         Arrays.fill(dp[i], -1);
        //     dp[0][0] = 0;
        //     //             如果想要满足限制条件2，则需要第i排可能的bitmask 与第 i - 1排可能的bitmask进行检测
        //     // // upper left and upper right are valid or not
        //     //                 (mask >> 1) & prev_mask 
        //     //                 mask & (prev_mask >> 1)
        //     //                 dp[r - 1][prev_mask] is valid
        //     //                 基于以上的分析，动规方程可以归纳为以下
        //     //                 dp[r][mask] = max(dp[r][mask], dp[r - 1][prev_mask] + bit_count(mask)
        //     for (int i = 1; i <= m; i++) 
        //         for (int curMask = 0; curMask <= rowMax[i]; curMask++) 
        //             if ((curMask & rowMax[i]) == curMask && (curMask & (curMask >> 1)) == 0) // 现行所有的有效掩码: 既不会坐墙上，也左右无人
        //                 for (int preMask = 0; preMask < range; preMask++) 
        //                     if (dp[i-1][preMask] != -1 && (curMask & (preMask >> 1)) == 0 && ((curMask >> 1) & preMask) == 0)
        //                         dp[i][curMask] = Math.max(dp[i][curMask], dp[i-1][preMask] + Integer.bitCount(curMask));
                    
        //     int max = 0;
        //     for (int i = 0; i < range; i++) 
        //         max = Math.max(max, dp[m][i]);
        //     return max;
        // }
        // private boolean isValid(char [][] arr, int v, int idx) { // 自己写的，不知道自己写的错哪里了，改天把它找出来
        //     for (int i = 0; i < n; i++) 
        //         if (((v >> i) & 1) == 1 && arr[idx][i] != '.') return false;
        //     return true;
        // }
        // int m, n;
        // public int maxStudents(char[][] seats) {
        //     m = seats.length;
        //     n = seats[0].length;
        //     int range = 1 << n;
        //     int [][] dp = new int [m+1][range];
        //     for (int i = 0; i <= m; i++) 
        //         Arrays.fill(dp[i], -1);
        //     dp[0][0] = 0;
        //     for (int i = 1; i < m; i++) {
        //         for (int k = 0; k < range; k++) { // cur mask == k
        //             if (!isValid(seats, k, i-1)) continue;
        //             for (int j = 0; j < range; j++) { // pre mask == j
        //                 if (dp[i-1][j] == -1) continue;
        //                 if (((k >> 1) & j) == 0 && (k & (j >> 1)) == 0)
        //                     dp[i][k] = Math.max(dp[i][k], dp[i-1][j] + Integer.bitCount(k));
        //             }
        //         }
        //     }
        //     int max = 0;
        //     for (int i = 1; i < range; i++) 
        //         max = Math.max(max, dp[m][i]);
        //     return max;
        // }

        
        // https://blog.csdn.net/u013325815/article/details/106991435
        // 最近学到了这个强行剪枝的技巧，就是收集到的size > 目前的结果，直接return；
        // 这题的思路就是先把skill 和set of people建立好，
        // 然后去用skill set做backtracking收集，如果temp team的size大于结果，直接return，否则update结果，
        // 这里有个小tricky的地方，就是如果people是新人，加入之后dfs，backtracking的时候，要判断如果是新人，则remove，否则不remove；
        // private void dfs(String [] arr, Set<Integer> tm, int idx) {
        //     if (tm.size() > n) return;
        //     if (idx == arr.length) {
        //         if (tm.size() < teamSize) {
        //             teamSize = tm.size();
        //             resTeam = new HashSet<>(tm);
        //         }
        //         return;
        //     }
        //     for (int people : ms.get(arr[idx])) {
        //         boolean isNewPerson = !tm.contains(people);
        //         tm.add(people);
        //         dfs(arr, tm, idx+1);
        //         if (isNewPerson) tm.remove(people);
        //     }
        // }
        // private boolean isSubset(int a, int b) {
        //     if (Integer.bitCount(a) < Integer.bitCount(b)) return false;
        //     if (Integer.bitCount(a) == Integer.bitCount(b) && (a ^ b) == 0) return true;
        //     int x = 0, y = 0;
        //     while (b > 0) {
        //         if (a % 2 == 0 && b % 2 == 1) return false;
        //         a >>= 1;
        //         b >>= 1;
        //     }
        //     return true;
        // }
        // Map<String, Set<Integer>> ms = new HashMap<>();
        // Set<Integer> resTeam = new HashSet<>();
        // int n, teamSize;
        // public int [] smallestSufficientTeam(String [] req_skills, List<List<String>> people) {
        //     n = people.size();
        //     teamSize = n;
        //     List<String> ask = Arrays.asList(req_skills);
        //     Map<Integer, Integer> mp = new HashMap<>();
        //     int [] arr = new int [n];
        //     TreeSet<Integer> mask = new TreeSet<>((a, b)->Integer.bitCount(b) - Integer.bitCount(a));
        //     int m  = 0, tm = 0, cur = 0;
        //     boolean noNeed = false;
        //     for (int i = 0; i < n; i++) {
        //         m = people.get(i).size();
        //         if (m == 0) continue; 
        //         tm = 0;
        //         for (int j = 0; j < ask.size(); j++) {
        //             if (people.get(i).contains(ask.get(j)))
        //                 tm |= (1 << j);
        //         }
        //         mp.put(tm, i);
        //         arr[i] = tm;
        //         // System.out.println("Integer.toBinaryString(tm): " + Integer.toBinaryString(tm));
        //     }
        //     // System.out.println("mp.size(): " + mp.size());
        //     // for (Map.Entry<Integer, Integer> entry : mp.entrySet()) 
        //     //     System.out.print(entry.getKey() + ", " + entry.getValue() + "\n");

        //     // still need custom sort map by value's bitCount
        //     // Arrays.sort(arr, (a, b)->(Integer.bitCount(b) - Integer.bitCount(a)));
        //     Collections.sort(people, (a, b)->b.size() - a.size());
        //     Comparator<Integer> cmp = (Integer a, Integer b) -> Integer.bitCount(b) - Integer.bitCount(a);
        //     Map<Integer, Integer> msorted = mp.entrySet().stream()
        //         .sorted(Map.Entry.comparingByKey(cmp)) // Comparator.reverseOrder()
        //         .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
        //     // System.out.println("msorted.size(): " + msorted.size());
        //     // for (Map.Entry<Integer, Integer> entry : msorted.entrySet()) 
        //     //     System.out.print(entry.getKey() + ", " + entry.getValue() + "\n");
        //     // for (int i = 0; i < n; i++) {
        //     for (Map.Entry<Integer, Integer> en : msorted.entrySet()) {
        //         noNeed = false;
        //         int i = en.getValue();
        //         if (mask.size() > 0 && arr[i] < Integer.bitCount(mask.first())) {
        //             Iterator it = mask.iterator();
        //             while (it.hasNext()) {
        //                 cur = (int)it.next();
        //                 if (isSubset(cur, tm)) {
        //                     noNeed = true;
        //                     break;
        //                 }
        //             }
        //         }
        //         if (noNeed) continue;
        //         System.out.println("i: " + i);
        //         // System.out.println("people.get(i).size(): " + people.get(i).size());
        //         // for (int z = 0; z < people.get(i).size(); ++z) 
        //         //     System.out.print(people.get(i).get(z) + ", ");
        //         // System.out.print("\n");
        //         mask.add(en.getKey());
        //         for (String ski : people.get(i)) {
        //             if (!ask.contains(ski)) continue;
        //             ms.putIfAbsent(ski, new HashSet<Integer>());
        //             ms.get(ski).add(i);
        //         }
        //     }
        //     System.out.println("ms.size(): " + ms.size());
        //     for (Map.Entry<String, Set<Integer>> entry : ms.entrySet()) {
        //         System.out.print(entry.getKey() + ":\n ");
        //         for (Integer z : entry.getValue())
        //             System.out.print(z + ", ");
        //         System.out.print("\n");
        //     }
        //     dfs(req_skills, new HashSet<>(), 0);
        //     int [] res = new int [resTeam.size()];
        //     int i = 0;
        //     for (Integer v : resTeam) 
        //         res[i++] = v;
        //     return res;
        // }
        // private int teamSize;
        // private Set<Integer> resTeam; 
        // public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        //     int n = people.size();
        //     teamSize = n;
        //     resTeam = new HashSet<Integer>();
        //     HashMap<String, Set<Integer>> map = new HashMap<>(); // map input to <Skill, Set<People>>;
        //     for(int i = 0; i < n; i++) 
        //         for(String skill: people.get(i)) {
        //             map.putIfAbsent(skill, new HashSet<Integer>());
        //             map.get(skill).add(i);
        //         }
        //     HashSet<Integer> team = new HashSet<>(); // search res;
        //     dfs(map, req_skills, team, 0);
        //     int[] res = new int[resTeam.size()]; // collect res;
        //     int index = 0;
        //     for (int person: resTeam) 
        //         res[index++] = person;
        //     return res;
        // }
        // private void dfs(HashMap<String, Set<Integer>> map, String[] req_skills, HashSet<Integer> team, int index) {
        //     if(team.size() > teamSize)  return;
        //     if(index == req_skills.length) {
        //         teamSize = team.size();
        //         resTeam = new HashSet<Integer>(team);
        //         return;
        //     }
        //     for(int people: map.get(req_skills[index])) {
        //         boolean isNewPerson = !team.contains(people);
        //         team.add(people);
        //         dfs(map, req_skills, team, index + 1);
        //         if (isNewPerson) 
        //             team.remove(people);
        //     }
        // }


        // public int numberWays(List<List<Integer>> hats) {
        //     int n = hats.size(), range = 1 << n, mod = (int)1e9 + 7;
        //     List<Integer> ids = new ArrayList<>();
        //     Map<Integer, List<Integer>> hm = new HashMap<>(); // hats map
        //     for (int i = 0; i < n; i++) 
        //         for (int j = 0; j < hats.get(i).size(); j++) {
        //             hm.computeIfAbsent(hats.get(i).get(j), k -> new ArrayList<>());
        //             hm.get(hats.get(i).get(j)).add(i);
        //             if (!ids.contains(hats.get(i).get(j))) ids.add(hats.get(i).get(j));
        //         }
        //    int [][] dp = new int [range][ids.size()+1];
        //    dp[0][0] = 1; // 回到dp[0][0]状态时为1个方案数！
        //     for (int i = 1; i <= ids.size(); i++) 
        //         for (int mask = 0; mask < range; mask++) {
        //             dp[mask][i] = dp[mask][i-1];     // 1.第i个帽子不分配的情况
        //             int size = hm.get(ids.get(i-1)).size();
        //             for (int j = 0; j < size; j++)   // 2.第i个帽子分给第j个人的情况
        //                 if ((mask & (1 << hm.get(ids.get(i-1)).get(j))) != 0) {
        //                     dp[mask][i] += dp[mask ^ (1 << hm.get(ids.get(i-1)).get(j))][i-1]; // 第i个帽子可以是由右边异或的状态转移过来的
        //                     dp[mask][i] %= mod;
        //                 }
        //         }
        //     return dp[range-1][ids.size()];
        // }
//         int size = capList[i].size();
//         for(int j = 0; j < size; j++){    //  人 j 当前已有帽子，不分配帽子 i，跳过
//             if ( (mask & (1 << capList[i].get(j))) != 0 ){
//                 continue;
//             }    else{ // 分配给人 j
//                 ways += countWays(mask | (1 << capList[i].get(j)), i+1);
//             }
//             ways %= MOD;
//         }
//         int dp[][] = new int[(1 << n)][101];
//         dp[0][0] = 1;
//         for(int i = 1; i <= 100; i++) {
//             for(int mask = 0; mask < (1<<n); mask++) {        // 1.第i个帽子不分配的情况
//                 dp[mask][i] = dp[mask][i-1];
//                 // 2.第i个帽子分给第j个人的情况
//                 int size = capList[i].size();
//                 for(int j = 0; j < size; j++) {
//                     if ((mask & (1 << capList[i].get(j))) != 0) {
//                         dp[mask][i] += dp[mask ^ (1 << capList[i].get(j))][i - 1];
//                         dp[mask][i] %= N;
//                     }
//                 }
//             }
//         }
//         return dp[(1 << n) - 1][100];
//         int dp[] = new int[(1 << n)];
//         dp[0] = 1;
// // 动态规划
//         for(int i = 1; i <= 100; i++) {
//             for(int mask = (1<<n)-1; mask >= 0; mask--) {
//                 int size = capList[i].size();
//                 for(int j = 0; j < size; j++) { //  将第 i 个帽子分配出去
//                     if ((mask & (1 << capList[i].get(j))) != 0) {
//                         int next = mask ^ (1 << capList[i].get(j));
//                         dp[next] += dp[mask];
//                         dp[next] %= N;
//                     }
//                 }
//             }
//         }
//         return dp[(1 << n) - 1];
//         static final int MOD = 1000000007;
//         int allmask = (1 << n) - 1;
//         // 表示所有的人都戴了帽子，比如n = 3，111 表示所有人都带了帽子，即为 7
//         long countWaysRec(int mask, int i){
//             if (mask = allmask) return 1;
//             if (i > 100) return 0;
//             long ways = countWays(mask, i+1);
// // 选择不分配第 i 个物品    // 选择将第 i 个帽子分配可分配的人
//             int size = capList[i].size();
//             for(int j = 0; j < size; j++){        //  人 j 当前已有帽子，不分配帽子 i，跳过
//                 if ( (mask & (1 << capList[i].get(j))) != 0 ){
//                     continue;
//                 } else { // 分配给人 j
//                     ways += countWays(mask | (1 << capList[i].get(j)), i+1);
//                 }
//                 ways %= MOD;
//             }
//             return ways;
//         }
//         static final int MOD = 1000000007;
//         int allmask = (1 << n) - 1;
//         // 表示所有的人都戴了帽子，比如n = 3，111 表示所有人都带了帽子，即为 7
//         int mem[][] = new int[1025][101];
//         // 备忘录
//         long countWaysMemo(int mask, int i){
//             if (mask = allmask) return 1;
//             if (i > 100) return 0;
//             if (mem[mask][i] != -1) return mem[mask][i];
//             // 查找备忘录中子问题的解，如果有，直接返回即可
//             long ways = countWays(mask, i+1);
// // 选择不分配第 i 个物品        // 选择将第 i 个帽子分配可分配的人
//             int size = capList[i].size();
//             for(int j = 0; j < size; j++){        //  人 j 当前已有帽子，不分配帽子 i，跳过
//                 if ( (mask & (1 << capList[i].get(j))) != 0 ){
//                     continue;
//                 }        else{ // 分配给人 j
//                     ways += countWays(mask | (1 << capList[i].get(j)), i+1);
//                 }
//                 ways %= MOD;
//             }
//             return mem[mask][i] = (int) ways;
//         }


        // Staightforward top-down DP for the first group. At the same time, we track which elements from the second group were connected in mask.
        // After finishing with the first group, we detect elements in group 2 that are still disconnected,
        // and connect them with the "cheapest" node in the first group.
        // private int dfs(List<List<Integer>> arr, int i, int mask, int [] minCost) { // 自顶向下，需要记忆
        //     if (dp[i][mask] != null) return dp[i][mask];
        //     // if (i == m && Integer.bitCount(mask) == n) return 0; // 这行可要可不要
        //     if (i == m) {       
        //         int res = 0;
        //         for (int j = 0; j < n; j++) 
        //             if ((mask  & (1 << j)) == 0) res += minCost[j];
        //         return dp[i][mask] = res;
        //     }
        //     int res = Integer.MAX_VALUE;
        //     for (int j = 0; j < n; j++) // 只有暴力查找尝试了所有可能性，才是全局最优解
        //         res = Math.min(res, dfs(arr, i+1, mask | (1 << j), minCost) + arr.get(i).get(j));
        //     return dp[i][mask] = res;
        // }
        // Integer [][] dp; // (number of points assigned in first group, bitmask of points assigned in second group).
        // int m, n;
        // public int connectTwoGroups(List<List<Integer>> cost) {
        //     m = cost.size();
        //     n = cost.get(0).size();
        //     dp = new Integer [m+1][1 << n]; // 右边点组过程中共有1 << n种状态，但是如何知道记住右边的点分别是与左边哪个点连接起来的呢？
        //     int [] minCost = new int [n];   // 对右边的每个点，它们分别与左边点连通，各点所需的最小花费
        //     Arrays.fill(minCost, Integer.MAX_VALUE);
        //     for (int j = 0; j < n; j++) 
        //         for (int i = 0; i < m; i++) 
        //             minCost[j] = Math.min(minCost[j], cost.get(i).get(j));
        //     return dfs(cost, 0, 0, minCost);
        // }
        // public int connectTwoGroups(List<List<Integer>> cost) { // 又不知道哪里错了？！！！
        //     int m = cost.size();
        //     int n = cost.get(0).size();
        //     int [][] dp = new int [m][1 << n]; // 右边点组过程中共有1 << n种状态，但是如何知道记住右边的点分别是与左边哪个点连接起来的呢？
        //     for (int i = 0; i < m; i++) 
        //         Arrays.fill(dp[i], Integer.MAX_VALUE/2);
        //     for (int i = 0; i < m; i++) {      // 暴力求解所有值取最小
        //         for (int j = 0; j < 1 << n; j++) {
        //             for (int k = 0; k < n; k++) {
        //                 if (i > 0 && dp[i-1][j^(1 << k)] != Integer.MAX_VALUE/2) 
        //                     dp[i][j] = Math.min(dp[i][j], cost.get(i).get(k) + dp[i-1][j ^ (1 << k)]);
        //                 if (i > 0 && dp[i-1][j] != Integer.MAX_VALUE/2)
        //                     dp[i][j] = Math.min(dp[i][j], cost.get(i).get(k) + dp[i-1][j]);
        //                 if (i == 0 && (j ^ (1 << k)) == 0) dp[i][j] = cost.get(i).get(k);
        //                 else if (dp[i][j^(1 << k)] != Integer.MAX_VALUE/2)
        //                     dp[i][j] = Math.min(dp[i][j], cost.get(i).get(k) + dp[i][j ^ (1 << k)]);
        //             }
        //         }
        //     }
        //     return dp[m-1][(1 << n)-1];
        // }



    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // int [][] a = new int [][] {{1, 3, 5}, {4, 1, 1}, {1, 5, 3}};
        int [][] a = new int [][] {{22},{91}};

        List<List<Integer>> ll = new ArrayList<>();
        for (int i = 0; i < a.length; i++) 
            ll.add(Arrays.stream(a[i]).boxed().collect(Collectors.toList()));

        int res = s.connectTwoGroups(ll);
        System.out.println("res: " + res);
    }
}

         