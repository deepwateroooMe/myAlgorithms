import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class generatePascalTriangle {
    public static class Solution {
        public List<List<Integer>> generate0(int numRows) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            if (numRows == 0) return res;
            res.add(new ArrayList<Integer>(Arrays.asList(1)));
            for (int i = 2; i <= numRows; i++) {
                List<Integer> curr = new ArrayList<Integer>(i);
                for (int j = 0; j < i; j++) 
                    curr.add(j, 1);
                List<Integer> prev = res.get(i - 2);
                for (int j = 1; j < i - 1; j++) 
                    curr.set(j, prev.get(j - 1) + prev.get(j));
                res.add(curr);
            }
            return res;
        }

        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            List<Integer> arr = new ArrayList<Integer>();
            for (int i = 1; i <= numRows; i++) {
                for (int j = i - 2; j > 0; j--) {
                    arr.set(j, arr.get(j - 1) + arr.get(j));
                }
                arr.add(1);
                res.add(new ArrayList<Integer>(arr));
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
