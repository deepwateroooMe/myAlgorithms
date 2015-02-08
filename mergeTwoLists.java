import com.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class mergeTwoLists {
    public static class Solution {
        /**
         * @param ListNode l1 is the head of the linked list
         * @param ListNode l2 is the head of the linked list
         * @return: ListNode head of linked list
         */
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(Integer.MIN_VALUE);
            ListNode curr = dummy;
            ListNode one = null;
            ListNode two = null;
            for ( one = l1, two = l2; one != null && two != null; curr = curr.next) {
                int a = one.val;
                int b = two.val;
                if (a <= b) {
                    curr.next = one;
                    one = one.next;
                } else {
                    curr.next = two;
                    two = two.next;
                }
            }
            if (one == null) curr.next = two;
            else curr.next = one;
            return dummy.next;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, 3, 8, 11, 15};
        int [] b = {2, 9};
        ListNode ah = new ListNode(a[0]);
        ListNode bh = new ListNode(b[0]);
        ah.buildList(ah, a);
        bh.buildList(bh, b);
        ListNode res = result.mergeTwoLists(ah, bh);
        System.out.println("");
        while (res != null) {
            System.out.print(res.val + ", ");
            res = res.next;
        }
    }
}
