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


        // 强行剪枝: 收集到的size >= 目前的结果，直接return；
        // 这题的思路就是先把skill 和set of people建立好，
        // 然后去用skill set做backtracking收集，如果temp team的size大于结果，直接return，否则update结果，
        // 这里有个小tricky的地方，就是如果people是新人，加入之后dfs，backtracking的时候，要判断如果是新人，则remove，否则不remove；
        // private void dfs(String[] req_skills, HashSet<Integer> team, int idx) {
        //     if (team.size() >= minTeamSize) return;
        //     if (idx == req_skills.length) {
        //         minTeamSize = team.size();
        //         resTeam = new HashSet<Integer>(team);
        //         return;
        //     }
        //     boolean isNewPerson = false;
        //     for (int people : map.get(req_skills[idx])) {
        //         isNewPerson = team.add(people);
        //         dfs(req_skills, team, idx + 1);
        //         if (isNewPerson)
        //             team.remove(people);
        //     }
        // }
        // HashMap<String, Set<Integer>> map;
        // Set<Integer> resTeam; 
        // int minTeamSize;
        // public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        //     minTeamSize = people.size();
        //     this.map = new HashMap<>(); 
        //     for (int i = 0; i < minTeamSize; i++) 
        //         for (String skill: people.get(i)) 
        //             map.computeIfAbsent(skill, k -> new HashSet<Integer>()).add(i);
        //     this.resTeam = new HashSet<Integer>();
        //     dfs(req_skills, new HashSet<Integer>(), 0);
        //     int[] res = new int[resTeam.size()];     
        //     int idx = 0;
        //     for (int person : resTeam) 
        //         res[idx++] = person;
        //     return res;
        // }
        // public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        //     int n = req_skills.length, range = 1 << n, cur, idx;
        //     Map<String, Integer> idxMap = new HashMap<>();
        //     for (int i = 0; i < n; i++) 
        //         idxMap.put(req_skills[i], i);
        //     long [] dp = new long [range]; // 每个bit位实际存了构成答案最小组的各成员的下标, 60个人, long
        //     int [] cnt = new int [range];
        //     Arrays.fill(cnt, Integer.MAX_VALUE);
        //     cnt[0] = 0;
        //     for (int i = 0; i < people.size(); i++) {
        //         List<String> l = people.get(i);
        //         cur = 0;
        //         for (String skill : l) 
        //             if (idxMap.containsKey(skill))
        //                 cur |= 1 << idxMap.get(skill);
        //         for (int j = range-1; j > 0; j--) {
        //             idx = (j & cur) ^ j; // 由其它人所构成的拥有j的这些种技能的子集/ j的这些种技能可以由j一个人来替换(其它可能需要很多人才能最终拥有这些技能)
        //             if (cnt[idx] != Integer.MAX_VALUE && cnt[j] > cnt[idx] + 1) {
        //                 cnt[j] = cnt[idx] + 1;
        //                 dp[j] = dp[idx] | (1L << i); // at most 60 people
        //             }
        //         }
        //     }
        //     int [] res = new int[cnt[range-1]];
        //     long preRes = dp[range-1]; // 5 people: 11111, 1111, 111, 11, 1
        //     int valIdx = 0;
        //     long val = 0;
        //     idx = 0;
        //     while (preRes != 0) {
        //         val = preRes & 1;
        //         if (val == 1) res[idx++] = valIdx;
        //         preRes >>= 1;
        //         valIdx++;
        //     }
        //     return res;
        // }
        // List<Integer> minComb;
        // int[] peopleSkillMasks;
        // Integer[] memo;  // 这个方法确实快一点儿
        // int[] nextPerson;
        // int n;
        // public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        //     // 1. some preprocess to get bitmask for people skills
        //     this.n = req_skills.length;
        //     Map<String, Integer> skillToIdx = new HashMap<>();
        //     for (int i = 0; i < n; i++) 
        //         skillToIdx.put(req_skills[i], i);
        //     this.peopleSkillMasks = new int[people.size()];
        //     for (int i = 0; i < peopleSkillMasks.length; i++) {
        //         int skillMask = 0;
        //         for (String skill : people.get(i)) 
        //             skillMask |= (1 << skillToIdx.get(skill));
        //         peopleSkillMasks[i] = skillMask;
        //     }
        //     // 2. dfs
        //     memo = new Integer[1 << n];
        //     nextPerson = new int[1 << n];
        //     dfs(0, 0);
        //     // 3. reconstruct the path
        //     int curSkillSet = 0;
        //     List<Integer> res = new ArrayList<>();
        //     while(curSkillSet != (1 << n) - 1) {
        //         res.add(nextPerson[curSkillSet]);
        //         curSkillSet |= peopleSkillMasks[nextPerson[curSkillSet]];
        //     }
        //     return res.stream().mapToInt(i->i).toArray();
        // }
        // // a very simple dfs with memo to compute all combinations of people. 
        // // Use memorization to optimize the time complexity to O(2^skill * people) 2^skill for 2^skill node in the tree, people because each node has people computation
        // private int dfs(int curSkillSet, int startIdx) {
        //     if (curSkillSet == (1 << n) - 1) return 0;
        //     if (memo[curSkillSet] == null) {
        //         int res = Integer.MAX_VALUE / 2;
        //         int nextPersonIdx = -1;
        //         for (int i = startIdx; i < peopleSkillMasks.length; i++) {
        //             int withNewSkill = peopleSkillMasks[i] | curSkillSet; 
        //             if (withNewSkill != curSkillSet) {
        //                 int numPeople = dfs(withNewSkill, i+1) + 1;
        //                 if (res > numPeople) {
        //                     res = numPeople;
        //                     nextPersonIdx = i;
        //                 }
        //             }
        //         }
        //         memo[curSkillSet] = res;
        //         nextPerson[curSkillSet] = nextPersonIdx; 
        //     }
        //     return memo[curSkillSet];
        // }


        // private void dfs(int [] tmp, int idx, int curCost, boolean [] vis, int path) {
        //     if (idx == n) {
        //         if (curCost > maxCost) {
        //             maxCost = curCost;
        //             best = Arrays.copyOf(tmp, n);
        //             // best = tmp.clone();
        //         }
        //         return;
        //     }
        //     for (int i = 0; i < n; i++) 
        //         if (!vis[i]) {
        //             int tmpCost = idx == 0 ? 0 : curCost + cost[tmp[idx-1]][i];
        //             int tmpPath = (path | (1 << i));
        //             int maxCost = dp[tmpPath][i];
        //             if (maxCost > 0 && tmpCost <= maxCost) continue;
        //             tmp[idx] = i;
        //             dp[tmpPath][i] = tmpCost; // need to remember the res
        //             vis[i] = true;
        //             dfs(tmp, idx+1, tmpCost, vis, tmpPath);
        //             vis[i] = false;
        //         }
        // }
        // int n, maxCost = Integer.MIN_VALUE; // 最长公共子串的长度和，越大越好
        // int [][] dp;
        // int [][] cost;
        // int [] best;
        // public String shortestSuperstring(String[] words) {
        //     n = words.length;
        //     cost = new int [n][n];
        //     for (int i = 0; i < n; i++) 
        //         for (int j = 0; j < n; j++) {
        //             if (i == j) continue;
        //             for (int k = 1; k <= words[i].length() && k <= words[j].length(); k++) {
        //                 if (words[i].substring(words[i].length()-k).equals(words[j].substring(0, k)))
        //                     cost[i][j] = k;
        //             }
        //         }
        //     dp = new int [1 << n][n];
        //     best = new int [n];
        //     dfs(new int [n], 0, 0, new boolean [n], 0);
        //     String res = words[best[0]];
        //     for (int i = 1; i < n; i++) {
        //         int costVal = cost[best[i-1]][best[i]];
        //         res += words[best[i]].substring(costVal);
        //     }
        //     return res;
        // }
        // public String shortestSuperstring(String[] words) {
        //     int n = words.length;
        //     String [][] dp = new String [1 << n][n];
        //     int [][] overlap = new int [n][n];
        //     for (int i = 0; i < n; i++) 
        //         for (int j = 0; j < n; j++) {
        //             if (i == j) continue;
        //             for (int k = Math.min(words[i].length(), words[j].length()); k > 0; k--) {
        //                 if (words[i].substring(words[i].length()-k).equals(words[j].substring(0, k))) {
        //                     overlap[i][j] = k;
        //                     break;
        //                 }
        //             }
        //         }
        //     for (int i = 0; i < n; i++)
        //         dp[1 << i][i] = words[i];
        //     for (int mask = 1; mask < (1 << n); mask++) 
        //         for (int j = 0; j < n; j++) {
        //             if ((mask & (1 << j)) == 0) continue;
        //             for (int i = 0; i < n; i++) {
        //                 if (i == j || (mask & (1 << i)) == 0) continue;
        //                 String tmp = dp[mask ^ (1 << j)][i] + words[j].substring(overlap[i][j]);
        //                 if (dp[mask][j] == null || tmp.length() < dp[mask][j].length()) // str.isEmpty()
        //                     dp[mask][j] = tmp;
        //             }
        //         }
        //     int last = (1 << n) - 1;
        //     String res = dp[last][0];
        //     for (int i = 1; i < n; i++) 
        //         if (dp[last][i].length() < res.length())
        //             res = dp[last][i];
        //     return res;
        // }


