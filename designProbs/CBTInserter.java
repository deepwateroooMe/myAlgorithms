import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;

public class CBTInserter {

    private Queue<TreeNode> q;
    private TreeNode rootOri, curr;
    
    public CBTInserter(TreeNode root) {
        q = new LinkedList<TreeNode>();
        if (root == null) return;
        rootOri = root;
        TreeNode p = root;
        curr = p;
        if (p.left != null) q.add(p.left);
        if (p.right != null) q.add(p.right);
        curr = p;
        while (p.left != null && p.right != null) {
            p = q.poll();
            if (p.left != null) q.add(p.left);
            if (p.right != null) q.add(p.right);
        }
        if (p.left == null || p.right == null)
        curr = p;
    }
    
    public int insert(int v) {
        if (rootOri == null) {
            rootOri = new TreeNode(v);
            q.add(rootOri);
            curr = rootOri;
            return rootOri.val;
        }
        TreeNode p = null;
        if (curr.left == null) {
            TreeNode tmp = new TreeNode(v);
            curr.left = tmp;
            q.add(tmp);
            p = curr;
            return p.val;
        } else if (curr.right == null) {
            TreeNode tmp = new TreeNode(v);
            curr.right = tmp;
            q.add(tmp);
            p = curr;
            curr = q.poll();
            return p.val;
        }
        return -1;
    }
    
    public TreeNode get_root() {
        return rootOri;
    }

    
    public static void main(String[] args) {

        // int [] a = new int [] {1}; 
        int [] a = new int [] {1, 2}; 
        // int [] a = new int [] {1, 2, 3, 4, 5, 6}; 

        TreeNode root = new TreeNode(a[0]);
        root.buildTree(root, a);
        root.levelPrintTree(root);
        CBTInserter s = new CBTInserter(root);

        // int r = s.insert(2);
        // System.out.println("r: " + r);
        
        int r1 = s.insert(3);
        System.out.println("r1: " + r1);

        int r2 = s.insert(4);
        System.out.println("r2: " + r2);
        
        
        TreeNode res = s.get_root();
        res.levelPrintTree(res);
    }
}