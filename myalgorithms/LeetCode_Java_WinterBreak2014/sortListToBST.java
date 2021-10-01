
import com.TreeNode;
import com.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class sortListToBST {
    public static class Solution {
        public TreeNode createMyTree(ListNode [] num, int bgn, int end) {
            TreeNode root = null;
            if (bgn == end) {
                root = new TreeNode(num[end].val);
                return root;
            }
            if (bgn < end) {
                int mid = bgn + (end - bgn) / 2;
                root = new TreeNode(num[mid].val);
                root.left = createMyTree(num, bgn, mid - 1);
                root.right = createMyTree(num, mid + 1, end);
                return root;
            }
            return null;
        }

        public TreeNode sortedListToBST0(ListNode head) {
            TreeNode root = null;
            if (head == null) return null;
            else if (head.next == null) {
                root = new TreeNode(head.val);
                return root;   
            }
            ListNode [] num = new ListNode[100000]; // 10,0000 works, 50000 doesn't
            ListNode curr = head;
            int idx = 0;
            while (curr != null) {
                num[idx++] = curr;
                curr = curr.next;
            }
            root = createMyTree(num, 0, idx - 1);
            return root;
        }

        public int listLength(ListNode head) {
            int n = 0;
            while (head != null) {
                ++n;
                head = head.next;
            }
            return n;
        }

        ListNode nth_node(ListNode node, int n) {
            while (--n > 0) 
                node = node.next;
                return node;
        }
        
        public TreeNode sortListToBST(ListNode head, int len) {
            if (len == 0) return null;
            if (len == 1) return new TreeNode(head.val);
            TreeNode root = new TreeNode(nth_node(head, len / 2 + 1).val);
            root.left = sortListToBST(head, len / 2);
            root.right = sortListToBST(nth_node(head, len / 2 + 2), (len - 1) / 2);
            return root;
        }
        
        public TreeNode sortedListToBST1(ListNode head) {
            return sortListToBST(head, listLength(head));
        }

        // I don't understand where I got wrong yet, cannot think this one tonight...
        public TreeNode sortedListToBST(ListNode head, int bgn ,int end) {
            if (bgn > end) return null;
            int mid = bgn + (end - bgn) / 2;
            TreeNode left = sortedListToBST(head, bgn, mid - 1);
            TreeNode root = new TreeNode(head.val);
            root.left = left;
            head = head.next;     // attention !
            root.right = sortedListToBST(head, mid + 1, end);
            return root;
        }
        
        public TreeNode sortedListToBST(ListNode head) {
            int len = 0;
            ListNode p = head;
            while (p != null) {
                len++;
                p = p.next;
            }
            return sortedListToBST(head, 0, len - 1);
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, 2, 3, 4, 5, 6};
        ListNode head = new ListNode(a[0]);
        head.buildList(head, a);
        head.printList(head);

        TreeNode res = result.sortedListToBST(head);
        //res.levelPrintTree(res);
        res.inOrderPrintTree(res);

    }
}
/*
  Input:	{3,5,8}
Output:	{3,3,5}
Expected:	{5,3,8}
*/
