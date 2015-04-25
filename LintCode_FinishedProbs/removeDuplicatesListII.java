import com.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class removeDuplicatesListII {
    public static class Solution {
        public static ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode dy = new ListNode(Integer.MIN_VALUE);
            ListNode prev = dy;
            ListNode slow = null;
            ListNode curr = head;
            ListNode fast = head.next;
            for( ; curr != null; // && fast != null;
                 curr = fast, fast = fast == null ? null : fast.next) {
                if (curr.val != slow.val &&
                    (fast == null || (fast != null && fast.val != curr.val))) {
                    slow = curr;
                    prev.next = curr;
                    prev = prev.next;
                } else {
                    slow = curr;
                    curr = fast;
                    fast = fast == null ? null : fast.next;
                } 
            }
            if (curr != null && fast == null)
                prev.next = curr;
            else prev.next = null;                
            return dy.next;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {-14, -13, -12, -12, -11, -11, -11, -11, -11, -10, -10, -9, -9, -9, -8, -8, -7, -7, -6, -5, -5, -5, -5, -3, -3, -3, -3, -2, -1, -1, -1, -1, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 5, 5, 6, 6, 6, 6, 7, 7, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 10, 10, 10, 11, 11, 12, 12, 13, 13, 13, 13, 13, 14, 14, 15, 15, 15, 16, 16, 16, 16, 17, 17, 17, 17, 18, 18, 18, 18, 19, 19, 21, 21, 21, 22, 23, 24, 25, 25, 25, 25, 25};
        ListNode head = new ListNode(a[0]);
        head.buildList(head, a);
        ListNode res = result.deleteDuplicates(head);
        System.out.println("");
        while (res != null) {
            System.out.print(res.val + ", ");
            res = res.next;
        }



    }
}
