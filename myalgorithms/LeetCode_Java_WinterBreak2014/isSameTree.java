import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class isSameTree {
    public static class Solution {
        public boolean isSameTree0(TreeNode p, TreeNode q) {
            if (p == null && q == null) return true;
            if (p == null || q == null) return false;
            return p.val == q.val
                && isSameTree(p.left, q.left)                
                && isSameTree(p.right, q.right);
        }

        public boolean isSameTree(TreeNode p, TreeNode q) {
            Stack<TreeNode> s = new Stack<TreeNode>();
            s.push(p);
            s.push(q);
            while (!s.isEmpty()) {
                p = s.pop();
                q = s.pop();
                if (p == null && q == null) continue;
                if (p == null || q == null) return false;
                if (p.val != q.val) return false;
                s.push(p.left);
                s.push(q.left);
                s.push(p.right);
                s.push(q.right);
            }
            return true;
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
