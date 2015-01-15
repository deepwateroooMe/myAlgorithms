import com.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class partitionList {
    public static class Solution {
        public ListNode partition(ListNode head, int x) {
            if (head == null || head.next == null) return head;
            ListNode res = null;
            ListNode prev = head;
            ListNode curr = head.next;
            ListNode fast = null;
            ListNode fpre = null;
            if (head.val >= x) {
                res = head;
                fpre = head;
                head = null;
                prev = null;
            }
            while (curr != null) {
                fast = curr.next;
                if (curr.val >= x) {
                    if (res == null) { // build head B
                        res = curr;
                        fpre = curr;
                    } else {
                        fpre.next = curr;
                        fpre = curr;
                    }
                } else { // head
                    if (head == null) {
                        head = curr;
                        prev = curr;
                    } else {
                        prev.next = curr;
                        prev = curr;
                    }
                }
                curr = fast;
                if (fpre != null)
                    fpre.next = null;
                if (prev != null)
                    prev.next = null;
            }
            if (head != null) {
                prev.next = res;
                return head;
            } else return res;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, 1};
        //int [] a = {1, 4, 3, 2, 5, 2};
        ListNode head = new ListNode(a[0]);
        head.buildList(head, a);
        head.printList(head);
    
        ListNode res = result.partition(head, 0);
        System.out.println("");
        while (res != null) {
            System.out.print(res.val + ", ");
            res = res.next;
        }
    }
}
/*
  Last executed input:	{1,1}, 0
 */
