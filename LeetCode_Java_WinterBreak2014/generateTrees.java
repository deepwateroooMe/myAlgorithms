import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class generateTrees {
    public static class Solution {
        public List<TreeNode> helper(int bgn, int end) {
            List<TreeNode> res = new ArrayList<TreeNode>();
            if (bgn > end) {
                res.add(null);  // important
                return res;
            }

            List<TreeNode> left = null;
            List<TreeNode> right = null;
            TreeNode root = null;
            for (int i = bgn; i <= end ; i++) {
                left = helper(bgn, i - 1);
                right = helper(i + 1, end);
                for (int j = 0; j < left.size(); j++) {
                    for (int k = 0; k < right.size(); k++) {
                        root = new TreeNode(i);
                        root.left = left.get(j);
                        root.right = right.get(k);
                        res.add(root);
                        root = null;
                    }
                }
                left = null;
                right = null;
            }
            return res;
        }
        
        public List<TreeNode> generateTrees(int n) {
            return helper(1, n);
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int n = 3;
        List<TreeNode> res = result.generateTrees(n);

        System.out.println("res.size(): " + res.size());
        System.out.println("");
        for (int i = 0; i < res.size(); ++i) {
            res.get(i).levelPrintTree(res.get(i));
            //res.get(i).levelOrderPrintTree(res.get(i));
        }
        System.out.println("");
    }
}
