import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class preorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    public static TreeNode TreeNode(int x) {
        TreeNode res = new TreeNode(-1);
        res.val = x;
        res.left = null;
        res.right = null;
        return res;
    }

    public static class Solution {
        // recursive method first
        public void preorderTraversalHelper(preorderTraversal.TreeNode root, List<Integer> res) {
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

        // iterative method: use a stack<TreeNode> right, left, root order
        public void preorderTraversalIter(preorderTraversal.TreeNode root, List<Integer> res) {       
            Stack<preorderTraversal.TreeNode> stack = new Stack<TreeNode>();
            Stack<preorderTraversal.TreeNode> fstack = new Stack<TreeNode>();
            stack.push(root);
            TreeNode prev = root;
            TreeNode curr = root.right;
            while (!stack.isEmpty()) {
                while (curr != null) {
                    stack.push(curr);
                    prev = curr;
                    curr = curr.right;
                } // curr == null
                while (!stack.isEmpty()) { // how to deal with left hand side ?
                    curr = stack.pop();
                    if (curr.left != null) {
                        stack.push(curr);
                        prev = curr;
                        curr = curr.right;
                        //fstack.push(curr.left); // put in final stack
                    }
                    fstack.push(curr);
                }
            }
            while (!fstack.isEmpty()) {
                curr = fstack.pop();
                res.add(curr.val);
            }
        }
        
        public List<Integer> preorderTraversal(preorderTraversal.TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            if (root == null) {
                return res;
            }
            //preorderTraversalHelper(root, res);
            preorderTraversalIter(root, res);
            return res;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        TreeNode one = TreeNode(2);
        TreeNode one2 = TreeNode(3);
        TreeNode one3 = TreeNode(1);
        //TreeNode one4 = TreeNode(4);
        one.left = one2;
        one2.left = one3;
        //one3.next = one4;

        List<Integer> res = new ArrayList<Integer>();
        res = result.preorderTraversal(one);
        for(Integer i : res) {
            System.out.println(i);
            
        }
    }
}
