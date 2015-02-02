import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class maxPathSum {
    public static class Solution {
        // need to fix this one, how to pass &max in c++ in java, boxing ?
        public int maxSum(TreeNode root, int [] max) {
            if (root == null) {
                max[0] = 0;
                return 0;   
            }
            if (root.left == null && root.right == null) {
                max[0] = root.val;
                return max[0];
            }
            int result;
            int ml = 0, mr = 0;
            int [] msl = {0, 0};
            int [] msr = {0, 0};
            ml = maxSum(root.left, msl);
            mr = maxSum(root.right, msr);
            max[0] = Math.max(Math.max(msl[0]+root.val, root.val),
                           Math.max(msr[0]+root.val, root.val));
            result = Math.max(Math.max(msl[0]+root.val, msl[0]+msr[0]+root.val),
                              Math.max(msr[0]+root.val, msr[0]+msl[0]+root.val));
            result = Math.max(result, root.val);
            if (root.left != null)
                result = Math.max(result, ml);
            if (root.right != null)
                result = Math.max(result, mr);
            return result;
        }
        
        public int maxPathSum0(TreeNode root) {
            if (root == null) return 0;
            int [] max = {0, 0};
            return maxSum(root, max);
        }

        private int res;
        public int dfs(TreeNode root) {
            if (root == null) return 0;
            int left = dfs(root.left);
            int right = dfs(root.right);
            int sum = root.val;
            if (left > 0) sum += left;
            if (right > 0) sum += right;
            res = Math.max(res, sum);
            return Math.max(right, left) > 0 ? Math.max(right, left) + root.val : root.val;
        }
        
        public int maxPathSum(TreeNode root) {
            res = Integer.MIN_VALUE;
            dfs(root);
            return res;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        //int [] a = {1, -2, -3, 1, 3, -2, -999, -1}; // -999 mark null
        int [] a = {1, 2, 3};
        TreeNode root = new TreeNode(a[0]);
        root.buildTree(root, a);
        root.preOrderPrintTree(root);
        root.levelPrintTree(root);
        int res = result.maxPathSum(root);
        System.out.println("res: " + res);
        
    }
}









