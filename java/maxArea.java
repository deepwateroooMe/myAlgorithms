import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class maxArea {
    public static class Solution {
        public int maxArea(int[] height) {
            if (height == null || height.length < 2) return 0;
            int i = 0;
            int j = height.length - 1;
            int res = 0;
            while (i < j) {
                res = Math.max(res,  Math.min(height[i], height[j]) * (j - i));
                if ( height[i] < height[j]) i++;
                else j--;
            }
            return res;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, 1};
        int res = result.maxArea(a);

        System.out.println(res);
    }
}
/*
  Input:	[1,1]
Output:	0
Expected:	1
 */
