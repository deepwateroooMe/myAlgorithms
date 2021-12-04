// import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;

public class dynathreemicProgramming {
    public static class Solution {

        // private void helper (int [] arr, int k, ) {
        // }
        // double max = 0;
        // int n;
        // public double largestSumOfAverages(int[] nums, int k) {
        //     n = nums.length;
        //     max = 0;
        //     helper(nums, k );
        //     return max;
        // }


        // public long maxAlternatingSum(int[] arr) {
        //     int n = arr.length;
        //     if (n == 1) return arr[0];
        //     int i = 0;
        //     long res = 0;
        //     while (true) {
        //         while (i < n-1 && arr[i+1] > arr[i]) ++i;
        //         res += arr[i];
        //         if (i == n-1) return res;
        //         ++i;
        //         while (i < n-1 && arr[i+1] < arr[i]) ++i;
        //         if (i == n-1) return res;
        //         res -= arr[i];
        //         ++i;
        //     }
        // }


    // // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108870/most-consistent-ways-of-dealing-with-the-series-of-stock-problems
    // // http://bookshadow.com/weblog/2017/10/22/leetcode-best-time-to-buy-and-sell-stock-with-transaction-fee/
    // // https://blog.csdn.net/fuxuemingzhu/article/details/79888528
    // // https://www.cnblogs.com/grandyang/p/7776979.html
    //     public int maxProfit(int[] prices, int fee) {
    //         int n = prices.length;
    //         int [] sold = new int[n];
    //         int [] hold = new int[n];
    //         hold[0] = -prices[0];
    //         for (int i = 1; i < n; i++) {
    //             sold[i] = Math.max(sold[i-1], hold[i-1]+prices[i]-fee);
    //             hold[i] = Math.max(hold[i-1], sold[i-1]-prices[i]);
    //         }
    //         return sold[n-1];
    //     }

        // public int maxTurbulenceSize(int[] arr) {
        //     int n = arr.length;
        //     if (n == 1 ) return 1;
        //     if (n == 2) return arr[0] == arr[1] ? 1 : 2;
        //     int [] dp = new int [n];
        //     Arrays.fill(dp, 1);
        //     int max = 1;
        //     int i = 0;
        //     boolean valid = false;
        //     for (i = 1; i < n-1; i++) {
        //         if ((arr[i] > arr[i-1] && arr[i] > arr[i+1])
        //             || (arr[i] < arr[i-1] && arr[i] < arr[i+1])) {
        //             dp[i] = Math.max(dp[i], (!valid ? 2 : dp[i-1]+1));
        //             dp[i+1] = Math.max(dp[i+1], dp[i]+1);
        //             valid = true;
        //         } else valid = false;
        //         max = Math.max(max, dp[i]);
        //     }
        //     if ((arr[i] > arr[n-2] && arr[n-2] < arr[n-3]) 
        //         || (arr[i] < arr[n-2] && arr[n-2] > arr[n-3]))
        //         dp[i] = Math.max(dp[i], dp[i-1]+1);
        //     max = Math.max(max, dp[i]);
        //     if (max == 1) {
        //         if (Arrays.stream(arr).distinct().count() == 1) return 1;
        //         return 2;
        //     }
        //     return max;
        // }

        // public int longestArithSeqLength(int[] arr) {
        //     int n = arr.length;
        //     if (n <= 2) return n;
        //     int [] dp = new int [n];
        //     Arrays.fill(dp, 2);
        //     boolean gd = false;
        //     int diff = arr[1] - arr[0];
        //     for (int i = 2; i < n; i++) {
        //         if (arr[i] - arr[i-1] == diff) {
        //             dp[i] = Math.max(dp[i], (!gd ? 3 : dp[i-1]+1));
        //             gd = true;
        //         } else {
        //             gd = false;
        //             diff = arr[i] - arr[i-1];
        //         }
        //     }
        // }


        // private int getMax(int [][] arr, int x, int y) {
        //     if (u[x][y] == 0 || d[x][y] == 0 || l[x][y] == 0 || r[x][y] == 0) return arr[x][y];
        //     int i = 0, j = 0, a = 0, b = 0;
        //     i = x;
        //     while (i >= 0 && u[i][y] > 0) --i;
        //     j = x;
        //     while (j < n && d[j][y] > 0) ++j;
        //     a = y;
        //     while (a >= 0 && l[a][y] > 0) --a;
        //     b = y;
        //     while (b < n && r[b][y] > 0) ++b;
        //     return (j-i-(i == 0 ? (j < m ? -1 : 0) : (j < m ? -1 : 1)))*(b-a-(a == 0 ? (b < n ? -1 : 0) : (b < n ? -1 : 1)));
        // }
        // int [][] u;
        // int [][] d;
        // int [][] l;
        // int [][] r;
        // int m, n;
        // public int largest1BorderedSquare(int[][] arr) {
        //     m = arr.length;
        //     n = arr[0].length;
        //     if (m == 1 || n == 1) {
        //         if (m == 1 && n == 1) return arr[0][0];
        //         if (m == 1) {
        //             for (int v : arr[0]) 
        //                 if (v == 1) return 1;
        //             return 0;
        //         }
        //         for (int j = 0; j < n; j++) 
        //             if (arr[j][0] == 1) return 1;
        //         return 0;
        //     }
        //     u = new int[m][n];
        //     d = new int[m][n];
        //     l = new int[m][n];
        //     r = new int[m][n];
        //     int cnt = 0;
        //     for (int i = 0; i < m; i++) {
        //         for (int j = 0; j < n; j++) {
        //             u[i][j] = (i > 0 ? u[i-1][j] + arr[i-1][j] : 0);
        //             l[i][j] = (j > 0 ? l[i][j-1] + arr[i][j-1] : 0);
        //             r[i][n-1-j] = (n-1-j < n-1 ? r[i][n-1-j+1]+arr[i][n-1-j+1] : 0);
        //             d[m-1-i][j] = (m-1-i < m-1 ? d[m-1-i+1][j]+arr[m-1-i+1][j] : 0);
        //             if (arr[i][j] == 1) ++cnt;
        //         }
        //     }
        //     if (cnt == m*n) return m*n;
        //     int max = 0, tmp = 0;
        //     for (int i = 0; i < m; i++) {
        //         for (int j = 0; j < n; j++) {
        //             tmp = getMax(arr, i, j);
        //             max = Math.max(max, tmp);
        //         }
        //     }
        //     return max;
        // }
        // public int largest1BorderedSquare(int[][] arr) {
        //     int m = arr.length;
        //     int n = arr[0].length;
        //     if (m == 0) return 0;
        //     int min = 0, num = 0;
        //     // 保存每个元素左上连续为 1 的个数。 0 代表左边，1 代表上边，比数组长度多1是为了方便循环计算。
        //     int[][][] dp = new int[m + 1][n + 1][2]; // 0 : left; 1: up
        //     for (int i = 1; i <= m; i++) {
        //         for (int j = 1; j <= n; j++) {
        //             // 如果当前元素为 1 ，dp记录其左、上元素连续为 1 的个数。否则计为0
        //             if (arr[i-1][j-1] == 1){
        //                 dp[i][j][0] = dp[i][j-1][0] + 1;
        //                 dp[i][j][1] = dp[i-1][j][1] + 1;
        //                 // 得到左、上中的小者
        //                 min = Math.min(dp[i][j][0], dp[i][j][1]);
        //                 // 左下顶点的上边、右上顶点的左边 连续 1 的个数，取小者（正方形）
        //                 while (dp[i][j-min+1][1] < min || dp[i-min+1][j][0] < min){
        //                     min--;
        //                 }
        //                 num = Math.max(num, min);
        //             }
        //         }
        //     }
        //     return num*num;
        // }


