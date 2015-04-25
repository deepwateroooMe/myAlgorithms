import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class buildTreePreInOrder {
    public static class Solution {
        // I tried this method before, but got stackoverflow out of careless
        // got frightened from there, but it is not be that difficult
        // and I need always come back just as I found it's Memory limit error instead of TLE ...
        
        public int getIdx(int [] a, int val) {
            int idx = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] == val) {
                    idx = i;
                    break;
                }
            }
            return idx;
        }
        
        public TreeNode helper(int [] pre, int [] in, int idx, int bgn, int end) {
            if (bgn > end) return null;
            TreeNode root = new TreeNode(pre[idx]);
            if (bgn == end) return root;

            int inEnd = getIdx(in, pre[idx]);
            root.left = helper(pre, in, idx + 1, bgn, inEnd - 1);
            root.right = helper(pre, in, idx + (inEnd - bgn) + 1, inEnd + 1, end);
            return root;
        }

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return helper(preorder, inorder, 0, 0, inorder.length - 1);
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {4, 1, 2, 3};
        int [] b = {1, 2, 3, 4};
        TreeNode root = result.buildTree(a, b);
        root.levelPrintTree(root);
    }
}
/*
  Runtime Error Message:	Line 29: java.lang.StackOverflowError
Last executed input:	[4,1,2,3], [1,2,3,4]
 */
