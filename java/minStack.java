import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class minStack {
    public static class MinStack {
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> minStack = new Stack<Integer>();
        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty() || x <= minStack.peek()) {
                minStack.push(x);
            }
        }

        public void pop() {
            int tmp = stack.pop();  // different from c++, return object
            //if (stack.peek() == minStack.peek()) { // sth wrong here   
            if (tmp == minStack.peek()) {
                minStack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            if (!minStack.isEmpty()) {
                return minStack.peek();
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args){
        MinStack result = new MinStack();
        result.push(512);
        result.push(-1024);
        result.push(-1024);
        result.push(512);
        result.pop();
        int res = result.getMin();
        System.out.println(res);
        result.pop();
        res = result.getMin();
        System.out.println(res);
        result.pop();
        res = result.getMin();
        System.out.println(res);
    }
}
/*
  push(512),push(-1024),push(-1024),push(512),pop,getMin,pop,getMin,pop,getMin
  Output:	[-1024,-1024,-1024]
  Expected:	[-1024,-1024,512]
*/
