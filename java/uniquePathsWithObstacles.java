import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class uniquePathsWithObstacles {
    public static class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            if (m == 0 || n == 0) return 0;
            else if (obstacleGrid[0][0] == 1) return 0;
            else if (m == 1 || n == 1) return obstacleGrid[m-1][n-1] == 1 ? 0 : 1;
            else if (m == 1 && n == 1) return obstacleGrid[0][0] == 1 ? 0 : 1;
            
            int [][] arr = new int[m][n];
            for (int i = 0; i < n; i++)
                if (obstacleGrid[0][i] == 1) {
                    for (int j = i; j < n; j++) 
                        arr[0][j] = 0;
                    i = n;
                } else arr[0][i] = 1;

            for (int i = 0; i < m; i++)
                if (obstacleGrid[i][0] != 1)
                    arr[i][0] = 1;
                else 
                    for (int j = i; j < m; j++) {
                        arr[j][0] = 0;
                        i = m;
                    }
            
            arr[0][0] = 0;
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (obstacleGrid[i][j] == 1)
                        arr[i][j] = 0;
                    else 
                        arr[i][j] = arr[i][j - 1] + arr[i - 1][j];
                }
            }
            return arr[m-1][n-1];
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [][] obstacleGrid = {{0, 1, 0}, {1, 1, 0}, {0, 0, 0}};
        int res = result.uniquePathsWithObstacles(obstacleGrid);

        System.out.println(res);
    }
}
