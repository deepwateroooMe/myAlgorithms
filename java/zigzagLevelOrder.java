import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;

public class zigzagLevelOrder {
    public static class Solution {
        public class Oj {
            TreeNode tn;
            int i;
            public Oj(TreeNode tmp, int x) {            
                tn = tmp;
                i = x;
            }
        }

        public List<List<Integer>> zigzagLevelOrder0(TreeNode root) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            List<Integer> tmp = new ArrayList<Integer>();
            if (root == null) return res;
            else if (root.left == null && root.right == null) {
                tmp.add(root.val);
                res.add(tmp);
                return res;
            }
            
            int cnt = 1, old = 1;
            Queue<Oj> q = new LinkedList<Oj>();
            Oj one = new Oj(root, cnt);
            q.add(one);
            TreeNode curr = null;
            while (!q.isEmpty()) {
                one = q.remove();
                curr = one.tn;
                cnt = one.i;
                if (cnt == old) 
                    if (cnt % 2 == 0)
                        tmp.add(0, curr.val);                        
                    else
                        tmp.add(curr.val);                        
                else {
                    old = cnt;
                    ++cnt;
                    res.add(tmp);
                    tmp = new ArrayList<Integer>();
                    tmp.add(curr.val);
                }
                if (curr.left != null) 
                    q.add(new Oj(curr.left, one.i + 1));
                if (curr.right != null)
                    q.add(new Oj(curr.right, one.i + 1));
            }
            if (res.get(res.size() - 1) != tmp && tmp.size() != 0) 
                res.add(tmp);                
            return res;
        }

        public void traverse(TreeNode root, int level,
                             List<List<Integer>> res, boolean lefttoright) {
            if (root == null) return;
            if (level > res.size())
                res.add(new ArrayList<Integer>());
            if (lefttoright)
                res.get(level - 1).add(root.val);
            else
                res.get(level - 1).add(0, root.val);
            traverse(root.left, level + 1, res, !lefttoright);
            traverse(root.right, level + 1, res, !lefttoright);
        }
        
        public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            traverse(root, 1, res, true);
            return res;
        }

        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            if (root == null) return res;
            Queue<TreeNode> q = new LinkedList<TreeNode>();
            boolean lefttoright = true;
            List<Integer> level = new ArrayList<Integer>();
            q.add(root);
            q.add(null);      // level separator
            while (!q.isEmpty()) {
                TreeNode curr = q.poll();
                if (curr != null) {
                    level.add(curr.val);
                    if (curr.left != null) q.add(curr.left);
                    if (curr.right != null) q.add(curr.right);
                } else {
                    if (lefttoright) {
                        res.add(level);
                    } else {
                        Collections.reverse(level);
                        res.add(level);
                    }
                    level = new ArrayList<Integer>();
                    lefttoright = !lefttoright;
                    if (q.size() > 0) q.add(null);
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
        List<List<Integer>> res = result.zigzagLevelOrder(root);
        System.out.println("");
        System.out.println("res.size(): " + res.size());

        for (int i = 0; i < res.size(); ++i) {
            System.out.println(res.get(i));
        }
        System.out.println("");
    }
}
