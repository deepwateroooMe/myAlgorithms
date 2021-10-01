// import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class DinnerPlates {

    List<Stack<Integer>> ss = new ArrayList<>();
    Stack<Integer> s;
    int capacity;
    int left, right, idx;
    
    public DinnerPlates(int capacity) {
        this.capacity = capacity;
        s = new Stack<>();
        left = 0;
        right = 0;
        idx = 0;
        ss = new ArrayList<>();
        ss.add(s);
    }
    
    public void push(int val) {
        if (this.s.size() < capacity) {
            s.push(val);
            // if (s.size() == capacity) {
            //     s = new Stack<>();
            //     ++idx;
            //     ss.add(s);
            // }
        } else {
            s = new Stack<Integer>();
            s.push(val);
            ss.add(s);
            ++idx;
            right = idx;
        }
    }
    
    public int pop() {
        if (s.size() > 0) {
            int val = s.pop();
            if (s.size() == 0) {
                --idx;
                --right;
            }
            return val;
        } else {
            --idx;
            --right;
            if (idx >= 0) {
                s = ss.get(idx);
                return s.pop();
            } else
                return -1;
        }
    }
    
    public int popAtStack(int index) {
        if (ss.get(index).size() > 0) 
            return (int)ss.get(index).pop();
        else {
            return -1;
        }
    }
    
    public static void main(String[] args) {
        DinnerPlates s = new DinnerPlates(2);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        int r = s.popAtStack(0);
        System.out.println("r: " + r);

        s.push(20);
        s.push(21);
        int r1 = s.popAtStack(0);
        System.out.println("r1: " + r1);

        int r2 = s.popAtStack(2);
        System.out.println("r2: " + r2);

        int r3 = s.pop();
        System.out.println("r3: " + r3);

        int r4 = s.pop();
        System.out.println("r4: " + r4);

        int r5 = s.pop();
        System.out.println("r5: " + r5);

        int r6 = s.pop();
        System.out.println("r6: " + r6);

        int r7 = s.pop();
        System.out.println("r7: " + r7);
    
    }
 }