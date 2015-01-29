import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class searchMatrix {
    public static class Solution {
        public boolean binarySearch(int [] a, int target, int bgn, int end) {
            while (bgn <= end) {
                int mid = bgn + (end - bgn) / 2;
                if (a[mid] == target) return true;
                if (a[mid] > target) end = mid - 1;
                else bgn = mid + 1;
            }
            return false;
        }
        
        public boolean searchMatrix0(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;
            int [] a = new int[m * n];
            int cnt = 0;
            for (int i = 0; i < m; i++) 
                for (int j = 0; j < n; j++) 
                    a[cnt++] = matrix[i][j];
            return binarySearch(a, target, 0, m * n - 1);
        }

        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;
            int bgn = 0;
            int end = m * n- 1;
            while (bgn <= end) {
                int mid = bgn + (end - bgn) / 2;
                int val = matrix[mid / n][mid % n];
                if (val == target) return true;
                if (val > target) end = mid - 1;
                else bgn = mid + 1;
            }
            return false;
        }

    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [][] a = {{1,   3,  5,  7},
                      {10, 11, 16, 20},
                      {23, 30, 34, 50}};
        boolean res = result.searchMatrix(a, 4);
        
        System.out.println(res);
    }
}
