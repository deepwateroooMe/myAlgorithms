import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class insertionSortList {
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

        public ListNode insertionSortList(ListNode head) {
            if (head == null) {
                return null;
            }
            
            ListNode prev = head;
            ListNode curr = head.next;
            ListNode next = head;
            ListNode tnext = head;
            ListNode tmp = head;
            while (curr != null) {
                next = curr.next;
                if (curr.val < prev.val) {
                    prev.next = next;
                    curr.next = null;
                    if (curr.val < head.val) {
                        curr.next = head;
                        head = curr;
                    } else {
                        tmp = head;
                        while (tmp.next != prev && curr.val > tmp.next.val) {
                            tmp = tmp.next;
                        }
                        tnext = tmp.next;
                        tmp.next = curr;
                        curr.next = tnext;
                    }
                    curr = next;
                } else {
                    prev = curr;
                    curr = curr.next;
                }
            }
            return head;
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

        curr = result.insertionSortList(one);
        while (curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }
    }
}
