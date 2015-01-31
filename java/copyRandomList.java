import com.RandomListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class copyRandomList {
    public static class Solution {

        // use old method:
        // 1. insert a node copy to make n -> 2n length, 1st round
        // 2. set randome pointers, 2nd round
        // 3. split into two lists, 3rd round, O(n)
        public RandomListNode copyRandomList0(RandomListNode head) {
            if (head == null) return null;
            RandomListNode result;
            RandomListNode tmp = head, one, next;
            while (tmp != null) {  // 1st
                one = new RandomListNode(tmp.label);
                next = tmp.next;
                tmp.next = one;
                one.next = next;
                tmp = next;
            }
            
            tmp = head;  // 2nd
            while (tmp != null) {
                next = tmp.next;
                if (next != null) {
                    if (tmp.random != null)
                        next.random = tmp.random.next;
                    tmp = tmp.next.next;
                }
            }

            tmp = head;  // 3rd
            result = head.next;
            one = result;
            tmp.next = one.next;
            tmp = tmp.next;
            one.next = null;
            while (tmp != null) {
                if (tmp != null && tmp.next != null) { 
                    next = tmp.next.next;
                    one.next = tmp.next;
                    one = one.next;
                    one.next = null;
                    tmp.next = next;
                    tmp = tmp.next;  // forgot this one
                }
            }
            return result;
        }

        public void printList(RandomListNode tmp) {
            while (tmp != null) {
                System.out.print(tmp.label + ", ");
                if (tmp.random != null)
                    System.out.print(tmp.random.label);
                else System.out.print("#");
                System.out.println("");

                tmp = tmp.next;
            }
        }

        public RandomListNode copyRandomList(RandomListNode head) {
            if (head == null) return null;
            for (RandomListNode curr = head; curr != null; ) {
                RandomListNode node = new RandomListNode(curr.label);
                node.next = curr.next;
                curr.next = node;
                curr = node.next;
            }
            for (RandomListNode curr = head; curr != null; ) {
                if (curr.random != null)
                    curr.next.random = curr.random.next;
                curr = curr.next.next;
            }
            RandomListNode dummy = new RandomListNode(-1);
            for (RandomListNode curr = head, newC = dummy; curr != null; ) {
                newC.next = curr.next;
                newC = newC.next;
                curr.next = curr.next.next;
                curr = curr.next;
            }
            return dummy.next;
        }
        
    }

    public static void main(String[] args){
        Solution result = new Solution();
        RandomListNode one = new RandomListNode(-1);
        RandomListNode one2 = new RandomListNode(1);
        one.next = one2;
        
        RandomListNode res = result.copyRandomList(one);
        result.printList(res);
    }
}
