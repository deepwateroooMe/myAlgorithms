import com.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class FrontMiddleBackQueue {

    // private class ListNode {
    //     public int val;
    //     public ListNode prev;
    //     public ListNode next;
    //     ListNode() {}
    //     ListNode(int val) { this.val = val; }
    //     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    // };

    private ListNode head, midd, tail;
    private int size; 
    private ListNode p, prev, next, dummy;

    public FrontMiddleBackQueue() {
        head = null;
        midd = null;
        tail = null;
        size = 0;
    }
    
    public void pushFront(int val) {
        if (head == null) {
            head = new ListNode(val);
            tail = head;
            midd = head;
            size = 1;
            return;
        }
        dummy = new ListNode(val);
        dummy.next = head;
        head.prev = dummy;
        head = dummy;
        ++size;
        if (size % 2 == 0) midd = midd.prev;
    }
    
    public void pushMiddle(int val) {
        if (midd == null) {
            midd = new ListNode(val);
            tail = midd;
            head = midd;
            size = 1;
            return;
        }
        if (size % 2 == 1) {
            dummy = new ListNode(val);
            prev = midd.prev;
            if (prev != null) {
                prev.next = dummy;
                dummy.prev = prev;
            }
            dummy.next = midd;
            midd.prev = dummy;
            if (head == midd) head = dummy; // tail no
            midd = dummy;
            ++size;
        } else {
            dummy = new ListNode(val);
            next = midd.next;
            midd.next = dummy;
            dummy.prev = midd;
            midd = dummy;
            next.prev = midd;
            midd.next = next;
            ++size;
        }
    }
    
    public void pushBack(int val) {
        if (tail == null) {
            tail = new ListNode(val);
            midd = tail;
            head = tail;
            size = 1;
            return;
        }
        dummy = new ListNode(val);
        tail.next = dummy;
        dummy.prev = tail;
        tail = dummy;
        ++size;
        if (size % 2 == 1) midd = midd.next;
    }
    
    public int popFront() {
        if (size == 0) return -1;
        dummy = head;
        head = head.next;
        dummy.next = null;
        // System.out.println(" (head != null): " +  (head != null));
        if (head != null) {
            // System.out.println("head.val: " + head.val);
            head.prev = null;
        } else {
            midd = null;
            tail = null;
        }
        --size;
        if (size == 1) midd = head; // this is important
        else if (size % 2 == 1) midd = midd.next;
        return dummy.val;
    }
    
    public int popMiddle() {
        if (size == 0) return -1;
        
        if (size == 1) {
            dummy = midd;
            System.out.println("dummy.val: " + dummy.val);
            
            head = null;
            midd = null;
            tail = null;
            size = 0;
            System.out.println("(dummy == null): " + (dummy == null));
            System.out.println("dummy.val: " + dummy.val);
            
            return dummy.val;
        }
        dummy = midd;
        prev = midd.prev;
        next = midd.next;
        if (prev != null) {
            prev.next = next;
            next.prev = prev;
            --size;
            if (size % 2 == 0) midd = prev;
            else midd = next;
            return dummy.val;
        } else {
            head = next;
            next.prev = null;
            midd = next;
            --size;
            return dummy.val;
        }
    }
    
    public int popBack() {
        if (size == 0) return -1;
        dummy = tail;
        tail = tail.prev;
        dummy.prev = null;
        if (tail != null) tail.next = null;
        else {
            head = null;
            midd = null;
        }
        --size;
        if (size % 2 == 0 && midd != null) midd = midd.prev;
        return dummy.val;
    }
    
    public static void main(String[] args) {
        FrontMiddleBackQueue s = new FrontMiddleBackQueue();

        s.pushFront(317978);
        s.pushMiddle(640499);
        s.pushMiddle(439848);
        s.pushMiddle(490915);
        s.pushMiddle(13308);
        s.popMiddle();
        s.popMiddle();
        s.popMiddle();
        s.popMiddle();
        s.pushMiddle(764234);
        s.popMiddle();
        s.pushMiddle(540602);
        s.pushMiddle(981429);
        s.popBack();
        s.pushMiddle(714953);
        s.pushMiddle(156472);
        s.popMiddle();
        s.popBack();
        s.popMiddle();
        s.popMiddle();
        s.popMiddle();
        s.pushMiddle(872796);
        s.head.printList(s.head);
        
        s.popMiddle();

        s.pushMiddle(274146);
        s.pushMiddle(426570);
        s.head.printList(s.head);
        s.popFront();
        s.popMiddle();
        // s.popMiddle();
        // s.popBack();
        // s.popBack();
        // s.pushMiddle(659396);
        // s.pushMiddle(330328);
        // s.popMiddle();
        // s.pushMiddle(719662);
        // s.pushMiddle(820139);
        // s.pushFront(11838);
        // s.popMiddle();
        // s.popMiddle();
        // s.pushBack(877442);
        // s.pushMiddle(658307);
        // s.pushMiddle(785841);
        // s.popMiddle();
        // s.popMiddle();
        // s.popMiddle();
        // s.pushMiddle(931901 );
        // s.pushMiddle(555573);
        // s.popMiddle();
        // s.popMiddle();
        // s.popMiddle();
        // s.popMiddle();
        // s.pushMiddle(300693);
        // s.pushFront(142530);
        // s.pushMiddle(235941);
        // s.popMiddle();

        // s.pushMiddle(8);  // [1, 3, 2]
        // if (s.head != null)
        // s.head.printList(s.head);

        // // int r1 = s.popMiddle();    // return 3 -> [4, 2]
        // // System.out.println("r1: " + r1);
        // // if (s.head != null)
        // // s.head.printList(s.head);

        // int r2 = s.popMiddle();    // return 3 -> [4, 2]
        // System.out.println("r2: " + r2);
        // if (s.head != null)
        // s.head.printList(s.head);


        // int r3 = s.popBack();      // return 2 -> []
        // System.out.println("r3: " + r3);
        // if (s.head != null)
        // s.head.printList(s.head);
        
        // int r = s.popFront();     // return 1 -> [4, 3, 2]
        // System.out.println("r: " + r);
        // if (s.head != null)
        // s.head.printList(s.head);
        
        
        // int r2 = s.popMiddle();    // return 4 -> [2]
        // System.out.println("r2: " + r2);
        // s.head.printList(s.head);

        // s.pushFront(1);   // [1]
        // s.head.printList(s.head);
        
        // s.pushBack(2);    // [1, 2]
        // s.head.printList(s.head);

        // s.pushMiddle(4);  // [1, 4, 3, 2]
        // s.head.printList(s.head);

        
        // int r4 = s.popFront();     // return -1 -> [] (The queue is empty)
        // System.out.println("r4: " + r4);
        // if (s.head != null)
        // s.head.printList(s.head);
    }
}
