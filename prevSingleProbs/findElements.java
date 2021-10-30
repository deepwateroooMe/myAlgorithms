import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;

class findElements {

    private HashSet<Integer> v;
    
    private void bfsTraverseTreeRecover(TreeNode r) { // dfs ? Stack dfs
        Stack<TreeNode> s = new Stack<TreeNode>();
        r.val = 0;
        v.add(r.val);
        TreeNode p = r;
        s.push(p);
        while (!s.isEmpty()) {
            p = s.pop();
            v.add(p.val);
            if (p.left != null) {
                p.left.val = 2 * p.val + 1;
                s.push(p.left);
            }
            if (p.right != null) {
                p.right.val = 2 * p.val + 2;
                s.push(p.right);
            }
        }
    }
    
    public findElements(TreeNode root) {
        v = new HashSet<Integer>();
        bfsTraverseTreeRecover(root);
    }
    
    public boolean find(int target) {
        if (v.contains(target)) return true;
        return false;
    }

    public static void main(String[] args) {

        int [] a = new int [] {0 ,0 ,0 ,0 ,0};
        TreeNode root = new TreeNode(a[0]);
        root.buildTree(root, a);
        root.levelPrintTree(root);

        findElements s = new findElements(root);

        boolean res1 = s.find(1);
        boolean res2 = s.find(3);
        System.out.println("res1: " + res1);
        System.out.println("res2: " + res2);
    }
    
}

// public class findElements {
//     public static class Solution {
//     }
// }