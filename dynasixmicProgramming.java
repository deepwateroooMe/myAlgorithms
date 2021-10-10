import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptException;

import static java.util.stream.Collectors.toMap;

public class dynasixmicProgramming {
    public static class Solution {

        // public int combinationSum4(int[] nums, int target) {
        //     int n = nums.length;
        //     if (n == 1 && target < nums[0] || nums[0] != 0 && target % nums[0] != 0) return 0;
        //     // int [] dp = new int [n];
        //     // int [] dp = new int [target + 1];
        //     // dp[nums[0]] = target % nums[0] == 0 ? 1 : 0;
        //     // for (int i = 1; i < n; i++) {
        //     }


        // private void helper(int [] arr, int i, int j) {
        //     if (i == j) return dp[i][j] = arr[i];
        //     if (j == i+1) return Math.abs(arr[i] - arr[j]);
        //     if (dp[i][j] > 0) return dp[i][j];
        // } // 还木有认出这个题到底是在考什么
        // int [][] dp;
        // int n;
        // public int lastStoneWeightII(int[] stones) {
        //     n = stones.length;
        //     if (n == 1) return stones[0];
        //     if (n == 2) return Math.abs(stones[0] - stones[1]);
        //     dp = new int [n][n];
        //     return dfs(stones, 0, n-1);
        // }


        // public int findMaxForm(String[] strs, int m, int n) {
        //     int [][] dp = new int [m+1][n+1];
        //     dp[0][0] = 0;
        //     for (String s : strs) {
        //         int one = 0, zoo = 0;
        //         for (int i = 0; i < s.length(); i++) {
        //             if (s.charAt(i) == '0') ++ zoo;
        //             else ++one;
        //         }
        //         for (int i = m; i >= zoo; i--) 
        //             for (int j = n; j >= one; j--) 
        //                 dp[i][j] = Math.max(dp[i][j], dp[i-zoo][j-one] + 1);
        //     }
        //     return dp[m][n];
        // }


        // public String optimalDivision(int[] nums) {
        //     int n = nums.length;
        //     if (n == 0) return "";
        //     String res = String.valueOf(nums[0]);
        //     if (n == 1) return res;
        //     if (n == 2) return res + "/" + nums[1];
        //     res += "/(" + nums[1];
        //     for (int i = 2; i < n; i++) 
        //         res += "/" + nums[i];
        //     return res + ")";
        // }

        
        // private int dfs(int [] arr, int target) {
        //     if (dp[target] != -1) return dp[target];
        //     int res = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (target >= arr[i])
        //             res += dfs(arr, target - arr[i]);
        //     }
        //     return dp[target] = res;
        // }
        // int [] dp;
        // int n;
        // public int combinationSum4(int[] nums, int target) {
        //     n = nums.length;
        //     dp = new int [target +1 ];
        //     Arrays.fill(dp, -1);
        //     dp [0] = 1;
        //     return dfs(nums, target);
        // }
        // public int combinationSum4(int[] nums, int target) {
        //     int n = nums.length;
        //     int [] dp = new int [target +1 ];
        //     dp [0] = 1;
        //     for (int i = 1; i <= target; i++) {
        //         for (int j = 0; j < n; j++) {
        //             if (i - nums[j] >= 0)
        //                 dp[i] += dp[i-nums[j]];
        //         }
        //     }
        //     return dp[target];
        // }


        // // 找出数组中等于target的最小非重叠区间的长度，用dp[i]表示当前i以及i之前的满足条件的最小区间长度,状态更新规则为
        // //     dp[i]=min(dp[i-1],i-j+1) if sum[j,i]=target
        // //     答案更新规则
        // //     res=min(res,dp[j−1]+i−j+1)
        // public int minSumOfLengths(int[] arr, int target) {
        //     int n = arr.length;
        //     int [] dp = new int [n];
        //     Arrays.fill(dp, Integer.MAX_VALUE);
        //     int cur = 0, s = 0;
        //     int res = Integer.MAX_VALUE, minLen = Integer.MAX_VALUE;
        //     for (int i = 0; i < n; i++) {
        //         cur += arr[i];
        //         while (cur > target) {
        //             cur -= arr[s];
        //             s += 1;
        //         }
        //         if (cur == target) {
        //             int curLen = i - s + 1;
        //             if (s > 0 && dp[s-1] != Integer.MAX_VALUE) 
        //                 res = Math.min(res, curLen + dp[s-1]);
        //             minLen = Math.min(minLen, curLen);
        //         }
        //         dp[i] = minLen;
        //     }
        //     return res == Integer.MAX_VALUE ? -1 : res;
        // }


        // class Node {
        //     private int val;
        //     private int back;
        //     public Node(int val, int back) {
        //         this.val = val;
        //         this.back = back; // 记住了每一跳是否是往反跳
        //     }
        // }
        // // 给出坐标 x ，可以往前跳的步长 a，往后跳的步长 b。要求输出能跳回家的最少跳跃次数。
        // // 求最少跳跃次数，思路用 BFS 求解，最先到达坐标 x 的方案即是最少跳跃次数。
        // // 对forbidden 的处理是把记忆化数组里面把他们标记为 true。
        // // 禁止连续往后跳 2 次的限制，要求我们在 BFS 入队的时候再记录一下跳跃方向，每次往后跳的时候判断前一跳是否是往后跳，如果是往后跳，此次就不能往后跳了。
        // public int minimumJumps(int[] forbidden, int a, int b, int x) {
        //     final int MAX = 100050;
        //     boolean [] take = new boolean [MAX];
        //     for (int fob: forbidden)        // 标记不能跳的点
        //         take[fob] = true; 
        //     int[][] dist = new int[MAX][2]; // 用于记录往前跳与往后跳的次数
        //     for(int i = 0; i < MAX; i++)    // 进行初始化
        //         Arrays.fill(dist[i], -1);
        //     dist[0][0] = 0;
        //     Queue<Node> q = new LinkedList<>(); // 创造队列
        //     q.offer(new Node(0, 0));
        //     Node cur = null;
        //     while (!q.isEmpty()) { // bfs 思路
        //         cur = q.poll();
        //         if(cur.val + a < MAX && !take[cur.val + a] && dist[cur.val + a][0] == -1){  // 往前跳
        //             dist[cur.val + a][0] = dist[cur.val][cur.back] + 1;
        //             q.offer(new Node(cur.val + a, 0));  // forward: 0
        //         }
        //         if(cur.back != 1 && cur.val - b >= 0 && !take[cur.val - b] && dist[cur.val - b][1] == -1){ // 往后跳
        //             dist[cur.val - b][1] = dist[cur.val][cur.back] + 1;
        //             q.offer(new Node(cur.val - b, 1));  // backward: 1
        //         }
        //     }
        //     int ans = Math.min((dist[x][0] == -1 ? Integer.MAX_VALUE : dist[x][0]), (dist[x][1] == -1 ? Integer.MAX_VALUE : dist[x][1]));
        //     return ans == Integer.MAX_VALUE ? -1 : ans;
        // }


//         private int dfs(int i, int j) {
//         }
// // To make the computation of each state in constant time,
//         // we could add another flag to the state that
//         // indicates whether or not we are in the middle of placing a line (placed start point but no endpoint).
//         //  use dynamic programming where the current index and remaining number of line segments to form can describe any intermediate state.
//         int [][][] dp;
//         public int numberOfSets(int n, int k) {
//             dp = new int [n][k+1][2];
//         }


