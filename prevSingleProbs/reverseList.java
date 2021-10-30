import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class reverseList {
    public static class Solution {
        public class ListNode {
            int val;
            ListNode next;
            ListNode() {}
            ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }
        public ListNode reverseList(ListNode head) {
            if (head == null) return head;
            ListNode dummy = head, newCurr = head;
            ListNode curr = head.next;
            dummy.next = null;
            while (curr != null) {
                newCurr = curr;
                curr = curr.next;
                newCurr.next = dummy;
                dummy = newCurr;
            }
            return newCurr;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        

        // System.out.println(res);
    }
}