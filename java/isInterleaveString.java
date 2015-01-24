import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class isInterleaveString {
    public static class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            if (s1 == null || s2 == null) return s3 == null;
            int m = s1.length();
            int n = s2.length();
            if (s3.length() != m + n) return false;
            if (m == 0) return s2.equals(s3);
            else if (n == 0) return s1.equals(s3);
            
            boolean [][] res = new boolean[m + 1][n + 1];
            res[0][0] = true;
            for (int j = 1; j <= n ; j++) {
                if (res[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1)) res[0][j] = true;
                else break;
            }
            for (int j = 1; j <= m ; j++) {
                if (res[j - 1][0] && s1.charAt(j - 1) == s3.charAt(j - 1)) res[j][0] = true;
                else break;
            }
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n ; j++) {
                    res[i][j] = ((res[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                                 (res[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1))));
                }
            }
            return res[m][n];
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String s1 = "aabaac";
        String s2 = "aadaaeaaf";
        String s3 = "aadaaeaabaafaac";
        boolean res = result.isInterleave(s1, s2, s3);
        
        System.out.println(res);
    }
}
/*
  Runtime Error Message:	Line 14: java.lang.ArrayIndexOutOfBoundsException: 7
Last executed input:	"aabaac", "aadaaeaaf", "aadaaeaabaafaac"
*/
