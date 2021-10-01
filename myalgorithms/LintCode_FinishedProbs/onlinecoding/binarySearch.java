import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class binarySearch {
    public static class Solution {
        /**
         * @param nums: The integer array.
         * @param target: Target to find.
         * @return: The first position of target. Position starts from 0.
         */
        public int binarySearch(int[] nums, int target) {
            if (target < nums[0] || target > nums[nums.length - 1]) return -1;
            int bgn = 0, end = nums.length - 1;
            if (bgn == end - 1) {
                if (target == nums[bgn]) return bgn;
                else if (target == nums[end]) return end;
                else return -1;
            }
            while (bgn < end - 1) {
                int mid1 = bgn + (end - bgn) / 2;
                int mid2 = mid1 + 1;
                if (target < nums[mid1]) end = mid1 - 1;
                else if (target > nums[mid2]) bgn = mid2 + 1;
                else if (target == nums[mid1]) end = mid1;
                else if (target == nums[mid2] && nums[mid1] < nums[mid2]) bgn = mid2;
            }
            if (bgn == end - 1) {
                if (target == nums[bgn]) return bgn;
                else if (target == nums[end]) return end;
                else return -1;
            } else if (bgn == end)
                return nums[bgn] == target ? bgn : -1;
            else return -1;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, 2, 3, 3, 4, 5, 10};
        int b = 3;
        int res = result.binarySearch(a, b);

        System.out.println(res);
    }
}
