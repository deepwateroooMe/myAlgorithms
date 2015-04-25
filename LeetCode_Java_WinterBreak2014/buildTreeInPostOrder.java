
import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class buildTreeInPostOrder {
    public static class Solution {
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
        
        public TreeNode helper(int [] in, int [] post, int idx, int bgn, int end) {
            if (bgn > end) return null;
            TreeNode root = new TreeNode(post[idx]);
            if (bgn == end) return root;
            int inEnd = getIdx(in, post[idx]);
            root.left = helper(in, post, idx - (end - inEnd) - 1, bgn, inEnd - 1);
            root.right = helper(in, post, idx - 1, inEnd + 1, end);
            return root;
        }
        
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return helper(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, 2, 3, 4, 5, 6, 7};
        int [] b = {1, 3, 2, 5, 7, 6, 4};
        TreeNode root = result.buildTree(a, b);
        root.levelPrintTree(root);
    }
}
