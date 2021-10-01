import com.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class removeDuplicatesList {
    public static class Solution {
        public static ListNode deleteDuplicates(ListNode head) {             
            ListNode prev = head;
            ListNode curr = head.next;
            for( ;curr != null; curr = curr.next) {
                if (curr.val != prev.val) {
                    prev.next = curr;
                    prev = prev.next;
                } 
            }
            prev.next = null;
            return head;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, 1, 2, 2, 3, 3, 3};
        ListNode head = new ListNode(a[0]);
        head.buildList(head, a);
        ListNode res = result.deleteDuplicates(head);
        System.out.println("");
        while (res != null) {
            System.out.print(res.val + ", ");
            res = res.next;
        }



    }
}
