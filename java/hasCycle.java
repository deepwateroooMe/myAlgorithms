import com.ListNode;

public class hasCycle {
    public static class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null || (head != null && head.next == null)) 
                return false;
            else if (head != null && head.next == head) 
                return true;
            ListNode fast = head;
            ListNode slow = head;
            while (fast != null && slow != null) {
                slow = slow.next;
                fast = fast.next.next; // 2X speed
                while (fast != null && fast.next != null && slow != null && fast.val != slow.val) {
                    slow = slow.next;
                    fast = fast.next.next; // 2X speed
                }
                if (fast == null || fast.next == null || slow == null) 
                    return false;
                else if (fast != null && slow != null && fast.val == slow.val) 
                    return true;
                else return false;
            }
            return false;
        }

        public boolean hasCycle(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) return true;
            }
            return false;
        }
        
    }

    public static void main(String[] args){
        Solution result = new Solution();
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(1);
        one.next = two;
        boolean res = result.hasCycle(one);
        System.out.println(res);
    }
}

