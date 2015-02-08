import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class minSubArray {
    public static class Solution {
        /**
         * @param nums: A list of integers
         * @return: A integer indicate the sum of min subarray
         */
        public int minSubArray(ArrayList<Integer> nums) {
            int n = nums.size();
            int [] res = new int[n];
            res[0] = nums.get(0);
            int result = res[0];
            for (int i = 1; i < n; i++) {
                res[i] = Math.min(nums.get(i), res[i - 1] + nums.get(i));
                result = Math.min(result, res[i]);
            }
            return result;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        Integer [] a = {1, -1, -2, 1};
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (Integer i : a) {
            nums.add(i);
        }
        int res = result.minSubArray(nums);
    
        System.out.println(res);
    }
}
