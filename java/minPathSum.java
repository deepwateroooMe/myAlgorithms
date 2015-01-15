import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class minPathSum {
    public static class Solution {
        public int minPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            if (m == 0 || n == 0) return 0;
            
            int [][] arr = new int[m][n];
            arr[0][0] = grid[0][0];
            
            for (int i = 1; i < n; i++)
                arr[0][i] = arr[0][i - 1] + grid[0][i];
            
            for (int i = 1; i < m; i++)
                arr[i][0] = arr[i - 1][0] + grid[i][0];
            
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    arr[i][j] = Math.min(arr[i][j - 1], arr[i - 1][j]) + grid[i][j];
                }
            }
            return arr[m-1][n-1];
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [][] obstacleGrid = {{1, 2}, {1, 1}};
        int res = result.minPathSum(obstacleGrid);

        System.out.println(res);
    }
}
