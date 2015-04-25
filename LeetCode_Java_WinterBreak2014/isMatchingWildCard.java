import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class isMatchingWildCard {
    public static class Solution {
        public boolean isMatch0(String s, String p) {
            if (p.length() == 0 && s.length() != 0) return false;
            else if (s.length()== 0 && p.length() == 0)  return true;
            else if (s.length() == 0 && p.charAt(0) != '*') return false;
            /*
            int m = s.length();
            int n = p.length();
            int i = 0;
            int j = 0;
            if (s.charAt(i) != p.charAt(j) && p.charAt(j) != '?' && p.charAt(j) != '*')
                return false;
            while ( s < m && j < n &&
                    (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') ) {
                i++;
                j++;
            }
            if (i == m && j == n) return true;
            else if (j == n) return false;
            else if (i == m && j < n) {
                if (p.charAt(j) != '*') return false;
                while (j < n && p.charAt(j) == '*') j++;
                if (j == n) return true;
                else return false;
            } else if (s.charAt(i) != p.charAt(j) && p.charAt(j) != '?' && p.charAt(j) != '*')
                return false;
            else if (p.charAt(j) == '*') {
                j++;
                while (i < m && j < n && (p.charAt(j) == '*' || p.charAt(j) == '?')) {
                    if ( p.charAt(j) == '?') i++;
                    j++;   
                }  // way too crazy ....
                // dp should be much easier
                if (j == n) return true;
                } */
            return false;
        }

        public boolean isMatch(String s, String p) {
            int minLen = 0;
            for (int i = 0; i < p.length(); i++) 
                if (p.charAt(i) != '*') ++minLen;
            if (s.length() < minLen) return false;
            int m = s.length();
            int n = p.length();
            boolean [][] dp = new boolean[m + 1][n + 1];
            dp[0][0] = true;
            for (int i = 1; i <= m ; i++) 
                dp[i][0] = false;
            for (int i = 1; i <= n ; i++) 
                dp[0][i] = (p.charAt(i - 1) == '*' && dp[0][i - 1]) ? true : false;
            for (int i = 1; i <= m; i++) 
                for (int j = 1; j <= n ; j++) {
                    if (p.charAt(j - 1) == '*')  // user * or not
                        dp[i][j] = (dp[i - 1][j] || dp[i][j - 1]);
                    else if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')
                        dp[i][j] = dp[i - 1][j - 1];
                }
            return dp[m][n];
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String s = "adcab";
        String t = "*a*b";
        boolean res = result.isMatch(s, t);
        
        System.out.println(res);
    }
}