        // private int getMinCnt(String s) {
        //     int n = s.length();
        //     if (n == 1) return 0;
        //     if (n == 2) return s.charAt(0) == s.charAt(1) ? 0 : 1;
        //     int i = 0, j = n-1, cnt = 0;
        //     while (i <= j) {
        //         if (s.charAt(i) != s.charAt(j)) ++ cnt;
        //         ++i;
        //         --j;
        //     }
        //     return cnt;
        // }
        // private int dfs(String s, int k, int idx, int v) {
        //     if (idx >= n) return 0;
        //     if (dp[idx][v] <= n) return dp[idx][v];
        //     if (v == 1)
        //         return dp[idx][v] = m.get(s.substring(idx));
        //     if (idx == n-v)
        //         return dp[idx][v] = 0;
        //     int min = n+1;
        //     for (int i = idx; i <= n-v; i++) 
        //         min = Math.min(min, m.get(s.substring(idx, i+1)) + dfs(s, k, i+1, v-1));
        //     return dp[idx][v] = min;
        // }
        // Map<String, Integer> m = new HashMap<>();
        // int [][] dp;
        // int n;
        // public int palindromePartition(String s, int k) {
        //     n = s.length();
        //     if (n == 1 || n == k) return 0;
        //     for (int i = 0; i < n; i++) 
        //         for (int j = i; j < n; j++)
        //             m.put(s.substring(i, j+1), getMinCnt(s.substring(i, j+1)));
        //     dp = new int [n][k+1];
        //     for (int i = 0; i < n; i++) 
        //         Arrays.fill(dp[i], n+1);
        //     return dfs(s, k, 0, k);
        // }


        // public boolean checkPartitioning(String s) {
        //     int n = s.length();
        //     if (n == 3) return true;
        //     boolean [][] p = new boolean[n][n];
        //     for (int i = n-1; i >= 0; i--) 
        //         for (int j = i; j < n; j++) 
        //             if (s.charAt(i) == s.charAt(j) && (j-i < 2 || p[i+1][j-1])) 
        //                 p[i][j] = true;
        //     for (int i = 0; i < n-2; i++) {
        //         for (int j = i+1; j < n-1; j++) {
        //             if (p[0][i] && p[i+1][j] && p[j+1][n-1]) return true;
        //         }
        //     }
        //     return false;
        // }


        // public int longestPalindrome(String s, String t) { // 这个题目没有懂，需要再好好看一下
        //     int m = s.length();
        //     int n = t.length();
        //     int mn = m + n;
        //     String st = s + t;
        //     int [][] dp = new int [mn][mn];
        //     for (int i = 0; i < mn; i++)
        //         dp[i][i] = 1;
        //     for (int l = 2; l <= mn; l++) {
        //         for (int i = 0, j = i+l-1; j < mn; i++,j++) { // 
        //             if (st.charAt(i) == st.charAt(j))
        //                 dp[i][j] = dp[i+1][j-1] + 2;
        //             else dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);                         
        //         }
        //     }
        //     int ans = 0;
        //     for (int i = 0; i < m; i++) {
        //         for (int j = 0; j < n; j++) {
        //             if (s.charAt(i) == t.charAt(j))
        //                 ans = Math.max(ans, dp[i][m+j]); // 
        //         }
        //     }
        //     return ans;
        // }


