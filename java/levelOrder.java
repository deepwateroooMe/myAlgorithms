import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class levelOrder {
    public static class Solution {
        public class Oj {
            TreeNode tn;
            int i;
            public Oj(TreeNode tmp, int x) {            
                tn = tmp;
                i = x;
            }
        }

        public List<List<Integer>> levelOrder(TreeNode root) {
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
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {3, 9, 20, -1, -1, 15, 7};
        TreeNode root = new TreeNode(a[0]);
        root.buildTree(root, a);
        root.levelPrintTree(root);
        List<List<Integer>> res = result.levelOrder(root);
        System.out.println("");
        System.out.println("res.size(): " + res.size());

        for (int i = 0; i < res.size(); ++i) {
            System.out.println(res.get(i));
        }
        System.out.println("");
    }
}
