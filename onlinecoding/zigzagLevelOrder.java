import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class zigzagLevelOrder {
    public static class Solution {
        /**
         * @param root: The root of binary tree.
         * @return: A list of lists of integer include 
         *          the zigzag level order traversal of its nodes' values 
         */
        public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
            ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
            if (root == null) return  res;
            Queue<TreeNode> q = new LinkedList<TreeNode>();
            q.add(null);
            q.add(root);
            TreeNode curr = root;
            TreeNode prev = null;
            int n = 0;
            int cnt = 0;
            while (!q.isEmpty()) {
                prev = curr;
                curr = q.poll();
                if (curr == null) {
                    if (prev != curr) {
                        res.add(new ArrayList<Integer>());
                        q.add(curr);
                        ++cnt;
                        continue;
                    } else {
                        res.remove(res.size() - 1);
                        return res;   
                    }
                }
                if (curr != null) {
                    n = res.size() - 1;
                    if (cnt % 2 == 1)
                        res.get(n).add(curr.val);
                    else
                        res.get(n).add(0, curr.val);
                    if (curr.left != null) q.add(curr.left);
                    if (curr.right != null) q.add(curr.right);
                }
            }
            return res;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {3, 9, 20, -1, -1, 15, 7};
        TreeNode root = new TreeNode(a[0]);
        root.buildTree(root, a);
        root.levelPrintTree(root);
        ArrayList<ArrayList<Integer>> res = result.zigzagLevelOrder(root);
        System.out.println("res.size(): " + res.size());
        System.out.println("");
        for (int i = 0; i < res.size(); ++i) {
            System.out.println(res.get(i));
        }
        System.out.println("");
    }
}
