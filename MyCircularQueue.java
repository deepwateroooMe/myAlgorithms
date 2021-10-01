import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class MyCircularQueue {

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

    public MyCircularQueue(int k) {
        head = new ListNode(-1);
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
    
    public boolean enQueue(int value) {
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
    
    public boolean deQueue() {
        if (cnt == 0) return false;
        dummy = head;
        head = head.next;
        dummy.val = -1;
        --cnt;
        return true;
    }
    
    public int Front() {
        return head.val == -1 ? -1 : head.val;
    }
    
    public int Rear() {
        return tail.val == -1 ? -1 : tail.val;
    }
    
    public boolean isEmpty() {
        return cnt == 0;
    }
    
    public boolean isFull() {
        return cnt == size;
    }
    
    public static void main(String[] args) {
        MyCircularQueue s = new MyCircularQueue(3);
        
        boolean res = s.enQueue(1); // return True
        System.out.println("res: " + res);
        
        boolean r = s.enQueue(2); // return True
        System.out.println("r: " + r);
        
        
        boolean r1 = s.enQueue(3); // return True
        System.out.println("r1: " + r1);
        
        boolean r2 = s.enQueue(4); // return False
        System.out.println("r2: " + r2);
        
        int r3 = s.Rear();     // return 3
        System.out.println("r3: " + r3);
        
        boolean r4 = s.isFull();   // return True
        System.out.println("r4: " + r4);
        
        boolean r5 = s.deQueue();  // return True
        System.out.println("r5: " + r5);
        
        boolean r6 = s.enQueue(4); // return True
        System.out.println("r6: " + r6);
        
        int r7 = s.Rear();     // return 4
        System.out.println("r7: " + r7);
        

        // System.out.println(res);
    }
}