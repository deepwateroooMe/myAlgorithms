import com.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class deleteDuplicates {
    public static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) return head;  // forgot this line
            
            ListNode res = head;
            ListNode curr = head.next;
            ListNode prev = head;
            ListNode fast = curr;
            while (curr != null) {
                if (curr.val == prev.val) {
                    fast = curr.next;
                    prev.next = fast;
                    curr.next = null;
                    curr = prev.next;
                } else {
                    prev = curr;
                    curr = curr.next;
                }
            }
            return res;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, 1, 2};
        ListNode head = new ListNode(1);
        head.buildList(head, a);
        head.printList(head);
        ListNode res = result.deleteDuplicates(head);
        System.out.println("");
        while (res != null) {
            System.out.print(res.val + ", ");
            res = res.next;
        }
    }
}
