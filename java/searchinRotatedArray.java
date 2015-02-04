import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class searchinRotatedArray {
    public static class Solution {
        public int helper(int [] a, int target, int start, int end) {
            if (start == end) {
                if (a[end] == target) return start;
                return -1;
            } else if (start + 1 == end) {
                if (a[start] == target || a[end] == target) 
                    return a[start] == target ? start : end;
                else return -1;
            }
            // still feel confusing when headache
            while (start < end - 1) {
                int mid = start + (end - start) / 2;
                if (a[mid] == target) return mid;
                if (a[mid] > a[end]) {
                    if (a[mid] < target) start = mid + 1;
                    else { // a[mid] >= target
                        if (target <= a[end]) start = mid + 1;
                        else end = mid - 1;
                    }
                } else { // a[mid] <= a[end]
                    if (target > a[end] || (target < a[mid]))
                        end = mid - 1;
                    else 
                        start = mid + 1;
                }
            }

            if (start == end) {
                if (a[end] == target) return start;
                return -1;
            } else { 
                if (a[start] == target || a[end] == target) 
                    return a[start] == target ? start : end;
                else return -1;
            } 
        }
        public int search(int[] a, int target) {
            int bgn = 0, end = a.length;
            while (bgn < end) {
                int mid = bgn + (end - bgn) / 2;
                if (a[mid] == target) return mid;
                if (a[bgn] <= a[mid]) {
                    if (a[bgn] <= target && target < a[mid])
                        end = mid;
                    else
                        bgn = mid + 1;
                } else {
                    if (a[mid] < target && target <= a[end - 1])
                        bgn = mid + 1;
                    else
                        end = mid;
                }
            }
            return -1;
        }
        
        public int search0(int[] A, int target) {
            if (A == null || A.length == 0) return -1;
            else if (A.length == 1) return A[0] == target ? 0 : -1;
            int start = 0;
            int end = A.length - 1;
            return helper(A, target, start, end);
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        //int [] a = {4, 5, 6, 7, 0, 1, 2};
        //int [] a = {4, 5, 6, 7, 8, 1, 2, 3};
        int [] a = {3, 1};
        int val = 2;

        int res = result.search(a, val);
        System.out.println(res);
    }
}
/*
  Input:	[5,1,3], 5
  Output:	-1
  Expected:	0

  Input:	[1,3,5], 1
  Output:	-1
  Expected:	0

  Input:	[4,5,6,7,8,1,2,3], 8
  Output:	-1
  Expected:	4

  Runtime Error Message:	Line 24: java.lang.ArrayIndexOutOfBoundsException: -1
  Last executed input:	[1,3], 4
*/
