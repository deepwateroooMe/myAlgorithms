import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class getRowPascalTriangle {
    public static class Solution {

        // use the same method as generatePascalTriange, just apply using the same list
        public List<Integer> getRow(int rowIndex) {
            List<Integer> res = new ArrayList<Integer>();
            if (rowIndex < 0) return null;
            if (rowIndex == 0) return res;
            res.add(1);
            if (rowIndex == 1) return res;
            res.add(1);
            int j;
            for (int i = 2; i <= rowIndex; i++) {
                for ( j = 0; j < i/2; j++) {
                    res.set(j + 1, res.get(j) + res.get(j + 1));
                }
                System.out.println("j: " + j);
                //res.remove(res.size() - 1);
                for ( j = res.size() - 1; j >= 0; j--) {
                    res.add(res.get(j));
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
