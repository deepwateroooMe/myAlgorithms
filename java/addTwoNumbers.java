import com.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class addTwoNumbers {
    public static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            int leftover;
            int val;
            val = (l1.val + l2.val) % 10;
            leftover = (l1.val + l2.val) / 10;
            ListNode head = new ListNode(val);
            ListNode curr = head, tmp;
            l1 = l1.next;
            l2 = l2.next;
            while (l1 != null && l2 != null) {
                val = (l1.val + l2.val + leftover) % 10;
                leftover = (l1.val + l2.val + leftover) / 10;
                tmp = new ListNode(val);
                curr.next = tmp;
                curr = curr.next;
                l1 = l1.next;
                l2 = l2.next;
            }
            
            if (l1 == null) l1 = l2;
            while (l1 != null && leftover > 0) {
                val = (l1.val + leftover) % 10;
                leftover = (l1.val + leftover) / 10;
                tmp = new ListNode(val);
                curr.next = tmp;
                curr = curr.next;
                l1 = l1.next;
            }

            if (l1 != null) curr.next = l1;                
            if (leftover > 0) {
                tmp = new ListNode(leftover);
                curr.next = tmp;
            }
            return head;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1};
        ListNode ha = new ListNode(a[0]);
        ha.buildList(ha, a);
        ha.printList(ha);
        int [] b = {9, 9};
        ListNode hb = new ListNode(b[0]);
        hb.buildList(hb, b);
        hb.printList(hb);

        ListNode res = result.addTwoNumbers(ha, hb);
        res.printList(res);
        
        //System.out.println(res);
    }
}
