import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class getRowPascalTriangle {
    public static class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> list = new ArrayList<Integer>();
            if (rowIndex < 0) return null;
            if (rowIndex == 0) return list;
            list.add(1);
            
            int [] res = new int[rowIndex + 1];
            res[0] = 1;
            for (int i = 1; i < rowIndex; i++) {
                res[i] = 
            }

        }
    }

    public static void main(String[] args){
        Solution result = new Solution();

        System.out.println(res);
    }
}
