import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class maxSubArray {
    public static class Solution {
        /**
         * @param nums: A list of integers
         * @return: A integer indicate the sum of max subarray
         */
        public int maxSubArray(ArrayList<Integer> nums) {
            int n = nums.size();
            int [] res = new int[n];
            res[0] = nums.get(0);
            int result = res[0];
            for (int i = 1; i < n; i++) {
                res[i] = Math.max(nums.get(i), res[i - 1] + nums.get(i));
                result = Math.max(result, res[i]);
            }
            return result;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        Integer [] a = {-2, 2, -3, 4, -1, 2, 1, -5, 3};
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (Integer i : a) {
            nums.add(i);
        }
        int res = result.maxSubArray(nums);
    
        System.out.println(res);
    }
}
