import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


public class getRowPascalTriangle {
    public static class Solution {
        // use the same method as generatePascalTriange, just apply using the same list
        // instead of using list, use array easier
        public List<Integer> getRow(int rowIndex) {
            if (rowIndex < 0) return null;
            if (rowIndex == 0) return null;
            if (rowIndex == 1) return Arrays.asList(1);

            int [] res = new int[rowIndex];
            res[0] = 1;  // f = n!/(r!*(n-1)!)
            for (int i = 1; i <= rowIndex; i++) {
                
                for ( j = 0; j < i/2; j++) {
                    res[j + 1] = res[j] + res[j + 1];
                }

            }
            return res;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int k = 3;
        List<Integer> res = result.getRow(k);

        System.out.println(res);
    }
}
