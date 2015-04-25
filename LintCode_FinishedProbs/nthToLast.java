import com.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class nthToLast {
    public static class Solution {
        /**
         * @param head: The first node of linked list.
         * @param n: An integer.
         * @return: Nth to last node of a singly linked list. 
         */
        ListNode nthToLast(ListNode head, int n) {
            int cnt = 0;
            ListNode curr = head;
            while (cnt < n && curr != null) {
                ++cnt;
                curr = curr.next;
            }
            if (cnt == n && curr == null) return head;
            if (cnt < n) return null;
            ListNode prev = head;
            while (curr != null) {
                prev = prev.next;
                curr = curr.next;
            }
            return prev;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {3, 2};
        ListNode head = new ListNode(a[0]);
        head.buildList(head, a);
        ListNode res = result.nthToLast(head, 2);
System.out.println("res.val: " + res.val);

    }
}
