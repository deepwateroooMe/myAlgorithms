import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class isValidBST {
    public static class Solution {
        // why it is tagged DFS-search ?
        public void inOrderTraversal(TreeNode root, List<Integer> res) {
            if (root == null) return;
            if (root.left != null)
                inOrderTraversal(root.left, res);
            res.add(root.val);
            if (root.right != null)
                inOrderTraversal(root.right, res);
        }
        
        public boolean isValidBST(TreeNode root) {
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
        int [] a = {1, -999, 2, 3};
        TreeNode head = new TreeNode(1);
        head.buildTree(head, a);
        head.levelPrintTree(head);
        boolean res = result.isValidBST(head);
        
        System.out.println(res);
    }
}
