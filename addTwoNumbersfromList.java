import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class addTwoNumbersfromList {
    public static class Solution {

        public ListNode addTwoNumbersfromList(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0);
            ListNode p = l1, q = l2, curr = dummy;
            int carry = 0;

            while (p != null || q != null) {
                int x = (p != null) ? p.val : 0;
                int y = (q != null) ? q.val : 0;
                int digit = carry + x + y;
                carry = digit / 10;
                curr.next = new ListNode(digit % 10);
                curr = curr.next;
                if (p != null) p = p.next;
                if (q != null) q = q.next;
            }
            if (carry > 0)
                curr.next = new ListNode(carry);
            return dummy.next;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        

        // System.out.println(res);
    }
}