//         public int minNumberOfSemesters(int n, int [][] relations, int k) {
//             int [] pre = new int [n]; // bitmask representing prerequirements
//             for (int i = 0; i < relations.length; i++) {
//                 int u = relations[i][0] - 1;
//                 int v = relations[i][1] - 1;
//                 pre[v] |= (1 << u);
//             }
//             int range = (1 << n);
//             int [] cnt = new int [range]; // 所有的状态只数一遍位数
//             for (int i = 0; i < range; i++) 
//                 cnt[i] = Integer.bitCount(i);
//             int [] dp = new int [range];
//             Arrays.fill(dp, n);
//             dp[0] = 0;
//             for (int i = 0; i < range; i++) {
//                 int available = 0;
//                 for (int j = 0; j < n; j++) 
//                     if ((i & pre[j]) == pre[j]) // 可是包含了忆经选过的课程
//                         available |= (1 << j);
//                 available &= ~i; // Don't want to study those already studied courses.
//                 int nextCourses = available;
//                 while (nextCourses > 0) {
//                     if (cnt[nextCourses] <= k)
//                         dp[i | nextCourses] = Math.min(dp[i | nextCourses], dp[i] + 1);
// // 遍历现在可选课程的所有子集：Enumerate all subsets. E.g, available = 101, next: 100 -> 001 -> 000
//                     nextCourses = (nextCourses -1) & available; 
//                 }
//             }
//              return dp[range-1];
//         }
        // void solve(int i, int s, int k, int n, int s0, int s1, vector<int> &f) {
        //     if (k == 0 || i == n) {
        //         f[s0 | s] = min(f[s0 | s], f[s0] + 1);
        //         return;
        //     }
        //     solve(i + 1, s, k, n, s0, s1, f);
        //     if ((s1 >> i) & 1)
        //         solve(i + 1, s | 1 << i, k - 1, n, s0, s1, f);
        // }
        // int minNumberOfSemesters(int n, vector<vector<int>>& dependencies, int k) {
        //     vector<int> pre(n, 0);
        //     for (const auto &v : dependencies)
        //         pre[v[1] - 1] |= 1 << (v[0] - 1);
        //     vector<int> f(1 << n, INT_MAX);
        //     f[0] = 0;
        //     for (int s0 = 0; s0 < (1 << n); s0++) {
        //         if (f[s0] == INT_MAX)
        //             continue;
        //         int s1 = 0;
        //         for (int i = 0; i < n; i++)
        //             if (!((s0 >> i) & 1) && ((pre[i] & s0) == pre[i]))
        //                 s1 |= 1 << i;
        //         solve(0, 0, k, n, s0, s1, f);
        //     }
        //     return f[(1 << n) - 1];
        // }

        
        // private int calcHappiness(long v, int cnt) { // TLE TLE TLE 自己写的暴力解法，超时
        //     StringBuilder s = new StringBuilder(Long.toBinaryString(v)); // 拍照存根留恋。。。。。。
        //     while (s.length() < cnt * 2) s.insert(0, '0');
        //     int row = cnt / n + (cnt % n == 0 ? 0 : 1), idx = 0;
        //     int [][] arr = new int [row+1][n];
        //     for (int i = 0; i+2 <= s.length(); i += 2) {
        //         arr[idx/n][idx%n] = Integer.parseInt(s.substring(i, i+2));
        //         ++idx;
        //     }
        //     int ans = 0, tmp = 0;
        //     for (int i = 0; i <= row; i++) 
        //         for (int j = 0; j < n; j++) {
        //             if (arr[i][j] == 0) continue;
        //             tmp = (arr[i][j] == 1 ? 120 : 40);
        //             for (int [] d : dirs) {
        //                 int x = i + d[0];
        //                 int y = j + d[1];
        //                 if (x < 0 || x > row || y < 0 || y >= n || arr[x][y] == 0) continue;
        //                 if (arr[i][j] == 1) tmp -= 30;
        //                 else tmp += 20;
        //             }
        //             ans += tmp;
        //         }
        //     return ans;
        // }
        // private void helper(int col, int pos, long cur, int inCnt, int exCnt) {
        //     if (pos == col) {            // 1: 0, 2: 1
        //         dic.put(cur, new int [] {inCnt, exCnt, Long.bitCount(cur) > 0 ? calcHappiness(cur, pos) : 0});
        //         return;
        //     }
        //     for (int i = 0; i < 3; i++) { // 0: empty, 1: introverts, 2: extroverts
        //         if (i == 1 && inCnt == 0) continue;
        //         if (i == 2 && exCnt == 0) continue;
        //         helper(col, pos+1, (cur << 2) | i, (i == 1 ? inCnt-1 : inCnt), (i == 2 ? exCnt-1 : exCnt));
        //     }
        // }
        // int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // Map<Long, int []> dic = new HashMap<>();
        // int m, n;
        // public int getMaxGridHappiness(int mm, int nn, int introvertsCount, int extrovertsCount) {
        //     m = mm; n = nn;
        //     helper(n, 0, 0, introvertsCount, extrovertsCount);
        //     int [] cnts = null;
        //     int max = 0, locH = 0, k = 0;
        //     if (m == 1) {
        //         for (long v : dic.keySet()) {
        //             cnts = dic.get(v);
        //             max = Math.max(max, cnts[2]);
        //         }
        //         return max;
        //     }
        //     Map<Long, int []> next = new HashMap<>();
        //     long cur = 0;
        //     for (int i = 1; i < m; i++) {
        //         for (int j = 0; j < n; j++) {
        //             for (long v : dic.keySet()) {
        //                 cnts = dic.get(v);
        //                 if (cnts[0] == 0 && cnts[1] == 0) continue;
        //                 for (k = 0; k < 3; k++) {
        //                     if (k > 0 && cnts[k-1] == 0) continue;
        //                     cur = (v << 2 | k);
        //                     locH = calcHappiness(cur, i*n+j+1);
        //                     next.put(cur, new int [] {(k == 1 ? cnts[0]-1 : cnts[0]), (k == 2 ? cnts[1]-1 : cnts[1]), locH});
        //                     max = Math.max(max, locH);
        //                 }
        //             }
        //             dic.clear();
        //             dic = new HashMap<>(next); 
        //             next.clear();              
        //         }
        //     }
        //     return max;
        // }        
