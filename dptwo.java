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

        public int longestSubsequence(int[] a, int dif) {
            int n = a.length, max = 0;
            Map<Integer, Integer> m = new HashMap<>();
            int [] dp = new int [n];
            Arrays.fill(dp, 1);
            for (int i = 0; i < n; i++) { // O(N)
                if (m.containsKey(a[i] - dif))
                    dp[i] = 1 + m.get(a[i] - dif);
                m.put(a[i], dp[i]);
                // for (int j = i-1; j >= 0; j--) { // O(N^2)
                //     if (a[i] - a[j] == dif) {
                //         dp[i] = Math.max(dp[i], dp[j] + 1);
                //         break;
                //     }
                // }
                max = Math.max(max, dp[i]);
            }
            return max;
        }
        public int longestSubsequence(int[] a, int dif) {
            int n = a.length, max = 0;
            Map<Integer, Integer> m = new HashMap<>();
            for (Integer v : a) {
                int curLen = 1 + m.getOrDefault(v - dif, 0);
                max = Math.max(max, curLen);
                m.put(v, curLen);
            }
            return max;
        }


        private int dfs(int [] a, int idx, int j, boolean sided) {
            if (idx == n) return 0;
            if (idx < n && a[idx] == j) return Integer.MAX_VALUE / 2;
            if (dp[idx][j] != Integer.MAX_VALUE/ 2) return dp[idx][j];
            int ans = Integer.MAX_VALUE / 2;
            if (sided) ans = dfs(a, idx+1, j, false);
            else {
                ans = dfs(a, idx+1, j, false);
                for (int k = 1; k <= 3; k++) {
                    if (a[idx] == k) continue;
                    ans = Math.min(ans, 1 + dfs(a, idx, k, true));
                }
            }
            return dp[idx][j] = ans;
        }
        int [][] dp;
        int n;
        public int minSideJumps(int [] a) {
            n = a.length;
            dp = new int [n][4];
            for (int i = 0; i < n; i++) 
                Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
            return dfs(a, 0, 2, false);
        }
        public int minSideJumps(int [] obs) {
            if (obs == null || obs.length <= 1) return 0;
            final int N = obs.length - 1, INF = N * 2;
            int[] dp = new int[]{1, 0, 1}; // 只需要dp[i-1]最后一个状态的信息，所以可以压缩空间
            for (int i = 1; i <= N; i++) {
                int ob = obs[i];
                if (ob != 0) dp[ob - 1] = INF;
                for (int j = 0; j < 3; j++) 
                    if (ob != j + 1) 
                        dp[j] = Math.min(dp[j], Math.min(dp[(j+1) % 3] + 1, dp[(j+2) % 3] + 1));
            }
            return Math.min(dp[0], Math.min(dp[1], dp[2]));
        }


        public int lastStoneWeight(int[] a) {
            List<Integer> l = Arrays.stream(a).boxed().collect(Collectors.toList());
            Queue<Integer> q = new PriorityQueue<>((x, y)->y-x);
            for (Integer v : a) q.offer(v);
            while (q.size() > 1) {
                int v = q.poll() - q.poll();
                if (v > 0)  q.offer(v);
            }
            return q.size() > 0 ? q.poll() : 0;
        }
        public int lastStoneWeightII(int [] a) {
            int n = a.length, sum = Arrays.stream(a).sum(), half = sum / 2;
            int [] dp = new int [half + 1];
            dp[0] = 1;
            for (Integer v : a) {
                for (int i = half; i >= v; i--) 
                    if (dp[i-v] > 0) dp[i] = dp[i-v] + 1;
            }
            int ans = sum;
            for (int i = half; i >= 0; i--) {
                if (dp[i] == 0) continue;
                ans = Math.min(ans, Math.abs(sum - i* 2));
            }
            return ans;
        }

        public int lenLongestFibSubseq(int [] a) {  // bug bug bug here
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

        private long dfs(int n, int k) {
            if (n == 0) return 1;
            if (dp[n][k] != null) return dp[n][k];
            long ans = 0;
            for (Integer v : next[k]) 
                ans = (ans + dfs(n-1, v)) % mod;
            return dp[n][k] = ans;
        }
        int [][] next = {{4, 6}, {6, 8}, {7, 9}, // 0 1 2
                         {4, 8}, {0, 3, 9}, {},  // 3 4 5
                         {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}}; // 6 7 8 9
        Long [][] dp;
        int mod = (int)1e9 + 7;
        public int knightDialer(int n) {
            dp = new Long [n+1][10];
            long ans = 0;
            for (int i = 0; i <= 9; i++) 
                ans = (ans + dfs(n-1, i)) % mod;
            return (int)ans;
        }

        public int combinationSum4(int[] a, int target) { // 如果是不同的序列会被认为是不同的，再想想
            int n = a.length;
            int [] dp = new int [target + 1];
            dp[0] = 1;
            for (Integer v : a) {
                System.out.println("\n v: " + v);
                for (int i = 0; i+v <= target; i++) {
                    if (dp[i] > 0)
                        dp[i+v] += dp[i];
                }
                System.out.println(Arrays.toString(dp));
            }
            return dp[target];
        }

        public int maxTurbulenceSize(int[] a) {
            int n = a.length, bgn = 0, max = 0;
            if (n <= 2) return n;
            for (int i = 0; i < n; i++) {
            }
        }

        public int lengthOfLIS(int[] a) { // 为什么这么写感觉比下面的写法更快呢？
            int n = a.length, max = 1;
            int [] dp = new int [n];
            Arrays.fill(dp, 1);
            for (int i = 0; i < n; i++) {
                // if (dp[i] == 0) dp[i]= 1;
                for (int j = i+1; j < n; j++) // 
                    if (a[j] > a[i]) dp[j] = Math.max(dp[j], dp[i] + 1);
                max = Math.max(max, dp[i]);
            }
            return max;
        }
        // public int lengthOfLIS(int[] a) {
        //     int n = a.length, max = 1;
        //     int [] dp = new int [n];
        //     for (int i = 0; i < n; i++) {
        //         dp[i]= 1;
        //         for (int j = 0; j < i; j++) {
        //             if (a[j] < a[i])
        //                 dp[i] = Math.max(dp[i], dp[j] + 1);
        //             max = Math.max(max, dp[i]);
        //         }
        //     }
        //     return max;
        // }

        public int maxDistance(int[][] grid) {
            int n = grid.length;
            Queue<int []> q = new LinkedList<>();
            // Set<Integer> vis = new HashSet<>();
            for (int i = 0; i < n; i++) 
                for (int j = 0; j < n; j++) 
                    if (grid[i][j] == 1) {
                        q.offer(new int [] {i, j});
                        // vis.add(i * n + j);
                    }
            int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            int cnt = 0;
            while (!q.isEmpty()) {
                for (int size = q.size()-1; size >= 0; size--) {
                    int [] cur = q.poll();
                    for (int [] d : dirs) {
                        int i = cur[0] + d[0], j = cur[1] + d[1];
                        if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] != 0) continue;
                        // if (vis.contains(i*n+j)) continue;
                        q.offer(new int [] {i, j});
                        // vis.add(i * n + j);
                        grid[i][j] = -1; // mark as visited, functionally serves as vis set
                    }
                }
                cnt++;
            }
            return cnt - 1 == 0 ? -1 : cnt - 1;
        }

        private boolean dfs(int [] a, int k, int target, int idx, int cnt) { // 确定是用回溯，但具体分配每个数到k个组的细节，某个地方想得不透
            if (cnt == 3) return true;
            if (idx < 0) return false;
            for (int i = idx; i >= 0; i--) {
                for (int j = 0; j < dp.size(); j++) { // 印象里这里好像还有一步什么优化，对重复数字的处理的 ？？？
                    if (j > 0 && dp.get(j) == dp.get(j-1)) continue; // 这里一个数字具体分配到哪个组里去，关系不大，不用反复回溯
                    if (dp.get(j) + a[i] <= target) {
                        dp.set(j, dp.get(j) + a[i]);
                        if (dfs(a, k, target, i-1, cnt + (dp.get(j) == target ? 1 : 0))) return true;
                        dp.set(j, dp.get(j) - a[i]);
                    }
                }
                if (dp.size() < k) {
                    dp.add(a[i]);
                    if (dfs(a, k, target, i-1, cnt)) return true;
                }
            }
            return false;
        }
        List<Integer> dp = new ArrayList<>();
        // int [] dp;
        int n;
        public boolean canPartitionKSubsets(int[] a, int k) {
            n = a.length;
            Arrays.sort(a);
            int sum = Arrays.stream(a).sum();
            if (sum % 4 != 0) return false;
            // if (sum % 4 != 0 || Arrays.stream(a).max().getAsInt() > sum / 4) return false;
            // dp = new int [k];
            return dfs(a, k, sum / 4, n-1, 0);
        }

        public int getMaxLen(int[] a) {
            int n = a.length, i = 0, j = 0, max = 0, cnt = 0, bgn = -1, end = -1;
            while (i < n) {
                while (i < n && a[i] != 0) {
                    if (a[i] < 0) {
                        if (bgn == -1) bgn = i;
                        end = i;
                        cnt++;
                    }
                    i++;
                }
                // if (i == n) return max = Math.max(max, i-j);
                if (cnt % 2 == 0) max = Math.max(max, i-j);
                else max = Math.max(max, Math.max(i-bgn-1, end-j));
                while (i < n && a[i] == 0) i++;
                j = i;
                bgn = -1;
                cnt = 0;
            }
            return max;
        }

        public int findNumberOfLIS(int[] a) {
            int n = a.length;
            int [][] dp = new int [n][n+1];
            for (int i = 0; i < n; i++) {
                dp[i][0] = 1;
                for (int j = i+1; j < n; j++) {
                    if (a[i] < a[j]) // 这里要怎么数呢，再想想
                }
            }
        }

        public List<Integer> largestDivisibleSubset(int[] a) {
            Arrays.sort(a);
            // List<List<Integer>> ll = new ArrayList<>();
            List<Integer> ans = new ArrayList<>();
            List<Integer> l = new ArrayList<>();
            int next = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    if (a[j] % a[i] == 0) {
                        l = new ArrayList<>();
                        l.add(a[i]);
                        l.add(a[j]);
                        next = a[j] * ()                        
                    }                    
                }
            }
        }

        public long maxPoints(int[][] p) { // tle tle tle O(N^3)
            int m = p.length, n = p[0].length;
            long [][] dp = new long [m][n];
            for (int j = 0; j < n; j++) 
                dp[0][j] = p[0][j];
            for (int i = 1; i < m; i++) 
                for (int j = 0; j < n; j++) // 这个步骤O(N^2)可以优化为O(N)
                    for (int k = 0; k < n; k++) {
                        dp[i][j] = Math.max(dp[i][j], p[i][j] + dp[i-1][k] - Math.abs(k-j));
                    }
            long max = 0;
            for (int j = 0; j < n; j++) 
                max = Math.max(max, dp[m-1][j]);
            return max;
        }
        public long maxPoints(int[][] p) { // O(N^2) time, O(4*N) space
            int m = p.length, n = p[0].length;
            // long [][] dp = new long [m][n];
            long [] dp = new long [n];
            for (int j = 0; j < n; j++) 
                // dp[0][j] = p[0][j];
                dp[j] = p[0][j];
            for (int i = 1; i < m; i++) {
                long [] pre = dp.clone();
                long [] left = new long [n], right = new long [n];
                left[0] = pre[0];
                right[n-1] = pre[n-1];
                for (int j = 1; j < n; j++) left[j] = Math.max(pre[j], left[j-1]-1);
                for (int j = n-2; j >= 0; j--) right[j] = Math.max(pre[j+1]-1, right[j+1] - 1);
                for (int j = 0; j < n; j++)
                    dp[j] = Math.max(left[j], right[j]) + p[i][j];
                    // for (int k = 0; k < n; k++) { // 这一步的目的是求上一行的综合代价后的最大值
                        // dp[i][j] = Math.max(dp[i][j], p[i][j] + dp[i-1][k] - Math.abs(k-j));
                    // }
            }
            long max = 0;
            for (int j = 0; j < n; j++) 
                max = Math.max(max, dp[j]);
            return max;
        }
        public long maxPoints(int[][] p) { // O(N^2) O(N) space
            int m = p.length, n = p[0].length;
            long [] dp = new long [n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) dp[j] += p[i][j];
                for (int j = 1; j < n; j++)
                    dp[j] = Math.max(dp[j], dp[j-1]-1);
                for (int j = n-2; j >= 0; j--)
                    dp[j] = Math.max(dp[j], dp[j+1] - 1);
            }
            return Arrays.stream(dp).max().getAsLong();
        }

        idea: 分两次遍历，先从右往右按end time遍历一次，为的是记住截止某个时间点为止，可以取得的最大分数 -- 》
        再从右往左遍历一次，找当前右端最大值下与先前记住里对应最大值是否可以取得全局最大值                   cur <-- max = Math.max(max, right + max po=ss of left)
        public int maxTwoEvents(int[][] events) { // [startTimei, endTimei, valuei]
            Arrays.sort(events, (a, b)->a[1] - b[1]);
            TreeMap<Integer, Integer> leftMax = new TreeMap<>();
            int max = 0; // left max value
            for (int [] e : events) {
                max = Math.max(max, e[2]);
                leftMax.put(e[1], max);
            }
            int ans = max; // 有可能取单个事件的最大值
            max = 0; // right max value
            Arrays.sort(events, (a, b)->b[0] - a[0]);
            for (int [] e : events) {
                max = Math.max(max, e[2]);
                Integer maxLeft = leftMax.floorKey(e[0]-1);
                if (maxLeft != null)
                    ans = Math.max(ans, leftMax.get(maxLeft) + max);
            }
            return ans;
        }
        public int maxTwoEvents(int[][] events) {
            Arrays.sort(events, (a, b) -> a[1] - b[1]);
            TreeMap<Integer, Integer> map = new TreeMap<>(){{put(0, 0);}}; // 效率不是很高，但这种简洁的写法可以学习一下
            int maxP = 0;
            for(int[] event : events) {
                maxP = Math.max(maxP, event[2] + map.lowerEntry(event[0]).getValue());
                int hi = Math.max(event[2], map.lastEntry().getValue());
                map.put(event[1], hi);
            }
            return maxP;
        }
        public int maxTwoEvents(int[][] events) { // todo: 这个扫描线要好好再学一下，感觉这两种写法有点儿剑走偏锋的偏
            List<int[]> list = new ArrayList<>();
            for(int i = 0; i < events.length; ++i) {
                int[] arrStart = new int[]{events[i][0], 1, events[i][2]};           //  {startTime, 1, value}
                int[] arrEnd = new int[]{events[i][1] + 1, 0, events[i][2]};         //  {endTime + 1, 0, value}  (+1 for exclusive)
                list.add(arrStart);
                list.add(arrEnd);
            }
            Collections.sort(list, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);   //sort by timstamp. if same, put startTime before endTime..
            int maxSoFar = 0, maxRes = 0;
            for(int j = 0; j < list.size(); ++j) {
                if(list.get(j)[1] == 1) // startTime
                    maxRes = Math.max(maxRes, maxSoFar + list.get(j)[2]);
                else      // endTime
                    maxSoFar = Math.max(maxSoFar, list.get(j)[2]);
            }
            return maxRes;
        }
        public int maxTwoEvents(int[][] events) {
            int n = events.length, max = 0, ans = 0;
            Arrays.sort(events, (a, b)-> a[0] != b[0] ? a[0] - b[0] : a[1]-b[1]);
            Queue<int []> q = new PriorityQueue<>((a, b)->a[0] - b[0]);
            for (int [] e : events) {
                while (!q.isEmpty()) {
                    if (q.peek()[0] >= e[0]) break;
                    int [] cur = q.poll();
                    max = Math.max(max, cur[1]);
                }
                ans = Math.max(ans, max + e[2]);
                q.offer(new int [] {e[1], e[2]});
            }
            return ans;
        }
        public int maxTwoEvents(int[][] events) {
            int result = 0, max = 0;
            Arrays.sort(events, (x,y)->x[0]-y[0]);   // Sort by Start time
            PriorityQueue<int[]> q = new PriorityQueue<>((x,y)->x[1]-y[1]); // sorted by end time
            for(int[] e : events) {
                while(!q.isEmpty() && q.peek()[1] < e[0])
                    max = Math.max(max, q.poll()[2]);
                result = Math.max(result, max + e[2]);
                q.offer(e);
            }
            return result;
        }

        public int minSumOfLengths(int[] a, int target) {
            int n = a.length, j = 0, min = Integer.MAX_VALUE;
            int [] l = new int [n], r = new int [n], sum = Arrays.copyOf(a, n);
            for (int i = 1; i < n; i++) sum[i] += sum[i-1];
            Map<Integer, Integer> m = new HashMap<>();
            m.put(0, -1);
            for (int i = 0; i < n; i++) {
                if (m.containsKey(sum[i] - target))
                    min = Math.min(min, i - m.get(sum[i] - target));
                m.put(sum[i], i);
                l[i] = min;
            }
            min = Integer.MAX_VALUE;
            m.clear();
            for (int i = n-1; i >= 0; i--) {
                if (m.containsKey(sum[i]+target))
                    min = Math.min(min, m.get(sum[i] + target) - i);
                m.put(sum[i], i);
                r[i] = min;
            }
            min = Integer.MAX_VALUE;
            for (int i = 1; i < n-1; i++) 
                if (l[i] != Integer.MAX_VALUE && r[i] != Integer.MAX_VALUE) min = Math.min(min, l[i] + r[i]);
            return min == Integer.MAX_VALUE ? -1 : min;
        }
        public int minSumOfLengths(int[] arr, int target) { // 双指针： 代码相对简洁
            int n = arr.length,res = Integer.MAX_VALUE;
            int[] dp = new int[n+1];
            Arrays.fill(dp, n);
            int i = -1,j = -1,sum = 0;
            while (j < n){
                if (j < n-1 && sum < target) sum += arr[++j];      // 右指针向右移动
                else if (i < n-1 && sum > target) sum -= arr[++i]; // 左指针向右移动
                else if (sum == target){
                    if (dp[i+1] < n)
                        res = Math.min(res,dp[i+1]+j-i);
                    dp[j+1] = j-i; 
                    sum -= arr[++i];
                }
                else break;
                dp[j+1] = Math.min(dp[j],dp[j+1]);
            }
            return res == Integer.MAX_VALUE?-1:res;
        }

        private long [] dfs(int [][] a, int x, int y) { // bug bug bug
            if (x < 0 || y < 0) return new long []{1, -1};
            if (x == 0 && y == 0) return new long [] {a[x][y] > 0 ? a[x][y] : -1, a[x][y] < 0 ? a[x][y] : 1};
            if (dp.containsKey(x * n + y)) return dp.get(x*n+y);
            long max = Long.MIN_VALUE, min = Long.MAX_VALUE;
            long [] v = dfs(a, x-1, y);
            max = Math.max(max, Math.max(v[0] * a[x][y], v[1] * a[x][y]));
            min = Math.min(min, Math.min(v[0] * a[x][y], v[1] * a[x][y]));
            v =  dfs(a, x, y-1);
            max = Math.max(max, Math.max(v[0] * a[x][y], v[1] * a[x][y]));
            min = Math.min(min, Math.min(v[0] * a[x][y], v[1] * a[x][y]));
            dp.put(x*n+y, new long [] {max, min});
            return dp.get(x*n+y);
        }
        Map<Integer, long []> dp = new HashMap<>(); // [0, 1]: max, min
        int mod = (int)1e9 + 7;
        int m, n;
        public int maxProductPath(int[][] grid) {
            if (grid[0][0] == 0) return 0;
            m = grid.length;
            n = grid[0].length;
            long [] v = dfs(grid, m-1, n-1);
            System.out.println(Arrays.toString(v));
            return (int)(v[0] % mod);
        }
        public int maxProductPath(int[][] grid) { // 还是不怎么会写dp
            int m = grid.length;
            int n = grid[0].length;
            long [][][] dp = new long [m][n][2];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j] = min[i][j] = (j == 0 ? grid[i][j] : dp[i][j-1] * grid[i][j]);
                    if (i == 0) continue;
                }
            }
        }

        private int dfs(int [] a, int [] b, int i, int k) { 
            if (k == m) return 0;
            if (dp[i][k] != Integer.MIN_VALUE) return dp[i][k];
            return dp[i][k] = Math.max(a[i] * b[k] + dfs(a, b, i+1, k+1), a[n-(k-i)-1] * b[k] + dfs(a, b, i, k+1));
        }
        int [][] dp;
        int m, n;
        public int maximumScore(int[] a, int[] b) {
            n = a.length;
            m = b.length;
            dp = new int [m][m]; // 从三维降至二维：这里第一维可以再压缩得小一点儿，从n 降至m
            for (int i = 0; i < m; i++) 
                Arrays.fill(dp[i], Integer.MIN_VALUE);
            return dfs(a, b, 0, 0);
        }
        public int maximumScore(int[] a, int[] b) { // todo: dp reduce dimension
            int n = a.length;
            int m = b.length;
            int [][] dp = new int [m+1][m+1]; // 代表从前面、后面各取i 和j 个数 // 假设dp[][]代表在nums取前i个和后j个和multi所能得到最大分数
            for (int i = 1; i < m+1; i++)     // 初始化basecase
                dp[i][0] = dp[i-1][0] + a[i-1] * b[i-1];
            for (int j = 1; j < m+1; j++) 
                dp[0][j] = dp[0][j-1] + a[n-j] * b[j-1];
            for (int i = 1; i < m+1; i++) 
                for (int j = 1; j < m+1; j++) {
                    if (i + j > m) continue;
                    dp[i][j] = Math.max(dp[i][j-1] + a[n-j] * b[i+j-1], dp[i-1][j] + a[i-1]*b[i+j-1]);
                }
            int ans = Integer.MIN_VALUE;
            for (int i = 0; i < m+1; i++) 
                ans = Math.max(ans, dp[i][m-i]);
            return ans;
        }

        public int maxScoreWords(String[] words, char[] letters, int[] score) {
            int [] cur = new int [26];
            int [] cnt = new int [26];
            for (char c : letters) cnt[c-'a']++;
            int n = words.length, range = (1 << n), max = 0, curScore = 0;
            boolean valid = true;
            for (int i = 1; i < range; i++) {
                Arrays.fill(cur, 0);
                curScore = 0;
                valid = true;
                for (int j = 0; j < n; j++) 
                    if (((i >> j) & 1) == 1) 
                        for (char c : words[j].toCharArray()) {
                            ++cur[c-'a'];
                            if (cur[c-'a'] > cnt[c-'a']) {
                                valid = false;
                                break;
                            }
                            curScore += score[c-'a'];
                        }
                if (valid) max = Math.max(max, curScore);
            }
            return max;
        }

        private int dfs(int [][] a, int i, int j, int k) {
        }
        int [][][] dp;
        int m, n;
        public int cherryPickup(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int [][][] dp = new int [m][n][n];
            dp[0][0][n-1] = grid[0][0] + grid[0][n-1];
            for (int i = 1; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (j == k) continue;
                    }
                }
            }
        }

        public class MinSeg { // 算法对于n不是2的次方的情况同样适用。这也是为什么我在上文中说线段树是一棵完全二叉树而非满二叉树的原因
            private ArrayList<Integer> minSeg;
            private int n;
            public MinSeg(int[] arr) {
                n = arr.length;
                minSeg = new ArrayList<>(2 * n);
                for (int i = 0; i < n; i++) minSeg.add(0); // 父节点， 占位
                for (int i = 0; i < n; i++) minSeg.add(arr[i]);
                for (int i = n - 1; i > 0; i--) // 对于每一个父节点，根据子节点更新更最值
                    minSeg.set(i, Math.min(minSeg.get(2 * i), minSeg.get(2 * i + 1)));
            }
            public void update(int i, int value) { // O(logN)
                i += n; // down to leaf nodes
                minSeg.set(i,  value); 
                while (i > 1) { // udpate parent nodes bottome up level by level
                    i /= 2;     // 从这一元素对应的叶子结点开始，沿二叉树的路径向上更新至根结点
                    minSeg.set(i, Math.min(minSeg.get(2 * i), minSeg.get(2 * i + 1)));
                }
            }
            // 区间查询大体上可以分为3种情况讨论：
            // 1. 当前结点所代表的区间完全位于给定需要被查询的区间之外，则不应考虑当前结点
            // 2. 当前结点所代表的区间完全位于给定需要被查询的区间之内，则可以直接查看当前结点的母结点
            // 3. 当前结点所代表的区间部分位于需要被查询的区间之内，部分位于其外，则我们先考虑位于区间外的部分，后考虑区间内的（注意总有可能找到完全位于区间内的结点，因为叶子结点的区间长度为1，因此我们总能组合出合适的区间）
            public int getMin(int left, int right) { // Get the minimum of range [left, right)
                left += n;
                right += n;
                int min = Integer.MAX_VALUE;
                while (left < right) {     // 这两个分支怎么反而想不明白了？
                    if ((left & 1) == 1) { // left is out of range of parent interval, check value of left node first, then shift it right in the same level
                        min = Math.min(min, minSeg.get(left));
                        left++;
                    }
                    if ((right & 1) == 1) { // right is out of range of current interval, shift it left in the same level and then check the value
                        right--;
                        min = Math.min(min,  minSeg.get(right));
                    }
                    left >>= 1;  // move left and right one level up
                    right >>= 1;
                }
                return min;
            }
        }
        public int minNumberOperations(int[] a) {
            int n = a.length, min = 0, minVal = 0;
            MinSeg minSeg = new MinSeg(a);
            minVal = minSeg.getMin(0, n);
            min += minVal;
        }

        public int minFallingPathSum(int[][] a) {
            int m = a.length, n = a[0].length;
            int [][] dp = new int [m][n];
            for (int i = 0; i < m; i++) 
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            System.arraycopy(a[0], 0, dp[0], 0, n);
            for (int i = 1; i < m; i++) 
                for (int j = 0; j < n; j++) 
                    for (int k = 0; k < n; k++) {
                        if (k == j) continue;
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + a[i][j]);
                    }
            int max = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) 
                max = Math.min(max, dp[m-1][j]);
            return max;
        }

        private int getMax(int [] a, int i, int j) {
            int max = 0;
            for (int k = i; k <= j; k++) 
                max = Math.max(max, a[k]);
            return max;
        }
        private int dfs(int [] a, int idx, int k) {
            if (idx == n || k <= 0) return 0;
            if (dp[idx][k] > 0) return dp[idx][k];
            if (k == 1) return dp[idx][k] = getMax(a, idx, n-1);
            if (idx == n-k) return dp[idx][k] = sum[n-1] - (idx == 0 ? 0 : sum[idx-1]);
            int ans = Integer.MAX_VALUE;
            for (int i = idx; i < n-(k-1); i++) 
                ans = Math.min(ans, getMax(a, idx, i) + dfs(a, i+1, k-1));
            return dp[idx][k] = ans;
        }
        int [][] dp;
        int [] sum;
        int n;
        public int minDifficulty(int[] jobDifficulty, int d) {
            n = jobDifficulty.length;
            dp = new int [n][d+1];
            sum = Arrays.copyOf(jobDifficulty, n);
            for (int i = 1; i < n; i++) 
                sum[i] += sum[i-1];
            int ans = dfs(jobDifficulty, 0, d);
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }        
        public int minDifficulty(int[] jobDifficulty, int d) { // todo: reduce dimension
            int n = jobDifficulty.length;
            if (n < d) return -1;
            if (n == d) return Arrays.stream(jobDifficulty).sum();
            int [][] dp = new int [d+1][n];
            for (int i = 0; i < d+1; i++) // 初始化为正无穷
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            for (int i = n-1, curMax = 0; i >= 0; i--) { // 求一下dp[1][i]
                curMax = Math.max(curMax, jobDifficulty[i]);
                dp[1][i] = curMax;
            }
            for (int i = 2; i <= d; i++) 
                for (int j = 0; j <= n-i; j++) {
                    int curMax = 0;
                    for (int k = j; k <= n-i; k++) {
                        curMax = Math.max(curMax, jobDifficulty[k]);
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][k+1] + curMax); // 跟写dfs方向是反着来的
                    }
                }
            return dp[d][0];
        }

        public int numOfWays(int n) { // 1st to try dp this way, feeling good !
            int mod = (int)1e9 + 7;
            Set<Integer> sur = new HashSet<>();
            for (int i = 0; i < 3; i++) 
                for (int j = 0; j < 3; j++) {
                    if (j == i) continue;
                    for (int k = 0; k < 3; k++) {
                        if (k == j) continue;
                        sur.add(((((1 << i) << 3) | (1 << j)) << 3) | (1 << k));
                    }
                }
            long [][] dp = new long [n][277];
            for (Integer v : sur) dp[0][v] = 1;
            for (int i = 1; i < n; i++) 
                for (int j = 0; j < 277; j++) {
                    if (dp[i-1][j] == 0) continue;
                    for (Integer v : sur) 
                        if ((v & j) == 0) 
                            dp[i][v] = (dp[i][v] + dp[i-1][j]) % mod;
                }
            long ans = 0;
            for (int i = 0; i < 277; i++)
                if (dp[n-1][i] > 0)
                    ans = (ans + dp[n-1][i]) % mod;
            return (int)ans;
        }

        private void generateAllSur(int pre, int cur, int val, int k, Set<Integer> sur) {
            if (k == 0) {
                sur.add(val);
                return;
            }
            for (int i = 0; i < 3; i++) {
                if (cur == i) continue;
                generateAllSur(cur, i, (val << 3) | (1 << i), k-1, sur);
            }
        }
        public int colorTheGrid(int m, int n) { // m < n
            long mod = (int)1e9 + 7;
            Set<Integer> sur = new HashSet<>();
            for (int i = 0; i < 3; i++) 
                generateAllSur(-1, i, (1 << i), m-1, sur);
            long [][] dp = new long [n][17685];
            for (Integer v : sur) dp[0][v] = 1;
            for (int i = 1; i < n; i++) 
                for (int j = 0; j < 17685; j++) {
                    if (dp[i-1][j] == 0) continue;
                    for (Integer v : sur) 
                        if ((v & j) == 0)
                            dp[i][v] = (dp[i][v] + dp[i-1][j]) % mod;
                }
            long ans = 0;
            for (int i = 0; i < 17685; i++)
                if (dp[n-1][i] > 0)
                    ans = (ans + dp[n-1][i]) % mod;
            return (int)ans;
        }
        // For m = 5, there are at most 48 valid states for a single column so we can handle it column by column.
        //     We encode the color arrangement by bit mask (3 bit for a position) and use dfs to generate the all valid states.
        //     Then for each column, we iterator all the states and check if it's still valid with the previous column.
        private void dfs(Map<Integer, Long> state, int j, int m, int pre, int cur) {
            if (j == m) {
                state.put(cur, state.getOrDefault(cur, 0L) + 1);
                return ;
            }
            for (int i = 0; i < 3; i++) {
                if (i == pre) continue;
                dfs(state, j+1, m, i, (cur << 3) | (1 << i));
            }
        }
        static int mod = (int) 1e9 + 7;
        public int colorTheGrid(int m, int n) {
            Map<Integer, Long> state = new HashMap();
            dfs(state, 0, m, -1, 0); // 生成所有可能的有效状态，只不过是放在表里
            Set<Integer> set = new HashSet<>(state.keySet()); // valid states
            for (int i = 1; i < n; i++) {
                Map<Integer, Long> dp = new HashMap();
                for (Integer a : set) 
                    for (Integer b : set) 
                        if ((a & b) == 0)
                            dp.put(a, dp.getOrDefault(a, 0l) + state.get(b) % mod);
                state = dp; // 滚动map
            }
            long ans = 0;
            for (Long v : state.values())
                ans = (ans + v) % mod;
            return (int)ans;
        }

        public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
            int t = minutesToTest / minutesToDie + 1;
            int cnt = 0;
            while (Math.pow(t, cnt) < buckets) cnt++;
            return cnt;
        }

        public String shortestCommonSupersequence(String ss, String tt) {
            int m = ss.length(), n = tt.length();
            char [] s = ss.toCharArray();
            char [] t = tt.toCharArray();
            int [][] dp = new int [m+1][n+1];
            for (int i = 1; i <= m; i++) 
                for (int j = 1; j <= n; j++) 
                    if (s[i-1] == t[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
                    else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            // System.out.println("dp.length: " + dp.length);
            // for (int z = 0; z < dp.length; ++z) 
            //     System.out.println(Arrays.toString(dp[z]));
            int i = m-1, j = n-1;
            StringBuilder sb = new StringBuilder(); // reversed Longest Common Subsequence
            while (i >= 0 && j >= 0) {
                if (dp[i+1][j+1] == dp[i][j] + 1) {
                    sb.append(s[i]);
                    --i;
                    --j;
                } else if (dp[i+1][j+1] == dp[i][j+1]) {
                    --i;
                } else --j;
            }
            // System.out.println("sb.toString(): " + sb.toString());
            // merge 3 strings
            return "";
        }

        private int dfs(int [] a, int i, int j) {
            if (i == j) return a[i]; // when i == j -1
            if (dp[i][j] > 0) return dp[i][j];
            int ans = 0; // when i == j -1, default to be 0
            for (int k = i+1; k < j; k++)                 
                ans = Math.max(ans, dfs(a, i, k) + dfs(a, k, j) + a[i]*a[k]*a[j]);
            return dp[i][j] = ans;
        }
        int [][] dp;
        int N;
        public int maxCoins(int[] a) {
            int n = a.length, N = n + 2;
            int [] arr = new int [n+2];
            Arrays.fill(arr, 1);
            System.arraycopy(a, 0, arr, 1, n);
            dp = new int [N][N];
            return dfs(arr, 0, n+1);
        }

        private int dfs(int [] a, int i, int j) { 
            if (i >= j-1) return 0; // 感觉写终止条件，有那么点稀里糊涂
            if (dp[i][j] > 0) return dp[i][j];
            int ans = Integer.MAX_VALUE / 2;
            for (int k = i+1; k < j; k++) {
                ans = Math.min(ans, a[j]-a[i] + dfs(a, i, k) + dfs(a, k, j));
            }
            return dp[i][j] = ans;
        }
        int [][] dp;
        public int minCost(int n, int[] cuts) {
            int m = cuts.length;
            int [] arr = new int [m+2];
            System.arraycopy(cuts, 0, arr, 1, cuts.length);
            arr[m+1] = n;
            Arrays.sort(arr);
            dp = new int [m+2][m+2];
            System.out.println(Arrays.toString(arr));
            return dfs(arr, 0, m+1);
        }

        private void dfs(int [] a, int idx, List<Integer> l) { // tle tle tle
            if (l.size() == n) {
                if (!ll.contains(l)) ll.add(new ArrayList<>(l));
                return ;
            }
            for (int i = 0; i < n; i++) {
                if (!vis[i]) {
                    vis[i] = true;
                    l.add(a[i]);
                    dfs(a, i+1, l);
                    l.remove(l.size()-1);
                    vis[i] = false;
                }
            }
        }
        private boolean isSquare(int v) {
            return Math.pow((int)Math.sqrt(v), 2) == v;
        }
        private boolean isValid(List<Integer> l) {
            for (int i = 0; i <= l.size()-2; i++) 
                if (!isSquare(l.get(i) + l.get(i+1))) return false;
            return true;
        }
        List<List<Integer>> ll = new ArrayList<>();
        boolean [] vis;
        int n;
        public int numSquarefulPerms(int[] a) {
            n = a.length;
            if (Arrays.stream(a).distinct().count() == 1) {
                for (int i = 0; i < n-1; i++) 
                    if (!isSquare(a[i] + a[i+1])) return 0;
                return 1;
            }
            int [] arr = new int [n];
            for (int i = 0; i < n; i++) 
                arr[i] = i;
            vis = new boolean[n];
            dfs(a, 0, new ArrayList<>());
            int ans = 0;
            for (List<Integer>  l : ll) 
                if (isValid(l)) ans++;
            return ans;
        }

        private int dfs(int [] a, int i, int k) {
            if (i == n || k == 0 ) return 0;
            if (dp[i][k] != null) return dp[i][k];
            if (k == 1) return dp[i][k] = sum[n-1] - (i == 0 ? 0 : sum[i-1]);
            if (i == n-k) {
                int max = 0;
                for (int j = i; j <= n-1; j++) 
                    max = Math.max(max, a[j]);
                return dp[i][k] = max;
            }
            int ans = Integer.MAX_VALUE;
            for (int j = i; j < n-(k-1); j++) 
                ans = Math.min(ans, Math.max(sum[j] - (i == 0 ? 0 : sum[i-1]), dfs(a, j+1, k-1)));
            return dp[i][k] = ans;
        }
        Integer [][] dp;
        int [] sum;
        int n;
        public int splitArray(int[] a, int m) {
            n = a.length;
            dp = new Integer [n][m+1];
            sum = Arrays.copyOf(a, n);
            for (int i = 1; i < n; i++) sum[i] += sum[i-1];
            return dfs(a, 0, m);
        }

        private int cntUnique(String s) {
            int [] cnt = new int [26];
            for (char c : s.toCharArray())
                cnt[c-'A']++;
            int ans = 0;
            for (Integer v : cnt) 
                if (v == 1) ans++;
            return ans;
        }
        public int uniqueLetterString(String s) { // tle tle tle
            int n = s.length(), ans = 0;
            for (int i = 0; i < n; i++) 
                for (int j = i+1; j <= n; j++) 
                    ans += cntUnique(s.substring(i, j));
            return ans;
        }

        private int dfs(int [] a, int i, int j, int k) {
            if (i > j || k == 0) return 0;
            if (dp[i][j][k] > 0) return dp[i][j][k];
            if (k == 1) {
                int max = 0;
                for (int x = i; x <= j; x++) 
                    max = Math.max(max, a[x]);
                return dp[i][j][k] = max;
            }
            return dp[i][j][k] = Math.max(a[i] + dfs(a, i+2, j, k-1), dfs(a, i+1, j, k));
        }
        int [][][] dp;
        int n;
        public int maxSizeSlices(int[] a) {
            n = a.length;
            dp = new int [n][n][n/3+1];
            int max = dfs(a, 0, n-2, n/3);
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) 
                Arrays.fill(dp[i][j], 0);
            return Math.max(max, dfs(a, 1, n-1, n/3));
        }

        private void dfs(int [] a, int k, int idx) { // todo: 这类题需要总结一下，外加其它高效方法汇总
            if (Arrays.stream(dp).max().getAsInt() >= min) return; // 这里可以豪爽地把 == min的全扔了
            if (idx < 0) {
                int tmp = Arrays.stream(dp).sum();
                if (tmp != sum) return ;
                int cur = Arrays.stream(dp).max().getAsInt();
                // if (cur < min)
                    min = cur; // 这里也就可以用再比较，直接取结果
                return ;
            }
            // for (int i = idx; i >= 0; i--) { // 为什么会画蛇添足地多加个没用的loop呢？？？！！！
                for (int j = 0; j < k; j++) {
                    if (j > 0 && dp[j] == dp[j-1]) continue;
                    dp[j] += a[idx];
                    dfs(a, k, idx-1);
                    dp[j] -= a[idx];
                }
            // }
        }
        int n, sum, min = Integer.MAX_VALUE;
        int [] dp;
        public int minimumTimeRequired(int[] jobs, int k) {
            n = jobs.length;
            dp = new int [k];
            Arrays.sort(jobs);
            sum = Arrays.stream(jobs).sum();
            dfs(jobs, k, n-1);
            return min;
        }

        int [][] dp;
        int n;
        public int mergeStones(int[] a, int k) {
            n = a.length;
            dp = new int [n][n];
                

        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        int []  a = new int []  {81, 823, 399, 421, 758, 520, 44, 346, 426, 380, 933, 766};

        int r = s.minimumTimeRequired(a, 12);
        System.out.println("r: " + r);
    }
}
