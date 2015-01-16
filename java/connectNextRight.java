import com.TreeLinkNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class connectNextRight {
    public static class Solution {
        public void connect(TreeLinkNode root) {
            if (root == null || (root.left == null && root.right == null) ) return;
            TreeLinkNode left = null;
            TreeLinkNode right = null;
            if (root.left != null && root.right != null) {
                root.left.next = root.right;
                left = root.left;
                right = root.right;
                while (left.right != null) {
                    left.right.next = right.left;
                    left = left.right;
                    right = right.left;
                }
                connect(root.left);
                connect(root.right);
            }
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {-2, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        TreeLinkNode root = new TreeLinkNode(a[0]);
        root.buildTree(root, a);
        root.levelPrintTree(root);
        result.connect(root);
        root.levelPrintTree(root);
    }
}
/*
Input:	{-1,0,1,2,3,4,5,6,7,8,9,10,11,12,13}
Output:	{-1,#,0,1,#,2,3,4,5,#,6,7,8,9,#}
Expected:	{-1,#,0,1,#,2,3,4,5,#,6,7,8,9,10,11,12,13,#}
 */
