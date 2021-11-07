import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;

public class dpone {
    public static class Solution {
        
        // public int[] countBits(int n) {
        //     int [] dp = new int [n+1];
        //     for (int i = 1; i <= n; i++)
        //         dp[i] = i % 2 + dp[i >> 1];
        //     return dp;
        // }

        // public int tribonacci(int n) {
        //     int [] dp = new int [3];
        //     dp[0] = 0;
        //     dp[1] = 1;
        //     dp[2] = 1;
        //     for (int i = 3; i <= n; i++) 
        //         dp[i % 3] = dp[(i-1) % 3] + dp[(i-2) % 3] + dp[(i-3) % 3];
        //     return dp[n % 3];
        // }

        // public int fib(int n) {
        //     int [] dp = new int [2];
        //     dp[0] = 0;
        //     dp[1] = 1;
        //     for (int i = 2; i <= n; i++) 
        //         dp[i % 2] = dp[(i-1) % 2] + dp[(i-2) % 2];
        //     return dp[n % 2];
        // }

        // public int minCostClimbingStairs(int[] cost) {
        //     int n = cost.length;
        //     int [] f = new int [2];
        //     f[(n-1) % 2] = cost[n-1];
        //     f[(n-2) % 2] = cost[n-2];
        //     for (int i = n-3; i >= 0; i--) 
        //         f[i % 2] = cost[i] + Math.min(f[(i+1)  % 2], f[(i+2)  % 2]);
        //     return Math.min(f[0], f[1]);
        // }


        // public int getMaximumGenerated(int n) {
        //     if (n == 0) return 0;
        //     int [] f = new int [n+1];
        //     f[0] = 0;
        //     f[1] = 1;
        //     int max = Math.max(f[0], f[1]);
        //     for (int i = 2; i <= n; i++) {
        //         if (i % 2 == 0) f[i] = f[i / 2];
        //         else f[i] = f[i / 2] + f[i / 2 + 1];
        //         max = Math.max(max, f[i]);
        //     }
        //     return max;
        // }

        // public int countSquares(int[][] mat) {
        //     int m = mat.length, n = mat[0].length;
        //     int [][] sum = new int [m+1][n+1];
        //     for (int i = 1; i <= m; i++) 
        //         for (int j = 1; j <= n; j++) 
        //             sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + mat[i-1][j-1];
        //     int ans = 0;
        //     for (int d = 1; d <= Math.min(m, n); d++) {
        //         for (int i = 1; i+d <= m+1; i++) {
        //             for (int j = 1; j+d <= n+1; j++) {
        //                 int x = i+d-1, y = j +d -1;
        //                 int cur = sum[x][y] - sum[i-1][y] - sum[x][j-1] + sum[i-1][j-1];
        //                 if (cur == d * d) ans++;
        //             }
        //         }
        //     }
        //     return ans;
        // }
        // public int countSquares(int[][] mat) {
        //     int m = mat.length, n = mat[0].length;
        //     int ans = 0;
        //     for (int i = 0; i < m; i++) {
        //         for (int j = 0; j < n; j++) 
        //             if (mat[i][j] != 0) 
        //                 if (i > 0 && j > 0) // 如果这个最小边长为2的正方形里有0，刚值不变，否则就会加1
        //                     mat[i][j] = Math.min(Math.min(mat[i-1][j], mat[i][j-1]), mat[i-1][j-1]) + 1;
        //     }
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) 
        //             ans += mat[i][j];
        //     return ans;
        // }

        // public int numSplits(String t) {
        //     int n = t.length(), ans = 0;
        //     char [] s = t.toCharArray();
        //     Set<Character> l = new HashSet<>();
        //     Map<Character, Integer> r = new HashMap<>();
        //     for (int i = 1; i < n; i++) 
        //         r.put(s[i], r.getOrDefault(s[i], 0) + 1);
        //     for (int i = 0; i < n-1; i++) {
        //         l.add(s[i]);
        //         if (l.size() == r.size()) ans++;
        //         r.put(s[i+1], r.get(s[i+1])-1);
        //         if (r.get(s[i+1]) == 0) r.remove(s[i+1]);
        //     }
        //     return ans;
        // }
        // private boolean equCnts(int [] a, int [] b)  {
        //     int x = 0, y = 0;
        //     for (int i = 0; i < 26; i++) {
        //         if (a[i] > 0) x++;
        //         if (b[i] > 0) y++;
        //     }
        //     return x == y;
        // }
        // public int numSplits(String t) {
        //     int n = t.length(), ans = 0;
        //     char [] s = t.toCharArray();
        //     int [] l = new int [26];
        //     int [] r = new int [26];
        //     for (int i = 1; i < n; i++)
        //         r[s[i]-'a']++;
        //     for (int i = 0; i < n-1; i++) {
        //         l[s[i]-'a']++;
        //         if (equCnts(l, r)) ans++;
        //         r[s[i+1]-'a']--;
        //     }
        //     return ans;
        // }
        // public int numSplits(String t) {
        //     int n = t.length()-1, ans = 0, leftDisCnt = 0, rightDisCnt = 0;
        //     char [] s = t.toCharArray();
        //     int [] l = new int [26];
        //     int [] r = new int [26];
        //     int [] lcnt = new int [n];
        //     int [] rcnt = new int [n];
        //     for (int i = 0; i < n; i++) {
        //         if (l[s[i]-'a'] == 0) {
        //             l[s[i]-'a'] = 1;
        //             leftDisCnt ++;
        //         }
        //         if (r[s[n-i]-'a'] == 0) {
        //             r[s[n-i]-'a'] = 1;
        //             rightDisCnt++;
        //         }
        //         lcnt[i] = leftDisCnt;
        //         rcnt[n-i - 1] = rightDisCnt;
        //     }
        //     for (int i = 0; i < n; i++) 
        //         if (lcnt[i] == rcnt[i]) ans++;
        //     return ans;
        // }

        // private int dfs(int [] a, int i, int j) { // min-max: 限制对手得分
        //     if (i > j) return 0;
        //     if (dp[i][j] != -1) return dp[i][j];
        //     return dp[i][j] = Math.max(a[i] - dfs(a, i+1, j), a[j] - dfs(a, i, j-1));
        // }
        // int [][] dp;
        // int n;
        // public boolean stoneGame(int[] a) {
        //     n = a.length;
        //     dp = new int [n][n];
        //     for (int i = 0; i < n; i++) 
        //         Arrays.fill(dp[i], -1);
        //     return dfs(a, 0, n-1) > 0;
        // }

        // private int dfs(int [] a, int i) {
        //     if (i == n) return 0;
        //     if (dp[i] > 0) return dp[i];
        //     int sum = 0, ans = Integer.MIN_VALUE;
        //     for (int j = 0; j < 3; j++) {
        //         if (i + j >= n) break;
        //         sum += a[i+j];
        //         ans = Math.max(ans, sum - dfs(a, i+j+1));
        //     }
        //     return dp[i] = ans;
        // }
        // int [] dp;
        // int n;
        // public String stoneGameIII(int[] a) {
        //     n = a.length;
        //     dp = new int [n];
        //     return dfs(a, 0) > 0 ? "Alice" : dp[0] == 0 ? "Tie" : "Bob";
        // }

