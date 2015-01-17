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

        public TreeNode sortedListToBST(ListNode head) {
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
