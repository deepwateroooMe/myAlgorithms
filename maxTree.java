import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class maxTree {
    public static class Solution {
        /**
         * @param A: Given an integer array with no duplicates.
         * @return: The root of max tree.
         */
        public TreeNode maxTree(int [] A, int bgn, int end) {
            if (bgn > end) return null;
            if (bgn == end) return new TreeNode(A[bgn]);
            if (bgn == end - 1) {
                TreeNode root = new TreeNode(A[bgn] > A[end] ? A[bgn] : A[end]);
                if (A[bgn] > A[end])
                    root.right = new TreeNode(A[end]);
                else
                    root.left = new TreeNode(A[bgn]);
                return root;
            }
            Map<Integer, Integer> m = new HashMap<Integer, Integer>();
            int max = Integer.MIN_VALUE;
            for (int i = bgn; i <= end; i++) {
                m.put(A[i], i);
                max = Math.max(max, A[i]);
            }
            TreeNode root = new TreeNode(max);
            int idx = m.get(max);
            root.left = maxTree(A, bgn, idx - 1);
            root.right = maxTree(A, idx + 1, end);
            return  root;
        }
        
        public TreeNode maxTree(int[] A) {
            Map<Integer, Integer> m = new HashMap<Integer, Integer>();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < A.length; i++) {
                m.put(A[i], i);
                max = Math.max(max, A[i]);
            }
            TreeNode root = new TreeNode(max);
            int idx = m.get(max);
            root.left = maxTree(A, 0, idx - 1);
            root.right = maxTree(A, idx + 1, A.length - 1);
            return  root;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {2, 5, 6, 0, 3, 1};
        TreeNode res = result.maxTree(a);
        res.levelPrintTree(res);
    }
}
