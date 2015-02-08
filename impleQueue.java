import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class impleQueue {
    public static class Solution {
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;
        public Solution() {
            stack1 = new Stack<Integer>();
            stack2 = new Stack<Integer>();
        }
    
        public void push(int element) {
            while (!stack2.isEmpty()) {
                int tmp = stack2.pop();
                stack1.push(tmp);
            }
            stack1.push(element);
            while (!stack1.isEmpty()) {
                int tmp = stack1.pop();
                stack2.push(tmp);
            }
        }

        public int pop() {
            int tmp = stack2.pop();
            return  tmp;
        }

        public int top() {
            int tmp = stack2.peek();
            return tmp;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();

        System.out.println(res);
    }
}
