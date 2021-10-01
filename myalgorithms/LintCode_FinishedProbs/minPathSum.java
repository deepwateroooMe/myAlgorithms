import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class minPathSum {
    public static class Solution {
        /**
         * @param grid: a list of lists of integers.
         * @return: An integer, minimizes the sum of all numbers along its path
         */
        public int minPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int res[][] = new int[m][n];
            res[0][0] = grid[0][0];
            for (int i = 1; i < n; i++) res[0][i] = res[0][i - 1] + grid[0][i];
            for (int j = 1; j < m; j++) res[j][0] = res[j - 1][0] + grid[j][0];
            for (int i = 1; i < m; i++) 
                for (int j = 1; j < n; j++) 
                    res[i][j] = Math.min(res[i - 1][j], res[i][j - 1]) + grid[i][j];
            return res[m - 1][n - 1];
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int a[][] = {{1,4,8,6,2,2,1,7},{4,7,3,1,4,5,5,1},{8,8,2,1,1,8,0,1},{8,9,2,9,8,0,8,9},{5,7,5,7,1,8,5,5},{7,0,9,4,5,6,5,6},{4,9,9,7,9,1,9,0}};
        
        int res = result.minPathSum(a);
        System.out.println(res);
    }
}
