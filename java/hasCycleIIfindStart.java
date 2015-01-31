import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

// now I understand this wired
public class hasCycleIIfindStart {
    public static class Solution {
        public  class ListNode {
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

        // http://www.cnblogs.com/hiddenfox/p/3408931.html
        public ListNode detectCycle0(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (true) {
                if (fast == null || fast.next == null) {
                    return null; // no cycle
                }
                slow = slow.next;
                fast = fast.next.next; // 2X speed
                if (fast == slow) {
                    break;
                }
            }
            // set slow to head
            slow = head;
            while (fast != slow) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        } 

        public ListNode detectCycle(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next; // 2X speed
                if (fast == slow) {
                    ListNode curr = head;
                    while (curr != slow) {
                        curr = curr.next;
                        slow = slow.next;
                    }
                    return curr;
                }
            }
            return null;
        } 

    }

    public static void main(String[] args){
        Solution result = new Solution();
        Solution.ListNode one = result.ListNode(1);
        Solution.ListNode two = result.ListNode(1);
        one.next = two;
        two.next = one;
        Solution.ListNode res = result.detectCycle(one);
        
        System.out.println(res.val);
    }
}

