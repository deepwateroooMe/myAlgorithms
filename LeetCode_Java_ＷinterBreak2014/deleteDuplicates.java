import com.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class deleteDuplicates {
    public static class Solution {
        public ListNode deleteDuplicates0(ListNode head) {
            if (head == null || head.next == null) return head;  // forgot this line
            
            ListNode res = head;
            ListNode curr = head.next;
            ListNode prev = head;
            ListNode fast = curr;
            while (curr != null) {
                if (curr.val == prev.val) {
                    fast = curr.next;
                    prev.next = fast;
                    curr.next = null;
                    curr = prev.next;
                } else {
                    prev = curr;
                    curr = curr.next;
                }
            }
            return res;
        }

        public void recursion(ListNode prev, ListNode curr) {
            if (curr == null) return;
            if (prev.val == curr.val) {
                prev.next = curr.next;
                recursion(prev, curr.next);
            } else {
                prev.next = curr;   // important for Java
                recursion(prev.next, curr.next);
            }
        }
        
        public ListNode deleteDuplicates1(ListNode head) {
            if (head == null) return head;
            ListNode dummy = new ListNode(head.val + 1);
            recursion(dummy, head);
            return dummy.next;
        }

        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) return head;
            for (ListNode prev = head, curr = head.next; curr != null; curr = curr.next) {
                if (prev.val == curr.val) {
                    prev.next = curr.next;
                } else {
                    prev = curr;
                }
            }
            return head;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, 1};
        ListNode head = new ListNode(1);
        head.buildList(head, a);
        head.printList(head);
        ListNode res = result.deleteDuplicates(head);
        System.out.println("");
        while (res != null) {
            System.out.print(res.val + ", ");
            res = res.next;
        }
    }
}
