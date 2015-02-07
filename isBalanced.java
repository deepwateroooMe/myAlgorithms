import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class isBalanced {
    public static class Solution {
        // is there any special way to pack List<Integer> like c++ &res ? don't understanding...
        public void getMaxDepth(TreeNode root, List<Integer> res, int cnt) {
            if (root == null) return;
            if (root.left == null && root.right == null) {
                if (cnt > res.get(0)) {
                    res.set(0, cnt);
                    System.out.println("cnt: " + cnt);

                    return;
                }
            }
            if (root.left != null) getMaxDepth(root.left, res, cnt + 1);
            if (root.right != null) getMaxDepth(root.right, res, cnt + 1);
        }
        
        public boolean isBalanced(TreeNode root) {
            if (root == null || (root.left == null && root.right == null)) return true;
            ArrayList<Integer> max = new ArrayList<Integer>();
            max.add(1);
            getMaxDepth(root.left, max, 1);
            int left = max.get(0);
            System.out.println("left: " + left);

            max.set(0, 1);
            getMaxDepth(root.right, max, 1);
            return Math.abs(left - max.get(0)) <= 1;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, 2, 3, 4, -1, 5, 6, 7, 8, 9, 10, 11, 12};
        TreeNode root = new TreeNode(a[0]);
        root.buildTree(root, a);
        root.preOrderPrintTree(root);
        root.levelPrintTree(root);

        boolean res = result.isBalanced(root);
        
        System.out.println(res);
    }
}
/* I think I only missed the tree level order definition here, check back at it tomorrow...
  7 / 13 test cases passed.
Input
{1,2,3,4,#,5,6,7,8,9,10,11,12}
Output
true
Expected
false
*/








