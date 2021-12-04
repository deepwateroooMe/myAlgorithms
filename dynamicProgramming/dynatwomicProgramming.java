// import com.UnionFind;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class dynatwomicProgramming {
    public static class Solution {
        // public int mctFromLeafValues(int[] arr) {
        //     int n = arr.length;
        //     if ( n == 2) return arr[0]* arr[1];
        //     int [][] dp = new int[n][n];
        // }
        // public int countSubstrings(String s) {
        //     int n = s.length();
        //     int [][] arr = new int[n][n];
        //     boolean [][] p = new boolean[n][n];
        //     for (int i = 0; i < n; i++) 
        //         arr[i][0] = 
        //             }
        // public int minCut(String s) {
        //     int n = s.length();
        //     int [] dp = new int[n+1];
        //     boolean [][] p = new boolean[n][n];
        //     // the worst case if cutting by each char
        //     for (int i = 0; i <= n; i++) 
        //         dp[i] = n-1-i;
        //     for (int i = n-1; i >= 0; i--) {
        //         for (int j = i; j < n; j++) {
        //             // 在原回文的基础上————前后再各加一个字符
        //             if (s.charAt(i) == s.charAt(j) && (j-i < 2 || p[i+1][j-1])) {
        //                 p[i][j] = true;
        //                 dp[i] = Math.min(dp[i], dp[j+1]+1);
        //             }
        //         }
        //     }
        //     return dp[0];
        // }

        
        // public double nthPersonGetsNthSeat(int n) {
        //     if(n==1) return 1.0;
        //     double[] dp = new double[n];
        //     double sum = 0;
        //     for (int i = 1; i < n; i++) {
        //         dp[i] =  (1 + sum) / (i + 1);
        //         sum += dp[i];
        //     }
        //     return dp[n - 1];
        // }
        // public int minDistance(String word1, String word2) {
        //     int m = word1.length();
        //     int n = word2.length();
        //     int [][] dp = new int[m+1][n+1];
        //     for (int i = 1; i <= m; i++) {
        //         for (int j = 1; j <= n; j++) {
        //             if (word1.charAt(i-1) == word2.charAt(j-1)) 
        //                 dp[i][j] = dp[i-1][j-1] + 1;
        //             else
        //                 dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        //         }
        //     }
        //     return m + n - 2 * dp[m][n];
        // }
        // public int minDistance(String word1, String word2) {
        //     int m = word1.length();
        //     int n = word2.length();
        //     int [][] dp = new int[m+1][n+1];
        //     for (int i = 0; i <= m; i++) dp[i][0] = i;
        //     for (int j = 0; j <= n; j++) dp[0][j] = j;
        //     for (int i = 1; i <= m; i++) {
        //         for (int j = 1; j <= n; j++) {
        //             if (word1.charAt(i-1) == word2.charAt(j-1)) 
        //                 dp[i][j] = dp[i-1][j-1];
        //             else
        //                 dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1]);
        //         }
        //     }
        //     return dp[m][n];
        // }
        // private int helper(String s, String t, int i, int j, int [][] arr) {
        //     if (arr[i][j] != 0) return arr[i][j];
        //     if (i == m || j == n) return m+n-i-j;
        //     if (s.charAt(i) == t.charAt(j))
        //         arr[i][j] = helper(s, t, i+1, j+1, arr);
        //     else
        //         arr[i][j] = Math.min(helper(s, t, i+1, j, arr), helper(s, t, i, j+1, arr)) + 1;
        //     return arr[i][j];
        // }
        // int m, n;
        // public int minDistance(String word1, String word2) {
        //     m = word1.length();
        //     n = word2.length();
        //     int [][] dp = new int[m+1][n+1];
        //     return helper(word1, word2, 0, 0, dp);
        // }
        //     public int minimumDeleteSum(String s1, String s2) {
        //         int m = s1.length();
        //         int n = s2.length();
        //         int [][] dp = new int[m+1][n+1];
        //         for (int j = 1; j < n+1; j++)
        //             dp[0][j] = dp[0][j-1] + s2.charAt(j-1);
        //         for (int i = 1; i <= m; i++) {
        //             dp[i][0] = dp[i-1][0] + s1.charAt(i-1);
        //             for (int j = 1; j <= n; j++) {
        //                 if (s1.charAt(i-1) == s2.charAt(j-1))
        //                     dp[i][j] = dp[i-1][j-1];
        //                 else
        //                     dp[i][j] = Math.min(dp[i-1][j] + s1.charAt(i-1), dp[i][j-1] + s2.charAt(j-1));
        //             }
        //         }
        //         return dp[m][n];
        //     }
        // // https://www.cnblogs.com/grandyang/p/7752002.html
        //     int minimumDeleteSum(string s1, string s2) { // 这个一维的和另一个题目再好好想一想
        //         int m = s1.size(), n = s2.size();
        //         vector<int> dp(n + 1, 0);
        //         for (int j = 1; j <= n; ++j) dp[j] = dp[j - 1] + s2[j - 1];
        //         for (int i = 1; i <= m; ++i) {
        //             int t1 = dp[0];
        //             dp[0] += s1[i - 1];
        //             for (int j = 1; j <= n; ++j) {
        //                 int t2 = dp[j];
        //                 dp[j] = (s1[i - 1] == s2[j - 1]) ? t1 : min(dp[j] + s1[i - 1], dp[j - 1] + s2[j - 1]);
        //                 t1 = t2;
        //             }
        //         }
        //         return dp[n];
        //     }
        
        // public boolean isPrintable(int[][] targetGrid) {
        //     int m = targetGrid.length;
        //     int n = targetGrid[0].length;
        //     int [][] dp = new int[m][n];
        //     for (int i = n-1; i >= 0; i--) {
        //         for (int j = i; j < n; j++) {
        //             dp[i][j] = i == j ? 1 : 1+dp[i+1][j];
        //             for (int k = i+1; k <= j; k++) {
        //                 if (targetGrid)
        //             }
        //         }
        //     }
        // }
        // public int strangePrinter(String s) {
        //     int n = s.length();
        //     int [][] dp = new int[n][n];
        //     for (int i = n-1; i >= 0; i--) {
        //         for (int j = i; j < n; j++) {
        //             dp[i][j] = i == j ? 1 : 1+dp[i+1][j];
        //             // 对于[i, j]范围的字符，我们从i+1位置上的字符开始遍历到j，[i+1 <= k <= j]
        //             // 如果 k 位和 i 位置上的字符相等，我们就以此位置为界，将[i+1, j]范围内的字符拆为两个部分，
        //             // 并将二者的dp值加起来，和原dp值相比，取较小的那个。
        //             for (int k = i+1; k <= j; k++) {
        //                 if (s.charAt(k) == s.charAt(i))
        //                     dp[i][j] = Math.min(dp[i][j], dp[i+1][k-1]+dp[k][j]);
        //             }
        //         }
        //     }
        //     return (n == 0) ? 0 : dp[0][n-1];
        // }
        // private int helper(String s, int [][] arr, int i, int j) {
        //     if (i > j) return 0;
        //     if (arr[i][j] > 0) return arr[i][j];
        //     arr[i][j] = helper(s, arr, i+1, j) + 1;
        //     for (int k = i+1; k <= j; k++) {
        //         if (s.charAt(i) == s.charAt(k))
        //             arr[i][j] = Math.min(arr[i][j], helper(s, arr, i+1, k-1) + helper(s, arr, k, j));
        //     }
        //     return arr[i][j];
        // }
        // public int strangePrinter(String s) {
        //     int n = s.length();
        //     int [][] arr = new int[n][n];
        //     return helper(s, arr, 0, n-1);
        // }
        // public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        //     int n = nums.length;
        //     int [] arr = new int [n]; // prefixSum
        //     arr[0] = nums[0];
        //     for (int i = 1; i < n; i++) 
        //         arr[i] = arr[i-1] + nums[i];
        //     int [][] dp = new int[n][n];
        //     int sum = 0, max = 0;
        //     int j = 0;
        //     for (int i = 0; i <= n-firstLen; i++) {
        //         sum = 0;
        //         j = i + firstLen;
        //         sum += arr[j-1] - (i==0 ? 0 : arr[i-1]);
        //         if (j-1 + secondLen <= n-1) {
        //             for (int k = j; k < n; k++) {
        //                 if (k + secondLen <= n) 
        //                     max = Math.max(max, sum + arr[k+secondLen-1] - arr[k-1]);
        //             }
        //         }
        //         if (secondLen < i) {
        //             for (int k = 0; k+secondLen < i; k++) {
        //                 if (k + secondLen < i) 
        //                     max = Math.max(max, sum + arr[k+secondLen-1] - (k-1 >= 0 ? arr[k-1] : 0));
        //             }
        //         }
        //     }
        //     return max;
        // }
        // public int mincostTickets(int[] days, int[] costs) {
        //     int n = days.length;
        //     if (n == 1) return costs[0];
        //     int [] dp = new int[n];
        //     dp[0] = costs[0];
        //     for (int i = 1; i < n; i++) {
        //         if (i < 6)
        //     }
        // }
        // int []  a = new int []  {1, 4, 6, 7, 8, 20}; 
        // int [] b = new int [] {2, 7, 15}; 
        // int res = s.mincostTickets(a, b);


// public int maxSubArray(int[] nums) {
        //     int res = nums[0], sum = 0;
        //     for (int i = 0; i < nums.length; i++) {
        //         sum = Math.max(sum + nums[i], nums[i]);
        //         res = Math.max(res, sum);
        //     }
        //     return res;
        // }
        // public int maxAbsoluteSum(int[] nums) {
        //     int n = nums.length;
        //     int max = nums[0], min = nums[0]; // global max s
        //     int maxSum = 0, minSum = 0; // local max s
        //     for (int i = 0; i < n; i++) {
        //         maxSum = Math.max(maxSum + nums[i], nums[i]);
        //         minSum = Math.min(minSum + nums[i], nums[i]);
        //         max = Math.max(max, maxSum);
        //         min = Math.min(min, minSum);
        //     }
        //     return max >= Math.abs(min) ? max : Math.abs(min);
        // }
        

        // List<String> ls = new ArrayList<>();
        // boolean [] vis;
        // private void helper(int n, StringBuilder s) {
        //     if (s.length() == n) {
        //         if (!ls.contains(s.toString()))
        //             ls.add(s.toString());
        //         return;
        //     }
        //     for (int i = 0; i < 5; i++) {
        //         char c = arr[i];
        //         if (s.length() == 0 || c >= s.charAt(s.length()-1)) {
        //             s.append(c);
        //             helper(n, s);
        //             s.deleteCharAt(s.length()-1);
        //         }
        //     }
        // }
        // char [] arr = {'a', 'e', 'i', 'o', 'u'};
        // private int cnt(int val, char c) {
        //     if (val == 0) return 0;
        //     if (val == 1) {
        //         switch (c) {
        //         case 'a': return 5;
        //         case 'e': return 4;
        //         case 'i': return 3;
        //         case 'o': return 2;
        //         case 'u': return 1;
        //         default:
        //             return 5;
        //         }
        //     }
        //     int  res = 0, cnt = 0;
        //     for (char ac : arr) {
        //         if (ac < c) continue;
        //         cnt = cnt(val-1, ac);
        //         res += cnt;
        //     }
        //     return res;
        // }
        // public int countVowelStrings(int n) {
        //     return cnt(n, (char)('a'-1));
        // }
        // public int mctFromLeafValues(int[] arr) {
        //     int n = arr.length;
        //     if (n == 2) return arr[0] * arr[1];
        //     int [][] dp = new int[n][n];
        // }
        // private boolean isValid(String s, String t) {
        //     int n = s.length();
        //     if (n - t.length() > 1 || n - t.length() == 0) return false;
        //     int i = 0, j = 0;
        //     int cnt = 0;
        //     for (i = 0; i < n; i++) {
        //         if (j == t.length()) return cnt < 1;
        //         if (s.charAt(i) != t.charAt(j)) {
        //             ++cnt;
        //             if (cnt > 1) return false;
        //             continue;
        //         } else ++j;
        //     }
        //     return true;
        // }
        // public int longestStrChain(String[] words) {
        //     int n = words.length;
        //     Arrays.sort(words, new java.util.Comparator<String>() {
        //             @Override public int compare(String s, String t) {
        //                 int comp = t.length() - s.length();
        //                 if (comp != 0) return comp;
        //                 for (int i = 0; i < s.length(); i++) {
        //                     if (s.charAt(i) != t.charAt(i))
        //                         return s.charAt(i) - t.charAt(i);
        //                 }
        //                 return -1; 
        //             }
        //         });
        //     int [] dp = new int [n];
        //     Arrays.fill(dp, 1);
        //     for (int i = 1; i < n; i++) {
        //         for (int j = 0; j < i; j++) {
        //             if (isValid(words[j], words[i]))
        //                 dp[i] = Math.max(dp[j]+1, dp[i]);
        //         }
        //     }
        //     int max = 0;
        //     for (int i = 0; i < n; i++) 
        //         max = Math.max(max, dp[i]);
        //     return max;
        // }
        // public int maxProfit(int[] prices, int fee) {
        //     int n = prices.length;
        //     int [] dp = new int [n];
        //     int max = prices[0];
        //     int min = prices[0];
        //     int locMin = prices[0], locMax = prices[0];
        //     for (int i = 1; i < n; i++) {
        //         min = Math.min(min, prices[i]);
        //         max = Math.max(max, prices[i]);
        //         if (prices[i] > prices[i-1]) {
        //             locMax = Math.max(locMax, prices[i]);
        //             if (prices[i] - prices[i-1] - fee > 0) {
        //                 dp[i] = Math.max(dp[i], dp[i-1]+prices[i] - prices[i-1] - fee);
        //                 if (dp[i] < locMax - locMin - fee) {
        //                     dp[i] = Math.max(dp[i], dp[i-1]+locMax-locMin-fee);
        //                     locMin = locMax;
        //                     locMax = 0;
        //                 }
        //                 if (max - min - fee > dp[i]) {
        //                     dp[i] = Math.max(dp[i], max-min-fee);
        //                     // locMin = locMax;
        //                     // locMax = 0;
        //                     min = max;
        //                     max = 0;
        //                 }
        //             }
        //         } else if (prices[i] < prices[i-1]) { // 这些拐点的地方什么时候重置哪些变量，再想想
        //             // 最好这里更新上一次交易赢利
        //             locMin = Math.min(locMin, prices[i]);
        //             dp[i] = dp[i-1];
        //         }
        //     }
        //     System.out.println("dp.length: " + dp.length);
        //     for (int z = 0; z < dp.length; ++z) 
        //         System.out.print(dp[z] + ", ");
        //     System.out.println("");
        //     max = dp[0];
        //     for (int i = 1; i < n; i++) 
        //         max = Math.max(max, dp[i]);
        //     return max;
        // }
        
        // public int minimumDeletions(String s) {
        //     int n = s.length();
        //     int [] bb = new int [n]; // n <= 10^5 最好是用BIT吧
        //     int [] aa = new int [n]; // 如果删除一个，更新后面的sum更快？
        //     int cntA = 0, cntB = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (s.charAt(i) == 'b') ++cntB;
        //         bb[i] = cntB;
        //     }
        //     for (int i = n-1; i >= 0; i--) {
        //         if (s.charAt(i) == 'a') ++cntA;
        //         aa[i] = cntA;
        //     } // 可是接下来的还木有想好怎么写。。。
        //     System.out.println("bb.length: " + bb.length);
        //     for (int z = 0; z < bb.length; ++z) 
        //         System.out.print(bb[z] + ", ");
        //     System.out.println("");
        //     System.out.println("aa.length: " + aa.length);
        //     for (int z = 0; z < aa.length; ++z) 
        //         System.out.print(aa[z] + ", ");
        //     System.out.println("");
        //     return 0;
        // }
        // String a = "aababbab";
        // System.out.println("a: " + a);
        // int res = s.minimumDeletions(a);
        // System.out.println("res: " + res);
        // public int deleteAndEarn(int[] arr) {
        //     int n = arr.length;
        //     int sum = 0;
        //     HashMap<Integer, Integer> m = new HashMap<>();
        //     for (int i = 0; i < n; i++) {
        //         // m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
        //         m.put(arr[i], m.getOrDefault(m, 0)
        //         sum += arr[i];
        //     }
        //     // System.out.println("m.size(): " + m.size());
        //     // for (Map.Entry<Integer, Integer> entry : m.entrySet()) 
        //     //     System.out.print(entry.getKey() + ", " + entry.getValue() + "\n");
        //     int [] dp = new int[m.size()];
        //     int i = 0;
        //     Map<Integer, Set<Integer>> ss = new HashMap<>();
        //     for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
        //         ss.clear();
        //         int key = entry.getKey();
        //         for (Integer k : map.keySet()) {
        //             if (k == key) continue;
        //             if (k == key+1 || k == key-1) {
        //                 ss.put(key, ss.getOrDefault(key, sum) - k*map.get(k));
        //             }
        //         }
        //     }
        //     return 0;
        // }
        // public int integerBreak(int n) {
        //     if (n == 2) return 1;
        //     if (n == 3) return 2;
        //     if (n % 3 = 0) return (n/3)
        // }
        // public int minSteps(int n) {
        //     if (n == 1) return 0;
        //     if (n <= 5) return n;
        //     int [] dp = new int[n+1];
        //     Arrays.fill(dp, Integer.MAX_VALUE);
        //     for (int i = 1; i <= 5; i++) 
        //         dp[i] = i;
        //     for (int i = 6; i < n; i++) {
        //         for (int j = 2; j <= n/2; j++) {
        //             dp[i] = Math.min(dp[i], b)
        //         }
        //     }
        // }

        
        // public boolean divisorGame(int n) {
        //     boolean[] dp = new boolean[n+1];
        //     for (int k = 1; k <= n; ++k) {
        //         for (int i = 1; i <= Math.sqrt(k) && i < k; ++i) {
        //             if (k%i == 0 && !dp[k-i]) {
        //                 dp[k] = true;
        //                 break;
        //             }
        //         }
        //     }
        //     return dp[n];
        // }
        // public int mincostTickets(int[] days, int[] costs) {
        //     int n = days.length;
        //     int lastday = days[n-1];
        //     int [] dp = new int[lastday + 1];
        //     dp[0] = 0;
        //     boolean [] vis = new boolean[lastday + 1];
        //     for (int d : days) 
        //         vis[d] = true;
        //     for (int i = 1; i <= lastday; i++) {
        //         if (!vis[i]) {
        //             dp[i] = dp[i-1];
        //             continue;
        //         }
        //         dp[i] = dp[i-1] + costs[0];
        //         dp[i]= Math.min(dp[i], dp[Math.max(0, i-7)] + costs[1]);
        //         dp[i] = Math.min(dp[i], dp[Math.max(0, i-30)] + costs[2]);
        //     }
        //     return dp[lastday];
        // }
        // private int help(int [][] arr, int i, int j) {
        //     if (dp[i][j] != 0) return dp[i][j];
        //     if (i == m-1 || j == n-1) return arr[i][j];
        //     if (arr[i][j] == 0) return 0;
        //     int bottom = help(arr, i+1, j);
        //     int right = help(arr, i, j+1);
        //     int bottomright = help(arr, i+1, j+1);
        //     int res = Math.min(Math.min(bottom, right), bottomright) + 1;
        //     dp[i][j] = res;
        //     return res;
        // }
        // int [][] dp;
        // int m, n;
        // public int countSquares(int[][] matrix) {
        //     m = matrix.length;
        //     n = matrix[0].length;
        //     dp = new int[m][n];
        //     int res = 0;
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) 
        //             res += help(matrix, i, j);
        //     return res;
        // }
        // public int countSquares(int[][] matrix) {
        //     int m = matrix.length;
        //     int n = matrix[0].length;
        //     int [][] preRow = new int[m][n];
        //     int [][] preCol = new int[m][n];
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) {
        //             if (j == 0) preRow[i][j] = matrix[i][j];
        //             else preRow[i][j] = preRow[i][j-1] + matrix[i][j];
        //         }
        //     for (int j = 0; j < n; j++) 
        //         for (int i = 0; i < m; i++) {
        //             if (i == 0) preCol[i][j] = matrix[i][j];
        //             else preCol[i][j] = preCol[i-1][j] + matrix[i][j];
        //         }
        //     int res = 0;
        //     for (int i = 0; i < m; i++) {
        //         for (int j = 0; j < n; j++) {
        //             if (matrix[i][j] == 0) continue;
        //             res ++;
        //             for (int k = 1; i+k < m && j+k < n; k++) {
        //                 int sum = preRow[i+k][j+k] - (j == 0 ? 0 : preRow[i+k][j-1]);
        //                 if (sum != k+1) break;
        //                 sum = preCol[i+k][j+k] - (i == 0 ? 0 : preCol[i-1][j+k]);
        //                 if (sum != k+1) break;
        //                 res ++;
        //             }
        //         }
        //     }
        //     return res;
        // }
        // public int mctFromLeafValues(int[] arr) {
        //     int n = arr.length;
        //     int [][] dp = new int [n][n];
        //     int [][] max = new int [n][n];
        //     int locMax = 0;
        //     for (int i = 0; i < n; i++) {
        //         locMax = 0;
        //         for (int j = i; j < n; j++) {
        //             locMax = Math.max(locMax, arr[j]);
        //             max[i][j] = locMax;
        //         }
        //     }
        //     for (int d = 1; d < n; d++) {
        //         for (int i = 0; i+d < n; i++) {
        //             int j = i + d;
        //             dp[i][j] = Integer.MAX_VALUE;
        //             for (int k = i; k < j; k++) 
        //                 dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + max[i][k]*max[k+1][j]);
        //         }
        //     }
        //     return dp[0][n-1];
        // }
        // public int mctFromLeafValues(int[] arr) {
        //     int n = arr.length;
        //     int res = 0;
        //     Stack<Integer> st = new Stack<>();
        //     for (int v : arr) {
        //         while (!st.isEmpty() && st.peek() <= v) 
        //             res += st.pop() * Math.min(st.isEmpty() ? Integer.MAX_VALUE : st.peek(), v);
        //         st.push(v);
        //     }
        //     int tmp = st.pop();
        //     while (!st.isEmpty()) {
        //         res += tmp * st.peek();
        //         tmp = st.pop();
        //     }
        //     return res;
        // }
        
        
        // public int numSubmat(int[][] mat) {
        //     int m = mat.length;
        //     int n = mat[0].length;
        //     int [][] dp = new int [n][n];
        //     for (int i = 0; i < m; i++) {
        //         for (int j = 0; j < n; j++) {
        //             if (j == 0) {
        //                 dp[i][j] = mat[i][j] == 0 ? 0 : 1;
        //                 continue;
        //             }
        //             dp[i][j] = mat[i][j] == 0 ? 0 : dp[i][j-1] + 1;
        //         }
        //     }
        //     int min = Integer.MAX_VALUE;
        //     for (int i = 1; i < n; i++) {
        //         min = Integer.MAX_VALUE;
        //         for (int j = 0; j < n; j++) {
        //             for (int k = 1; j+k < n; k++) {
        //             }
        //             dp[i][j] = 
        //         }
        //     }
        // }
        // public int waysToMakeFair(int[] nums) {
        //     int n = nums.length;
        //     int [] od = new int [n/2 + 1 + n% 2 == 0 ? 0 : 1];
        //     int [] en = new int [n/2 + 1];
        //     int io = 0, ie = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (i % 2 == 0) en[ie] = nums[i] + en[ie++-1];
        //         else od[io] = nums[i] + od[io++-1];
        //     }
        //     System.out.println("od.length: " + od.length);
        //     for (int z = 0; z < od.length; ++z) 
        //         System.out.print(od[z] + ", ");
        //     System.out.println("");
        //     System.out.println("en.length: " + en.length);
        //     for (int z = 0; z < en.length; ++z) 
        //         System.out.print(en[z] + ", ");
        //     System.out.println("");
        // }

        
        // private void helper(String s, int i, int j) {
        //     while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
        //         --i;
        //         ++j;
        //         ++res;
        //     }
        // }
        // int res = 0;
        // public int countSubstrings(String s) {
        //     int n = s.length();
        //     res = 0;
        //     for (int i = 0; i < n; i++) {
        //         helper(s, i, i);
        //         helper(s, i, i+1);
        //     }
        //     return res;
        // }
        // public int countSubstrings(String s) {
        //     int n = s.length();
        //     boolean [][] dp = new boolean[n][n];
        //     int res = 0;
        //     for (int i = n-1; i >= 0; i--) {
        //         for (int j = i; j < n; j++) {
        //             dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i+1][j-1]);
        //             if (dp[i][j]) res ++;
        //         }
        //     } 
        //     return res;
        // }

        
        // int min = Integer.MAX_VALUE;
        // private boolean considerable(List<Integer> nee, List<Integer> off, List<Integer> pri) {
        //     if (nee.size() == 1 && off.get(off.size()-1) > pri.get(0)) return false;
        //     for (int i = 0; i < nee.size(); i++) 
        //         if (nee.get(i) < off.get(i)) return false;
        //     return true;
        // }
        // private void helper(List<List<Integer>> ll, List<Integer> li, int val, List<Integer> price) {
        //     for (int i = 0; i < ll.size(); i++) {
        //         if (considerable(li, ll.get(i), price)) {
        //             List<Integer> l = new ArrayList<>(li);
        //             int cnt = 0;
        //             for (int j = 0; j < l.size(); j++) {
        //                 l.set(j, l.get(j)-ll.get(i).get(j));
        //                 if (l.get(j) == 0) ++cnt;
        //             }
        //             if (cnt == l.size()) {
        //                 if (val + ll.get(i).get(ll.get(i).size()-1) < min)
        //                     min = val + ll.get(i).get(ll.get(i).size()-1);
        //                 return;
        //             }
        //             helper(ll, l, val + ll.get(i).get(ll.get(i).size()-1), price);
        //         }
        //     }
        //     for (int i = 0; i < li.size(); i++) 
        //         val += li.get(i)* price.get(i);
        //     if (val < min) min = val;
        // }
        // public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        //     int cnt = 0;
        //     for (int i = 0; i < price.size(); i++) 
        //         if (price.get(i) == 0) ++cnt;
        //     if (cnt == price.size()) return 0;
        //     int n = price.size();
        //     int m = special.size();
        //     helper(special, needs, 0, price);
        //     return min;
        // }


        // public int minimumDeletions(String s) {
        //     int n = s.length();
        //     if (n == 1) return 0;
        //     int [] bb = new int [n]; 
        //     int [] aa = new int [n]; 
        //     int cntA = 0, cntB = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (s.charAt(i) == 'b') ++cntB;
        //         bb[i] = cntB;
        //     }
        //     for (int i = n-1; i >= 0; i--) {
        //         if (s.charAt(i) == 'a') ++cntA;
        //         aa[i] = cntA;
        //     }
        //     int res = 0;       
        //     int min = Integer.MAX_VALUE;
        //     for (int i = 0; i < n; i++) {
        //         if (bb[i] == 0 || aa[i] == 0) continue;
        //         min = Math.min(min, (i == 0 ? 0 : bb[i]) + (i == n-1 ? 0 : aa[i])-1);
        //     }
        //     // String a = "aaaaaabbbbabaaaabbabaaabbabbbaaabababaaaaaaabbaaabaaababaaabababa";
        //     return min == Integer.MAX_VALUE ? 0 : min;
        // }
        // public int minimumDeletions(String s) {
        //     int n = s.length();
        //     int acnt = 0, bcnt = 0;
        //     for (int i = 0; i < n; i++) 
        //         acnt += s.charAt(i) == 'a' ? 1 : 0;
        //     int res = acnt; //change string s to be all b-s
        //     for (int i = 0; i < n; i++) {
        //         bcnt += s.charAt(i) == 'b' ? 1 : 0;
        //         acnt -= s.charAt(i) == 'a' ? 1 : 0;
        //         res = Math.min(res, acnt + bcnt - (s.charAt(i) == 'b' ? 1 : 0));
        //     }
        //     return res;
        // }
        // public int minFlipsMonoIncr(String s) {
        //     int n = s.length();
        //     int res = 0;
        //     for (int i = 0; i < n; i++) 
        //         res += s.charAt(i) == '0' ? 1 : 0;
        //     int one = 0;
        //     int zero = res;
        //     for (int i = 0; i < n; i++) {
        //         one += s.charAt(i) == '1' ? 1 : 0;
        //         zero -= s.charAt(i) == '0' ? 1 : 0;
        //         res = Math.min(res, one + zero - (s.charAt(i) == '1' ? 1 : 0));
        //     }
        //     return res;
        // }

        // public String longestPalindrome(String s) {
        //     int n = s.length();
        //     boolean [][] f = new boolean[n][n];
        //     int idx = 0, max = 1;
        //     for (int i = 0; i < n; i++) {
        //         f[i][i] = true;
        //         for (int j = 0; j < i; j++) {
        //             f[j][i] = (s.charAt(i) == s.charAt(j) && (i-j < 2 || f[j+1][i-1])); // i, ii, ixi, iaxai
        //             if (f[j][i] && max < i-j+1) {
        //                 max = i-j+1;
        //                 idx = j;
        //             }
        //         }
        //     }
        //     return s.substring(idx, max);
        // }

        
        // private void helper(int [] arr, int d, int oi, int v, int idx, int cnt) {
        //     System.out.println("v: " + v);
        //     System.out.println("idx: " + idx);

        //     boolean poss = true;
        //     int tmp = 0;
        //     for (int k = 1; k <= d; k++) {
        //         for (int i = Math.max(0, idx-k); i <= Math.min(n-1, idx+k); i++) {
        //             if (v > arr[i]) {
        //                 if (vis[i] && dp[i] >= 1) {
        //                     max = Math.max(max, cnt + dp[i]);
        //                     continue;
        //                 }
        //                 poss = true;
        //                 for (int j = Math.min(idx, i)+1; j <= Math.max(idx, i)-1; j++) {
        //                     if (v < arr[j]) poss = false;
        //                     break;
        //                 }
        //                 System.out.println("poss: " + poss);
        //                 if (poss) {
        //                     helper(arr, d, oi, arr[i], i, cnt+1);
        //                     ++tmp;
        //                 }
        //             }
        //         }
        //     }
        //     if (tmp == 0 && cnt > max) {
        //         max = cnt;
        //         dp[oi] = Math.max(dp[oi], max);
        //         vis[oi] = true;
        //     }
        // }
        // int max = 1;
        // Map<Integer, Integer> m;
        // int [] dp;
        // boolean [] vis;
        // int n;
        // public int maxJumps(int[] arr, int d) {
        //     n = arr.length;
        //     dp = new int [n];
        //     vis = new boolean[n];
        //     Arrays.fill(dp, 1);
        //     int max = 0;
        //     int locMax = 0;
        //     boolean poss = true;
        //     Map<Integer, Integer> map = new HashMap<>();
        //     for (int i = 0; i < n; i++) 
        //         map.put(arr[i], i);
        //     m = map.entrySet().stream()
        //         .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
        //         .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
        //     System.out.println("m.size(): " + m.size());
        //     for (Map.Entry<Integer, Integer> entry : m.entrySet()) 
        //         System.out.print(entry.getKey() + ", " + entry.getValue() + "\n");
        //     max = 1;
        //     for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
        //         helper(arr, d, entry.getValue(), entry.getKey(), entry.getValue(), 1);
        //         System.out.println("max: " + max);
        //     }
        //     return max;
        // }

        // private int findMax(int [] arr, int i, int d) {
        //     if (dp[i] != 0) return dp[i];
        //     int max = 0;
        //     for (int k = 1; k <= d; k++) {
        //         if (i + k >= arr.length || arr[i+k] >= arr[i]) break;
        //         if (dp[i+k] == 0) {
        //             dp[i+k] = findMax(arr, i+k, d);
        //         }
        //         max = Math.max(max, dp[i+k]);
        //     }
        //     for (int k = 1; k <= d; k++) {
        //         if (i-k < 0 || arr[i-k] >= arr[i]) break;
        //         if (dp[i-k] == 0)
        //             dp[i-k] = findMax(arr, i-k, d);
        //         max = Math.max(max, dp[i-k]);
        //     }
        //     return max+1;
        // }
        // int [] dp;
        // public int maxJumps(int[] arr, int d) {
        //     dp = new int[arr.length];
        //     int max = 1;
        //     for (int i = 0; i < arr.length; i++) {
        //         int locMax = findMax(arr, i, d);
        //         dp[i] = locMax;
        //         max = Math.max(max, dp[i]);
        //     }
        //     return max;
        // }

        // public int longestSubsequence(int[] arr, int difference) {
        //     Map<Integer, Integer> m = new HashMap<>();
        //     m.put(arr[0], 1);
        //     int max = 1;
        //     for (int i = 1; i < arr.length; i++) {
        //         m.put(arr[i], m.getOrDefault(arr[i]-difference, 0) + 1);
        //         max = Math.max(max, m.get(arr[i]));
        //     }
        //     return max;
        // }


        // public int findLongestChain(int[][] pairs) {
        //     int n = pairs.length;
        //     Arrays.sort(pairs, new Comparator<int []>() {
        //             public int compare( int [] x, int [] y ) {
        //                 if ( x[0] != y[0]) return x[0] - y[0];
        //                 return x[1] - y[1];
        //             }
        //         });
        //     int [] dp = new int[n];
        //     Arrays.fill(dp, 1);
        //     int max = 1;
        //     for (int i = 0; i < n; i++) {
        //         for (int j = i+1; j < n; j++) {
        //             if (pairs[j][0] > pairs[i][1]) {
        //                 dp[j] = Math.max(dp[j], dp[i]+1);
        //                 max = Math.max(max, dp[j]);
        //             }
        //         }
        //     }
        //     return max;
        // }
        
        // private void helper (int t, List<Integer> l, int val) {
        //     if (l.size() > min) return;
        //     if (val == t) {
        //         if (l.size() < min) min = l.size();
        //         return;
        //     }
        //     for (int i = 0; i < m; i++) {
        //         if (!vis[i]) {
        //             if (val + arr[i] > t) continue;
        //             vis[i] = true;
        //             l.add(arr[i]);
        //             helper(t, l, val + arr[i]);
        //             l.remove(l.size()-1);
        //             vis[i] = false;
        //         }
        //     }
        // }
        // int min = Integer.MAX_VALUE;
        // int [] arr;
        // boolean [] vis;
        // int n, m;
        // public int coinChange(int[] coins, int amount) {
        //     if (amount == 0) return 0;
        //     n = coins.length;
        //     if (n == 1 && amount < coins[0]) return -1;
        //     Arrays.sort(coins);
        //     int cnt = n-1;
        //     while (coins[cnt] > amount) --cnt;
        //     if (cnt < 0) return -1;
        //     m = (cnt+1)*(amount / coins[cnt] + (amount % coins[cnt] == 0 ? 0 : 1));
        //     arr = new int [m];
        //     for (int i = 0; i <= cnt; i++) {
        //         arr[i] = coins[cnt-i];
        //         for (int j = 0; j < amount / coins[cnt] + 1; j++) {
        //             if (j * (cnt+1) + i < arr.length)
        //                 arr[j*(cnt+1)+i] = coins[cnt-i];
        //         }
        //     }
        //     vis = new boolean[m];
        //     List<Integer> l = new ArrayList<>();
        //     helper(amount, l, 0);
        //     return min == Integer.MAX_VALUE ? -1 : min;
        // }
        // public int coinChange(int[] coins, int amount) {
        //     int n = coins.length;
        //     // 数组大小为 amount + 1，初始值也为 amount + 1
        //     int [] arr = new int [amount+1];
        //     Arrays.fill(arr, amount+1);
        //     arr[0] = 0;
        //     for (int i = 0; i <= amount; i++) {
        //         for (int val : coins) {
        //             if (i - val < 0) continue;
        //             arr[i] = Math.min(arr[i], arr[i-val]+1);
        //         }
        //     }
        //     return (arr[amount] == amount+1) ? -1 : arr[amount];
        // }
        
        // public int numRollsToTarget(int d, int f, int target) {
        //     int [] [] dp = new int [d][target+1];
        //     for (int i = d-1; i >= 0; i--) {
        //         if (i == d-1) {
        //             for (int j = 1; j <= Math.min(f, target); j++) // match 1, 2 .... f
        //                 dp[i][j] = 1;
        //             continue;
        //         }
        //         for (int j = 1; j <= target; j++) {
        //             if (j > (d-i)*f) continue;
        //             for (int k = 1; k <= f && k <= j; k++) {
        //                 dp[i][j] = (dp[i][j] + dp[i+1][j-k]) % 1000000007;
        //             }
        //         } 
        //     }
        //     return dp[0][target];
        // }


        // private int cntLeft(int [][] arr, int n, int x, int y) {
        //     int cnt = 0;
        //     for (int j = y-1; j >= 0; j--) {
        //         if (arr[x][j] == 1) ++cnt;
        //         else break;
        //     }
        //     return cnt;
        // }
        // private int cntRight(int [][] arr, int n, int x, int y) {
        //     int cnt = 0;
        //     for (int j = y+1; j < n; j++)  {
        //         if (arr[x][j] == 1) ++cnt;
        //         else break;
        //     }
        //     return cnt;
        // }
        // private int cntUp(int [][] arr, int n, int x, int y) {
        //     int cnt = 0;
        //     for (int i = x-1; i >= 0; i--) {
        //         if (arr[i][y] == 1) ++cnt;
        //         else break;
        //     }
        //     return cnt;
        // }
        // private int cntDown(int [][] arr, int n, int x, int y) {
        //     int cnt = 0;
        //     for (int i = x+1; i < n; i++) {
        //         if (arr[i][y] == 1) ++cnt;
        //         else break;
        //     }
        //     return cnt;
        // }
        // public int orderOfLargestPlusSign(int n, int[][] mines) {
        //     if (n == 1) return mines.length == 0 ? 1 : 0;
        //     int [][] arr = new int[n][n];
        //     for (int i = 0; i < n; i++) 
        //         Arrays.fill(arr[i], 1);
        //     for (int [] v : mines) 
        //         arr[v[0]][v[1]] = 0;
        //     int [][] left = new int[n][n];
        //     int [][] right = new int[n][n];
        //     int [][] up = new int[n][n];
        //     int [][] down = new int[n][n];
        //     int max = Integer.MIN_VALUE;
        //     int min = Integer.MAX_VALUE;
        //     for (int i = 0; i < n; i++) {
        //         for (int j = 0; j < n; j++) {
        //             if (arr[i][j] == 0) continue;
        //             left[i][j] = cntLeft(arr, n, i, j);
        //             right[i][j] = cntRight(arr, n, i, j);
        //             up[i][j] = cntUp(arr, n, i, j);
        //             down[i][j] = cntDown(arr, n, i, j);
        //             min = Math.min(right[i][j], left[i][j]);
        //             min = Math.min(min, up[i][j]);
        //             min = Math.min(min, down[i][j]);
        //             max = Math.max(max, min+1);
        //         }
        //     }
        //     return max == Integer.MIN_VALUE ? 0 : max;
        // }

        // public int combinationSum4(int[] arr, int target) {
        //     int n = arr.length;
        //     int [] dp = new int[target+1];
        //     Arrays.sort(arr);
        //     // System.out.println("arr.length: " + arr.length);
        //     // for (int z = 0; z < arr.length; ++z) 
        //     //     System.out.print(arr[z] + ", ");
        //     // System.out.println("");
        //     for (int v : arr) {
        //         dp[v] += 1;
        //         int cur = v;
        //         while (cur + v < target) {
        //             dp[cur+v] += 1;
        //             cur += v;
        //         }
        //         for (int j = v-1; j >= 0; j--) {
        //             if (dp[j] > 0 && j+v <= target)
        //                 dp[j+v] += dp[j];
        //         }
        //     }
        //     System.out.println("dp.length: " + dp.length);
        //     for (int z = 0; z < dp.length; ++z) 
        //         System.out.print(dp[z] + ", ");
        //     System.out.println("");
        //     return dp[target];
        // }

        
        // private int binarySearch(int [] arr, int v, int l, int h) {
        //     if (l < 0 || h >= arr.length || l > h) return -1;
        //     if (l == h) return arr[l] == v ? l : -1;
        //     if (l == h-1) return arr[l] == v ? l : (arr[h] == v ? h : -1);
        //     int m = l + (h-l)/2;
        //     if (arr[m] == v) return m;
        //     if (arr[m] < v) return binarySearch(arr, v, m+1, h);
        //     return binarySearch(arr, v, l, m-1);
        // }
        // public int lenLongestFibSubseq(int[] arr) {
        //     int n = arr.length;
        //     int [][] dp = new int [n][n];
        //     int max = 0;
        //     List<Integer> l = new ArrayList<>();
        //     int cnt = 0, k = 0, tmp = 0;
        //     for (int i = 0; i < n; i++) {
        //         for (int j = i+1; j < n; j++) {
        //             cnt = 2;
        //             k = i;
        //             l = new ArrayList<>();
        //             l.add(arr[i]);
        //             l.add(arr[j]);
        //             while (k != -1) {
        //                 k = binarySearch(arr, l.get(l.size()-1)+l.get(l.size()-2), k+1, n-1);
        //                 if (k != -1) {
        //                     ++cnt;
        //                     tmp = l.get(l.size()-1)+l.get(l.size()-2);
        //                     l.add(tmp);
        //                 }
        //                 if (k == n-1) break;
        //             }
        //             max = Math.max(max, cnt);
        //         }
        //     }
        //     return max <= 2 ? 0 : max;
        // }



        // public int longestMountain(int[] arr) {
        //     int n = arr.length;
        //     if (n < 3) return 0;
        //     int i = 0, max = 0, bgn = 0;
        //     while (i < n-1 && arr[i] >= arr[i+1]) ++i;
        //     bgn = i;
        //     ++i;
        //     if (i == n) return 0;
        //     boolean up = (arr[i] > arr[i-1] ? true : false), down = false;
        //     while (i < n) {
        //         while (i < n-1 && arr[i] < arr[i+1]) {
        //             ++i;  // increasingf
        //             up = true;
        //         }
        //         if (i == n-1) return max;
        //         if (arr[i] < arr[i-1]) down = true;
        //         while (i < n-1 && arr[i] > arr[i+1]) {
        //             ++i; // decreasing
        //             down = true;
        //         }
        //         if (up && down) 
        //             max = Math.max(max, i-bgn + 1);
        //         if (i == n-1) return max;
        //         up = false;
        //         down = false;
        //         while (i < n-1 && arr[i] >= arr[i+1]) ++i;
        //         bgn = i;
        //     }
        //     return max;
        // }

        // public int longestArithSeqLength(int[] arr) {
        //     int n = arr.length;
        //     List<Map<Integer, Integer>> lm = new ArrayList<>();
        //     lm.add(new HashMap<>());
        //     int diff = 0;
        //     int max = 0, locMax = 0;
        //     for (int i = 1; i < n; i++) {
        //         Map<Integer, Integer> m = new HashMap<>();
        //         for (int j = i-1; j >= 0; j--) {
        //             diff = arr[i] - arr[j];
        //             locMax = Math.max(m.getOrDefault(diff, 2), lm.get(j).getOrDefault(diff, 1) + 1);
        //             m.put(diff, locMax);
        //             max = Math.max(max, locMax);
        //         }
        //         lm.add(m);
        //     }
        //     return max;
        // }

        // public int eraseOverlapIntervals(int[][] arr) { // 这种解法把问题想复杂了
        //     int n = arr.length;
        //     if (n == 1) return 0;
        //     Arrays.sort(arr, new Comparator<int []>() {
        //             @Override public int compare(int [] a, int [] b) {
        //                 int cmp = a[0]-b[0];
        //                 if (cmp != 0) return cmp;
        //                 return a[1]-b[1];
        //             }
        //         });
        //     List<Map<Integer, Integer>> lm = new ArrayList<>();
        //     Map<Integer, Integer> m0 = new HashMap<>();
        //     m0.put(arr[0][1], 1);
        //     lm.add(m0);
        //     int max = 1, locMax = 1;
        //     for (int i = 1; i < n; i++) {
        //         Map<Integer, Integer> m = new TreeMap<>(); // end time: count
        //         locMax = 1;
        //         for (int j = 0; j < i; j++) {
        //             if (lm.get(j).size() == 0) {
        //                 m.put(arr[i][1], m.getOrDefault(arr[i][1], 0) + 1);
        //                 continue;
        //             }
        //             for (Integer key : lm.get(j).keySet()) {
        //                 if (arr[i][0] >= key) 
        //                     locMax = Math.max(locMax, lm.get(j).get(key)+1);
        //             }
        //             m.put(arr[i][1], locMax);
        //             max = Math.max(max, locMax);
        //         }
        //         lm.add(m);
        //     }
        //     return n - max;
        // }
        // public int eraseOverlapIntervals(int[][] arr) {
        //     int n = arr.length;
        //     if (n == 1) return 0;
        //     Arrays.sort(arr, new Comparator<int []>() {
        //             @Override public int compare(int [] a, int [] b) {
        //                 int cmp = a[0]-b[0];
        //                 if (cmp != 0) return cmp;
        //                 return a[1]-b[1];
        //             }
        //         });
        //     int res = 0, now = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (i == 0) {
        //             now = arr[i][1];
        //             continue;
        //         }
        //         if (arr[i][0] < now) {
        //             res += 1;
        //             now = Math.min(now, arr[i][1]);
        //         } else now = arr[i][1];
        //     }
        //     return res;
        // }        


        

    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int [][] a = new int [][] {{1,2},{2,3}};

        int res = s.eraseOverlapIntervals(a);
        System.out.println("res: " + res);
    }
}