        // public int maxProfit(int[] prices, int fee) {
        //     int n = prices.length;
        //     int [] sold = new int[n];
        //     int [] hold = new int[n];
        //     hold[0] = -prices[0];
        //     for (int i = 1; i < n; i++) {
        //         sold[i] = Math.max(sold[i-1], hold[i-1]+prices[i]-fee);
        //         hold[i] = Math.max(hold[i-1], sold[i-1]-prices[i]);
        //     }
        //     return sold[n-1];
        // }

        // private double getmax(int [] arr, int k, int idx) {
        //     if (idx == n) return 0;
        //     if (k >= 1 && idx == n-k) return (double)(pre[n-1]-pre[n-k-1]);
        //     if (k == 1) return (double)((pre[n-1]-(idx > 0 ? pre[idx-1] : 0))/(n-idx));
        //     double max = 0;
        //     for (int i = n-k; i >= idx; i--) {
        //         max = Math.max(max, (double)((pre[i] - (idx > 0 ? pre[idx-1] : 0))/((double)(i-idx+1))) + getmax(arr, k-1, i+1));
        //         dp[i] = max;
        //     }
        //     return max;
        // }
        // double [] dp;
        // int [] pre;
        // int n;
        // public double largestSumOfAverages(int[] arr, int k) {
        //     n = arr.length;
        //     pre = new int[n];
        //     pre[0] = arr[0];
        //     for (int i = 1; i < n; i++) 
        //         pre[i] = pre[i-1] + arr[i];
        //     if (k == 1) return (double)(pre[n-1]/n);
        //     if (k == n) return pre[n-1];
        //     dp = new double[n];
        //    double max = 0;
        //     for (int i = k; i >= 1; i--) 
        //         max = Math.max(max, getmax(arr, i, 0));
        //     return getmax(arr, k, 0); // 自己写的，答案不对！！
        // }
        // public double largestSumOfAverages(int[] arr, int k) {
        //     int n = arr.length;
        //     int [] pre = new int[n+1];
        //     for (int i = 1; i <= n; i++) 
        //         pre[i] = pre[i-1] + arr[i-1];
        //     double [][] dp = new double[n][k];
        //     for (int i = 0; i < n; i++) 
        //         dp[i][0] = (double)((pre[n] - pre[i])/ (double)(n-i));
        //     for (int d = 1; d < k; d++) {
        //         for (int i = 0; i < n-1; i++) {
        //             for (int j = i+1; j < n; j++) { // [i, j), include i, not including j
        //                 dp[i][d] = Math.max(dp[i][d], dp[j][d-1]+(double)((pre[j]-pre[i])/(double)(j-i)));
        //             }
        //         }
        //     }
        //     return dp[0][k-1];
        // }


        // public int waysToMakeFair(int[] arr) {
        //     int n = arr.length;
        //     int [] en = new int[n];
        //     int [] od = new int [n];
        //     for (int i = 0; i < n; i++) {
        //         if (i % 2 == 0) {
        //             if (i == 0) en[i] = arr[i];
        //             else en[i] = arr[i] + en[i-1];
        //             if (i == 0) od[i] = 0;
        //             else od[i] = od[i-1];
        //         } else {
        //             en[i] = en[i-1];
        //             if (i == 1) od[i] = arr[i];
        //             else od[i] = od[i-1]+arr[i];
        //         }
        //     }
        //     List<Integer> l = new ArrayList<>();
        //     for (int i = 0; i < n; i++) {
        //         if (i == 0 || i == n-1) {
        //             if (i % 2 == 0 && en[n-1]-arr[i] == od[n-1]) l.add(i);
        //             else if (i % 2 == 1 && od[n-1] - arr[i] == en[n-1]) l.add(i);
        //             continue;
        //         }
        //         if (i % 2 == 0) {
        //             if (en[i] - arr[i] + od[n-1] - od[i] == od[i] + en[n-1] - en[i]) l.add(i);
        //         } else {
        //             if (od[n-1] - od[i] + en[i] == od[i] - arr[i] + en[n-1]-en[i]) l.add(i);
        //         }
        //     }
        //     return l.size();
        // }

