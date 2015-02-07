import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class inorderTraversal {
    public static class Solution {
        /**
         * @param root: The root of binary tree.
         * @return: Inorder in ArrayList which contains node values.
         */
        public void inorderTraversal(TreeNode root, ArrayList<Integer> res) {
            if (root == null) return;
            inorderTraversal(root.left, res);
            res.add(root.val);
            inorderTraversal(root.right, res);
        }
        
        public ArrayList<Integer> inorderTraversal(TreeNode root) {
            ArrayList<Integer> res = new ArrayList<Integer>();
            inorderTraversal(root, res);
            return res;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, -1, 2, 3};
        TreeNode root = new TreeNode(a[0]);
        root.buildTree(root, a);
        root.levelPrintTree(root);
        ArrayList<Integer> res = result.inorderTraversal(root);

        System.out.println(res);
    }
}
