import com.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class reotateRight {
    public static class Solution {
        public ListNode rotateRight0(ListNode head, int n) {
            if (n == 0 || head == null || head.next == null) return head;
            
            ListNode curr = head;
            ListNode prev = head;
            int cnt = 0;
            while (cnt < n && curr != null) {
                prev = curr;
                curr = curr.next;
                ++cnt;
            }
            
            if (curr == null && n == cnt) return head;
            else if (curr == null && n > cnt) return rotateRight(head, n - cnt);
            
            ListNode fast = curr;
            ListNode res = head;
            
            if (fast.next == null) {
                res = head.next;
                fast.next = head;
                head.next = null;
                return res;
            }
            
            curr = head;
            while (fast.next != null) {
                prev = curr;
                curr = curr.next;
                fast = fast.next;
            }
            res = curr.next;
            curr.next = null;
            fast.next = head;
            return res;
        }

        public ListNode rotateRight(ListNode head, int n) {
            if (head == null || n == 0) return head;
            int len = 1;
            ListNode curr = head;
            while (curr.next != null) {
                len++;
                curr = curr.next;
            }
            n = len - n % len;
            curr.next = head;
            for (int step = 0; step < n; step++) {
                curr = curr.next;
            }
            head = curr.next;
            curr.next = null;
            return head;
        }
        
    }
    
    public static void main(String[] args){
        Solution result = new Solution();
        int [] a= {1, 2, 3};
        ListNode b = new ListNode(1);
        b.buildList(b, a);
        ListNode res = result.rotateRight(b, 2);

        res.printList(res);
    }
}