        // private int cntOnes(int v) {
        //     if (v == 0) return 0;
        //     int cnt = 0, tmp = 0;
        //     while (v >= 1){
        //         if ((v & 1) == 1) ++cnt;
        //         v >>= 1;
        //     }
        //     return cnt;
        // }
        // public int[] countBits(int n) {
        //     int [] ans = new int [n+1];
        //     for (int i = 1; i <= n; i++) 
        //         ans[i] = cntOnes(i);
        //     return ans;
        // }


        // public int wiggleMaxLength(int[] arr) {
        //     int n = arr.length;
        //     if (n == 1) return 1;
        //     if (n == 2) return arr[0] != arr[1] ? 2 : 1;
        //     int j = 0, cnt = 1;
        //     boolean up = (arr[0] < arr[1] ? true : false);
        //     boolean dn = (arr[0] > arr[1] ? true : false);
        //     boolean flat = (arr[0] == arr[1] ? true : false);
        //     for (int i = 1; i < n; i++) {
        //         if (arr[i] > arr[i-1] && (dn || i == 1)) {
        //             ++cnt;
        //             dn = false;
        //             up = true;
        //         } else if (arr[i] < arr[i-1] && (up || i ==1)) {
        //             ++cnt;
        //             dn = true;
        //             up = false;
        //         } else if (arr[i] == arr[i-1] && flat) {
        //             j = i;
        //             while (j < n-1 && arr[j] == arr[j+1]) ++j;
        //             if (j == n-1) return cnt;
        //             if (arr[j+1] > arr[j]) {
        //                 dn = true;
        //                 up = false;
        //             } else {
        //                 up = true;
        //                 dn = false;
        //             }
        //             continue;
        //         } else if (arr[i] >= arr[i-1] && up) {
        //             j = i;
        //             while (j < n-1 && arr[j] <= arr[j+1]) ++j;
        //             i = j;
        //             if (j == n-1) return cnt;
        //         } else if (arr[i] <= arr[i-1] && dn) {
        //             j = i;
        //             while (j < n-1 && arr[j] >= arr[j+1]) ++j;
        //             i = j;
        //             if (j == n-1) return cnt;
        //         }
        //     }
        //     return cnt;
        // }


        // public int maximalSquare(char[][] matrix) {
        //     int m = matrix.length;
        //     int n = matrix[0].length;
        //     int [][][] dp = new int[m][n][2]; // 3rd: 0 <-- cnt of 1s to left, 1 ^| cnt of 1s to up
        //     int maxSide = 0, res = 0, tmp = 0;
        //     boolean hasOne = false;
        //     for (int i = 0; i < m; i++) {
        //         for (int j = 0; j < n; j++) {
        //             if (matrix[i][j] == '1') {
        //                 if (!hasOne) hasOne = true;
        //                 dp[i][j][0] = (j == 0 ? 1 : 1 + dp[i][j-1][0]);
        //                 dp[i][j][1] = (i == 0 ? 1 : 1 + dp[i-1][j][1]);
        //             }
        //         }
        //     }
        //     for (int i = 0; i < m; i++) {
        //         for (int j = 0; j < n; j++) {
        //             if (matrix[i][j] == '1') {
        //                 maxSide = Math.min(dp[i][j][0], dp[i][j][1]);
        //                 tmp = 1;
        //                 while (tmp <= maxSide && dp[i][j-tmp+1][1] >= tmp && dp[i-tmp+1][j][0] >= tmp) ++tmp;
        //                 res = Math.max(res, tmp-1);
        //             }
        //         } 
        //     }
        //     return res == 0 ? (hasOne ? 1 : 0) : res * res;
        // }


        // public int numOfSubarrays(int[] arr) {
        //     int n = arr.length;
        //     int [] pre = new int[n+1];
        //     int od = 0;
        //     int en = 0;
        //     long cnt = 0;
        //     for (int i = 0; i < n; i++) {
        //         pre[i+1] = arr[i] + pre[i];
        //         if (pre[i+1] % 2 == 1) ++cnt;
        //     }
        //     for (int i = 1; i <= n; i++) {
        //         if (pre[i] % 2 == 1) {
        //             ++od;
        //             cnt += en;
        //         } else {
        //             ++en;
        //             cnt += od;
        //         }
        //     }
        //     return (int)(cnt % 1000000007);
        // }
        // public int numOfSubarrays(int[] arr) {
        //     int oddNum = 0, evenNum = 0; // 奇数前缀和个数，偶数前缀和个数
        //     int preSum = 0; // 前缀和
        //     long res = 0;   // 返回结果
        //     for (int num : arr){ // 循环每个数
        //         preSum += num;   // 计算前缀和
        //         if (preSum % 2 == 0){ // 前缀和是偶数
        //             evenNum++;        // 偶数前缀和个数加一
        //             res += oddNum; // 将奇数前缀和个数累加至返回结果
        //         } else { // 前缀和是奇数
        //             oddNum++; // 奇数前缀和个数加一
        //             res++; // 返回结果加一（当前前缀区间）
        //             res += evenNum; // 将偶数前缀和个数累加至返回结果
        //         }
        //         res %= 1000000007;
        //     }
        //     return (int)res;
        // }

        // public int maxRotateFunction(int[] nums) {
        //     int n = nums.length;
        //     int sum = 0;
        //     for (int i = 0; i < n; i++) 
        //         sum += nums[i];
        //     int max = Integer.MIN_VALUE;
        //     int cur = 0;
        //     int pre = 0;
        //     // 那么我们就找到规律了, F(i) = F(i-1) + sum - n * A[n-i]，是个递推公式
        //     for (int i = 0; i < n; i++) {
        //         if (i == 0) {
        //             for (int j = 0; j < n; j++) 
        //                 cur += j * nums[j];
        //         } else 
        //             cur = pre + sum - n * nums[n-i];
        //         max = Math.max(max, cur);
        //         pre = cur;
        //     }
        //     return max;
        // }


