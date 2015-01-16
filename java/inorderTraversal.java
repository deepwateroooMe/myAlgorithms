import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class inorderTraversal {
    public static class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            if (root == null) return res;
            TreeNode curr = root;
            Stack<TreeNode> s = new Stack<TreeNode>();
            while (!s.isEmpty() || curr != null) {
                while (curr != null) {
                    s.push(curr);
                    curr = curr.left;
                }
                curr = s.pop();
                res.add(curr.val);
                curr = curr.right;
            }
            return res;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, -1, 2, 3};
        TreeNode root = new TreeNode(a[0]);
        root.buildTree(root, a);
        root.levelPrintTree(root);
        List<Integer> res = result.inorderTraversal(root);
        root.levelPrintTree(root);
    }
}
