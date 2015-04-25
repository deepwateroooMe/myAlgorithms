import com.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class removeNthFromEnd {
    public static class Solution {
        public ListNode removeNthFromEnd0(ListNode head, int n) {
            if (head == null) return head;
            if (head != null && head.next == null) return null;
            int cnt = 1;
            ListNode curr = head;
            ListNode tmp = head;
            ListNode prev = head;
            while (tmp != null && cnt < n) {
                prev = curr;
                curr = tmp;
                tmp = tmp.next;
                cnt++;
            }
            
            if (tmp == null)
                return head;
            if (tmp.next == null) {
                tmp = head.next;
                head.next = null;
                head = tmp;
                return head;
            }

            tmp = tmp.next;
            curr = head;
            while (tmp != null) {
                prev = curr;
                curr = curr.next;
                tmp = tmp.next;
            }
            
            if (curr != null) {
                tmp = curr.next;
                prev.next = tmp;
                curr.next = null;
            }
            return head;
        }

        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(-1);
            ListNode p = dummy;
            ListNode q = dummy;
            p.next = head;
            q.next = head;
            for (int i = 0; i < n; i++) {
                q = q.next;
            }
            while (q.next != null) {
                p = p.next;
                q = q.next;
            }
            ListNode tmp = p.next;
            p.next = tmp.next;
            return dummy.next;
        }
        
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, 2};
        int b = 2;
        ListNode head = new ListNode(a[0]);
        head.buildList(head, a);
        head.printList(head);
        
        ListNode res = result.removeNthFromEnd(head, b);
        res.printList(res);
        
        //System.out.println(res);
    }
}
