import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class minDistance {
    public static class Solution {
        public int minDistance(String s, String t) {
            int m = s.length();
            int n = t.length();
            int [][] res = new int[m + 1][n + 1];
            for (int i = 0; i <= m; i++)
                res[i][0] = i;
            for (int i = 0; i <= n; i++)
                res[0][i] = i;

            for (int i = 1; i <= m; i++) 
                for (int j = 1; j <= n; j++) 
                    if (s.charAt(i - 1) == t.charAt(j - 1))
                        res[i][j] = res[i - 1][j - 1];
                    else 
                        res[i][j] = Math.min(Math.min(res[i - 1][j], res[i][j - 1]),
                                             Math.min(res[i - 1][j], res[i - 1][j - 1])) + 1;
            return res[m][n];
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String s = "distance";
        String t = "springbok";
        int res = result.minDistance(s, t);
        
        System.out.println(res);
    }
}
/*
  Input:	"distance", "springbok"
Output:	8
Expected:	9

  Input:	"", "a"
Output:	0
Expected:	1
 */
