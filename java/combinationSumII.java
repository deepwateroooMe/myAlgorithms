import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class combinationSumII {
    public static class Solution {
        // see combinaitonSum for original confusing staff
        public void dfs(int [] candidates, int size, int bgn, int target,
                        List<Integer> one, List<List<Integer>> res, int cnt) {
            if (target < 0) return;
            if (target == 0) {
                res.add(new ArrayList<Integer> (one));
                return;
            }

            for (int i = bgn; i < size; i++) {
                if (candidates[i] > target) return;
                
                if (i > 0 && candidates[i] == candidates[i - 1]) cnt++;
                else cnt = 1;

                if (cnt == 1 || (one.size() >= cnt - 1
                                 && one.get(one.size() - cnt + 1) == candidates[i])) {
                    one.add(candidates[i]);
                    dfs(candidates, size, i + 1, target - candidates[i], one, res, cnt); // use once
                    one.remove(one.size() - 1);
                }

                /*
                if (i > 0 && candidates[i] == candidates[i - 1]
                    && !one.contains(candidates[i])) continue;
                one.add(candidates[i]);
                dfs(candidates, size, i + 1, target - candidates[i], one, res, cnt); // use once
                one.remove(one.size() - 1);
                */
            }
            return;
        }
        
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            if (candidates == null || candidates.length == 0) return res;
            List<Integer> one = new ArrayList<Integer>();
            Arrays.sort(candidates); // to prevent potential duplicates
            dfs(candidates, candidates.length, 0, target, one, res, 0);
            return res;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        //int [] a = {2, 2, 2};
        int [] a = {10, 1, 2, 7, 6, 1, 5};
        int b = 8;
        System.out.println("");
        for(int i : a)
            System.out.print(i + ", ");
        System.out.println("");

        List<List<Integer>> res = result.combinationSum2(a, b);
        System.out.println("");
        for (int i = 0; i < res.size(); ++i) {
            System.out.println(res.get(i));
        }
        System.out.println("");
    }
}

/*
  Input:	[2,2,2], 4
Output:	[[2,2],[2,2]]
Expected:	[[2,2]]
 */
