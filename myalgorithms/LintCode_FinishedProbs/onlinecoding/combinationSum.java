import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class combinationSum {
    public static class Solution {
        /**
         * @param candidates: A list of integers
         * @param target:An integer
         * @return: A list of lists of integers
         */
        public void combinationSum(int [] candidates, int gap, int idx, 
                                   List<List<Integer>> res, List<Integer> path) {
            if (gap == 0) 
                res.add(new ArrayList<Integer>(path));
            for (int i = idx; i < candidates.length; i++) {
                if (candidates[i] <= gap) {
                    path.add(candidates[i]);
                    combinationSum(candidates, gap - candidates[i], i, res, path);
                    path.remove(path.size() - 1);
                }
            }
        }
        
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            int n = candidates.length;
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            List<Integer> path = new ArrayList<Integer>();
            Arrays.sort(candidates);
            combinationSum(candidates, target, 0, res, path);
            return res;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {2,3,6,7};
        int b = 7;
        List<List<Integer>> res = result.combinationSum(a, b);

        System.out.println("");
        for (int i = 0; i < res.size(); ++i) {
            System.out.println(res.get(i));
        }
        System.out.println("");
    }
}