        // public int getMaxLen(int[] arr) {
        //     int n = arr.length;
        //     if (n == 1) return arr[0] > 0 ? 1 : 0;
        //     int i = 0, j = n-1;
        //     while (i < n && arr[i] == 0) ++i;
        //     while (j >= 0 && arr[j] == 0) --j;
        //     int max = 0;
        //     int bgn = i, ngcnt = 0, idx = 0;
        //     while (i < j) {
        //         while (i <= j && arr[i] != 0) {
        //             if (arr[i] < 0) ++ngcnt;
        //             ++i;
        //         }
        //         if (ngcnt % 2 == 0) max = Math.max(max, i-bgn);
        //         else {
        //             idx = bgn;
        //             while (arr[idx] > 0) ++idx;
        //             max = Math.max(max, i-idx-1);
        //             idx = i-1;
        //             while (idx >= 0 && arr[idx] > 0) --idx;
        //             max = Math.max(max, idx-bgn);
        //         }
        //         if (i == j+1) return max;
        //         ++i;
        //         bgn = i;
        //         ngcnt = 0;
        //     }
        //     max = Math.max(max, i-bgn);
        //     return max;
        // }

        
        // int min = Integer.MAX_VALUE;
        // private void helper(long v, int cnt) {
        //     if (v == 1) {
        //         if (cnt < min) min = cnt;
        //         return;
        //     }
        //     if (cnt > min) return;
        //     if (v % 2 == 0) helper(v/2, cnt+1);
        //     else {
        //         helper(v+1, cnt+1);
        //         helper(v-1, cnt+1);
        //     }
        // }
        // public int integerReplacement(int n) {
        //     if (n == 1) return 0;
        //     if (n == 2) return 1;
        //     min = Integer.MAX_VALUE;
        //     helper(n, 0);
        //     return min;
        // }

        // // 如果是普通的DP方法，那么使用二维dp[i][j]表示子数组的起始和结束区间，能做到O(n^2)的时间复杂度，但是题目对时间复杂度要求的很死，必须O(N).
        // // 正确的做法也是动态规划，dp[i]表示以A[i]结尾的所有子数组的异或结果，其实是个set。
        // // 转移方程式: 
        // // dp[i] = [b | A[i] for b in dp[i - 1]] + A[i]，
        // //     即以A[i]结尾的所有子数组异或结果等于以A[i-1]结尾的所有子数组异或结果，和当前的A[i]异或，再加上A[i]这个结果。
        // //     同时使用一个set保存所有的异或结果。最后返回这个结果set的长度。
        // public int subarrayBitwiseORs(int[] arr) {
        //     int n = arr.length;
        //     int j = 0, cur = 0;
        //     Set<Integer> sg = new HashSet<>(); // set of global
        //     List<Set<Integer>> ls = new ArrayList<>();
        //     for (int i = 0; i < n; i++) 
        //         ls.add(new HashSet<>());
        //     ls.get(0).add(arr[0]);
        //     sg.add(arr[0]);
        //     for (int i = 1; i < n; i++) {
        //         for (Integer v : ls.get(i-1)) {
        //             ls.get(i).add(v | arr[i]);
        //             sg.add(v | arr[i]);
        //         }
        //         ls.get(i).add(arr[i]);
        //         sg.add(arr[i]);
        //     }
        //     return sg.size();
        // }
        // public int subarrayBitwiseORs(int[] arr) { // 这个方法写得好仙幻啊，看不懂呀看不懂～！！！
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


        // private void help(int [][] arr, int i, int j) {
        //     if (i == m-1 && j == n-1) {
        //         max[i][j] = (long)arr[i][j];
        //         min[i][j] = (long)arr[i][j];
        //         return;
        //     }
        //     if (max[i][j] != 0) return; // 当前点已经递归过
        //     max[i][j] = Integer.MIN_VALUE;
        //     min[i][j] = Integer.MAX_VALUE;
        //     if (i+1 < m) {
        //         help(arr, i+1, j);
        //         max[i][j] = Math.max(max[i+1][j]*arr[i][j], max[i][j]);
        //         max[i][j] = Math.max(min[i+1][j]*arr[i][j], max[i][j]);
        //         min[i][j] = Math.min(min[i][j], max[i+1][j]*arr[i][j]);
        //         min[i][j] = Math.min(min[i][j], min[i+1][j]*arr[i][j]);
        //     }
        //     if (j+1 < n) {
        //         help(arr, i, j+1);
        //         max[i][j] = Math.max(max[i][j], max[i][j+1]*arr[i][j]);
        //         max[i][j] = Math.max(max[i][j], min[i][j+1]*arr[i][j]);
        //         min[i][j] = Math.min(min[i][j], max[i][j+1]*arr[i][j]);
        //         min[i][j] = Math.min(min[i][j], min[i][j+1]*arr[i][j]);
        //     }
        // }
        // long [][] max;
        // long [][] min;
        // int m, n;
        // public int maxProductPath(int[][] grid) {
        //     m = grid.length;
        //     n = grid[0].length;
        //     max = new long[m][n];
        //     min = new long[m][n];
        //     help(grid, 0, 0);
        //     if (max[0][0] < 0) return -1;
        //     return (int)(max[0][0] % 1000000007);
        // }


        // public int maxSubArray(int[] nums) { // 普通非环形的最大子序列和
        //     int max = nums[0], locMax = nums[0]; // local vs global
        //     for (int i = 1; i < nums.length; i++) {
        //         locMax = Math.max(locMax + nums[i], nums[i]);
        //         max = Math.max(max, locMax);
        //     }
        //     return max;
        // }
        // public int maxSubarraySumCircular(int[] nums) {
        //     int n = nums.length; // 这是自己随便写的，不对，也没再深想
        //     int rand = n/2;
        //     int max = nums[rand], lmax = nums[rand];
        //     for (int i = 1; i <= n; i++) {
        //         lmax = Math.max(nums[(i+rand) % n], lmax + nums[(i+rand) % n]);
        //         max = Math.max(max, lmax);
        //     }
        //     return max;
        // }
        // public int maxSubarraySumCircular(int[] arr) {
        //     int n = nums.length;
        //     int sum = 0;
        //     int max = Integer.MIN_VALUE, lmax = 0;
        //     int min = Integer.MAX_VALUE, lmin = 0;
        //     for (int v : arr) {
        //         lmax = Math.max(lmax + v, v);
        //         max = Math.max(max, lmax);
        //         lmin = Math.min(lmin + v, v);
        //         min = Math.min(min, lmin);
        //         sum += v;
        //     }
        //     return max > 0 ? Math.max(max, sum - min) : max;
        // }


