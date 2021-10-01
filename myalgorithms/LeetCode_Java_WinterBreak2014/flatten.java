import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Arrays;

public class flatten {
    public static class Solution {
        public TreeNode flatten(TreeNode root, TreeNode tail) {
            if (root == null) return tail;
            root.right = flatten(root.left, flatten(root.right, tail));
            root.left = null;
            return root;
        }
        
        public void flatten2(TreeNode root) {
            flatten(root, null);
        }

        public void flatten(TreeNode root) {
            if (root == null) return;
            Stack<TreeNode> s = new Stack<TreeNode>();
            s.push(root);
            while (!s.isEmpty()) {
                TreeNode p = s.pop();
                if (p.right != null)
                    s.push(p.right);
                if (p.left != null)
                    s.push(p.left);
                p.left = null;
                if (!s.isEmpty())
                    p.right = s.peek();
            }
        }
        
        public void flatten1(TreeNode root) {
            if (root == null) return;
            flatten(root.left);
            flatten(root.right);
            if (root.left == null) return;

            TreeNode p = root.left;
            while (p.right != null) {
                p = p.right;
            }
            p.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        
        public void flatten0(TreeNode root) {
            if (root == null) return;
            if (root == null || (root.left == null && root.right == null)) return;
            if (root.left == null && root.right.left == null && root.right.right == null) return;
            Stack<TreeNode> s = new Stack<TreeNode>();
            TreeNode prev = null;
            TreeNode curr = root;
            TreeNode tmp = root.right;
            TreeNode one = null;
            s.push(root);
            while (!s.isEmpty()) {
                curr = s.pop();
                if (curr.left == null && curr.right != null) {
                    s.push(curr.right);
                    if (prev == null)
                        prev = curr;
                    else {
                        prev.right = curr;
                        prev.left = null;
                        prev = prev.right;
                    }
                    continue;
                }
                
                while (curr != null && curr.left != null) {
                    if (curr.right != null) 
                        s.push(curr.right);
                    if (prev == null) {
                        prev = curr;
                        //prev.left = null;  // no no no no~~!!
                    } else {                    
                        prev.right = curr;
                        prev.left = null;
                        prev = prev.right;
                    }
                    curr = curr.left;
                }

                if (curr != null && curr.left == null) {
                    if (curr.right != null) s.push(curr.right);
                    if (prev == null) {
                        prev = root;
                        prev.left = null;
                    } else {         
                        prev.right = curr;
                        prev.left = null;
                        prev = prev.right;
                    }
                }
            }
            prev.right = null;
            return;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, -1, 2, 3};
        //int [] a = {1, 2, 5, 3, 4, -1, 6};

        TreeNode root = new TreeNode(a[0]);
        root.buildTree(root, a);
        root.levelPrintTree(root);
        //root.inOrderPrintTree(root);

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
