import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class numDistanceDistinctSequence {
    public static class Solution {
        public int numDistinct(String s, String t) {
            if (s == null || s.length() == 0) return 0;
            int m = s.length();
            int n = t.length();
            if (n == 0) return 1;
            
            int [][] res = new int[m + 1][n + 1];
            for (int i = 0; i <= m; i++) // when t = ""
                res[i][0] = 1;
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (s.charAt(i - 1) == t.charAt(j - 1))
                        res[i][j] = res[i - 1][j] + res[i - 1][j - 1];
                    else
                        res[i][j] = res[i - 1][j];
                }
            }
            return res[m][n];
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String s = "rabbbit";
        String t = "rabbit";
        int res = result.numDistinct(s, t);
        
        System.out.println(res);
    }
}
