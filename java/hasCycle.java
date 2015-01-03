import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

// now I understand this wired
public class hasCycle {
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

        //ListNode one = new ListNode(-1);
        public boolean hasCycle(ListNode head) {
            if (head == null || (head != null && head.next == null)) {  // special situation
                return false;
            } else if (head != null && head.next == head) {
                return true;
            }
            
            ListNode fast = head;
            ListNode slow = head;
            
            while (fast != null && slow != null) {
                slow = slow.next;
                fast = fast.next.next; // 2X speed
                while (fast != null && fast.next != null && slow != null && fast.val != slow.val) {
                    slow = slow.next;
                    fast = fast.next.next; // 2X speed
                }
                if (fast == null || fast.next == null || slow == null) {
                    return false;
                } else if (fast != null && slow != null && fast.val == slow.val) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        Solution.ListNode one = result.ListNode(1);
        Solution.ListNode two = result.ListNode(1);
        //one.next = two;
        boolean res = result.hasCycle(one);
        
        System.out.println(res);
    }
}

