import com.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class reverseKGroup {
    public static class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
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
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, 2, 3, 4, 5, 6, 7};
        ListNode head = new ListNode(a[0]);
        head.buildList(head, a);
        head.printList(head);
        ListNode res = result.reverseKGroup(head, 3);
        res.printList(res);
    }
}
