import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class MyLinkedList {
    
    private class ListNode {
        public int val;
        public ListNode prev;
        public ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    };

    private ListNode head, tail;
    private int cnt, idx;         // size
    private ListNode p, prev, dummy;
        
    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = null;
        tail = null;
        cnt = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index > cnt - 1) return -1;
        p = head;
        prev = p;
        idx = 0;
        while (idx < index) { 
                idx++;
            prev = p;
            p = p.next;
        }
        return p.val;
    }
    
/** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        dummy = new ListNode(val);
        dummy.next = head;
        if (head == null) {
            head = dummy;
            tail = dummy;
        } else {
            head.prev = dummy;
            head = dummy;
        }
        ++cnt;
    }
    
/** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        dummy = new ListNode(val);
        if (tail == null) {
            head = dummy;
            tail = dummy;
        } else {
            tail.next = dummy;
            dummy.prev = tail;
        }
        tail = dummy;
        ++cnt;
    }
    
/** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        } else if (index >= cnt) {
            addAtTail(val);
            return;
        }
        idx = -1;

        dummy = new ListNode(-1);
        dummy.next = head;
        p = dummy;

        while (idx < index) {
            idx++;
            prev = p;
            p = p.next;
        }
        dummy = new ListNode(val);
        dummy.prev = prev;
        dummy.next = p;
        prev.next = dummy;
        p.prev = dummy;
        ++cnt;
    }
    
/** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= cnt) return ;
        if (index == 0) {
            prev = head;
            p = head.next;
            if (p == null) {
                --cnt;
                head = null;
                tail = null;
                return;
            }            
            p.prev = null;
            head.next = null;
            head = p;
            --cnt;
            return;
        } else if (index == cnt - 1) {
            p = tail.prev;
            p.next = null;
            tail.prev = null;
            tail = p;
            --cnt;
            return;
        }
        idx = 0;
        p = head;
        prev = head;
        while (idx < index) {
            idx++;
            prev = p;
            p = p.next;
        }
        prev.next = p.next;
        if (p.next != null)
        p.next.prev = prev;
        else
        tail = prev;
        p.prev = null;
        p.next = null;
        --cnt;
    }

    public static void main(String[] args) {
        MyLinkedList s = new MyLinkedList();
        s.addAtHead(2);
        s.deleteAtIndex(1);

        s.addAtHead(2);
        s.addAtHead(7);
        s.addAtHead(3);
        s.addAtHead(2);
        s.addAtHead(5);

        s.addAtTail(5);
        int res = s.get(5);
        System.out.println(res);

        s.deleteAtIndex(6);
        s.deleteAtIndex(4);
    }
}
