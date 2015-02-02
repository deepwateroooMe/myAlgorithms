import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class pathSum {
    public static class Solution {
        public void judSum(TreeNode root, int sum, List<List<Integer>> res,
                           List<Integer> one, int curr) {
            curr += root.val;
            one.add(root.val);
            int n;
            
            if (root.left == null && root.right == null) {
                if (curr == sum) 
                    res.add(one);
                else {
                    n = one.size();
                    one.remove(n - 1);
                }
                return;
            }

            if (root.left != null) {
                List<Integer> two1 = new ArrayList<Integer>(one);
                judSum(root.left, sum, res, two1, curr);
            }
            if (root.right != null) {
                List<Integer> two2 = new ArrayList<Integer>(one);
                judSum(root.right, sum, res, two2, curr);
            }
        }
        public void pathSum(TreeNode root, int gap, List<Integer> curr,
                            List<List<Integer>> res) {
            if (root == null) return;
            curr.add(root.val);
            if (root.left == null && root.right == null) 
                if (root.val == gap) 
                    res.add(curr);
            pathSum(root.left, gap - root.val, new ArrayList<Integer>(curr), res);
            pathSum(root.right, gap - root.val, new ArrayList<Integer>(curr), res);
        }
        
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            List<Integer> curr = new ArrayList<Integer>();
            pathSum(root, sum, curr, res);
            return res;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {5, 4, 8, 11, -1, 13, 4, 7, 2, -1, -1, 5, 1};
        TreeNode root = new TreeNode(a[0]);
        root.buildTree(root, a);
        root.levelPrintTree(root);
        List<List<Integer>> res = result.pathSum(root, 22);
        System.out.println("");
        for (int i = 0; i < res.size(); ++i) {
            System.out.println(res.get(i));
        }
        System.out.println("");
    }
}
