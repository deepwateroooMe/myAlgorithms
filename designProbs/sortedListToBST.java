import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class {
    public static class Solution {
        /**
         * Definition for singly-linked list.
         * public class ListNode {
         *     int val;
         *     ListNode next;
         *     ListNode() {}
         *     ListNode(int val) { this.val = val; }
         *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         * }
         */
        /**
         * Definition for a binary tree node.
         * public class TreeNode {
         *     int val;
         *     TreeNode left;
         *     TreeNode right;
         *     TreeNode() {}
         *     TreeNode(int val) { this.val = val; }
         *     TreeNode(int val, TreeNode left, TreeNode right) {
         *         this.val = val;
         *         this.left = left;
         *         this.right = right;
         *     }
         * }
         */    

        private ListNode list;
        
        private TreeNode buildBSTfromSortedList(int bgn, int end) {
            if (bgn > end) return null;
            int mid = (bgn + end) / 2;
            TreeNode leftChild = buildBSTfromSortedList(bgn, mid - 1);
            TreeNode parent = new TreeNode(list.val);
            parent.left = leftChild;
            list = list.next;
            parent.right = buildBSTfromSortedList(mid + 1, end);
            return parent;
        }

        public TreeNode sortedListToBST(ListNode head) {
            int n = 0;
            ListNode p = head;
            while (p != null) {
                p = p.next;
                n++;
            }
            list = head;
            return buildBSTfromSortedList(0, n - 1);
        }
    }

    public static void main (String [] args){
        Solution result = new Solution ();

        System.out.println (res);
    }
}