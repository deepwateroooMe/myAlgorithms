import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class hasPathSum {
    public static class Solution {
        public boolean judSum(TreeNode root, int sum, int curr) {
                curr += root.val;
                if (root.left == null && root.right == null) 
                    return (curr == sum);

                if (root.left != null && root.right == null) 
                    return judSum(root.left, sum, curr);
                else if (root.right != null && root.left == null) 
                    return judSum(root.right, sum, curr);
                else
                    return (judSum(root.left, sum, curr) || judSum(root.right, sum, curr));
        }
        
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) return false;
            if (root.left == null && root.right == null)
                return sum == root.val;
            return hasPathSum(root.left, sum - root.val)
                || hasPathSum(root.right, sum - root.val);
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {5, 4, 8, 11, -1, 13, 4, 7, 2, -1, -1, -1, 1};
        TreeNode root = new TreeNode(a[0]);
        root.buildTree(root, a);
        root.levelPrintTree(root);
        boolean res = result.hasPathSum(root, 22);

        System.out.println(res);
    }
}
