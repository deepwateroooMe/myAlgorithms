import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class longestValidParentheses {
    public static class Solution {
        public int longestValidParentheses(String s) {
            if (s == null || s.length() < 2) return 0;
            else if (s.length() == 2) return s.equals("()") ? 2 : 0;
            Stack<Integer> k = new Stack<Integer>();
            int [] res = new int[s.length()];
            int i = 0;
            char j;
            int tmp;
            while (i < s.length()) {
                j = s.charAt(i);
                if (j == '(') {
                    k.push(i);
                } else if (j == ')'){
                    if (!k.isEmpty()) {
                        res[i] = 1;
                        tmp = k.pop();
                        res[tmp] = 1;
                    }
                }
                ++i;
            }
            
            // count continue ones
            int max = 0;
            tmp = res[0] == 1 ? 1 : 0;
            for ( i = 1; i < s.length(); i++) {
                if (res[i] == res[i - 1] && res[i] == 1) {
                    ++tmp;
                    if (tmp > max) max = tmp;
                } else if (res[i] == 0) {
                    if (res[i - 1] == 1)
                        if (tmp > max) max = tmp;                            
                    tmp = 0;
                } else tmp = 1;
            }
            return max;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String s = "(()(((()";
        
        int res = result.longestValidParentheses(s);
        
        System.out.println(res);
    }
}
/*  158/229, work on it later ~~!!
  Input:	"(()(((()"
Output:	4
Expected:	2

  Input:	")()(((())))("
Output:	0
Expected:	10

  Input:	"()()"
Output:	0
Expected:	4

  Input:	"()(()"
Output:	4
Expected:	2

  Input:	"(()"
  Output:	0
  Expected:

  Runtime Error Message:	Line 10: java.lang.StringIndexOutOfBoundsException: String index out of range: 8
  Last executed input:	"))))))))"
*/
