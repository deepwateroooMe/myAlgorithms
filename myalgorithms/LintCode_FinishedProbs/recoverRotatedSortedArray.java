import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


public class recoverRotatedSortedArray {
    public static class Solution {
        /**
         * @param nums: The rotated sorted array
         * @return: The recovered sorted array
         */
        public int getMinIdx(ArrayList<Integer> a) {
            int n = a.size();
            if (n == 1) return 0;
            if (n == 2) return a.get(0) < a.get(1) ? 0 : 1;
            int bgn = 0, end = n - 1;
            while (bgn < end - 1) {
                int mid = bgn + (end - bgn) / 2;
                if (a.get(mid) < a.get(bgn) && a.get(bgn) > a.get(end))
                    end = mid;
                else if (a.get(mid) > a.get(bgn) && a.get(bgn) > a.get(end))
                    bgn = mid + 1;
                else if (a.get(mid) > a.get(bgn) && a.get(bgn) < a.get(end))
                    end = mid - 1;
            }
            if (bgn == end) return bgn;
            if (bgn == end - 1) return a.get(bgn) < a.get(end) ? bgn : end;
            return -1;
        }
        
        public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
            int n = nums.size();
            int tmp = 0;
            if (n < 2) return;
            if (n == 2) {
                if (nums.get(0) > nums.get(0)) {
                    tmp = nums.get(0);
                    nums.set(0, nums.get(1));
                    nums.set(1, tmp);
                }
                return;
            }
            int i = 0, j = getMinIdx(nums);
            if (j == 0) return;
            int cnt = n - j;
            while (cnt > 0) {
                tmp = nums.get(n - 1);
                nums.remove(n - 1);
                nums.add(0, tmp);
                --cnt;
            }
            return;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        Integer [] a = {3, 4, 5, 6, 1, 2};
        ArrayList<Integer> res = new ArrayList<Integer>(Arrays.asList(a));
        result.recoverRotatedSortedArray(res);
        System.out.println("");
        for (int i = 0; i < res.size(); ++i) {
            System.out.println(res.get(i));
        }
        System.out.println("");
    }
}