        // private int dfs(int [] a, int i, int m) { // min-max
        //     if (i == n) return 0;
        //     if (dp[i][m] != -1) return dp[i][m];
        //     int sum = 0, ans = 0;
        //     for (int j = 1; j <= Math.min(n-1-i, 2 * m); j++) {
        //         sum += a[i+j-1];
        //         ans = Math.max(ans, sum - dfs(a, i+j, Math.max(m, j))); // 也想要计算比对手多拿的石头，为什么会错掉呢
        //     }
        //     return dp[i][m] = ans;
        // }
        // int [][] dp;
        // int n;
        // public int stoneGameII(int[] a) {
        //     int n = a.length, sum = Arrays.stream(a).sum();
        //     dp = new int [n][n/2];
        //     for (int i = 0; i < n; i++) 
        //         Arrays.fill(dp[i], -1);
        //     int v = dfs(a, 0, 1); 
        //     System.out.println("v: " + v);
        //     System.out.println("sum: " + sum);
        //     return (sum - v) / 2 + v;
        // }

        // private boolean dfs(int v, int idx) {
        //     if (v == 1) return idx % 2 == 0;
        //     if (v == 0) return idx % 2 != 0;
        //     if (dp[v][idx % 2] != null) return dp[v][idx % 2];
        //     if (idx % 2 == 0) { // alice's turn
        //         for (int i = 1; i*i <= v; i++) {
        //             if (dfs(v - i * i, idx + 1)) // 是自己的turn,那么我只要找到一种可以稳胜的策略，我就赢了
        //                 return dp[v][0] = true;
        //         }
        //         return dp[v][0] = false;
        //     } else { // bob's turn
        //         for (int i = 1; i*i <= v; i++) {
        //             if (!dfs(v - i * i, idx + 1)) // 是对方的turn,那么bob想，他只要找到一种策略保证alice不能赢(return false时)，那么他就赢了
        //                 return dp[v][1] = false;
        //         }
        //         return dp[v][1] = true;
        //     }
        // }
        // Boolean [][] dp;
        // public boolean winnerSquareGame(int n) {
        //     dp = new Boolean [n+1][2];
        //     return dfs(n, 0);
        // }

        // private int dfs(int [] a, int i, int j, int sum) {
        //     if (i > j) return 0;
        //     if (dp[i][j] != -1) return dp[i][j];
        //     return dp[i][j] = Math.max(sum - a[i] - dfs(a, i+1, j, sum-a[i]), sum-a[j] - dfs(a, i, j-1, sum-a[j]));
        // }
        // int [][] dp;
        // int n;
        // public int stoneGameVII(int[] stones) {
        //     n = stones.length;
        //     dp = new int [n][n];
        //     for (int i = 0; i < n; i++) 
        //         Arrays.fill(dp[i], -1);
        //     return dfs(stones, 0, n-1, Arrays.stream(stones).sum());
        // }


        // private int dfs(int [] a, int i, int j) {
        //     if (i >= j) return 0;
        //     if (dp[i][j] > 0) return dp[i][j];
        //     int ans = 0;
        //     for (int k = i; k < j; k++) {
        //         int l = pre[k] - (i == 0 ? 0 : pre[i-1]);
        //         int r = pre[j] - pre[k];
        //         if (l < r)
        //             ans = Math.max(ans, l + dfs(a, i, k));
        //         else if (l > r)
        //             ans = Math.max(ans, r + dfs(a, k+1, j));
        //         else ans = Math.max(ans, Math.max(l + dfs(a, i, k), r + dfs(a, k+1, j)));
        //     }
        //     return dp[i][j] = ans;
        // }
        // int [][] dp;
        // int [] pre;
        // int n;
        // public int stoneGameV(int [] a) {
        //     n = a.length;
        //     dp = new int [n][n];
        //     pre = Arrays.copyOf(a, n);
        //     for (int i = 1; i < n; i++) 
        //         pre[i] += pre[i-1];
        //     return dfs(a, 0, n-1);
        // }

        
        // private int dfs(int [] arr, int k, int idx) {
        //     if (idx == n) return 0;
        //     if (dp[idx] != -1) return dp[idx];
        //     int ans = 0;
        //     for (int i = idx; i < Math.min(idx+k, n); i++) 
        //         ans = Math.max(ans, max[idx][i]*(i-idx+1) + dfs(arr, k, i+1));
        //     return dp[idx] = ans;
        // }
        // int [] dp;
        // int [][] max; // 终于懂得自己记忆，而不是每要用时再调用和计算了
        // int n;
        // public int maxSumAfterPartitioning(int[] arr, int k) {
        //      n = arr.length;
        //      int cur = 0;
        //      max = new int [n][n];
        //      for (int i = 0; i < n; i++) {
        //          max[i][i] = arr[i];
        //          cur = arr[i];
        //          for (int j = i+1; j < n; j++) {
        //              cur = Math.max(cur, arr[j]);
        //              max[i][j] = cur;
        //          }
        //      }
        //      dp = new int [n];
        //      Arrays.fill(dp, -1);
        //      return dfs(arr, k, 0);
        //  }


        // public int mctFromLeafValues(int[] arr) {
        //     int n = arr.length;
        //     int [][] dp = new int [n][n];
        //     int [][] max = new int [n][n];
        //     int cur = 0;
        //     for (int i = 0; i < n; i++) {
        //         max[i][i] = arr[i];
        //         cur = arr[i];
        //         for (int j = i+1; j < n; j++) {
        //             cur = Math.max(cur, arr[j]);
        //             max[i][j] = cur;
        //         }
        //     }
        //     for (int i = 0; i < n; i++) {
        //         for (int j = i+1; j < n; j++) {
        //         }
        //     }
        //     return dp[0][n-1];
        // }


        // public int minFallingPathSum(int[][] mat) {
        //     int n = mat.length;
        //     int [][] dp = new int [n][n];
        //     for (int i = 0; i < n; i++) 
        //         Arrays.fill(dp[i], 10001);
        //     dp[0] = Arrays.copyOf(mat[0], n);
        //     for (int i = 1; i < n; i++) {
        //         for (int j = 0; j < n; j++) {
        //             if (dp[i-1][j] != 10001) {
        //                 if (j > 0) dp[i][j-1] = Math.min(dp[i][j-1], dp[i-1][j] + mat[i][j-1]);
        //                 dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + mat[i][j]);
        //                 if (j < n-1)
        //                     dp[i][j+1] = Math.min(dp[i][j+1], dp[i-1][j] + mat[i][j+1]);
        //             }
        //         }
        //     }
        //     int ans = Integer.MAX_VALUE;
        //     for (int i = 0; i < n; i++) 
        //         ans = Math.min(ans, dp[n-1][i]);
        //     return  ans;
        // }


        // public boolean isMatch(String ss, String tt) { // 应该还是用dp比较好做一点儿吧，几年前做的，现在完整没有思路了。。。
        //     int m = ss.length(), n = tt.length();
        //     char [] s = ss.toCharArray();
        //     char [] t = tt.toCharArray();
        //     int i = 0, j = 0;
        //     char pre = null;
        //     while (i < m && j < n) {
        //         if (s[i] == t[j] || t[j] == '.') {
        //             pre = s[i];
        //             i++;
        //             j++;
        //             continue;
        //         }
        //         if (t[j]== '*' && s[i] != pre) return false;
        //     }
        // }

        
        // private void dfs(int i, int j, int [][] a) {
        // }
        // int [][] dirs = {{0, 1}, {1, 0}};
        // int min;
        // public int calculateMinimumHP(int[][] mat) {
        //     int m = mat.length, n = mat[0].length;
        //     min = Integer.MAX_VALUE;
        //     dfs(0, 0, mat);
        //     return min > 0
        // }


        // public int countSubstrings(String t) {
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     boolean [][] p = new boolean [n][n];
        //     int [][] dp = new int [n][n];
        //     for (int i = n-1; i >= 0; i--) {
        //         p[i][i] = true;
        //         dp[i][i]= 1;
        //         for (int j = i; j < n; j++) {
        //             if (s[i] == s[j] && ())
        //         }
        //     }
        // }


