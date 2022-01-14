import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class {
    public static class Solution {
    
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
        private TreeNode buildBSTfromSortedArray(int [] nums, int bgn, int end) {
            if (bgn > end) return null;
            int mid = (bgn + end) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = buildBSTfromSortedArray(nums, bgn, mid - 1);
            root.right = buildBSTfromSortedArray(nums, mid + 1, end);
            return root;
        }
        
        public TreeNode sortedArrayToBST(int[] nums) {
            buildBSTfromSortedArray(nums, 0, nums.length - 1);
        }
    }

    public static void main (String [] args){
        Solution result = new Solution ();

        System.out.println (res);
    }
}