import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class searchinRotatedArray {
    public static class Solution {
        // not quite sure if this one works
        public int helper0(int [] a, int target, int start, int end) {
            if (start == end) {
                if (a[end] == target) return start;
                return -1;
            }
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (a[mid] == target) return mid;
                else if (a[mid] < target) {
                    if (target <= a[end])
                        start = mid + 1;
                    else
                        end = mid - 1;
                } else { // a[mid] > target
                    if (target >= a[start])
                        end = mid - 1;
                    else
                        start = mid + 1;
                }
            }
            System.out.println("start: " + start);
            System.out.println("end: " + end);
            if (a[end] == target) return start;
            return -1;
        }
        
        public int helper(int [] a, int target, int start, int end) {
            if (start == end - 1) {
                if (a[end] == target) return end;
                else if (a[start] == target) return start;
                return -1;
            }
            while (start < end - 1) {
                int mid1 = start + (end - start) / 2;
                int mid2 = mid1 + 1;
                if (a[mid1] == target) return mid1;
                else if (a[mid2] == target) return mid2;
                else if (a[mid1] < a[mid2]) {
                    if (target <= a[end])
                        start = mid2 + 1;
                    else
                        end = mid1 - 1;
                } else { // a[mid] > target
                    if (target >= a[start])
                        end = mid - 1;
                    else
                        start = mid + 1;
                }
            }
            System.out.println("start: " + start);
            System.out.println("end: " + end);
            if (start == end - 1) {
                if (a[end] == target) return end;
                else if (a[start] == target) return start;
                return -1;
            }
        }

        public int search(int[] A, int target) {
            if (A == null || A.length == 0) return -1;
            int start = 0;
            int end = A.length - 1;
            return helper(A, target, start, end);
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        //int [] a = {1, 3};
        int [] a = {4, 5, 6, 7, 0, 1, 2};

        int res = result.search(a, 0);
        
        System.out.println(res);
    }
}
/*
  Runtime Error Message:	Line 24: java.lang.ArrayIndexOutOfBoundsException: -1
Last executed input:	[1,3], 4
 */
