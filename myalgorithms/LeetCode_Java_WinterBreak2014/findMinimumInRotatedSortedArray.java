import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class findMinimumInRotatedSortedArray {
    public static class Solution {
        public  int helper(int[] num, int start, int end) {
            if (start == end)  {
                return num[start];
            }
            int mid = start + (end - start) / 2;
            if (num[mid] > num[end]) {
                return helper(num, mid+1, end);
            } else {  // sure on the left ? could be equal
                return helper(num, start, mid);
            }
        }
        public int findMin(int[] num) {
            if (num.length == 1) {
                return num[0];
            }
            return helper(num, 0, num.length-1);
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {5, 6, 7, 0, 1, 2, 4};
        int res = result.findMin(a);
        
        System.out.println(res);
    }
}
