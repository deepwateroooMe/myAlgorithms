import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class preorderTraversal {
    public static class Solution {
        
        // recursive method first
        public void preorderTraversalHelper(TreeNode root, List<Integer> res) {
            if (root != null) {
                res.add(root.val);
            }
            if (root.left != null) {
                preorderTraversalHelper(root.left, res);
            }
            if (root.right != null) {
                preorderTraversalHelper(root.right, res);
            }
        }
        
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            if (root == null) {
                return res;
            }
            Stack<TreeNode> s = new Stack<TreeNode>();
            TreeNode curr = root;
            while (!s.isEmpty() || curr != null) {
                while (curr != null) {
                    res.add(curr.val);
                    s.push(curr);
                    curr = curr.left;
                }
                if (!s.isEmpty()) {
                    curr = s.pop();
                    curr = curr.right;
                } 
            }
            return res;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {3, 1, -1, -1, 2};
        TreeNode root = new TreeNode(a[0]);
        root.buildTree(root, a);
        root.levelPrintTree(root);
        //root.preOrderPrintTree(root);
        
        List<Integer> res = result.preorderTraversal(root);
        System.out.println("");
        for (int i = 0; i < res.size(); ++i) {
            System.out.print(res.get(i) + ", ");
        }
        System.out.println("");

    }
}

/*
  Input:	{3,1,#,#,2}
Output:	[3,1]
Expected:	[3,1,2]

  Input:	{4,2,#,1,3}
Output:	[4,2,3]
Expected:	[4,2,1,3]

Input:	{4,1,#,2,#,3}
Output:	[4,1,2]
Expected:	[4,1,2,3]
 */
        /* // thought and got it too complicated
        // iterative method: use a stack<TreeNode> right, left, root order
        public void preorderTraversalIter(TreeNode root, List<Integer> res) {       
            Stack<TreeNode> s = new Stack<TreeNode>();
            Stack<TreeNode> f = new Stack<TreeNode>();
            TreeNode curr = null;
            if (root.right != null) {
                curr = root.right;
                s.push(curr);
                while (!s.isEmpty()) {
                    while (curr.right != null) {
                        curr = curr.right;
                        s.push(curr);
                    }
                    while (!s.isEmpty()) {
                        curr = s.pop();
                        if (curr.left != null)
                            f.push(curr.left);
                        f.push(curr);
                    }  
                } 
            }

            // root.left
            if (root.left != null) {
                curr = root.left;
                s.push(curr);
                while (!s.isEmpty()) {
                    while (curr.right != null) {
                        curr = curr.right;
                        s.push(curr);
                    }
                    while (curr.left != null) {
                        curr = curr.left;
                        s.push(curr);
                    }
                    //System.out.println("s.size(): " + s.size());

                    while (!s.isEmpty()) {
                        curr = s.pop();
                        f.push(curr);
                        /*
                        if (curr.left == null && curr.right == null) {
                            f.push(curr);   
                        } else if (curr.right == null) f.push(curr);

                    }
                }
            }

            f.push(root);
            while (!f.isEmpty()) {
                curr = f.pop();
                res.add(curr.val);
            }
        }
        */

