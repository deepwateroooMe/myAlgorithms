import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class isSymmetric {
    public static class Solution {
        public boolean isSymTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) return true;
            else if (p == null || q == null) return false;
            else if (p.val != q.val) return false;
            return isSymTree(p.left, q.right) && isSymTree(p.right, q.left);
        }

        public boolean isSymmetric(TreeNode root) {
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
