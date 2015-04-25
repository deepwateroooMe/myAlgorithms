import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class minPathSum {
    public static class Solution {
        public int minPathSum0(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            if (m == 0 || n == 0) return 0;
            
            int [][] f = new int[m][n];
            f[0][0] = grid[0][0];
            for (int i = 1; i < n; i++)
                f[0][i] = f[0][i - 1] + grid[0][i];
            for (int i = 1; i < m; i++)
                f[i][0] = f[i - 1][0] + grid[i][0];
            
            for (int i = 1; i < m; i++) 
                for (int j = 1; j < n; j++) 
                    f[i][j] = Math.min(f[i][j - 1], f[i - 1][j]) + grid[i][j];
            return f[m-1][n-1];
        }

        // try to optimize code
        private int [][] f;

        private int getOrUpdate(int [][] grid, int x, int y) {
            if (x < 0 || y < 0) return Integer.MAX_VALUE;
            if (f[x][y] >= 0) return f[x][y];
            else {
                f[x][y] = dfs(grid, x, y);
                return f[x][y];
            }
        }
        
        private int dfs(int [][] grid, int x, int y) {
            if (x < 0 || y < 0) return Integer.MAX_VALUE;
            if (x == 0 && y == 0) return grid[0][0];
            return Math.min(getOrUpdate(grid, x - 1, y),
                            getOrUpdate(grid, x, y - 1)) + grid[x][y];
        }

        public int minPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            f = new int[m][n];
            for (int i = 0; i < m; i++) 
                for (int j = 0; j < n; j++) 
                    f[i][j] = -1;
            return dfs(grid, m - 1, n - 1);
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [][] obstacleGrid = {{1, 2}, {1, 1}};
        int res = result.minPathSum(obstacleGrid);

        System.out.println(res);
    }
}
