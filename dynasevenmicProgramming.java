import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.*;
// import javafx.util.Pair;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class dynasevenmicProgramming {
    public static class Solution {

        // private int binarySearch(int [][] arr, int v, int l, int r) {
        //     if (l >= n || r < 0) return -1;
        //     if (l == r) return arr[l][0] > v ? l : -1;
        //     if (l == r-1) return arr[l][0] > v ? l : (arr[r][0] > v ? r : -1);
        //     int m = l + (r-l)/2;
        //     if (arr[m][0] > v) return binarySearch(arr, v, l, m);
        //     return binarySearch(arr, v, m+1, r);
        // }
        // private int dfs(int [][] arr, int idx, int k) {
        //     if (idx >= n) return 0;
        //     if (dp[idx][k] > 0) return dp[idx][k];
        //     if (k == 1) {
        //         int max = arr[idx][2];
        //         for (int i = idx+1; i < n; i++) 
        //             max = Math.max(max, arr[i][2]);
        //         return dp[idx][k] = max;
        //     }
        //     int max = 0;
        //     int tmp = binarySearch(arr, arr[idx][1], idx+1, n-1);
        //     if (tmp != -1)
        //         max = Math.max(arr[idx][2] + dfs(arr, tmp, k-1), dfs(arr, idx+1, k));
        //     else max = Math.max(arr[idx][2], dfs(arr, idx+1, k));
        //     return dp[idx][k] = max;
        // }
        // int [][] dp;
        // int n;
        // public int maxValue(int[][] events, int k) {
        //     n = events.length;
        //     if (k == 1) {
        //         int max = 0;
        //         for (int i = 0; i < n; i++) 
        //             max = Math.max(max, events[i][2]);
        //         return max;
        //     }
        //     Arrays.sort(events, new Comparator<int []>() {
        //             @Override public int compare(int [] a, int [] b) {
        //                 int cmp = a[0] - b[0];
        //                 if (cmp != 0) return cmp;
        //                 return a[1] - b[1];
        //             }
        //         });
        //     dp = new int[n][k+1];
        //     dfs(events, 0, k);
        //     return dp[0][k];
        // }

        
        // private int dfs(int n, int m, int k, int x, int y, int z) {
        //     if (dp[x][y][z] > 0) return dp[x][y][z];
        //     if (z == k) 
        //         }
        // int mod = 1_000_000_007;
        // int [][][] dp;
        // // where dp[a][b][c] is the number of ways you can start building the array
        // // starting from index a where the search_cost = c and the maximum used integer was b.
        // // Recursively, solve the small sub-problems first. Optimize your answer by stopping the search if you exceeded k changes.
        // public int numOfArrays(int n, int m, int k) {
        //     dp = new int[n+1][m+1][k+1];
        //     long res = 0;
        //     for (int i = 1; i <= n; i++)
        //         res  = (res + dfs(n, m, k, i, m, 0)) % mod;
        //     return (int)res;
        // }


        // public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        //     int mod = 1_000_000_007;
        //     int [][][] dp = new int [maxMove + 1][m][n];
        //     long v1 = 0, v2 = 0, v3 = 0, v4 = 0;
        //     for (int k = 1; k <= maxMove; k++) {
        //         for (int i = 0; i < m; i++) {
        //             for (int j = 0; j < n; j++) {
        //                 v1 = i == 0 ? 1 : dp[k-1][i-1][j];
        //                 v2 = i == m-1 ? 1 : dp[k-1][i+1][j];
        //                 v3 = j == 0 ? 1 : dp[k-1][i][j-1];
        //                 v4 = j == n-1 ? 1 : dp[k-1][i][j+1];
        //                 dp[k][i][j] = (int)(((v1 + v2) % mod + v3) % mod + v4) % mod;
        //             }
        //         }
        //     }
        //     return dp[maxMove][startRow][startColumn];
        // }
        // private int dfs(int i, int j, int cnt) { // buggy, but don't wnat to solve this way any more, fix the bug later
        //     if (i < 0 || i >= m || j < 0 || j >= n) return 1;
        //     if (cnt == 0) return 0;
        //     if (dp[i][j][cnt] != -1) return dp[i][j][cnt];
        //     int res = 0;
        //     for (int [] d : dirs) 
        //         res = (res + dfs(i+d[0], j+d[1], cnt-1)) % mod;
        //     return dp[i][j][cnt] = res;
        // }
        // int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // int mod = 1_000_000_007;
        // int [][][] dp;
        // int m, n;
        // public int findPaths(int mm, int nn, int maxMove, int startRow, int startColumn) {
        //     m = mm;
        //     n = nn;
        //     dp = new int [m][n][maxMove + 1];
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) 
        //             Arrays.fill(dp[i][j], -1);
        //     return dfs(startRow, startColumn, maxMove);
        // }


        // public int numTilings(int n) {
        //     int mod = 1_000_000_007;
        //     // int [][] dp = new int [n][3];
        //     int [][] dp = new int [n+1][2]; // dp[i][1] always equals == dp[i][2]
        //     dp[0][0] = 1;
        //     dp[1][0] = 1;
        //     for (int i = 2; i <= n; i++) {
        //         // dp[i][0] = dp[i-1][0] + dp[i-2][0] + dp[i-1][1] + dp[i-2][2];
        //         // dp[i][1] = dp[i-2][0] + dp[i-1][2];
        //         // dp[i][2] = dp[i-2][0] + dp[i-1][1];
        //         dp[i][0] = (int)((dp[i-1][0] + dp[i-2][0]) % mod + (2 * dp[i-1][1]) % mod) % mod;
        //         dp[i][1] = (int)(dp[i-2][0] + dp[i-1][1]) % mod;
        //     }
        //     return dp[n][0];
        // }

        
        // 1）dp（里面不含有A，并且结尾不是“L”）：只能以P结尾，所以dp[i] = dp[i-1] + dpl[i-1] + dpll[i-1]。
        // 2）dpl（里面不含有A，并且结尾是“L”）：只能在dp的基础上加上L结尾，所以dpl[i] = dp[i-1]。
        // 3）dpll（里面不含有A，并且结尾是“LL”）：只能在dpl的基础上加上L结尾，所以dpll[i] = dpl[i-1]。
        // 4）dpa（里面含有A，并且结尾不是“L”）：如果以P结尾，则dpa[i] = dpa[i-1] + dpal[i-1] + dpall[i-1]；如果以A结尾，则dpa[i] = dp[i-1] + dpl[i-1] + dpll[i-1]。
        // 5）dpal（里面含有A，并且结尾是“L”）：只能在dpa的基础上加上L结尾，所以dpal[i] = dpa[i-1]。
        // 6）dpall（里面含有A，并且结尾是“LL”）：只能在dpal的基础上加上L结尾，所以dpall[i] = dpal[i-1]。
        // 最后返回的应该是ret = dp[n] + dpl[n] + dpll[n] + dpa[n] + dpal[n] + dpall[n]。
        // 但是由于返回的结果可能会非常大，所以我们用long long来表示，并且每递推完成之后都取模，以防止溢出。这样算法的时间复杂度就为O(n)，空间复杂度也是O(n)。
        // public  int checkRecord(Integer n) {
        //     int mod = 1_000_000_007;
        //     long [] d = new long [n+1];
        //     long [] dl = new long [n+1];
        //     long [] dll = new long [n+1];
        //     long [] a = new long [n+1];
        //     long [] al = new long [n+1];
        //     long [] all = new long [n+1];
        //     d[1] = 1;
        //     dl[1] = 1;
        //     a[1] = 1;
        //     for (int i = 2; i <= n; i++) {
        //         d[i] = ((d[i-1] + dl[i-1]) % mod + dll[i-1]) % mod;
        //         dl[i] = d[i-1];
        //         dll[i] = dl[i-1];
        //         a[i] = ((a[i-1] + al[i-1]) % mod + all[i-1]) % mod; // ends with P
        //         a[i] = (((a[i] + d[i-1]) % mod + dl[i-1]) % mod + dll[i-1]) % mod; // ends with A
        //         al[i] = a[i-1];
        //         all[i] = al[i-1];
        //     }
        //     long res = 0;
        //     res = (((((d[n] + dl[n]) % mod + dll[n]) % mod + a[n]) % mod + al[n]) % mod + all[n]) % mod;
        //     return (int) res;
        // }
        // private int sum (int [] arr) {
        //     long res = 0;
        //     for (int v : arr) 
        //         res = (res + v) % mod;
        //     return (int)res;
        // }
        // // 利用dp[n][A][L]表示长度为n，包含A个字符'A'，以L个连续的'L'结尾的字符串的个数。
        // // 初始令dp[1] = [[1, 1, 0], [1, 0, 0]]
        // // 状态转移方程：
        // //     dp[n][0][0] = sum(dp[n - 1][0])
        // //     dp[n][0][1] = dp[n - 1][0][0]
        // //     dp[n][0][2] = dp[n - 1][0][1]
        // //     dp[n][1][0] = sum(dp[n - 1][0]) + sum(dp[n - 1][1])
        // //     dp[n][1][1] = dp[n - 1][1][0]
        // //     dp[n][1][2] = dp[n - 1][1][1]
        // int mod = 1_000_000_007;
        // public  int checkRecord(Integer n) {
        //     int [][] dp = {{1, 1, 0}, {1, 0, 0}};
        //     for (int i = 2; i <= n; i++) {
        //         int ndp [][] = {{0, 0, 0}, {0, 0, 0}};
        //         ndp[0][0] = sum(dp[0]);
        //         ndp[0][1] = dp[0][0];
        //         ndp[0][2] = dp[0][1];
        //         ndp[1][0] = (sum(dp[0]) + sum(dp[1])) % mod;
        //         ndp[1][1] = dp[1][0];
        //         ndp[1][2] = dp[1][1];
        //         dp = ndp;
        //     }
        //     return (int)((sum(dp[0]) + sum(dp[1])) % mod);
        // }

        
        // public int minSteps(int n) {
        //     if (n == 1) return 0;
        //     int res = n;
        //     for (int i = n-1; i >= 2; i--) {
        //         if (n % i == 0)                             // 看不懂： 怎么是 + i 呢 ？？？
        //             res = Math.min(res, minSteps(n/i) + i); // minSteps(n/i) + 1 + (n/i -1)
        //     }
        //     return res;
        // }
        // public int minSteps(int n) {
        //     if (n == 1) return 0;
        //     int [] dp = new int [n+1];
        //     dp[1] = 0;
        //     dp[2] = 2;
        //     for (int i = 3; i <= n; i++) {
        //         dp[i] = i;
        //         for (int j = i-1; j >= 2; j--)  {
        //             if (i % j == 0)
        //                 dp[i] = Math.min(dp[i], dp[j] + 1 + i/j-1);
        //         }
        //     }
        //     return dp[n];
        // }


        // public int maxSumDivThree(int[] arr) {
        //     int n = arr.length;
        //     int [] pre = new int[n];
        //     pre[0] = arr[0];
        //     for (int i = 1; i < n; i++) 
        //         pre[i] = pre[i-1] + arr[i];
        //     if (pre[n-1] % 3 == 0) return pre[n-1];
        //     Arrays.sort(arr);
        //     List<Integer> li = new ArrayList<>();
        //     List<Integer> lii = new ArrayList<>();
        //     for (int i = 0; i < n; i++) {
        //         if (arr[i] % 3 == 1) {
        //             li.add(arr[i]);
        //             if (li.size() == 2 && lii.size() == 1) break;
        //         } else if (arr[i] % 3 == 2) {
        //             lii.add(arr[i]);
        //             if (li.size() == 2 && lii.size() == 1) break;
        //         }
        //     }
        //     if (pre[n-1] % 3 == 1) {
        //         if (li.size() > 0 && (lii.size() < 2 || li.get(0) < lii.get(0)+lii.get(1)))
        //             return pre[n-1] - li.get(0);
        //         else
        //             return pre[n-1] - (lii.get(0)+lii.get(1));
        //     } else if (pre[n-1] % 3 == 2) {
        //         if (lii.size() > 0 && (li.size() < 2 || lii.get(0) < li.get(0)+li.get(1)))
        //             return pre[n-1]-lii.get(0);
        //         else
        //             return pre[n-1] - (li.get(0)+li.get(1));
        //     }
        //     return -1;
        // }
        // private int dfs(int [] arr, int i, int j) { // x % y + z 还有一点儿没理清楚
        //     System.out.println("\ni: " + i);
        //     if (i == n-1) {
        //         dp[i][arr[i] % 3] = arr[i];
        //         System.out.println("dp[i][j]: " + dp[i][j]);
        //         return dp[i][j];
        //     }
        //     if (dp[i][j] > 0) return dp[i][j];
        //     int res = 0;
        //     if (arr[i] % 3 == 0) {
        //         res = dfs(arr, i+1, 0) + arr[i];
        //         // dp[i][1] = dfs(arr, i+1, 1); // 要把这些重新理好作更新
        //         // dp[i][2] = dfs(arr, i+1, 2);
        //     } else if (arr[i] % 3 == 1) {
        //         res = Math.max(dfs(arr, i+1, 0), arr[i] + dfs(arr, i+1, 2));
        //         // dp[i][1] = Math.max(dfs(arr, i+1, 0) + arr[i], dfs(arr, i+1, 1));
        //         // dp[i][2] = Math.max(dfs(arr, i+1, 1) + arr[i], dfs(arr, i+1, 1));
        //     } else {
        //         res = Math.max(dfs(arr, i+1, 0), arr[i] + dfs(arr, i+1, 1));
        //         // dp[i][1] = Math.max(dfs(arr, i+1, 0) + arr[i], dfs(arr, i+1, 1));
        //         // dp[i][2] = Math.max(dfs(arr, i+1, 1) + arr[i], dfs(arr, i+1, 1));
        //     }
        //     return dp[i][0] = res;
        // }
        // int [][] dp;
        // int n;
        // public int maxSumDivThree(int[] arr) {
        //     n = arr.length;
        //     int sum = Arrays.stream(arr).sum();
        //     dp = new int [sum+1][3];
        //     dfs(arr, 0, 0);
        //     System.out.println("dp.length: " + dp.length);
        //     for (int z = 0; z < dp.length; ++z) {
        //         for (int w = 0; w < dp[z].length; w++) 
        //             System.out.print(dp[z][w] + ", ");
        //         System.out.print("\n");
        //     }
        //     return dp[0][0];
        // }


        // (动态规划) O(nm)O(nm)
        // f(i,j,k)f(i,j,k) 表示前 ii 次投，最后一次结果为 jj 且最后的数字连续了 kk 次的方案数。
        // 初始时，f(0,j,1)=1f(0,j,1)=1，其余均为 0。
        //     转移时，对于每一个 ii 和 jj，枚举上一次最后的结果 tt，如果 j==tj==t，则转移 f(i,j,k)=f(i,j,k)+f(i−1,j,k−1)f(i,j,k)=f(i,j,k)+f(i−1,j,k−1)；否则 f(i,j,1)=f(i,j,1)+f(i−1,t,k)f(i,j,1)=f(i,j,1)+f(i−1,t,k)。
        //     最终答案为 f(n−1,j,k)f(n−1,j,k) 的总和。
        // public int dieSimulator(int n, int[] rollMax) {
        //     int mod = 1_000_000_007;
        //     int [][][] dp = new int [n][6][16];
        //     for (int j = 0; j < 6; j++) 
        //         dp[0][j][1] = 1;
        //     for (int i = 1; i < n; i++) {
        //         for (int j = 0; j < 6; j++) {
        //             for (int t = 0; t < 6; t++) {
        //                 if (j == t) {
        //                     for (int k = 2; k <= rollMax[j]; k++)  
        //                         dp[i][j][k] = (dp[i][j][k] + dp[i-1][j][k-1]) % mod;
        //                 } else {
        //                     for (int k = 1; k <= rollMax[t]; k++) 
        //                         dp[i][j][1] = (dp[i][j][1] + dp[i-1][t][k]) % mod;
        //                 }
        //             }
        //         }
        //     }
        //     int ans = 0;
        //     for (int j = 0; j < 6; j++) 
        //         for (int k = 1; k <= rollMax[j]; k++) 
        //             ans = (ans + dp[n-1][j][k]) % mod;
        //     return ans;
        // }
        // private int dfs(int [] arr, int pre, int len, int n) { // 这个题被绕晕了，主要是一开始的想法不对，却没去想换个思路再去解 
        //     if (n == 0) return 1;
        //     if (dp[pre][len][n] != null) return dp[pre][len][n];
        //     int res = 0;
        //     for (int i = 1; i <= 6; i++) {
        //         if (i == pre && arr[i-1] > len) 
        //             res = (res + dfs(arr, i, len+1, n-1)) % mod;
        //         else if (i != pre) 
        //             res = (res + dfs(arr, i, 1, n-1)) % mod;
        //     }
        //     dp[pre][len][n] = (int)res;
        //     return dp[pre][len][n];
        // }
        // int mod = 1_000_000_007;
        // Integer [][][] dp; // 这个状态与上一次投掷所连续出现的这个数字的次数密切相关: n, preNum, preNumCnt
        // public int dieSimulator(int n, int[] rollMax) {
        //     dp = new Integer [7][16][n+1];
        //     return dfs(rollMax, 0, 0, n);
        // }


        // private int dfs(int [] arr, int [][] cost, int i, int j, int k) { // i: index, j: lastColor, k: groups to be estabilished
        //     if (k < 0) return -1;
        //     if (i == arr.length) return k == 0 ? 0 : -1;
        //     if (dp[i][j][k] != null) return dp[i][j][k];
        //     int res = Integer.MAX_VALUE, tmp = 0;
        //     if (arr[i] > 0) {
        //         if (arr[i] == j) res = dfs(arr, cost, i+1, j, k);
        //         else res = dfs(arr, cost, i+1, arr[i], k-1);
        //         return dp[i][j][k] = res;
        //     }
        //     for (int x = 0; x < cost[i].length; x++) {
        //         tmp = dfs(arr, cost, i+1, x+1, (x+1 == j ? k : k-1));
        //         if (tmp != -1)
        //             res = Math.min(res, cost[i][x] + tmp);
        //     }
        //     return dp[i][j][k] = res == Integer.MAX_VALUE ? -1 : res;
        // }
        // Integer [][][] dp;
        // public Integer minCost(int [] houses, int [][] cost, int m, int n, int target) {
        //     dp = new Integer [m][n+1][target+1];
        //     return dfs(houses, cost, 0, 0, target);
        // }


        // 定义dp[l][r][k]表示在[l, r]区间并且在后面包含了k个与boxes[r]相同颜色的boxes的情况下，可以获得的最大得分，显然题目要求的就是dp[0][boxes.size() - 1][0]。
        // 首先将dp[l][r][k]的值初始化为dp[l][r - 1][0] + (k + 1)^2，表示首先消除l到r-1之间的boxes,然后将boxes[r]连同后面的k个boxes一起消除。
        // 然后就尝试对dp[l][r][k]进行更新了：
        // 如果在l到r-1区间内有boxes[i]和boxes[r]相同的字符，那么可以尝试首先将区间[i + 1, r - 1]消除，这样i就和后面的k + 1个boxes连起来了，
        // 其可以获得分数就是需要进一步计算的dp[l][i][k + 1]。
        // private int dfs(int [] arr, int i, int j, int  k) {
        //     if (i > j) return 0;
        //     if (dp[i][j][k] > 0) return dp[i][j][k];
        //     int res = dfs(arr, i, j-1, 0) + (k+1)*(k+1);
        //     for (int x = i; x < j; x++) 
        //         if (arr[x] == arr[j]) {
        //             res = Math.max(res, dfs(arr, i, x, k+1) + dfs(arr, x+1, j-1, 0));
        //         }
        //     return dp[i][j][k] = res;
        // }
        // int [][][] dp;
        // int n;
        // public int removeBoxes(int[] boxes) {
        //     n = boxes.length;
        //     dp = new int [n][n][n];
        //     return dfs(boxes, 0, n-1, 0);
        // }


        // public int bestTeamScore(int[] scores, int[] ages) {
        //     int n = scores.length;
        //     int [][] arr = new int [n][2];
        //     for (int i = 0; i < n; i++) 
        //         arr[i] = new int [] {ages[i], scores[i]};
        //     Arrays.sort(arr, (a, b) -> (a[1] != b[1] ? a[1]-b[1] : a[0]-b[0]));
        //     int [] dp = new int [n];
        //     int max = 0;
        //     for (int i = 0; i < n; i++)  {
        //         dp[i] = arr[i][1];
        //         for (int j = i-1; j >= 0; j--) {
        //             if (arr[j][0] <= arr[i][0])
        //                 dp[i] = Math.max(dp[i], dp[j] + arr[i][1]);
        //         }
        //         max = Math.max(max, dp[i]);
        //     }
        //     return max;
        // }


        // private int dfs(String s, int idx, int left, int right) {
        //     if (idx == n) return 0;
        //     if (dp[idx][left][right] != null) return dp[idx][left][right];
        //     int cur = s.charAt(idx) - 'A';
        //     int leftCost = 0;
        //     if (left != 26) {
        //         int diffX = Math.abs(left % 6 - cur % 6);
        //         int diffY = Math.abs(left / 6 - cur / 6);
        //         leftCost = diffX + diffY;
        //     }
        //     int rightCost = 0;
        //     if (right != 26) {
        //         int diffX = Math.abs(right % 6 - cur % 6);
        //         int diffY = Math.abs(right / 6 - cur / 6);
        //         rightCost = diffX + diffY;
        //     }
        //     int res = Math.min(leftCost + dfs(s, idx+1, cur, right), rightCost + dfs(s, idx+1, left, cur));
        //     dp[idx][left][right] = res;
        //     return res;
        // }
        // Integer [][][] dp; // dp[i][j][k]: smallest movements when you have one finger on i-th char and the other one on j-th char
        // int n;         // already having written k first characters from word.
        // public int minimumDistance(String word) {
        //     n = word.length();
        //     dp = new  Integer[n][27][27];
        //     return dfs(word, 0, 26, 26);
        // }


        // private int dfs(String s, int k, int i) {
        //     System.out.println("\ni: " + i);
        //     if (i == n-1) return s.charAt(i) > 0 ? 1 : 0;
        //     if (dp[i] > 0) return dp[i];
        //     long res = 0; // 这里的折分思路再想一下 
        //     if (s.charAt(i) == '0' || s.charAt(i+1) == '0' || Integer.parseInt(s.substring(i)) >= k) res = dfs(s, k, i+1) % mod;
        //     // else if (Integer.parseInt(s.substring(i)) == k) res = dfs(s, k, i+1) % mod;
        //     else res = (dfs(s, k, i+1) * 2) % mod;
        //     return dp[i] = (int)res;
        // }
        // int mod = 1_000_000_007;
        // int [] dp;
        // int n;
        // public int numberOfArrays(String s, int k) {
        //     n = s.length();
        //     dp = new int [n];
        //     dfs(s, k, 0);
        //     System.out.println("dp.length: " + dp.length);
        //     for (int z = 0; z < dp.length; ++z) 
        //         System.out.print(dp[z] + ", ");
        //     System.out.println("");
        //     return dp[0];
        // }


        // public int twoEggDrop(int n) { // 1 + 2 + 3 + ... + x >= n ==> get x
        //     if (n <= 2) return n;
        //     return (int)(Math.ceil((-1 + Math.sqrt((long)n * 8 + 1)) / 2.0));
        // }
        // https://zhuanlan.zhihu.com/p/41257286
        // 思路：
        // DP[i][j]表示用i个鸡蛋，j层楼的情况下最坏情况下所需扔鸡蛋的最少数目。
        // 可知初始条件为：
        // DP[1][0] = 0; DP[2][0] = 0;
        // DP[1][1] = 1; DP[2][1] = 1;
        // DP[1][i] = i; //i = 1 … n
        // 对于DP[2][i], i = 2 … n的情况，我们可以这样考虑：
        //     遍历j=2…i，求DP[2][j]，分两种情况：
        //     如果第1个鸡蛋在第j-1层摔破了，则我们在第j层只需摔第2个鸡蛋一次即可，此时总摔鸡蛋数为DP[1][j-1]+1。
        //     注意上面的1是因为第j层需要摔第2个鸡蛋1次。为什么DP[1][j-1]不能写成1呢？因为第1个鸡蛋在第j-1层摔破了，我们不能肯定在第1,2,…,j-2层不会破，所以要用DP[1][j-1]。
        //     如果第1个鸡蛋在第j-1层没有摔破，则我们在第j到i层有2个鸡蛋可以摔，此时退化到DP[2][i-j]的情况。该种情形下总共扔1+DP[2][i-j]。那个1就是表示第1个鸡蛋在第j-1层扔了1次。这里我们为什么只考虑用1，而不用考虑DP[1][j-1]呢？因为如果第j-1层没有摔破，第1,2,…,j-2层也就不用考虑了。
        //     因为是求最坏情况下的数目，所以DP[2][j]=1 + max(DP[1][j-1]+1, DP[2][i-j])。
        //     而我们是要求所有最坏情况下的最少数目，所以DP[2][j]=min(1 + max(DP[1][j-1]+1, DP[2][i-j]))。i = 2…n, j = 2…i。
        // public int twoEggDrop(int n) { // 1 + 2 + 3 + ... + x >= n ==> get x
        //     if (n <= 1) return n;
        //     int [][] dp = new int [3][n+1];
        //     for (int i = 0; i < 3; i++) 
        //         Arrays.fill(dp[i], Integer.MAX_VALUE);
        //     dp[1][0] = 0;
        //     dp[1][1] = 1;
        //     dp[2][0] = 0;
        //     dp[2][1] = 1;
        //     for (int i = 1; i <= n; i++) 
        //         dp[1][i] = i;
        //     for (int i = 2; i <= n; i++) 
        //         for (int j = 2; j <= i; j++) 
        //             dp[2][i] = Math.min(dp[2][i], 1 + Math.max(dp[1][j-1], dp[2][i-j]));
        //     return dp[2][n];
        // }


        // public int videoStitching(int[][] clips, int time) {
        //     int n = clips.length;
        //     Arrays.sort(clips, new Comparator<int []>() {
        //             @Override public int compare(int [] a, int [] b) {
        //                 int comp = a[0] - b[0];
        //                 if (comp != 0) return comp;
        //                 return a[1] - b[1];
        //             }
        //         });
        //     int cnt = 0;
        //     int curEnd = 0, maxEnd = 0;
        //     int lastStart = -1;
        //     for (int i = 0; i < n;) {
        //         if (clips[i][0] > curEnd) return -1;
        //         maxEnd = curEnd;
        //         while (i < n && clips[i][0] <= curEnd) {
        //             maxEnd = Math.max(maxEnd, clips[i][1]);
        //             i++;
        //         }
        //         ++cnt;
        //         curEnd = maxEnd;
        //         if (curEnd >= time) return cnt;
        //     }
        //     return -1;
        // }


