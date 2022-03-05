import java.util.HashMap;

import java.util.Map;

import java.util.ArrayList;

import java.util.List;


public class {
    public static class Solution {

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
        // // assuming the input array is sorted  O(NlogN)
        // Map<Integer, Integer> map = new HashMap<>();
        // for (int i = 0; i < nums.length; i++) {
        //     int x = nums[i];
        //     int val = bsearch(nums, target - x, i + 1);
        //     if (val > -1)
        //         return new int[] {val, i};
        // }
        // throw new IllegalArgumentException("No two sum solution");
            
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
    }
}

public static void main(String[] args){
    Solution result = new Solution();


    System.out.println(res);

        
}
    
}
