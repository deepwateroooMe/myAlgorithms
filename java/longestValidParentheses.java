import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class longestValidParentheses {
    public static class Solution {
        public int longestValidParentheses0(String s) {
            Stack<Integer> k = new Stack<Integer>();
            int [] res = new int[s.length()];
            char j;
            int tmp = 0;
            for (int i = 0; i < s.length(); i++) {
                j = s.charAt(i);
                if (j == '(') 
                    k.push(i);
                else if (j == ')'){
                    if (!k.isEmpty()) {
                        res[i] = 1;
                        tmp = k.pop();
                        res[tmp] = 1;
                    }
                }
            }
            int max = 0;
            int i = 0;
            while (i < s.length()) {
                tmp = 0;  // reset value
                while (i < s.length() && res[i] == 0) i++;
                while (i < s.length() && res[i] == 1) {
                    tmp++;
                    i++;
                }
                max = Math.max(max, tmp);
            }
            return max;
        }

        public int longestValidParentheses1(String s) {
            Stack<Integer> k = new Stack<Integer>();
            int res = 0;
            int tmp = 0;
            k.push(-1); // 
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(')
                    k.push(i);
                else { // ')'
                    if (k.isEmpty())
                        k.push(i);
                    else {
                        tmp = k.peek();
                        if (tmp >= 0 && s.charAt(tmp) == '(') {
                            k.pop();
                            res = Math.max(res, i - k.peek());
                        } else k.push(i);
                    }
                }
            }
            return res;
        }

        public int longestValidParentheses(String s) {
            int n = s.length();
            int res = 0;
            int [] dp = new int[n];
            int j = 0;
            for (int i = n - 2; i >= 0; i--) {
                if (s.charAt(i) == '(') {
                    j = dp[i + 1] + i + 1;
                    if (j < n && s.charAt(j) == ')') {
                        dp[i] = dp[i + 1] + 2;
                        if (j + 1 < n)
                            dp[i] += dp[j + 1];
                        res = Math.max(res, dp[i]);
                    }
                }
            }
            return res;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String s = "(()";
        
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
