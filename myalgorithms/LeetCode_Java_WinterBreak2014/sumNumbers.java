import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class sumNumbers {
    public static class Solution {
        public void mysum(TreeNode root, List<Integer> res, List<Integer> one) {
            int val = one.get(0);
            List<Integer> atmp = new ArrayList<Integer>();
            List<Integer> btmp = new ArrayList<Integer>();

            if (root == null) return;
            val *= 10;
            val += root.val;
            if (root.left == null && root.right == null) {
                res.set(0, res.get(0) + val);
                return;
            }

            atmp.add(val);
            btmp.add(val);
            if (root.left != null)
                mysum(root.left, res, atmp);
            if (root.right != null)
                mysum(root.right, res, btmp);
        }

        public int dfs(TreeNode root, int sum) {
            if (root == null) return 0;
            if (root.left == null && root.right == null)
                return sum * 10 + root.val;
            return dfs(root.left, sum * 10 + root.val)
                + dfs(root.right, sum * 10 + root.val);
        }
        
        public int sumNumbers(TreeNode root) {
            return dfs(root, 0);
        }

        public int sumNumbers0(TreeNode root) {
            if (root == null) return 0;
            else if (root.left == null && root.right == null) return root.val;
            List<Integer> one = new ArrayList<Integer>();
            List<Integer> res = new ArrayList<Integer>();
            one.add(0);
            res.add(0);
            mysum(root, res, one);
            return res.get(0);
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, 2, 3};
        TreeNode root = new TreeNode(a[0]);
        root.buildTree(root, a);
        root.levelPrintTree(root);
        int res = result.sumNumbers(root);
        
        System.out.println(res);
    }
}
