import com.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class removeNthFromEnd {
    public static class Solution {
        ListNode removeNthFromEnd(ListNode head, int n) {
            int cnt = 0;
            ListNode curr = head;
            while (cnt < n && curr != null) {
                ++cnt;
                curr = curr.next;
            }
            if (cnt == n && curr == null) return head.next;
            if (cnt < n) return null;
            ListNode prev = head;
            ListNode slow = null;
            while (curr != null) {
                slow = prev;
                prev = prev.next;
                curr = curr.next;
            }
            slow.next = prev.next;
            return head;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {3, 2};
        ListNode head = new ListNode(a[0]);
        head.buildList(head, a);
        ListNode res = result.removeNthFromEnd(head, 2);
        System.out.println("res.val: " + res.val);

    }
}