        // // 这个题感觉稀里糊涂，改天再好好学习一下别人的写法
        // public List<Integer> largestDivisibleSubset(int[] nums) {
        //     int n = nums.length;
        //     List<Integer> l = new ArrayList<>();
        //     List<Integer> res = new ArrayList<>();
        //     if (n == 1) {
        //         l.add(nums[0]);
        //         return l;
        //     }
        //     Arrays.sort(nums);
        //     int j = 0;
        //     for (int i = 1; i < n; i++) {
        //         j = i-1;
        //         while (j >= 0) {
        //             l.clear();
        //             if (nums[i] % nums[j] == 0) {
        //                 l.add(nums[j]);
        //                 l.add(nums[i]);
        //                 List<Integer> li = new ArrayList<>(l);
        //                 int v = nums[j];
        //                 for (int k = j-1; k >= 0; k--) {
        //                     if (v % nums[k] == 0) {
        //                         while (k >= 0 && v % nums[k] == 0) {
        //                             li.add(0, nums[k]);
        //                             v = nums[k];
        //                             --k;
        //                         }
        //                     }
        //                     if (li.size() > res.size()) res = new ArrayList<>(li);
        //                 }
        //                 v = nums[i];
        //                 for (int k = i+1; k < n; k++) {
        //                     if (nums[k] % v == 0) {
        //                         while (k < n && nums[k] % v == 0) {
        //                             li.add(nums[k]);
        //                             v = nums[k];
        //                             ++k;
        //                         }
        //                         if (li.size() > res.size()) res = new ArrayList<>(li);
        //                     }
        //                 }
        //                 if (l.size() > res.size()) res = new ArrayList<>(l);
        //             }
        //             --j;
        //         }
        //     }
        //     if (res.size() == 0) {
        //         l.add(nums[0]);
        //         return l;
        //     }
        //     return res;
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
        //     int [] maxBgnHere = new int [n];
        //     int [] maxEndHere = new int [n];
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
        // 解法1：动态规划。跟 53. Maximum Subarray 比，多了一个变量，用来记录delete一个元素后的subarray最大值。题目中说删除一个元素是optional的，最终的结果在删除的最大值与不删除的最大值中出。思路比较曲折一点
        // public int maximumSum(int[] arr) {
        //     int sum = arr[0], sumWithDeletion = 0, ans = arr[0];
        //     for(int i = 1; i < arr.size(); ++i){
        //         ans = max(ans, sumWithDeletion + arr[i]);
        //         sumWithDeletion = max(sumWithDeletion + arr[i], sum);
        //         sum = sum < 0 ? 0 : sum;
        //         sum += arr[i];
        //         ans = max(ans, sum);
        //     }
        //     return ans;
        // }

        
//         先考虑这个最大连续区间和会出现在什么地方？
//         - 单独数组的中间部分
//         - 数组头 + 数组尾
//         - 数组尾 + (k – 2) * 数组和 + 数组头
//         分别举例来说明一下：
//         arr = [-100, 5, -100] // 单独数组的中间部分为最大值
// // [-100, 5, -100, -100, 5, -100, -100, 5, -100, ......]
// // 即使将数组重复N次，连续区间最大和都是5。
//         arr = [1, -100, 5] // 数组头 + 数组尾为最大值
// // [1, -100, 5, 1, -100, 5, 1, -100, 5, ......]
// // 连续区间最大和为5+1=6。
//         arr = [-2, 1, 5] // 数组尾 + (k - 2) * 数组和 + 数组头为最大值
// // [-2, 1, 5, -2, 1, 5, -2, 1, 5, ......, -2, 1, 5]
// // 此时数组尾是 1 + 5 = 6，数组头是 -2 + 1 + 5 = 4
// // 中间部分是(k - 2) * 数组和
        // public int kConcatenationMaxSum(int[] arr, int k) {
        //     int n = arr.length;
        //     long presum = 0;
        //     long maxPresum = 0;
        //     long endsum = 0;
        //     long maxEndsum = 0;
        //     long subsum = 0;
        //     long maxSubsum = 0;
        //     for (int i = 0; i < n; i++) {
        //         presum += arr[i];
        //         maxPresum = Math.max(maxPresum, presum);
        //         endsum += arr[n-1-i];
        //         maxEndsum = Math.max(maxEndsum, endsum);
        //         if (subsum < 0) subsum = arr[i];
        //         else subsum += arr[i];
        //         maxSubsum = Math.max(maxSubsum, subsum);
        //     }
        //     if (k == 1) return (int)(maxSubsum % 1000000007);
        //     int max1 = (int)(maxSubsum % 1000000007);
        //     int max2 = (int)((maxPresum + maxEndsum) % 1000000007);
        //     int max3 = (int) ((maxPresum + maxEndsum + presum*(k-2)%1000000007)%1000000007);
        //     return Math.max(Math.max(max1, max2), max3);
        // }
        // 例子1中数组全是正数，则最大和的子数组就是其本身，那么重复几次，就要都加上，就是原数组所有数字之和再乘以k。
        // 例子2中由于有负数存在，所以最大和只是某个子数组，这里就是单独的一个1，但是一旦可以重复了，那么首尾的1就可以连在一起，形成一个和为2的子数组了，但也不是连的越多越好，只有有首尾相连才可能使得正数相连，所以最多连2个就行了，因为这里整个数组之和为0，连再多跟没连一样。
        // 但如果把数组变为 [1,-2,2] 的话，那就不一样了，虽然说两个为 [1,-2,2,1,-2,2] 的最大子数组之和为3，但是由于原数组之和为1，只要尽可能多的连，就可以得到更大的值，所以这种情况也要考虑到。
        // 例子3中数组全是负数，则不管重复多少次，还是取空数组和为0。
        // 通过分析也大概可以得出解题思路了，就是根据k的大小，
        // - 若等于1，则对原数组用 Kadane 算法，
        // - 若大于1，则只拼接一个数组，那么这里就可以用 min(k, 2) 来合并这两种情况，不过在取数的时候，要用 arr[i % n] 来避免越界，这样就可以得到最大子数组之和了
        // - 对于 k 大于2的情况，还是要把减去2剩余的次数乘以整个数组之和的值加上，再一起比较，这样最终的结果就是三者之中的最大值了
        // public int kConcatenationMaxSum(int[] arr, int k) {
        //     int n = arr.length;
        //     int res = Integer.MIN_VALUE;
        //     int curSum = 0;
        //     int M = 1000000007;
        //     long sum = 0;
        //     for (int v : arr) sum += v;
        //     for (int i = 0; i < n*Math.min(k, 2); i++) {
        //         curSum = Math.max(curSum + arr[i % n], arr[i%n]);
        //         res = Math.max(res, curSum);
        //     }
        //     return (int)(Math.max(Math.max(0, res), sum*Math.max(0, k-2)+res) % M);
        // }


