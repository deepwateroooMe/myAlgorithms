import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class combinationSumII {
    public static class Solution {
        public void dfs(int [] candidates, int bgn, int target,
                        List<Integer> path, List<List<Integer>> res) {
            if (target == 0) {
                res.add(new ArrayList<Integer> (path));
                return;
            }
            int previous = -1;
            for (int i = bgn; i < candidates.length; i++) {
                //if (i > 0 && candidates[i] == candidates[i - 1]) cnt++;
                //else cnt = 1;
                if (previous == candidates[i]) continue;
                if (candidates[i] > target) return;
                //if (cnt == 1 || (path.size() >= cnt - 1
                //               && path.get(path.size() - cnt + 1) == candidates[i])) {
                previous = candidates[i];
                path.add(candidates[i]);                             // , cnt
                dfs(candidates, i + 1, target - candidates[i], path, res); // use once
                path.remove(path.size() - 1);
                // }
            }
            return;
        }
        
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates); 
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            List<Integer> path = new ArrayList<Integer>();
            dfs(candidates, 0, target, path, res);
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
