import com.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class mergeTwoLists {
    public static class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            ListNode result;
            if (l1.val < l2.val) {
                result = l1;
                l1 = l1.next;
                result.next = null;
            } else {
                result = l2;
                l2 = l2.next;
                result.next = null;
            }
            ListNode curr = result;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    curr.next = l1;
                    curr = curr.next;
                    l1 = l1.next;
                    curr.next = null;
                } else {
                    curr.next = l2;
                    curr = curr.next;
                    l2 = l2.next;
                    curr.next = null;
                }
            }
            if (l1 == null && l2 == null)
                return result;
            l1 = (l1 == null) ? l2 : l1;
            curr.next = l1;
            return result;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, 3, 5, 7};
        int [] b = {2, 4, 6, 8, 10};
        ListNode ha = new ListNode(a[0]);
        ha.buildList(ha, a);
        ha.printList(ha);
        ListNode hb = new ListNode(b[0]);
        hb.buildList(hb, b);
        hb.printList(hb);
        ListNode res = result.mergeTwoLists(ha, hb);
        res.printList(res);
    }
}
