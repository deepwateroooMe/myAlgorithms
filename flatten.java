import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class flatten {
    public static class Solution {
        // got completely confused by myself now...
        // I remembered there is a special trick to remember right, then flip left to right for root.left,
        // but I just got stubbern and don't really understand how to operate now...
        // work on it some other day, 2 difficult tree questions left now
        
        public TreeNode helper(TreeNode root) {
            if (root == null || (root.left == null && root.right == null)) return root;
            if (root.left == null && root.right.left == null && root.right.right == null) return root;
            Stack<TreeNode> s = new Stack<TreeNode>();
            TreeNode prev = null;
            TreeNode curr = root;
            TreeNode tmp = root.right;
            TreeNode one = null;
            s.push(root);
            int cnt = 0;
            while (!s.isEmpty()) {
                curr = s.pop();

                ++cnt;
                System.out.println("");
                System.out.println("cnt: " + cnt);
                System.out.println("curr.val: " + curr.val);
                if (prev != null)
                    System.out.println("prev.val 0: " + prev.val);

                if (curr.right != null) 
                    s.push(curr.right);
                if (curr == root) {
                    prev = curr;
                    System.out.println("prev.val 11: " + prev.val);
                }
                while (curr.left != null) {
                    prev.right = curr;
                    prev.left = null;
                    prev = prev.right;
                    curr = curr.left;
                    if (curr.right != null) 
                        s.push(curr.right);
                }
            }
            return root;
        }
        
        public void flatten(TreeNode root) {
            if (root == null) return;
            root = helper(root);
            return;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        //int [] a = {1, -1, 2, 3};
        int [] a = {1, 2, 5, 3, 4, -1, 6};

        TreeNode root = new TreeNode(a[0]);
        root.buildTree(root, a);
        root.levelPrintTree(root);

        result.flatten(root);
        root.inOrderPrintTree(root);
    }
}
/*
  Time Limit ExceededMore Details 
  Last executed input:	{1,#,2,3}

  Runtime Error Message:	Line 14: java.lang.NullPointerException
  Last executed input:	{0}

  Time Limit ExceededMore Details 
  Last executed input:	{1,#,2}
*/
