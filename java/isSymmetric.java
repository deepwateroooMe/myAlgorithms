import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class isSymmetric {
    public static class Solution {
        public boolean isSymTree(TreeNode left, TreeNode right) {
            if (left == null && right == null) return true;
            if (left == null || right == null) return false;
            return left.val == right.val
                && isSymTree(left.left, right.right)
                && isSymTree(left.right, right.left);
        }

        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            Stack<TreeNode> s = new Stack<TreeNode>();
            s.push(root.left);
            s.push(root.right);
            while (!s.isEmpty()) {
                TreeNode p = s.pop();
                TreeNode q = s.pop();
                if (p == null && q == null) continue;
                if (p == null || q == null) return false;
                if (p.val != q.val) return false;
                s.push(p.left);
                s.push(q.right);
                s.push(p.right);
                s.push(q.left);
            }
            return true;
        }
        
        public boolean isSymmetric0(TreeNode root) {
            if (root == null ) return true;
            return isSymTree(root.left, root.right);
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, 2, 2, 3, 4, 4, 3};
        TreeNode ahead = new TreeNode(a[0]);
        ahead.buildTree(ahead, a);
        ahead.levelPrintTree(ahead);
        boolean res = result.isSymmetric(ahead);

        System.out.println(res);
    }
}
