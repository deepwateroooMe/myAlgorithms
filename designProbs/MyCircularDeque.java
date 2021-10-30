import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class MyCircularDeque {

    private class ListNode {
        public int val;
        public ListNode prev;
        public ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    };

    private ListNode head, tail;
    private int cnt, size; 
    private ListNode p, prev, dummy;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        head = new ListNode(-1);
        // System.out.println("head.val: " + head.val);
        
        if (k == 1) {
            tail = head;
            head.next = head;
            size = k;
            return;
        }
        p = head;
        prev = head;
        cnt = 0;
        while (cnt < k) {
            dummy = new ListNode(-1);
            p.next = dummy;
            dummy.prev = p;
            prev = p;
            p = p.next;
            ++cnt;
        }
        p.next = head;
        head.prev = p;
        tail = p;
        size = k;
        cnt = 0;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (cnt == size) return false;
        
        System.out.println("(head == null): " + (head == null));
        
        if (head.val == -1) {
            head.val = value;
            ++cnt;
            tail = head;
            return true;
        }
        dummy = head.prev;
        dummy.val = value;
        head = dummy;
        ++cnt;
        return true;
        
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (cnt == size) return false;
        if (tail.val == -1) {
            tail.val = value;
            ++cnt;
            head = tail;
            return true;
        }
        dummy = tail.next;
        dummy.val = value;
        tail = dummy;
        ++cnt;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (cnt == 0) return false;
        dummy = head;
        head = head.next;
        dummy.val = -1;
        --cnt;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (cnt == 0) return false;
        dummy = tail;
        tail = tail.prev;
        dummy.val = -1;
        --cnt;
        return true;
        
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        return head.val == -1 ? -1 : head.val;
        
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        return tail.val == -1 ? -1 : tail.val;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return cnt == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return cnt == size;
    }
    
    public static void main(String[] args) {
        MyCircularDeque s = new MyCircularDeque(8);
        
        // boolean res = s.insertLast(1); // return True
        // System.out.println("res: " + res);
        
        // boolean r = s.insertLast(2); // return True
        // System.out.println("r: " + r);
        
        
        boolean r1 = s.insertFront(5); // return True
        System.out.println("r1: " + r1);
        
        // boolean r2 = s.insertFront(4); // return False
        // System.out.println("r2: " + r2);
        
        // int r3 = s.getRear();     // return 3
        // System.out.println("r3: " + r3);
        
        // boolean r4 = s.isFull();   // return True
        // System.out.println("r4: " + r4);
        
        // boolean r5 = s.deleteLast();  // return True
        // System.out.println("r5: " + r5);
        
        // boolean r6 = s.insertFront(4); // return True
        // System.out.println("r6: " + r6);
        
        int r7 = s.getFront();     // return 4
        System.out.println("r7: " + r7);
        
        // boolean res = s.insertLast(1); // return True
        // System.out.println("res: " + res);
        
        // boolean r = s.insertLast(2); // return True
        // System.out.println("r: " + r);
        
        
        // boolean r1 = s.insertFront(3); // return True
        // System.out.println("r1: " + r1);
        
        // boolean r2 = s.insertFront(4); // return False
        // System.out.println("r2: " + r2);
        
        // int r3 = s.getRear();     // return 3
        // System.out.println("r3: " + r3);
        
        // boolean r4 = s.isFull();   // return True
        // System.out.println("r4: " + r4);
        
        // boolean r5 = s.deleteLast();  // return True
        // System.out.println("r5: " + r5);
        
        // boolean r6 = s.insertFront(4); // return True
        // System.out.println("r6: " + r6);
        
        // int r7 = s.getFront();     // return 4
        // System.out.println("r7: " + r7);
    }
}