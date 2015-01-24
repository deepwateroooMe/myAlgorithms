import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class isScramble {
    public static class Solution {
        public boolean isScramble(String s1, String s2) {
            if (s1 == null || s2 == null) return false;
            if (s1.length() != s2.length()) return false;
            int n = s1.length();
            
            // dp[k][i][j] s2 from j k length frag is Scr of s1 from i of k len
            boolean [][][] dp = new boolean[n + 1][n][n];
            for (int i = 0; i < n; i++) 
                for (int j = 0; j < n; j++) 
                    dp[1][i][j] = s1.charAt(i) == s2.charAt(j) ? true : false;

            for (int k = 2; k <= n; k++) {
                for (int i = 0; i <= n - k; i++) {
                    for (int j = 0; j <= n - k; j++) {
                        dp[k][i][j] = false;
                        // x len of substring bgn from substring start
                        for (int x = 1; x < k && !dp[k][i][j]; x++) {
                            dp[k][i][j] = ( (dp[x][i][j] && dp[k - x][x + i][x + j])
                                           || (dp[k - x] [x + i][j] && dp[x][i][k - x + j]));
                        }
                    }
                }
            }
            return dp[n][0][0];
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String s = "great";
        String t = "rgeat";
        boolean res = result.isScramble(s, t);
        
        System.out.println(res);
    }
}
