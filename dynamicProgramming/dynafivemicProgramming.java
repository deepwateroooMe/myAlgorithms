import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class dynafivemicProgramming {
    public static class Solution {

        // private int getCnt(int v) {
        //     int cnt = 0;
        //     while (v > 0) {
        //         if (v % 2 == 1) cnt ++;
        //         v >>= 1;
        //     }
        //     return cnt;
        // }
        // public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        //     Arrays.sort(req_skills);
        //     for (int i = 0; i < people.size(); i++) 
        //         Collections.sort(people.get(i));
        //     int n = req_skills.length;
        //     int mask = (int)(Math.pow(2, n)-1);
        //     List<Integer> l = new ArrayList<>();
        //     for (int i = 0; i < people.size(); i++) {
        //         int ma = 0;
        //         for (int j = 0; j < n; j++) {
        //             if (people.get(i).contains(req_skills[j])) 
        //                 ma += ((j+1) << 1);
        //         }
        //         if (!l.contains(ma)) l.add(ma);
        //     }
        //     Collections.sort(l, (a, b)->getCnt(b)-getCnt(a));
        //     // System.out.println("l.size(): " + l.size());
        //     // for (int z = 0; z < l.size(); ++z) 
        //     //     System.out.print(l.get(z) + ", ");
        //     // System.out.print("\n");
        //     int m = l.size();
        //     int [] dp = new int [m];
        //     int [] va = new int[m];
        //     Arrays.fill(dp, Integer.MAX_VALUE);
        //     dp[0] = 1;
        //     va[0] = l.get(0);
        //     for (int i = 1; i < m; i++) {
        //         for (int j = 0; j < i; j++) {
        //             if ((l.get(i) | va[j]) == mask) { // 不一定要一定满足要求，增加了技能也是需要更新的
        //                 // dp[i] = Math.min(dp[i], dp[j] + 1);
        //                 if (dp[j]+1 < dp[i]) {
        //                     va[i] = (va[j] | l.get(i));
        //                 }
        //             }
        //         }
        //     }
        //     return new int[0];
        // }
        // String []  a = new String []  {"java", "nodejs", "reactjs"};
        // String [][] b = new String [][] {{"java"},{"nodejs"},{"nodejs","reactjs"}};
        // List<List<String>> ll = new ArrayList<>();
        // for (int i = 0; i < b.length; i++) 
        //     ll.add(Arrays.asList(b[i]));


        // private String dfs(int [] arr, int target) {
        //     if (dp[target] != null) return dp[target];
        //     String res = "", tmp = "";
        //     for (int i = n; i >= 1; i--) {
        //         tmp = "";
        //         if (arr[i-1] <= target) {
        //             tmp = dfs(arr, target - arr[i-1]);
        //             if (tmp.equals("0")) continue; // 如果子问题结果是"0"，代表当前选择为不合理解，跳过, 这个特殊情况不要忘记
        //             tmp += i; // 之前我把顺序加反了
        //             if (tmp.length() > res.length() || tmp.length() == res.length() && tmp.compareTo(res) >= 0)
        //                 res = tmp;
        //         }
        //     }
        //     dp[target] = res.equals("") ? "0" : res;
        //     return dp[target];
        // }
        // String [] dp;
        // int min;
        // int n;
        // public String largestNumber(int[] cost, int target) { 
        //     n = cost.length;
        //     dp = new String [target + 1];
        //     min = Integer.MAX_VALUE;
        //     for (int v : cost) 
        //         min = Math.min(min, v);
        //     dp[0] = "";
        //     for (int i = 1; i < min; i++) 
        //         dp[i] = "0";
        //     dfs(cost, target);
        //     return dp[target];
        // }
        // public String largestNumber(int[] cost, int target) { 
        //     int n = cost.length;
        //     int [] dp = new int [target+1];
        //     Arrays.fill(dp, -1);
        //     dp[0] = 0;
        //     for (int i = 0; i < n; i++) {
        //         for (int j = cost[i]; j <= target; j++) {
        //             if (dp[j-cost[i]] >= 0)
        //                 dp[j] = Math.max(dp[j], dp[j-cost[i]]+1);
        //         }
        //     }
        //     if (dp[target] < 0) return "0";
        //     char [] ans = new char[dp[target]]; // 采樱桃机器人数组路线那天可以想出来，今天这个路径居然没有想出来！
        //     int left = target;
        //     for (int i = 0; i < dp[target]; i++) {
        //         for (int j = n-1; j > 0; j--) {
        //             if (left >= cost[j-1] && dp[left] == dp[left-cost[j-1]] + 1) {
        //                 ans[i] = (char)('0' + j);
        //                 left -= cost[j-1];
        //                 break;
        //             }
        //         }
        //     }
        //     return String.valueOf(ans);
        // }

        
        // // 使用helper函数表示Alex能比Lee多选的分数。可能比双函数更简洁易懂了。
        // // 记忆化递归的缺点：１．有可能爆栈；２．无法降维，而DP是可以降维的。
        // private int dfs(int [] arr, int l, int r) {
        //     if (l > r) return 0;
        //     if (dp[l][r] > 0) return dp[l][r]; // 走了来时的路，不需要重走，直接返回
        //     dp[l][r] = Math.max(arr[l] - dfs(arr, l+1, r), arr[r]-dfs(arr, l, r-1));
        //     return dp[l][r];
        // }
        // int [][] dp; 
        // public boolean stoneGame(int[] piles) {
        //     int n = piles.length;
        //     dp = new int[n][n];
        //     return dfs(piles, 0, n-1) > 0;
        // }
        // // 动态规划解法比较难想，dp数组的第i个位置表示的是从第i个石头到第i+l-1个石头之间最大的比对手得分。
        // // 使用的是一个长度变量和起始索引，计算每个位置开始的长度1～N长度的区间的dp状态。
        // public boolean stoneGame(int[] piles) {
        //     int n = piles.length;
        //     int [][] dp = new int[n][n];
        //     for (int i = n-1; i >= 0; i--) { // 最后一列
        //         dp[i][i] = piles[i];         // 填右上角
        //         for (int j = i+1; j < n; j++) 
        //             dp[i][j] = Math.max(piles[i] - dp[i+1][j], piles[j]-dp[i][j-1]);
        //     }
        //     return dp[0][n-1] > 0;
        // }

        
        // // dfs + memoization模板
        // // 当次取的最优策略是限制下一次取的数量
        // private int dfs(int [] arr, int idx, int m) {
        //     if (dp[idx][m] > 0) return dp[idx][m];
        //     if (idx == n) return 0;
        //     if (idx >= n - 2 * m) {
        //         dp[idx][m] = suf[idx];
        //         return dp[idx][m];
        //     }
        //     int min = Integer.MAX_VALUE;
        //     for (int i = 1; i <= 2 * m; i++) 
        //         min = Math.min(min, dfs(arr, idx+i, Math.max(m, i)));
        //     dp[idx][m] = suf[idx] - min;
        //     return dp[idx][m];
        // }
        // int [][] dp;
        // int [] suf;
        // int n;
        // public int stoneGameII(int[] piles) {
        //     n = piles.length;
        //     dp = new int [n][2*n];
        //     suf = new int [n+1];
        //     for (int i = n-1; i >= 0; i--) 
        //         suf[i] = suf[i+1] + piles[i];
        //     return dfs(piles, 0, 1);
        // }

        // private int minimax(int [] arr, int idx) {
        //     if (idx == n) return 0;
        //     if (dp[idx] > 0) return dp[idx];
        //     int max = Integer.MIN_VALUE, sum = 0;
        //     for (int i = 0; i < 3 && idx + i < n; i++) {
        //         sum += arr[idx + i];
        //         max = Math.max(max, sum - minimax(arr, idx+i+1));
        //     }
        //     dp[idx] = max;
        //     return dp[idx];
        // }
        // int [] dp;
        // int n;
        // public String stoneGameIII(int[] stoneValue) {
        //     n = stoneValue.length;
        //     dp = new int [n];
        //     return minimax(stoneValue, 0) > 0 ?  "Alice" : (dp[0] == 0 ? "Tie" : "Bob");
        // }

        // private boolean dfs(int v) {
        //     if (dp[v] != null) return dp[v];
        //      for (int i = 1; i <= Math.sqrt(v); i++) 
        //         if (!dfs(v - i*i)) { 
        //             dp[v] = true;
        //             return true;
        //         }
        //     return dp[v] = false;
        // }
        // Boolean [] dp;
        // public boolean winnerSquareGame(int n) {
        //     if (n == 1) return true;
        //     dp = new Boolean [n+1]; 
        //     return dfs(n);
        // }


        // private int minimax(int [] arr, int i, int j, int sum) {
        //     if (i > j) return 0;
        //     if (dp[i][j] > 0) return dp[i][j];
        //     dp[i][j] = Math.max(sum - arr[i] - minimax(arr, i+1, j, sum-arr[i]), sum-arr[j] - minimax(arr, i, j-1, sum-arr[j]));
        //     return dp[i][j];
        // }
        // int [][] dp;
        // int [] pre;
        // int n;
        // public int stoneGameVII(int[] stones) {
        //     n = stones.length;
        //     dp = new int [n][n];
        //     pre = new int [n+1];
        //     for (int i = 1; i <= n; i++) 
        //         pre[i] = pre[i-1] + stones[i-1];
        //     return minimax(stones, 0, n-1, pre[n]);
        // }

         
        // private int minimax(int [] arr, int va) { // va: # of removed stones 超时了
        //     if (va == n-1) return 0;
        //     if (dp[va] != Integer.MIN_VALUE) return dp[va];
        //     int max = Integer.MIN_VALUE;
        //     for (int i = va+1; i < n; i++) 
        //         max = Math.max(max, pre[i+1] - minimax(arr, i));
        //     dp[va] = max;
        //     return dp[va];
        // }
        // int [] dp; // dp[numberOfRemovedStones]
        // int [] pre;
        // int n;     // dp[x] = max(sum of all elements up to y - dp[y]) for all y > x
        // public int stoneGameVIII(int[] stones) {
        //     n = stones.length;
        //     dp = new int [n];
        //     Arrays.fill(dp, Integer.MIN_VALUE);
        //     pre = new int [n+1];
        //     for (int i = 1; i <= n; i++)
        //         pre[i] = pre[i-1] + stones[i-1];
        //     return minimax(stones, 0);
        // }
        // 使用 dp(i) 表示还剩下 [i, n) 要选择的情况下，Alice 所能得到的最大分数差。
        //     对于某个玩家来说，其对应决策可以分为两种：
        //     选取当前数及之前的所有数（等价于 pres[pos]，其中 pos 为上个玩家选完后的下个位置），那么 dp[i] = pres[i] - dp[i+1]。
        //     这是因为 bob 也会最大化发挥。
        //     不选择当前数（可能选下一个，下下一个。。。 etc），那么 dp[i] = dp[i + 1]
        // public int stoneGameVIII(int[] stones) {
        //     int n = stones.length;
        //     int [] dp = new int [n];
        //     Arrays.fill(dp, Integer.MIN_VALUE);
        //     int [] pre = new int [n+1];
        //     for (int i = 1; i <= n; i++)
        //         pre[i] = pre[i-1] + stones[i-1];
        //     dp[n-1] = pre[n];
        //     for (int i = n-2; i >= 0; i--) 
        //         dp[i] = Math.max(dp[i+1], pre[i+1]-dp[i+1]);
        //     return dp[1];
        // }


        // private int dfs(int [] arr, int idx, int l, int r) {
        //     if (l == r) return 0;
        //     if (r == l + 1) {
        //         dp[l][r] = Math.min(arr[l], arr[r]);
        //         return dp[l][r];
        //     }
        //     if (dp[l][r] != 0) return dp[l][r];
        //     int max = 0;
        //     int left = 0, right = 0;
        //     for (int i = idx; i <= r-1; i++) {
        //         left = pre[i+1] - pre[l];
        //         right = pre[r+1] - pre[i+1];
        //         if (left > right) 
        //             max = Math.max(max, right + dfs(arr, i+1, i+1, r));
        //         else if (left < right) 
        //             max = Math.max(max, left + dfs(arr, l, l, i));
        //         else max = Math.max(max, Math.max(dfs(arr, l, l, i), dfs(arr, i+1, i+1, r)) + left);
        //     }
        //     dp[l][r] = max;
        //     return dp[l][r];
        // }
        // int [][] dp;
        // int [] pre;
        // int n;
        //  public int stoneGameV(int[] stoneValue) {
        //     n = stoneValue.length;
        //     dp = new int [n][n];
        //     pre = new int [n+1];
        //     for (int i = 1; i <= n; i++) 
        //         pre[i] = pre[i-1] + stoneValue[i-1];
        //     return dfs(stoneValue, 0, 0, n-1);
        // }


        // public int minInsertions(String s) {
        //     int n = s.length();
        // }        


        // dp[i][j] 有下面几种情况
        // dp[i][i] = 1
        // dp[i][j] = 2 + dp[i+1][j-1];                 // if s.charAt(i) == s.charAt(j)
        // dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]); // else
        // public int longestPalindromeSubseq(String s) {
        //     int n = s.length();
        //     int [][] dp = new int [n][n];
        //         dp[n-1][n-1] = 1;
        //     for (int i = n-2; i >= 0; i--) {
        //         dp[i][i] = 1;
        //         for (int j = i+1; j < n; j++) {
        //             if (s.charAt(i) == s.charAt(j))
        //                 dp[i][j] = 2 + dp[i+1][j-1];
        //             else dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
        //         }
        //     }
        //     return dp[0][n-1];
        // }
        // public int minInsertions(String s) {
        //     int n = s.length();
        //     int [][] dp = new int [n][n];
        //     dp[n-1][n-1] = 1;
        //     for (int i = n-2; i >= 0; i--) {
        //         dp[i][i] = 1;
        //         for (int j = i+1; j < n; j++) {
        //             if (s.charAt(i) == s.charAt(j))
        //                 dp[i][j] = 2 + dp[i+1][j-1];
        //             else dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
        //         }
        //     }
        //     return n - dp[0][n-1];
        // }

        
        // public boolean checkPartitioning(String s) {
        //     int n = s.length();
        //     if (n == 3) return true;
        //     boolean [][] p = new boolean [n][n];
        //     for (int i = 0; i < n; i++) {
        //         // System.out.println("\ni: " + i);
        //         // System.out.println("s.charAt(i): " + s.charAt(i));
        //         p[i][i] = true;
        //         for (int d = 1; i-d >= 0 && i+d < n; d++) {
        //             // System.out.println("d: " + d);
        //             if (s.charAt(i-d) == s.charAt(i+d) && p[i-d+1][i+d-1] && !p[i-d][i+d]) p[i-d][i+d] = true;
        //             // System.out.println("p[i-d][i+d]: " + p[i-d][i+d]);
        //         }
        //         if (i < n-1 && s.charAt(i) == s.charAt(i+1)) {
        //             p[i][i+1] = true;
        //             for (int d = 1; i-d >= 0 && i+1+d < n; d++) { // caac
        //                 if (s.charAt(i-d) == s.charAt(i+1+d) && p[i-d-1][i+d] && !p[i-d][i+1+d])
        //                     p[i-d][i+1+d] = true;
        //             }
        //         }
        //     }
        //     System.out.println("p.length: " + p.length);
        //     for (int z = 0; z < p.length; ++z) {
        //         for (int w = 0; w < p[z].length; w++) 
        //             System.out.print(p[z][w] + ", ");
        //         System.out.print("\n");
        //     }
        //     for (int i = 1; i < n-1; i++) {
        //         for (int j = i; j < n-1; j++) {
        //             // System.out.println("\ni: " + i);
        //             // System.out.println("j: " + j);
        //             // System.out.println("(p[i][j] && p[0][i-1] && p[j+1][n-1]) : " + (p[i][j] && p[0][i-1] && p[j+1][n-1]) );
        //             if (p[i][j] && p[0][i-1] && p[j+1][n-1]) return true;
        //         }
        //     }
        //     return false;
        // }
        // public boolean checkPartitioning(String s) {
        //     int n = s.length();
        //     if (n == 3) return true;
        //     int [] dp = new int[n+1];
        //     boolean [][] p = new boolean[n][n];
        //     int max = 0;
        //     for (int i = 0; i <= n; i++) 
        //         dp[i] = n-1-i;
        //     for (int i = n-1; i >= 0; i--) {
        //         for (int j = i; j < n; j++) {
        //             // 在原回文的基础上————前后再各加一个字符
        //             if (s.charAt(i) == s.charAt(j) && (j-i < 2 || p[i+1][j-1])) {
        //                 p[i][j] = true;
        //                 dp[i] = Math.min(dp[i], dp[j+1]+1); // 想不明白这里为什么是 dp[j+1]+1 ?
        //             }
        //         }
        //         max = Math.max(max, dp[i]);
        //     }
        //     return dp[0] <= 2;
        // }


        // public boolean canPartition(int[] arr) {
        //     int n = arr.length;
        //     Arrays.sort(arr);
        //     int sum = 0;
        //     for (int i = 0; i < n; i++)  
        //         sum += arr[i];
        //     if (sum % 2 == 1 || arr[n-1] > sum / 2) return false;
        //     int target = sum / 2;
        //     if (arr[n-1] == target) return true;
        //     int [] pre = new int [n+1];
        //     for (int i = 1; i <= n; i++) 
        //         pre[i] = pre[i-1] + arr[i-1];
        //     int [] dp = new int[target+1];
        //     dp[arr[0]] = 1;
        //     for (int i = 1; i < n && arr[i] <= target; i++) {
        //         for (int j = Math.min(pre[i], target); j >= 0; j--) {
        //             if (dp[j] > 0 && arr[i] + j <= target) {
        //                 dp[j+arr[i]] += 1;
        //                 if (j + arr[i] == target) return true;
        //             }
        //         }
        //     }
        //     return dp[target] > 0;
        // }


        // private int dfs(int [] bas, int [] top, int target, int i) {
        //     if (bas[i] > target) return Integer.MAX_VALUE;
        //     if (bas[i] == target) return target;
        //     int res = Integer.MAX_VALUE;
        //     for (int j = 0; j < m; j++) { // 读错题目了，每种T 只要不超过两次就可以叠加
        //         if (bas[i] + top[j] == target) return target;
        //         if (bas[i] + top[j] > target) continue;
        //         for (int k = 0; k < m; k++) {
        //             if (bas[i] + top[j] + top[k] == target) return target;
        //             if (bas[i] + top[j] + top[k] > target) continue;
        //             res = Math.min( target - bas[i] - top[j] - top[k], target - res);
        //         }
        //     }
        //     return target - res;
        // }
        // int m, n;
        // public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        //     n = baseCosts.length;
        //     m = toppingCosts.length;
        //     int tmp = 0, res = 0, minDiff = Integer.MAX_VALUE;
        //     for (int i = 0; i < n; i++) {
        //         tmp = dfs(baseCosts, toppingCosts, target, i);
        //         if (tmp == target) return target;
        //         if (tmp < target && target - tmp < minDiff) {
        //             minDiff = target - tmp;
        //             res = tmp;
        //         }
        //     }
        //     return res;
        // }


        // private int dfs(int [] arr, int i) {
        //     if (i >= n) return 0;
        //     if (i == n-1) {
        //         dp[i] = arr[i];
        //         return dp[i];
        //     }
        //     if (dp[i] >  0) return dp[i];
        //     dp[i] = Math.max(arr[i] + dfs(arr, i+2), dfs(arr, i+1));
        //     return dp[i];
        // }
        // int [] dp;
        // int n;
        // public int rob(int[] nums) {
        //     n = nums.length;
        //     if (n == 1) return nums[0];
        //     if (Arrays.stream(nums).distinct().count() == 1 && nums[0] == 0) return 0;
        //     dp = new int [n];
        //     return dfs(nums, 0);
        // }
        // // // int []  a = new int []  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};


        // private int dfs(int [] arr, int i, int end, int [] dp) { // end: n-1
        //     if (i > end) return 0;
        //     if (i == end) {
        //         dp[i] = arr[i];
        //         return dp[i];
        //     }
        //     if (dp[i] > 0) return dp[i];
        //     dp[i] = Math.max(arr[i] + dfs(arr, i+2, end, dp), dfs(arr, i+1, end, dp));
        //     return dp[i];
        // }
        // int n;
        // public int rob(int[] nums) {
        //     n = nums.length;
        //     if (n == 1) return nums[0];
        //     if (Arrays.stream(nums).distinct().count() == 1 && nums[0] == 0) return 0;
        //     int [] dp = new int [n];
        //     int max = dfs(nums, 0, n-2, dp);
        //     Arrays.fill(dp, 0);
        //     return Math.max(max, dfs(nums, 1, n-1, dp));
        // }


        // private int dfs(TreeNode r) {
        //     if (r == null) return 0;
        //     if (r.left == null && r.right == null) {
        //         dp.put(r, r.val);
        //         return r.val;
        //     }
        //     if (dp.containsKey(r)) return dp.get(r);
        //     int max = r.val + (r.left != null ? dfs(r.left.left) + dfs(r.left.right) : 0)
        //         + (r.right != null ? dfs(r.right.left) + dfs(r.right.right) : 0);
        //     max = Math.max(max, dfs(r.left) + dfs(r.right));
        //     dp.put(r, max);
        //     return max;
        // }
        // Map<TreeNode, Integer> dp;
        // public int rob(TreeNode root) {
        //     if (root.left == null && root.right == null) return root.val;
        //     dp = new HashMap<>();
        //     return dfs(root);
        // }


        // private void helper(List<Integer> l, int v) {
        //     if (l.size() <= 1) {
        //         if (l.size() == 1) v += l.get(0) * m.get(l.get(0));
        //         if (v > max) max = v;
        //         return;
        //     }
        //     List<Integer> li = new ArrayList<>(l);
        //     for (int i = l.size()-1; i >= 0; i--) {
        //         li = new ArrayList<>(l);
        //         li.remove(i);
        //         for (int j = li.size()-1; j >= 0; j--) {
        //             if (li.get(j) == l.get(i) + 1 || li.get(j) == l.get(i)-1)
        //                 li.remove(j);
        //         }
        //          helper(new ArrayList<>(li), v+l.get(i)*m.get(l.get(i)));
        //          li.add(l.get(i));
        //     }
        // }
        // Map<Integer, Integer> m = new HashMap<>();
        // int max = Integer.MIN_VALUE;
        // public int deleteAndEarn(int[] nums) {
        //     int n = nums.length;
        //     List<Integer> l = Arrays.stream(nums).boxed().distinct().collect(Collectors.toList());
        //     for (int i = 0; i < n; i++) 
        //         m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);
        //     max = Integer.MIN_VALUE;
        //     helper(l, 0);
        //     return max;
        // }

        
        // private int dfs(int [] arr, int v) {
        //     if (v <= 0) return 0;
        //     if (dp[v] > 0) return dp[v];
        //     dp[v] = Math.max(dfs(arr, v-1), v * cnt[v] + dfs(arr, v-2));
        //     return dp[v];
        // }
        // int [] dp;
        // int [] cnt;
        // public int deleteAndEarn(int[] nums) {
        //     Arrays.sort(nums);
        //     dp = new int [nums[nums.length-1]+1];
        //     cnt = new int[nums[nums.length-1]+1];
        //     for (int v : nums)
        //         cnt[v]++;
        //     return dfs(nums, nums[nums.length-1]);
        // }


        // private int dfs(int [] arr, int i, int j, boolean sdd) {
        //     if (i == n-1) {
        //         dp[i][j] = 0;
        //         return dp[i][j];
        //     }
        //     if (dp[i][j] != Integer.MAX_VALUE) return dp[i][j];
        //     int min = Integer.MAX_VALUE;
        //     if (arr[i+1] != j) 
        //         min = dfs(arr, i+1, j, false);
        //     if (arr[i+1] == j || !sdd) {
        //         for (int k = 1; k <= 3; k++) {
        //             if (k == j || arr[i] == k) continue;
        //             min = Math.min(min, 1 + dfs(arr, i, k, true));
        //         }                
        //     }
        //     dp[i][j] = min;
        //     return dp[i][j];
        // }
        // int [][] dp;
        // int n;
        // public int minSideJumps(int[] obstacles) {
        //     n = obstacles.length;
        //     dp = new int [n][4];
        //     for (int i = 0; i < n; i++) 
        //         Arrays.fill(dp[i], Integer.MAX_VALUE);
        //     return dfs(obstacles, 0, 2, false);
        // }


        // int n;
        // public int firstDayBeenInAllRooms(int[] nextVisit) {
        //     n = nextVisit.length;
        //     int [] dp = new int [n];
        //     dp[0] = nextVisit[0];
        //     for (int i = 1; i < n; i++) {
        //     }
        // }


        // private int dfs(int [] arr, int i, int end, int [] dp) { // end: n-1
        //     if (i > end) return 0;
        //     if (i == end) {
        //         dp[i] = arr[i];
        //         return dp[i];
        //     }
        //     if (dp[i] > 0) return dp[i];
        //     dp[i] = Math.max(arr[i] + dfs(arr, i+2, end, dp), dfs(arr, i+1, end, dp));
        //     return dp[i];
        // }
        // int n;
        // public int rob(int[] nums) {
        //     n = nums.length;
        //     if (n == 1) return nums[0];
        //     if (Arrays.stream(nums).distinct().count() == 1 && nums[0] == 0) return 0;
        //     int [] dp = new int [n];
        //     int max = dfs(nums, 0, n-2, dp);
        //     Arrays.fill(dp, 0);
        //     return Math.max(max, dfs(nums, 1, n-1, dp));
        // }
        // private int getMax(int [] arr, int l, int r) {
        //     int max = 0;
        //     for (int i = l; i <= r; i++) 
        //         max = Math.max(max, arr[i]);
        //     return max;
        // }
        // private int dfs(int [] arr, int[][] dp,  int i, int j, int cnt) { // i: idx
        //     if (i > j) return 0;
        //     if (cnt == n/3-1) {
        //         dp[i][cnt] = getMax(arr, i, j);
        //         return dp[i][cnt];
        //     }
        //     if (dp[i][cnt] > 0) return dp[i][cnt];
        //     dp[i][cnt] = Math.max(arr[i] + dfs(arr, dp, i+2, j, cnt+1), dfs(arr, dp, i+1, j, cnt));
        //     return dp[i][cnt];
        // }
        // int n;
        // public int maxSizeSlices(int[] slices) {
        //     n = slices.length;
        //     int [][] dp = new int [n][n/3];
        //     int max = dfs(slices, dp, 0, n-2, 0);
        //     for (int i = 0; i < n; i++) 
        //         Arrays.fill(dp[i], 0);
        //     return Math.max(max, dfs(slices, dp, 1, n-1, 0));
        // }


        // private int dfs(int [] arr, int i, int j, int k) {
        //     if (i == j) return arr[i];
        //     if (dp[i][j] > 0) return dp[i][j];
        // }
        // int [][] dp;
        // int n;
        // public int mergeStones(int[] stones, int k) {
        //    n = stones.length;
        //    dp = new int [n][n];
        //    return dfs(stones, 0, n-1, k);
        // }


        // public int maxProfit(int[] prices) {
        //     int start = prices[0];
        //     int res = 0;
        //     for (int i = 1; i < prices.length; i++) {
        //         if (prices[i] >= prices[i-1]) continue;
        //         res += prices[i-1] - start;
        //         start = prices[i];
        //     }
        //     res += prices[prices.length-1] - start;
        //     return res;
        // }
        // public int maxProfit(int[] prices) { // 多次交易，只要把结果加起来就可以了
        //     int start = prices[0];
        //     int res = 0;
        //     for (int i = 1; i < prices.length; i++) {
        //         if (prices[i] > prices[i-1]) {
        //             res += prices[i] - prices[i-1];
        //             start = prices[i];
        //         }
        //     }
        //     return res;
        // }


        // // k 次交易 = k 个 non-overlapping subarray
        // //     以这个角度去想，无非就是从两个方向扫描，
        // //     利用 localMin / localMax 与当前元素的差值，去构造从左边/右边扫的 dp 数组。
        // //     left[i] : 从最左面到 i 所能获得的最大利益（单次交易）
        // //     right[i] : 从 i 到最右面所能获得的最大利益（单次交易）
        // public int maxProfit(int[] prices) {
        //     int n = prices.length;
        //     int [] left = new int [n];
        //     int [] right = new int[n];
        //     int locMin = prices[0];
        //     int globalMax = Integer.MIN_VALUE;
        //     for (int i = 1; i < n; i++) {
        //         globalMax = Math.max(globalMax, Math.max(0, prices[i] - locMin));
        //         locMin = Math.min(locMin, prices[i]);
        //         left[i] = globalMax;
        //     }
        //     int locMax = prices[n-1];
        //     globalMax = Integer.MIN_VALUE;
        //     for (int i = n-2; i >= 0; i--) {
        //         globalMax = Math.max(globalMax, Math.max(0, locMax - prices[i]));
        //         locMax = Math.max(locMax, prices[i]);
        //         right[i] = globalMax;
        //     }
        //     globalMax = 0;
        //     for (int i = 0; i < n-1; i++) 
        //         globalMax = Math.max(globalMax, left[i] + right[i+1]);
        //     globalMax = Math.max(globalMax, left[n-1]);
        //     return globalMax;
        // }


        // public int maxProfit(int k, int [] prices) {
        //     if (prices == null || prices.length == 0) return 0;
        //     int n = prices.length;
        //     int diff = 0;
        //     if (k >= n/2) {
        //         int res = 0;
        //         for (int i = 1; i < n; i++) {
        //            diff = prices[i] - prices[i-1];
        //             if (diff > 0) res += diff;
        //         }
        //         return res;
        //     }
        //     int [][] locMax = new int [n][k+1];
        //     int [][] gloMax = new int [n][k+1];
        //     for (int i = 1; i < n; i++) {
        //         diff = prices[i] - prices[i-1];
        //         for (int j = 1; j <= k && j * 2 <= i+1; j++) {
        //             locMax[i][j] = Math.max(locMax[i-1][j], gloMax[i-1][j-1]) + diff;
        //             gloMax[i][j] = Math.max(locMax[i][j], gloMax[i-1][j]);
        //         }
        //     }
        //     return gloMax[n-1][k];
        // }


        // public int minCut(String s) {
        //     if (s == null || s.length() <= 1) return 0;
        //     int n = s.length();
        //     int [] dp = new int[n];
        //     boolean [][] p = new boolean[n][n];
        //     for (int i = 0; i < n; i++) {
        //         dp[i] = i; // ?
        //         for (int j = 0; j <= i; j++) {
        //             if (s.charAt(i) == s.charAt(j) && (i-j < 2 || p[j+1][i-1])) {
        //                 p[i][j] = p[j][i] = true;
        //                 if (j == 0) dp[i] = 0;
        //                 else dp[i] = Math.min(dp[i], dp[j-1]+1);
        //             }
        //         }
        //     }
        //     return dp[n-1];
        // }
        

        // public int maxCoins(int[] nums) {
        //     int n = nums.length;
        //     int [][]  dp = new int [n+2][n+2];
        //     int [] arr = new int [n+2];
        //     System.arraycopy(nums, 0, arr, 1, n);
        //     arr[0] = arr[n+1] = 1;  // [0, n+1] ==> [1, n]
        //     int j = 0;
        //     for (int len = 1; len <= n; len++) { // [1, n]
        //         for (int i = 1; i+len-1 <= n; i++) { // [1, n]
        //             j = i + len - 1;
        //             for (int k = i; k <= j; k++) 
        //                 dp[i][j] = Math.max(dp[i][j], dp[i][k-1] + dp[k+1][j] + arr[i-1]*arr[k]*arr[j+1]);
        //         }
        //     }
        //     return dp[1][n];
        // }
        // // 0    0    0    0    0    0
        // // 0    3    30   159  167  0
        // // 0    0    15   135  159  0
        // // 0    0    0    40   48   0
        // // 0    0    0    0    40   0
        // // 0    0    0    0    0    0
        // private int memorizedSearch(int [] arr, int x, int y) {
        //     if (x > y ) return 0;
        //     // if (x == y) return dp[x][y] = arr[x]; // 没有这些个边际条件
        //     // if (x == y-1) 
        //     //     return dp[x][y] = arr[x] * arr[y] + Math.max(arr[x], arr[y]);
        //     if (dp[x][y] > 0) return dp[x][y];
        //     int max = 0;
        //     for (int i = x; i <= y; i++) {
        //         max = Math.max(max, memorizedSearch(arr, x, i-1) + memorizedSearch(arr, i+1, y) + arr[x-1]*arr[i]*arr[y+1]);
        //     }
        //     return dp[x][y] = max;
        // }
        // int [][] dp;
        // int n;
        // public int maxCoins(int[] nums) {
        //     int n = nums.length + 2;
        //     dp = new int [n][n];
        //     int [] arr = new int [n];
        //     System.arraycopy(nums, 0, arr, 1, n-2);
        //     arr[0] = arr[n-1] = 1;
        //     return memorizedSearch(arr, 1, n-2);
        // }

        
        // public int mergeStones(int[] stones, int k) {
        //     int n = stones.length;
        //     if ((n-1) % (k-1) != 0) return -1;
        //     int [][] dp = new int[n][n];
        //     int [] pre = new int[n+1];
        //     for (int i = 1; i <= n; i++) 
        //         pre[i] = pre[i-1] + stones[i-1];
        //     int j = 0;
        //     for (int len = k; len <= n; len++) {
        //         for (int i = 0; i+len-1 < n; i++) {
        //             j = i + len -1;
        //             dp[i][j] = Integer.MAX_VALUE; // have to initialize it here !!!
        //             for (int x = i; x < j; x += k-1) 
        //                 dp[i][j] = Math.min(dp[i][j], dp[i][x] + dp[x+1][j]);
        //             if ((j - i) % (k - 1) == 0) // 如果总长度满足合并只剩一个数的条件，则可以再合并一次
        //                 dp[i][j] += pre[j+1] - pre[i];
        //         }
        //     }
        //     return dp[0][n-1];
        // }


        // public int numFactoredBinaryTrees(int[] arr) {
        //     int n = arr.length;
        //     Arrays.sort(arr);
        //     Map<Integer, Long> dp = new HashMap<>();
        //     int mod = 1_000_000_007;
        //     long res = 0;
        //     long max = 0;
        //     for (int i = 0; i < n; i++) {
        //         dp.put(arr[i], 1l);
        //         for (int j = 0; j < i; j++) {
        //             if (arr[i] % arr[j] == 0 && dp.containsKey(arr[i]/arr[j])) {
        //                 max = dp.get(arr[i]) + dp.get(arr[j]) * dp.get(arr[i]/arr[j]);
        //                 dp.put(arr[i], max % mod);
        //             }
        //         }
        //         res += dp.get(arr[i]);
        //         res %= mod;
        //     }
        //     return (int)(res % mod);
        // }


        // public int sumSubarrayMins(int[] arr) {
        //     int n = arr.length;
        //     // for each A[i], find k <= i <= j, so that A[i] is the min from [k,j]
        //     // sum += A[i] * (i-k+1) * (j-i+1)
        //     // so we need to find the next min to the right and to the left
        //     //这个过程可以简化为使用一个栈。对于被某个数从栈中弹出的数而言，它右侧第一个比它小的数就是这个数。所以我们可以对所有被弹出的数得到左侧的区间范围和右侧的区间范围。我觉得这是一种非常聪明的做法。 这个栈我看得稀里糊涂，再想一下
        //     long [] right = new long [n];  // next smaller element index to the right 
        //     long [] left = new long[n];    // next smaller element index to the left
        //     Stack<Integer> s = new Stack<>();
        //     for (int i = 0; i < n; i++) {
        //         while (!s.isEmpty() && arr[i] <= arr[s.peek()]) {
        //             right[s.pop()] = i-1;
        //         }
        //         s.push(i);
        //     }
        //     while (!s.isEmpty()) {
        //         right[s.pop()] = n-1;
        //     }
        //     s.clear();
        //     for (int i = n-1; i >= 0; i--) {
        //         while (!s.isEmpty() && arr[i] < arr[s.peek()])
        //             left[s.pop()] = i+1;
        //         s.push(i);
        //     }
        //     while (!s.isEmpty())
        //         left[s.pop()] = 0;
        //     long sum = 0;
        //     long leftsize = 0, rightsize = 0;
        //     for (int i = 0; i < n; i++) {
        //         leftsize = i - left[i] +1;
        //         rightsize = right[i] - i + 1;
        //         sum += arr[i] * leftsize * rightsize;
        //         sum %= mod;
        //     }
        //     return (int)sum;
        // }
        // int mod = 1_000_000_007;
        // public int sumSubarrayMins(int[] arr) {
        //     int n = arr.length;
        //     long [] left = new long[n];
        //     long [] right = new long[n];
        //     long sum = 0;
        //     long cnt = 0;
        //     int j = 0;
        //     for (int i = 0; i < n; i++) { // 计算左边比自身大的数的个数
        //         cnt = 1;
        //         j = i-1;
        //         while (j >= 0 && arr[j] >= arr[i]) {
        //             cnt += left[j];
        //             j -= left[j];
        //         }
        //         left[i] = cnt;
        //     }
        //     // 就是因为计算了两个方向，所以对于数组里面有相同元素的情况下，需要特别考虑一下。
        //     //     不能重复计算， 也不能漏掉，
        //     //     具体就是一个方向的时候用<=, 另外一个方向的时候用<。 这个在做的时候也bug了。
        //     for (int i = n-1; i >= 0; i--) { // 计算右边比自身大的数的个数
        //         cnt = 1;
        //         j = i+1;
        //         while (j < n && arr[j] > arr[i]) {
        //             cnt += right[j];
        //             j += right[j];
        //         }
        //         right [i] = cnt;
        //     }
        //     for (int i = 0; i < n; i++) 
        //         sum += arr[i] * left[i] * right[i];
        //     return (int) (sum % mod);
        // }


        // public int maxResult(int[] nums, int k) { // O(N) DP with double ended queue
        //     int n = nums.length;
        //     int [] dp = new int[n];
        //     ArrayDeque<Integer> q = new ArrayDeque<>();
        //     for (int i = 0; i < n; i++) {
        //         while (!q.isEmpty() && q.peekFirst() < i-k) // 头大尾小
        //             q.removeFirst();
        //         dp[i] = nums[i] + (q.isEmpty() ? 0 : dp[q.peekFirst()]);
        //         while (q.size() > 0 && dp[q.peekLast()] <= dp[i])
        //             q.removeLast();
        //         q.addLast(i);
        //     }
        //     return dp[n-1];
        // }
        // public int maxResult(int[] nums, int k) { // BigO: O (NlogN)
        //     int n = nums.length;
        //     int [] dp = new int[n];
        //     Queue<int []> q = new PriorityQueue<>(Comparator.comparingInt(e -> -e[0]));
        //     for (int i = 0; i < n; i++) {
        //         while (!q.isEmpty() && q.peek()[1] + k < i)
        //             q.poll();
        //         dp[i] = nums[i] + (q.isEmpty() ? 0 : q.peek()[0]);
        //         q.add(new int[] {dp[i], i});
        //     }
        //     return dp[n-1];
        // }

        
        // public int longestPalindromeSubseq(String s) {
        //     int n = s.length();
        //     int [][] dp = new int [n][n];
        //     dp[n-1][n-1] = 1;
        //     for (int i = n-2; i >= 0; i--) {
        //         dp[i][i] = 1;
        //         for (int j = i+1; j < n; j++) {
        //             if (s.charAt(i) == s.charAt(j))
        //                 dp[i][j] = 2 + dp[i+1][j-1];
        //             else dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
        //         }
        //     }
        //     return dp[0][n-1];
        // }


        // private int dfs(int [] arr, int i, int j) {
        //     if (i >= j) return 0;
        //     if (j - i == 1) return 0;
        //     if (dp[i][j] != Integer.MAX_VALUE) return dp[i][j];
        //     for (int x = i+1; x < j; x++) 
        //         dp[i][j] = Math.min(dp[i][j], arr[j] - arr[i] + dfs(arr, i, x) + dfs(arr, x, j));
        //     return dp[i][j];
        // }
        // int [][] dp;
        // int m;
        // public int minCost(int n, int[] cuts) {
        //     int m = cuts.length + 2;
        //     dp = new int [m][m];
        //     for (int i = 0; i < m; i++) 
        //         Arrays.fill(dp[i], Integer.MAX_VALUE);
        //     Arrays.sort(cuts);
        //     int [] arr = new int [m];
        //     System.arraycopy(cuts, 0, arr, 1, cuts.length);
        //     arr[m-1] = n;
        //     return dfs(arr, 0, m-1);
        // }


        // // 动态规划，递归可以使逻辑简单（本质还是动态规划）
        // // 将多边形起始位置设为start，end, 用一个数组dp来记录任意起始位置的score
        // //     为了计算dp[start][end], 我们用一个index k在start到end之间遍历
        // //     dp[start][end] = min(dp[start][k] + dp[k][end] + A[start] * A[k] * A[end])
        // //     结果为dp[0][n - 1]
        // //     注意：
        // //     相邻的dp[i][i + 1] = 0, 因为两条边无法组成三角形
        // private int dfs(int [] arr, int x, int y) {
        //     if (y - x < 2) return dp[x][y] = 0;
        //     if (dp[x][y] > 0) return dp[x][y];
        //     int min = Integer.MAX_VALUE;
        //     for (int i = x+1; i < y; i++) 
        //         min = Math.min(min, dfs(arr, x,  i) + dfs(arr, i, y) + arr[x]*arr[i]*arr[y]);
        //     return dp[x][y] = min;
        // }
        // int [][] dp;
        // int n;
        // public int minScoreTriangulation(int[] arr) {
        //     n = arr.length;
        //     dp = new int [n][n];
        //     return dfs(arr, 0, n-1);
        // }


        // // state是前走的人走完之后的局面，sum是当前数字总和，返回的是当前走的人是否能赢
        // private boolean dfs(int max, int target, int state, int val) {
        //     if (dp[state] != -1) return dp[state] > 0;
        //     if (val >= target) { // 如果对方取数的时候总和达到target了，则当前走的人输了，做记忆并返回false
        //         dp[state] = 0;
        //         return false;
        //     }
        //     for (int i = 1; i <= max; i++) {  // 枚举当前人取哪个数
        //         if ((state >> i-1 & 1) == 0 && !dfs(max, target, state | (1 << i-1), val + i)) {
        //             dp[state] = 1;
        //             return true;
        //         }
        //     }
        //     dp[state] = 0;
        //     return false;
        // }
        // int [] dp;
        // public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        //     if (desiredTotal <= maxChoosableInteger) return true;
        //     if (desiredTotal > (maxChoosableInteger + 1)*maxChoosableInteger / 2) return false;
        //     dp = new int[1 << maxChoosableInteger]; // 时空复杂度O ( 2 m ) O(2^m)O(2 
        //     Arrays.fill(dp, -1);
        //     return dfs(maxChoosableInteger, desiredTotal, 0, 0);
        // }


        // public double champagneTower(int poured, int query_row, int query_glass) {
        //     double[][] dp = new double[101][101];
        //     dp[0][0] = poured;
        //     for (int i = 0; i <= query_row; i++) {
        //         for (int j = 0; j <= i; j++) {
        //             if (dp[i][j] >= 1) {
        //                 dp[i+1][j] += (dp[i][j] - 1.0) / 2.0;
        //                 dp[i+1][j+1] += (dp[i][j] - 1.0) / 2.0;
        //             }
        //         }
        //     }
        //     return Math.min(1.0, dp[query_row][query_glass]);
        // }
        // // 想到pascal triangle上去了，其它比那个简单太多

        
        // private int dfs(int l, int r) {
        //     if (dp[l][r] > 0) return dp[l][r];
        //     if (l == r) return dp[l][r] = 0;
        //     if (l == r-1) return dp[l][r] = Math.min(l, r);
        //     int min = Integer.MAX_VALUE;
        //     for (int i = l; i <= r; i++) {
        //         min = Math.min(min, i + Math.max((i == r ? i : dfs(i+1, r)), (i == l ? i : dfs(l, i-1))));
        //     }
        //     return dp[l][r] = min;
        // }
        // int [][] dp;
        // public int getMoneyAmount(int n) {
        //     dp = new int[n+1][n+1];
        //     return dfs(1, n);
        // }        

    }
    
    public static void main(String[] args) {
        Solution s = new Solution();

        int []  a = new int []  {2, 7, 13, 19};

        int r = s.nthUglyNumber(12);
        System.out.println("r: " + r);
    }
}