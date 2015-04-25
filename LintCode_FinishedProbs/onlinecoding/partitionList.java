import com.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class partitionList {
    public static class Solution {
        /**
         * @param head: The first node of linked list.
         * @param x: an integer
         * @return: a ListNode 
         */
        public ListNode partition(ListNode head, int x) {
            ListNode left = new ListNode(Integer.MIN_VALUE);
            ListNode right = new ListNode(Integer.MIN_VALUE);
            ListNode one = left;
            ListNode two = right;
            for(;head != null; head = head.next) {
                if (head.val < x) {
                    one.next = head;
                    one = one.next;
                } else {
                    two.next = head;
                    two = two.next;
                }
            }
            one.next = right.next;
            return left.next;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, 4, 3, 2, 5, 2, 3};
        ListNode head = new ListNode(a[0]);
        head.buildList(head, a);
        ListNode res = result.partition(head, 3);
System.out.println("");
while (res != null) {
    System.out.print(res.val + ", ");
    res = res.next;
}



    }
}
