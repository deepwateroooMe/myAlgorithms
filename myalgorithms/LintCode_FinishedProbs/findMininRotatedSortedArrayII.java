import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class findMininRotatedSortedArrayII {
    public static class Solution {
        /**
         * @param num: a rotated sorted array
         * @return: the minimum number in the array
         */
        public int findMin(int[] num) {
            int n = num.length;
            if (n == 1) return num[0];
            if (n == 2) return Math.min(num[0], num[1]);
            int bgn = 0, end = n - 1;
            while (bgn < end) {
                int mid = bgn + (end - bgn) / 2;
                if (num[mid] < num[bgn] && num[bgn] >= num[end])
                    end = mid;
                else if (num[mid] > num[end])
                    bgn = mid + 1;
                else if (num[mid] < num[end]) {
                    if (num[end] < num[bgn])
                        bgn = mid + 1;
                    else end = mid;
                } else if (num[mid] == num[end]) {
                    if (num[bgn] != num[end]) {
                        end = mid;
                    } else {
                        int i = mid + 1;
                        while (i < end && num[i] == num[i - 1]) i++;
                        if (i == end) end = mid - 1;
                        else bgn = mid + 1;
                    }
                }
            }
            return num[bgn];
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {4, 4, 5, 6, 7, 0, 1, 2};
        int res = result.findMin(a);
        
        System.out.println(res);
    }
}
