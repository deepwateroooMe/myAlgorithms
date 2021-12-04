// import com.UnionFind;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;

public class dynaonemicProgramming {
    public static class Solution {
            
        // public int fib(int n) {
        //     int [] dp = new int [2];
        //     dp[0] = 0;
        //     dp[1] = 1;
        //     for (int i = 2; i <= n; i++) 
        //         dp[i % 2] = dp[(i-1) % 2] + dp[(i-2) % 2];
        //     return dp[n % 2];
        // }

        // public int tribonacci(int n) {
        //     int [] dp = new int [3];
        //     dp[0] = 0;
        //     dp[1] = 1;
        //     dp[2] = 1;
        //     for (int i = 3; i <= n; i++) 
        //         dp[i%3] = dp[(i-1) % 3] + dp[(i-2) % 3] + dp[(i-3) % 3];
        //     return dp[n % 3];
        // }

        // public int climbStairs(int n) {
        //     int [] dp = new int [2];
        //     dp[0] = 1;
        //     dp[1] = 2;
        //     for (int i = 2; i < n; i++)
        //         dp[i % 2] = dp[(i-1) % 2] + dp[(i-2) % 2];
        //     return dp[(n-1) % 2];
        // }

        // public int minCostClimbingStairs(int[] cost) {
        //     int n = cost.length;
        //     int [] arr = new int [n+2];
        //     System.arraycopy(cost, 0, arr, 1, n);
        //     int [] dp = new int [2];
        //     dp[(n+1) % 2] = 0;
        //     dp[n % 2] = arr[n];
        //     for (int i = n-1; i >= 0; i--) 
        //         dp[i % 2] = arr[i] + Math.min(dp[(i+1) % 2], dp[(i+2) % 2]);
        //     return dp[0];
        // }

        
        // private int dfs(int [] arr, int idx) {
        //     if (idx >= n) return 0;
        //     if (dp[idx] > 0) return dp[idx];
        //     return dp[idx] = Math.max(dfs(arr, idx+2) + arr[idx], dfs(arr, idx+1)); // 不要忘记记忆——记住答案！！！
        // }
        // int [] dp;
        // int n;
        // public int rob(int[] a) {
        //     if (Arrays.stream(a).sum() == 0) return 0;
        //      n = a.length;
        //      dp = new int [n];
        //      return dfs(a, 0);
        // }

        // private int dfs(int [] arr, int i, int j, int idx) {
        //     if (idx > j) return 0;
        //     if (dp[idx] != -1) return dp[idx];
        //     return dp[idx] = Math.max(dfs(arr, i, j, idx+2) + arr[idx], dfs(arr, i, j, idx+1));
        // }
        // int [] dp;
        // int n;
        // public int rob(int[] arr) {
        //      n = arr.length;
        //      if (n == 1) return arr[0];
        //      dp = new int [n];
        //      Arrays.fill(dp, -1);
        //      int max = dfs(arr, 1, n-1, 1);
        //      Arrays.fill(dp, -1); // 不要忘了dp数组的重置与重新计算
        //      // return Math.max(dfs(arr, 1, n-1, 1), dfs(arr, 0, n-2, 0)); // BUG: 因为dp数组不重置，会发生数据混淆，得到错误答案
        //      return Math.max(max, dfs(arr, 0, n-2, 0));
        // }

        // private int dfs(int [] cnt, int i) {
        //     if (i >= N) return 0;
        //     if (dp[i] > 0) return dp[i];
        //     return dp[i] = Math.max(dfs(cnt, i+2) + cnt[i]*i, dfs(cnt, i+1));
        // }
        // int [] dp;
        // int N;
        // public int deleteAndEarn(int[] nums) {
        //     int n = nums.length, max = Arrays.stream(nums).max().getAsInt();
        //     N = max+1;
        //     int [] cnt = new int [N];
        //     for (Integer v : nums) 
        //         cnt[v]++;
        //     dp = new int [N];
        //     int i = 0;
        //     while (i < N && cnt[i] == 0) i++;
        //     return dfs(cnt, i);
        // }
        // public int deleteAndEarn(int[] nums) {
        //     int n = nums.length, N = 10001;
        //     int [] cnt = new int [N];
        //     for (Integer v : nums) 
        //         cnt[v] += v;
        //     int preOne = 0, preTwo = 0, ans = 0; // 相当于是滚动数组，把一维dp压缩为两个位置
        //     for (Integer v : cnt) {
        //         ans = Math.max(preOne, v + preTwo);
        //         preTwo = preOne;
        //         preOne = ans;
        //     }
        //     return ans;
        // }


        // public boolean canJump(int[] a) { // 几年前写的，居然看不懂了？！！！
        //     int f[] = new int[a.length];
        //     f[0] = 0;
        //     for (int i = 1; i < a.length; i++) {
        //         f[i] = Math.max(f[i - 1], a[i - 1]) - 1;
        //         if (f[i] < 0) return false;
        //     }
        //     return f[a.length - 1] >= 0;
        // }
       // public boolean canJump(int[] a) {
       //     int n = a.length, dist = a[0];
       //      for (int i = 1; i < n; i++) 
       //          if (i <= dist && i + a[i] > dist)
       //              dist = i + a[i];
       //      return dist >= n-1;
       //  }
        // public int jump(int[] arr) {
        //     int n = arr.length;
        //     if (n == 1) return 0;
        //     Queue<Integer> q = new LinkedList<>(); // idx
        //     q.offer(0);
        //     int cnt = 0;
        //     while (!q.isEmpty()) {
        //         for (int i = q.size()-1; i >= 0; i--) {
        //             int cur = q.poll();
        //             int l = q.isEmpty() ? cur + 1 : q.peek() + 1, r = Math.min(n-1, cur + arr[cur]);
        //             for (int j = r; j >= l; j--) {
        //                 if (j == n-1) return cnt + 1;
        //                 q.offer(j);
        //             }
        //         }
        //         cnt++;
        //     }
        //     return -1;
        // } 
        // public int jump(int[] arr) {  // O(N^2)
        //     int n = arr.length;
        //     if (n == 1) return 0;
        //     int [] dp = new int [n];
        //     Arrays.fill(dp, Integer.MAX_VALUE / 2);
        //     dp[0] = 0;
        //     for (int i = 1; i < n; i++) 
        //         for (int j = i-1; j >= 0; j--) 
        //             // if (dp[j] != Integer.MAX_VALUE && j + arr[j] >= i) { // I suppose this is the best answer
        //             if (j + arr[j] >= i) { // I suppose this is the best answer
        //                 dp[i] = Math.min(dp[i], dp[j] + 1);
        //             }
        //     return dp[n-1];
        // }
        // public int jump(int[] arr) { // 贪心算法
        //     int n = arr.length;
        //     int maxReach = 0, cnt = 0, end = 0;
        //     for (int i = 0; i < n-1; i++) { // i < n-1
        //         maxReach = Math.max(maxReach, i + arr[i]);
        //         if (i == end) {
        //             end = maxReach;
        //             cnt++;
        //         }
        //     }
        //     return cnt;
        // }


        
    }    
    public static void main(String[] args) {
        Solution s = new Solution();

        int [] a = new int [] {2,3,1,1,4};

        int  r = s.jump(a);
        System.out.println("r: " + r);
    }
}
