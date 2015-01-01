import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class findPeakElement {
    public static class Solution {
        public int helper(int[] num, int start, int end) {
            if (start == end) {
                return start;
            }

            int mid = start + (end - start) / 2;
            int mid2 = mid + 1;
            if (num[mid] > num[mid2]) {
                return helper(num, start, mid);
            } else {
                return helper(num, mid2, end);
            }
        }
        
        public int findPeakElement(int[] num) {
            if (num == null) {
                return 0;   
            }
            int n = num.length;
            if (n == 1) {
                return 0;
            }
            return helper(num, 0, num.length-1);
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int[] arr = {2, 1};
        int res = result.findPeakElement(arr);
        System.out.println(res);
    }
}
