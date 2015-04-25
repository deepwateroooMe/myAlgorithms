import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Arrays;

public class largestRectangleArea {
    public static class Solution {
        public int largestRectangleArea0(int[] height) {
            int n = height.length;
            int res = 0;
            int right = 0;
            int local = 0;
            int minVal = 0;
            while (right < n) {
                if (right + 1 < n && height[right + 1] >= height[right])
                    right++;
                else { // found right border
                    minVal = height[right];
                    for (int left = right; left >= 0; left--) {
                        minVal = Math.min(minVal, height[left]);
                        local = minVal * (right - left + 1);
                        res = Math.max(res, local);
                    }
                    right++;
                    local = 0;
                    minVal = 0;
                }
            }
            return res;
        }
        
        public int largestRectangleArea(int[] height) {
            Stack<Integer> s = new Stack<Integer>();
            int [] hnew = new int[height.length + 1];
            hnew = Arrays.copyOf(height, height.length + 1);
            int res = 0; 
            int tmp;     
            int left;
            for (int i = 0; i <= height.length; i++) {
                if (s.isEmpty() || hnew[i] > hnew[s.peek()]) s.push(i);
                else {
                    tmp = s.pop();
                    res = Math.max(res, hnew[tmp] * 
                                   (s.isEmpty() ? i : i - s.peek() - 1));
                    i--;
                }
            }
            return res;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1};
        int res = result.largestRectangleArea(a);
        
        System.out.println(res);
    }
}
/*
  Input:	[2,1,2]
Output:	2
Expected:	3
*/
