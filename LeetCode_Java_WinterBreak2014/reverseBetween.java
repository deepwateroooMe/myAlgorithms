import com.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class reverseBetween {
    public static class Solution {
        public ListNode reverseBetween0(ListNode head, int m, int n) {
            if (head == null || head.next == null || m == n) return head;
            ListNode curr = head;
            ListNode prev = null;
            ListNode tail = null;
            int cnt = 1;
            while (curr != null && cnt < m) {
                prev = curr;
                curr = curr.next;
                ++cnt;
            }

            ListNode btai = curr;
            if (m == 1) {
                tail = null;
            } else {
                tail = prev;
                tail.next = null;
            }
            ListNode bcur = curr;
            curr = curr.next; // ++cnt;
            bcur.next = null;
            ListNode fast = null;
            ++cnt;
            while (curr != null && cnt < n) {
                fast = curr.next;
                curr.next = bcur;
                bcur = curr;
                curr = fast;
                ++cnt;
            }
            fast = curr.next;
            curr.next = bcur;
            btai.next = fast;
            if (tail != null) {
                tail.next = curr;
                return head;                
            } else
                return curr;
        }

        public ListNode reverseBetween(ListNode head, int m, int n) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode prevM = null;
            ListNode curr = dummy;
            for (int i = 1; i <= n ; i++) {
                if (i == m) prevM = curr;
                if (i > m && i <= n) {
                    curr.next = head.next;
                    head.next = prevM.next;
                    prevM.next = head;
                    head = curr;
                }
                curr = head;
                head = head.next;
            }
            return dummy.next;
        }
        
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {3, 5};  // special situation
        ListNode head = new ListNode(a[0]);
        head.buildList(head, a);
        head.printList(head);
        ListNode res = result.reverseBetween(head, 1, 2);

        System.out.println("");
        while (res != null) {
            System.out.print(res.val + ", ");
            res = res.next;
        }
    }
}
