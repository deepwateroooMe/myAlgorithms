import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class combinationSum2 {
    public static class Solution {
        /**
         * @param candidates: A list of integers
         * @param target:An integer
         * @return: A list of lists of integers
         */
        public void combinationSum2(int [] candidates, int gap, int idx, 
                                    List<List<Integer>> res, List<Integer> path,
                                    boolean [] used) {
            if (gap == 0) 
                res.add(new ArrayList<Integer>(path));
            for (int i = idx; i < candidates.length; i++) {
                if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) continue;
                if (candidates[i] <= gap) {
                    used[i] = true;
                    path.add(candidates[i]);
                    combinationSum2(candidates, gap - candidates[i], i + 1, res, path, used);
                    path.remove(path.size() - 1);
                    used[i] = false;
                }
            }
        }
        
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            int n = candidates.length;
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            List<Integer> path = new ArrayList<Integer>();
            Arrays.sort(candidates);
            boolean [] used = new boolean[n];
            combinationSum2(candidates, target, 0, res, path, used);
            return res;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {10, 1, 6, 7, 2, 1, 5};
        int b = 8;
        List<List<Integer>> res = result.combinationSum2(a, b);

        System.out.println("");
        for (int i = 0; i < res.size(); ++i) {
            System.out.println(res.get(i));
        }
        System.out.println("");
    }
}
