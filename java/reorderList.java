import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class reorderList {
    public static class Solution {
        public class ListNode {
            int val;
            ListNode next;
            ListNode(int x) {
                val = x;
                next = null;
            }
        }
        
        public ListNode ListNode(int x) {
            ListNode res = new Solution.ListNode(-1);
            res.val = x;
            res.next = null;
            return res;
        }
        ListNode one = new ListNode(-1);

        public void reorderList(ListNode head) {
            if (head == null || (head != null && head.next == null)) {
                return;
            } // consider one node situation
            
            ListNode fast = head;
            ListNode slow = head;
            ListNode fwrd = head; // backward
            ListNode tail = head;
            while (fast != null && fast.next != null && slow != null) {
                fwrd = slow;
                slow = slow.next;
                fast = fast.next.next;
            } // slow reaches second half
            fwrd.next = null; // cut into two halves
            
            // reverse second half
            ListNode curr = slow.next;
            slow.next = null;  // set tail, remember
            while (curr != null) {
                fwrd = curr.next;
                curr.next = slow;
                slow = curr;
                curr = fwrd;
            }

            // slow: second half head
            curr = head;
            while (curr != null && slow != null) {
                fwrd = curr.next;
                curr.next = slow;
                tail = slow;
                slow = slow.next;
                curr.next.next = fwrd;
                curr = fwrd;
            }
            if (curr == null && slow != null) {
                tail.next = slow;
            }
        }

        public  void printList(ListNode head) {
            ListNode tmp = head;
            while (tmp != null) {
                System.out.println(tmp.val);
                tmp = tmp.next;
            }
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        Solution.ListNode one = result.ListNode(1);
        Solution.ListNode one2 = result.ListNode(2);
        Solution.ListNode one3 = result.ListNode(3);
        Solution.ListNode one4 = result.ListNode(4);
        one.next = one2;
        one2.next = one3;
        //one3.next = one4;
        result.reorderList(one);
        result.printList(one);
        
        //System.out.println(res.val);
    }
}
