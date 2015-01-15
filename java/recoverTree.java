import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class recoverTree {
    public static class Solution {

        TreeNode prev = null;
        TreeNode first = null;
        TreeNode second = null;
        public void inOrderTraverse(TreeNode root) {
            if (root == null) return;
            if (root.left != null)
                inOrderTraverse(root.left);

            if (prev.val < root.val) {
                prev = root;
            } else if (prev.val > root.val) {
                if (first == null) {
                    first = prev;
                    second = root;
                } else second = root;
                prev = root;
            }

            if (root.right != null)
                inOrderTraverse(root.right);
        }

        public void recoverTree(TreeNode root) {
            if (root == null || (root.left == null && root.right == null)) return;
            if (root.left != null && root.right == null &&
                root.left.left == null && root.left.right == null) {
                first = root;
                second = root.left;
            } else if (root.right != null && root.left == null &&
                root.right.left == null && root.right.right == null) {
                first = root;
                second = root.right;
            }
            if (first == null || second == null) {
                TreeNode curr = root;
                if (curr.left != null)
                    while (curr.left != null) 
                        curr = curr.left;
                prev = curr;
                inOrderTraverse(root);
            }
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {2, 3, 1};
        TreeNode head = new TreeNode(a[0]);
        head.buildTree(head, a);
        head.inOrderPrintTree(head);
        System.out.println("");
        result.recoverTree(head);
        head.inOrderPrintTree(head);
    }
}

/*
  Input:	{2,3,1}
Output:	{3,1,2}
Expected:	{2,1,3}

 */