// // 之前用原创想法也写了很多图的题，但缺乏归纳总结，原创想法更多的是解决了题目，但解法与效率、与优化算法间的距离还需要很多比较归纳与总结，才能把图这一块吃透
// // https://leetcode.jp/leetcode-1334-find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance-%E8%A7%A3%E9%A2%98%E6%80%9D%E8%B7%AF%E5%88%86%E6%9E%90/  这个题需要重新写
// // map：图结构
// // city：当前城市
// // dis：当前所剩距离
// // v：已经被记录为邻居的节点
// // maxDis：走到某个节点时，剩余距离的最大值
// // 返回值为当前城市的邻居数。
//         private int dfs(int [][] arr, int city, int dis, boolean [] vis, int [] maxDis) {
//             int res = 0;
//             for (int i = 0; i < arr[0].length; i++) { // 循环当前城市的所有相邻城市
//                 int distance = arr[city][i]; // 与相邻城市的距离，如果为0，说明与该城市不相连
//                 int diffDis = dis - distance;// 到达相邻城市后，与阈值相比的剩余距离。
//                 if (distance > 0 && diffDis >= maxDis[i]) { // 与该城市相连并且剩余距离大于等于访问数组中的值
//                     maxDis[i] = diffDis;     // 更新访问数组中的剩余距离   
//                     if (!vis[i]) {
//                         vis[i] = true;
//                         res++;
//                     }
//                     res += dfs(arr, i, diffDis, vis, maxDis); // 递归dfs与该城市相连的其他城市：图中我似乎还很没有dfs以及递归的概念
//                 }
//             }
//             return res;
//         }
//         public int findTheCity(int n, int[][] edges, int distanceThreshold) {
//             int [][] map = new int [n][n];
//             for (int [] eg : edges) {
//                 map[eg[0]][eg[1]] = eg[2];
//                 map[eg[1]][eg[0]] = eg[2];
//             }
//             int min = n;
//             int res = 0;
//             for (int i = 0; i < n; i++) {
//                 boolean [] vis = new boolean [n];
//                 vis[i] = true;
//                 int cnt = dfs(map, i, distanceThreshold, vis, new int [n]);
//                 if (cnt <= min) {
//                     min = cnt;
//                     res = i;
//                 }
//             }
//             return res;
//         }
        // public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        //     // 1.创建邻接矩阵
        //     int [][] graph = new int [n][n]; // 相比于我只会用HashMap来建邻接关系，邻接链表与数组都可能，看哪个用起来方便
        //     for (int i = 0; i < n; i++)
        //         Arrays.fill(graph[i], Integer.MAX_VALUE); // pre filled n equaivlent to Integer.MAX_VALUE
        //     for (int [] eg : edges) {
        //         graph[eg[0]][eg[1]] = eg[2];
        //         graph[eg[1]][eg[0]] = eg[2];
        //     }
        //     // 2.floyd算法
        //     for (int k = 0; k < n; k++)          // 中间结点
        //         for (int i = 0; i < n; i++)      // 开始结点
        //             for (int j = 0; j < n; j++) {// 结尾结点
        //                 if (i == j || graph[i][k] == Integer.MAX_VALUE || graph[k][j] == Integer.MAX_VALUE) continue;
        //                 graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
        //             }                
        //     // 3.每个城市距离不大于distanceThreshold的邻居城市的数目
        //     int [] mark = new int [n]; //记录小于distanceThreshold的邻居城市个数
        //     for (int i = 0; i < n; i++) 
        //         for (int j = 0; j < n; j++) 
        //             if (graph[i][j] <= distanceThreshold)
        //                 mark[i]++;
        //     // 4.找数目少，编号最大的
        //     int min = n;
        //     int ans = 0;
        //     for (int i = 0; i < n; i++) 
        //         if (min >= mark[i]) {
        //             min = mark[i];
        //             ans = i;
        //         }
        //     return ans;
        // }


        // private int dfs(int i, int k) {
        //     if (i == n) return 0;   //到头了，不管k多大，需要的空间都是为0
        //     if (k == 0) return total[i][n-1]; //没k了，不能再分段，[idx...n-1]必须看作一整段，可以直接返回
        //     if (dp[i][k] != -1) return dp[i][k];
        //     int res = Integer.MAX_VALUE;
        //     for (int j = i; j < n; j++) //枚举所有的分段位置，结果为Min（当前确定的分段需要的空间+递归计算后续数组少分一段的需要的空间）
        //         res = Math.min(res, total[i][j] + dfs(j+1, k-1));
        //     return dp[i][k] = res;
        // }
        // int [][] dp;
        // int [][] total;
        // int n;
        // // 多理解几遍题意，最终转化为
        // //     nums数组可以划分k次，也就是分为k+1段
        // //     每段的值是该段的长度len*该段最大的元素mx
        // //     题目答案是各段的值相加的最小值
        // public int minSpaceWastedKResizing(int[] nums, int k) {
        //     n = nums.length;
        //     if (k == 0) return Arrays.stream(nums).max().getAsInt()*n-Arrays.stream(nums).sum();
        //     dp = new int [n][k+1];
        //     for (int i = 0; i < n; i++) 
        //         Arrays.fill(dp[i], -1);
        //     total = new int [n][n];
        //     for (int i = 0; i < n; i++) 
        //         for (int j = i, max = 0; j < n; j++) {
        //             max = Math.max(max, nums[j]);
        //             total[i][j] = max * (j - i + 1);
        //         }
        //     return dfs(0, k) - Arrays.stream(nums).sum();
        // }
        // public int minSpaceWastedKResizing(int[] nums, int k) {
        //     int n = nums.length;
        //     if (k == 0) return Arrays.stream(nums).max().getAsInt()*n-Arrays.stream(nums).sum();
        //     if (k >= n-1) return 0;
        //     int [] dp = new int [n+1];
        //     Arrays.fill(dp, Integer.MAX_VALUE/2);
        //     dp[n] = 0;
        //     for (int time = 0; time <= k; time++) {
        //         for (int i = 0; i < n; i++) {
        //             int max = nums[i], sum = 0, ans = Integer.MAX_VALUE;
        //             for (int j = i; j < n; j++) {
        //                 max = Math.max(max, nums[j]);
        //                 sum += nums[j];
        //                 int was = max * (j - i + 1) - sum;
        //                 ans = Math.min(ans, dp[j+1] + was);
        //             }
        //             dp[i] = ans;
        //             if (time == k) break;
        //         }
        //     }
        //     return dp[0];
        // }


        // private int dfs(int i, int j, int k) {
        //     if (m.get(i).size() == 0) return -1;
        //     if (k == 0) {
        //         if (m.get(i).contains(j)) {
        //             int idx = 0;
        //             while (idx < m.get(i).size() && m.get(i).get(idx) != j) ++idx;
        //             return o.get(i).get(idx);
        //         }
        //         return Integer.MAX_VALUE/2;
        //     }
        //     if (dp[i][j][k] != -1) return dp[i][j][k];
        //     int res = Integer.MAX_VALUE;
        //     for (int x = 0; x < m.get(i).size(); x++) 
        //         res = Math.min(res, o.get(i).get(x) + (m.get(i).get(x) == j ? 0 : dfs(m.get(i).get(x), j, k-1)));
        //     return dp[i][j][k] = res;
        // }
        // HashMap<Integer, List<Integer>> m = new HashMap<>();
        // HashMap<Integer, List<Integer>> o = new HashMap<>();
        // int [][][] dp;
        // public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //     List<Integer> l = new ArrayList<>();
        //     for (int i = 0; i < n; i++) {
        //         l = new ArrayList<>();
        //         m.put(i, l);
        //         l = new ArrayList<>();
        //         o.put(i, l);
        //     }
        //     for (int i = 0; i < flights.length; i++) {
        //         m.get(flights[i][0]).add(flights[i][1]);
        //         o.get(flights[i][0]).add(flights[i][2]);
        //     }
        //     dp = new int [n][n][k+1];
        //     for (int i = 0; i < n; i++) 
        //         for (int j = 0; j < n; j++) 
        //             Arrays.fill(dp[i][j], -1);
        //     int res = dfs(src, dst, k);
        //     return res < (k+1)*10000 && res > 0 ? res : -1;
        // }


        // public int countPaths(int n, int[][] roads) { // 看的别人的，改天需要自己再写一遍
        //     int [][] map = new int [n][n];
        //     for (int i = 0; i < n; i++)
        //         Arrays.fill(map[i], -1);
        //     int u = 0, v = 0, t = 0;
        //     for (int i = 0; i < roads.length; i++) {
        //         u = roads[i][0];
        //         v = roads[i][1];
        //         t = roads[i][2];
        //         map[u][v] = t;
        //         map[v][u] = t;
        //     }
        //     int mod = 1_000_000_007;
        //     long [] time = new long [n]; // time[i]表示从路口0出发到达路口i的最短用时
        //     long [] cnt = new long [n];  // count[i]表示在最短用时情况下从路口0出发到达路口i对应的方案数
        //     Arrays.fill(time, -1);
        //     time[0] = 0;
        //     cnt[0] = 1;                  // 路口0的到达方案数为1       
        //     Queue<int []> q = new PriorityQueue<>((a, b)->a[1]-b[1]); //小顶堆，用于输出下一最快到达的路口及时间
        //     for (int i = 0; i < n; i++) 
        //         if (map[0][i] > 0) q.offer(new int [] {i, map[0][i], 0});
        //     int [] cur = null;
        //     while (!q.isEmpty()) {
        //         cur = q.poll();
        //         u = cur[0];
        //         t = cur[1];
        //         v = cur[2];
        //         if (time[u] != -1 && t > time[u]) continue; // 当前路口已在更短的时间内被访问，即当前路径不是最短路径，跳过
        //         if (time[u] == -1) {    // 第一次到达
        //             time[u] = t;
        //             cnt[u] = cnt[v] % mod;
        //             for (int i = 0; i < n; i++)
        //                 if (map[u][i] > 0)
        //                     q.offer(new int [] {i, t + map[u][i], u});
        //         } else // time[u] == t: true
        //             cnt[u] = (cnt[u] + cnt[v]) % mod;
        //     }
        //     return (int)cnt[n-1];
        // }


        // private int dfs(int i, int m, int k, int max) {
        //     if (i < 0 || k < 0) return 0;
        //     if (i == 0 && k == 0) return 1; // empty array []
        //     if (max != -1 && dp[i][k][max] != null) return dp[i][k][max];
        //     long res = 0;
        //     for (int x = 1; x <= m; x++) {
        //         res += dfs(i-1, m, (x > max ? k-1 : k), Math.max(max, x));
        //         res %= mod;
        //     }
        //     if (max != -1)
        //         dp[i][k][max] = (int) res;
        //     return (int)res;
        // }
        // int mod = 1_000_000_007;
        // Integer [][][] dp;
        // public int numOfArrays(int n, int m, int k) {
        //     dp = new Integer [n+1][k+1][m+1];
        //     return dfs(n, m, k, -1);
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
        // public int numOfArrays(int n, int m, int k) {
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


        // public boolean canCross(int[] stones) { 
        //     int n = stones.length;
        //     Map<Integer, Set<Integer>> jmp = new HashMap<>(); // set里存的是到达当前石头所用的步长
        //     for (int i = 0; i < n; i++)
        //         jmp.put(stones[i], new HashSet<>());
        //     jmp.get(0).add(0);
        //     for (int i = 0; i < n-1; i++) {
        //         int idx = stones[i];
        //         if (jmp.get(idx).size() == 0) continue;
        //         for (int v : jmp.get(idx)) {
        //             for (int j = v-1; j <= v+1; j++) { // [v-1, v, v+1]
        //                 if (j <= 0) continue;
        //                 if (jmp.containsKey(idx + j))
        //                     jmp.get(idx+j).add(j);
        //             }
        //         }
        //     }
        //     return jmp.get(stones[n-1]).size() != 0;
        // }
        // public boolean canCross(int[] stones) {
        //     int n = stones.length;
        //     if (n == 1 && stones[0] == 0) return true;
        //     if (stones[1] != 1) return false;
        //     boolean [][] dp = new boolean [n][n];
        //     dp[0][0] = true;
        //     for (int i = 0; i < n; i++) {
        //         for (int j = 0; j < i; j++) {
        //             int k = stones[i] - stones[j];
        //             if (k >= n) continue; // 因为最大的步数就是stones.length
        //             dp[i][k] = dp[j][k];
        //             if (k -1 >= 0) dp[i][k] |= dp[j][k-1];
        //             if (k + 1 < n) dp[i][k] |= dp[j][k+1];
        //         }
        //     }
        //     for (int i = 0; i < n; i++) 
        //         if (dp[n-1][i]) return true;
        //     return false;
        // }
        // private int getIdx(int [] arr, int v, int l, int r) { 
        //     if (l == r) return arr[l] == v ? l : -1;
        //     if (l == r -1) return arr[l] == v ? l : (arr[r] == v ? r : -1);
        //     int m = l + (r-l)/2;
        //     if (arr[m] == v) return m;
        //     if (arr[m] > v) return getIdx(arr, v, l, m-1);
        //     return getIdx(arr, v, m+1, r);
        // }
        // // 暴力解法的问题在于里面存在重复计算：
        // // 例如在a->b->c的过程中，假设b->c跳跃了k步，但是a->b的过程既有可能跳跃了k-1步，也有可能跳跃了k+1步。
        // // 所以b->c跳跃k步的情况就有可能在a->b的递推过程中被重复计算。因此这种算法不能通过所有的测试用例。
        // private boolean dfs(int [] arr, int i, int k) { // 暴力dfs虽然记忆，仍然存在着大量的的重复计算，一定会超时，得用其它方法
        //     if (i >= n || i < 0) return false;
        //     if (i == n-1) return true;
        //     if (dp[i][k] != null && dp[i][k]) return dp[i][k];
        //     for (int j = Math.max(k-1, 1); j <= k+1; j++) {
        //         int tmp = getIdx(arr, arr[i] + j, i+1, n-1);
        //         if (tmp == -1) continue;
        //         if (dfs(arr, tmp, j)) return dp[i][k] = true;
        //     }
        //     dp[i][k] = false;
        //     return false;
        // }
        // Boolean [][] dp;
        // int n;
        // public boolean canCross(int[] stones) { 
        //     n = stones.length;
        //     if (stones[1] != 1) return false;
        //     for (int i = 1; i <= n-1; i++) 
        //         if (stones[i] > i *(i+1)/2) return false;
        //     if (stones[1] != 1) return false;
        //     dp = new Boolean[n][n];
        //     dfs(stones, 0, 1);
        //     return dfs(stones, 0, 1);
        // }


        // public int minTaps(int n, int[] ranges) {
        //     int [][] arr = new int[n+1][2];
        //     for (int i = 0; i < ranges.length; i++) 
        //         arr[i] = new int[]{i-ranges[i], i+ranges[i]};
        //     Arrays.sort(arr, (a, b)-> (a[0] != b[0] ? a[0]-b[0] : a[1]-b[1]));
        //     System.out.println("arr.length: " + arr.length);
        //     for (int z = 0; z < arr.length; ++z) {
        //         for (int w = 0; w < arr[z].length; w++) 
        //             System.out.print(arr[z][w] + ", ");
        //         System.out.print("\n");
        //     }
        //     if (arr[0][0] > 0) return -1;
        //     int cnt = 0, right = arr[0][1];
        //     int i = 1;
        //     int [] cur = arr[0];
        //     while (i < n+1 && right < n) {
        //         System.out.println("\ni: " + i);
        //         System.out.println(" (i < n+1 && arr[i][0] == cur[0]): " +  (i < n+1 && arr[i][0] == cur[0]));
        //         System.out.println("cnt: " + cnt);   
        //         if  (i < n+1 && arr[i][0] == cur[0]) {
        //             while (i < n+1 && arr[i][0] == cur[0]) ++i;
        //             if (i == n+1 && arr[i-1][1] >= n) return cnt;
        //             ++cnt;
        //             System.out.println("cnt I: " + cnt);   
        //         }
        //         right = arr[i-1][1];
        //         cur = arr[i];
        //         if (cur[0] > right) return -1;
        //         if (arr[i][1] <= right) {
        //             while (i < n+1 && arr[i][1] <= right) ++ i;
        //             if (i == n+1 && arr[i-1][1] >= n) return cnt;
        //             ++ cnt;
        //             right = arr[i-1][1];
        //             cur = arr[i];
        //         }
        //     }
        //     return cnt;
        // }


        // // 参考 n 的范围 [1, 14]，可状态压缩后结合动态规划方法求解。
        // // 设计一个动态规划数组 dp[1 << n]，
        // // 对每个 dp[i]，若 i 的二进制表示中 1 的个数为 num, 1 的位置为 k1, k2, …, knum,
        // //     dp[i] 表示 nums1 的前 num 个数和 nums2 第 k1, k2, …, knum 个数的最小异或值之和。
        // public int minimumXORSum(int[] nums1, int[] nums2) {
        //     int n = nums1.length;
        //     int range = 1 << n;
        //     // 若i的二进制表示中1的个数为num, 1的位置为k1,k2,...,knum, dp[i]表示nums1的前num个数和nums2第k1,k2,...,knum个数的最小异或值之和
        //     int [] dp = new int [range]; 
        //     Arrays.fill(dp, Integer.MAX_VALUE);
        //     dp[0] = 0;
        //     for (int i = 0; i < range; i++) { // 遍历i的各个二进制位 
        //         for (int j = 0; j < n; j++) { // i的第j位为1 bits: from right to left
        //             if (((i >> j) & 1) == 1)  // 尝试选取nums1[num]和nums2[j]进行异或更新dp[i]
        //                 dp[i] = Math.min(dp[i], dp[i ^ (1 << j)] + (nums1[Integer.bitCount(i)-1] ^ nums2[j]));
        //         }
        //     }
        //     return dp[range-1];
        // }
        // int count(int x){ // 计算 二进制 1 的 个数
        //     int s = 0;
        //     while(x) {
        //         s++;
        //         x = x&(x-1);
        //     }
        //     return s;
        // }
        // int minimumXORSum(vector<int>& nums1, vector<int>& nums2) { // c++ 这应该是与上面的这种解法方向相反
        //     int n = nums1.size();
        //     vector<int> dp(1<<n, INT_MAX);
        //     for(int i = 0; i < n; ++i)
        //         dp[1<<i] = nums1[0]^nums2[i];  // 第一个数跟 nums2 结合的情况
        //     for(int i = 1; i < n; ++i)
        //     {	// 剩余的 nums1 的数
        //         for(int state = (1<<n)-1; state > 0; --state)
        //         {	// 遍历所有状态
        //             if(dp[state] == INT_MAX) continue; // 不存在的状态，pass
        //             if(count(state) == i) // 原状态的 1 的个数 为 i 个，可以进行状态转移
        //             {
        //                 for(int j = 0; j < n; ++j)
        //                 { // 遍历所有的位，碰到 state 0 的位置可以放一个 1
        //                     if(((state>>j)&1)==0)
        //                         dp[state|(1<<j)] = min(dp[state|(1<<j)], dp[state]+(nums1[i]^nums2[j]));
        //                 }
        //             }
        //         }
        //     }
        //     return dp.back();
        // }


        // public int oddEvenJumps(int[] arr) {
        //     int n = arr.length;
        //     int [][] dp = new int [n][2];
        //     // for (int i = 0; i < n; i++) 
        //     //     Arrays.fill(dp[i], -1);
        //     dp[n-1][0] = 1;
        //     dp[n-1][1] = 1;
        //     for (int i = n-2; i >= 0; i--) { // 更新奇数次一步到位的，只
        //         if (arr[i] < arr[n-1]) {
        //             if (i == n-2) {
        //                 dp[i][1] = 1;
        //                 continue;
        //             }
        //             int j = i+1;
        //             for ( j = i+1; j < n-1; j++) 
        //                 if (arr[j] > arr[i]) break;
        //             if (j == n-1) dp[i][1] = 1;
        //         }
        //     }
        // }

        
        // public int oddEvenJumps(int[] arr) {
        //     int n = arr.length;
        //     boolean[] od = new boolean[n];
        //     boolean[] en = new boolean[n];
        //     TreeMap<Integer, Integer> tm = new TreeMap<>();
        //     od[n-1] = en[n-1] = true;
        //     tm.put(arr[n-1], n-1);
        //     int cnt = 1;
        //     for (int i = n-2; i >= 0; i--) {
        //         Integer ceil = tm.ceilingKey(arr[i]); // higherKey() equaivlents
        //         Integer floor = tm.floorKey(arr[i]);  // lowerKey()
        //         if (ceil != null)
        //             od[i] = en[tm.get(ceil)];
        //         if (floor != null)
        //             en[i] = od[tm.get(floor)];
        //         if (od[i]) ++cnt;
        //         tm.put(arr[i], i);
        //     }
        //     return cnt;
        // }
        // // 当数据量比较大的时候，是需要用dp来做的，而不应该再用dfs
        // private boolean dfs(int [] arr, int i, int cnt) { // i: idx, cnt 1st 2nd jumps
        //     if (i >= n) return false;
        //     if (i == n-1) return dp[i][cnt%2] = true;
        //     if (dp[i][cnt % 2] != null) return dp[i][cnt%2];
        //     if (cnt % 2 == 1) {
        //         if (min[i] == -1) return dp[i][cnt%2] = false;
        //         return dp[i][cnt%2] = dfs(arr, min[i], cnt+1);
        //     }
        //     if (max[i] == -1) return dp[i][cnt%2] = false;
        //     return dp[i][cnt%2] = dfs(arr, max[i], cnt+1);
        // }
        // Boolean [][] dp;
        // int [] max;
        // int [] min;
        // int n;
        // public int oddEvenJumps(int[] arr) {
        //     n = arr.length;
        //     dp = new Boolean [n][2];
        //     max = new int [n]; // 这部分排序法是O(N*N),应该寻找更高效的O(NlgN)解法
        //     min = new int [n];
        //     int locMin = Integer.MAX_VALUE, locMax = -1, locMaxIdx = -1, locMinIdx = -1;
        //     for (int i = 0; i < n; i++) {
        //         locMin = Integer.MAX_VALUE;
        //         locMax = -1;
        //         locMaxIdx = -1;
        //         locMinIdx = -1;
        //         for (int j = i+1; j < n; j++) {
        //             if (arr[j] >= arr[i] && arr[j] < locMin) {
        //                 locMin = arr[j];
        //                 locMinIdx = j;
        //             }
        //             if (arr[j] <= arr[i] && arr[j] > locMax) {
        //                 locMax = arr[j];
        //                 locMaxIdx = j;
        //             }
        //         }
        //         min[i] = locMinIdx;
        //         max[i] = locMaxIdx;
        //     }
        //     for (int i = 0; i < n; i++) {
        //         if (dp[i][1] != null) continue;
        //         dfs(arr, i, 1);
        //     }
        //     int cnt = 0;
        //     for (int i = 0; i < n; i++) 
        //         if (dp[i][1] != null && dp[i][1]) ++cnt;
        //     return cnt;
        // }


        
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // int []  a = new int []  {10, 13, 12, 14, 15};
        int []  a = new int []  {2, 3, 1, 1, 4};
        // int []  a = new int []  { 5, 1, 3, 4, 2};

        int res = s.oddEvenJumps(a);
        System.out.println("res: " + res);
    }
}

