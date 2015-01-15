import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class isBalanced {
    public static class Solution {

        private void helper(TreeNode root, List<Integer> res, int idx) {
            int cnt = res.get(0);
            if (root == null) return;
            else if (root.left == null && root.right == null) {
                if (idx > cnt)
                    res.add(0, idx);
                return;
            }
            helper(root.left, res, idx + 1);
            helper(root.right, res, idx + 1);
        }
        
        private int maxDepth(TreeNode root) {
            if (root == null) return 0;
            else if (root.left == null && root.right == null) return 1;

            List<Integer> res = new ArrayList<Integer>();
            int cnt = 1;
            res.add(cnt);
            helper(root, res, 1);
            return res.get(0);
        }

        public boolean isBalanced(TreeNode root) {
            if (root == null) return true;
            else if (root.left == null && root.right == null) return true;
            else if (root.left == null)
                return root.right.left == null && root.right.right == null;
            else if (root.right == null)
                return root.left.left == null && root.left.right == null;
            
            if (!isBalanced(root.left) || !isBalanced(root.right)) return false;
            // must make sure they differ at most by one
            return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, 2, 2, 3, 3, -1, -1, 4, 4};
        TreeNode root = new TreeNode(a[0]);
        root.buildTree(root, a);
        root.levelPrintTree(root);
        boolean res = result.isBalanced(root);

        System.out.println(res);
    }
}
