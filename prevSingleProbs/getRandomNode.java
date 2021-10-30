import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class getRandomNode {
    public static class Solution {

        public class ListNode {
            int val;
            ListNode next;
            ListNode() {}
            ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }
        
        /** @param head The linked list's head.
            Note that the head is guaranteed to be not null, so it contains at least one node. */
        public Solution(ListNode head) {
            
        }

        // private buildCircularList(ListNode head) {
        //     if (head.next == null) return head;
        //     ListNode p = head;
        //     while (p.next != null) 
        //         p = p.next;
        //     p.next = head;
        // }

        /** Returns a random node's value. */
        public int getRandom() {
            Random rand = new Random();
            int tmp = rand.nextInt(100000) % 10000;
            System.out.println("tmp: " + tmp);
            int cnt = 0;
            ListNode p = head;
            while (cnt < tmp) {
                cnt++;
                p = p.next;
            }
            return p.val;
        }


        
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        

        // System.out.println(res);
    }
}