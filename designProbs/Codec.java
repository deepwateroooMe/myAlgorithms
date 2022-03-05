import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;

public class Codec {

    // // Encodes a tree to a single string.
    // public String serialize(TreeNode root) {
        
    // }

    // // Decodes your encoded data to tree.
    // public TreeNode deserialize(String data) {
        
    // }
    
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        if (root == null) return res.toString();
        TreeNode p = root;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(p);
        res.append(p.val + ", ");
        while (!q.isEmpty()) {
            p = q.poll();
            if (p.left != null) {
                q.add(p.left);
                res.append(p.left.val + ", ");
            } else {
                res.append("#, ");
            }
            if (p.right != null) {
                q.add(p.right);
                res.append(p.right.val + ", ");
            } else {
                res.append("#, ");
            }
        }
        return res.toString();
    }

    private  List<Integer> deserializeToArray(String data) {
        List<Integer> l = new ArrayList<>();
        int n = data.length();
        int j = data.charAt(0) == '-' ? 1 : 0, i = 0;
        while (j < n) {
            while (j < n && (Character.isDigit(data.charAt(j)) || data.charAt(j) == '-')) j++;
            System.out.println("j: " + j);
            if (j > i && j < n) {
                // System.out.println("Integer.parseInt(data.substring(0, j): " + Integer.parseInt(data.substring(0, j)));
                l.add(Integer.parseInt(data.substring(i, j)));
                // System.out.println("");
                // System.out.println("l.size(): " + l.size());
                // for ( i = 0; i < l.size(); ++i) 
                // System.out.print(l.get(i) + ", ");
                // System.out.println("");
                if (j == n) return l;
            }
            if (data.charAt(j) == '#') {
                l.add(-1111);
                ++j;
            }
            while (j < n && data.charAt(j) != '-' && data.charAt(j) != '#' && !Character.isDigit(data.charAt(j))) j++;
            if (j == n) return l;
            // System.out.println("j: " + j);
            i = j;
            System.out.println("i: " + i);
        }
        // System.out.println("(l == null): " + (l == null));
        // System.out.println("");
        // System.out.println("l.size(): " + l.size());
        // for ( i = 0; i < l.size(); ++i) 
        //     System.out.print(l.get(i) + ", ");
        // System.out.println("");
        return l;
    }
    
    public TreeNode deserialize(String data) {
        int n = data.length();
        if (data == null || data.length() == 0) return null;
        
        List<Integer> l = deserializeToArray(data);
        int i = 0;
        TreeNode root = new TreeNode(l.get(0));
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode p = root, tmp;
        q.add(p);
        while (!q.isEmpty() && i < l.size()) {
            p = q.poll();
            ++i;
            // System.out.println("\np.val: " + p.val);
            // System.out.println("i: " + i);
            // System.out.println("l.get(i): " + l.get(i));
            
            if (i % 2 == 1) {
                if (l.get(i) == -1111) p.left = null;
                else {
                    tmp = new TreeNode(l.get(i));
                    p.left = tmp;
                    q.add(tmp);
                }
            }
            ++i;
            if (i % 2 == 0) {
                if (l.get(i) == -1111) p.right = null;
                else {
                    tmp = new TreeNode(l.get(i));
                    p.right = tmp;
                    q.add(tmp);
                }
            }
        }
        return root;
    }
    
    public static void main(String[] args) {
        int [] a = new int [] {1, 2};
        
        TreeNode root = new TreeNode(a[0]);
        root.buildTree(root, a);
        root.levelPrintTree(root);

        Codec ser = new Codec();
        Codec deser = new Codec();

        String tmp = ser.serialize(null);
        System.out.println("res: " + tmp);
        
        TreeNode res = deser.deserialize(ser.serialize(root));
        res.levelPrintTree(res);
    }
}