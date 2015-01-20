import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class minCut {
    public static class Solution {
        // will have to use dynamic programming, think about it ...
        public int minCut(String s) {
            if (s == null || s.length() == 0)  return 0;
            int res = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                System.out.println("i: " + i);

                int bgn = 0;
                int end = i;
                while (bgn < end) {
                    if (s.charAt(bgn) == s.charAt(end)) {
                        bgn ++;
                        end --;
                    } else break;
                }
                if (bgn >= end) {
                    res = s.length() - 1 - i;
                    break;
                }
            }
            return res;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String s = "cbb";
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
