import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class uniquePaths {
    public static class Solution {
        public int uniquePaths0(int m, int n) {
            if (m == 0 || n == 0) return 1;
            else if (m == 1 && n == 1) return 1;
            
            int [][] dp = new int[m][n];
            for (int i = 0; i < n; i++) 
                dp[0][i] = 1;
            for (int i = 0; i < m; i++)
                dp[i][0] = 1;
            dp[0][0] = 0;
            for (int i = 1; i < m; i++) 
                for (int j = 1; j < n; j++) 
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            return dp[m-1][n-1];
        }

        public int combination(int a, int b) {
            if (b > (a >>> 1)) b = a - b;
            long res = 1;
            for (int i = 1; i <= b ; i++) 
                res = res * (a - i + 1) / i;
            return (int)res;
        }
        
        public int uniquePaths1(int m, int n) {
            return combination(m + n - 2, m - 1);
        }

        // another one
        private int [][] f;
        
        public int dfs(int x, int y) {
            if (x < 1 || y < 1) return 0;   
            if (x == 1 && y == 1) return 1; 
            return getOrUpdate(x - 1, y) + getOrUpdate(x, y - 1);
        }
    
        public int getOrUpdate(int x, int y) {
            if (f[x][y] > 0) return f[x][y];
            else return f[x][y] = dfs(x, y);
        }
    
        public int uniquePaths(int m, int n) {        
            f = new int[m + 1][n + 1];
            return dfs(m, n);
        }

    }

    public static void main(String[] args){
        Solution result = new Solution();
        int res = result.uniquePaths(3, 7);

        System.out.println(res);
    }
}
