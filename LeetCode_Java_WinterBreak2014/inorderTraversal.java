import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class inorderTraversal {
    public static class Solution {
        public List<Integer> inorderTraversal0(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            if (root == null) return res;
            TreeNode p = root;
            Stack<TreeNode> s = new Stack<TreeNode>();
            while (!s.isEmpty() || p != null) {
                if (p != null) {
                    s.push(p);
                    p = p.left;
                } else {
                    p = s.pop();
                    res.add(p.val);
                    p = p.right;
                }
            }
            return res;
        }

        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            TreeNode prev = null;
            TreeNode curr = root;
            Stack<TreeNode> s = new Stack<TreeNode>();
            while (curr != null) {
                if (curr.left == null) {
                    res.add(curr.val);
                    prev = curr;
                    curr = curr.right;
                } else {
                    TreeNode node = curr.left;
                    while (node.right != null && node.right != curr) {
                        node = node.right;
                    }
                    if (node.right == null) {
                        node.right = curr;
                        curr = curr.left;
                    } else {
                        res.add(curr.val);
                        node.right = null;
                        curr = curr.right;
                    }
                }
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
