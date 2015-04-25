import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class isValidBST {
    public static class Solution {
        public void inOrderTraversal(TreeNode root, List<Integer> res) {
            if (root == null) return;
            if (root.left != null)
                inOrderTraversal(root.left, res);
            res.add(root.val);
            if (root.right != null)
                inOrderTraversal(root.right, res);
        }

       private boolean isValidBST(TreeNode root, int lower, int upper) {
            if (root == null) return true;
            if (root.val == Integer.MIN_VALUE && root.left != null)
                return false;
            if(root.val == Integer.MAX_VALUE && root.right != null)
                return false;
            return root.val >= lower && root.val <= upper
                && isValidBST(root.left, lower, root.val - 1)
                && isValidBST(root.right, root.val + 1, upper);
        }
        
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        public void inOrderTraversal0(TreeNode root, List<Integer> res) {
            if (root == null) return;
            if (root.left != null)
                inOrderTraversal(root.left, res);
            res.add(root.val);
            if (root.right != null)
                inOrderTraversal(root.right, res);
        }
        
        public boolean isValidBST0(TreeNode root) {
            if (root == null || (root.left == null && root.right == null)) return true;
            List<Integer> res = new ArrayList<Integer>();
            inOrderTraversal(root, res);
            for (int i = 1; i < res.size(); i++) {
                if (res.get(i) <= res.get(i - 1)) return false;
            }
            return true;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {2147483647};
        TreeNode head = new TreeNode(a[0]);
        head.buildTree(head, a);
        head.levelPrintTree(head);
        boolean res = result.isValidBST(head);
        
        System.out.println(res);
    }
}

/*
  Input:	{2147483647}
Output:	false
Expected:	true
*/
