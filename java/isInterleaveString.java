import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class isInterleaveString {
    public static class Solution {
        public boolean isInterleave0(String s1, String s2, String s3) { 
            int m = s1.length();
            int n = s2.length();
            if (s3.length() != m + n) return false;
            return true;
        }
        
        public boolean isInterleave1(String s1, String s2, String s3) {
            int m = s1.length();
            int n = s2.length();
            if (s3.length() != m + n) return false;
            boolean [][] f = new boolean[m + 1][n + 1];
            f[0][0] = true;
            for (int j = 1; j <= m ; j++) 
                f[j][0] = f[j - 1][0] && s1.charAt(j - 1) == s3.charAt(j - 1);
            for (int j = 1; j <= n ; j++) 
                f[0][j] = f[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n ; j++) {
                    f[i][j] = ((f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                                 (f[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1))));
                }
            }
            return f[m][n];
        }

        public boolean isInterleave(String s1, String s2, String s3) {
            int m = s1.length();
            int n = s2.length();
            if (s3.length() != m + n) return false;
            if (m < n) return isInterleave(s2, s1, s3);
            boolean [] f = new boolean[n + 1];
            for (int i = 0; i < n + 1; i++) 
                f[i] = true;
            for (int i = 1; i < n + 1 ; i++) 
                f[i] = s2.charAt(i - 1) == s3.charAt(i - 1) && f[i - 1];
            for (int i = 1; i < m + 1; i++) {
                f[0] = s1.charAt(i - 1) == s3.charAt(i - 1) && f[0];
                for (int j = 1; j < n + 1; j++) 
                    f[j] = (s1.charAt(i - 1) == s3.charAt(i + j - 1) && f[j])
                        || (s2.charAt(j - 1) == s3.charAt(i + j - 1) && f[j - 1]);
            }
            return f[n];
        }

    }

    public static void main(String[] args){
        Solution result = new Solution();
        String s1 = "";
        String s2 = "";
        String s3 = "";
        boolean res = result.isInterleave(s1, s2, s3);
        
        System.out.println(res);
    }
}
/*
  Runtime Error Message:	Line 14: java.lang.ArrayIndexOutOfBoundsException: 7
Last executed input:	"aabaac", "aadaaeaaf", "aadaaeaabaafaac"
*/
