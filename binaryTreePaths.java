Seaimport com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class binaryTreePaths {
    public static class Solution {

        public List<String> binaryTreePaths(TreeNode root) {

            
        }
        
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int [] a = new int [] {1, 2, 3, -1, 5};
        TreeNode root = new TreeNode(a[0]);
        root.buildTree(root, a);
        root.levelPrintTree(root);

        TreeNode res = s.binaryTreePaths(root4);
        res.levelPrintTree(res);
    }
}