        // private List<Integer> findCommonElements(int [] a, int [] b) {
        //     Set<Integer> sa = new HashSet<>();
        //     Set<Integer> sb = new HashSet<>();
        //     for (int v : a) 
        //         sa.add(v);
        //     for (int v : b) 
        //         sb.add(v);
        //     sa.retainAll(sb);
        //     List<Integer> l = new ArrayList<>();
        //     for (Integer v : sa) 
        //         l.add(v);
        //     Collections.sort(l);
        //     return l;
        // }
        // private int binarySearch(int [] arr, int v, int l, int r) {
        //     if (l == r) return arr[l] == v ? l : -1;
        //     if (l == r-1) return arr[l] == v ? l : (arr[r] == v ? r : -1);
        //     int m = l + (r-l)/2;
        //     if (arr[m] == v) return m;
        //     if (arr[m] < v) return binarySearch(arr, v, m+1, r);
        //     return binarySearch(arr, v, l, m-1);
        // }
        // public int maxSum(int[] a, int[] b) {
        //     int m = a.length;
        //     int n = b.length;
        //     int mod = 1_000_000_007;
        //     if (a[m-1] <= b[0] || a[0] >= b[n-1])
        //         return (int)((a[m-1] <= b[0] ? Arrays.stream(b).sum() : Arrays.stream(a).sum()) % mod);
        //     long [] pa = new long [m+1];
        //     long [] pb = new long [n+1];
        //     for (int i = 1; i <= m; i++)
        //         pa[i] = pa[i-1] + a[i-1];
        //     for (int i = 1; i <= n; i++) 
        //         pb[i] = pb[i-1] + b[i-1];
        //     List<Integer> s = findCommonElements(a, b);
        //     if (s.size() == 0) return (int)(Math.max(pa[m], pb[n]) % mod);
        //     long res = 0;
        //     int i = 0, j = 0, pi = 0, pj = 0, v = 0;
        //     for (int x = 0; x < s.size(); x++) {
        //         v = s.get(x);
        //         i = binarySearch(a, v,  pi, m-1);
        //         j = binarySearch(b, v, pj, n-1);
        //         res = (res + Math.max(pa[i+1]-(pi == 0 ? 0 : pa[pi]), pb[j+1]-(pj == 0 ? 0 : pb[pj]))) % mod;
        //         pi = i+1;
        //         pj = j + 1;
        //     }
        //     if (i != pi || j != pj) {
        //         if (i != pi && j != pj)
        //             res = (res + Math.max(pa[m]-pa[pi], pb[n]-pb[pj])) % mod;
        //         else if (i != pi)
        //             res = (res + pa[m]-pa[pi]) % mod;
        //         else res = (res + pb[n]-pb[pj]) % mod;
        //     }
        //     return (int)res;
        // }

        
        // public int[] pathsWithMaxScore(List<String> board) {
        //     int m = board.size();
        //     int n = board.get(0).length();
        //     int [][] max = new int[m][n];
        //     long [][] cnt = new long [m][n];
        //     int mod = 1_000_000_007;
        //     cnt[m-1][n-1] = 1;
        //     for (int i = m-2; i >= 0; i--) 
        //         if (board.get(i).charAt(n-1) != 'X') {
        //             max[i][n-1] = max[i+1][n-1] + board.get(i).charAt(n-1)-'0';
        //             cnt[i][n-1] = cnt[i+1][n-1];
        //         } else {
        //             max[i][n-1] = Integer.MIN_VALUE;
        //             cnt[i][n-1] = Integer.MIN_VALUE;
        //         }
        //     for (int j = n-2; j >= 0; j--) 
        //         if (board.get(m-1).charAt(j) != 'X') {
        //             max[m-1][j] = max[m-1][j+1] + board.get(m-1).charAt(j)-'0';
        //             cnt[m-1][j] = cnt[m-1][j+1];
        //         } else {
        //             max[m-1][j] = Integer.MIN_VALUE;
        //             cnt[m-1][j] = Integer.MIN_VALUE;
        //         }
        //     int tmp = 0;
        //     for (int i = m-2; i >= 0; i--) {
        //         for (int j = n-2; j >= 0; j--) {
        //             if (board.get(i).charAt(j) == 'X') {
        //                 max[i][j] = Integer.MIN_VALUE;
        //                 cnt[i][j] = Integer.MIN_VALUE;
        //                 continue;
        //             }
        //             tmp = Math.max(max[i+1][j], max[i][j+1]); 
        //             tmp = Math.max(tmp, max[i+1][j+1]) + (board.get(i).charAt(j) == 'E' ? 0 : board.get(i).charAt(j) - '0');  
        //             max[i][j]= tmp;
        //             if (tmp == max[i+1][j+1] + (board.get(i).charAt(j) == 'E' ? 0 : board.get(i).charAt(j) - '0'))
        //                 cnt[i][j] = cnt[i+1][j+1];
        //             else {
        //                 if (max[i+1][j] == max[i][j+1]) cnt[i][j] = cnt[i+1][j] + cnt[i][j+1];
        //                 else cnt[i][j] = (tmp == max[i+1][j] + (board.get(i).charAt(j) == 'E' ? 0 : board.get(i).charAt(j) - '0') ? cnt[i+1][j] : cnt[i][j+1]);
        //             }
        //             cnt[i][j] %= mod;
        //         }
        //     }
        //     return new int[] {max[0][0] > 0 ? max[0][0] : 0, (int)cnt[0][0] > 0 ? (int)cnt[0][0] : 0};
        // }


        // public int firstDayBeenInAllRooms(int[] nextVisit) {
        //     int n = nextVisit.length;
        //     int [] dp = new int [n];
        //     int cnt = 0;
        //     dp[0] = 0;
        //     for (int i = 0; i < n; i++) {
        //     }
        // }

        // private boolean dfs(char [] s, int i, int cnt) { // cnt of left (
        //     if (cnt < 0) return false;
        //     if (i == s.length) return cnt == 0;
        //     if (dp[i][cnt] != null) return dp[i][cnt];
        //     char c = s[i];
        //     boolean res = false;
        //     if (c == '(') res = dfs(s, i+1, cnt+1);
        //     else if (c == ')') res = dfs(s, i+1, cnt-1);
        //     else res = dfs(s, i+1, cnt) || dfs(s, i+1, cnt+1) || dfs(s, i+1, cnt-1);
        //     return dp[i][cnt] = res;
        // }
        // Boolean [][] dp;
        // int n;
        // public boolean checkValidString(String s) {
        //     n = s.length();
        //     dp = new Boolean [n][n];
        //     return dfs(s.toCharArray(), 0, 0);
        // }


        // public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        //     int n = nums.length;
        //     int [] pre = new int [n+1];
        //     for (int i = 1; i <= n; i++) 
        //         pre[i] = pre[i-1] + nums[i-1];
        //     // left[i]表示在区间[0, i]范围内长度为k且和最大的子数组的起始位置
        //     // right[i]表示在区间[i, n - 1]范围内长度为k且和最大的子数组的起始位置
        //     int [] left = new int [n];
        //     int [] right = new int [n];
        //     int [] res = new int [3];
        //     Arrays.fill(right, n-k);
        //     for (int i = k, total = pre[k]-pre[0]; i < n; i++) {
        //         if (pre[i+1] - pre[i+1-k] > total) {
        //             left[i]= i+1-k;
        //             total = pre[i+1] - pre[i+1-k];
        //         } else left[i] = left[i-1];
        //     }
        //     for (int i = n-1-k, total = pre[n]-pre[n-k]; i >= 0; i--) {
        //         if (pre[i+k] - pre[i] >= total) {
        //             right[i] = i;
        //             total = pre[i+k] - pre[i];
        //         } else right[i] = right[i+1];
        //     }
        //     int max = Integer.MIN_VALUE;
        //     for (int i = k; i <= n-2*k; i++) {
        //         int l = left[i-1];
        //         int r = right[i+k];
        //         int total = (pre[i+k]-pre[i]) + (pre[k+l]-pre[l]) + (pre[r+k] - pre[r]);
        //         if (max < total) {
        //             max = total;
        //             res = new int [] {l, i, r};
        //         }
        //     }
        //     return res;
        // }


