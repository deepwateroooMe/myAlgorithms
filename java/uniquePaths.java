import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class uniquePaths {
    public static class Solution {
        public int uniquePaths(int m, int n) {
            if (m == 0 || n == 0) return 1;
            else if (m == 1 && n == 1) return 1;
            
            int [][] arr = new int[m][n];
            for (int i = 0; i < n; i++) 
                arr[0][i] = 1;
            for (int i = 0; i < m; i++)
                arr[i][0] = 1;
            arr[0][0] = 0;
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) 
                    arr[i][j] = arr[i][j - 1] + arr[i - 1][j];
            }
            return arr[m-1][n-1];
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int res = result.uniquePaths(3, 7);

        System.out.println(res);
    }
}
