import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class minCutPalindromePartitioningII {
    public static class Solution {
        // will have to use dynamic programming, think about it ...
        // use the symmetric cutting
        public int minCut(String s) {
            if (s == null || s.length() == 0)  return 0;
            int n = s.length();
            int [] res = new int[n + 1];
            for (int i = 0; i <= n ; i++) 
                res[i] = i - 1;

            for (int i = 0; i < n; i++) {
                // s[i - j] == s[i + j], aba
                for (int j = 0; i - j >= 0 && i + j <= n - 1 && s.charAt(i - j) == s.charAt(i + j); j++)
                    res[i + j + 1] = Math.min(res[i - j] + 1, res[i + j + 1]);

                // s[i - j] == s[i + 1 + j], abba
                for (int j = 0; i - j >= 0 && i + 1 + j <= n - 1 && s.charAt(i - j) == s.charAt(i + 1 + j); j++)
                    res[i + j + 2] = Math.min(res[i - j] + 1, res[i + j + 2]);
            }
            return res[n];
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String s = "cdd";
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