//         public int getMaxGridHappiness(int m, int n, int introvertsCount, int extrovertsCount) {
//             return helper(m, n, 0, 0, introvertsCount, extrovertsCount, 0, new Integer[m][n][introvertsCount+1][extrovertsCount+1][243]);
//         }        
// // Ternary get ith bit value (0, 1 or 2)
//         private int get(int preN, int i) {
//             preN /= ((int) Math.pow(3, i));
//             return preN % 3;
//         }
// // Ternary set new-coming bit to value
//         private int set(int curRow, int value) {
//             return (curRow * 3 + value) % 243;
//         }
// // Ternary bit meaning -> empty: 0, intro: 1, extro: 2
//         private int helper(int m, int n, int x, int y, int inCnt, int exCnt, int preN, Integer [][][][][] dp) {
//             if (y == n) { // advance pointer
//                 y = 0;
//                 x++;
//             }
//             if (inCnt == 0 && exCnt == 0) return 0;
//             if (x == m) return 0;
//             if (dp[x][y][inCnt][exCnt][preN] != null) return dp[x][y][inCnt][exCnt][preN];
//             int res = helper(m, n, x, y+1, inCnt, exCnt, set(preN, 0), dp); // leave the cell empty
//             int up = get(preN, n-1); // get up bit -> which is at (n - 1)th
//             int left = get(preN, 0); // get left bit -> which is at (0)th
//             if (inCnt > 0) {
//                 int cur = preN;
//                 cur = set(cur, 1); // set new-coming bit to 1
//                 int addOn = 120;
//                 if (x-1 >= 0 && up != 0) { // up: 1 or 2
//                     addOn -= 30;
//                     if (up == 1) addOn -= 30;
//                     else addOn += 20;
//                 }
//                 if (y-1 >= 0 && left != 0) {
//                     addOn -= 30;
//                     if (left == 1) addOn -= 30;
//                     else addOn += 20;
//                 }
//                 res = Math.max(res, helper(m, n, x, y+1, inCnt-1, exCnt, cur, dp) + addOn);
//             }
//             if (exCnt > 0) {
//                 int cur = preN;
//                 cur = set(cur, 2); // set new-coming bit to 1
//                 int addOn = 40 ;
//                 if (x-1 >= 0 && up != 0) { // up: 1 or 2
//                     addOn += 20;
//                     if (up == 1) addOn -= 30;
//                     else addOn += 20;
//                 }
//                 if (y-1 >= 0 && left != 0) {
//                     addOn += 20;
//                     if (left == 1) addOn -= 30;
//                     else addOn += 20;
//                 }
//                 res = Math.max(res, helper(m, n, x, y+1, inCnt  , exCnt-1, cur, dp) + addOn);
//             }
//             return dp[x][y][inCnt][exCnt][preN] = res;
//         }
        // public int getMaxGridHappiness(int m, int n, int introvertsCount, int extrovertsCount) {
        //     Map<String, Integer> memo = new HashMap<>();
        //     return helper("0".repeat(n), 0, m, n, introvertsCount, extrovertsCount, memo);
        // }
        // private int helper(String state, int idx, int m, int n, int inCnt, int exCnt, Map<String, Integer> memo) {
        //     if (inCnt == 0 && exCnt == 0 || idx == m*n) return 0;
        //     String key = idx + state + inCnt + exCnt;
        //     if (memo.containsKey(key)) return memo.get(key);
        //     int i = idx / n, j = idx % n;
        //     int max = 0;
        //     if (inCnt > 0) { // case 1: place an introvert in this cell if possible.
        //         int curVal = 120;
        //         if (i > 0) curVal = calScore(state.charAt(0)-'0', 1, curVal);
        //         if (j > 0) curVal = calScore(state.charAt(state.length()-1)-'0', 1, curVal);
        //         max = Math.max(max, helper(state.substring(1)+"1", idx+1, m, n, inCnt-1, exCnt, memo) + curVal);
        //     }
        //     if (exCnt > 0) { // case 2: place an extrovert in this cell if possible.
        //         int curVal = 40;
        //         if (i > 0) curVal = calScore(state.charAt(0)-'0', 2, curVal);
        //         if (j > 0) curVal = calScore(state.charAt(state.length()-1)-'0', 2, curVal);
        //         max = Math.max(max, helper(state.substring(1)+"2", idx+1, m, n, inCnt, exCnt-1, memo) + curVal);
        //     }                // case 3: Do not place any person.
        //     max = Math.max(max, helper(state.substring(1)+"0", idx+1, m, n, inCnt, exCnt, memo)); // 不要忘记这种选择
        //     memo.put(key, max);
        //     return max;
        // }
        // private int calScore(int i, int j, int v) {
        //     if (i == 1 && j == 1) return v - 60;
        //     if (i == 2 && j == 2) return v + 40;
        //     if (i == 1 && j == 2 || i == 2 && j == 1) return v - 10;
        //     return v;
        // }

        
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // int res = s.getMaxGridHappiness(1, 2, 1, 1);
        int res = s.getMaxGridHappiness(2, 3, 1, 2);
        System.out.println("res: " + res);
    }
}