import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class searchinRotatedArrayDupII {
    public static class Solution {
        public boolean helper(int [] a, int target, int start, int end) {
            if (start == end) {
                if (a[end] == target) return true;
                return false;
            } else if (start + 1 == end) {
                if (a[start] == target || a[end] == target) 
                    return true;
                else return false;
            }

            while (start < end - 1) {
                int mid = start + (end - start) / 2;
                if (a[mid] == target) return true;
                if (a[mid] > a[end]) {
                    if (a[end] < a[start]) {
                        if (target > a[mid] || target <= a[end]) start = mid + 1;
                        else end = mid - 1;
                    } else { //if (a[end] == a[start]) {
                        if (target > a[mid] || target < a[end]) start = mid + 1;
                        else end = mid - 1;
                    } 
                } else if (a[mid] < a[end]) {
                    if (target > a[mid] && target <= a[end])
                        start = mid + 1;
                    else end = mid - 1;
                } else { // a[mid] == a[end] 
                    if (a[start] > a[end]) 
                        end = mid - 1;
                    else if (a[start] < a[end]) {
                        if (target > a[end] || target < a[start]) return false;
                        end = mid - 1;
                        //mid = end - 1;
                    } else if (a[start] == a[end]) {
                        for (int i = mid + 1; i < end ; i++) {
                            if (a[i] == target) return true;
                        }
                        end = mid - 1;
                    }
                }
            }

            if (start == end) {
                if (a[end] == target) return true;
                return false;
            } else { 
                if (a[start] == target || a[end] == target) 
                    return true;
                else return false;
            } 
        }

        public boolean search(int[] A, int target) {
            if (A == null || A.length == 0) return false;
            else if (A.length == 1) return A[0] == target ? true : false;
            int start = 0;
            int end = A.length - 1;
            if (target == A[0] || target == A[end]) return true;
            return helper(A, target, start, end);
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {3,3,3,3,4,4,4,4,5,5,5,6,6,6,6,6,6,7,7,8,8,8,8,8,8,8,8,9,9,10,10,10,10,10,-10,-10,-9,-9,-9,-9,-9,-9,-9,-9,-9,-8,-8,-8,-8,-8,-8,-7,-7,-7,-6,-6,-6,-6,-6,-6,-6,-6,-6,-6,-5,-5,-5,-5,-5,-5,-4,-4,-4,-4,-4,-3,-3,-2,-2,-2,-2,-1,-1,-1,-1,-1,-1,0,0,0,1,1,1,1,1,1,2,2,2,2};
        int val = 10;

        boolean res = result.search(a, val);
        System.out.println(res);
    }
}

/* // when headache should NOT work on this one !!!
   /*
   Input:	[3,3,3,3,4,4,4,4,5,5,5,6,6,6,6,6,6,7,7,8,8,8,8,8,8,8,8,9,9,10,10,10,10,10,-10,-10,-9,-9,-9,-9,-9,-9,-9,-9,-9,-8,-8,-8,-8,-8,-8,-7,-7,-7,-6,-6,-6,-6,-6,-6,-6,-6,-6,-6,-5,-5,-5,-5,-5,-5,-4,-4,-4,-4,-4,-3,-3,-2,-2,-2,-2,-1,-1,-1,-1,-1,-1,0,0,0,1,1,1,1,1,1,2,2,2,2], 10
Output:	false
Expected:	true

  Time Limit ExceededMore Details 
Last executed input:	[1,2,2,2,0,1,1], 0

  Input:	[0,0,1,1,2,0], 2
Output:	false
Expected:	true

  Input:	[4,5,6,7,0,1,2], 6
Output:	false
Expected:	true

 Time Limit ExceededMore Details 
Last executed input:	[0,2,2], -1

   Time Limit ExceededMore Details 
Last executed input:	[1,2,2,2,0,1,1], 0

   Time Limit ExceededMore Details 
Last executed input:	[0,2,2], 0

  Time Limit ExceededMore Details 
Last executed input:	[0,2,2], 3

  Time Limit ExceededMore Details 
Last executed input:	[3,1,1], 0

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
