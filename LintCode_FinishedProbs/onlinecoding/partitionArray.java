import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class partitionArray {
    public static class Solution {
        /** 
         *@param nums: The integer array you should partition
         *@param k: As description
         *return: The index after partition
         */
        public int partitionArray(ArrayList<Integer> nums, int k) {
            int n = nums.size();
            if (n == 0) return 0;
            int i = 0, j = n - 1;
            while (i < j) {
                while (j >= 0 && nums.get(j) >= k) j--;
                while (i < n && nums.get(i) < k) i++;
                if (i == n) return n;
                if (j == -1) return 0;
                else if (i < j) {
                    int tmp = nums.get(i);
                    nums.set(i++, nums.get(j));
                    nums.set(j--, tmp);
                }
            }
            System.out.println(nums);
            return i;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        Integer [] a = {9,9,9,8,9,8,7,9,8,8,8,9,8,9,8,8,6,9};
        int k = 9;
        int res = result.partitionArray(new ArrayList<Integer>(Arrays.asList(a)), k);
        System.out.println(res);
    }
}
