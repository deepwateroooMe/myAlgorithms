// import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.TreeSet;

public class DinnerPlates {

    List<Deque<Integer>> stackList = new ArrayList<>();
    TreeSet<Integer> pushIdxSet = new TreeSet<>();
    TreeSet<Integer> popIdxSet = new TreeSet<>();
    int capacity;
    public DinnerPlates(int capacity) {
        stackList = new ArrayList<>();
        pushIdxSet = new TreeSet<>();
        popIdxSet = new TreeSet<>();
        this.capacity = capacity;
        stackList.add(new ArrayDeque<>());
        pushIdxSet.add(0);
    }
    public void push(int val) {
        int idx = pushIdxSet.first();
        if (stackList.get(idx).isEmpty()) 
            popIdxSet.add(idx);
        stackList.get(idx).offerLast(val);
        if (stackList.get(idx).size() == capacity) {
            if (idx == stackList.size() - 1) {
                stackList.add(new ArrayDeque<>());
                pushIdxSet.add(idx + 1);
            }
            pushIdxSet.remove(idx);
        }
    }
    public int pop() {
        if (popIdxSet.isEmpty()) return -1;
        int idx = popIdxSet.last();
        if (stackList.get(idx).size() == capacity)
            pushIdxSet.add(idx);
        int res = stackList.get(idx).pollLast();
        if (stackList.get(idx).isEmpty())
            popIdxSet.remove(idx);
        return res;
    }
    public int popAtStack(int index) {
        if (index >= stackList.size()) return -1;
        if (stackList.get(index).isEmpty()) return -1;
        if (stackList.get(index).size() == capacity)
            pushIdxSet.add(index);
        int res = stackList.get(index).pollLast();
        if (stackList.get(index).isEmpty()) 
            popIdxSet.remove(index);
        return res;
    }

    // Stack<Stack<Integer>> stacks = new Stack<>();
    // TreeSet<Integer> set = new TreeSet<>(); // set: 
    // int capacity;
    // public DinnerPlates(int capacity) {
    //     this.capacity = capacity;
    //     stacks = new Stack<>();
    // }
    // public void push(int val) {
    //     if (set.size() != 0) {
    //         int idx = set.iterator().next();
    //         stacks.get(idx).push(val);
    //         if (stacks.get(idx).size() == capacity)
    //             set.remove(idx);
    //     } else {
    //         if (stacks.isEmpty() || stacks.peek().size() == capacity) {
    //             stacks.add(new Stack<>()); // 更高效一点儿？ // stacks.push(new Stack<>());
    //             stacks.peek().add(val);
    //         } else stacks.peek().add(val);
    //     }
    // }
    // public int pop() {
    //     if (!stacks.isEmpty()) {
    //         int k = stacks.peek().pop();
    //         while (!stacks.isEmpty() && stacks.peek().isEmpty()) {
    //             set.remove(stacks.size()-1);
    //             stacks.pop();
    //         }
    //         return k;
    //     }
    //     return -1;
    // }
    // public int popAtStack(int index) {
    //     if (index >= stacks.size() || stacks.get(index).size() == 0) 
    //         return -1;
    //     if (index == stacks.size()-1)
    //         return this.pop();
    //     set.add(index);
    //     return stacks.get(index).pop();
    // }

    public static void main(String[] args) {
        DinnerPlates s = new DinnerPlates(2);
        s.push(373);
        s.push(86);
        s.push(395);
        s.push(306);
        s.push(370);
        s.push(94);
        s.push(41);
        s.push(17);
        s.push(387);
        s.push(403);
        s.push(66);
        s.push(82);
        s.push(27);
        s.push(335);
        s.push(252);
        s.push(6);
        s.push(269);
        s.push(231);
        s.push(35);
        s.push(346);
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // s.push(4);
        // s.push(7);
        int r = s.popAtStack(4);
        int r1 = s.popAtStack(6);
        int r2 = s.popAtStack(2);
        int r3 = s.popAtStack(5);
        int r4 = s.popAtStack(2);
        int r5 = s.popAtStack(2);
        int r6 = s.popAtStack(7);
        int r7 = s.popAtStack(9);
        int r8 = s.popAtStack(8);
        int r9 = s.popAtStack(1);

        // int r = s.popAtStack(8);
        // System.out.println("r: " + r);

        // s.push(20);
        // s.push(21);
        // int r1 = s.popAtStack(0);
        // System.out.println("r1: " + r1);

        // int r2 = s.popAtStack(2);
        // System.out.println("r2: " + r2);

        // int r3 = s.pop();
        // System.out.println("r3: " + r3);

        // int r4 = s.pop();
        // System.out.println("r4: " + r4);

        // int r5 = s.pop();
        // System.out.println("r5: " + r5);

        // int r6 = s.pop();
        // System.out.println("r6: " + r6);

        // int r7 = s.pop();
        // System.out.println("r7: " + r7);
    
    }
 }
//     "push","push","push","push","push","push","push","push","push","push","push","push","push","push","push","push","push","push","push","push","pop","pop","pop","pop","pop","pop","pop","pop","pop","pop"]
//     );

// 474,216,256,196,332,43,75,22,273,101,11,403,33,365,338,331,134,1,250,19,,,,,,,,,,
