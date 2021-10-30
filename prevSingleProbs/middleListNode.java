import com.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class middleListNode {
    public static class Solution {

        // public ListNode middleNode(ListNode head) {
        //     if (head == null || head.next == null) return head;
        //     if (head.next.next == null) return head.next;
        //     ListNode p = head, q = head;
        //     while (q.next != null) {
        //         p = p.next;
        //         q = q.next;
        //         if (q.next != null)
        //             q = q.next;
        //         else
        //             return p;
        //     }
        //     return p;
        // }

        // public void deleteNode(ListNode node) {
        //     node.val = node.next.val;
        //     node.next = node.next.next;
        // }

        
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // int [] a = new int [] {4,5,1,9}; 
        int [] a = new int [] {2, 0, 1, 3}; 

        ListNode head = new ListNode(a[0]);
        head.buildList(head, a, 2);
        head.printList(head);

        s.deleteNode(head.pp);
        head.printList(head);
    }
}