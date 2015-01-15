import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class searchRange {
    public static class Solution {
        public int searchFirsst(int [] a, int target, int start, int end) {
            if (start == end) return (a[end] == target) ? start : -1;
            if (start == end - 1) {
                if (a[start] == target) return start;
                else if (a[end] == target) return end;
                else return -1;
            }

            while (start < end - 1) {
                int mid = start + (end - start) / 2;
                if (a[mid] >= target) 
                    end = mid;
                else 
                    start = mid + 1;
            }
            if (start == end) return (a[end] == target) ? start : -1;
            if (start == end - 1) {
                if (a[start] == target) return start;
                else if (a[end] == target) return end;
                else return -1;
            }
            return -1;
        }
        
        public int searchLast(int [] a, int target, int start, int end) {
            if (start == end) return (a[end] == target) ? end : -1;
            if (start == end - 1) {
                if (a[end] == target) return end;        
                else if (a[start] == target) return start;
                else return -1;
            }

            while (start < end - 1) {
                int mid = start + (end - start) / 2;
                if (a[mid] > target) 
                    end = mid - 1;
                else 
                    start = mid;
            }
            if (start == end) return (a[end] == target) ? end : -1;
            if (start == end - 1) {
                if (a[end] == target) return end;        
                else if (a[start] == target) return start;
                else return -1;
            }
            return -1;
        }

        public int[] searchRange(int[] A, int target) {
            int [] res = new int[2];
            if (A == null || A.length == 0 ||
                (A.length == 1 && A[0] != target)) {
                res[0] = -1;
                res[1] = -1;
                return res;   
            } else if (A.length == 1) {
                res[0] = 0;
                res[1] = 0;
                return res;   
            }
            res[0] = searchFirsst(A, target, 0, A.length-1);
            res[1] = searchLast(A, target, 0, A.length-1);
            return res;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, 2, 2};
        int [] res = result.searchRange(a, 2);
        for(int i : res)
            System.out.println(i);
    }
}
