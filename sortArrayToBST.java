import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class sortArrayToBST {
    public static class Solution {
        public TreeNode sortedArrayToBST(int[] num) {
            TreeNode root = new TreeNode(num[0]);
            //root.buildTree(root, num);
            int i = 0;
            
            return root;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, 2, 3, 4, 5, 6};
        TreeNode res = result.sortedArrayToBST(a);
        res.levelPrintTree(res);
    }
}
