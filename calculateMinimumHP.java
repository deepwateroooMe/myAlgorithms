import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class calculateMinimumHP {
    public static class Solution {
        // sth different here, take a breath ...
        public int calculateMinimumHP(int[][] dungeon) {
            if (dungeon == null || dungeon.length == 0) return 0;
            int m = dungeon.length;
            int n = dungeon[0].length;
            int [][] max = new int[m][n];

            max[0][0] = dungeon[0][0];
            for (int i = 1; i < m; i++) 
                max[i][0] = max[i - 1][0] + dungeon[i][0];
            for (int j = 1; j < n; j++) 
                max[0][j] = max[0][j - 1] + dungeon[0][j];

            for (int i = 1; i < m; i++) 
                for (int j = 1; j < n; j++) 
                    max[i][j] = Math.max(max[i - 1][j] + dungeon[i][j],
                                         max[i][j - 1] + dungeon[i][j]);
            return max[m - 1][n - 1] > 0 ? 0 : -max[m - 1][n - 1] + 1;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [][] a = {{-2, -3, 3},
                      {-5, -10, 1},
                      {10, 30, -5}};
        int res = result.calculateMinimumHP(a);
        System.out.println(res);
    }
}
