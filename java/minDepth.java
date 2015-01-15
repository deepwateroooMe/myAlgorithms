import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

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
        
        public int minDepth(TreeNode root) {
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
