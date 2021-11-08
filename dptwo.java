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
 
        // public int lenLongestFibSubseq(int [] a) {  // bug bug bug here
        //     int n = a.length, max = 0;
        //     int [] dp = new int [n];
        //     Arrays.fill(dp, 1);
        //     for (int i = 0; i < n; i++)
        //         for (int j = i+1; j < n; j++) {
        //             int dif = a[j] - a[i], next = a[j] + dif, pre = j;
        //             int idx = Arrays.binarySearch(a, j+1, n-1, next); // 也可以自己手写binary search 
        //             while (idx != -1) {
        //                 dp[idx] = Math.max(dp[idx], (dp[j] < 3 ? 2 : dp[pre]) + 1);
        //                 max = Math.max(max, dp[idx]);
        //                 pre = idx;
        //                 next = a[idx] + dif;
        //                 idx = Arrays.binarySearch(a, idx+1, n-1, next);
        //             }
        //         }
        //     return max;
        // }

        // private long dfs(int n, int k) {
        //     if (n == 0) return 1;
        //     if (dp[n][k] != null) return dp[n][k];
        //     long ans = 0;
        //     for (Integer v : next[k]) 
        //         ans = (ans + dfs(n-1, v)) % mod;
        //     return dp[n][k] = ans;
        // }
        // int [][] next = {{4, 6}, {6, 8}, {7, 9}, // 0 1 2
        //                  {4, 8}, {0, 3, 9}, {},  // 3 4 5
        //                  {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}}; // 6 7 8 9
        // Long [][] dp;
        // int mod = (int)1e9 + 7;
        // public int knightDialer(int n) {
        //     dp = new Long [n+1][10];
        //     long ans = 0;
        //     for (int i = 0; i <= 9; i++) 
        //         ans = (ans + dfs(n-1, i)) % mod;
        //     return (int)ans;
        // }

        // public int combinationSum4(int[] a, int target) { // 如果是不同的序列会被认为是不同的，再想想
        //     int n = a.length;
        //     int [] dp = new int [target + 1];
        //     dp[0] = 1;
        //     for (Integer v : a) {
        //         System.out.println("\n v: " + v);
        //         for (int i = 0; i+v <= target; i++) {
        //             if (dp[i] > 0)
        //                 dp[i+v] += dp[i];
        //         }
        //         System.out.println(Arrays.toString(dp));
        //     }
        //     return dp[target];
        // }

        // public int maxTurbulenceSize(int[] a) {
        //     int n = a.length, bgn = 0, max = 0;
        //     if (n <= 2) return n;
        //     for (int i = 0; i < n; i++) {
        //     }
        // }

        // public int lengthOfLIS(int[] a) { // 为什么这么写感觉比下面的写法更快呢？
        //     int n = a.length, max = 1;
        //     int [] dp = new int [n];
        //     Arrays.fill(dp, 1);
        //     for (int i = 0; i < n; i++) {
        //         // if (dp[i] == 0) dp[i]= 1;
        //         for (int j = i+1; j < n; j++) // 
        //             if (a[j] > a[i]) dp[j] = Math.max(dp[j], dp[i] + 1);
        //         max = Math.max(max, dp[i]);
        //     }
        //     return max;
        // }
        // // public int lengthOfLIS(int[] a) {
        // //     int n = a.length, max = 1;
        // //     int [] dp = new int [n];
        // //     for (int i = 0; i < n; i++) {
        // //         dp[i]= 1;
        // //         for (int j = 0; j < i; j++) {
        // //             if (a[j] < a[i])
        // //                 dp[i] = Math.max(dp[i], dp[j] + 1);
        // //             max = Math.max(max, dp[i]);
        // //         }
        // //     }
        // //     return max;
        // // }

        // public int maxDistance(int[][] grid) {
        //     int n = grid.length;
        //     Queue<int []> q = new LinkedList<>();
        //     // Set<Integer> vis = new HashSet<>();
        //     for (int i = 0; i < n; i++) 
        //         for (int j = 0; j < n; j++) 
        //             if (grid[i][j] == 1) {
        //                 q.offer(new int [] {i, j});
        //                 // vis.add(i * n + j);
        //             }
        //     int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        //     int cnt = 0;
        //     while (!q.isEmpty()) {
        //         for (int size = q.size()-1; size >= 0; size--) {
        //             int [] cur = q.poll();
        //             for (int [] d : dirs) {
        //                 int i = cur[0] + d[0], j = cur[1] + d[1];
        //                 if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] != 0) continue;
        //                 // if (vis.contains(i*n+j)) continue;
        //                 q.offer(new int [] {i, j});
        //                 // vis.add(i * n + j);
        //                 grid[i][j] = -1; // mark as visited, functionally serves as vis set
        //             }
        //         }
        //         cnt++;
        //     }
        //     return cnt - 1 == 0 ? -1 : cnt - 1;
        // }

        // private boolean dfs(int [] a, int k, int target, int idx, int cnt) { // 确定是用回溯，但具体分配每个数到k个组的细节，某个地方想得不透
        //     if (cnt == 3) return true;
        //     if (idx < 0) return false;
        //     for (int i = idx; i >= 0; i--) {
        //         for (int j = 0; j < dp.size(); j++) { // 印象里这里好像还有一步什么优化，对重复数字的处理的 ？？？
        //             if (j > 0 && dp.get(j) == dp.get(j-1)) continue; // 这里一个数字具体分配到哪个组里去，关系不大，不用反复回溯
        //             if (dp.get(j) + a[i] <= target) {
        //                 dp.set(j, dp.get(j) + a[i]);
        //                 if (dfs(a, k, target, i-1, cnt + (dp.get(j) == target ? 1 : 0))) return true;
        //                 dp.set(j, dp.get(j) - a[i]);
        //             }
        //         }
        //         if (dp.size() < k) {
        //             dp.add(a[i]);
        //             if (dfs(a, k, target, i-1, cnt)) return true;
        //         }
        //     }
        //     return false;
        // }
        // List<Integer> dp = new ArrayList<>();
        // // int [] dp;
        // int n;
        // public boolean canPartitionKSubsets(int[] a, int k) {
        //     n = a.length;
        //     Arrays.sort(a);
        //     int sum = Arrays.stream(a).sum();
        //     if (sum % 4 != 0) return false;
        //     // if (sum % 4 != 0 || Arrays.stream(a).max().getAsInt() > sum / 4) return false;
        //     // dp = new int [k];
        //     return dfs(a, k, sum / 4, n-1, 0);
        // }

        // private int bfs(int [][] a, int x, int y) {
        //     Set<Integer> vis = new HashSet<>();
        //     Queue<int []> q = new LinkedList<>();
        //     q.offer(new int [] {x, y});
        //     vis.add(x * n + y);
        //     int cnt = 0;
        //     while (!q.isEmpty()) {
        //         for (int size = q.size()-1; size >= 0; size--) {
        //             int [] cur = q.poll();
        //             for (int [] d : dirs) {
        //                 int i = cur[0] + d[0], j = cur[1] + d[1];
        //                 if (i < 0 || i >= m || j < 0 || j >= n || vis.contains(i * n + j)) continue;
        //                 if (a[i][j] == 0) return cnt + 1;
        //                 q.offer(new int [] {i, j});
        //                 vis.add(i * n + j);
        //             }
        //         }
        //         cnt ++;
        //     }
        //     return -1;
        // }
        // int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // int m, n;
        // public int[][] updateMatrix(int[][] mat) {  // tle tle tle ???
        //     m = mat.length;
        //     n = mat[0].length;
        //     int [][] ans = new int [m][];
        //     for (int i = 0; i < m; i++) 
        //         ans[i] = Arrays.copyOf(mat[i], n);
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) {
        //             if (mat[i][j] == 1)
        //                 ans[i][j] = bfs(mat, i, j);
        //         }
        //     return ans;
        // }

        // public int getMaxLen(int[] a) {
        //     int n = a.length, i = 0, j = 0, max = 0, cnt = 0, bgn = -1, end = -1;
        //     while (i < n) {
        //         while (i < n && a[i] != 0) {
        //             if (a[i] < 0) {
        //                 if (bgn == -1) bgn = i;
        //                 end = i;
        //                 cnt++;
        //             }
        //             i++;
        //         }
        //         // if (i == n) return max = Math.max(max, i-j);
        //         if (cnt % 2 == 0) max = Math.max(max, i-j);
        //         else max = Math.max(max, Math.max(i-bgn-1, end-j));
        //         while (i < n && a[i] == 0) i++;
        //         j = i;
        //         bgn = -1;
        //         cnt = 0;
        //     }
        //     return max;
        // }

        // public int findNumberOfLIS(int[] a) {
        //     int n = a.length;
        //     int [][] dp = new int [n][n+1];
        //     for (int i = 0; i < n; i++) {
        //         dp[i][0] = 1;
        //         for (int j = i+1; j < n; j++) {
        //             if (a[i] < a[j]) // 这里要怎么数呢，再想想
        //         }
        //     }
        // }

        // public List<Integer> largestDivisibleSubset(int[] a) {
        //     Arrays.sort(a);
        //     // List<List<Integer>> ll = new ArrayList<>();
        //     List<Integer> ans = new ArrayList<>();
        //     List<Integer> l = new ArrayList<>();
        //     int next = 0;
        //     for (int i = 0; i < n; i++) {
        //         for (int j = i+1; j < n; j++) {
        //             if (a[j] % a[i] == 0) {
        //                 l = new ArrayList<>();
        //                 l.add(a[i]);
        //                 l.add(a[j]);
        //                 next = a[j] * ()                        
        //             }                    
        //         }
        //     }
        // }

        // // idea: 分两次遍历，先从右往右按end time遍历一次，为的是记住截止某个时间点为止，可以取得的最大分数 -- 》
        // // 再从右往左遍历一次，找当前右端最大值下与先前记住里对应最大值是否可以取得全局最大值                   cur <-- max = Math.max(max, right + max po=ss of left)
        // public int maxTwoEvents(int[][] events) { // [startTimei, endTimei, valuei]
        //     Arrays.sort(events, (a, b)->a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]); 
        // }

        
        public int maxProductPath(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            long [][] max = new long [m][n];
            long [][] min = new long [m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                }
            }
        }

        
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        // int []  a = new int []  {-1, -2, -3, 0, 1};
        int []  a = new int []  {0, 1, -2, -3, -4};

        System.out.println(Arrays.toString(a));

        int r = s.getMaxLen(a);
        System.out.println("r: " + r);
        
    }
}
        
