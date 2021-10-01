import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class maxPathSum {
    public static class Solution {
        /**
         * @param root: The root of binary tree.
         * @return: An integer.
         */
        // somewhere confusing here....
        public int maxPathSum(TreeNode root, List<Integer> res, int val) {
            if (root == null) return 0;
            /*
            if (root.left == null && root.right == null) {
                if (root.val + val > res.get(0))
                    res.set(0, root.val + val);
                return root.val + val;
                } */
            int left = maxPathSum(root.left, res, root.val + val);
            int right = maxPathSum(root.right, res, root.val + val);
            if (left > 0 && right > 0) {
                if (left + right - root.val - val > res.get(0))
                    res.set(0, left + right - root.val - val);
            } else if (left > 0 && left > res.get(0)) 
                res.set(0, left);
            else if (right > 0 && right > res.get(0))
                res.set(0, right);
            return root.val > 0 ? Math.max(root.val + left + val, root.val + right + val) : val;
        }
        
        public int maxPathSum(TreeNode root) {
            if (root == null) return 0;
            ArrayList<Integer> res = new ArrayList<Integer>();
            res.add(Integer.MIN_VALUE);
            maxPathSum(root, res, 0);
            return res.get(0);
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        TreeNode root = new TreeNode(a[0]);
        root.buildTree(root, a);
        int res = result.maxPathSum(root);
        
        System.out.println(res);
    }
}
