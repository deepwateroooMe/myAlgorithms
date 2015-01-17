import com.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class deleteDuplicatesfromSortedListII {
    public static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) return head;  // forgot this line

            ListNode res = head;
            ListNode tail = head;
            ListNode curr = head.next;
            ListNode prev = head;
            if (head.next.val == head.val) {
                while (curr != null && curr.val == prev.val) {
                    curr = curr.next;
                }
                if (curr == null) return null;
                else {
                    prev = curr;
                    curr = curr.next;
                    if (curr == null) return prev;
                    else if (curr.val != prev.val) {
                        res = prev;
                        tail = prev;
                        prev = curr;
                        curr = curr.next;
                    } else {
                        while (curr != null && curr.val == prev.val) {
                            curr = curr.next;
                        }
                        if (curr == null) return res;
                        else 
                        
                    }
                } 
            } else {
                res = head;
                tail = head;
                prev = head;
                curr = head.next;
            }
            if (curr == null) return res;
            //ListNode fast = curr.next;
            tail.next = deleteDuplicates(curr);
            return tail;
            /*            
            while (curr != null && fast != null) {
                System.out.println("curr.val: " + curr.val);
                System.out.println("fast.val: " + fast.val);

                if (curr.val == prev.val) {
                    while (curr != null && curr.val == prev.val) {
                        curr = curr.next;
                    }
                    System.out.println("prev.val 0: " + prev.val);
                    System.out.println("curr.val 0: " + curr.val);
                    if (prev == head) {
                        tail = curr;
                    } else {
                        tail.next = curr;
                        tail = tail.next;
                    }
                    if (curr == null) return res;
                } else { //!=
                    prev = curr;
                    tail.next = prev;
                    tail = tail.next;
                    curr = curr.next;
                    if (curr != null) fast = curr.next;
                }
            }
            return res;
            */
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, 2, 3, 3, 4, 4, 5}; // [1, 1]
        //int [] a = {1, 1, 2, 3, 3};

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
