import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class findPeak {
    public static class Solution {
        /**
         * @param A: An integers array.
         * @return: return any of peek positions.
         */
        public int findPeak(int[] a) {
            int n = a.length;
            if (n < 3) return -1;
            if (n == 3) return (a[0] < a[1] && a[1] > a[2]) ? 1 : -1;
            int bgn = 0, end = n - 1;
            while (bgn < end) {
                int mid = bgn + (end - bgn) / 2;
                if (a[mid] > a[mid - 1] && a[mid] > a[mid + 1]) return mid;
                if (a[mid] > a[mid - 1]) bgn = mid;
                else end = mid;
            }
            return bgn;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, 2, 1, 3, 4, 5, 7, 6};
        int res = result.findPeak(a);

        System.out.println(res);
    }
}
