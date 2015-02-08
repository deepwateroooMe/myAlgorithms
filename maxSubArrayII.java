import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class maxSubArrayII {
    public static class Solution {
        /**
         * @param nums: A list of integers
         * @return: A integer indicate the sum of max subarray
         */
        // may need to do the other direction around, max rit-->left, min left-->rit
       public int maxTwoSubArrays(ArrayList<Integer> nums) {
            int n = nums.size();
            int [][] max = new int[2][n];
            max[0][0] = nums.get(0);
            max[1][0] = nums.get(0);
            int [][] min = new int[2][n];
            min[0][n - 1] = nums.get(n - 1); 
            min[1][n - 1] = nums.get(n - 1);
           int res = Integer.MIN_VALUE;
            for (int i = 1; i < n; i++) {
                max[0][i] = Math.max(nums.get(i), max[0][i - 1] + nums.get(i));
                max[1][i] = Math.max(max[0][i], max[1][i - 1]);
            }
            for (int i = n - 2; i > 0; i--) {
                min[0][i] = Math.max(nums.get(i), min[0][i + 1] + nums.get(i));
                min[1][i] = Math.max(min[0][i], min[1][i + 1]);
                int tmp = Math.max(max[1][i] + min[1][i + 1],
                                   max[1][i - 1] + min[1][i]);
                res = Math.max(res, tmp);
            }
            res = Math.max(res, max[1][0] + min[1][1]);
            return res;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        Integer [] a = {-1, -1};
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (Integer i : a) {
            nums.add(i);
        }
        int res = result.maxTwoSubArrays(nums);
        System.out.println(res);
    }
}
