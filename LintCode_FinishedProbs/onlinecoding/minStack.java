import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class minStack {
    public static class Solution {
        Stack<Integer> s;
        Stack<Integer> t;
        public Solution() {
            s = new Stack<Integer>();
            t = new Stack<Integer>();
        }

        public void push(int x) {
            if (t.isEmpty() || (!t.isEmpty() && x <= t.peek().intValue()))
                t.push(x);
            s.push(x);
        }

        public int pop() {
            int tmp = s.pop().intValue();
            if (!t.isEmpty() && tmp == t.peek().intValue())
                t.pop();
            return tmp;
        }

        public int min() {
            return t.peek();
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        result.push(1);
        System.out.println("result.pop(): " + result.pop());
        result.push(2);
        result.push(3);
        System.out.println("result.min(): " + result.min());
        result.push(1);
        System.out.println("result.min(): " + result.min());
    }
}
