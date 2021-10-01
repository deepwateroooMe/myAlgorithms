import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;

public class subrectangleQueries {

    private int [][] arr;
    private int m, n;
    
    public subrectangleQueries(int[][] rectangle) {
        m = rectangle.length;
        n = rectangle[0].length;
        arr = new int [m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = rectangle[i][j];
            }
        }
    }
    
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        m = row2 - row1 + 1;
        n = col2 - col1 + 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[row1+i][col1+j] = newValue;
            }
        }
    }
    
    public int getValue(int row, int col) {
        return arr[row][col];
    }
    
    public static void main(String[] args) {

        int [][] a = new int [][] {{1,2,1},{4,3,4},{3,2,1},{1,1,1}};

        subrectangleQueries s = new subrectangleQueries(a);
        // s.updateSubrectangle(row1,col1,row2,col2,newValue);
        
        // int res = s.getValue(0, 2);
        // System.out.println("res: " + res);

        s.updateSubrectangle(0, 0, 3, 2, 5);

        // int res = s.getValue(0, 2); // return 5
        // System.out.println("res: " + res);
        
        // int res = s.getValue(3, 1); // return 5
        // System.out.println("res: " + res);
        
        s.updateSubrectangle(3, 0, 3, 2, 10);
        // // After this update the rectangle looks like:
        // // 5   5   5
        // // 5   5   5
        // // 5   5   5
        // // 10  10  10 
        // int res = s.getValue(3, 1); // return 10
        // System.out.println("res: " + res);
        
        int res = s.getValue(0, 2); // return 5
        System.out.println("res: " + res);
    }
}
