import com.TreeNode;
import com.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class sortedListToBST {
    public static class Solution {
        /**
         * @param head: The first node of linked list.
         * @return: a tree node
         */
        /**
         * Definition for ListNode.
         * public class ListNode {
         *     int val;
         *     ListNode next;
         *     ListNode(int val) {
         *         this.val = val;
         *         this.next = null;
         *     }
         * }
         * Definition of TreeNode:
         * public class TreeNode {
         *     public int val;
         *     public TreeNode left, right;
         *     public TreeNode(int val) {
         *         this.val = val;
         *         this.left = this.right = null;
         *     }
         * }
         */
        // set test case && both methods
        public int getSize(ListNode head) {
            int cnt = 0;
            while (head != null) {
                ++cnt;
                head = head.next;
            }
            return cnt;
        }
        public ListNode getKthNode(ListNode head, int n) {
            int cnt = 0;
            while (head != null && cnt < n) {
                ++cnt;
                head = head.next;
            }
            return head;
        }
        
        public TreeNode sortedListToBST(ListNode head) {
            if (head == null) return null;
            if (head.next == null) return new TreeNode(head.val);
            int n = getSize(head);
            TreeNode root = new TreeNode(getKthNode(head, (n - 1) / 2).val);
            ListNode leftT = getKthNode(head, (n - 1) / 2 - 1);  // do I need to set tail = null ?
            leftT.next = null;
            root.left = sortedListToBST(head);
            root.right = sortedListToBST(getKthNode(head, (n - 1) / 2 + 1));
            return root;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();

        System.out.println(res);
    }
}
