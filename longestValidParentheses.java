import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class longestValidParentheses {
    public static class Solution {
        public class Oj {
            char val;
            int x;
            public Oj(char b, int a) {
                val = b;
                x = a;
            }
        }

        public int longestValidParentheses(String s) {
            if (s == null || s.length() < 2) return 0;
            else if (s.length() == 2) return s.equals("()") ? 2 : 0;
            Stack<Oj> k = new Stack<Oj>();
            int i = 0, res = 0, one = 0, start = 0, end = 0;
            char j;
            Oj top;
            while (i < s.length() && k.isEmpty()) {
                j = s.charAt(i);
                if (j == '(') {
                    k.push(new Oj(j, i));
                    start = i;
                    ++i;
                    ++one;
                } else ++i;
            }
            if (i == s.length()) return 0;
            while (i < s.length()) {
                j = s.charAt(i);
                if (j == '(') {
                    k.push(new Oj(j, i));
                    ++one;
                } else {
                    if (!k.isEmpty()) {
                        k.pop();
                        ++one;
                    } else {
                        if (one > res) 
                            res = one;
                        one = 0;
                    }
                }
                ++i;
            }
            if (!k.isEmpty()) {
                while (!k.isEmpty()) {
                    top = k.pop();
                    --one;
                    end = top.x;
                }
                if (one > res && i - 1 - end == one) return one;
                else if (one > res && i - 1 - end < one) 
                    return Math.max(Math.max(res, i - 1 - end),
                                    Math.max(res, end - start));
            }
            return Math.max(res, one);
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
