import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Arrays;

public class largestRectangleArea {
    public static class Solution {
        public int largestRectangleArea(int[] height) {
            if (height == null || height.length == 0) return 0;
            else if (height.length == 1) return height[0];

            Stack<Integer> s = new Stack<Integer>();
            int [] hnew = new int[height.length + 1];
            hnew = Arrays.copyOf(height, height.length + 1);
            int res = 0;  // tract max area
            int i = 0;    // idx
            int tmp;      // s.pop()
            int left;

            while (i < hnew.length) {
                if (s.isEmpty() || hnew[i] >= hnew[s.peek()]) s.push(i++);
                else if (!s.isEmpty() && hnew[i] < hnew[s.peek()]) {
                    while (!s.isEmpty() && hnew[s.peek()] > hnew[i]) {
                        tmp = s.pop();
                        res = Math.max(res,
                                       (s.isEmpty() ? i : i - s.peek().intValue() - 1) * hnew[tmp]);
                    }
                }
            }
            return res;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {2, 1, 2};
        int res = result.largestRectangleArea(a);
        
        System.out.println(res);
    }
}
/*
  Input:	[2,1,2]
Output:	2
Expected:	3
*/