        // public int waysToMakeFair(int[] arr) {
        //     int n = arr.length;
        //     int [] odd = new int [n];
        //     int [] evn = new int [n];
        //     for (int i = 0; i < n; i++) 
        //         if (i % 2 == 0) {
        //             evn[i] = (i == 0 ? 0 : evn[i-1]) + arr[i];
        //             odd[i] = i == 0 ? 0 : odd[i-1];
        //         } else {
        //             odd[i] = (i == 1 ? 0 : odd[i-1]) + arr[i];
        //             evn[i] = evn[i-1];
        //         }
        //     List<Integer> l = new ArrayList<>();
        //     for (int i = 0; i < n; i++) {
        //         if (i % 2 == 0) {
        //             if ((i == 0 ? 0 : evn[i] - arr[i]) + odd[n-1] - odd[i] == odd[i] + evn[n-1] - evn[i]) l.add(i);
        //         } else { // i % 2 == 1
        //             if ((i == 1 ? 0 : odd[i] - arr[i]) + evn[n-1] - evn[i] == evn[i] + odd[n-1] - odd[i]) l.add(i);
        //         }
        //     }
        //     return l.size();
        // }


        // public int minCost(String t, int[] cost) {
        //     int n = t.length(), i = 0, j = 0, ans = 0;
        //     char [] s = t.toCharArray();
        //     while (i < n-1 && s[i+1] != s[i]) i++;
        //     int locMin = cost[i];
        //     // System.out.println("i: " + i);
        //     while (i < n-1) {
        //         // System.out.println("\n i: " + i);
        //         j = i;
        //         while (i < n-1 && s[i+1] == s[i]) {
        //             locMin = Math.min(locMin, s[i+1]);
        //             i++;
        //         }
        //         ans += locMin;
        //         while (i < n-1 && s[i] != s[i+1]) i++;
        //         locMin = cost[i];
        //     }
        //     return ans;
        // }

        
        // private int getMaxSumXLenSumarray(int [] arr, int i, int j, int len) {
        //     if (j - i + 1 < len) return 0;
        //     int l = i, max = 0, locSum = 0;
        //     for (int r = i; r <= j; r++) {
        //         if (r - l + 1 < len) continue;
        //         while (r - l + 1 > len) ++l;
        //         if (r - l + 1 == len) {
        //             locSum = sum[r] - (l == 0 ? 0 : sum[l-1]);
        //             max = Math.max(max, locSum);
        //         } 
        //     }
        //     return max;
        // }
        // int [] sum;
        // public int maxSumTwoNoOverlap(int[] arr, int fst, int snd) {
        //     int n = arr.length;
        //     sum = Arrays.copyOf(arr, n);
        //     for (int i = 1; i < n; i++) sum[i] += sum[i-1];
        //     int j = 0, max = 0, cnt = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (i - j + 1 < fst) continue;
        //         while (i - j + 1 > fst) ++j;
        //         if (i - j + 1 == fst) {
        //             int locMax = Math.max(getMaxSumXLenSumarray(arr, 0, j-1, snd), getMaxSumXLenSumarray(arr, i+1, n-1, snd));
        //             max = Math.max(max, sum[i] - (j == 0 ? 0 : sum[j-1]) + locMax);
        //         } 
        //     }
        //     return max;
        // }


        // private boolean isGood(String t) {
        //     Set<Character> s = new HashSet<>(List.of('3', '4', '7'));
        //     Set<Character> pos = new HashSet<>(List.of('0', '1', '8'));
        //     Set<Character> good = new HashSet<>(List.of('2', '5', '6', '9'));
        //     for (char c : s) 
        //         if (t.indexOf(c) != -1) return false;
        //     for (char c : pos) {
        //         if (t.indexOf(c) == -1) continue;
        //         for (char d : good) 
        //             if (t.indexOf(d) != -1) return true;
        //         return false;
        //     }
        //     return true;
        // }
        // public int rotatedDigits(int n) {
        //     int ans = 0;
        //     for (int i = 1; i <= n; i++) 
        //         if (isGood("" + i)) ans++;
        //     return ans;
        // }


        // public int longestCommonSubsequence(String ss, String tt) {
        //     int m = ss.length(), n = tt.length();
        //     int [][] dp = new int [m+1][n+1];
        //     char [] s = ss.toCharArray();
        //     char [] t = tt.toCharArray();
        //     for (int i = 1; i <= m; i++) 
        //         for (int j = 1; j <= n; j++) {
        //             if (s[i-1] == t[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
        //             else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        //         }
        //     return dp[m][n];
        // }

        // public String optimalDivision(int[] arr) {
        //     int n = arr.length;
        //     if (n == 1) return ""+arr[0];
        //     if (n == 2) return "" + arr[0] + "/" + arr[1];
        //     String ans = "";
        //     for (int i = 0; i < n; i++) {
        //         if (i == 0) ans += arr[i] + "/(";
        //         else if (i <= n-2) ans += arr[i] + "/";
        //         else if (i == n-1) ans += arr[i] + ")";
        //     }
        //     return ans;
        // }


        // public int countSubstrings(String t) {
        //     int n = t.length(), ans = 0;
        //     char [] s = t.toCharArray();
        //     boolean [][] dp = new boolean [n][n];
        //     for (int i = n-1; i >= 0; i--) 
        //         for (int j = i; j < n; j++) {
        //             dp[i][j] = s[i] == s[j] && (j-i <= 2 || dp[i+1][j-1]);
        //             if (dp[i][j]) ans++;
        //         }
        //     return ans;
        // }

        // public int longestPalindromeSubseq(String tt) {
        //     int n = tt.length();
        //     char [] s = tt.toCharArray(); // ori
        //     char [] t = (new StringBuilder(tt).reverse().toString()).toCharArray(); // reverse
        //     int [][] dp = new int [n+1][n+1];
        //     for (int i = 1; i <= n; i++) 
        //         for (int j = 1; j <= n; j++) {
        //             if (s[i-1] == t[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
        //             else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        //         }
        //     return dp[n][n];
        // }


        // public String longestPalindrome(String t) {
        //     int n = t.length(), max = 0;
        //     char [] s = t.toCharArray();
        //     String ans = "";
        //     boolean [][] dp = new boolean [n][n];
        //     for (int i = n-1; i >= 0; i--) 
        //         for (int j = i; j < n; j++) {
        //             dp[i][j] = s[i] == s[j] && (j-i <= 2 || dp[i+1][j-1]);
        //             if (dp[i][j] && (max == 0 || max < j-i+1)) {
        //                 max = j - i + 1;
        //                 ans = t.substring(i, j+1);
        //             }
        //         }
        //     return ans;
        // }

        // public int minInsertions(String tt) {
        //     int n = tt.length();
        //     char [] s = tt.toCharArray(); // ori
        //     char [] t = (new StringBuilder(tt)).reverse().toString().toCharArray(); // reverse
        //     int [][] dp = new int [n+1][n+1];
        //     for (int i = 1; i <= n; i++) 
        //         for (int j = 1; j <= n; j++) {
        //             if (s[i-1] == t[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
        //             else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        //         }
        //     return n - dp[n][n];
        // }

        // public boolean checkPartitioning(String t) {
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     boolean [][] f = new boolean [n][n];
        //     for (int i = n-1; i >= 0; i--) 
        //         for (int j = i; j < n; j++) 
        //             f[i][j] = s[i] == s[j] && (j-i <= 2 || f[i+1][j-1]);
        //     for (int i = 0; i < n-2; i++) 
        //         for (int j = i+1; j < n-1; j++) 
        //             if (f[0][i] && f[i+1][j] && f[j+1][n-1])
        //                 return true;
        //     return false;
        // }

