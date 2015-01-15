import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class searchMatrix {
    public static class Solution {
        public boolean binarySearch(int [] a, int target, int bgn, int end) {
            if (bgn == end) return a[bgn] == target;
            else if (a[bgn] > target) return false;
            else if (a[end] < target) return false;
            
            while (bgn < end) {
                int mid = bgn + (end - bgn) / 2;
                if (a[mid] == target)
                    return true;
                if (a[mid] > target)
                    end = mid - 1;
                else
                    bgn = mid + 1;
            }
            if (bgn == end) return a[bgn] == target;
            return false;
        }
        
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0) return false;
            else if (matrix.length == 1 && matrix[0].length == 1) return matrix[0][0] == target;
            int m = matrix.length;
            int n = matrix[0].length;
            int [] a = new int[m * n];

            int cnt = 0;
            for (int i = 0; i < m; i++) 
                for (int j = 0; j < n; j++) 
                    a[cnt++] = matrix[i][j];
            return binarySearch(a, target, 0, m * n - 1);
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
