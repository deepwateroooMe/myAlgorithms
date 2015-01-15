import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class sumNumbers {
    public static class Solution {
        public int sumNumbers(TreeNode root) {
            if (root == null) return 0;
            if ()
            int result = 0;
            
            return result;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, 2, 3};
        TreeNode root = new TreeNode(a[0]);
        root.buildTree(root, a);
        root.levelPrintTree(root);
        int res = result.sumNumbers(root);
        
        System.out.println(res);
    }
}
