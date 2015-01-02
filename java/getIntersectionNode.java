import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class getIntersectionNode {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static class Solution {
        // consider no intersection
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) { // special situations
                return null;
            }
            
            ListNode p1 = headA;
            ListNode p2 = headB;
            while (p1 != null && p2 != null && p1 != p2) {
                p1 = p1.next;
                p2 = p2.next;
                if (p1 == p2) return p1;
                if (p1 == null) {
                    p1 = headB;
                }
                if (p2 == null) {
                    p2 = headA;
                }
            }
            return p1;

            /* // way way too complicated~~~
            ListNode result;
            while (p1.next != null && p1.val != p2.val) {
                p1 = p1.next;
            }
            if (p1.val == p2.val) {
                return headB;
            }
            
            while (p2.next != null && p2.val != headA.val) {
                p2 = p2.next;
            }
            if (p2.val == headA.val) {
                return headA;
            }
            if (p1.val != p2.val) { // confirm no intersection
                return null;
            }

            // has intersection
            p1 = headA;
            p2 = headB;
            while (p1.next != null && p2.next != null) {
                p1 = p1.next;
                p2 = p2.next;
            }
            if (p1.next == null) {
                p1.next = headB;
            } else {
                p2.next = headA;
            }

            while (p1.next != null && p2.next != null) {
                p1 = p1.next;
                p2 = p2.next;
            }
            if (p1.next == null) {
                p1.next = headB;
            } else {
                p2.next = headA;
            }

            while (p1.next != headA && p1.val != p2.val) {
                p1 = p1.next;
                p2 = p2.next;
            }
            if (p1.next == headA) {
                p1.next = null;  // remember to recover
                p2.next = null;
                return null;
            } else {
                result = p1;
                while (p1.next.val == p2.next.val) {
                    p1 = p1.next;
                    p2 = p2.next;
                }
                p1.next = null;  // remember to recover
                p2.next = null;
                return p1;
            }
            */
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        ListNode a, b;
        ListNode res = result.getIntersectionNode(a, b);
        
        System.out.println(res);
    }
}