        // public int maxDotProduct(int[] a, int[] b) {
        //     int m = a.length;
        //     int n = b.length;
        //     int [][] dp = new int [m][n];
        //     dp[m-1][n-1] = a[m-1]*b[n-1];
        //     for (int i = m-2; i >= 0; i--) 
        //         dp[i][n-1] = Math.max(a[i] * b[n-1], dp[i+1][n-1]);
        //     for (int j = n-2; j >= 0; j--) 
        //         dp[m-1][j] = Math.max(a[m-1]*b[j], dp[m-1][j+1]);
        //     int cur = 0, tmp = 0;
        //     int right = 0, down = 0, dr = 0;
        //     for (int i = m-2; i >= 0; i--) {
        //         for (int j = n-2; j >= 0; j--) {
        //             cur = a[i] * b[j];
        //             tmp = Math.max(dp[i+1][j], dp[i][j+1]);
        //             tmp = Math.max(tmp, cur);
        //             if (dp[i+1][j+1] > 0 && cur > 0) tmp = Math.max(tmp, dp[i+1][j+1] + cur);
        //             dp[i][j] = tmp;
        //         }
        //     }
        //     return dp[0][0];
        // }


        // private int dfs(int steps, int n, int i) {
        //     if (steps < i) return 0; // 裁枝： 如果剩余步数小于index，说明已无法返回起点
        //     if (i < 0 || i >= n) return 0;
        //     if (steps == 0 && i == 0) return 1; 
        //     if (dp[steps][i] > 0) return dp[steps][i];
        //     long res = dfs(steps-1, n, i-1) % mod;
        //     res = (res + dfs(steps-1, n, i+1)) % mod;
        //     res = (res + dfs(steps-1, n, i)) % mod;
        //     return dp[steps][i] = (int)res;
        // }
        // int mod = 1_000_000_007;
        // // memo[i][j]代表，还剩下i步时，从下标j返回下标0的方案数
        // // 由于能够到达的最远index一定不能超过步数的一半，
        // // j的最大值为steps/2+1
        // int [][] dp;
        // public int numWays(int steps, int arrLen) {
        //     dp = new int [steps + 1][steps/2 + 1];
        //     return dfs(steps, arrLen, 0);
        // }
        // public int numWays(int steps, int arrLen) {
        //     int maxPos = Math.min(steps/2+1, arrLen);
        //     long[][] dp = new long[steps + 1][maxPos + 1];
        //     int mod = 1_000_000_007;
        //     dp[1][0] = 1;
        //     dp[1][1] = 1;
        //     for (int i = 2; i <= steps; i++) 
        //         for (int j = 0; j < maxPos; j++) 
        //             dp[i][j] = (dp[i-1][j] + dp[i-1][j+1] + (j > 0 ? dp[i-1][j-1] : 0)) % mod;
        //     return (int)(dp[steps][0] % mod);
        // }


        // public int maxSumSubmatrix(int[][] mat, int k) {
        //     int m = mat.length;
        //     int n = mat[0].length;
        //     if (m == 1 && n == 1) return mat[0][0];
        //     int [][] pre = new int [m][n];
        //     int res = Integer.MIN_VALUE;
        //     for (int i = 0; i < m; i++) {
        //         for (int j = 0; j < n; j++) {
        //             int t = mat[i][j];
        //             if (i > 0) t += pre[i-1][j];
        //             if (j > 0) t += pre[i][j-1];
        //             if (i > 0 && j > 0) t -= pre[i-1][j-1];
        //             pre[i][j] = t;
        //             for (int r = 0; r <= i; r++) {
        //                 for (int c = 0; c <= j; c++) {
        //                     int d = pre[i][j];
        //                     if (r > 0) d -= pre[r-1][j];
        //                     if (c > 0) d -= pre[i][c-1];
        //                     if (r > 0 && c > 0) d += pre[r-1][c-1];
        //                     if (d <= k) res = Math.max(res, d);
        //                 }
        //             }
        //         }
        //     }
        //     return res;
        // }
        // // 把二维数组按行或列拆成多个一维数组，然后利用一维数组的累加和来找符合要求的数字，
        // // 这里用了 lower_bound 来加快的搜索速度，也可以使用二分搜索法来替代。
        // public int maxSumSubmatrix(int[][] mat, int target) {
        //     int row = mat.length;
        //     int col = mat[0].length;
        //     int res = Integer.MIN_VALUE;
        //     boolean key = col > row ? false : true;
        //     int m = Math.min(row, col);
        //     int n = Math.max(row, col);
        //     int [] pre = new int [n];
        //     TreeSet<Integer> ts = new TreeSet<>(); //用来保存当前高度下，长度为从0开始到k位置的矩形的结果。理解set的含义是解决此题的关键。
        //     Integer tmp = 0;
        //     for (int i = 0; i < m; i++) { // 找从第i行开始一直到第0行这i+1行的可能组成的矩形长度
        //         Arrays.fill(pre, 0);
        //         for (int j = i; j >= 0; j--) {
        //             ts.clear();
        //             ts.add(0);
        //             int curSum = 0;
        //             for (int k = 0; k < n; k++) {
        //                 if (key)
        //                     pre[k] += mat[k][j];
        //                 else pre[k] += mat[j][k];
        //                 curSum += pre[k];
        //                  // * 因为要满足  （sum-set中的元素）<=target,
        //                  // * 而且sum-set中的元素的值要尽可能的大，
        //                  // * 所以也就是再求小于等于sum-target中满足条件的元素的最小的一个
        //                  // * 正好TreeSet中提供了这个方法ceil()，可以很方便的找出这个元素
        //                 tmp = ts.ceiling(curSum - target);
        //                 if (tmp != null) res = Math.max(res, curSum - tmp);
        //                 ts.add(curSum);
        //             }
        //         }
        //     }
        //     return res;
        // }