        // 首先我们对矩阵进行数据初始化。即求出每一行以及每一列上的前缀和。
        // 遍历矩阵每一个点（两层循环），并以该点最为起点（row, col），向右下方向画矩形（两层循环，分别循环矩形的宽width和高height），注意矩形范围不能越界。起始时width和height分别为0，即当前点自身是一个矩形。
        // 当width扩大一格后，实际上是增加了(row, col+width)到(row+height, col+width)这一部分的面积（宽为1，高为height），我们通过前缀和数组求出该区域和是否等于height，如果等于，返回结果加一即可。
        // height扩大一格的操作同理。
/*        public int numSubmat(int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;
            int [][] preRow = new int [m][n]; // 每一行的前缀和
            int [][] preCol = new int [n][m]; // 每一列的前缀和
            for (int i = 0; i < m; i++) 
                for (int j = 0; j < n; j++) 
                    if (j == 0) preRow[i][j] = mat[i][j];
                    else preRow[i][j] = preRow[i][j-1] + mat[i][j]; 
            for (int j = 0; j < n; j++) 
                for (int i = 0; i < m; i++)
                    if (i == 0) preCol[j][i] = mat[i][j];           // 这里的写法好tricky
                    else preCol[j][i] = preCol[j][i-1] + mat[i][j]; // 这里的写法好tricky
            int res = 0;
            int row = 0, col = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {

                    for (int r = 0; i+r < m; r++) {    // 以当前点为顶点，向下扩大一格
                        for (int c = 0; j+c < n; c++) {// 以当前点为顶点，向右扩大一格
                            row = i + r;
                            col = j + c;
                            // 通过前缀和数组求出新增区域面积，如果该面积与新增面积相同，代表区域内都是1
                            if ((j == 0 && preRow[row][col] == c+1 || j > 0 && preRow[row][col]-preRow[row][j-1] == c+1)
                                && (i == 0 && preCol[col][row] == r+1 || i > 0 && preCol[col][row] - preCol[col][i-1] == r+1))
                                // && (r == 0 && preCol[row][col] == r+1 || r > 0 && preCol[row][col]-preCol[r-1][col] == r+1))
                                res++;
                            else break;
                        }
                    }
                }
            }
            return res;
        }  */
//     https://blog.csdn.net/qq_46105170/article/details/108935687
// 位运算。本质上是枚举矩阵宽度。对于A [ i ] [ j ] A[i][j]A[i][j]，我们看一下其与其右边最多能延伸出多少个1 11，如果能延伸出x xx个1 11，那么显然长宽都为1 11的1 11子矩阵数量就是1 + 2 + . . . + x = ( 1 + x ) x 2 1+2+...+x=\frac{(1+x)x}{2}1+2+...+x= x*(x+1)/2 个。
// 如果我们令A [ i ] [ j ] A[i][j]A[i][j]都按位与一下A [ i + 1 ] [ j ] A[i+1][j]A[i+1][j]，那么此时的A [ i ] [ j ] A[i][j]A[i][j]就代表了原先矩阵A [ i : i + 1 ] [ j ] A[i:i+1][j]A[i:i+1][j]是否都是1 11，这样如果改变后的矩阵从A [ i ] [ j ] A[i][j]A[i][j]能向右延伸出x xx个1 11，就说明以A [ i ] [ j ] A[i][j]A[i][j]为左上角的宽度为2 22的矩形的最大长度是x xx，那么宽为2 22的1 11子矩阵数量就是1 + 2 + . . . + x = ( 1 + x ) x 2 1+2+...+x=\frac{(1+x)x}{2}1+2+...+x= 个。这样就能枚举出以A [ i ] [ j ] A[i][j]A[i][j]为左上角的所有1 11矩阵的数量了。
        // public int numSubmat(int[][] mat) {
        //     int m = mat.length;
        //     int n = mat[0].length;
        //     int res = 0;
        //     // 计算宽度为 m-i 的mat[j][k]为左上角的1矩阵的数量
        //     for (int i = m-1; i >= 0; i--) {
        //         for (int j = 0; j <= i; j++) {
        //             int width = 0;
        //             for (int k = 0; k < n; k++) {
        //                 if (mat[j][k] == 1) width++;
        //                 else width = 0;
        //                 res += width; // 累加1 矩阵的数量
        //                 if (j < i)    // 算完了，就向下做 按位与 位操作！！！
        //                     mat[j][k] &= mat[j+1][k];
        //             }
        //         }
        //     }
        //     return res;
        // }

