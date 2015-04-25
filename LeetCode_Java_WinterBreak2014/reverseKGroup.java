import com.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class reverseKGroup {
    public static class Solution {
        public ListNode reverseKGroup0(ListNode head, int k) {
            if (head == null || head.next == null || k == 1) return head;

            // walk once to make sure long enough
            int cnt = 0;
            ListNode curr = head;
            while (curr != null && cnt < k) {
                ++cnt;
                curr = curr.next;
            }
            if (cnt < k) return head;
            ListNode next = curr; // next fragment
            
            ListNode tail = head;
            ListNode result = tail.next;
            ListNode fast = result.next;
            result.next = tail;
            curr = result;
            cnt = 2;
            while (cnt < k) {
                curr = fast;
                fast = fast.next;
                curr.next = result;
                result = curr;
                ++cnt;
            }
            tail.next = reverseKGroup(next, k);
            return result;
        }

        public ListNode reverseKGroup1(ListNode head, int k) {
            if (head == null || head.next == null || k < 2) return head;
            ListNode gNext = head;
            for (int i = 0; i < k; i++) {
                if (gNext != null) {
                    gNext = gNext.next;
                } else return head;
            }
            // next_group is the head of next group
            // new_next_group is the new head of next group after reversion
            ListNode newGNext = reverseKGroup(gNext, k);
            ListNode prev = null;
            ListNode curr = head;
            while (curr != gNext) {
                ListNode next = curr.next;
                curr.next = prev != null ? prev : newGNext;
                prev = curr;
                curr = next;
            }
            return prev;
        }

        public ListNode reversion(ListNode prev, ListNode bgn, ListNode end) {
            ListNode eNext = end.next;
            System.out.println("eNext.val: " + eNext.val);

            for (ListNode p = bgn, curr = p.next, next = curr.next;
                 curr != null;
                 p = curr, curr = next, next = next != null ? next.next : null) {
                curr.next = p;
            }
            bgn.next = eNext;
            prev.next = end;
            System.out.println("bgn.val: " + bgn.val);
System.out.println("");

            return bgn;
        }
        
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || head.next == null || k < 2) return head;
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            for (ListNode prev = dummy, end = head;
                 end != null;
                 end = prev.next) {
                for (int i = 1; i < k && end != null; i++) {
                    end = end.next;
                }
                System.out.println("(end == null): " + (end == null));

                if (end == null) break;
                prev = reversion(prev, prev.next, end);
            }
            return dummy.next;
        }
        
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, 2, 3};
        int b = 2;
        ListNode head = new ListNode(a[0]);
        head.buildList(head, a);
        head.printList(head);
        ListNode res = result.reverseKGroup(head, 2);
        res.printList(res);
    }
}