        // int [][] dp;
        // public int getMaxGridHappiness(int m, int n, int introvertsCount, int extrovertsCount) {
        //     dp = new int [m][n];
        // }


        // public String largestMultipleOfThree(int[] digits) {
        //     int n = digits.length;
        //     Arrays.sort(digits);
        //     int [] dg = IntStream.rangeClosed(0, n-1).map(z->digits[n-1-z]).toArray();
        //     System.out.println("dg.length: " + dg.length);
        //     for (int z = 0; z < dg.length; ++z) 
        //         System.out.print(dg[z] + ", ");
        //     System.out.println("");
        //     // find the longest subsequece of sum % 3 == 0
        //     return "";
        // }

        // // DP + BitSet : 这里面有个小问题需要挑出来
        // // 使用一个DP数组存下当前行和之前行每行选一个数可能构成的和，
        // // 在本题中，可以使用BitSet（简介）来存储之前行可以组成的和（由于所有数的最大值为70，而行数最大也为70，故BitSet最大的位数即为4900）。
        // // 对于当前行，遍历BitSet已经set过的位（即代表之前行可能组成的和），然后加上当前数，set新的和
        // // 最后遍历BitSet，求出当前位与target的最小值
        // public int minimizeTheDifference(int[][] mat, int target) {
        //     int m = mat.length;
        //     int n = mat[0].length;
        //     BitSet sum = new BitSet(); // 遍历每一行，存下当前行和之前行可能组成的和
        //     for (int i = 0; i < n; i++) // 初始时存下第一行
        //         sum.set(mat[0][i]);
        //     for (int i = 1; i < m; i++) {
        //         BitSet newSum = new BitSet(); // 用来存新的和
        //         for (int j = 0; j < n; j++) {
        //             // 注意：要遍历BitSet中的真实位，请使用以下循环：previousSetBit()方法 用于查找在指定的起始索引上或之前是否存在任何真位
        //             // for (int i = bs.length(); (i = bs.previousSetBit(i-1)) >= 0; ) {
        //             //     // operate on index i here
        //             // }
        //             for (int k = sum.length(); (k = sum.previousSetBit(k-1)) >= 0; ) {
        //                 newSum.set(k+mat[i][j]);
        //             }
        //         }
        //         sum = newSum;
        //     }
        //     int ans = 4900;
        //     for (int k = sum.length(); (k = sum.previousSetBit(k-1)) >= 0;) {
        //         int diff = Math.abs(k - target);
        //         ans = Math.min(ans, diff);
        //     }
        //     return ans;
        // }
        // public int minimizeTheDifference(int[][] mat, int target) {
        //     int m = mat.length;
        //     int n = mat[0].length;
        //     int diff = Integer.MAX_VALUE, limit = 4900;
        //     int [] dp = new int[limit];
        //     for (int i = 0; i < n; i++) // 相当于是手工实现java BitSet
        //         dp[mat[0][i]] = 1;
        //     for (int i = 1; i < m; i++) {
        //         int [] tmp = new int [limit];
        //         for (int v = limit-1; v >= 0; v--) {
        //             if (dp[v] == 0) continue;
        //             for (int j = 0; j < n; j++) {
        //                 if (v + mat[i][j] < limit)
        //                     tmp[v+mat[i][j]] = 1;
        //             }
        //         }
        //         System.arraycopy(tmp, 0, dp, 0, dp.length);
        //     }
        //     for (int i = 0; i < limit; i++) 
        //         if (dp[i] > 0) diff = Math.min(diff, Math.abs(i-target));
        //     return diff;  // min difference
        // }


