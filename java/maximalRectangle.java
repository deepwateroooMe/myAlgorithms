import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Arrays;

public class maximalRectangle {
    public static class Solution {
        private int largestRectangleArea(int[] height) {
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

        public int maximalRectangle(char[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
            int [] h = new int[matrix[0].length];

            int res = 0; // record max area
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) 
                    h[j] = matrix[i][j] == '0' ? 0 : h[j] + 1;
                /*
                System.out.println("");
                for(int x : h)
                    System.out.print(x + ", ");
                System.out.println("");
                */
                res = Math.max(res, largestRectangleArea(h));
            }
            return res;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        //char [][] s = {{'1','1','1'},{'1','1','1'},{'1','1','0'}};
        char [][] s = {{'1','0','1','0','0'},
                       {'1','0','1','1','1'},
                       {'1','1','1','1','1'},
                       {'1','0','0','1','0'}};
        int res = result.maximalRectangle(s);
        
        System.out.println(res);
    }
}

/*
  Input:	["10100","10111","11111","10010"]
Output:	4
Expected:	6
 */
