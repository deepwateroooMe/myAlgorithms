import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class sortArrayToBST {
    public static class Solution {
        public TreeNode createMyTree(int [] num, int bgn, int end) {
            TreeNode root = null;
            if (bgn == end) {
                root = new TreeNode(num[end]);
                return root;
            }
            if (bgn < end) {
                int mid = bgn + (end - bgn) / 2;
                root = new TreeNode(num[mid]);
                root.left = createMyTree(num, bgn, mid - 1);
                root.right = createMyTree(num, mid + 1, end);
                return root;
            }
            return null;
        }
        
        public TreeNode sortedArrayToBST(int[] num) {
            if (num == null || num.length == 0) return null;
            TreeNode root = createMyTree(num, 0, num.length - 1);
            return root;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, 2, 3, 4, 5, 6};
        TreeNode res = result.sortedArrayToBST(a);
        //res.levelPrintTree(res);
        res.inOrderPrintTree(res);

    }
}
