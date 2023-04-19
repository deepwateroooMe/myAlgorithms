import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class rangeSumBST {
    public static class Solution {

        private int result;

        private void inOrderTraversalTree(TreeNode root, int low, int high) {
            if (root == null) return;
            if (root.left != null)
                inOrderTraversalTree(root.left, low, high);
            if (root.val >= low && root.val <= high)
                result += root.val;
            if (root.right != null)
                inOrderTraversalTree(root.right, low, high);
        }
        
        public int rangeSumBST(TreeNode root, int low, int high) {
            result = 0;
            inOrderTraversalTree(root, low, high);
            return result;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int [] a = {10,5,15,3,7,13,18,1,-1,6};
        
        TreeNode root = new TreeNode(a[0]);
        root.buildTree(root, a);
        root.levelPrintTree(root);

        int res = s.rangeSumBST(root, 6, 10);
        System.out.println("res: " + res);
    }
}