        // private int dfs(int [] a, int i) {
        //     if (i >= n) return 0;
        //     if (dp[i] > 0) return dp[i];
        //     return dp[i] = Math.max(a[i] + dfs(a, i+2), dfs(a, i+1));
        // }
        // int [] dp;
        // int n;
        // public int rob(int[] a) {
        //     n = a.length;
        //     if (Arrays.stream(a).max().getAsInt() == 0) return 0; // 永远记不住这个细节
        //     dp = new int [n];
        //     return dfs(a, 0);
        // }

        // private int dfs(int [] a, int j, int idx) {
        //     if (idx > j) return 0;
        //     if (dp[idx] > 0) return dp[idx];
        //     return dp[idx] = Math.max(dfs(a, j, idx+2) + a[idx], dfs(a, j, idx+1));
        // }
        // int [] dp;
        // int n;
        // public int rob(int[] a) {
        //     int n = a.length;
        //     if (n == 1) return a[0];
        //     if (Arrays.stream(a).max().getAsInt() == 0) return 0;
        //     dp = new int [n];
        //     int max = dfs(a, n-2, 0);
        //     Arrays.fill(dp, 0);
        //     return Math.max(max, dfs(a, n-1, 1));
        // }

        // private int dfs(TreeNode r) {
        //     if (r == null) return 0;
        //     if (dp.containsKey(r)) return dp.get(r);
        //     int ans =  Math.max(r.val +  (r.left == null ? 0 : rob(r.left.left) + rob(r.left.right)) +
        //                         (r.right == null ? 0 : rob(r.right.left) + rob(r.right.right)),
        //                         rob(r.left) + rob(r.right));
        //     dp.put(r, ans);
        //     return ans;
        // }
        // Map<TreeNode, Integer> dp = new HashMap<>();
        // public int rob(TreeNode r) {
        //     return dfs(r);
        // }

        // public int minimumDeleteSum(String ss, String tt) {
        //     int m = ss.length(), n = tt.length();
        //     char [] s = ss.toCharArray();
        //     char [] t = tt.toCharArray();
        //     int [][] dp = new int [m+1][n+1];
        //     for (int i = 1; i <= m; i++) 
        //         for (int j = 1; j <= n; j++) 
        //             if (s[i-1] == t[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
        //             else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        //     System.out.println("dp.length: " + dp.length);
        //     for (int z = 0; z < dp.length; ++z) 
        //         System.out.println(Arrays.toString(dp[z]));
        //     int i = m-1, j = n-1;
        //     StringBuilder sb = new StringBuilder();
        //     while (i >= 0 && j >= 0) {
        //         if (dp[i+1][j+1] == dp[i][j] + 1) {
        //             sb.append(s[i]);
        //             i--;
        //             j--;
        //         } else if (dp[i+1][j+1] == dp[i][j+1]) i--;
        //         else j--;
        //     }
        //     System.out.println("sb.toString(): " + sb.toString());
        //     // reverse to common subsequence, then calculate the rest......
        //     return 0;
        // }


        // private int dfs(int [] a, int i, int m) { 
        //     if (i == n) return 0;
        //     if (dp[i][m] != -1) return dp[i][m];
        //     int sum = 0, ans = Integer.MIN_VALUE; // 思路是对的，就是细节上要注意 ans = Integer.MIN_VALUE 而不是 ans = 0
        //     for (int j = 1; j <= Math.min(n-i, 2 * m); j++) {
        //         sum += a[i+j-1];
        //         ans = Math.max(ans, sum - dfs(a, i+j, Math.max(m, j))); 
        //     }
        //     return dp[i][m] = ans;
        // }
        // int [][] dp;
        // int [] pre;
        // int n;
        // public int stoneGameII(int[] a) {
        //     n = a.length;
        //     if (n == 1) return a[0];
        //     int sum = Arrays.stream(a).sum();
        //     pre = Arrays.copyOf(a, n);
        //     for (int i = 1; i < n; i++) 
        //         pre[i] += pre[i-1];
        //     dp = new int [n][n];
        //     for (int i = 0; i < n; i++) 
        //         Arrays.fill(dp[i], -1);
        //     int v = dfs(a, 0, 1); 
        //     return (sum + v) / 2;
        // }


        // private int dfs(int i) { // tle tle tle  忘记当初是怎么写这个题的了，因为数组元素的改变，可能记忆数组帮的作用不大？再想想这个题
        //     if (i >= n-1) return 0;
        //     if (dp[i] != Integer.MIN_VALUE) return dp[i];
        //     int ans = Integer.MIN_VALUE, tmp = 0;
        //     for (int j = 2; i+j-1 < n; j++) { // 棋盘状态发生了改变，记忆无效，所以会超时 tle tle tle
        //         ans = Math.max(ans, pre[i+j-1] - dfs(i+j-1));
        //     }
        //     return dp[i] = ans;
        // }
        // int [] dp;
        // int [] pre;
        // int n;
        // public int stoneGameVIII(int[] stones) {
        //     n = stones.length;
        //     dp = new int [n];
        //     pre = Arrays.copyOf(stones, n);
        //     for (int i = 1; i < n; i++) 
        //         pre[i] += pre[i-1];
        //     Arrays.fill(dp, Integer.MIN_VALUE);
        //     return dfs(0);
        // }
        // public int stoneGameVIII(int[] stones) {
        //     int n = stones.length;
        //     for (int i = 1; i < n; i++) 
        //         stones[i] += stones[i-1];
        //     int ans = stones[n-1];
        //     for (int i = n-1; i >= 2; i--) 
        //         ans = Math.max(ans, stones[i-1] - ans);
        //     return ans;
        // }

        // public int maxSubArray(int[] a) {
        //     int n = a.length;
        //     for (int i = 1; i < n; i++)
        //         a[i] += a[i-1];
        //     int j = 0, ans = 0, sum = 0;
        //     for (int i = 0; i < n; i++) {
        //         sum += a[i];
        //         if (sum < 0) 
        //     }
        // }


