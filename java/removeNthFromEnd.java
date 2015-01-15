import com.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class removeNthFromEnd {
    public static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
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
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, 2};
        ListNode head = new ListNode(a[0]);
        head.buildList(head, a);
        head.printList(head);
        
        ListNode res = result.removeNthFromEnd(head, 2);
        res.printList(res);
        
        //System.out.println(res);
    }
}