        // public boolean splitArraySameAverage(int[] nums) {
        //     int n = nums.length;
        //     int m = n / 2;
        //     int sum = Arrays.stream(nums).sum();
        //     boolean poss = false;
        //     for (int i = 1; i <= m; i++) {
        //         if (sum * i % n == 0) {
        //             poss = true;
        //             break;
        //         }
        //     }
        //     if (!poss) return false;
        //     BitSet [] bits = new BitSet [m+1];
        //     // bitset<300001> bits[m + 1] = {1}; // c++ 这里不知道该怎么改写了
        //     // for (int num : A) {
        //     //     for (int i = m; i >= 1; --i) {
        //     //         bits[i] |= bits[i - 1] << num;
        //     //     }
        //     // }
        //     for (int i = 0; i <= m; i++) 
        //         bits[i] = new BitSet(1);
        //     for (int v : nums) {
        //         for (int i = m; i >= 1; i--) 
        //             bits[i] |= bits[i-1] << v;
        //     }
        //     for (int i = 1; i <= m; i++) {
        //         // if (sum * i % n == 0 && bits[i][])
        //     }
        //     return false;
        // }
        // private boolean helper(int [] arr, int curSum, int cur, int start) {
        //     if (cur == 0) return curSum == 0;
        //     if (arr[start] > curSum / cur) return false;
        //     for (int i = start; i < arr.length - cur + 1; i++) {
        //         if (i > start && arr[i] == arr[i-1]) continue;
        //         if (helper(arr, curSum - arr[i], cur-1, i+1)) return true;
        //     }
        //     return false;
        // }
        // public boolean splitArraySameAverage(int[] nums) {
        //     int n = nums.length;
        //     int m = n / 2;
        //     int sum = Arrays.stream(nums).sum();
        //     boolean poss = false;
        //     for (int i = 1; i <= m; i++) {
        //         if (sum * i % n == 0) {
        //             poss = true;
        //             break;
        //         }
        //     }
        //     if (!poss) return false;
        //     Arrays.sort(nums);
        //     for (int i = 1; i <= m; i++) 
        //         if (sum * i % n == 0 && helper(nums, sum * i / n, i, 0)) return true;
        //     return false;
        // }
        // bool splitArraySameAverage(vector<int>& A) {  // https://www.cnblogs.com/grandyang/p/10285531.html
        //     int n = A.size(), m = n / 2, sum = accumulate(A.begin(), A.end(), 0);
        //     bool possible = false;
        //     for (int i = 1; i <= m && !possible; ++i) {
        //         if (sum * i % n == 0) possible = true;
        //     }
        //     if (!possible) return false;
        //     bitset<300001> bits[m + 1] = {1};
        //     for (int num : A) {
        //         for (int i = m; i >= 1; --i) {
        //             bits[i] |= bits[i - 1] << num;
        //         }
        //     }
        //     for (int i = 1; i <= m; ++i) {
        //         if (sum * i % n == 0 && bits[i][sum * i / n]) return true;
        //     }
        //     return false;
        // }
    //     1）如果一个长度为n的数组可以被划分为A和B两个数组，我们假设A的长度小于B并且A的大小是k，那么：total_sum / n == A_sum / k == B_sum / (n - k)，其中1 <= k <= n / 2。那么可以知道：A_sum = total_sum * k / n。由于A_sum一定是个整数，所以我们可以推导出total_sum * k % n == 0，那就是说，对于特定的total_sum和n而言，符合条件的k不会太多。这样我们在第一步中就首先验证是否存在符合条件的k，如果不存在就可以提前返回false。
    //     2）如果经过第一步的验证，发现确实有符合条件的k，那么我们在第二步中，就试图产生k个子元素的所有组合，并且计算他们的和。这里的思路就有点类似于背包问题了，vector<unordered_set<int>> sums，其中sums[i][j]表示A[0, i]这个子数组中的任意j个元素的所有可能和。可以得到递推公式是：sums[i][j] = sums[i - 1][j] "join" (sums[i][j - 1] + A[i])，其中等式右边的第一项表示这j个元素中不包含A[i]，而第二项表示这j个元素包含A[i]。这样就可以采用动态规划的思路得到sums[n - 1][k]了（1 <= k <= n / 2）。
    // 3）有了sums[n - 1][k]，我们就检查sums[n - 1][k]中是否包含(total_sum * k / n)。一旦发现符合条件的k，就返回true，否则就返回false。
    // 在递推公式中我们发现，sums[i][j]仅仅和sums[i - 1][j]，sums[i][j - 1]有关，所以可以进一步将空间复杂度从O(n^2*M)降低到O(n*M)，其中M是n中的所有元素的组合数（可能高达O(2^n)）。时间复杂度为O(n^3*M)。
        // public boolean splitArraySameAverage(int[] nums) {
        //     int n = nums.length;
        //     int m = n / 2;
        //     int sum = Arrays.stream(nums).sum();
        //     boolean poss = false;
        //     for (int i = 1; i <= m; i++) {
        //         if (sum * i % n == 0) {
        //             poss = true;
        //             break;
        //         }
        //     }
        //     if (!poss) return false;
        //     List<Set<Integer>> ls = new ArrayList<>();
        //     for (int i = 0; i <= m; i++) 
        //         ls.add(new HashSet<Integer>());
        //     ls.get(0).add(0);    // 这种构建子序列和的方法，要学习一下
        //     for (int v : nums) { // for each element in A, we try to add it to sums[i] by joining sums[i - 1]
        //         for (int i = m; i >= 1; i--) 
        //             for (int t : ls.get(i-1)) 
        //                 ls.get(i).add(t + v);
        //     }
        //     for (int i = 1; i <= m; i++) {
        //         if (sum * i % n == 0 && ls.get(i).contains(sum * i / n))
        //             return true;
        //     }
        //     return false;
        // }


        // public int numSquares(int n) {
        //     int [] dp = new int [n+1];
        //     Arrays.fill(dp, n+1);
        //     dp[0] = 0;
        //     for (int i = 1; i <= n; i++) {
        //         for (int j = 1; j*j <= n; j++) 
        //             if (i - j*j >= 0) dp[i] = Math.min(dp[i], dp[i-j*j] + 1);
        //     }
        //     return dp[n];
        // }


        // public int coinChange(int[] coins, int amount) {
        //     if (amount == 0) return 0;
        //     int n = coins.length;
        //     int [] dp = new int [amount + 1];
        //     Arrays.sort(coins);
        //     Arrays.fill(dp, amount + 1);
        //     dp[0] = 0;
        //     for (int i = 0; i <= amount; i++) {
        //         for (int v : coins) {
        //             if (i - v < 0) continue;
        //             dp[i] = Math.min(dp[i], dp[i-v] + 1);
        //         }
        //     }
        //     return dp[amount] == amount + 1 ? -1 : dp[amount];
        // }
        // public int change(int target, int[] nums) {
        //     int[] dp = new int[target + 1];
        //     // 初始化dp[0]为1
        //     dp[0] = 1;
        //     // 循环数组中所有数字
        //     for (int val : nums) {
        //         for (int i = 0; i <= target - val; i++) {
        //             // dp[i]大于0说明，存在dp[i]种组合，其和为i的可能性
        //             if (dp[i] > 0) {
        //                 // 既然存在和为i的可能，那么i加上当前数字的和也是存在的
        //                 dp[i + val] += dp[i];
        //             }
        //         }
        //     }
        //     return dp[target];
        // }


        // public int backPackIII(int[] A, int[] V, int m) {
        //     int n = A.length;
        //     int [] dp = new int[m+1];
        //     for (int i = 1; i <= m; i++) {
        //         for (int j = 0; j < n; j++) {
        //             if (i - A[j] >= 0)
        //                 dp[i] = Math.max(dp[i], dp[i-A[j]] + V[j]);
        //         }
        //     }
        //     return dp[m];
        // }

        
        // public int lastStoneWeightII(int[] stones) {
        //     int n = stones.length;
        //     int sum = Arrays.stream(stones).sum();
        //     boolean[] dp = new boolean[sum+1];
        //     dp[0] = true;
        //     sum = 0;
        //     for (int v : stones) {
        //         sum += v;
        //         for (int i = sum; i >= v; i--) 
        //             if (dp[i-v]) dp[i] = true;
        //     }
        //     for (int i = sum/2; i >= 0; i--) 
        //         if (dp[i]) return sum - i * 2;
        //     return 0;
        // }


