import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class postorderTraversal {
    public static class Solution {
        public List<Integer> postorderTraversal0(TreeNode root) {
            // get preorder results first, no no no no, root, right, left
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
                    curr = curr.right;
                }
                if (!s.isEmpty()) {
                    curr = s.pop();
                    curr = curr.left;
                } 
            }
            /*
            System.out.println("");
            for (int i = 0; i < res.size(); ++i) {
                System.out.print(res.get(i) + ", ");
            }
            System.out.println("");
            */
            List<Integer> result = new ArrayList<Integer>();
            for (int i = res.size() - 1; i >= 0; i--) {
                result.add(res.get(i));
            }
            return result;
        }

        public List<Integer> postorderTraversal1(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            TreeNode prev= null; 
            TreeNode curr= root; 
            Stack<TreeNode> s = new Stack<TreeNode>();
            do {
                while (curr != null) {
                    s.push(curr);
                    curr = curr.left;
                }
                prev = null;
                while (!s.isEmpty()) {
                    curr = s.pop();
                    if (curr.right == prev) {
                        res.add(curr.val);
                        prev = curr;
                    } else {
                        s.push(curr);
                        curr = curr.right;
                        break;
                    }
                }
            } while (!s.isEmpty());
            return res;
        }

        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            

        }
        
    }
    
    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, 2};
        TreeNode root = new TreeNode(a[0]);
        root.buildTree(root, a);
        root.levelPrintTree(root);
        //root.postorderPrintTree(root);
        
        List<Integer> res = result.postorderTraversal(root);
        System.out.println("");
        for (int i = 0; i < res.size(); ++i) {
            System.out.print(res.get(i) + ", ");
        }
        System.out.println("");

    }
}
/*
  Input:	{1,2}
Output:	[2,1]
Expected:	[1,2]

Input:	{3,1,2}
Output:	[2,1,3]
Expected:	[1,2,3]
 */
