import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Arrays;

public class maximalRectangle {
    public static class Solution {
        private int largestRectangleArea(int[] height) {
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

        public int maximalRectangle0(char[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
            int [] h = new int[matrix[0].length];
            int res = 0;     // record max area
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) 
                    h[j] = matrix[i][j] == '0' ? 0 : h[j] + 1;
                res = Math.max(res, largestRectangleArea(h));
            }
            return res;
        }

        public int maximalRectangle(char[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
            int m = matrix.length;
            int n = matrix[0].length;
            int [][] dp = new int[m][n];
            int res = 0;
            int width = 0;
            for (int i = 0; i < m; i++) 
                dp[i][n - 1] = matrix[i][n - 1] == '1' ? 1 : 0;
            for (int i = 0; i < m; i++) 
                for (int j = n - 2; j >= 0; j--) 
                    if (matrix[i][j] == '1')
                        dp[i][j] = dp[i][j + 1] + 1;
            for (int i = 0; i < m; i++) 
                for (int j = 0; j < n; j++) {
                    if ((n - j) * (m - i) <= res)
                        break; // 剪枝，column-j是最大宽度，row-i是最大高度
                    width = dp[i][j];
                    for (int k = i; k < m && width > 0; k++) {
                        if (width * (m - i) <= res) break;
                        if (width > dp[k][j]) width = dp[k][j];
                        res = Math.max(res, width * (k - i + 1));
                    }
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
