import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class generatePascalTriangle {
    public static class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            List<Integer> one = new ArrayList<Integer>();
            if (numRows < 0) return null;
            if (numRows == 0) return res;

            res.add(new ArrayList<Integer>(Arrays.asList(1)));
            if (numRows == 1) return res;
            res.add(new ArrayList<Integer>(Arrays.asList(1, 1)));

            for (int i = 2; i < numRows; i++) {
                one.add(1);
                for (int j = 0; j < i/2 ; j++) 
                    one.add(res.get(i - 1).get(j) + res.get(i-1).get(j + 1));
                for (int j = (i - 1)/2; j >= 0; j--) 
                    one.add(one.get(j));
                res.add(one);
                one = new ArrayList<Integer>();
            }
            return res;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        List<List<Integer>> res = result.generate(6);
        
        System.out.println(res);
    }
}
