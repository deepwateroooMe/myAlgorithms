import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class copyRandomList {
    public static class Solution {
        public class RandomListNode {
            int label;
            RandomListNode next, random;
            RandomListNode(int x) { this.label = x; }
        }

        public RandomListNode RandomListNode(int x) {
            RandomListNode res = new Solution.RandomListNode(-1);
            res.label = x;
            res.next = null;
            res.random = null;
            return res;
        }

        // use old method:
        // 1. insert a node copy to make n -> 2n length, 1st round
        // 2. set randome pointers, 2nd round
        // 3. split into two lists, 3rd round, O(n)
        public RandomListNode copyRandomList(RandomListNode head) {
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
                System.out.println("tmp.label 2: " + tmp.label);
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
                System.out.println("tmp.label: " + tmp.label); // 1
                System.out.println("tmp.next == null: " + (tmp.next == null));
                if (tmp != null && tmp.next != null) { // sth wrong here, don't think my mind is working, work on it tomorrow ~
                    next = tmp.next.next;
                    one.next = tmp.next;
                    one = one.next;
                    one.next = null;
                    tmp.next = next;
                } else
                    tmp.next = null;
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
    }

    public static void main(String[] args){
        Solution result = new Solution();
        Solution.RandomListNode one = result.RandomListNode(-1);
        Solution.RandomListNode one2 = result.RandomListNode(1);
        one.next = one2;
        
        Solution.RandomListNode res = result.copyRandomList(one);
        result.printList(res);
    }
}
