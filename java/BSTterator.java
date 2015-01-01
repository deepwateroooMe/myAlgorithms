import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BSTterator {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static class Solution {

        // https://oj.leetcode.com/discuss/20001/my-solutions-in-3-languages-with-stack
        public class BSTIterator {
            private Stack<TreeNode> stack = new Stack<TreeNode>();

            public BSTIterator(TreeNode root) {
                pushAll(root);
            }

            /** @return whether we have a next smallest number */
            public boolean hasNext() {
                return !stack.isEmpty();
            }

            /** @return the next smallest number */
            public int next() {
                TreeNode tmpNode = stack.pop();
                pushAll(tmpNode.right);
                return tmpNode.val;
            }

            private void pushAll(TreeNode node) {
                for(; node != null; stack.push(node), node = node.left);
            }
        }

        /**
         * Your BSTIterator will be called like this:
         * BSTIterator i = new BSTIterator(root);
         * while (i.hasNext()) v[f()] = i.next();
         */
    };

    public static void main(String[] args){
        Solution result = new Solution();
        System.out.println(result);
    }
}
