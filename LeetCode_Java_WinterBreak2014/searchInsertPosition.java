import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class searchInsertPosition {
    public static class Solution {
        public int helper(int [] a, int target, int start, int end) {
            if (start == end) {
                if (a[end] >= target) return start;
                else if (a[end] < target) return end + 1;
            }
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (a[mid] == target)
                    end = mid;
                else if (a[mid] < target && a[mid + 1] > target)
                    return mid + 1;
                else if (a[mid] < target)
                    start = mid + 1;
                else if (a[mid] > target && a[mid - 1] < target)
                    return mid;
                else // a[mid] > target
                    end = mid - 1;
            }
            if (start == end) {
                if (a[end] >= target) return start;
                else if (a[end] < target) return end + 1;
            }
            return -1;
        }
        
        public int searchInsert(int[] A, int target) {
            if (A == null || A.length == 0 || target <= A[0]) return 0;
            if (target > A[A.length - 1]) return A.length;
            return helper(A, target, 0, A.length - 1);
        }

        public int searchInsert(int[] a, int target) {
            int bgn = 0, end = a.length - 1;
            while (bgn <= end) {
                int mid = bgn + (end - bgn) / 2;
                if (a[mid] ==  target) return mid;
                if (mid > bgn && a[mid] > target && a[mid - 1] < target) return mid;
                if (a[mid] > target)
                    end = mid - 1;
                else
                    bgn = mid + 1;
            }
            return bgn;
        }

    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, 3, 5, 6};
        int res = result.searchInsert(a, 2);

        System.out.println(res);
    }
}
