import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class rotateImage {
    public static class Solution {
        void rotate(int [][] matrix) {
            int tmp;
            for (int i = 0; i < matrix.length/2; i++)
                for (int j = 0; j < matrix[0].length; j++) {
                    tmp = matrix[i][j];
                    matrix[i][j] = matrix[matrix.length - 1 - i][j];
                    matrix[matrix.length - 1 - i][j] = tmp;
                    //swap(matrix[i][j], matrix[matrix.length - 1 - i][j]);
                }
            for (int i = 1; i < matrix.length; i++) 
                for (int j = 0; j < i ; j++) {
                    tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                    //swap(matrix[i][j], matrix[j][i]);
                }
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [][] matrix = {{1, 2, 3, 4},            
                           {5, 6, 7, 8},
                           {9, 10, 11, 12},
                           {13, 14, 15, 16}};
        result.rotate(matrix);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println("");
        }
    }
}
