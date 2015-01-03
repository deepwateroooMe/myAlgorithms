import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class evalRPN {
    public static class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<Integer>();
            if (tokens == null || tokens.length == 0) return 0;
            int one = 0, two = 0, result = 0;
            for(String i : tokens) {
                if (i.equals("+")) {
                    one = stack.pop();
                    two = stack.pop();
                    stack.push(one + two);
                } else if (i.equals("-")) {
                    one = stack.pop();
                    two = stack.pop();
                    stack.push(two - one);
                } else if (i.equals("*")) {
                    one = stack.pop();
                    two = stack.pop();
                    stack.push(one * two);
                } else if (i.equals("/")) {
                    one = stack.pop();
                    two = stack.pop();
                    stack.push(two / one);
                } else {
                    stack.push(Integer.parseInt(i));
                }
            }
            return stack.pop();
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String [] a = {"4", "13", "5", "/", "+"};
        int res = result.evalRPN(a);
        
        System.out.println(res);
    }
}