        // public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        //     int m = baseCosts.length;  // 还有bug， 暂时不想再改这个题目了
        //     int n = toppingCosts.length;
        //     if (m == 1 && target < baseCosts[0]) return baseCosts[0]; // 不喜欢处理这种特殊情况
        //     Arrays.sort(toppingCosts);
        //     int [] des = IntStream.rangeClosed(0, n-1).map(z->toppingCosts[n-1-z]).toArray();
        //     boolean [] dp = new boolean [target + 1];
        //     int cur = 0;
        //     dp[0] = true;
        //     for (int i = 0; i < m; i++) {
        //         cur = baseCosts[i];
        //         if (cur <= target) 
        //             dp[cur] = true;
        //     }
        //     for (int i = 0; i < n; i++) {
        //         int v = toppingCosts[i];
        //         for (int j = target; j > 0; j--) {
        //             if (!dp[j]) continue;
        //             if (j + v + v <= target) 
        //                 dp[j+v+v] = true;
        //             if (j + v <= target)
        //                 dp[j+v] = true;  
        //         }
        //     }
        //     for (int i = target; i > 0; i--) 
        //         if (dp[i]) return i;
        //     return -1;
        // }
        // private void helper(int [] arr, int target, int cur, int idx) {
        //     if (Math.abs(cur - target) < Math.abs(res - target) || Math.abs(cur - target) == Math.abs(res - target) && cur < res)
        //         res = cur;
        //     if (idx == arr.length) return;
        //     helper(arr, target, cur, idx+1);
        //     helper(arr, target, cur + arr[idx], idx+1);
        //     helper(arr, target, cur + arr[idx]*2, idx+1);
        // }
        // int res = Integer.MAX_VALUE;
        // public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        //     for (int v : baseCosts) 
        //         helper(toppingCosts, target, v, 0);
        //     return res;
        // }


        // private int dfs(int [] arr, int [] mi, int i, int j, int cnt) {
        //     if (cnt >= mi.length) return 0;
        //     if (cache.containsKey(i) && cache.get(i).containsKey(j)) return cache.get(i).get(j);
        //     int res = Math.max(
        //         mi[cnt] * arr[i] + dfs(arr, mi, i+1, j, cnt+1),
        //         mi[cnt] * arr[j] + dfs(arr, mi, i, j-1, cnt+1));
        //     if (!cache.containsKey(i)) cache.put(i, new HashMap<Integer, Integer>());
        //     cache.get(i).put(j, res);
        //     return res;
        // }
        // Map<Integer, Map<Integer, Integer>> cache = new HashMap<>();
        // public int maximumScore(int[] nums, int[] multipliers) {
        //     return dfs(nums, multipliers, 0, nums.length-1, 0);
        // }
        // public int maximumScore(int[] arr, int[] multipliers) {
        //     int n = arr.length;
        //     int m = multipliers.length;
        //     if (n == 1) return arr[0] * multipliers[0];
        //     int [] dp = new int [n]; // the max product if get i vals from left side
        //     Arrays.fill(dp, Integer.MIN_VALUE);
        //     dp[0] = arr[n-1] * multipliers[0];
        //     dp[1] = arr[0] * multipliers[0];
        //     for (int o = 1; o < m; o++) {
        //         if (o + 1 < n) 
        //             dp[o+1] = dp[o] + arr[o] * multipliers[o];
        //         for (int i = o; i > 0; i--) 
        //             dp[i] = Math.max(dp[i-1] + arr[i-1] * multipliers[o], dp[i] + arr[n-(o-i)-1] * multipliers[o]);
        //         dp[0] = dp[0] + arr[n - o - 1] * multipliers[o];
        //     }
        //     int max = Integer.MIN_VALUE;
        //     for (int i = 0; i < n; i++) 
        //         max = Math.max(dp[i], max);
        //     return max;
        // }
        // 定义二维数组dp[m + 1][m + 1]。dp[i][j]：表示nums数组中前i个数和后j个数组成的最大分数。
        // base case：
        // dp[0][0] = 0;
        // dp[i][0]：此状态表示nums数组中前i个数和后0个数组成的最大分数，此状态只可能由dp[i - 1][0]转移得到。
        // dp[0][j]：此状态表示nums数组中前0个数和后j个数组成的最大分数，此状态只可能由dp[0][j - 1]转移得到。
        // dp[i][j]：该状态表示nums数组中前i个数和后j个数组成的最大分数，可能由状态
        // dp[i - 1][j]和状态dp[i][j - 1]转移得到，取其中得分最大的一个。
        // 遍历所有可能的组合（满足i + j = m）获得最大得分。
        // public int maximumScore(int[] arr, int[] multipliers) { // 这里有个bug暂时不想改了，但思路清晰
        //     int n = arr.length;
        //     int m = multipliers.length;
        //     if (n == 1) return arr[0] * multipliers[0];
        //     int [][] dp = new int [m+1][m+1];
        //     for (int i = 1; i <= m; i++)
        //         dp[i][0] = dp[i-1][0] + arr[i-1]*multipliers[i-1];
        //     for (int i = 1; i <= m; i++)
        //         dp[0][i] = dp[i-1][0] + arr[n-i]*multipliers[i-1];
        //     for (int i = 1; i <= m; i++) 
        //         for (int j = 1; j <= m; j++)
        //             if (i + j <= m)
        //             dp[i][j] = Math.max(dp[i-1][j] + arr[i-1]*multipliers[i+j-1], dp[i][j-1] + arr[n-j]*multipliers[i+j-1]);
        //     int max = Integer.MIN_VALUE;
        //     for (int i = 0; i <= m; i++) 
        //         max = Math.max(max, dp[i][m-i]);
        //     return max;
        // }

