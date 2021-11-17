import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.Arrays;
import java.util.stream.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;

public class dpseven {
    public static class Solution {

        public int minDistance(int[] h, int k) {
            n = h.length;
            d = new int [n][n];
            dp = new int [n][k+1];
            Arrays.sort(h);
            return dfs(h, 0, k);
        }
        int [][] d;
        int [][] dp;
        int n;
        private int dfs(int [] a, int i, int k) {
            if (i == n || i == n-k) return 0; // 剩余每户人家放一个邮箱，距离为0
            if (k == 1) return dp[i][k] = getDist(a, i, n-1);
            if (dp[i][k] > 0) return dp[i][k];
            int ans = Integer.MAX_VALUE;
            for (int j = i; j < n-(k-1); j++)  // 留足k-1户人家
                ans = Math.min(ans, dfs(a, j+1, k-1) + getDist(a, i, j));
            return dp[i][k] = ans;
        }
        private int getDist(int [] a, int i, int j) {
            if (d[i][j] > 0) return d[i][j];
            int m = i + (j-i) / 2, v = a[m], sum = 0;
            for (int k = i; k <= j; k++) 
                sum  += Math.abs(v - a[k]);
            return d[i][j] = sum;
        }
        public int minDistance(int[] h, int k) {
            int n = h.length;
            Arrays.sort(h);
            int [][] medsum = new int[n][n];
            for (int i = n - 2; i >= 0; --i) 
                for (int j = i + 1; j < n; ++j) 
                    medsum[i][j] = medsum[i + 1][j - 1] + h[j] - h[i];
            int [][] f = new int[n][k + 1];
            for (int i = 0; i < n; ++i) 
                Arrays.fill(f[i], Integer.MAX_VALUE / 2);
            for (int i = 0; i < n; ++i) {
                f[i][1] = medsum[0][i];
                for (int j = 2; j <= k && j <= i + 1; ++j)
                    for (int x = 0; x < i; x++) 
                        f[i][j] = Math.min(f[i][j], f[x][j-1] + medsum[x+1][i]);
            }
            return f[n - 1][k];
        }

        
    }
    public static void main(String[] args) {
        Solution s = new Solution();



        int [] a = new int [] {7,2,6,8};

        int r = s.minDistance(a, 1);
        System.out.println("r: " + r);
    }
}