import com.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class deleteDuplicatesfromSortedListII {
    public static class Solution {
        public ListNode deleteDuplicates0(ListNode head) {
            if (head == null || head.next == null) return head;  // forgot this line

            ListNode res = head;
            ListNode tail = head;
            ListNode curr = head.next;
            ListNode prev = head;
            if (head.next.val == head.val) {
                while (curr != null && curr.val == prev.val) 
                    curr = curr.next;
                if (curr == null) return null;
                else return deleteDuplicates(curr);                
            } else {
                head.next = deleteDuplicates(head.next);
                return head;
            }
        }

        public ListNode deleteDuplicates1(ListNode head) {
            if (head == null || head.next == null) return head;  
            ListNode curr = head.next;
            if (head.val == curr.val) {
                while (curr != null && head.val == curr.val) 
                    curr = curr.next;
                return deleteDuplicates(curr);
            } else {
                head.next = deleteDuplicates(head.next);
                return head;
            }
        }
        
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) return head;  
            ListNode dummy = new ListNode(Integer.MIN_VALUE);
            dummy.next = head;
            ListNode prev = dummy;
            ListNode curr = head;
            while (curr != null) {
                boolean dup = false;
                while (curr.next != null && curr.val == curr.next.val) {
                    dup = true;
                    curr = curr.next;
                }
                if (dup) {
                    curr = curr.next;
                    continue;
                }
                prev.next = curr;
                prev = prev.next;
                curr = curr.next;
            }
            prev.next = curr;
            return dummy.next;
        }
    
    }
    
    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, 1}; // [1, 1]
        //int [] a = {1, 1, 2, 3, 3};

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
