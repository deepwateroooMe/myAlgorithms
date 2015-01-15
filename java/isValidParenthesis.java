import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class isValidParenthesis {
    public static class Solution {
        public boolean mymatch(char s, char t) {
            switch (s) {
            case '(':
                if (t == ')') return true;
                return false;
            case '[':
                if (t == ']') return true;
                return false;
            case '{':
                if (t == '}') return true;
                return false;
            }
            return false;
        }
        
        public boolean isValid(String s) {
            if (s == null || s.length() == 0) return false;
            Stack<Character> stack = new Stack<Character>();
            stack.push(s.charAt(0));
            int cnt = 1;
            char top = 'a';
            while (cnt < s.length()) {
                if (s.charAt(cnt) == '(' || s.charAt(cnt) == '[' || s.charAt(cnt) == '{')
                    stack.push(s.charAt(cnt));
                else {
                    if (stack.isEmpty())
                        return false;
                    else {
                        top = stack.pop();
                        if (!stack.isEmpty() && !mymatch((char)top, s.charAt(cnt)))
                            return false;
                    }
                }
                cnt++;
            }
            if (stack.isEmpty())
                return true;
            return false;
        }
    }
    
    public static void main(String[] args){
        Solution result = new Solution();
        String s = "([)";
        boolean res = result.isValid(s);
        
        System.out.println(res);
    }
}
