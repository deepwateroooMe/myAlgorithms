import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class sortList {
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

        public ListNode divideList(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            ListNode prev = head;
            while (fast != null && fast.next != null) {
                prev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            prev.next = null;
            return slow;
        }
        
        public ListNode mergeList(ListNode one, ListNode two) {
            if (one == null) return two;
            if (two == null) return one;
            ListNode dummy = new ListNode(Integer.MIN_VALUE);
            ListNode curr = dummy;
            while (one != null && two != null) {
                if (one.val < two.val) {
                    curr.next = one;
                    one = one.next;
                } else {
                    curr.next = two;
                    two = two.next;
                }
                curr.next.next = null;
                curr = curr.next;
            }
            if (one != null) curr.next = one;
            else curr.next = two;
            return dummy.next;
        }
        
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode second = divideList(head);
            ListNode firstSorted = sortList(head);
            ListNode secondSorted = sortList(second);
            return mergeList(firstSorted, secondSorted);
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a= {6, 5, 3, 1, 2};
        Solution.ListNode one = result.ListNode(a[0]);
        Solution.ListNode curr = one;
        for (int i = 1; i < a.length; i++) {
            Solution.ListNode tmp = result.ListNode(a[i]);
            curr.next = tmp;
            curr = curr.next;
        }

        curr = result.sortList(one);
        while (curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }
    }
}