        // public long maxPoints(int[][] points) {// 这是自己想出来的最为原始的暴力DP，时间空间复杂度都。。。。。。
        //     int m = points.length;
        //     int n = points[0].length;
        //     long max = Long.MIN_VALUE;
        //     if (m == 1 && n == 1) return points[0][0];
        //     long [][] dp = new long [m][n];
        //     for (int i = 0; i < n; i++) {
        //         dp[0][i] = points[0][i];
        //         max = Math.max(max, dp[0][i]);
        //     }
        //     if (m == 1) return max;
        //     for (int i = 1; i < m; i++) {
        // 在进行dp[j]的状态转移时，需要发生O(n²)次的计算(原来自己的暴力解法)
        //         for (int j = 0; j < n; j++) {
        //             for (int k = 0; k < n; k++) 
        //                 dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + points[i][j] - Math.abs(k-j));
        //             if (i == m-1)
        //                 max = Math.max(max, dp[i][j]);
        //         }
        //     }
        //     return max;
        // }
        // 为简化每个格子最高分数的求解，可进一步结合动态规划方法，预处理计算各个位置选取上一行的左、右侧格子所能得到的最高分。
        // public long maxPoints(int[][] points) { 
        //     int m = points.length;
        //     int n = points[0].length;
        //     if (m == 1 && n == 1) return points[0][0];
        //     long [] dp = new long [n]; // 表示当前行第i 个格子的最大得分
        //     long [] lastline = new long [n];
        //     long [] left = new long [n];
        //     long [] right = new long [n];
        //     for (int i = 0; i < n; i++) 
        //         dp[i] = points[0][i];
        //     for (int i = 1; i < m; i++) {
        //         System.arraycopy(dp, 0, lastline, 0, n); // 复制得到上一行各个格子的最大得分
        //         Arrays.fill(left, 0);
        //         Arrays.fill(right, 0);
        //         // 在进行dp[j]的状态转移时，需要发生O(n²)次的计算(原来自己的暴力解法)
        //         // 预处理计算各个位置选取上一行左右侧格子所能得到的最高分 为简化代码，当前正上格子统计在左侧中
        //         // 这个左右侧的预处理可以提速：处理一行由O(n^2)优化成为O(n)，左右两次遍历而已
        //         // 可使用加权前缀和 和 加权后缀和进行优化，将时间复杂度优化至：O(n)
        //         left[0] = lastline[0]; 
        //         for (int j = 1; j < n; j++) 
        //             left[j] = Math.max(left[j-1]-1, lastline[j]);
        //         right[n-1] = 0;
        //         for (int j = n-2; j >= 0; j--) 
        //             right[j] = Math.max(right[j+1]-1, lastline[j+1]-1);
        //         for (int j = 0; j < n; j++) { // 
        //             dp[j] = Math.max(left[j], right[j]) + points[i][j];
        //         }
        //     }
        //     long max = Long.MIN_VALUE;
        //     for (int i = 0; i < n; i++) 
        //         max = Math.max(max, dp[i]);
        //     return max;
        // }

        
        // private int getDp(int [][][] arr, int t, int x, int xi) {
        //     if (x < 0 || xi < 0 || t-x < 0 || t-xi < 0) return -1;
        //     return arr[t][x][xi];
        // }
        // public int cherryPickup(int[][] grid) { // 时间复杂度:  O(N^3) 空间复杂度: O(N^3)
        //     int n  = grid.length;
        //     int count = 2 * n-1;
        //     int [][][] dp = new int [count][n][n]; // count, x1, x2
        //     int x = 0, y = 0, xi = 0, yi = 0;
        //     for (int t = 0; t < count; t++) {
        //         for (int i = 0; i < n; i++) {
        //             for (int j = 0; j < n; j++) { // x, y, xi, yi
        //                 x = i;
        //                 y = t - x;
        //                 xi = j;
        //                 yi = t - xi;
        //                 if (x < 0 || y < 0 || xi >= n || yi >= n) continue;
        //                 if (xi < 0 || yi < 0 || x >= n || y >= n) continue;
        //                 if (grid[x][y] == -1 || grid[xi][yi] == -1) {
        //                     dp[t][x][xi] = -1;
        //                     continue;
        //                 }
        //                 int pre = 0, pi = 0, pii = 0;
        //                 if (t > 0) {
        //                     pi = Math.max(getDp(dp, t-1, x-1, xi), getDp(dp, t-1, x-1, xi-1));
        //                     pii = Math.max(getDp(dp, t-1, x, xi), getDp(dp, t-1, x, xi-1));
        //                     pre = Math.max(pi, pii);
        //                     if (pre < 0) {
        //                         dp[t][x][xi] = -1;
        //                         continue;
        //                     }
        //                 }
        //                 dp[t][x][xi] = pre + grid[x][y]; // 如果重复，只加一遍，对应返回时走了来时的格子
        //                 if (x != xi)
        //                     dp[t][x][xi] += grid[xi][yi]; // 两点不同，才同时加两个点
        //             }
        //         }
        //     }
        //     return Math.max(0, dp[count-1][n-1][n-1]);
        // }
        // public int cherryPickup(int[][] grid) { // 时间复杂度:  O(N^3) 空间复杂度: O(N^3)
        //     int n  = grid.length;
        //     if (grid == null || n == 0 || grid[0].length == 0) return 0;
        //     int [][][] dp = new int [n+1][n+1][n+1];
        //     for (int i = 0; i <= n; i++) 
        //         for (int j = 0; j <= n; j++) 
        //             Arrays.fill(dp[i][j], -1);
        //     dp[1][1][1] = grid[0][0];
        //     int y = 0, max = 0, m = 0, mi = 0;
        //     for (int i = 1; i <= n; i++) {
        //         for (int j = 1; j <= n; j++) {
        //             for (int x = 1; x <= n; x++) {
        //                 y = i + j - x;
        //                 if (dp[i][j][x] >= 0 || y < 1 || y > n || grid[i-1][j-1] < 0 || grid[x-1][y-1] < 0) continue;
        //                 m = Math.max(dp[i-1][j][x], dp[i][j-1][x]);      // (i-1, j, x, y-1), (i, j-1, x, y-1)
        //                 mi = Math.max(dp[i-1][j][x-1], dp[i][j-1][x-1]); // (i-1, j, x-1, y), (i, j-1, x-1, y)
        //                 max = Math.max(m, mi);
        //                 if (max == -1) continue;
        //                 dp[i][j][x] = max + grid[i-1][j-1];
        //                 if (x != i) dp[i][j][x] += grid[x-1][y-1];
        //             }
        //         }
        //     }
        //     return Math.max(0, dp[n][n][n]);
        // }

        
        // public int cherryPickup(int[][] grid) {
        //     int m = grid.length;
        //     int n = grid[0].length;
        //     int [][][] dp = new int [m+1][n+1][n+1]; // m rows, r1 n cols and r2 n cols
        //     for (int i = 0; i <= m; i++) 
        //         for (int j = 0; j <= n; j++) 
        //             Arrays.fill(dp[i][j], -1);
        //     dp[1][1][1] = grid[0][0];
        //     dp[1][n][n] = grid[0][n-1];
        //     int max = 0, pj = 0, pk = 0, gmax = 0;
        //     for (int i = 1; i <= m; i++) {
        //         System.out.println("\ni: " + i);
        //         for (int j = 1; j <= n; j++) { 
        //             for (int k = 1; k <= n; k++) {
        //                 // if (dp[i][j][k] == -1) continue;
        //                 pj = Math.max(Math.max(dp[i-1][j-1][k], dp[i-1][j][k]), (j+1 <= n ? dp[i-1][j+1][k] : 0));
        //                 pk = Math.max(Math.max(dp[i-1][j][k-1], dp[i-1][j][k]), (k+1 <= n ? dp[i-1][j][k+1] : 0));
        //                 max = Math.max(pj, pk);
        //                 dp[i][j][k] = max + (pj >= pk ? grid[i-1][j-1] : grid[i-1][k-1]);
        //                 if (j != k) dp[i][j][k] +=  (pj >= pk ? grid[i-1][k-1] : grid[i-1][j-1]);
        //                 System.out.println("dp[i][j][k]: " + dp[i][j][k]);
        //                 if (i == m) gmax = Math.max(gmax, dp[i][j][k]);
        //                 if (i == m) System.out.println("gmax: " + gmax);
        //             }
        //         }
        //     }
        //     return gmax;
        // }
        // public int cherryPickup(int[][] grid) {
        //     int m = grid.length;
        //     int n = grid[0].length;
        //     int [][][] dp = new int [m][n][n];
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) 
        //             Arrays.fill(dp[i][j], -1);
        //     dp[0][0][n-1] = n != 1 ? grid[0][0] + grid[0][n-1] : grid[0][0];
        //     int xi = 0, xii =0;
        //     for (int i = 1; i < m; i++) {
        //         for (int j = 0; j <= Math.min(i, n-1); j++) {
        //             for (int k = Math.max(0, n-i-1); k <= n-1; k++) {
        //                 for (int x = -1; x <= 1; x++) {
        //                     for (int y = -1; y <= 1; y++) {
        //                         xi = j + x;
        //                         xii = k + y;
        //                         if (xi >= 0 && xi < n && xii >= 0 && xii < n) {
        //                             if (dp[i-1][xi][xii] != -1) {
        //                                 if (j == k)
        //                                     dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][xi][xii]+grid[i][j]);
        //                                 else dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][xi][xii]+grid[i][j] + grid[i][k]);
        //                             }
        //                         }
        //                     }
        //                 }
        //             }
        //         }
        //     }
        //     int res = 0;
        //     for (int i = 0; i < n; i++) 
        //         for (int j = 0; j < n; j++) 
        //             res = Math.max(res, dp[m-1][i][j]);
        //     return res;
        // }
        // private int helper (int [][] arr, int i, int j, int k) { // 还是没能想明白怎么压缩重复计算问题
        //     if (dp[i][j][k] != null) return dp[i][j][k];         // 这里自顶向下，与自底向上不同方向的计算、以及是否返回值逻辑上容易混乱
        //     int res = arr[i][j];
        //     if (j != k) res += arr[i][k];
        //     int max = 0;
        //     for (int [] d : dirs) {
        //         if (i+d[0] == m) break;
        //         if (j+d[1] < 0 || j+d[1] >= n) continue;
        //         for (int [] dd : dirs) {
        //             if (k+dd[1] < 0 || k +dd[1] >= n) continue;
        //             max = Math.max(max, helper(arr, i+d[0], j+d[1], k+dd[1]));
        //         }
        //     }
        //     res += max;
        //     dp[i][j][k] = res;
        //     return res;
        // }
        // int[][] dirs = new int[][]{{1,-1},{1,0},{1,1}}; // 可移动的方向
        // int max = 0;
        // Integer [][][] dp;
        // int m, n;
        // public int cherryPickup(int[][] grid) {
        //     m = grid.length;
        //     n = grid[0].length;
        //     dp = new Integer [m][n][n]; // m rows, r1 n cols and r2 n cols
        //     max = 0;
        //     return helper(grid, 0, 0, n-1);
        // }

        
    }        

    
    public static void main(String[] args) {
        Solution s  =  new Solution();

        // int [][] a = new int [][] {{3,1,1},{2,5,1},{1,5,5},{2,1,1}};
        // int [][] a = new int [][] {{1,0,0,0,0,0,1},{2,0,0,0,0,3,0},{2,0,9,0,0,0,0},{0,3,0,5,4,0,0},{1,0,2,3,0,0,6}};
        int [][] a = new int [][] {{1,0,0,3},{0,0,0,3},{0,0,3,3},{9,0,3,3}};
        

        System.out.println("a.length: " + a.length);
        for (int z = 0; z < a.length; ++z) {
            for (int w = 0; w < a[z].length; w++) 
                System.out.print(a[z][w] + ", ");
            System.out.print("\n");
        }

        int r = s.cherryPickup(a);
        System.out.println("r: " + r);
    }
}