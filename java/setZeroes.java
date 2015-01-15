import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class setZeroes {
    public static class Solution {
        public void setZeroes(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
            int m = matrix.length;
            int n = matrix[0].length;
            Stack<Integer> row = new Stack<Integer>();
            Stack<Integer> col = new Stack<Integer>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        row.push(i);
                        col.push(j);
                    } 
                }
            }
            int tmp = 0;
            while (!row.isEmpty()) {
                tmp = row.pop();
                for (int i = 0; i < n; i++) 
                    matrix[tmp][i] = 0;
            }
            while (!col.isEmpty()) {
                tmp = col.pop();
                for (int i = 0; i < m; i++) 
                    matrix[i][tmp] = 0;
            }
        } // end function
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [][] a = {{1, 0, 1}, {1, 1, 1}, {1, 1, 1}};
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + ", ");
            }
            System.out.println("");
        }

        System.out.println("");
        result.setZeroes(a);

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + ", ");
            }
            System.out.println("");
        }
        
    }
}
