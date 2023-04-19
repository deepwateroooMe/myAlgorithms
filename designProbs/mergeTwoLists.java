import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class mergeTwoLists {
    public static class Solution {

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0);
            ListNode p = dummy;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    p.next = l1;
                    l1 = l1.next;
                } else {
                    p.next = l2;
                    l2 = l2.next;
                }
                p = p.next;
            }
            if (l1 != null) p.next = l1;
            if (l2 != null) p.next = l2;
            return dummy.next;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        

        // System.out.println(res);
    }
}