import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.Arrays;
import java.util.stream.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;

public class dptwo {
    public static class Solution {

        // public int longestSubsequence(int[] a, int dif) {
        //     int n = a.length, max = 0;
        //     Map<Integer, Integer> m = new HashMap<>();
        //     int [] dp = new int [n];
        //     Arrays.fill(dp, 1);
        //     for (int i = 0; i < n; i++) { // O(N)
        //         if (m.containsKey(a[i] - dif))
        //             dp[i] = 1 + m.get(a[i] - dif);
        //         m.put(a[i], dp[i]);
        //         // for (int j = i-1; j >= 0; j--) { // O(N^2)
        //         //     if (a[i] - a[j] == dif) {
        //         //         dp[i] = Math.max(dp[i], dp[j] + 1);
        //         //         break;
        //         //     }
        //         // }
        //         max = Math.max(max, dp[i]);
        //     }
        //     return max;
        // }
        // public int longestSubsequence(int[] a, int dif) {
        //     int n = a.length, max = 0;
        //     Map<Integer, Integer> m = new HashMap<>();
        //     for (Integer v : a) {
        //         int curLen = 1 + m.getOrDefault(v - dif, 0);
        //         max = Math.max(max, curLen);
        //         m.put(v, curLen);
        //     }
        //     return max;
        // }


        // private int dfs(int [] a, int idx, int j, boolean sided) {
        //     if (idx == n) return 0;
        //     if (idx < n && a[idx] == j) return Integer.MAX_VALUE / 2;
        //     if (dp[idx][j] != Integer.MAX_VALUE/ 2) return dp[idx][j];
        //     int ans = Integer.MAX_VALUE / 2;
        //     if (sided) ans = dfs(a, idx+1, j, false);
        //     else {
        //         ans = dfs(a, idx+1, j, false);
        //         for (int k = 1; k <= 3; k++) {
        //             if (a[idx] == k) continue;
        //             ans = Math.min(ans, 1 + dfs(a, idx, k, true));
        //         }
        //     }
        //     return dp[idx][j] = ans;
        // }
        // int [][] dp;
        // int n;
        // public int minSideJumps(int [] a) {
        //     n = a.length;
        //     dp = new int [n][4];
        //     for (int i = 0; i < n; i++) 
        //         Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        //     return dfs(a, 0, 2, false);
        // }
        // public int minSideJumps(int [] obs) {
        //     if (obs == null || obs.length <= 1) return 0;
        //     final int N = obs.length - 1, INF = N * 2;
        //     int[] dp = new int[]{1, 0, 1}; // 只需要dp[i-1]最后一个状态的信息，所以可以压缩空间
        //     for (int i = 1; i <= N; i++) {
        //         int ob = obs[i];
        //         if (ob != 0) dp[ob - 1] = INF;
        //         for (int j = 0; j < 3; j++) 
        //             if (ob != j + 1) 
        //                 dp[j] = Math.min(dp[j], Math.min(dp[(j+1) % 3] + 1, dp[(j+2) % 3] + 1));
        //     }
        //     return Math.min(dp[0], Math.min(dp[1], dp[2]));
        // }


        // public int lastStoneWeight(int[] a) {
        //     List<Integer> l = Arrays.stream(a).boxed().collect(Collectors.toList());
        //     Queue<Integer> q = new PriorityQueue<>((x, y)->y-x);
        //     for (Integer v : a) q.offer(v);
        //     while (q.size() > 1) {
        //         int v = q.poll() - q.poll();
        //         if (v > 0)  q.offer(v);
        //     }
        //     return q.size() > 0 ? q.poll() : 0;
        // }
        // public int lastStoneWeightII(int [] a) {
        //     int n = a.length, sum = Arrays.stream(a).sum(), half = sum / 2;
        //     int [] dp = new int [half + 1];
        //     dp[0] = 1;
        //     for (Integer v : a) {
        //         for (int i = half; i >= v; i--) 
        //             if (dp[i-v] > 0) dp[i] = dp[i-v] + 1;
        //     }
        //     int ans = sum;
        //     for (int i = half; i >= 0; i--) {
        //         if (dp[i] == 0) continue;
        //         ans = Math.min(ans, Math.abs(sum - i* 2));
        //     }
        //     return ans;
        // }

        // public int longestArithSeqLength(int[] a) { // 这里哪里可能想得不够清楚，再想想
        //     int n = a.length, max = 2;
        //     Map<Integer, Map<Integer, Integer>> dp = new HashMap<>();
        //     for (int i = 0; i < n; i++) {
        //         for (int j = i+1; j < n; j++) {
        //             int dif = a[j] - a[i];
        //             if (dp.containsKey(dif)) {
        //                 Map<Integer, Integer> tmp = dp.get(dif);
        //                 if (tmp.containsKey(a[i])) {
        //                     tmp.put(a[j], tmp.get(a[i]) + 1);
        //                     // tmp.remove(a[i]); // 为什么这里不能移掉？
        //                     max = Math.max(max, tmp.get(a[j]));
        //                 } else tmp.put(a[j], 2);
        //             } else {
        //                 Map<Integer, Integer> tmp = new HashMap<>();
        //                 tmp.put(a[j], 2);
        //                 dp.put(dif, tmp);
        //             }
        //         }
        //     }
        //     return max;
        // }
 
        public int lenLongestFibSubseq(int [] a) {  // bug here
            int n = a.length, max = 0;
            int [] dp = new int [n];
            Arrays.fill(dp, 1);
            for (int i = 0; i < n; i++)
                for (int j = i+1; j < n; j++) {
                    int dif = a[j] - a[i], next = a[j] + dif, pre = j;
                    int idx = Arrays.binarySearch(a, j+1, n-1, next); // 也可以自己手写binary search 
                    while (idx != -1) {
                        dp[idx] = Math.max(dp[idx], (dp[j] < 3 ? 2 : dp[pre]) + 1);
                        max = Math.max(max, dp[idx]);
                        pre = idx;
                        next = a[idx] + dif;
                        idx = Arrays.binarySearch(a, idx+1, n-1, next);
                    }
                }
            return max;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        int [] a = new int [] {1,2,3,4,5,6,7,8};

        int r = s.lenLongestFibSubseq(a);
        System.out.println("r: " + r);
    }
}
        