        // private int dfs(int [][] a, int i, int j) {
        //     if (dp[i][j] > 0) return dp[i][j];
        //     vis[i][j] = true;
        //     int ans = 1;
        //     for (int [] d : dirs) {
        //         int x = i + d[0], y = j + d[1];
        //         if (x < 0 || x >= m || y < 0 || y >= n) continue;
        //         if (vis[x][y] || a[x][y] <= a[i][j]) continue;
        //         ans = Math.max(ans, 1 + dfs(a, x, y));
        //     }
        //     vis[i][j] = false; // 哈哈哈哈： 回溯的结果是，vis数组自动回溯为原始状态，全为false
        //     return dp[i][j] = ans;
        // }
        // int [][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}} ;
        // boolean [][] vis;
        // int [][] dp;
        // int m, n, max;
        // public int longestIncreasingPath(int[][] mat) {
        //     m = mat.length;
        //     n = mat[0].length;
        //     dp = new int [m][n];
        //     vis = new boolean [m][n];
        //     max = 1;
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) {
        //             // for (int k = 0; k < m; k++) // 这里是不需要重置的，不重署反而更高效，因为过程中的最优解都记录下来了 ????
        //             //     Arrays.fill(vis[k], false);
        //             int cur = dfs(mat, i, j);
        //             max = Math.max(max, cur);
        //         }
        //     return max;
        // }


        // private void getAllSums(int [] a, int idx, int sum, Set<Integer> sums) {
        //     if (idx == a.length) {
        //         sums.add(sum);
        //         return;
        //     }
        //     for (int i = idx; i < a.length; i++) {
        //         getAllSums(a, i+1, sum + a[i], sums);
        //         getAllSums(a, i+1, sum, sums);
        //     }            
        // }
        // public boolean canPartition(int[] a) { // come on: O(2^200)想过OJ ?? 脑袋真是错错了！！
        //     int n = a.length, sum = Arrays.stream(a).sum();
        //     if (sum % 2 != 0) return false;
        //     Set<Integer> sums = new HashSet<>();
        //     getAllSums(a, 0, 0, sums);
        //     return sums.contains(sum / 2);
        // }
        // public boolean canPartition(int[] a) {
        //     int n = a.length, sum = Arrays.stream(a).sum();
        //     if (sum % 2 != 0) return false;
        //     int target = sum / 2;
        //     int [] dp = new int [target + 1];
        //     int [] cnt = new int [101];
        //     for (Integer v : a) cnt[v]++;
        //     dp[0] = 1;
        //     for (int i = 1; i < 101; i++) {
        //         if (cnt[i] == 0) continue;
        //         // for (int j = 0; j+i <= target; j++) { // 注意正向遍历有个重复使用的问题:当前更新的j会被后面遍历的j重复使用，
        //         for (int j = target; j >= 0; j--) {      // 反向遍历可以避开这个问题
        //             if (dp[j] == 0) continue;
        //             for (int k = 1; k <= cnt[i]; k++) {
        //                 if (j + i * k > target) break;
        //                 dp[j + i * k] = Math.max(dp[j+i*k], dp[j]+k);
        //             }
        //         }
        //     }
        //     return dp[target] > 0;
        // }

        
        // public int findTargetSumWays(int[] a, int target) { // tle tle tle
        //     int n = a.length, range = (1 << n), ans = 0;
        //     for (int i = 0; i < range; i++) {
        //         int sum = 0;
        //         for (int j = 0; j < n; j++) {
        //             if (((i >> j) & 1) == 1) sum += a[j];
        //             else sum -= a[j];
        //         }
        //         if (sum == target) ans++;
        //     }
        //     return ans;
        // }
        // private int getAllSums(int [] a, int target, int idx, int sum, int cnt) { // (2^20) 可否一试呢？理论上是可以过的
        //     if (idx == a.length) {                                                // n < 17 比较好 这个2^N的复朵度，真要命呀。。。。。。
        //         if (sum == target) cnt++;
        //         return cnt; // 有return int代码更简洁，但是全局变量cnt效率更高
        //     }
        //     // for (int i = idx; i < a.length; i++) { // 为什么要画蝇添足，加个多余的for loop呢？ 
        //         // getAllSums(a, target, idx+1, sum + a[idx]);
        //         // getAllSums(a, target, idx+1, sum - a[idx]);
        //     // }
        //     return getAllSums(a, target, idx+1, sum + a[idx], cnt)
        //         + getAllSums(a, target, idx+1, sum - a[idx], cnt);
        // }
        // public int findTargetSumWays(int[] a, int target) { 
        //     int n = a.length;
        //     return getAllSums(a, target, 0, 0, 0);
        // }
// // dfs + memorization的代码
        // private int dfs(int [] a, int target, int idx, int sum) {
        //     String key = idx + "_" + sum;
        //     if (dp.containsKey(key)) return dp.get(key);
        //     if (idx == n) {
        //         if (sum == target) return 1;
        //         else return 0;
        //     }
        //     int add = dfs(a, target, idx+1, sum + a[idx]);
        //     int sub = dfs(a, target, idx+1, sum - a[idx]);
        //     dp.put(key, add+sub);
        //     return add + sub;
        // }
        // Map<String, Integer> dp = new HashMap<>();
        // int n;
        // public int findTargetSumWays(int[] a, int target) {
        //     n = a.length;
        //     return dfs(a, target, 0, 0);
        // }
        // private int dfs(int [] a, int sum, int idx) {
        //     if (idx == a.length) {
        //         if (sum == 0) return 1;
        //         else return 0;
        //     }
        //     Map<Integer, Integer> tmp = dp.get(idx);
        //     if (tmp != null) {
        //         if (tmp.containsKey(sum))
        //             return tmp.get(sum);
        //     } else {
        //         tmp = new HashMap<>();
        //         dp.put(idx, tmp);
        //     }
        //     int cnt = dfs(a, sum - a[idx], idx+1) + dfs(a, sum + a[idx], idx+1);
        //     tmp.put(sum, cnt);
        //     return cnt;
        // }
        // Map<Integer, Map<Integer, Integer>> dp = new HashMap<>();
        // public int findTargetSumWays(int[] nums, int target) {
        //     return dfs(nums, target, 0);
        // }
// sum[p] + sum[n] = sum[nums];
// sum[p] - sum[n] = S;
// 2sum[p] = sum[nums] + S
// sum[p] = (sum[nums] +S) / 2
        // public int findTargetSumWays(int [] a, int S) {
        //     int sum = Arrays.stream(a).sum(), target = (sum + S) / 2; // 根据推导公式，计算出target
        //     if (S > 0 && sum < S || S < 0 && -sum > S) return 0; // 如果和小于S，说明无法得到解，返回false。（注意S有可能为负）
        //     if ((sum + S) % 2 != 0) return 0; // 如果计算出的target不是整数，返回false。
        //     int [] dp = new int [target + 1]; // dp[i]表示在原数组中找出一些数字，并且他们的和为下标i的可能有多少种。
        //     dp[0] = 1; // 初始化dp[0]为1
        //     for (Integer v : a) 
        //         // for (int i = target-v; i >= 0; i--) { // 从0循环到target - n, 注意逆序
        //         //     if (dp[i] > 0)        // dp[i]大于0说明，存在dp[i]种组合，其和为i的可能性
        //         //         dp[i+v] += dp[i]; // 既然存在和为i的可能，那么i加上当前数字的和也是存在的
        //         // }
        //         for (int i = target; i >= v; i--)  // 从0循环到target - n, 注意逆序
        //             dp[i] += dp[i-v];              // 两种写法都对
        //     return dp[target];
        // }
        // // bottom up的动态规划解法 todo
        // // 因为所有数的和不会超过1000， 所以在表格向上平移了1000
        // // dp的基本递推关系如下
        // // dp[i][j+nums[i]] += dp[i-1][j];
        // // dp[i][j-nums[i]] += dp[i-1][j];
        // public int findTargetSumWays(int[] nums, int S) {
        //     int n = nums.length;
        //     int [][] dp = new int[n][2001];
        //     for (int i = 0; i < n; i++) {
        //         if (i == 0) {
        //             dp[i][1000+nums[i]] += 1;
        //             dp[i][1000-nums[i]] += 1;
        //         } else {
        //             for (int j = 0; j < dp[i].length; j++) {
        //                 if (dp[i-1][j] > 0) {
        //                     if (j + nums[i] < dp[i].length)
        //                         dp[i][j+nums[i]] += dp[i-1][j];
        //                     if (j - nums[i] >= 0)
        //                         dp[i][j-nums[i]] += dp[i-1][j];
        //                 }
        //             }
        //         }
        //     }
        //     if (S > 1000) return 0;
        //     return dp[n-1][1000+S];
        // }
        // // 由于每个数的状态都只和前面一个数的状态有关， 所以，可以在空间上把二维降到一维
        // public int findTargetSumWays(int[] nums, int k) {
        //     int n = nums.length;
        //     if (k > 1000) return 0;
        //     int [] dp = new int[2001];
        //     dp [1000] = 1;
        //     for (int va : nums) {
        //         int [] next = new int[2001];
        //         for (int i = dp.length-1-va; i >= va; i--) {
        //             next[i+va] += dp[i];
        //             next[i-va] += dp[i];
        //         }
        //         dp = next;
        //     }
        //     return dp[k+1000];
        // }
        // public int findTargetSumWays(int[] nums, int S) {
        //     Map<Integer, Integer> cntMap = new HashMap<>();
        //     cntMap.put(0, 1);
        //     for (int num: nums) {
        //         Map<Integer, Integer> next = new HashMap<>();
        //         for (Map.Entry<Integer, Integer> entry: cntMap.entrySet()) {
        //             int v = entry.getKey();
        //             int cnt = entry.getValue();
        //             next.put(v+num, next.getOrDefault(v + num, 0) + cnt);
        //             next.put(v-num, next.getOrDefault(v - num, 0) + cnt);
        //         }
        //         cntMap = next;
        //     }
        //     return cntMap.getOrDefault(S, 0);
        // }
    // https://www.cnblogs.com/cnoodle/p/14869498.html
    // https://leetcode.com/problems/target-sum/discuss/97334/Java-(15-ms)-C++-(3-ms)-O(ns)-iterative-DP-solution-using-subset-sum-with-explanation/239290
    // http://www.noteanddata.com/leetcode-494-Target-Sum-java-solution-note.html
    // https://www.i4k.xyz/article/gqk289/54709004
    // https://github.com/cherryljr/LeetCode/blob/master/Target%20Sum.java


        // public int coinChange(int[] coins, int amount) {
        //     int n = coins.length;
        //     Arrays.sort(coins);
        //     int [] dp = new int [amount + 1];
        //     dp[0] = 1;
        //     for (int i = n-1; i >= 0; i--) {
        //         if (dp[i] == 0) continue;
        //         for (int j = 0; j+coins[i] <= amount; j++) {
        //             dp
        //         }
        //     }
        // }

        // private int dfs(int [] a, int i) {
        //     if (i >= N) return 0;
        //     if (dp[i] > 0) return dp[i];
        //     int j = i;
        //     while (j < N && a[j] == 0) j++;
        //     if (j == N) return 0;
        //     return dp[i] = Math.max(a[j] * j + dfs(a, j+2), dfs(a, j+1));
        // }
        // int [] dp;
        // int n, N;
        // public int deleteAndEarn(int[] a) {
        //     n = a.length;
        //     N = 10001;
        //     int [] cnt = new int [N];
        //     for (Integer v : a) cnt[v]++;
        //     dp = new int [N];
        //     return dfs(cnt, 1);
        // }

        //  private int dfs(int v) {   // tle tle tle
        //     if (v == 2) return dp[v] = 1;
        //     if (v == 3) return dp[v] = 2;
        //     int ans = 1, pre = 0, cur = 0;
        //     for (int i = v/2; i >= 2; i--) {
        //         cur = i * Math.max(v-i, dfs(v-i));
        //         if (cur < pre) break;
        //         ans = Math.max(ans, cur);
        //         pre = cur;
        //     }
        //     return dp[v] = ans;
        // }
        // int [] dp;
        // int m;
        // public int integerBreak(int n) {
        //     m = n;
        //     dp = new int [n+1];
        //     return dfs(n);
        // }

        // private double dfs(int [] a, int idx, int k) {
        //     if (idx == n || k <= 0) return 0;
        //     if (dp[idx][k] != null) return dp[idx][k];
        //     if (idx == n-k || k == 1) 
        //         return dp[idx][k] = k == 1 ? avg[idx][n-1] : sum[n-1] - (idx == 0 ? 0 : sum[idx-1]);
        //     double ans = 0;
        //     for (int i = idx; i < n-(k-1); i++) 
        //         ans = Math.max(ans, avg[idx][i] + dfs(a, i+1, k-1));
        //     return dp[idx][k] = ans;
        // }
        // Double [][] dp;
        // double [][] avg;
        // int [] sum;
        // int n;
        // public double largestSumOfAverages(int[] a, int k) {
        //     n = a.length;
        //     dp = new Double [n][k+1];
        //     sum = Arrays.copyOf(a, n);
        //     for (int i = 1; i < n; i++) 
        //         sum[i] += sum[i-1];
        //     avg = new double [n][n];
        //     for (int i = 0; i < n; i++) 
        //         for (int j = i; j < n; j++) 
        //             avg[i][j] = (double)(sum[j] - (i == 0 ? 0 : sum[i-1])) / (j-i+1);
        //     return dfs(a, 0, k);
        // }

        // public int maxUncrossedLines(int[] a, int[] b) {
        //     int m = a.length, n = b.length;
        //     int [][] dp = new int [m+1][n+1];
        //     for (int i = 1; i <= m; i++) 
        //         for (int j = 1; j <= n; j++) 
        //             if (a[i-1] == b[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
        //             else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        //     return dp[m][n];
        // }

        // public int longestStrChain(String[] words) {
        //     int n = words.length, max = 1;
        //     Arrays.sort(words, (a,b)->b.length()-a.length());
        //     int [] dp = new int [n];
        //     Arrays.fill(dp, 1);
        //     Map<String, Integer> m = new HashMap<>();
        //     for (int i = 0; i < n; i++) 
        //         m.put(words[i], i);
        //     for (int i = 0; i < n; i++) {
        //         String cur = words[i];
        //         for (int j = 0; j < cur.length(); j++) {
        //             String next = (j == 0 ? "" : cur.substring(0, j)) + cur.substring(j+1);
        //             if (m.keySet().contains(next))
        //                 dp[m.get(next)] = Math.max(dp[m.get(next)], dp[i] + 1);
        //         }
        //     }
        //     for (int i = 0; i < n; i++) 
        //         max = Math.max(max, dp[i]);
        //     return max;
        // }

        // private int getMax(int [] a, int l, int r) {
        //     int max = 0;
        //     for (int i = l; i <= r; i++) 
        //         max = Math.max(max, a[i]);
        //     return max;
        // }
        // private int dfs(int [] a, int x, int y) {
        //     if (x == y) return 0;
        //     if (dp[x][y] > 0) return dp[x][y];
        //     int ans = Integer.MAX_VALUE, max = a[x];
        //     for (int i = x; i < y; i++) {
        //         max = Math.max(max, a[i]);
        //         ans = Math.min(ans, max * getMax(a, i+1, y) + dfs(a, x, i) + dfs(a, i+1, y));
        //     }
        //     return dp[x][y] = ans;
        // }
        // int [][] dp;
        // int n;
        // public int mctFromLeafValues(int[] a) { // 我终于认出你是区间型dp了，哈哈。。。
        //     int n = a.length;
        //     dp = new int [n][n];
        //     return dfs(a, 0, n-1);
        // }

        
        // public int minFlipsMonoIncr(String t) {
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     boolean hasOne = false, hasZoo = false;
        //     int cntOne = 0, cntZoo = 0;
        //     int i = 0, j = 0;
        //     while (i < n && s[i] != '1') i++;
        //     if (i == n) return 0;
        //     hasOne = true;
        //     i++;
        //     while (i < n) {
        //         if (s[i] == '0') cntZoo++;
        //         i++;
        //     }
        //     i = n-1;
        //     while (i >= 0 && s[i] != '0') i--;
        //     i--;
        //     while (i >= 0) {
        //         if (s[i] == '1') cntOne++;
        //         i--;
        //     }
        //     return Math.min(cntOne, cntZoo);
        // }


        // private int maxzigZag(TreeNode r, TreeNode p,  int l) { // left 1 or not 0
        //     if (r == null) return 0;                            // 总体思路没问题，不知道哪里细节错了
        //     String key = r + "_" + l;
        //     if (m.containsKey(key)) return m.get(key);
        //     int base = 0;
        //     if (p != null) base = 1;
        //     if (l == 1) m.put(key, Math.max(base + maxzigZag(r.right, r, 1-l), maxzigZag(r.left, r, 1)));
        //     else m.put(key, Math.max(base + maxzigZag(r.left, r, 1-l), maxzigZag(r.right, r, 0)));
        //     return m.get(key);
        // }
        // Map<String, Integer> m = new HashMap<>();
        // TreeNode GRoot;
        // public int longestZigZag(TreeNode root) {
        //     GRoot = root;
        //     return Math.max(maxzigZag(root, null, 1), maxzigZag(root, null, 0));
        // }

        //  public int maxAbsoluteSum(int[] a) {
        //     int n = a.length;
        //     int max = a[0], min = a[0];
        //     int gmax = a[0], gmin = a[0], ans = Math.abs(a[0]);
        //     ans = Math.max(ans, Math.max(Math.abs(min), max));
        //     for (int i = 1; i < n; i++) {
        //         max = Math.max(max + a[i], a[i]);
        //         min = Math.min(min + a[i], a[i]);
        //         ans = Math.max(ans, Math.max(Math.abs(min), max));
        //     }
        //     return ans;
        // }

        // public int findLongestChain(int[][] pairs) {
        //     int n = pairs.length, max = 1;
        //     int [] dp = new int [n];
        //     Arrays.sort(pairs, (a, b)->a[0] - b[0]);
        //     Arrays.fill(dp, 1);
        //     for (int i = 1; i < n; i++) {
        //         int [] cur = pairs[i];
        //         for (int j = i-1; j >= 0; j--) {
        //             int [] pre = pairs[j];
        //             if (pre[1] < cur[0])
        //                 dp[i] = Math.max(dp[i], dp[j] + 1);
        //         }
        //         max = Math.max(max, dp[i]);
        //     }
        //     return max;
        // }

        // public int minDistance(String ss, String tt) {
        //     int m = ss.length(), n = tt.length();
        //     char [] s = ss.toCharArray();
        //     char [] t = tt.toCharArray();
        //     int [][] dp = new int [m+1][n+1];
        //     for (int i = 1; i <= m; i++) 
        //         for (int j = 1; j <= n; j++) 
        //             if (s[i-1] == t[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
        //             else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        //     return m + n - 2 * dp[m][n];
        // }


        // public int maxSubArray(int[] a) {
        //     int n = a.length, ans = a[0], cur = a[0];
        //     for (int i = 1; i < n; i++) {
        //         cur = Math.max(cur + a[i], a[i]);
        //         ans = Math.max(ans, cur);
        //     }
        //     return ans;
        // }


        // public class Trie {
        //     private class Node {
        //         boolean word;
        //         Node [] next;
        //         public Node () {
        //             word = false;
        //             next = new Node [26];
        //         }
        //     }
        //     private Node root;
        //     public Trie() {
        //         root = new Node();
        //     }
        //     public void insert(String t) {
        //         char [] s = t.toCharArray();
        //         Node r = root;
        //         for (int i = 0; i < t.length(); i++) {
        //             if (r.next[s[i]-'a'] == null)
        //                 r.next[s[i]-'a'] = new Node();
        //             r = r.next[s[i]-'a'];
        //         }
        //         r.word = true;
        //     }
        //     private boolean startsWith(String ss, Node r, int idx) {
        //         System.out.println("\n idx: " + idx);
        //         System.out.println("(r == null): " + (r == null));
        //         // r = r.next[ss.charAt(idx)-'a'];
        //         // if (r == null && idx != ss.length()) return false;
        //         // // else if (r == null) return true;
        //         for (int i = idx; i < ss.length(); i++) {
        //             System.out.println("\n i: " + i);
        //             System.out.println("ss.charAt(i): " + ss.charAt(i));
        //             if (r.next[ss.charAt(i)-'a'] == null) return false;
        //             r = r.next[ss.charAt(i)-'a'];
        //             System.out.println(" (r.word && startsWith(ss, r, i+1)) : " +  (r.word && startsWith(ss, r, i+1)) );
        //             // if (r.word && startsWith(ss, r, i+1)) return true; // 被这两个函数的这种循环绕昏了
        //         }
        //         return r.word;
        //     }
        //     public boolean startsWith(String ss, int idx) { 
        //         char [] s = ss.toCharArray();
        //         Node r = root;
        //         for (int i = idx; i < ss.length(); i++) {
        //             // System.out.println("\n i: " + i);
        //             //  System.out.println("s[i]: " + s[i]);
        //             if (r.next[s[i]-'a'] == null) return false;
        //             r = r.next[s[i]-'a'];
        //             // System.out.println("r.word: " + r.word);
        //             // System.out.println("(r.word && startsWith(ss, r, i+1)): " + (r.word && startsWith(ss, r, i+1)));
        //             if (r.word && startsWith(ss, r, i+1)) return true;
        //         }
        //         return false;
        //     }
        // }
        //  public boolean wordBreak(String s, List<String> wordDict) {
        //      int n = wordDict.size();
        //      Trie t = new Trie();
        //      for (String  v : wordDict) t.insert(v);
        //      return t.startsWith(s, 0);
        //  }
         // public boolean wordBreak(String s, List<String> wordDict) { // 没有想到这个题可以用dp简简单单地写出来
         //     int n = s.length();
         //     Set<String> ss = new HashSet<>(wordDict);
         //     if (n == 1) return ss.contains(s);
         //     boolean [][] dp = new boolean [n+1][n+1];
         //     dp[0][0] = true;
         //     for (int i = 1; i <= s.length(); i++) {
         //         for (int j = i; j <= n; j++) {
         //             if (ss.contains(s.substring(i-1, j)) && (i == 1 || dp[1][i-1]))
         //                 dp[1][j] = true;
         //         }
         //     }
         //     return dp[1][n];
         // }
        // public boolean wordBreak(String s, List<String> wordDict) { // 没有想到这个题可以用dp简简单单地写出来, 改天再把这个一维的补完 todo dp[]
        //     int n = s.length();
        //     Set<String> ss = new HashSet<>(wordDict);
        //     int i = 0, j = 0;
        //     boolean [] dp = new boolean [n+1];
        //     dp[0] = true;
        //     while (j < n) {
        //         while (j < n && !ss.contains(s.substring(i, j))) j++;
        //         if (j == n) return ss.contains(s.substring(i, j)) && dp[i+1];
        //         if (dp[i]) dp[j+1] = true;
        //     }
        //     return false;
        // }

        // private void backTracking(String s, int idx, List<String> l) { // bug: 对长重复字符的处理 问题 ？？？ todo: 总结重复字符和数字的处理
        //     if (idx == n) {
        //         // if (!ans.contains(l)) // 注意：这里不需要判断，严密工整的算法，不会有重复 ，多加这一句，下面的case就过不了了。。。。。。
        //             ans.add(new ArrayList<>(l));
        //         return ;
        //     }
        //     for (int i = idx; i < n; i++) {
        //         if (!f[idx][i]) continue;
        //         l.add(s.substring(idx, i+1));
        //         backTracking(s, i+1, l);
        //         l.remove(l.size()-1);
        //     }
        // }
        // List<List<String>> ans = new ArrayList<>();
        // boolean [][] f;
        // int n;
        // public List<List<String>> partition(String t) {
        //     n = t.length();
        //     char [] s = t.toCharArray();
        //     f = new boolean [n][n];
        //     for (int i = n-1; i >= 0; i--) {
        //         f[i][i] = true;
        //         for (int j = i; j < n; j++) 
        //             f[i][j] = s[i] == s[j] && (j-i <= 2 || f[i+1][j-1]);
        //     }
        //     backTracking(t, 0, new ArrayList<>());
        //     return ans;
        // }  // "bbbbbbbbbbbbbbbb"

        // public boolean isSubsequence(String ss, String tt) {
        //     int m = ss.length(), n = tt.length();
        //     char [] s = ss.toCharArray();
        //     char [] t = tt.toCharArray();
        //     int i = 0, j = 0;
        //     while (i < m && j < n) {
        //         while (i < m && j < n && s[i] == t[j]) {
        //             i++;
        //             j++;
        //         }
        //         if (i < m && j < n && s[i] != t[j]) j++;
        //     }
        //     return i >= m;
        // }

        // public int numSquares(int n) {
        //     if (n < 5) return n >= 2 && n <= 3 ? n : 1;
        //     int [] dp = new int [n+1];
        //     dp[1] = 1;
        //     dp[2] = 2;
        //     dp[3] = 3;
        //     dp[4] = 1;
        //     for (int i = 5; i <= n; i++) {
        //         dp[i] = n;
        //         for (int j = (int)Math.sqrt(i); j >= 1; j--) 
        //             dp[i] = Math.min(dp[i], 1 + dp[i-j*j]);
        //     }
        //     return dp[n];
        // }

        // public int coinChange(int[] a, int amount) {
        //     int n = a.length;
        //     int [] dp = new int [amount + 1];
        //     Arrays.sort(a);
        //     Arrays.fill(dp, Integer.MAX_VALUE);
        //     dp[0] = 0;
        //     for (int i = n-1; i >= 0; i--)
        //     // for (int i = 0; i < n; i++) 
        //         for (int j = 0; j+a[i] <= amount; j++) {
        //             if (dp[j] == Integer.MAX_VALUE) continue;
        //             dp[a[i] + j] = Math.min(dp[a[i]+j], dp[j] + 1);
        //         }
        //     return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
        // }
        // public int change(int amount, int[] a) { 
        //     int n = a.length;
        //     int [] dp = new int [amount+1];
        //     dp[0] = 1;
        //     for (Integer v : a) 
        //         for (int i = 0; i <= amount-v; i++) 
        //             if (dp[i] > 0)
        //                 dp[i+v] += dp[i];
        //     return dp[amount];
        // }

        // private double dfs(int i, int j, int k) {
        //     if (i < 0 || i >= n || j < 0 || j >= n) return 0;
        //     if (k == 0) return 1;
        //     if (dp[i][j][k] != null) return dp[i][j][k];
        //     double ans = 0;
        //     for (int [] d : dirs) 
        //         ans += 0.125 * dfs(i+d[0], j+d[1], k-1);
        //     return dp[i][j][k] = ans;
        // }
        // int [][] dirs = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
        // Double [][][] dp;
        // int n;
        // public double knightProbability(int n, int k, int row, int column) {
        //     this.n = n;
        //     dp = new Double[n][n][k+1];
        //     return dfs(row, column, k);
        // }

        // public int maxSumDivThree(int[] a) {
        //     int n = a.length, N = 10000, minOne = N, secOne = N, minTwo = N, secTwo = N, sum = Arrays.stream(a).sum();
        //     for (Integer v : a) {
        //         if (v % 3 == 1) {
        //             if (minOne == N) minOne = v;
        //             else if (v <= minOne) {
        //                 secOne = minOne;
        //                 minOne = v;
        //             } else if (v < secOne)
        //                 secOne = v;
        //         } else if (v % 3 == 2) {
        //             if (minTwo == N) minTwo = v;
        //             else if (v <= minTwo) {
        //                 secTwo = minTwo;
        //                 minTwo = v;
        //             } else if (v < secTwo)
        //                 secTwo = v;
        //         }
        //     }
        //     int v = sum % 3;
        //     if (v == 0) return sum;
        //     if (v == 1) return sum - Math.min(minOne , minTwo + secTwo);
        //     else return sum - Math.min(minOne + secOne , minTwo);
        // }
        // public int maxSumDivThree(int[] nums) {
        //     int res = 0, leftOne = 20000, leftTwo = 20000;
        //     for(int n:nums){
        //         res+=n;
        //         if(n%3==1){
        //             leftTwo = Math.min(leftTwo,leftOne+n);
        //             leftOne = Math.min(leftOne,n);
        //         }
        //         if(n%3==2) {
        //             leftOne = Math.min(leftOne,leftTwo+n);
        //             leftTwo = Math.min(leftTwo,n);
        //         }
        //     }
        //     if(res%3==0) return res;
        //     if(res%3==1) return res-leftOne;
        //     return res - leftTwo;
        // }
        // public int maxSumDivThree(int[] a) {
        //     int n = a.length;
        //     int [][] dp = new int [3][n+1];
        //     for (int i = 1; i <= n; i++)  {
        //         int v = a[i-1];
        //         for (int j = 0; j < 3; j++) { // for 3 remainders possible i.e. 0, 1, 2
        //             int sum = dp[j][i-1] + v; // add cur number with previous sum for all remainders each.
        //             int newRemainder = sum % 3;
        //             dp[newRemainder][i] = Math.max(dp[newRemainder][i], sum); // hold sum for new remainder 
        //             dp[j][i] = Math.max(dp[j][i-1], dp[j][i]); // check if we can pick max sum from previous location
        //         }
        //     }
        //     return dp[0][a.length];
        // }

        // private int dfs(int [] a, int i, int j) {
        //     if (i > j) return 0;
        //     if (dp[i][j] != Integer.MIN_VALUE) return dp[i][j];
        //     return dp[i][j] = Math.max(a[i] -dfs(a, i+1, j), a[j] - dfs(a, i, j-1));
        // }
        // int [][] dp;
        // int n;
        // public boolean PredictTheWinner(int[] a) {
        //     n = a.length;
        //     dp = new int [n][n];
        //     for (int i = 0; i < n; i++) 
        //         Arrays.fill(dp[i], Integer.MIN_VALUE);
        //     return dfs(a, 0, n-1) >= 0;
        // }
        // public boolean PredictTheWinner(int[] a) { // DP的写法还是要习惯起来，看着好别扭 todo: review dp solutions of this type
        //     int sum = Arrays.stream(a).sum();
        //     int [][] dp = new int[a.length][a.length];
        //     for (int i = a.length - 1; i >= 0; i--) 
        //         for (int j = i; j < a.length; j++) {
        //             if (j == i) dp[i][j] = a[i];
        //             if (j - i == 1) dp[i][j] = Math.max(a[i], a[j]);
        //             if (j - i >= 2 && i + 2 < a.length && j - 2 >= 0) 
        //                 dp[i][j] = Math.max(a[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]),
        //                                     a[j] + Math.min(dp[i][j - 2], dp[i + 1][j - 1]));
        //         }
        //     return dp[0][a.length - 1] * 2 >= sum;
        // }

        // public int videoStitching(int[][] clips, int time) { // bug bug bug 
        //     int n = clips.length;
        //     Arrays.sort(clips, (a, b)-> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        //     if (clips[0][0] > 0) return -1;
        //     int [] dp = new int [n];
        //     Arrays.fill(dp, n);
        //     dp[0] = 0;
        //     int min = n+1;
        //     for (int i = 0; i < n; i++) {
        //         int [] c = clips[i];
        //         for (int j = i-1; j >= 0; j--) {
        //             int [] p = clips[j];
        //             if (p[1] < c[0]) continue;
        //             dp[i] = Math.min(dp[i], dp[j] + 1);
        //         }
        //         if (c[1] >= time) min = Math.min(min, dp[i]);
        //     }
        //     return min == n+1 ? -1 : min;
        // }

        
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        // int [][] a = new int [][] {{0,1},{6,8},{0,2},{5,6},{0,4},{0,3},{6,7},{1,3},{4,7},{1,4},{2,5},{2,6},{3,4},{4,5},{5,7},{6,9}};
        int [][] a = new int [][] {{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}};

        int r = s.videoStitching(a, 10);
        System.out.println("r: " + r);
    }
}
        
