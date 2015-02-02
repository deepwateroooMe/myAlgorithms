import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


public class getRowPascalTriangle {
    public static class Solution {
        // O(n) EXTRA space, not O(n) space
        // it should be handled using list only, but got tired of it today~
        // don't need array and list at the same time, one works already~
        // set() function
        public List<Integer> getRow(int rowIndex) {
            List<Integer> arr = new ArrayList<Integer>();
            for (int i = 0; i <= rowIndex ; i++) {
                for (int j = i - 1; j > 0; j--) {
                    arr.set(j, arr.get(j - 1) + arr.get(j));
                }
                arr.add(1);
            }
            return arr;
        }
        
        public List<Integer> getRow0(int rowIndex) {
            if (rowIndex < 0) return null;
            if (rowIndex == 0) return Arrays.asList(1);
            if (rowIndex == 1) return Arrays.asList(1, 1);

            List<Integer> result = new ArrayList<Integer>(rowIndex);
            int [] tmp = new int[rowIndex + 1];
            tmp[0] = 1;
            tmp[1] = 1;
            for (int i = 1; i <= rowIndex + 1; i++) {
                if (i == rowIndex + 1) break;
                System.out.println("");
                System.out.println("i: " + i);
                int j;
                for ( j = i / 2; j >= 1; j--) {
                    tmp[j] = tmp[j] + tmp[j - 1];
                }
                for(int val : tmp)
                    System.out.print(val + ", ");
                System.out.println("");

                for (int y = i/2 + 1; y <= i ; y++) {
                    tmp[y] = tmp[i - y];
                }
                for(int val : tmp)
                    System.out.print(val + ", ");
                System.out.println("");
            }
            for (int i = 0; i <= rowIndex; i++) {
                result.add(tmp[i]);
            }
            return result;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int k = 4;
        List<Integer> res = result.getRow(k);

        System.out.println(res);
    }
}
/*
  Input:	4
Output:	[1,4,7,4,1]
Expected:	[1,4,6,4,1]
*/
