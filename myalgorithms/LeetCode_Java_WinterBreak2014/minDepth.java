import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class minDepth {
    public static class Solution {
        private void helper(TreeNode root, List<Integer> res, int idx) {
            int cnt = res.get(0);
            if (root == null) return;
            else if (root.left == null && root.right == null) {
                if (idx < cnt)
                    res.add(0, idx);
                return;
            }
            helper(root.left, res, idx + 1);
            helper(root.right, res, idx + 1);
        }

        public int minDepth(TreeNode root, boolean hasBrother) {
            if (root == null) return hasBrother ? Integer.MAX_VALUE : 0;
            return 1 + Math.min(minDepth(root.left, root.right != null),
                                minDepth(root.right, root.left != null));
        }
        
        public int minDepth1(TreeNode root) {
            return minDepth(root, false);
        }

        public class Tnd {
            TreeNode tn;
            int dep;
            public Tnd() {
                tn = null;
                dep = 0;
            }
            public Tnd(TreeNode x, int y) {
                tn = x;
                dep = y;
            }
        }

        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            int res = Integer.MAX_VALUE;
            Stack<Tnd> s = new Stack<Tnd>();
            s.push(new Tnd(root, 1));
            while (!s.isEmpty()) {
                Tnd tmp = s.pop();
                TreeNode curr = tmp.tn;
                int depth = tmp.dep;
                if (curr.left == null && curr.right == null)
                    res = Math.min(res, depth);
                if (curr.left != null && res > depth)
                    s.push(new Tnd(curr.left, depth + 1));
                if (curr.right != null && res > depth)
                    s.push(new Tnd(curr.right, depth + 1));
            }
            return res;
        }

        public int minDepth0(TreeNode root) {
            if (root == null) return 0;
            else if (root.left == null && root.right == null) return 1;
            
            List<Integer> res = new ArrayList<Integer>();
            int cnt = Integer.MAX_VALUE;
            res.add(cnt);
            helper(root, res, 1);
            return res.get(0);
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {3, 20, 9, 15, 7};
        TreeNode head = new TreeNode(a[0]);
        head.buildTree(head, a);
        head.levelPrintTree(head);
        int res = result.minDepth(head);

        System.out.println(res);
    }
}
