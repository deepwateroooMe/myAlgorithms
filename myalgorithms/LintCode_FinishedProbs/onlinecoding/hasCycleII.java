import com.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class hasCycleII {
    public static class Solution {
        /**
         * @param head: The first node of linked list.
         * @return: The node where the cycle begins. 
         *           if there is no cycle, return null
         */
        public ListNode detectCycle(ListNode head) {  
            if (head == null || head.next == null) return null;
            ListNode slow = head.next;
            ListNode fast = head.next.next;
            if (fast == null) return null;
            while (fast != null && fast.next != null && fast != slow) {
                slow = slow.next;
                fast = fast.next.next;
            }
            if (fast == null || fast.next == null) return null;
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {-21, 10, 17, 8, 4, 26, 5, 35, 33, -7, -16, 27, -12, 6, 29, -12, 5, 9, 20, 14, 14, 2, 13, -24, 21, 23, -21, 5};
        ListNode head = new ListNode(a[0]);
        head.buildList(head, a);
        ListNode res = result.detectCycle(head);
        
        System.out.println("");
        while (head != null) {
            System.out.print(head.val + ", ");
            head = head.next;
        }

        System.out.println(res);
    }
}
