import java.util.HashMap;

import java.util.Map;

import java.util.ArrayList;

import java.util.List;


public class {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static class Solution {
        private boolean bsearch(TreeNode root, int target) {
            if (root.val = target) return true;
            else if (root.val > target) {
                if (root.left != null)
                return bsearch(root.left, target);
                else return false;
            } else if (root.val < target) {
                if (root.right != null)
                return bsearch(root.right, target);
                else return false;
            }
        }
 
        private void getBSTTreeSize(TreeNode root, int cnt) { // int address
            if (root.left == null && root.right == null) return cnt;
            else if (root.left == null) return getBSTTreeSize(root.right, cnt + 1);
            else if (root.right == null) return  getBSTTreeSize(root.left, cnt + 1);
            else return getBSTTreeSize(root.left, cnt + 1) + getBSTTreeSize(root.right, cnt + 1);
            if (root.left != null)
            
        }
        private int [] inOrderTraverseBST(TreeNode root) {
            int i = 1;
            int size = getBSTTreeSize(root, i);
            
            int [] 
        }
        public boolean findTarget(TreeNode root, int k) {
            
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int x = nums[i];
                int val = bsearch(nums, target - x, i + 1);
                if (val > -1)
                return new int[] {val, i};
            }
            throw new IllegalArgumentException("No two sum solution");

        }

        // // for regular array, input array is not sorted
        // Map<Integer, Integer> map = new HashMap<>();
        // for (int i = 0; i < nums.length; i++) {
        //     int x = nums[i];
        //     if (map.containsKey(target - x)) {
        //         return new int[] {map.get(target - x) + 1, i + 1};
        //     }
        //     map.put(x, i);
        // }
        // throw new IllegalArgumentException("No two sum solution");

        private int bsearch(int [] A, int key, int start) {
            int L = start, R = A.length - 1;
            while (L < R) {
                int M = (L + R) / 2;
                if (A[M] < key) {
                    L = M + 1;
                } else
                R = M;
            }
            return (L == R && A[L] == key) ? L : -1;
        }
        public int[] twoSum(int[] nums, int target) {
            // int length = nums.length;
            int i = 0, j = nums.length - 1;
            // for (int i = 0, j = length - 1; i < length, j > 0; ) {
            while (i < j) {
                if (nums[i] + nums[j] > target)
                j--;
                else if (nums[i] + nums[j] < target)
                i++;
                else
                return new int[] {i, j};
            }
            throw new IllegalArgumentException("No two sum solution");
            
        } 

        
    }

    public static void main(String[] args){
        Solution result = new Solution();


        System.out.println(res);

        
    }
    
}