    // // https://blog.csdn.net/luke2834/article/details/89457888 // 这个题目要多写几遍
        // public int tallestBillboard(int[] rods) { // 写得好神奇呀
        //     int n = rods.length;
        //     int sum = Arrays.stream(rods).sum();
        //     System.out.println("sum: " + sum);
        //     int [][] dp = new int [2][(sum + 1) << 1];  // (sum + 1) * 2
        //     for (int i = 0; i < 2; i++) 
        //         Arrays.fill(dp[i], -1);
        //     dp[0][sum] = 0;
        //     for (int i = 0; i < n; i++) {
        //         int cur = i & 1, next = (i & 1) ^ 1; // 相当于是滚动数组： [0, 1]
        //         for (int j = 0; j < dp[cur].length; j++) {
        //             if (dp[cur][j] == -1) continue;
        //             dp[next][j] = Math.max(dp[cur][j], dp[next][j]); // update to max
        //             dp[next][j+rods[i]] = Math.max(dp[next][j+rods[i]], dp[cur][j] + rods[i]);
        //             dp[next][j-rods[i]] = Math.max(dp[next][j-rods[i]], dp[cur][j] + rods[i]);
        //         }
        //     }
        //     return dp[rods.length & 1][sum] >> 1; // dp[n&1][sum] / 2
        // }
        // // 1. 所有的状态全集：dp[len][sum+1], len = length of array, sum = sum of the array，代表两边共有的高度
        // // 2. state transfer:
        // //     a. 忽略当前 dp[i][j] = max(dp[i-1][j], dp[i][j])
        // //     b. 加入到higher一侧 dp[i][j+h] = max(dp[i][j+h], dp[i-1][j])
        // //     c. 加入到lower一侧 lower = abs(j-h); dp[i][lower] = max(dp[i][lower], dp[i][j] + min(j, h)); 其中min(j,h)为新增高度
        // private void dfs(int [] arr, int idx) {
        //     int cur = arr[idx];
        //     if (dp[idx][cur] != -1) return;
        //     if (idx == 0) {
        //         dp[idx][cur] = 0; // add
        //         dp[idx][0] = 0;      // ignore
        //         return;
        //     }
        //     dfs(arr, idx-1);
        //     int lower = 0;
        //     for (int i = 0; i < dp[idx].length-cur; i++) {
        //         if (dp[idx-1][i] < 0) continue;
        //         dp[idx][i] = Math.max(dp[idx][i], dp[idx-1][i]);          // 1: ignore
        //         dp[idx][i+cur] = Math.max(dp[idx][i+cur], dp[idx-1][i]);  // 2: add to higher
        //         lower = Math.abs(i - cur);                                //3. add to lower
        //         dp[idx][lower] = Math.max(dp[idx][lower], dp[idx-1][i] + Math.min(i, cur));
        //     }
        // }
        // int [][] dp;
        // int n;
        // public int tallestBillboard(int[] rods) { 
        //     int n = rods.length;
        //     int sum = Arrays.stream(rods).sum();
        //     dp = new int [n][sum+1];
        //     for (int i = 0; i < n; i++) 
        //         Arrays.fill(dp[i], -1);
        //     dfs(rods, n-1);
        //     return dp[n-1][0];
        // }
    // 定义一个数对键值：（i,j）：i表示两个子序列的累加和差值的绝对值，j表示这个差值下，子序列中累加和的最大值，定义一个dp的map存放前m个数的所有子序列的累加和之差和对应的累加和最大值:比如：[1,2,3,4,5], 累加和为15，[7,8,9],累加和为24，两者差值为9，那么用(9,24)
    //         新建一个HashMap temp用于存放第m个数对之前子序列累加和只差的状态转移结果
    //         对于新到来的rod，只能够有3中情况：
    //         1.rod不加入任何列表：
    //         从dp中拿出每个子序列的差值k的累加和最大值v1，每个结果与temp中相应k的累加和最大值v2比较，如果v1>v2,那么更新temp中k对应的最大累加和为v1
    //         2.rod加入累加和较大的序列
    //         从dp中拿出每个子序列的差值k的累加和最大值v1，并加上rod,这时差值变成k + rod，累加和最大值变成v1+ rod, 每个结果与temp中相应k + rod的累加和最大值v2比较，如果v1 + rod > v2,那么更新temp中k对应的最大累加和为v1+rod
    //         3.rod加入累加和较小的序列
    //         从dp中拿出每个子序列的差值k的累加和最大值v1，累加和较小的子序列加上了rod，那么和累加和较大的子序列之差为k-rod，k-rod为负数时，说明累加和较小数组超越了累加和较大的数组，为非负数时，说明较大累加和的数组不变，因此当前累加和最大值为x = Max(v, v - (k - rod)), 然后再和temp中序列差为abs(k-rod)的最大累加和v2比较，如果x>v2则更新temp中abs(k-rod)为x;
        // public int tallestBillboard(int[] rods) {
        //     int n = rods.length;
        //     Map<Integer, Integer> dp = new HashMap<>();
        //     dp.put(0, 0);
        //     for (int rod : rods) {
        //         System.out.println("\nrod: " + rod);
        //         Map<Integer, Integer> tmp = new HashMap<>();
        //         dp.forEach((k, v) -> {
        //                 if (tmp.getOrDefault(k, -1) < v) tmp.put(k, v);
        //                 if (tmp.getOrDefault(k+rod, -1) < v+rod) tmp.put(k + rod, v+rod);
        //                 int dis = k - rod;
        //                 int larger = Math.max(v, v-dis);
        //                 dis = Math.abs(dis);
        //                 if (tmp.getOrDefault(dis, -1) < larger) tmp.put(dis, larger);
        //             });
        //         dp = tmp;
        //     }
        //     return dp.get(0);
        // }
        
    }
    public static void main(String[] args)  {
        Solution s = new Solution();

        int []  a = new int []  {1, 2, 3};

        int r = s.tallestBillboard(a);
       System.out.println("r: " + r);
    }
}