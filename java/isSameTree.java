import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class isSameTree {
    public static class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) return true;
            else if (p == null || q == null) return false;
            else if (p.val != q.val) return false;
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {2, 3, 4, 5, 6};
        int [] b = {2, 3, 4, 5, 7};
        TreeNode ahead = new TreeNode(a[0]);
        TreeNode bhead = new TreeNode(b[0]);
        ahead.buildTree(ahead, a);
        bhead.buildTree(bhead, b);
        ahead.levelPrintTree(ahead);
        bhead.levelPrintTree(bhead);
        boolean res = result.isSameTree(ahead, bhead);

        System.out.println(res);
    }
}
