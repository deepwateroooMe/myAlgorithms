import com.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class swapPairs {
    public static class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode result = head.next;
            ListNode fast = result.next;
            ListNode curr = head;
            result.next = curr;
            curr.next = fast;
            ListNode prev = result;
            while (fast != null) {
                if (fast.next == null)
                    return result;
                fast = fast.next.next;
                prev = curr;
                curr = curr.next.next;
                curr.next = prev.next;
                prev.next = curr;
                prev = curr;
                curr = curr.next;
                curr.next = fast;
            }
            return result;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(a[0]);
        head.buildList(head, a);
        head.printList(head);
        ListNode res = result.swapPairs(head);
        res.printList(res);
    }
}
