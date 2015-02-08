import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class maxDepth {
    public static class Solution {
        public void maxDepth(TreeNode root, int cnt, List<Integer> res) {
            if (root == null) return;
            if (root.left == null && root.right == null) {
                if (cnt > res.get(0)) res.set(0, cnt);
                return;
            }
            maxDepth(root.left, cnt + 1, res);
            maxDepth(root.right, cnt + 1, res);
        }
        
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            List<Integer> res = new ArrayList<Integer>();
            res.add(1);
            maxDepth(root, 1, res);
            return res.get(0);
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, 2, 3, -1, -1, 4, 4};
        TreeNode curr = new TreeNode(a[0]);
        curr.buildTree(curr, a);
        curr.levelPrintTree(curr);
        int res = result.maxDepth(curr);
        System.out.println(res);
    }
}
