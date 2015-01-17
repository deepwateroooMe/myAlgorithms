import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class generateMatrix {
    public static class Solution {
        public int[][] generateMatrix(int n) {
            int [][] matrix = new int[n][n];  // return 
            if (matrix == null || matrix.length == 0) return matrix;
            
            int size = n * n;
            int ibgn = 0, iend = n - 1;
            int jbgn = 0, jend = n - 1;
            boolean toup = false, toleft = false;
            int cnt = 1;

            while (cnt <= size && ibgn < n && jbgn < n) {
                for (int j = jbgn; j <= jend; j++) 
                    matrix[ibgn][j] = cnt++;
                ++ibgn;
                toleft = true;
                
                for (int j = ibgn; j <= iend; j++) 
                    matrix[j][jend] = cnt++;
                --jend;
                toup = true;

                if (toleft && cnt <= n * n) {
                    for (int j = jend; j >= jbgn ; j --) 
                        matrix[iend][j] = cnt++;
                    --iend;
                    toleft = false;
                }

                if (toup && cnt <= n * n) {
                    for (int i = iend; i >= ibgn ; i --) 
                        matrix[i][jbgn] = cnt++;
                    ++jbgn;
                    toup = false;
                }
            }
            return matrix;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int n = 4;
        int [][] res = result.generateMatrix(n);

        System.out.println("");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) 
                System.out.print(res[i][j] + ", ");
            System.out.println("");
        }
    }
}
