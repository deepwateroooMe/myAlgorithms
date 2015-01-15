import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class flatten {
    public static class Solution {
        public void flatten(TreeNode root) {
            //if (root == null) return;
            TreeNode curr = null;
            TreeNode rit = null;
            TreeNode tmp = null;
            if (root == null || (root.left == null && root.right == null)) return;
            else if (root.left == null) {
                curr = root.right;
                while (curr != null && curr.left == null)
                    curr = curr.right;
                if (curr == null) return;
            } else if (root.right == null) {
                flatten(root.left);
                root.right = root.left;
            } else {            
                if (root.left.left == null && root.left.right == null &&
                    root.right.left == null && root.right.right == null) {
                    tmp = root.right;
                    root.right = root.left;
                    root = root.right;
                    root.right = tmp;
                }
                flatten(root.left);
                flatten(root.right);
                rit = root.right;
                root.right = root.left;
                curr = root.right;
                while (curr.right != null) 
                    curr = curr.right;
                curr.right = rit;
            }
            return;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, 2, 5, 3, 4, -1, 6};
        TreeNode root = new TreeNode(a[0]);
        root.buildTree(root, a);
        root.levelPrintTree(root);
        result.flatten(root);
        root.inOrderPrintTree(root);
    }
}
