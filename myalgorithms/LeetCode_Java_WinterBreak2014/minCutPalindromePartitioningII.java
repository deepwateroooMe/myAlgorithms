import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class minCutPalindromePartitioningII {
    public static class Solution {
        // will have to use dynamic programming, think about it ...
        // use the symmetric cutting
        
        public int minCut0(String s) {
            if (s == null || s.length() == 0)  return 0;
            int n = s.length();
            int [] dp = new int[n + 1];
            for (int i = 0; i <= n ; i++) 
                dp[i] = i - 1;

            for (int i = 0; i < n; i++) {
                // s[i - j] == s[i + j], aba
                for (int j = 0; i - j >= 0 && i + j <= n - 1 && s.charAt(i - j) == s.charAt(i + j); j++)
                    dp[i + j + 1] = Math.min(dp[i - j] + 1, dp[i + j + 1]);

                // s[i - j] == s[i + 1 + j], abba
                for (int j = 0; i - j >= 0 && i + 1 + j <= n - 1 && s.charAt(i - j) == s.charAt(i + 1 + j); j++)
                    dp[i + j + 2] = Math.min(dp[i - j] + 1, dp[i + j + 2]);
            }
            return dp[n];
        }

        public int minCut(String s) {
            int n = s.length();
            int [] f = new int[n + 1];
            boolean [][] p = new boolean[n][n];
            for (int i = 0; i <= n; i++) 
                f[i] = n - 1 - i;
            for (int i = n - 1; i >= 0; i--) {
                for (int j = i; j < n; j++) {
                    if (s.charAt(i) == s.charAt(j) &&
                        (j - i < 2 || p[i + 1][j - 1] == true)) {
                        p[i][j] = true;
                        f[i] = Math.min(f[i], f[j + 1] + 1);
                    }
                }
            }
            return f[0];
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String s = "a";
        int res = result.minCut(s);
        
        System.out.println(res);
    }
}
/*
  Input:	"cdd"
  Output:	2
  Expected:	1

  Input:	"bb"
  Output:	1
  Expected:	0

  Input:	"ab"
  Output:	0
  Expected:	1
*/
